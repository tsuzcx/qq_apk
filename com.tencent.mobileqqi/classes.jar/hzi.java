import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class hzi
  implements Iterator
{
  int jdField_a_of_type_Int;
  hzf jdField_a_of_type_Hzf = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  hzf jdField_b_of_type_Hzf = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  hzi(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected hzf a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Hzf = this.jdField_a_of_type_Hzf;
    this.jdField_a_of_type_Hzf = hzf.a(this.jdField_a_of_type_Hzf);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Hzf;
  }
  
  public boolean hasNext()
  {
    hzf[] arrayOfhzf = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      hzf localhzf = this.jdField_a_of_type_Hzf;
      int i = this.jdField_a_of_type_Int;
      while ((localhzf == null) && (i > 0))
      {
        i -= 1;
        localhzf = arrayOfhzf[i];
      }
      this.jdField_a_of_type_Hzf = localhzf;
      this.jdField_a_of_type_Int = i;
      if (localhzf == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localhzf.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Hzf = hzf.a(this.jdField_a_of_type_Hzf);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Hzf == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Hzf = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hzi
 * JD-Core Version:    0.7.0.1
 */