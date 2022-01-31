import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vdi
  extends vcy
{
  public final int c;
  
  public vdi(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends vcz> a()
  {
    return vdj.class;
  }
  
  @NonNull
  public vcz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vdj(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */