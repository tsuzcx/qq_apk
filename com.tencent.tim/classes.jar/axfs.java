import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class axfs
  implements axft.a
{
  axfs(axfr paramaxfr, axfp paramaxfp, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void acx(String paramString)
  {
    QLog.d(axfr.access$100(), 4, "create pngs for material index = " + this.a.index + " end, pngDir = " + paramString);
    this.jk[0] = paramString;
    String[] arrayOfString = new File(paramString).list();
    String str = paramString + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      awtg.p(paramString + File.separator + arrayOfString[0], 320, 320, str);
    }
    axfr.a(this.this$0).FF.add(str);
    axfr.a(this.this$0).FD.add(paramString);
    if ((this.a.cUe != null) && (!this.a.cUe.equals(""))) {
      axfr.a(this.this$0).FE.add(this.a.cUe);
    }
    for (;;)
    {
      axfr.a(this.this$0).FG.add(Integer.valueOf(this.a.index));
      this.b.release();
      return;
      axfr.a(this.this$0).FE.add(this.a.text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfs
 * JD-Core Version:    0.7.0.1
 */