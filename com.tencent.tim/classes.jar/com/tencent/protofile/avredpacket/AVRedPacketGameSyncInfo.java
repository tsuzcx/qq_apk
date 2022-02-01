package com.tencent.protofile.avredpacket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AVRedPacketGameSyncInfo
{
  public static final class C2CGameInfo
    extends MessageMicro<C2CGameInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 66, 72, 80, 88, 96 }, new String[] { "key", "state", "exceptionType", "fromWho", "musicId", "money", "resultCode", "resultState", "scores", "enterType", "maxScore", "totalEmojiNum" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CGameInfo.class);
    public final PBUInt32Field enterType = PBField.initUInt32(0);
    public final PBUInt32Field exceptionType = PBField.initUInt32(0);
    public final PBUInt32Field fromWho = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field maxScore = PBField.initUInt32(0);
    public final PBStringField money = PBField.initString("");
    public final PBUInt32Field musicId = PBField.initUInt32(0);
    public final PBUInt32Field resultCode = PBField.initUInt32(0);
    public final PBStringField resultState = PBField.initString("");
    public final PBUInt32Field scores = PBField.initUInt32(0);
    public final PBEnumField state = PBField.initEnum(0);
    public final PBUInt32Field totalEmojiNum = PBField.initUInt32(0);
  }
  
  public static final class Emoji
    extends MessageMicro<Emoji>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "emojiTypeId", "startTime", "eventType", "trackNum", "id", "isBigEmoji", "fallDownDuration" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, Emoji.class);
    public final PBUInt32Field emojiTypeId = PBField.initUInt32(0);
    public final PBUInt32Field eventType = PBField.initUInt32(0);
    public final PBUInt32Field fallDownDuration = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBoolField isBigEmoji = PBField.initBool(false);
    public final PBUInt64Field startTime = PBField.initUInt64(0L);
    public final PBUInt32Field trackNum = PBField.initUInt32(0);
  }
  
  public static final class FocusInfo
    extends MessageMicro<FocusInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "id" }, new Object[] { Integer.valueOf(0) }, FocusInfo.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
  }
  
  public static final class FrameSyncInfo
    extends MessageMicro<FrameSyncInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "emojis", "focusInfo", "hitInfo", "currScores", "frameSyncGameState", "seq" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FrameSyncInfo.class);
    public final PBUInt32Field currScores = PBField.initUInt32(0);
    public final PBRepeatMessageField<AVRedPacketGameSyncInfo.Emoji> emojis = PBField.initRepeatMessage(AVRedPacketGameSyncInfo.Emoji.class);
    public AVRedPacketGameSyncInfo.FocusInfo focusInfo = new AVRedPacketGameSyncInfo.FocusInfo();
    public final PBEnumField frameSyncGameState = PBField.initEnum(0);
    public AVRedPacketGameSyncInfo.HitInfo hitInfo = new AVRedPacketGameSyncInfo.HitInfo();
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class HitInfo
    extends MessageMicro<HitInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "id", "topWordTipType", "comboCnt", "newAddScore", "startTime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, HitInfo.class);
    public final PBUInt32Field comboCnt = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt32Field newAddScore = PBField.initUInt32(0);
    public final PBUInt64Field startTime = PBField.initUInt64(0L);
    public final PBUInt32Field topWordTipType = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo
 * JD-Core Version:    0.7.0.1
 */