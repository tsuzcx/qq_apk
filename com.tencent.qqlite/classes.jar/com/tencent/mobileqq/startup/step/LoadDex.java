package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.InjectUtils;

public class LoadDex
  extends Step
{
  protected boolean a()
  {
    if ((BaseApplicationImpl.h == 4) || ("Success".equals(BaseApplicationImpl.jdField_a_of_type_JavaLangString))) {
      return true;
    }
    boolean bool1;
    if (this.x == 1)
    {
      bool1 = true;
      label30:
      BaseApplicationImpl.jdField_a_of_type_JavaLangString = InjectUtils.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, bool1);
      if (bool1) {
        if (BaseApplicationImpl.jdField_a_of_type_JavaLangString != null) {
          break label78;
        }
      }
    }
    label78:
    for (boolean bool2 = true;; bool2 = false)
    {
      BaseApplicationImpl.b = bool2;
      if ((bool1) || ("Success".equals(BaseApplicationImpl.jdField_a_of_type_JavaLangString))) {
        break;
      }
      return false;
      bool1 = false;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */