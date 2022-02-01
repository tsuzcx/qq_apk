import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.troopFile.AutoProcessFileListTask;
import com.tencent.tim.cloudfile.troopFile.AutoProcessFileListTask.a;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class atmv
  implements AutoProcessFileListTask.a, Manager
{
  private AutoRetryManager a;
  private boolean dij;
  private QQAppInterface mApp;
  private Map<Long, AutoProcessFileListTask> ps = new HashMap();
  
  public atmv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.a = new AutoRetryManager(this.mApp);
    if (this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).getBoolean("tim_cloudfile_autosave_flag", true)) {
      this.dij = true;
    }
    QLog.w("TroopFileToCloudeManager.TroopAutoSaveToCloud", 1, "copyFileToCloudGroup autosaveflag is : " + this.dij);
  }
  
  /* Error */
  public void j(long paramLong, java.util.List<com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: ifnull +20 -> 23
    //   6: aload_3
    //   7: invokeinterface 98 1 0
    //   12: ifle +11 -> 23
    //   15: aload_0
    //   16: getfield 35	atmv:a	Lcom/tencent/tim/cloudfile/troopFile/AutoRetryManager;
    //   19: aload_3
    //   20: invokevirtual 102	com/tencent/tim/cloudfile/troopFile/AutoRetryManager:nO	(Ljava/util/List;)V
    //   23: aload_0
    //   24: getfield 27	atmv:ps	Ljava/util/Map;
    //   27: lload_1
    //   28: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokeinterface 114 2 0
    //   36: checkcast 116	com/tencent/tim/cloudfile/troopFile/AutoProcessFileListTask
    //   39: invokevirtual 119	com/tencent/tim/cloudfile/troopFile/AutoProcessFileListTask:onDestory	()V
    //   42: aload_0
    //   43: getfield 27	atmv:ps	Ljava/util/Map;
    //   46: invokeinterface 123 1 0
    //   51: invokeinterface 129 1 0
    //   56: invokeinterface 135 1 0
    //   61: ifeq +59 -> 120
    //   64: aload_0
    //   65: getfield 27	atmv:ps	Ljava/util/Map;
    //   68: invokeinterface 123 1 0
    //   73: invokeinterface 129 1 0
    //   78: invokeinterface 139 1 0
    //   83: checkcast 104	java/lang/Long
    //   86: invokevirtual 143	java/lang/Long:longValue	()J
    //   89: lstore_1
    //   90: new 145	com/tencent/tim/cloudfile/troopFile/TroopFileToCloudeManager$2
    //   93: dup
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 27	atmv:ps	Ljava/util/Map;
    //   99: lload_1
    //   100: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: invokeinterface 148 2 0
    //   108: checkcast 116	com/tencent/tim/cloudfile/troopFile/AutoProcessFileListTask
    //   111: invokespecial 151	com/tencent/tim/cloudfile/troopFile/TroopFileToCloudeManager$2:<init>	(Latmv;Lcom/tencent/tim/cloudfile/troopFile/AutoProcessFileListTask;)V
    //   114: invokestatic 157	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: aload_0
    //   121: getfield 35	atmv:a	Lcom/tencent/tim/cloudfile/troopFile/AutoRetryManager;
    //   124: invokevirtual 160	com/tencent/tim/cloudfile/troopFile/AutoRetryManager:euf	()V
    //   127: goto -10 -> 117
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	atmv
    //   0	135	1	paramLong	long
    //   0	135	3	paramList	java.util.List<com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity>
    // Exception table:
    //   from	to	target	type
    //   6	23	130	finally
    //   23	117	130	finally
    //   117	119	130	finally
    //   120	127	130	finally
    //   131	133	130	finally
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmv
 * JD-Core Version:    0.7.0.1
 */