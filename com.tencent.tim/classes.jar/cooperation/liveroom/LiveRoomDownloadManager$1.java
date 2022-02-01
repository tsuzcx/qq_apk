package cooperation.liveroom;

import aquy;
import aquz;

class LiveRoomDownloadManager$1
  extends aquy
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (this.val$callback != null)
    {
      if (paramaquz.getStatus() == 3) {
        this.val$callback.onSuccess(paramaquz.getStatus(), paramaquz.ov);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(paramaquz.getStatus(), paramaquz.ov);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */