import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wku
  extends xvp
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public wku(Context paramContext)
  {
    super(paramContext);
  }
  
  public void W_()
  {
    xvp localxvp1 = a().a("DetailCommentSegment");
    xvp localxvp2 = a().a("DetailLikeListSegment");
    wkt localwkt = (wkt)a().a("DetailDoubleTabSegment");
    if ((localwkt != null) && (localwkt.a() > 0) && (localxvp1 != null) && (localxvp1.a() == 0) && (localxvp2 != null) && (localxvp2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localwkt.b();
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
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramInt = xsm.d(this.jdField_a_of_type_AndroidContentContext);
    int i = xsm.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = xsm.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (wlf)a().a("GeneralFeedProfileSegment");
    wlh localwlh = (wlh)a().a("ShareGroupFeedProfileSegment");
    wko localwko = (wko)a().a("BannerProfileSegment");
    wkw localwkw = (wkw)a().a("DetailInteractSegment");
    wkt localwkt = (wkt)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localwlh.b() + localwko.b() + localwkw.b() + localwkt.c()) - k;
    if (paramInt > xsm.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramwtq.a().getLayoutParams().height = paramInt;
      wxe.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramwtq.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramwtq.a(2131377077);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(alud.a(2131703529));
    }
    for (;;)
    {
      return paramwtq.a();
      paramwtq.a().getLayoutParams().height = xsm.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(alud.a(2131703530));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561422, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wku
 * JD-Core Version:    0.7.0.1
 */