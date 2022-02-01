import android.content.Context;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkk
  extends JobSegment<Integer, List<pkd.a>>
{
  private pkm b;
  private Context mContext;
  
  public pkk(Context paramContext, pkm parampkm)
  {
    this.mContext = paramContext;
    this.b = parampkm;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "start GalleryScanSegment");
    paramInteger = (psr)psx.a(10);
    paramJobContext = new pjo();
    long l2 = ((Long)paramInteger.c("key_last_pic_scan_time", Long.valueOf(-1L))).longValue();
    long l1 = ((Long)paramInteger.c("key_last_date_album_time", Long.valueOf(-1L))).longValue();
    if ((l2 != -1L) && (l1 != -1L))
    {
      this.b.rE(true);
      paramInteger = paramJobContext.a(this.mContext, 1L + l2, true, 10);
      if (paramInteger.isEmpty())
      {
        ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No new picture scanned.");
        notifyResult(paramInteger);
        return;
      }
      paramInteger = ((pju)psx.a(30)).a();
      if (!this.b.Ih()) {
        break label255;
      }
    }
    label255:
    for (paramJobContext = paramJobContext.a(this.mContext, l1 + 1L, true, paramInteger.q(true));; paramJobContext = paramJobContext.a(this.mContext, l1, false, paramInteger.q(false)))
    {
      if ((paramJobContext != null) && (!paramJobContext.isEmpty())) {
        break label275;
      }
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No picture scanned in your phone");
      notifyResult(paramJobContext);
      return;
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "It is not inc scan :" + true + ",lastPicScanTime" + l2 + " ,lastDateAlbumTime=" + l1);
      this.b.rE(false);
      l1 = -1L;
      break;
    }
    label275:
    pju.dI(paramJobContext);
    this.b.fc(((pkd.a)paramJobContext.get(paramJobContext.size() - 1)).zV);
    paramInteger = paramJobContext.iterator();
    while (paramInteger.hasNext()) {
      ram.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "scan pic result=%s", (pkd.a)paramInteger.next());
    }
    paramInteger = new ArrayList();
    int i = 0;
    while (i < paramJobContext.size() - 1)
    {
      if (((pkd.a)paramJobContext.get(i + 1)).mCreateTime - ((pkd.a)paramJobContext.get(i)).mCreateTime > 2L) {
        paramInteger.add(paramJobContext.get(i));
      }
      i += 1;
    }
    paramInteger.add(paramJobContext.get(paramJobContext.size() - 1));
    i = paramJobContext.size() - paramInteger.size();
    l2 = ((pkd.a)paramJobContext.get(0)).mCreateTime;
    if (paramJobContext.size() > 1) {}
    for (l1 = ((pkd.a)paramJobContext.get(paramJobContext.size() - 1)).mCreateTime;; l1 = l2)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "filter the similar last=%d repeatPicCount=%d time span=%d", new Object[] { Integer.valueOf(paramInteger.size()), Integer.valueOf(i), Long.valueOf(l1 - l2) });
      rar.a("video_shoot_slides", "same_reject", 0, 0, new String[] { "" + i, l1 - l2 + "" });
      notifyResult(paramInteger);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkk
 * JD-Core Version:    0.7.0.1
 */