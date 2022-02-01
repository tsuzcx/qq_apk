import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class iry
  implements SoundPool.OnLoadCompleteListener
{
  iry(irx paramirx, irx.a parama) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_b_of_type_Irx;
    paramSoundPool.asU += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_b_of_type_Irx.asU + ",musicCount = " + this.jdField_b_of_type_Irx.asT);
    }
    if (paramInt2 == 0) {
      this.jdField_b_of_type_Irx.E.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_b_of_type_Irx.asU == this.jdField_b_of_type_Irx.asT) {
      this.jdField_b_of_type_Irx$a.onLoadFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iry
 * JD-Core Version:    0.7.0.1
 */