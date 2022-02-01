import org.json.JSONObject;

public class aejp
{
  private int cNv;
  
  public static aejp a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aejp localaejp = new aejp();
      localaejp.cNv = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localaejp;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int Co()
  {
    return this.cNv;
  }
  
  public String toString()
  {
    return super.toString() + " showDonDisturb=" + this.cNv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejp
 * JD-Core Version:    0.7.0.1
 */