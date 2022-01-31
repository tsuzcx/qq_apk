import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uqx
  implements uqz
{
  private String a;
  
  public uqx()
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory:DiscoverManager";
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(CardItem paramCardItem)
  {
    awbw localawbw = a().a().createEntityManager();
    localawbw.a().a();
    try
    {
      CardEntry localCardEntry1 = paramCardItem.toCardEntry();
      paramCardItem = a(localawbw, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getCardIdSelection(), new String[] { paramCardItem.cardId });
      if (paramCardItem == null) {
        return;
      }
      paramCardItem = paramCardItem.iterator();
      while (paramCardItem.hasNext())
      {
        CardEntry localCardEntry2 = (CardEntry)paramCardItem.next();
        localCardEntry2.PBData = localCardEntry1.PBData;
        localawbw.a(localCardEntry2);
        wsv.a(this.jdField_a_of_type_JavaLangString, "update db cardId=%s id=%d", localCardEntry2.cardId, Long.valueOf(localCardEntry2.getId()));
      }
    }
    finally
    {
      localawbw.a().b();
    }
    localawbw.a().b();
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
  
  public void a(String paramString, vcu paramvcu)
  {
    awbw localawbw = a().a().createEntityManager();
    localawbw.a().a();
    try
    {
      if (paramvcu.jdField_b_of_type_JavaUtilList.size() == paramvcu.jdField_a_of_type_JavaUtilList.size())
      {
        DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = new DiscoverBannerVideoEntry();
        localDiscoverBannerVideoEntry.bannerId = paramString;
        localDiscoverBannerVideoEntry.totalCount = paramvcu.jdField_b_of_type_Int;
        paramString = new ArrayList(paramvcu.jdField_b_of_type_JavaUtilList.size());
        int i = 0;
        while (i < paramvcu.jdField_b_of_type_JavaUtilList.size())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = new DiscoverBannerVideoEntry.BannerInfo();
          localBannerInfo.b = ((String)paramvcu.jdField_b_of_type_JavaUtilList.get(i));
          localBannerInfo.jdField_a_of_type_JavaLangString = ((String)paramvcu.jdField_a_of_type_JavaUtilList.get(i));
          paramString.add(localBannerInfo);
          i += 1;
        }
        localDiscoverBannerVideoEntry.bannerInfoList = paramString;
        localDiscoverBannerVideoEntry.nextCookie = paramvcu.jdField_a_of_type_JavaLangString;
        localawbw.b(localDiscoverBannerVideoEntry);
      }
      localawbw.a().c();
      return;
    }
    finally
    {
      localawbw.a().b();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqx
 * JD-Core Version:    0.7.0.1
 */