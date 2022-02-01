import android.content.Context;

public class qln
{
  static volatile qln a;
  Context mContext;
  
  private qln(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static qln a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new qln(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public boolean JT()
  {
    return false;
  }
  
  public void boT() {}
  
  public void cC(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qln
 * JD-Core Version:    0.7.0.1
 */