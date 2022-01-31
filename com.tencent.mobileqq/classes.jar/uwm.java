import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.qphone.base.util.QLog;

class uwm
  implements Runnable
{
  uwm(uwl paramuwl, Drawable paramDrawable1, Drawable paramDrawable2) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + DoodleMsgLayout.a(this.jdField_a_of_type_Uwl.a));
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (DoodleMsgLayout.b(this.jdField_a_of_type_Uwl.a) != null)) {
      DoodleMsgLayout.b(this.jdField_a_of_type_Uwl.a).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (DoodleMsgLayout.c(this.jdField_a_of_type_Uwl.a) != null) {
      DoodleMsgLayout.c(this.jdField_a_of_type_Uwl.a).setImageDrawable(this.b);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      Drawable localDrawable = ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getCurrDrawable();
      if ((localDrawable instanceof GifDrawable)) {
        ((GifDrawable)localDrawable).getImage().reset();
      }
      ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setIndividualPause(false);
    }
    DoodleMsgLayout.a(this.jdField_a_of_type_Uwl.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */