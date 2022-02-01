import android.os.Handler;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.SupportFace.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class ikw
  extends iku
{
  private boolean RY;
  private int aok = -1;
  private int aol = -1;
  private int aom = -1;
  private int aon = -1;
  
  public ikw(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private boolean tF()
  {
    return iow.uX();
  }
  
  private boolean tG()
  {
    return iow.uZ();
  }
  
  private boolean tH()
  {
    return iow.uY();
  }
  
  private boolean tI()
  {
    return iow.uZ();
  }
  
  public int an(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.aok;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.aol;
    }
    if ("SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString)) {
      return this.aom;
    }
    if ("creative".equalsIgnoreCase(paramString)) {
      return this.aon;
    }
    return -1;
  }
  
  public void anD()
  {
    boolean bool2 = ikx.tM();
    if (angh.ay(BaseApplicationImpl.getContext()) == 1) {}
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoController localVideoController = this.mApp.b();
      bool3 = tF();
      if ((bool3) && (bool2)) {
        localVideoController.d(1, "SUPPORT_TRUE");
      }
      bool4 = tI();
      if ((bool4) && (bool2)) {
        localVideoController.d(3, "SUPPORT_SWITCH_FACE");
      }
      bool5 = tG();
      if ((bool5) && (bool2)) {
        localVideoController.d(3, "SUPPORT_TRUE");
      }
      bool6 = tH();
      if ((bool6) && (bool1))
      {
        AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
        localAVFunChatMessage.uint64_type.set(14L);
        localAVFunChatMessage.enum_operator.set(1);
        localAVFunChatMessage.str_msg.set("SUPPORT_CREATIVECOP_TRUE");
        localVideoController.a(14, localAVFunChatMessage);
      }
      if ((!bool3) || (!bool4) || (!bool5) || (!bool6)) {
        break;
      }
      return;
    }
    QLog.w("SupportFace", 1, "sendSupportMsg, normal[" + bool3 + "], switchfaceStandard[" + bool4 + "], interact[" + bool5 + "], creativePendant[" + bool6 + "], isSOExist[" + bool2 + "],isPagSoExist[" + bool1 + "]");
  }
  
  public boolean ct(String paramString)
  {
    boolean bool = false;
    igd.aK("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.model, Integer.valueOf(this.sdkVersion), Long.valueOf(this.lz), Integer.valueOf(this.aoj), Long.valueOf(this.lA) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      bool = tF();
    }
    do
    {
      return bool;
      if ("interact".equalsIgnoreCase(paramString)) {
        return tG();
      }
      if ("SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString)) {
        return tI();
      }
    } while (!"creative".equalsIgnoreCase(paramString));
    return tH();
  }
  
  public boolean e(int paramInt, String paramString)
  {
    if (!this.RY) {
      asfe.getUIHandler().postDelayed(new SupportFace.1(this), 1100L);
    }
    igd.aJ("SupportFace", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      if (!paramString.equals("SUPPORT_TRUE")) {
        break label123;
      }
      if (paramInt != 1) {
        break label83;
      }
      this.aok = 1;
    }
    label83:
    label123:
    do
    {
      return false;
      if (paramInt == 3)
      {
        this.aok = 1;
        this.aol = 1;
        return false;
      }
      if (paramInt == 14)
      {
        this.aon = 1;
        igd.aJ("SupportFace", "onReceiveSupportMessage  support reason 1:");
        return false;
      }
      return true;
      if (paramString.equals("SUPPORT_FALSE"))
      {
        if (paramInt == 1)
        {
          this.aok = 0;
          this.aol = 0;
        }
        for (;;)
        {
          return true;
          if (paramInt == 3)
          {
            this.aol = 0;
          }
          else if (paramInt == 14)
          {
            this.aon = 0;
            igd.aJ("SupportFace", "onReceiveSupportMessage not support reason 1:");
          }
        }
      }
      if (paramString.equals("SUPPORT_SWITCH_FACE"))
      {
        if (paramInt == 3) {
          this.aom = 1;
        }
        return true;
      }
      if (paramString.equals("SUPPORT_CREATIVECOP_TRUE"))
      {
        if (paramInt == 14)
        {
          this.aon = 1;
          igd.aJ("SupportFace", "onReceiveSupportMessage  support reason 2:");
        }
        return true;
      }
    } while (!paramString.equals("SUPPORT_CREATIVECOP_FALSE"));
    if (paramInt == 14)
    {
      this.aon = 0;
      igd.aJ("SupportFace", "onReceiveSupportMessage  not support reason 2:");
    }
    return true;
  }
  
  public void restore()
  {
    this.RY = false;
    this.aok = -1;
    this.aol = -1;
    this.aom = -1;
    this.aon = -1;
    igd.aJ("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikw
 * JD-Core Version:    0.7.0.1
 */