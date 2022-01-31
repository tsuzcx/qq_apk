import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class xeq
  extends xej
{
  protected EditVideoParams a;
  public String c;
  
  public xeq(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public xeq(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public Class<? extends xek> a()
  {
    return xes.class;
  }
  
  @NonNull
  public xek a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xes(this, paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xeq
 * JD-Core Version:    0.7.0.1
 */