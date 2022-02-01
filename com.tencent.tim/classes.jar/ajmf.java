import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class ajmf
  implements angd.b
{
  ajmf(ajlu paramajlu, ajlp paramajlp, String paramString) {}
  
  public void onComplete(int paramInt)
  {
    if ((this.b.a != null) && (this.b.a.o != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.val$key + ", result = " + paramInt + " , uniseq = " + this.b.a.o.uniseq);
    }
    this.e.b(this.b, paramInt, 0, "");
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.b.a != null) && (this.b.a.o != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.val$key + ", pos = " + paramInt + " , uniseq = " + this.b.a.o.uniseq);
    }
    if (this.b.a != null)
    {
      String str = this.e.a(this.b.a.b);
      ajlq localajlq = this.e.a(str);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.progress = paramInt;
        this.e.a(str, localajlq);
        ajlu.a(this.e, localajlq, localajlq.progress);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmf
 * JD-Core Version:    0.7.0.1
 */