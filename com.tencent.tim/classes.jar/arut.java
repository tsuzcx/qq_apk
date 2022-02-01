import android.text.TextUtils;

public class arut
{
  String appId;
  int ekZ;
  long time;
  String via;
  
  public arut(String paramString1, String paramString2, int paramInt)
  {
    this.appId = paramString1;
    this.via = paramString2;
    this.ekZ = paramInt;
    this.time = System.currentTimeMillis();
  }
  
  public boolean j(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(this.appId)) {
        break label58;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1)
      {
        this.appId = paramString1;
        this.via = paramString2;
        this.ekZ = paramInt;
        this.time = System.currentTimeMillis();
      }
      return bool1;
      label58:
      bool1 = bool2;
      if (this.ekZ == paramInt)
      {
        bool1 = bool2;
        if (this.appId.equals(paramString1))
        {
          bool1 = bool2;
          if (this.via.equals(paramString2))
          {
            bool1 = bool2;
            if (System.currentTimeMillis() - this.time < 1000L) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arut
 * JD-Core Version:    0.7.0.1
 */