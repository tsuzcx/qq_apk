import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqAddFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDelFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pqf
  extends prg
{
  public static final String auj = ppf.fQ("StorySvc.add_feed_comment");
  public static final String auk = ppf.fQ("StorySvc.del_feed_comment");
  public static final String aul = ppf.fQ("StorySvc.get_comment_list");
  protected pqj a;
  protected int bjO;
  private String mCookie;
  protected boolean mIsEnd;
  
  public pqf(pqj parampqj)
  {
    this.a = parampqj;
  }
  
  public static void a(CommentEntry paramCommentEntry, prm paramprm)
  {
    paramCommentEntry = new pqf.c(paramCommentEntry, paramprm);
    paramprm = new pqf.d(paramprm);
    pri.a().a(paramCommentEntry, paramprm);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).putOpt("vid", paramString3);
      ((JSONObject)localObject2).putOpt("feedid", paramString4);
      ((JSONObject)localObject2).putOpt("pvid", paramString5);
      ((JSONObject)localObject2).putOpt("styles", new JSONArray(paramString6));
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "addGamePKComment jsonException " + localJSONException);
      }
    }
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new pqg(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, prm paramprm)
  {
    paramString1 = new pqf.a(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramprm);
    paramString2 = new pqf.b(paramprm);
    pri.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, prm paramprm)
  {
    paramCommentEntry = new pqf.a(paramCommentEntry, paramprm);
    paramprm = new pqf.b(paramprm);
    pri.a().a(paramCommentEntry, paramprm);
  }
  
  public void bm(String paramString, int paramInt)
  {
    paramString = new pqf.e(paramString, paramInt);
    pqf.f localf = new pqf.f();
    pri.a().a(paramString, localf);
  }
  
  public void bmm()
  {
    bm(this.a.a.feedId, 0);
  }
  
  public static class a
    extends prk
  {
    long An;
    CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    prm jdField_a_of_type_Prm;
    String auq;
    int commentType;
    String content;
    String extras;
    String feedid;
    int source;
    int type;
    
    public a(CommentEntry paramCommentEntry, prm paramprm)
    {
      this(paramCommentEntry.feedId, paramCommentEntry.replierUnionId, paramCommentEntry.content, paramCommentEntry.fakeId, paramCommentEntry.pbType, paramCommentEntry.extras, paramCommentEntry.commentType, paramprm);
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    }
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, prm paramprm)
    {
      this.feedid = paramString1;
      this.auq = paramString2;
      this.content = paramString3;
      this.An = paramLong;
      this.type = paramInt1;
      this.commentType = paramInt2;
      this.extras = paramString4;
      this.jdField_a_of_type_Prm = paramprm;
      paramString1 = rar.gc("home_page-comment_suc-d1");
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramInt1 = 0;; paramInt1 = Integer.parseInt(paramString1))
      {
        this.source = paramInt1;
        return;
      }
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspAddFeedComment localRspAddFeedComment = new qqstory_service.RspAddFeedComment();
      try
      {
        localRspAddFeedComment.mergeFrom(paramArrayOfByte);
        return new pqf.b(localRspAddFeedComment, this.jdField_a_of_type_Prm);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqAddFeedComment localReqAddFeedComment = new qqstory_service.ReqAddFeedComment();
      localReqAddFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedid));
      localReqAddFeedComment.content.set(ByteStringMicro.copyFromUtf8(this.content));
      localReqAddFeedComment.fake_id.set(this.An);
      localReqAddFeedComment.source.set(this.source);
      if (!TextUtils.isEmpty(this.auq)) {
        localReqAddFeedComment.reply_union_id.set(ByteStringMicro.copyFromUtf8(this.auq));
      }
      if (this.type == 1) {
        localReqAddFeedComment.type.set(1);
      }
      for (;;)
      {
        localReqAddFeedComment.comment_type.set(this.commentType);
        if (!TextUtils.isEmpty(this.extras)) {
          localReqAddFeedComment.extras.set(ByteStringMicro.copyFromUtf8(this.extras));
        }
        return localReqAddFeedComment.toByteArray();
        localReqAddFeedComment.type.set(0);
      }
    }
    
    public String mg()
    {
      return pqf.auj;
    }
  }
  
  public static class b
    extends prl
  {
    qqstory_service.RspAddFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment;
    prm jdField_a_of_type_Prm;
    
    public b(qqstory_service.RspAddFeedComment paramRspAddFeedComment, prm paramprm)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment = paramRspAddFeedComment;
      this.jdField_a_of_type_Prm = paramprm;
    }
    
    public b(prm paramprm)
    {
      this.jdField_a_of_type_Prm = paramprm;
    }
    
    public void aJ(int paramInt, String paramString)
    {
      this.jdField_a_of_type_Prm.aJ(paramInt, paramString);
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      this.jdField_a_of_type_Prm.h(paramInt, paramBundle);
    }
    
    public void onSuccess()
    {
      this.jdField_a_of_type_Prm.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment);
    }
    
    public void q(boolean paramBoolean, Bundle paramBundle)
    {
      this.jdField_a_of_type_Prm.q(paramBoolean, paramBundle);
    }
  }
  
  public static class c
    extends prk
  {
    prm a;
    int commentId;
    String feedid;
    
    public c(CommentEntry paramCommentEntry, prm paramprm)
    {
      this.feedid = paramCommentEntry.feedId;
      this.commentId = paramCommentEntry.commentId;
      this.a = paramprm;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspDelFeedComment localRspDelFeedComment = new qqstory_service.RspDelFeedComment();
      try
      {
        localRspDelFeedComment.mergeFrom(paramArrayOfByte);
        return new pqf.d(localRspDelFeedComment, this.a);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqDelFeedComment localReqDelFeedComment = new qqstory_service.ReqDelFeedComment();
      localReqDelFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedid));
      localReqDelFeedComment.comment_id.set(this.commentId);
      return localReqDelFeedComment.toByteArray();
    }
    
    public String mg()
    {
      return pqf.auk;
    }
  }
  
  public static class d
    extends prl
  {
    qqstory_service.RspDelFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment;
    prm jdField_a_of_type_Prm;
    
    public d(qqstory_service.RspDelFeedComment paramRspDelFeedComment, prm paramprm)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment = paramRspDelFeedComment;
      this.jdField_a_of_type_Prm = paramprm;
    }
    
    public d(prm paramprm)
    {
      this.jdField_a_of_type_Prm = paramprm;
    }
    
    public void aJ(int paramInt, String paramString)
    {
      this.jdField_a_of_type_Prm.aJ(paramInt, paramString);
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      this.jdField_a_of_type_Prm.h(paramInt, paramBundle);
    }
    
    public void onSuccess()
    {
      this.jdField_a_of_type_Prm.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment);
    }
    
    public void q(boolean paramBoolean, Bundle paramBundle)
    {
      this.jdField_a_of_type_Prm.q(paramBoolean, paramBundle);
    }
  }
  
  public class e
    extends prk
  {
    public final String aul = ppf.fQ("StorySvc.get_comment_list");
    int bjQ;
    String mVid;
    
    public e(String paramString, int paramInt)
    {
      this.mVid = paramString;
      this.bjQ = paramInt;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspGetCommentList localRspGetCommentList = new qqstory_service.RspGetCommentList();
      try
      {
        localRspGetCommentList.mergeFrom(paramArrayOfByte);
        return new pqf.f(pqf.this, localRspGetCommentList);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory:GetCommentListRequest", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqGetCommentList localReqGetCommentList = new qqstory_service.ReqGetCommentList();
      localReqGetCommentList.vid.set(ByteStringMicro.copyFromUtf8(this.mVid));
      localReqGetCommentList.latest_comment_id.set(this.bjQ);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:GetCommentListRequest", 2, "getCommentListData by latest_comment_id: " + this.bjQ);
      }
      return localReqGetCommentList.toByteArray();
    }
    
    public String mg()
    {
      return this.aul;
    }
    
    public String toString()
    {
      return "GetCommentListRequest{ vid=" + this.mVid + ", startCommentID=" + this.bjQ + '}';
    }
  }
  
  public class f
    extends prl
  {
    qqstory_service.RspGetCommentList jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList;
    
    public f() {}
    
    public f(qqstory_service.RspGetCommentList paramRspGetCommentList)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList = paramRspGetCommentList;
    }
    
    public void aJ(int paramInt, String paramString)
    {
      pqf.this.a.showError();
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "ReqGetCommentList fails: " + paramInt + "|" + paramString);
      }
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      pqf.this.a.showError();
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, new Object[] { "ReqGetCommentList NetWork ErrorCode:", Integer.valueOf(paramInt) });
      }
    }
    
    public void onSuccess()
    {
      boolean bool = false;
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.comment_list.get();
      ArrayList localArrayList = new ArrayList();
      pqf.a(pqf.this, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.cookie.get().toStringUtf8());
      ptf localptf = (ptf)psx.a(2);
      int i = 0;
      if (i < ((List)localObject).size())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((List)localObject).get(i));
        QQUserUIItem localQQUserUIItem = localptf.c(localCommentEntry.authorUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable()))
        {
          localCommentEntry.authorName = qem.auW;
          label114:
          if (!TextUtils.isEmpty(localCommentEntry.replyUin))
          {
            localQQUserUIItem = localptf.c(localCommentEntry.replierUnionId);
            if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
              break label187;
            }
          }
        }
        label187:
        for (localCommentEntry.replierName = qem.auW;; localCommentEntry.replierName = localQQUserUIItem.nickName)
        {
          localArrayList.add(localCommentEntry);
          i += 1;
          break;
          localCommentEntry.authorName = localQQUserUIItem.nickName;
          break label114;
        }
      }
      localObject = pqf.this;
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.is_end.get() == 1) {
        bool = true;
      }
      ((pqf)localObject).mIsEnd = bool;
      pqf.this.bjO = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetCommentList.total_comment_num.get();
      pqf.this.a.dX(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqf
 * JD-Core Version:    0.7.0.1
 */