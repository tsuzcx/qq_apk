import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xjc
  extends xis
{
  public final int c;
  
  public xjc(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends xit> a()
  {
    return xjd.class;
  }
  
  @NonNull
  public xit a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xjd(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */