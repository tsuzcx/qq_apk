import android.content.Context;
import android.widget.BaseAdapter;

public abstract class ygh<PACKAGE extends yfy>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected yga a;
  
  public ygh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Yfy = paramPACKAGE;
  }
  
  public void a(yga paramyga)
  {
    this.jdField_a_of_type_Yga = paramyga;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Yfy == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Yfy.b();
    int j = this.jdField_a_of_type_Yfy.a();
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
 * Qualified Name:     ygh
 * JD-Core Version:    0.7.0.1
 */