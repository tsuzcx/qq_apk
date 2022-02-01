package com.google.android.exoplayer2.util;

import android.util.Pair;

public abstract interface ErrorMessageProvider<T extends Throwable>
{
  public abstract Pair<Integer, String> getErrorMessage(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ErrorMessageProvider
 * JD-Core Version:    0.7.0.1
 */