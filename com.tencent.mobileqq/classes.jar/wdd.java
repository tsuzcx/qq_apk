import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class wdd
  extends wda<wdi>
{
  private wdk a;
  private wdk b;
  private wdk c;
  
  public wdd()
  {
    int i = ((wca)wpm.a(30)).a().b();
    this.jdField_a_of_type_Wdk = new wdk();
    this.jdField_a_of_type_Wdk.a = 2;
    this.jdField_a_of_type_Wdk.b = 6;
    this.jdField_a_of_type_Wdk.d = i;
    this.jdField_a_of_type_Wdk.e = (i - 1);
    this.b = new wdk();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new wdk();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<wcl> a(List<wcl> paramList, int paramInt, wdk paramwdk)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        wcl localwcl = (wcl)paramList.next();
        if (wcj.a(localwcl, paramInt)) {
          localArrayList.add(localwcl);
        }
      }
      return a(localArrayList, paramwdk);
    }
    return new ArrayList(1);
  }
  
  private List<wcl> a(List<wcl> paramList, wdk paramwdk)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (wcl)paramList.next();
      if (((HashMap)localObject1).containsKey(((wcl)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((wcl)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((wcl)localObject2).b, localArrayList1);
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
          wcl localwcl = (wcl)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localwcl.d)) {
            localArrayList1.add(localwcl.d);
          }
          if ((localwcl.a != null) && (localwcl.a.size() > 0)) {
            localArrayList2.addAll(localwcl.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localwcl.a());
            long l3 = l2;
            if (localwcl.f() < l2) {
              l3 = localwcl.f();
            }
            l2 = l3;
            if (localwcl.g() <= l1) {
              break;
            }
            l1 = localwcl.g();
            l2 = l3;
            break;
            yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localwcl.toString() });
          }
        }
        localObject3 = new wcl(paramwdk.a, (List)localObject3);
        ((wcl)localObject3).b = ((String)localObject2);
        ((wcl)localObject3).d = localArrayList1.toString();
        ((wcl)localObject3).a = localArrayList2;
        ((wcl)localObject3).a(l2, l1);
        ((wcl)localObject3).a(paramwdk);
        paramList.add(localObject3);
        yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((wcl)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, anni.a(2131704185)));
  }
  
  protected List<wcl> a(@NonNull List<wcm> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (wcm)paramList.next();
      AddressItem localAddressItem = ((wcm)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((wcm)localObject4).c + ((wcm)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new wcl(2, (List)localObject3);
      ((wcl)localObject3).a(this.jdField_a_of_type_Wcl);
      localObject4 = new wdb();
      ((wdb)localObject4).a((wcl)localObject3);
      ((wdb)localObject4).a(this.jdField_a_of_type_Wdk);
      paramList.addAll(a(((wdb)localObject4).b(), 5, this.jdField_a_of_type_Wdk));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new wcl(4, (List)localObject2);
      ((wcl)localObject2).a(this.jdField_a_of_type_Wcl);
      localObject3 = new wdc();
      ((wdc)localObject3).a(this.b);
      ((wdc)localObject3).a((wcl)localObject2);
      paramList.addAll(a(((wdc)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new wcl(3, (List)localObject1);
      ((wcl)localObject1).a(this.jdField_a_of_type_Wcl);
      localObject2 = new wdc();
      ((wdc)localObject2).a(this.c);
      ((wdc)localObject2).a((wcl)localObject1);
      paramList.addAll(a(((wdc)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(wdk paramwdk)
  {
    this.jdField_a_of_type_Wdk = paramwdk;
  }
  
  public void b(wdk paramwdk)
  {
    this.b = paramwdk;
  }
  
  public void c(wdk paramwdk)
  {
    this.c = paramwdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdd
 * JD-Core Version:    0.7.0.1
 */