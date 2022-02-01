import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class aggo
  implements ahal.a
{
  aggo(aggm paramaggm, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    if (this.b.getCloudType() == 0) {
      QfileBaseRecentFileTabView.z(this.a.this$0).a().jt(this.b.nSessionId);
    }
    acde localacde;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.b.getCloudType() != 6) {
        break;
      }
      localacde = (acde)QfileBaseRecentFileTabView.A(this.a.this$0).getBusinessHandler(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.b.uniseq));
    } while (localacde.af(localArrayList));
    ahao.OS(2131693818);
    return;
    QfileBaseRecentFileTabView.B(this.a.this$0).a().jk(this.b.nSessionId);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggo
 * JD-Core Version:    0.7.0.1
 */