import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

class ivg
  implements WXShareHelper.a
{
  ivg(ivc.b paramb, String paramString, Context paramContext, int paramInt1, int paramInt2) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 2;
    QLog.w("ShareChat", 1, "onWXShareResp, mWXTransaction[" + this.QH + "], transaction[" + paramBaseResp.transaction + "], errCode[" + paramBaseResp.errCode + "], seq[" + this.this$0.seq + "]");
    if (!TextUtils.equals(this.QH, paramBaseResp.transaction)) {
      return;
    }
    ivc.b localb;
    int j;
    int k;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(this.val$context, 1, this.val$context.getString(2131720152), 0).show();
    case -2: 
      WXShareHelper.a().b(this);
      localb = this.this$0;
      j = this.atX;
      k = this.atW;
      if (paramBaseResp.errCode != 0) {
        break;
      }
    }
    for (;;)
    {
      localb.C(j, k, i);
      return;
      QQToast.a(this.val$context, 2, this.val$context.getString(2131720175), 0).show();
      break;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivg
 * JD-Core Version:    0.7.0.1
 */