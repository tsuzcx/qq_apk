import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class wxo
  extends wrl<wvn, wro<wvn>>
{
  private int a;
  
  public wxo(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    wvn localwvn = (wvn)a(paramInt);
    if (localwvn != null) {
      return localwvn.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((wvn)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(wro<wvn> paramwro)
  {
    super.onViewDetachedFromWindow(paramwro);
    paramwro.a();
  }
  
  public wro b(ViewGroup paramViewGroup, int paramInt)
  {
    return wzb.a(paramViewGroup, paramInt);
  }
  
  public void b(wro paramwro, int paramInt)
  {
    paramwro.a((wvn)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxo
 * JD-Core Version:    0.7.0.1
 */