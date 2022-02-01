import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class yfa
{
  private LinkedHashMap<zgo, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, zgo> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<zgo, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public zgo a(ImageView paramImageView)
  {
    paramImageView = (zgo)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, zgo paramzgo)
  {
    zgo localzgo = (zgo)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramzgo);
    if (localzgo != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localzgo);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramzgo, new WeakReference(paramImageView));
  }
  
  public void a(zgo paramzgo)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramzgo);
  }
  
  public zgo b(ImageView paramImageView)
  {
    return (zgo)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfa
 * JD-Core Version:    0.7.0.1
 */