import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class adhc
  extends SosoInterface.a
{
  adhc(adgy paramadgy, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    adgy.f(this.this$0, false);
    if (adgy.a(this.this$0) != null) {
      adgy.a(this.this$0).removeMessages(2);
    }
    if (adgy.a(this.this$0)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      paramInt = (int)(paramSosoLbsInfo.cd * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.ce * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.cd + ", Lon_02 = " + paramSosoLbsInfo.ce + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.altitude + ", accuracy = " + paramSosoLbsInfo.accuracy + ", name = " + paramSosoLbsInfo.name + ", address = " + paramSosoLbsInfo.address);
      paramSosoLbsInfo = adhr.a(this.this$0.b.recognitions, adgy.a(this.this$0));
      adgy.a(this.this$0, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new adhf();
    paramSosoLbsInfo.retCode = 2;
    adhr.a(this.this$0.b.recognitions, adgy.a(this.this$0), paramSosoLbsInfo);
    if (adgy.a(this.this$0) != null) {
      adgy.a(this.this$0).b(0, adgy.a(this.this$0));
    }
    adgy.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhc
 * JD-Core Version:    0.7.0.1
 */