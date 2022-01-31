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

public class wcg
  extends vzg
{
  private String jdField_a_of_type_JavaLangString = "";
  private uxp jdField_a_of_type_Uxp;
  private vtt jdField_a_of_type_Vtt;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new wci(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Vtt == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Vtt.a();
    paramView = xva.a(this.jdField_a_of_type_Vzd.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Vzd.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new wch(this, localVideoViewVideoHolder));
    }
    if (xsx.a(this.jdField_a_of_type_Vzd.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      wxj.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    this.jdField_a_of_type_Vtt = paramvtt;
    StoryVideoItem localStoryVideoItem = paramvtt.a();
    this.jdField_a_of_type_Uxp = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Uxp == null) || (this.jdField_a_of_type_Uxp.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Vzd.k();
      return;
    }
    this.jdField_a_of_type_Vzd.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvtt.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramvtt = this.jdField_a_of_type_Uxp.b;
      String str1 = this.jdField_a_of_type_Uxp.c;
      String str2 = this.jdField_a_of_type_Uxp.d;
      wxe.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramvtt, str1, str2);
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramvzh.b.setVisibility(0);
      paramvzh.b.setTypeface(null, 0);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      vzd.a(str2, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
      paramvzh.b.setText(paramvtt);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      wxj.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvtt.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcg
 * JD-Core Version:    0.7.0.1
 */