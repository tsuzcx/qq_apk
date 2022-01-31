import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class wgz
  implements View.OnClickListener
{
  public wgz(wgx paramwgx, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    wxe.d("QQStoryMainController", "top right button on click:" + this.jdField_a_of_type_Wgx);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Wgx.c)) && (ndd.a(this.jdField_a_of_type_Wgx.c)))
    {
      paramView = this.jdField_a_of_type_Wgx.c;
      if (this.jdField_a_of_type_Wgx.a != 1) {
        break label172;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
    for (;;)
    {
      wxj.a("hall", "exp", 0, 0, new String[] { "" });
      if (!"troopStoryHallConfig".equals(this.jdField_a_of_type_JavaLangString)) {
        break label197;
      }
      wxj.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
      return;
      paramView = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
      label172:
      if ((this.jdField_a_of_type_Wgx.a == 2) || (this.jdField_a_of_type_Wgx.a != 3)) {}
    }
    label197:
    wxj.a("home_page", "clk_find_entry", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */