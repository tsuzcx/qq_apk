import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.ArrayList;

public class ujj
  implements ulb
{
  public ujj(WSFollowFragment paramWSFollowFragment) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (uxr.a(paramJceStruct.feeds));
    uya.b("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujj
 * JD-Core Version:    0.7.0.1
 */