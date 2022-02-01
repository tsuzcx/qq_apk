import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class vxy
  extends vxv<vyd>
{
  private vyf a;
  private vyf b;
  private vyf c;
  
  public vxy()
  {
    int i = ((vwv)wjs.a(30)).a().b();
    this.jdField_a_of_type_Vyf = new vyf();
    this.jdField_a_of_type_Vyf.a = 2;
    this.jdField_a_of_type_Vyf.b = 6;
    this.jdField_a_of_type_Vyf.d = i;
    this.jdField_a_of_type_Vyf.e = (i - 1);
    this.b = new vyf();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new vyf();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<vxg> a(List<vxg> paramList, int paramInt, vyf paramvyf)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        vxg localvxg = (vxg)paramList.next();
        if (vxe.a(localvxg, paramInt)) {
          localArrayList.add(localvxg);
        }
      }
      return a(localArrayList, paramvyf);
    }
    return new ArrayList(1);
  }
  
  private List<vxg> a(List<vxg> paramList, vyf paramvyf)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (vxg)paramList.next();
      if (((HashMap)localObject1).containsKey(((vxg)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((vxg)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((vxg)localObject2).b, localArrayList1);
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
          vxg localvxg = (vxg)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localvxg.d)) {
            localArrayList1.add(localvxg.d);
          }
          if ((localvxg.a != null) && (localvxg.a.size() > 0)) {
            localArrayList2.addAll(localvxg.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localvxg.a());
            long l3 = l2;
            if (localvxg.f() < l2) {
              l3 = localvxg.f();
            }
            l2 = l3;
            if (localvxg.g() <= l1) {
              break;
            }
            l1 = localvxg.g();
            l2 = l3;
            break;
            ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localvxg.toString() });
          }
        }
        localObject3 = new vxg(paramvyf.a, (List)localObject3);
        ((vxg)localObject3).b = ((String)localObject2);
        ((vxg)localObject3).d = localArrayList1.toString();
        ((vxg)localObject3).a = localArrayList2;
        ((vxg)localObject3).a(l2, l1);
        ((vxg)localObject3).a(paramvyf);
        paramList.add(localObject3);
        ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((vxg)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, anvx.a(2131704873)));
  }
  
  protected List<vxg> a(@NonNull List<vxh> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (vxh)paramList.next();
      AddressItem localAddressItem = ((vxh)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((vxh)localObject4).c + ((vxh)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new vxg(2, (List)localObject3);
      ((vxg)localObject3).a(this.jdField_a_of_type_Vxg);
      localObject4 = new vxw();
      ((vxw)localObject4).a((vxg)localObject3);
      ((vxw)localObject4).a(this.jdField_a_of_type_Vyf);
      paramList.addAll(a(((vxw)localObject4).b(), 5, this.jdField_a_of_type_Vyf));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new vxg(4, (List)localObject2);
      ((vxg)localObject2).a(this.jdField_a_of_type_Vxg);
      localObject3 = new vxx();
      ((vxx)localObject3).a(this.b);
      ((vxx)localObject3).a((vxg)localObject2);
      paramList.addAll(a(((vxx)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new vxg(3, (List)localObject1);
      ((vxg)localObject1).a(this.jdField_a_of_type_Vxg);
      localObject2 = new vxx();
      ((vxx)localObject2).a(this.c);
      ((vxx)localObject2).a((vxg)localObject1);
      paramList.addAll(a(((vxx)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(vyf paramvyf)
  {
    this.jdField_a_of_type_Vyf = paramvyf;
  }
  
  public void b(vyf paramvyf)
  {
    this.b = paramvyf;
  }
  
  public void c(vyf paramvyf)
  {
    this.c = paramvyf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxy
 * JD-Core Version:    0.7.0.1
 */