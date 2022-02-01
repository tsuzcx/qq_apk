import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;
import java.util.List;

public class rzi
{
  private long CK;
  private rzi.a a;
  private COMM.StCommonExt b;
  
  public void a(rzi.a parama)
  {
    this.a = parama;
  }
  
  public COMM.StCommonExt d()
  {
    return this.b;
  }
  
  public void sX(String paramString)
  {
    this.CK = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.b, 0, 1);
    VSNetworkHelper.a().a(paramString, new rzj(this));
  }
  
  public static abstract interface a
  {
    public abstract void p(List<sam> paramList, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzi
 * JD-Core Version:    0.7.0.1
 */