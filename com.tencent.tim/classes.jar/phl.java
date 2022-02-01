import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public abstract class phl<T>
{
  protected ovv a;
  protected ReportExtraTypeInfo b = new ReportExtraTypeInfo();
  protected View mContainer;
  public Object mData;
  protected ExtraTypeInfo mExtraTypeInfo;
  protected int mPos;
  
  public boolean HW()
  {
    return false;
  }
  
  protected boolean HY()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isFakeFeed())
    {
      bool1 = bool2;
      if (this.mContainer != null)
      {
        QQToast.a(this.mContainer.getContext(), 0, 2131700160, 0).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, String paramString, QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.nick.get())) && (!TextUtils.isEmpty(paramString)) && (paramQCircleAsyncTextView != null))
    {
      paramQCircleAsyncTextView.setText("");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStUser.nick.get()).append("：").append(paramString);
      paramQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStUser.nick.get().length(), new phm(this, paramStUser));
      paramQCircleAsyncTextView.bxX();
      paramQCircleAsyncTextView.setText(localSpannableStringBuilder);
      paramQCircleAsyncTextView.setVisibility(0);
    }
  }
  
  public void a(ovv paramovv)
  {
    this.a = paramovv;
  }
  
  public FeedCloudMeta.StFeed b()
  {
    if ((this.mData instanceof FeedCloudMeta.StFeed)) {
      return (FeedCloudMeta.StFeed)this.mData;
    }
    return null;
  }
  
  public int getPos()
  {
    return this.mPos;
  }
  
  public boolean isFakeFeed()
  {
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      String str = ((FeedCloudMeta.StFeed)this.mData).id.get();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("qcircle_fakeid_"))) {
        return true;
      }
    }
    return false;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void vC(int paramInt)
  {
    if (pcr.a().ez(57))
    {
      pcp.b(paramInt, 2, this.b);
      return;
    }
    pcl.a(paramInt, 2, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phl
 * JD-Core Version:    0.7.0.1
 */