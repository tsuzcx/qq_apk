import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class yhe
  implements Runnable
{
  public void run()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    Object localObject2 = localSharedPreferences.getString("inner_res_md5", null);
    boolean bool;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.i("ApolloManager", 1, "need to unzip def.zip");
      bool = true;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "check default res cost: " + (l2 - l1) + " ms, unzip: " + bool);
      }
      if ((bool) && (ApolloManager.a()))
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ApolloUtil.c("apollo_def_rsc");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localSharedPreferences.edit().putString("inner_res_md5", (String)localObject2).commit();
        }
      }
      ApolloManager.a().set(false);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "check default ready scene file cost: " + (System.currentTimeMillis() - l2));
      }
      return;
      localObject1 = ApolloUtil.c("apollo_def_rsc");
      if (!((String)localObject2).equals(localObject1))
      {
        QLog.d("ApolloManager", 2, "local md5: " + (String)localObject2 + ", newMd5: " + (String)localObject1);
        bool = true;
      }
      else if (!ApolloUtil.c(0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role res is invalid");
        }
        bool = true;
      }
      else
      {
        localObject2 = ApolloResDownloader.a(0);
        if ((localObject2 == null) || (localObject2.length == 0))
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("dresses is invalid size:");
            if (localObject2 != null) {
              break label355;
            }
          }
          label355:
          for (i = 0;; i = localObject2.length)
          {
            QLog.d("ApolloManager", 2, i);
            bool = true;
            break;
          }
        }
        int j = localObject2.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label429;
          }
          int k = localObject2[i];
          if (!ApolloUtil.b(k))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "dress is invalid id: " + k);
            }
            bool = true;
            break;
          }
          i += 1;
        }
        label429:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhe
 * JD-Core Version:    0.7.0.1
 */