import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

class ackp
  extends SosoInterface.a
{
  ackp(ackn paramackn, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish errCode: " + paramInt + ", info: " + paramSosoLbsInfo);
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    if (paramInt != 0)
    {
      this.this$0.a(2L, null, 22);
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d3 = paramSosoLbsInfo.a.ce;
      double d4 = paramSosoLbsInfo.a.cd;
      double d1 = paramSosoLbsInfo.a.altitude;
      int j = (int)paramSosoLbsInfo.a.accuracy;
      String str1 = paramSosoLbsInfo.a.bro;
      String str2 = paramSosoLbsInfo.a.brn;
      int k = paramSosoLbsInfo.a.cAN;
      double d2 = paramSosoLbsInfo.a.RJ;
      float f = paramSosoLbsInfo.a.speed;
      String str3 = paramSosoLbsInfo.a.cityCode;
      paramInt = 0;
      try
      {
        int i = Integer.parseInt(str3);
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("RecommendTroopManagerImp", 1, "parse cityCode error");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish longitude=" + d3 + ", latitude=" + d4 + ", accuracy=" + j + ", verifyKey=" + str2 + ", source=" + str1 + ", fakeReason=" + k + ", speed=" + f + ", locationTime=" + d2);
      }
      d3 = Double.valueOf(paramSosoLbsInfo.a.cd * 1000000.0D).intValue();
      d4 = Double.valueOf(paramSosoLbsInfo.a.ce * 1000000.0D).intValue();
      paramSosoLbsInfo = new oidb_0x935.GPS();
      paramSosoLbsInfo.uint32_latitude.set((int)d3);
      paramSosoLbsInfo.uint32_longitude.set((int)d4);
      paramSosoLbsInfo.uint32_altitude.set((int)d1);
      paramSosoLbsInfo.uint32_accuracy.set(j);
      paramSosoLbsInfo.uint32_time.set((int)d2);
      paramSosoLbsInfo.uint32_cityid.set(paramInt);
      paramSosoLbsInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
      paramSosoLbsInfo.uint32_client.set(2);
      this.this$0.a(2L, paramSosoLbsInfo, 22);
      return;
    }
    this.this$0.a(2L, null, 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackp
 * JD-Core Version:    0.7.0.1
 */