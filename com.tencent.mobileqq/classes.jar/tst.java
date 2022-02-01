import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class tst
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "120";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "0";
  
  public tst(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.contains("v_present=1")) || (this.jdField_a_of_type_JavaLangString.contains("v_present=2")))) {
      this.jdField_a_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_auto_top=0"))) {
      this.jdField_c_of_type_Int = 0;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_top"))) {
      this.jdField_d_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_present_top");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("channelId"))) {
      this.jdField_e_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("channelId");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("unreadMessageCount"))) {}
    try
    {
      paramString1 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("unreadMessageCount");
      if (paramString1 != null) {
        this.jdField_e_of_type_Int = Integer.valueOf(paramString1).intValue();
      }
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        QLog.e(ViolaBaseView.a(), 1, paramString1.toString());
      }
    }
    paramString1 = (QQAppInterface)pha.a();
    if (paramString1 != null) {
      this.jdField_c_of_type_JavaLangString = paramString1.getAccount();
    }
    this.jdField_d_of_type_Int = bgtn.c(CommonSuspensionGestureLayout.a(BaseActivity.sTopActivity));
  }
  
  public tst(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    this(paramString1, paramJSONObject, paramString2);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getResources();
    if (localObject == null) {}
    do
    {
      return 1;
      localObject = ((Resources)localObject).getConfiguration();
    } while (localObject == null);
    return ((Configuration)localObject).orientation;
  }
  
  public String a()
  {
    return a().toString();
  }
  
  public JSONObject a()
  {
    int j = 0;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_OrgJsonJSONObject.put("unreadMessageCount", this.jdField_e_of_type_Int);
      localJSONObject.put("param", this.jdField_a_of_type_OrgJsonJSONObject);
      localJSONObject.put("cache", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("uin", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("isPresent", this.jdField_a_of_type_Int);
      localJSONObject.put("isChannel", this.jdField_b_of_type_Int);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
      {
        i = 1;
        localJSONObject.put("isNightMode", i);
        localJSONObject.put("isAutoTop", this.jdField_c_of_type_Int);
        localJSONObject.put("presentMarginTop", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("nowNavBarHeight", this.jdField_d_of_type_Int);
        localJSONObject.put("orientation", a());
        localJSONObject.put("screenWidth", FlexConvertUtils.getScreenWidth(BaseApplicationImpl.getApplication()));
        localJSONObject.put("screenHeight", FlexConvertUtils.getScreenHeight(BaseApplicationImpl.getApplication()));
        if (bhhb.a() != 1) {
          break label279;
        }
      }
      label279:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("isKindCard", i);
        localJSONObject.put("channel_id", this.jdField_e_of_type_JavaLangString);
        i = j;
        if (siy.a.a()) {
          i = 1;
        }
        localJSONObject.put("supportRate", i);
        localJSONObject.put("netType", nlw.a());
        float[] arrayOfFloat = trd.a();
        localJSONObject.put("topActivityWidth", arrayOfFloat[0]);
        localJSONObject.put("topActivityHeight", arrayOfFloat[1]);
        return localJSONObject;
        i = 0;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(ViolaBaseView.a(), 1, "ViolaCreactPageObject toJSON error = " + localJSONException.getMessage());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaCreactPageObject : url:");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "null";
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break label107;
      }
      str = "null";
      label55:
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label118;
      }
    }
    label107:
    label118:
    for (String str = "null";; str = this.jdField_b_of_type_JavaLangString)
    {
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      return localStringBuilder.toString();
      str = this.jdField_a_of_type_JavaLangString;
      break;
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */