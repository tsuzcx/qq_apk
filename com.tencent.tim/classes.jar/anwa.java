import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class anwa
{
  private static ArrayList<anwa.a> AV = new ArrayList();
  private static ArrayList<Integer> AW = new ArrayList();
  private static boolean cKk = true;
  private static boolean cKl;
  private static boolean cKm;
  private static boolean cKn;
  private static AtomicBoolean dR = new AtomicBoolean();
  
  public static void QD(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = AV.iterator();
      while (localIterator.hasNext()) {
        ((anwa.a)localIterator.next()).onChange(paramBoolean);
      }
    }
    finally {}
  }
  
  public static void QE(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeManager", 2, String.format("setstudent mask = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aqmj.z("study_mode_key_student_mask", Boolean.valueOf(paramBoolean));
  }
  
  public static void QF(boolean paramBoolean)
  {
    try
    {
      cKk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean TK()
  {
    return cKk;
  }
  
  public static void a(anwa.a parama)
  {
    try
    {
      if (!AV.contains(parama)) {
        AV.add(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static boolean aze()
  {
    if (!dR.get()) {
      init();
    }
    if (cKk) {
      return cKl;
    }
    return false;
  }
  
  public static boolean azf()
  {
    cKn = anwg.a.azg();
    return cKn;
  }
  
  public static void b(anwa.a parama)
  {
    try
    {
      if (AV.contains(parama)) {
        AV.remove(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public static void b(boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +25 -> 31
    //   9: ldc 65
    //   11: iconst_2
    //   12: ldc 130
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_0
    //   21: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 79	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: getstatic 30	anwa:dR	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: invokevirtual 105	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifne +7 -> 46
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: getstatic 110	anwa:cKl	Z
    //   49: iload_0
    //   50: if_icmpeq -8 -> 42
    //   53: ldc 132
    //   55: iload_0
    //   56: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: invokestatic 91	aqmj:z	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: iload_0
    //   63: putstatic 110	anwa:cKl	Z
    //   66: getstatic 23	anwa:cKk	Z
    //   69: ifeq +7 -> 76
    //   72: iload_0
    //   73: invokestatic 134	anwa:QD	(Z)V
    //   76: aload_1
    //   77: ifnull -35 -> 42
    //   80: aload_1
    //   81: bipush 87
    //   83: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   86: checkcast 142	acks
    //   89: iconst_1
    //   90: iconst_0
    //   91: invokevirtual 146	acks:bJ	(ZZ)V
    //   94: goto -52 -> 42
    //   97: astore_1
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramBoolean	boolean
    //   0	103	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   37	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	97	finally
    //   31	38	97	finally
    //   46	76	97	finally
    //   80	94	97	finally
  }
  
  public static void init()
  {
    try
    {
      anvz.a locala = anvz.a();
      if (locala.cKj) {
        cKk = anvz.a.a(locala);
      }
      ArrayList localArrayList = anwb.a().AX;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        AW.clear();
        AW.addAll(localArrayList);
      }
      cKl = ((Boolean)aqmj.get("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
      cKm = ((Boolean)aqmj.get("study_mode_key_student_mask", Boolean.valueOf(false))).booleanValue();
      cKn = anwg.a.azg();
      dR.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", new Object[] { Boolean.valueOf(cKk), Boolean.valueOf(cKl), Boolean.valueOf(cKm), "sBlackIds.toString()", Boolean.valueOf(locala.cKj), Boolean.valueOf(cKn) }));
      }
      return;
    }
    finally {}
  }
  
  public static boolean lK(int paramInt)
  {
    if (!dR.get()) {
      return false;
    }
    if (aze()) {}
    for (;;)
    {
      try
      {
        if (AW.size() > 0)
        {
          bool = AW.contains(Integer.valueOf(paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, String.format("init ,studyModeSwitch = %b,notifyID = %d,blackResult = %b,sBlackIds = %s", new Object[] { Boolean.valueOf(cKk), Integer.valueOf(paramInt), Boolean.valueOf(bool), AW.toString() }));
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StudyModeManager", 2, localThrowable, new Object[0]);
        }
      }
      boolean bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwa
 * JD-Core Version:    0.7.0.1
 */