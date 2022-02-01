import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class auar
  implements atza
{
  auar(auaj paramauaj) {}
  
  public void a(atzy.a parama)
  {
    Object localObject = ((atzc)parama).b();
    parama = this.this$0.c.b();
    if ((localObject != null) && (parama != null) && (!aueh.isFileExists(parama.getFilePath())))
    {
      localObject = aths.a().c(parama, 640);
      if (!aqhq.fileExistsAndNotEmpty((String)localObject)) {
        break label134;
      }
      if (this.this$0.a != null) {
        this.this$0.a.fP(new String(parama.cloudId) + new String(parama.pDirKey), (String)localObject);
      }
    }
    for (;;)
    {
      this.this$0.a(this.this$0.c, 4);
      return;
      label134:
      localObject = aths.a().c(parama, 256);
      if ((aqhq.fileExistsAndNotEmpty((String)localObject)) && (this.this$0.a != null)) {
        this.this$0.a.fP(new String(parama.cloudId) + new String(parama.pDirKey), (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auar
 * JD-Core Version:    0.7.0.1
 */