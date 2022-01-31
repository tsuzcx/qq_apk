import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.videostory.app.material.AEMaterialMgr.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class wqh
{
  private static final String jdField_a_of_type_JavaLangString = wqh.class.getSimpleName();
  private static wqh jdField_a_of_type_Wqh = new wqh();
  private Map<String, WeakReference<wqj>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, MetaMaterial> b = new HashMap();
  
  public static wqh a()
  {
    return jdField_a_of_type_Wqh;
  }
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (wqj)((WeakReference)localObject).get();
        if (localObject != null) {
          ((wqj)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (wqj)((WeakReference)localObject).get();
        if (localObject != null) {
          ((wqj)localObject).a(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(PtvTemplateManager.jdField_a_of_type_JavaLangString, paramMetaMaterial.id).getAbsolutePath();
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, wqj paramwqj)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      if (paramwqj != null) {
        paramwqj.b(paramMetaMaterial);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramMetaMaterial.id, new WeakReference(paramwqj));
    ThreadManager.getFileThreadHandler().post(new AEMaterialMgr.1(this, paramMetaMaterial, paramAppInterface));
  }
  
  /* Error */
  public boolean a(MetaMaterial paramMetaMaterial)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 46	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   8: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 75	java/io/File
    //   19: dup
    //   20: getstatic 125	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: aload_1
    //   24: getfield 46	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   27: invokespecial 128	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 132	java/io/File:exists	()Z
    //   35: ifeq -21 -> 14
    //   38: aload_2
    //   39: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 141	bace:c	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -36 -> 14
    //   53: aload_2
    //   54: aload_1
    //   55: getfield 144	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:packageMd5	Ljava/lang/String;
    //   58: invokevirtual 150	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq -47 -> 14
    //   64: new 152	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 78	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 46	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   81: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 160	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 75	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: ldc 165
    //   101: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_2
    //   105: new 75	java/io/File
    //   108: dup
    //   109: aload_3
    //   110: ldc 167
    //   112: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: astore_3
    //   116: aload_2
    //   117: invokevirtual 132	java/io/File:exists	()Z
    //   120: ifne +58 -> 178
    //   123: aload_3
    //   124: invokevirtual 132	java/io/File:exists	()Z
    //   127: ifne +51 -> 178
    //   130: new 75	java/io/File
    //   133: dup
    //   134: getstatic 125	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   137: aload_1
    //   138: getfield 46	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   141: invokespecial 128	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   144: getstatic 78	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokestatic 171	mpx:a	(Ljava/io/File;Ljava/lang/String;)V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_1
    //   153: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -142 -> 14
    //   159: aload_1
    //   160: invokevirtual 179	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_1
    //   166: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq -155 -> 14
    //   172: aload_1
    //   173: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: iconst_1
    //   179: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	wqh
    //   0	180	1	paramMetaMaterial	MetaMaterial
    //   30	87	2	localObject1	Object
    //   93	31	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	152	java/lang/UnsatisfiedLinkError
    //   130	150	165	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqh
 * JD-Core Version:    0.7.0.1
 */