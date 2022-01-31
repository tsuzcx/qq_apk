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

public class ujf
  extends ugf
{
  private String jdField_a_of_type_JavaLangString = "";
  private teo jdField_a_of_type_Teo;
  private uas jdField_a_of_type_Uas;
  private boolean c;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new ujh(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_Uas == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Uas.a();
    paramView = wbz.a(this.jdField_a_of_type_Ugc.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_Ugc.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new ujg(this, localVideoViewVideoHolder));
    }
    if (vzw.a(this.jdField_a_of_type_Ugc.b())) {}
    for (paramView = "1";; paramView = "2")
    {
      vei.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return true;
    }
  }
  
  public void b(ugg paramugg, uas paramuas)
  {
    this.jdField_a_of_type_Uas = paramuas;
    StoryVideoItem localStoryVideoItem = paramuas.a();
    this.jdField_a_of_type_Teo = localStoryVideoItem.getOALinkInfo();
    if ((this.jdField_a_of_type_Teo == null) || (this.jdField_a_of_type_Teo.jdField_a_of_type_Int != 6))
    {
      this.jdField_a_of_type_Ugc.k();
      return;
    }
    this.jdField_a_of_type_Ugc.j();
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuas.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      paramuas = this.jdField_a_of_type_Teo.b;
      String str1 = this.jdField_a_of_type_Teo.c;
      String str2 = this.jdField_a_of_type_Teo.d;
      ved.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramuas, str1, str2);
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramugg.b.setVisibility(0);
      paramugg.b.setTypeface(null, 0);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ugc.a(str2, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
      paramugg.b.setText(paramuas);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (!this.c) {
        break;
      }
      vei.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuas.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */