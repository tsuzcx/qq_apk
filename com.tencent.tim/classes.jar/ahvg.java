import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ahvg
{
  private static volatile ahvg a;
  private Map<String, ahvg.a> ll = Collections.synchronizedMap(new HashMap());
  
  public static ahvg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahvg();
      }
      return a;
    }
    finally {}
  }
  
  private void dqn()
  {
    if ((this.ll != null) && (this.ll != null) && (this.ll.size() == 1) && (this.ll.containsKey("task_qgame_task_all_complete")))
    {
      ahvg.a locala = (ahvg.a)this.ll.get("task_qgame_task_all_complete");
      if ((locala != null) && (ahvg.a.a(locala) != null))
      {
        ahvg.a.a(locala).a("task_qgame_task_all_complete", new EIPCResult());
        this.ll.remove(locala);
      }
    }
  }
  
  public void a(String paramString, ahvg.b paramb)
  {
    if ((paramb != null) && (this.ll.containsKey(paramString))) {
      ahvg.a.a((ahvg.a)this.ll.get(paramString), paramb);
    }
  }
  
  public void cn(String paramString, boolean paramBoolean)
  {
    ahvg.a locala = (ahvg.a)this.ll.get(paramString);
    if (locala == null) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", ahvg.a.a(locala), null, new ahvh(this, locala, paramString, paramBoolean));
  }
  
  public void dqm()
  {
    if (this.ll != null)
    {
      this.ll.clear();
      this.ll.put("task_get_qgame_msg", new ahvg.a("findMessage"));
      this.ll.put("task_get_qgame_session_msg", new ahvg.a("getGameMsg"));
      this.ll.put("task_qgame_task_all_complete", new ahvg.a("task_qgame_task_all_complete"));
    }
  }
  
  public void onDestory()
  {
    a = null;
  }
  
  public class a
  {
    private ahvg.b a;
    private String taskName;
    
    public a(String paramString)
    {
      this.taskName = paramString;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, EIPCResult paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvg
 * JD-Core Version:    0.7.0.1
 */