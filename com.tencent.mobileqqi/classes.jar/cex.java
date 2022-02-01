import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.qphone.base.util.QLog;

public class cex
  extends FMObserver
{
  public cex(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("silasBug", 4, "OnFileTransferProgress");
    }
    this.a.a(8, paramString, -2147483648);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("silasBug", 4, "OnFileTransferEnd");
    }
    this.a.a(8, paramString1, -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cex
 * JD-Core Version:    0.7.0.1
 */