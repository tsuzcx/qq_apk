import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.data.AEMaterialConfigParser.AEMaterialConfigParseException;
import dov.com.qq.im.ae.data.AEMaterialManager.1;
import dov.com.qq.im.ae.data.AEMaterialManager.3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class axbr
  extends axpm
{
  public static final Long ab = Long.valueOf(2000L);
  private static AtomicBoolean eL = new AtomicBoolean(false);
  private static axbu jdField_g_of_type_Axbu;
  private static VideoMaterial jdField_g_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private static axbu h;
  private List<axbq> Mn = new CopyOnWriteArrayList();
  private List<axbq> Mo = new CopyOnWriteArrayList();
  private List<axbq> Mp = new ArrayList();
  private List<axbu> Mq = new LinkedList();
  private axbq a;
  private anhn jdField_b_of_type_Anhn;
  private axbq jdField_b_of_type_Axbq;
  public String cTx = "recent_template_setting_new";
  public String cTy = "recent_template_list_new";
  public String cTz = "recent_circle_template_list_new";
  private final Object gl = new Object();
  private final Object gm = new Object();
  private final Object gn = new Object();
  private final Object go = new Object();
  
  public axbr()
  {
    if (this.a == null)
    {
      this.a = new axbq(HA());
      this.a.Mm = new ArrayList(100);
    }
    if (this.jdField_b_of_type_Axbq == null)
    {
      this.jdField_b_of_type_Axbq = new axbq(HA());
      this.jdField_b_of_type_Axbq.Mm = new ArrayList(100);
    }
  }
  
  @Nullable
  public static String A(@Nullable ArrayList<axbx> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  private String HA()
  {
    return acfp.m(2131711235);
  }
  
  public static String HB()
  {
    File localFile = new File(awtn.b.b.cSS);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  public static String HC()
  {
    File localFile = new File(awtn.b.b.cSQ);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private axbu a(axbu paramaxbu)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.Mn.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (axbq)localIterator1.next();
      int i;
      if (((axbq)localObject2).Mm != null)
      {
        Iterator localIterator2 = ((axbq)localObject2).Mm.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (axbu)localIterator2.next();
          if (((axbu)localObject2).equals(paramaxbu))
          {
            i = 1;
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i != 0)
        {
          return localObject1;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        break;
        i = 0;
      }
    }
    return localObject1;
  }
  
  private axbu a(String paramString)
  {
    synchronized (this.Mn)
    {
      axbu localaxbu;
      do
      {
        Iterator localIterator1 = this.Mo.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((axbq)localIterator1.next()).Mm.iterator();
        }
        localaxbu = (axbu)localIterator2.next();
      } while (!localaxbu.id.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localaxbu;
      return null;
    }
  }
  
  private HashMap<String, axbq> a(@Nullable axbq paramaxbq)
  {
    HashMap localHashMap = new HashMap();
    axbq localaxbq1 = new axbq();
    axbq localaxbq2 = new axbq();
    if ((paramaxbq == null) || (paramaxbq.Mm == null))
    {
      localHashMap.put("normal_material", localaxbq1);
      localHashMap.put("circle_material", localaxbq2);
      return localHashMap;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramaxbq.Mm.iterator();
    while (localIterator.hasNext())
    {
      axbu localaxbu = (axbu)localIterator.next();
      if ("circleCamera".equals(localaxbu.cTD)) {
        localArrayList2.add(localaxbu);
      } else {
        localArrayList1.add(localaxbu);
      }
    }
    localaxbq1.Mm = localArrayList1;
    localaxbq1.categoryId = paramaxbq.categoryId;
    localaxbq1.categoryName = paramaxbq.categoryName;
    localaxbq1.cTw = paramaxbq.cTw;
    localaxbq1.dtV = paramaxbq.dtV;
    localaxbq1.eEw = paramaxbq.eEw;
    localaxbq2.Mm = localArrayList2;
    localaxbq2.categoryId = paramaxbq.categoryId;
    localaxbq2.categoryName = paramaxbq.categoryName;
    localaxbq2.cTw = paramaxbq.cTw;
    localaxbq2.dtV = paramaxbq.dtV;
    localaxbq2.eEw = paramaxbq.eEw;
    localHashMap.put("normal_material", localaxbq1);
    localHashMap.put("circle_material", localaxbq2);
    return localHashMap;
  }
  
  private List<axbq> a(File paramFile1, File paramFile2)
    throws AEMaterialConfigParser.AEMaterialConfigParseException
  {
    paramFile1 = e(paramFile1);
    List localList = e(paramFile2);
    if ((localList == null) || (localList.isEmpty())) {
      return paramFile1;
    }
    Iterator localIterator1 = paramFile1.iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      paramFile2 = (axbq)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (axbq)localIterator2.next();
      } while (!paramFile1.categoryName.equals(paramFile2.categoryName));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.Mm.iterator();
        while (paramFile1.hasNext()) {
          u((axbu)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.Mm.iterator();
      label149:
      axbu localaxbu;
      if (localIterator2.hasNext())
      {
        localaxbu = (axbu)localIterator2.next();
        Iterator localIterator3 = paramFile1.Mm.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (axbu)localIterator3.next();
        } while (!localaxbu.id.equals(paramFile2.id));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          u(localaxbu);
          break label149;
        }
        if (localaxbu.md5.equals(paramFile2.md5)) {
          break label149;
        }
        u(localaxbu);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private boolean aOp()
  {
    return (this.jdField_b_of_type_Axbq != null) && (this.jdField_b_of_type_Axbq.Mm != null) && (this.jdField_b_of_type_Axbq.Mm.size() >= 100);
  }
  
  @Nullable
  public static ArrayList<axbx> ap(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new axbs().getType());
  }
  
  private boolean auF()
  {
    return (this.a != null) && (this.a.Mm.size() >= 100);
  }
  
  public static axbu b()
  {
    return h;
  }
  
  private axbu b(String paramString)
  {
    synchronized (this.Mn)
    {
      axbu localaxbu;
      do
      {
        Iterator localIterator1 = this.Mp.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((axbq)localIterator1.next()).Mm.iterator();
        }
        localaxbu = (axbu)localIterator2.next();
      } while (!localaxbu.id.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localaxbu;
      return null;
    }
  }
  
  private void b(AppInterface paramAppInterface, String paramString, axbu paramaxbu, axcc.b paramb)
  {
    axcc.a(paramAppInterface, paramaxbu, paramString, new axbt(this, paramb));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (paramaxbu == null) {}
    for (paramAppInterface = "null";; paramAppInterface = paramaxbu.id)
    {
      axiy.i("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  /* Error */
  public static boolean b(axbu paramaxbu)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 329	axbu:name	Ljava/lang/String;
    //   11: invokestatic 334	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 337	axbr:c	(Laxbu;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramaxbu	axbu
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  private static boolean c(axbu paramaxbu)
  {
    boolean bool = false;
    Object localObject = paramaxbu.getLocalPath();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(paramaxbu.HE());
        if (!localFile2.exists()) {
          return false;
        }
        jqp.b(localFile2, paramaxbu.HD());
        return true;
      }
      catch (Exception paramaxbu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", paramaxbu);
        }
        if (localFile1.exists()) {
          break label110;
        }
      }
      if (((File)localObject).exists()) {
        label110:
        return true;
      }
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  private boolean d(@Nullable axbu paramaxbu)
  {
    if ((paramaxbu == null) || (TextUtils.isEmpty(paramaxbu.id)) || (TextUtils.isEmpty(paramaxbu.md5))) {
      return false;
    }
    Iterator localIterator = this.Mq.iterator();
    while (localIterator.hasNext())
    {
      axbu localaxbu = (axbu)localIterator.next();
      if ((localaxbu != null) && (!TextUtils.isEmpty(localaxbu.id)) && (!TextUtils.isEmpty(localaxbu.md5)) && (localaxbu.id.equals(paramaxbu.id)) && (localaxbu.md5.equals(paramaxbu.md5))) {
        return true;
      }
    }
    return false;
  }
  
  private List<axbq> e(File paramFile)
    throws AEMaterialConfigParser.AEMaterialConfigParseException
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = ayzs.p(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.ao(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  public static void e(VideoMaterial paramVideoMaterial)
  {
    jdField_g_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
  }
  
  private void eIE()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "initMaterialList enter");
    }
    eIG();
    for (;;)
    {
      Object localObject8;
      Object localObject7;
      synchronized (this.go)
      {
        localObject8 = new File(awtn.b.b.cSS, "camera_story_update_template.json");
        localObject7 = new File(awtn.b.b.cSS, "camera_story_default_template.json");
        if (!((File)localObject8).exists())
        {
          List localList1;
          if (!((File)localObject7).exists())
          {
            localList1 = hM();
            if ((localList1 != null) && (!localList1.isEmpty())) {
              break label257;
            }
            return;
          }
          try
          {
            localList1 = e((File)localObject7);
          }
          catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
          {
            aqhq.deleteFile(((File)localObject7).getPath());
            List localList2 = hM();
            eIF();
          }
        }
      }
      boolean bool = ((File)localObject7).exists();
      List localList4;
      if (!bool)
      {
        try
        {
          List localList3 = e((File)localObject8);
          aqhq.moveFile(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          aqhq.deleteFile(((File)localObject8).getPath());
          localList4 = hM();
          eIF();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        aqhq.deleteFile(((File)localObject7).getPath());
        aqhq.moveFile(((File)localObject8).getPath(), ((File)localObject7).getPath());
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        localObject2 = hM();
        eIF();
      }
      continue;
      label257:
      synchronized (this.gn)
      {
        this.Mn.clear();
        this.Mo.clear();
        this.Mp.clear();
        this.Mn.addAll((Collection)localObject2);
        localObject2 = ((List)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject7).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject7 = (axbq)((Iterator)localObject2).next();
            } while (localObject7 == null);
            Object localObject9 = a((axbq)localObject7);
            localObject8 = (axbq)((HashMap)localObject9).get("normal_material");
            localObject9 = (axbq)((HashMap)localObject9).get("circle_material");
            if ((localObject9 != null) && (((axbq)localObject9).Mm != null) && (((axbq)localObject9).Mm.size() > 0)) {
              this.Mp.add(localObject9);
            }
            if ((localObject8 != null) && (((axbq)localObject8).Mm != null) && (((axbq)localObject8).Mm.size() > 0)) {
              this.Mo.add(localObject8);
            }
            localObject7 = ((axbq)localObject7).Mm.iterator();
          }
          localObject8 = (axbu)((Iterator)localObject7).next();
        } while (localObject8 == null);
        ((axbu)localObject8).usable = b((axbu)localObject8);
      }
      eIH();
      eII();
      eL.set(true);
      synchronized (this.gn)
      {
        if ((this.Mo.size() > 0) && (!HA().equals(((axbq)this.Mo.get(0)).categoryName))) {
          this.Mo.add(0, this.a);
        }
        if ((this.Mp.size() > 0) && (!HA().equals(((axbq)this.Mp.get(0)).categoryName))) {
          this.Mp.add(0, this.jdField_b_of_type_Axbq);
        }
        eIL();
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("AEMaterialManager", 2, "initMaterialList exit, cost = " + (l2 - l1) + "ms");
        return;
      }
    }
  }
  
  private void eIF()
  {
    axis.a().hh("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void eIG()
  {
    axiy.i("AEMaterialManager", "filament isSupport: " + supportFilament());
  }
  
  private void eIH()
  {
    int i = 0;
    if (this.a == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = axis.a().t(this.cTy + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getRecentTemplate list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.gl)
      {
        this.a.Mm.clear();
        if (i >= arrayOfString.length) {
          break label248;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label251;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = a(localObject3[0]);
        if (localObject3 == null) {
          break label251;
        }
        if (this.a.Mm.size() >= 100) {
          return;
        }
      }
      if (this.a.Mm.contains(localObject3)) {
        return;
      }
      if (((axbu)localObject3).id.equals("0")) {
        return;
      }
      this.a.Mm.add(localObject3);
      break label251;
      label248:
      return;
      label251:
      i += 1;
    }
  }
  
  private void eII()
  {
    int i = 0;
    if (this.jdField_b_of_type_Axbq == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = axis.a().t(this.cTz + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getRecentTemplate list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.gm)
      {
        this.jdField_b_of_type_Axbq.Mm.clear();
        if (i >= arrayOfString.length) {
          break label245;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label248;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = b(localObject3[0]);
        if (localObject3 == null) {
          break label248;
        }
        if (this.jdField_b_of_type_Axbq.Mm.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_b_of_type_Axbq.Mm.contains(localObject3)) && (!((axbu)localObject3).id.equals("0")))
      {
        this.jdField_b_of_type_Axbq.Mm.add(localObject3);
        break label248;
        label245:
        return;
      }
      label248:
      i += 1;
    }
  }
  
  private void eIM()
  {
    if (this.jdField_b_of_type_Anhn != null) {
      this.jdField_b_of_type_Anhn.notify(111, new Object[] { this.a });
    }
  }
  
  private void eIN()
  {
    if (this.jdField_b_of_type_Anhn != null) {
      this.jdField_b_of_type_Anhn.notify(111, new Object[] { this.jdField_b_of_type_Axbq });
    }
  }
  
  private int f(List<axbu> paramList, String paramString)
  {
    int j;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label61;
      }
      j = i;
      if (((axbu)paramList.get(i)).id.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  private List<axbq> hM()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = axbk.bT(a().getApp());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        localObject = AEMaterialConfigParser.ao((String)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          return localObject;
        }
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException)
      {
        QLog.d("AEMaterialManager", 4, "loadMaterialListFromAssets err=" + localAEMaterialConfigParseException.getMessage());
      }
    }
    return localArrayList;
  }
  
  private List<axbu> i(List<axbq> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.gn)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        axbq localaxbq = (axbq)paramList.next();
        if (localaxbq.categoryName.equals(paramString))
        {
          localArrayList.addAll(localaxbq.Mm);
          if ((localArrayList.size() > 0) && (((axbu)localArrayList.get(0)).equals(axbu.i))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
  }
  
  public static boolean supportFilament()
  {
    try
    {
      boolean bool = FilamentInitializer.supportFilament();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void u(axbu paramaxbu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + paramaxbu.id);
    }
    File localFile = new File(awtn.b.b.cSR, paramaxbu.id);
    if (localFile.exists()) {
      aqhq.cn(localFile.getPath());
    }
    paramaxbu = new File(awtn.b.b.cSQ, paramaxbu.id);
    if (paramaxbu.exists()) {
      aqhq.cn(paramaxbu.getPath());
    }
  }
  
  public void F(int paramInt, Object paramObject)
  {
    if (this.jdField_b_of_type_Anhn != null)
    {
      this.jdField_b_of_type_Anhn.notify(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public axbu a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.Mp;; localObject = this.Mo)
    {
      if (((List)localObject).isEmpty()) {
        eIE();
      }
      localObject = ((List)localObject).iterator();
      axbq localaxbq;
      axbu localaxbu;
      int j;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localaxbq = (axbq)((Iterator)localObject).next();
          } while ((localaxbq == null) || (localaxbq.Mm == null));
          localIterator = localaxbq.Mm.iterator();
          i = 0;
        }
        localaxbu = (axbu)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!localaxbu.id.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localaxbu);
      }
      localaxbu.cTB = localaxbq.categoryName;
      localaxbu.position = j;
      return localaxbu;
    }
    return null;
  }
  
  public void a(anho paramanho, int paramInt)
  {
    try
    {
      if (this.jdField_b_of_type_Anhn == null) {
        this.jdField_b_of_type_Anhn = new anhn();
      }
      this.jdField_b_of_type_Anhn.a(paramanho, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, axbu paramaxbu, axcc.b paramb)
  {
    a(paramAppInterface, awtn.b.b.cSQ, paramaxbu, paramb);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, axbu paramaxbu, axcc.b paramb)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, paramaxbu, paramb), 128, null, true);
  }
  
  public void aGs()
  {
    eIE();
  }
  
  public void aco(String paramString)
  {
    try
    {
      paramString = e(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = i(hM(), acfp.m(2131689975));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = i(paramString, acfp.m(2131689976));
      }
      axis.a().ai("PhotoConst.ae_latest_material", A(localArrayList), 4);
      return;
    }
    catch (NullPointerException paramString)
    {
      label131:
      paramString.printStackTrace();
    }
    localArrayList = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      axbu localaxbu = (axbu)paramString.next();
      if ((localArrayList.size() < 10) && (localaxbu != null) && (localaxbu.id != null) && (localaxbu.iconurl != null)) {
        localArrayList.add(new axbx(localaxbu.id, localaxbu.iconurl));
      }
    }
  }
  
  public void adH(int paramInt)
  {
    try
    {
      if (this.jdField_b_of_type_Anhn != null) {
        this.jdField_b_of_type_Anhn.remove(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(axbu paramaxbu, boolean paramBoolean)
  {
    c(paramaxbu, paramBoolean);
    F(113, null);
  }
  
  public void c(axbu paramaxbu, boolean paramBoolean)
  {
    jdField_g_of_type_Axbu = h;
    h = paramaxbu;
    if ((paramaxbu == null) || (paramaxbu.aOq())) {
      jdField_g_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean)
    {
      if ("circleCamera".equals(paramaxbu.cTD)) {
        w(paramaxbu);
      }
    }
    else {
      return;
    }
    v(paramaxbu);
  }
  
  public void d(anho paramanho)
  {
    try
    {
      if (this.jdField_b_of_type_Anhn != null) {
        this.jdField_b_of_type_Anhn.a(paramanho);
      }
      return;
    }
    finally
    {
      paramanho = finally;
      throw paramanho;
    }
  }
  
  public void eIC()
  {
    eID();
  }
  
  public void eID()
  {
    eIE();
  }
  
  public void eIJ()
  {
    if (this.a == null) {}
    while ((this.a.Mm != null) && (this.a.Mm.isEmpty())) {
      return;
    }
    synchronized (this.gl)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.a.Mm.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        axbu localaxbu = (axbu)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localaxbu.id)) && (!localaxbu.equals(axbu.i)))
        {
          localStringBuilder.append(localaxbu.id).append("|");
          localStringBuilder.append(localaxbu.categoryId).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    axis.a().ai(this.cTy + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void eIK()
  {
    if ((this.jdField_b_of_type_Axbq == null) || (this.jdField_b_of_type_Axbq.Mm == null) || (this.jdField_b_of_type_Axbq.Mm.isEmpty())) {
      return;
    }
    synchronized (this.gm)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_b_of_type_Axbq.Mm.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        axbu localaxbu = (axbu)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localaxbu.id)) && (!localaxbu.equals(axbu.i)))
        {
          localStringBuilder.append(localaxbu.id).append("|");
          localStringBuilder.append(localaxbu.categoryId).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    axis.a().ai(this.cTz + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void eIL()
  {
    if ((!this.Mq.isEmpty()) && (!d(h)))
    {
      c(axbu.i, false);
      e(null);
    }
    if (a() != null) {
      a().notifyObservers(axrf.class, 3, true, null);
    }
    if (this.jdField_b_of_type_Anhn != null) {
      this.jdField_b_of_type_Anhn.notify(116, null);
    }
  }
  
  public List<axbq> hJ()
  {
    return this.Mp;
  }
  
  public List<axbq> hK()
  {
    return this.Mo;
  }
  
  public List<axbu> hL()
  {
    return i(this.Mo, acfp.m(2131702173));
  }
  
  public void oD(@Nullable List<axbu> paramList)
  {
    if (paramList != null) {
      this.Mq = paramList;
    }
  }
  
  public void refresh()
  {
    ThreadManager.excute(new AEMaterialManager.1(this), 64, null, false);
  }
  
  public void v(axbu paramaxbu)
  {
    if (paramaxbu == null) {}
    while (paramaxbu.aOq()) {
      return;
    }
    if (this.a == null)
    {
      eIH();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.gl)
      {
        i = f(this.a.Mm, paramaxbu.id);
        if (i != -1) {
          break label183;
        }
        if (!auF())
        {
          this.a.Mm.add(0, paramaxbu);
          eIM();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.a.Mm.remove(99);
      this.a.Mm.add(0, paramaxbu);
      eIM();
      continue;
      label183:
      if (i != 0)
      {
        this.a.Mm.remove(i);
        this.a.Mm.add(0, paramaxbu);
        eIM();
      }
    }
  }
  
  public void w(axbu paramaxbu)
  {
    if (paramaxbu == null) {}
    while (paramaxbu.aOq()) {
      return;
    }
    if (this.jdField_b_of_type_Axbq == null)
    {
      eII();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.gm)
      {
        i = f(this.jdField_b_of_type_Axbq.Mm, paramaxbu.id);
        if (i != -1) {
          break label183;
        }
        if (!aOp())
        {
          this.jdField_b_of_type_Axbq.Mm.add(0, paramaxbu);
          eIN();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.jdField_b_of_type_Axbq.Mm.remove(99);
      this.jdField_b_of_type_Axbq.Mm.add(0, paramaxbu);
      eIN();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_b_of_type_Axbq.Mm.remove(i);
        this.jdField_b_of_type_Axbq.Mm.add(0, paramaxbu);
        eIN();
      }
    }
  }
  
  public List<axbq> x(boolean paramBoolean)
  {
    return this.Mo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbr
 * JD-Core Version:    0.7.0.1
 */