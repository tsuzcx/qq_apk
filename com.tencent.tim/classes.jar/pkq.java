import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class pkq
  extends pkn<pku.a>
{
  private pku.c a;
  private pku.c b;
  private pku.c c;
  
  public pkq()
  {
    int i = ((pju)psx.a(30)).a().sg();
    this.jdField_a_of_type_Pku$c = new pku.c();
    this.jdField_a_of_type_Pku$c.type = 2;
    this.jdField_a_of_type_Pku$c.bje = 6;
    this.jdField_a_of_type_Pku$c.bjf = i;
    this.jdField_a_of_type_Pku$c.bjg = (i - 1);
    this.b = new pku.c();
    this.b.type = 4;
    this.b.bje = 10;
    this.b.bjf = i;
    this.b.bjg = -1;
    this.c = new pku.c();
    this.c.type = 3;
    this.c.bje = 6;
    this.b.bjf = i;
    this.b.bjg = -1;
  }
  
  private List<pkd> a(List<pkd> paramList, int paramInt, pku.c paramc)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        pkd localpkd = (pkd)paramList.next();
        if (pkb.a(localpkd, paramInt)) {
          localArrayList.add(localpkd);
        }
      }
      return a(localArrayList, paramc);
    }
    return new ArrayList(1);
  }
  
  private List<pkd> a(List<pkd> paramList, pku.c paramc)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (pkd)paramList.next();
      if (((HashMap)localObject1).containsKey(((pkd)localObject2).mAlbumName))
      {
        ((List)((HashMap)localObject1).get(((pkd)localObject2).mAlbumName)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((pkd)localObject2).mAlbumName, localArrayList1);
      }
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject4 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localArrayList1 = new ArrayList(((List)localObject4).size());
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = new ArrayList();
      if (((List)localObject4).size() == 1)
      {
        paramList.add(((List)localObject4).get(0));
      }
      else
      {
        long l2 = 2147483647L;
        long l1 = 0L;
        localObject4 = ((List)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          pkd localpkd = (pkd)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localpkd.asS)) {
            localArrayList1.add(localpkd.asS);
          }
          if ((localpkd.lU != null) && (localpkd.lU.size() > 0)) {
            localArrayList2.addAll(localpkd.lU);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localpkd.bD());
            long l3 = l2;
            if (localpkd.getStartTime() < l2) {
              l3 = localpkd.getStartTime();
            }
            l2 = l3;
            if (localpkd.getEndTime() <= l1) {
              break;
            }
            l1 = localpkd.getEndTime();
            l2 = l3;
            break;
            ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localpkd.toString() });
          }
        }
        localObject3 = new pkd(paramc.type, (List)localObject3);
        ((pkd)localObject3).mAlbumName = ((String)localObject2);
        ((pkd)localObject3).asS = localArrayList1.toString();
        ((pkd)localObject3).lU = localArrayList2;
        ((pkd)localObject3).M(l2, l1);
        ((pkd)localObject3).a(paramc);
        paramList.add(localObject3);
        ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((pkd)localObject3).toString() });
      }
    }
    return paramList;
  }
  
  private boolean a(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (paramAddressItem.poiType == 1);
  }
  
  private boolean b(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, acfp.m(2131707080)));
  }
  
  public void a(pku.c paramc)
  {
    this.jdField_a_of_type_Pku$c = paramc;
  }
  
  protected List<pkd> ah(@NonNull List<pkd.a> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (pkd.a)paramList.next();
      AddressItem localAddressItem = ((pkd.a)localObject4).b;
      if (localAddressItem == null) {
        ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((pkd.a)localObject4).asT + ((pkd.a)localObject4).mPath });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new pkd(2, (List)localObject3);
      ((pkd)localObject3).a(this.jdField_a_of_type_Pkd);
      localObject4 = new pko();
      ((pko)localObject4).c((pkd)localObject3);
      ((pko)localObject4).b(this.jdField_a_of_type_Pku$c);
      paramList.addAll(a(((pko)localObject4).bE(), 5, this.jdField_a_of_type_Pku$c));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new pkd(4, (List)localObject2);
      ((pkd)localObject2).a(this.jdField_a_of_type_Pkd);
      localObject3 = new pkp();
      ((pkp)localObject3).b(this.b);
      ((pkp)localObject3).c((pkd)localObject2);
      paramList.addAll(a(((pkp)localObject3).bE(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new pkd(3, (List)localObject1);
      ((pkd)localObject1).a(this.jdField_a_of_type_Pkd);
      localObject2 = new pkp();
      ((pkp)localObject2).b(this.c);
      ((pkp)localObject2).c((pkd)localObject1);
      paramList.addAll(a(((pkp)localObject2).bE(), 1, this.c));
    }
    return paramList;
  }
  
  public void b(pku.c paramc)
  {
    this.b = paramc;
  }
  
  public void c(pku.c paramc)
  {
    this.c = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkq
 * JD-Core Version:    0.7.0.1
 */