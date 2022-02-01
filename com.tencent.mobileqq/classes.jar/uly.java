import android.content.Context;

public abstract class uly<MSG extends ulp, INFO extends ulq>
{
  MSG a;
  
  public uly(MSG paramMSG)
  {
    this.a = paramMSG;
  }
  
  public abstract boolean a(Context paramContext, INFO paramINFO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uly
 * JD-Core Version:    0.7.0.1
 */