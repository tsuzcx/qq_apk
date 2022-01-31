import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class dyh
  implements Runnable
{
  public dyh(QQPlayerService paramQQPlayerService) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyh
 * JD-Core Version:    0.7.0.1
 */