import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class vic
  extends pub.b
{
  public vic(NearbyActivity paramNearbyActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startLocation end, errCode=").append(paramInt).append(" lbsInfo=").append(paramSosoLbsInfo).append(", info.location=");
      if (paramSosoLbsInfo == null) {
        break label103;
      }
    }
    label103:
    for (SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;; localSosoLocation = null)
    {
      QLog.d("nearby.heart_beat", 2, localSosoLocation);
      if ((!this.this$0.isFinishing()) && (!this.this$0.aYJ))
      {
        this.this$0.aYJ = false;
        this.this$0.a.c(1, paramSosoLbsInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vic
 * JD-Core Version:    0.7.0.1
 */