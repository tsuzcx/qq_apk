import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class ykt
  extends zsv
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public ykt(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    zsv localzsv = a().a("MemoriesVideoListSegment");
    if ((localzsv != null) && (localzsv.a() == 0))
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
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramInt = zps.d(this.jdField_a_of_type_AndroidContentContext);
    int i = zps.e(this.jdField_a_of_type_AndroidContentContext);
    int j = zps.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramyqw.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramyqw.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561778, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykt
 * JD-Core Version:    0.7.0.1
 */