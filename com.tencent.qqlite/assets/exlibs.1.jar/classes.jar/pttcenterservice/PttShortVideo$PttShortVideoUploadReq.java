package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$PttShortVideoUploadReq
  extends MessageMicro
{
  public static final int MSG_PTTSHORTVIDEOFILEINFO_FIELD_NUMBER = 5;
  public static final int UINT32_AGENT_TYPE_FIELD_NUMBER = 7;
  public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 4;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 6;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint64_group_code", "uint32_agent_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0) }, PttShortVideoUploadReq.class);
  public PttShortVideo.PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
  public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoUploadReq
 * JD-Core Version:    0.7.0.1
 */