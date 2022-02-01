import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;

public class ajct
  extends TaskFlowEngine
{
  private static volatile ajct jdField_a_of_type_Ajct;
  private ajct.a jdField_a_of_type_Ajct$a;
  private ajcu jdField_a_of_type_Ajcu;
  private boolean baseDownloadEngineLoaded;
  
  private ajct()
  {
    dwb();
  }
  
  public static ajct a()
  {
    if (jdField_a_of_type_Ajct == null) {}
    try
    {
      if (jdField_a_of_type_Ajct == null) {
        jdField_a_of_type_Ajct = new ajct();
      }
      return jdField_a_of_type_Ajct;
    }
    finally {}
  }
  
  private void dwb()
  {
    this.jdField_a_of_type_Ajcu = new ajcu(BaseApplicationImpl.getApplication());
    initTasks(new BaseTask[] { this.jdField_a_of_type_Ajcu });
  }
  
  public void a(ajct.a parama)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]detachDownloadListener in:" + parama + ",current:" + this.jdField_a_of_type_Ajct$a);
    if ((parama != null) && (parama.equals(this.jdField_a_of_type_Ajct$a)))
    {
      this.jdField_a_of_type_Ajct$a = null;
      this.jdField_a_of_type_Ajcu.c(null);
      return;
    }
    QLog.w("MiniLoadManager", 1, "[MiniEng]detachDownloadListener failed");
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, ajct.a parama)
  {
    this.baseDownloadEngineLoaded = false;
    resetTaskAndDepends(this.jdField_a_of_type_Ajcu);
    b(parama);
    super.start();
  }
  
  public void a(EngineChannel paramEngineChannel)
  {
    this.jdField_a_of_type_Ajcu.b(paramEngineChannel);
    QLog.i("MiniLoadManager", 1, "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppUtil.getProcessName());
  }
  
  public void b(ajct.a parama)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener " + parama);
    this.jdField_a_of_type_Ajct$a = parama;
    this.jdField_a_of_type_Ajcu.c(parama);
    boolean bool;
    if (this.jdField_a_of_type_Ajcu.isDone())
    {
      QLog.i("MiniLoadManager", 1, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (parama != null)
      {
        bool = this.jdField_a_of_type_Ajcu.isSucceed();
        if (this.jdField_a_of_type_Ajcu.msg != null) {
          break label90;
        }
      }
    }
    label90:
    for (String str = "";; str = this.jdField_a_of_type_Ajcu.msg)
    {
      parama.onEngineLoad(bool, str);
      return;
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    QLog.i("MiniLoadManager", 1, "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.jdField_a_of_type_Ajcu);
    if ((paramBaseTask instanceof ajcu))
    {
      if (paramBaseTask.isSucceed()) {
        break label98;
      }
      if (this.jdField_a_of_type_Ajct$a != null) {
        this.jdField_a_of_type_Ajct$a.onEngineLoad(false, ((ajcu)paramBaseTask).msg);
      }
    }
    for (this.baseDownloadEngineLoaded = false;; this.baseDownloadEngineLoaded = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label98:
      if (this.jdField_a_of_type_Ajct$a != null) {
        this.jdField_a_of_type_Ajct$a.onEngineLoad(true, "");
      }
    }
  }
  
  @Deprecated
  public void start()
  {
    QLog.w("MiniLoadManager", 1, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
  
  public static abstract interface a
  {
    public abstract void onEngineLoad(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajct
 * JD-Core Version:    0.7.0.1
 */