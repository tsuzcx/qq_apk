package dov.com.qq.im.story;

import aycg;
import com.tencent.qphone.base.util.QLog;

public class StoryGameAudioMixManager$1
  implements Runnable
{
  public void run()
  {
    this.this$0.eJB = 1;
    if (QLog.isColorLevel()) {
      QLog.d("StoryGameAudioMixManager", 2, "bgmBytes start");
    }
    if (aycg.h(this.bq, this.br))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StoryGameAudioMixManager", 2, "conver succeed");
      }
      this.this$0.eJB = 2;
      return;
    }
    this.this$0.eJB = 3;
    QLog.e("StoryGameAudioMixManager", 1, "bgm conver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.StoryGameAudioMixManager.1
 * JD-Core Version:    0.7.0.1
 */