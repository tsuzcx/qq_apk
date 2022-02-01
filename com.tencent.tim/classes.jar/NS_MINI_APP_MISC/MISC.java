package NS_MINI_APP_MISC;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MISC
{
  public static final class StAppPlayingInfo
    extends MessageMicro<StAppPlayingInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "playType", "myRank", "friendRank", "appMetaInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, StAppPlayingInfo.class);
    public INTERFACE.StApiAppInfo appMetaInfo = new INTERFACE.StApiAppInfo();
    public final PBUInt32Field friendRank = PBField.initUInt32(0);
    public final PBUInt32Field myRank = PBField.initUInt32(0);
    public final PBUInt32Field playType = PBField.initUInt32(0);
  }
  
  public static final class StGetFriendPlayListReq
    extends MessageMicro<StGetFriendPlayListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "friendUin", "pageSize", "ext" }, new Object[] { "", Integer.valueOf(0), null }, StGetFriendPlayListReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField friendUin = PBField.initString("");
    public final PBUInt32Field pageSize = PBField.initUInt32(0);
  }
  
  public static final class StGetFriendPlayListRsp
    extends MessageMicro<StGetFriendPlayListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "total", "finish", "appPlayingInfos", "moreJumpLink", "ext", "showOtherFriPlay" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), null, "", null, Boolean.valueOf(false) }, StGetFriendPlayListRsp.class);
    public final PBRepeatMessageField<MISC.StAppPlayingInfo> appPlayingInfos = PBField.initRepeatMessage(MISC.StAppPlayingInfo.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBBoolField finish = PBField.initBool(false);
    public final PBStringField moreJumpLink = PBField.initString("");
    public final PBBoolField showOtherFriPlay = PBField.initBool(false);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class StGetFriendPlayListV2Req
    extends MessageMicro<StGetFriendPlayListV2Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "friendUin", "pageSize", "ext" }, new Object[] { "", Integer.valueOf(0), null }, StGetFriendPlayListV2Req.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField friendUin = PBField.initString("");
    public final PBUInt32Field pageSize = PBField.initUInt32(0);
  }
  
  public static final class StGetFriendPlayListV2Rsp
    extends MessageMicro<StGetFriendPlayListV2Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "total", "finish", "appPlayingInfos", "moreJumpLink", "ext", "showOtherFriPlay" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), null, "", null, Boolean.valueOf(false) }, StGetFriendPlayListV2Rsp.class);
    public final PBRepeatMessageField<MISC.StAppPlayingInfo> appPlayingInfos = PBField.initRepeatMessage(MISC.StAppPlayingInfo.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBBoolField finish = PBField.initBool(false);
    public final PBStringField moreJumpLink = PBField.initString("");
    public final PBBoolField showOtherFriPlay = PBField.initBool(false);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class StTrans4RoomidReq
    extends MessageMicro<StTrans4RoomidReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "groupid" }, new Object[] { "", "" }, StTrans4RoomidReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField groupid = PBField.initString("");
  }
  
  public static final class StTrans4RoomidRsp
    extends MessageMicro<StTrans4RoomidRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "roomid", "openid", "tinyid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, StTrans4RoomidRsp.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC
 * JD-Core Version:    0.7.0.1
 */