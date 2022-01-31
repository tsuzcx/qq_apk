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

public class uji
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public uji(View paramView)
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
    paramMap.put(new ujk(this), "");
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramuas = paramuas.a();
    if (paramuas == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramuas.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      axqy.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = vzs.b(i);
      switch (i)
      {
      default: 
        paramuas = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramuas);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramuas = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramuas = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramuas.a != null) && (paramuas.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Uas != null) {}
    for (paramView = this.jdField_a_of_type_Uas.a(); paramView == null; paramView = null)
    {
      ved.e(this.b, "click error , video info not found");
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    vzs.a(paramView.mSourceTagType);
    switch (paramView.mSourceTagType)
    {
    default: 
      return;
    }
    Dialog localDialog = wbz.a(b(), paramView.mOwnerUid, "4", paramView.mVid, 3, paramView.mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new ujj(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (vzw.a(b()))
    {
      i = 2;
      vei.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramView.mOwnerUid, "weishi", paramView.mVid });
      if (!vzw.a(b())) {
        break label220;
      }
    }
    label220:
    for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
    {
      axqy.b(null, "dc00898", "", "", "weishi_share_videoplay", paramView, 0, 0, "", "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */