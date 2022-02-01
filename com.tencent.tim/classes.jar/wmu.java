import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class wmu
  extends aqrd
{
  public wmu(PokePanel paramPokePanel) {}
  
  protected void onPokeAuth(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (((Bundle)localObject).getInt("fromType") != 0) {
      return;
    }
    int j = ((Bundle)localObject).getInt("id");
    int i = ((Bundle)localObject).getInt("feeType");
    String str1 = "free";
    if (i == 4)
    {
      str1 = "vip";
      label47:
      if (!paramBoolean) {
        break label160;
      }
      paramObject = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      ujt.a(PokePanel.a(this.this$0), BaseApplicationImpl.getContext(), PokePanel.a(this.this$0), 126, j, paramObject, (String)localObject);
      if (true == xks.bhd) {
        xks.bhd = false;
      }
      label106:
      if (!paramBoolean) {
        break label421;
      }
    }
    label160:
    label419:
    label421:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (i != 5) {
        break label47;
      }
      str1 = "svip";
      break label47;
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.this$0.bPr = paramObject.getInt("id", 0);
      String str2 = acfp.m(2131709796);
      if (l == 0L)
      {
        this.this$0.pay_type = 1;
        if (true != xks.bhd) {
          break;
        }
        xks.bhd = false;
        return;
      }
      if (l == 4002L)
      {
        this.this$0.pay_type = 2;
        paramObject = acfp.m(2131709799);
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label419;
        }
        xks.a(PokePanel.a(this.this$0), (Activity)this.this$0.getContext(), paramObject, (String)localObject, this.this$0.bPr, this.this$0.pay_type);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.this$0.pay_type = 4;
          paramObject = acfp.m(2131709798);
          localObject = str2;
        }
        else
        {
          this.this$0.pay_type = 1;
          str2 = acfp.m(2131709797);
          QLog.e("Q.aio.PokePanel", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmu
 * JD-Core Version:    0.7.0.1
 */