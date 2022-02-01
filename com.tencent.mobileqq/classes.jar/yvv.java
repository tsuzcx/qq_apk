import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class yvv
  extends yvr
{
  @NonNull
  public final wkn a;
  @NonNull
  public final String c;
  
  public yvv(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull wkn paramwkn)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramwkn;
  }
  
  @NonNull
  public Class<? extends yvs> a()
  {
    return yvx.class;
  }
  
  @NonNull
  public yvs a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new yvx(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvv
 * JD-Core Version:    0.7.0.1
 */