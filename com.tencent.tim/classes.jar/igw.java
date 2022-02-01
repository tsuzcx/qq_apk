import com.qq.jce.wup.UniPacket;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class igw
{
  private static igw jdField_a_of_type_Igw;
  private static final String[] aJ = { "UNKNOWN", "WIFI", "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET" };
  private strupbuff jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff = new strupbuff(this.cN);
  private igw.a jdField_a_of_type_Igw$a = new igw.a();
  private byte[] aL = new byte[256];
  private int ale;
  private Map<String, ArrayList<byte[]>> cN = new ConcurrentHashMap();
  private UniPacket client = new UniPacket(true);
  
  private int a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.cN == null) || (this.client == null) || (this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff == null)) {
      return 0;
    }
    this.cN.clear();
    this.cN.put("617", new ArrayList());
    ((ArrayList)this.cN.get("617")).add(paramArrayOfByte);
    this.client.put("Data", this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff);
    paramArrayOfByte = this.client.encode();
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setNeedRemindSlowNetwork(false);
    try
    {
      int i = MsfServiceSdk.get().sendMsg(localToServiceMsg);
      if (i >= 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return 0;
  }
  
  public static igw a()
  {
    if (jdField_a_of_type_Igw == null) {
      jdField_a_of_type_Igw = new igw();
    }
    return jdField_a_of_type_Igw;
  }
  
  private int ae(String paramString)
  {
    int k = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramString.length) {
          break;
        }
        this.aL[this.ale] = paramString[i];
        this.ale += 1;
        i += 1;
      }
      return j;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      j = -1;
    }
  }
  
  private void bv(long paramLong)
  {
    int i = (byte)(int)(paramLong >> 56 & 0xFF);
    int j = (byte)(int)(paramLong >> 48 & 0xFF);
    int k = (byte)(int)(paramLong >> 40 & 0xFF);
    int m = (byte)(int)(paramLong >> 32 & 0xFF);
    int n = (byte)(int)(paramLong >> 24 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 16 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 8 & 0xFF);
    int i3 = (byte)(int)(0xFF & paramLong);
    this.aL[this.ale] = i;
    this.aL[(this.ale + 1)] = j;
    this.aL[(this.ale + 2)] = k;
    this.aL[(this.ale + 3)] = m;
    this.aL[(this.ale + 4)] = n;
    this.aL[(this.ale + 5)] = i1;
    this.aL[(this.ale + 6)] = i2;
    this.aL[(this.ale + 7)] = i3;
    this.ale += 8;
  }
  
  private int co(int paramInt)
  {
    int i;
    if (this.aL == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return i;
                kl(this.jdField_a_of_type_Igw$a.LU.length());
                j = ae(this.jdField_a_of_type_Igw$a.LU);
                i = j;
              } while (j < 0);
              kl(this.jdField_a_of_type_Igw$a.LV.length());
              j = ae(this.jdField_a_of_type_Igw$a.LV);
              i = j;
            } while (j < 0);
            kl(this.jdField_a_of_type_Igw$a.LW.length());
            j = ae(this.jdField_a_of_type_Igw$a.LW);
            i = j;
          } while (j < 0);
          kl(this.jdField_a_of_type_Igw$a.LZ.length());
          j = ae(this.jdField_a_of_type_Igw$a.LZ);
          i = j;
        } while (j < 0);
        kl(this.jdField_a_of_type_Igw$a.LX.length());
        j = ae(this.jdField_a_of_type_Igw$a.LX);
        i = j;
      } while (j < 0);
      kl(this.jdField_a_of_type_Igw$a.LY.length());
      j = ae(this.jdField_a_of_type_Igw$a.LY);
      i = j;
    } while (j < 0);
    bv(this.jdField_a_of_type_Igw$a.kC);
    bv(this.jdField_a_of_type_Igw$a.kA);
    kk(this.jdField_a_of_type_Igw$a.alf);
    bv(this.jdField_a_of_type_Igw$a.kB);
    kk(this.jdField_a_of_type_Igw$a.alg);
    kk(paramInt);
    return 0;
  }
  
  public static void e(long paramLong1, long paramLong2, int paramInt)
  {
    igw localigw = a();
    localigw.g(0L, paramLong1, paramLong2);
    localigw.a(paramInt, 2, paramLong2);
  }
  
  private String gF()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  
  private int getApn()
  {
    int i = 0;
    String str = aqiw.K(BaseApplication.getContext());
    if ("wifi".equals(str)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_OffLine", 2, "getApn: " + i);
      }
      return i;
      if ("cmnet".equals(str)) {
        i = 3;
      } else if ("cmwap".equals(str)) {
        i = 2;
      } else if ("ctnet".equals(str)) {
        i = 7;
      } else if ("ctwap".equals(str)) {
        i = 6;
      } else if ("uninet".equals(str)) {
        i = 5;
      } else if ("uniwap".equals(str)) {
        i = 4;
      } else if ("3gnet".equals(str)) {
        i = 9;
      } else if ("3gwap".equals(str)) {
        i = 8;
      }
    }
  }
  
  private void kk(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    this.aL[this.ale] = i;
    this.ale += 1;
  }
  
  private void kl(int paramInt)
  {
    int i = (byte)(paramInt >> 8 & 0xFF);
    int j = (byte)(paramInt & 0xFF);
    this.aL[this.ale] = i;
    this.aL[(this.ale + 1)] = j;
    this.ale += 2;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_Igw$a == null) {
      paramInt2 = -1;
    }
    do
    {
      return paramInt2;
      int j = getApn();
      this.jdField_a_of_type_Igw$a.LY = aJ[j];
      this.jdField_a_of_type_Igw$a.LX = gF();
      this.jdField_a_of_type_Igw$a.alf = 0;
      this.jdField_a_of_type_Igw$a.alg = paramInt2;
      if (paramLong != 0L) {
        this.jdField_a_of_type_Igw$a.kB = paramLong;
      }
      this.ale = 0;
      if (co(paramInt1) < 0) {
        return -1;
      }
      if (this.ale <= 0) {
        break;
      }
      byte[] arrayOfByte = new byte[this.ale];
      paramInt2 = 0;
      while (paramInt2 < this.ale)
      {
        arrayOfByte[paramInt2] = this.aL[paramInt2];
        paramInt2 += 1;
      }
      a(this.jdField_a_of_type_Igw$a.kA, arrayOfByte);
      this.ale = 0;
      paramInt2 = i;
    } while (!QLog.isColorLevel());
    QLog.d("SharpReport_Node", 2, "report_node is" + paramInt1);
    return 0;
    return -1;
  }
  
  public void g(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Igw$a == null) {
      return;
    }
    this.jdField_a_of_type_Igw$a.kB = paramLong3;
    this.jdField_a_of_type_Igw$a.kA = paramLong2;
    this.jdField_a_of_type_Igw$a.kC = paramLong1;
    this.jdField_a_of_type_Igw$a.LW = String.valueOf(AppSetting.getAppId());
    this.jdField_a_of_type_Igw$a.LZ = AppSetting.getLC();
  }
  
  public class a
  {
    String LU = null;
    String LV = null;
    String LW = null;
    String LX = null;
    String LY = null;
    String LZ = null;
    int alf = 0;
    int alg = 0;
    long kA = 0L;
    long kB = 0L;
    long kC = 0L;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igw
 * JD-Core Version:    0.7.0.1
 */