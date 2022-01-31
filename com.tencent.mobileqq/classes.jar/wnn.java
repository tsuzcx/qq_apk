import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wnn
  extends xvp
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public wnn(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    xvp localxvp = a().a("MemoriesVideoListSegment");
    if ((localxvp != null) && (localxvp.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void W_()
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
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramInt = xsm.d(this.jdField_a_of_type_AndroidContentContext);
    int i = xsm.e(this.jdField_a_of_type_AndroidContentContext);
    int j = xsm.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = xsm.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramwtq.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramwtq.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561502, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */