package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class fn$1
  extends Handler
{
  fn$1(fn paramfn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 1;
    int i = 2;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Object localObject1 = fq.cr();
    paramMessage = fd.dD();
    ag localag = new ag();
    Object localObject2 = new ai();
    ((ai)localObject2).cG = 2;
    ((ai)localObject2).cH = 201;
    localag.ct = ((ai)localObject2);
    localObject2 = new al();
    String str = gr.A(gv.dE());
    ((al)localObject2).d = str;
    ((al)localObject2).db = "D8F0AABC489AE12F";
    ((al)localObject2).h = "102769";
    ((al)localObject2).dc = gz.V(gr.eZ());
    ((al)localObject2).cA = 70;
    ((al)localObject2).de = new aj();
    Object localObject3 = "5.3.2".trim().split("[\\.]");
    if (localObject3.length >= 3)
    {
      ((al)localObject2).de.cI = Integer.parseInt(localObject3[0]);
      ((al)localObject2).de.cJ = Integer.parseInt(localObject3[1]);
      ((al)localObject2).de.cK = Integer.parseInt(localObject3[2]);
    }
    localObject3 = gz.V(gr.B((Context)localObject1));
    ((al)localObject2).aX = ("V2;" + str + ";" + (String)localObject3);
    ((al)localObject2).df = gz.V(gr.k((Context)localObject1));
    if (gp.x((Context)localObject1) == 2)
    {
      ((al)localObject2).dd = i;
      if (!gj.t((Context)localObject1)) {
        break label397;
      }
    }
    label397:
    for (i = j;; i = 0)
    {
      ((al)localObject2).cB = i;
      ((al)localObject2).dh = dk.bJ();
      ((al)localObject2).ba = 10000;
      localObject1 = eo.da();
      if (localObject1 != null) {
        ((al)localObject2).dm = ((eo)localObject1).cC();
      }
      localag.cu = ((al)localObject2);
      localObject1 = new ah();
      ((ah)localObject1).cz = "102769";
      ((ah)localObject1).cA = 70;
      localag.cv = ((ah)localObject1);
      paramMessage.a(553, localag, null, 0, new fn.1.1(this));
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fn.1
 * JD-Core Version:    0.7.0.1
 */