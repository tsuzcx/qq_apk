import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class axsx
  extends pub.b
{
  axsx(axsw paramaxsw, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      ram.d("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.a.cd + " longitude=" + paramSosoLbsInfo.a.ce);
      axsu.a(this.a.this$0, true);
      axsu.a(this.a.this$0, this.a.dww);
      this.a.this$0.c(null);
      return;
    }
    ram.d("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsx
 * JD-Core Version:    0.7.0.1
 */