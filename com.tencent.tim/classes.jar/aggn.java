import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class aggn
  implements ahal.a
{
  aggn(aggm paramaggm, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    this.a.this$0.a.a().dlW();
    if (this.b.getCloudType() == 0) {
      QfileBaseRecentFileTabView.t(this.a.this$0).a().cf(this.b.nSessionId);
    }
    acde localacde;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.b.getCloudType() != 6) {
        break;
      }
      localacde = (acde)QfileBaseRecentFileTabView.u(this.a.this$0).getBusinessHandler(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.b.uniseq));
    } while (localacde.af(localArrayList));
    ahao.OS(2131693818);
    return;
    QfileBaseRecentFileTabView.v(this.a.this$0).a().l(this.b);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggn
 * JD-Core Version:    0.7.0.1
 */