import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uup
  extends wcr
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public uup(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    wcr localwcr = a().a("MemoriesVideoListSegment");
    if ((localwcr != null) && (localwcr.a() == 0))
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
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramInt = vzo.d(this.jdField_a_of_type_AndroidContentContext);
    int i = vzo.e(this.jdField_a_of_type_AndroidContentContext);
    int j = vzo.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = vzo.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramvas.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramvas.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561295, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uup
 * JD-Core Version:    0.7.0.1
 */