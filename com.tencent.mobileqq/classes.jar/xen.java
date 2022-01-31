import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xen
  extends xej
{
  @NonNull
  public final usm a;
  @NonNull
  public final String c;
  
  public xen(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull usm paramusm)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramusm;
  }
  
  @NonNull
  public Class<? extends xek> a()
  {
    return xep.class;
  }
  
  @NonNull
  public xek a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xep(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xen
 * JD-Core Version:    0.7.0.1
 */