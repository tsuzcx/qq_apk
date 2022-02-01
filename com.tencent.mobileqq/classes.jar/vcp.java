import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class vcp
  implements zxa<QQCircleProfile.SetUserSwitchRsp>
{
  vcp(vco paramvco, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      vtt.a(paramLong, this.jdField_a_of_type_Vco.a.a(), paramString, 0);
      return;
    }
    zwp.a().a(new QCircleSyncToTroopSettingEvent(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcp
 * JD-Core Version:    0.7.0.1
 */