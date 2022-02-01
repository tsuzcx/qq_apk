import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;

public class qrv
{
  private boolean aCy;
  private boolean aFb = true;
  private String mFeedId;
  private int mType = -1;
  
  public qrv(String paramString, boolean paramBoolean)
  {
    this.mFeedId = paramString;
    this.aFb = paramBoolean;
  }
  
  public qrv(String paramString, boolean paramBoolean, int paramInt)
  {
    this.mFeedId = paramString;
    this.aFb = paramBoolean;
    this.mType = paramInt;
  }
  
  private boolean isOpen()
  {
    return (this.aFb) && ((!this.aFb) || (this.mType != 0));
  }
  
  public void tj(boolean paramBoolean)
  {
    qrv.b localb = new qrv.b();
    localb.feedId = this.mFeedId;
    localb.isOpen = this.aFb;
    if (this.mType != -1) {
      localb.type = this.mType;
    }
    ppv.a().a(localb, new qrw(this, paramBoolean));
  }
  
  public static class a
    extends plt
  {
    public boolean aFd;
    public boolean aFe;
    public boolean aFf;
    public String mFeedId;
    public int mHasLike;
    public int mLikeCount;
    public List<LikeEntry> mLikeEntryList;
    public int mType;
    
    public a(ErrorMessage paramErrorMessage, String paramString)
    {
      this.b = paramErrorMessage;
      this.mFeedId = paramString;
    }
    
    public String toString()
    {
      return "GetLikeListEvent{feedId='" + this.mFeedId + '\'' + ", isForDetail=" + this.aFd + ", mType=" + this.mType + ", mLikeCount=" + this.mLikeCount + ", mHasLike=" + this.mHasLike + ", mLikeEntryList=" + this.mLikeEntryList + '}';
    }
  }
  
  public static class b
    extends ppw<qah>
  {
    public String feedId;
    public boolean isOpen;
    public int type = -1;
    
    public ppu a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
      try
      {
        localRspFeedLikeList.mergeFrom(paramArrayOfByte);
        return new qrv.c(localRspFeedLikeList);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory:GetLikeListRequest", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
      throws QQStoryCmdHandler.IllegalUinException
    {
      qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
      localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
      if (this.isOpen) {}
      for (int i = 2;; i = 1)
      {
        localReqFeedLikeList.source.set(i);
        if (this.type != -1) {
          localReqFeedLikeList.type.set(this.type);
        }
        return localReqFeedLikeList.toByteArray();
      }
    }
    
    public String mg()
    {
      return ppf.fQ("StorySvc.feed_like_list_715");
    }
    
    public String toString()
    {
      return "GetLikeListRequest{, feedId='" + this.feedId + '\'' + ", isOpen=" + this.isOpen + ", type=" + this.type + '}';
    }
  }
  
  public static class c
    extends ppu
  {
    public int mHasLike;
    public int mLikeCount;
    public List<LikeEntry> mLikeEntryList;
    
    public c(qqstory_service.RspFeedLikeList paramRspFeedLikeList)
    {
      super();
      paramRspFeedLikeList = (qqstory_struct.FeedLikeInfo)paramRspFeedLikeList.feed_like_info.get();
      this.mLikeEntryList = a(paramRspFeedLikeList);
      this.mLikeCount = paramRspFeedLikeList.like_total_count.get();
      this.mHasLike = paramRspFeedLikeList.has_like.get();
    }
    
    public List<LikeEntry> a(qqstory_struct.FeedLikeInfo paramFeedLikeInfo)
    {
      paramFeedLikeInfo = paramFeedLikeInfo.like_list.get();
      ArrayList localArrayList1 = new ArrayList();
      ptf localptf = (ptf)psx.a(2);
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramFeedLikeInfo.size())
      {
        LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)paramFeedLikeInfo.get(i));
        if (localptf.b(localLikeEntry.unionId) == null) {
          localArrayList2.add(new QQUserUIItem.a("", localLikeEntry.unionId));
        }
        localArrayList1.add(localLikeEntry);
        i += 1;
      }
      if (!localArrayList2.isEmpty()) {
        new pxs().B(1, localArrayList2);
      }
      return localArrayList1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrv
 * JD-Core Version:    0.7.0.1
 */