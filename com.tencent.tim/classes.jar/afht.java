import android.graphics.BitmapFactory.Options;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class afht
{
  public static axpk a = new axpk();
  
  public static String kD(String paramString)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0, -1);
    localCompressInfo.cuS = true;
    boolean bool = akyj.b(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSendControl", 2, new Object[] { "compressBeforeUpload, success: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      paramString = localCompressInfo.destPath;
    }
    return paramString;
  }
  
  public static void ke(List<String> paramList)
  {
    QLog.i("FavEmoSendControl", 1, "uploadCameraEmoList");
    Object localObject1 = (QQAppInterface)axol.getAppInterface();
    afhu localafhu = (afhu)((QQAppInterface)localObject1).getManager(149);
    acef localacef = (acef)((QQAppInterface)localObject1).getBusinessHandler(72);
    String str1 = ((QQAppInterface)localObject1).getCurrentUin();
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int j = 0;
    Iterator localIterator = paramList.iterator();
    String str2;
    List localList;
    int i;
    label109:
    Object localObject2;
    if (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      localList = localafhu.ez();
      localObject1 = localList.iterator();
      i = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (i >= ((CustomEmotionData)localObject2).emoId) {
          break label740;
        }
        i = ((CustomEmotionData)localObject2).emoId;
      }
    }
    label421:
    label737:
    label740:
    for (;;)
    {
      break label109;
      CustomEmotionData localCustomEmotionData1 = new CustomEmotionData();
      localCustomEmotionData1.uin = str1;
      localCustomEmotionData1.emoId = (i + 1);
      localCustomEmotionData1.emoOriginalPath = str2;
      localCustomEmotionData1.RomaingType = "needUpload";
      if (!lS(localCustomEmotionData1.emoOriginalPath))
      {
        QLog.e("FavEmoSendControl", 1, new Object[] { "doStep, checkPicFavEnable false, path ", localCustomEmotionData1.emoOriginalPath });
        localCustomEmotionData1.emoPath = str2;
        localCustomEmotionData1.RomaingType = "failed";
        localafhu.c(localCustomEmotionData1);
        k += 1;
        localacef.notifyUI(2, true, null);
        p(false, 1, 0);
        break;
      }
      localObject1 = localCustomEmotionData1.emoOriginalPath;
      if (needCompress()) {
        localObject1 = kD(localCustomEmotionData1.emoOriginalPath);
      }
      String str3 = SecUtil.getFileMd5((String)localObject1);
      localObject2 = ".jpg";
      i = ((String)localObject1).lastIndexOf(".");
      if (i > 0) {
        localObject2 = ((String)localObject1).substring(i);
      }
      localObject2 = acbn.bmd + aczs.jH(str1) + str3 + (String)localObject2;
      boolean bool = aqhq.copyFile((String)localObject1, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoSendControl", 2, new Object[] { "doStep, copyFile completed, result:", Boolean.valueOf(bool) });
      }
      if (!((String)localObject1).equals(localCustomEmotionData1.emoOriginalPath)) {
        aqhq.deleteFile((String)localObject1);
      }
      localObject1 = localList.iterator();
      i = 0;
      int n = j;
      int m = i;
      CustomEmotionData localCustomEmotionData2;
      if (((Iterator)localObject1).hasNext())
      {
        localCustomEmotionData2 = (CustomEmotionData)((Iterator)localObject1).next();
        if ((!((String)localObject2).equals(localCustomEmotionData2.emoPath)) && (!str3.equals(localCustomEmotionData2.md5))) {
          break label737;
        }
        QLog.e("FavEmoSendControl", 1, new Object[] { "doStep fail, duplicate path, path:", localCustomEmotionData2.emoPath });
        p(false, 2, 0);
        if ("needDel".equals(localCustomEmotionData2.RomaingType))
        {
          localafhu.a(localCustomEmotionData2, localList.indexOf(localCustomEmotionData2));
          i = 1;
        }
      }
      for (;;)
      {
        break label421;
        if ("failed".equals(localCustomEmotionData2.RomaingType))
        {
          localafhu.a(localCustomEmotionData2);
        }
        else
        {
          m = 1;
          n = j + 1;
          j = n;
          if (m != 0) {
            break;
          }
          localCustomEmotionData1.md5 = str3;
          localCustomEmotionData1.emoPath = ((String)localObject2);
          localafhu.c(localCustomEmotionData1);
          localArrayList.add(localCustomEmotionData1);
          j = n;
          if (paramList.indexOf(str2) % 4 != 3) {
            break;
          }
          localacef.notifyUI(2, true, null);
          j = n;
          break;
          if (!localArrayList.isEmpty())
          {
            localacef.notifyUI(2, true, null);
            QLog.d("FavEmoSendControl", 1, "doStep, insert completed");
            i = paramList.size();
            a.y(String.valueOf(1011), new Object[] { localArrayList, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            return;
          }
          new CameraEmoAllSend().h(paramList.size(), 0, 0, k, j);
          return;
        }
      }
    }
  }
  
  public static boolean lS(String paramString)
  {
    try
    {
      aejt.a locala = (aejt.a)aeif.a().o(561);
      if (new File(paramString).length() >= locala.cNz) {
        return false;
      }
      if (!akyr.lP(paramString))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if (localOptions.outWidth < locala.cNA)
        {
          int i = localOptions.outHeight;
          int j = locala.cNA;
          if (i < j) {}
        }
        else
        {
          return false;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("FavEmoSendControl", 1, "checkPicFavEnable exception, ", paramString);
    }
    return true;
  }
  
  public static boolean needCompress()
  {
    return true;
  }
  
  public static void p(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("sucFlag", str);
      localHashMap.put("retCode", String.valueOf(paramInt1));
      localHashMap.put("serverRetCode", String.valueOf(paramInt2));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "FavEmoUploadLocal", false, 0L, 0L, localHashMap, null);
      if (!paramBoolean) {
        break label93;
      }
    }
    label93:
    for (String str = "0";; str = String.valueOf(paramInt1))
    {
      ajdg.ew(str, 1);
      return;
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afht
 * JD-Core Version:    0.7.0.1
 */