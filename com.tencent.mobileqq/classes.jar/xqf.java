import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class xqf
{
  private LinkedHashMap<yrv, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, yrv> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<yrv, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public yrv a(ImageView paramImageView)
  {
    paramImageView = (yrv)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, yrv paramyrv)
  {
    yrv localyrv = (yrv)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramyrv);
    if (localyrv != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localyrv);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramyrv, new WeakReference(paramImageView));
  }
  
  public void a(yrv paramyrv)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramyrv);
  }
  
  public yrv b(ImageView paramImageView)
  {
    return (yrv)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqf
 * JD-Core Version:    0.7.0.1
 */