package android.support.v4.util;

import java.util.Map;

class ArraySet$1
  extends MapCollections
{
  ArraySet$1(ArraySet paramArraySet) {}
  
  protected void colClear()
  {
    this.this$0.clear();
  }
  
  protected Object colGetEntry(int paramInt1, int paramInt2)
  {
    return ArraySet.access$100(this.this$0)[paramInt1];
  }
  
  protected Map colGetMap()
  {
    throw new UnsupportedOperationException("not a map");
  }
  
  protected int colGetSize()
  {
    return ArraySet.access$000(this.this$0);
  }
  
  protected int colIndexOfKey(Object paramObject)
  {
    return this.this$0.indexOf(paramObject);
  }
  
  protected int colIndexOfValue(Object paramObject)
  {
    return this.this$0.indexOf(paramObject);
  }
  
  protected void colPut(Object paramObject1, Object paramObject2)
  {
    this.this$0.add(paramObject1);
  }
  
  protected void colRemoveAt(int paramInt)
  {
    this.this$0.removeAt(paramInt);
  }
  
  protected Object colSetValue(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("not a map");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.ArraySet.1
 * JD-Core Version:    0.7.0.1
 */