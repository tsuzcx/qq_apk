import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import java.util.HashSet;
import java.util.Set;

public class wys
  extends wxx
{
  private vwm a;
  
  private vwm a(StoryVideoItem paramStoryVideoItem)
  {
    vwm localvwm = paramStoryVideoItem.getOALinkInfo();
    if ((localvwm != null) && (localvwm.a != null))
    {
      xvv.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localvwm;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localvwm = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localvwm;
      } while (localvwm == null);
      paramStoryVideoItem = localvwm;
    } while (localvwm.a == null);
    xvv.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localvwm;
  }
  
  public Set<wqo> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new wyt(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Vwm == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Vwm.a == null)
    {
      xvv.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Vwm.a.a;
    paramView = this.jdField_a_of_type_Vwm.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Wxu.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Wxu.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bfwg.a(QQStoryContext.a(), this.jdField_a_of_type_Wxu.b(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    xvv.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Wxu.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    paramwsk = a(paramwsk.a());
    if (paramwsk == null)
    {
      this.jdField_a_of_type_Wxu.k();
      return;
    }
    this.jdField_a_of_type_Vwm = paramwsk;
    this.jdField_a_of_type_Wxu.j();
    paramwxy.b.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramwsk.e)) {
      paramwxy.b.setText(paramwsk.e);
    }
    for (;;)
    {
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(paramwsk.b());
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramwsk.d)) {
        break;
      }
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839656);
      return;
      paramwxy.b.setVisibility(8);
    }
    wxu.a(paramwsk.d, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Wxu.b();
    ((vul)vux.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wys
 * JD-Core Version:    0.7.0.1
 */