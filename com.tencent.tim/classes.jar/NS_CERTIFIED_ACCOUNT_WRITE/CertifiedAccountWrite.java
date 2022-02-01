package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAutoAioReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushSet;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountWrite
{
  public static final class StCancelPushReq
    extends MessageMicro<StCancelPushReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "pFeed" }, new Object[] { null, null }, StCancelPushReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StPushSet pFeed = new CertifiedAccountMeta.StPushSet();
  }
  
  public static final class StCancelPushRsp
    extends MessageMicro<StCancelPushRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StCancelPushRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StCreateAccountReq
    extends MessageMicro<StCreateAccountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "name", "desc", "logo", "adminqq" }, new Object[] { null, "", "", "", "" }, StCreateAccountReq.class);
    public final PBStringField adminqq = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class StCreateAccountRsp
    extends MessageMicro<StCreateAccountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StCreateAccountRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDelAioMsgReq
    extends MessageMicro<StDelAioMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecMsgId" }, new Object[] { null, "" }, StDelAioMsgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> vecMsgId = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StDelAioMsgRsp
    extends MessageMicro<StDelAioMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDelAioMsgRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDelFeedReq
    extends MessageMicro<StDelFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "feed", "from" }, new Object[] { null, null, Integer.valueOf(0) }, StDelFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
  }
  
  public static final class StDelFeedRsp
    extends MessageMicro<StDelFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDelFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDoCommentReq
    extends MessageMicro<StDoCommentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "extInfo", "commentType", "comment", "feed", "from" }, new Object[] { null, Integer.valueOf(0), null, null, Integer.valueOf(0) }, StDoCommentReq.class);
    public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
    public final PBUInt32Field commentType = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
  }
  
  public static final class StDoCommentRsp
    extends MessageMicro<StDoCommentRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "comment" }, new Object[] { null, null }, StDoCommentRsp.class);
    public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDoFollowReq
    extends MessageMicro<StDoFollowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "followType", "user" }, new Object[] { null, Integer.valueOf(0), null }, StDoFollowReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  }
  
  public static final class StDoFollowRsp
    extends MessageMicro<StDoFollowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoFollowRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDoLikeReq
    extends MessageMicro<StDoLikeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "extInfo", "likeType", "like", "feed" }, new Object[] { null, Integer.valueOf(0), null, null }, StDoLikeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public CertifiedAccountMeta.StLike like = new CertifiedAccountMeta.StLike();
    public final PBUInt32Field likeType = PBField.initUInt32(0);
  }
  
  public static final class StDoLikeRsp
    extends MessageMicro<StDoLikeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "like" }, new Object[] { null, null }, StDoLikeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StLike like = new CertifiedAccountMeta.StLike();
  }
  
  public static final class StDoReplyReq
    extends MessageMicro<StDoReplyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48 }, new String[] { "extInfo", "replyType", "reply", "comment", "feed", "from" }, new Object[] { null, Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, StDoReplyReq.class);
    public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public CertifiedAccountMeta.StReply reply = new CertifiedAccountMeta.StReply();
    public final PBUInt32Field replyType = PBField.initUInt32(0);
  }
  
  public static final class StDoReplyRsp
    extends MessageMicro<StDoReplyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "reply" }, new Object[] { null, null }, StDoReplyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StReply reply = new CertifiedAccountMeta.StReply();
  }
  
  public static final class StDoTipOffReq
    extends MessageMicro<StDoTipOffReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 56 }, new String[] { "extInfo", "reasonId", "reasonText", "tipOffType", "user", "feed", "feedbackType" }, new Object[] { null, Integer.valueOf(1), "", Integer.valueOf(0), null, null, Integer.valueOf(0) }, StDoTipOffReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBUInt32Field feedbackType = PBField.initUInt32(0);
    public final PBEnumField reasonId = PBField.initEnum(1);
    public final PBStringField reasonText = PBField.initString("");
    public final PBUInt32Field tipOffType = PBField.initUInt32(0);
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  }
  
  public static final class StDoTipOffRsp
    extends MessageMicro<StDoTipOffRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoTipOffRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StModAccountInfoReq
    extends MessageMicro<StModAccountInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "user", "modField" }, new Object[] { null, null, Integer.valueOf(0) }, StModAccountInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field modField = PBField.initUInt32(0);
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  }
  
  public static final class StModAccountInfoRsp
    extends MessageMicro<StModAccountInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StModAccountInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StModAutoAioReplyReq
    extends MessageMicro<StModAutoAioReplyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "sceneType", "modType", "autoAioReply" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StModAutoAioReplyReq.class);
    public CertifiedAccountMeta.StAutoAioReply autoAioReply = new CertifiedAccountMeta.StAutoAioReply();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field modType = PBField.initUInt32(0);
    public final PBUInt32Field sceneType = PBField.initUInt32(0);
  }
  
  public static final class StModAutoAioReplyRsp
    extends MessageMicro<StModAutoAioReplyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StModAutoAioReplyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StModifyFeedReq
    extends MessageMicro<StModifyFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "feed", "mBitmap" }, new Object[] { null, null, Long.valueOf(0L) }, StModifyFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBUInt64Field mBitmap = PBField.initUInt64(0L);
  }
  
  public static final class StModifyFeedRsp
    extends MessageMicro<StModifyFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "feed" }, new Object[] { null, null }, StModifyFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  }
  
  public static final class StPublishFeedReq
    extends MessageMicro<StPublishFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "feed" }, new Object[] { null, null }, StPublishFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  }
  
  public static final class StPublishFeedRsp
    extends MessageMicro<StPublishFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "feed" }, new Object[] { null, null }, StPublishFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  }
  
  public static final class StPushFeedReq
    extends MessageMicro<StPushFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "pFeed" }, new Object[] { null, null }, StPushFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StPushSet pFeed = new CertifiedAccountMeta.StPushSet();
  }
  
  public static final class StPushFeedRsp
    extends MessageMicro<StPushFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "pFeed", "pushFeedResult" }, new Object[] { null, null, Integer.valueOf(0) }, StPushFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StPushSet pFeed = new CertifiedAccountMeta.StPushSet();
    public final PBUInt32Field pushFeedResult = PBField.initUInt32(0);
  }
  
  public static final class StSetFansGroupListReq
    extends MessageMicro<StSetFansGroupListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecGroup" }, new Object[] { null, null }, StSetFansGroupListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta.StQQGroup.class);
  }
  
  public static final class StSetFansGroupListRsp
    extends MessageMicro<StSetFansGroupListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetFansGroupListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetSyncDataFromQzoneReq
    extends MessageMicro<StSetSyncDataFromQzoneReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "feeds" }, new Object[] { null, null }, StSetSyncDataFromQzoneReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  }
  
  public static final class StSetSyncDataFromQzoneRsp
    extends MessageMicro<StSetSyncDataFromQzoneRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetSyncDataFromQzoneRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite
 * JD-Core Version:    0.7.0.1
 */