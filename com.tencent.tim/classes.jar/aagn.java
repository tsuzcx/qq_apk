import com.tencent.qphone.base.util.QLog;

class aagn
  implements jgm.a
{
  aagn(aagm paramaagm) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onError " + paramInt);
    }
  }
  
  public void onFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onFinish " + paramString);
    }
  }
  
  public void onStart(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onStart " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagn
 * JD-Core Version:    0.7.0.1
 */