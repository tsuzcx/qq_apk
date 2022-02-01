package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
class EmptyImmutableListMultimap
  extends ImmutableListMultimap<Object, Object>
{
  static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
  private static final long serialVersionUID = 0L;
  
  private EmptyImmutableListMultimap()
  {
    super(ImmutableMap.of(), 0);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableListMultimap
 * JD-Core Version:    0.7.0.1
 */