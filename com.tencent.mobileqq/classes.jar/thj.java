import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class thj
  extends tbg<tfi, tbj<tfi>>
{
  private int a;
  
  public thj(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    tfi localtfi = (tfi)a(paramInt);
    if (localtfi != null) {
      return localtfi.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((tfi)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(tbj<tfi> paramtbj)
  {
    super.onViewDetachedFromWindow(paramtbj);
    paramtbj.a();
  }
  
  public tbj b(ViewGroup paramViewGroup, int paramInt)
  {
    return tiw.a(paramViewGroup, paramInt);
  }
  
  public void b(tbj paramtbj, int paramInt)
  {
    paramtbj.a((tfi)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thj
 * JD-Core Version:    0.7.0.1
 */