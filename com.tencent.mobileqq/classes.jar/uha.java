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

public class uha
  extends ugf
{
  private teo a;
  
  private teo a(StoryVideoItem paramStoryVideoItem)
  {
    teo localteo = paramStoryVideoItem.getOALinkInfo();
    if ((localteo != null) && (localteo.a != null))
    {
      ved.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localteo;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localteo = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localteo;
      } while (localteo == null);
      paramStoryVideoItem = localteo;
    } while (localteo.a == null);
    ved.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localteo;
  }
  
  public Set<tyw> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new uhb(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Teo == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Teo.a == null)
    {
      ved.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Teo.a.a;
    paramView = this.jdField_a_of_type_Teo.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Ugc.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Ugc.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bbex.a(QQStoryContext.a(), this.jdField_a_of_type_Ugc.b(), (String)localObject);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    ved.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Ugc.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(ugg paramugg, uas paramuas)
  {
    paramuas = a(paramuas.a());
    if (paramuas == null)
    {
      this.jdField_a_of_type_Ugc.k();
      return;
    }
    this.jdField_a_of_type_Teo = paramuas;
    this.jdField_a_of_type_Ugc.j();
    paramugg.b.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramuas.e)) {
      paramugg.b.setText(paramuas.e);
    }
    for (;;)
    {
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(paramuas.b());
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramuas.d)) {
        break;
      }
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
      return;
      paramugg.b.setVisibility(8);
    }
    ugc.a(paramuas.d, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Ugc.b();
    ((tcn)tcz.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */