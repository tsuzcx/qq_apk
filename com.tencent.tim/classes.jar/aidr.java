import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class aidr
  implements Handler.Callback
{
  aidr(aidq paramaidq) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 4: 
      label461:
      do
      {
        do
        {
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return false;
                } while (aidq.a(this.this$0) == null);
                aidq.a(this.this$0).k(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= aidq.a(this.this$0)) || (aidq.a(this.this$0) == null));
              aidq.a(this.this$0).k(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(aidq.a(this.this$0)) });
              aidq.a(this.this$0, i);
              return false;
              if (aidq.a(this.this$0) != null) {
                aidq.a(this.this$0).k(2, new Object[] { paramMessage.obj });
              }
            } while (aidt.ls.get(aidq.a(this.this$0)) == null);
            aids.report(String.valueOf(((aidt)aidt.ls.get(aidq.a(this.this$0))).ddb));
            return false;
            if (aidq.a(this.this$0) != null) {
              aidq.a(this.this$0).k(3, new Object[] { paramMessage.obj });
            }
          } while (aidt.ls.get(aidq.a(this.this$0)) == null);
          aids.report(String.valueOf(((aidt)aidt.ls.get(aidq.a(this.this$0))).ddc));
          return false;
          InstalledPlugin localInstalledPlugin;
          aidq.a locala;
          if (aidq.a(this.this$0) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            locala = aidq.a(this.this$0);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            locala.k(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(aidq.b(this.this$0)) });
            aidq.a(this.this$0, "HuayangPluginNewDownloader", acfp.m(2131707299) + (System.currentTimeMillis() - aidq.c(this.this$0)));
            aidq.a(this.this$0, false);
            return false;
          }
        } while (aidq.a(this.this$0) == null);
        aidq.a(this.this$0).k(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      aidq.a(this.this$0, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      aidq.a(this.this$0).sendMessage(Message.obtain(aidq.a(this.this$0), 1, (int)(d * 100.0D), 0));
      aidq.a(this.this$0).sendMessageDelayed(Message.obtain(aidq.a(this.this$0), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(aidq.a(this.this$0), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    aidq.a(this.this$0).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidr
 * JD-Core Version:    0.7.0.1
 */