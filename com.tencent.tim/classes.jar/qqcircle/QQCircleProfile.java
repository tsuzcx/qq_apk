package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleProfile
{
  public static final class StBatchGetProfileReq
    extends MessageMicro<StBatchGetProfileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "userId", "infoTypes" }, new Object[] { null, "", Integer.valueOf(0) }, StBatchGetProfileReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<Integer> infoTypes = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBRepeatField<String> userId = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StBatchGetProfileRsp
    extends MessageMicro<StBatchGetProfileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userInfos" }, new Object[] { null, null }, StBatchGetProfileRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleProfile.StUserInfo> userInfos = PBField.initRepeatMessage(QQCircleProfile.StUserInfo.class);
  }
  
  public static final class StBatchVerifyQQFriendReq
    extends MessageMicro<StBatchVerifyQQFriendReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uinList" }, new Object[] { Integer.valueOf(0) }, StBatchVerifyQQFriendReq.class);
    public final PBRepeatField<Integer> uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class StBatchVerifyQQFriendRsp
    extends MessageMicro<StBatchVerifyQQFriendRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "friendInfoList" }, new Object[] { null }, StBatchVerifyQQFriendRsp.class);
    public final PBRepeatMessageField<QQCircleProfile.StQQFriendInfo> friendInfoList = PBField.initRepeatMessage(QQCircleProfile.StQQFriendInfo.class);
  }
  
  public static final class StGetMainPageProfileReq
    extends MessageMicro<StGetMainPageProfileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "userId", "bizData" }, new Object[] { null, "", localByteStringMicro }, StGetMainPageProfileReq.class);
    }
  }
  
  public static final class StGetMainPageProfileRsp
    extends MessageMicro<StGetMainPageProfileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field TempChatBtnStatus = PBField.initInt32(0);
    public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "user", "bizData", "TempChatBtnStatus" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, StGetMainPageProfileRsp.class);
    }
  }
  
  public static final class StGetQQFriendListReq
    extends MessageMicro<StGetQQFriendListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "circleUser" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, StGetQQFriendListReq.class);
    public final PBBoolField circleUser = PBField.initBool(false);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class StGetQQFriendListRsp
    extends MessageMicro<StGetQQFriendListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "friendList" }, new Object[] { Integer.valueOf(0) }, StGetQQFriendListRsp.class);
    public final PBRepeatField<Integer> friendList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class StQQFriendInfo
    extends MessageMicro<StQQFriendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "relationType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StQQFriendInfo.class);
    public final PBEnumField relationType = PBField.initEnum(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class StSingleInfo
    extends MessageMicro<StSingleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "value" }, new Object[] { Integer.valueOf(0), "" }, StSingleInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class StUserInfo
    extends MessageMicro<StUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "user", "infos" }, new Object[] { null, null }, StUserInfo.class);
    public final PBRepeatMessageField<QQCircleProfile.StSingleInfo> infos = PBField.initRepeatMessage(QQCircleProfile.StSingleInfo.class);
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleProfile
 * JD-Core Version:    0.7.0.1
 */