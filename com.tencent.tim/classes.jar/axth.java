import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class axth
  extends pub.b
{
  axth(axtg paramaxtg, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.a.bo = paramSosoLbsInfo.a.cd;
      this.a.a.bp = paramSosoLbsInfo.a.ce;
      ram.d("FacePoiManager", "onLocationUpdate() latitude=" + this.a.a.bo + " longitude=" + this.a.a.bp);
      if (this.a.aHj) {
        this.a.a.btk();
      }
      return;
    }
    this.a.a.bo = 0.0D;
    this.a.a.bp = 0.0D;
    ram.d("FacePoiManager", "onLocationUpdate() error");
    this.a.a.a.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axth
 * JD-Core Version:    0.7.0.1
 */