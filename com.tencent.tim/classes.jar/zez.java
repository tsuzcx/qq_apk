import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;

public class zez
  extends aghq
{
  public zez(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  protected void a(agnk paramagnk)
  {
    if ((TextUtils.isEmpty(paramagnk.fileId)) || (TextUtils.isEmpty(paramagnk.filePath))) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "OnThumbDownLoad error : [fileId] = " + paramagnk.fileId + " [path] = " + paramagnk.filePath);
      }
    }
    while (this.this$0.b == null) {
      return;
    }
    this.this$0.b.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void bJj()
  {
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void bJl()
  {
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zez
 * JD-Core Version:    0.7.0.1
 */