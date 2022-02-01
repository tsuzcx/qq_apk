package wf7;

import android.os.Handler;

class hv$1
  implements hc.b
{
  hv$1(hv paramhv, int paramInt) {}
  
  public void aa(String paramString)
  {
    fm.dL().K(paramString);
    hk.y(500774, this.uq);
    if (this.uq == 8) {
      hk.az(500176);
    }
    switch (hv.c(this.ur))
    {
    }
    for (;;)
    {
      hv.b(this.ur).post(new hv.1.2(this, paramString));
      return;
      hk.az(398674);
      continue;
      hk.az(398673);
      continue;
      hk.az(398675);
      continue;
      hk.az(398672);
      continue;
      hk.az(398686);
    }
  }
  
  public void ay(int paramInt)
  {
    hk.y(500773, paramInt);
    hv.b(this.ur).post(new hv.1.3(this, paramInt));
  }
  
  public void onProgress(int paramInt)
  {
    hv.b(this.ur).post(new hv.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.hv.1
 * JD-Core Version:    0.7.0.1
 */