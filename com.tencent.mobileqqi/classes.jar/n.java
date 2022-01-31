import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.activities.DLFileViewerActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class n
  extends DataLineObserver
{
  public n(DLFileViewerActivity paramDLFileViewerActivity) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    if (paramLong != DLFileViewerActivity.a(this.a).sessionid) {
      return;
    }
    this.a.runOnUiThread(new s(this, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    if (paramLong1 != DLFileViewerActivity.a(this.a).sessionid) {}
    while (DLFileViewerActivity.a(this.a).isSendFromLocal()) {
      return;
    }
    if (paramBoolean2)
    {
      this.a.a.a = DLBaseFileViewActivity.DLFileState.RECVING;
      DLFileViewerActivity.a(this.a).fileMsgStatus = 0L;
      this.a.b.a().c(DLFileViewerActivity.a(this.a).msgId);
    }
    this.a.runOnUiThread(new o(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if (!paramString.equals(DLFileViewerActivity.a(this.a).strMoloKey)) {
      return;
    }
    DLFileViewerActivity.a(this.a).nAppStatus = 1;
    this.a.runOnUiThread(new t(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    if (paramLong != DLFileViewerActivity.a(this.a).sessionid) {
      return;
    }
    this.a.runOnUiThread(new q(this, paramBoolean));
  }
  
  protected void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    if (paramLong1 != DLFileViewerActivity.a(this.a).sessionid) {}
    while (!DLFileViewerActivity.a(this.a).isSendFromLocal()) {
      return;
    }
    if (paramBoolean2) {
      this.a.a.a = DLBaseFileViewActivity.DLFileState.SENDING;
    }
    this.a.runOnUiThread(new p(this));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    if (paramLong != DLFileViewerActivity.a(this.a).sessionid) {
      return;
    }
    this.a.runOnUiThread(new r(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     n
 * JD-Core Version:    0.7.0.1
 */