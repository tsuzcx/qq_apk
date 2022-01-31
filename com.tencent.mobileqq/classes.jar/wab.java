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

public class wab
  extends vzg
{
  private uxp a;
  
  private uxp a(StoryVideoItem paramStoryVideoItem)
  {
    uxp localuxp = paramStoryVideoItem.getOALinkInfo();
    if ((localuxp != null) && (localuxp.a != null))
    {
      wxe.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localuxp;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localuxp = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localuxp;
      } while (localuxp == null);
      paramStoryVideoItem = localuxp;
    } while (localuxp.a == null);
    wxe.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localuxp;
  }
  
  public Set<vrx> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new wac(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Uxp == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Uxp.a == null)
    {
      wxe.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Uxp.a.a;
    paramView = this.jdField_a_of_type_Uxp.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Vzd.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Vzd.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bdib.a(QQStoryContext.a(), this.jdField_a_of_type_Vzd.b(), (String)localObject);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    wxe.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Vzd.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    paramvtt = a(paramvtt.a());
    if (paramvtt == null)
    {
      this.jdField_a_of_type_Vzd.k();
      return;
    }
    this.jdField_a_of_type_Uxp = paramvtt;
    this.jdField_a_of_type_Vzd.j();
    paramvzh.b.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramvtt.e)) {
      paramvzh.b.setText(paramvtt.e);
    }
    for (;;)
    {
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(paramvtt.b());
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramvtt.d)) {
        break;
      }
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839436);
      return;
      paramvzh.b.setVisibility(8);
    }
    vzd.a(paramvtt.d, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Vzd.b();
    ((uvo)uwa.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wab
 * JD-Core Version:    0.7.0.1
 */