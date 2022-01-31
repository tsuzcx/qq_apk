import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class ufa
  extends vpv
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public ufa(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    vpv localvpv1 = a().a("DetailCommentSegment");
    vpv localvpv2 = a().a("DetailLikeListSegment");
    uez localuez = (uez)a().a("DetailDoubleTabSegment");
    if ((localuez != null) && (localuez.a() > 0) && (localvpv1 != null) && (localvpv1.a() == 0) && (localvpv2 != null) && (localvpv2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localuez.b();
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
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramInt = vms.d(this.jdField_a_of_type_AndroidContentContext);
    int i = vms.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = vms.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (ufl)a().a("GeneralFeedProfileSegment");
    ufn localufn = (ufn)a().a("ShareGroupFeedProfileSegment");
    ueu localueu = (ueu)a().a("BannerProfileSegment");
    ufc localufc = (ufc)a().a("DetailInteractSegment");
    uez localuez = (uez)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localufn.b() + localueu.b() + localufc.b() + localuez.c()) - k;
    if (paramInt > vms.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramunw.a().getLayoutParams().height = paramInt;
      urk.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramunw.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramunw.a(2131310725);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(ajjy.a(2131637349));
    }
    for (;;)
    {
      return paramunw.a();
      paramunw.a().getLayoutParams().height = vms.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(ajjy.a(2131637350));
    }
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495624, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufa
 * JD-Core Version:    0.7.0.1
 */