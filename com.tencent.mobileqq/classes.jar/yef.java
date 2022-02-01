import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class yef
  implements View.OnClickListener
{
  public yef(yed paramyed, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    yuk.d("QQStoryMainController", "top right button on click:" + this.jdField_a_of_type_Yed);
    String str;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Yed.c)) && (nnr.a(this.jdField_a_of_type_Yed.c)))
    {
      str = this.jdField_a_of_type_Yed.c;
      if (this.jdField_a_of_type_Yed.a != 1) {
        break label179;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      label102:
      yup.a("hall", "exp", 0, 0, new String[] { "" });
      if (!"troopStoryHallConfig".equals(this.jdField_a_of_type_JavaLangString)) {
        break label204;
      }
      yup.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
      label179:
      if ((this.jdField_a_of_type_Yed.a == 2) || (this.jdField_a_of_type_Yed.a != 3)) {
        break label102;
      }
      break label102;
      label204:
      yup.a("home_page", "clk_find_entry", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yef
 * JD-Core Version:    0.7.0.1
 */