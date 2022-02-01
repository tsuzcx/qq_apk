package fudai;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_comm
{
  public static final class AudioInfo
    extends MessageMicro<AudioInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cover_info", "audio_url" }, new Object[] { null, "" }, AudioInfo.class);
    public final PBStringField audio_url = PBField.initString("");
    public fd_comm.PicInfo cover_info = new fd_comm.PicInfo();
  }
  
  public static final class AuthInfo
    extends MessageMicro<AuthInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField a8 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field city_code = PBField.initUInt32(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBStringField imei = PBField.initString("");
    public final PBStringField latitude = PBField.initString("");
    public final PBStringField longitude = PBField.initString("");
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 88, 98, 170, 178, 184 }, new String[] { "uin", "ctime", "skey", "a8", "appid", "net_type", "imei", "longitude", "latitude", "city_code" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, AuthInfo.class);
    }
  }
  
  public static final class BlessPackInfo
    extends MessageMicro<BlessPackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bless_des", "jmp_url", "bless_id" }, new Object[] { "", "", Integer.valueOf(0) }, BlessPackInfo.class);
    public final PBStringField bless_des = PBField.initString("");
    public final PBUInt32Field bless_id = PBField.initUInt32(0);
    public final PBStringField jmp_url = PBField.initString("");
  }
  
  public static final class BusiElement
    extends MessageMicro<BusiElement>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "busi_id", "biz_desc", "biz_logo", "ad_type", "pic_info", "video_info", "audio_info", "official_account_info" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(1), null, null, null, null }, BusiElement.class);
    public final PBEnumField ad_type = PBField.initEnum(1);
    public fd_comm.AudioInfo audio_info = new fd_comm.AudioInfo();
    public final PBStringField biz_desc = PBField.initString("");
    public final PBStringField biz_logo = PBField.initString("");
    public final PBUInt32Field busi_id = PBField.initUInt32(0);
    public fd_comm.OfficialAccountInfo official_account_info = new fd_comm.OfficialAccountInfo();
    public fd_comm.PicInfo pic_info = new fd_comm.PicInfo();
    public fd_comm.VideoInfo video_info = new fd_comm.VideoInfo();
  }
  
  public static final class CardPackInfo
    extends MessageMicro<CardPackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "card_id", "card_des", "jmp_url", "url_suffix" }, new Object[] { Integer.valueOf(0), "", "", "" }, CardPackInfo.class);
    public final PBStringField card_des = PBField.initString("");
    public final PBUInt32Field card_id = PBField.initUInt32(0);
    public final PBStringField jmp_url = PBField.initString("");
    public final PBStringField url_suffix = PBField.initString("");
  }
  
  public static final class FDShareMeta
    extends MessageMicro<FDShareMeta>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "target_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, FDShareMeta.class);
    public final PBUInt64Field target_id = PBField.initUInt64(0L);
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class GrabPack
    extends MessageMicro<GrabPack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "pack_type", "none_pack_desc", "monay_pack_info", "card_pack_info", "bless_pack_info" }, new Object[] { Integer.valueOf(0), "", null, null, null }, GrabPack.class);
    public fd_comm.BlessPackInfo bless_pack_info = new fd_comm.BlessPackInfo();
    public fd_comm.CardPackInfo card_pack_info = new fd_comm.CardPackInfo();
    public fd_comm.MoneyPackInfo monay_pack_info = new fd_comm.MoneyPackInfo();
    public final PBStringField none_pack_desc = PBField.initString("");
    public final PBEnumField pack_type = PBField.initEnum(0);
  }
  
  public static final class LuckCard
    extends MessageMicro<LuckCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "luck_card_type", "show_icon_tab", "icon_url", "des_type", "des" }, new Object[] { Integer.valueOf(1), Boolean.valueOf(false), "", Integer.valueOf(1), "" }, LuckCard.class);
    public final PBStringField des = PBField.initString("");
    public final PBEnumField des_type = PBField.initEnum(1);
    public final PBStringField icon_url = PBField.initString("");
    public final PBEnumField luck_card_type = PBField.initEnum(1);
    public final PBBoolField show_icon_tab = PBField.initBool(false);
  }
  
  public static final class MoneyPackInfo
    extends MessageMicro<MoneyPackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "money", "des", "money_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, MoneyPackInfo.class);
    public final PBStringField des = PBField.initString("");
    public final PBUInt32Field money = PBField.initUInt32(0);
    public final PBUInt32Field money_id = PBField.initUInt32(0);
  }
  
  public static final class OfficialAccountInfo
    extends MessageMicro<OfficialAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "official_uin", "official_nick" }, new Object[] { Long.valueOf(0L), "" }, OfficialAccountInfo.class);
    public final PBStringField official_nick = PBField.initString("");
    public final PBUInt64Field official_uin = PBField.initUInt64(0L);
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pic_url" }, new Object[] { "" }, PicInfo.class);
    public final PBStringField pic_url = PBField.initString("");
  }
  
  public static final class TxtAndUrl
    extends MessageMicro<TxtAndUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txt_des", "jmp_url" }, new Object[] { "", "" }, TxtAndUrl.class);
    public final PBStringField jmp_url = PBField.initString("");
    public final PBStringField txt_des = PBField.initString("");
  }
  
  public static final class UinProf
    extends MessageMicro<UinProf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "nick" }, new Object[] { Long.valueOf(0L), "" }, UinProf.class);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cover_info", "video_url" }, new Object[] { null, "" }, VideoInfo.class);
    public fd_comm.PicInfo cover_info = new fd_comm.PicInfo();
    public final PBStringField video_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     fudai.fd_comm
 * JD-Core Version:    0.7.0.1
 */