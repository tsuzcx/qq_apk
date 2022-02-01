package com.tencent.qqmail.popularize.businessfilter;

import androidx.annotation.Nullable;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.popularize.model.CommercialAdvertiseEnum;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AdvertiseFilter
  implements PopularizeFilter
{
  @Nullable
  private final HashMap<String, String> replacement;
  
  public AdvertiseFilter(@Nullable HashMap<String, String> paramHashMap)
  {
    this.replacement = paramHashMap;
  }
  
  private void replaceName(Popularize paramPopularize)
  {
    if (this.replacement != null)
    {
      Iterator localIterator = this.replacement.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramPopularize.updateAbstractsReplacement((String)localEntry.getKey(), (String)localEntry.getValue());
        paramPopularize.updateContentReplacement((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Popularize localPopularize = (Popularize)paramArrayList.next();
      if ((localPopularize.getType() == 9) && (!localPopularize.isStop()) && (!localPopularize.isCancel())) {
        ((ArrayList)localObject).add(localPopularize);
      }
    }
    paramArrayList = new CommFilter().filter((ArrayList)localObject).iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (Popularize)paramArrayList.next();
      if (((((Popularize)localObject).getCommercialAdvertiseType() != CommercialAdvertiseEnum.VIRTURE_MAIL) || (VirtualAdManager.getInstance().ensureVirtualAdsMailDownloaded((Popularize)localObject))) && (NativeAdsHelper.getInstance().makesureAvatarUrlDownload((Popularize)localObject)))
      {
        replaceName((Popularize)localObject);
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.AdvertiseFilter
 * JD-Core Version:    0.7.0.1
 */