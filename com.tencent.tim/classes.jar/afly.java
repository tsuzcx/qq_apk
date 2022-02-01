import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class afly
  implements URLDrawableDownListener
{
  afly(aflw paramaflw, aflv paramaflv, URLImageView paramURLImageView, ImageView paramImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Aflv.toString());
    aflw.a(this.jdField_a_of_type_Aflw, this.ba, this.yM);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Aflv.toString());
    aflw.a(this.jdField_a_of_type_Aflw, this.ba, this.yM);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Aflv.toString());
    aflw.a(this.jdField_a_of_type_Aflw, this.ba, this.yM);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    aflw.a(this.jdField_a_of_type_Aflw, this.ba, this.yM);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionAdapter", 2, "onLoadSuccessed: " + this.jdField_a_of_type_Aflv.toString());
    }
    aflw.a(this.jdField_a_of_type_Aflw, this.ba, this.yM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afly
 * JD-Core Version:    0.7.0.1
 */