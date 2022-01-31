import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class fjq
  implements Iterator
{
  int jdField_a_of_type_Int;
  fjn jdField_a_of_type_Fjn = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  fjn jdField_b_of_type_Fjn = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  fjq(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected fjn a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Fjn = this.jdField_a_of_type_Fjn;
    this.jdField_a_of_type_Fjn = fjn.a(this.jdField_a_of_type_Fjn);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Fjn;
  }
  
  public boolean hasNext()
  {
    fjn[] arrayOffjn = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      fjn localfjn = this.jdField_a_of_type_Fjn;
      int i = this.jdField_a_of_type_Int;
      while ((localfjn == null) && (i > 0))
      {
        i -= 1;
        localfjn = arrayOffjn[i];
      }
      this.jdField_a_of_type_Fjn = localfjn;
      this.jdField_a_of_type_Int = i;
      if (localfjn == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localfjn.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Fjn = fjn.a(this.jdField_a_of_type_Fjn);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Fjn == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Fjn = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjq
 * JD-Core Version:    0.7.0.1
 */