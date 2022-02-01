import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.ArrayList;

public class uxg
  implements uyy
{
  public uxg(WSFollowFragment paramWSFollowFragment) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (vmg.a(paramJceStruct.feeds));
    vmp.b("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxg
 * JD-Core Version:    0.7.0.1
 */