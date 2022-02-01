import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class yef
  extends zpa
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public yef(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    zpa localzpa1 = a().a("DetailCommentSegment");
    zpa localzpa2 = a().a("DetailLikeListSegment");
    yee localyee = (yee)a().a("DetailDoubleTabSegment");
    if ((localyee != null) && (localyee.a() > 0) && (localzpa1 != null) && (localzpa1.a() == 0) && (localzpa2 != null) && (localzpa2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localyee.b();
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
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramInt = zlx.d(this.jdField_a_of_type_AndroidContentContext);
    int i = zlx.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = zlx.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (yeq)a().a("GeneralFeedProfileSegment");
    yes localyes = (yes)a().a("ShareGroupFeedProfileSegment");
    ydz localydz = (ydz)a().a("BannerProfileSegment");
    yeh localyeh = (yeh)a().a("DetailInteractSegment");
    yee localyee = (yee)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localyes.b() + localydz.b() + localyeh.b() + localyee.c()) - k;
    if (paramInt > zlx.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramynb.a().getLayoutParams().height = paramInt;
      yqp.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramynb.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramynb.a(2131377881);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(anni.a(2131701926));
    }
    for (;;)
    {
      return paramynb.a();
      paramynb.a().getLayoutParams().height = zlx.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(anni.a(2131701927));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561658, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yef
 * JD-Core Version:    0.7.0.1
 */