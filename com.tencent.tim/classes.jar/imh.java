import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.config.Common;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class imh
{
  static volatile boolean Sv;
  static boolean Sw;
  static byte aA;
  static byte aB;
  static byte aC = 1;
  static byte aD = 0;
  static byte angle_local_background;
  static byte angle_local_front = 0;
  static byte angle_remote_background_0;
  static byte angle_remote_background_180;
  static byte angle_remote_background_270;
  static byte angle_remote_background_90;
  static byte angle_remote_front_0;
  static byte angle_remote_front_180;
  static byte angle_remote_front_270;
  static byte angle_remote_front_90;
  static int apN;
  static int apO;
  static int apP;
  static byte aq;
  static byte ar;
  static byte as;
  static byte at;
  static byte au;
  static byte av;
  static byte aw;
  static byte ax;
  static byte ay;
  static byte az;
  static byte bace_camera_format;
  static byte dAudio_enable;
  static byte front_camera_format;
  static volatile boolean isReadDone;
  imm a = null;
  img b = null;
  byte[] configMsg = null;
  String m_Appid = null;
  Context m_Context = null;
  
  static
  {
    angle_local_background = 0;
    angle_remote_front_0 = 0;
    angle_remote_front_90 = 0;
    angle_remote_front_180 = 0;
    angle_remote_front_270 = 0;
    angle_remote_background_0 = 0;
    angle_remote_background_90 = 0;
    angle_remote_background_180 = 0;
    angle_remote_background_270 = 0;
    apN = 1;
    ar = 0;
    as = 0;
    at = 0;
    au = 0;
    av = 0;
    aw = 0;
    ax = 0;
    ay = 0;
    az = 0;
    aA = 0;
    apO = 1;
    front_camera_format = 0;
    bace_camera_format = 0;
    dAudio_enable = 1;
    apP = -1;
  }
  
  public imh(String paramString, Context paramContext)
  {
    this.m_Appid = paramString;
    this.m_Context = paramContext;
    this.a = new imm();
    imm.getCpuInfo();
    this.b = new img();
  }
  
  static void GetAngleInfo(Context paramContext)
  {
    int i = 0;
    Object localObject = ijc.a(paramContext);
    if (!((imf)localObject).isEmpty())
    {
      ils localils = new ils();
      Sv = localils.b((imf)localObject);
      if (Sv)
      {
        angle_local_front = localils.I;
        angle_local_background = localils.M;
        angle_remote_front_0 = localils.N;
        angle_remote_front_90 = localils.O;
        angle_remote_front_180 = localils.P;
        angle_remote_front_270 = localils.Q;
        angle_remote_background_0 = localils.R;
        angle_remote_background_90 = localils.S;
        angle_remote_background_180 = localils.T;
        angle_remote_background_270 = localils.U;
        aq = localils.V;
        apN = localils.aoK;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + angle_local_front + ", angle_local_background: " + angle_local_background + ", angle_remote_front_0: " + angle_remote_front_0 + ", angle_remote_front_90: " + angle_remote_front_90 + ", angle_remote_front_180: " + angle_remote_front_180 + ", angle_remote_front_270: " + angle_remote_front_270 + ", angle_remote_background_0: " + angle_remote_background_0 + ", angle_remote_background_90: " + angle_remote_background_90 + ", angle_remote_background_180: " + angle_remote_background_180 + ", angle_remote_background_270: " + angle_remote_background_270 + ", angle_sensor: " + aq + ", angle_mini_sdk:" + apN);
        }
      }
      boolean bool = localils.d((imf)localObject);
      i = bool;
      if (bool)
      {
        ar = localils.W;
        as = localils.X;
        at = localils.Y;
        au = localils.Z;
        av = localils.aa;
        aw = localils.ab;
        ax = localils.ac;
        ay = localils.ad;
        az = localils.ae;
        aA = localils.af;
        aB = localils.ag;
        apO = localils.aoM;
        i = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("ConfigSystemImpl", 2, "angle_landscape_local_front: " + ar + ", angle_landscape_local_back: " + as + ", angle_landscape_remote_front_0: " + at + ", angle_landscape_remote_front_90: " + au + ", angle_landscape_remote_front_180: " + av + ", angle_landscape_remote_front_270: " + aw + ", angle_landscape_remote_back_0: " + ax + ", angle_landscape_remote_back_90: " + ay + ", angle_landscape_remote_back_180: " + az + ", angle_landscape_remote_back_270: " + aA + ", angle_landscape_sensor: " + aB + ", angle_landscape_mini_sdk:" + apO);
          i = bool;
        }
      }
    }
    if (Sv) {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "using new camera angle config");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ConfigSystemImpl", 2, "using old camera angle config");
            }
            if ((i != 0) && (QLog.isColorLevel())) {
              QLog.d("ConfigSystemImpl", 2, "using new camera angle landscape config");
            }
            paramContext = Common.readFile(paramContext, "VideoConfigInfo");
          } while (paramContext == null);
          localObject = new img();
        } while (((img)localObject).k(paramContext) != 0);
        paramContext = ((img)localObject).a();
      } while (paramContext == null);
      angle_local_front = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForLocalPreview;
      angle_local_background = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForLocalPreview;
      angle_remote_front_0 = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_0;
      angle_remote_front_90 = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_90;
      angle_remote_front_180 = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_180;
      angle_remote_front_270 = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_270;
      angle_remote_background_0 = paramContext.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_0;
      angle_remote_background_90 = paramContext.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_90;
      angle_remote_background_180 = paramContext.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_180;
      angle_remote_background_270 = paramContext.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_270;
      front_camera_format = paramContext.jdField_a_of_type_Img$b$a.m_FrontCameraFormat;
      bace_camera_format = paramContext.jdField_a_of_type_Img$b$a.m_BackCameraFormat;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + angle_local_front + ", angle_local_background: " + angle_local_background + ", angle_remote_front_0: " + angle_remote_front_0 + ", angle_remote_front_90: " + angle_remote_front_90 + ", angle_remote_front_180: " + angle_remote_front_180 + ", angle_remote_front_270: " + angle_remote_front_270 + ", angle_remote_background_0: " + angle_remote_background_0 + ", angle_remote_background_90: " + angle_remote_background_90 + ", angle_remote_background_180: " + angle_remote_background_180 + ", angle_remote_background_270: " + angle_remote_background_270);
  }
  
  public static String R(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload not have config file");
      }
      return "";
    }
    img localimg = new img();
    if (localimg.k(paramContext) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload unPack TLV video config err");
      }
      return "";
    }
    paramContext = localimg.a();
    if (paramContext != null) {
      return paramContext.On;
    }
    return "";
  }
  
  public static int W(Context paramContext)
  {
    if (apP >= 0) {
      return apP;
    }
    try
    {
      paramContext = jkg.get(paramContext, "ro.qq.camera.sensor");
      if (!TextUtils.isEmpty(paramContext)) {
        apP = Integer.parseInt(paramContext);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        apP = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "read system sensor property fail", paramContext);
        }
        if (apP < 0) {
          apP = 0;
        }
      }
    }
    finally
    {
      if (apP >= 0) {
        break label91;
      }
      apP = 0;
    }
    return apP;
  }
  
  static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!isReadDone) {}
    label59:
    label71:
    do
    {
      do
      {
        try
        {
          if (!isReadDone)
          {
            GetAngleInfo(paramContext);
            isReadDone = true;
          }
          byte b1 = 0;
          if (!paramBoolean3) {
            break label71;
          }
          if (!paramBoolean2) {
            break label59;
          }
          if (paramBoolean1)
          {
            b1 = ar;
            return b1;
          }
        }
        finally {}
        return angle_local_front;
        if (paramBoolean1) {
          return as;
        }
        return angle_local_background;
        if (paramBoolean4)
        {
          if (paramBoolean1) {
            return aB;
          }
          return aq;
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramByte == 0)
        {
          if (paramBoolean1) {
            return at;
          }
          return angle_remote_front_0;
        }
        if (paramByte == 1)
        {
          if (paramBoolean1) {
            return au;
          }
          return angle_remote_front_90;
        }
        if (paramByte == 2)
        {
          if (paramBoolean1) {
            return av;
          }
          return angle_remote_front_180;
        }
      } while (paramByte != 3);
      if (paramBoolean1) {
        return aw;
      }
      return angle_remote_front_270;
      if (paramByte == 0)
      {
        if (paramBoolean1) {
          return ax;
        }
        return angle_remote_background_0;
      }
      if (paramByte == 1)
      {
        if (paramBoolean1) {
          return ay;
        }
        return angle_remote_background_90;
      }
      if (paramByte == 2)
      {
        if (paramBoolean1) {
          return az;
        }
        return angle_remote_background_180;
      }
    } while (paramByte != 3);
    if (paramBoolean1) {
      return aA;
    }
    return angle_remote_background_270;
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if ((!paramBoolean3) || (Sv)) {
      return i;
    }
    return W(paramContext);
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    Object localObject1;
    boolean bool;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateAVSwitchTypeTLV, msg[");
      if (paramArrayOfByte != null)
      {
        bool = true;
        QLog.w("ConfigSystemImpl", 1, bool + "]");
      }
    }
    else
    {
      localObject2 = null;
      localObject1 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject1 = Common.readFile(paramContext, "VideoConfigInfo");
      }
      if (localObject1 != null) {
        break label192;
      }
      paramContext = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV, not config");
        paramContext = localObject2;
      }
      label93:
      if (paramContext == null) {
        break label278;
      }
      dAudio_enable = paramContext.ah;
      aC = paramContext.ao;
      aD = paramContext.ap;
      Sw = true;
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV, dAudio_enable[" + dAudio_enable + "], dSmallScrren_enable[" + aC + "], dAudioHowlingEnable[" + aD + "]");
      }
    }
    label192:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
      paramContext = new img();
      int i = paramContext.k((byte[])localObject1);
      if (i != 0)
      {
        paramContext = localObject2;
        if (!QLog.isColorLevel()) {
          break label93;
        }
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV err, ret[" + i + "]");
        paramContext = localObject2;
        break label93;
      }
      paramArrayOfByte = paramContext.a();
      paramContext = localObject2;
      if (paramArrayOfByte == null) {
        break label93;
      }
      paramContext = paramArrayOfByte.jdField_a_of_type_Img$b$e;
      break label93;
    }
    label278:
    QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV info == null");
  }
  
  public static byte[] a(long paramLong, String paramString, Context paramContext)
  {
    itl.a().al("request", -1);
    return new imh(paramString, paramContext).b(paramLong);
  }
  
  public static boolean aa(Context paramContext)
  {
    boolean bool = true;
    if (!Sw) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel()) {
      QLog.w("ConfigSystemImpl", 1, "isAudioHowlingEnable[" + aD + "]");
    }
    if (aD == 1) {
      bool = false;
    }
    return bool;
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (!Sv) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "server config enabled");
      }
    }
    return i;
    label41:
    return W(paramContext);
  }
  
  public static int[] d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      img localimg;
      do
      {
        return null;
        localimg = new img();
        if (localimg.k(paramArrayOfByte) == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystemImpl", 2, "unPack PB err");
      return null;
      paramArrayOfByte = localimg.a();
    } while ((paramArrayOfByte == null) || (!paramArrayOfByte.jdField_a_of_type_Img$b$c.Su));
    return new int[] { paramArrayOfByte.jdField_a_of_type_Img$b$c.apf, paramArrayOfByte.jdField_a_of_type_Img$b$c.apg, paramArrayOfByte.jdField_a_of_type_Img$b$c.aph, paramArrayOfByte.jdField_a_of_type_Img$b$c.api, paramArrayOfByte.jdField_a_of_type_Img$b$c.apj, paramArrayOfByte.jdField_a_of_type_Img$b$c.apk, paramArrayOfByte.jdField_a_of_type_Img$b$c.apl, paramArrayOfByte.jdField_a_of_type_Img$b$c.apm, paramArrayOfByte.jdField_a_of_type_Img$b$c.apo, paramArrayOfByte.jdField_a_of_type_Img$b$c.apq, paramArrayOfByte.jdField_a_of_type_Img$b$c.apr, paramArrayOfByte.jdField_a_of_type_Img$b$c.aps };
  }
  
  public static boolean isDAudioEnable(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isDAudioEnable:" + dAudio_enable);
    }
    return dAudio_enable == 1;
  }
  
  public static boolean isNeedStartVideoProcess(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isNeedStartVideoProcess");
    }
    if (paramArrayOfByte != null)
    {
      paramString = new imh(paramString, paramContext);
      paramString.setConfigMsg(paramArrayOfByte);
      paramString.WriteConfigInfoToFile();
      return paramString.isNeedStartVideoProcess();
    }
    return false;
  }
  
  public static boolean tY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isSupportSmallScreen --> " + aC);
    }
    return true;
  }
  
  public void WriteConfigInfoToFile()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("WriteConfigInfoToFile begin, configMsg[");
      if (this.configMsg != null)
      {
        localObject1 = Integer.valueOf(this.configMsg.length);
        QLog.w("ConfigSystemImpl", 1, localObject1 + "]");
      }
    }
    else if ((this.configMsg != null) && (this.configMsg.length > 0))
    {
      Common.writeFile(this.m_Context, "VideoConfigInfo", this.configMsg);
      dAudio_enable = 1;
      a(this.m_Context, this.configMsg);
      localObject1 = j(this.configMsg);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label357;
      }
      localObject2 = ((String)localObject1).substring(0, 1);
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, sharpConfigType[" + (String)localObject2 + "]");
      }
      if (!((String)localObject2).equals("0")) {
        break label231;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, SHARP_CONFIG_TYPE_CLEAR");
      }
      Common.writeFile(this.m_Context, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
      localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
      this.m_Context.sendBroadcast((Intent)localObject1);
    }
    label231:
    do
    {
      return;
      localObject1 = null;
      break;
      if (((String)localObject2).equals("1"))
      {
        localObject1 = ((String)localObject1).substring(2);
        if (QLog.isColorLevel()) {
          QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, FileName[" + Common.SHARP_CONFIG_PAYLOAD_FILE_NAME + "], payload[\n" + (String)localObject1 + "\n]");
        }
        Common.writeFile(this.m_Context, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, ((String)localObject1).getBytes());
        localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        this.m_Context.sendBroadcast((Intent)localObject1);
        return;
      }
    } while ((!((String)localObject2).equals("2")) || (!QLog.isColorLevel()));
    QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile SharpConfigPayload url");
    return;
    label357:
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, sharpConfigPayload为空");
    }
    Common.writeFile(this.m_Context, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
    Object localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    this.m_Context.sendBroadcast((Intent)localObject1);
  }
  
  public byte[] b(long paramLong)
  {
    Object localObject = this.b;
    localObject.getClass();
    localObject = new img.d((img)localObject);
    ((img.d)localObject).deviceType = 201;
    ((img.d)localObject).osType = this.a.getOsType();
    ((img.d)localObject).apF = imm.getCpuArchitecture();
    ((img.d)localObject).apG = imm.getNumCores();
    ((img.d)localObject).cpuFreq = ((int)(imm.getMaxCpuFreq() / 1000L));
    ((img.d)localObject).apH = 0;
    ((img.d)localObject).apI = 0;
    ((img.d)localObject).apJ = 0;
    ((img.d)localObject).screenWidth = this.a.mdispWidth;
    ((img.d)localObject).screenHeight = this.a.mdispHeight;
    ((img.d)localObject).apK = 22;
    ((img.d)localObject).apL = ConfigInfo.getSharpConfigVersionFromFile(this.m_Context);
    ((img.d)localObject).apM = 37;
    ((img.d)localObject).appID = this.m_Appid;
    ((img.d)localObject).os_version = ("android_" + Build.VERSION.RELEASE);
    ((img.d)localObject).deviceName = imm.getDeviceNameForConfigSystem();
    ((img.d)localObject).Or = Build.VERSION.INCREMENTAL;
    ((img.d)localObject).appVersion = Common.getVersion(this.m_Context);
    this.b.a(paramLong, (img.d)localObject);
    return this.b.v();
  }
  
  public boolean isNeedStartVideoProcess()
  {
    return false;
  }
  
  public String j(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload not have config file");
      }
      return "";
    }
    img localimg = new img();
    if (localimg.k(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = localimg.a();
    if (paramArrayOfByte != null)
    {
      QLog.w("ConfigSystemImpl", 1, "getSharpConfigPayload, Content[\n" + paramArrayOfByte.m_sharpConfigPayload + "\n], test[\n" + paramArrayOfByte.On + "\n]");
      return paramArrayOfByte.m_sharpConfigPayload;
    }
    return "";
  }
  
  void setConfigMsg(byte[] paramArrayOfByte)
  {
    this.configMsg = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imh
 * JD-Core Version:    0.7.0.1
 */