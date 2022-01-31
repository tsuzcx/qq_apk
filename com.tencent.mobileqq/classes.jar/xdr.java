import android.content.Context;
import android.widget.BaseAdapter;

public abstract class xdr<PACKAGE extends xdi>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected xdk a;
  
  public xdr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Xdi = paramPACKAGE;
  }
  
  public void a(xdk paramxdk)
  {
    this.jdField_a_of_type_Xdk = paramxdk;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xdi == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Xdi.b();
    int j = this.jdField_a_of_type_Xdi.a();
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
 * Qualified Name:     xdr
 * JD-Core Version:    0.7.0.1
 */