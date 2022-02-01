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

public class xoh
  extends xms
{
  private String jdField_a_of_type_JavaLangString = "";
  private wlh jdField_a_of_type_Wlh;
  private xhf jdField_a_of_type_Xhf;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xoi(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wlh == null) || (this.jdField_a_of_type_Wlh.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wlh.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bhey.a(QQStoryContext.a(), this.jdField_a_of_type_Xmp.b(), this.jdField_a_of_type_Wlh.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_Xmp.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Wlh.a());
    this.jdField_a_of_type_Xmp.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Wlh.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      ykv.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    this.jdField_a_of_type_Xhf = paramxhf;
    StoryVideoItem localStoryVideoItem = paramxhf.a();
    wlh localwlh = localStoryVideoItem.getVideoLinkInfo();
    if ((localwlh == null) || (localwlh.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_Xmp.k();
      this.jdField_a_of_type_Xhf = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxhf.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_Wlh = localwlh;
      this.jdField_a_of_type_Xmp.j();
      paramxmt.b.setVisibility(0);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localwlh.e)) {
        break label184;
      }
      paramxmt.b.setText(localwlh.e);
    }
    for (;;)
    {
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(localwlh.b());
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localwlh.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846641);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxhf.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramxmt.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localwlh.d))
    {
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839677);
      return;
    }
    xmp.a(localwlh.d, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */