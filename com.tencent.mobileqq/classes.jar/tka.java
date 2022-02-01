import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class tka
  implements WXShareHelper.WXShareListener
{
  tka(tjz paramtjz) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((tjz.a(this.a) == null) || (!tjz.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.a(1, 2131718380);
      bool = false;
    }
    for (;;)
    {
      uhd.a.a(bool);
      return;
      yyi.a(2, 2131718398);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tka
 * JD-Core Version:    0.7.0.1
 */