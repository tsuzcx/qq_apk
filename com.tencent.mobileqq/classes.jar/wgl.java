import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wgl
  extends xrg
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public wgl(Context paramContext)
  {
    super(paramContext);
  }
  
  public void Z_()
  {
    xrg localxrg1 = a().a("DetailCommentSegment");
    xrg localxrg2 = a().a("DetailLikeListSegment");
    wgk localwgk = (wgk)a().a("DetailDoubleTabSegment");
    if ((localwgk != null) && (localwgk.a() > 0) && (localxrg1 != null) && (localxrg1.a() == 0) && (localxrg2 != null) && (localxrg2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localwgk.b();
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
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramInt = xod.d(this.jdField_a_of_type_AndroidContentContext);
    int i = xod.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = xod.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (wgw)a().a("GeneralFeedProfileSegment");
    wgy localwgy = (wgy)a().a("ShareGroupFeedProfileSegment");
    wgf localwgf = (wgf)a().a("BannerProfileSegment");
    wgn localwgn = (wgn)a().a("DetailInteractSegment");
    wgk localwgk = (wgk)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localwgy.b() + localwgf.b() + localwgn.b() + localwgk.c()) - k;
    if (paramInt > xod.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramwph.a().getLayoutParams().height = paramInt;
      wsv.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramwph.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramwph.a(2131377023);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(alpo.a(2131703517));
    }
    for (;;)
    {
      return paramwph.a();
      paramwph.a().getLayoutParams().height = xod.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(alpo.a(2131703518));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561404, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgl
 * JD-Core Version:    0.7.0.1
 */