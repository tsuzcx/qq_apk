import com.tencent.qphone.base.util.QLog;

class ajmg
  implements agzl
{
  ajmg(ajlu paramajlu, String paramString, ajlp paramajlp) {}
  
  public void Ke(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.val$key + ", result = " + paramBoolean);
    }
    ajlu.a(this.e, this.b, paramBoolean);
  }
  
  public void Kf(boolean paramBoolean) {}
  
  public void onUpdateProgress(int paramInt)
  {
    if ((this.b != null) && (this.b.a != null))
    {
      String str = this.b.a.vW();
      ajlq localajlq = this.e.a(str);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.progress = paramInt;
        this.e.a(str, localajlq);
        ajlu.a(this.e, localajlq, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmg
 * JD-Core Version:    0.7.0.1
 */