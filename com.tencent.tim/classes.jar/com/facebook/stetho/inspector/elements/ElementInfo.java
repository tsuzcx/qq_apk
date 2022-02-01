package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class ElementInfo
{
  public final List<Object> children;
  public final Object element;
  public final Object parentElement;
  
  public ElementInfo(Object paramObject1, Object paramObject2, List<Object> paramList)
  {
    this.element = Util.throwIfNull(paramObject1);
    this.parentElement = paramObject2;
    this.children = ListUtil.copyToImmutableList(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ElementInfo)) {
        break;
      }
      paramObject = (ElementInfo)paramObject;
    } while ((this.element == paramObject.element) && (this.parentElement == paramObject.parentElement) && (ListUtil.identityEquals(this.children, paramObject.children)));
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.ElementInfo
 * JD-Core Version:    0.7.0.1
 */