import android.content.Context;
import android.widget.BaseAdapter;

public abstract class xia<PACKAGE extends xhr>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected xht a;
  
  public xia(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Xhr = paramPACKAGE;
  }
  
  public void a(xht paramxht)
  {
    this.jdField_a_of_type_Xht = paramxht;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xhr == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Xhr.b();
    int j = this.jdField_a_of_type_Xhr.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xia
 * JD-Core Version:    0.7.0.1
 */