import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class wtt
  extends wnq<wrs, wnt<wrs>>
{
  private int a;
  
  public wtt(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    wrs localwrs = (wrs)a(paramInt);
    if (localwrs != null) {
      return localwrs.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((wrs)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(wnt<wrs> paramwnt)
  {
    super.onViewDetachedFromWindow(paramwnt);
    paramwnt.a();
  }
  
  public wnt b(ViewGroup paramViewGroup, int paramInt)
  {
    return wvg.a(paramViewGroup, paramInt);
  }
  
  public void b(wnt paramwnt, int paramInt)
  {
    paramwnt.a((wrs)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtt
 * JD-Core Version:    0.7.0.1
 */