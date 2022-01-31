package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import efm;

public class InitMemoryCache
  extends Step
{
  protected boolean a()
  {
    if (BaseApplicationImpl.g == 1)
    {
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new efm(Integer.valueOf((int)5242880L));
      BaseApplicationImpl.jdField_a_of_type_Int = (int)5242880L;
    }
    int i;
    do
    {
      do
      {
        return true;
      } while (!BaseApplicationImpl.processName.endsWith(":peak"));
      i = 5242880;
      if (MemoryManager.a() > 268435456L) {
        i = 10485760;
      }
      int j = 4194304;
      if (i > 4194304) {
        j = i;
      }
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new efm(Integer.valueOf(j));
      BaseApplicationImpl.jdField_a_of_type_Int = i;
    } while (!QLog.isColorLevel());
    QLog.d("MemoryCache", 2, "memory size:" + i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */