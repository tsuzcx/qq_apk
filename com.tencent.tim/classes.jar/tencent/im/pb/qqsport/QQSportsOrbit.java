package tencent.im.pb.qqsport;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQSportsOrbit
{
  public static final class OrbitHeader
    extends MessageMicro<OrbitHeader>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 50, 56, 64, 72, 80 }, new String[] { "type", "startTime", "endTime", "totalTime", "distance", "kmRecords", "totalSteps", "platform", "source", "stepType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, OrbitHeader.class);
    public final PBFloatField distance = PBField.initFloat(0.0F);
    public final PBInt32Field endTime = PBField.initInt32(0);
    public final PBRepeatMessageField<QQSportsOrbit.OrbitPacePoint> kmRecords = PBField.initRepeatMessage(QQSportsOrbit.OrbitPacePoint.class);
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field startTime = PBField.initInt32(0);
    public final PBInt32Field stepType = PBField.initInt32(0);
    public final PBInt32Field totalSteps = PBField.initInt32(0);
    public final PBInt32Field totalTime = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class OrbitPacePoint
    extends MessageMicro<OrbitPacePoint>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33 }, new String[] { "km", "time", "latitude", "longitude" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D) }, OrbitPacePoint.class);
    public final PBInt32Field km = PBField.initInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBInt32Field time = PBField.initInt32(0);
  }
  
  public static final class OrbitPoint
    extends MessageMicro<OrbitPoint>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 25, 32, 45, 53, 61, 69, 72, 80, 93, 96 }, new String[] { "speed", "latitude", "longitude", "time", "latitudef", "longitudef", "timef", "speedf", "accuracy", "step", "altitude", "millisecond" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0) }, OrbitPoint.class);
    public final PBInt32Field accuracy = PBField.initInt32(0);
    public final PBFloatField altitude = PBField.initFloat(0.0F);
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBFloatField latitudef = PBField.initFloat(0.0F);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBFloatField longitudef = PBField.initFloat(0.0F);
    public final PBInt32Field millisecond = PBField.initInt32(0);
    public final PBDoubleField speed = PBField.initDouble(0.0D);
    public final PBFloatField speedf = PBField.initFloat(0.0F);
    public final PBInt32Field step = PBField.initInt32(0);
    public final PBInt32Field time = PBField.initInt32(0);
    public final PBFixed32Field timef = PBField.initFixed32(0);
  }
  
  public static final class OrbitReq
    extends MessageMicro<OrbitReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "reqHeader", "tracePath", "isOver", "num" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, OrbitReq.class);
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public QQSportsOrbit.OrbitHeader reqHeader = new QQSportsOrbit.OrbitHeader();
    public final PBRepeatMessageField<QQSportsOrbit.OrbitPoint> tracePath = PBField.initRepeatMessage(QQSportsOrbit.OrbitPoint.class);
  }
  
  public static final class OrbitRsp
    extends MessageMicro<OrbitRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "retCode", "lastNum", "isOver", "rspHeader" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, OrbitRsp.class);
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBInt32Field lastNum = PBField.initInt32(0);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public QQSportsOrbit.OrbitHeader rspHeader = new QQSportsOrbit.OrbitHeader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit
 * JD-Core Version:    0.7.0.1
 */