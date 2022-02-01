import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class xyg
  extends zgz
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public xyg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void P_()
  {
    zgz localzgz1 = a().a("DetailCommentSegment");
    zgz localzgz2 = a().a("DetailLikeListSegment");
    xyf localxyf = (xyf)a().a("DetailDoubleTabSegment");
    if ((localxyf != null) && (localxyf.a() > 0) && (localzgz1 != null) && (localzgz1.a() == 0) && (localzgz2 != null) && (localzgz2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localxyf.b();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (xyr)a().a("GeneralFeedProfileSegment");
    xyt localxyt = (xyt)a().a("ShareGroupFeedProfileSegment");
    xya localxya = (xya)a().a("BannerProfileSegment");
    xyi localxyi = (xyi)a().a("DetailInteractSegment");
    xyf localxyf = (xyf)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localxyt.b() + localxya.b() + localxyi.b() + localxyf.c()) - k;
    if (paramInt > UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramyhc.a().getLayoutParams().height = paramInt;
      ykq.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramyhc.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramyhc.a(2131378086);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(anvx.a(2131702619));
    }
    for (;;)
    {
      return paramyhc.a();
      paramyhc.a().getLayoutParams().height = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(anvx.a(2131702620));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561647, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyg
 * JD-Core Version:    0.7.0.1
 */