package com.tencent.mobileqq.apollo.utils;

import abwh;
import abyv;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ApolloSoLoader$1
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      abyv.access$000();
      if (abyv.access$100())
      {
        QLog.i("ApolloSoLoader", 1, "User is doing reinstall operation. Stop loading this time.");
        abyv.Ir(1);
        return;
      }
      if (!abyv.id(0))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy jsc.");
        abyv.Ir(0);
        return;
      }
      if (!abyv.id(1))
      {
        QLog.w("ApolloSoLoader", 1, "fail to copy sava.");
        abyv.Ir(1);
        return;
      }
      boolean bool1 = abyv.access$400();
      boolean bool2 = abyv.access$500();
      if ((!bool1) || (!bool2))
      {
        if (!bool1)
        {
          if (abyv.access$600()) {
            abwh.b(10, 100, new Object[] { "sava is not exist" });
          }
          abyv.Ir(1);
        }
        if (!bool2)
        {
          if (abyv.access$600()) {
            abwh.b(10, 100, new Object[] { "jsc is not exist" });
          }
          abyv.Ir(0);
        }
        return;
      }
      if (!abyv.access$700())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to read script.");
        return;
      }
      if (abyv.access$600())
      {
        abwh.a(10, 100, 0, new Object[] { "so is complete" });
        abwh.gN(10, 300);
      }
      if (!abyv.access$800())
      {
        QLog.w("ApolloSoLoader", 1, "[main loader], FAIL to load so.");
        return;
      }
      abyv.B(true);
      abyv.Iq(0);
      abyv.access$1000();
      abyv.cGs();
      if (abyv.access$600())
      {
        abwh.Im(10);
        abwh.bl(10, false);
      }
      QLog.i("ApolloSoLoader", 1, "[main loader], SUCCEED to load script and so.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[main loader]," + localThrowable);
      abyv.Iq(1);
      return;
    }
    finally
    {
      long l2;
      if (abyv.access$900())
      {
        l2 = System.currentTimeMillis();
        QLog.i("ApolloSoLoader", 1, "[main loader], cost:" + (l2 - l1));
      }
      abyv.f().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1
 * JD-Core Version:    0.7.0.1
 */