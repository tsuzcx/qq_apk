import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class vjf
  extends Animation
{
  private int jdField_a_of_type_Int;
  private WeakReference<vip> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public vjf(vip paramvip, ArrayList<Integer> paramArrayList)
  {
    a(paramvip, paramArrayList);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(vip paramvip, ArrayList<Integer> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvip);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2) || ((vip)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    float f = 1.0F / (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    int i = (int)(paramFloat / f);
    f = (paramFloat - i * f) / f;
    if (i == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 2;
    }
    for (;;)
    {
      int k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      int j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F)
      {
        i = (int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f);
        int m = (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f);
        int n = (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f);
        paramFloat = Color.blue(k);
        i = Color.argb(i, m, n, (int)((Color.blue(j) - Color.blue(k)) * f + paramFloat));
      }
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjf
 * JD-Core Version:    0.7.0.1
 */