import android.app.Dialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class ujl
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public ujl(View paramView)
  {
    super(paramView);
  }
  
  public String a()
  {
    return "WeishiTagVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new ujn(this), "");
  }
  
  public void a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramuav = paramuav.a();
    if (paramuav == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramuav.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      axqw.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = vzv.b(i);
      switch (i)
      {
      default: 
        paramuav = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramuav);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramuav = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramuav = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramuav.a != null) && (paramuav.a.a == 13)) {}
    while (paramStoryVideoItem.mSourceTagType != 1) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return -1;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Uav != null) {}
    for (paramView = this.jdField_a_of_type_Uav.a(); paramView == null; paramView = null)
    {
      veg.e(this.b, "click error , video info not found");
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    vzv.a(paramView.mSourceTagType);
    switch (paramView.mSourceTagType)
    {
    default: 
      return;
    }
    Dialog localDialog = wcc.a(b(), paramView.mOwnerUid, "4", paramView.mVid, 3, paramView.mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new ujm(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (vzz.a(b()))
    {
      i = 2;
      vel.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramView.mOwnerUid, "weishi", paramView.mVid });
      if (!vzz.a(b())) {
        break label220;
      }
    }
    label220:
    for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
    {
      axqw.b(null, "dc00898", "", "", "weishi_share_videoplay", paramView, 0, 0, "", "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujl
 * JD-Core Version:    0.7.0.1
 */