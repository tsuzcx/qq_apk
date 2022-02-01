import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class yia
  extends zsv
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public yia(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    zsv localzsv1 = a().a("DetailCommentSegment");
    zsv localzsv2 = a().a("DetailLikeListSegment");
    yhz localyhz = (yhz)a().a("DetailDoubleTabSegment");
    if ((localyhz != null) && (localyhz.a() > 0) && (localzsv1 != null) && (localzsv1.a() == 0) && (localzsv2 != null) && (localzsv2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localyhz.b();
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
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramInt = zps.d(this.jdField_a_of_type_AndroidContentContext);
    int i = zps.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = zps.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (yil)a().a("GeneralFeedProfileSegment");
    yin localyin = (yin)a().a("ShareGroupFeedProfileSegment");
    yhu localyhu = (yhu)a().a("BannerProfileSegment");
    yic localyic = (yic)a().a("DetailInteractSegment");
    yhz localyhz = (yhz)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localyin.b() + localyhu.b() + localyic.b() + localyhz.c()) - k;
    if (paramInt > zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramyqw.a().getLayoutParams().height = paramInt;
      yuk.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramyqw.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramyqw.a(2131378034);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(anzj.a(2131702033));
    }
    for (;;)
    {
      return paramyqw.a();
      paramyqw.a().getLayoutParams().height = zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(anzj.a(2131702034));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561699, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yia
 * JD-Core Version:    0.7.0.1
 */