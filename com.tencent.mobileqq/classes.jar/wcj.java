import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wcj
  extends wcf
{
  public wcj(int paramInt, wcz paramwcz)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new wde();
    ((wde)localObject).a(paramInt);
    ((wde)localObject).a(paramwcz);
    a((wda)localObject);
    paramwcz = new wdd();
    localObject = ((wca)wpm.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wdk localwdk = (wdk)((Iterator)localObject).next();
        switch (localwdk.a)
        {
        default: 
          break;
        case 2: 
          paramwcz.a(localwdk);
          break;
        case 4: 
          paramwcz.b(localwdk);
          break;
        case 3: 
          paramwcz.c(localwdk);
        }
      }
    }
    paramwcz.a(new wdi());
    a(paramwcz);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull wcl paramwcl, int paramInt)
  {
    Object localObject = paramwcl.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((wcm)((List)localObject).get(0)).a;
      localObject = ((wcm)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        yqp.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramwcl);
        paramwcl.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramwcl.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramwcl.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramwcl.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramwcl.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramwcl.b = localAddressItem.country;
        return true;
      }
    }
    paramwcl.b = "";
    return false;
  }
  
  protected List<wcm> a()
  {
    yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      wcm localwcm = (wcm)localIterator.next();
      if (localwcm.a != null) {
        localArrayList.add(localwcm);
      }
    }
    yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<wcl> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcj
 * JD-Core Version:    0.7.0.1
 */