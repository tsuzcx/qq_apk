package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONObject;

public class SelfUpdateInterface
{
  public static final String LOG_TAG = "SelfUpdateInterface";
  public static final String MAIN_CONFIG_FILE_NAME = "main.config";
  private static final String STATUS_IDLE = "IDLE";
  private static final String STATUS_INSTALLING = "INSTALLING";
  private static final String STATUS_UPDATE_FAILED = "MAYDAY";
  private static final String STATUS_UPDATING = "UPDATING";
  public static final String TAG_COUNT = "count";
  public static final String TAG_PATCHES = "patches";
  public static final String TAG_SIGNATURE = "sign";
  public static Context mContext = null;
  public static String mPathSeparator = File.separator;
  
  public static void DoUpdate()
  {
    setUpdateStatus("UPDATING");
    String str = Common.GetDownloadFolder() + mPathSeparator + "main.config";
    int j = 0;
    int i = j;
    try
    {
      if (updateMainConfig(str))
      {
        localObject = MainConfig.parseFromFile(str);
        if (localObject != null) {
          break label84;
        }
        Common.Log.d("SelfUpdateInterface", "Update got malformed mainconfig");
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        Iterator localIterator;
        Common.Log.d("SelfUpdateInterface", "Update exception : " + localException);
        i = j;
        continue;
        UpdateManager.Update((PatchInfo)localException.next(), false);
      }
      setUpdateStatus("MAYDAY");
    }
    new File(str).delete();
    if (i != 0)
    {
      setUpdateStatus("IDLE");
      return;
      label84:
      localIterator = MainConfig.getMainConfig(mContext).getPatchList().iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          localObject = ((MainConfig)localObject).getPatchList().iterator();
          if (((Iterator)localObject).hasNext()) {
            break label222;
          }
          i = 1;
          break;
        }
        PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
        if (((MainConfig)localObject).findPatch(localPatchInfo.mFlag) == null)
        {
          Common.Log.d("SelfUpdateInterface", "Patch has been removed : " + localPatchInfo.mPatchName);
          localPatchInfo.mEnabled = "false";
          UpdateManager.Update(localPatchInfo, true);
        }
      }
    }
    label222:
  }
  
  public static boolean ShouldDoUpdate()
  {
    if (!Utils.getCurrentProcessName(mContext).equals(Utils.getPackageName(mContext)))
    {
      Common.Log.d("SelfUpdateInterface", "Don't do update in sub-process");
      return false;
    }
    String str1 = Common.GetUpdateStatus();
    String str2 = Common.GetLastUpdateTime();
    if (str2.equals(""))
    {
      Common.Log.d("SelfUpdateInterface", "Never do update yet");
      return true;
    }
    Date localDate2;
    long l;
    for (;;)
    {
      Date localDate1;
      try
      {
        localDate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str2);
        localDate2 = new Date();
        if (localDate2.getTime() > localDate1.getTime())
        {
          l = localDate2.getTime() - localDate1.getTime();
          if (!str1.equals("UPDATING")) {
            break;
          }
          if (l <= 900000L) {
            break label225;
          }
          Common.Log.d("SelfUpdateInterface", "Force re-update :" + l);
          return true;
        }
      }
      catch (ParseException localParseException)
      {
        return true;
      }
      l = localDate1.getTime() - localDate2.getTime();
    }
    if (localParseException.equals("MAYDAY"))
    {
      Common.Log.d("SelfUpdateInterface", "Force do update");
      return true;
    }
    if ((!localParseException.equals("IDLE")) && (!localParseException.equals("INSTALLING")))
    {
      Common.Log.d("SelfUpdateInterface", "Illegal status : " + localParseException + ", force update!");
      return true;
    }
    label225:
    if (l > Common.getMaxUpdateInterval())
    {
      Common.Log.d("SelfUpdateInterface", "Need update. Last update time : " + str2 + ", current time : " + localDate2.toString());
      return true;
    }
    Common.Log.d("SelfUpdateInterface", "Don't need update. Last update time : " + str2 + ", current time : " + localDate2.toString());
    return false;
  }
  
  public static void initSelfUpdateInterface(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private static void setUpdateStatus(String paramString)
  {
    Common.SetLastUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    Common.SetUpdateStatus(paramString);
  }
  
  public static boolean updateMainConfig(String paramString)
    throws Exception
  {
    String str2 = DataReport.getQQUin();
    String str3 = DataReport.getAppVersion();
    long l = DataReport.getAppVersionCode();
    String str1 = Utils.getRandomString(16);
    str2 = "&k=" + URLEncoder.encode(str1, "UTF-8") + "&u=" + URLEncoder.encode(str2, "UTF-8") + "&v=" + "3.0" + "&vn=" + str3 + "&vc=" + l;
    str2 = Constant.MAIN_CONFIG_URL + str2;
    Common.Log.d("SelfUpdateInterface", "MainConfig url : " + str2);
    if (Utils.download(str2, paramString))
    {
      paramString = Utils.ReadFileToStringEx(paramString);
      Common.Log.d("SelfUpdateInterface", "MainConfig : " + paramString);
      if (verifyMainConfig(paramString, str1))
      {
        Common.Log.d("SelfUpdateInterface", "Verify mainconfig OK");
        return true;
      }
      Common.Log.d("SelfUpdateInterface", "Verify mainconfig failed ");
      return false;
    }
    Common.Log.d("SelfUpdateInterface", "Download mainconfig failed");
    return false;
  }
  
  public static boolean verifyMainConfig(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new JSONObject(paramString1);
      String str = ((JSONObject)localObject).getString("sign");
      localObject = String.format("],\"count\":%d,\"sign\":\"%s\"}", new Object[] { Integer.valueOf(((JSONObject)localObject).getInt("count")), str });
      if ((paramString1.indexOf("[") != paramString1.lastIndexOf("[")) || (paramString1.indexOf("]") != paramString1.lastIndexOf("]")) || (!paramString1.startsWith("{\"patches\":[")) || (!paramString1.endsWith((String)localObject)))
      {
        Common.Log.d("SelfUpdateInterface", "Unexpected content format : " + paramString1);
        return false;
      }
      paramString1 = paramString1.substring(paramString1.indexOf("["), paramString1.indexOf("]") + 1) + paramString2;
      Common.Log.d("SelfUpdateInterface", "Signature : " + str);
      Common.Log.d("SelfUpdateInterface", "Payload : " + paramString1);
      paramString2 = EncryptUtilsForQQ.RsaDecryptData(str);
      Common.Log.d("SelfUpdateInterface", "Decrypted signature : " + paramString2);
      paramString1 = Utils.getSHA1String(paramString1.getBytes());
      Common.Log.d("SelfUpdateInterface", "Current signature : " + paramString1);
      boolean bool = paramString1.equals(paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      Common.Log.d("SelfUpdateInterface", "Verify mainconfig error : " + paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.SelfUpdateInterface
 * JD-Core Version:    0.7.0.1
 */