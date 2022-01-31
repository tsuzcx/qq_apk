import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.activity.richmedia.subtitles.BaseAnimDrawer;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;

public class xwo
  implements Runnable
{
  public xwo(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    if (SubtitleLayout.a(this.a))
    {
      if (SubtitleLayout.a(this.a) != null)
      {
        long l = System.currentTimeMillis();
        String str1 = "录制时说话可以添加字幕。";
        String str2 = "Record and speak with subtitles added.";
        if (!AudioTranslator.a(false))
        {
          str1 = "网络状态差无法识别你的语音";
          str2 = "Unable to Recognize Your Speaking due to Poor Internet Connection";
        }
        if (SubtitleLayout.a(this.a).a(false) <= 4) {
          SubtitleLayout.a(this.a).a(l, 1000L + l, str1, str2, true);
        }
      }
      SubtitleLayout.a(this.a, 1000);
      SubtitleLayout.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwo
 * JD-Core Version:    0.7.0.1
 */