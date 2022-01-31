package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class OpenIdInfoServlet
  extends MSFServlet
{
  private static String a = "OpenIdInfoServlet";
  private static final String b = "OidbSvc.0x70e_1";
  private static final String c = "k_uin";
  private static final String d = "k_appid";
  
  public static void a(AppInterface paramAppInterface, int paramInt, Bundle paramBundle)
  {
    NewIntent localNewIntent = new NewIntent(paramAppInterface.a(), OpenIdInfoServlet.class);
    localNewIntent.putExtra("k_uin", paramAppInterface.a());
    localNewIntent.putExtra("k_appid", paramInt);
    if (paramBundle != null) {
      localNewIntent.putExtra("callbackdata", paramBundle);
    }
    paramAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getOpenIDInfo:--startServlet--");
    }
  }
  
  byte[] a(long paramLong, int paramInt)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1806);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putInt(paramInt);
    localByteBuffer.putInt((int)paramLong);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 127	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore_3
    //   5: ldc 129
    //   7: astore 5
    //   9: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +29 -> 41
    //   15: getstatic 21	com/tencent/mobileqq/servlet/OpenIdInfoServlet:a	Ljava/lang/String;
    //   18: iconst_2
    //   19: new 131	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   26: ldc 134
    //   28: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_3
    //   32: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: new 146	android/os/Bundle
    //   44: dup
    //   45: invokespecial 147	android/os/Bundle:<init>	()V
    //   48: astore 6
    //   50: aload_2
    //   51: invokevirtual 150	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   54: invokestatic 153	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 157	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   62: pop
    //   63: aload_2
    //   64: invokevirtual 161	java/nio/ByteBuffer:getInt	()I
    //   67: iconst_4
    //   68: isub
    //   69: newarray byte
    //   71: astore 4
    //   73: aload_2
    //   74: aload 4
    //   76: invokevirtual 164	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   79: pop
    //   80: new 69	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   83: dup
    //   84: invokespecial 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   87: aload 4
    //   89: invokevirtual 168	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   92: checkcast 69	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: getfield 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   98: invokevirtual 171	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   101: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   104: invokestatic 153	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   107: astore 4
    //   109: aload 4
    //   111: invokevirtual 161	java/nio/ByteBuffer:getInt	()I
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 161	java/nio/ByteBuffer:getInt	()I
    //   120: pop
    //   121: aload 4
    //   123: invokevirtual 176	java/nio/ByteBuffer:getShort	()S
    //   126: newarray byte
    //   128: astore_2
    //   129: aload 4
    //   131: aload_2
    //   132: invokevirtual 164	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   135: pop
    //   136: new 178	java/lang/String
    //   139: dup
    //   140: aload_2
    //   141: invokespecial 181	java/lang/String:<init>	([B)V
    //   144: astore_2
    //   145: aload 4
    //   147: invokevirtual 176	java/nio/ByteBuffer:getShort	()S
    //   150: newarray byte
    //   152: astore 5
    //   154: aload 4
    //   156: aload 5
    //   158: invokevirtual 164	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   161: pop
    //   162: new 178	java/lang/String
    //   165: dup
    //   166: aload 5
    //   168: invokespecial 181	java/lang/String:<init>	([B)V
    //   171: astore 4
    //   173: aload 6
    //   175: ldc 183
    //   177: aload_2
    //   178: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 6
    //   183: ldc 189
    //   185: aload 4
    //   187: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_1
    //   191: ldc 48
    //   193: invokevirtual 195	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   196: ifeq +16 -> 212
    //   199: aload 6
    //   201: ldc 48
    //   203: aload_1
    //   204: ldc 48
    //   206: invokevirtual 199	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   209: invokevirtual 203	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   212: aload_0
    //   213: aload_1
    //   214: iconst_1
    //   215: iload_3
    //   216: aload 6
    //   218: ldc 205
    //   220: invokevirtual 209	com/tencent/mobileqq/servlet/OpenIdInfoServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   223: return
    //   224: astore 4
    //   226: ldc 129
    //   228: astore_2
    //   229: iconst_0
    //   230: istore_3
    //   231: aload 4
    //   233: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   236: aload 6
    //   238: ldc 183
    //   240: aload_2
    //   241: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 6
    //   246: ldc 189
    //   248: ldc 129
    //   250: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_1
    //   254: ldc 48
    //   256: invokevirtual 195	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   259: ifeq +16 -> 275
    //   262: aload 6
    //   264: ldc 48
    //   266: aload_1
    //   267: ldc 48
    //   269: invokevirtual 199	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   272: invokevirtual 203	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   275: aload_0
    //   276: aload_1
    //   277: iconst_1
    //   278: iconst_0
    //   279: aload 6
    //   281: ldc 205
    //   283: invokevirtual 209	com/tencent/mobileqq/servlet/OpenIdInfoServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   286: return
    //   287: astore 4
    //   289: aload 5
    //   291: astore_2
    //   292: aload 6
    //   294: ldc 183
    //   296: aload_2
    //   297: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 6
    //   302: ldc 189
    //   304: ldc 129
    //   306: invokevirtual 187	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_1
    //   310: ldc 48
    //   312: invokevirtual 195	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   315: ifeq +16 -> 331
    //   318: aload 6
    //   320: ldc 48
    //   322: aload_1
    //   323: ldc 48
    //   325: invokevirtual 199	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   328: invokevirtual 203	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   331: aload_0
    //   332: aload_1
    //   333: iconst_1
    //   334: iload_3
    //   335: aload 6
    //   337: ldc 205
    //   339: invokevirtual 209	com/tencent/mobileqq/servlet/OpenIdInfoServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   342: aload 4
    //   344: athrow
    //   345: astore 4
    //   347: goto -55 -> 292
    //   350: astore 4
    //   352: goto -60 -> 292
    //   355: astore 4
    //   357: goto -128 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	OpenIdInfoServlet
    //   0	360	1	paramIntent	Intent
    //   0	360	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   4	331	3	bool	boolean
    //   71	115	4	localObject1	Object
    //   224	8	4	localException1	java.lang.Exception
    //   287	56	4	localObject2	Object
    //   345	1	4	localObject3	Object
    //   350	1	4	localObject4	Object
    //   355	1	4	localException2	java.lang.Exception
    //   7	283	5	localObject5	Object
    //   48	288	6	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   50	145	224	java/lang/Exception
    //   50	145	287	finally
    //   145	173	345	finally
    //   231	236	350	finally
    //   145	173	355	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("k_uin");
    int i = paramIntent.getIntExtra("k_appid", 0);
    paramPacket.putSendData(a(Long.parseLong(str), i));
    paramPacket.setSSOCommand("OidbSvc.0x70e_1");
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "--onSend--");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.OpenIdInfoServlet
 * JD-Core Version:    0.7.0.1
 */