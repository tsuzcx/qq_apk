import com.tencent.cloudfile.CloudFileContext.Logger;
import com.tencent.qphone.base.util.QLog;

class atgj
  implements CloudFileContext.Logger
{
  atgj(atgi paramatgi) {}
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
    case 2: 
    case 3: 
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(paramString1, 2, paramString2);
      return;
    case 4: 
    case 5: 
      QLog.w(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgj
 * JD-Core Version:    0.7.0.1
 */