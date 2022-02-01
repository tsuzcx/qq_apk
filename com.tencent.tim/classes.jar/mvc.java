import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class mvc
  extends acfd
{
  mvc(muz parammuz, QQAppInterface paramQQAppInterface) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("VALUE_USER_UIN_TO_GET_NICK_NAME", paramString);
      localBundle.putString("VALUE_USER_NICK_NAME", aqgv.b(this.val$app, paramString, true));
      QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.PROCESS_NAME, "Module_VideoFeedsIPCServer", "CMD_GET_NICK_NAME_BY_UIN", localBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvc
 * JD-Core Version:    0.7.0.1
 */