import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ofw
  implements opn.a
{
  public ofw(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void aU(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.this$0) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.this$0).link_strategy_type)
    {
      opb.a(this.this$0.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, i, WSRecommendFragment.a(this.this$0, WSRecommendFragment.a(this.this$0)));
      ond.a(4, 114, 0, null, null);
      ong.W(114, paramInt, WSRecommendFragment.a(this.this$0).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000003, WSRecommendFragment.a(this.this$0).cid, WSRecommendFragment.a(this.this$0).trace_id);
      return;
    }
  }
  
  public void aV(String paramString, int paramInt)
  {
    kxm.C(this.this$0.getActivity(), paramString);
    ong.W(140, paramInt, WSRecommendFragment.a(this.this$0).cid);
    WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000004, WSRecommendFragment.a(this.this$0).cid, WSRecommendFragment.a(this.this$0).trace_id);
  }
  
  public void aW(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.this$0) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.this$0).link_strategy_type)
    {
      paramString = WSRecommendFragment.a(this.this$0, i);
      oir.a(this.this$0.getActivity(), paramString, false);
      ong.W(115, paramInt, WSRecommendFragment.a(this.this$0).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000002, WSRecommendFragment.a(this.this$0).cid, WSRecommendFragment.a(this.this$0).trace_id);
      return;
    }
  }
  
  public void aX(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofw
 * JD-Core Version:    0.7.0.1
 */