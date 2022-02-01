import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class afld
  implements ajdq<Emoticon>
{
  afld(aflb paramaflb, int paramInt, String paramString) {}
  
  public void b(Emoticon paramEmoticon)
  {
    if ((paramEmoticon == null) || (!paramEmoticon.hasEncryptKey()))
    {
      this.this$0.J(Integer.toString(this.cRS), this.bDR, true);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
      }
    }
    do
    {
      return;
      this.this$0.c(paramEmoticon);
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func trySend ends, everything is ok.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afld
 * JD-Core Version:    0.7.0.1
 */