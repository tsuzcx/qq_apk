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

public class uhu
  extends ugf
{
  private String jdField_a_of_type_JavaLangString = "";
  private teo jdField_a_of_type_Teo;
  private uas jdField_a_of_type_Uas;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new uhv(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Teo == null) || (this.jdField_a_of_type_Teo.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Teo.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bbex.a(QQStoryContext.a(), this.jdField_a_of_type_Ugc.b(), this.jdField_a_of_type_Teo.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Ugc.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Teo.a());
    this.jdField_a_of_type_Ugc.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Teo.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      vei.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(ugg paramugg, uas paramuas)
  {
    this.jdField_a_of_type_Uas = paramuas;
    StoryVideoItem localStoryVideoItem = paramuas.a();
    teo localteo = localStoryVideoItem.getVideoLinkInfo();
    if ((localteo == null) || (localteo.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Ugc.k();
      this.jdField_a_of_type_Uas = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuas.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Teo = localteo;
      this.jdField_a_of_type_Ugc.j();
      paramugg.b.setVisibility(0);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localteo.e)) {
        break label184;
      }
      paramugg.b.setText(localteo.e);
    }
    for (;;)
    {
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(localteo.b());
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localteo.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845729);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuas.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramugg.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localteo.d))
    {
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
      return;
    }
    ugc.a(localteo.d, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhu
 * JD-Core Version:    0.7.0.1
 */