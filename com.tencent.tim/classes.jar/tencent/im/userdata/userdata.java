package tencent.im.userdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userdata
{
  public static final class FaceScore
    extends MessageMicro<FaceScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_facescore", "uint32_scored_people", "uint32_datenum", "uint32_high_score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceScore.class);
    public final PBUInt32Field uint32_datenum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_facescore = PBField.initUInt32(0);
    public final PBUInt32Field uint32_high_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scored_people = PBField.initUInt32(0);
  }
  
  public static final class FaceScoreCalc
    extends MessageMicro<FaceScoreCalc>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_datenum", "uint32_numerator", "uint32_denominator" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceScoreCalc.class);
    public final PBUInt32Field uint32_datenum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_denominator = PBField.initUInt32(0);
    public final PBUInt32Field uint32_numerator = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.userdata.userdata
 * JD-Core Version:    0.7.0.1
 */