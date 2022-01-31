import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.activity.richmedia.subtitles.BaseAnimDrawer;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.qphone.base.util.QLog;

public class xth
  implements Runnable
{
  public xth(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    SubtitleLayout.a(this.a, true);
    if ((SubtitleLayout.a(this.a) != null) && (SubtitleLayout.a(this.a).b() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "count down, not in preview state.");
      }
      SubtitleLayout.a(this.a, null);
      return;
    }
    AudioTranslator.a().a(true, false);
    this.a.a();
    if (this.a.a != 0)
    {
      SubtitleLayout.a(this.a);
      SubtitleLayout.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "stop auto trans.");
    }
    SubtitleLayout.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xth
 * JD-Core Version:    0.7.0.1
 */