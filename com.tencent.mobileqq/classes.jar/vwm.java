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

public class vwm
  extends vux
{
  private String jdField_a_of_type_JavaLangString = "";
  private utg jdField_a_of_type_Utg;
  private vpk jdField_a_of_type_Vpk;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new vwn(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Utg == null) || (this.jdField_a_of_type_Utg.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Utg.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bdds.a(QQStoryContext.a(), this.jdField_a_of_type_Vuu.b(), this.jdField_a_of_type_Utg.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Vuu.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Utg.a());
    this.jdField_a_of_type_Vuu.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Utg.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      wta.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    this.jdField_a_of_type_Vpk = paramvpk;
    StoryVideoItem localStoryVideoItem = paramvpk.a();
    utg localutg = localStoryVideoItem.getVideoLinkInfo();
    if ((localutg == null) || (localutg.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Vuu.k();
      this.jdField_a_of_type_Vpk = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvpk.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Utg = localutg;
      this.jdField_a_of_type_Vuu.j();
      paramvuy.b.setVisibility(0);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localutg.e)) {
        break label184;
      }
      paramvuy.b.setText(localutg.e);
    }
    for (;;)
    {
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(localutg.b());
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localutg.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846108);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvpk.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramvuy.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localutg.d))
    {
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839435);
      return;
    }
    vuu.a(localutg.d, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwm
 * JD-Core Version:    0.7.0.1
 */