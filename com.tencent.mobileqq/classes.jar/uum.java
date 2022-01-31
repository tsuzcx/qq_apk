import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uum
  extends wco
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public uum(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    wco localwco = a().a("MemoriesVideoListSegment");
    if ((localwco != null) && (localwco.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void R_()
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
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramInt = vzl.d(this.jdField_a_of_type_AndroidContentContext);
    int i = vzl.e(this.jdField_a_of_type_AndroidContentContext);
    int j = vzl.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = vzl.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramvap.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramvap.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561294, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uum
 * JD-Core Version:    0.7.0.1
 */