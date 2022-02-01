import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.qphone.base.util.QLog;

public class acte
  extends Resources
{
  private acth a;
  
  public acte(acth paramacth)
  {
    super(paramacth.c().getAssets(), paramacth.c().getDisplayMetrics(), paramacth.c().getConfiguration());
    this.a = paramacth;
  }
  
  public CharSequence getText(int paramInt)
    throws Resources.NotFoundException
  {
    int i = this.a.gK(paramInt);
    try
    {
      CharSequence localCharSequence = this.a.b().getText(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiLanguageEngine", 4, new Object[] { "getText delegate:", Integer.valueOf(paramInt), " ,langId:", Integer.valueOf(i), " ,content:" + localCharSequence });
      }
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return this.a.c().getText(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acte
 * JD-Core Version:    0.7.0.1
 */