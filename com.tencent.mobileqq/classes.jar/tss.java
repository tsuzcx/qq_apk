import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

final class tss
  implements URLDrawable.URLDrawableListener
{
  tss(long paramLong, ttd paramttd) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.PlayModeUtils", 2, "urlDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    if (this.jdField_a_of_type_Ttd != null) {
      this.jdField_a_of_type_Ttd.b();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.PlayModeUtils", 2, "urlDrawable onLoadSuccessed");
    }
    vei.b("storypic", "load_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    if (this.jdField_a_of_type_Ttd != null) {
      this.jdField_a_of_type_Ttd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tss
 * JD-Core Version:    0.7.0.1
 */