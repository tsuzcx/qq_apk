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

public class xzp
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private TextView a;
  private String c = "";
  private boolean e;
  
  public xzp(View paramView)
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
    paramMap.put(new xzr(this), "");
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramxqz = paramxqz.a();
    if (paramxqz == null)
    {
      k();
      return;
    }
    if (TextUtils.equals(this.c, paramStoryVideoItem.mVid))
    {
      this.e = false;
      int i = paramxqz.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      j();
      bdll.b(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = zpz.b(i);
      switch (i)
      {
      default: 
        paramxqz = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramxqz);
      return;
      this.e = true;
      this.c = paramStoryVideoItem.mVid;
      break;
      label123:
      k();
      return;
      paramxqz = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramxqz = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramxqz.a != null) && (paramxqz.a.a == 13)) {}
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
    if (this.jdField_a_of_type_Xqz != null)
    {
      localObject = this.jdField_a_of_type_Xqz.a();
      if (localObject != null) {
        break label41;
      }
      yuk.e(this.b, "click error , video info not found");
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
      zpz.a(((StoryVideoItem)localObject).mSourceTagType);
      switch (((StoryVideoItem)localObject).mSourceTagType)
      {
      }
    }
    Dialog localDialog = zsg.a(b(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new xzq(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
    int i;
    if (zqd.a(b()))
    {
      i = 2;
      label154:
      yup.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
      if (!zqd.a(b())) {
        break label235;
      }
    }
    label235:
    for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
    {
      bdll.b(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      break;
      i = 1;
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzp
 * JD-Core Version:    0.7.0.1
 */