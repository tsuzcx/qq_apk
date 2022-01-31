import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class vqb
  extends vpu
{
  protected EditVideoParams a;
  public String c;
  
  public vqb(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public vqb(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public Class<? extends vpv> a()
  {
    return vqd.class;
  }
  
  @NonNull
  public vpv a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqd(this, paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqb
 * JD-Core Version:    0.7.0.1
 */