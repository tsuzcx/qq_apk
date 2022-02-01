import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class pkp
  extends pkn<pku.c>
{
  public pkp()
  {
    b(new pku.c());
  }
  
  private List<pkd> a(pkw.a parama, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (parama.a.mLevel >= paramInt1)) || (parama.ma.size() <= 0))
    {
      if (parama.getPicCount() >= ((pku.c)a()).bje)
      {
        localObject1 = new pkd(((pku.c)a()).type);
        ((pkd)localObject1).a(this.a);
        ((pkd)localObject1).asS = parama.a.mStr;
        ((pkd)localObject1).lU = new ArrayList();
        localObject2 = parama.bG().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (pkw.a)((Iterator)localObject2).next();
          ((pkd)localObject1).lU.add(((pkw.a)localObject3).a.mStr);
        }
        parama.blo();
        ram.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        parama = new ArrayList(1);
        parama.add(localObject1);
        return parama;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = parama.ma.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (pkw.a)((Iterator)localObject3).next();
      localObject5 = a((pkw.a)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((pkw.a)localObject4).getPicCount() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((pku.c)a()).bje) && (parama.a.mLevel >= paramInt2))
    {
      localObject3 = new pkd(((pku.c)a()).type);
      ((pkd)localObject3).a(this.a);
      ((pkd)localObject3).asS = parama.a.mStr;
      ((pkd)localObject3).lU = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((pkw.a)((Iterator)localObject2).next()).bG().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (pkw.a)((Iterator)localObject4).next();
          ((pkd)localObject3).lU.add(((pkw.a)localObject5).a.mStr);
        }
      }
      parama.blo();
      ram.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private pkw a(HashMap<String, List<pkd.a>> paramHashMap)
  {
    paramHashMap = new pkw(paramHashMap);
    paramHashMap.mh();
    return paramHashMap;
  }
  
  protected List<pkd> ah(List<pkd.a> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (pkd.a)paramList.next();
      if (localHashMap.containsKey(((pkd.a)localObject1).asT))
      {
        ((List)localHashMap.get(((pkd.a)localObject1).asT)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((pkd.a)localObject1).asT, localObject2);
      }
    }
    paramList = a(localHashMap);
    ram.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((pku.c)a()).bjf), Integer.valueOf(((pku.c)a()).bjg));
    paramList = a(paramList.a(), ((pku.c)a()).bjf, ((pku.c)a()).bjg);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (pkd)((Iterator)localObject1).next();
        if ((((pkd)localObject2).lU == null) || (((pkd)localObject2).lU.size() == 0))
        {
          ram.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          rom.fail("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((pkd)localObject2).lU.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((pkd)localObject2).dN(localArrayList);
          ((pkd)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkp
 * JD-Core Version:    0.7.0.1
 */