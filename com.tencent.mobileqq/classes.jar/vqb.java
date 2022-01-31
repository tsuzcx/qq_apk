import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vqb
  extends vpr
{
  public final int c;
  
  public vqb(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends vps> a()
  {
    return vqc.class;
  }
  
  @NonNull
  public vps a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqc(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqb
 * JD-Core Version:    0.7.0.1
 */