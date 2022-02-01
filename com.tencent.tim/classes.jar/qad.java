import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qad
  extends ppu
{
  public int aEs;
  public int blD = -1;
  public boolean isEnd;
  public ArrayList<VideoCollectionItem> mT = new ArrayList();
  public String nextCookie;
  public long seq;
  
  public qad(String paramString, qqstory_service.RspDateVideoCollectionList paramRspDateVideoCollectionList)
  {
    super(paramRspDateVideoCollectionList.result);
    if (paramRspDateVideoCollectionList.is_end.get() == 1) {}
    for (;;)
    {
      this.isEnd = bool;
      this.nextCookie = paramRspDateVideoCollectionList.next_cookie.get().toStringUtf8();
      this.aEs = paramRspDateVideoCollectionList.total_video_count.get();
      this.seq = paramRspDateVideoCollectionList.seqno.get();
      this.blD = paramRspDateVideoCollectionList.is_friend.get();
      paramRspDateVideoCollectionList = paramRspDateVideoCollectionList.collection_list.get().iterator();
      while (paramRspDateVideoCollectionList.hasNext())
      {
        qqstory_struct.DateVideoCollection localDateVideoCollection = (qqstory_struct.DateVideoCollection)paramRspDateVideoCollectionList.next();
        VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
        localVideoCollectionItem.convertFrom("Q.qqstory.memories:GetDateCollectionListResponse", paramString, localDateVideoCollection);
        this.mT.add(localVideoCollectionItem);
      }
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetDateCollectionListResponse{isEnd=" + this.isEnd + ", nextCookie='" + this.nextCookie + '\'' + ", seq=" + this.seq + ", mTotalVideoCount=" + this.aEs + ", mIsFriend=" + this.blD + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qad
 * JD-Core Version:    0.7.0.1
 */