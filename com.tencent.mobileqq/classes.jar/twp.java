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

public class twp
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public twp(View paramView)
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
    paramMap.put(new twr(this), "");
  }
  
  public void a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramtnz = paramtnz.a();
    if (paramtnz == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramtnz.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      awqx.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = vmz.b(i);
      switch (i)
      {
      default: 
        paramtnz = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtnz);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramtnz = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramtnz = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramtnz.a != null) && (paramtnz.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Tnz != null) {}
    for (paramView = this.jdField_a_of_type_Tnz.a(); paramView == null; paramView = null)
    {
      urk.e(this.b, "click error , video info not found");
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    vmz.a(paramView.mSourceTagType);
    switch (paramView.mSourceTagType)
    {
    default: 
      return;
    }
    Dialog localDialog = vpg.a(b(), paramView.mOwnerUid, "4", paramView.mVid, 3, paramView.mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new twq(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (vnd.a(b()))
    {
      i = 2;
      urp.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramView.mOwnerUid, "weishi", paramView.mVid });
      if (!vnd.a(b())) {
        break label220;
      }
    }
    label220:
    for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
    {
      awqx.b(null, "dc00898", "", "", "weishi_share_videoplay", paramView, 0, 0, "", "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twp
 * JD-Core Version:    0.7.0.1
 */