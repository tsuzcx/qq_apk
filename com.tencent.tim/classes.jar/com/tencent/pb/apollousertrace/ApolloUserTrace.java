package com.tencent.pb.apollousertrace;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloUserTrace
{
  public static final class STClickInfo
    extends MessageMicro<STClickInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "posx", "posy", "rotx", "roty", "velx", "vely", "angularvel", "btnstate", "time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, STClickInfo.class);
    public final PBInt32Field angularvel = PBField.initInt32(0);
    public final PBUInt32Field btnstate = PBField.initUInt32(0);
    public final PBInt32Field posx = PBField.initInt32(0);
    public final PBInt32Field posy = PBField.initInt32(0);
    public final PBInt32Field rotx = PBField.initInt32(0);
    public final PBInt32Field roty = PBField.initInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBInt32Field velx = PBField.initInt32(0);
    public final PBInt32Field vely = PBField.initInt32(0);
  }
  
  public static final class STUserClickTrack
    extends MessageMicro<STUserClickTrack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "screenScale", "screenX", "screenY", "time", "list", "name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "" }, STUserClickTrack.class);
    public final PBRepeatMessageField<ApolloUserTrace.STClickInfo> list = PBField.initRepeatMessage(ApolloUserTrace.STClickInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field screenScale = PBField.initInt32(0);
    public final PBInt32Field screenX = PBField.initInt32(0);
    public final PBInt32Field screenY = PBField.initInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
  }
  
  public static final class STUserTrackReq
    extends MessageMicro<STUserTrackReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "strFrom", "gameId", "roomId", "playts", "userClick" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, STUserTrackReq.class);
    public final PBInt32Field gameId = PBField.initInt32(0);
    public final PBInt32Field playts = PBField.initInt32(0);
    public final PBUInt64Field roomId = PBField.initUInt64(0L);
    public final PBStringField strFrom = PBField.initString("");
    public ApolloUserTrace.STUserClickTrack userClick = new ApolloUserTrace.STUserClickTrack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.apollousertrace.ApolloUserTrace
 * JD-Core Version:    0.7.0.1
 */