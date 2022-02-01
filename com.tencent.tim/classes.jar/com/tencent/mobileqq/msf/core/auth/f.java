package com.tencent.mobileqq.msf.core.auth;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Comparator;

class f
  implements Comparator
{
  f(d paramd) {}
  
  public int a(SimpleAccount paramSimpleAccount1, SimpleAccount paramSimpleAccount2)
  {
    long l = Long.parseLong(paramSimpleAccount1.getAttribute("_loginTime", "0"));
    if (Long.parseLong(paramSimpleAccount2.getAttribute("_loginTime", "0")) > l) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.f
 * JD-Core Version:    0.7.0.1
 */