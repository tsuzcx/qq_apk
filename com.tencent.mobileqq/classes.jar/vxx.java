import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class vxx
  extends vux
{
  private String jdField_a_of_type_JavaLangString = "";
  private utg jdField_a_of_type_Utg;
  private vpk jdField_a_of_type_Vpk;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new vxz(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Vpk == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Vpk.a();
    paramView = xqr.a(this.jdField_a_of_type_Vuu.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Vuu.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new vxy(this, localVideoViewVideoHolder));
    }
    if (xoo.a(this.jdField_a_of_type_Vuu.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      wta.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    this.jdField_a_of_type_Vpk = paramvpk;
    StoryVideoItem localStoryVideoItem = paramvpk.a();
    this.jdField_a_of_type_Utg = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Utg == null) || (this.jdField_a_of_type_Utg.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Vuu.k();
      return;
    }
    this.jdField_a_of_type_Vuu.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvpk.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramvpk = this.jdField_a_of_type_Utg.b;
      String str1 = this.jdField_a_of_type_Utg.c;
      String str2 = this.jdField_a_of_type_Utg.d;
      wsv.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramvpk, str1, str2);
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramvuy.b.setVisibility(0);
      paramvuy.b.setTypeface(null, 0);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      vuu.a(str2, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
      paramvuy.b.setText(paramvpk);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      wta.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvpk.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxx
 * JD-Core Version:    0.7.0.1
 */