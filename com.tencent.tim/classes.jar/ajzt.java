import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.qphone.base.util.QLog;

class ajzt
  implements ajvz.c
{
  ajzt(ajzr paramajzr) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (ajzr.a(this.a) != null)
    {
      ajzr.a(this.a).b(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (ajzr.a(this.a) != null)
    {
      ajzr.a(this.a).b(paramComment, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onDataNotAvailable, code=" + paramInt + ", tip=" + paramString + ", comment=" + paramComment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzt
 * JD-Core Version:    0.7.0.1
 */