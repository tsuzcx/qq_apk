import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class wnf
{
  private LinkedHashMap<xqv, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, xqv> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<xqv, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public xqv a(ImageView paramImageView)
  {
    paramImageView = (xqv)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, xqv paramxqv)
  {
    xqv localxqv = (xqv)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramxqv);
    if (localxqv != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localxqv);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramxqv, new WeakReference(paramImageView));
  }
  
  public void a(xqv paramxqv)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramxqv);
  }
  
  public xqv b(ImageView paramImageView)
  {
    return (xqv)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnf
 * JD-Core Version:    0.7.0.1
 */