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

public class twm
  extends ttm
{
  private String jdField_a_of_type_JavaLangString = "";
  private srv jdField_a_of_type_Srv;
  private tnz jdField_a_of_type_Tnz;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new two(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Tnz == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Tnz.a();
    paramView = vpg.a(this.jdField_a_of_type_Ttj.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Ttj.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new twn(this, localVideoViewVideoHolder));
    }
    if (vnd.a(this.jdField_a_of_type_Ttj.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      urp.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    this.jdField_a_of_type_Tnz = paramtnz;
    StoryVideoItem localStoryVideoItem = paramtnz.a();
    this.jdField_a_of_type_Srv = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Srv == null) || (this.jdField_a_of_type_Srv.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Ttj.k();
      return;
    }
    this.jdField_a_of_type_Ttj.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramtnz.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramtnz = this.jdField_a_of_type_Srv.b;
      String str1 = this.jdField_a_of_type_Srv.c;
      String str2 = this.jdField_a_of_type_Srv.d;
      urk.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramtnz, str1, str2);
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramttn.b.setVisibility(0);
      paramttn.b.setTypeface(null, 0);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ttj.a(str2, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
      paramttn.b.setText(paramtnz);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      urp.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramtnz.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twm
 * JD-Core Version:    0.7.0.1
 */