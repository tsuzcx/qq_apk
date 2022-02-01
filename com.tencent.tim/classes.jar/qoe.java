import android.app.Dialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class qoe
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private boolean aEu;
  private String axL = "";
  private TextView xr;
  
  public qoe(View paramView)
  {
    super(paramView);
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new qoe.a(this), "");
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramqjq = paramqjq.b();
    if (paramqjq == null)
    {
      hide();
      return;
    }
    if (TextUtils.equals(this.axL, paramStoryVideoItem.mVid))
    {
      this.aEu = false;
      int i = paramqjq.mSourceTagType;
      if (i != 1) {
        break label123;
      }
      show();
      anot.a(null, "dc00898", "", "", "weishi_share_videoplay", "story_entry_exp", 0, 0, "", "", "", "");
      paramStoryVideoItem = rpu.ci(i);
      switch (i)
      {
      default: 
        paramqjq = paramStoryVideoItem;
      }
    }
    for (;;)
    {
      this.xr.setText(paramqjq);
      return;
      this.aEu = true;
      this.axL = paramStoryVideoItem.mVid;
      break;
      label123:
      hide();
      return;
      paramqjq = paramStoryVideoItem;
      if (TextUtils.isEmpty(paramStoryVideoItem)) {
        paramqjq = "来自微视APP";
      }
    }
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramqjq.h != null) && (paramqjq.h.nodeType == 13)) {}
    while (paramStoryVideoItem.mSourceTagType != 1) {
      return false;
    }
    return true;
  }
  
  public void dJ(View paramView)
  {
    this.xr = ((TextView)paramView);
    this.xr.setOnClickListener(this);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy() {}
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public String getTag()
  {
    return "WeishiTagVideoInfoWidget";
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      localObject = this.a.b();
      if (localObject != null) {
        break label41;
      }
      ram.e(this.TAG, "click error , video info not found");
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
      rpu.getJumpUrl(((StoryVideoItem)localObject).mSourceTagType);
      switch (((StoryVideoItem)localObject).mSourceTagType)
      {
      }
    }
    Dialog localDialog = rrt.a(getActivity(), ((StoryVideoItem)localObject).mOwnerUid, "4", ((StoryVideoItem)localObject).mVid, 3, ((StoryVideoItem)localObject).mWsSchema);
    if (localDialog != null)
    {
      localDialog.setOnDismissListener(new qof(this, localVideoViewVideoHolder));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.sH(true);
      }
    }
    int i;
    if (rpw.isWeishiInstalled(getActivity()))
    {
      i = 2;
      label154:
      rar.a("weishi_share", "tag_clk", 0, i, new String[] { "4", ((StoryVideoItem)localObject).mOwnerUid, "weishi", ((StoryVideoItem)localObject).mVid });
      if (!rpw.isWeishiInstalled(getActivity())) {
        break label235;
      }
    }
    label235:
    for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
    {
      anot.a(null, "dc00898", "", "", "weishi_share_videoplay", (String)localObject, 0, 0, "", "", "", "");
      break;
      i = 1;
      break label154;
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qoe, pxs.b>
  {
    public a(@NonNull qoe paramqoe)
    {
      super();
    }
    
    public void a(@NonNull qoe paramqoe, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.b(this.TAG, "receive user info event. %s.", paramb.toString());
        paramqoe.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoe
 * JD-Core Version:    0.7.0.1
 */