import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class aseq
  implements asel
{
  private asen jdField_a_of_type_Asen;
  private aset jdField_a_of_type_Aset;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  private Context mContext;
  private long mSelfUin;
  
  public aseq(Context paramContext, long paramLong, asen paramasen)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.jdField_a_of_type_Asen = paramasen;
    this.jdField_a_of_type_Asen.a(this);
    asey.a().fT(this.mContext);
    this.jdField_a_of_type_Aset = new aset(this.mContext, this.mSelfUin, this.jdField_a_of_type_Asen);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = this.jdField_a_of_type_Aset.a();
    ClientLogReport.instance();
    GAClientLogReport.instance();
  }
  
  public static void a(asen paramasen)
  {
    if (paramasen != null) {
      paramasen.emR();
    }
  }
  
  public static void a(asen paramasen, Context paramContext, long paramLong)
  {
    if (paramasen != null) {
      paramasen.bJ(imh.a(paramLong, String.valueOf(AppSetting.getAppId()), paramContext));
    }
  }
  
  public static int getApn()
  {
    int i;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    for (;;)
    {
      asev.d("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
      return i;
      if (AppNetConnInfo.isMobileConn()) {
        switch (AppNetConnInfo.getMobileInfo())
        {
        default: 
          i = 100;
          break;
        case 1: 
          i = 3;
          break;
        case 2: 
          i = 9;
          break;
        case 3: 
          i = 11;
          break;
        case 4: 
          i = 14;
          break;
        }
      } else {
        i = 0;
      }
    }
  }
  
  public aser a()
  {
    return this.jdField_a_of_type_Aset;
  }
  
  public void bK(byte[] paramArrayOfByte) {}
  
  public void bL(byte[] paramArrayOfByte) {}
  
  public void bM(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(1, paramArrayOfByte);
    }
  }
  
  public void bN(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(2, paramArrayOfByte);
    }
  }
  
  public void bO(byte[] paramArrayOfByte)
  {
    imh.isNeedStartVideoProcess(String.valueOf(AppSetting.getAppId()), this.mContext, paramArrayOfByte);
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aset != null)
    {
      this.jdField_a_of_type_Aset.destroy();
      this.jdField_a_of_type_Aset = null;
    }
    this.mContext = null;
    this.mSelfUin = 0L;
    this.jdField_a_of_type_Asen = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  }
  
  public void gB(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aseq
 * JD-Core Version:    0.7.0.1
 */