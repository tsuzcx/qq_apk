import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter.ViewHolder;
import com.tencent.mobileqq.widget.ImageProgressCircle;

public class gzi
  implements URLDrawableDownListener
{
  ImageProgressCircle jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter$ViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
  
  public gzi(TroopAvatarBigPhotoAdapter paramTroopAvatarBigPhotoAdapter, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter$ViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzi
 * JD-Core Version:    0.7.0.1
 */