import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.utils.ContactUtils;

class tif
  implements View.OnClickListener
{
  tif(tib paramtib, ADMsg paramADMsg, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.e;
    paramView = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.f;
    if ((((String)localObject).equals("TMTWAPI")) || (((String)localObject).equals("WAPI")))
    {
      paramView = Config.a(paramView, 0, null);
      localObject = new Intent(this.jdField_a_of_type_Tib.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Tib.a.app.getCurrentAccountUin());
      this.jdField_a_of_type_Tib.a.startActivity(((Intent)localObject).putExtra("url", paramView));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
      this.jdField_a_of_type_Tib.a.a.sendEmptyMessageDelayed(1010, 1000L);
      return;
      if ((((String)localObject).equals("TMTWAP")) || (((String)localObject).equals("WAP")))
      {
        localObject = new Intent(this.jdField_a_of_type_Tib.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Tib.a.app.getCurrentAccountUin());
        this.jdField_a_of_type_Tib.a.startActivity(((Intent)localObject).putExtra("url", paramView));
      }
      else if (((String)localObject).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.g.split(",")[0];
          if (("".equals(paramView)) || (this.jdField_a_of_type_Tib.a.app.getCurrentAccountUin().equals(paramView))) {}
          for (paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_Tib.a.app.getCurrentAccountUin(), 0);; paramView = new ProfileActivity.AllInOne(paramView, 19))
          {
            ProfileActivity.b(this.jdField_a_of_type_Tib.a, paramView);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.g.split(",")[0];
          if (!"".equals(paramView)) {
            if (((FriendsManager)this.jdField_a_of_type_Tib.a.app.getManager(50)).b(paramView)) {
              this.jdField_a_of_type_Tib.a(paramView, 0, ContactUtils.k(this.jdField_a_of_type_Tib.a.app, paramView));
            } else {
              this.jdField_a_of_type_Tib.a(paramView, 1001, ContactUtils.k(this.jdField_a_of_type_Tib.a.app, paramView));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase(paramView))
        {
          this.jdField_a_of_type_Tib.a.startActivity(new Intent(this.jdField_a_of_type_Tib.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */