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

public class vya
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public vya(View paramView)
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
    paramMap.put(new vyc(this), "");
  }
  
  public void a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramvpk = paramvpk.a();
    if (paramvpk == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramvpk.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      azmj.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = xok.b(i);
      switch (i)
      {
      default: 
        paramvpk = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvpk);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramvpk = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramvpk = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramvpk.a != null) && (paramvpk.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Vpk != null) {}
    for (paramView = this.jdField_a_of_type_Vpk.a(); paramView == null; paramView = null)
    {
      wsv.e(this.b, "click error , video info not found");
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    xok.a(paramView.mSourceTagType);
    switch (paramView.mSourceTagType)
    {
    default: 
      return;
    }
    Dialog localDialog = xqr.a(b(), paramView.mOwnerUid, "4", paramView.mVid, 3, paramView.mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new vyb(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (xoo.a(b()))
    {
      i = 2;
      wta.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramView.mOwnerUid, "weishi", paramView.mVid });
      if (!xoo.a(b())) {
        break label220;
      }
    }
    label220:
    for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
    {
      azmj.b(null, "dc00898", "", "", "weishi_share_videoplay", paramView, 0, 0, "", "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vya
 * JD-Core Version:    0.7.0.1
 */