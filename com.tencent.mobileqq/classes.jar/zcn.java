import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class zcn
  extends zcd
{
  public final int c;
  
  public zcn(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends zce> a()
  {
    return zco.class;
  }
  
  @NonNull
  public zce a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zco(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcn
 * JD-Core Version:    0.7.0.1
 */