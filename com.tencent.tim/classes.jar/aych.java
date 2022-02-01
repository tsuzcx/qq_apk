import com.tencent.qphone.base.util.QLog;

final class aych
  implements jgm.a
{
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onError " + paramInt);
    }
  }
  
  public void onFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onFinish " + paramString);
    }
  }
  
  public void onStart(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onStart " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aych
 * JD-Core Version:    0.7.0.1
 */