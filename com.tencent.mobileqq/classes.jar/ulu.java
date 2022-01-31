import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class ulu
{
  private LinkedHashMap<vpk, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, vpk> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<vpk, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public vpk a(ImageView paramImageView)
  {
    paramImageView = (vpk)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, vpk paramvpk)
  {
    vpk localvpk = (vpk)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramvpk);
    if (localvpk != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localvpk);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramvpk, new WeakReference(paramImageView));
  }
  
  public void a(vpk paramvpk)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramvpk);
  }
  
  public vpk b(ImageView paramImageView)
  {
    return (vpk)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */