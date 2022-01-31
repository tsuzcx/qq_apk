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

public class tvb
  extends ttm
{
  private String jdField_a_of_type_JavaLangString = "";
  private srv jdField_a_of_type_Srv;
  private tnz jdField_a_of_type_Tnz;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new tvc(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Srv == null) || (this.jdField_a_of_type_Srv.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Srv.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bade.a(QQStoryContext.a(), this.jdField_a_of_type_Ttj.b(), this.jdField_a_of_type_Srv.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Ttj.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Srv.a());
    this.jdField_a_of_type_Ttj.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Srv.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      urp.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    this.jdField_a_of_type_Tnz = paramtnz;
    StoryVideoItem localStoryVideoItem = paramtnz.a();
    srv localsrv = localStoryVideoItem.getVideoLinkInfo();
    if ((localsrv == null) || (localsrv.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Ttj.k();
      this.jdField_a_of_type_Tnz = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramtnz.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Srv = localsrv;
      this.jdField_a_of_type_Ttj.j();
      paramttn.b.setVisibility(0);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localsrv.e)) {
        break label184;
      }
      paramttn.b.setText(localsrv.e);
    }
    for (;;)
    {
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(localsrv.b());
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localsrv.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845540);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramtnz.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramttn.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localsrv.d))
    {
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839330);
      return;
    }
    ttj.a(localsrv.d, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvb
 * JD-Core Version:    0.7.0.1
 */