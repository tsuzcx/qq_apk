import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class uod
{
  public static List<uof> a(stFriendFeed paramstFriendFeed)
  {
    if (paramstFriendFeed == null) {
      return Collections.emptyList();
    }
    paramstFriendFeed = paramstFriendFeed.friendFeeds;
    if ((paramstFriendFeed == null) || (paramstFriendFeed.size() == 0)) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a((stSimpleMetaFeed)paramstFriendFeed.get(0)));
    int i = 1;
    while (i < paramstFriendFeed.size())
    {
      Object localObject = (stSimpleMetaFeed)paramstFriendFeed.get(i);
      uof localuof = (uof)localArrayList.get(localArrayList.size() - 1);
      if (!localuof.a((stSimpleMetaFeed)localObject))
      {
        a(localuof);
        localObject = a((stSimpleMetaFeed)localObject);
        ((uof)localObject).a(i);
        localArrayList.add(localObject);
      }
      i += 1;
    }
    a((uof)localArrayList.get(localArrayList.size() - 1));
    ulf.a().c(localArrayList);
    return localArrayList;
  }
  
  private static uof a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    uof localuof = new uof();
    localuof.a(paramstSimpleMetaFeed);
    return localuof;
  }
  
  private static void a(uof paramuof)
  {
    paramuof.a(ulf.a().a().contains(paramuof.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uod
 * JD-Core Version:    0.7.0.1
 */