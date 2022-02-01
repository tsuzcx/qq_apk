package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aqdj;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.contentbox.model.MQMsg;

class MsgPhotoView$2
  implements Runnable
{
  MsgPhotoView$2(MsgPhotoView paramMsgPhotoView, MQMsg paramMQMsg) {}
  
  public void run()
  {
    if ((this.this$0.mContext == null) || (this.this$0.a == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = aqdj.g(1, 1);
      localObject = aqdj.a(((BaseActivity)this.this$0.mContext).app, 1, this.b.user_avatar, 1, (Drawable)localObject, (Drawable)localObject, null);
    } while (this.this$0.a == null);
    this.this$0.a.obtainMessage(10001, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.2
 * JD-Core Version:    0.7.0.1
 */