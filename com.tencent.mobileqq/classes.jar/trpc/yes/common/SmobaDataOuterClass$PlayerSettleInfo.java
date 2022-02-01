package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SmobaDataOuterClass$PlayerSettleInfo
  extends MessageMicro<PlayerSettleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBUInt32Field assistcnt = PBField.initUInt32(0);
  public final PBUInt32Field curcontinuewincnt = PBField.initUInt32(0);
  public final PBUInt32Field deadcnt = PBField.initUInt32(0);
  public final PBUInt32Field destroytowercnt = PBField.initUInt32(0);
  public final PBUInt32Field ghostlevel = PBField.initUInt32(0);
  public final PBUInt32Field godlikecnt = PBField.initUInt32(0);
  public final PBUInt32Field heroid = PBField.initUInt32(0);
  public final PBUInt32Field isai = PBField.initUInt32(0);
  public final PBInt32Field ismvp = PBField.initInt32(0);
  public final PBUInt32Field killbigdragoncnt = PBField.initUInt32(0);
  public final PBUInt32Field killcnt = PBField.initUInt32(0);
  public final PBUInt32Field killdragoncnt = PBField.initUInt32(0);
  public final PBUInt32Field killmonstercnt = PBField.initUInt32(0);
  public final PBUInt32Field killsoldiercnt = PBField.initUInt32(0);
  public final PBUInt32Field multicamprank = PBField.initUInt32(0);
  public final PBInt32Field oldmvpscore = PBField.initInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBInt32Field partition = PBField.initInt32(0);
  public final PBInt32Field partner_type = PBField.initInt32(0);
  public final PBUInt32Field rampagecnt = PBField.initUInt32(0);
  public final PBUInt64Field roleid = PBField.initUInt64(0L);
  public final PBUInt32Field selfcampkillcnt = PBField.initUInt32(0);
  public final PBInt32Field serverid = PBField.initInt32(0);
  public final PBEnumField tag = PBField.initEnum(0);
  public final PBStringField tag_name = PBField.initString("");
  public final PBInt32Field total_battle_by_day = PBField.initInt32(0);
  public final PBInt32Field total_win_by_day = PBField.initInt32(0);
  public final PBUInt32Field totalbeherohurtcnt = PBField.initUInt32(0);
  public final PBUInt32Field totalbehurtcnt = PBField.initUInt32(0);
  public final PBUInt32Field totalherohurtcnt = PBField.initUInt32(0);
  public final PBUInt32Field totalhurtcnt = PBField.initUInt32(0);
  public final PBUInt32Field totalinbattlecoin = PBField.initUInt32(0);
  public final PBUInt32Field trippekillcnt = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt32Field ultrakillcnt = PBField.initUInt32(0);
  public final PBUInt32Field usedtime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 800, 808, 818, 824, 832, 840, 848, 856 }, new String[] { "serverid", "openid", "roleid", "ismvp", "killcnt", "deadcnt", "assistcnt", "heroid", "godlikecnt", "trippekillcnt", "ultrakillcnt", "rampagecnt", "destroytowercnt", "ghostlevel", "usedtime", "killsoldiercnt", "totalhurtcnt", "totalherohurtcnt", "totalbehurtcnt", "totalbeherohurtcnt", "killmonstercnt", "killdragoncnt", "killbigdragoncnt", "totalinbattlecoin", "curcontinuewincnt", "oldmvpscore", "multicamprank", "isai", "selfcampkillcnt", "tag", "uid", "tag_name", "area", "partition", "total_battle_by_day", "total_win_by_day", "partner_type" }, new Object[] { localInteger, "", Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), "", localInteger, localInteger, localInteger, localInteger, localInteger }, PlayerSettleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.PlayerSettleInfo
 * JD-Core Version:    0.7.0.1
 */