import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.qphone.base.util.QLog;

public class afcm
  extends xui.a
{
  public afcm(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.hotchat", 4, "notifyImageProgress progress:" + paramInt3);
    }
    if ((HotChatFlashPicActivity.a(this.this$0).id == paramLong1) && (HotChatFlashPicActivity.a(this.this$0).subId == paramInt1)) {
      HotChatFlashPicActivity.a(this.this$0, paramInt3 / 100);
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.hotchat", 4, "notifyImageResult type:" + paramInt2 + ",resultStr:" + paramString + ",result:" + paramInt3 + ",isPart:" + paramBoolean);
    }
    if ((HotChatFlashPicActivity.a(this.this$0).id == paramLong) && (HotChatFlashPicActivity.a(this.this$0).subId == paramInt1) && (paramInt2 == 2))
    {
      HotChatFlashPicActivity.a(this.this$0, false);
      if (paramInt3 != 1) {
        break label228;
      }
      HotChatFlashPicActivity.a(this.this$0).aVX = paramString;
      HotChatFlashPicActivity.a(this.this$0).bjc = paramBoolean;
      HotChatFlashPicActivity.a(this.this$0).bim = false;
      HotChatFlashPicActivity.a(this.this$0, HotChatFlashPicActivity.a(this.this$0));
      if ((HotChatFlashPicActivity.b(this.this$0) == null) || (HotChatFlashPicActivity.b(this.this$0).equals("I:E"))) {
        break label242;
      }
      aqgy.il(HotChatFlashPicActivity.b(this.this$0), HotChatFlashPicActivity.c(this.this$0));
      HotChatFlashPicActivity.b(this.this$0, true);
      HotChatFlashPicActivity.a(this.this$0, HotChatFlashPicActivity.b(this.this$0));
    }
    label228:
    label242:
    while (HotChatFlashPicActivity.b(this.this$0) == null)
    {
      return;
      HotChatFlashPicActivity.a(this.this$0).bim = true;
      break;
    }
    HotChatFlashPicActivity.a(this.this$0).sendEmptyMessage(1);
  }
  
  public void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void notifyFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcm
 * JD-Core Version:    0.7.0.1
 */