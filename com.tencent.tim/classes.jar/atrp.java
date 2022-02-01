import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.ArrayList;
import java.util.List;

class atrp
  implements ahal.a
{
  atrp(atrn paramatrn, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    if (this.b.getCloudType() == 0) {
      QfileBaseRecentFileTabView.w(this.a.this$0).a().jt(this.b.nSessionId);
    }
    acde localacde;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.b.getCloudType() != 6) {
        break;
      }
      localacde = (acde)QfileBaseRecentFileTabView.x(this.a.this$0).getBusinessHandler(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.b.uniseq));
    } while (localacde.af(localArrayList));
    auds.OS(2131693818);
    return;
    QfileBaseRecentFileTabView.y(this.a.this$0).a().jk(this.b.nSessionId);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrp
 * JD-Core Version:    0.7.0.1
 */