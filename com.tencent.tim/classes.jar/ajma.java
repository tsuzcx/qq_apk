import com.tencent.qphone.base.util.QLog;

class ajma
  implements akxb
{
  ajma(ajlu paramajlu, ajlp paramajlp) {}
  
  public void a(akxb.a parama)
  {
    int j;
    int i;
    if (parama != null)
    {
      j = parama.result;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (parama.a != null)
      {
        i = parama.a.errCode;
        parama = parama.a.bUJ;
      }
    }
    for (;;)
    {
      ajlu.a(this.e, this.b, j, i, parama);
      return;
      i = 0;
      parama = "";
      continue;
      j = 0;
      i = 0;
      parama = "";
    }
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    ajlu.a(this.e, this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajma
 * JD-Core Version:    0.7.0.1
 */