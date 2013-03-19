android-tab-loader-crash
========================

A simple application demonstrating strange crash behavior.

Discussed in [this stackoverflow question](http://stackoverflow.com/questions/15490904/loader-delivers-result-to-wrong-fragment).

When you switch to the Bar tab before the Foo tab has finished loading, the result intended for the Foo fragment is delivered to the Bar fragment, resulting in a ClassCastException.

`crash_script.py` is a monkeyrunner script demonstrating the problem. When running an emulator or device, run

`monkeyrunner crash_script.py`

to attempt to force the crash. The script connects to your device, installs this application, starts it, and then quickly switches to the Bar tab.

Depending on your screen dimensions, `crash_script.py` may miss the tab, meaning you will just stay on the Foo tab. It was tested on a 480x800 screen, and assumes the tab is on the right about 100 dip from the top. If the script doesn't work, you can trigger the crash manually by starting the application and quickly switching to the Bar tab.
