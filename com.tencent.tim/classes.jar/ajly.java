import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class ajly
  implements angd.b
{
  ajly(ajlu paramajlu, long paramLong, ajlp paramajlp, String paramString, int paramInt1, int paramInt2) {}
  
  public void onComplete(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.val$id + ", result =" + paramInt);
    }
    if (this.b.a.o != null)
    {
      String str = ShortVideoUtils.a(this.b.a.o, "mp4");
      ajlq localajlq = this.e.a(this.val$key);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.result = paramInt;
        localajlq.jdField_a_of_type_Ajlp.fileType = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localajlq.jdField_a_of_type_Ajmh = new ajmh(this.val$id, this.bWI, this.val$type, i, str, false);
        this.e.a(this.val$key, localajlq);
        this.e.b(localajlq.jdField_a_of_type_Ajlp, 0, 0, "");
      }
    }
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.e.c != null) && (this.b.a.o != null)) {
      this.e.c.b(this.val$id, this.bWI, this.val$type, paramInt, this.b.a.o.videoFileSize, true);
    }
    ajlq localajlq;
    if (this.b.a != null)
    {
      localajlq = this.e.a(this.val$key);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.progress = paramInt;
        this.e.a(this.val$key, localajlq);
        if (!ajlu.a(this.e)) {
          break label136;
        }
        ajlu.a(this.e, localajlq, localajlq.progress);
      }
    }
    return;
    label136:
    ajlu.b(this.e, localajlq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajly
 * JD-Core Version:    0.7.0.1
 */