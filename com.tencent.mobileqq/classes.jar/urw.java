import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class urw
  extends wcr
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public urw(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
  {
    wcr localwcr1 = a().a("DetailCommentSegment");
    wcr localwcr2 = a().a("DetailLikeListSegment");
    urv localurv = (urv)a().a("DetailDoubleTabSegment");
    if ((localurv != null) && (localurv.a() > 0) && (localwcr1 != null) && (localwcr1.a() == 0) && (localwcr2 != null) && (localwcr2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localurv.b();
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
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramInt = vzo.d(this.jdField_a_of_type_AndroidContentContext);
    int i = vzo.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = vzo.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (ush)a().a("GeneralFeedProfileSegment");
    usj localusj = (usj)a().a("ShareGroupFeedProfileSegment");
    urq localurq = (urq)a().a("BannerProfileSegment");
    ury localury = (ury)a().a("DetailInteractSegment");
    urv localurv = (urv)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localusj.b() + localurq.b() + localury.b() + localurv.c()) - k;
    if (paramInt > vzo.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramvas.a().getLayoutParams().height = paramInt;
      veg.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramvas.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramvas.a(2131376521);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(ajyc.a(2131703134));
    }
    for (;;)
    {
      return paramvas.a();
      paramvas.a().getLayoutParams().height = vzo.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(ajyc.a(2131703135));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561215, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urw
 * JD-Core Version:    0.7.0.1
 */