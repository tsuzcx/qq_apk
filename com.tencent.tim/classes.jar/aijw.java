import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.a;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;

public class aijw
  implements WxShareHelperFromReadInjoy.a
{
  public aijw(QQApiPlugin.3 param3) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.this$0.Qt == null) || (!this.a.this$0.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.ez(1, 2131720152);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.this$0.bxh))
      {
        this.a.this$0.callJs(this.a.this$0.bxh, new String[] { String.valueOf(bool) });
        return;
        rwt.ez(2, 2131720175);
        if ((this.a.this$0.jdField_a_of_type_Ardm$l != null) && (this.a.this$0.jdField_a_of_type_Ardm$o != null))
        {
          int i;
          label171:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.amz))
          {
            i = 1009;
            paramBaseResp = this.a.this$0.jdField_a_of_type_Ardm$l.CF();
            str1 = this.a.this$0.jdField_a_of_type_Ardm$l.CG();
            str2 = this.a.ake;
            str3 = AccountDetailActivity.dX(this.a.this$0.jdField_a_of_type_Ardm$o.getCurrentUrl());
            String str4 = this.a.this$0.jdField_a_of_type_Ardm$l.CH();
            if ((str4 == null) || ("".equals(str4))) {
              break label314;
            }
            kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Ardm$o.getCurrentUrl(), str3, false);
          }
          for (;;)
          {
            bool = true;
            break;
            i = 1004;
            break label171;
            label314:
            if ("2".equals(this.a.amz)) {
              i = 1003;
            }
            kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
          }
          bool = false;
        }
      }
      else
      {
        this.a.this$0.callJs4OpenApiIfNeeded("shareMsg", 0, String.valueOf(bool));
        return;
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijw
 * JD-Core Version:    0.7.0.1
 */