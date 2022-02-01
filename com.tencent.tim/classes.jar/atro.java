import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.ArrayList;
import java.util.List;

class atro
  implements ahal.a
{
  atro(atrn paramatrn, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    this.a.this$0.b.a().dlW();
    if (this.b.getCloudType() == 0) {
      QfileBaseRecentFileTabView.q(this.a.this$0).a().cf(this.b.nSessionId);
    }
    acde localacde;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.b.getCloudType() != 6) {
        break;
      }
      localacde = (acde)QfileBaseRecentFileTabView.r(this.a.this$0).getBusinessHandler(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.b.uniseq));
    } while (localacde.af(localArrayList));
    auds.OS(2131693818);
    return;
    QfileBaseRecentFileTabView.s(this.a.this$0).a().l(this.b);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atro
 * JD-Core Version:    0.7.0.1
 */