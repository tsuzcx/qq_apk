package cooperation.liveroom;

import avfw;

class LiveRoomPluginInstaller$2
  implements Runnable
{
  LiveRoomPluginInstaller$2(LiveRoomPluginInstaller paramLiveRoomPluginInstaller, avfw paramavfw, String paramString) {}
  
  public void run()
  {
    this.val$pluginManager.installPlugin("LiveRoomPlugin.apk", new LiveRoomPluginInstaller.MyOnPluginInstallListener(this.this$0, this.val$from));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginInstaller.2
 * JD-Core Version:    0.7.0.1
 */