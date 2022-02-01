import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;

class ylg
  implements SeekBar.OnSeekBarChangeListener
{
  ylg(ylf paramylf) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NativeGifImage.QZONE_DELAY = (int)(this.a.jdField_a_of_type_Double * paramInt + this.a.g);
      if (this.a.jdField_a_of_type_Ynw.a.a != null) {
        this.a.jdField_a_of_type_Ynw.a.a.setDuration(NativeGifImage.QZONE_DELAY);
      }
      this.a.jdField_a_of_type_Boolean = true;
      this.a.e = NativeGifImage.QZONE_DELAY;
      this.a.d = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onProgressChanged | delayTime:" + this.a.e + " barPosition:" + this.a.d);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylg
 * JD-Core Version:    0.7.0.1
 */