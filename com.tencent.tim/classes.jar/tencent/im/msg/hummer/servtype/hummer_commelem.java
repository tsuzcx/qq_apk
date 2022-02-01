package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.VideoFile;

public final class hummer_commelem
{
  public static final class MsgElemInfo_servtype1
    extends MessageMicro<MsgElemInfo_servtype1>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reward_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_create_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reward_money = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reward_type_ext = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96 }, new String[] { "bytes_reward_id", "uint64_sender_uin", "uint32_pic_type", "uint32_reward_money", "bytes_url", "bytes_content", "uint32_create_timestamp", "uint32_status", "uint32_size", "uint32_video_duration", "uint64_seq", "uint32_reward_type_ext" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MsgElemInfo_servtype1.class);
    }
  }
  
  public static final class MsgElemInfo_servtype11
    extends MessageMicro<MsgElemInfo_servtype11>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_Doodle_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_Doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resMD5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField reserve_Info1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField reserve_Info2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_doodleData_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_doodle_gif_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 66 }, new String[] { "bytes_resID", "bytes_resMD5", "reserve_Info1", "reserve_Info2", "uint32_doodleData_offset", "uint32_doodle_gif_id", "bytes_Doodle_url", "bytes_Doodle_md5" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6 }, MsgElemInfo_servtype11.class);
    }
  }
  
  public static final class MsgElemInfo_servtype13
    extends MessageMicro<MsgElemInfo_servtype13>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sys_head_id", "uint32_head_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MsgElemInfo_servtype13.class);
    public final PBUInt32Field uint32_head_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_head_id = PBField.initUInt32(0);
  }
  
  public static final class MsgElemInfo_servtype14
    extends MessageMicro<MsgElemInfo_servtype14>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField reserve_Info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_id", "reserve_Info" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgElemInfo_servtype14.class);
    }
  }
  
  public static final class MsgElemInfo_servtype15
    extends MessageMicro<MsgElemInfo_servtype15>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field author = PBField.initUInt64(0L);
    public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBUInt32Field ctr_version = PBField.initUInt32(0);
    public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64 }, new String[] { "vid", "cover", "title", "summary", "createTime", "comment_content", "author", "ctr_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0) }, MsgElemInfo_servtype15.class);
    }
  }
  
  public static final class MsgElemInfo_servtype16
    extends MessageMicro<MsgElemInfo_servtype16>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ctr_version = PBField.initUInt32(0);
    public final PBBytesField doodleUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sourceActionData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sourceActionType = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sourceName = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField storyID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField thumbUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field videoHeight = PBField.initUInt32(0);
    public final PBUInt32Field videoWidth = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 90, 96 }, new String[] { "uid", "unionID", "storyID", "md5", "thumbUrl", "doodleUrl", "videoWidth", "videoHeight", "sourceName", "sourceActionType", "sourceActionData", "ctr_version" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0) }, MsgElemInfo_servtype16.class);
    }
  }
  
  public static final class MsgElemInfo_servtype18
    extends MessageMicro<MsgElemInfo_servtype18>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_listid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt64Field uint64_current_amount = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_amount = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_current_amount", "uint64_total_amount", "bytes_listid", "bytes_auth_key", "uint32_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, MsgElemInfo_servtype18.class);
    }
  }
  
  public static final class MsgElemInfo_servtype19
    extends MessageMicro<MsgElemInfo_servtype19>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_data" }, new Object[] { localByteStringMicro }, MsgElemInfo_servtype19.class);
    }
  }
  
  public static final class MsgElemInfo_servtype2
    extends MessageMicro<MsgElemInfo_servtype2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_poke_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vaspoke_minver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vaspoke_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_double_hit = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face_bubble_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_poke_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_poke_strength = PBField.initUInt32(0);
    public final PBUInt32Field uint32_poke_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vaspoke_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 64, 72, 80 }, new String[] { "uint32_poke_type", "bytes_poke_summary", "uint32_double_hit", "uint32_vaspoke_id", "bytes_vaspoke_name", "bytes_vaspoke_minver", "uint32_poke_strength", "uint32_msg_type", "uint32_face_bubble_count", "uint32_poke_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgElemInfo_servtype2.class);
    }
  }
  
  public static final class MsgElemInfo_servtype20
    extends MessageMicro<MsgElemInfo_servtype20>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_data" }, new Object[] { localByteStringMicro }, MsgElemInfo_servtype20.class);
    }
  }
  
  public static final class MsgElemInfo_servtype21
    extends MessageMicro<MsgElemInfo_servtype21>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_confessor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
    public C2CConfessContext c2c_confess_ctx = new C2CConfessContext();
    public GroupConfessContext group_confess_ctx = new GroupConfessContext();
    public GroupConfessMsg group_confess_msg = new GroupConfessMsg();
    public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sysmsg_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 64, 74, 82 }, new String[] { "uint32_topic_id", "uint64_confessor_uin", "bytes_confessor_nick", "uint32_confessor_sex", "uint32_sysmsg_flag", "c2c_confess_ctx", "bytes_topic", "uint64_confess_time", "group_confess_msg", "group_confess_ctx" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2, Long.valueOf(0L), null, null }, MsgElemInfo_servtype21.class);
    }
    
    public static final class C2CConfessContext
      extends MessageMicro<C2CConfessContext>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_confess = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_confessor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_bg_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_biz_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_confess_num = PBField.initUInt32(0);
      public final PBUInt32Field uint32_confess_to_sex = PBField.initUInt32(0);
      public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
      public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
      public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72, 80, 88, 96 }, new String[] { "uint64_confessor_uin", "uint64_confess_to_uin", "uint64_send_uin", "bytes_confessor_nick", "bytes_confess", "uint32_bg_type", "uint32_topic_id", "uint64_confess_time", "uint32_confessor_sex", "uint32_biz_type", "uint32_confess_num", "uint32_confess_to_sex" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CConfessContext.class);
      }
    }
    
    public static final class GroupConfessContext
      extends MessageMicro<GroupConfessContext>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_confess_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_confessor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_confess_to_nick_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
      public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
      public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 82 }, new String[] { "uint64_confessor_uin", "uint64_confess_to_uin", "uint64_send_uin", "uint32_confessor_sex", "bytes_confess_to_nick", "bytes_topic", "uint32_topic_id", "uint64_confess_time", "uint32_confess_to_nick_type", "bytes_confessor_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3 }, GroupConfessContext.class);
      }
    }
    
    public static final class GroupConfessItem
      extends MessageMicro<GroupConfessItem>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_confess_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_confess_to_nick_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
      public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_topic_id", "uint64_confess_to_uin", "bytes_confess_to_nick", "bytes_topic", "uint32_confess_to_nick_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, GroupConfessItem.class);
      }
    }
    
    public static final class GroupConfessMsg
      extends MessageMicro<GroupConfessMsg>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_confess_time", "uint64_confessor_uin", "uint32_confessor_sex", "uint32_sysmsg_flag", "confess_items", "uint32_total_topic_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, GroupConfessMsg.class);
      public final PBRepeatMessageField<hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem> confess_items = PBField.initRepeatMessage(hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem.class);
      public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
      public final PBUInt32Field uint32_sysmsg_flag = PBField.initUInt32(0);
      public final PBUInt32Field uint32_total_topic_count = PBField.initUInt32(0);
      public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class MsgElemInfo_servtype23
    extends MessageMicro<MsgElemInfo_servtype23>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_face_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_others = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_face_bubble_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint32_face_type", "uint32_face_bubble_count", "bytes_face_summary", "uint32_flag", "bytes_others" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, MsgElemInfo_servtype23.class);
    }
  }
  
  public static final class MsgElemInfo_servtype24
    extends MessageMicro<MsgElemInfo_servtype24>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "limit_chat_enter", "limit_chat_exit" }, new Object[] { null, null }, MsgElemInfo_servtype24.class);
    public LimitChatEnter limit_chat_enter = new LimitChatEnter();
    public LimitChatExit limit_chat_exit = new LimitChatExit();
    
    public static final class LimitChatEnter
      extends MessageMicro<LimitChatEnter>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_match_nick = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_c2c_expired_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
      public final PBUInt64Field uint64_match_ts = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_ready_ts = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58 }, new String[] { "bytes_tips_wording", "uint32_left_chat_time", "uint64_match_ts", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint64_ready_ts", "bytes_match_nick" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, LimitChatEnter.class);
      }
    }
    
    public static final class LimitChatExit
      extends MessageMicro<LimitChatExit>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_exit_method", "uint64_match_ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, LimitChatExit.class);
      public final PBUInt32Field uint32_exit_method = PBField.initUInt32(0);
      public final PBUInt64Field uint64_match_ts = PBField.initUInt64(0L);
    }
  }
  
  public static final class MsgElemInfo_servtype27
    extends MessageMicro<MsgElemInfo_servtype27>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_file" }, new Object[] { null }, MsgElemInfo_servtype27.class);
    public im_msg_body.VideoFile video_file = new im_msg_body.VideoFile();
  }
  
  public static final class MsgElemInfo_servtype29
    extends MessageMicro<MsgElemInfo_servtype29>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_luckybag_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_luckybag_msg" }, new Object[] { localByteStringMicro }, MsgElemInfo_servtype29.class);
    }
  }
  
  public static final class MsgElemInfo_servtype3
    extends MessageMicro<MsgElemInfo_servtype3>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "flash_troop_pic", "flash_c2c_pic" }, new Object[] { null, null }, MsgElemInfo_servtype3.class);
    public im_msg_body.NotOnlineImage flash_c2c_pic = new im_msg_body.NotOnlineImage();
    public im_msg_body.CustomFace flash_troop_pic = new im_msg_body.CustomFace();
  }
  
  public static final class MsgElemInfo_servtype31
    extends MessageMicro<MsgElemInfo_servtype31>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_text", "bytes_ext" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, MsgElemInfo_servtype31.class);
    }
  }
  
  public static final class MsgElemInfo_servtype33
    extends MessageMicro<MsgElemInfo_servtype33>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_compat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_index", "bytes_text", "bytes_compat", "bytes_buf" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, MsgElemInfo_servtype33.class);
    }
  }
  
  public static final class MsgElemInfo_servtype34
    extends MessageMicro<MsgElemInfo_servtype34>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField from_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public GameSession game_session = new GameSession();
    public final PBUInt32Field push_window_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "from_nickname", "push_window_flag", "game_session", "bytes_ext" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2 }, MsgElemInfo_servtype34.class);
    }
    
    public static final class GameSession
      extends MessageMicro<GameSession>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField from_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField from_role_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt64Field from_tiny_id = PBField.initUInt64(0L);
      public final PBUInt64Field game_appid = PBField.initUInt64(0L);
      public final PBBytesField to_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField to_role_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt64Field to_tiny_id = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56 }, new String[] { "from_role_id", "from_open_id", "to_role_id", "to_open_id", "game_appid", "from_tiny_id", "to_tiny_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GameSession.class);
      }
    }
  }
  
  public static final class MsgElemInfo_servtype4
    extends MessageMicro<MsgElemInfo_servtype4>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34 }, new String[] { "uint32_imsg_type", "st_story_aio_obj_msg" }, new Object[] { Integer.valueOf(0), null }, MsgElemInfo_servtype4.class);
    public hummer_commelem.StoryAioObjMsg st_story_aio_obj_msg = new hummer_commelem.StoryAioObjMsg();
    public final PBUInt32Field uint32_imsg_type = PBField.initUInt32(0);
  }
  
  public static final class MsgElemInfo_servtype5
    extends MessageMicro<MsgElemInfo_servtype5>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field author = PBField.initUInt64(0L);
    public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56 }, new String[] { "vid", "cover", "title", "summary", "createTime", "comment_content", "author" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L) }, MsgElemInfo_servtype5.class);
    }
  }
  
  public static final class MsgElemInfo_servtype8
    extends MessageMicro<MsgElemInfo_servtype8>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "wifi_deliver_gift_msg" }, new Object[] { null }, MsgElemInfo_servtype8.class);
    public im_msg_body.DeliverGiftMsg wifi_deliver_gift_msg = new im_msg_body.DeliverGiftMsg();
  }
  
  public static final class MsgElemInfo_servtype9
    extends MessageMicro<MsgElemInfo_servtype9>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_anchor_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_anchor_nickname = PBField.initString("");
    public final PBStringField str_live_title = PBField.initString("");
    public final PBUInt32Field uint32_anchor_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_anchor_status", "bytes_jump_schema", "str_anchor_nickname", "bytes_anchor_head_url", "str_live_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", localByteStringMicro2, "" }, MsgElemInfo_servtype9.class);
    }
  }
  
  public static final class StoryAioObjMsg
    extends MessageMicro<StoryAioObjMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_ui_url", "str_jmp_url" }, new Object[] { "", "" }, StoryAioObjMsg.class);
    public final PBStringField str_jmp_url = PBField.initString("");
    public final PBStringField str_ui_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem
 * JD-Core Version:    0.7.0.1
 */