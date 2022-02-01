import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

final class aqgg
  implements ajat.c
{
  public void OC(int paramInt)
  {
    switch (paramInt)
    {
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    MediaPlayerManager.a((QQAppInterface)localAppRuntime).stop(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgg
 * JD-Core Version:    0.7.0.1
 */