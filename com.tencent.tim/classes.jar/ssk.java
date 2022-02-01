import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

class ssk
  implements joy
{
  ssk(ssj paramssj, long paramLong, Context paramContext, boolean paramBoolean, joy paramjoy) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    this.this$0.aGf = jpa.dL(this.this$0.mBid);
    String str = jpe.dO(this.this$0.mBid) + this.this$0.mBid + "/" + this.this$0.mPluginName;
    try
    {
      Object localObject = new File(this.this$0.aoF);
      if (!this.this$0.k.getString(this.this$0.gL(this.this$0.mBid), "-1").equals(this.this$0.aGf))
      {
        if (!((File)localObject).exists()) {
          break label379;
        }
        aqhq.cn(((File)localObject).getAbsolutePath());
        this.this$0.k.edit().putString(this.this$0.gL(this.this$0.mBid), jpa.dL(this.this$0.mBid)).commit();
        ((File)localObject).mkdirs();
      }
      for (;;)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.val$context, this.this$0.mPluginName).getCanonicalPath();
        this.this$0.mClassLoader = new DexClassLoader(str, this.this$0.aoF, (String)localObject, this.val$context.getClassLoader());
        this.this$0.a = new sse(this.val$context, 0, str, null, null, this.aMS);
        if (this.a == null) {
          break;
        }
        this.a.loaded(paramInt, paramString);
        return;
        label379:
        ((File)localObject).mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssk
 * JD-Core Version:    0.7.0.1
 */