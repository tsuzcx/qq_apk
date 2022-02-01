import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch.CMsgRequest;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch.CMsgResponse;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch.ParamPair;

public class ajnh
  extends accg
{
  public ajnh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private long getVersion()
  {
    long l = 0L;
    String str;
    if (!TextUtils.isEmpty("3.4.4")) {
      str = "3.4.4".replace(".", "");
    }
    try
    {
      l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0L;
  }
  
  private void kb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        paramToServiceMsg = new MusicSongInfoMatch.CMsgResponse();
        paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = new String(paramToServiceMsg.data.get().toByteArray());
      }
      switch (paramToServiceMsg.reqtype.get())
      {
      case 1: 
        notifyUI(81, true, paramFromServiceMsg);
        return;
      case 2: 
        notifyUI(82, true, paramFromServiceMsg);
        return;
      case 3: 
        notifyUI(83, true, paramFromServiceMsg);
        return;
        notifyUI(81, false, null);
        return;
      }
      return;
    }
    catch (Exception paramToServiceMsg) {}
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QLog.d("MusicPlayerHandler", 4, new Object[] { "requestMatchSongInfo ", String.valueOf(paramString1), " ", String.valueOf(paramString2), " ", String.valueOf(paramString3), " ", String.valueOf(paramString4), " ", String.valueOf(paramString5), " ", String.valueOf(paramInt) });
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong), "MusicSongInfoMatchSvc.songquery");
    MusicSongInfoMatch.CMsgRequest localCMsgRequest = new MusicSongInfoMatch.CMsgRequest();
    if (!TextUtils.isEmpty(paramString1))
    {
      MusicSongInfoMatch.ParamPair localParamPair = new MusicSongInfoMatch.ParamPair();
      localParamPair.key.set(ByteStringMicro.copyFromUtf8("songname"));
      localParamPair.value.set(ByteStringMicro.copyFromUtf8(paramString1));
      localCMsgRequest.urlparams.add(localParamPair);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new MusicSongInfoMatch.ParamPair();
      paramString1.key.set(ByteStringMicro.copyFromUtf8("singername"));
      paramString1.value.set(ByteStringMicro.copyFromUtf8(paramString2));
      localCMsgRequest.urlparams.add(paramString1);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new MusicSongInfoMatch.ParamPair();
      paramString1.key.set(ByteStringMicro.copyFromUtf8("albumname"));
      paramString1.value.set(ByteStringMicro.copyFromUtf8(paramString3));
      localCMsgRequest.urlparams.add(paramString1);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = new MusicSongInfoMatch.ParamPair();
      paramString1.key.set(ByteStringMicro.copyFromUtf8("songid"));
      paramString1.value.set(ByteStringMicro.copyFromUtf8(paramString4));
      localCMsgRequest.urlparams.add(paramString1);
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString1 = new MusicSongInfoMatch.ParamPair();
      paramString1.key.set(ByteStringMicro.copyFromUtf8("summary"));
      paramString1.value.set(ByteStringMicro.copyFromUtf8(paramString5));
      localCMsgRequest.urlparams.add(paramString1);
    }
    if (paramInt > 0)
    {
      paramInt /= 1000;
      paramString1 = new MusicSongInfoMatch.ParamPair();
      paramString1.key.set(ByteStringMicro.copyFromUtf8("duration"));
      paramString1.value.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramInt)));
      localCMsgRequest.urlparams.add(paramString1);
    }
    localCMsgRequest.reqtype.set(1);
    localCMsgRequest.uin.set(paramLong);
    localCMsgRequest.ct.set(1008L);
    localCMsgRequest.cv.set(getVersion());
    localToServiceMsg.putWupBuffer(localCMsgRequest.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    QLog.d("MusicPlayerHandler", 4, new Object[] { "requestLikeSong ", String.valueOf(paramString), " ", String.valueOf(paramLong1), " ", String.valueOf(paramLong2), " ", String.valueOf(paramBoolean) });
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MusicSongInfoMatchSvc.songquery");
    MusicSongInfoMatch.CMsgRequest localCMsgRequest = new MusicSongInfoMatch.CMsgRequest();
    MusicSongInfoMatch.ParamPair localParamPair1 = new MusicSongInfoMatch.ParamPair();
    localParamPair1.key.set(ByteStringMicro.copyFromUtf8("songid"));
    localParamPair1.value.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramLong2)));
    MusicSongInfoMatch.ParamPair localParamPair2 = new MusicSongInfoMatch.ParamPair();
    localParamPair2.key.set(ByteStringMicro.copyFromUtf8("OpenUDID"));
    localParamPair2.value.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString)));
    localCMsgRequest.urlparams.add(localParamPair1);
    localCMsgRequest.urlparams.add(localParamPair2);
    if (paramBoolean) {
      localCMsgRequest.reqtype.set(2);
    }
    for (;;)
    {
      localCMsgRequest.uin.set(paramLong1);
      localCMsgRequest.ct.set(1008L);
      localCMsgRequest.cv.set(getVersion());
      localToServiceMsg.putWupBuffer(localCMsgRequest.toByteArray());
      sendPbReq(localToServiceMsg);
      return;
      localCMsgRequest.reqtype.set(3);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return MusicPlayerActivity.b.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MusicSongInfoMatchSvc.songquery".equals(paramFromServiceMsg.getServiceCmd())) {
      kb(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnh
 * JD-Core Version:    0.7.0.1
 */