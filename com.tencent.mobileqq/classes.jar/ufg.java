import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ufg
  extends uff<ufn>
{
  public String a(AddressItem paramAddressItem)
  {
    return "city:" + paramAddressItem.city + " district:" + paramAddressItem.district + " building:" + paramAddressItem.building;
  }
  
  protected List<ueq> a(List<uer> paramList)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (uer)paramList.next();
      Object localObject3 = ((uer)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localObject3 != null)
      {
        localObject3 = a((AddressItem)localObject3);
        if (((HashMap)localObject1).containsKey(localObject3))
        {
          ((List)((HashMap)localObject1).get(localObject3)).add(localObject2);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          ((HashMap)localObject1).put(localObject3, localArrayList);
        }
      }
      else
      {
        wsv.a("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit pic poi is null picPath=%s", ((uer)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (((List)localObject2).size() >= a().b)
      {
        localObject2 = new ueq(a().a, (List)localObject2);
        ((ueq)localObject2).a(this.a);
        ((ueq)localObject2).a(a());
        paramList.add(localObject2);
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */