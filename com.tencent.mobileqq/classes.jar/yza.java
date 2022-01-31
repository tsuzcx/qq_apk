import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class yza
  implements Runnable
{
  public yza(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool4 = false;
    boolean bool3 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a == null)) {
      return;
    }
    bool1 = bool3;
    boolean bool2;
    label54:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1) {
        break label385;
      }
      bool2 = true;
      localObject = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get();
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "parseShopRedTouchManager:", localObject, ", isNewRed：", Boolean.valueOf(bool2), ",refreshByGetUserAction:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          localObject = localJSONObject.optString("_show_mission");
          localJSONObject = localJSONObject.optJSONObject("msg");
          bool1 = bool3;
          if (localJSONObject != null)
          {
            localJSONObject = localJSONObject.optJSONObject((String)localObject);
            bool1 = bool3;
            if (localJSONObject != null)
            {
              ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getManager(152);
              ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, localApolloManager.a(this.jdField_a_of_type_JavaLangString, (String)localObject, localJSONObject, bool2, 6));
              localObject = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
              bool1 = bool3;
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException1)
        {
          label385:
          bool1 = bool4;
        }
        try
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "parseShopRedTouchManager pushItem:", ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).toString() });
            }
            ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).icon_url);
            ApolloPanel.d(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, "cmshow", "Apollo", "house_new_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.b()), 0, new String[] { ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).msg_id });
          }
          bool1 = true;
          ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, bool1);
          if (bool1) {
            break;
          }
          ApolloPanel.e(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool1 = true;
          }
        }
      }
      bool2 = false;
      break label54;
      QLog.e("ApolloPanel", 1, "parseShopRedTouchManager error :", localException1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yza
 * JD-Core Version:    0.7.0.1
 */