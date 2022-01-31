import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class ghf
  implements Runnable
{
  public ghf(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.g() == 5) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.b(QQPlayerService.g()) + ",needRetryPlay:" + bool);
      }
      if ((bool) && (QQPlayerService.b() != null)) {
        QQPlayerService.a(this.a, QQPlayerService.b().a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghf
 * JD-Core Version:    0.7.0.1
 */