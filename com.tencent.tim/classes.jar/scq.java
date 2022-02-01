import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tribe.async.dispatch.Dispatcher;

class scq
  implements rxc.a<CertifiedAccountWrite.StDoLikeRsp>
{
  scq(sci paramsci) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Long.valueOf(paramLong), paramString, paramStDoLikeRsp }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scq
 * JD-Core Version:    0.7.0.1
 */