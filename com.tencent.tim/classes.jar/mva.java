import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class mva
  implements wla.a
{
  mva(muz parammuz, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if ((paramaoko == null) || (this.b == null) || (paramaoko.uniseq != this.b.uniseq)) {}
    while ((paramaoko.fileType != 6) && (paramaoko.fileType != 17) && (paramaoko.fileType != 9) && (paramaoko.fileType != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", paramaoko.status);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", paramaoko.domain);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", paramaoko.urls);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", paramaoko.uniseq);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.PROCESS_NAME, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mva
 * JD-Core Version:    0.7.0.1
 */