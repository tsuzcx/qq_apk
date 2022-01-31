package btmsdkobf;

import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import java.util.TreeMap;

class gx
  implements Runnable
{
  gx(da paramda, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    try
    {
      synchronized (da.b(this.g))
      {
        da.a locala = (da.a)da.d(this.g).remove(Integer.valueOf(this.a));
        if (locala == null)
        {
          eh.h("SharkProcessProxy", da.e(this.g) + " callBack(), no callback for ipcSeqNo: " + this.a);
          return;
        }
      }
      da.h(this.g).removeMessages(0, localObject2);
    }
    catch (Exception localException)
    {
      eh.h("SharkProcessProxy", "exception: " + localException);
      return;
    }
    JceStruct localJceStruct = cd.a(this.b, localObject2.kI);
    if (localObject2.kI != localJceStruct) {
      localObject2.kI = localJceStruct;
    }
    localObject2.kF = this.c;
    eh.f("SharkProcessProxy", da.e(this.g) + " callBack() ipcSeqNo: " + this.a + " seqNo: " + this.d + " cmdId: " + this.c + " retCode: " + this.e + " dataRetCode: " + this.f);
    this.g.a(localObject2, Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gx
 * JD-Core Version:    0.7.0.1
 */