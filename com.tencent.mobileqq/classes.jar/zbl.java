import android.content.Context;
import android.widget.BaseAdapter;

public abstract class zbl<PACKAGE extends zbc>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected zbe a;
  
  public zbl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Zbc = paramPACKAGE;
  }
  
  public void a(zbe paramzbe)
  {
    this.jdField_a_of_type_Zbe = paramzbe;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zbc == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Zbc.b();
    int j = this.jdField_a_of_type_Zbc.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbl
 * JD-Core Version:    0.7.0.1
 */