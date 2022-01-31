import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vqe
  extends vpu
{
  public final int c;
  
  public vqe(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends vpv> a()
  {
    return vqf.class;
  }
  
  @NonNull
  public vpv a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqf(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqe
 * JD-Core Version:    0.7.0.1
 */