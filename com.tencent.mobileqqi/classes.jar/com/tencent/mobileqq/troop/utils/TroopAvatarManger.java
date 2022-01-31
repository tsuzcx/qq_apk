package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class TroopAvatarManger
{
  public static int a = 0;
  protected static Map a;
  protected static final String f = "htdata3.qq.com";
  protected static final String g = "htdata4.qq.com";
  protected static final String h = "http://14.17.18.20:80";
  protected static final String i = "http://112.90.139.96:80";
  protected TroopHandler a;
  protected final String a;
  protected final String b = "5520";
  protected final String c = "3";
  protected final String d = "5";
  protected final String e = "ip/cgi-bin/httpconn?";
  public String j;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public TroopAvatarManger(String paramString, Class paramClass, TroopHandler paramTroopHandler)
  {
    this.jdField_a_of_type_JavaLangString = "0x6ff0072";
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = paramTroopHandler;
    this.j = paramString;
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      paramClass = UploadingFactory.a(paramClass);
      jdField_a_of_type_JavaUtilMap.put(paramString, paramClass);
    }
  }
  
  /* Error */
  protected String a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/mobileqq/transfile/SosoSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/SosoSrvAddrProvider;
    //   3: astore 8
    //   5: aload 8
    //   7: invokevirtual 94	com/tencent/mobileqq/transfile/SosoSrvAddrProvider:c	()V
    //   10: aconst_null
    //   11: astore_1
    //   12: aload 8
    //   14: ifnull +12 -> 26
    //   17: aload 8
    //   19: getstatic 100	com/tencent/mobileqq/transfile/SosoSrvAddrProvider$SosoSrvAddrType:URL_ENCODE_SRV	Lcom/tencent/mobileqq/transfile/SosoSrvAddrProvider$SosoSrvAddrType;
    //   22: invokevirtual 103	com/tencent/mobileqq/transfile/SosoSrvAddrProvider:a	(Lcom/tencent/mobileqq/transfile/SosoSrvAddrProvider$SosoSrvAddrType;)Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +120 -> 147
    //   30: ldc 54
    //   32: ldc 105
    //   34: aload_1
    //   35: invokevirtual 111	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   38: astore_1
    //   39: new 113	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   46: aload_1
    //   47: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 120
    //   52: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 38
    //   57: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 122
    //   62: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 42
    //   67: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 124
    //   72: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 6
    //   77: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 126
    //   82: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_3
    //   86: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 128
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 5
    //   96: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 130
    //   101: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 132
    //   106: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 134
    //   116: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 46
    //   121: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 136
    //   126: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 50
    //   131: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 138
    //   136: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_2
    //   140: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: areturn
    //   147: ldc 12
    //   149: invokestatic 148	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   152: invokevirtual 151	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   155: astore_1
    //   156: ldc 54
    //   158: ldc 105
    //   160: new 113	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   167: ldc 153
    //   169: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 155
    //   178: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 111	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   187: astore_1
    //   188: iconst_1
    //   189: istore 7
    //   191: iload 7
    //   193: ifne +128 -> 321
    //   196: ldc 15
    //   198: invokestatic 148	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   201: invokevirtual 151	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload_1
    //   207: ldc 105
    //   209: new 113	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   216: ldc 153
    //   218: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 155
    //   228: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokevirtual 111	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   237: astore 8
    //   239: aload 8
    //   241: astore_1
    //   242: goto -203 -> 39
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 158	java/net/UnknownHostException:printStackTrace	()V
    //   250: iconst_0
    //   251: istore 7
    //   253: ldc 54
    //   255: astore_1
    //   256: goto -65 -> 191
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   264: iconst_0
    //   265: istore 7
    //   267: ldc 54
    //   269: astore_1
    //   270: goto -79 -> 191
    //   273: astore 9
    //   275: new 161	java/util/Random
    //   278: dup
    //   279: ldc2_w 162
    //   282: invokespecial 166	java/util/Random:<init>	(J)V
    //   285: invokevirtual 170	java/util/Random:nextInt	()I
    //   288: iconst_2
    //   289: idiv
    //   290: ifne +24 -> 314
    //   293: ldc 18
    //   295: astore 8
    //   297: aload_1
    //   298: ldc 105
    //   300: aload 8
    //   302: invokevirtual 111	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   305: astore_1
    //   306: aload 9
    //   308: invokevirtual 158	java/net/UnknownHostException:printStackTrace	()V
    //   311: goto -272 -> 39
    //   314: ldc 21
    //   316: astore 8
    //   318: goto -21 -> 297
    //   321: goto -282 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	TroopAvatarManger
    //   0	324	1	paramAppInterface	AppInterface
    //   0	324	2	paramString1	String
    //   0	324	3	paramString2	String
    //   0	324	4	paramString3	String
    //   0	324	5	paramString4	String
    //   0	324	6	paramString5	String
    //   189	77	7	k	int
    //   3	314	8	localObject	Object
    //   273	34	9	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   147	188	245	java/net/UnknownHostException
    //   147	188	259	java/lang/Exception
    //   196	239	273	java/net/UnknownHostException
  }
  
  public ArrayList a()
  {
    return ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
  }
  
  public void a(Class paramClass, AppInterface paramAppInterface, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, HashMap paramHashMap)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a(paramClass, paramArrayList, paramHashMap, a(paramAppInterface, "0", "0", paramString1, paramString3, paramString2));
  }
  
  public void a(String paramString)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a(paramString);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).addObserver(paramObserver);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d(paramString);
    }
  }
  
  public void b(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).b(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAvatarManger
 * JD-Core Version:    0.7.0.1
 */