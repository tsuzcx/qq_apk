package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage
{
  public static final class StGetFriendCloudStorageReq
    extends MessageMicro<StGetFriendCloudStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "appid", "keyList" }, new Object[] { null, "", "" }, StGetFriendCloudStorageReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetFriendCloudStorageRsp
    extends MessageMicro<StGetFriendCloudStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "data" }, new Object[] { null, null }, StGetFriendCloudStorageRsp.class);
    public final PBRepeatMessageField<CloudStorage.StUserGameData> data = PBField.initRepeatMessage(CloudStorage.StUserGameData.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StGetGroupCloudStorageReq
    extends MessageMicro<StGetGroupCloudStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ext", "appid", "keyList", "shareTicket" }, new Object[] { null, "", "", "" }, StGetGroupCloudStorageReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField shareTicket = PBField.initString("");
  }
  
  public static final class StGetGroupCloudStorageRsp
    extends MessageMicro<StGetGroupCloudStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "data" }, new Object[] { null, null }, StGetGroupCloudStorageRsp.class);
    public final PBRepeatMessageField<CloudStorage.StUserGameData> data = PBField.initRepeatMessage(CloudStorage.StUserGameData.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StGetPotentialFriendListReq
    extends MessageMicro<StGetPotentialFriendListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "appid" }, new Object[] { null, "" }, StGetPotentialFriendListReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StGetPotentialFriendListRsp
    extends MessageMicro<StGetPotentialFriendListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "data" }, new Object[] { null, null }, StGetPotentialFriendListRsp.class);
    public final PBRepeatMessageField<CloudStorage.StUserGameData> data = PBField.initRepeatMessage(CloudStorage.StUserGameData.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StGetUserCloudStorageReq
    extends MessageMicro<StGetUserCloudStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "appid", "keyList" }, new Object[] { null, "", "" }, StGetUserCloudStorageReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetUserCloudStorageRsp
    extends MessageMicro<StGetUserCloudStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "KVDataList" }, new Object[] { null, null }, StGetUserCloudStorageRsp.class);
    public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StGetUserInteractiveStorageReq
    extends MessageMicro<StGetUserInteractiveStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "appid", "keyList" }, new Object[] { null, "", "" }, StGetUserInteractiveStorageReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetUserInteractiveStorageRsp
    extends MessageMicro<StGetUserInteractiveStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "encryptedData", "iv" }, new Object[] { null, "", "" }, StGetUserInteractiveStorageRsp.class);
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
  }
  
  public static final class StKVData
    extends MessageMicro<StKVData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, StKVData.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class StModifyFriendInteractiveStorageReq
    extends MessageMicro<StModifyFriendInteractiveStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "ext", "appid", "toUser", "shareId", "opNum", "operation", "KVDataList", "version" }, new Object[] { null, "", "", "", Integer.valueOf(0), "", null, Integer.valueOf(0) }, StModifyFriendInteractiveStorageReq.class);
    public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBInt32Field opNum = PBField.initInt32(0);
    public final PBStringField operation = PBField.initString("");
    public final PBStringField shareId = PBField.initString("");
    public final PBStringField toUser = PBField.initString("");
    public final PBInt32Field version = PBField.initInt32(0);
  }
  
  public static final class StModifyFriendInteractiveStorageRsp
    extends MessageMicro<StModifyFriendInteractiveStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "details" }, new Object[] { null, "" }, StModifyFriendInteractiveStorageRsp.class);
    public final PBStringField details = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StRemoveUserCloudStorageReq
    extends MessageMicro<StRemoveUserCloudStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "ext", "appid", "openid", "accessToken", "signature", "sigMethod", "keyList" }, new Object[] { null, "", "", "", "", "", "" }, StRemoveUserCloudStorageReq.class);
    public final PBStringField accessToken = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField sigMethod = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
  }
  
  public static final class StRemoveUserCloudStorageRsp
    extends MessageMicro<StRemoveUserCloudStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { null }, StRemoveUserCloudStorageRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StSetUserCloudStorageReq
    extends MessageMicro<StSetUserCloudStorageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "ext", "appid", "openid", "accessToken", "signature", "sigMethod", "KVDataList" }, new Object[] { null, "", "", "", "", "", null }, StSetUserCloudStorageReq.class);
    public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
    public final PBStringField accessToken = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField sigMethod = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
  }
  
  public static final class StSetUserCloudStorageRsp
    extends MessageMicro<StSetUserCloudStorageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { null }, StSetUserCloudStorageRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StUserGameData
    extends MessageMicro<StUserGameData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "avatarUrl", "nickname", "openid", "KVDataList" }, new Object[] { "", "", "", null }, StUserGameData.class);
    public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
    public final PBStringField avatarUrl = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage
 * JD-Core Version:    0.7.0.1
 */