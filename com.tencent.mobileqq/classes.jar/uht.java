import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uht
  extends vpv
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public uht(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    vpv localvpv = a().a("MemoriesVideoListSegment");
    if ((localvpv != null) && (localvpv.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void T_()
  {
    f();
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
    int j = vms.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = vms.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramunw.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramunw.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495704, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uht
 * JD-Core Version:    0.7.0.1
 */