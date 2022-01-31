package com.tencent.mobileqq.pb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PBRepeatField<T>
  extends PBField<List<T>>
{
  private final PBField<T> helper;
  private List<T> value = Collections.emptyList();
  
  public PBRepeatField(PBField<T> paramPBField)
  {
    this.helper = paramPBField;
  }
  
  public void add(T paramT)
  {
    get().add(paramT);
  }
  
  public void addAll(Collection<T> paramCollection)
  {
    get().addAll(paramCollection);
  }
  
  public void clear(Object paramObject)
  {
    this.value = Collections.emptyList();
  }
  
  public int computeSize(int paramInt)
  {
    return computeSizeDirectly(paramInt, this.value);
  }
  
  protected int computeSizeDirectly(int paramInt, List<T> paramList)
  {
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      i += this.helper.computeSizeDirectly(paramInt, localObject);
    }
    return i;
  }
  
  protected void copyFrom(PBField<List<T>> paramPBField)
  {
    paramPBField = (PBRepeatField)paramPBField;
    if (paramPBField.isEmpty())
    {
      this.value = Collections.emptyList();
      return;
    }
    List localList = get();
    localList.clear();
    localList.addAll(paramPBField.value);
  }
  
  public T get(int paramInt)
  {
    return this.value.get(paramInt);
  }
  
  public List<T> get()
  {
    if (this.value == Collections.emptyList()) {
      this.value = new ArrayList();
    }
    return this.value;
  }
  
  public boolean has()
  {
    return !isEmpty();
  }
  
  public boolean isEmpty()
  {
    return this.value.isEmpty();
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    add(this.helper.readFromDirectly(paramCodedInputStreamMicro));
  }
  
  protected List<T> readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    throw new RuntimeException("PBRepeatField not support readFromDirectly method.");
  }
  
  public void remove(int paramInt)
  {
    get().remove(paramInt);
  }
  
  public void set(int paramInt, T paramT)
  {
    this.value.set(paramInt, paramT);
  }
  
  public void set(List<T> paramList)
  {
    this.value = paramList;
  }
  
  public int size()
  {
    return this.value.size();
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
    throws IOException
  {
    writeToDirectly(paramCodedOutputStreamMicro, paramInt, this.value);
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, List<T> paramList)
    throws IOException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      this.helper.writeToDirectly(paramCodedOutputStreamMicro, paramInt, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBRepeatField
 * JD-Core Version:    0.7.0.1
 */