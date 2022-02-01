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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class xpv
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public xpv(View paramView)
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
    paramMap.put(new xpx(this), "");
  }
  
  public void a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramxhf = paramxhf.a();
    if (paramxhf == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramxhf.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      bdla.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = zfj.b(i);
      switch (i)
      {
      default: 
        paramxhf = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramxhf);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramxhf = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramxhf = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramxhf.a != null) && (paramxhf.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Xhf != null)
    {
      localObject = this.jdField_a_of_type_Xhf.a();
      if (localObject != null) {
        break label41;
      }
      ykq.e(this.b, "click error , video info not found");
    }
    label41:
    VideoViewVideoHolder localVideoViewVideoHolder;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = null;
      break;
      localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      zfj.a(((StoryVideoItem)localObject).mSourceTagType);
      switch (((StoryVideoItem)localObject).mSourceTagType)
      {
      }
    }
    Dialog localDialog = zgk.a(b(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new xpw(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (zfn.a(b()))
    {
      i = 2;
      label154:
      ykv.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
      if (!zfn.a(b())) {
        break label235;
      }
    }
    label235:
    for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
    {
      bdla.b(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      break;
      i = 1;
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpv
 * JD-Core Version:    0.7.0.1
 */