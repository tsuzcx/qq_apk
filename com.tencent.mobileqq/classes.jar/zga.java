import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class zga
  implements bfah
{
  zga(zfy paramzfy, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_Zfy.o == null) || (!this.jdField_a_of_type_Zfy.o.equals(paramBaseResp.transaction))) {}
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
        ybk.a(1, 2131720031);
        return;
      }
      ybk.a(2, 2131720050);
      if ((this.jdField_a_of_type_Zfy.a instanceof begc))
      {
        paramBaseResp = ((begc)this.jdField_a_of_type_Zfy.a).b();
        if (this.jdField_a_of_type_Zfy.e == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.j;
          str2 = paramBaseResp.i;
          str3 = AccountDetailActivity.a(paramBaseResp.g);
          String str4 = paramBaseResp.k;
          if ((str4 == null) || ("".equals(str4))) {
            break label200;
          }
          nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.g, str3, false);
          return;
        }
      }
    }
    label200:
    if (this.jdField_a_of_type_Zfy.e == 1) {
      i = 1003;
    }
    nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zga
 * JD-Core Version:    0.7.0.1
 */