import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.a;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;

public class pik
  extends pii
{
  protected View.OnClickListener cH;
  protected SquareImageView g;
  protected View.OnClickListener mCoverClickListener;
  protected ImageView mu;
  protected View nW;
  private ViewStub x;
  
  public pik(int paramInt)
  {
    super(paramInt);
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    ImageView localImageView;
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if ((this.nW == null) && (this.x != null)) {
        this.nW = this.x.inflate();
      }
      if (this.nW != null)
      {
        this.g = ((SquareImageView)this.nW.findViewById(2131369745));
        this.mu = ((ImageView)this.nW.findViewById(2131369749));
        this.nW.setVisibility(0);
        this.g.setRoundRect(20);
        ous.b(paramStNotice.feed.cover.picUrl.get(), this.g);
        localImageView = this.mu;
        if (!ovd.b(paramStNotice.feed)) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      this.nW.setOnClickListener(t());
      return;
    }
  }
  
  private QCircleInitBean c()
  {
    try
    {
      if (this.a.feed.get() != null)
      {
        Object localObject = new QCircleInitBean.a();
        pdt.b(this.a.feed, 3);
        ((QCircleInitBean.a)localObject).a(this.a.feed);
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
        localExtraTypeInfo.sourceType = 1002;
        ((QCircleInitBean.a)localObject).a(localExtraTypeInfo);
        a((QCircleInitBean.a)localObject);
        localObject = ((QCircleInitBean.a)localObject).a();
        ((QCircleInitBean)localObject).isSingleFeed = true;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleDefaultMessagePresenter", 1, "jumpDetailPageError:" + localException.getMessage());
      localException.printStackTrace();
    }
    return null;
  }
  
  private View.OnClickListener t()
  {
    if (this.mCoverClickListener == null) {
      this.mCoverClickListener = new pil(this);
    }
    return this.mCoverClickListener;
  }
  
  protected void a(QCircleInitBean.a parama) {}
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    b(paramStNotice);
  }
  
  public void h(Context paramContext, View paramView)
  {
    this.x = ((ViewStub)paramView.findViewById(2131374603));
  }
  
  public void kJ()
  {
    if (u() != null)
    {
      if (this.mContainer != null) {
        this.mContainer.setOnClickListener(u());
      }
      if (this.wT != null) {
        this.wT.setOnClickListener(u());
      }
    }
  }
  
  protected View.OnClickListener u()
  {
    if (this.cH == null) {
      this.cH = t();
    }
    return this.cH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pik
 * JD-Core Version:    0.7.0.1
 */