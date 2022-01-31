import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class uju
  extends VasExtensionObserver
{
  public uju(PokePanel paramPokePanel) {}
  
  protected void e(boolean paramBoolean, Object paramObject)
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
      ChatActivityFacade.a(PokePanel.a(this.a), BaseApplicationImpl.getContext(), PokePanel.a(this.a), 126, j, paramObject, (String)localObject);
      if (true == PokeItemHelper.a) {
        PokeItemHelper.a = false;
      }
      label106:
      if (!paramBoolean) {
        break label409;
      }
    }
    label407:
    label409:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (i != 5) {
        break label47;
      }
      str1 = "svip";
      break label47;
      label160:
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.a.a = paramObject.getInt("id", 0);
      String str2 = "立即开通";
      if (l == 0L)
      {
        this.a.b = 1;
        if (true != PokeItemHelper.a) {
          break;
        }
        PokeItemHelper.a = false;
        return;
      }
      if (l == 4002L)
      {
        this.a.b = 2;
        paramObject = "开通会员即可使用该戳一戳手势";
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label407;
        }
        PokeItemHelper.a(PokePanel.a(this.a), (Activity)this.a.getContext(), paramObject, (String)localObject, this.a.a, this.a.b);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.a.b = 4;
          paramObject = "开通超级会员即可使用该戳一戳手势";
          localObject = str2;
        }
        else
        {
          this.a.b = 1;
          str2 = "确定";
          QLog.e("Q.aio.PokePanel", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uju
 * JD-Core Version:    0.7.0.1
 */