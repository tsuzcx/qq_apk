import android.app.Activity;

public class ojt
  extends ojn
{
  public ojt(ojp paramojp)
  {
    super(paramojp);
  }
  
  public boolean a(ojp paramojp)
  {
    if ((paramojp.getContext() instanceof Activity))
    {
      oir.a((Activity)paramojp.getContext(), paramojp.b(), true);
      if (paramojp.a() != null) {
        paramojp.a().bfx();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojt
 * JD-Core Version:    0.7.0.1
 */