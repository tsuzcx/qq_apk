import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnCellsListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import java.util.ArrayList;
import java.util.Iterator;

public class fkr
  extends PhoneStateListener
{
  private int jdField_a_of_type_Int = 2147483647;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private fkr(SosoInterface paramSosoInterface) {}
  
  /* Error */
  private ArrayList a()
  {
    // Byte code:
    //   0: new 27	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 28	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   12: ldc 36
    //   14: invokevirtual 42	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 44	android/telephony/TelephonyManager
    //   20: astore 6
    //   22: aload 6
    //   24: invokevirtual 48	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   27: astore 7
    //   29: aload 6
    //   31: invokevirtual 52	android/telephony/TelephonyManager:getPhoneType	()I
    //   34: istore_1
    //   35: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +28 -> 66
    //   41: ldc 60
    //   43: iconst_2
    //   44: new 62	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   51: ldc 65
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_1
    //   57: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload 7
    //   68: ifnull +302 -> 370
    //   71: iload_1
    //   72: iconst_1
    //   73: if_icmpne +203 -> 276
    //   76: aload 7
    //   78: instanceof 82
    //   81: ifeq +195 -> 276
    //   84: aload 7
    //   86: checkcast 82	android/telephony/gsm/GsmCellLocation
    //   89: astore 7
    //   91: aload 7
    //   93: invokevirtual 85	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   96: istore_3
    //   97: aload 7
    //   99: invokevirtual 88	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   102: istore 4
    //   104: iload_3
    //   105: ifgt +8 -> 113
    //   108: iload 4
    //   110: ifle +260 -> 370
    //   113: aload 6
    //   115: invokevirtual 91	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   118: astore 7
    //   120: aload 7
    //   122: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +245 -> 370
    //   128: aload 7
    //   130: invokevirtual 102	java/lang/String:length	()I
    //   133: iconst_3
    //   134: if_icmplt +236 -> 370
    //   137: aload 7
    //   139: ldc 104
    //   141: invokevirtual 108	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   144: iconst_0
    //   145: aaload
    //   146: astore 7
    //   148: aload 7
    //   150: iconst_0
    //   151: iconst_3
    //   152: invokevirtual 112	java/lang/String:substring	(II)Ljava/lang/String;
    //   155: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   158: istore_2
    //   159: aload 7
    //   161: iconst_3
    //   162: invokevirtual 121	java/lang/String:substring	(I)Ljava/lang/String;
    //   165: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   168: istore_1
    //   169: aload 5
    //   171: new 123	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell
    //   174: dup
    //   175: iload_2
    //   176: iload_1
    //   177: iload_3
    //   178: iload 4
    //   180: iconst_0
    //   181: iconst_1
    //   182: invokespecial 126	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell:<init>	(IIIIIZ)V
    //   185: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   188: pop
    //   189: aload 6
    //   191: invokevirtual 134	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   194: astore 6
    //   196: aload 6
    //   198: ifnull +172 -> 370
    //   201: aload 6
    //   203: invokeinterface 139 1 0
    //   208: ifle +162 -> 370
    //   211: aload 6
    //   213: invokeinterface 143 1 0
    //   218: astore 6
    //   220: aload 6
    //   222: invokeinterface 148 1 0
    //   227: ifeq +143 -> 370
    //   230: aload 6
    //   232: invokeinterface 152 1 0
    //   237: checkcast 154	android/telephony/NeighboringCellInfo
    //   240: astore 7
    //   242: aload 5
    //   244: new 123	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell
    //   247: dup
    //   248: iload_2
    //   249: iload_1
    //   250: aload 7
    //   252: invokevirtual 155	android/telephony/NeighboringCellInfo:getLac	()I
    //   255: aload 7
    //   257: invokevirtual 156	android/telephony/NeighboringCellInfo:getCid	()I
    //   260: aload 7
    //   262: invokevirtual 159	android/telephony/NeighboringCellInfo:getRssi	()I
    //   265: iconst_0
    //   266: invokespecial 126	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell:<init>	(IIIIIZ)V
    //   269: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   272: pop
    //   273: goto -53 -> 220
    //   276: iload_1
    //   277: iconst_2
    //   278: if_icmpne +92 -> 370
    //   281: aload 7
    //   283: instanceof 161
    //   286: ifeq +84 -> 370
    //   289: aload 7
    //   291: checkcast 161	android/telephony/cdma/CdmaCellLocation
    //   294: astore 7
    //   296: aload 7
    //   298: invokevirtual 164	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   301: istore_2
    //   302: aload 7
    //   304: invokevirtual 167	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   307: istore_3
    //   308: aload 7
    //   310: invokevirtual 170	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   313: istore 4
    //   315: aload 6
    //   317: invokevirtual 91	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   320: astore 6
    //   322: aload 6
    //   324: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifne +74 -> 401
    //   330: aload 6
    //   332: invokevirtual 102	java/lang/String:length	()I
    //   335: iconst_3
    //   336: if_icmplt +65 -> 401
    //   339: aload 6
    //   341: iconst_0
    //   342: iconst_3
    //   343: invokevirtual 112	java/lang/String:substring	(II)Ljava/lang/String;
    //   346: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   349: istore_1
    //   350: aload 5
    //   352: new 123	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell
    //   355: dup
    //   356: iload_1
    //   357: iload_2
    //   358: iload_3
    //   359: iload 4
    //   361: iconst_0
    //   362: iconst_1
    //   363: invokespecial 126	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell:<init>	(IIIIIZ)V
    //   366: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   369: pop
    //   370: aload 5
    //   372: areturn
    //   373: astore 6
    //   375: iconst_0
    //   376: istore_1
    //   377: goto -27 -> 350
    //   380: astore 7
    //   382: iconst_0
    //   383: istore_1
    //   384: iconst_0
    //   385: istore_2
    //   386: goto -197 -> 189
    //   389: astore 7
    //   391: iconst_0
    //   392: istore_1
    //   393: goto -204 -> 189
    //   396: astore 7
    //   398: goto -209 -> 189
    //   401: iconst_0
    //   402: istore_1
    //   403: goto -53 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	fkr
    //   34	369	1	i	int
    //   158	228	2	j	int
    //   96	263	3	k	int
    //   102	258	4	m	int
    //   7	364	5	localArrayList	ArrayList
    //   20	320	6	localObject1	Object
    //   373	1	6	localException1	java.lang.Exception
    //   27	282	7	localObject2	Object
    //   380	1	7	localException2	java.lang.Exception
    //   389	1	7	localException3	java.lang.Exception
    //   396	1	7	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   339	350	373	java/lang/Exception
    //   137	159	380	java/lang/Exception
    //   159	169	389	java/lang/Exception
    //   169	189	396	java/lang/Exception
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int != 2147483647))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        ??? = (SosoInterface.SosoCell)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((SosoInterface.SosoCell)???).a) {
          ((SosoInterface.SosoCell)???).e = this.jdField_a_of_type_Int;
        }
      }
      synchronized (SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface))
      {
        Iterator localIterator = SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface).iterator();
        if (localIterator.hasNext()) {
          ((SosoInterface.OnCellsListener)localIterator.next()).a(0, this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface);
    }
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    this.jdField_a_of_type_JavaUtilArrayList = a();
    a();
  }
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkr
 * JD-Core Version:    0.7.0.1
 */