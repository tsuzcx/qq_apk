import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyj
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.feed_like_list_batch_715");
  private int mSource;
  private List<String> ne;
  
  public pyj(List<String> paramList, boolean paramBoolean)
  {
    this.ne = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.mSource = i;
      return;
    }
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchFeedLike localRspBatchFeedLike = new qqstory_service.RspBatchFeedLike();
    try
    {
      localRspBatchFeedLike.mergeFrom(paramArrayOfByte);
      return new pyj.a(localRspBatchFeedLike);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqBatchFeedLike localReqBatchFeedLike = new qqstory_service.ReqBatchFeedLike();
    List localList = ak(this.ne);
    localReqBatchFeedLike.feed_id_list.set(localList);
    localReqBatchFeedLike.source.set(this.mSource);
    return localReqBatchFeedLike.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppu
  {
    public List<pyj.b> ni = new ArrayList();
    
    public a(ErrorMessage paramErrorMessage)
    {
      super(paramErrorMessage.errorMsg);
    }
    
    public a(qqstory_service.RspBatchFeedLike paramRspBatchFeedLike)
    {
      super();
      paramRspBatchFeedLike = paramRspBatchFeedLike.feed_like_info_list.get().iterator();
      while (paramRspBatchFeedLike.hasNext())
      {
        Object localObject = (qqstory_struct.FeedLikeInfo)paramRspBatchFeedLike.next();
        pyj.b localb = new pyj.b();
        localb.feedId = ((qqstory_struct.FeedLikeInfo)localObject).feed_id.get().toStringUtf8();
        localb.blo = ((qqstory_struct.FeedLikeInfo)localObject).has_like.get();
        localb.likeCount = ((qqstory_struct.FeedLikeInfo)localObject).like_total_count.get();
        localb.nj = new ArrayList();
        localObject = ((qqstory_struct.FeedLikeInfo)localObject).like_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)((Iterator)localObject).next());
          localLikeEntry.feedId = localb.feedId;
          localb.nj.add(localLikeEntry);
        }
        this.ni.add(localb);
      }
    }
  }
  
  public static class b
  {
    public int blo;
    public String feedId;
    public int likeCount;
    public List<LikeEntry> nj;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.feedId != null) {
          return this.feedId.equals(paramObject.feedId);
        }
      } while (paramObject.feedId == null);
      return false;
    }
    
    public int hashCode()
    {
      if (this.feedId != null) {
        return this.feedId.hashCode();
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyj
 * JD-Core Version:    0.7.0.1
 */