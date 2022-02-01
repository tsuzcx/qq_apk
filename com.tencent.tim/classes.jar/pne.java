import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class pne
  implements aolm.b
{
  pne(pnb.c paramc) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {}
    png localpng;
    do
    {
      do
      {
        return;
        localObject = ((aoll)paramaomh.b).U();
      } while ((localObject == null) || (!(localObject instanceof png)));
      localpng = (png)localObject;
      this.b.a.fC.remove(((png)localObject).downloadKey);
      localpng.Ag = (System.currentTimeMillis() - localpng.Af);
    } while (localpng.a == null);
    Object localObject = localpng.a;
    if (paramaomh.mResult == 0) {}
    for (paramaomh = new ErrorMessage(0, "");; paramaomh = new ErrorMessage(paramaomh.mErrCode, paramaomh.clO))
    {
      ((pnb.a)localObject).a(localpng, paramaomh);
      return;
    }
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.U();
    if ((??? != null) && ((??? instanceof png)))
    {
      png localpng = (png)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.bl)
      {
        if (this.b.a.mListeners != null)
        {
          Iterator localIterator = this.b.a.mListeners.iterator();
          while (localIterator.hasNext())
          {
            pni.a locala = (pni.a)((WeakReference)localIterator.next()).get();
            if (locala != null) {
              locala.a(localpng.vid, localpng.fileType, i, localpng);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pne
 * JD-Core Version:    0.7.0.1
 */