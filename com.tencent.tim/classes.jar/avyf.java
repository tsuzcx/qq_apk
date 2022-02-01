import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class avyf
  implements Handler.Callback
{
  private Handler handler;
  private Context mContext;
  Map<String, avyf.a> ql;
  Map<String, PluginRecord> qm;
  
  avyf(Context paramContext)
  {
    this.mContext = paramContext;
    this.ql = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.qm = new HashMap();
    avyg localavyg = new avyg(this);
    avyo.a(paramContext, this.qm, localavyg);
  }
  
  private boolean a(PluginRecord paramPluginRecord)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramPluginRecord != null)
    {
      if (!a(paramPluginRecord, avyo.c(BaseApplicationImpl.getContext(), paramPluginRecord.id), false)) {
        break label69;
      }
      paramPluginRecord.state = 4;
    }
    for (bool1 = true;; bool1 = bool2)
    {
      QLog.i("plugin_tag", 1, "verifyInstalledPlugin :" + paramPluginRecord + "," + bool1);
      return bool1;
      label69:
      a(paramPluginRecord, null);
      paramPluginRecord.state = 0;
    }
  }
  
  static boolean a(@NonNull PluginRecord paramPluginRecord, @Nullable File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    String str2;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      QLog.e("plugin_tag", 1, "isValidPluginFile4LZMA file not exist");
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
      if (paramBoolean) {}
      for (paramPluginRecord = "0";; paramPluginRecord = "1")
      {
        LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 1, paramPluginRecord);
        bool = false;
        return bool;
      }
    }
    String str1 = PluginStatic.encodeFile(paramFile.getPath());
    if (paramBoolean)
    {
      paramFile = paramPluginRecord.md5;
      label93:
      if ((paramFile != null) && (paramFile.equalsIgnoreCase(str1))) {
        break label195;
      }
      QLog.e("plugin_tag", 1, "isValidPluginFile invalid:" + paramFile + ", " + str1 + ", " + paramBoolean);
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
      if (!paramBoolean) {
        break label197;
      }
    }
    label195:
    label197:
    for (paramPluginRecord = "0";; paramPluginRecord = "1")
    {
      LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 4, paramPluginRecord);
      return false;
      paramFile = paramPluginRecord.md5_2;
      break label93;
      break;
    }
  }
  
  private void b(avyf.a parama)
  {
    Object localObject1 = parama.jdField_a_of_type_Avyf$b;
    PluginRecord localPluginRecord = parama.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    if (localObject1 != null) {
      ((avyf.b)localObject1).d(parama.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    }
    Object localObject2 = avyo.g(this.mContext, localPluginRecord.id);
    localObject1 = avyo.c(this.mContext, localPluginRecord.id);
    File localFile1 = avyo.d(this.mContext, localPluginRecord.id);
    long l1 = System.currentTimeMillis();
    if (!a(localPluginRecord, (File)localObject2, true))
    {
      QLog.w("QZonePluginManger", 1, "文件校验失败");
      Message.obtain(this.handler, 2, parama).sendToTarget();
      return;
    }
    File localFile2 = ((File)localObject1).getParentFile();
    int i = LzmaUtils.m(this.mContext, ((File)localObject2).getAbsolutePath(), localFile2.getAbsolutePath());
    QLog.d("QZonePluginManger", 1, "LZMA uncompress ret=" + i);
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "解压缩LZMA的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 100, i + "");
    if (i != 0)
    {
      QLog.w("QZonePluginManger", 1, "解压缩LZMA失败, ret=" + i);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 5);
      Message.obtain(this.handler, 2, parama).sendToTarget();
      return;
    }
    localPluginRecord.md5_2 = PluginStatic.encodeFile(((File)localObject1).getAbsolutePath());
    boolean bool;
    if (localFile1.exists())
    {
      localObject2 = localFile1.listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        QLog.i("QZonePluginManger", 2, "delete avsdk so libPath:" + localFile1.getAbsolutePath());
        int j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localFile2 = localObject2[i];
            if (localFile2.exists()) {}
            try
            {
              bool = localFile2.delete();
              QLog.i("QZonePluginManger", 2, "delete file:" + localFile2.getName() + " success:" + bool);
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("QZonePluginManger", 2, Log.getStackTraceString(localException2));
              }
            }
          }
        }
      }
    }
    try
    {
      bool = ((File)localObject1).canRead();
      QLog.i("QZonePluginManger", 1, "installFile canRead=" + bool);
      if (!bool)
      {
        bool = ((File)localObject1).setReadable(true);
        QLog.i("QZonePluginManger", 1, "installFile can read=" + bool);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localException1, new Object[0]);
      }
      l1 = System.currentTimeMillis() - l1;
      QLog.i("QZonePluginManger", 1, "插件安装成功, cost=" + l1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l1 / 1000.0D, 0);
      Message.obtain(this.handler, 3, parama).sendToTarget();
    }
    localObject1 = PluginUtils.extractLibs(((File)localObject1).getAbsolutePath(), localFile1.getAbsolutePath());
    l2 = System.currentTimeMillis() - l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "释放so的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 101);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.w("QZonePluginManger", 1, "释放so失败:" + (String)localObject1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 3, (String)localObject1);
      Message.obtain(this.handler, 2, parama).sendToTarget();
      return;
    }
  }
  
  public void a(avyf.a parama)
  {
    QLog.i("plugin_tag", 1, "unInstallPluginInner : " + parama.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    parama = parama.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    File localFile1 = avyo.c(this.mContext, parama.id);
    File localFile2 = avyo.d(this.mContext, parama.id);
    localFile1.delete();
    localFile2.delete();
    avyo.i(parama);
  }
  
  public void a(PluginRecord paramPluginRecord, avyf.b paramb)
  {
    QLog.i("plugin_tag", 1, "installPlugin: " + paramPluginRecord);
    avyf.a locala = new avyf.a();
    locala.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    locala.jdField_a_of_type_Avyf$b = paramb;
    locala.id = paramPluginRecord.id;
    Message.obtain(this.handler, 0, locala).sendToTarget();
  }
  
  public void a(PluginRecord paramPluginRecord, avyf.c paramc)
  {
    QLog.i("plugin_tag", 1, "unInstallPlugin: " + paramPluginRecord);
    avyf.a locala = new avyf.a();
    locala.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    locala.jdField_a_of_type_Avyf$c = paramc;
    Message.obtain(this.handler, 1, locala).sendToTarget();
  }
  
  public PluginRecord b(String paramString)
  {
    return (PluginRecord)this.qm.get(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              return false;
              localObject2 = (avyf.a)paramMessage.obj;
            } while (this.ql.containsKey(((avyf.a)localObject2).id));
            this.ql.put(((avyf.a)localObject2).id, localObject2);
            localObject1 = ((avyf.a)localObject2).jdField_a_of_type_CooperationQzonePluginPluginRecord;
            localObject2 = ((avyf.a)localObject2).jdField_a_of_type_Avyf$b;
            if (localObject2 != null) {
              ((avyf.b)localObject2).d((PluginRecord)localObject1);
            }
            b((avyf.a)paramMessage.obj);
            return false;
            paramMessage = (avyf.a)paramMessage.obj;
          } while (!this.ql.containsKey(paramMessage.id));
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Avyf$b;
          if (localObject2 != null) {
            ((avyf.b)localObject2).a(false, (PluginRecord)localObject1);
          }
          this.ql.remove(paramMessage.id);
          return false;
          paramMessage = (avyf.a)paramMessage.obj;
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Avyf$c;
          if (!this.ql.containsKey(paramMessage.id))
          {
            if (localObject2 != null) {
              ((avyf.c)localObject2).e((PluginRecord)localObject1);
            }
            this.ql.put(paramMessage.id, paramMessage);
            a(paramMessage);
            this.ql.remove(paramMessage.id);
            this.qm.remove(((PluginRecord)localObject1).id);
            avyo.i((PluginRecord)localObject1);
            if (localObject2 != null) {
              ((avyf.c)localObject2).b(true, (PluginRecord)localObject1);
            }
          }
        } while (localObject2 == null);
        ((avyf.c)localObject2).b(false, (PluginRecord)localObject1);
        return false;
        localObject1 = (avyf.a)paramMessage.obj;
      } while (!this.ql.containsKey(((avyf.a)localObject1).id));
      paramMessage = ((avyf.a)localObject1).jdField_a_of_type_CooperationQzonePluginPluginRecord;
      this.ql.remove(((avyf.a)localObject1).id);
      paramMessage.state = 4;
      this.qm.put(paramMessage.id, paramMessage);
      QLog.i("QZonePluginManger", 1, "QZonePluginInstaller 安装成功 record:" + paramMessage);
      avyo.h(paramMessage);
      localObject1 = ((avyf.a)localObject1).jdField_a_of_type_Avyf$b;
    } while (localObject1 == null);
    ((avyf.b)localObject1).a(true, paramMessage);
    return false;
  }
  
  class a
  {
    avyf.b jdField_a_of_type_Avyf$b;
    avyf.c jdField_a_of_type_Avyf$c;
    PluginRecord jdField_a_of_type_CooperationQzonePluginPluginRecord;
    String id;
    
    a() {}
  }
  
  static abstract interface b
  {
    public abstract void a(boolean paramBoolean, PluginRecord paramPluginRecord);
    
    public abstract void d(PluginRecord paramPluginRecord);
  }
  
  static abstract interface c
  {
    public abstract void b(boolean paramBoolean, PluginRecord paramPluginRecord);
    
    public abstract void e(PluginRecord paramPluginRecord);
  }
  
  static abstract interface d
  {
    public abstract boolean a(PluginRecord paramPluginRecord, File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyf
 * JD-Core Version:    0.7.0.1
 */