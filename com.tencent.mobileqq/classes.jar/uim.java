import android.app.Activity;

public class uim
  extends uig
{
  public uim(uii paramuii)
  {
    super(paramuii);
  }
  
  public boolean a(uii paramuii)
  {
    if ((paramuii.a() instanceof Activity))
    {
      ugx.a((Activity)paramuii.a(), paramuii.a(), true);
      if (paramuii.a() != null) {
        paramuii.a().d();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uim
 * JD-Core Version:    0.7.0.1
 */