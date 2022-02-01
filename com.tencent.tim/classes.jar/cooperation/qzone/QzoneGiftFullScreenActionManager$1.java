package cooperation.qzone;

import avra;

public class QzoneGiftFullScreenActionManager$1
  implements Runnable
{
  public QzoneGiftFullScreenActionManager$1(avra paramavra, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   4: getfield 29	avra:isRelease	Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +18 -> 27
    //   12: aload_0
    //   13: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   16: aload_0
    //   17: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   20: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   23: invokestatic 37	avra:b	(Lavra;Laixt;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   31: aload_0
    //   32: getfield 16	cooperation/qzone/QzoneGiftFullScreenActionManager$1:val$path	Ljava/lang/String;
    //   35: invokestatic 39	avra:a	(Lavra;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   42: getfield 42	avra:jdField_a_of_type_Aiyf	Laiyf;
    //   45: ldc 44
    //   47: invokevirtual 50	aiyf:lH	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +144 -> 196
    //   55: aload_0
    //   56: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   59: aload_0
    //   60: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   63: getfield 53	avra:jdField_a_of_type_Aixv	Laixv;
    //   66: aload_3
    //   67: invokevirtual 58	aixv:a	(Ljava/lang/String;)Laixt;
    //   70: putfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   73: aload_0
    //   74: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   77: aload_0
    //   78: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   81: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   84: invokestatic 60	avra:a	(Lavra;Laixt;)V
    //   87: aload_0
    //   88: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   91: aload_0
    //   92: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   95: getfield 53	avra:jdField_a_of_type_Aixv	Laixv;
    //   98: aload_3
    //   99: invokevirtual 64	aixv:ay	(Ljava/lang/String;)Ljava/util/List;
    //   102: putfield 68	avra:CL	Ljava/util/List;
    //   105: aload_0
    //   106: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   109: invokestatic 71	avra:a	(Lavra;)V
    //   112: aload_0
    //   113: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   116: getfield 68	avra:CL	Ljava/util/List;
    //   119: invokeinterface 77 1 0
    //   124: astore_3
    //   125: aload_3
    //   126: invokeinterface 83 1 0
    //   131: ifeq +65 -> 196
    //   134: aload_3
    //   135: invokeinterface 87 1 0
    //   140: checkcast 89	aixr
    //   143: astore 4
    //   145: aload_0
    //   146: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   149: aload 4
    //   151: putfield 92	avra:jdField_b_of_type_Aixr	Laixr;
    //   154: aload 4
    //   156: aload_0
    //   157: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   160: getfield 95	avra:jdField_b_of_type_Aiyl	Laiyl;
    //   163: putfield 97	aixr:jdField_a_of_type_Aiyl	Laiyl;
    //   166: aload 4
    //   168: aload_0
    //   169: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   172: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   175: putfield 98	aixr:jdField_a_of_type_Aixt	Laixt;
    //   178: aload 4
    //   180: invokevirtual 101	aixr:ace	()Z
    //   183: istore_1
    //   184: aload_0
    //   185: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   188: getfield 104	avra:isShutDown	Z
    //   191: istore_2
    //   192: iload_2
    //   193: ifeq +18 -> 211
    //   196: aload_0
    //   197: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   200: aload_0
    //   201: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   204: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   207: invokestatic 37	avra:b	(Lavra;Laixt;)V
    //   210: return
    //   211: iload_1
    //   212: ifeq -16 -> 196
    //   215: aload_0
    //   216: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   219: getfield 104	avra:isShutDown	Z
    //   222: istore_1
    //   223: iload_1
    //   224: ifeq -99 -> 125
    //   227: goto -31 -> 196
    //   230: astore_3
    //   231: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +31 -> 265
    //   237: ldc 111
    //   239: iconst_2
    //   240: new 113	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   247: ldc 116
    //   249: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_3
    //   253: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   256: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_0
    //   266: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   269: aload_0
    //   270: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   273: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   276: invokestatic 37	avra:b	(Lavra;Laixt;)V
    //   279: return
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   285: aload_0
    //   286: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lavra;
    //   289: getfield 33	avra:jdField_a_of_type_Aixt	Laixt;
    //   292: invokestatic 37	avra:b	(Lavra;Laixt;)V
    //   295: aload_3
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	1
    //   7	217	1	bool1	boolean
    //   191	2	2	bool2	boolean
    //   50	85	3	localObject1	Object
    //   230	23	3	localException	java.lang.Exception
    //   280	16	3	localObject2	Object
    //   143	36	4	localaixr	aixr
    // Exception table:
    //   from	to	target	type
    //   0	8	230	java/lang/Exception
    //   27	51	230	java/lang/Exception
    //   55	125	230	java/lang/Exception
    //   125	192	230	java/lang/Exception
    //   215	223	230	java/lang/Exception
    //   0	8	280	finally
    //   27	51	280	finally
    //   55	125	280	finally
    //   125	192	280	finally
    //   215	223	280	finally
    //   231	265	280	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager.1
 * JD-Core Version:    0.7.0.1
 */