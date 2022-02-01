import android.app.Activity;

public class ujb
  extends uiv
{
  public ujb(uix paramuix)
  {
    super(paramuix);
  }
  
  public boolean a(uix paramuix)
  {
    if ((paramuix.a() instanceof Activity))
    {
      ugz.a((Activity)paramuix.a(), paramuix.a(), true);
      if (paramuix.a() != null) {
        paramuix.a().d();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujb
 * JD-Core Version:    0.7.0.1
 */