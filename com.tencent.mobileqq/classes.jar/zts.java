import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.qphone.base.util.BaseApplication;

public class zts
  implements Runnable
{
  public zts(SecSvcHandler paramSecSvcHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcHandler.b.getApp(), NotificationActivity.class);
      localIntent.putExtra("type", 11);
      Bundle localBundle = new Bundle();
      localBundle.putString("dlg_title", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("dlg_content", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("dlg_lbutton", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("dlg_rbutton", this.d);
      localBundle.putString("dlg_url", this.e);
      localBundle.putInt("dlg_lbtnid", this.jdField_a_of_type_Int);
      localBundle.putInt("dlg_rbtnid", this.jdField_b_of_type_Int);
      localBundle.putInt("dlg_seccmd", this.jdField_c_of_type_Int);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(872415232);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppSecSvcHandler.b.isBackground_Stop) {
        this.jdField_a_of_type_ComTencentMobileqqAppSecSvcHandler.b.getApp().startActivity(localIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zts
 * JD-Core Version:    0.7.0.1
 */