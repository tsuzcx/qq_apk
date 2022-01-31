import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wje
  extends xrg
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public wje(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    xrg localxrg = a().a("MemoriesVideoListSegment");
    if ((localxrg != null) && (localxrg.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void Z_()
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
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramInt = xod.d(this.jdField_a_of_type_AndroidContentContext);
    int i = xod.e(this.jdField_a_of_type_AndroidContentContext);
    int j = xod.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = xod.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramwph.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramwph.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561484, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wje
 * JD-Core Version:    0.7.0.1
 */