package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_near_anchor
{
  public static final class GetNearAnchorListReq
    extends MessageMicro<GetNearAnchorListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48 }, new String[] { "longitude", "latitude", "start", "num", "source", "gender" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNearAnchorListReq.class);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetNearAnchorListRsp
    extends MessageMicro<GetNearAnchorListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "anchor_num", "anchor_infos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GetNearAnchorListRsp.class);
    public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
    public final PBUInt32Field anchor_num = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class GetNearAnchorReq
    extends MessageMicro<GetNearAnchorReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48, 56 }, new String[] { "longitude", "latitude", "start", "num", "source", "gender", "gender_filter" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNearAnchorReq.class);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBEnumField gender_filter = PBField.initEnum(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetNearAnchorRsp
    extends MessageMicro<GetNearAnchorRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "ret", "anchor_num", "anchor_infos", "allow_repeated", "gender_filter" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, GetNearAnchorRsp.class);
    public final PBUInt32Field allow_repeated = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
    public final PBUInt32Field anchor_num = PBField.initUInt32(0);
    public final PBEnumField gender_filter = PBField.initEnum(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class GetNearListByRoomIDReq
    extends MessageMicro<GetNearListByRoomIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48, 56 }, new String[] { "longitude", "latitude", "roomid", "num", "source", "gender", "gender_filter" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNearListByRoomIDReq.class);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBEnumField gender_filter = PBField.initEnum(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
  }
  
  public static final class GetNearListByRoomIDRsp
    extends MessageMicro<GetNearListByRoomIDRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "anchor_num", "anchor_infos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GetNearListByRoomIDRsp.class);
    public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
    public final PBUInt32Field anchor_num = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class GetNearMicroAnchorReq
    extends MessageMicro<GetNearMicroAnchorReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48 }, new String[] { "longitude", "latitude", "start", "num", "source", "gender" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNearMicroAnchorReq.class);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetNearMicroAnchorRsp
    extends MessageMicro<GetNearMicroAnchorRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "micro_infos", "micro_anchor_num" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, GetNearMicroAnchorRsp.class);
    public final PBUInt32Field micro_anchor_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_near_anchor.NearMicroAnchor> micro_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearMicroAnchor.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class GetNearPgcAnchorReq
    extends MessageMicro<GetNearPgcAnchorReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 25, 32, 40, 50, 56 }, new String[] { "longitude", "latitude", "distance_range", "start", "num", "filter", "gender" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, GetNearPgcAnchorReq.class);
    public final PBDoubleField distance_range = PBField.initDouble(0.0D);
    public ilive_feeds_near_anchor.PgcAnchorFilter filter = new ilive_feeds_near_anchor.PgcAnchorFilter();
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetNearPgcAnchorRsp
    extends MessageMicro<GetNearPgcAnchorRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "anchor_num", "anchor_infos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GetNearPgcAnchorRsp.class);
    public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
    public final PBUInt32Field anchor_num = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class NearAnchorInfo
    extends MessageMicro<NearAnchorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_type = PBField.initUInt32(0);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBDoubleField distance = PBField.initDouble(0.0D);
    public final PBUInt32Field jump_type = PBField.initUInt32(0);
    public final PBBytesField lable_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField medal_face = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pic_time = PBField.initUInt32(0);
    public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field root_roomid = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field sub_roomid = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 42, 50, 56, 66, 72, 82, 88, 96, 106, 112 }, new String[] { "uid", "root_roomid", "sub_roomid", "distance", "room_name", "cover_url", "create_time", "city", "start_time", "medal_face", "pic_time", "anchor_type", "lable_url", "jump_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0) }, NearAnchorInfo.class);
    }
  }
  
  public static final class NearMicroAnchor
    extends MessageMicro<NearMicroAnchor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32 }, new String[] { "longitude", "latitude", "uid", "roomid" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L), Integer.valueOf(0) }, NearMicroAnchor.class);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class PgcAnchorFilter
    extends MessageMicro<PgcAnchorFilter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uin2gender", "interest_bit", "constellation", "home_town", "profession" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PgcAnchorFilter.class);
    public final PBUInt32Field constellation = PBField.initUInt32(0);
    public final PBUInt32Field home_town = PBField.initUInt32(0);
    public final PBUInt32Field interest_bit = PBField.initUInt32(0);
    public final PBUInt32Field profession = PBField.initUInt32(0);
    public final PBUInt32Field uin2gender = PBField.initUInt32(0);
  }
  
  public static final class TmemOidbUserInfo
    extends MessageMicro<TmemOidbUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "interest_bit", "constellation", "home_town", "profession", "update_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TmemOidbUserInfo.class);
    public final PBUInt32Field constellation = PBField.initUInt32(0);
    public final PBUInt32Field home_town = PBField.initUInt32(0);
    public final PBUInt32Field interest_bit = PBField.initUInt32(0);
    public final PBUInt32Field profession = PBField.initUInt32(0);
    public final PBUInt32Field update_time = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor
 * JD-Core Version:    0.7.0.1
 */