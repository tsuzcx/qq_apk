import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class xdo
  implements Runnable
{
  xdo(xdn paramxdn, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (CommonHbFragment.a(this.jdField_a_of_type_Xdn.a) == null) {}
    do
    {
      return;
      if (!"512".equals(CommonHbFragment.h(this.jdField_a_of_type_Xdn.a))) {
        break;
      }
    } while (CommonHbFragment.d(this.jdField_a_of_type_Xdn.a));
    CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(0);
    return;
    if ("4096".equals(CommonHbFragment.h(this.jdField_a_of_type_Xdn.a)))
    {
      CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(8);
      return;
    }
    JSONObject localJSONObject;
    if ((!"5".equals(CommonHbFragment.h(this.jdField_a_of_type_Xdn.a))) && (!"16".equals(CommonHbFragment.h(this.jdField_a_of_type_Xdn.a))) && (!"2048".equals(CommonHbFragment.h(this.jdField_a_of_type_Xdn.a))))
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label304;
      }
      localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("hb_vip");
      if (localJSONObject == null) {
        break label304;
      }
    }
    label304:
    for (int i = localJSONObject.optInt("enable_shop_enter");; i = 1)
    {
      if (i == 1)
      {
        CommonHbFragment.b(this.jdField_a_of_type_Xdn.a, IndividualRedPacketManager.a(3, (QQAppInterface)this.jdField_a_of_type_Xdn.a.getActivity().getAppRuntime()));
        if (TextUtils.isEmpty(CommonHbFragment.i(this.jdField_a_of_type_Xdn.a)))
        {
          CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(8);
          return;
        }
        if (CommonHbFragment.d(this.jdField_a_of_type_Xdn.a)) {
          break;
        }
        CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(0);
        return;
      }
      CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(8);
      return;
      CommonHbFragment.a(this.jdField_a_of_type_Xdn.a).setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdo
 * JD-Core Version:    0.7.0.1
 */