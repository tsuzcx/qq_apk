import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.BubbleReq;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.FontReq;
import QC.GetUsrKeyWordInfoReq;
import QC.Hamlet;
import QC.LoginInfo;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniLoginCheckReq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq.TDiyFontReqInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp.TMd5Ret;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TSetPosterFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TSetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TTipsInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class acle
  extends accg
{
  public BubbleManager b;
  private boolean bJk;
  private int cxN = -1;
  private int cxO = -1;
  private int cxP = -1;
  private int cxQ = -1;
  private int cxR = -1;
  private int cxS = -1;
  
  public acle(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = ((BubbleManager)paramQQAppInterface.getManager(44));
  }
  
  public static int Q(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static int R(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private LoginInfo a()
  {
    try
    {
      String str1 = this.app.getCurrentAccountUin();
      String str2 = ((TicketManager)this.app.getManager(2)).getSkey(str1);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str1);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = str2;
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = aqgz.getQQVersion();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e("SVIPHandler", 1, "getLoginInfo fail", localException);
    }
    return null;
  }
  
  private void fA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if ((paramObject instanceof MessageRemindRsp))
      {
        notifyUI(113, true, paramObject);
        return;
      }
      notifyUI(113, false, null);
      return;
    }
    QLog.e("vip_pretty.SVIPHandler", 1, "handleGetBigTroopExpiredInfo resp failed:" + paramFromServiceMsg.getResultCode());
    notifyUI(113, false, null);
  }
  
  private void fB(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof FontRecommendRsp))
    {
      notifyUI(107, true, paramObject);
      return;
    }
    notifyUI(107, false, null);
  }
  
  private void fC(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof BubbleRecommendRsp))
    {
      notifyUI(108, true, paramObject);
      return;
    }
    notifyUI(108, false, null);
  }
  
  private void fD(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("setFontBubbleSeq");
    if ((paramObject instanceof SetFontBubbleRsp))
    {
      notifyUI(109, true, new Object[] { paramObject, Integer.valueOf(i) });
      return;
    }
    notifyUI(109, false, new Object[] { null, Integer.valueOf(i) });
  }
  
  private void fE(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetRoamToastRsp))
    {
      notifyUI(111, true, paramObject);
      return;
    }
    notifyUI(111, false, paramObject);
  }
  
  private void fF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof FaceRsp))
    {
      notifyUI(112, true, paramObject);
      return;
    }
    notifyUI(112, false, paramObject);
  }
  
  private void fs(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (ku)this.app.getManager(42);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleGetUserFont isSuccess = " + paramFromServiceMsg.isSuccess() + " data = " + StructLongMessageDownloadProcessor.bytesToHexString((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramObject = new VipFontUpdate.TFontSsoRsp();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp)paramObject.st_md5_check_rsp.get();
        if ((paramFromServiceMsg.rpt_md5_ret.has()) && (paramFromServiceMsg.rpt_md5_ret.get().size() > 0))
        {
          paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp.TMd5Ret)paramFromServiceMsg.rpt_md5_ret.get().get(0);
          int i = paramFromServiceMsg.i32_check_ret.get();
          int j = paramFromServiceMsg.i32_check_font_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleGetUserFont fontid = " + j + " md5ret = " + i);
          }
          if ((j == AR()) && (i > 0)) {
            paramToServiceMsg.B(j, this.cxR);
          }
        }
        paramFromServiceMsg = (VipFontUpdate.TFontFreshRsp)paramObject.st_fresh_rsp.get();
        if (paramFromServiceMsg.i32_font_type.has())
        {
          lf.iN = paramFromServiceMsg.i32_font_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "handleGetFontShieldType type= " + lf.iN);
          }
          lf.eG = this.app.getCurrentUin();
          lf.s(this.app);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleGetUserFont error: " + paramFromServiceMsg.getMessage());
        continue;
      }
      paramToServiceMsg.D.set(true);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "handleGetUserFont response not success message = " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  private void ft(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      do
      {
        ArrayList localArrayList;
        acff localacff;
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (VipFontUpdate.TDiyFontRsp)paramToServiceMsg.st_diyfont_rsp.get();
          localArrayList = new ArrayList();
          localacff = (acff)this.app.getManager(51);
          Iterator localIterator = paramToServiceMsg.rpt_font_rsp_info.get().iterator();
          while (localIterator.hasNext())
          {
            VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo localTDiyFontRspInfo = (VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo)localIterator.next();
            String str = String.valueOf(localTDiyFontRspInfo.u64_uin.get());
            paramObject = localTDiyFontRspInfo.str_diy_font_config.get();
            paramToServiceMsg = paramObject;
            if (paramObject == null) {
              paramToServiceMsg = "";
            }
            int i = localTDiyFontRspInfo.i32_font_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "handleGetDiyFontConfig uin = " + str + " fontId = " + i + " config = " + paramToServiceMsg + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
            }
            paramObject = localacff.a(str);
            if (paramObject.diyFontConfigMap == null) {
              paramObject.diyFontConfigMap = new ConcurrentHashMap();
            }
            if ((!paramObject.diyFontConfigMap.containsKey(Integer.valueOf(i))) || (!paramToServiceMsg.equals(paramObject.diyFontConfigMap.get(Integer.valueOf(i)))))
            {
              paramObject.diyFontConfigMap.put(Integer.valueOf(i), paramToServiceMsg);
              ((ku)this.app.getManager(42)).n(str, i);
              localArrayList.add(paramObject);
            }
          }
          if (localArrayList.size() <= 0) {
            continue;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.e("VasFont", 1, "handleGetDiyFontConfig error: + " + paramToServiceMsg.getMessage());
          return;
        }
        localacff.iN(localArrayList);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VasFont", 2, "handleGetDiyFontConfig return empty");
      return;
    }
    QLog.e("VasFont", 1, "handleGetDiyFontConfig not success errorcode = " + paramFromServiceMsg.getResultCode() + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
  }
  
  private void fu(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("hiboom_auth_type");
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramObject.i32_ret.get() != 0)
        {
          notifyUI(102, false, Integer.valueOf(i));
          return;
        }
        paramFromServiceMsg = (VipFontUpdate.TCheckRsp)paramObject.st_check_rsp.get();
        if (paramFromServiceMsg != null)
        {
          notifyUI(102, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Integer.valueOf(paramToServiceMsg.extraData.getInt("hiboom_id")), paramToServiceMsg.extraData.getString("hiboom_text"), Integer.valueOf(i) });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleAuthHiBoom error: " + paramToServiceMsg.getLocalizedMessage() + Log.getStackTraceString(paramToServiceMsg));
        notifyUI(102, false, Integer.valueOf(i));
        return;
      }
      QLog.e("SVIPHandler", 1, "handleAuthHiBoom fail authRsp is null");
      notifyUI(102, false, Integer.valueOf(i));
      return;
    }
    paramToServiceMsg = new StringBuilder().append("handleAuthHiBoom fail isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" data is null : ");
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("SVIPHandler", 1, bool);
      notifyUI(102, false, Integer.valueOf(i));
      return;
    }
  }
  
  private void fv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (ahxs)this.app.getManager(219);
        if (paramToServiceMsg.i32_ret.get() != 0)
        {
          QLog.e("HiBoomFont", 1, "handleGetHiBoomList fail ret = " + paramToServiceMsg.i32_ret.get());
          paramFromServiceMsg.dqP();
          return;
        }
        paramToServiceMsg = (VipFontUpdate.TGetPosterFontRsp)paramToServiceMsg.st_getposterfont_rsp.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.a(paramToServiceMsg, true);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("HiBoomFont", 1, "handleGetHiBoomList error: " + Log.getStackTraceString(paramToServiceMsg));
        return;
      }
      QLog.e("HiBoomFont", 1, "handleGetHiBoomList st_getposterfont_rsp is null");
      paramFromServiceMsg.dqP();
      return;
    }
    QLog.e("HiBoomFont", 1, "handleGetHiBoomList fail");
  }
  
  private void fw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("hiboom_auth_is_send", false);
    String str = paramToServiceMsg.extraData.getString("hiboom_text", "");
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramObject.i32_ret.get() != 0)
        {
          notifyUI(103, false, null);
          return;
        }
        paramFromServiceMsg = (VipFontUpdate.TSetPosterFontRsp)paramObject.st_setposterfont_rsp.get();
        if (paramFromServiceMsg == null)
        {
          notifyUI(103, false, Boolean.valueOf(bool));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("HiBoomFont", 1, "handleSetHiBoom error:" + Log.getStackTraceString(paramToServiceMsg));
        notifyUI(103, false, Boolean.valueOf(bool));
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("hiboom_id");
      notifyUI(103, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), Integer.valueOf(i), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Boolean.valueOf(bool), str });
    }
  }
  
  private void fy(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleRequestColorNickPanel resp = " + paramFromServiceMsg.toString());
    }
    if ((paramObject instanceof readItemInfoRsp))
    {
      notifyUI(105, true, (readItemInfoRsp)paramObject);
      return;
    }
    notifyUI(105, false, null);
  }
  
  public static long g(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1;
  }
  
  /* Error */
  public int AR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	acle:cxQ	I
    //   6: iconst_m1
    //   7: if_icmpne +53 -> 60
    //   10: aload_0
    //   11: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: bipush 51
    //   16: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 331	acff
    //   22: aload_0
    //   23: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 542	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokevirtual 392	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +9 -> 43
    //   37: iconst_0
    //   38: istore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: aload_0
    //   44: aload_2
    //   45: getfield 545	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   48: l2i
    //   49: putfield 27	acle:cxQ	I
    //   52: aload_0
    //   53: aload_2
    //   54: getfield 548	com/tencent/mobileqq/data/ExtensionInfo:vipFontType	I
    //   57: putfield 29	acle:cxR	I
    //   60: aload_0
    //   61: getfield 27	acle:cxQ	I
    //   64: istore_1
    //   65: goto -26 -> 39
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	acle
    //   38	27	1	i	int
    //   32	22	2	localExtensionInfo	ExtensionInfo
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	68	finally
    //   43	60	68	finally
    //   60	65	68	finally
  }
  
  public int AS()
  {
    try
    {
      if (this.cxN == -1) {
        this.cxN = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("svip_bubble_id", 0);
      }
      int i = Q(this.cxN);
      return i;
    }
    finally {}
  }
  
  public int AT()
  {
    if ((this.b != null) && (this.b.a != null))
    {
      adxm localadxm = (adxm)this.b.a.get(Integer.valueOf(AS()));
      if ((localadxm != null) && (localadxm.afM()))
      {
        int i = localadxm.BW();
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, "main bubbleid: " + this.cxN + ", subBubbleId: " + i);
        }
        return i;
      }
    }
    return 0;
  }
  
  /* Error */
  public int AU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 600	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   5: getstatic 606	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:MsgLengthByBubble	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   8: invokevirtual 609	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   11: ldc_w 611
    //   14: invokevirtual 614	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: aload_3
    //   21: invokestatic 617	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_3
    //   30: iload_2
    //   31: istore_1
    //   32: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq -10 -> 25
    //   38: ldc 100
    //   40: iconst_2
    //   41: aload_3
    //   42: invokevirtual 618	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   45: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload_2
    //   49: istore_1
    //   50: goto -25 -> 25
    //   53: astore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	acle
    //   24	26	1	i	int
    //   19	30	2	j	int
    //   17	4	3	str	String
    //   29	13	3	localNumberFormatException	java.lang.NumberFormatException
    //   53	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	29	java/lang/NumberFormatException
    //   2	18	53	finally
    //   20	25	53	finally
    //   32	48	53	finally
  }
  
  public int AV()
  {
    try
    {
      if (this.cxO == -1) {
        this.cxO = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("svip_bubble_diy_text_id", 0);
      }
      int i = this.cxO;
      return i;
    }
    finally {}
  }
  
  public int AW()
  {
    try
    {
      if (this.cxP == -1) {
        this.cxP = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("svip_bubble_voice_print_id", 0);
      }
      int i = this.cxP;
      return i;
    }
    finally {}
  }
  
  public int AX()
  {
    int i = VipUtils.a(this.app, null);
    if ((i & 0x4) != 0) {
      return 3;
    }
    if ((i & 0x2) != 0) {
      return 1;
    }
    if ((i & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
  
  public void JK(int paramInt)
  {
    try
    {
      if (paramInt != this.cxN)
      {
        this.cxN = paramInt;
        this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.bJk = false;
      return;
    }
    finally {}
  }
  
  public void JL(int paramInt)
  {
    try
    {
      if (paramInt != this.cxP)
      {
        this.cxP = paramInt;
        this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_voice_print_id", paramInt).commit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void JM(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setMagicFont setup = " + paramInt);
      }
      acff localacff = (acff)this.app.getManager(51);
      ExtensionInfo localExtensionInfo2 = localacff.a(this.app.getAccount());
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = new ExtensionInfo();
        localExtensionInfo1.uin = this.app.getAccount();
      }
      if (localExtensionInfo1.magicFont != paramInt)
      {
        localExtensionInfo1.magicFont = paramInt;
        if (1 == paramInt) {
          localExtensionInfo1.fontEffect = 0;
        }
      }
      localacff.a(localExtensionInfo1);
      this.bJk = false;
      return;
    }
    finally {}
  }
  
  public void JN(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "setFontEffect fontEffectId = " + paramInt);
        }
        acff localacff = (acff)this.app.getManager(51);
        ExtensionInfo localExtensionInfo = localacff.a(this.app.getAccount());
        if (localExtensionInfo == null)
        {
          localExtensionInfo = new ExtensionInfo();
          localExtensionInfo.uin = this.app.getAccount();
          localExtensionInfo.fontEffect = -1;
          i = 1;
          if (localExtensionInfo.fontEffect != paramInt)
          {
            localExtensionInfo.fontEffect = paramInt;
            localExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
            ((ku)this.app.getManager(42)).eT();
            if (paramInt == 0) {
              break label166;
            }
            localExtensionInfo.magicFont = 0;
            break label166;
          }
          if (i != 0) {
            localacff.a(localExtensionInfo);
          }
          this.bJk = false;
          return;
        }
      }
      finally {}
      int i = 0;
      continue;
      label166:
      i = 1;
    }
  }
  
  public void JO(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "groupnick.readitem");
    readItemInfoReq localreadItemInfoReq = new readItemInfoReq(109L, aqgz.getQQVersion(), paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadItemInfoReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void JP(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "profilelogic.readUserInfo");
    readUserInfoReq localreadUserInfoReq = new readUserInfoReq(aqgz.getQQVersion(), 109, paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadUserInfoReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void JQ(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "profilelogic.setUserProfile");
    setUserProfileReq localsetUserProfileReq = new setUserProfileReq(paramInt, aqgz.getQQVersion(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserProfileReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void JR(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "profilelogic.setUserFlag");
    setUserFlagReq localsetUserFlagReq = new setUserFlagReq(paramInt, aqgz.getQQVersion(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserFlagReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void JS(int paramInt)
  {
    FaceReq localFaceReq = new FaceReq();
    localFaceReq.stLogin = a();
    if (localFaceReq.stLogin == null) {
      return;
    }
    localFaceReq.faceID = paramInt;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Face.setFace");
    localToServiceMsg.extraData.putSerializable("req", localFaceReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void W(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!paramMessageRecord.needVipBubble())) {
      break label11;
    }
    label11:
    while (((jof.a(paramMessageRecord)) && (jof.b(paramMessageRecord))) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) {
      return;
    }
    if (AV() > 0)
    {
      paramMessageRecord.vipBubbleID = g(AS(), AV());
      paramMessageRecord.vipBubbleDiyTextId = AV();
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        int i = AW();
        if (i > 0) {
          paramMessageRecord.vipBubbleID = i;
        }
      }
      paramMessageRecord.vipSubBubbleId = AT();
      if (paramMessageRecord.vipSubBubbleId == 0) {
        break;
      }
      paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(paramMessageRecord.vipSubBubbleId));
      cMi();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("SVIPHandler", 2, "addSendingBubbleId: changeSubBubbleId, messageRecord: " + paramMessageRecord.getClass().getSimpleName());
      return;
      paramMessageRecord.vipBubbleID = AS();
    }
  }
  
  public void a(GetRoamToastRsp paramGetRoamToastRsp)
  {
    Object localObject = this.app.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("SVIPHandler", 1, "closeToast null uin");
    }
    int i;
    do
    {
      return;
      localObject = this.app.getApp().getSharedPreferences((String)localObject, 0);
      paramGetRoamToastRsp = "roam_toast_close_" + paramGetRoamToastRsp.sToastKey;
      i = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
      ((SharedPreferences)localObject).edit().putInt(paramGetRoamToastRsp, i + 1).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SVIPHandler", 2, "closeToast: " + paramGetRoamToastRsp + "," + (i + 1));
  }
  
  public void a(acci paramacci, boolean paramBoolean)
  {
    paramacci = createToServiceMsg("QCUniBusinessLogin.check", paramacci, paramBoolean);
    UniLoginCheckReq localUniLoginCheckReq = new UniLoginCheckReq(a(), new ArrayList(), 2L, new GetUsrKeyWordInfoReq());
    paramacci.extraData.putSerializable("req", localUniLoginCheckReq);
    this.app.sendToService(paramacci);
  }
  
  public void a(ArrayList<Hamlet> paramArrayList, acci paramacci, boolean paramBoolean)
  {
    paramacci = createToServiceMsg("QCUniBusinessLogin.check", paramacci, paramBoolean);
    paramArrayList = new UniLoginCheckReq(a(), paramArrayList, 3L, new GetUsrKeyWordInfoReq());
    paramacci.extraData.putSerializable("req", paramArrayList);
    this.app.sendToService(paramacci);
  }
  
  public boolean a(GetRoamToastRsp paramGetRoamToastRsp)
  {
    boolean bool = true;
    Object localObject = this.app.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("SVIPHandler", 1, "shouldShowToast null uin");
      return false;
    }
    localObject = this.app.getApp().getSharedPreferences((String)localObject, 0);
    paramGetRoamToastRsp = "roam_toast_close_" + paramGetRoamToastRsp.sToastKey;
    int i = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "shouldShowToast: " + paramGetRoamToastRsp + "," + i);
    }
    if (i < 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void aI(int paramInt1, int paramInt2, int paramInt3)
  {
    SetFontBubbleReq localSetFontBubbleReq = new SetFontBubbleReq();
    localSetFontBubbleReq.stLogin = a();
    if (localSetFontBubbleReq.stLogin == null) {
      return;
    }
    localSetFontBubbleReq.stFontReq = new FontReq(paramInt1);
    localSetFontBubbleReq.stBubbleReq = new BubbleReq(paramInt2);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "FontBubbleRecommend.setFontBubble");
    localToServiceMsg.extraData.putInt("setFontBubbleSeq", paramInt3);
    localToServiceMsg.extraData.putSerializable("req", localSetFontBubbleReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public boolean aL(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.b.a != null))
    {
      adxm localadxm = (adxm)this.b.a.get(Integer.valueOf(paramInt1));
      return (localadxm != null) && (localadxm.afM()) && (localadxm.iS(paramInt2));
    }
    return false;
  }
  
  public void af(Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "pbGetDiyFontConfig");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(3);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("3.4.4.3058");
    localObject = new VipFontUpdate.TDiyFontReq();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      VipFontUpdate.TDiyFontReq.TDiyFontReqInfo localTDiyFontReqInfo = new VipFontUpdate.TDiyFontReq.TDiyFontReqInfo();
      localTDiyFontReqInfo.u64_uin.set(Long.parseLong(str));
      localTDiyFontReqInfo.i32_font_id.set(((Integer)paramMap.get(str)).intValue());
      ((VipFontUpdate.TDiyFontReq)localObject).rpt_font_req_info.add(localTDiyFontReqInfo);
    }
    localTFontSsoReq.st_diyfont_req.set((MessageMicro)localObject);
    paramMap = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Font.fresh");
    paramMap.putWupBuffer(localTFontSsoReq.toByteArray());
    paramMap.extraData.putInt("CMD", 3);
    sendPbReq(paramMap);
  }
  
  /* Error */
  public void bo(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 23	acle:cxO	I
    //   7: if_icmpeq +139 -> 146
    //   10: aload_0
    //   11: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +132 -> 146
    //   17: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 100
    //   25: iconst_2
    //   26: new 126	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 973
    //   36: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 23	acle:cxO	I
    //   54: aload_0
    //   55: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: aload_0
    //   62: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: iconst_0
    //   69: invokevirtual 559	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   72: invokeinterface 636 1 0
    //   77: ldc_w 621
    //   80: iload_1
    //   81: invokeinterface 642 3 0
    //   86: invokeinterface 645 1 0
    //   91: pop
    //   92: iload_1
    //   93: ifle +53 -> 146
    //   96: new 126	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   103: aload_0
    //   104: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: invokevirtual 542	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   110: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 975
    //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: iload_2
    //   128: ifeq +26 -> 154
    //   131: new 977	com/tencent/mobileqq/app/SVIPHandler$1
    //   134: dup
    //   135: aload_0
    //   136: aload_3
    //   137: invokespecial 980	com/tencent/mobileqq/app/SVIPHandler$1:<init>	(Lacle;Ljava/lang/String;)V
    //   140: iconst_5
    //   141: aconst_null
    //   142: iconst_0
    //   143: invokestatic 986	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 647	acle:bJk	Z
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: invokestatic 991	adxn:a	()Ladxn;
    //   157: aload_0
    //   158: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   161: aload_3
    //   162: aconst_null
    //   163: invokevirtual 994	adxn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lacci;)V
    //   166: goto -20 -> 146
    //   169: astore_3
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_3
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	acle
    //   0	174	1	paramInt	int
    //   0	174	2	paramBoolean	boolean
    //   126	36	3	str	String
    //   169	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	169	finally
    //   49	92	169	finally
    //   96	127	169	finally
    //   131	146	169	finally
    //   146	151	169	finally
    //   154	166	169	finally
  }
  
  /* Error */
  public void bp(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 31	acle:cxS	I
    //   7: if_icmpeq +101 -> 108
    //   10: aload_0
    //   11: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +94 -> 108
    //   17: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 100
    //   25: iconst_2
    //   26: new 126	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 997
    //   36: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 31	acle:cxS	I
    //   54: iload_1
    //   55: ifle +53 -> 108
    //   58: new 126	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 542	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   72: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 975
    //   78: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_1
    //   82: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_3
    //   89: iload_2
    //   90: ifeq +26 -> 116
    //   93: new 999	com/tencent/mobileqq/app/SVIPHandler$2
    //   96: dup
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 1000	com/tencent/mobileqq/app/SVIPHandler$2:<init>	(Lacle;Ljava/lang/String;)V
    //   102: iconst_5
    //   103: aconst_null
    //   104: iconst_0
    //   105: invokestatic 986	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 647	acle:bJk	Z
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: invokestatic 1005	abgl:a	()Labgl;
    //   119: aload_0
    //   120: getfield 55	acle:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: aload_3
    //   124: aconst_null
    //   125: invokevirtual 1008	abgl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lacci;)Lcom/tencent/mobileqq/addon/DiyPendantEntity;
    //   128: pop
    //   129: goto -21 -> 108
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	acle
    //   0	137	1	paramInt	int
    //   0	137	2	paramBoolean	boolean
    //   88	36	3	str	String
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	132	finally
    //   49	54	132	finally
    //   58	89	132	finally
    //   93	108	132	finally
    //   108	113	132	finally
    //   116	129	132	finally
  }
  
  public void cMh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "getHiBoomList");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(4);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("3.4.4.3058");
    localObject = new VipFontUpdate.TGetPosterFontReq();
    ((VipFontUpdate.TGetPosterFontReq)localObject).isgetrecommend.set(1);
    localTFontSsoReq.st_getposterfont_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 4);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cMi()
  {
    try
    {
      if ((this.b != null) && (this.b.a != null))
      {
        adxm localadxm = (adxm)this.b.a.get(Integer.valueOf(AS()));
        if ((localadxm != null) && (localadxm.afM())) {
          localadxm.cUV();
        }
      }
      return;
    }
    finally {}
  }
  
  public void cMj()
  {
    FontRecommendReq localFontRecommendReq = new FontRecommendReq();
    localFontRecommendReq.stLogin = a();
    if (localFontRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "FontBubbleRecommend.getFontRecommend");
    localToServiceMsg.extraData.putSerializable("req", localFontRecommendReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void cMk()
  {
    BubbleRecommendReq localBubbleRecommendReq = new BubbleRecommendReq();
    localBubbleRecommendReq.stLogin = a();
    if (localBubbleRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "FontBubbleRecommend.getBubbleRecommend");
    localToServiceMsg.extraData.putSerializable("req", localBubbleRecommendReq);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void cMl()
  {
    try
    {
      Object localObject1 = this.app.getCurrentAccountUin();
      Object localObject2 = ((TicketManager)this.app.getManager(2)).getSkey((String)localObject1);
      localObject1 = new GetRoamToastReq(Long.parseLong((String)localObject1), (String)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "RoamWrap.GetRoamToast");
      ((ToServiceMsg)localObject2).extraData.putSerializable("req", (Serializable)localObject1);
      this.app.sendToService((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SVIPHandler", 1, "getRoamToast fail", localException);
    }
  }
  
  public ToServiceMsg createToServiceMsg(String paramString, acci paramacci, boolean paramBoolean)
  {
    return super.createToServiceMsg(paramString, paramacci, paramBoolean);
  }
  
  public int ct(String paramString)
  {
    int i = this.app.getApp().getSharedPreferences(paramString, 0).getInt("svip_colorScreen_id", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "getColorScreenId " + paramString + " id " + i);
    }
    return i;
  }
  
  public void dH(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(paramString, 0);
    localSharedPreferences.getInt("svip_colorScreen_id", 0);
    localSharedPreferences.edit().putInt("svip_colorScreen_id", paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "setColorScreenId " + paramString + " id " + paramInt);
    }
    this.bJk = false;
  }
  
  public void e(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "setHiboom id = " + paramInt);
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(5);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("3.4.4.3058");
    localObject = new VipFontUpdate.TSetPosterFontReq();
    ((VipFontUpdate.TSetPosterFontReq)localObject).i32_font_id.set(paramInt);
    localTFontSsoReq.st_setposterfont_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 5);
    ((ToServiceMsg)localObject).extraData.putInt("hiboom_id", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("hiboom_auth_is_send", paramBoolean);
    ((ToServiceMsg)localObject).extraData.putString("hiboom_text", paramString);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void fx(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleFriendClone: resp=" + paramFromServiceMsg.toString());
    }
    if (((paramObject instanceof ArrayList)) && (((Integer)((ArrayList)paramObject).get(0)).intValue() == 0))
    {
      notifyUI(104, true, paramObject);
      return;
    }
    notifyUI(104, false, null);
  }
  
  public void fz(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleRequestDefaultCard: resp=" + paramFromServiceMsg.toString());
    }
    if (((paramObject instanceof readUserInfoRsp)) || ((paramObject instanceof setUserProfileRsp)) || ((paramObject instanceof setUserFlagRsp)))
    {
      notifyUI(106, true, paramObject);
      return;
    }
    notifyUI(106, false, paramFromServiceMsg.getServiceCmd());
  }
  
  public void gZ(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setSelfFontInfo id = " + paramInt1 + " type = " + paramInt2);
      }
      Object localObject1;
      if ((paramInt1 != this.cxQ) || (paramInt2 != this.cxR))
      {
        acff localacff = (acff)this.app.getManager(51);
        ExtensionInfo localExtensionInfo = localacff.a(this.app.getAccount());
        localObject1 = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = this.app.getAccount();
        }
        ((ExtensionInfo)localObject1).uVipFont = paramInt1;
        ((ExtensionInfo)localObject1).vipFontType = paramInt2;
        this.cxQ = paramInt1;
        this.cxR = paramInt2;
        localacff.a((ExtensionInfo)localObject1);
      }
      if (lf.iP != paramInt1)
      {
        lf.iP = paramInt1;
        localObject1 = this.app.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          ((MqqHandler)localObject1).removeMessages(87);
          ((MqqHandler)localObject1).sendEmptyMessage(87);
        }
      }
      this.bJk = false;
      return;
    }
    finally {}
  }
  
  public void h(String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "FriendClone.CloneAuthStatus");
    paramString.extraData.putInt("operation", paramInt);
    paramString.extraData.putString("uUin", this.app.getCurrentAccountUin());
    paramString.extraData.putBoolean("bOpenAuth", paramBoolean);
    this.app.sendToService(paramString);
  }
  
  public void hN(long paramLong)
  {
    MessageRemindReq localMessageRemindReq = new MessageRemindReq();
    localMessageRemindReq.iGroupCode = paramLong;
    Object localObject = ((TroopManager)this.app.getManager(52)).b(paramLong + "");
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo troopInfo == null, troopUin: " + paramLong);
      }
    }
    do
    {
      return;
      localMessageRemindReq.uOwnerUin = Long.parseLong(((TroopInfo)localObject).troopowneruin);
      localMessageRemindReq.dwAppId = AppSetting.getAppId();
      localMessageRemindReq.sKey = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getAccount());
      if (localMessageRemindReq.sKey != null)
      {
        localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "GroupCare.getMessageRemindInfo");
        ((ToServiceMsg)localObject).extraData.putSerializable("req", localMessageRemindReq);
        this.app.sendToService((ToServiceMsg)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo skey == null, troopUin: " + paramLong);
  }
  
  public int j(MessageRecord paramMessageRecord)
  {
    int j = Q(paramMessageRecord.vipBubbleID);
    if (j == 0) {
      return 0;
    }
    int i;
    if (paramMessageRecord.vipSubBubbleId != 0) {
      i = paramMessageRecord.vipSubBubbleId;
    }
    for (;;)
    {
      if ((i != 0) && (aL(j, i)))
      {
        paramMessageRecord.vipSubBubbleId = i;
        return i;
        String str = paramMessageRecord.getExtInfoFromExtStr("bubble_sub_id");
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, String.format("try get bubbleSubId from msg id %d : %s", new Object[] { Long.valueOf(paramMessageRecord.uniseq), str }));
        }
        if (!TextUtils.isEmpty(str)) {
          i = Integer.parseInt(str);
        }
      }
      else
      {
        paramMessageRecord.vipSubBubbleId = 0;
        return j;
      }
      i = 0;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aclh.class;
  }
  
  public void onDestroy()
  {
    if ((this.b != null) && (this.b.a != null)) {
      this.b.a.clear();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Font.fresh".equals(paramFromServiceMsg.getServiceCmd()))
    {
      switch (paramToServiceMsg.extraData.getInt("CMD"))
      {
      default: 
        return;
      case 1: 
        fs(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 3: 
        ft(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 2: 
        fu(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 4: 
        fv(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      fw(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("FriendClone.CloneAuthStatus".equals(paramFromServiceMsg.getServiceCmd()))
    {
      fx(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("groupnick.readitem".equals(paramFromServiceMsg.getServiceCmd()))
    {
      fy(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().startsWith("profilelogic."))
    {
      fz(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo"))
    {
      fA(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend"))
    {
      fB(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend"))
    {
      fC(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble"))
    {
      fD(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast"))
    {
      fE(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("Face.setFace"))
    {
      fF(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    notifyUI(paramToServiceMsg, 0, true, paramObject);
  }
  
  public void z(int paramInt1, String paramString, int paramInt2)
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(2);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("3.4.4.3058");
    localObject = new VipFontUpdate.TCheckReq();
    ((VipFontUpdate.TCheckReq)localObject).i32_font_id.set(paramInt1);
    ((VipFontUpdate.TCheckReq)localObject).i32_type.set(paramInt2);
    ((VipFontUpdate.TCheckReq)localObject).str_message_test.set(paramString);
    localTFontSsoReq.st_check_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Font.fresh");
    switch (NetworkState.getNetworkType())
    {
    case 2: 
    case 3: 
    default: 
      ((ToServiceMsg)localObject).setTimeout(5000L);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("CMD", 2);
      ((ToServiceMsg)localObject).extraData.putInt("hiboom_id", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("hiboom_text", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("hiboom_auth_type", paramInt2);
      sendPbReq((ToServiceMsg)localObject);
      return;
      ((ToServiceMsg)localObject).setTimeout(5000L);
      continue;
      ((ToServiceMsg)localObject).setTimeout(10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acle
 * JD-Core Version:    0.7.0.1
 */