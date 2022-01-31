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
    Iterator localIterator;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
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
      return;
    case 1: 
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
    case 2: 
      paramMessage = new ArrayList();
      hs.c(this.tX).tB = false;
      paramMessage.add(hs.c(this.tX));
      if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
      {
        hs.d(this.tX).tB = false;
        paramMessage.add(hs.d(this.tX));
        localIterator = hs.g(this.tX).values().iterator();
        while (localIterator.hasNext()) {
          ((hp)localIterator.next()).tF = false;
        }
        hs.a(this.tX, paramMessage, hs.g(this.tX).values());
      }
      hs.a(this.tX).t(paramMessage);
      this.tX.fy();
      return;
    case 3: 
      paramMessage = new ArrayList();
      hs.c(this.tX).tB = true;
      paramMessage.add(hs.c(this.tX));
      if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
      {
        hs.d(this.tX).tB = false;
        paramMessage.add(hs.d(this.tX));
        hs.a(this.tX, paramMessage, hs.g(this.tX).values());
      }
      hs.a(this.tX).t(paramMessage);
      hs.h(this.tX);
      return;
    }
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    hs.a(this.tX, i, j);
    paramMessage = new ArrayList();
    paramMessage.add(hs.i(this.tX));
    if ((hs.j(this.tX)) && (hs.k(this.tX) != null))
    {
      hs.c(this.tX).tB = false;
      paramMessage.add(hs.c(this.tX));
      localIterator = hs.k(this.tX).values().iterator();
      while (localIterator.hasNext()) {
        ((hp)localIterator.next()).tF = false;
      }
      hs.a(this.tX, paramMessage, hs.k(this.tX).values());
    }
    if ((hs.f(this.tX)) && (hs.g(this.tX) != null))
    {
      hs.d(this.tX).tB = false;
      paramMessage.add(hs.d(this.tX));
      hs.a(this.tX, paramMessage, hs.g(this.tX).values());
    }
    hs.a(this.tX).t(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hs.1
 * JD-Core Version:    0.7.0.1
 */