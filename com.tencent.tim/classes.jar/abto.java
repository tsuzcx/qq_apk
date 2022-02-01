import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class abto
{
  public static ConcurrentHashMap<Integer, irb> dx = new ConcurrentHashMap();
  public static ConcurrentHashMap<Integer, Boolean> dy = new ConcurrentHashMap();
  public static final int[] jS = { 1, 2, 3, 4, 5, 6, 7 };
  public static final int[] jT = { 53, 54, 55, 56, 86, 87, 88 };
  public static final int[] jU = { 91, 90, 63, 64, 65, 102, 103 };
  
  static void a(abhh paramabhh, int paramInt1, int paramInt2)
  {
    Object localObject = new File(x(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramabhh == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(aqhq.readFileToString((File)localObject));
          paramabhh.c(paramInt1, paramInt2, ((JSONObject)localObject).optLong("version"));
          if (paramInt1 == 1)
          {
            paramabhh = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramabhh != null) && (paramabhh.length() > 0))
            {
              int i = paramabhh.length();
              localObject = new irb();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((irb)localObject).add(paramabhh.optInt(paramInt1));
                paramInt1 += 1;
              }
              dx.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramabhh)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramabhh.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramabhh) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public static void a(AppInterface paramAppInterface, abto.d paramd, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!aqiw.isNetworkAvailable(paramAppInterface.getApplication())))
    {
      if (paramd != null) {
        paramd.aR(false, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = new File(di(paramInt));
            if ((paramBoolean) || (!((File)localObject).exists())) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "file exsit resType->4 id->" + paramInt);
            }
          } while (paramd == null);
          paramd.aR(true, paramInt);
          return;
          str = y(4, paramInt);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->4 id->" + paramInt);
          }
        } while (paramd == null);
        paramd.aR(false, paramInt);
        return;
        paramAppInterface = (aqva)paramAppInterface.getManager(47);
        if (paramAppInterface != null) {
          break;
        }
      } while (paramd == null);
      paramd.aR(false, paramInt);
      return;
      paramAppInterface = paramAppInterface.a(3);
      if (paramAppInterface != null) {
        break;
      }
    } while (paramd == null);
    paramd.aR(false, paramInt);
    return;
    ((File)localObject).getParentFile().mkdirs();
    Object localObject = new aquz(str, (File)localObject);
    ((aquz)localObject).cWy = true;
    ((aquz)localObject).cWw = true;
    ((aquz)localObject).cxX = "apollo_res";
    ((aquz)localObject).retryCount = 1;
    ((aquz)localObject).cWz = true;
    ((aquz)localObject).cWA = true;
    paramAppInterface.a((aquz)localObject, new abtu(paramInt, paramd), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, abto.b paramb, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      if (paramAppInterface != null) {}
    }
    while (paramAppInterface == null)
    {
      return;
      b(paramAppInterface, paramString, new abtp((abhh)paramAppInterface.getManager(153), paramArrayOfInt, paramAppInterface, paramb, paramBoolean, paramInt1), paramInt1, null, paramInt2, paramInt3, paramBoolean);
      return;
    }
    b(paramAppInterface, paramString, paramb, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, abto.c paramc, List<abto.a> paramList, boolean paramBoolean)
  {
    abhh localabhh = (abhh)paramAppInterface.getManager(153);
    Object localObject1;
    if (localabhh != null)
    {
      localObject1 = localabhh.b(paramString);
      if (localObject1 != null) {
        break label162;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((abkd)localObject1).roleId >= 0) && (localabhh.f(1, ((abkd)localObject1).roleId) / 1000L != ((abkd)localObject1).NM))
      {
        QLog.i("ApolloPet", 1, "update pet role :" + ((abkd)localObject1).roleId + " to:" + ((abkd)localObject1).NM);
        paramList.add(new abto.a(1, ((abkd)localObject1).roleId));
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (paramc != null) {
        paramc.e(false, paramString, paramList);
      }
    }
    label162:
    label202:
    do
    {
      do
      {
        return;
        localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
        break;
        localObject1 = (aqva)paramAppInterface.getManager(47);
        if (localObject1 != null) {
          break label202;
        }
      } while (paramc == null);
      paramc.e(false, paramString, paramList);
      return;
      localObject1 = ((aqva)localObject1).a(3);
      if (localObject1 != null) {
        break label229;
      }
    } while (paramc == null);
    paramc.e(false, paramString, paramList);
    return;
    label229:
    AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    int k;
    int m;
    Object localObject2;
    label376:
    boolean bool;
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (abto.a)paramList.get(i);
        k = ((abto.a)localObject3).mResType;
        m = ((abto.a)localObject3).mId;
        localObject2 = y(k, m);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
          }
          localAtomicInteger1.decrementAndGet();
          i += 1;
        }
        else if (!paramBoolean)
        {
          if (k == 1) {
            bool = ApolloUtil.ih(m);
          }
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
        }
        localAtomicInteger1.decrementAndGet();
        break label376;
        if (k == 2)
        {
          bool = ApolloUtil.ig(m);
          continue;
        }
        if (k != 3) {
          break label782;
        }
        if ((ApolloUtil.aF(m, ((abto.a)localObject3).mActionType)) || (ApolloUtil.jdMethod_if(m)))
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
      }
      if (!aqiw.isNetworkAvailable(paramAppInterface.getApplication()))
      {
        if (paramc != null) {
          paramc.e(false, paramString, paramList);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
        return;
      }
      localObject3 = new File(x(k, m), "res.zip");
      ((File)localObject3).getParentFile().mkdirs();
      localObject2 = new aquz((String)localObject2, (File)localObject3);
      ((aquz)localObject2).cWy = true;
      ((aquz)localObject2).cWw = true;
      ((aquz)localObject2).cxX = "apollo_res";
      ((aquz)localObject2).retryCount = 1;
      ((aquz)localObject2).cWz = true;
      ((aquz)localObject2).cWA = true;
      ((aqvc)localObject1).a((aquz)localObject2, new abtq((File)localObject3, localabhh, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramc, paramString, paramList), null);
      break label376;
      if (localAtomicInteger1.get() != 0) {
        break;
      }
      if (paramc != null) {
        paramc.e(true, paramString, paramList);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
      return;
      label782:
      bool = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, abto.e parame)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = arwv.toMD5(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          new File(abxi.bir).mkdir();
          new File(abxi.biv).mkdir();
          localObject = new File(abxi.biv + (String)localObject + File.separator + (String)localObject + ".zip");
          if (((File)localObject).exists())
          {
            QLog.i("ApolloResDownloader", 1, "checkDownloadFaceData url data is exists:" + paramString);
            if (parame == null) {
              continue;
            }
            parame.aR(true, 0);
          }
        }
      }
      catch (Exception localException)
      {
        File localFile;
        for (;;)
        {
          QLog.e("ApolloResDownloader", 1, "checkDownloadFaceData e" + localException);
          localFile = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData url:" + paramString);
        }
        localFile.getParentFile().mkdir();
        aquz localaquz = new aquz(paramString, localFile);
        localaquz.cWy = true;
        localaquz.cWw = true;
        localaquz.cxX = "apollo_res";
        localaquz.retryCount = 1;
        localaquz.cWz = true;
        localaquz.cWA = true;
        ((aqva)paramAppInterface.getManager(47)).a(3).a(localaquz, new abtt(paramString, localFile, parame), null);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle, aquy paramaquy)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new aquz(paramString2, paramString1);
    paramString1.cWy = true;
    paramString1.cWw = true;
    paramString1.cxX = "apollo_res";
    paramString1.retryCount = 1;
    paramString1.cWz = true;
    paramString1.cWA = true;
    ((aqva)paramAppInterface.getManager(47)).a(3).a(paramString1, paramaquy, paramBundle);
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, abto.b paramb, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppInterface == null)
    {
      if (paramb != null) {
        paramb.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    label254:
    AtomicInteger localAtomicInteger1;
    label428:
    do
    {
      do
      {
        ArrayList localArrayList;
        abhh localabhh;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localabhh = (abhh)paramAppInterface.getManager(153);
              if (localabhh != null)
              {
                localObject1 = localabhh.b(paramString);
                if (localObject1 != null) {
                  break label254;
                }
              }
              for (localObject1 = null;; localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress())
              {
                if ((localObject1 != null) && (((abkd)localObject1).roleId >= 0) && (localabhh.f(1, ((abkd)localObject1).roleId) / 1000L != ((abkd)localObject1).NM))
                {
                  QLog.i("ApolloPet", 1, "update pet role :" + ((abkd)localObject1).roleId + " to:" + ((abkd)localObject1).NM);
                  localArrayList.add(new abto.a(1, ((abkd)localObject1).roleId));
                }
                if (paramInt1 >= 0) {
                  localArrayList.add(new abto.a(1, paramInt1));
                }
                if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
                  break;
                }
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new abto.a(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new abto.a(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramb == null);
            paramb.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (aqva)paramAppInterface.getManager(47);
            if (localObject1 != null) {
              break;
            }
          } while (paramb == null);
          paramb.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((aqva)localObject1).a(3);
          if (localObject1 != null) {
            break;
          }
        } while (paramb == null);
        paramb.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localAtomicInteger1 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = (abto.a)localArrayList.get(i);
          int k = ((abto.a)localObject2).mResType;
          int m = ((abto.a)localObject2).mId;
          Object localObject3 = y(k, m);
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
            }
            localAtomicInteger1.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label428;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtil.ih(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label652;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
                }
                localAtomicInteger1.decrementAndGet();
                break;
                if (k == 2) {
                  bool = ApolloUtil.ig(m);
                } else if (k == 3) {
                  bool = ApolloUtil.aF(m, paramInt3);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
              }
            }
            if (!aqiw.isNetworkAvailable(paramAppInterface.getApplication()))
            {
              if (paramb != null) {
                paramb.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localObject2 = new File(x(k, m), "res.zip");
            ((File)localObject2).getParentFile().mkdirs();
            localObject3 = new aquz((String)localObject3, (File)localObject2);
            ((aquz)localObject3).cWy = true;
            ((aquz)localObject3).cWw = true;
            ((aquz)localObject3).cxX = "apollo_res";
            ((aquz)localObject3).retryCount = 1;
            ((aquz)localObject3).cWz = true;
            ((aquz)localObject3).cWA = true;
            ((aqvc)localObject1).a((aquz)localObject3, new abtr((File)localObject2, localabhh, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramb, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (localAtomicInteger1.get() != 0);
      if (paramb != null) {
        paramb.onDownLoadFinish(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    label652:
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new aquz(paramString2, paramString1);
    paramString2.cWy = true;
    paramString2.cWw = true;
    paramString2.cxX = "apollo_res";
    paramString2.retryCount = 1;
    paramString2.cWz = true;
    paramString2.cWA = true;
    ((aqva)paramAppInterface.getManager(47)).a(3).a(paramString2, new abts(paramString1), null);
  }
  
  public static String dh(int paramInt)
  {
    Object localObject = new File(x(1, paramInt), "config.json");
    if (!((File)localObject).exists()) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          localObject = new JSONObject(aqhq.readFileToString((File)localObject)).optString("bubbleTips");
          return localObject;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
            return null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
    return null;
  }
  
  public static String di(int paramInt)
  {
    return x(4, paramInt) + "music.amr";
  }
  
  public static boolean hV(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (dy.containsKey(Integer.valueOf(paramInt))) {
      bool1 = ((Boolean)dy.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject;
    do
    {
      return bool1;
      localObject = new File(x(3, paramInt), "config.json");
      bool1 = bool2;
    } while (!((File)localObject).exists());
    for (;;)
    {
      try
      {
        localObject = new JSONObject(aqhq.readFileToString((File)localObject)).optJSONObject("audio");
        if (localObject == null) {
          break label164;
        }
        bool1 = ((JSONObject)localObject).optBoolean("hasSound");
        dy.put(Integer.valueOf(paramInt), Boolean.valueOf(bool1));
        return bool1;
      }
      catch (Exception localException)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        bool1 = bool2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
      return false;
      label164:
      bool1 = false;
    }
  }
  
  public static int[] j(int paramInt)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    if (dx.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (irb)dx.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return null;
      }
      return ((irb)localObject1).toArray(null);
    }
    for (;;)
    {
      try
      {
        Object localObject5 = new File(x(1, paramInt), "config.json");
        Object localObject3 = localObject4;
        if (((File)localObject5).exists())
        {
          localObject5 = new JSONObject(aqhq.readFileToString((File)localObject5)).optJSONArray("dressIds");
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            localObject3 = localObject4;
            if (((JSONArray)localObject5).length() > 0)
            {
              int j = ((JSONArray)localObject5).length();
              localObject3 = new irb();
              int i = 0;
              if (i < j)
              {
                ((irb)localObject3).add(((JSONArray)localObject5).optInt(i));
                i += 1;
                continue;
              }
              dx.put(Integer.valueOf(paramInt), localObject3);
              localObject3 = ((irb)localObject3).toArray(null);
            }
          }
        }
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject3.length != 0) {}
        }
        else
        {
          if (paramInt != 1) {
            continue;
          }
          localObject1 = jT;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds ex!" + localException.getMessage());
        if ((0 != 0) && (null.length != 0)) {
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
        localObject1 = jT;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = jU;
        continue;
        localObject1 = jS;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds OOM!");
        if ((0 != 0) && (null.length != 0)) {
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
        localObject1 = jT;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = jU;
        continue;
        localObject1 = jS;
        continue;
      }
      finally
      {
        if ((0 != 0) && (null.length != 0)) {
          break label372;
        }
        if (paramInt != 1) {
          break label374;
        }
        arrayOfInt = jT;
      }
      return localObject1;
      if (2 == paramInt) {
        localObject1 = jU;
      } else {
        localObject1 = jS;
      }
    }
    for (;;)
    {
      int[] arrayOfInt;
      label372:
      throw localObject2;
      label374:
      if (2 == paramInt) {
        arrayOfInt = jU;
      } else {
        arrayOfInt = jS;
      }
    }
  }
  
  public static String x(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        localObject = abxi.bio + "/def/role/0/";
      }
    }
    String str;
    do
    {
      return localObject;
      return abxi.bis + paramInt2 + File.separator;
      if (paramInt1 == 2) {
        return abxi.bir + paramInt2 + File.separator;
      }
      if (paramInt1 == 3) {
        return abxi.bip + paramInt2 + File.separator;
      }
      if (paramInt1 == 4) {
        return abxi.biq + paramInt2 + File.separator;
      }
      str = abxi.bim + "/unknow/" + paramInt2 + File.separator;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResFile unknow Type->" + paramInt1 + " id->" + paramInt2);
    return str;
  }
  
  public static String y(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt2 > abxi.ctt)
    {
      str1 = "/android.zip";
      if (paramInt1 != 1) {
        break label54;
      }
      str1 = "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_" + paramInt2 + str1;
    }
    label54:
    do
    {
      return str1;
      str1 = "/d.zip";
      break;
      if (paramInt1 == 2) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + str1;
      }
      if (paramInt1 == 3) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/d.zip";
      }
      if (paramInt1 == 4) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/apollo_audio_" + paramInt2 + ".amr";
      }
      str1 = str2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResUrl recognize Type->" + paramInt1 + " id->" + paramInt2);
    return "";
  }
  
  public static class a
  {
    public int mActionType;
    public int mId;
    public int mResType;
    
    public a(int paramInt1, int paramInt2)
    {
      this.mResType = paramInt1;
      this.mId = paramInt2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  }
  
  public static abstract interface c
    extends abto.b
  {
    public abstract void e(boolean paramBoolean, String paramString, List<abto.a> paramList);
  }
  
  public static abstract interface d
  {
    public abstract void aR(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void aR(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abto
 * JD-Core Version:    0.7.0.1
 */