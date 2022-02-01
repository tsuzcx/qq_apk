import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class qny
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ProgressBar F;
  private LinearLayout eT;
  private boolean mIsRetrying;
  private ImageView mN;
  private TextView xq;
  
  public qny(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new qny.a(this), "");
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    n(paramStoryVideoItem);
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public void dJ(View paramView)
  {
    this.eT = ((LinearLayout)paramView.findViewById(2131381842));
    this.mN = ((ImageView)paramView.findViewById(2131381844));
    this.F = ((ProgressBar)paramView.findViewById(2131381843));
    this.xq = ((TextView)paramView.findViewById(2131381845));
    this.eT.setOnClickListener(this);
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy() {}
  
  public int getLayoutId()
  {
    return 2131562027;
  }
  
  public String getTag()
  {
    return "UploadStatusVideoInfoWidget";
  }
  
  public void n(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      show();
      this.F.setVisibility(8);
      this.mN.setVisibility(0);
      switch (paramStoryVideoItem.mUpLoadFailedError)
      {
      default: 
        this.xq.setText(2131701956);
      }
      while (this.mIsRetrying)
      {
        this.mIsRetrying = false;
        rar.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
        this.xq.setText(2131701958);
      }
      rar.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      show();
      this.F.setVisibility(0);
      this.mN.setVisibility(8);
      int i = poe.a().bb(paramStoryVideoItem.mVid);
      if (i >= 0) {
        this.xq.setText(acfp.m(2131716269) + i + "%");
      }
      for (;;)
      {
        poe.a().a(paramStoryVideoItem.mVid, new qnz(this));
        return;
        this.xq.setText(acfp.m(2131716271));
      }
    }
    hide();
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.a != null)
    {
      localStoryVideoItem = this.a.b();
      if (localStoryVideoItem != null) {
        break label41;
      }
      ram.w(this.TAG, "video item not found ,click error..");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localStoryVideoItem = null;
      break;
      label41:
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131381842: 
        switch (localStoryVideoItem.mUploadStatus)
        {
        }
        break;
      }
    }
    if (!qem.b(localStoryVideoItem, getActivity())) {
      rar.a("play_video", "retrypub_fail", 0, 0, new String[0]);
    }
    for (;;)
    {
      rar.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from) });
      ram.d(this.TAG, "on retry click !");
      break;
      this.mIsRetrying = true;
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qny, pnx.d>
  {
    public a(@NonNull qny paramqny)
    {
      super();
    }
    
    public void a(@NonNull qny paramqny, @NonNull pnx.d paramd)
    {
      if ((paramqny.a == null) || (paramd.b == null) || (!TextUtils.equals(paramqny.a.vid, paramd.b.mVid))) {}
      do
      {
        return;
        paramqny.updateUI();
        paramqny = (qjs)paramqny.a(qjs.class);
      } while (paramqny == null);
      paramqny.bon();
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qny
 * JD-Core Version:    0.7.0.1
 */