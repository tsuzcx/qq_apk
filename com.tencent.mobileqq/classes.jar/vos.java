import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudRead.StGetFollowListRsp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class vos
{
  private final int a;
  public final List<FeedCloudMeta.StRelationInfo> a;
  public final vor a;
  
  private vos(FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList(paramStGetFollowListRsp.relationInfo.get());
    String str;
    long l;
    if (paramStGetFollowListRsp.hasNext.get() == 1)
    {
      str = paramStGetFollowListRsp.attachInfo.get();
      l = 0L;
      paramStGetFollowListRsp = paramStGetFollowListRsp.extInfo.mapInfo.get().iterator();
      while (paramStGetFollowListRsp.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramStGetFollowListRsp.next();
        if ((localEntry != null) && ("timestamp".equals(localEntry.key.get()))) {
          l = Long.parseLong(localEntry.value.get());
        }
      }
    }
    for (this.jdField_a_of_type_Vor = new vor(str, l, paramInt, null);; this.jdField_a_of_type_Vor = null)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vos
 * JD-Core Version:    0.7.0.1
 */