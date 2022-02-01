package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackRanking
{
  public static final class PkgReq
    extends MessageMicro<PkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "cmdtype", "uin", "query_ranking" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, PkgReq.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public PackRanking.QueryRankingReq query_ranking = new PackRanking.QueryRankingReq();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class PkgResp
    extends MessageMicro<PkgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public PackRanking.QueryRankingResp query_ranking = new PackRanking.QueryRankingResp();
    public final PBBytesField resp_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBBytesField retmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 82 }, new String[] { "cmdtype", "uin", "retcode", "retmsg", "resp_name", "query_ranking" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, PkgResp.class);
    }
  }
  
  public static final class QueryRankingReq
    extends MessageMicro<QueryRankingReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "flag", "num" }, new Object[] { Integer.valueOf(3), Integer.valueOf(100) }, QueryRankingReq.class);
    public final PBEnumField flag = PBField.initEnum(3);
    public final PBUInt32Field num = PBField.initUInt32(100);
  }
  
  public static final class QueryRankingResp
    extends MessageMicro<QueryRankingResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rank_swipe", "rank_combo" }, new Object[] { null, null }, QueryRankingResp.class);
    public PackRanking.RankingInfo rank_combo = new PackRanking.RankingInfo();
    public PackRanking.RankingInfo rank_swipe = new PackRanking.RankingInfo();
  }
  
  public static final class RankingElem
    extends MessageMicro<RankingElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, RankingElem.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RankingInfo
    extends MessageMicro<RankingInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uin", "ranking", "count", "elems" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, RankingInfo.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBRepeatMessageField<PackRanking.RankingElem> elems = PBField.initRepeatMessage(PackRanking.RankingElem.class);
    public final PBUInt32Field ranking = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking
 * JD-Core Version:    0.7.0.1
 */