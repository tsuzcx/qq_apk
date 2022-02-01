import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class uhh
{
  public static List<uhj> a(stFriendFeed paramstFriendFeed)
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
      uhj localuhj = (uhj)localArrayList.get(localArrayList.size() - 1);
      if (!localuhj.a((stSimpleMetaFeed)localObject))
      {
        a(localuhj);
        localObject = a((stSimpleMetaFeed)localObject);
        ((uhj)localObject).a(i);
        localArrayList.add(localObject);
      }
      i += 1;
    }
    a((uhj)localArrayList.get(localArrayList.size() - 1));
    uen.a().c(localArrayList);
    return localArrayList;
  }
  
  private static uhj a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    uhj localuhj = new uhj();
    localuhj.a(paramstSimpleMetaFeed);
    return localuhj;
  }
  
  private static void a(uhj paramuhj)
  {
    paramuhj.a(uen.a().a().contains(paramuhj.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uhh
 * JD-Core Version:    0.7.0.1
 */