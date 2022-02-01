import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class wgy
  extends wgv<whd>
{
  private whf a;
  private whf b;
  private whf c;
  
  public wgy()
  {
    int i = ((wfv)wth.a(30)).a().b();
    this.jdField_a_of_type_Whf = new whf();
    this.jdField_a_of_type_Whf.a = 2;
    this.jdField_a_of_type_Whf.b = 6;
    this.jdField_a_of_type_Whf.d = i;
    this.jdField_a_of_type_Whf.e = (i - 1);
    this.b = new whf();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new whf();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<wgg> a(List<wgg> paramList, int paramInt, whf paramwhf)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        wgg localwgg = (wgg)paramList.next();
        if (wge.a(localwgg, paramInt)) {
          localArrayList.add(localwgg);
        }
      }
      return a(localArrayList, paramwhf);
    }
    return new ArrayList(1);
  }
  
  private List<wgg> a(List<wgg> paramList, whf paramwhf)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (wgg)paramList.next();
      if (((HashMap)localObject1).containsKey(((wgg)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((wgg)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((wgg)localObject2).b, localArrayList1);
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
          wgg localwgg = (wgg)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localwgg.d)) {
            localArrayList1.add(localwgg.d);
          }
          if ((localwgg.a != null) && (localwgg.a.size() > 0)) {
            localArrayList2.addAll(localwgg.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localwgg.a());
            long l3 = l2;
            if (localwgg.f() < l2) {
              l3 = localwgg.f();
            }
            l2 = l3;
            if (localwgg.g() <= l1) {
              break;
            }
            l1 = localwgg.g();
            l2 = l3;
            break;
            yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localwgg.toString() });
          }
        }
        localObject3 = new wgg(paramwhf.a, (List)localObject3);
        ((wgg)localObject3).b = ((String)localObject2);
        ((wgg)localObject3).d = localArrayList1.toString();
        ((wgg)localObject3).a = localArrayList2;
        ((wgg)localObject3).a(l2, l1);
        ((wgg)localObject3).a(paramwhf);
        paramList.add(localObject3);
        yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((wgg)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, anzj.a(2131704292)));
  }
  
  protected List<wgg> a(@NonNull List<wgh> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (wgh)paramList.next();
      AddressItem localAddressItem = ((wgh)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((wgh)localObject4).c + ((wgh)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new wgg(2, (List)localObject3);
      ((wgg)localObject3).a(this.jdField_a_of_type_Wgg);
      localObject4 = new wgw();
      ((wgw)localObject4).a((wgg)localObject3);
      ((wgw)localObject4).a(this.jdField_a_of_type_Whf);
      paramList.addAll(a(((wgw)localObject4).b(), 5, this.jdField_a_of_type_Whf));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new wgg(4, (List)localObject2);
      ((wgg)localObject2).a(this.jdField_a_of_type_Wgg);
      localObject3 = new wgx();
      ((wgx)localObject3).a(this.b);
      ((wgx)localObject3).a((wgg)localObject2);
      paramList.addAll(a(((wgx)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new wgg(3, (List)localObject1);
      ((wgg)localObject1).a(this.jdField_a_of_type_Wgg);
      localObject2 = new wgx();
      ((wgx)localObject2).a(this.c);
      ((wgx)localObject2).a((wgg)localObject1);
      paramList.addAll(a(((wgx)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(whf paramwhf)
  {
    this.jdField_a_of_type_Whf = paramwhf;
  }
  
  public void b(whf paramwhf)
  {
    this.b = paramwhf;
  }
  
  public void c(whf paramwhf)
  {
    this.c = paramwhf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgy
 * JD-Core Version:    0.7.0.1
 */