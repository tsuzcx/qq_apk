package com.qzone.utils;

public class AssertUtil
{
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.AssertUtil
 * JD-Core Version:    0.7.0.1
 */