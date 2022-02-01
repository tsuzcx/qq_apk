import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.qqcircle.requests.QCircleRecomForwardRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class pfy
  extends peo
  implements peo.a
{
  private ImageButton X;
  private ImageButton Y;
  private FeedCloudMeta.StFeed mFeed;
  private TextView wr;
  
  public pfy(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void biG()
  {
    if (this.mFeed == null)
    {
      ram.i("QCircleBaseInputPopupWindow", "QCircleForwardRequest feed == null, return");
      return;
    }
    Object localObject = new FeedCloudMeta.StRecomForward();
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    ((FeedCloudMeta.StRecomForward)localObject).poster.set(localStUser);
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    if (!TextUtils.isEmpty(getText()))
    {
      ((FeedCloudMeta.StRecomForward)localObject).title.set(getText());
      if ((this.Y != null) && (this.Y.isSelected()))
      {
        localStComment.id.set("fakeId_" + System.currentTimeMillis());
        localStComment.content.set(getText());
        localStComment.createTime.set((int)(System.currentTimeMillis() / 1000L));
        localStComment.postUser.set(localStUser);
      }
    }
    this.mFeed.recomForward.set((MessageMicro)localObject);
    localObject = new QCircleRecomForwardRequest(this.mFeed, localStComment);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new pfz(this));
    setText("");
    qG(null);
    dismiss();
  }
  
  protected void dD(View paramView)
  {
    this.X = ((ImageButton)paramView.findViewById(2131363933));
    this.wr = ((TextView)paramView.findViewById(2131380955));
    this.Y = ((ImageButton)paramView.findViewById(2131364015));
    this.X.setOnClickListener(this);
    this.wr.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.Y.setSelected(true);
    a(this);
  }
  
  protected int getLayoutId()
  {
    return 2131560946;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      continue;
      if (this.Y.isSelected()) {
        this.Y.setSelected(false);
      } else {
        this.Y.setSelected(true);
      }
    }
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfy
 * JD-Core Version:    0.7.0.1
 */