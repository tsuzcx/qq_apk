import common.qzone.component.cache.common.SoftHashMap;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map.Entry;

public class hze
  extends SoftReference
  implements Map.Entry
{
  private final int jdField_a_of_type_Int;
  private hze jdField_a_of_type_Hze;
  private Object jdField_a_of_type_JavaLangObject;
  
  public hze(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue, int paramInt, hze paramhze)
  {
    super(paramObject1, paramReferenceQueue);
    this.jdField_a_of_type_JavaLangObject = paramObject2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Hze = paramhze;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        localObject1 = getKey();
        localObject2 = paramObject.getKey();
      } while ((localObject1 != localObject2) && ((localObject1 == null) || (!localObject1.equals(localObject2))));
      localObject1 = getValue();
      paramObject = paramObject.getValue();
    } while ((localObject1 != paramObject) && ((localObject1 == null) || (!localObject1.equals(paramObject))));
    return true;
  }
  
  public Object getKey()
  {
    return SoftHashMap.a(get());
  }
  
  public Object getValue()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label36;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label36:
      j = localObject2.hashCode();
    }
  }
  
  public Object setValue(Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return localObject;
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hze
 * JD-Core Version:    0.7.0.1
 */