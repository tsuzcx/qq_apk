import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;

public class aiah
  implements aiaj
{
  private static final String DIR = BaseApplicationImpl.getApplication().getFilesDir() + "/identification/packFile";
  private aiay.a a;
  private long abf;
  private int appId;
  private String bMA;
  private String bMz;
  private int dcQ;
  private String key;
  private int mServiceType;
  private String mSession;
  private String method;
  private String name;
  private String openId;
  private String ticket;
  private String uin;
  
  public aiah(Intent paramIntent, String paramString, aiay.a parama)
  {
    this.dcQ = paramIntent.getIntExtra("platformAppId", 0);
    this.appId = paramIntent.getIntExtra("srcAppId", 0);
    this.openId = paramIntent.getStringExtra("srcOpenId");
    this.bMz = paramIntent.getStringExtra("idNum");
    this.name = paramIntent.getStringExtra("name");
    this.key = paramIntent.getStringExtra("key");
    this.method = paramIntent.getStringExtra("method");
    this.uin = paramIntent.getStringExtra("uin");
    this.ticket = paramIntent.getStringExtra("ticket");
    this.mServiceType = paramIntent.getIntExtra("serviceType", -1);
    paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
    if (paramIntent != null) {
      this.mSession = paramIntent.session;
    }
    if (this.openId == null)
    {
      paramIntent = "";
      this.openId = paramIntent;
      if (this.bMz != null) {
        break label223;
      }
      paramIntent = "";
      label154:
      this.bMz = paramIntent;
      if (this.name != null) {
        break label231;
      }
      paramIntent = "";
      label169:
      this.name = paramIntent;
      if (this.key != null) {
        break label239;
      }
      paramIntent = "";
      label184:
      this.key = paramIntent;
      if (this.mSession != null) {
        break label247;
      }
    }
    label223:
    label231:
    label239:
    label247:
    for (paramIntent = "";; paramIntent = this.mSession)
    {
      this.mSession = paramIntent;
      this.a = parama;
      this.bMA = paramString;
      return;
      paramIntent = this.openId;
      break;
      paramIntent = this.bMz;
      break label154;
      paramIntent = this.name;
      break label169;
      paramIntent = this.key;
      break label184;
    }
  }
  
  private faceproto.Request a(String paramString1, String paramString2)
  {
    faceproto.Request localRequest = new faceproto.Request();
    localRequest.AppID.set(this.dcQ);
    localRequest.TmpKey.set(this.key);
    Object localObject = new faceproto.App();
    ((faceproto.App)localObject).AppID.set(this.appId);
    ((faceproto.App)localObject).OpenID.set(this.openId);
    localRequest.SrcApp.set((MessageMicro)localObject);
    localObject = new faceproto.UserInfo();
    if ((this.method == null) || ("identify".equals(this.method)))
    {
      ((faceproto.UserInfo)localObject).IDCardNumber.set(this.bMz);
      ((faceproto.UserInfo)localObject).Name.set(this.name);
    }
    localRequest.UserInfo.set((MessageMicro)localObject);
    localObject = new faceproto.FaceInfo();
    faceproto.Media localMedia = new faceproto.Media();
    localMedia.Size.set(paramString1.getBytes().length);
    localMedia.Type.set(3);
    ((faceproto.FaceInfo)localObject).RecMode.set(4);
    localRequest.FaceInfo.set((MessageMicro)localObject);
    localRequest.Session.set(paramString2);
    return localRequest;
  }
  
  /* Error */
  private String a(faceproto.Request paramRequest, String paramString)
  {
    // Byte code:
    //   0: new 225	java/io/File
    //   3: dup
    //   4: getstatic 57	aiah:DIR	Ljava/lang/String;
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 231	java/lang/System:currentTimeMillis	()J
    //   17: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 120
    //   22: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 5
    //   33: new 225	java/io/File
    //   36: dup
    //   37: getstatic 57	aiah:DIR	Ljava/lang/String;
    //   40: invokespecial 239	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 243	java/io/File:exists	()Z
    //   48: ifne +129 -> 177
    //   51: aload_3
    //   52: invokevirtual 246	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 248	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 250	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 253	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 256	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: bipush 40
    //   81: invokevirtual 259	java/io/BufferedOutputStream:write	(I)V
    //   84: aload 4
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 262	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   91: astore_1
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: aload_1
    //   98: arraylength
    //   99: invokestatic 268	aqft:i	(I)[B
    //   102: invokevirtual 271	java/io/BufferedOutputStream:write	([B)V
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: aload_2
    //   111: ldc_w 273
    //   114: invokevirtual 276	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   117: arraylength
    //   118: invokestatic 268	aqft:i	(I)[B
    //   121: invokevirtual 271	java/io/BufferedOutputStream:write	([B)V
    //   124: aload 4
    //   126: astore_3
    //   127: aload 4
    //   129: aload_1
    //   130: invokevirtual 271	java/io/BufferedOutputStream:write	([B)V
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: aload_2
    //   139: ldc_w 273
    //   142: invokevirtual 276	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   145: invokevirtual 271	java/io/BufferedOutputStream:write	([B)V
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: bipush 41
    //   155: invokevirtual 259	java/io/BufferedOutputStream:write	(I)V
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: invokevirtual 279	java/io/BufferedOutputStream:flush	()V
    //   166: aload 4
    //   168: invokestatic 283	aqft:d	(Ljava/io/Closeable;)V
    //   171: aload 5
    //   173: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: areturn
    //   177: aload_3
    //   178: invokevirtual 289	java/io/File:delete	()Z
    //   181: pop
    //   182: aload_3
    //   183: invokevirtual 246	java/io/File:mkdirs	()Z
    //   186: pop
    //   187: goto -131 -> 56
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: ldc_w 291
    //   200: iconst_1
    //   201: aload_1
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   209: aload 4
    //   211: invokestatic 283	aqft:d	(Ljava/io/Closeable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aload 4
    //   222: astore_3
    //   223: ldc_w 291
    //   226: iconst_1
    //   227: aload_1
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   235: aload 4
    //   237: invokestatic 283	aqft:d	(Ljava/io/Closeable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: invokestatic 283	aqft:d	(Ljava/io/Closeable;)V
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: goto -7 -> 245
    //   255: astore_1
    //   256: goto -36 -> 220
    //   259: astore_1
    //   260: goto -66 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	aiah
    //   0	263	1	paramRequest	faceproto.Request
    //   0	263	2	paramString	String
    //   43	203	3	localObject	Object
    //   72	164	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   31	141	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   56	74	190	java/io/FileNotFoundException
    //   56	74	216	java/io/IOException
    //   56	74	242	finally
    //   77	84	251	finally
    //   87	92	251	finally
    //   95	105	251	finally
    //   108	124	251	finally
    //   127	133	251	finally
    //   136	148	251	finally
    //   151	158	251	finally
    //   161	166	251	finally
    //   197	209	251	finally
    //   223	235	251	finally
    //   77	84	255	java/io/IOException
    //   87	92	255	java/io/IOException
    //   95	105	255	java/io/IOException
    //   108	124	255	java/io/IOException
    //   127	133	255	java/io/IOException
    //   136	148	255	java/io/IOException
    //   151	158	255	java/io/IOException
    //   161	166	255	java/io/IOException
    //   77	84	259	java/io/FileNotFoundException
    //   87	92	259	java/io/FileNotFoundException
    //   95	105	259	java/io/FileNotFoundException
    //   108	124	259	java/io/FileNotFoundException
    //   127	133	259	java/io/FileNotFoundException
    //   136	148	259	java/io/FileNotFoundException
    //   151	158	259	java/io/FileNotFoundException
    //   161	166	259	java/io/FileNotFoundException
  }
  
  public static Bundle b(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("needRetry", paramBoolean);
    return localBundle;
  }
  
  public void KT(String paramString)
  {
    this.bMA = paramString;
  }
  
  public void destroy() {}
  
  public void drK()
  {
    Object localObject = a(this.bMA, this.mSession);
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ActReflectRequestHelper", 1, new Object[] { "start pack request, request is null ? ", Boolean.valueOf(bool) });
      if (localObject == null) {
        break label237;
      }
      localObject = a((faceproto.Request)localObject, this.bMA);
      if (localObject != null) {
        break;
      }
      this.a.o(2, b(211, acfp.m(2131707673), false));
      return;
    }
    this.abf = System.currentTimeMillis();
    byte[] arrayOfByte = MD5.getFileMd5((String)localObject);
    long l = aqhq.getFileSizes((String)localObject) / 1024L;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    localBundle.putByteArray("md5", arrayOfByte);
    localBundle.putInt("srcAppId", this.appId);
    localBundle.putInt("serviceType", this.mServiceType);
    localBundle.putString("method", this.method);
    localBundle.putString("uin", this.uin);
    localBundle.putString("ticket", this.ticket);
    localBundle.putInt("key_identification_type", 4);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", localBundle, new aiai(this, l));
    return;
    label237:
    this.a.o(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiah
 * JD-Core Version:    0.7.0.1
 */