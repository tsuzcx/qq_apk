import android.content.Context;
import java.util.ArrayList;

public class zgs
{
  public String[] cW;
  public int[] jd;
  public ArrayList<zgs.a> mList = new ArrayList();
  
  public void a(Context paramContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.jd = paramArrayOfInt1;
    String[] arrayOfString = new String[paramArrayOfInt2.length];
    int i = 0;
    while (i < paramArrayOfInt2.length)
    {
      arrayOfString[i] = paramContext.getString(paramArrayOfInt2[i]);
      this.mList.add(new zgs.a(paramArrayOfInt1[i], arrayOfString[i]));
      i += 1;
    }
    this.cW = arrayOfString;
  }
  
  public static class a
  {
    public int mId;
    public String mTitle;
    
    public a(int paramInt, String paramString)
    {
      this.mId = paramInt;
      this.mTitle = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgs
 * JD-Core Version:    0.7.0.1
 */