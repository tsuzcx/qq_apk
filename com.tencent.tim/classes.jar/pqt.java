import android.os.Bundle;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLikeFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLikeFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pqt
  extends prg
{
  public static final String aus = ppf.fQ("StorySvc.feed_like_list_715");
  public static final String aut = ppf.fQ("StorySvc.like_feed");
  protected pqu a;
  protected String mFeedId;
  private boolean mIsOpen;
  
  public pqt(pqu parampqu, boolean paramBoolean)
  {
    this.a = parampqu;
    this.mFeedId = this.a.a.feedId;
    this.mIsOpen = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    pri.a().a(new pqt.c(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new pqt.d());
  }
  
  public void ay(String paramString, boolean paramBoolean)
  {
    pri.a().a(new pqt.a(paramString, paramBoolean), new pqt.b());
  }
  
  public void bmm()
  {
    ay(this.mFeedId, this.mIsOpen);
  }
  
  public class a
    extends prk
  {
    String feedId;
    boolean isOpen;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.feedId = paramString;
      this.isOpen = paramBoolean;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
      try
      {
        localRspFeedLikeList.mergeFrom(paramArrayOfByte);
        return new pqt.b(pqt.this, localRspFeedLikeList, this.isOpen);
      }
      catch (Exception paramArrayOfByte)
      {
        ram.w("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
      localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
      if (this.isOpen) {}
      for (int i = 2;; i = 1)
      {
        localReqFeedLikeList.source.set(i);
        return localReqFeedLikeList.toByteArray();
      }
    }
    
    public String mg()
    {
      return pqt.aus;
    }
  }
  
  public class b
    extends prl
  {
    qqstory_service.RspFeedLikeList jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList;
    boolean isOpen;
    
    public b() {}
    
    public b(qqstory_service.RspFeedLikeList paramRspFeedLikeList, boolean paramBoolean)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList = paramRspFeedLikeList;
      this.isOpen = paramBoolean;
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
    
    public void aJ(int paramInt, String paramString)
    {
      pqt.this.a.showError();
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory:FeedLikeDataProvider", 2, "GetLikeListResponse fails: " + paramInt + "|" + paramString);
      }
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      pqt.this.a.showError();
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory:FeedLikeDataProvider", 2, new Object[] { "GetLikeListResponse NetWork ErrorCode:", Integer.valueOf(paramInt) });
      }
    }
    
    public void onSuccess()
    {
      qqstory_struct.FeedLikeInfo localFeedLikeInfo = (qqstory_struct.FeedLikeInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList.feed_like_info.get();
      List localList = a(localFeedLikeInfo);
      pqt.this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = localFeedLikeInfo.like_total_count.get();
      pqt.this.a.mx = localList;
      pqt.this.a.jdField_a_of_type_Psm.b(localList, pqt.this.mFeedId, this.isOpen, true);
      pqt.this.a.dX(localList);
    }
  }
  
  public static class c
    extends prk
  {
    String feedId;
    boolean isLike;
    int source;
    int type = -1;
    
    public c(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.feedId = paramString;
      this.isLike = paramBoolean;
      this.type = paramInt1;
      this.source = paramInt2;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspLikeFeed localRspLikeFeed = new qqstory_service.RspLikeFeed();
      try
      {
        localRspLikeFeed.mergeFrom(paramArrayOfByte);
        return new pqt.d(localRspLikeFeed);
      }
      catch (Exception paramArrayOfByte)
      {
        ram.w("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqLikeFeed localReqLikeFeed = new qqstory_service.ReqLikeFeed();
      localReqLikeFeed.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
      PBUInt32Field localPBUInt32Field = localReqLikeFeed.operation;
      if (this.isLike) {}
      for (int i = 1;; i = 2)
      {
        localPBUInt32Field.set(i);
        localReqLikeFeed.source.set(this.source);
        if (this.type != -1) {
          localReqLikeFeed.type.set(this.type);
        }
        return localReqLikeFeed.toByteArray();
      }
    }
    
    public String mg()
    {
      return pqt.aut;
    }
  }
  
  public static class d
    extends prl
  {
    qqstory_service.RspLikeFeed a;
    
    public d() {}
    
    public d(qqstory_service.RspLikeFeed paramRspLikeFeed)
    {
      super();
      this.a = paramRspLikeFeed;
    }
    
    public void aJ(int paramInt, String paramString) {}
    
    public void h(int paramInt, Bundle paramBundle) {}
    
    public void onSuccess() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqt
 * JD-Core Version:    0.7.0.1
 */