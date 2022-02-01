import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class zch
  extends zcd
{
  @NonNull
  public final wqh a;
  @NonNull
  public final String c;
  
  public zch(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull wqh paramwqh)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramwqh;
  }
  
  @NonNull
  public Class<? extends zce> a()
  {
    return zcj.class;
  }
  
  @NonNull
  public zce a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zcj(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zch
 * JD-Core Version:    0.7.0.1
 */