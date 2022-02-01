import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afkp
{
  public static String a(QQAppInterface paramQQAppInterface, aquz paramaquz, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramQQAppInterface == null) && (paramaquz == null)) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return null;
      localObject = paramaquz.getParams();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    } while (localEmoticonPackage == null);
    int i = ((Bundle)localObject).getInt("jsonType", afke.cRu);
    File localFile = (File)paramaquz.ov.get(paramaquz.key);
    Object localObject = new afkz();
    paramaquz = localArrayList;
    if (localFile != null)
    {
      if (localFile.exists()) {
        paramaquz = aqhq.fileToBytes(localFile);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label162;
      }
    }
    label162:
    for (paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramaquz, localArrayList);; paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramaquz, localArrayList, (afkz)localObject))
    {
      if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
        QLog.d("EmotionJsonUtils", 2, "handleJsonFileDownload : json parse result = " + paramQQAppInterface);
      }
      return paramQQAppInterface;
      paramaquz = null;
      break;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: parseSmallJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: app is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: data is null");
      }
      return "json data is null";
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: params is null");
      }
      return "params is null";
    }
    paramQQAppInterface = (ajdg)paramQQAppInterface.getManager(14);
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      long l = paramArrayOfByte.getLong("timestamp");
      JSONObject localJSONObject = paramArrayOfByte.getJSONObject("data");
      JSONArray localJSONArray1 = localJSONObject.getJSONArray("baseInfo");
      JSONArray localJSONArray2 = localJSONObject.getJSONArray("operationInfo");
      if ((localJSONArray1 != null) && (localJSONArray2 != null))
      {
        a(paramEmoticonPackage, paramInt, paramArrayList, paramQQAppInterface, paramArrayOfByte, l, localJSONObject, localJSONArray1, localJSONArray2);
        return null;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail OutOfMemoryError  exception=" + paramQQAppInterface.toString());
      return null;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    return "parseSmallJson:json data is error";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList, afkz paramafkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseJson : parseJson start");
    }
    Object localObject = a(paramQQAppInterface, paramEmoticonPackage, paramArrayOfByte, paramArrayList, paramafkz);
    if (localObject != null) {
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      return paramQQAppInterface;
      localObject = (ajdg)paramQQAppInterface.getManager(14);
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(paramArrayOfByte, "utf-8"));
        String str = localJSONObject.getString("id");
        paramQQAppInterface = localJSONObject.getString("name");
        c(paramEmoticonPackage, localJSONObject);
        paramArrayOfByte = a(paramEmoticonPackage, paramInt, (ajdg)localObject, localJSONObject, str, paramQQAppInterface, "");
        paramQQAppInterface = paramArrayOfByte;
        if (paramArrayOfByte != null) {
          continue;
        }
        if (paramEmoticonPackage.isAPNG == 2)
        {
          paramQQAppInterface = localJSONObject.optString("supportApngSize");
          if (TextUtils.isEmpty(paramQQAppInterface)) {}
        }
        for (paramEmoticonPackage.supportSize = paramQQAppInterface;; paramEmoticonPackage.supportSize = localJSONObject.getJSONArray("supportSize").toString()) {
          do
          {
            if ((localJSONObject != null) && (localJSONObject.has("commDiyText"))) {
              paramEmoticonPackage.businessExtra = localJSONObject.getJSONArray("commDiyText").toString();
            }
            ((ajdg)localObject).m(paramEmoticonPackage);
            int i = ((ajdg)localObject).dx(str);
            boolean bool = false;
            if (afnu.a(paramEmoticonPackage)) {
              bool = true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("EmotionJsonUtils", 2, "parseJson: ep = " + paramEmoticonPackage + " ,update :" + bool);
            }
            paramArrayOfByte = a(paramEmoticonPackage, paramInt, paramArrayList, paramafkz, (ajdg)localObject, localJSONObject, str, i, bool);
            paramQQAppInterface = paramArrayOfByte;
            if (paramArrayOfByte != null) {
              break;
            }
            return null;
          } while ((localJSONObject == null) || (!localJSONObject.has("supportSize")));
        }
        return paramArrayOfByte;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.d("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      }
    }
  }
  
  protected static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList, afkz paramafkz)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ap is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : json data is null");
      }
      return "json data is null";
    }
    if ((paramArrayList == null) || (paramafkz == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : params is null");
      }
      return "params is null";
    }
    return null;
  }
  
  protected static String a(EmoticonPackage paramEmoticonPackage, int paramInt, ajdg paramajdg, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    int i2 = 0;
    int k = paramEmoticonPackage.extraFlags & 0x1;
    if (paramJSONObject.has("isOriginal")) {}
    for (int i = paramJSONObject.getInt("isOriginal");; i = 0)
    {
      if (paramJSONObject.optInt("isApng") == 1)
      {
        j = 2;
        paramEmoticonPackage.isAPNG = j;
        if (k != 0) {
          break label368;
        }
        paramEmoticonPackage.extraFlags |= i;
        label66:
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
        }
        if (paramJSONObject.has("mark")) {
          paramString3 = paramJSONObject.getString("mark");
        }
        if (!paramJSONObject.has("type")) {
          break label455;
        }
      }
      label428:
      label455:
      for (int j = paramJSONObject.getInt("type");; j = 0)
      {
        if (paramJSONObject.has("feetype")) {}
        for (k = paramJSONObject.getInt("feetype");; k = 0)
        {
          if (paramJSONObject.has("rscType")) {}
          for (int m = paramJSONObject.getInt("rscType");; m = 0)
          {
            if (paramJSONObject.has("updateTime")) {}
            for (int n = paramJSONObject.getInt("updateTime");; n = 0)
            {
              String str;
              boolean bool;
              if (paramJSONObject.has("ringtype"))
              {
                str = paramJSONObject.getString("ringtype");
                if ("1".equals(str))
                {
                  i = 1;
                  bool = true;
                }
              }
              for (;;)
              {
                label243:
                if ((paramJSONObject.has("type")) && (1 == j)) {}
                for (int i1 = 3;; i1 = 0)
                {
                  if (paramJSONObject.has("downloadcount")) {
                    i2 = paramJSONObject.getInt("downloadcount");
                  }
                  paramEmoticonPackage.epId = paramString1;
                  paramEmoticonPackage.name = paramString2;
                  paramEmoticonPackage.mark = paramString3;
                  paramEmoticonPackage.type = j;
                  paramEmoticonPackage.mobileFeetype = k;
                  paramEmoticonPackage.hasSound = bool;
                  paramEmoticonPackage.subType = i;
                  paramEmoticonPackage.downloadCount = i2;
                  paramEmoticonPackage.jobType = i1;
                  a(paramEmoticonPackage, paramInt, paramajdg, paramJSONObject, paramString1, m, j, n);
                  a(paramEmoticonPackage, paramJSONObject);
                  b(paramEmoticonPackage, paramJSONObject);
                  return null;
                  j = 0;
                  break;
                  label368:
                  if (k <= 0) {
                    break label66;
                  }
                  paramEmoticonPackage.extraFlags &= i;
                  break label66;
                  if ("2".equals(str)) {
                    return "qFace are not supported";
                  }
                  if (!"4".equals(str)) {
                    break label428;
                  }
                  i = 4;
                  bool = false;
                  break label243;
                }
                i = 0;
                bool = false;
              }
            }
          }
        }
      }
    }
  }
  
  protected static String a(EmoticonPackage paramEmoticonPackage, int paramInt1, ArrayList<Emoticon> paramArrayList, afkz paramafkz, ajdg paramajdg, JSONObject paramJSONObject, String paramString, int paramInt2, boolean paramBoolean)
    throws JSONException
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("imgs");
    int n = localJSONArray1.length();
    boolean bool = true;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    JSONObject localJSONObject;
    String str1;
    String str2;
    int k;
    int m;
    String str3;
    Object localObject;
    if (j < n)
    {
      localJSONObject = localJSONArray1.getJSONObject(j);
      str1 = localJSONObject.getString("id");
      str2 = localJSONObject.getString("name");
      k = 0;
      m = 0;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson: emotion.id:" + str1);
      }
      if (localJSONObject.has("wWidthInPhone")) {
        k = localJSONObject.getInt("wWidthInPhone");
      }
      if (localJSONObject.has("wHeightInPhone")) {
        m = localJSONObject.getInt("wHeightInPhone");
      }
      str3 = f(localJSONObject, str2);
      localObject = "";
      paramJSONObject = (JSONObject)localObject;
      if (localJSONObject.has("diyText"))
      {
        JSONArray localJSONArray2 = localJSONObject.getJSONArray("diyText");
        paramJSONObject = (JSONObject)localObject;
        if (localJSONArray2 != null) {
          paramJSONObject = localJSONArray2.toString();
        }
      }
      localObject = paramajdg.a(paramString, str1);
      if (localObject == null) {
        if (paramInt1 != afke.cRv)
        {
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = str1;
          ((Emoticon)localObject).epId = paramString;
          ((Emoticon)localObject).name = str2;
          ((Emoticon)localObject).width = k;
          ((Emoticon)localObject).height = m;
          ((Emoticon)localObject).keywords = str3;
          ((Emoticon)localObject).businessExtra = paramJSONObject;
          bool = true;
        }
      }
    }
    label613:
    for (;;)
    {
      if (localObject == null)
      {
        k = i;
        if (QLog.isColorLevel())
        {
          QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + paramString);
          k = i;
        }
        j += 1;
        i = k;
        break;
        if ((!str1.equals(((Emoticon)localObject).eId)) || (!paramString.equals(((Emoticon)localObject).epId)) || (!str2.equals(((Emoticon)localObject).name)))
        {
          ((Emoticon)localObject).eId = str1;
          ((Emoticon)localObject).epId = paramString;
          if (!TextUtils.isEmpty(str2)) {
            ((Emoticon)localObject).name = str2;
          }
          ((Emoticon)localObject).width = k;
          ((Emoticon)localObject).height = m;
          ((Emoticon)localObject).keywords = str3;
          ((Emoticon)localObject).businessExtra = paramJSONObject;
          bool = true;
          continue;
        }
        bool = false;
        if (!str3.equals(((Emoticon)localObject).keywords))
        {
          bool = true;
          ((Emoticon)localObject).keywords = str3;
        }
        if (paramJSONObject.equals(((Emoticon)localObject).businessExtra)) {
          break label613;
        }
        bool = true;
        ((Emoticon)localObject).businessExtra = paramJSONObject;
        continue;
      }
      paramJSONObject = a(paramEmoticonPackage, (Emoticon)localObject);
      if (paramJSONObject != null) {
        return paramJSONObject;
      }
      if (TextUtils.isEmpty(((Emoticon)localObject).encryptKey)) {
        i = 1;
      }
      for (;;)
      {
        ((Emoticon)localObject).isSound = paramEmoticonPackage.hasSound;
        a(paramEmoticonPackage, paramArrayList, paramInt2, paramBoolean, bool, localArrayList, localJSONObject, str1, str2, (Emoticon)localObject);
        k = i;
        break;
        paramajdg.lp(localArrayList);
        if (paramEmoticonPackage.newSoundEp) {
          paramajdg.m(paramEmoticonPackage);
        }
        if (i == 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramafkz.bYL = paramBoolean;
          return null;
        }
      }
    }
  }
  
  private static String a(EmoticonPackage paramEmoticonPackage, Emoticon paramEmoticon)
  {
    if (paramEmoticonPackage.jobType == 0) {
      paramEmoticon.jobType = 0;
    }
    for (;;)
    {
      return null;
      if (paramEmoticonPackage.jobType == 1) {
        return "qFace are not supported";
      }
      if (paramEmoticonPackage.jobType == 3) {
        paramEmoticon.jobType = 2;
      } else if (paramEmoticonPackage.jobType == 5) {
        paramEmoticon.jobType = 4;
      }
    }
  }
  
  protected static void a(EmoticonPackage paramEmoticonPackage, int paramInt1, ajdg paramajdg, JSONObject paramJSONObject, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramEmoticonPackage.copywritingType != ajdf.dhY)
    {
      paramEmoticonPackage.extraFlags |= 0x4;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson, ep.extraFlags = " + paramEmoticonPackage.extraFlags);
      }
    }
    if ((paramJSONObject.has("type")) && (4 == paramInt3)) {
      paramEmoticonPackage.jobType = 5;
    }
    paramEmoticonPackage.rscType = paramInt2;
    if (paramInt1 != afke.cRv) {
      paramEmoticonPackage.localVersion = paramInt4;
    }
    paramajdg = paramajdg.c(paramString);
    if (paramajdg != null)
    {
      paramEmoticonPackage.status = paramajdg.status;
      paramEmoticonPackage.valid = paramajdg.valid;
    }
    if ((paramEmoticonPackage.mobileFeetype == 1) || ((paramString != null) && ("10278".equals(paramString))) || (paramEmoticonPackage.jobType == 1))
    {
      paramEmoticonPackage.wordingId = 1L;
      return;
    }
    if (paramajdg != null)
    {
      paramEmoticonPackage.wordingId = paramajdg.wordingId;
      return;
    }
    paramEmoticonPackage.wordingId = -1L;
  }
  
  protected static void a(EmoticonPackage paramEmoticonPackage, int paramInt1, ArrayList<Emoticon> paramArrayList, ajdg paramajdg, JSONArray paramJSONArray, int paramInt2, boolean paramBoolean)
    throws JSONException
  {
    int i = 0;
    Object localObject;
    String str1;
    String str2;
    String str4;
    String str3;
    if (i < paramInt2)
    {
      localObject = paramJSONArray.getJSONObject(i);
      str1 = ((JSONObject)localObject).getString("id");
      str2 = ((JSONObject)localObject).getString("name");
      str4 = ((JSONObject)localObject).getString("character");
      str3 = paramEmoticonPackage.epId;
      localObject = paramajdg.a(str3, str1);
      if (localObject == null)
      {
        if (paramInt1 == afke.cRv) {
          break label362;
        }
        localObject = new Emoticon();
        ((Emoticon)localObject).eId = str1;
        ((Emoticon)localObject).epId = str3;
        ((Emoticon)localObject).name = str2;
        ((Emoticon)localObject).character = str4;
        ((Emoticon)localObject).jobType = 3;
        paramBoolean = true;
      }
    }
    label362:
    for (;;)
    {
      label121:
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + str3);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!str1.equals(((Emoticon)localObject).eId)) || (!str3.equals(((Emoticon)localObject).epId)) || (!str2.equals(((Emoticon)localObject).name)))
        {
          ((Emoticon)localObject).eId = str1;
          ((Emoticon)localObject).epId = str3;
          if (!TextUtils.isEmpty(str2)) {
            ((Emoticon)localObject).name = str2;
          }
          if (!TextUtils.isEmpty(str4)) {
            ((Emoticon)localObject).character = str4;
          }
          paramBoolean = true;
          break label121;
        }
        paramBoolean = false;
        break label121;
        int j = 0;
        if (afnu.a(paramEmoticonPackage)) {
          j = 1;
        }
        ((Emoticon)localObject).isSound = paramEmoticonPackage.hasSound;
        paramArrayList.add(localObject);
        if ((paramBoolean) && (j == 0)) {
          paramajdg.e((Emoticon)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseSmallJson :emoticon eId[" + str1 + "]eName[" + str2 + "]");
        }
      }
      return;
    }
  }
  
  protected static void a(EmoticonPackage paramEmoticonPackage, int paramInt, ArrayList<Emoticon> paramArrayList, ajdg paramajdg, JSONObject paramJSONObject1, long paramLong, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    throws JSONException
  {
    paramJSONArray1 = (JSONObject)paramJSONArray1.get(0);
    paramJSONArray2 = (JSONObject)paramJSONArray2.get(0);
    String str = paramJSONArray1.getString("name");
    paramEmoticonPackage.isAPNG = (paramJSONArray1.optInt("isAPNG", 0) + 1);
    if (paramEmoticonPackage.isAPNG == 2) {
      paramEmoticonPackage.rscType = 2;
    }
    int j = paramEmoticonPackage.extraFlags & 0x1;
    if (paramJSONArray1.has("isOriginal")) {}
    for (int i = paramJSONArray1.getInt("isOriginal");; i = 0)
    {
      if (j == 0)
      {
        paramEmoticonPackage.extraFlags |= i;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseSmallJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
        }
        i = 6;
        if (paramJSONObject1.has("type")) {
          i = paramJSONObject1.getInt("type");
        }
        if (!paramJSONArray2.has("feeType")) {
          break label388;
        }
      }
      label388:
      for (j = paramJSONArray2.getInt("feeType");; j = 0)
      {
        paramEmoticonPackage.localVersion = ((int)(paramLong / 1000L));
        paramEmoticonPackage.name = str;
        paramEmoticonPackage.mark = "";
        paramEmoticonPackage.type = i;
        paramEmoticonPackage.mobileFeetype = j;
        paramEmoticonPackage.jobType = 4;
        if ((paramEmoticonPackage.mobileFeetype == 1) || ((paramEmoticonPackage.epId != null) && ("10278".equals(paramEmoticonPackage.epId)))) {
          paramEmoticonPackage.wordingId = 1L;
        }
        for (;;)
        {
          paramajdg.m(paramEmoticonPackage);
          if (QLog.isColorLevel()) {
            QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep = " + paramEmoticonPackage);
          }
          paramJSONObject1 = paramJSONObject2.getJSONArray("itemInfo");
          a(paramEmoticonPackage, paramInt, paramArrayList, paramajdg, paramJSONObject1, paramJSONObject1.length(), true);
          return;
          if (j <= 0) {
            break;
          }
          paramEmoticonPackage.extraFlags &= i;
          break;
          paramJSONObject1 = paramajdg.c(paramEmoticonPackage.epId);
          if (paramJSONObject1 != null) {
            paramEmoticonPackage.wordingId = paramJSONObject1.wordingId;
          } else {
            paramEmoticonPackage.wordingId = -1L;
          }
        }
      }
    }
  }
  
  private static void a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ArrayList<Emoticon> paramArrayList2, JSONObject paramJSONObject, String paramString1, String paramString2, Emoticon paramEmoticon)
  {
    paramJSONObject = paramJSONObject.optJSONObject("voiceData");
    if (paramJSONObject != null)
    {
      paramEmoticon.backColor = paramJSONObject.optString("backcolor", null);
      paramEmoticon.volumeColor = paramJSONObject.optString("fontcolor", null);
      paramJSONObject = paramJSONObject.optString("heightItems", null);
      paramEmoticon.voicePrint = paramJSONObject;
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramEmoticon.voicePrintItems = paramEmoticon.parseSoundPrintString();
        paramEmoticonPackage.newSoundEp = true;
      }
    }
    paramArrayList1.add(paramEmoticon);
    if (paramInt != -1)
    {
      paramEmoticon.extensionWidth = paramInt;
      paramEmoticon.extensionHeight = paramInt;
    }
    if ((paramBoolean2) && (!paramBoolean1)) {
      paramArrayList2.add(paramEmoticon);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "paseJson: emoticon eId[" + paramString1 + "]eName[" + paramString2 + "]");
    }
  }
  
  protected static void a(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
    throws JSONException
  {
    int i;
    int j;
    if ((paramJSONObject != null) && (paramJSONObject.has("operationInfo")))
    {
      paramJSONObject = paramJSONObject.getJSONArray("operationInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        i = 0;
        j = paramJSONObject.length();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if ((localJSONObject == null) || (!localJSONObject.has("platform")) || (!"3".equals(localJSONObject.getString("platform")))) {
          break label116;
        }
        if (localJSONObject.has("minVersion"))
        {
          paramJSONObject = localJSONObject.getString("minVersion");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            paramEmoticonPackage.minQQVersion = paramJSONObject;
          }
        }
      }
      return;
      label116:
      i += 1;
    }
  }
  
  protected static void b(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("childEmojiId")))
    {
      paramJSONObject = paramJSONObject.getString("childEmojiId");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramJSONObject.split(",");
        if ((paramJSONObject != null) && (paramJSONObject.length > 0))
        {
          paramJSONObject = paramJSONObject[0];
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmotionJsonUtils", 2, "parseJson, child magic, id=" + paramJSONObject);
            }
            paramEmoticonPackage.childEpId = paramJSONObject;
          }
        }
      }
    }
  }
  
  protected static void c(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("diversionConfig");
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 1, "diversionConfig = " + localObject);
    }
    if (localObject != null)
    {
      int i = ((JSONObject)localObject).optInt("diversionType");
      paramJSONObject = ((JSONObject)localObject).optString("diversionName");
      String str1 = ((JSONObject)localObject).optString("copywriting");
      String str2 = ((JSONObject)localObject).optString("jumpUrl");
      String str3 = ((JSONObject)localObject).optString("displayImg");
      long l1 = ((JSONObject)localObject).optLong("beginTime");
      long l2 = ((JSONObject)localObject).optLong("endTime");
      String str4 = ((JSONObject)localObject).optString("wording");
      localObject = ((JSONObject)localObject).optString("from");
      paramEmoticonPackage.copywritingType = i;
      paramEmoticonPackage.copywritingContent = str1;
      paramEmoticonPackage.jumpUrl = str2;
      paramEmoticonPackage.imageUrl = str3;
      paramEmoticonPackage.diversionName = paramJSONObject;
      paramEmoticonPackage.beginTime = l1;
      paramEmoticonPackage.endTime = l2;
      paramEmoticonPackage.buttonWording = str4;
      paramEmoticonPackage.comeFom = ((String)localObject);
    }
  }
  
  private static String f(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if (paramJSONObject.has("keywords"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("keywords");
      if (!TextUtils.isEmpty(paramString)) {
        paramJSONObject.put(paramString);
      }
      return paramJSONObject.toString();
    }
    return "[" + paramString + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkp
 * JD-Core Version:    0.7.0.1
 */