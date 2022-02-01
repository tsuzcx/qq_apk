import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pjy
  implements pjz
{
  protected pjz.a a;
  protected boolean aAh = true;
  protected List<pkn> lQ;
  private List<pkd.a> lR;
  private List<pkd.a> lS = new ArrayList();
  public int mAlbumType;
  protected String mTag;
  
  public pjy(int paramInt)
  {
    this.mAlbumType = paramInt;
    this.mTag = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void l(List<pkd> paramList, String paramString) {}
  
  public void a(pjz.a parama)
  {
    ram.d(this.mTag, "start");
    this.a = parama;
    parama = bD();
    if ((parama == null) || (parama.isEmpty()))
    {
      ram.e(this.mTag, "can't find enough pic");
      dL(null);
      return;
    }
    if (this.lQ == null)
    {
      ram.e(this.mTag, "must set split strategy");
      dL(null);
      return;
    }
    parama = new pkd(this.mAlbumType, parama);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(parama);
    parama = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.lQ.size())
    {
      Object localObject2 = (pkn)this.lQ.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (pkd)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          ram.d(this.mTag, "to split StoryAlbum=%s", ((pkd)localObject3).toString());
          ((pkn)localObject2).c((pkd)localObject3);
          localObject3 = ((pkn)localObject2).bE();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            ram.w(this.mTag, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            l((List)localObject3, localObject2.toString());
            ram.d(this.mTag, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              pkd localpkd = (pkd)((Iterator)localObject3).next();
              if (i == this.lQ.size() - 1) {
                localArrayList.add(localpkd);
              } else {
                parama.add(localpkd);
              }
            }
          }
        }
      }
      if (parama.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = parama;
      parama = (pjz.a)localObject1;
      localObject1 = localObject2;
    }
    dL(localArrayList);
  }
  
  public void a(pkn parampkn)
  {
    if (this.lQ == null) {
      this.lQ = new ArrayList();
    }
    this.lQ.add(parampkn);
  }
  
  @NonNull
  protected List<pkd.a> bD()
  {
    if (this.lR == null) {
      return new ArrayList();
    }
    return this.lR;
  }
  
  public void dK(List<pkd.a> paramList)
  {
    this.lR = new ArrayList();
    this.lR.addAll(paramList);
  }
  
  protected void dL(List<pkd> paramList)
  {
    this.lS = new ArrayList();
    this.lS.addAll(this.lR);
    if ((paramList != null) && (paramList.size() > 0))
    {
      dM(paramList);
      if (!this.aAh)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((pkd)((Iterator)localObject).next()).bD().iterator();
          while (localIterator.hasNext())
          {
            pkd.a locala = (pkd.a)localIterator.next();
            this.lS.remove(locala);
          }
        }
      }
    }
    Object localObject = this.mTag;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ram.b((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.lS.size()));
      this.a.s(paramList, this.lS);
      return;
    }
  }
  
  protected void dM(List<pkd> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjy
 * JD-Core Version:    0.7.0.1
 */