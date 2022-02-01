import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class vze
  extends vtc<vxd, vtf<vxd>>
{
  private int a;
  
  public vze(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    vxd localvxd = (vxd)a(paramInt);
    if (localvxd != null) {
      return localvxd.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((vxd)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(vtf<vxd> paramvtf)
  {
    super.onViewDetachedFromWindow(paramvtf);
    paramvtf.a();
  }
  
  public vtf b(ViewGroup paramViewGroup, int paramInt)
  {
    return war.a(paramViewGroup, paramInt);
  }
  
  public void b(vtf paramvtf, int paramInt)
  {
    paramvtf.a((vxd)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vze
 * JD-Core Version:    0.7.0.1
 */