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

public class xvr
  extends xsr
{
  private String jdField_a_of_type_JavaLangString = "";
  private wrb jdField_a_of_type_Wrb;
  private xne jdField_a_of_type_Xne;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xvt(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Xne == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xne.a();
    paramView = zol.a(this.jdField_a_of_type_Xso.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Xso.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new xvs(this, localVideoViewVideoHolder));
    }
    if (zmi.a(this.jdField_a_of_type_Xso.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      yqu.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(xss paramxss, xne paramxne)
  {
    this.jdField_a_of_type_Xne = paramxne;
    StoryVideoItem localStoryVideoItem = paramxne.a();
    this.jdField_a_of_type_Wrb = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Wrb == null) || (this.jdField_a_of_type_Wrb.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Xso.k();
      return;
    }
    this.jdField_a_of_type_Xso.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxne.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramxne = this.jdField_a_of_type_Wrb.b;
      String str1 = this.jdField_a_of_type_Wrb.c;
      String str2 = this.jdField_a_of_type_Wrb.d;
      yqp.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramxne, str1, str2);
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxss.b.setVisibility(0);
      paramxss.b.setTypeface(null, 0);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      xso.a(str2, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
      paramxss.b.setText(paramxne);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      yqu.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxne.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvr
 * JD-Core Version:    0.7.0.1
 */