import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class xul
  implements View.OnClickListener
{
  public xul(xuj paramxuj, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ykq.d("QQStoryMainController", "top right button on click:" + this.jdField_a_of_type_Xuj);
    String str;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Xuj.c)) && (HttpUtil.isValidUrl(this.jdField_a_of_type_Xuj.c)))
    {
      str = this.jdField_a_of_type_Xuj.c;
      if (this.jdField_a_of_type_Xuj.a != 1) {
        break label179;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      label102:
      ykv.a("hall", "exp", 0, 0, new String[] { "" });
      if (!"troopStoryHallConfig".equals(this.jdField_a_of_type_JavaLangString)) {
        break label204;
      }
      ykv.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
      label179:
      if ((this.jdField_a_of_type_Xuj.a == 2) || (this.jdField_a_of_type_Xuj.a != 3)) {
        break label102;
      }
      break label102;
      label204:
      ykv.a("home_page", "clk_find_entry", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xul
 * JD-Core Version:    0.7.0.1
 */