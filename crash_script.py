# Imports the monkeyrunner modules used by this program
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

# Installs the Android package. Notice that this method returns a boolean, so you can test
# to see if the installation worked.
device.installPackage('bin/CrashExample.apk')

# sets a variable with the package's internal name
package = 'com.colonialclub.example.crashexample'

# sets a variable with the name of an Activity in the package
activity = 'com.colonialclub.example.crashexample.MainActivity'

# sets the name of the component to start
runComponent = package + '/' + activity

# Runs the component
device.startActivity(component=runComponent)

# Wait for a moment, then tap third tab.
MonkeyRunner.sleep(.4)
density = float(device.getProperty("display.density"))
y = int(100*density)
x = int(device.getProperty("display.width")) - int(10*density)
device.touch(x, y, MonkeyDevice.DOWN_AND_UP)
