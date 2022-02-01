import android.content.Context;
import android.widget.BaseAdapter;

public abstract class zfg<PACKAGE extends zex>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected zez a;
  
  public zfg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Zex = paramPACKAGE;
  }
  
  public void a(zez paramzez)
  {
    this.jdField_a_of_type_Zez = paramzez;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zex == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Zex.b();
    int j = this.jdField_a_of_type_Zex.a();
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
 * Qualified Name:     zfg
 * JD-Core Version:    0.7.0.1
 */