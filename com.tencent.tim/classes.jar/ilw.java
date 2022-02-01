import android.text.TextUtils;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.av.chatroom.chatroom_sso.Msg;

public class ilw
{
  public static int STATE_SENDING = 1;
  public static int aoS = 2;
  public static int aoT = 3;
  public static int aoU = 4;
  private static long lL;
  private int aoV;
  public ChatRoomInfo b;
  public final long lN = bC();
  public long lO;
  public final String msg;
  public final long senderUin;
  public int state;
  public long time;
  
  public ilw(ChatRoomInfo paramChatRoomInfo, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    this.senderUin = paramLong1;
    this.b = paramChatRoomInfo;
    this.msg = paramString;
    this.time = paramLong2;
    this.lO = paramLong3;
    this.state = paramInt;
    if (this.state == STATE_SENDING)
    {
      paramChatRoomInfo = this.b;
      paramChatRoomInfo.aoO += 1;
    }
    this.aoV = 0;
  }
  
  private static long bC()
  {
    long l = lL + 1L;
    lL = l;
    return l;
  }
  
  public boolean a(chatroom_sso.Msg paramMsg)
  {
    if (paramMsg == null) {}
    while ((this.lO != paramMsg.msg_id.get()) || (this.senderUin != paramMsg.uin.get()) || (!TextUtils.equals(this.msg, paramMsg.msg.get()))) {
      return false;
    }
    return true;
  }
  
  public void aod()
  {
    this.aoV += 1;
  }
  
  public void kX(int paramInt)
  {
    ChatRoomInfo localChatRoomInfo;
    if (paramInt == aoT)
    {
      localChatRoomInfo = this.b;
      localChatRoomInfo.aoQ += 1;
    }
    for (;;)
    {
      if ((this.lO == -9223372036854775808L) || (this.state != aoU)) {
        this.state = paramInt;
      }
      return;
      if (paramInt == aoS)
      {
        localChatRoomInfo = this.b;
        localChatRoomInfo.aoP += 1;
      }
    }
  }
  
  public boolean tW()
  {
    return this.lO != -9223372036854775808L;
  }
  
  public boolean tX()
  {
    return (this.state == aoS) && (this.aoV < 3) && (this.lO == -9223372036854775808L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("ChatRoomMsg{senderUin: ").append(this.senderUin).append(", serverSeq: ").append(this.lO).append(", localSeq: ").append(this.lN).append(", state: ").append(this.state).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilw
 * JD-Core Version:    0.7.0.1
 */