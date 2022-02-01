import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

class agtw
  implements agsu
{
  agtw(agts paramagts) {}
  
  public void a(aguk.a parama)
  {
    agsd localagsd = ((agsx)parama).b();
    if (localagsd != null)
    {
      if (1 != localagsd.getCloudType()) {
        break label158;
      }
      if (!localagsd.b().isZipInnerFile) {
        break label100;
      }
      parama = this.a.mAppInterface.a().c(localagsd.b());
      if ((parama != null) && (this.a.a != null)) {
        this.a.a.fP(String.valueOf(localagsd.fR()), parama);
      }
    }
    label100:
    while (2 != localagsd.getCloudType()) {
      for (;;)
      {
        this.a.a(localagsd, 4);
        return;
        parama = this.a.mAppInterface.a().a(localagsd.b(), 7);
        if ((parama != null) && (this.a.a != null)) {
          this.a.a.fP(localagsd.getUuid(), parama);
        }
      }
    }
    label158:
    aghw localaghw = this.a.mAppInterface.a();
    String str = localagsd.getFileId();
    if (localagsd.b() == null) {}
    for (parama = null;; parama = localagsd.b().encodeUrl)
    {
      parama = localaghw.a(str, parama, 7, localagsd);
      if ((parama == null) || (this.a.a == null)) {
        break;
      }
      this.a.a.fP(localagsd.getFileId(), parama);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtw
 * JD-Core Version:    0.7.0.1
 */