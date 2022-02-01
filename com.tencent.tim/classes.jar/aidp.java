import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aidp
  implements Handler.Callback
{
  aidp(aido paramaido) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = aido.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aido.a)((Iterator)localObject).next()).onProgressUpdate(paramMessage.arg1);
      }
      localObject = aido.a(this.this$0).iterator();
      if (((Iterator)localObject).hasNext())
      {
        aido.a locala = (aido.a)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          locala.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(aidi.lu(aido.a(this.this$0).mPackageName));
      if (paramMessage.arg1 == 0)
      {
        if (aidi.mU(aido.a(this.this$0).mPackageName)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          aido.a(this.this$0).sendBroadcast((Intent)localObject);
          if (aidt.ls.get(aido.a(this.this$0)) == null) {
            break;
          }
          aids.report(String.valueOf(((aidt)aidt.ls.get(aido.a(this.this$0))).ddf));
          return false;
        }
      }
      if (aidi.mU(aido.a(this.this$0).mPackageName)) {
        aids.Lb("2691708");
      }
      for (;;)
      {
        aide.j((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        aido.a(this.this$0).sendBroadcast((Intent)localObject);
        return false;
        if (aidi.mV(aido.a(this.this$0).mPackageName)) {
          aids.Lb("2597726");
        } else if (aidt.ls.get(aido.a(this.this$0)) != null) {
          aids.report(String.valueOf(((aidt)aidt.ls.get(aido.a(this.this$0))).dde));
        }
      }
      paramMessage = new Intent(aidi.lu(aido.a(this.this$0).mPackageName));
      paramMessage.putExtra("key_state", 6);
      aido.a(this.this$0).sendBroadcast(paramMessage);
    } while (aidt.ls.get(aido.a(this.this$0)) == null);
    aids.report(String.valueOf(((aidt)aidt.ls.get(aido.a(this.this$0))).ddd));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidp
 * JD-Core Version:    0.7.0.1
 */