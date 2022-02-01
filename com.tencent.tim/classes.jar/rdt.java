import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

class rdt
  extends pub.b
{
  rdt(rds paramrds, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.a.this$0.bo = paramSosoLbsInfo.a.cd;
      this.a.this$0.bp = paramSosoLbsInfo.a.ce;
      ram.d("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.this$0.bo + " longitude=" + this.a.this$0.bp);
      if (this.a.aHj) {
        this.a.this$0.btk();
      }
      return;
    }
    this.a.this$0.bo = 0.0D;
    this.a.this$0.bp = 0.0D;
    ram.d("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdt
 * JD-Core Version:    0.7.0.1
 */