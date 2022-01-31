import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vdc
  extends vcy
{
  @NonNull
  public final srb a;
  @NonNull
  public final String c;
  
  public vdc(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull srb paramsrb)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramsrb;
  }
  
  @NonNull
  public Class<? extends vcz> a()
  {
    return vde.class;
  }
  
  @NonNull
  public vcz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vde(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */