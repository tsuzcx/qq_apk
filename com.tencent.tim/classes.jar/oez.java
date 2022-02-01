import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.ArrayList;

public class oez
  implements ogo
{
  public oez(WSFollowFragment paramWSFollowFragment) {}
  
  public void d(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (oor.v(paramJceStruct.feeds));
    ooz.d("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.this$0.dw(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oez
 * JD-Core Version:    0.7.0.1
 */