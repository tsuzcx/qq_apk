import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ywt
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      ApolloSoLoader.b();
      if (!ApolloSoLoader.b())
      {
        ApolloSoLoader.b(0);
        ApolloSoLoader.b(1);
      }
      boolean bool1 = ApolloSoLoader.c();
      boolean bool2 = ApolloSoLoader.d();
      if ((!bool1) || (!bool2))
      {
        if (!bool1) {
          ApolloSoLoader.c(1);
        }
        if (!bool2) {
          ApolloSoLoader.c(0);
        }
        return;
      }
      if (!ApolloSoLoader.e())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (!ApolloSoLoader.f())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      ApolloSoLoader.a(true);
      ApolloSoLoader.a(0);
      ApolloSoLoader.c();
      ApolloSoLoader.d();
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      ApolloSoLoader.a(1);
      return;
    }
    finally
    {
      long l2;
      if (ApolloSoLoader.g())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      ApolloSoLoader.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywt
 * JD-Core Version:    0.7.0.1
 */