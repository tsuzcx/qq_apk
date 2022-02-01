import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffRsp;
import com.tencent.qphone.base.util.QLog;

class sgv
  implements rxc.a<CertifiedAccountWrite.StDoTipOffRsp>
{
  sgv(sgu paramsgu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoTipOffRsp paramStDoTipOffRsp)
  {
    paramBoolean = true;
    if (paramLong == 0L)
    {
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest success");
      if (this.a.a != null)
      {
        paramString = this.a.a;
        if (paramLong != 0L) {
          break label78;
        }
      }
    }
    for (;;)
    {
      paramString.onResult(paramBoolean);
      return;
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest failed retCode:" + paramLong);
      break;
      label78:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgv
 * JD-Core Version:    0.7.0.1
 */