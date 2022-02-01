package com.google.common.hash;

import com.google.common.base.Preconditions;

abstract class AbstractCompositeHashFunction
  extends AbstractStreamingHashFunction
{
  private static final long serialVersionUID = 0L;
  final HashFunction[] functions;
  
  AbstractCompositeHashFunction(HashFunction... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramVarArgs[i]);
      i += 1;
    }
    this.functions = paramVarArgs;
  }
  
  abstract HashCode makeHash(Hasher[] paramArrayOfHasher);
  
  public Hasher newHasher()
  {
    Hasher[] arrayOfHasher = new Hasher[this.functions.length];
    int i = 0;
    while (i < arrayOfHasher.length)
    {
      arrayOfHasher[i] = this.functions[i].newHasher();
      i += 1;
    }
    return new AbstractCompositeHashFunction.1(this, arrayOfHasher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.AbstractCompositeHashFunction
 * JD-Core Version:    0.7.0.1
 */