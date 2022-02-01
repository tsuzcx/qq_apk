import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.http.AvatarUpdateService.1;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class arxc
  implements arxi.a
{
  private static arxc a;
  public SharedPreferences af = BaseApplicationImpl.getApplication().getSharedPreferences("uin_avatarurl", 0);
  public HashMap<String, arxc.a> pQ = new HashMap();
  
  public static arxc a()
  {
    try
    {
      if (a == null) {
        a = new arxc();
      }
      return a;
    }
    finally {}
  }
  
  public void E(String paramString, Bitmap arg2)
  {
    boolean bool2 = true;
    Object localObject1;
    for (;;)
    {
      synchronized (this.pQ)
      {
        localObject1 = (arxc.a)this.pQ.get(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append(", bitmap = null ? ");
          if (??? == null)
          {
            bool1 = true;
            ??? = ((StringBuilder)???).append(bool1).append(", task = null ? ");
            if (localObject1 != null) {
              break label116;
            }
            bool1 = bool2;
            QLog.d("AvatarUpdateService", 2, bool1);
          }
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label116:
      bool1 = false;
    }
    ??? = (Context)((arxc.a)localObject1).context.get();
    if ((??? != null) && (??? != null))
    {
      ??? = artw.a((Context)???, ???, 63, 63);
      if (??? == null) {}
    }
    try
    {
      e(???, ((arxc.a)localObject1).path);
      ??? = this.af.edit();
      ((SharedPreferences.Editor)???).putString(((arxc.a)localObject1).uin, ((arxc.a)localObject1).imageUrl);
      ((SharedPreferences.Editor)???).commit();
      label205:
      localObject1 = (arxi.a)((arxc.a)localObject1).callback.get();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarUpdateService", 2, "-->onTaskCompleted--callback not null, invoke it");
        }
        ((arxi.a)localObject1).E(paramString, ???);
      }
      synchronized (this.pQ)
      {
        this.pQ.remove(paramString);
        return;
      }
    }
    catch (IOException localIOException)
    {
      break label205;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, arxi.a parama)
  {
    QLog.d("AvatarUpdateService", 1, "-->updateAvatar--uin = " + artw.qx(paramString1));
    String str2 = "https://openmobile.qq.com/getface?appid=716027609&imgtype=3&encrytype=0&devtype=0&keytype=0&uin=" + paramString1;
    for (String str1 = paramString1; str1.length() < 10; str1 = "0" + str1) {}
    str1 = "o" + str1;
    ThreadManager.post(new AvatarUpdateService.1(this, str2, "uin=" + str1 + "; skey=" + paramString2, paramString1, paramString3, paramContext, parama), 5, null, true);
  }
  
  protected void e(Bitmap paramBitmap, String paramString)
    throws IOException
  {
    if (paramBitmap == null) {}
    do
    {
      return;
      paramString = aqhu.createNewFile(paramString);
    } while (paramString == null);
    paramString = new FileOutputStream(paramString);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
  
  public class a
  {
    public WeakReference<arxi.a> callback;
    public WeakReference<Context> context;
    public String imageUrl;
    public String path;
    public String uin;
    
    public a(Context paramContext, String paramString1, String paramString2, String paramString3, arxi.a parama)
    {
      this.context = new WeakReference(paramContext);
      this.uin = paramString1;
      this.path = paramString2;
      this.imageUrl = paramString3;
      this.callback = new WeakReference(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxc
 * JD-Core Version:    0.7.0.1
 */