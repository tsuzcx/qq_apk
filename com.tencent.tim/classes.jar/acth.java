import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;

public class acth
{
  private String bqT;
  private Resources h;
  private Resources i;
  
  public acth(Context paramContext)
  {
    this.h = paramContext.getResources();
  }
  
  public void a(Resources paramResources, String paramString)
  {
    this.i = paramResources;
    this.bqT = paramString;
  }
  
  public Resources b()
  {
    if (this.i == null) {
      return this.h;
    }
    return this.i;
  }
  
  public Resources c()
  {
    return this.h;
  }
  
  public int gK(int paramInt)
  {
    if ((this.h == null) || (this.i == null)) {}
    String str1;
    int j;
    do
    {
      return paramInt;
      str1 = this.h.getResourceEntryName(paramInt);
      String str2 = this.h.getResourceTypeName(paramInt);
      j = this.i.getIdentifier(str1, str2, this.bqT);
    } while (j <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("MultiLanguageEngine", 2, new Object[] { "resourceName:", str1, " ,lanResID:", Integer.valueOf(j), " ,oldId:", Integer.valueOf(paramInt) });
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acth
 * JD-Core Version:    0.7.0.1
 */