import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ufi
  extends uff<ufn>
{
  private ufp a;
  private ufp b;
  private ufp c;
  
  public ufi()
  {
    int i = ((uef)urr.a(30)).a().b();
    this.jdField_a_of_type_Ufp = new ufp();
    this.jdField_a_of_type_Ufp.a = 2;
    this.jdField_a_of_type_Ufp.b = 6;
    this.jdField_a_of_type_Ufp.d = i;
    this.jdField_a_of_type_Ufp.e = (i - 1);
    this.b = new ufp();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new ufp();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<ueq> a(List<ueq> paramList, int paramInt, ufp paramufp)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ueq localueq = (ueq)paramList.next();
        if (ueo.a(localueq, paramInt)) {
          localArrayList.add(localueq);
        }
      }
      return a(localArrayList, paramufp);
    }
    return new ArrayList(1);
  }
  
  private List<ueq> a(List<ueq> paramList, ufp paramufp)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (ueq)paramList.next();
      if (((HashMap)localObject1).containsKey(((ueq)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((ueq)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((ueq)localObject2).b, localArrayList1);
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
          ueq localueq = (ueq)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localueq.d)) {
            localArrayList1.add(localueq.d);
          }
          if ((localueq.a != null) && (localueq.a.size() > 0)) {
            localArrayList2.addAll(localueq.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localueq.a());
            long l3 = l2;
            if (localueq.f() < l2) {
              l3 = localueq.f();
            }
            l2 = l3;
            if (localueq.g() <= l1) {
              break;
            }
            l1 = localueq.g();
            l2 = l3;
            break;
            wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localueq.toString() });
          }
        }
        localObject3 = new ueq(paramufp.a, (List)localObject3);
        ((ueq)localObject3).b = ((String)localObject2);
        ((ueq)localObject3).d = localArrayList1.toString();
        ((ueq)localObject3).a = localArrayList2;
        ((ueq)localObject3).a(l2, l1);
        ((ueq)localObject3).a(paramufp);
        paramList.add(localObject3);
        wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((ueq)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, alpo.a(2131705772)));
  }
  
  protected List<ueq> a(@NonNull List<uer> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (uer)paramList.next();
      AddressItem localAddressItem = ((uer)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((uer)localObject4).c + ((uer)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new ueq(2, (List)localObject3);
      ((ueq)localObject3).a(this.jdField_a_of_type_Ueq);
      localObject4 = new ufg();
      ((ufg)localObject4).a((ueq)localObject3);
      ((ufg)localObject4).a(this.jdField_a_of_type_Ufp);
      paramList.addAll(a(((ufg)localObject4).b(), 5, this.jdField_a_of_type_Ufp));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new ueq(4, (List)localObject2);
      ((ueq)localObject2).a(this.jdField_a_of_type_Ueq);
      localObject3 = new ufh();
      ((ufh)localObject3).a(this.b);
      ((ufh)localObject3).a((ueq)localObject2);
      paramList.addAll(a(((ufh)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new ueq(3, (List)localObject1);
      ((ueq)localObject1).a(this.jdField_a_of_type_Ueq);
      localObject2 = new ufh();
      ((ufh)localObject2).a(this.c);
      ((ufh)localObject2).a((ueq)localObject1);
      paramList.addAll(a(((ufh)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(ufp paramufp)
  {
    this.jdField_a_of_type_Ufp = paramufp;
  }
  
  public void b(ufp paramufp)
  {
    this.b = paramufp;
  }
  
  public void c(ufp paramufp)
  {
    this.c = paramufp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufi
 * JD-Core Version:    0.7.0.1
 */