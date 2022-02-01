import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class zsg
  implements WXShareHelper.WXShareListener
{
  zsg(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!TextUtils.equals(this.a, paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      yyi.a(1, 2131718380);
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this);
      return;
      yyi.a(2, 2131718398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsg
 * JD-Core Version:    0.7.0.1
 */