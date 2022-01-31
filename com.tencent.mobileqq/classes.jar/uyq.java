import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class uyq
{
  private LinkedHashMap<wcg, WeakReference<ImageView>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, wcg> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public ListIterator<Map.Entry<wcg, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public wcg a(ImageView paramImageView)
  {
    paramImageView = (wcg)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
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
  
  public void a(ImageView paramImageView, wcg paramwcg)
  {
    wcg localwcg = (wcg)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramwcg);
    if (localwcg != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localwcg);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramwcg, new WeakReference(paramImageView));
  }
  
  public void a(wcg paramwcg)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramwcg);
  }
  
  public wcg b(ImageView paramImageView)
  {
    return (wcg)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyq
 * JD-Core Version:    0.7.0.1
 */