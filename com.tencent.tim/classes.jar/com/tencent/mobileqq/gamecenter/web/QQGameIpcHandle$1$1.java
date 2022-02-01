package com.tencent.mobileqq.gamecenter.web;

import ahvg;
import ahvg.a;
import ahvg.b;
import ahvh;
import eipc.EIPCResult;
import java.util.Map;

public class QQGameIpcHandle$1$1
  implements Runnable
{
  public QQGameIpcHandle$1$1(ahvh paramahvh, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    if (ahvg.a.a(this.jdField_a_of_type_Ahvh.a) != null) {
      ahvg.a.a(this.jdField_a_of_type_Ahvh.a).a(this.jdField_a_of_type_Ahvh.bLO, this.jdField_a_of_type_EipcEIPCResult);
    }
    if (this.jdField_a_of_type_Ahvh.cit)
    {
      ahvg.a(this.jdField_a_of_type_Ahvh.b).remove(this.jdField_a_of_type_Ahvh.bLO);
      ahvg.a(this.jdField_a_of_type_Ahvh.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameIpcHandle.1.1
 * JD-Core Version:    0.7.0.1
 */