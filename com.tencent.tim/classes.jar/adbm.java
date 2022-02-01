import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class adbm
{
  public long RR;
  public boolean bLc;
  public String brD;
  public String brE;
  public String brF;
  public int cBF;
  public int cBG = 1;
  public int cBH = 1;
  public int cBI;
  public String mJumpUrl = "https://www.qq.com";
  public ArrayList<adbm.a> ua = new ArrayList();
  
  public static adbm a(JSONObject paramJSONObject)
  {
    localadbm = new adbm();
    try
    {
      if (paramJSONObject.has("preDownload")) {
        localadbm.cBF = paramJSONObject.optInt("preDownload");
      }
      if (paramJSONObject.has("Video360Restart")) {
        localadbm.cBG = paramJSONObject.optInt("Video360Restart");
      }
      int i;
      if (paramJSONObject.has("Video360Repeat"))
      {
        localadbm.cBH = paramJSONObject.optInt("Video360Repeat");
        if (localadbm.cBH > 0) {
          break label440;
        }
        i = 2147483647;
      }
      for (;;)
      {
        localadbm.cBH = i;
        if (paramJSONObject.has("Video360ConnectType")) {
          localadbm.cBI = paramJSONObject.optInt("Video360ConnectType");
        }
        Object localObject1;
        if (paramJSONObject.has("TraversingResource"))
        {
          localObject1 = paramJSONObject.optJSONObject("TraversingResource");
          if (((JSONObject)localObject1).has("TraversingResourceSize")) {
            localadbm.RR = ((JSONObject)localObject1).optLong("TraversingResourceSize");
          }
          if (((JSONObject)localObject1).has("TraversingResourceUrl")) {
            localadbm.brD = ((JSONObject)localObject1).optString("TraversingResourceUrl");
          }
          if (((JSONObject)localObject1).has("TraversingResourceMD5")) {
            localadbm.brE = ((JSONObject)localObject1).optString("TraversingResourceMD5");
          }
        }
        label440:
        if (paramJSONObject.has("FragmentInfos"))
        {
          paramJSONObject = paramJSONObject.optJSONArray("FragmentInfos");
          int k = paramJSONObject.length();
          i = 0;
          label212:
          if (i < k)
          {
            Object localObject2 = paramJSONObject.getJSONObject(i);
            localObject1 = new adbm.a();
            if (((JSONObject)localObject2).has("name")) {
              ((adbm.a)localObject1).brG = ((JSONObject)localObject2).getString("name");
            }
            if (((JSONObject)localObject2).has("md5")) {
              ((adbm.a)localObject1).brH = ((JSONObject)localObject2).getString("md5");
            }
            if (((JSONObject)localObject2).has("url")) {
              ((adbm.a)localObject1).mVideoUrl = ((JSONObject)localObject2).getString("url");
            }
            int j;
            if (((JSONObject)localObject2).has("repeat"))
            {
              ((adbm.a)localObject1).cBJ = ((JSONObject)localObject2).optInt("repeat");
              if (((adbm.a)localObject1).cBJ <= 0)
              {
                j = 2147483647;
                ((adbm.a)localObject1).cBJ = j;
              }
            }
            else
            {
              if (((JSONObject)localObject2).has("triggerType")) {
                ((adbm.a)localObject1).mTriggerType = ((JSONObject)localObject2).optInt("triggerType");
              }
              if (((JSONObject)localObject2).has("trigger"))
              {
                localObject2 = ((JSONObject)localObject2).getString("trigger").split("\\|");
                if (localObject2 != null)
                {
                  j = localObject2.length;
                  if (j != 2) {}
                }
              }
            }
            try
            {
              ((adbm.a)localObject1).cBK = Integer.parseInt(localObject2[0]);
              ((adbm.a)localObject1).cBL = Integer.parseInt(localObject2[1]);
              localadbm.ua.add(localObject1);
              i += 1;
              break label212;
              i = localadbm.cBH;
              continue;
              j = ((adbm.a)localObject1).cBJ;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                ((adbm.a)localObject1).cBK = 0;
                ((adbm.a)localObject1).cBL = 0;
                QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, numberException\n%s", new Object[] { localNumberFormatException }));
              }
            }
          }
        }
      }
      return localadbm;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
  }
  
  public static class a
  {
    public String brG;
    public String brH;
    public int cBJ = 2;
    public int cBK;
    public int cBL;
    public int mTriggerType;
    public String mVideoUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbm
 * JD-Core Version:    0.7.0.1
 */