import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class yhc
  extends ygy
{
  @NonNull
  public final vvs a;
  @NonNull
  public final String c;
  
  public yhc(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull vvs paramvvs)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramvvs;
  }
  
  @NonNull
  public Class<? extends ygz> a()
  {
    return yhe.class;
  }
  
  @NonNull
  public ygz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new yhe(paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhc
 * JD-Core Version:    0.7.0.1
 */