import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;

class rbd
  implements SeekBar.OnSeekBarChangeListener
{
  rbd(rbc paramrbc) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NativeGifImage.QZONE_DELAY = (int)(this.a.bm * paramInt + this.a.bpB);
      if (this.a.b.a.a != null) {
        this.a.b.a.a.setDuration(NativeGifImage.QZONE_DELAY);
      }
      this.a.aGy = true;
      this.a.delayTime = NativeGifImage.QZONE_DELAY;
      this.a.bpA = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onProgressChanged | delayTime:" + this.a.delayTime + " barPosition:" + this.a.bpA);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbd
 * JD-Core Version:    0.7.0.1
 */