import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aggt
  extends ahbk
{
  public aggt(QfileRecentAllFileTabView paramQfileRecentAllFileTabView) {}
  
  public void dfJ()
  {
    this.this$0.a.a().dkY();
  }
  
  public void dfK()
  {
    this.this$0.a.a().dlk();
  }
  
  public void dfL()
  {
    this.this$0.a.a().dll();
  }
  
  public void dfM()
  {
    this.this$0.a.a().dlm();
    Object localObject = agmz.db();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (agmy.mt(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          anot.a(QfileRecentAllFileTabView.b(this.this$0), "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void dfN()
  {
    this.this$0.a.a().dln();
  }
  
  public void dfO()
  {
    this.this$0.a.a().dlA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggt
 * JD-Core Version:    0.7.0.1
 */