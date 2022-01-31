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

public class vvs
  extends vux
{
  private utg a;
  
  private utg a(StoryVideoItem paramStoryVideoItem)
  {
    utg localutg = paramStoryVideoItem.getOALinkInfo();
    if ((localutg != null) && (localutg.a != null))
    {
      wsv.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localutg;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localutg = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localutg;
      } while (localutg == null);
      paramStoryVideoItem = localutg;
    } while (localutg.a == null);
    wsv.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localutg;
  }
  
  public Set<vno> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new vvt(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_Utg == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Utg.a == null)
    {
      wsv.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_Utg.a.a;
    paramView = this.jdField_a_of_type_Utg.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_Vuu.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_Vuu.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = bdds.a(QQStoryContext.a(), this.jdField_a_of_type_Vuu.b(), (String)localObject);
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    wsv.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_Vuu.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    paramvpk = a(paramvpk.a());
    if (paramvpk == null)
    {
      this.jdField_a_of_type_Vuu.k();
      return;
    }
    this.jdField_a_of_type_Utg = paramvpk;
    this.jdField_a_of_type_Vuu.j();
    paramvuy.b.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramvpk.e)) {
      paramvuy.b.setText(paramvpk.e);
    }
    for (;;)
    {
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(paramvpk.b());
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramvpk.d)) {
        break;
      }
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839435);
      return;
      paramvuy.b.setVisibility(8);
    }
    vuu.a(paramvpk.d, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_Vuu.b();
    ((urf)urr.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvs
 * JD-Core Version:    0.7.0.1
 */