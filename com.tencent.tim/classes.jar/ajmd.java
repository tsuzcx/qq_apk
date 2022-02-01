import com.tencent.qphone.base.util.QLog;

class ajmd
  extends akye.a
{
  ajmd(ajlu paramajlu, String paramString, ajlp paramajlp) {}
  
  public void a(int paramInt, akxr paramakxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.val$key + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramakxr != null)
    {
      str1 = str2;
      i = j;
      if (paramakxr.c != null)
      {
        i = paramakxr.c.errCode;
        str1 = paramakxr.c.bUJ;
      }
    }
    ajlu.a(this.e, this.b, paramInt, i, str1);
  }
  
  public void aO(int paramInt, boolean paramBoolean)
  {
    ajlu.a(this.e, this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmd
 * JD-Core Version:    0.7.0.1
 */