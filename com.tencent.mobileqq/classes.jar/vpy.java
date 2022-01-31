import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vpy
  extends vpu
{
  @NonNull
  public final tdx a;
  @NonNull
  public final String c;
  
  public vpy(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull tdx paramtdx)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramtdx;
  }
  
  @NonNull
  public Class<? extends vpv> a()
  {
    return vqa.class;
  }
  
  @NonNull
  public vpv a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqa(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpy
 * JD-Core Version:    0.7.0.1
 */