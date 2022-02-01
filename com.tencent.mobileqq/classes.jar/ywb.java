import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class ywb
  extends yvr
{
  public final int c;
  
  public ywb(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends yvs> a()
  {
    return ywc.class;
  }
  
  @NonNull
  public yvs a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new ywc(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywb
 * JD-Core Version:    0.7.0.1
 */