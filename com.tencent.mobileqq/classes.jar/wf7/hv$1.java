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
    int i = hv.c(this.ur);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              hk.az(398686);
            }
          }
          else {
            hk.az(398675);
          }
        }
        else {
          hk.az(398674);
        }
      }
      else {
        hk.az(398673);
      }
    }
    else {
      hk.az(398672);
    }
    hv.b(this.ur).post(new hv.1.2(this, paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hv.1
 * JD-Core Version:    0.7.0.1
 */