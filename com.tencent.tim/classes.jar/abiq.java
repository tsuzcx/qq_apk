import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class abiq
{
  public static void a(AppInterface paramAppInterface, String paramString1, abiq.a parama, List<abip.a> paramList, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {}
    label191:
    do
    {
      abip.a locala;
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              locala = null;
              if (!TextUtils.isEmpty(paramString2))
              {
                locala = new abip.a();
                locala.bgr = paramString2;
                locala.mResType = 6;
                localArrayList.add(locala);
              }
              if (paramList != null) {
                localArrayList.addAll(paramList);
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
              QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
            } while (parama == null);
            parama.a(false, paramString1, paramList, "");
            return;
            paramAppInterface = (aqva)paramAppInterface.getManager(47);
          } while (paramAppInterface == null);
          paramAppInterface = paramAppInterface.a(3);
        } while (paramAppInterface == null);
        paramString2 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        int k = localArrayList.size();
        int i = 0;
        if (i < k)
        {
          Object localObject = (abip.a)localArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscDownloader", 2, "IdolRscItem:" + localObject);
          }
          int m = ((abip.a)localObject).mResType;
          int n = ((abip.a)localObject).mId;
          String str = ((abip.a)localObject).getDownloadUrl();
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes url is empty resType->" + m + " id->" + n);
            }
            paramString2.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label191;
            File localFile = new File(((abip.a)localObject).qU());
            if (!paramBoolean)
            {
              if ((localFile.exists()) && (((abip.a)localObject).Yp())) {}
              for (int j = 1;; j = 0)
              {
                if (j == 0) {
                  break label430;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscDownloader", 2, "file exsit resType->" + m + " id->" + n);
                }
                paramString2.decrementAndGet();
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscDownloader", 2, "file not exsit resType->" + m + " id->" + n);
              }
            }
            if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
            {
              if (parama != null) {
                parama.a(false, paramString1, paramList, "");
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localFile.getParentFile().mkdirs();
            localObject = new aquz(str, localFile);
            ((aquz)localObject).cWy = true;
            ((aquz)localObject).cWw = true;
            ((aquz)localObject).cxX = "apollo_res";
            ((aquz)localObject).retryCount = 1;
            ((aquz)localObject).cWz = true;
            ((aquz)localObject).cWA = true;
            paramAppInterface.a((aquz)localObject, new abir(str, localFile, localAtomicInteger2, m, n, localAtomicInteger1, paramString2, parama, locala, paramString1, paramList), null);
          }
        }
      } while (paramString2.get() != 0);
      if (parama != null)
      {
        paramAppInterface = "";
        if (locala != null) {
          paramAppInterface = locala.qV();
        }
        parama.a(true, paramString1, paramList, paramAppInterface);
      }
    } while (!QLog.isColorLevel());
    label430:
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString1 + ", all cnt: " + paramString2.get());
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, List<abip.a> paramList, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abiq
 * JD-Core Version:    0.7.0.1
 */