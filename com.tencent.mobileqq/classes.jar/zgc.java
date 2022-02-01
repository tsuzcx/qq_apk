import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class zgc
  extends zfy
{
  @NonNull
  public final wuc a;
  @NonNull
  public final String c;
  
  public zgc(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull wuc paramwuc)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramwuc;
  }
  
  @NonNull
  public Class<? extends zfz> a()
  {
    return zge.class;
  }
  
  @NonNull
  public zfz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zge(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgc
 * JD-Core Version:    0.7.0.1
 */