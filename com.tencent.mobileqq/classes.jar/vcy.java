import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class vcy
  extends VasExtensionObserver
{
  public vcy(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  protected void e(boolean paramBoolean, Object paramObject)
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
      ChatActivityFacade.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 126, j, paramObject, (String)localObject);
      if (true == PokeItemHelper.a) {
        PokeItemHelper.a = false;
      }
      label107:
      if (!paramBoolean) {
        break label410;
      }
    }
    label408:
    label410:
    for (i = 0;; i = 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "poke", "send", "", 0, i, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
      return;
      if (5 != i) {
        break label48;
      }
      str1 = "svip";
      break label48;
      label161:
      long l = ((Bundle)localObject).getLong("result");
      localObject = ((Bundle)localObject).getString("msg");
      paramObject = (Bundle)paramObject;
      this.a.jdField_b_of_type_Int = paramObject.getInt("id", 0);
      String str2 = "立即开通";
      if (l == 0L)
      {
        this.a.c = 1;
        if (true != PokeItemHelper.a) {
          break;
        }
        PokeItemHelper.a = false;
        return;
      }
      if (l == 4002L)
      {
        this.a.c = 2;
        paramObject = "开通会员即可使用该戳一戳手势";
        localObject = str2;
      }
      for (;;)
      {
        if (l == 0L) {
          break label408;
        }
        PokeItemHelper.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.a.jdField_a_of_type_AndroidContentContext, paramObject, (String)localObject, this.a.jdField_b_of_type_Int, this.a.c);
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(j), str1, "", "", "", "", 0, 0, 0, 0);
        break;
        if (l == 5002L)
        {
          this.a.c = 4;
          paramObject = "开通超级会员即可使用该戳一戳手势";
          localObject = str2;
        }
        else
        {
          this.a.c = 1;
          str2 = "确定";
          QLog.e("GivingHeart", 1, "vas poke auth fail, result: " + l);
          paramObject = localObject;
          localObject = str2;
        }
      }
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcy
 * JD-Core Version:    0.7.0.1
 */