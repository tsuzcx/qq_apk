import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atzx
  implements atza
{
  atzx(atzs paramatzs) {}
  
  public void a(atzy.a parama)
  {
    agsd localagsd = ((atzc)parama).b();
    if (localagsd != null)
    {
      parama = null;
      if (1 != localagsd.getCloudType()) {
        break label160;
      }
      if (!localagsd.b().isZipInnerFile) {
        break label102;
      }
      parama = this.a.mAppInterface.a().c(localagsd.b());
      if ((parama != null) && (this.a.a != null)) {
        this.a.a.fP(String.valueOf(localagsd.fR()), parama);
      }
    }
    for (;;)
    {
      this.a.a(localagsd, 4);
      return;
      label102:
      parama = this.a.mAppInterface.a().a(localagsd.b(), 7);
      if ((parama != null) && (this.a.a != null))
      {
        this.a.a.fP(localagsd.getUuid(), parama);
        continue;
        label160:
        if (2 == localagsd.getCloudType())
        {
          if (localagsd.b() != null) {
            parama = this.a.mAppInterface.a().a(localagsd.getFileId(), localagsd.getFileName(), 7, localagsd);
          }
          if ((parama != null) && (this.a.a != null)) {
            this.a.a.fP(localagsd.getFileId(), parama);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzx
 * JD-Core Version:    0.7.0.1
 */