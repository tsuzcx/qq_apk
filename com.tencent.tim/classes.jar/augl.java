import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

class augl
  extends atsn
{
  augl(auge paramauge) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (!auge.a(this.this$0, paramLong2)) {}
    while ((auge.a(this.this$0) == null) || (auge.a(this.this$0).first == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "FMObserver OnFileTransferProgress progress=" + ((FileManagerEntity)auge.a(this.this$0).first).getfProgress());
    }
    auge.a(this.this$0, auge.c(this.this$0), (int)(((FileManagerEntity)auge.a(this.this$0).first).getfProgress() * 100.0F));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (!auge.a(this.this$0, paramLong2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "FMObserver OnFileTransferEnd isSuccess = " + paramBoolean);
    }
    auge.a(this.this$0, auge.c(this.this$0), 100);
    if (paramBoolean) {
      if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).first != null) && (auge.a(this.this$0).second != null)) {
        ((auge.a)auge.a(this.this$0).second).filePath = ((FileManagerEntity)auge.a(this.this$0).first).getFilePath();
      }
    }
    for (;;)
    {
      auge.c(this.this$0);
      return;
      auge.b(this.this$0);
      if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).first != null)) {
        auge.a(this.this$0, ((FileManagerEntity)auge.a(this.this$0).first).fileName);
      }
    }
  }
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (!auge.a(this.this$0, paramLong2)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MailPluginAttachDownloader", 2, "FMObserver OnFileTransferStart");
  }
  
  protected void cq(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "FMObserver OnShowToast errCode=" + paramInt + ", errMsg=" + paramString);
    }
    QQToast.a(auge.a(this.this$0), 1, paramString, 0).show(auge.a(this.this$0).getResources().getDimensionPixelSize(2131299627));
    auge.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augl
 * JD-Core Version:    0.7.0.1
 */