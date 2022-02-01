import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class uhm
{
  public static List<uho> a(stFriendFeed paramstFriendFeed)
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
      uho localuho = (uho)localArrayList.get(localArrayList.size() - 1);
      if (!localuho.a((stSimpleMetaFeed)localObject))
      {
        a(localuho);
        localObject = a((stSimpleMetaFeed)localObject);
        ((uho)localObject).a(i);
        localArrayList.add(localObject);
      }
      i += 1;
    }
    a((uho)localArrayList.get(localArrayList.size() - 1));
    uep.a().c(localArrayList);
    return localArrayList;
  }
  
  private static uho a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    uho localuho = new uho();
    localuho.a(paramstSimpleMetaFeed);
    return localuho;
  }
  
  private static void a(uho paramuho)
  {
    paramuho.a(uep.a().a().contains(paramuho.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhm
 * JD-Core Version:    0.7.0.1
 */