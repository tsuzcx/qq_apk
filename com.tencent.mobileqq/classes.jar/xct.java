import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic.QwTextAdapter;

public class xct
  extends SendHbLogic.QwTextAdapter
{
  public xct(CommonHbFragment paramCommonHbFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = CommonHbFragment.a(this.a).getText().toString();
    Object localObject1;
    Object localObject2;
    SendHbLogic localSendHbLogic;
    if ((CommonHbFragment.a(this.a)) && (CommonHbFragment.b(this.a)) && ((CommonHbFragment.a(this.a).getCurrentItem() != 2) || (!TextUtils.isEmpty(paramEditable))) && (((!"1".equals(CommonHbFragment.a(this.a))) && (!"7".equals(CommonHbFragment.a(this.a)))) || (CommonHbFragment.a(this.a).getCurrentItem() != 1) || (!TextUtils.isEmpty(paramEditable))))
    {
      if (!CommonHbFragment.a(this.a).isEnabled())
      {
        CommonHbFragment.a(this.a).setEnabled(true);
        CommonHbFragment.a(this.a).setClickable(true);
        CommonHbFragment.a(this.a, "hongbao.wrap.enable", "");
      }
      paramEditable = new StringBuffer();
      paramEditable.append(this.a.getString(2131431267));
      if ("2".equals(CommonHbFragment.b(this.a)))
      {
        localObject1 = CommonHbFragment.b(this.a).getText().toString();
        localObject2 = this.a;
        localSendHbLogic = this.a.a;
        CommonHbFragment.a((CommonHbFragment)localObject2, SendHbLogic.a((String)localObject1, "1"));
        paramEditable.append(CommonHbFragment.d(this.a));
        paramEditable.append("元");
        CommonHbFragment.a(this.a).setText(paramEditable.toString());
        label261:
        if (!TextUtils.isEmpty(CommonHbFragment.b(this.a).getText().toString())) {
          break label524;
        }
        CommonHbFragment.b(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (CommonHbFragment.c(this.a) != null)
      {
        if (!TextUtils.isEmpty(CommonHbFragment.c(this.a).getText().toString())) {
          break label539;
        }
        CommonHbFragment.c(this.a).setGravity(19);
      }
      return;
      if (CommonHbFragment.c(this.a) == null)
      {
        localObject1 = CommonHbFragment.b(this.a).getText().toString();
        localObject2 = this.a;
        localSendHbLogic = this.a.a;
        CommonHbFragment.a((CommonHbFragment)localObject2, SendHbLogic.a((String)localObject1, "1"));
        break;
      }
      localObject1 = this.a;
      localObject2 = this.a.a;
      CommonHbFragment.a((CommonHbFragment)localObject1, SendHbLogic.a(CommonHbFragment.c(this.a), "1"));
      break;
      if (CommonHbFragment.a(this.a).isEnabled())
      {
        CommonHbFragment.a(this.a).setClickable(false);
        CommonHbFragment.a(this.a).setEnabled(false);
        CommonHbFragment.a(this.a, "hongbao.wrap.disable", "");
      }
      if ((CommonHbFragment.b(this.a) != null) && (CommonHbFragment.b(this.a).getText() != null)) {
        CommonHbFragment.a(this.a, CommonHbFragment.b(this.a).getText().toString());
      }
      CommonHbFragment.a(this.a).setText(2131431267);
      break label261;
      label524:
      CommonHbFragment.b(this.a).setGravity(21);
    }
    label539:
    CommonHbFragment.c(this.a).setGravity(21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xct
 * JD-Core Version:    0.7.0.1
 */