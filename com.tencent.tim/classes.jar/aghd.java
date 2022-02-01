import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aghd
  extends ahbk
{
  public aghd(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView) {}
  
  public void dfJ() {}
  
  public void dfK() {}
  
  public void dfL() {}
  
  public void dfM()
  {
    Object localObject = agmz.db();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (agmy.mt(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          anot.a(QfileRecentTDocFileTabView.b(this.this$0), "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void dfN() {}
  
  public void dfO()
  {
    this.this$0.a.a().dlA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghd
 * JD-Core Version:    0.7.0.1
 */