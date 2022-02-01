import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class mvb
  implements kqh.a
{
  mvb(muz parammuz) {}
  
  public void N(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS", paramInt);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.PROCESS_NAME, "Module_VideoFeedsIPCServer", "CMD_CAMERA_CAPTURE_SO_DOWNLOAD", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvb
 * JD-Core Version:    0.7.0.1
 */