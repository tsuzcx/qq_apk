package moai.patch.log;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;

class Log$FileLogPrinter$1
  implements Runnable
{
  Log$FileLogPrinter$1(Log.FileLogPrinter paramFileLogPrinter) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)Log.FileLogPrinter.access$000(this.this$0).take();
        if (str != null)
        {
          Log.d(Log.FileLogPrinter.TAG, str);
          BufferedWriter localBufferedWriter = Log.FileLogPrinter.access$100(this.this$0);
          if (localBufferedWriter != null) {}
        }
        else
        {
          return;
        }
        try
        {
          Log.FileLogPrinter.access$100(this.this$0).write(str);
          Log.FileLogPrinter.access$100(this.this$0).newLine();
          Log.FileLogPrinter.access$100(this.this$0).flush();
        }
        catch (IOException localIOException)
        {
          Log.e(Log.FileLogPrinter.TAG, "print moai log failed:" + localIOException.toString());
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.e(Log.FileLogPrinter.TAG, "print fail:" + localInterruptedException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.Log.FileLogPrinter.1
 * JD-Core Version:    0.7.0.1
 */