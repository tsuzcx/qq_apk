import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class qsu
  extends rsd
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int bmt;
  
  public qsu(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramInt = rpq.getWindowScreenHeight(this.context);
    int i = rpq.getStatusBarHeight(this.context);
    int j = ((FragmentActivity)this.context).getTitleBarHeight();
    int k = rpq.dip2px(this.context, 56.0F);
    paramViewGroup = (qtf)a().a("GeneralFeedProfileSegment");
    qth localqth = (qth)a().a("ShareGroupFeedProfileSegment");
    qsr localqsr = (qsr)a().a("BannerProfileSegment");
    qsw localqsw = (qsw)a().a("DetailInteractSegment");
    qst localqst = (qst)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.sP() + localqth.sP() + localqsr.sP() + localqsw.sP() + localqst.sP()) - k;
    if (paramInt > rpq.dip2px(this.context, 50.0F))
    {
      paramqyd.getItemView().getLayoutParams().height = paramInt;
      ram.d("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramqyd.getItemView().getLayoutParams().height));
      paramViewGroup = (TextView)paramqyd.get(2131378790);
      if (this.bmt != 1) {
        break label247;
      }
      paramViewGroup.setText(acfp.m(2131704932));
    }
    for (;;)
    {
      return paramqyd.getItemView();
      paramqyd.getItemView().getLayoutParams().height = rpq.dip2px(this.context, 50.0F);
      break;
      label247:
      paramViewGroup.setText(acfp.m(2131704933));
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561815, paramViewGroup, false));
  }
  
  public void bqo()
  {
    rsd localrsd1 = a().a("DetailCommentSegment");
    rsd localrsd2 = a().a("DetailLikeListSegment");
    qst localqst = (qst)a().a("DetailDoubleTabSegment");
    if ((localqst != null) && (localqst.getCount() > 0) && (localrsd1 != null) && (localrsd1.getCount() == 0) && (localrsd2 != null) && (localrsd2.getCount() == 0))
    {
      this.isDisplay = true;
      this.bmt = localqst.sO();
      return;
    }
    this.isDisplay = false;
  }
  
  public int getCount()
  {
    if (this.isDisplay) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "DetailEmptyInteractionSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsu
 * JD-Core Version:    0.7.0.1
 */