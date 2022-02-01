package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
class EmptyImmutableSetMultimap
  extends ImmutableSetMultimap<Object, Object>
{
  static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
  private static final long serialVersionUID = 0L;
  
  private EmptyImmutableSetMultimap()
  {
    super(ImmutableMap.of(), 0, null);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableSetMultimap
 * JD-Core Version:    0.7.0.1
 */