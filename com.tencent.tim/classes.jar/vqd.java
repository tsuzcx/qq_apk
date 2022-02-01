import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

public class vqd
  extends SosoInterface.a
{
  public vqd(QQSettingMe paramQQSettingMe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramInt = (int)(paramSosoLbsInfo.a.cd * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.a.ce * 1000000.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onLocationFinish latitude:" + paramInt + ",longtitude:" + i);
      }
      abcz.a(this.this$0.app, paramInt, i, this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqd
 * JD-Core Version:    0.7.0.1
 */