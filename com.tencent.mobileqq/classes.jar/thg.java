import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class thg
  extends tbd<tff, tbg<tff>>
{
  private int a;
  
  public thg(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    tff localtff = (tff)a(paramInt);
    if (localtff != null) {
      return localtff.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((tff)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(tbg<tff> paramtbg)
  {
    super.onViewDetachedFromWindow(paramtbg);
    paramtbg.a();
  }
  
  public tbg b(ViewGroup paramViewGroup, int paramInt)
  {
    return tit.a(paramViewGroup, paramInt);
  }
  
  public void b(tbg paramtbg, int paramInt)
  {
    paramtbg.a((tff)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thg
 * JD-Core Version:    0.7.0.1
 */