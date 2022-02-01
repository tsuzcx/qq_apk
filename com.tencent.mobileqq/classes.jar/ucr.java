import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.ArrayList;

public class ucr
  implements uej
{
  public ucr(WSFollowFragment paramWSFollowFragment) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (uov.a(paramJceStruct.feeds));
    upe.b("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucr
 * JD-Core Version:    0.7.0.1
 */