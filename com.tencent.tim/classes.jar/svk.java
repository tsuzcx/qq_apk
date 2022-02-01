import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

class svk
  implements WXShareHelper.a
{
  svk(svi paramsvi, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.this$0.Qt == null) || (!this.this$0.Qt.equals(paramBaseResp.transaction))) {}
    int i;
    String str1;
    String str2;
    String str3;
    for (;;)
    {
      return;
      BaseApplicationImpl.getContext();
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        rwt.ez(1, 2131720152);
        return;
      }
      rwt.ez(2, 2131720175);
      if ((this.this$0.activity instanceof aqzs))
      {
        paramBaseResp = ((aqzs)this.this$0.activity).c();
        if (this.this$0.bzo == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.msgid;
          str2 = paramBaseResp.awT;
          str3 = AccountDetailActivity.dX(paramBaseResp.mUrl);
          String str4 = paramBaseResp.aTX;
          if ((str4 == null) || ("".equals(str4))) {
            break label200;
          }
          kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.mUrl, str3, false);
          return;
        }
      }
    }
    label200:
    if (this.this$0.bzo == 1) {
      i = 1003;
    }
    kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.val$url, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */