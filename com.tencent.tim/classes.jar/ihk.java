import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.longconn.hd_video.CmdS2CInviteReqBody;
import tencent.im.cs.longconn.hd_video.InviteTempSessionData;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.VideoHead;

public class ihk
{
  public static int a(short paramShort)
  {
    return 0xFFFF & paramShort;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    paramInt -= 1;
    for (;;)
    {
      l2 = l1;
      if (paramInt < 0) {
        break;
      }
      l2 = paramArrayOfByte[paramInt];
      int i = paramInt - 1;
      l1 = (l2 & 0xFF) << paramInt * 8 | l1;
      paramInt = i;
    }
  }
  
  public static ihk.a a(byte[] paramArrayOfByte)
  {
    ihk.a locala = new ihk.a();
    Object localObject = new hd_video.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (hd_video.MsgBody)((hd_video.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.msg_video_head.has())
        {
          localObject = (hd_video.VideoHead)paramArrayOfByte.msg_video_head.get();
          locala.MC = ((hd_video.VideoHead)localObject).str_from_mobile.get();
          locala.MD = ((hd_video.VideoHead)localObject).str_from_nation.get();
          locala.alZ = ((hd_video.VideoHead)localObject).enum_body_type.get();
          locala.uin = ((hd_video.VideoHead)localObject).uint64_uin.get();
          if (((hd_video.VideoHead)localObject).int32_sub_service_type.has())
          {
            i = ((hd_video.VideoHead)localObject).int32_sub_service_type.get();
            locala.ama = i;
            locala.seq = ((hd_video.VideoHead)localObject).uint32_seq.get();
            locala.roomId = ((hd_video.VideoHead)localObject).uint64_room_id.get();
            if (paramArrayOfByte.msg_invite_body.has())
            {
              paramArrayOfByte = (hd_video.CmdS2CInviteReqBody)paramArrayOfByte.msg_invite_body.get();
              locala.kY = paramArrayOfByte.uint64_from_uin.get();
              locala.amb = paramArrayOfByte.uint32_new_business_flag.get();
              locala.Pr = paramArrayOfByte.bool_terminal_switch_flag.get();
              if (paramArrayOfByte.msg_temp_session.has())
              {
                paramArrayOfByte = paramArrayOfByte.msg_temp_session;
                locala.la = paramArrayOfByte.uint64_group_uin.get();
                locala.amc = paramArrayOfByte.uint32_relationship_type.get();
              }
            }
            QLog.d("VideoPackageUtils", 1, " --- parse video message " + locala.toString());
            return locala;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("nearby.video.multiMsg", 2, " head not exist");
          continue;
        }
        int i = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VideoPackageUtils", 1, " invalid format:" + paramArrayOfByte.toString());
        return locala;
      }
    }
  }
  
  public static int b(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        j = k;
      }
    }
    else {
      return j;
    }
    k = 0;
    for (;;)
    {
      j = i;
      if (k >= paramInt) {
        break;
      }
      i = (int)(i | (paramArrayOfByte[k] & 0xFF) << (paramInt - k - 1) * 8);
      k += 1;
    }
  }
  
  public static long bytesToLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j;
    for (int i = 0;; i = j)
    {
      l2 = l1;
      if (i >= paramInt) {
        break;
      }
      l2 = paramArrayOfByte[i];
      j = i + 1;
      l1 = (l2 & 0xFF) << (paramInt - i - 1) * 8 | l1;
    }
  }
  
  public static short bytesToShort(byte[] paramArrayOfByte, int paramInt)
  {
    short s3 = 0;
    short s1 = 0;
    short s2 = s1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 2) {
        s2 = s1;
      }
    }
    else {
      return s2;
    }
    int i = 0;
    s1 = s3;
    for (;;)
    {
      s2 = s1;
      if (i >= paramInt) {
        break;
      }
      s1 = (short)(int)(s1 | (paramArrayOfByte[i] & 0xFF) << (paramInt - i - 1) * 8);
      i += 1;
    }
  }
  
  public static long q(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  public static long u(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str2;
    do
    {
      for (;;)
      {
        return 0L;
        String str1 = paramString;
        str2 = paramString;
        try
        {
          if (paramString.startsWith("+"))
          {
            str2 = paramString;
            str1 = paramString.substring(1);
          }
          str2 = str1;
          long l = jji.B(str1);
          if (l >= 10000L) {
            return l;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoPackageUtils", 2, "uin = " + str2 + " is error");
    return 0L;
  }
  
  public static class a
  {
    public String MC;
    public String MD;
    public boolean Pr;
    public int alZ;
    public int ama;
    public int amb;
    public int amc;
    public long kY;
    public long la;
    public long roomId;
    public int seq;
    public long uin;
    
    public boolean sD()
    {
      return this.alZ == 3;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("VideoPacket{roomId=").append(this.roomId).append(", bodyType=").append(this.alZ).append(", uin=").append(this.uin).append(", fromuin=").append(this.kY).append(", subServiceType=").append(this.ama).append(", seq=").append(this.seq).append(", business_flag=").append(this.amb).append(", terminal_switch_flag =").append(this.Pr).append(", u32AccountType =").append(this.amc).append(", uint64_group_uin =").append(this.la).append(", str_from_nation =").append(this.MD).append(", str_from_mobile =");
      if (this.MC != null) {}
      for (boolean bool = true;; bool = false) {
        return bool + '}';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihk
 * JD-Core Version:    0.7.0.1
 */