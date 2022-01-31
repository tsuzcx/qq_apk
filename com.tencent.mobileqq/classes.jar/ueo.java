import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ueo
  extends uek
{
  public ueo(int paramInt, ufe paramufe)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new ufj();
    ((ufj)localObject).a(paramInt);
    ((ufj)localObject).a(paramufe);
    a((uff)localObject);
    paramufe = new ufi();
    localObject = ((uef)urr.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ufp localufp = (ufp)((Iterator)localObject).next();
        switch (localufp.a)
        {
        default: 
          break;
        case 2: 
          paramufe.a(localufp);
          break;
        case 4: 
          paramufe.b(localufp);
          break;
        case 3: 
          paramufe.c(localufp);
        }
      }
    }
    paramufe.a(new ufn());
    a(paramufe);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull ueq paramueq, int paramInt)
  {
    Object localObject = paramueq.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((uer)((List)localObject).get(0)).a;
      localObject = ((uer)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        wsv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramueq);
        paramueq.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramueq.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramueq.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramueq.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramueq.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramueq.b = localAddressItem.country;
        return true;
      }
    }
    paramueq.b = "";
    return false;
  }
  
  protected List<uer> a()
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      uer localuer = (uer)localIterator.next();
      if (localuer.a != null) {
        localArrayList.add(localuer);
      }
    }
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<ueq> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ueo
 * JD-Core Version:    0.7.0.1
 */