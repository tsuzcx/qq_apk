package com.tencent.mobileqq.model;

import ajdg;
import java.util.List;

public class EmoticonManager$10
  implements Runnable
{
  public EmoticonManager$10(ajdg paramajdg, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 25	java/util/HashSet
    //   3: dup
    //   4: invokespecial 26	java/util/HashSet:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 14	com/tencent/mobileqq/model/EmoticonManager$10:this$0	Lajdg;
    //   12: getfield 32	ajdg:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: invokevirtual 38	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 43	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   23: aload_0
    //   24: getfield 16	com/tencent/mobileqq/model/EmoticonManager$10:CV	Ljava/util/List;
    //   27: invokeinterface 49 1 0
    //   32: astore_3
    //   33: aload_3
    //   34: invokeinterface 55 1 0
    //   39: ifeq +143 -> 182
    //   42: aload_3
    //   43: invokeinterface 59 1 0
    //   48: checkcast 61	com/tencent/mobileqq/data/Emoticon
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull -22 -> 33
    //   58: aload_2
    //   59: aload 4
    //   61: getfield 65	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   64: invokevirtual 69	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: getfield 14	com/tencent/mobileqq/model/EmoticonManager$10:this$0	Lajdg;
    //   72: aload 4
    //   74: invokestatic 73	ajdg:a	(Lajdg;Lcom/tencent/mobileqq/data/Emoticon;)V
    //   77: aload_0
    //   78: getfield 14	com/tencent/mobileqq/model/EmoticonManager$10:this$0	Lajdg;
    //   81: aload 4
    //   83: invokestatic 76	ajdg:a	(Lajdg;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   86: ifne -53 -> 33
    //   89: ldc 78
    //   91: iconst_1
    //   92: new 80	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   99: ldc 83
    //   101: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 4
    //   106: getfield 90	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 92
    //   114: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 4
    //   119: getfield 95	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto -98 -> 33
    //   134: astore_3
    //   135: ldc 78
    //   137: iconst_1
    //   138: new 80	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   145: ldc 107
    //   147: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 110	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 113	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   167: aload_0
    //   168: getfield 14	com/tencent/mobileqq/model/EmoticonManager$10:this$0	Lajdg;
    //   171: getfield 117	ajdg:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: invokestatic 122	yhf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lyhf;
    //   177: aload_2
    //   178: invokevirtual 126	yhf:f	(Ljava/util/Collection;)V
    //   181: return
    //   182: aload_1
    //   183: invokevirtual 129	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   186: aload_1
    //   187: invokevirtual 113	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   190: goto -23 -> 167
    //   193: astore_2
    //   194: aload_1
    //   195: invokevirtual 113	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   198: aload_2
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	10
    //   18	177	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   7	171	2	localHashSet	java.util.HashSet
    //   193	6	2	localObject	Object
    //   32	11	3	localIterator	java.util.Iterator
    //   134	17	3	localException	java.lang.Exception
    //   51	67	4	localEmoticon	com.tencent.mobileqq.data.Emoticon
    // Exception table:
    //   from	to	target	type
    //   19	33	134	java/lang/Exception
    //   33	53	134	java/lang/Exception
    //   58	131	134	java/lang/Exception
    //   182	186	134	java/lang/Exception
    //   19	33	193	finally
    //   33	53	193	finally
    //   58	131	193	finally
    //   135	163	193	finally
    //   182	186	193	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.10
 * JD-Core Version:    0.7.0.1
 */