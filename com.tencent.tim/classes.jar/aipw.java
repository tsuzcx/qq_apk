import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.1;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.2;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.3;

public class aipw
{
  public static void br(boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new QQMusicPlayReport.1(paramBoolean, paramInt), 5, null, false);
  }
  
  public static void bs(boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new QQMusicPlayReport.3(paramBoolean, aqiw.getNetworkType(null), paramInt), 5, null, false);
  }
  
  public static void iy(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new QQMusicPlayReport.2(paramInt1, paramInt2), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipw
 * JD-Core Version:    0.7.0.1
 */