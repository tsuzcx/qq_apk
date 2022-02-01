import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xfh
  extends wov
{
  public List<wsy> a;
  
  public xfh(qqstory_service.RspWatchVideoBatch paramRspWatchVideoBatch)
  {
    super(paramRspWatchVideoBatch.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspWatchVideoBatch = paramRspWatchVideoBatch.succ_video_list.get();
    if (paramRspWatchVideoBatch == null) {}
    for (;;)
    {
      return;
      paramRspWatchVideoBatch = paramRspWatchVideoBatch.iterator();
      while (paramRspWatchVideoBatch.hasNext())
      {
        qqstory_service.VideoItem localVideoItem = (qqstory_service.VideoItem)paramRspWatchVideoBatch.next();
        wsy localwsy = new wsy();
        localwsy.a = localVideoItem.vid.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilList.add(localwsy);
      }
    }
  }
  
  public String toString()
  {
    return "WatchVideoBatchResponse{ errorCode=" + this.jdField_a_of_type_Int + " succList=" + this.jdField_a_of_type_JavaUtilList + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfh
 * JD-Core Version:    0.7.0.1
 */