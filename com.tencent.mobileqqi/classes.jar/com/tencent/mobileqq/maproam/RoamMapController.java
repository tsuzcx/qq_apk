package com.tencent.mobileqq.maproam;

import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class RoamMapController
  implements Manager
{
  public static String a;
  public LBSHandler a;
  public LBSObserver a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RoamMapController";
  }
  
  public RoamMapController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  public java.util.List a(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 29	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 30	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 24	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: iconst_3
    //   15: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   18: checkcast 37	com/tencent/mobileqq/app/LBSHandler
    //   21: putfield 39	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSHandler	Lcom/tencent/mobileqq/app/LBSHandler;
    //   24: aload_0
    //   25: new 41	gft
    //   28: dup
    //   29: aload_0
    //   30: iload_3
    //   31: aload 4
    //   33: invokespecial 44	gft:<init>	(Lcom/tencent/mobileqq/maproam/RoamMapController;ILjava/util/ArrayList;)V
    //   36: putfield 46	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSObserver	Lcom/tencent/mobileqq/app/LBSObserver;
    //   39: aload_0
    //   40: getfield 24	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: aload_0
    //   44: getfield 46	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSObserver	Lcom/tencent/mobileqq/app/LBSObserver;
    //   47: iconst_1
    //   48: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;Z)V
    //   51: aload_0
    //   52: getfield 39	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSHandler	Lcom/tencent/mobileqq/app/LBSHandler;
    //   55: iconst_0
    //   56: iconst_1
    //   57: aconst_null
    //   58: iload_1
    //   59: iload_2
    //   60: iconst_2
    //   61: getstatic 55	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:x	I
    //   64: invokevirtual 58	com/tencent/mobileqq/app/LBSHandler:a	(IZ[JIIII)V
    //   67: aload_0
    //   68: getfield 39	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSHandler	Lcom/tencent/mobileqq/app/LBSHandler;
    //   71: astore 5
    //   73: aload 5
    //   75: monitorenter
    //   76: aload_0
    //   77: getfield 39	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSHandler	Lcom/tencent/mobileqq/app/LBSHandler;
    //   80: ldc2_w 59
    //   83: invokevirtual 64	java/lang/Object:wait	(J)V
    //   86: aload 5
    //   88: monitorexit
    //   89: aload_0
    //   90: getfield 24	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   93: aload_0
    //   94: getfield 46	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSObserver	Lcom/tencent/mobileqq/app/LBSObserver;
    //   97: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:c	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   100: aload 4
    //   102: areturn
    //   103: astore 6
    //   105: aload 5
    //   107: monitorexit
    //   108: aload 6
    //   110: athrow
    //   111: astore 5
    //   113: aload 5
    //   115: invokevirtual 71	java/lang/InterruptedException:printStackTrace	()V
    //   118: aload_0
    //   119: getfield 24	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: aload_0
    //   123: getfield 46	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSObserver	Lcom/tencent/mobileqq/app/LBSObserver;
    //   126: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:c	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   129: aload 4
    //   131: areturn
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 24	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   138: aload_0
    //   139: getfield 46	com/tencent/mobileqq/maproam/RoamMapController:jdField_a_of_type_ComTencentMobileqqAppLBSObserver	Lcom/tencent/mobileqq/app/LBSObserver;
    //   142: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:c	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   145: aload 4
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	RoamMapController
    //   0	148	1	paramInt1	int
    //   0	148	2	paramInt2	int
    //   0	148	3	paramInt3	int
    //   7	123	4	localArrayList	java.util.ArrayList
    //   132	14	4	localObject1	Object
    //   111	3	5	localInterruptedException	java.lang.InterruptedException
    //   103	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   76	89	103	finally
    //   105	108	103	finally
    //   67	76	111	java/lang/InterruptedException
    //   108	111	111	java/lang/InterruptedException
    //   67	76	132	finally
    //   108	111	132	finally
    //   113	118	132	finally
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.RoamMapController
 * JD-Core Version:    0.7.0.1
 */