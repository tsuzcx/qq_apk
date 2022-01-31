import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class urt
  extends wco
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public urt(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
  {
    wco localwco1 = a().a("DetailCommentSegment");
    wco localwco2 = a().a("DetailLikeListSegment");
    urs localurs = (urs)a().a("DetailDoubleTabSegment");
    if ((localurs != null) && (localurs.a() > 0) && (localwco1 != null) && (localwco1.a() == 0) && (localwco2 != null) && (localwco2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localurs.b();
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
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramInt = vzl.d(this.jdField_a_of_type_AndroidContentContext);
    int i = vzl.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = vzl.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (use)a().a("GeneralFeedProfileSegment");
    usg localusg = (usg)a().a("ShareGroupFeedProfileSegment");
    urn localurn = (urn)a().a("BannerProfileSegment");
    urv localurv = (urv)a().a("DetailInteractSegment");
    urs localurs = (urs)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localusg.b() + localurn.b() + localurv.b() + localurs.c()) - k;
    if (paramInt > vzl.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramvap.a().getLayoutParams().height = paramInt;
      ved.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramvap.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramvap.a(2131376523);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(ajya.a(2131703145));
    }
    for (;;)
    {
      return paramvap.a();
      paramvap.a().getLayoutParams().height = vzl.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(ajya.a(2131703146));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561214, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urt
 * JD-Core Version:    0.7.0.1
 */