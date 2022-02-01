package com.tencent.qapmsdk.common.logger;

import android.os.Environment;
import android.util.Log;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class Logger$DefaultLogProxy$writeLogFile$1
  implements Runnable
{
  Logger$DefaultLogProxy$writeLogFile$1(Logger.DefaultLogProxy paramDefaultLogProxy) {}
  
  public final void run()
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.this$0)
      {
        boolean bool = Logger.DefaultLogProxy.access$getFlushing$p(this.this$0);
        if (bool) {
          return;
        }
        try
        {
          String str1 = Environment.getExternalStorageState();
          if (str1 == null)
          {
            i = 0;
            if (i != 0) {
              continue;
            }
            Logger.DefaultLogProxy.access$getWriterQueue$p(this.this$0).clear();
            Log.e("QAPM_common_Logger", "sdcard could not write");
            return;
          }
          switch (str1.hashCode())
          {
          case 1242932856: 
            if (!str1.equals("mounted")) {
              continue;
            }
            i = 1;
            break;
          case 1299749220: 
            bool = str1.equals("mounted_ro");
            if (!bool) {
              continue;
            }
            i = 0;
            continue;
            Log.e("QAPM_common_Logger", (String)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject1 = localException.getMessage();
          if (localObject1 == null) {
            break label578;
          }
        }
        int i = 0;
        continue;
        localObject1 = new File(Intrinsics.stringPlus(FileUtil.Companion.getRootPath(), "/Log"));
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        Logger.DefaultLogProxy.access$setFlushing$p(this.this$0, true);
        Object localObject3 = (String)Logger.DefaultLogProxy.access$getWriterQueue$p(this.this$0).poll();
        if (localObject3 != null) {
          Logger.DefaultLogProxy.access$getSb$p(this.this$0).append((String)localObject3 + "\r\n");
        }
        if (localObject3 != null) {
          continue;
        }
        long l;
        if (((CharSequence)Logger.DefaultLogProxy.access$getSb$p(this.this$0)).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            l = System.currentTimeMillis();
            if (l - Logger.DefaultLogProxy.access$getLastTimeMillis$p(this.this$0) > 1800000)
            {
              localObject3 = new SimpleDateFormat("MM.dd.HH", Locale.US);
              Logger.DefaultLogProxy.access$setLogFile$p(this.this$0, new File((File)localObject1, "QAPM_" + ((SimpleDateFormat)localObject3).format(Long.valueOf(l)) + ".log"));
            }
          }
        }
        try
        {
          localObject1 = Logger.DefaultLogProxy.access$getLogFile$p(this.this$0);
          if (localObject1 != null)
          {
            if (!((File)localObject1).exists()) {
              ((File)localObject1).createNewFile();
            }
            localCloseable = (Closeable)new BufferedWriter((Writer)new FileWriter((File)localObject1, true));
            localObject3 = (Throwable)null;
            localObject1 = localObject3;
          }
        }
        catch (Throwable localThrowable1)
        {
          Closeable localCloseable;
          Object localObject5;
          Log.e("QAPM_common_Logger", Logger.INSTANCE.getThrowableMessage(localThrowable1));
          continue;
        }
        try
        {
          localObject5 = (BufferedWriter)localCloseable;
          localObject1 = localObject3;
          ((BufferedWriter)localObject5).write(Logger.DefaultLogProxy.access$getSb$p(this.this$0).toString());
          localObject1 = localObject3;
          ((BufferedWriter)localObject5).flush();
          localObject1 = localObject3;
          localObject5 = Unit.INSTANCE;
          CloseableKt.closeFinally(localCloseable, (Throwable)localObject3);
          Logger.DefaultLogProxy.access$setLastTimeMillis$p(this.this$0, l);
          Logger.DefaultLogProxy.access$getSb$p(this.this$0).delete(0, Logger.DefaultLogProxy.access$getSb$p(this.this$0).length());
          Logger.DefaultLogProxy.access$setFlushing$p(this.this$0, false);
          localObject1 = Unit.INSTANCE;
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localThrowable2;
          throw localThrowable2;
        }
        finally
        {
          CloseableKt.closeFinally(localCloseable, (Throwable)localObject1);
        }
        i = 0;
      }
      continue;
      label578:
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger.DefaultLogProxy.writeLogFile.1
 * JD-Core Version:    0.7.0.1
 */