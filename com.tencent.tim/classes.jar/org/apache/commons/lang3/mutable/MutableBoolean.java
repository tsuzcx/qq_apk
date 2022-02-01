package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class MutableBoolean
  implements Serializable, Comparable<MutableBoolean>, Mutable<Boolean>
{
  private static final long serialVersionUID = -4830728138360036487L;
  private boolean value;
  
  public MutableBoolean() {}
  
  public MutableBoolean(Boolean paramBoolean)
  {
    this.value = paramBoolean.booleanValue();
  }
  
  public MutableBoolean(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public boolean booleanValue()
  {
    return this.value;
  }
  
  public int compareTo(MutableBoolean paramMutableBoolean)
  {
    return BooleanUtils.compare(this.value, paramMutableBoolean.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MutableBoolean))
    {
      bool1 = bool2;
      if (this.value == ((MutableBoolean)paramObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Boolean getValue()
  {
    return Boolean.valueOf(this.value);
  }
  
  public int hashCode()
  {
    if (this.value) {
      return Boolean.TRUE.hashCode();
    }
    return Boolean.FALSE.hashCode();
  }
  
  public boolean isFalse()
  {
    return !this.value;
  }
  
  public boolean isTrue()
  {
    return this.value == true;
  }
  
  public void setFalse()
  {
    this.value = false;
  }
  
  public void setTrue()
  {
    this.value = true;
  }
  
  public void setValue(Boolean paramBoolean)
  {
    this.value = paramBoolean.booleanValue();
  }
  
  public void setValue(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public Boolean toBoolean()
  {
    return Boolean.valueOf(booleanValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.mutable.MutableBoolean
 * JD-Core Version:    0.7.0.1
 */