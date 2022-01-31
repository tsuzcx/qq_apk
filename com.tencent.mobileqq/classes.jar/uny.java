import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class uny
  implements View.OnClickListener
{
  public uny(unw paramunw, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ved.d("QQStoryMainController", "top right button on click:" + this.jdField_a_of_type_Unw);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Unw.c)) && (naj.a(this.jdField_a_of_type_Unw.c)))
    {
      paramView = this.jdField_a_of_type_Unw.c;
      if (this.jdField_a_of_type_Unw.a != 1) {
        break label172;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
    for (;;)
    {
      vei.a("hall", "exp", 0, 0, new String[] { "" });
      if (!"troopStoryHallConfig".equals(this.jdField_a_of_type_JavaLangString)) {
        break label197;
      }
      vei.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
      return;
      paramView = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
      label172:
      if ((this.jdField_a_of_type_Unw.a == 2) || (this.jdField_a_of_type_Unw.a != 3)) {}
    }
    label197:
    vei.a("home_page", "clk_find_entry", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uny
 * JD-Core Version:    0.7.0.1
 */