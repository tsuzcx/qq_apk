import com.tencent.qphone.base.util.QLog;

class ajme
  extends angu.a
{
  ajme(ajlu paramajlu, String paramString, ajlp paramajlp) {}
  
  public void a(int paramInt, angq paramangq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.val$key + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramangq != null)
    {
      str1 = str2;
      i = j;
      if (paramangq.c != null)
      {
        i = paramangq.c.errCode;
        str1 = paramangq.c.bUJ;
      }
    }
    this.e.b(this.b, paramInt, i, str1);
  }
  
  public void onUpdateProgress(int paramInt)
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
 * Qualified Name:     ajme
 * JD-Core Version:    0.7.0.1
 */