import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aghg
  implements ahal.a
{
  aghg(aghf paramaghf, FileManagerEntity paramFileManagerEntity) {}
  
  public void aD()
  {
    if ((this.b.status == 3) || (this.b.status == 0))
    {
      if (this.b.getCloudType() == 0)
      {
        this.a.mApp.a().jt(this.b.nSessionId);
        return;
      }
      this.a.mApp.a().jk(this.b.nSessionId);
      return;
    }
    if (this.b.getCloudType() == 0)
    {
      this.a.mApp.a().cf(this.b.nSessionId);
      return;
    }
    this.a.mApp.a().l(this.b);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghg
 * JD-Core Version:    0.7.0.1
 */