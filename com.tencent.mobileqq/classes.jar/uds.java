import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class uds
  implements ura
{
  public uds(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.a) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.a).link_strategy_type)
    {
      uqh.a(this.a.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, i, WSRecommendFragment.a(this.a, WSRecommendFragment.a(this.a)));
      uno.a(4, 114, 0, null, null);
      unx.a(114, paramInt, WSRecommendFragment.a(this.a).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000003, WSRecommendFragment.a(this.a).cid, WSRecommendFragment.a(this.a).trace_id);
      return;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    ozs.d(this.a.getActivity(), paramString);
    unx.a(140, paramInt, WSRecommendFragment.a(this.a).cid);
    WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000004, WSRecommendFragment.a(this.a).cid, WSRecommendFragment.a(this.a).trace_id);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.a) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.a).link_strategy_type)
    {
      paramString = WSRecommendFragment.a(this.a, i);
      ugz.a(this.a.getActivity(), paramString, false);
      unx.a(115, paramInt, WSRecommendFragment.a(this.a).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000002, WSRecommendFragment.a(this.a).cid, WSRecommendFragment.a(this.a).trace_id);
      return;
    }
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uds
 * JD-Core Version:    0.7.0.1
 */