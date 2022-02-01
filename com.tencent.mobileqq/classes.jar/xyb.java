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

public class xyb
  extends xwm
{
  private String jdField_a_of_type_JavaLangString = "";
  private wuw jdField_a_of_type_Wuw;
  private xqz jdField_a_of_type_Xqz;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xyc(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wuw == null) || (this.jdField_a_of_type_Wuw.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wuw.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bhni.a(QQStoryContext.a(), this.jdField_a_of_type_Xwj.b(), this.jdField_a_of_type_Wuw.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Xwj.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Wuw.a());
    this.jdField_a_of_type_Xwj.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Wuw.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      yup.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    this.jdField_a_of_type_Xqz = paramxqz;
    StoryVideoItem localStoryVideoItem = paramxqz.a();
    wuw localwuw = localStoryVideoItem.getVideoLinkInfo();
    if ((localwuw == null) || (localwuw.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Xwj.k();
      this.jdField_a_of_type_Xqz = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxqz.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Wuw = localwuw;
      this.jdField_a_of_type_Xwj.j();
      paramxwn.b.setVisibility(0);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localwuw.e)) {
        break label184;
      }
      paramxwn.b.setText(localwuw.e);
    }
    for (;;)
    {
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(localwuw.b());
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localwuw.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846637);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxqz.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramxwn.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localwuw.d))
    {
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
      return;
    }
    xwj.a(localwuw.d, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyb
 * JD-Core Version:    0.7.0.1
 */