package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ExecutionError
  extends Error
{
  private static final long serialVersionUID = 0L;
  
  protected ExecutionError() {}
  
  public ExecutionError(@Nullable Error paramError)
  {
    super(paramError);
  }
  
  protected ExecutionError(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public ExecutionError(@Nullable String paramString, @Nullable Error paramError)
  {
    super(paramString, paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ExecutionError
 * JD-Core Version:    0.7.0.1
 */