import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import dov.com.qq.im.ae.SessionWrap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class anhq
{
  private static anhq a;
  private boolean cGf;
  private boolean cGg;
  private String cdX;
  private int dGh = -1;
  private int dGi;
  
  public static anhq a()
  {
    if (a == null) {
      a = new anhq();
    }
    return a;
  }
  
  public static boolean axc()
  {
    boolean bool1 = QmcfManager.getInstance().hasQmcfEntrance(2);
    boolean bool2 = bool1;
    int i;
    if (bool1)
    {
      i = anjn.JJ();
      if (i <= 0) {
        break label77;
      }
    }
    label77:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        QmcfManager.getInstance().setQmcfMobileNotSupport(anjn.cen);
        QLog.d("DanceGameVideoManager", 1, String.format("isDanceGameSupport supportFrameType[%d], gpuinfo[%s], model[%s]", new Object[] { Integer.valueOf(i), anjn.cen, Build.MODEL }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean) {
      if (paramInt2 == 5)
      {
        paramBoolean = true;
        if (paramInt2 != 6) {
          break label55;
        }
        bool = true;
        label19:
        switch (paramInt1)
        {
        }
      }
    }
    label55:
    label67:
    label82:
    do
    {
      return false;
      paramBoolean = false;
      break;
      bool = false;
      break label19;
      if (paramInt2 == 3)
      {
        paramBoolean = true;
        if (paramInt2 != 4) {
          break label82;
        }
      }
      for (bool = true;; bool = false)
      {
        break;
        paramBoolean = false;
        break label67;
      }
      return paramBoolean;
      return bool;
    } while ((!paramBoolean) && (!bool));
    return true;
  }
  
  public static boolean ly(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean s(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.zQ() == null) {}
    do
    {
      do
      {
        return false;
        if (ShortVideoUtils.awI()) {
          break;
        }
        ShortVideoUtils.B(paramAppInterface);
      } while (!ShortVideoUtils.awI());
    } while ((ankq.aB(BaseApplicationImpl.getContext()) == 2) || (ankq.JS() == 2));
    return true;
  }
  
  public static boolean t(AppInterface paramAppInterface)
  {
    paramAppInterface = VideoEnvironment.zQ();
    if (TextUtils.isEmpty(paramAppInterface)) {}
    do
    {
      String str;
      do
      {
        return false;
        if (ShortVideoUtils.awI()) {
          break;
        }
        str = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
      } while (!aqhq.fileExists(str + paramAppInterface));
    } while ((ankq.aB(BaseApplicationImpl.getContext()) == 2) || (ankq.JS() == 2));
    return true;
  }
  
  public void PK(boolean paramBoolean)
  {
    this.cGf = paramBoolean;
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (s(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DanceGameVideoManager", 2, "jumpToVideoPreview by danceVideo tail");
      }
      paramQQAppInterface = null;
      if (paramSessionInfo != null) {
        paramQQAppInterface = new SessionWrap(paramSessionInfo.aTl, paramSessionInfo.aTn, paramSessionInfo.cZ, paramSessionInfo.troopUin);
      }
      paramQQAppInterface = awrp.a(paramQQAppInterface, paramActivity.getClass().getName(), 10000, 100, true, 10, "");
      rnq.a().a(paramActivity, paramQQAppInterface, 11);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
        break label297;
      }
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label252;
      }
      j = paramFromServiceMsg.uint32_result.get();
      if (j != 0) {
        break label197;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte.array());
      k = paramFromServiceMsg.rpt_msg_uin_data.size();
      i = 0;
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        int j;
        int k;
        int i;
        String str;
        int m;
        label197:
        label252:
        this.cdX = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleGetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        label297:
        this.cdX = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
        i += 1;
      }
    }
    if (i < k)
    {
      paramArrayOfByte = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i);
      str = String.valueOf(paramArrayOfByte.uint64_uin.get());
      if (paramArrayOfByte.uint32_dance_max_score.has())
      {
        m = paramArrayOfByte.uint32_dance_max_score.get();
        dI(m, str);
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore uin:", str, " maxScore:", Integer.valueOf(m) });
        }
      }
    }
    else
    {
      for (this.cdX = ("error ret " + j);; this.cdX = paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore result: ", this.cdX });
        }
        return;
        if (paramFromServiceMsg != null) {
          break;
        }
        paramFromServiceMsg = "no pkg";
      }
    }
  }
  
  public void a(Packet paramPacket, String paramString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_dance_max_score.set(1);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1515);
    paramString.uint32_service_type.set(203);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    paramString = paramString.toByteArray();
    localObject = ByteBuffer.allocate(paramString.length + 4);
    ((ByteBuffer)localObject).putInt(paramString.length + 4);
    ((ByteBuffer)localObject).put(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setSSOCommand("OidbSvc.0x5eb_203");
  }
  
  public void a(Packet paramPacket, String paramString, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(13);
    long l = Long.parseLong(paramString);
    this.dGi = paramInt;
    localByteBuffer.putInt(aqft.ag(l)).put((byte)0).putShort((short)1).putShort((short)27245).putShort((short)2).putShort((short)paramInt);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1279);
    paramString.uint32_service_type.set(9);
    paramString.uint32_result.set(0);
    paramString.str_client_version.set(AppSetting.getVersion());
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = paramString.toByteArray();
    localByteBuffer = ByteBuffer.allocate(paramString.length + 4);
    localByteBuffer.putInt(paramString.length + 4);
    localByteBuffer.put(paramString);
    paramPacket.putSendData(localByteBuffer.array());
    paramPacket.setSSOCommand("OidbSvc.0x4ff_203");
  }
  
  public boolean axa()
  {
    return this.cGg;
  }
  
  public boolean axb()
  {
    return this.cGf;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
          continue;
        }
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          continue;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          long l = aqft.K(ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
          if (this.dGi > this.dGh)
          {
            dI(this.dGi, String.valueOf(Long.valueOf(l)));
            this.cGg = true;
          }
        }
        this.cdX = ("error ret " + i);
      }
      catch (Exception paramFromServiceMsg)
      {
        this.cdX = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleSetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        this.cdX = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameVideoManager", 2, new Object[] { "handleSetDanceMaxScore result: ", this.cdX });
      }
      return;
      if (paramFromServiceMsg != null) {
        continue;
      }
      paramFromServiceMsg = "no pkg";
      this.cdX = paramFromServiceMsg;
    }
  }
  
  public void dI(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getRuntime().getApplication().getSharedPreferences("danceConfig", 4).edit();
    localEditor.putInt(paramString + "_max_score", paramInt);
    localEditor.commit();
    this.dGh = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("DanceGameVideoManager", 2, "updateDanceMaxScore maxScore:" + this.dGh + " ,new:" + paramInt);
    }
    this.dGh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhq
 * JD-Core Version:    0.7.0.1
 */