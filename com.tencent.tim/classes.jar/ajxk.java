import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class ajxk
  implements WXShareHelper.a
{
  ajxk(String paramString, ajxd.a parama) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.adM, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.a != null) {
        this.a.onResult(true);
      }
    }
    label50:
    while (this.a == null) {
      return;
    }
    this.a.onResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxk
 * JD-Core Version:    0.7.0.1
 */