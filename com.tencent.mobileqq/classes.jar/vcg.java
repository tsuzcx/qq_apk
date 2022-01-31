import android.content.Context;
import android.widget.BaseAdapter;

public abstract class vcg<PACKAGE extends vbx>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected vbz a;
  
  public vcg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Vbx = paramPACKAGE;
  }
  
  public void a(vbz paramvbz)
  {
    this.jdField_a_of_type_Vbz = paramvbz;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Vbx == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Vbx.b();
    int j = this.jdField_a_of_type_Vbx.a();
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
 * Qualified Name:     vcg
 * JD-Core Version:    0.7.0.1
 */