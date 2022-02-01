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

public class xug
  extends xsr
{
  private String jdField_a_of_type_JavaLangString = "";
  private wrb jdField_a_of_type_Wrb;
  private xne jdField_a_of_type_Xne;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xuh(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wrb == null) || (this.jdField_a_of_type_Wrb.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wrb.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bgng.a(QQStoryContext.a(), this.jdField_a_of_type_Xso.b(), this.jdField_a_of_type_Wrb.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Xso.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Wrb.a());
    this.jdField_a_of_type_Xso.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Wrb.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      yqu.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(xss paramxss, xne paramxne)
  {
    this.jdField_a_of_type_Xne = paramxne;
    StoryVideoItem localStoryVideoItem = paramxne.a();
    wrb localwrb = localStoryVideoItem.getVideoLinkInfo();
    if ((localwrb == null) || (localwrb.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Xso.k();
      this.jdField_a_of_type_Xne = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxne.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Wrb = localwrb;
      this.jdField_a_of_type_Xso.j();
      paramxss.b.setVisibility(0);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localwrb.e)) {
        break label184;
      }
      paramxss.b.setText(localwrb.e);
    }
    for (;;)
    {
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(localwrb.b());
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localwrb.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846620);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxne.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramxss.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localwrb.d))
    {
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839610);
      return;
    }
    xso.a(localwrb.d, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xug
 * JD-Core Version:    0.7.0.1
 */