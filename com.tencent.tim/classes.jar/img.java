import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdReportClientInfoReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileHardWareValue;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.ReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.TransBuffer;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.VideoHardWareInfo;

public class img
{
  public static String Om = "";
  private img.a jdField_a_of_type_Img$a = new img.a();
  private img.c jdField_a_of_type_Img$c = new img.c();
  
  public img.b a()
  {
    img.b localb = null;
    if (this.jdField_a_of_type_Img$c != null) {
      localb = this.jdField_a_of_type_Img$c.a();
    }
    return localb;
  }
  
  public void a(long paramLong, img.d paramd)
  {
    this.jdField_a_of_type_Img$a.a(paramLong, paramd);
  }
  
  public int k(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Img$c != null) {
      return this.jdField_a_of_type_Img$c.l(paramArrayOfByte);
    }
    return -1;
  }
  
  public byte[] v()
  {
    byte[] arrayOfByte = null;
    if (this.jdField_a_of_type_Img$a != null) {
      arrayOfByte = this.jdField_a_of_type_Img$a.x();
    }
    return arrayOfByte;
  }
  
  public class a
  {
    private img.d jdField_a_of_type_Img$d;
    private hd_video_putinfo.ReqBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody = new hd_video_putinfo.ReqBody();
    private long lP;
    
    public a() {}
    
    private void aof()
    {
      hd_video_putinfo.PutinfoHead localPutinfoHead = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_putinfo_head.get();
      localPutinfoHead.enum_body_type.set(1);
      localPutinfoHead.uint64_uin.set(this.lP);
      localPutinfoHead.bytes_appid.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Img$d.appID.getBytes()));
      localPutinfoHead.uint64_seq.set(new Random().nextLong());
      localPutinfoHead.bytes_config_ver.set(ByteStringMicro.copyFrom(img.Om.getBytes()));
      this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_putinfo_head.set(localPutinfoHead);
    }
    
    private void aog()
    {
      hd_video_putinfo.CmdReportClientInfoReqBody localCmdReportClientInfoReqBody = (hd_video_putinfo.CmdReportClientInfoReqBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_report_client_info_req_body.get();
      localCmdReportClientInfoReqBody.uint32_mobile_type.set(this.jdField_a_of_type_Img$d.deviceType);
      localCmdReportClientInfoReqBody.uint32_mobile_os_info.set(this.jdField_a_of_type_Img$d.osType);
      localCmdReportClientInfoReqBody.uint32_instid.set(11001);
      localCmdReportClientInfoReqBody.bytes_client_system_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Img$d.os_version.getBytes()));
      localCmdReportClientInfoReqBody.bytes_device_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Img$d.deviceName.getBytes()));
      Object localObject = (hd_video_putinfo.MobileHardWareValue)localCmdReportClientInfoReqBody.msg_device_info.get();
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_struct.set(this.jdField_a_of_type_Img$d.apF);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_number.set(this.jdField_a_of_type_Img$d.apG);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_hertz.set(this.jdField_a_of_type_Img$d.cpuFreq);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_camera_turn.set(this.jdField_a_of_type_Img$d.apH);
      localCmdReportClientInfoReqBody.msg_device_info.set((MessageMicro)localObject);
      localObject = (hd_video_putinfo.VideoHardWareInfo)localCmdReportClientInfoReqBody.msg_video_info.get();
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_encodeframe.set(this.jdField_a_of_type_Img$d.apI);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_decodeframe.set(this.jdField_a_of_type_Img$d.apJ);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_width.set(this.jdField_a_of_type_Img$d.screenWidth);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_height.set(this.jdField_a_of_type_Img$d.screenHeight);
      localCmdReportClientInfoReqBody.msg_video_info.set((MessageMicro)localObject);
      localCmdReportClientInfoReqBody.bytes_mobile_rom_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Img$d.Or.getBytes()));
      localCmdReportClientInfoReqBody.uint32_sharp_sdk_ver.set(this.jdField_a_of_type_Img$d.apM);
      localCmdReportClientInfoReqBody.uint32_open_general_info.set(this.jdField_a_of_type_Img$d.apL);
      localCmdReportClientInfoReqBody.bytes_app_version.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Img$d.appVersion.getBytes()));
      this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_report_client_info_req_body.set(localCmdReportClientInfoReqBody);
    }
    
    public void a(long paramLong, img.d paramd)
    {
      this.lP = paramLong;
      this.jdField_a_of_type_Img$d = paramd;
    }
    
    public byte[] x()
    {
      aof();
      aog();
      return this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.toByteArray();
    }
  }
  
  public class b
  {
    String On = "";
    boolean St = true;
    img.b.a jdField_a_of_type_Img$b$a = new img.b.a();
    img.b.b jdField_a_of_type_Img$b$b = new img.b.b();
    img.b.c jdField_a_of_type_Img$b$c = new img.b.c();
    img.b.d jdField_a_of_type_Img$b$d = new img.b.d();
    img.b.e jdField_a_of_type_Img$b$e = new img.b.e();
    List<img.b.f> fk = new ArrayList();
    String m_sharpConfigPayload = "";
    
    public b() {}
    
    class a
    {
      byte m_BackCameraAngleForLocalPreview = 0;
      byte m_BackCameraAngleForRemote_0 = 0;
      byte m_BackCameraAngleForRemote_180 = 0;
      byte m_BackCameraAngleForRemote_270 = 0;
      byte m_BackCameraAngleForRemote_90 = 0;
      byte m_BackCameraFormat = 0;
      byte m_FrontCameraAngleForLocalPreview = 0;
      byte m_FrontCameraAngleForRemote_0 = 0;
      byte m_FrontCameraAngleForRemote_180 = 0;
      byte m_FrontCameraAngleForRemote_270 = 0;
      byte m_FrontCameraAngleForRemote_90 = 0;
      byte m_FrontCameraFormat = 0;
      
      a() {}
    }
    
    class b
    {
      String Oo = "";
      String Op = "";
      int aoX = 0;
      int aoY = 0;
      int aoZ = 0;
      int apa = 0;
      int apb = 0;
      int apc = 0;
      int apd = 0;
      int ape = 0;
      
      b() {}
    }
    
    class c
    {
      boolean Su = false;
      int apf = 0;
      int apg = 0;
      int aph = 0;
      int api = 0;
      int apj = 0;
      int apk = 0;
      int apl = 0;
      int apm = 0;
      int apo = 0;
      int apq = 0;
      int apr = 0;
      int aps = 0;
      int apt = 0;
      int apu = 0;
      int apv = 0;
      
      c() {}
    }
    
    class d
    {
      int apA = 0;
      int apB = 0;
      int apC = 0;
      int apD = 0;
      int apw = 0;
      int apx = 0;
      int apy = 0;
      int apz = 0;
      
      d() {}
    }
    
    class e
    {
      byte ah = 1;
      byte ai = 0;
      byte aj = 1;
      byte ak = 1;
      byte al = 1;
      byte am = 0;
      byte an = 0;
      byte ao = 0;
      byte ap = 0;
      
      e() {}
    }
    
    class f
    {
      String Oq = "";
      int apE = 0;
      
      f() {}
    }
  }
  
  public class c
  {
    private hd_video_putinfo.RspBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody = new hd_video_putinfo.RspBody();
    private img.b b = new img.b(img.this);
    
    public c() {}
    
    private int le()
    {
      int k = 0;
      int i;
      if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.has()) {
        i = -1;
      }
      Object localObject1;
      boolean bool;
      int j;
      label1260:
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.get();
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
              {
                i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
                localObject2 = this.b;
                if (i != 0) {
                  break;
                }
                bool = false;
                ((img.b)localObject2).St = bool;
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
                ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
              {
                localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForLocalPreview = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraAngleForLocalPreview = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_0 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_0 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_90 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_90 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_180 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_180 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraAngleForRemote_270 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraAngleForRemote_270 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
                this.b.jdField_a_of_type_Img$b$a.m_FrontCameraFormat = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
                this.b.jdField_a_of_type_Img$b$a.m_BackCameraFormat = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
              {
                localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
                this.b.jdField_a_of_type_Img$b$d.apw = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
                this.b.jdField_a_of_type_Img$b$d.apx = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
                this.b.jdField_a_of_type_Img$b$d.apy = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
                this.b.jdField_a_of_type_Img$b$d.apz = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
                this.b.jdField_a_of_type_Img$b$d.apA = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
                this.b.jdField_a_of_type_Img$b$d.apB = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
                this.b.jdField_a_of_type_Img$b$d.apC = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
                this.b.jdField_a_of_type_Img$b$d.apD = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
              {
                long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
                this.b.jdField_a_of_type_Img$b$e.ah = ((byte)(int)(l & 1L));
                this.b.jdField_a_of_type_Img$b$e.ai = ((byte)(int)(l >> 1 & 1L));
                this.b.jdField_a_of_type_Img$b$e.aj = ((byte)(int)(l >> 2 & 1L));
                this.b.jdField_a_of_type_Img$b$e.ak = ((byte)(int)(l >> 3 & 1L));
                this.b.jdField_a_of_type_Img$b$e.al = ((byte)(int)(l >> 4 & 1L));
                this.b.jdField_a_of_type_Img$b$e.am = ((byte)(int)(l >> 5 & 1L));
                this.b.jdField_a_of_type_Img$b$e.an = ((byte)(int)(l >> 6 & 1L));
                this.b.jdField_a_of_type_Img$b$e.ao = ((byte)(int)(l >> 7 & 1L));
                this.b.jdField_a_of_type_Img$b$e.ap = ((byte)(int)(l >> 13 & 1L));
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
              {
                this.b.jdField_a_of_type_Img$b$c.Su = true;
                localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
                this.b.jdField_a_of_type_Img$b$c.apf = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
                this.b.jdField_a_of_type_Img$b$c.apg = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
                this.b.jdField_a_of_type_Img$b$c.aph = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
                this.b.jdField_a_of_type_Img$b$c.api = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
                this.b.jdField_a_of_type_Img$b$c.apj = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
                this.b.jdField_a_of_type_Img$b$c.apk = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
                this.b.jdField_a_of_type_Img$b$c.apl = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
                this.b.jdField_a_of_type_Img$b$c.apm = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
                this.b.jdField_a_of_type_Img$b$c.apo = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
                this.b.jdField_a_of_type_Img$b$c.apq = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
                this.b.jdField_a_of_type_Img$b$c.apr = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
                this.b.jdField_a_of_type_Img$b$c.aps = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
                this.b.jdField_a_of_type_Img$b$c.apt = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
                this.b.jdField_a_of_type_Img$b$c.apu = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
                this.b.jdField_a_of_type_Img$b$c.apv = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
              }
              if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
              {
                localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
                this.b.jdField_a_of_type_Img$b$b.aoX = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
                this.b.jdField_a_of_type_Img$b$b.aoY = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
                this.b.jdField_a_of_type_Img$b$b.aoZ = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
                this.b.jdField_a_of_type_Img$b$b.apa = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
                this.b.jdField_a_of_type_Img$b$b.Oo = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
                this.b.jdField_a_of_type_Img$b$b.apb = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
                this.b.jdField_a_of_type_Img$b$b.apc = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
                this.b.jdField_a_of_type_Img$b$b.apd = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
                this.b.jdField_a_of_type_Img$b$b.ape = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
                this.b.jdField_a_of_type_Img$b$b.Op = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
              }
              i = k;
            } while (!((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has());
            localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
            i = k;
          } while (localObject1 == null);
          i = k;
        } while (((List)localObject1).size() <= 0);
        j = 0;
        i = k;
      } while (j >= ((List)localObject1).size());
      Object localObject2 = this.b;
      localObject2.getClass();
      localObject2 = new img.b.f((img.b)localObject2);
      ((img.b.f)localObject2).apE = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).uint32_type.get();
      ((img.b.f)localObject2).Oq = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).bytes_content.get().toStringUtf8();
      this.b.fk.add(localObject2);
      if (((img.b.f)localObject2).apE == 1) {
        this.b.m_sharpConfigPayload = ((img.b.f)localObject2).Oq;
      }
      for (;;)
      {
        j += 1;
        break label1260;
        bool = true;
        break;
        if (((img.b.f)localObject2).apE == 2) {
          this.b.On = ((img.b.f)localObject2).Oq;
        }
      }
    }
    
    public img.b a()
    {
      return this.b;
    }
    
    public int l(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return -1;
      }
      try
      {
        this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.mergeFrom(paramArrayOfByte);
        if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.has()) {
          return -1;
        }
        paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
        {
          if (paramArrayOfByte.bytes_config_ver.has()) {
            img.Om = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
          }
          int i = le();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return -1;
    }
  }
  
  public class d
  {
    String Or = "";
    int apF = 0;
    int apG = 0;
    int apH = 0;
    int apI = 0;
    int apJ = 0;
    int apK = 0;
    int apL = 0;
    int apM = 0;
    String appID = "";
    String appVersion = "";
    int cpuFreq = 0;
    String deviceName = "";
    int deviceType = 0;
    int osType = 0;
    String os_version = "";
    int screenHeight = 0;
    int screenWidth = 0;
    
    public d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     img
 * JD-Core Version:    0.7.0.1
 */