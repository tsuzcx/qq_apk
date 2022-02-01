import com.tencent.qphone.base.util.QLog;

final class jgz
  implements jgm.a
{
  public void onError(int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onError " + paramInt);
    jgx.A(false, paramInt);
  }
  
  public void onFinish(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onFinish " + paramString);
    jgx.A(true, 0);
  }
  
  public void onStart(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onStart " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgz
 * JD-Core Version:    0.7.0.1
 */