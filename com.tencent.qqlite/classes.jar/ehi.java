import QQService.RespTmpChatPicDownload;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.transfile.LbsTransfileProcessor;

public class ehi
  extends MessageObserver
{
  public ehi(LbsTransfileProcessor paramLbsTransfileProcessor) {}
  
  protected void a(boolean paramBoolean, RespTmpChatPicDownload paramRespTmpChatPicDownload)
  {
    if ((paramRespTmpChatPicDownload != null) && (paramRespTmpChatPicDownload.lReplyCode == 0) && (paramRespTmpChatPicDownload.strDownloadURL != null) && (paramRespTmpChatPicDownload.strDownloadURL.length() > 0))
    {
      this.a.d(paramRespTmpChatPicDownload.strDownloadURL);
      return;
    }
    this.a.b(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehi
 * JD-Core Version:    0.7.0.1
 */