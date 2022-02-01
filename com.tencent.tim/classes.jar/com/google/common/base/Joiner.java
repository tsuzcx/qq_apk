package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner
{
  private final String separator;
  
  private Joiner(Joiner paramJoiner)
  {
    this.separator = paramJoiner.separator;
  }
  
  private Joiner(String paramString)
  {
    this.separator = ((String)Preconditions.checkNotNull(paramString));
  }
  
  private static Iterable<Object> iterable(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    Preconditions.checkNotNull(paramArrayOfObject);
    return new Joiner.3(paramArrayOfObject, paramObject1, paramObject2);
  }
  
  public static Joiner on(char paramChar)
  {
    return new Joiner(String.valueOf(paramChar));
  }
  
  public static Joiner on(String paramString)
  {
    return new Joiner(paramString);
  }
  
  @CanIgnoreReturnValue
  public <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable)
    throws IOException
  {
    return appendTo(paramA, paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public final <A extends Appendable> A appendTo(A paramA, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
    throws IOException
  {
    return appendTo(paramA, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public <A extends Appendable> A appendTo(A paramA, Iterator<?> paramIterator)
    throws IOException
  {
    Preconditions.checkNotNull(paramA);
    if (paramIterator.hasNext())
    {
      paramA.append(toString(paramIterator.next()));
      while (paramIterator.hasNext())
      {
        paramA.append(this.separator);
        paramA.append(toString(paramIterator.next()));
      }
    }
    return paramA;
  }
  
  @CanIgnoreReturnValue
  public final <A extends Appendable> A appendTo(A paramA, Object[] paramArrayOfObject)
    throws IOException
  {
    return appendTo(paramA, Arrays.asList(paramArrayOfObject));
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    return appendTo(paramStringBuilder, paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
  {
    return appendTo(paramStringBuilder, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      appendTo(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    return appendTo(paramStringBuilder, Arrays.asList(paramArrayOfObject));
  }
  
  public final String join(Iterable<?> paramIterable)
  {
    return join(paramIterable.iterator());
  }
  
  public final String join(@Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
  {
    return join(iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  public final String join(Iterator<?> paramIterator)
  {
    return appendTo(new StringBuilder(), paramIterator).toString();
  }
  
  public final String join(Object[] paramArrayOfObject)
  {
    return join(Arrays.asList(paramArrayOfObject));
  }
  
  public Joiner skipNulls()
  {
    return new Joiner.2(this, this);
  }
  
  CharSequence toString(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
  
  public Joiner useForNull(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return new Joiner.1(this, this, paramString);
  }
  
  public MapJoiner withKeyValueSeparator(char paramChar)
  {
    return withKeyValueSeparator(String.valueOf(paramChar));
  }
  
  public MapJoiner withKeyValueSeparator(String paramString)
  {
    return new MapJoiner(this, paramString, null);
  }
  
  public static final class MapJoiner
  {
    private final Joiner joiner;
    private final String keyValueSeparator;
    
    private MapJoiner(Joiner paramJoiner, String paramString)
    {
      this.joiner = paramJoiner;
      this.keyValueSeparator = ((String)Preconditions.checkNotNull(paramString));
    }
    
    @Beta
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A paramA, Iterable<? extends Map.Entry<?, ?>> paramIterable)
      throws IOException
    {
      return appendTo(paramA, paramIterable.iterator());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A paramA, Iterator<? extends Map.Entry<?, ?>> paramIterator)
      throws IOException
    {
      Preconditions.checkNotNull(paramA);
      if (paramIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramIterator.next();
        paramA.append(this.joiner.toString(localEntry.getKey()));
        paramA.append(this.keyValueSeparator);
        paramA.append(this.joiner.toString(localEntry.getValue()));
        while (paramIterator.hasNext())
        {
          paramA.append(this.joiner.separator);
          localEntry = (Map.Entry)paramIterator.next();
          paramA.append(this.joiner.toString(localEntry.getKey()));
          paramA.append(this.keyValueSeparator);
          paramA.append(this.joiner.toString(localEntry.getValue()));
        }
      }
      return paramA;
    }
    
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A paramA, Map<?, ?> paramMap)
      throws IOException
    {
      return appendTo(paramA, paramMap.entrySet());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<? extends Map.Entry<?, ?>> paramIterable)
    {
      return appendTo(paramStringBuilder, paramIterable.iterator());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator<? extends Map.Entry<?, ?>> paramIterator)
    {
      try
      {
        appendTo(paramStringBuilder, paramIterator);
        return paramStringBuilder;
      }
      catch (IOException paramStringBuilder)
      {
        throw new AssertionError(paramStringBuilder);
      }
    }
    
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder paramStringBuilder, Map<?, ?> paramMap)
    {
      return appendTo(paramStringBuilder, paramMap.entrySet());
    }
    
    @Beta
    public String join(Iterable<? extends Map.Entry<?, ?>> paramIterable)
    {
      return join(paramIterable.iterator());
    }
    
    @Beta
    public String join(Iterator<? extends Map.Entry<?, ?>> paramIterator)
    {
      return appendTo(new StringBuilder(), paramIterator).toString();
    }
    
    public String join(Map<?, ?> paramMap)
    {
      return join(paramMap.entrySet());
    }
    
    public MapJoiner useForNull(String paramString)
    {
      return new MapJoiner(this.joiner.useForNull(paramString), this.keyValueSeparator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Joiner
 * JD-Core Version:    0.7.0.1
 */