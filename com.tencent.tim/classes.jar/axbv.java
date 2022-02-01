import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class axbv
{
  private static final String TAG = axbv.class.getSimpleName();
  private static axbv a = new axbv();
  private Map<String, WeakReference<axbv.a>> qA = new ConcurrentHashMap();
  private Map<String, MetaMaterial> qB = new HashMap();
  
  public static axbv a()
  {
    return a;
  }
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    if (this.qA.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.qA.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (axbv.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((axbv.a)localObject).b(paramMetaMaterial);
        }
      }
    }
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.qA.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.qA.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (axbv.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((axbv.a)localObject).b(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(awtn.b.b.cSR, paramMetaMaterial.id).getAbsolutePath();
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, axbv.a parama)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      if (parama != null) {
        parama.c(paramMetaMaterial);
      }
      return;
    }
    this.qA.put(paramMetaMaterial.id, new WeakReference(parama));
    ThreadManager.getFileThreadHandler().post(new AEMaterialMgr.1(this, paramMetaMaterial, paramAppInterface));
  }
  
  /* Error */
  public boolean a(MetaMaterial paramMetaMaterial)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 57	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   8: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: getstatic 134	awtn$b$b:cSQ	Ljava/lang/String;
    //   19: astore_2
    //   20: new 81	java/io/File
    //   23: dup
    //   24: aload_2
    //   25: aload_1
    //   26: getfield 57	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   29: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 138	java/io/File:exists	()Z
    //   37: ifeq -23 -> 14
    //   40: aload_3
    //   41: invokevirtual 141	java/io/File:getPath	()Ljava/lang/String;
    //   44: invokestatic 147	aqhq:px	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne -38 -> 14
    //   55: aload_3
    //   56: aload_1
    //   57: getfield 150	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:packageMd5	Ljava/lang/String;
    //   60: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   63: ifeq -49 -> 14
    //   66: new 158	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 86	awtn$b$b:cSR	Ljava/lang/String;
    //   76: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: getstatic 166	java/io/File:separator	Ljava/lang/String;
    //   82: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: getfield 57	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   89: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 166	java/io/File:separator	Ljava/lang/String;
    //   95: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore 4
    //   103: new 81	java/io/File
    //   106: dup
    //   107: aload 4
    //   109: ldc 171
    //   111: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: astore_3
    //   115: new 81	java/io/File
    //   118: dup
    //   119: aload 4
    //   121: ldc 173
    //   123: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: astore 4
    //   128: aload_3
    //   129: invokevirtual 138	java/io/File:exists	()Z
    //   132: ifne +76 -> 208
    //   135: aload 4
    //   137: invokevirtual 138	java/io/File:exists	()Z
    //   140: ifne +68 -> 208
    //   143: new 81	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: aload_1
    //   149: getfield 57	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   152: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: new 158	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   162: getstatic 86	awtn$b$b:cSR	Ljava/lang/String;
    //   165: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 166	java/io/File:separator	Ljava/lang/String;
    //   171: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 178	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_1
    //   183: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -172 -> 14
    //   189: aload_1
    //   190: invokevirtual 186	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_1
    //   196: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -185 -> 14
    //   202: aload_1
    //   203: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   206: iconst_0
    //   207: ireturn
    //   208: iconst_1
    //   209: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	axbv
    //   0	210	1	paramMetaMaterial	MetaMaterial
    //   19	129	2	str	String
    //   32	97	3	localObject1	Object
    //   101	35	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	182	java/lang/UnsatisfiedLinkError
    //   143	180	195	java/lang/Exception
  }
  
  public boolean isDownloading(String paramString)
  {
    return this.qB.containsKey(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void b(MetaMaterial paramMetaMaterial);
    
    public abstract void b(MetaMaterial paramMetaMaterial, int paramInt);
    
    public abstract void c(MetaMaterial paramMetaMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbv
 * JD-Core Version:    0.7.0.1
 */