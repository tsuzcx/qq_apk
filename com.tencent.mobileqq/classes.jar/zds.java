import android.content.SharedPreferences;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zds
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = ApolloUtil.a();
        Object localObject = new File(ApolloConstant.n);
        if (!((File)localObject).exists()) {
          break;
        }
        if (!((File)localObject).isDirectory()) {
          return;
        }
        if (FileUtils.b(ApolloConstant.n) <= 104857600L) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        if (localObject == null) {
          break;
        }
        localObject = Arrays.asList((Object[])localObject);
        Collections.sort((List)localObject, ApolloUtil.a);
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        File localFile = (File)localIterator.next();
        int i = 0;
        if ((localFile != null) && (localFile.exists()))
        {
          String str = localFile.getName();
          if ((str.endsWith(".patch")) || (str.endsWith(".patched")))
          {
            localFile.delete();
            i = 1;
          }
          localObject = str;
          if (str.endsWith(".zip")) {
            localObject = str.substring(0, str.indexOf("."));
          }
          if (AvatarTroopUtil.b((String)localObject))
          {
            long l1 = localSharedPreferences.getLong((String)localObject, 0L);
            long l2 = NetConnInfoCenter.getServerTimeMillis();
            if ((l2 - l1 > 2592000000L) && (l2 - localFile.lastModified() > 2592000000L))
            {
              if (QLog.isColorLevel()) {
                QLog.i("ApolloUtil", 2, "time limit delete file:" + localFile.getName());
              }
              localFile.delete();
              i = 1;
              if (i != 0)
              {
                l1 = FileUtils.b(ApolloConstant.n);
                if (l1 < 104857600L)
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("ApolloUtil", 2, "delete finish,new size:" + l1);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "deleteGameResIfNeed error:", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zds
 * JD-Core Version:    0.7.0.1
 */