package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonMatcher
{
  abstract int end();
  
  abstract boolean find();
  
  abstract boolean find(int paramInt);
  
  abstract boolean matches();
  
  abstract String replaceAll(String paramString);
  
  abstract int start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.CommonMatcher
 * JD-Core Version:    0.7.0.1
 */