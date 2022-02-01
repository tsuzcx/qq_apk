import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import mqq.app.MobileQQ;

class nnh
  implements WXShareHelper.a
{
  nnh(nng paramnng, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((nng.a(this.this$0) == null) || (!nng.a(this.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.eA(1, 2131720152);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)kxm.getAppRuntime();
      nns.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.d, this.baw, -1, false, bool);
      return;
      rwt.eA(2, 2131720175);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnh
 * JD-Core Version:    0.7.0.1
 */