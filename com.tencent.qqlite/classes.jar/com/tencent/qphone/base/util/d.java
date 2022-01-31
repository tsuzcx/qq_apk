package com.tencent.qphone.base.util;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

final class d
  extends PhoneStateListener
{
  private short a = 0;
  
  /* Error */
  public void onCellLocationChanged(android.telephony.CellLocation paramCellLocation)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: instanceof 21
    //   9: ifeq +333 -> 342
    //   12: new 23	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 24	java/util/ArrayList:<init>	()V
    //   19: invokestatic 29	com/tencent/qphone/base/util/c:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   22: pop
    //   23: new 31	LBS/Cell
    //   26: dup
    //   27: invokespecial 32	LBS/Cell:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: aload_1
    //   35: checkcast 21	android/telephony/gsm/GsmCellLocation
    //   38: invokevirtual 36	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   41: putfield 40	LBS/Cell:iLac	I
    //   44: aload 4
    //   46: aload_1
    //   47: checkcast 21	android/telephony/gsm/GsmCellLocation
    //   50: invokevirtual 43	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   53: putfield 46	LBS/Cell:iCellId	I
    //   56: invokestatic 49	com/tencent/qphone/base/util/c:a	()Landroid/telephony/TelephonyManager;
    //   59: invokevirtual 55	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +47 -> 111
    //   67: aload_3
    //   68: invokevirtual 60	java/lang/String:length	()I
    //   71: istore_2
    //   72: iload_2
    //   73: iconst_5
    //   74: if_icmplt +37 -> 111
    //   77: aload 4
    //   79: aload_3
    //   80: iconst_0
    //   81: iconst_3
    //   82: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: invokestatic 70	java/lang/Short:valueOf	(Ljava/lang/String;)Ljava/lang/Short;
    //   88: invokevirtual 74	java/lang/Short:shortValue	()S
    //   91: putfield 77	LBS/Cell:shMcc	S
    //   94: aload 4
    //   96: aload_3
    //   97: iconst_3
    //   98: iconst_5
    //   99: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   102: invokestatic 70	java/lang/Short:valueOf	(Ljava/lang/String;)Ljava/lang/Short;
    //   105: invokevirtual 74	java/lang/Short:shortValue	()S
    //   108: putfield 80	LBS/Cell:shMnc	S
    //   111: aload 4
    //   113: aload_0
    //   114: getfield 12	com/tencent/qphone/base/util/d:a	S
    //   117: putfield 83	LBS/Cell:shRssi	S
    //   120: aload 4
    //   122: getfield 40	LBS/Cell:iLac	I
    //   125: iconst_m1
    //   126: if_icmpeq +21 -> 147
    //   129: aload 4
    //   131: getfield 46	LBS/Cell:iCellId	I
    //   134: iconst_m1
    //   135: if_icmpeq +12 -> 147
    //   138: invokestatic 87	com/tencent/qphone/base/util/c:b	()Ljava/util/ArrayList;
    //   141: iconst_0
    //   142: aload 4
    //   144: invokevirtual 91	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   147: invokestatic 49	com/tencent/qphone/base/util/c:a	()Landroid/telephony/TelephonyManager;
    //   150: invokevirtual 95	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull -153 -> 4
    //   160: aload 4
    //   162: invokeinterface 100 1 0
    //   167: ifeq -163 -> 4
    //   170: aload 4
    //   172: invokeinterface 104 1 0
    //   177: astore 4
    //   179: aload 4
    //   181: invokeinterface 110 1 0
    //   186: ifeq +156 -> 342
    //   189: aload 4
    //   191: invokeinterface 114 1 0
    //   196: checkcast 116	android/telephony/NeighboringCellInfo
    //   199: astore 5
    //   201: aload 5
    //   203: ifnull -24 -> 179
    //   206: new 31	LBS/Cell
    //   209: dup
    //   210: invokespecial 32	LBS/Cell:<init>	()V
    //   213: astore 6
    //   215: aload_3
    //   216: ifnull +47 -> 263
    //   219: aload_3
    //   220: invokevirtual 60	java/lang/String:length	()I
    //   223: istore_2
    //   224: iload_2
    //   225: iconst_5
    //   226: if_icmplt +37 -> 263
    //   229: aload 6
    //   231: aload_3
    //   232: iconst_0
    //   233: iconst_3
    //   234: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   237: invokestatic 70	java/lang/Short:valueOf	(Ljava/lang/String;)Ljava/lang/Short;
    //   240: invokevirtual 74	java/lang/Short:shortValue	()S
    //   243: putfield 77	LBS/Cell:shMcc	S
    //   246: aload 6
    //   248: aload_3
    //   249: iconst_3
    //   250: iconst_5
    //   251: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   254: invokestatic 70	java/lang/Short:valueOf	(Ljava/lang/String;)Ljava/lang/Short;
    //   257: invokevirtual 74	java/lang/Short:shortValue	()S
    //   260: putfield 80	LBS/Cell:shMnc	S
    //   263: aload 6
    //   265: aload 5
    //   267: invokevirtual 117	android/telephony/NeighboringCellInfo:getLac	()I
    //   270: putfield 40	LBS/Cell:iLac	I
    //   273: aload 6
    //   275: aload 5
    //   277: invokevirtual 118	android/telephony/NeighboringCellInfo:getCid	()I
    //   280: putfield 46	LBS/Cell:iCellId	I
    //   283: aload 6
    //   285: aload 5
    //   287: invokevirtual 121	android/telephony/NeighboringCellInfo:getRssi	()I
    //   290: iconst_2
    //   291: imul
    //   292: bipush 113
    //   294: isub
    //   295: i2s
    //   296: putfield 83	LBS/Cell:shRssi	S
    //   299: aload 6
    //   301: invokestatic 124	com/tencent/qphone/base/util/c:a	(LLBS/Cell;)V
    //   304: goto -125 -> 179
    //   307: astore_3
    //   308: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +31 -> 342
    //   314: ldc 131
    //   316: iconst_2
    //   317: new 133	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   324: ldc 136
    //   326: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_3
    //   330: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 150	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload_0
    //   343: aload_1
    //   344: invokespecial 152	android/telephony/PhoneStateListener:onCellLocationChanged	(Landroid/telephony/CellLocation;)V
    //   347: return
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 155	java/lang/NumberFormatException:printStackTrace	()V
    //   355: goto -244 -> 111
    //   358: astore 7
    //   360: aload 7
    //   362: invokevirtual 155	java/lang/NumberFormatException:printStackTrace	()V
    //   365: goto -102 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	d
    //   0	368	1	paramCellLocation	android.telephony.CellLocation
    //   71	156	2	i	int
    //   62	187	3	str	java.lang.String
    //   307	23	3	localException	java.lang.Exception
    //   30	160	4	localObject	java.lang.Object
    //   199	87	5	localNeighboringCellInfo	android.telephony.NeighboringCellInfo
    //   348	3	5	localNumberFormatException1	java.lang.NumberFormatException
    //   213	87	6	localCell	LBS.Cell
    //   358	3	7	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   5	63	307	java/lang/Exception
    //   67	72	307	java/lang/Exception
    //   77	111	307	java/lang/Exception
    //   111	147	307	java/lang/Exception
    //   147	155	307	java/lang/Exception
    //   160	179	307	java/lang/Exception
    //   179	201	307	java/lang/Exception
    //   206	215	307	java/lang/Exception
    //   219	224	307	java/lang/Exception
    //   229	263	307	java/lang/Exception
    //   263	304	307	java/lang/Exception
    //   350	355	307	java/lang/Exception
    //   360	365	307	java/lang/Exception
    //   77	111	348	java/lang/NumberFormatException
    //   229	263	358	java/lang/NumberFormatException
  }
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength.isGsm()) {
      if (paramSignalStrength.getGsmSignalStrength() != 99) {
        this.a = ((short)(paramSignalStrength.getGsmSignalStrength() * 2 - 113));
      }
    }
    for (;;)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      return;
      this.a = ((short)paramSignalStrength.getGsmSignalStrength());
      continue;
      this.a = ((short)paramSignalStrength.getCdmaDbm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.d
 * JD-Core Version:    0.7.0.1
 */