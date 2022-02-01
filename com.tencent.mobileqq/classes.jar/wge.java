import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wge
  extends wga
{
  public wge(int paramInt, wgu paramwgu)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new wgz();
    ((wgz)localObject).a(paramInt);
    ((wgz)localObject).a(paramwgu);
    a((wgv)localObject);
    paramwgu = new wgy();
    localObject = ((wfv)wth.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        whf localwhf = (whf)((Iterator)localObject).next();
        switch (localwhf.a)
        {
        default: 
          break;
        case 2: 
          paramwgu.a(localwhf);
          break;
        case 4: 
          paramwgu.b(localwhf);
          break;
        case 3: 
          paramwgu.c(localwhf);
        }
      }
    }
    paramwgu.a(new whd());
    a(paramwgu);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull wgg paramwgg, int paramInt)
  {
    Object localObject = paramwgg.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((wgh)((List)localObject).get(0)).a;
      localObject = ((wgh)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramwgg);
        paramwgg.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramwgg.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramwgg.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramwgg.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramwgg.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramwgg.b = localAddressItem.country;
        return true;
      }
    }
    paramwgg.b = "";
    return false;
  }
  
  protected List<wgh> a()
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      wgh localwgh = (wgh)localIterator.next();
      if (localwgh.a != null) {
        localArrayList.add(localwgh);
      }
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<wgg> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wge
 * JD-Core Version:    0.7.0.1
 */