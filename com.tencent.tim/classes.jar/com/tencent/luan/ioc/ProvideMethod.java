package com.tencent.luan.ioc;

public abstract interface ProvideMethod<T>
  extends InjectConstructor<T>
{
  public abstract InjectParam provideParam();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.ProvideMethod
 * JD-Core Version:    0.7.0.1
 */