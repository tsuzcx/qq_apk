import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class xms
  implements bcww
{
  xms(xmq paramxmq, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_Xmq.o == null) || (!this.jdField_a_of_type_Xmq.o.equals(paramBaseResp.transaction))) {}
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
        wij.a(1, 2131719487);
        return;
      }
      wij.a(2, 2131719506);
      if ((this.jdField_a_of_type_Xmq.a instanceof bccs))
      {
        paramBaseResp = ((bccs)this.jdField_a_of_type_Xmq.a).b();
        if (this.jdField_a_of_type_Xmq.e == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.k;
          str2 = paramBaseResp.j;
          str3 = AccountDetailActivity.a(paramBaseResp.h);
          String str4 = paramBaseResp.l;
          if ((str4 == null) || ("".equals(str4))) {
            break label200;
          }
          nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.h, str3, false);
          return;
        }
      }
    }
    label200:
    if (this.jdField_a_of_type_Xmq.e == 1) {
      i = 1003;
    }
    nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xms
 * JD-Core Version:    0.7.0.1
 */