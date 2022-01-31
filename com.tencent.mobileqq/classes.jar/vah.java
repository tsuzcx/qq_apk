import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class vah
  extends uue<uyg, uuh<uyg>>
{
  private int a;
  
  public vah(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    uyg localuyg = (uyg)a(paramInt);
    if (localuyg != null) {
      return localuyg.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((uyg)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(uuh<uyg> paramuuh)
  {
    super.onViewDetachedFromWindow(paramuuh);
    paramuuh.a();
  }
  
  public uuh b(ViewGroup paramViewGroup, int paramInt)
  {
    return vbu.a(paramViewGroup, paramInt);
  }
  
  public void b(uuh paramuuh, int paramInt)
  {
    paramuuh.a((uyg)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */