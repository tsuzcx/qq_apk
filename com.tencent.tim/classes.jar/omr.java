import android.content.Context;

public abstract class omr<MSG extends omj, INFO extends omk>
{
  MSG a;
  
  public omr(MSG paramMSG)
  {
    this.a = paramMSG;
  }
  
  public abstract boolean a(Context paramContext, INFO paramINFO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omr
 * JD-Core Version:    0.7.0.1
 */