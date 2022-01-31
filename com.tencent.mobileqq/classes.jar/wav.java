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

public class wav
  extends vzg
{
  private String jdField_a_of_type_JavaLangString = "";
  private uxp jdField_a_of_type_Uxp;
  private vtt jdField_a_of_type_Vtt;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new waw(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Uxp == null) || (this.jdField_a_of_type_Uxp.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Uxp.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bdib.a(QQStoryContext.a(), this.jdField_a_of_type_Vzd.b(), this.jdField_a_of_type_Uxp.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Vzd.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Uxp.a());
    this.jdField_a_of_type_Vzd.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Uxp.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      wxj.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    this.jdField_a_of_type_Vtt = paramvtt;
    StoryVideoItem localStoryVideoItem = paramvtt.a();
    uxp localuxp = localStoryVideoItem.getVideoLinkInfo();
    if ((localuxp == null) || (localuxp.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Vzd.k();
      this.jdField_a_of_type_Vtt = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvtt.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Uxp = localuxp;
      this.jdField_a_of_type_Vzd.j();
      paramvzh.b.setVisibility(0);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localuxp.e)) {
        break label184;
      }
      paramvzh.b.setText(localuxp.e);
    }
    for (;;)
    {
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(localuxp.b());
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localuxp.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846181);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvtt.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramvzh.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localuxp.d))
    {
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839436);
      return;
    }
    vzd.a(localuxp.d, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wav
 * JD-Core Version:    0.7.0.1
 */