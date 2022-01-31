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

public class wcj
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public wcj(View paramView)
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
    paramMap.put(new wcl(this), "");
  }
  
  public void a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramvtt = paramvtt.a();
    if (paramvtt == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramvtt.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      azqs.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = xst.b(i);
      switch (i)
      {
      default: 
        paramvtt = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvtt);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramvtt = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramvtt = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramvtt.a != null) && (paramvtt.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Vtt != null) {}
    for (paramView = this.jdField_a_of_type_Vtt.a(); paramView == null; paramView = null)
    {
      wxe.e(this.b, "click error , video info not found");
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    xst.a(paramView.mSourceTagType);
    switch (paramView.mSourceTagType)
    {
    default: 
      return;
    }
    Dialog localDialog = xva.a(b(), paramView.mOwnerUid, "4", paramView.mVid, 3, paramView.mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new wck(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (xsx.a(b()))
    {
      i = 2;
      wxj.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramView.mOwnerUid, "weishi", paramView.mVid });
      if (!xsx.a(b())) {
        break label220;
      }
    }
    label220:
    for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
    {
      azqs.b(null, "dc00898", "", "", "weishi_share_videoplay", paramView, 0, 0, "", "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcj
 * JD-Core Version:    0.7.0.1
 */