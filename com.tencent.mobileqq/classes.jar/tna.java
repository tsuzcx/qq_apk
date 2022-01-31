import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.statistics.ReportController;

class tna
  implements Runnable
{
  tna(tmz paramtmz, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
      return;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("http://"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("https://")) {
        localObject1 = "http://" + (String)localObject2;
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_Tmz.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("is_register_uin", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("register_uin_msg", 104);
    ((Intent)localObject2).putExtra("register_uin_class", RegisterPhoneNumActivity.class.getName());
    this.jdField_a_of_type_Tmz.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
    ReportController.b(this.jdField_a_of_type_Tmz.a.app, "CliOper", "", "", "0X800665A", "0X800665A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tna
 * JD-Core Version:    0.7.0.1
 */