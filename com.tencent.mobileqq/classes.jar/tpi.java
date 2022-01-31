import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tpi
  implements ScaleGestureDetector.OnScaleGestureListener
{
  private tpi(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.jdField_a_of_type_Float = paramScaleGestureDetector.getScaleFactor();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "缩放比例是" + this.a.jdField_a_of_type_Float);
    }
    QLog.d("qqBaseActivity", 2, "catch zoom");
    if (PublicAccountImageCollectionMainActivity.a(this.a))
    {
      if (PublicAccountImageCollectionMainActivity.a(this.a).getScaleType() != ImageView.ScaleType.MATRIX) {
        PublicAccountImageCollectionMainActivity.a(this.a).setScaleType(ImageView.ScaleType.MATRIX);
      }
      this.a.jdField_b_of_type_AndroidGraphicsMatrix.set(PublicAccountImageCollectionMainActivity.a(this.a).getImageMatrix());
      this.a.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.a.jdField_b_of_type_ArrayOfFloat);
      if (this.a.jdField_b_of_type_ArrayOfFloat[0] > this.a.jdField_a_of_type_ArrayOfFloat[0] * 3.0F)
      {
        this.a.jdField_a_of_type_Float = (this.a.jdField_a_of_type_ArrayOfFloat[0] * 3.0F / this.a.jdField_b_of_type_ArrayOfFloat[0]);
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "the last scale is" + this.a.jdField_a_of_type_Float);
        }
      }
      this.a.jdField_a_of_type_AndroidGraphicsMatrix.set(this.a.jdField_b_of_type_AndroidGraphicsMatrix);
      this.a.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.a.jdField_a_of_type_Float, this.a.jdField_a_of_type_Float, PublicAccountImageCollectionMainActivity.a(this.a).getWidth() / 2, PublicAccountImageCollectionMainActivity.a(this.a).getHeight() / 2);
      PublicAccountImageCollectionMainActivity.a(this.a).setImageMatrix(this.a.jdField_a_of_type_AndroidGraphicsMatrix);
      return true;
    }
    this.a.jdField_b_of_type_AndroidViewViewGroup = PublicAccountImageCollectionMainActivity.a(this.a).a();
    if ((this.a.jdField_b_of_type_AndroidViewViewGroup != null) && ((this.a.jdField_b_of_type_AndroidViewViewGroup.getTag() instanceof toq)))
    {
      paramScaleGestureDetector = (ZImageView)this.a.jdField_b_of_type_AndroidViewViewGroup.getChildAt(0);
      if ((paramScaleGestureDetector != null) && ((paramScaleGestureDetector instanceof ZImageView)))
      {
        PublicAccountImageCollectionMainActivity.a(this.a, paramScaleGestureDetector.getDrawable());
        int i = paramScaleGestureDetector.getWidth();
        int j = paramScaleGestureDetector.getHeight();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(15);
        this.a.jdField_c_of_type_AndroidGraphicsMatrix = paramScaleGestureDetector.getImageMatrix();
        this.a.jdField_c_of_type_AndroidGraphicsMatrix.getValues(this.a.jdField_a_of_type_ArrayOfFloat);
        this.a.jdField_a_of_type_AndroidGraphicsMatrix.set(this.a.jdField_c_of_type_AndroidGraphicsMatrix);
        PublicAccountImageCollectionMainActivity.a(this.a, new PublicAccountImageView(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidOsHandler, this.a.jdField_c_of_type_AndroidGraphicsMatrix, this.a.jdField_a_of_type_Int, i, j));
        PublicAccountImageCollectionMainActivity.a(this.a).setImageDrawable(PublicAccountImageCollectionMainActivity.a(this.a));
        PublicAccountImageCollectionMainActivity.a(this.a).setImageMatrix(this.a.jdField_a_of_type_AndroidGraphicsMatrix);
        this.a.jdField_a_of_type_AndroidViewViewGroup.addView(PublicAccountImageCollectionMainActivity.a(this.a), localLayoutParams);
        PublicAccountImageCollectionMainActivity.b(this.a, true);
        i = ((toq)this.a.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int;
        if (PublicAccountImageCollectionMainActivity.a(this.a).a != null)
        {
          paramScaleGestureDetector = ((tpt)PublicAccountImageCollectionMainActivity.a(this.a).a.get(i - 1)).jdField_a_of_type_JavaLangString;
          nrt.a(null, this.a.jdField_a_of_type_JavaLangString, "0X8007B91", "0X8007B91", 0, 0, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_c_of_type_JavaLangString, paramScaleGestureDetector, "1", false);
        }
      }
    }
    PublicAccountImageCollectionMainActivity.a(this.a).a();
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tpi
 * JD-Core Version:    0.7.0.1
 */