import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qal
  extends ppu
{
  public boolean isEnd;
  public ArrayList<VideoCollectionItem> mT = new ArrayList();
  public String nextCookie;
  public long seq;
  
  public qal(String paramString, qqstory_service.RspGroupDateVideoList paramRspGroupDateVideoList)
  {
    super(paramRspGroupDateVideoList.result);
    if (paramRspGroupDateVideoList.is_end.get() == 1) {}
    for (;;)
    {
      this.isEnd = bool;
      this.nextCookie = paramRspGroupDateVideoList.next_cookie.get().toStringUtf8();
      this.seq = paramRspGroupDateVideoList.seqno.get();
      paramRspGroupDateVideoList = paramRspGroupDateVideoList.group_node_info.get().iterator();
      while (paramRspGroupDateVideoList.hasNext())
      {
        qqstory_struct.GroupNodeInfo localGroupNodeInfo = (qqstory_struct.GroupNodeInfo)paramRspGroupDateVideoList.next();
        VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
        localVideoCollectionItem.convertFrom("Q.qqstory.shareGroup:GetDateCollectionListResponse", paramString, localGroupNodeInfo);
        this.mT.add(localVideoCollectionItem);
      }
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetShareGroupDateListResponse{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + ", isEnd=" + this.isEnd + ", nextCookie='" + this.nextCookie + '\'' + ", seq=" + this.seq + ", mCollectionItemList=" + this.mT + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qal
 * JD-Core Version:    0.7.0.1
 */