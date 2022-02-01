import com.tencent.qphone.base.util.QLog;

class ajmb
  implements akxb
{
  ajmb(ajlu paramajlu, ajlp paramajlp) {}
  
  public void a(akxb.a parama)
  {
    int i = 0;
    String str = "";
    int k;
    if (parama != null)
    {
      k = parama.result;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (parama.a != null)
      {
        i = parama.a.errCode;
        str = parama.a.bUJ;
      }
    }
    for (int j = k;; j = 0)
    {
      this.e.b(this.b, j, i, str);
      return;
    }
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    if (this.b.a != null)
    {
      String str = this.e.a(this.b.a.b);
      ajlq localajlq = this.e.a(str);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.progress = (paramInt / 100);
        this.e.a(str, localajlq);
        ajlu.a(this.e, localajlq, paramInt / 100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmb
 * JD-Core Version:    0.7.0.1
 */