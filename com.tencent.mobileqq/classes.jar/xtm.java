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

public class xtm
  extends xsr
{
  private wrb a;
  
  private wrb a(StoryVideoItem paramStoryVideoItem)
  {
    wrb localwrb = paramStoryVideoItem.getOALinkInfo();
    if ((localwrb != null) && (localwrb.a != null))
    {
      yqp.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localwrb;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localwrb = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localwrb;
      } while (localwrb == null);
      paramStoryVideoItem = localwrb;
    } while (localwrb.a == null);
    yqp.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localwrb;
  }
  
  public Set<xli> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xtn(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Wrb == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wrb.a == null)
    {
      yqp.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Wrb.a.a;
    paramView = this.jdField_a_of_type_Wrb.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Xso.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Xso.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bgng.a(QQStoryContext.a(), this.jdField_a_of_type_Xso.b(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    yqp.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Xso.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(xss paramxss, xne paramxne)
  {
    paramxne = a(paramxne.a());
    if (paramxne == null)
    {
      this.jdField_a_of_type_Xso.k();
      return;
    }
    this.jdField_a_of_type_Wrb = paramxne;
    this.jdField_a_of_type_Xso.j();
    paramxss.b.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramxne.e)) {
      paramxss.b.setText(paramxne.e);
    }
    for (;;)
    {
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(paramxne.b());
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramxne.d)) {
        break;
      }
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839610);
      return;
      paramxss.b.setVisibility(8);
    }
    xso.a(paramxne.d, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Xso.b();
    ((wpa)wpm.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtm
 * JD-Core Version:    0.7.0.1
 */