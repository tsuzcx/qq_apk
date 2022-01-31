import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;

class faw
  implements Runnable
{
  faw(fav paramfav, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Fav.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     faw
 * JD-Core Version:    0.7.0.1
 */