package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import gjy;

public class InitMemoryCache
  extends Step
{
  protected boolean a()
  {
    if ("com.tencent.mobileqqi".equals(BaseApplicationImpl.processName))
    {
      long l = MemoryManager.a() * 3L / 16L;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new gjy(Integer.valueOf((int)l));
      BaseApplicationImpl.jdField_a_of_type_Int = (int)l;
    }
    for (;;)
    {
      return true;
      if (BaseApplicationImpl.processName.endsWith(":peak"))
      {
        int j = (int)(MemoryManager.a() * 3L / 16L);
        int i = 4194304;
        if (j > 4194304) {
          i = j;
        }
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new gjy(Integer.valueOf(i));
        BaseApplicationImpl.jdField_a_of_type_Int = j;
        if (QLog.isColorLevel()) {
          QLog.d("MemoryCache", 2, "memory size:" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */