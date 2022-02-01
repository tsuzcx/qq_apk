import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.9.1;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.QZLog;

public class zub
  implements pog.e
{
  zub(ztv paramztv, long paramLong, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2) {}
  
  public void g(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("PhotoListActivity", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.LA) });
      ThreadManager.postImmediately(new PhotoListLogicDefault.9.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    ((NewPhotoListActivity)this.this$0.mActivity).mHandler.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zub
 * JD-Core Version:    0.7.0.1
 */