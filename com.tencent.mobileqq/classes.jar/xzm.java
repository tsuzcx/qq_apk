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

public class xzm
  extends xwm
{
  private String jdField_a_of_type_JavaLangString = "";
  private wuw jdField_a_of_type_Wuw;
  private xqz jdField_a_of_type_Xqz;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new xzo(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Xqz == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
    paramView = zsg.a(this.jdField_a_of_type_Xwj.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Xwj.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new xzn(this, localVideoViewVideoHolder));
    }
    if (zqd.a(this.jdField_a_of_type_Xwj.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      yup.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    this.jdField_a_of_type_Xqz = paramxqz;
    StoryVideoItem localStoryVideoItem = paramxqz.a();
    this.jdField_a_of_type_Wuw = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Wuw == null) || (this.jdField_a_of_type_Wuw.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Xwj.k();
      return;
    }
    this.jdField_a_of_type_Xwj.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxqz.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramxqz = this.jdField_a_of_type_Wuw.b;
      String str1 = this.jdField_a_of_type_Wuw.c;
      String str2 = this.jdField_a_of_type_Wuw.d;
      yuk.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramxqz, str1, str2);
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxwn.b.setVisibility(0);
      paramxwn.b.setTypeface(null, 0);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      xwj.a(str2, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
      paramxwn.b.setText(paramxqz);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      yup.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxqz.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzm
 * JD-Core Version:    0.7.0.1
 */