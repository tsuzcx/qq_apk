import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class xjl
  extends ysg
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public xjl(Context paramContext)
  {
    super(paramContext);
  }
  
  public void N_()
  {
    ysg localysg1 = a().a("DetailCommentSegment");
    ysg localysg2 = a().a("DetailLikeListSegment");
    xjk localxjk = (xjk)a().a("DetailDoubleTabSegment");
    if ((localxjk != null) && (localxjk.a() > 0) && (localysg1 != null) && (localysg1.a() == 0) && (localysg2 != null) && (localysg2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localxjk.b();
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
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (xjw)a().a("GeneralFeedProfileSegment");
    xjy localxjy = (xjy)a().a("ShareGroupFeedProfileSegment");
    xjf localxjf = (xjf)a().a("BannerProfileSegment");
    xjn localxjn = (xjn)a().a("DetailInteractSegment");
    xjk localxjk = (xjk)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localxjy.b() + localxjf.b() + localxjn.b() + localxjk.c()) - k;
    if (paramInt > UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramxsh.a().getLayoutParams().height = paramInt;
      xvv.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramxsh.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramxsh.a(2131377804);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(amtj.a(2131702268));
    }
    for (;;)
    {
      return paramxsh.a();
      paramxsh.a().getLayoutParams().height = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(amtj.a(2131702269));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561579, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjl
 * JD-Core Version:    0.7.0.1
 */