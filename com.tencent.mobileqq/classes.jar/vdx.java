import android.app.Activity;

public class vdx
  extends vdr
{
  public vdx(vdt paramvdt)
  {
    super(paramvdt);
  }
  
  public boolean a(vdt paramvdt)
  {
    if ((paramvdt.a() instanceof Activity))
    {
      vbq.a((Activity)paramvdt.a(), paramvdt.a(), true);
      if (paramvdt.a() != null) {
        paramvdt.a().d();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdx
 * JD-Core Version:    0.7.0.1
 */