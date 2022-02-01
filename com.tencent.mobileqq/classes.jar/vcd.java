import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class vcd
{
  public static List<vcf> a(stFriendFeed paramstFriendFeed)
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
      vcf localvcf = (vcf)localArrayList.get(localArrayList.size() - 1);
      if (!localvcf.a((stSimpleMetaFeed)localObject))
      {
        a(localvcf);
        localObject = a((stSimpleMetaFeed)localObject);
        ((vcf)localObject).a(i);
        localArrayList.add(localObject);
      }
      i += 1;
    }
    a((vcf)localArrayList.get(localArrayList.size() - 1));
    uzf.a().c(localArrayList);
    return localArrayList;
  }
  
  private static vcf a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    vcf localvcf = new vcf();
    localvcf.a(paramstSimpleMetaFeed);
    return localvcf;
  }
  
  private static void a(vcf paramvcf)
  {
    paramvcf.a(uzf.a().a().contains(paramvcf.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */