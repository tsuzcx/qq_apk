import com.tencent.mobileqq.data.OpenID;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class avzy
  implements acci
{
  public avzy(QZoneShareActivity paramQZoneShareActivity, String paramString, QZoneShareData paramQZoneShareData) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 1) && ((paramObject instanceof OpenID)))
    {
      paramObject = (OpenID)paramObject;
      if ((paramObject.openID != null) && (!paramObject.openID.equals(this.cOC))) {
        this.this$0.a(this.this$0, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzy
 * JD-Core Version:    0.7.0.1
 */