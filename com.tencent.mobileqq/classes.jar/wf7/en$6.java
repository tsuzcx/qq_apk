package wf7;

import com.qq.taf.jce.JceStruct;
import java.util.TreeMap;

class en$6
  implements Runnable
{
  en$6(en paramen, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    try
    {
      synchronized (en.c(this.nS))
      {
        en.a locala = (en.a)en.c(this.nS).get(Integer.valueOf(this.nW));
        if (locala == null) {
          return;
        }
        JceStruct localJceStruct = df.a(this.nX, locala.og, false);
        if (locala.og != localJceStruct) {
          locala.og = localJceStruct;
        }
        locala.gV = this.nU;
        this.nS.a(locala, Integer.valueOf(this.lY), Integer.valueOf(this.nY), Integer.valueOf(this.nZ));
        en.c(this.nS).remove(Integer.valueOf(this.nW));
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.en.6
 * JD-Core Version:    0.7.0.1
 */