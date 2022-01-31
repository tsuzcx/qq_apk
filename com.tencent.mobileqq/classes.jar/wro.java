import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class wro
{
  private LinkedHashMap<xve, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, xve> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<xve, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public xve a(ImageView paramImageView)
  {
    paramImageView = (xve)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramImageView != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramImageView);
    }
    return paramImageView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
  }
  
  public void a(ImageView paramImageView, xve paramxve)
  {
    xve localxve = (xve)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramxve);
    if (localxve != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localxve);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramxve, new WeakReference(paramImageView));
  }
  
  public void a(xve paramxve)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramxve);
  }
  
  public xve b(ImageView paramImageView)
  {
    return (xve)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wro
 * JD-Core Version:    0.7.0.1
 */