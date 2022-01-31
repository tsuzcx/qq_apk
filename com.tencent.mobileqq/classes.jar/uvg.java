import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uvg
  implements uvi
{
  private String a;
  
  public uvg()
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory:DiscoverManager";
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(CardItem paramCardItem)
  {
    awgf localawgf = a().a().createEntityManager();
    localawgf.a().a();
    try
    {
      CardEntry localCardEntry1 = paramCardItem.toCardEntry();
      paramCardItem = a(localawgf, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getCardIdSelection(), new String[] { paramCardItem.cardId });
      if (paramCardItem == null) {
        return;
      }
      paramCardItem = paramCardItem.iterator();
      while (paramCardItem.hasNext())
      {
        CardEntry localCardEntry2 = (CardEntry)paramCardItem.next();
        localCardEntry2.PBData = localCardEntry1.PBData;
        localawgf.a(localCardEntry2);
        wxe.a(this.jdField_a_of_type_JavaLangString, "update db cardId=%s id=%d", localCardEntry2.cardId, Long.valueOf(localCardEntry2.getId()));
      }
    }
    finally
    {
      localawgf.a().b();
    }
    localawgf.a().b();
  }
  
  public DiscoverBannerVideoEntry a(String paramString)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), DiscoverBannerVideoEntry.class, DiscoverBannerVideoEntry.class.getSimpleName(), "bannerId=?", new String[] { paramString });
    if ((paramString != null) && (paramString.size() > 0)) {
      return (DiscoverBannerVideoEntry)paramString.get(0);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString, vhd paramvhd)
  {
    awgf localawgf = a().a().createEntityManager();
    localawgf.a().a();
    try
    {
      if (paramvhd.jdField_b_of_type_JavaUtilList.size() == paramvhd.jdField_a_of_type_JavaUtilList.size())
      {
        DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = new DiscoverBannerVideoEntry();
        localDiscoverBannerVideoEntry.bannerId = paramString;
        localDiscoverBannerVideoEntry.totalCount = paramvhd.jdField_b_of_type_Int;
        paramString = new ArrayList(paramvhd.jdField_b_of_type_JavaUtilList.size());
        int i = 0;
        while (i < paramvhd.jdField_b_of_type_JavaUtilList.size())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = new DiscoverBannerVideoEntry.BannerInfo();
          localBannerInfo.b = ((String)paramvhd.jdField_b_of_type_JavaUtilList.get(i));
          localBannerInfo.jdField_a_of_type_JavaLangString = ((String)paramvhd.jdField_a_of_type_JavaUtilList.get(i));
          paramString.add(localBannerInfo);
          i += 1;
        }
        localDiscoverBannerVideoEntry.bannerInfoList = paramString;
        localDiscoverBannerVideoEntry.nextCookie = paramvhd.jdField_a_of_type_JavaLangString;
        localawgf.b(localDiscoverBannerVideoEntry);
      }
      localawgf.a().c();
      return;
    }
    finally
    {
      localawgf.a().b();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvg
 * JD-Core Version:    0.7.0.1
 */