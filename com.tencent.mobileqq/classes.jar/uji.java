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

public class uji
  extends ugi
{
  private String jdField_a_of_type_JavaLangString = "";
  private ter jdField_a_of_type_Ter;
  private uav jdField_a_of_type_Uav;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new ujk(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Uav == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Uav.a();
    paramView = wcc.a(this.jdField_a_of_type_Ugf.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Ugf.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new ujj(this, localVideoViewVideoHolder));
    }
    if (vzz.a(this.jdField_a_of_type_Ugf.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      vel.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(ugj paramugj, uav paramuav)
  {
    this.jdField_a_of_type_Uav = paramuav;
    StoryVideoItem localStoryVideoItem = paramuav.a();
    this.jdField_a_of_type_Ter = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Ter == null) || (this.jdField_a_of_type_Ter.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Ugf.k();
      return;
    }
    this.jdField_a_of_type_Ugf.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuav.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramuav = this.jdField_a_of_type_Ter.b;
      String str1 = this.jdField_a_of_type_Ter.c;
      String str2 = this.jdField_a_of_type_Ter.d;
      veg.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramuav, str1, str2);
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramugj.b.setVisibility(0);
      paramugj.b.setTypeface(null, 0);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ugf.a(str2, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
      paramugj.b.setText(paramuav);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      vel.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuav.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */