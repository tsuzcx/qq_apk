import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class yhi
  extends ygy
{
  public final int c;
  
  public yhi(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends ygz> a()
  {
    return yhj.class;
  }
  
  @NonNull
  public ygz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new yhj(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhi
 * JD-Core Version:    0.7.0.1
 */