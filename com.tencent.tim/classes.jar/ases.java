import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import java.util.ArrayList;

public class ases
  implements iny
{
  protected asen a;
  protected QQGAudioCtrl a;
  protected Context mContext;
  protected long mSelfUin;
  
  public ases(Context paramContext, long paramLong, asen paramasen)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.jdField_a_of_type_Asen = paramasen;
    loadLibrary();
    alE();
  }
  
  private void alE()
  {
    asev.d("MultiOperatorBase", "initGAudioCtrl");
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          int i = aseq.getApn();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(AppSetting.getAppId());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.mContext, this.mSelfUin, 1, "3.4.4");
          ClientLogReport.instance().init(this.mContext, AppSetting.getAppId());
          GAClientLogReport.instance();
          return;
        }
        asev.e("MultiOperatorBase", "initGAudioCtrl create instance fail.");
        return;
      }
    }
    catch (Exception localException)
    {
      asev.e("MultiOperatorBase", "initGAudioCtrl  fail.", localException);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
  }
  
  private void emT()
  {
    asev.d("MultiOperatorBase", "unInitGAudioCtrl");
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.uninit();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      }
      return;
    }
    catch (Exception localException)
    {
      asev.e("MultiOperatorBase", "unInitGAudioCtrl  fail.", localException);
    }
  }
  
  private boolean loadLibrary()
  {
    asev.d("MultiOperatorBase", "loadLibrary");
    try
    {
      SoLoadUtil.loadNativeLibrary(this.mContext, "c++_shared", 0, false);
      SoLoadUtil.loadNativeLibrary(this.mContext, "xplatform", 0, false);
      AVSoUtils.c(this.mContext, "SDKCommon", true);
      AVSoUtils.c(this.mContext, "VideoCtrl", true);
      AVSoUtils.c(this.mContext, "qav_media_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      asev.e("MultiOperatorBase", "loadLibrary fail.", localThrowable);
    }
    return false;
  }
  
  public void A(byte[] paramArrayOfByte) {}
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    return 0L;
  }
  
  public QQGAudioCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(int paramInt, long paramLong, itn paramitn) {}
  
  public void a(int paramInt, long paramLong, int... paramVarArgs) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long paramLong2, ArrayList<inx> paramArrayList) {}
  
  public void a(long paramLong, ArrayList<ini> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4) {}
  
  public void a(ini paramini, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs) {}
  
  public void a(inw paraminw) {}
  
  public void alT() {}
  
  public void alU() {}
  
  public iiv b()
  {
    return null;
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asen != null) {
      this.jdField_a_of_type_Asen.c(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  public void b(long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void bC(long paramLong) {}
  
  public void bD(long paramLong) {}
  
  public void c(int paramInt1, long paramLong, int paramInt2) {}
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void c(int paramInt, byte[] paramArrayOfByte) {}
  
  public void c(long paramLong1, long paramLong2, String paramString) {}
  
  public void destroy()
  {
    this.mContext = null;
    this.mSelfUin = 0L;
    this.jdField_a_of_type_Asen = null;
    emT();
  }
  
  public void e(int paramInt, ArrayList<ini> paramArrayList) {}
  
  public void e(long paramLong, ArrayList<ini> paramArrayList) {}
  
  public void f(int paramInt1, long paramLong, int paramInt2) {}
  
  public void g(long paramLong, int paramInt1, int paramInt2) {}
  
  public void h(long paramLong, int paramInt1, int paramInt2) {}
  
  public void i(long paramLong, int paramInt1, int paramInt2) {}
  
  public void j(long paramLong, int paramInt1, int paramInt2) {}
  
  public void ks(int paramInt) {}
  
  public void ku(int paramInt) {}
  
  public void m(long paramLong, int paramInt) {}
  
  public void o(int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ases
 * JD-Core Version:    0.7.0.1
 */