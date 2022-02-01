package com.google.common.util.concurrent;

final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1
  extends ClassValue<Boolean>
{
  protected Boolean computeValue(Class<?> paramClass)
  {
    FuturesGetChecked.checkExceptionClassValidity(paramClass.asSubclass(Exception.class));
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.ClassValueValidator.1
 * JD-Core Version:    0.7.0.1
 */