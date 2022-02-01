import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qan
  extends ppu
{
  public int blF;
  public boolean isEnd;
  public ArrayList<ShareGroupCollectionItem> mW = new ArrayList();
  public String nextCookie;
  public long seqno;
  
  public qan(String paramString, qqstory_service.RspShareVideoCollectionList paramRspShareVideoCollectionList)
  {
    super(paramRspShareVideoCollectionList.result);
    this.blF = paramRspShareVideoCollectionList.total_share_group_count.get();
    this.nextCookie = paramRspShareVideoCollectionList.next_cookie.get().toStringUtf8();
    this.seqno = paramRspShareVideoCollectionList.seqno.get();
    if (paramRspShareVideoCollectionList.is_end.get() == 1) {}
    for (;;)
    {
      this.isEnd = bool;
      paramRspShareVideoCollectionList = paramRspShareVideoCollectionList.collection_list.get().iterator();
      while (paramRspShareVideoCollectionList.hasNext())
      {
        qqstory_struct.ShareGroupFeed localShareGroupFeed = (qqstory_struct.ShareGroupFeed)paramRspShareVideoCollectionList.next();
        ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem();
        localShareGroupCollectionItem.convertFrom(paramString, localShareGroupFeed);
        this.mW.add(localShareGroupCollectionItem);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qan
 * JD-Core Version:    0.7.0.1
 */