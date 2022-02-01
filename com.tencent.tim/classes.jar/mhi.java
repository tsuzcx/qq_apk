import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class mhi
{
  public List<mhj> iN;
  
  public static mhi a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    mhi localmhi = new mhi();
    if (paramHotWordInfo.rpt_hot_word_item.has())
    {
      localmhi.iN = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        mhj localmhj = mhj.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localmhi.iN.add(localmhj);
      }
    }
    return localmhi;
  }
  
  public byte[] E()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if (this.iN.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.iN.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((mhj)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhi
 * JD-Core Version:    0.7.0.1
 */