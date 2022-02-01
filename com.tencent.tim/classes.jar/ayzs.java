import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.1;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.2;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.5;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayzs
  extends axpm
{
  private static File aH;
  public static final Long ab = Long.valueOf(2000L);
  private static final String bTU;
  public static String bYM = "ptv_template_usable";
  public static String bYN = "ptv_debug";
  public static File bl;
  public static String cdu = bl.getPath() + File.separator + cdu + File.separator;
  public static int dyy;
  public static AtomicBoolean eL = new AtomicBoolean(false);
  public List<axql> Fu = new CopyOnWriteArrayList();
  private MovieMaterial a;
  private anhn jdField_b_of_type_Anhn;
  private axql jdField_b_of_type_Axql;
  String bYP;
  String bYQ;
  private axql c;
  public String cTx = "recent_template_setting";
  public String cTy = "recent_template_list";
  private String cYr;
  public final Object eI = new Object();
  protected Object gr = new Object();
  HashMap<Integer, Object> mBusinessParams = new HashMap();
  
  static
  {
    File localFile = new File(aasa.SDCARD_PATH);
    bTU = localFile.getPath();
    aH = new File(localFile, "dov_ptv_template_dov");
    bYM = aH.getPath() + File.separator + bYM + File.separator;
    bYN = aH.getPath() + File.separator + bYN;
    bl = new File(localFile, "doodle_template");
  }
  
  public static List<axql> a(ayzs paramayzs, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (paramayzs != null)
        {
          if (((JSONObject)localObject).has("guide_video_url")) {
            paramayzs.bYP = ((JSONObject)localObject).getString("guide_video_url");
          }
          if (((JSONObject)localObject).has("guide_video_md5")) {
            paramayzs.bYQ = ((JSONObject)localObject).getString("guide_video_md5");
          }
        }
        if (!((JSONObject)localObject).has("bigheadCommonRes")) {
          break label148;
        }
        paramString = ((JSONObject)localObject).getJSONObject("bigheadCommonRes");
        if (paramString == null) {
          break label148;
        }
        str = paramString.optString("bighead_model_name", "");
        paramayzs = paramString.optString("bighead_model_resurl", "");
        paramString = paramString.optString("bighead_model_resmd5", "");
        if (!((JSONObject)localObject).has("category")) {
          break;
        }
        localObject = l(((JSONObject)localObject).getJSONArray("category"));
        a((List)localObject, str, paramayzs, paramString);
        return localObject;
      }
      catch (JSONException paramayzs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramayzs.printStackTrace();
      return null;
      label148:
      String str = "";
      paramString = "";
      paramayzs = "";
    }
  }
  
  private static void a(List<axql> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (axql)paramList.next();
      if ((((axql)localObject).Fv == null) || (((axql)localObject).Fv.size() <= 0)) {
        break;
      }
      localObject = ((axql)localObject).Fv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
        {
          localPtvTemplateInfo.bigHeadName = paramString1;
          localPtvTemplateInfo.bigHeadUrl = paramString2;
          localPtvTemplateInfo.bigHeadMd5 = paramString3;
        }
      }
    }
  }
  
  public static boolean aRz()
  {
    boolean bool = new File(aH, "ptv_template_new.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager isStickerConfigFileExist" + bool);
    }
    return bool;
  }
  
  private boolean auF()
  {
    return (this.jdField_b_of_type_Axql != null) && (this.jdField_b_of_type_Axql.Fv.size() >= 100);
  }
  
  private ArrayList<axql> aw(ArrayList<axql> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      axql localaxql = c((axql)paramArrayList.next());
      if ((localaxql != null) && (localaxql.Fv.size() > 0)) {
        localArrayList.add(localaxql);
      } else if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "templateInfoList.size() == 0 all not support segment should hide tab!");
      }
    }
    return localArrayList;
  }
  
  private int g(List<PtvTemplateManager.PtvTemplateInfo> paramList, String paramString)
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
      if (((PtvTemplateManager.PtvTemplateInfo)paramList.get(i)).id.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  private boolean g(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject;
    label186:
    label207:
    label209:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          localObject = new File(aH, paramString1);
          if (((File)localObject).exists()) {
            try
            {
              localObject = aqhq.px(((File)localObject).getPath());
              if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase(paramString2))) {
                break label209;
              }
              localObject = bYM + paramString1 + File.separator;
              paramString2 = new File((String)localObject, "params.json");
              localObject = new File((String)localObject, "params.dat");
              if ((paramString2.exists()) || ((paramBoolean) && (((File)localObject).exists()))) {
                break label207;
              }
              if (!QLog.isColorLevel()) {}
            }
            catch (UnsatisfiedLinkError paramString1)
            {
              try
              {
                jqp.b(new File(aH, paramString1), bYM);
                return true;
              }
              catch (Exception paramString1)
              {
                if (!QLog.isColorLevel()) {
                  break label186;
                }
                QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable unZipFile exp:", paramString1);
              }
              paramString1 = paramString1;
            }
          }
        }
        QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable calcMd5 error:", paramString1);
        return false;
      } while ((!paramString2.exists()) || ((!paramBoolean) && (!((File)localObject).exists())));
      return true;
      return true;
    } while (!QLog.isColorLevel());
    QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable md5 exp, fileMd5:" + (String)localObject + ", tempMd5:" + paramString2 + ", name:" + paramString1);
    return false;
  }
  
  static void he(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.2(paramString2, paramString1));
  }
  
  static List<axql> l(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    int j;
    do
    {
      return null;
      j = paramJSONArray.length();
    } while (j <= 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      axql localaxql;
      if (i < j) {
        try
        {
          localaxql = new axql();
          Object localObject = paramJSONArray.getJSONObject(i);
          if (((JSONObject)localObject).has("content")) {
            localaxql.Fv = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject).getJSONArray("content"));
          }
          if (((JSONObject)localObject).has("categoryName")) {
            localaxql.categoryName = ((JSONObject)localObject).getString("categoryName");
          }
          if ((((JSONObject)localObject).has("TipsVer")) && (((JSONObject)localObject).has("Tips")))
          {
            localaxql.dyC = ((JSONObject)localObject).getInt("TipsVer");
            localaxql.bZc = ((JSONObject)localObject).getString("Tips");
          }
          localaxql.dvY = "1".equals(((JSONObject)localObject).optString("random_position"));
          if (((JSONObject)localObject).has("categoryId"))
          {
            localaxql.categoryId = ((JSONObject)localObject).getInt("categoryId");
            if ((localaxql.Fv != null) && (!localaxql.Fv.isEmpty()))
            {
              localObject = localaxql.Fv.iterator();
              while (((Iterator)localObject).hasNext())
              {
                ((PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next()).categoryId = localaxql.categoryId;
                continue;
                return localArrayList;
              }
            }
          }
        }
        catch (JSONException paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            paramJSONArray.printStackTrace();
          }
        }
      }
      localArrayList.add(localaxql);
      i += 1;
    }
  }
  
  public static String p(File paramFile)
  {
    paramFile = aqhq.fileToBytes(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, ", paramFile);
    }
    return null;
  }
  
  public void F(int paramInt, Object paramObject)
  {
    if (this.jdField_b_of_type_Anhn != null)
    {
      this.jdField_b_of_type_Anhn.notify(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public String IC()
  {
    return this.cYr;
  }
  
  public int Io()
  {
    return -1;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = dt().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (axql)localIterator.next();
        } while ((localObject == null) || (((axql)localObject).Fv == null) || (((axql)localObject).categoryId != axpa.eGs));
        localObject = ((axql)localObject).Fv.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(axpa.cVC));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localPtvTemplateInfo);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public Runnable a(File paramFile)
  {
    return new QIMPtvTemplateManager.5(this, paramFile);
  }
  
  public Runnable a(boolean paramBoolean)
  {
    return new QIMPtvTemplateManager.1(this, paramBoolean);
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
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    if (paramPtvTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
      }
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramb);
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramPtvTemplateInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        if (paramPtvTemplateInfo.kind == 5)
        {
          paramPtvTemplateInfo.dgStageUsable = g(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          paramPtvTemplateInfo.dgModelUsable = g(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
          boolean bool3 = g(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool3), paramPtvTemplateInfo.id }));
          }
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgStageUsable) {
            continue;
          }
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgModelUsable) {
            continue;
          }
          bool1 = bool3;
          continue;
        }
        if (paramPtvTemplateInfo.kind == 6)
        {
          paramPtvTemplateInfo.dgStageUsable = g(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgStageUsable) {
            continue;
          }
          bool1 = g(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          continue;
        }
        bool1 = g(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
      }
      finally {}
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
  
  public void adM(String paramString)
  {
    this.cYr = paramString;
  }
  
  public void aq(String paramString1, int paramInt, String paramString2)
  {
    axpa.cVC = paramString1;
    axpa.eGs = paramInt;
    axpa.bec = paramString2;
    paramString1 = new StringBuilder("QIMPtvTemplateManager setSelectedPtvTemplate id=").append(paramString1).append(" categoryId =").append(paramInt).append(" currentPath=").append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, paramString1.toString());
    }
    F(113, null);
  }
  
  public axql b(axql paramaxql)
  {
    int i = 0;
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    ??? = BaseApplicationImpl.getApplication().getSharedPreferences(this.cTx, 0).getString(this.cTy + (String)???, null);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplate list=" + (String)???);
    }
    if (TextUtils.isEmpty((CharSequence)???)) {
      return paramaxql;
    }
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject2;
      synchronized (this.gr)
      {
        paramaxql.Fv.clear();
        if (i >= arrayOfString.length) {
          break label212;
        }
        localObject2 = arrayOfString[i].split("\\|");
        if ((localObject2 == null) || (localObject2.length != 2)) {
          break label216;
        }
        Integer.valueOf(localObject2[1]).intValue();
        localObject2 = b(localObject2[0]);
        if (localObject2 == null) {
          break label216;
        }
        if (paramaxql.Fv.size() >= 100) {
          return paramaxql;
        }
      }
      paramaxql.Fv.add(localObject2);
      break label216;
      label212:
      return paramaxql;
      label216:
      i += 1;
    }
  }
  
  public MovieMaterial b()
  {
    return this.a;
  }
  
  public PtvTemplateManager.PtvTemplateInfo b(String paramString)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator1 = dt().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((axql)localIterator1.next()).Fv.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramPtvTemplateInfo.startDownloadTime = System.currentTimeMillis();
      aoll localaoll = new aoll();
      localaoll.f = new ayzu(this, paramPtvTemplateInfo, paramb);
      localaoll.bZ = paramPtvTemplateInfo.resurl;
      localaoll.mHttpMethod = 0;
      if (paramPtvTemplateInfo.name == null)
      {
        QLog.i("QIMPtvTemplateManager", 1, "startDownloadTemplate fail, info.name is null, url:" + paramPtvTemplateInfo.resurl);
        return;
      }
      localaoll.atY = new File(aH, paramPtvTemplateInfo.name).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localaoll.mExcuteTimeLimit = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localaoll);
        localaoll.f.onUpdateProgeress(localaoll, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QIMPtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void b(MovieMaterial paramMovieMaterial)
  {
    this.a = paramMovieMaterial;
  }
  
  protected axql c(axql paramaxql)
  {
    if (paramaxql == null) {
      return null;
    }
    Object localObject = (awrz)axov.a().c(13);
    paramaxql = paramaxql.a();
    if ((localObject == null) || (!((awrz)localObject).aNw())) {
      return paramaxql;
    }
    localObject = paramaxql.Fv.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
      if (!localPtvTemplateInfo.multivideosupport)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, "should hide template not support segment, categoryID=" + localPtvTemplateInfo.categoryId + ", templateID = " + localPtvTemplateInfo.id + ", templateName = " + localPtvTemplateInfo.name);
        }
        ((Iterator)localObject).remove();
      }
    }
    return paramaxql;
  }
  
  public void c(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.gr)
      {
        if (this.jdField_b_of_type_Axql == null)
        {
          this.jdField_b_of_type_Axql = new axql(acfp.m(2131711238));
          this.jdField_b_of_type_Axql.Fv = new ArrayList(100);
          b(this.jdField_b_of_type_Axql);
        }
        if (this.c == null) {
          this.c = this.jdField_b_of_type_Axql.a();
        }
        i = g(this.jdField_b_of_type_Axql.Fv, paramPtvTemplateInfo.id);
        if (i == -1)
        {
          if (!auF())
          {
            this.jdField_b_of_type_Axql.Fv.add(0, paramPtvTemplateInfo);
            this.c.Fv.add(0, paramPtvTemplateInfo);
            if (this.jdField_b_of_type_Anhn != null) {
              this.jdField_b_of_type_Anhn.notify(paramInt, new Object[] { this.c });
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
            }
            return;
          }
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_b_of_type_Axql.Fv.remove(99);
          this.jdField_b_of_type_Axql.Fv.add(0, paramPtvTemplateInfo);
          this.c.Fv.remove(localPtvTemplateInfo);
          this.c.Fv.add(0, paramPtvTemplateInfo);
          if (this.jdField_b_of_type_Anhn == null) {
            continue;
          }
          this.jdField_b_of_type_Anhn.notify(paramInt, new Object[] { this.c });
        }
      }
      if (i != 0)
      {
        this.jdField_b_of_type_Axql.Fv.remove(i);
        this.jdField_b_of_type_Axql.Fv.add(0, paramPtvTemplateInfo);
      }
    }
  }
  
  public ArrayList<axql> d(boolean paramBoolean)
  {
    ArrayList localArrayList = aw(dt());
    synchronized (this.gr)
    {
      if (this.jdField_b_of_type_Axql == null)
      {
        this.jdField_b_of_type_Axql = new axql(acfp.m(2131711235));
        this.jdField_b_of_type_Axql.Fv = new ArrayList(100);
      }
      if (paramBoolean) {
        b(this.jdField_b_of_type_Axql);
      }
      eL.set(true);
      this.c = c(this.jdField_b_of_type_Axql);
      localArrayList.add(0, this.c);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate needInitRecent: " + paramBoolean);
      }
      return localArrayList;
    }
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
  
  protected void dKh()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QIMPtvTemplateManager.3(this), ab.longValue());
  }
  
  public ArrayList<axql> dt()
  {
    ArrayList localArrayList = new ArrayList(this.Fu);
    if (!anjo.lC(dyy))
    {
      List localList = fW();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public void eIC()
  {
    eUx();
  }
  
  public void eIJ()
  {
    if (this.jdField_b_of_type_Axql == null) {}
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_b_of_type_Axql.Fv != null) && (this.jdField_b_of_type_Axql.Fv.isEmpty()));
        localStringBuilder = new StringBuilder();
        localObject1 = this.jdField_b_of_type_Axql.Fv.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject2).id))
          {
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).id).append("|");
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).categoryId).append("$");
          }
        }
      } while (TextUtils.isEmpty(localStringBuilder.toString()));
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences(this.cTx, 0);
      ((SharedPreferences)localObject2).edit().putString(this.cTy + (String)localObject1, localStringBuilder.toString());
      ((SharedPreferences)localObject2).edit().commit();
    } while (!QLog.isColorLevel());
    QLog.d("QIMPtvTemplateManager", 2, "saveRecentTemplate list=" + localStringBuilder.toString());
  }
  
  public void eUx()
  {
    File localFile = new File(aH, "ptv_template_new.cfg");
    if (!localFile.exists()) {}
    for (Runnable localRunnable = a(false);; localRunnable = a(localFile))
    {
      localRunnable.run();
      if (QLog.isDevelopLevel()) {
        QLog.d("QIMPtvTemplateManager", 4, new Object[] { "initTemplateConfig, cacheFile exists:", Boolean.valueOf(localFile.exists()), ", runnable:", Integer.valueOf(localRunnable.hashCode()) });
      }
      return;
    }
  }
  
  public List<axql> f(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    paramFile = p(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return null;
      paramFile = a(this, paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    Iterator localIterator = paramFile.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (axql)localIterator.next();
      if ((((axql)localObject).Fv != null) && (((axql)localObject).Fv.size() != 0))
      {
        localObject = ((axql)localObject).Fv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo != null) {
            localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
          }
        }
      }
    }
    dKh();
    return paramFile;
  }
  
  public List<axql> fW()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Fu.iterator();
    while (localIterator.hasNext())
    {
      axql localaxql = (axql)localIterator.next();
      if (localaxql.czY) {
        localArrayList.add(localaxql);
      }
    }
    return localArrayList;
  }
  
  public void hn(String paramString, int paramInt)
  {
    List localList = a(null, paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      QLog.d("QIMPtvTemplateManager", 1, "handleGetServerConfig no infos");
      return;
    }
    he(paramString, "ptv_template_new.cfg");
    a().notifyObservers(axrf.class, 3, true, null);
  }
  
  public void lW(List<axql> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = paramList.iterator();
    } while (!paramList.hasNext());
    Object localObject = (axql)paramList.next();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((axql)localObject).Fv);
    int i = 0;
    label63:
    if (i < localArrayList.size())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)localArrayList.get(i);
      if ((localObject != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject).predownload) && (!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).resurl))) {
        break label116;
      }
    }
    for (;;)
    {
      i += 1;
      break label63;
      break;
      label116:
      ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.4(this, (PtvTemplateManager.PtvTemplateInfo)localObject));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Axql = null;
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzs
 * JD-Core Version:    0.7.0.1
 */