package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.wifisdk.ui.view.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class hs$1
  extends Handler
{
  hs$1(hs paramhs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        Object localObject;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            i = paramMessage.arg1;
            int j = paramMessage.arg2;
            hs.a(this.tX, i, j);
            paramMessage = new ArrayList();
            paramMessage.add(hs.i(this.tX));
            if ((hs.j(this.tX)) && (hs.k(this.tX) != null))
            {
              hs.c(this.tX).tB = false;
              paramMessage.add(hs.c(this.tX));
              localObject = hs.k(this.tX).values().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((hp)((Iterator)localObject).next()).tF = false;
              }
              localObject = this.tX;
              hs.a((hs)localObject, paramMessage, hs.k((hs)localObject).values());
            }
            if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
            {
              hs.d(this.tX).tB = false;
              paramMessage.add(hs.d(this.tX));
              localObject = this.tX;
              hs.a((hs)localObject, paramMessage, hs.g((hs)localObject).values());
            }
            hs.a(this.tX).t(paramMessage);
            return;
          }
          paramMessage = new ArrayList();
          hs.c(this.tX).tB = true;
          paramMessage.add(hs.c(this.tX));
          if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
          {
            hs.d(this.tX).tB = false;
            paramMessage.add(hs.d(this.tX));
            localObject = this.tX;
            hs.a((hs)localObject, paramMessage, hs.g((hs)localObject).values());
          }
          hs.a(this.tX).t(paramMessage);
          hs.h(this.tX);
          return;
        }
        paramMessage = new ArrayList();
        hs.c(this.tX).tB = false;
        paramMessage.add(hs.c(this.tX));
        if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
        {
          hs.d(this.tX).tB = false;
          paramMessage.add(hs.d(this.tX));
          localObject = hs.g(this.tX).values().iterator();
          while (((Iterator)localObject).hasNext()) {
            ((hp)((Iterator)localObject).next()).tF = false;
          }
          localObject = this.tX;
          hs.a((hs)localObject, paramMessage, hs.g((hs)localObject).values());
        }
        hs.a(this.tX).t(paramMessage);
        this.tX.fy();
        return;
      }
      if (!ca.b(hs.b(this.tX)))
      {
        this.tX.fy();
        return;
      }
      paramMessage = new ArrayList();
      hs.c(this.tX).tB = false;
      paramMessage.add(hs.c(this.tX));
      hs.d(this.tX).tB = true;
      paramMessage.add(hs.d(this.tX));
      hs.a(this.tX).t(paramMessage);
      hs.e(this.tX);
      return;
    }
    hs.a(this.tX).fO();
    if (!ca.b(hs.b(this.tX)))
    {
      this.tX.fy();
      return;
    }
    paramMessage = new ArrayList();
    hs.c(this.tX).tB = false;
    paramMessage.add(hs.c(this.tX));
    hs.d(this.tX).tB = false;
    paramMessage.add(hs.d(this.tX));
    hs.a(this.tX).t(paramMessage);
    sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hs.1
 * JD-Core Version:    0.7.0.1
 */