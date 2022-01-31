import android.content.Context;
import android.widget.BaseAdapter;

public abstract class voz<PACKAGE extends voq>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected vos a;
  
  public voz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Voq = paramPACKAGE;
  }
  
  public void a(vos paramvos)
  {
    this.jdField_a_of_type_Vos = paramvos;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Voq == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_Voq.b();
    int j = this.jdField_a_of_type_Voq.a();
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
 * Qualified Name:     voz
 * JD-Core Version:    0.7.0.1
 */