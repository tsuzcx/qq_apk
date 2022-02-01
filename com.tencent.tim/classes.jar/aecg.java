import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

public class aecg
  implements aebx
{
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface != null) {
      ((ykc)localQQAppInterface.getManager(365)).a(paramContext, paramColorNote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecg
 * JD-Core Version:    0.7.0.1
 */