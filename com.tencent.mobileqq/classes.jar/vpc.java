import android.content.Context;
import android.widget.BaseAdapter;

public abstract class vpc<PACKAGE extends vot>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected vov a;
  
  public vpc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Vot = paramPACKAGE;
  }
  
  public void a(vov paramvov)
  {
    this.jdField_a_of_type_Vov = paramvov;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Vot == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Vot.b();
    int j = this.jdField_a_of_type_Vot.a();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */