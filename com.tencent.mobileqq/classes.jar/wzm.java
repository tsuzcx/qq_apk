import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class wzm
  extends wxx
{
  private String jdField_a_of_type_JavaLangString = "";
  private vwm jdField_a_of_type_Vwm;
  private wsk jdField_a_of_type_Wsk;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new wzn(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Vwm == null) || (this.jdField_a_of_type_Vwm.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Vwm.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bfwg.a(QQStoryContext.a(), this.jdField_a_of_type_Wxu.b(), this.jdField_a_of_type_Vwm.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Wxu.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Vwm.a());
    this.jdField_a_of_type_Wxu.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Vwm.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      xwa.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    this.jdField_a_of_type_Wsk = paramwsk;
    StoryVideoItem localStoryVideoItem = paramwsk.a();
    vwm localvwm = localStoryVideoItem.getVideoLinkInfo();
    if ((localvwm == null) || (localvwm.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Wxu.k();
      this.jdField_a_of_type_Wsk = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramwsk.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Vwm = localvwm;
      this.jdField_a_of_type_Wxu.j();
      paramwxy.b.setVisibility(0);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localvwm.e)) {
        break label184;
      }
      paramwxy.b.setText(localvwm.e);
    }
    for (;;)
    {
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(localvwm.b());
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localvwm.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846545);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramwsk.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramwxy.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localvwm.d))
    {
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839656);
      return;
    }
    wxu.a(localvwm.d, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzm
 * JD-Core Version:    0.7.0.1
 */