import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class acfi
{
  public static Set<String> bM = new HashSet();
  
  public static void a(Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener) {}
  
  private static void a(aquz paramaquz, String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, afhu paramafhu, IPicDownloadListener paramIPicDownloadListener, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2)
  {
    bM.remove(paramString);
    if ((3 == paramaquz.getStatus()) && (paramFile.exists()))
    {
      paramCustomEmotionData.emoPath = paramFile.getAbsolutePath();
      if ("needDownload".equals(paramCustomEmotionData.RomaingType)) {
        paramCustomEmotionData.RomaingType = "isUpdate";
      }
      if (paramBoolean1) {
        paramCustomEmotionData.eId = "";
      }
      if ((TextUtils.isEmpty(paramCustomEmotionData.md5)) && (!TextUtils.isEmpty(paramCustomEmotionData.emoPath))) {
        paramCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramCustomEmotionData.emoPath));
      }
      if (paramBoolean2) {
        paramafhu.b(paramCustomEmotionData);
      }
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
      }
      paramList1.add(paramCustomEmotionData);
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->sucess");
      }
    }
    for (;;)
    {
      paramAtomicInteger1.getAndIncrement();
      if ((paramAtomicInteger1.get() == paramAtomicInteger2.get()) && (paramIPicDownloadListener != null)) {
        paramIPicDownloadListener.onDone(paramList1, paramList2);
      }
      return;
      paramList2.add(paramCustomEmotionData);
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->faile");
      }
      aqrm.b("emotionType", "emotionActionFav", "3", "", "", aqiw.getNetworkType(paramContext) + "", paramaquz.errCode + "", "", "", "");
    }
  }
  
  private static void a(boolean paramBoolean, Context paramContext, IPicDownloadListener paramIPicDownloadListener, aqvc paramaqvc, afhu paramafhu, afim paramafim, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, CustomEmotionData paramCustomEmotionData)
  {
    if (!TextUtils.isEmpty(paramCustomEmotionData.url)) {
      if (paramaqvc.a(paramCustomEmotionData.url) != null) {
        paramAtomicInteger1.decrementAndGet();
      }
    }
    for (;;)
    {
      return;
      String str = acbn.bmd;
      boolean bool1 = false;
      File localFile;
      if ((paramafim != null) && (paramafim.a(paramCustomEmotionData))) {
        if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(acbn.bmd)))
        {
          paramafim = paramCustomEmotionData.emoPath;
          localFile = new File(paramafim);
          if (!localFile.exists()) {
            break label609;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FunyPicHelper", 2, "download path is exsit->" + paramafim);
          }
          paramAtomicInteger1.decrementAndGet();
          paramCustomEmotionData.emoPath = localFile.getAbsolutePath();
          if ("needDownload".equals(paramCustomEmotionData.RomaingType)) {
            paramCustomEmotionData.RomaingType = "isUpdate";
          }
          if (bool1) {
            paramCustomEmotionData.eId = "";
          }
          if ((TextUtils.isEmpty(paramCustomEmotionData.md5)) && (!TextUtils.isEmpty(paramCustomEmotionData.emoPath))) {
            paramCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramCustomEmotionData.emoPath));
          }
          if (paramBoolean) {
            paramafhu.b(paramCustomEmotionData);
          }
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
          }
          paramList1.add(paramCustomEmotionData);
          if (QLog.isColorLevel()) {
            QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->sucess");
          }
        }
      }
      for (;;)
      {
        if ((paramAtomicInteger1.get() != 0) || (paramIPicDownloadListener == null)) {
          break label768;
        }
        paramIPicDownloadListener.onDone(paramList1, paramList2);
        return;
        if (!TextUtils.isEmpty(paramCustomEmotionData.md5))
        {
          paramafim = paramafim.getFilePath(paramCustomEmotionData.md5);
          break;
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.resid))
        {
          paramafim = str + aczs.jH(paramCustomEmotionData.resid);
          break;
        }
        paramafim = str + paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1);
        break;
        if (paramCustomEmotionData.url.contains("qto_"))
        {
          paramafim = str + jj(paramCustomEmotionData.url);
          break;
        }
        if (!TextUtils.isEmpty(jj(paramCustomEmotionData.eId)))
        {
          str = str + paramCustomEmotionData.eId;
          boolean bool2 = true;
          paramafim = str;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FunyPicHelper", 2, "emotion is FunnyPic path download from server->" + paramCustomEmotionData.eId);
          paramafim = str;
          bool1 = bool2;
          break;
        }
        paramafim = str + paramCustomEmotionData.resid;
        break;
        label609:
        aquz localaquz = new aquz(paramCustomEmotionData.url, localFile);
        localaquz.cWy = false;
        localaquz.cxX = "emotion_pic";
        localaquz.retryCount = 1;
        paramafim = "";
        if (paramCustomEmotionData.url.contains("qto_"))
        {
          str = jj(paramCustomEmotionData.url);
          paramafim = str;
          if (!TextUtils.isEmpty(str))
          {
            paramafim = str;
            if (str.length() > "qto_".length() + 8)
            {
              paramafim = str.substring(0, "qto_".length() + 8);
              bM.add(paramafim);
            }
          }
        }
        paramaqvc.a(localaquz, new acfj(paramafim, localFile, paramCustomEmotionData, bool1, paramBoolean, paramafhu, paramIPicDownloadListener, paramList1, paramList2, paramContext, paramAtomicInteger2, paramAtomicInteger1), null);
      }
      label768:
      continue;
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (TextUtils.isEmpty(paramCustomEmotionData.RomaingType)) {}
      for (paramContext = "null"; QLog.isColorLevel(); paramContext = paramCustomEmotionData.RomaingType)
      {
        QLog.d("FunyPicHelper", 2, "checkLoadEmotionPic, url is null : " + paramCustomEmotionData.resid + ", romaingType:" + paramContext);
        return;
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      for (;;)
      {
        return;
        if (!aqiw.isNetworkAvailable(paramContext)) {
          break;
        }
        aqvc localaqvc = ((aqva)paramAppInterface.getManager(47)).a(1);
        if (localaqvc != null)
        {
          afhu localafhu = (afhu)paramAppInterface.getManager(149);
          paramAppInterface = (afim)paramAppInterface.getManager(141);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
          AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            a(paramBoolean, paramContext, paramIPicDownloadListener, localaqvc, localafhu, paramAppInterface, localArrayList1, localArrayList2, localAtomicInteger1, localAtomicInteger2, (CustomEmotionData)paramList.next());
          }
        }
      }
    } while (paramIPicDownloadListener == null);
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  public static void cp(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = aqhq.readFileContent(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), aqpi.f.cuN));
      Object localObject2 = "";
      String str = "";
      j = 1;
      i = j;
      localObject5 = str;
      localObject6 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = str;
        localObject4 = localObject2;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = j;
        localObject5 = str;
        localObject6 = localObject2;
        localObject3 = str;
        localObject4 = localObject2;
        if (((JSONObject)localObject1).has("data"))
        {
          localObject3 = str;
          localObject4 = localObject2;
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          i = j;
          localObject5 = str;
          localObject6 = localObject2;
          localObject3 = str;
          localObject4 = localObject2;
          if (((JSONObject)localObject1).has("releaseZipInfo"))
          {
            localObject3 = str;
            localObject4 = localObject2;
            localObject1 = ((JSONObject)localObject1).getJSONArray("releaseZipInfo");
            i = j;
            localObject5 = str;
            localObject6 = localObject2;
            localObject3 = str;
            localObject4 = localObject2;
            if (((JSONArray)localObject1).length() > 0)
            {
              localObject3 = str;
              localObject4 = localObject2;
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(0);
              localObject1 = localObject2;
              localObject3 = str;
              localObject4 = localObject2;
              if (localJSONObject.has("zipID"))
              {
                localObject3 = str;
                localObject4 = localObject2;
                localObject1 = localJSONObject.getString("zipID");
              }
              localObject2 = str;
              localObject3 = str;
              localObject4 = localObject1;
              if (localJSONObject.has("img"))
              {
                localObject3 = str;
                localObject4 = localObject1;
                localObject2 = localJSONObject.getString("img");
              }
              i = j;
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localJSONObject.has("type"))
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                i = localJSONObject.getInt("type");
                localObject6 = localObject1;
                localObject5 = localObject2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = j;
          localObject5 = localObject3;
          localObject6 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("FunyPicHelper", 2, localException.getMessage());
            i = j;
            localObject5 = localObject3;
            localObject6 = localObject4;
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("funny_pic_info", 0);
      if (!TextUtils.isEmpty(localObject6)) {
        paramQQAppInterface.edit().putString("funnypic_count_sp_key", localObject6).commit();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        paramQQAppInterface.edit().putString("funnypic_name_sp_key", (String)localObject5).commit();
      }
      paramQQAppInterface.edit().putInt("funnypic_type_sp_key", i).commit();
    } while (!QLog.isColorLevel());
    QLog.d("FunyPicHelper", 2, "funnypic zipID->" + localObject6 + ";imgName -> " + (String)localObject5 + ";type -> " + i);
  }
  
  public static int cq(String paramString)
  {
    String str2 = "0";
    String str1 = str2;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring("qto_".length() + i, paramString.length());
      }
    }
    try
    {
      i = Integer.parseInt(str1);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, paramString.getMessage());
      }
    }
    return 0;
  }
  
  public static String jj(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    return str1;
  }
  
  public static class a
    extends aoiz
  {
    public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
      {
        paramOutputStream = (String)paramDownloadParams.tag;
        paramDownloadParams = acbn.bmd;
        paramDownloadParams = new File(paramDownloadParams + Utils.Crc64String(paramOutputStream));
        if (paramDownloadParams.exists()) {
          return paramDownloadParams;
        }
        if (aqva.a(new aquz(paramOutputStream, paramDownloadParams), null) == 0) {
          return paramDownloadParams;
        }
      }
      return null;
    }
    
    public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      paramURLDrawableHandler = paramDownloadParams.getHeader("funnypic_type");
      if (paramURLDrawableHandler != null)
      {
        paramURLDrawableHandler = paramURLDrawableHandler.getValue();
        float f = paramDownloadParams.mGifRoundCorner;
        if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (Integer.valueOf(paramURLDrawableHandler).intValue() == 2)) {
          return new aqqk(paramFile, true, f, 3);
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfi
 * JD-Core Version:    0.7.0.1
 */