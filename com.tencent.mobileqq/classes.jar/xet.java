import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xet
  extends xej
{
  public final int c;
  
  public xet(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends xek> a()
  {
    return xeu.class;
  }
  
  @NonNull
  public xek a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xeu(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xet
 * JD-Core Version:    0.7.0.1
 */