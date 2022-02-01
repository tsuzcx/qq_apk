import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public abstract class iki
  extends EffectConfigBase<PendantItem>
  implements ijt.a
{
  private static final DecryptListener decryptListener = new ikj();
  protected final iki.a a;
  protected ikk a;
  protected String[] aN;
  protected boolean mDestroy;
  
  public iki(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Iki$a = new iki.a();
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, false, decryptListener);
  }
  
  public iki.a a(int paramInt1, int paramInt2)
  {
    if (!iow.va()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    PendantItem localPendantItem = (PendantItem)a();
    if (this.mDestroy)
    {
      this.mDestroy = false;
      clear();
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Iki$a.path)) {
        this.jdField_a_of_type_Iki$a.path = null;
      }
      return null;
    }
    String str1 = c(localPendantItem);
    String str2 = localPendantItem.getId();
    if ((str1.equals(this.jdField_a_of_type_Iki$a.path)) && (this.jdField_a_of_type_Iki$a.b != null) && (str2.equals(this.jdField_a_of_type_Iki$a.b.getId()))) {
      return this.jdField_a_of_type_Iki$a;
    }
    long l = System.currentTimeMillis();
    VideoMaterial localVideoMaterial = parseVideoMaterial(str1);
    this.jdField_a_of_type_Iki$a.a = localVideoMaterial;
    this.jdField_a_of_type_Iki$a.b = localPendantItem;
    this.jdField_a_of_type_Iki$a.path = str1;
    igd.aJ(this.TAG, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
    return this.jdField_a_of_type_Iki$a;
  }
  
  public Class<?> a()
  {
    return PendantItem.class;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = igg.gw() + paramPendantItem.getMd5();
    }
    return str;
  }
  
  protected void a(long paramLong, PendantItem paramPendantItem)
  {
    if (this.mApp != null) {
      ((iju)this.mApp.a(1)).a(paramLong, paramPendantItem);
    }
  }
  
  public void a(ikk paramikk)
  {
    this.jdField_a_of_type_Ikk = paramikk;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    iiv localiiv = VideoController.a().b();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      localiiv.b.set(1);
      return bool;
    }
    localiiv.b.clear(1);
    return bool;
  }
  
  public String b(PendantItem paramPendantItem)
  {
    String str = "";
    if (paramPendantItem != null) {
      str = igg.gx() + paramPendantItem.getMd5() + File.separator;
    }
    return str;
  }
  
  protected boolean b(PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramPendantItem);
    String str1;
    Object localObject;
    int k;
    int i;
    if (bool)
    {
      str1 = c(paramPendantItem);
      if ((this.aN == null) || (this.aN.length <= 0)) {
        break label284;
      }
      localObject = this.aN;
      int m = localObject.length;
      k = 0;
      i = 0;
      j = i;
      if (k < m)
      {
        String str2 = localObject[k];
        File localFile = new File(str1, str2);
        long l = localFile.length();
        if (((!localFile.exists()) || (l >= 1L)) && (localFile.exists())) {
          break label265;
        }
        j = 1;
        label111:
        if ((j == 0) && (i == 0)) {
          break label270;
        }
        i = 1;
        label121:
        if ((j != 0) && (QLog.isColorLevel())) {
          QLog.i(this.TAG, 2, "isTemplateUsable, fileName[" + str2 + "], item[" + paramPendantItem + "]");
        }
        if (i == 0) {
          break label275;
        }
      }
    }
    label265:
    label270:
    label275:
    label284:
    for (int j = i;; j = 0)
    {
      if (j != 0)
      {
        str1 = a(paramPendantItem);
        localObject = b(paramPendantItem);
        ThreadManager.excute(new EffectPendantBase.1(this, new File(str1), (String)localObject), 16, null, false);
        if (QLog.isDevelopLevel()) {
          QLog.i(this.TAG, 4, "isTemplateUsable, need unzip item[" + paramPendantItem + "]");
        }
      }
      return bool;
      j = 0;
      break label111;
      i = 0;
      break label121;
      k += 1;
      break;
    }
  }
  
  protected String c(PendantItem paramPendantItem)
  {
    Object localObject1 = "";
    Object localObject3 = localObject1;
    Object localObject2;
    String str;
    if (paramPendantItem != null)
    {
      localObject2 = null;
      str = b(paramPendantItem) + paramPendantItem.getName() + File.separator;
      if (!new File(str).exists()) {
        break label141;
      }
      localObject1 = str;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = localObject1;
        if (QLog.isDevelopLevel())
        {
          QLog.i(this.TAG, 4, "getFilterPathForRead, new[" + str + "], old[" + (String)localObject2 + "], item[" + paramPendantItem + "]");
          localObject3 = localObject1;
        }
      }
      return localObject3;
      label141:
      localObject3 = igg.gv() + paramPendantItem.getName() + File.separator;
      localObject2 = localObject3;
      if (new File((String)localObject3).exists())
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
      }
    }
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Iki$a.a = null;
    this.jdField_a_of_type_Iki$a.b = null;
    this.jdField_a_of_type_Iki$a.path = null;
  }
  
  protected boolean cs(String paramString)
  {
    return ikx.b(this.mApp);
  }
  
  public abstract int kU();
  
  public void onCreate()
  {
    super.onCreate();
    ijt localijt = (ijt)this.mApp.a(12);
    if (localijt != null) {
      localijt.a(kU(), this);
    }
  }
  
  public VideoMaterial parseVideoMaterial(String paramString)
  {
    VideoMaterial localVideoMaterial = parseVideoMaterial(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    return localVideoMaterial;
  }
  
  public List<PendantItem> y(String paramString)
  {
    paramString = super.y(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public static class a
  {
    public VideoMaterial a;
    public PendantItem b;
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iki
 * JD-Core Version:    0.7.0.1
 */