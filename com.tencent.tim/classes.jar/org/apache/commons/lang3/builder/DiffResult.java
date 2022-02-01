package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiffResult
  implements Iterable<Diff<?>>
{
  private static final String DIFFERS_STRING = "differs from";
  public static final String OBJECTS_SAME_STRING = "";
  private final List<Diff<?>> diffs;
  private final Object lhs;
  private final Object rhs;
  private final ToStringStyle style;
  
  DiffResult(Object paramObject1, Object paramObject2, List<Diff<?>> paramList, ToStringStyle paramToStringStyle)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("Left hand object cannot be null");
    }
    if (paramObject2 == null) {
      throw new IllegalArgumentException("Right hand object cannot be null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("List of differences cannot be null");
    }
    this.diffs = paramList;
    this.lhs = paramObject1;
    this.rhs = paramObject2;
    if (paramToStringStyle == null)
    {
      this.style = ToStringStyle.DEFAULT_STYLE;
      return;
    }
    this.style = paramToStringStyle;
  }
  
  public List<Diff<?>> getDiffs()
  {
    return Collections.unmodifiableList(this.diffs);
  }
  
  public int getNumberOfDiffs()
  {
    return this.diffs.size();
  }
  
  public ToStringStyle getToStringStyle()
  {
    return this.style;
  }
  
  public Iterator<Diff<?>> iterator()
  {
    return this.diffs.iterator();
  }
  
  public String toString()
  {
    return toString(this.style);
  }
  
  public String toString(ToStringStyle paramToStringStyle)
  {
    if (this.diffs.size() == 0) {
      return "";
    }
    ToStringBuilder localToStringBuilder = new ToStringBuilder(this.lhs, paramToStringStyle);
    paramToStringStyle = new ToStringBuilder(this.rhs, paramToStringStyle);
    Iterator localIterator = this.diffs.iterator();
    while (localIterator.hasNext())
    {
      Diff localDiff = (Diff)localIterator.next();
      localToStringBuilder.append(localDiff.getFieldName(), localDiff.getLeft());
      paramToStringStyle.append(localDiff.getFieldName(), localDiff.getRight());
    }
    return String.format("%s %s %s", new Object[] { localToStringBuilder.build(), "differs from", paramToStringStyle.build() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffResult
 * JD-Core Version:    0.7.0.1
 */