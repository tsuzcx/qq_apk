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

public class uhx
  extends ugi
{
  private String jdField_a_of_type_JavaLangString = "";
  private ter jdField_a_of_type_Ter;
  private uav jdField_a_of_type_Uav;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new uhy(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Ter == null) || (this.jdField_a_of_type_Ter.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Ter.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bbej.a(QQStoryContext.a(), this.jdField_a_of_type_Ugf.b(), this.jdField_a_of_type_Ter.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Ugf.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Ter.a());
    this.jdField_a_of_type_Ugf.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ter.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      vel.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(ugj paramugj, uav paramuav)
  {
    this.jdField_a_of_type_Uav = paramuav;
    StoryVideoItem localStoryVideoItem = paramuav.a();
    ter localter = localStoryVideoItem.getVideoLinkInfo();
    if ((localter == null) || (localter.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Ugf.k();
      this.jdField_a_of_type_Uav = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuav.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Ter = localter;
      this.jdField_a_of_type_Ugf.j();
      paramugj.b.setVisibility(0);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localter.e)) {
        break label184;
      }
      paramugj.b.setText(localter.e);
    }
    for (;;)
    {
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(localter.b());
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localter.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845723);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuav.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramugj.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localter.d))
    {
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
      return;
    }
    ugf.a(localter.d, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */