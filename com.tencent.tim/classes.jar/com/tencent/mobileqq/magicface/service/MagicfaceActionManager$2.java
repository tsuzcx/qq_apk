package com.tencent.mobileqq.magicface.service;

import aixr;
import aixv;
import aiyf;
import aiyh;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MagicfaceActionManager$2
  implements Runnable
{
  public MagicfaceActionManager$2(aiyh paramaiyh, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      bool1 = this.this$0.isRelease;
      if (bool1) {
        return;
      }
      this.this$0.Qt(this.dgT);
      localObject1 = null;
      if (this.val$type != 0) {
        break label277;
      }
      localObject1 = this.this$0.jdField_a_of_type_Aiyf.lH("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label248;
      }
      this.this$0.jdField_a_of_type_Aixt = this.this$0.jdField_a_of_type_Aixv.a((String)localObject1);
      if (this.val$type == 1) {
        this.this$0.dvv();
      }
      this.this$0.a(this.this$0.jdField_a_of_type_Aixt);
      this.this$0.CL = this.this$0.jdField_a_of_type_Aixv.ay((String)localObject1);
      this.this$0.dvu();
      localObject1 = this.this$0.CL.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        aixr localaixr;
        boolean bool2;
        label248:
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + localException.toString());
        }
        label277:
        label301:
        return;
        label383:
        if (bool1)
        {
          bool1 = this.this$0.isShutDown;
          if (!bool1) {}
        }
      }
    }
    finally
    {
      if (!QLog.isColorLevel()) {
        break label417;
      }
      QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      label417:
      this.this$0.b(this.this$0.jdField_a_of_type_Aixt);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localaixr = (aixr)((Iterator)localObject1).next();
      this.this$0.jdField_b_of_type_Aixr = localaixr;
      localaixr.jdField_a_of_type_Aiyl = this.this$0.jdField_b_of_type_Aiyl;
      localaixr.jdField_a_of_type_Aixt = this.this$0.jdField_a_of_type_Aixt;
      bool1 = localaixr.ace();
      bool2 = this.this$0.isShutDown;
      if (!bool2) {
        break label301;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      }
      this.this$0.b(this.this$0.jdField_a_of_type_Aixt);
      return;
      if (this.val$type != 1) {
        break;
      }
      localObject1 = this.this$0.jdField_a_of_type_Aiyf.lH("receive.xml");
      break;
      if (!localaixr.cmA) {
        break label383;
      }
      this.this$0.dvt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2
 * JD-Core Version:    0.7.0.1
 */