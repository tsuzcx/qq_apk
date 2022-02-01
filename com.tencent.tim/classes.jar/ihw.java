import com.tencent.av.VideoController;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ihw
{
  public static void a(long paramLong, VideoController paramVideoController, ihw.a.a parama, ihw.a parama1)
  {
    long l1 = System.currentTimeMillis();
    String str = parama.gH();
    paramVideoController = paramVideoController.a(paramLong, parama.kH(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + parama.akU + "], sampleMD5[" + parama.MF + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      NativeCodec.hardwareCodecLevelInfo();
      QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + imm.getNumCores() + ", cpu frep: " + imm.getMaxCpuFreq() + ", memory: " + imm.bD() + ", output format: " + ioc.lm() + ", H264EncBaseLineLevel: " + NativeCodec.mH264EncBaseLineLevel + ", H264DecBaseLineLevel: " + NativeCodec.mH264DecBaseLineLevel + ", H264EncHighProfileLevel: " + NativeCodec.mH264EncHighProfileLevel + ", H264DecHighProfileLevel: " + NativeCodec.mH264DecHighProfileLevel + ", H265EncLevel: " + NativeCodec.mH265EncLevel + ", H265DecLevel: " + NativeCodec.mH265DecLevel);
      parama = new iof('=', ';');
      parama.unflatten(paramVideoController);
      parama1.a(parama.getInt("i_resultCode", -99), "", 0, parama.getInt("i_delay", -99), null);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);
    
    public static class a
    {
      public String MF;
      public String MG;
      public String MH;
      public String MI;
      public int akU;
      public int amk;
      public int aml;
      
      public String gH()
      {
        iof localiof = new iof('=', ';');
        localiof.set("s_path", this.MG);
        if (sJ())
        {
          localiof.set("i_fps", this.amk);
          localiof.set("i_bitrate", this.aml);
          localiof.set("s_outpath", this.MI);
          File localFile = new File(this.MI);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        for (;;)
        {
          return localiof.flatten();
          localiof.set("s_expMd5", this.MH);
        }
      }
      
      public int kH()
      {
        if (this.akU == 1) {
          return 2;
        }
        if (this.akU == 4) {
          return 1;
        }
        if (this.akU == 2) {
          return 4;
        }
        if (this.akU == 8) {
          return 3;
        }
        return 0;
      }
      
      public boolean sJ()
      {
        boolean bool2 = false;
        boolean bool1;
        if ((this.akU == 2) || (this.akU == 8)) {
          bool1 = true;
        }
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (this.akU == 1);
          bool1 = bool2;
        } while (this.akU != 4);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihw
 * JD-Core Version:    0.7.0.1
 */