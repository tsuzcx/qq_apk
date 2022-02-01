import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class afgm
  implements URLDrawableDownListener
{
  afgm(afgf paramafgf, afmi paramafmi, afgf.a parama) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Afmi.toString());
    afgf.a(this.c, this.jdField_a_of_type_Afgf$a.aZ, this.jdField_a_of_type_Afgf$a);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Afmi.toString());
    afgf.a(this.c, this.jdField_a_of_type_Afgf$a.aZ, this.jdField_a_of_type_Afgf$a);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Afmi.toString());
    afgf.a(this.c, this.jdField_a_of_type_Afgf$a.aZ, this.jdField_a_of_type_Afgf$a);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_Afmi.toString());
    }
    afgf.a(this.c, this.jdField_a_of_type_Afgf$a.aZ, this.jdField_a_of_type_Afgf$a);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_Afmi.toString());
    }
    afgf.a(this.c, this.jdField_a_of_type_Afgf$a.aZ, this.jdField_a_of_type_Afgf$a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgm
 * JD-Core Version:    0.7.0.1
 */