package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
abstract interface PatternCompiler
{
  public abstract CommonPattern compile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.PatternCompiler
 * JD-Core Version:    0.7.0.1
 */