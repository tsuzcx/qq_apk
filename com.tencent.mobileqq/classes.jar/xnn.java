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

public class xnn
  extends xms
{
  private wlh a;
  
  private wlh a(StoryVideoItem paramStoryVideoItem)
  {
    wlh localwlh = paramStoryVideoItem.getOALinkInfo();
    if ((localwlh != null) && (localwlh.a != null))
    {
      ykq.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localwlh;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localwlh = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localwlh;
      } while (localwlh == null);
      paramStoryVideoItem = localwlh;
    } while (localwlh.a == null);
    ykq.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localwlh;
  }
  
  public Set<xfj> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xno(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Wlh == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wlh.a == null)
    {
      ykq.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Wlh.a.a;
    paramView = this.jdField_a_of_type_Wlh.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Xmp.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Xmp.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bhey.a(QQStoryContext.a(), this.jdField_a_of_type_Xmp.b(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    ykq.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Xmp.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    paramxhf = a(paramxhf.a());
    if (paramxhf == null)
    {
      this.jdField_a_of_type_Xmp.k();
      return;
    }
    this.jdField_a_of_type_Wlh = paramxhf;
    this.jdField_a_of_type_Xmp.j();
    paramxmt.b.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramxhf.e)) {
      paramxmt.b.setText(paramxhf.e);
    }
    for (;;)
    {
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(paramxhf.b());
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramxhf.d)) {
        break;
      }
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839677);
      return;
      paramxmt.b.setVisibility(8);
    }
    xmp.a(paramxhf.d, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Xmp.b();
    ((wjg)wjs.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnn
 * JD-Core Version:    0.7.0.1
 */