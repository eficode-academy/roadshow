from subprocess import Popen, PIPE, call
import re

pipe = Popen(["git", "log", "-1"], stdout=PIPE)
gitLog = pipe.communicate()[0]
print gitLog
matchObj = re.match(r"Task\s+(\d+)",gitLog, flags=0)

if not matchObj:
    call("echo 'You need to spesify a task.'",shell=1)
    call(["exit","1"], shell=1) 
