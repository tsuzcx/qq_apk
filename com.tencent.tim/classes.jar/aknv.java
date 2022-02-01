import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

public class aknv
{
  public static aknv a;
  public static DeviceProfileManager.a a;
  private static final String aUb = DeviceProfileManager.DpcNames.ocrCfg.name();
  public String aUc;
  public int dnP = 1;
  public int dnQ = 800;
  public int dnR = 1080;
  public int dnS = 1920;
  public int dnT = 100;
  public int dnU = 6;
  public int dnV = 140;
  public int dnW = 100;
  public int picQuality = 70;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = new aknw();
  }
  
  public aknv()
  {
    DeviceProfileManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
  }
  
  public static aknv a()
  {
    if (jdField_a_of_type_Aknv != null) {
      return jdField_a_of_type_Aknv;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
    }
    load();
    return jdField_a_of_type_Aknv;
  }
  
  /* Error */
  public static void load()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 92	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 34	aknv:aUb	Ljava/lang/String;
    //   9: invokevirtual 96	com/tencent/mobileqq/app/DeviceProfileManager:jf	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: new 2	aknv
    //   16: dup
    //   17: invokespecial 97	aknv:<init>	()V
    //   20: putstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   23: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   26: aload_1
    //   27: putfield 99	aknv:aUc	Ljava/lang/String;
    //   30: aload_1
    //   31: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +157 -> 191
    //   37: aload_1
    //   38: ldc 107
    //   40: invokevirtual 113	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: arraylength
    //   46: istore_0
    //   47: iload_0
    //   48: bipush 9
    //   50: if_icmplt +141 -> 191
    //   53: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   56: aload_1
    //   57: iconst_0
    //   58: aaload
    //   59: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   62: invokevirtual 123	java/lang/Integer:intValue	()I
    //   65: putfield 45	aknv:dnP	I
    //   68: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   71: aload_1
    //   72: iconst_1
    //   73: aaload
    //   74: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   77: invokevirtual 123	java/lang/Integer:intValue	()I
    //   80: putfield 47	aknv:picQuality	I
    //   83: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   86: aload_1
    //   87: iconst_2
    //   88: aaload
    //   89: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   92: invokevirtual 123	java/lang/Integer:intValue	()I
    //   95: putfield 49	aknv:dnQ	I
    //   98: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   101: aload_1
    //   102: iconst_3
    //   103: aaload
    //   104: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 123	java/lang/Integer:intValue	()I
    //   110: putfield 51	aknv:dnR	I
    //   113: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   116: aload_1
    //   117: iconst_4
    //   118: aaload
    //   119: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   122: invokevirtual 123	java/lang/Integer:intValue	()I
    //   125: putfield 53	aknv:dnS	I
    //   128: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   131: aload_1
    //   132: iconst_5
    //   133: aaload
    //   134: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   137: invokevirtual 123	java/lang/Integer:intValue	()I
    //   140: putfield 55	aknv:dnT	I
    //   143: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   146: aload_1
    //   147: bipush 6
    //   149: aaload
    //   150: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   153: invokevirtual 123	java/lang/Integer:intValue	()I
    //   156: putfield 57	aknv:dnU	I
    //   159: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   162: aload_1
    //   163: bipush 7
    //   165: aaload
    //   166: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   169: invokevirtual 123	java/lang/Integer:intValue	()I
    //   172: putfield 59	aknv:dnV	I
    //   175: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   178: aload_1
    //   179: bipush 8
    //   181: aaload
    //   182: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   185: invokevirtual 123	java/lang/Integer:intValue	()I
    //   188: putfield 61	aknv:dnW	I
    //   191: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +30 -> 224
    //   197: ldc 77
    //   199: iconst_2
    //   200: new 125	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   207: ldc 128
    //   209: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   215: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: ldc 2
    //   226: monitorexit
    //   227: return
    //   228: astore_1
    //   229: ldc 77
    //   231: iconst_1
    //   232: new 125	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   239: ldc 140
    //   241: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   248: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   260: bipush 70
    //   262: putfield 47	aknv:picQuality	I
    //   265: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   268: sipush 800
    //   271: putfield 49	aknv:dnQ	I
    //   274: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   277: sipush 1080
    //   280: putfield 51	aknv:dnR	I
    //   283: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   286: sipush 1920
    //   289: putfield 53	aknv:dnS	I
    //   292: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   295: bipush 100
    //   297: putfield 55	aknv:dnT	I
    //   300: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   303: bipush 6
    //   305: putfield 57	aknv:dnU	I
    //   308: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   311: sipush 140
    //   314: putfield 59	aknv:dnV	I
    //   317: getstatic 69	aknv:jdField_a_of_type_Aknv	Laknv;
    //   320: bipush 100
    //   322: putfield 61	aknv:dnW	I
    //   325: goto -134 -> 191
    //   328: astore_1
    //   329: ldc 2
    //   331: monitorexit
    //   332: aload_1
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	5	0	i	int
    //   12	167	1	localObject1	Object
    //   228	17	1	localException	java.lang.Exception
    //   328	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   53	191	228	java/lang/Exception
    //   3	47	328	finally
    //   53	191	328	finally
    //   191	224	328	finally
    //   229	325	328	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrSwitch:").append(this.dnP).append(",picQuality:").append(this.picQuality).append(",picShortestSide:").append(this.dnQ).append(",maxPreviewWidth:").append(this.dnR).append(",maxPreviewHeight:").append(this.dnS).append(",").append(this.dnT).append(",").append(this.dnU).append(",").append(this.dnV).append(",").append(this.dnW);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknv
 * JD-Core Version:    0.7.0.1
 */