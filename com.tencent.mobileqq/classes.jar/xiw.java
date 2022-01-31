import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xiw
  extends xis
{
  @NonNull
  public final uwv a;
  @NonNull
  public final String c;
  
  public xiw(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull uwv paramuwv)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramuwv;
  }
  
  @NonNull
  public Class<? extends xit> a()
  {
    return xiy.class;
  }
  
  @NonNull
  public xit a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xiy(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xiw
 * JD-Core Version:    0.7.0.1
 */