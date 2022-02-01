import android.support.annotation.Nullable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;

class aykq
  extends aykn.d
{
  aykq(aykn paramaykn, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
  }
  
  protected void b(@Nullable DoodleEmojiItem arg1)
  {
    super.onResult(???);
    ram.d("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.bm)
    {
      this.a.a = null;
      this.a.startDownload();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykq
 * JD-Core Version:    0.7.0.1
 */