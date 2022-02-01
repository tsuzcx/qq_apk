package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class MoreObjects
{
  public static <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return Preconditions.checkNotNull(paramT2);
  }
  
  public static ToStringHelper toStringHelper(Class<?> paramClass)
  {
    return new ToStringHelper(paramClass.getSimpleName(), null);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject.getClass().getSimpleName(), null);
  }
  
  public static ToStringHelper toStringHelper(String paramString)
  {
    return new ToStringHelper(paramString, null);
  }
  
  public static final class ToStringHelper
  {
    private final String className;
    private final ValueHolder holderHead = new ValueHolder(null);
    private ValueHolder holderTail = this.holderHead;
    private boolean omitNullValues = false;
    
    private ToStringHelper(String paramString)
    {
      this.className = ((String)Preconditions.checkNotNull(paramString));
    }
    
    private ValueHolder addHolder()
    {
      ValueHolder localValueHolder = new ValueHolder(null);
      this.holderTail.next = localValueHolder;
      this.holderTail = localValueHolder;
      return localValueHolder;
    }
    
    private ToStringHelper addHolder(@Nullable Object paramObject)
    {
      addHolder().value = paramObject;
      return this;
    }
    
    private ToStringHelper addHolder(String paramString, @Nullable Object paramObject)
    {
      ValueHolder localValueHolder = addHolder();
      localValueHolder.value = paramObject;
      localValueHolder.name = ((String)Preconditions.checkNotNull(paramString));
      return this;
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, char paramChar)
    {
      return addHolder(paramString, String.valueOf(paramChar));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, double paramDouble)
    {
      return addHolder(paramString, String.valueOf(paramDouble));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, float paramFloat)
    {
      return addHolder(paramString, String.valueOf(paramFloat));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, int paramInt)
    {
      return addHolder(paramString, String.valueOf(paramInt));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, long paramLong)
    {
      return addHolder(paramString, String.valueOf(paramLong));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, @Nullable Object paramObject)
    {
      return addHolder(paramString, paramObject);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String paramString, boolean paramBoolean)
    {
      return addHolder(paramString, String.valueOf(paramBoolean));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(char paramChar)
    {
      return addHolder(String.valueOf(paramChar));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(double paramDouble)
    {
      return addHolder(String.valueOf(paramDouble));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(float paramFloat)
    {
      return addHolder(String.valueOf(paramFloat));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(int paramInt)
    {
      return addHolder(String.valueOf(paramInt));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(long paramLong)
    {
      return addHolder(String.valueOf(paramLong));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(@Nullable Object paramObject)
    {
      return addHolder(paramObject);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(boolean paramBoolean)
    {
      return addHolder(String.valueOf(paramBoolean));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper omitNullValues()
    {
      this.omitNullValues = true;
      return this;
    }
    
    public String toString()
    {
      boolean bool = this.omitNullValues;
      StringBuilder localStringBuilder = new StringBuilder(32).append(this.className).append('{');
      ValueHolder localValueHolder = this.holderHead.next;
      Object localObject1 = "";
      if (localValueHolder != null)
      {
        Object localObject3 = localValueHolder.value;
        Object localObject2;
        if (bool)
        {
          localObject2 = localObject1;
          if (localObject3 == null) {}
        }
        else
        {
          localStringBuilder.append((String)localObject1);
          localObject2 = ", ";
          if (localValueHolder.name != null) {
            localStringBuilder.append(localValueHolder.name).append('=');
          }
          if ((localObject3 == null) || (!localObject3.getClass().isArray())) {
            break label148;
          }
          localObject1 = Arrays.deepToString(new Object[] { localObject3 });
          localStringBuilder.append((CharSequence)localObject1, 1, ((String)localObject1).length() - 1);
        }
        for (;;)
        {
          localValueHolder = localValueHolder.next;
          localObject1 = localObject2;
          break;
          label148:
          localStringBuilder.append(localObject3);
        }
      }
      return '}';
    }
    
    static final class ValueHolder
    {
      String name;
      ValueHolder next;
      Object value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.MoreObjects
 * JD-Core Version:    0.7.0.1
 */