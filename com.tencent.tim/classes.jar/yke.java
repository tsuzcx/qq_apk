import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

class yke
  implements aebo.a
{
  yke(ykc paramykc) {}
  
  public void h(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aebs.j(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + paramColorNote);
    }
    ykc.a(this.a, paramColorNote, 1001);
    anot.a(null, "dc00898", "", "", "0X800AE81", "0X800AE81", ykf.a(paramColorNote).reportType, 0, "", "", "", "");
  }
  
  public void i(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aebs.j(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + paramColorNote);
    }
    ykc.a(this.a, paramColorNote, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yke
 * JD-Core Version:    0.7.0.1
 */