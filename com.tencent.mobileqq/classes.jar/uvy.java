import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class uvy
  extends upv<utx, upy<utx>>
{
  private int a;
  
  public uvy(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    utx localutx = (utx)a(paramInt);
    if (localutx != null) {
      return localutx.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((utx)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(upy<utx> paramupy)
  {
    super.onViewDetachedFromWindow(paramupy);
    paramupy.a();
  }
  
  public upy b(ViewGroup paramViewGroup, int paramInt)
  {
    return uxl.a(paramViewGroup, paramInt);
  }
  
  public void b(upy paramupy, int paramInt)
  {
    paramupy.a((utx)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvy
 * JD-Core Version:    0.7.0.1
 */