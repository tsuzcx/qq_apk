import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkb
  extends pjy
{
  public pkb(int paramInt, pkm parampkm)
  {
    super(2);
    this.mTag = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.aAh = false;
    Object localObject = new pkr();
    ((pkr)localObject).setInterval(paramInt);
    ((pkr)localObject).c(parampkm);
    a((pkn)localObject);
    parampkm = new pkq();
    localObject = ((pju)psx.a(30)).bA();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        pku.c localc = (pku.c)((Iterator)localObject).next();
        switch (localc.type)
        {
        default: 
          break;
        case 2: 
          parampkm.a(localc);
          break;
        case 4: 
          parampkm.b(localc);
          break;
        case 3: 
          parampkm.c(localc);
        }
      }
    }
    parampkm.b(new pku.a());
    a(parampkm);
  }
  
  private static boolean M(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull pkd parampkd, int paramInt)
  {
    Object localObject = parampkd.bD();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((pkd.a)((List)localObject).get(0)).b;
      localObject = ((pkd.a)((List)localObject).get(((List)localObject).size() - 1)).b;
      if ((localAddressItem == null) || (localObject == null))
      {
        ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + parampkd);
        parampkd.mAlbumName = "";
        return false;
      }
      if ((paramInt <= 5) && (M(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        parampkd.mAlbumName = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (M(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        parampkd.mAlbumName = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (M(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        parampkd.mAlbumName = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (M(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        parampkd.mAlbumName = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (M(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        parampkd.mAlbumName = localAddressItem.country;
        return true;
      }
    }
    parampkd.mAlbumName = "";
    return false;
  }
  
  protected List<pkd.a> bD()
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.bD().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.bD().iterator();
    while (localIterator.hasNext())
    {
      pkd.a locala = (pkd.a)localIterator.next();
      if (locala.b != null) {
        localArrayList.add(locala);
      }
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void dM(List<pkd> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkb
 * JD-Core Version:    0.7.0.1
 */