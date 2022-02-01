package org.apache.commons.lang3.builder;

final class IDKey
{
  private final int id;
  private final Object value;
  
  public IDKey(Object paramObject)
  {
    this.id = System.identityHashCode(paramObject);
    this.value = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IDKey)) {}
    do
    {
      return false;
      paramObject = (IDKey)paramObject;
    } while ((this.id != paramObject.id) || (this.value != paramObject.value));
    return true;
  }
  
  public int hashCode()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.IDKey
 * JD-Core Version:    0.7.0.1
 */