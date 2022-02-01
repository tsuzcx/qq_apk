import com.tencent.qphone.base.util.QLog;

class isc
  implements isj.a
{
  isc(isb paramisb) {}
  
  public void onShow()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "onShow called, needDetectFace set true");
    }
    if (this.a.c != null) {
      this.a.c.UB = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isc
 * JD-Core Version:    0.7.0.1
 */