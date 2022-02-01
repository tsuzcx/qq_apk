import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class wnz
  extends whx<wly, wia<wly>>
{
  private int a;
  
  public wnz(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    wly localwly = (wly)a(paramInt);
    if (localwly != null) {
      return localwly.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((wly)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(wia<wly> paramwia)
  {
    super.onViewDetachedFromWindow(paramwia);
    paramwia.a();
  }
  
  public wia b(ViewGroup paramViewGroup, int paramInt)
  {
    return wpm.a(paramViewGroup, paramInt);
  }
  
  public void b(wia paramwia, int paramInt)
  {
    paramwia.a((wly)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnz
 * JD-Core Version:    0.7.0.1
 */