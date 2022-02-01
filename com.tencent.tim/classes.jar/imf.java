import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;

public final class imf
{
  protected String mData;
  
  public imf(String paramString)
  {
    this.mData = paramString;
  }
  
  public String getData()
  {
    return this.mData;
  }
  
  public int getIntValue(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      paramString = getIntValues(paramString);
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[0];
  }
  
  public int[] getIntValues(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    String[] arrayOfString;
    int j;
    int i;
    try
    {
      localObject1 = GraphicRenderMgr.getInstance().findConfigValue(this.mData, paramString, "unknown");
      paramString = localObject2;
      if (localObject1 != null)
      {
        if (((String)localObject1).equalsIgnoreCase("unknown")) {
          paramString = localObject2;
        }
      }
      else {
        return paramString;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          localObject1 = null;
        }
        arrayOfString = ((String)localObject1).split(",");
        paramString = localObject2;
      } while (arrayOfString == null);
      j = arrayOfString.length;
      localObject1 = new int[j];
      i = 0;
    }
    for (;;)
    {
      paramString = (String)localObject1;
      if (i >= j) {
        break;
      }
      try
      {
        localObject1[i] = Integer.parseInt(arrayOfString[i].trim());
        i += 1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          localObject1[i] = 0;
        }
      }
    }
  }
  
  public String getStringValue(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      paramString1 = getStringValues(paramString1);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    return paramString1[0];
  }
  
  public String[] getStringValues(String paramString)
  {
    paramString = GraphicRenderMgr.getInstance().findConfigValue(this.mData, paramString, "unknown");
    if ((paramString == null) || (paramString.equalsIgnoreCase("unknown"))) {
      return null;
    }
    return paramString.trim().split(",");
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imf
 * JD-Core Version:    0.7.0.1
 */