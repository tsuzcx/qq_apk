import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class axsp
  implements URLDrawable.URLDrawableListener
{
  axsp(String paramString1, String paramString2, ayne paramayne, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, axqg paramaxqg, int paramInt3) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    axso.rv.remove(this.val$path);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "urlDrawableListener onLoadSuccessed");
    }
    axso.b(paramURLDrawable, this.val$name, this.val$path, this.jdField_b_of_type_Ayne, this.bdm, this.eGU, this.Ew, this.Ex, this.val$scale, this.a, this.jdField_b_of_type_Axqg, this.eGV);
    axso.rv.remove(this.val$path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsp
 * JD-Core Version:    0.7.0.1
 */