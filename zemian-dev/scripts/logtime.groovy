//
// Calculate elapse time between each log statement's timestamp and print
// lines that has longest elapse time first.
//
// Usage: groovy logtime.groovy target/spring-debug.log  | head

dtFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
def extractTimestamp(line) {
    def m = (line =~ /(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}.\d{3}) .+/)
    //println(line)
    //println([m.find(), m.groupCount()])
    if (m.matches() && m.groupCount() >= 1) {
        def s = m.group(1)
        def dt = dtFormat.parse(s)
        return dt.getTime()
    }
    return 0
}

lines = []
lastTimestamp = 0
new File(args[0]).eachLine{ line ->
    def timstaamp = extractTimestamp(line)
    if (timstaamp > 0) {
        if (lastTimestamp > 0) {
            def elapse = timstaamp - lastTimestamp    
            lines.add("$elapse $line")
        }
        lastTimestamp = timstaamp
    }
}

sortedLines = lines.sort{ a, b -> 
    def aInt = (a.split(' ')[0]).toInteger()
    def bInt = (b.split(' ')[0]).toInteger()
    return bInt <=> aInt 
}

sortedLines.each { println(it) }
