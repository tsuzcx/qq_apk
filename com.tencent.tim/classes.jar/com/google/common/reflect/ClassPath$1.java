package com.google.common.reflect;

import com.google.common.base.Predicate;

final class ClassPath$1
  implements Predicate<ClassPath.ClassInfo>
{
  public boolean apply(ClassPath.ClassInfo paramClassInfo)
  {
    return ClassPath.ClassInfo.access$000(paramClassInfo).indexOf('$') == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.ClassPath.1
 * JD-Core Version:    0.7.0.1
 */