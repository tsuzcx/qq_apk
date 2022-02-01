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

public class xax
  extends wxx
{
  private String jdField_a_of_type_JavaLangString = "";
  private vwm jdField_a_of_type_Vwm;
  private wsk jdField_a_of_type_Wsk;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xaz(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Wsk == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
    paramView = yrr.a(this.jdField_a_of_type_Wxu.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Wxu.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new xay(this, localVideoViewVideoHolder));
    }
    if (yqu.a(this.jdField_a_of_type_Wxu.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      xwa.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    this.jdField_a_of_type_Wsk = paramwsk;
    StoryVideoItem localStoryVideoItem = paramwsk.a();
    this.jdField_a_of_type_Vwm = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Vwm == null) || (this.jdField_a_of_type_Vwm.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Wxu.k();
      return;
    }
    this.jdField_a_of_type_Wxu.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramwsk.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramwsk = this.jdField_a_of_type_Vwm.b;
      String str1 = this.jdField_a_of_type_Vwm.c;
      String str2 = this.jdField_a_of_type_Vwm.d;
      xvv.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramwsk, str1, str2);
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramwxy.b.setVisibility(0);
      paramwxy.b.setTypeface(null, 0);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      wxu.a(str2, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
      paramwxy.b.setText(paramwsk);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      xwa.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramwsk.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xax
 * JD-Core Version:    0.7.0.1
 */