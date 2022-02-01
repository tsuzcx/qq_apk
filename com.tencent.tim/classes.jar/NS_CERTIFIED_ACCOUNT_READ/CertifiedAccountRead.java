package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAioMsg;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAutoAioReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StNotice;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushSet;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.PublicAccountInfo;

public final class CertifiedAccountRead
{
  public static final class StGetAccountInfoReq
    extends MessageMicro<StGetAccountInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetAccountInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetAccountInfoRsp
    extends MessageMicro<StGetAccountInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "user", "verifyState" }, new Object[] { null, null, Integer.valueOf(0) }, StGetAccountInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
    public final PBUInt32Field verifyState = PBField.initUInt32(0);
  }
  
  public static final class StGetAioMsgListReq
    extends MessageMicro<StGetAioMsgListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "listNum" }, new Object[] { null, Integer.valueOf(0) }, StGetAioMsgListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
  }
  
  public static final class StGetAioMsgListRsp
    extends MessageMicro<StGetAioMsgListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecAioMsg", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetAioMsgListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StAioMsg> vecAioMsg = PBField.initRepeatMessage(CertifiedAccountMeta.StAioMsg.class);
  }
  
  public static final class StGetAutoAioReplyReq
    extends MessageMicro<StGetAutoAioReplyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "sceneType" }, new Object[] { null, Integer.valueOf(0) }, StGetAutoAioReplyReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field sceneType = PBField.initUInt32(0);
  }
  
  public static final class StGetAutoAioReplyRsp
    extends MessageMicro<StGetAutoAioReplyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "autoAioReply" }, new Object[] { null, null }, StGetAutoAioReplyRsp.class);
    public CertifiedAccountMeta.StAutoAioReply autoAioReply = new CertifiedAccountMeta.StAutoAioReply();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetCommentListReq
    extends MessageMicro<StGetCommentListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "userId", "feedId", "listNum", "from" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0) }, StGetCommentListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class StGetCommentListRsp
    extends MessageMicro<StGetCommentListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecComment", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetCommentListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StComment> vecComment = PBField.initRepeatMessage(CertifiedAccountMeta.StComment.class);
  }
  
  public static final class StGetFansGroupListReq
    extends MessageMicro<StGetFansGroupListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetFansGroupListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFansGroupListRsp
    extends MessageMicro<StGetFansGroupListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecGroup" }, new Object[] { null, null }, StGetFansGroupListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta.StQQGroup.class);
  }
  
  public static final class StGetFeedDetailReq
    extends MessageMicro<StGetFeedDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58 }, new String[] { "extInfo", "from", "userId", "feedId", "createTime", "adres", "adAttchInfo" }, new Object[] { null, Integer.valueOf(0), "", "", Long.valueOf(0L), localByteStringMicro, "" }, StGetFeedDetailReq.class);
    }
  }
  
  public static final class StGetFeedDetailRsp
    extends MessageMicro<StGetFeedDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo" }, new Object[] { null, "", null, null, null, Integer.valueOf(0), "" }, StGetFeedDetailRsp.class);
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBStringField detailUrl = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecRcmdFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  }
  
  public static final class StGetFeedListReq
    extends MessageMicro<StGetFeedListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 80 }, new String[] { "extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "source" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, "", Integer.valueOf(0) }, StGetFeedListReq.class);
    }
  }
  
  public static final class StGetFeedListRsp
    extends MessageMicro<StGetFeedListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "vecFeed", "isFinish", "user", "adAttchInfo" }, new Object[] { null, null, Integer.valueOf(0), null, "" }, StGetFeedListRsp.class);
    public final PBStringField adAttchInfo = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  }
  
  public static final class StGetFollowFeedsReq
    extends MessageMicro<StGetFollowFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetFollowFeedsReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFollowFeedsRsp
    extends MessageMicro<StGetFollowFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "feeds", "isFinish", "noticeCount", "messStatus" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), null }, StGetFollowFeedsRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountMeta.StMessageStatus messStatus = new CertifiedAccountMeta.StMessageStatus();
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
  }
  
  public static final class StGetFollowListReq
    extends MessageMicro<StGetFollowListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "seq", "attach_info", "count" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0) }, StGetFollowListReq.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class StGetFollowListRsp
    extends MessageMicro<StGetFollowListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "extInfo", "seq", "attach_info", "refresh", "has_next", "account_list" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, StGetFollowListRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8.PublicAccountInfo> account_list = PBField.initRepeatMessage(oidb_cmd0xcf8.PublicAccountInfo.class);
    public final PBStringField attach_info = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field has_next = PBField.initUInt32(0);
    public final PBUInt32Field refresh = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class StGetFollowRcmdReq
    extends MessageMicro<StGetFollowRcmdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetFollowRcmdReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFollowRcmdRsp
    extends MessageMicro<StGetFollowRcmdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "rcmdList" }, new Object[] { null, null }, StGetFollowRcmdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFollowRcmd> rcmdList = PBField.initRepeatMessage(CertifiedAccountMeta.StFollowRcmd.class);
  }
  
  public static final class StGetMainPageReq
    extends MessageMicro<StGetMainPageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "userId", "from" }, new Object[] { null, "", Integer.valueOf(0) }, StGetMainPageReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class StGetMainPageRsp
    extends MessageMicro<StGetMainPageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 80, 88, 98, 106, 114 }, new String[] { "extInfo", "user", "feedCount", "fansCount", "followCount", "vecFeed", "isFinish", "share", "vecGroup", "ytdFansCount", "viewTotalCount", "pushFeed", "messStatus", "jumpURLs" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, null, Long.valueOf(0L), Long.valueOf(0L), null, null, null }, StGetMainPageRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
    public final PBUInt32Field feedCount = PBField.initUInt32(0);
    public final PBUInt32Field followCount = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public CertifiedAccountRead.StMainPageJumpH5URL jumpURLs = new CertifiedAccountRead.StMainPageJumpH5URL();
    public CertifiedAccountMeta.StMessageStatus messStatus = new CertifiedAccountMeta.StMessageStatus();
    public CertifiedAccountMeta.StPushSet pushFeed = new CertifiedAccountMeta.StPushSet();
    public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
    public final PBRepeatMessageField<CertifiedAccountMeta.StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta.StQQGroup.class);
    public final PBUInt64Field viewTotalCount = PBField.initUInt64(0L);
    public final PBUInt64Field ytdFansCount = PBField.initUInt64(0L);
  }
  
  public static final class StGetMsgPageTopReq
    extends MessageMicro<StGetMsgPageTopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetMsgPageTopReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetMsgPageTopRsp
    extends MessageMicro<StGetMsgPageTopRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "noticeCount", "vecUser" }, new Object[] { null, Integer.valueOf(0), null }, StGetMsgPageTopRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta.StUser.class);
  }
  
  public static final class StGetNoticeListReq
    extends MessageMicro<StGetNoticeListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "listNum" }, new Object[] { null, Integer.valueOf(0) }, StGetNoticeListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
  }
  
  public static final class StGetNoticeListRsp
    extends MessageMicro<StGetNoticeListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecNotice", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetNoticeListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StNotice> vecNotice = PBField.initRepeatMessage(CertifiedAccountMeta.StNotice.class);
  }
  
  public static final class StGetPushListReq
    extends MessageMicro<StGetPushListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "userId", "listNum", "from" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, StGetPushListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class StGetPushListRsp
    extends MessageMicro<StGetPushListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecPushFeed", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetPushListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StPushSet> vecPushFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StPushSet.class);
  }
  
  public static final class StGetRecommendUserListReq
    extends MessageMicro<StGetRecommendUserListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listNum", "from", "userId" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, StGetRecommendUserListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class StGetRecommendUserListRsp
    extends MessageMicro<StGetRecommendUserListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "extInfo", "vecUser", "totalNum", "isFinish", "entry", "noticeCount", "expType", "vecUserWithFeed" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null }, StGetRecommendUserListRsp.class);
    public CertifiedAccountMeta.StEntry entry = new CertifiedAccountMeta.StEntry();
    public final PBUInt32Field expType = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta.StUser.class);
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecUserWithFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  }
  
  public static final class StGetSyncDataFromQzoneReq
    extends MessageMicro<StGetSyncDataFromQzoneReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetSyncDataFromQzoneReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetSyncDataFromQzoneRsp
    extends MessageMicro<StGetSyncDataFromQzoneRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "feeds", "isFinish" }, new Object[] { null, null, Integer.valueOf(0) }, StGetSyncDataFromQzoneRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
  }
  
  public static final class StMainPageJumpH5URL
    extends MessageMicro<StMainPageJumpH5URL>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pushSetURL", "pushListURL", "editPageURL" }, new Object[] { "", "", "" }, StMainPageJumpH5URL.class);
    public final PBStringField editPageURL = PBField.initString("");
    public final PBStringField pushListURL = PBField.initString("");
    public final PBStringField pushSetURL = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead
 * JD-Core Version:    0.7.0.1
 */