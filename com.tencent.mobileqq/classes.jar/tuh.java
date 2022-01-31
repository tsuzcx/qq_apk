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

public class tuh
  extends ttm
{
  private srv a;
  
  private srv a(StoryVideoItem paramStoryVideoItem)
  {
    srv localsrv = paramStoryVideoItem.getOALinkInfo();
    if ((localsrv != null) && (localsrv.a != null))
    {
      urk.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localsrv;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localsrv = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localsrv;
      } while (localsrv == null);
      paramStoryVideoItem = localsrv;
    } while (localsrv.a == null);
    urk.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localsrv;
  }
  
  public Set<tmd> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new tui(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Srv == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Srv.a == null)
    {
      urk.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Srv.a.a;
    paramView = this.jdField_a_of_type_Srv.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Ttj.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Ttj.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bade.a(QQStoryContext.a(), this.jdField_a_of_type_Ttj.b(), (String)localObject);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    urk.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Ttj.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    paramtnz = a(paramtnz.a());
    if (paramtnz == null)
    {
      this.jdField_a_of_type_Ttj.k();
      return;
    }
    this.jdField_a_of_type_Srv = paramtnz;
    this.jdField_a_of_type_Ttj.j();
    paramttn.b.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramtnz.e)) {
      paramttn.b.setText(paramtnz.e);
    }
    for (;;)
    {
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(paramtnz.b());
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramtnz.d)) {
        break;
      }
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839330);
      return;
      paramttn.b.setVisibility(8);
    }
    ttj.a(paramtnz.d, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Ttj.b();
    ((spu)sqg.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuh
 * JD-Core Version:    0.7.0.1
 */