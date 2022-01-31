import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ujr
  extends ujo<ujw>
{
  private ujy a;
  private ujy b;
  private ujy c;
  
  public ujr()
  {
    int i = ((uio)uwa.a(30)).a().b();
    this.jdField_a_of_type_Ujy = new ujy();
    this.jdField_a_of_type_Ujy.a = 2;
    this.jdField_a_of_type_Ujy.b = 6;
    this.jdField_a_of_type_Ujy.d = i;
    this.jdField_a_of_type_Ujy.e = (i - 1);
    this.b = new ujy();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new ujy();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<uiz> a(List<uiz> paramList, int paramInt, ujy paramujy)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        uiz localuiz = (uiz)paramList.next();
        if (uix.a(localuiz, paramInt)) {
          localArrayList.add(localuiz);
        }
      }
      return a(localArrayList, paramujy);
    }
    return new ArrayList(1);
  }
  
  private List<uiz> a(List<uiz> paramList, ujy paramujy)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (uiz)paramList.next();
      if (((HashMap)localObject1).containsKey(((uiz)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((uiz)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((uiz)localObject2).b, localArrayList1);
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
          uiz localuiz = (uiz)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localuiz.d)) {
            localArrayList1.add(localuiz.d);
          }
          if ((localuiz.a != null) && (localuiz.a.size() > 0)) {
            localArrayList2.addAll(localuiz.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localuiz.a());
            long l3 = l2;
            if (localuiz.f() < l2) {
              l3 = localuiz.f();
            }
            l2 = l3;
            if (localuiz.g() <= l1) {
              break;
            }
            l1 = localuiz.g();
            l2 = l3;
            break;
            wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localuiz.toString() });
          }
        }
        localObject3 = new uiz(paramujy.a, (List)localObject3);
        ((uiz)localObject3).b = ((String)localObject2);
        ((uiz)localObject3).d = localArrayList1.toString();
        ((uiz)localObject3).a = localArrayList2;
        ((uiz)localObject3).a(l2, l1);
        ((uiz)localObject3).a(paramujy);
        paramList.add(localObject3);
        wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((uiz)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, alud.a(2131705784)));
  }
  
  protected List<uiz> a(@NonNull List<uja> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (uja)paramList.next();
      AddressItem localAddressItem = ((uja)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((uja)localObject4).c + ((uja)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new uiz(2, (List)localObject3);
      ((uiz)localObject3).a(this.jdField_a_of_type_Uiz);
      localObject4 = new ujp();
      ((ujp)localObject4).a((uiz)localObject3);
      ((ujp)localObject4).a(this.jdField_a_of_type_Ujy);
      paramList.addAll(a(((ujp)localObject4).b(), 5, this.jdField_a_of_type_Ujy));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new uiz(4, (List)localObject2);
      ((uiz)localObject2).a(this.jdField_a_of_type_Uiz);
      localObject3 = new ujq();
      ((ujq)localObject3).a(this.b);
      ((ujq)localObject3).a((uiz)localObject2);
      paramList.addAll(a(((ujq)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new uiz(3, (List)localObject1);
      ((uiz)localObject1).a(this.jdField_a_of_type_Uiz);
      localObject2 = new ujq();
      ((ujq)localObject2).a(this.c);
      ((ujq)localObject2).a((uiz)localObject1);
      paramList.addAll(a(((ujq)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(ujy paramujy)
  {
    this.jdField_a_of_type_Ujy = paramujy;
  }
  
  public void b(ujy paramujy)
  {
    this.b = paramujy;
  }
  
  public void c(ujy paramujy)
  {
    this.c = paramujy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujr
 * JD-Core Version:    0.7.0.1
 */