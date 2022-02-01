import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vxe
  extends vxa
{
  public vxe(int paramInt, vxu paramvxu)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new vxz();
    ((vxz)localObject).a(paramInt);
    ((vxz)localObject).a(paramvxu);
    a((vxv)localObject);
    paramvxu = new vxy();
    localObject = ((vwv)wjs.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        vyf localvyf = (vyf)((Iterator)localObject).next();
        switch (localvyf.a)
        {
        default: 
          break;
        case 2: 
          paramvxu.a(localvyf);
          break;
        case 4: 
          paramvxu.b(localvyf);
          break;
        case 3: 
          paramvxu.c(localvyf);
        }
      }
    }
    paramvxu.a(new vyd());
    a(paramvxu);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull vxg paramvxg, int paramInt)
  {
    Object localObject = paramvxg.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((vxh)((List)localObject).get(0)).a;
      localObject = ((vxh)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        ykq.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramvxg);
        paramvxg.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramvxg.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramvxg.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramvxg.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramvxg.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramvxg.b = localAddressItem.country;
        return true;
      }
    }
    paramvxg.b = "";
    return false;
  }
  
  protected List<vxh> a()
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      vxh localvxh = (vxh)localIterator.next();
      if (localvxh.a != null) {
        localArrayList.add(localvxh);
      }
    }
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<vxg> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxe
 * JD-Core Version:    0.7.0.1
 */