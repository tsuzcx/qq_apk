import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class uyn
{
  private LinkedHashMap<wcd, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, wcd> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<wcd, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public wcd a(ImageView paramImageView)
  {
    paramImageView = (wcd)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, wcd paramwcd)
  {
    wcd localwcd = (wcd)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramwcd);
    if (localwcd != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localwcd);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramwcd, new WeakReference(paramImageView));
  }
  
  public void a(wcd paramwcd)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramwcd);
  }
  
  public wcd b(ImageView paramImageView)
  {
    return (wcd)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyn
 * JD-Core Version:    0.7.0.1
 */