import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class yrd
  implements Runnable
{
  public yrd(ApolloCardWindow paramApolloCardWindow) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = new File(ApolloConstant.g);
        if (((File)localObject1).exists())
        {
          if (!((File)localObject1).isDirectory()) {
            return;
          }
          localObject1 = ((File)localObject1).listFiles();
          int j = localObject1.length;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            if ((localObject3 == null) || (!localObject3.getPath().endsWith(".cache"))) {
              break label143;
            }
            ??? = localObject3.getName();
            String str = ((String)???).substring(0, ((String)???).indexOf("."));
            synchronized (ApolloCardWindow.a)
            {
              ApolloCardWindow.a.put(str, this.a.a(localObject3.getPath()));
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloCardWindow", 1, "mPreloadRunnable error:", localException);
      }
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrd
 * JD-Core Version:    0.7.0.1
 */