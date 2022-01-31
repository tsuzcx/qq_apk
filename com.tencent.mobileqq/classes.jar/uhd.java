import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.HashSet;
import java.util.Set;

public class uhd
  extends ugi
{
  private ter a;
  
  private ter a(StoryVideoItem paramStoryVideoItem)
  {
    ter localter = paramStoryVideoItem.getOALinkInfo();
    if ((localter != null) && (localter.a != null))
    {
      veg.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localter;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localter = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localter;
      } while (localter == null);
      paramStoryVideoItem = localter;
    } while (localter.a == null);
    veg.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localter;
  }
  
  public Set<tyz> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new uhe(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Ter == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Ter.a == null)
    {
      veg.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Ter.a.a;
    paramView = this.jdField_a_of_type_Ter.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Ugf.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Ugf.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bbej.a(QQStoryContext.a(), this.jdField_a_of_type_Ugf.b(), (String)localObject);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    veg.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Ugf.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(ugj paramugj, uav paramuav)
  {
    paramuav = a(paramuav.a());
    if (paramuav == null)
    {
      this.jdField_a_of_type_Ugf.k();
      return;
    }
    this.jdField_a_of_type_Ter = paramuav;
    this.jdField_a_of_type_Ugf.j();
    paramugj.b.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramuav.e)) {
      paramugj.b.setText(paramuav.e);
    }
    for (;;)
    {
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(paramuav.b());
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramuav.d)) {
        break;
      }
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
      return;
      paramugj.b.setVisibility(8);
    }
    ugf.a(paramuav.d, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Ugf.b();
    ((tcq)tdc.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */