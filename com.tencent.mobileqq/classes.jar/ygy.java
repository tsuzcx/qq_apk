import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class ygy
  extends zpa
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public ygy(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    zpa localzpa = a().a("MemoriesVideoListSegment");
    if ((localzpa != null) && (localzpa.a() == 0))
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
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramInt = zlx.d(this.jdField_a_of_type_AndroidContentContext);
    int i = zlx.e(this.jdField_a_of_type_AndroidContentContext);
    int j = zlx.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = zlx.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramynb.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramynb.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561737, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygy
 * JD-Core Version:    0.7.0.1
 */