import org.json.JSONObject;

public class aend
{
  public String bzI = "";
  public int cNR;
  public int cNS;
  
  public static aend a(aeic[] paramArrayOfaeic)
  {
    localaend = new aend();
    int i = 0;
    try
    {
      while (i < paramArrayOfaeic.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[i].content);
        if (localJSONObject.has("preloadSwitch"))
        {
          localaend.cNR = localJSONObject.optInt("preloadSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preloadswtich=" + localaend.cNR);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localaend.cNS = localJSONObject.optInt("preloadInterval", 30);
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed swtich=" + localaend.cNS);
          }
        }
        if (localJSONObject.has("preloadUrl"))
        {
          localaend.bzI = localJSONObject.optString("preloadUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preload url=" + localaend.bzI);
          }
        }
        i += 1;
      }
      return localaend;
    }
    catch (Throwable paramArrayOfaeic)
    {
      com.tencent.TMG.utils.QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaeic.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aend
 * JD-Core Version:    0.7.0.1
 */