import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vpv
  extends vpr
{
  @NonNull
  public final tdu a;
  @NonNull
  public final String c;
  
  public vpv(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull tdu paramtdu)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramtdu;
  }
  
  @NonNull
  public Class<? extends vps> a()
  {
    return vpx.class;
  }
  
  @NonNull
  public vps a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vpx(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */