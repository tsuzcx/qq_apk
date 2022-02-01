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

public class xxh
  extends xwm
{
  private wuw a;
  
  private wuw a(StoryVideoItem paramStoryVideoItem)
  {
    wuw localwuw = paramStoryVideoItem.getOALinkInfo();
    if ((localwuw != null) && (localwuw.a != null))
    {
      yuk.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localwuw;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localwuw = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localwuw;
      } while (localwuw == null);
      paramStoryVideoItem = localwuw;
    } while (localwuw.a == null);
    yuk.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localwuw;
  }
  
  public Set<xpd> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xxi(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Wuw == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wuw.a == null)
    {
      yuk.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Wuw.a.a;
    paramView = this.jdField_a_of_type_Wuw.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Xwj.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Xwj.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bhni.a(QQStoryContext.a(), this.jdField_a_of_type_Xwj.b(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    yuk.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Xwj.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    paramxqz = a(paramxqz.a());
    if (paramxqz == null)
    {
      this.jdField_a_of_type_Xwj.k();
      return;
    }
    this.jdField_a_of_type_Wuw = paramxqz;
    this.jdField_a_of_type_Xwj.j();
    paramxwn.b.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramxqz.e)) {
      paramxwn.b.setText(paramxqz.e);
    }
    for (;;)
    {
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(paramxqz.b());
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramxqz.d)) {
        break;
      }
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
      return;
      paramxwn.b.setVisibility(8);
    }
    xwj.a(paramxqz.d, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Xwj.b();
    ((wsv)wth.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxh
 * JD-Core Version:    0.7.0.1
 */