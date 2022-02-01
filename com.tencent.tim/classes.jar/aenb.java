import org.json.JSONObject;

public class aenb
{
  public String bzG = "";
  public String bzH = "";
  public int cNO;
  public int cNP;
  public int cNQ;
  
  public static aenb a(aeic[] paramArrayOfaeic)
  {
    localaenb = new aenb();
    int i = 0;
    try
    {
      while (i < paramArrayOfaeic.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[i].content);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localaenb.cNO = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localaenb.cNO);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localaenb.cNP = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localaenb.cNP);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localaenb.cNQ = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localaenb.cNQ);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localaenb.bzH = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localaenb.bzG);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localaenb.bzG = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localaenb.bzG);
          }
        }
        i += 1;
      }
      return localaenb;
    }
    catch (Throwable paramArrayOfaeic)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaeic.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenb
 * JD-Core Version:    0.7.0.1
 */