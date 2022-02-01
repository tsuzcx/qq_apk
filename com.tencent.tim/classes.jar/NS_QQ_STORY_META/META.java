package NS_QQ_STORY_META;

import NS_COMM.COMM.BytesEntry;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META
{
  public static final class EmojiMeta
    extends MessageMicro<EmojiMeta>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "emojiType", "count", "createtime" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, EmojiMeta.class);
    public final PBUInt64Field count = PBField.initUInt64(0L);
    public final PBUInt64Field createtime = PBField.initUInt64(0L);
    public final PBEnumField emojiType = PBField.initEnum(1);
  }
  
  public static final class EmojiMetaWithUser
    extends MessageMicro<EmojiMetaWithUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "emojiMeta", "user" }, new Object[] { null, null }, EmojiMetaWithUser.class);
    public META.EmojiMeta emojiMeta = new META.EmojiMeta();
    public META.StUser user = new META.StUser();
  }
  
  public static final class OperationInfo
    extends MessageMicro<OperationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "opActionType", "opUser", "opTime" }, new Object[] { null, Integer.valueOf(1), null, Integer.valueOf(0) }, OperationInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField opActionType = PBField.initEnum(1);
    public final PBUInt32Field opTime = PBField.initUInt32(0);
    public META.StUser opUser = new META.StUser();
  }
  
  public static final class StCellComm
    extends MessageMicro<StCellComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "operateMask", "feedsAttr", "operateMask2", "feedsAttr2" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StCellComm.class);
    public final PBUInt32Field feedsAttr = PBField.initUInt32(0);
    public final PBUInt32Field feedsAttr2 = PBField.initUInt32(0);
    public final PBUInt32Field operateMask = PBField.initUInt32(0);
    public final PBUInt32Field operateMask2 = PBField.initUInt32(0);
  }
  
  public static final class StComment
    extends MessageMicro<StComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "id", "postUser", "createTime", "content", "vecAtUin", "replyCount", "vecReply" }, new Object[] { "", null, Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0), null }, StComment.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public META.StUser postUser = new META.StUser();
    public final PBUInt32Field replyCount = PBField.initUInt32(0);
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<META.StReply> vecReply = PBField.initRepeatMessage(META.StReply.class);
  }
  
  public static final class StCommonCmdAndBuf
    extends MessageMicro<StCommonCmdAndBuf>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiBuf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField cmd = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "busiBuf" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, StCommonCmdAndBuf.class);
    }
  }
  
  public static final class StEmoji
    extends MessageMicro<StEmoji>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "emojiList", "totalCount" }, new Object[] { null, Long.valueOf(0L) }, StEmoji.class);
    public final PBRepeatMessageField<META.EmojiMeta> emojiList = PBField.initRepeatMessage(META.EmojiMeta.class);
    public final PBUInt64Field totalCount = PBField.initUInt64(0L);
  }
  
  public static final class StImage
    extends MessageMicro<StImage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "url", "width", "height", "vecImageUrl", "fileId" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, "" }, StImage.class);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBRepeatMessageField<META.StImageUrl> vecImageUrl = PBField.initRepeatMessage(META.StImageUrl.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StImageUrl
    extends MessageMicro<StImageUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "levelType", "url", "width", "height" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StImageUrl.class);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StLike
    extends MessageMicro<StLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "id", "count", "status", "vecUser" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null }, StLike.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StUser> vecUser = PBField.initRepeatMessage(META.StUser.class);
  }
  
  public static final class StMusic
    extends MessageMicro<StMusic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 136, 146, 154, 162, 168, 178, 186, 194, 200 }, new String[] { "uiSongId", "strSongMid", "strSongName", "strLanguage", "iTrySize", "iTryBegin", "iTryEnd", "iPlayTime", "strPlayUrl", "iSize", "copyright", "strFormat", "strLyric", "iType", "iStartPos", "strLabel", "uiAlbumId", "strAlbumMid", "strAlbumName", "strAlbumPic", "uiSingerId", "strSingerMid", "strSingerName", "strSingerPic", "iFrom" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, StMusic.class);
    public final PBInt32Field copyright = PBField.initInt32(0);
    public final PBInt32Field iFrom = PBField.initInt32(0);
    public final PBInt32Field iPlayTime = PBField.initInt32(0);
    public final PBInt32Field iSize = PBField.initInt32(0);
    public final PBUInt64Field iStartPos = PBField.initUInt64(0L);
    public final PBInt32Field iTryBegin = PBField.initInt32(0);
    public final PBInt32Field iTryEnd = PBField.initInt32(0);
    public final PBInt32Field iTrySize = PBField.initInt32(0);
    public final PBInt32Field iType = PBField.initInt32(0);
    public final PBStringField strAlbumMid = PBField.initString("");
    public final PBStringField strAlbumName = PBField.initString("");
    public final PBStringField strAlbumPic = PBField.initString("");
    public final PBStringField strFormat = PBField.initString("");
    public final PBStringField strLabel = PBField.initString("");
    public final PBStringField strLanguage = PBField.initString("");
    public final PBStringField strLyric = PBField.initString("");
    public final PBStringField strPlayUrl = PBField.initString("");
    public final PBStringField strSingerMid = PBField.initString("");
    public final PBStringField strSingerName = PBField.initString("");
    public final PBStringField strSingerPic = PBField.initString("");
    public final PBStringField strSongMid = PBField.initString("");
    public final PBStringField strSongName = PBField.initString("");
    public final PBUInt64Field uiAlbumId = PBField.initUInt64(0L);
    public final PBUInt64Field uiSingerId = PBField.initUInt64(0L);
    public final PBUInt64Field uiSongId = PBField.initUInt64(0L);
  }
  
  public static final class StReply
    extends MessageMicro<StReply>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "id", "postUser", "createTime", "content", "targetUser", "vecAtUin" }, new Object[] { "", null, Long.valueOf(0L), "", null, Long.valueOf(0L) }, StReply.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public META.StUser postUser = new META.StUser();
    public META.StUser targetUser = new META.StUser();
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class StStoryFeed
    extends MessageMicro<StStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128 }, new String[] { "id", "desc", "postUser", "coverImage", "storyVideo", "createTime", "vecText", "likeInfo", "commentCount", "vecComment", "cellComm", "vecExtInfo", "storyMusic", "emojiInfo", "vecBytesExt", "secureHit" }, new Object[] { "", "", null, null, null, Long.valueOf(0L), "", null, Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0) }, StStoryFeed.class);
    public META.StCellComm cellComm = new META.StCellComm();
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public META.StImage coverImage = new META.StImage();
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField desc = PBField.initString("");
    public META.StEmoji emojiInfo = new META.StEmoji();
    public final PBStringField id = PBField.initString("");
    public META.StLike likeInfo = new META.StLike();
    public META.StUser postUser = new META.StUser();
    public final PBUInt32Field secureHit = PBField.initUInt32(0);
    public META.StMusic storyMusic = new META.StMusic();
    public META.StVideo storyVideo = new META.StVideo();
    public final PBRepeatMessageField<COMM.BytesEntry> vecBytesExt = PBField.initRepeatMessage(COMM.BytesEntry.class);
    public final PBRepeatMessageField<META.StComment> vecComment = PBField.initRepeatMessage(META.StComment.class);
    public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBRepeatField<String> vecText = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StUser
    extends MessageMicro<StUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uin", "nick", "icon", "total" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, StUser.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class StVideo
    extends MessageMicro<StVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 88, 98 }, new String[] { "fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", "playCount", "vecExtInfo" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null }, StVideo.class);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field playCount = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBRepeatMessageField<META.StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(META.StVideoUrl.class);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StVideoUrl
    extends MessageMicro<StVideoUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "levelType", "playUrl", "videoPrior", "videoRate", "transStatus" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StVideoUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META
 * JD-Core Version:    0.7.0.1
 */