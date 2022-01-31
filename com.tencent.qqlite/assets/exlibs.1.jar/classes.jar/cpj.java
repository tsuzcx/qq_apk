import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;

public class cpj
  implements Runnable
{
  public cpj(LebaListViewAdapter paramLebaListViewAdapter, LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder, Drawable paramDrawable, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    LebaListViewAdapter localLebaListViewAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter;
    ImageView localImageView1 = this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$CornerListItemHolder.f;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ImageView localImageView2 = this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$CornerListItemHolder.g;
    if (this.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      LebaListViewAdapter.a(localLebaListViewAdapter, localImageView1, localDrawable, localImageView2, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpj
 * JD-Core Version:    0.7.0.1
 */