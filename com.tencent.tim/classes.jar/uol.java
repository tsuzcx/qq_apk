import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class uol
  implements ahal.a
{
  uol(uoj paramuoj, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    if (this.b.getCloudType() == 0) {
      this.a.this$0.mApp.a().jt(this.b.nSessionId);
    }
    acde localacde;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.b.getCloudType() != 6) {
        break;
      }
      localacde = (acde)this.a.this$0.mApp.getBusinessHandler(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.b.uniseq));
    } while (localacde.af(localArrayList));
    ahao.OS(2131693818);
    return;
    this.a.this$0.mApp.a().jk(this.b.nSessionId);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uol
 * JD-Core Version:    0.7.0.1
 */