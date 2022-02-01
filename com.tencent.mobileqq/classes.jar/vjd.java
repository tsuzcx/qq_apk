import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class vjd
  extends vja<vji>
{
  private vjk a;
  private vjk b;
  private vjk c;
  
  public vjd()
  {
    int i = ((via)vux.a(30)).a().b();
    this.jdField_a_of_type_Vjk = new vjk();
    this.jdField_a_of_type_Vjk.a = 2;
    this.jdField_a_of_type_Vjk.b = 6;
    this.jdField_a_of_type_Vjk.d = i;
    this.jdField_a_of_type_Vjk.e = (i - 1);
    this.b = new vjk();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new vjk();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<vil> a(List<vil> paramList, int paramInt, vjk paramvjk)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        vil localvil = (vil)paramList.next();
        if (vij.a(localvil, paramInt)) {
          localArrayList.add(localvil);
        }
      }
      return a(localArrayList, paramvjk);
    }
    return new ArrayList(1);
  }
  
  private List<vil> a(List<vil> paramList, vjk paramvjk)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (vil)paramList.next();
      if (((HashMap)localObject1).containsKey(((vil)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((vil)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((vil)localObject2).b, localArrayList1);
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
          vil localvil = (vil)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localvil.d)) {
            localArrayList1.add(localvil.d);
          }
          if ((localvil.a != null) && (localvil.a.size() > 0)) {
            localArrayList2.addAll(localvil.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localvil.a());
            long l3 = l2;
            if (localvil.f() < l2) {
              l3 = localvil.f();
            }
            l2 = l3;
            if (localvil.g() <= l1) {
              break;
            }
            l1 = localvil.g();
            l2 = l3;
            break;
            xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localvil.toString() });
          }
        }
        localObject3 = new vil(paramvjk.a, (List)localObject3);
        ((vil)localObject3).b = ((String)localObject2);
        ((vil)localObject3).d = localArrayList1.toString();
        ((vil)localObject3).a = localArrayList2;
        ((vil)localObject3).a(l2, l1);
        ((vil)localObject3).a(paramvjk);
        paramList.add(localObject3);
        xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((vil)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, amtj.a(2131704522)));
  }
  
  protected List<vil> a(@NonNull List<vim> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (vim)paramList.next();
      AddressItem localAddressItem = ((vim)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((vim)localObject4).c + ((vim)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new vil(2, (List)localObject3);
      ((vil)localObject3).a(this.jdField_a_of_type_Vil);
      localObject4 = new vjb();
      ((vjb)localObject4).a((vil)localObject3);
      ((vjb)localObject4).a(this.jdField_a_of_type_Vjk);
      paramList.addAll(a(((vjb)localObject4).b(), 5, this.jdField_a_of_type_Vjk));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new vil(4, (List)localObject2);
      ((vil)localObject2).a(this.jdField_a_of_type_Vil);
      localObject3 = new vjc();
      ((vjc)localObject3).a(this.b);
      ((vjc)localObject3).a((vil)localObject2);
      paramList.addAll(a(((vjc)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new vil(3, (List)localObject1);
      ((vil)localObject1).a(this.jdField_a_of_type_Vil);
      localObject2 = new vjc();
      ((vjc)localObject2).a(this.c);
      ((vjc)localObject2).a((vil)localObject1);
      paramList.addAll(a(((vjc)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(vjk paramvjk)
  {
    this.jdField_a_of_type_Vjk = paramvjk;
  }
  
  public void b(vjk paramvjk)
  {
    this.b = paramvjk;
  }
  
  public void c(vjk paramvjk)
  {
    this.c = paramvjk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjd
 * JD-Core Version:    0.7.0.1
 */