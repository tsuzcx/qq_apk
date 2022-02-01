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

public class xps
  extends xms
{
  private String jdField_a_of_type_JavaLangString = "";
  private wlh jdField_a_of_type_Wlh;
  private xhf jdField_a_of_type_Xhf;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xpu(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Xhf == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
    paramView = zgk.a(this.jdField_a_of_type_Xmp.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Xmp.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new xpt(this, localVideoViewVideoHolder));
    }
    if (zfn.a(this.jdField_a_of_type_Xmp.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      ykv.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    this.jdField_a_of_type_Xhf = paramxhf;
    StoryVideoItem localStoryVideoItem = paramxhf.a();
    this.jdField_a_of_type_Wlh = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Wlh == null) || (this.jdField_a_of_type_Wlh.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Xmp.k();
      return;
    }
    this.jdField_a_of_type_Xmp.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxhf.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramxhf = this.jdField_a_of_type_Wlh.b;
      String str1 = this.jdField_a_of_type_Wlh.c;
      String str2 = this.jdField_a_of_type_Wlh.d;
      ykq.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramxhf, str1, str2);
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxmt.b.setVisibility(0);
      paramxmt.b.setTypeface(null, 0);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      xmp.a(str2, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
      paramxmt.b.setText(paramxhf);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      ykv.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxhf.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xps
 * JD-Core Version:    0.7.0.1
 */