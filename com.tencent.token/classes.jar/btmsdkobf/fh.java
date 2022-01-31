package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tmsdk.common.roach.nest.ActionI;

class fh
  extends Handler
{
  fh(bq parambq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 259)
    {
      paramMessage = (br)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.gz != null)) {}
    }
    label193:
    label216:
    label247:
    do
    {
      for (;;)
      {
        return;
        Object localObject = bq.a(this.a).i(paramMessage.gz.gH);
        if (localObject != null) {
          if (paramMessage.gz.gI >= ((br)localObject).gz.gI)
          {
            if (paramMessage.gA != 1) {
              break label247;
            }
            if (((br)localObject).gB != 3) {
              break label216;
            }
            if (paramMessage.gz.gI != ((br)localObject).gz.gI) {
              break label193;
            }
            bq.a(this.a, (br)localObject, 1);
          }
        }
        for (;;)
        {
          this.a.gu.removeMessages(260);
          this.a.gu.sendEmptyMessage(260);
          this.a.gu.removeMessages(258);
          this.a.gu.sendEmptyMessage(258);
          this.a.gu.removeMessages(262);
          this.a.gu.sendEmptyMessage(262);
          return;
          bq.a(this.a, (br)localObject, true);
          bq.a(this.a).e(paramMessage);
          continue;
          if (paramMessage.gz.gI > ((br)localObject).gz.gI)
          {
            bq.a(this.a).d(paramMessage);
            continue;
            if (paramMessage.gA == 2)
            {
              bq.a(this.a, (br)localObject, true);
              continue;
              if (paramMessage.gA == 1) {
                bq.a(this.a).e(paramMessage);
              } else if (paramMessage.gA == 2) {
                bq.a(this.a, paramMessage, true);
              }
            }
          }
        }
        if (paramMessage.what == 257)
        {
          paramMessage = bq.a(this.a).ag();
          if ((paramMessage != null) && (paramMessage.size() > 0))
          {
            paramMessage = paramMessage.iterator();
            while (paramMessage.hasNext())
            {
              localObject = (br)paramMessage.next();
              if ((((br)localObject).gB == 3) && (((br)localObject).gA == 1) && (((br)localObject).gz != null) && (((br)localObject).gz.gL >= System.currentTimeMillis()) && (new File(((br)localObject).aa() + File.separator + ((br)localObject).Z()).exists())) {
                bq.a(this.a, (br)localObject, 1);
              }
            }
          }
        }
        else if (paramMessage.what == 258)
        {
          paramMessage = bq.a(this.a).af();
          if (paramMessage != null)
          {
            paramMessage = paramMessage.iterator();
            while (paramMessage.hasNext())
            {
              localObject = (br)paramMessage.next();
              bq.a(this.a, (br)localObject);
            }
            if (bq.a(this.a).af() != null)
            {
              bq.b(this.a);
              return;
            }
            bq.c(this.a);
          }
        }
        else if (paramMessage.what == 260)
        {
          paramMessage = bq.a(this.a).ae();
          if (paramMessage != null)
          {
            paramMessage = paramMessage.iterator();
            while (paramMessage.hasNext())
            {
              localObject = (br)paramMessage.next();
              bq.a(this.a, (br)localObject, true);
            }
          }
        }
        else if (paramMessage.what == 261)
        {
          paramMessage = (ActionI)paramMessage.obj;
          if (paramMessage == null) {
            continue;
          }
          try
          {
            localObject = this.a.gs.keySet().iterator();
            bt localbt;
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              localbt = (bt)((Iterator)localObject).next();
            } while ((ActionI)this.a.gs.get(localbt) != paramMessage);
            this.a.gs.remove(localbt);
            return;
          }
          catch (Throwable paramMessage)
          {
            return;
          }
        }
      }
    } while (paramMessage.what != 262);
    bq.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fh
 * JD-Core Version:    0.7.0.1
 */