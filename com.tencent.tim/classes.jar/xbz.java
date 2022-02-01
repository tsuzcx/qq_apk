import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class xbz
  extends aqrd
{
  xbz(xbu paramxbu) {}
  
  protected void onPokeAuth(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (1 != ((Bundle)localObject).getInt("fromType")) {
      return;
    }
    int j = ((Bundle)localObject).getInt("id");
    int i = ((Bundle)localObject).getInt("feeType");
    String str1 = "free";
    if (4 == i)
    {
      str1 = "vip";
      label48:
      if (!paramBoolean) {
        break label161;
      }
      paramObject = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      ujt.a(this.this$0.mApp, BaseApplicationImpl.getContext(), this.this$0.sessionInfo, 126, j, paramObject, (String)localObject);
      if (true == xks.bhd) {
        xks.bhd = false;
      }
      label107:
      if (!paramBoolean) {
        break label422;
      }
    }
    label161:
    label420:
    label422:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (5 != i) {
        break label48;
      }
      str1 = "svip";
      break label48;
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.this$0.bPr = paramObject.getInt("id", 0);
      String str2 = acfp.m(2131706964);
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
        paramObject = acfp.m(2131706969);
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label420;
        }
        xks.a(this.this$0.mApp, (Activity)this.this$0.mContext, paramObject, (String)localObject, this.this$0.bPr, this.this$0.pay_type);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.this$0.pay_type = 4;
          paramObject = acfp.m(2131706968);
          localObject = str2;
        }
        else
        {
          this.this$0.pay_type = 1;
          str2 = acfp.m(2131706967);
          QLog.e("GivingHeart", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbz
 * JD-Core Version:    0.7.0.1
 */