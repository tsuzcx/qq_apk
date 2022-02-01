import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class pnd
  implements angu
{
  pnd(pnb.b paramb, String paramString) {}
  
  public void a(int paramInt, angq paramangq)
  {
    png localpng;
    if (paramangq.mResult == 0)
    {
      paramangq = (akxb.a)paramangq.en;
      localpng = (png)this.b.a.fC.remove(this.atS);
      if (localpng != null)
      {
        if (!new File(paramangq.bUF).exists()) {
          break label99;
        }
        localpng.Ag = (System.currentTimeMillis() - localpng.Af);
        if (localpng.a != null) {
          localpng.a.a(localpng, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        ram.w("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.atS });
        return;
        ram.w("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.atS, String.valueOf(paramangq.mResult) });
        localpng = (png)this.b.a.fC.remove(this.atS);
      } while (localpng == null);
      localpng.Ag = (System.currentTimeMillis() - localpng.Af);
    } while (localpng.a == null);
    localpng.a.a(localpng, new ErrorMessage(paramangq.mResult, "onFailed"));
  }
  
  public void b(int paramInt, angq paramangq) {}
  
  public void h(int paramInt, ArrayList<angq> paramArrayList) {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnd
 * JD-Core Version:    0.7.0.1
 */