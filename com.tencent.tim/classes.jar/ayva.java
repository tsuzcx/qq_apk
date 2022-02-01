import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.QIMRedDotConfig;
import dov.com.qq.im.capture.data.QIMRedDotConfig.RedDotItemConfig;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArrayList<Ldov.com.qq.im.capture.data.FilterCategory;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayva
{
  private static int ResExist;
  private static int ResFailed = -1;
  private static int ResGenerating;
  private static ayva a;
  public static QIMRedDotConfig b;
  public static final String bek = aywt.bei + "artfilter" + File.separator;
  private static final String cXY = aasa.SDCARD_PATH + "dov_capture_qsvf" + File.separator;
  private static boolean dBb;
  private static boolean dBc;
  public static Object ez;
  public static String lowLightDir;
  public static String lowLightPath;
  public static int mLowLightResStatus;
  public static HashMap<String, FilterDesc> rB = new HashMap();
  static int test;
  public axqc[] a;
  public QIMFilterCategoryItem[] a;
  private TransitionCategoryItem b;
  public QIMFilterCategoryItem[] b;
  private aygz c;
  public FilterDesc c;
  public QIMFilterCategoryItem[] c;
  private boolean dBa = true;
  private int eCJ = -1;
  private Bitmap ib;
  private int mFilterTextureFbo = -1;
  private int[] mFilterTextureId = { -1 };
  
  static
  {
    ez = new Object();
    test = 1300000;
    lowLightDir = aywt.bei + "lowlight";
    lowLightPath = lowLightDir + File.separator + "LowLight.png";
    ResExist = 2;
    ResGenerating = 1;
  }
  
  private ayva()
  {
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
    this.jdField_a_of_type_ArrayOfAxqc = new axqc[5];
    this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
    this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
  }
  
  public static void Om(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.update))
      {
        jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.update = false;
        QIMRedDotConfig.saveRedDotConfig(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig, aywt.bei);
      }
      return;
    }
    QIMRedDotConfig.saveRedDotConfig(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig, aywt.bei);
  }
  
  public static ayva.b a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    ayva.b localb = new ayva.b();
    paramBoolean1 = aRh();
    Object localObject1 = a(paramCopyOnWriteArrayList, 1, paramBoolean1);
    Object localObject3 = a(paramCopyOnWriteArrayList, 2, paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramCopyOnWriteArrayList = null;
    Object localObject2 = null;
    ArrayList localArrayList3 = new ArrayList();
    Object localObject4 = ((ArrayList)localObject1).iterator();
    FilterCategory localFilterCategory;
    Iterator localIterator;
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (FilterCategory)((Iterator)localObject4).next();
      localFilterCategory = new FilterCategory(((FilterCategory)localObject1).categoryId, ((FilterCategory)localObject1).categoryName, ((FilterCategory)localObject1).dvZ, ((FilterCategory)localObject1).dwa, ((FilterCategory)localObject1).eGF, ((FilterCategory)localObject1).mSourceType);
      localIterator = ((FilterCategory)localObject1).Fv.iterator();
      while (localIterator.hasNext())
      {
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        localObject1 = paramCopyOnWriteArrayList;
        if (localQIMFilterCategoryItem.auG())
        {
          localObject1 = paramCopyOnWriteArrayList;
          if (paramCopyOnWriteArrayList == null) {
            localObject1 = localQIMFilterCategoryItem;
          }
        }
        localQIMFilterCategoryItem = localQIMFilterCategoryItem.a();
        if (paramBoolean2)
        {
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
          if (!localQIMFilterCategoryItem.aPy()) {}
        }
        else
        {
          localFilterCategory.Fv.add(localQIMFilterCategoryItem);
          localArrayList1.add(localQIMFilterCategoryItem);
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
        }
      }
      localArrayList3.add(localFilterCategory);
    }
    localObject4 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    localObject1 = localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (FilterCategory)((Iterator)localObject3).next();
      localFilterCategory = new FilterCategory(((FilterCategory)localObject2).categoryId, ((FilterCategory)localObject2).categoryName, ((FilterCategory)localObject2).dvZ, ((FilterCategory)localObject2).dwa, ((FilterCategory)localObject2).eGF, ((FilterCategory)localObject2).mSourceType);
      localIterator = ((FilterCategory)localObject2).Fv.iterator();
      while (localIterator.hasNext())
      {
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        localObject2 = localObject1;
        if (localQIMFilterCategoryItem.auG())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localQIMFilterCategoryItem;
          }
        }
        localQIMFilterCategoryItem = localQIMFilterCategoryItem.a();
        if (paramBoolean2)
        {
          localObject1 = localObject2;
          if (!localQIMFilterCategoryItem.aPy()) {}
        }
        else
        {
          localFilterCategory.Fv.add(localQIMFilterCategoryItem);
          localArrayList1.add(localQIMFilterCategoryItem);
          localArrayList2.add(localQIMFilterCategoryItem);
          localObject1 = localObject2;
        }
      }
      ((ArrayList)localObject4).add(localFilterCategory);
    }
    localb.GE = localArrayList3;
    localb.GF = ((ArrayList)localObject4);
    localb.GG = localArrayList1;
    localb.filterList = localArrayList2;
    localb.g = paramCopyOnWriteArrayList;
    localb.h = ((QIMFilterCategoryItem)localObject1);
    return localb;
  }
  
  public static ayva a()
  {
    if (jdField_a_of_type_Ayva == null) {
      jdField_a_of_type_Ayva = new ayva();
    }
    return jdField_a_of_type_Ayva;
  }
  
  public static ArrayList<FilterCategory> a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((aRh()) && (paramBoolean))
    {
      i = 1;
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    }
    label525:
    label531:
    for (;;)
    {
      Object localObject;
      FilterCategory localFilterCategory;
      QIMFilterCategoryItem localQIMFilterCategoryItem;
      if (paramCopyOnWriteArrayList.hasNext())
      {
        localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
        if ((paramInt == 1) && (((FilterCategory)localObject).dvZ))
        {
          localFilterCategory = new FilterCategory(((FilterCategory)localObject).categoryId, ((FilterCategory)localObject).categoryName, ((FilterCategory)localObject).dvZ, ((FilterCategory)localObject).dwa, ((FilterCategory)localObject).eGF, ((FilterCategory)localObject).mSourceType);
          localFilterCategory.dvZ = true;
          localObject = ((FilterCategory)localObject).Fv.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if (((i != 0) || (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.c(localQIMFilterCategoryItem)))
              {
                localFilterCategory.Fv.add(localQIMFilterCategoryItem);
                continue;
                i = 0;
                break;
              }
            }
          }
          if (localFilterCategory.Fv.size() <= 0) {
            continue;
          }
          localObject = localFilterCategory.Fv.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((QIMFilterCategoryItem)((Iterator)localObject).next()).auG());
        }
      }
      for (int j = 0;; j = 1)
      {
        if (j != 0) {
          break label531;
        }
        localArrayList.add(localFilterCategory);
        break;
        if ((paramInt != 2) || (((FilterCategory)localObject).dvZ)) {
          break;
        }
        localFilterCategory = new FilterCategory(((FilterCategory)localObject).categoryId, ((FilterCategory)localObject).categoryName, ((FilterCategory)localObject).dvZ, ((FilterCategory)localObject).dwa, ((FilterCategory)localObject).eGF, ((FilterCategory)localObject).mSourceType);
        localFilterCategory.dvZ = false;
        localObject = ((FilterCategory)localObject).Fv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
          if (((i != 0) || (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.c(localQIMFilterCategoryItem))) {
            localFilterCategory.Fv.add(localQIMFilterCategoryItem);
          }
        }
        if (localFilterCategory.Fv.size() <= 0) {
          break;
        }
        localObject = localFilterCategory.Fv.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((QIMFilterCategoryItem)((Iterator)localObject).next()).auG());
        for (j = 0;; j = 1)
        {
          if (j != 0) {
            break label525;
          }
          localArrayList.add(localFilterCategory);
          break;
          if (QLog.isColorLevel())
          {
            paramCopyOnWriteArrayList = new StringBuilder(20);
            paramCopyOnWriteArrayList.append("getFilterCategory categoryType:").append(paramInt).append(" filter:");
            if (localArrayList != null) {
              break label508;
            }
            paramCopyOnWriteArrayList.append("null ");
          }
          for (;;)
          {
            QLog.d("VideoFilterTools", 2, paramCopyOnWriteArrayList.toString());
            return localArrayList;
            label508:
            paramCopyOnWriteArrayList.append(localArrayList.size());
          }
        }
        break;
      }
    }
  }
  
  public static boolean aRf()
  {
    if (dBc) {
      return dBb;
    }
    dBc = true;
    dBb = false;
    String str = Build.MODEL;
    if ((str.equals("ZTE BA610C")) || (str.equals("ZTE BA610T")) || (str.equals("vivo Y51A")) || (str.equals("vivo Y51")) || (str.equals("vivo Y37")) || (str.equals("OPPO A37t")) || (str.equals("OPPO A37m")) || (str.equals("SLA-TL10")) || (str.equals("SM-A5000")) || (str.equals("SM-A8000")) || (str.equals("HUAWEI GRA-TL00")) || (str.equals("OPPO A33m")) || (str.equals("OPPO A33")) || (str.equals("vivo X6A")) || (str.equals("CUN-AL00")) || (str.equals("Redmi 3")) || (str.equals("CAM-TL00")) || (str.equals("vivo Y35A")) || (str.equals("KIW-AL10")) || (str.equals("vivo Y31A")) || (str.equals("OPPO A53m")) || (str.equals("OPPO A53")) || (str.equals("OPPO R7sm")) || (str.equals("M6 Note")) || (str.equals("HUAWEI TIT-AL00")) || (str.equals("CUN-TL00")) || (str.equals("HUAWEI TIT-TL00")) || (str.equals("m2")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterTools", 2, "in TransitionBlackModel:" + str);
      }
      dBb = true;
    }
    return dBb;
  }
  
  public static boolean aRh()
  {
    boolean bool1 = QmcfManager.getInstance().hasQmcfEntrance(1);
    boolean bool2 = bool1;
    int i;
    if (bool1)
    {
      i = anjn.JJ();
      if (i <= 0) {
        break label79;
      }
    }
    label79:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        QmcfManager.getInstance().setQmcfMobileNotSupport(anjn.cen);
        QLog.d("VideoFilterTools", 1, String.format("isArtFilterSupport supportFrameType[%d], gpuinfo[%s], model[%s]", new Object[] { Integer.valueOf(i), anjn.cen, Build.MODEL }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public static void ae(Context paramContext, int paramInt)
  {
    jll.bl("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_config_version_775", paramInt);
    paramContext.commit();
  }
  
  public static int ak(Context paramContext)
  {
    int i = 0;
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_config_version_775", 0);
    if ((j > 0) && (!new File(aywt.bei + "filter_config_new.xml").exists())) {
      jll.bl("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      jll.bl("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  static ArrayList<FilterDesc> av(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      jll.bl("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      try
      {
        Object localObject = FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters"));
        paramString = (String)localObject;
        localObject = paramString;
        if (paramString == null) {
          localObject = new ArrayList();
        }
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        jll.bl("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
      paramString = null;
    }
  }
  
  public static String aw(Context paramContext)
  {
    try
    {
      File localFile = new File(aywt.bei + "filter_config_new.xml");
      jll.bl("VideoFilterTools", "getQQShortVideoFilterConfig:" + aywt.bei + "filter_config_new.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return aqhq.readFileToString(localFile);
      }
      ae(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void dKj()
  {
    if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
    {
      QIMRedDotConfig localQIMRedDotConfig = QIMRedDotConfig.getRedDotConfigFromFile(aywt.bei);
      if (localQIMRedDotConfig != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "VideoFilterTools reddot config init");
        }
        synchronized (ez)
        {
          jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig = localQIMRedDotConfig;
          return;
        }
      }
    }
  }
  
  private static boolean df(Context paramContext)
  {
    boolean bool = false;
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_first_change_path", 0);
    jll.bl("VideoFilterTools", "getIsfisrtChangePath:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void dw(Context paramContext, String paramString)
  {
    if (paramString == null) {
      jll.bl("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
    }
    do
    {
      return;
      if (df(BaseApplicationImpl.getContext()))
      {
        gL(BaseApplicationImpl.getContext());
        if (new File(cXY).exists()) {
          aqhq.cn(cXY);
        }
      }
      l(paramContext, paramString, aw(paramContext));
    } while (!oz(paramString));
    aqhq.z(aywt.bei, "filter_config_new.xml", paramString);
  }
  
  public static JSONArray g(List<FilterDesc> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("filterid", localFilterDesc.id + "");
        localJSONObject.put("type", localFilterDesc.type + "");
        localJSONObject.put("name", localFilterDesc.name);
        localJSONObject.put("respicname", localFilterDesc.respicname);
        localJSONObject.put("version", localFilterDesc.version);
        localJSONObject.put("md5", localFilterDesc.resMD5);
        localJSONObject.put("resurl", localFilterDesc.resurl);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      QLog.w("VideoFilterTools", 2, "convertFilterDesc" + paramList.toString());
      QLog.w("VideoFilterTools", 2, "convertFilterDesc json" + localJSONArray.toString());
    }
  }
  
  private static void gL(Context paramContext)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_first_change_path", 1);
    paramContext.commit();
  }
  
  private void generateLowlightRes()
  {
    File localFile = new File(lowLightPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          mLowLightResStatus = ResFailed;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("VideoFilterTools", 2, "LowLightTools saveBitmap:" + localException);
        }
        mLowLightResStatus = ResExist;
      }
    }
  }
  
  public static String getFileNameWithoutExtension(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  static void l(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals(""))) {}
    for (paramContext = av(paramString1);; paramContext = null)
    {
      paramString1 = localIterator;
      if (paramString2 != null)
      {
        paramString1 = localIterator;
        if (!paramString2.equals("")) {
          paramString1 = av(paramString2);
        }
      }
      if (paramContext == null) {
        aqhq.cn(aywt.bej);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        jll.bl("VideoFilterTools", "compareContent :" + (l2 - l1));
        return;
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                jll.bl("VideoFilterTools", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((!TextUtils.isEmpty(localFilterDesc.resMD5)) && (!localFilterDesc.resMD5.equals(paramString2.resMD5)))
                {
                  jll.bl("VideoFilterTools", "compareContentDelete res:" + paramString2.getResFold(aywt.bej));
                  aqhq.cn(paramString2.getResFold(aywt.bej));
                }
                jll.bl("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((!TextUtils.isEmpty(localFilterDesc.iconMD5)) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5)))
                {
                  jll.bl("VideoFilterTools", "compareContentDelete iconMD5:" + paramString2.getIconFile(aywt.bej));
                  aqhq.deleteFile(paramString2.getIconFile(aywt.bej));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mQIMRedDotConfig is null");
          }
          return false;
        }
        boolean bool = jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  public static void oW(List<QIMFilterCategoryItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      label13:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label13;
      }
      Object localObject1 = (QIMFilterCategoryItem)paramList.next();
      if (((QIMFilterCategoryItem)localObject1).za == null) {
        break;
      }
      localObject1 = ((QIMFilterCategoryItem)localObject1).za.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = a().a((String)localObject2);
        if ((localObject2 != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(((FilterDesc)localObject2).id))) {
          paramList.remove();
        }
      }
    }
  }
  
  public static boolean oz(String paramString)
  {
    label821:
    for (;;)
    {
      try
      {
        int i;
        synchronized (ez)
        {
          paramString = new JSONObject(paramString);
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig = new QIMRedDotConfig(1);
            if (QLog.isColorLevel()) {
              QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
            }
          }
          i = paramString.optInt("iconRedDotVersion");
          boolean bool = paramString.optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion + ",ver=" + i + ",showRed " + bool);
          }
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.showRedDot = bool;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasShow = false;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.firstShowTime = 0L;
          }
          i = paramString.optInt("combo_iconRedDotVersion");
          bool = paramString.optBoolean("combo_needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer combo oldVer=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion + ",ver=" + i + ",showRed " + bool);
          }
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboShowRedDot = bool;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasShow = false;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboFirstShowTime = 0L;
          }
          i = paramString.optInt("combo_defaultCategoryVersion");
          int j = paramString.optInt("combo_defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer + ",ver=" + i + ",comboDefaultCategoryId " + j);
          }
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId = j;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasChoose = false;
          }
          i = paramString.optInt("defaultCategoryVersion");
          j = paramString.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer + ",ver=" + i + ",defaultCategoryId " + j);
          }
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId = j;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose = false;
          }
          i = paramString.optInt("defaultUseVersion");
          Object localObject2 = paramString.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer + ",ver=" + i + ",defaultUseId " + (String)localObject2);
          }
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId = ((String)localObject2);
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasUse = false;
          }
          i = paramString.optInt("itemRedDotVersion");
          if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotVersion != i)
          {
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotVersion = i;
            jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotItems.clear();
            if (paramString.has("itemNeedRedDot"))
            {
              paramString = paramString.getJSONArray("itemNeedRedDot");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("updateFromServer redDotList: ");
              i = 0;
              if (i < paramString.length())
              {
                String str = paramString.optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label821;
                }
                QIMRedDotConfig.RedDotItemConfig localRedDotItemConfig = new QIMRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject2).append(str).append(",");
                jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label821;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
          Om(false);
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "updateComboConfig accept");
          }
          return true;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "updateRedDotConfigFromServer null", paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "updateRedDotConfigFromServer fail");
        }
        return false;
      }
    }
  }
  
  public void I(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig == null) {
          return;
        }
        if ((jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString)) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateRedDotInfo==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  public int Io()
  {
    synchronized (ez)
    {
      if ((jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultCategoryId=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
        }
        int i = jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public int Si()
  {
    synchronized (ez)
    {
      if ((jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultComboCategoryId=" + jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
        }
        int i = jdField_b_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public int Sj()
  {
    return this.eCJ;
  }
  
  public boolean Xp()
  {
    dKj();
    Object localObject = axwf.py("filter_template.cfg");
    try
    {
      localObject = new ayva.a((String)localObject);
      ((axpr)axov.a(5)).b((ayva.a)localObject);
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("VideoFilterTools", 2, "initFromAsset " + false, localException);
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoFilterTools", 2, "initFromAsset " + bool1);
    }
    return bool1;
  }
  
  public void ZP(boolean paramBoolean)
  {
    this.dBa = paramBoolean;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)rB.get(paramString);
  }
  
  public TransitionCategoryItem a()
  {
    return this.jdField_b_of_type_DovComQqImCaptureDataTransitionCategoryItem;
  }
  
  /* Error */
  public void a(Context paramContext, ayva.c paramc, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_5
    //   3: invokestatic 912	axov:a	(I)Laxon;
    //   6: checkcast 914	axpr
    //   9: astore 4
    //   11: aload 4
    //   13: getfield 936	axpr:a	Layva$a;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +44 -> 62
    //   21: ldc_w 269
    //   24: ldc_w 938
    //   27: invokestatic 396	jll:bl	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: ifnull +64 -> 95
    //   34: aload_1
    //   35: getfield 942	ayva$a:am	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   38: astore_1
    //   39: aload_2
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: iconst_0
    //   45: invokeinterface 945 2 0
    //   50: iload_3
    //   51: ifeq +8 -> 59
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 948	ayva:b	(Ljava/util/concurrent/CopyOnWriteArrayList;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: ldc_w 269
    //   65: ldc_w 950
    //   68: invokestatic 396	jll:bl	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getstatic 954	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   75: invokevirtual 957	ayva:bw	(Landroid/content/Context;)Z
    //   78: ifne +8 -> 86
    //   81: aload_0
    //   82: invokevirtual 959	ayva:Xp	()Z
    //   85: pop
    //   86: aload 4
    //   88: getfield 936	axpr:a	Layva$a;
    //   91: astore_1
    //   92: goto -62 -> 30
    //   95: new 240	java/util/concurrent/CopyOnWriteArrayList
    //   98: dup
    //   99: invokespecial 960	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   102: astore_1
    //   103: goto -64 -> 39
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ayva
    //   0	111	1	paramContext	Context
    //   0	111	2	paramc	ayva.c
    //   0	111	3	paramBoolean	boolean
    //   9	78	4	localaxpr	axpr
    // Exception table:
    //   from	to	target	type
    //   2	17	106	finally
    //   21	30	106	finally
    //   34	39	106	finally
    //   43	50	106	finally
    //   54	59	106	finally
    //   59	61	106	finally
    //   62	86	106	finally
    //   86	92	106	finally
    //   95	103	106	finally
    //   107	109	106	finally
  }
  
  public void a(axqc paramaxqc, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfAxqc[2] = paramaxqc;
      this.jdField_a_of_type_ArrayOfAxqc[1] = paramaxqc;
    }
    while (paramInt != -1)
    {
      this.jdField_a_of_type_ArrayOfAxqc[paramInt] = paramaxqc;
      return;
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramQIMFilterCategoryItem;
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] = paramQIMFilterCategoryItem;
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] = paramQIMFilterCategoryItem;
    }
    while (paramInt != -1)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
      paramActivity = paramQIMFilterCategoryItem;
      if (localQIMFilterCategoryItem != null)
      {
        paramActivity = paramQIMFilterCategoryItem;
        if (paramQIMFilterCategoryItem != null)
        {
          paramActivity = paramQIMFilterCategoryItem;
          if (TextUtils.equals(localQIMFilterCategoryItem.id, paramQIMFilterCategoryItem.id)) {
            paramActivity = localQIMFilterCategoryItem;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedCombo last:" + localQIMFilterCategoryItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramActivity;
      if ((paramActivity != null) && (!paramActivity.auG())) {
        I(3, paramActivity.categoryId, paramActivity.id);
      }
      return;
    }
  }
  
  public void a(TransitionCategoryItem paramTransitionCategoryItem)
  {
    this.jdField_b_of_type_DovComQqImCaptureDataTransitionCategoryItem = paramTransitionCategoryItem;
  }
  
  public boolean aRg()
  {
    return this.dBa;
  }
  
  public void afK(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "setFrontCaptureScene " + paramInt);
    }
    this.eCJ = paramInt;
  }
  
  public void as(Bitmap paramBitmap)
  {
    if (this.ib != null)
    {
      this.ib.recycle();
      this.ib = null;
    }
    try
    {
      this.ib = paramBitmap.copy(paramBitmap.getConfig(), true);
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap exception!", paramBitmap.toString() });
      return;
    }
    catch (Error paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap error!", paramBitmap.toString() });
    }
  }
  
  public aygz b()
  {
    if (this.jdField_c_of_type_Aygz == null) {}
    return this.jdField_c_of_type_Aygz;
  }
  
  public QIMFilterCategoryItem b(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public void b(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "setSelectedFilter " + paramQIMFilterCategoryItem + " scene " + paramInt);
    }
    if (paramInt == -1) {}
    do
    {
      return;
      paramActivity = this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
      this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramQIMFilterCategoryItem;
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedFilter last:" + paramActivity);
      }
    } while ((paramQIMFilterCategoryItem == null) || (paramQIMFilterCategoryItem.auG()));
    I(3, paramQIMFilterCategoryItem.categoryId, paramQIMFilterCategoryItem.id);
  }
  
  void b(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    label20:
    axpr localaxpr;
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() == 0))
    {
      jll.bl("VideoFilterTools", "preDownloadResource list is empty!");
      return;
    }
    else
    {
      jll.bl("VideoFilterTools", " preDownloadResource Categorylist size: " + paramCopyOnWriteArrayList.size());
      localaxpr = (axpr)axov.a(5);
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    }
    for (;;)
    {
      if (!paramCopyOnWriteArrayList.hasNext()) {
        break label20;
      }
      Object localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
      if (((FilterCategory)localObject).dvZ) {
        break;
      }
      localObject = ((FilterCategory)localObject).Fv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        axqf localaxqf = localaxpr.a((QIMFilterCategoryItem)((Iterator)localObject).next());
        if ((localaxqf.aPw()) && (localaxqf.getState() == 2)) {
          localaxqf.Rq();
        }
      }
    }
  }
  
  public Bitmap bc()
  {
    if ((this.ib == null) || (this.ib.isRecycled()))
    {
      Bitmap localBitmap = null;
      if (this.jdField_c_of_type_Aygz != null) {
        localBitmap = this.jdField_c_of_type_Aygz.W();
      }
      if (localBitmap != null) {
        this.ib = localBitmap.copy(localBitmap.getConfig(), true);
      }
    }
    return this.ib;
  }
  
  public boolean bw(Context paramContext)
  {
    bool2 = false;
    dKj();
    paramContext = aw(paramContext);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        paramContext = new ayva.a(paramContext);
        ((axpr)axov.a(5)).b(paramContext);
        bool1 = paramContext.am.isEmpty();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("VideoFilterTools", 2, "initFromCache", paramContext);
        bool1 = bool2;
        continue;
        bool1 = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoFilterTools", 2, "initFromCache " + bool1);
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public QIMFilterCategoryItem c(int paramInt)
  {
    return this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public QIMFilterCategoryItem d(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public void e(PublishVideoEntry paramPublishVideoEntry)
  {
    QLog.w("VideoFilterTools", 2, "saveRenderManagerData begin");
    if (paramPublishVideoEntry != null)
    {
      Object localObject = awte.a(awte.eCS);
      if (localObject != null)
      {
        List localList = ((QQFilterRenderManager)localObject).getBusinessOperation().getCurrentAVFilterIdList();
        if ((localList != null) && (localList.size() > 0))
        {
          paramPublishVideoEntry.putExtra("hasAVFilter", Boolean.valueOf(true));
          paramPublishVideoEntry.putExtra("jsonAVFilterData", g(localList));
          localObject = ((QQFilterRenderManager)localObject).getBusinessOperation().getMusicItemInfo();
          if (localObject != null) {
            paramPublishVideoEntry.putExtra("jsonMusicData", ((MusicItemInfo)localObject).convertToJSON());
          }
        }
      }
    }
  }
  
  public void eTO()
  {
    this.jdField_c_of_type_Aygz = null;
    if (this.ib != null)
    {
      this.ib.recycle();
      this.ib = null;
    }
  }
  
  public void k(aygz paramaygz)
  {
    if (paramaygz == null) {}
    this.jdField_c_of_type_Aygz = paramaygz;
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null) {
      jll.bl("VideoFilterTools", "setCurrentId id: " + paramFilterDesc.id);
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      return;
      jll.bl("VideoFilterTools", "setCurrentId null");
    }
  }
  
  public static class a
  {
    CopyOnWriteArrayList<FilterCategory> am;
    public ayva.b b = new ayva.b();
    public ayva.b c = new ayva.b();
    public ayva.b d = new ayva.b();
    String mContent;
    public HashMap<String, LockedCategory> rs = new HashMap();
    
    public a(String paramString)
      throws JSONException
    {
      this.mContent = paramString;
      this.am = e(paramString);
      this.b = ayva.a(this.am, true, false);
      this.c = ayva.a(this.am, false, true);
      this.d = ayva.a(this.am, false, false);
    }
    
    private TransitionCategoryItem a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {
      TransitionCategoryItem localTransitionCategoryItem = new TransitionCategoryItem();
      localTransitionCategoryItem.id = (paramInt1 + "");
      localTransitionCategoryItem.name = paramString1;
      localTransitionCategoryItem.iconUrl = paramString4;
      localTransitionCategoryItem.apngUrl = paramString3;
      localTransitionCategoryItem.categoryId = paramInt2;
      localTransitionCategoryItem.za = new ArrayList(1);
      localTransitionCategoryItem.za.add(paramString2);
      localTransitionCategoryItem.transId = paramString5;
      localTransitionCategoryItem.cVN = paramString7;
      localTransitionCategoryItem.themeId = paramString8;
      localTransitionCategoryItem.cVO = paramString6;
      return localTransitionCategoryItem;
    }
    
    private void a(ayva.b paramb1, ayva.b paramb2)
    {
      int j = 0;
      Object localObject1 = (awrz)axov.a(13);
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < paramb1.GE.size())
      {
        if (!((awrz)localObject1).nW(((FilterCategory)paramb1.GE.get(i)).eGF)) {
          localArrayList1.add(paramb1.GE.get(i));
        }
        i += 1;
      }
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = (ArrayList)paramb1.filterList.clone();
      i = j;
      Object localObject2;
      if (i < paramb1.GF.size())
      {
        if (!((awrz)localObject1).nW(((FilterCategory)paramb1.GF.get(i)).eGF)) {
          localArrayList2.add(paramb1.GF.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((FilterCategory)paramb1.GF.get(i)).Fv.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!localQIMFilterCategoryItem.equals(paramb1.h)) {
              localArrayList3.remove(localQIMFilterCategoryItem);
            }
          }
        }
      }
      localArrayList2 = (ArrayList)localArrayList2.clone();
      localArrayList3 = (ArrayList)localArrayList3.clone();
      if (((awrz)localObject1).aNx())
      {
        localObject1 = localArrayList2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FilterCategory)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((FilterCategory)localObject2).mSourceType != 1)) {
            ((Iterator)localObject1).remove();
          }
        }
        localObject1 = localArrayList3.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((QIMFilterCategoryItem)localObject2).sourceType != 1)) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      paramb2.GE = localArrayList1;
      paramb2.GF = localArrayList2;
      paramb2.filterList = localArrayList3;
      paramb2.GG = paramb1.GG;
      paramb2.g = paramb1.g;
      paramb2.h = paramb1.h;
    }
    
    public ayva.b a(int paramInt)
    {
      ayva.b localb2 = new ayva.b();
      ayva.b localb1 = this.b;
      switch (paramInt)
      {
      }
      for (;;)
      {
        a(localb1, localb2);
        return localb2;
        localb1 = this.c;
        continue;
        localb1 = this.d;
        continue;
        localb1 = this.b;
      }
    }
    
    public TransitionCategoryItem b()
    {
      if (ayva.aRf()) {
        return a(5, acfp.m(2131716381), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic");
      }
      return a(4, acfp.m(2131716392), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
    }
    
    public void c(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
    {
      axpz localaxpz = ((axpr)axov.a(5)).a();
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
      while (paramCopyOnWriteArrayList.hasNext())
      {
        FilterCategory localFilterCategory = (FilterCategory)paramCopyOnWriteArrayList.next();
        if (localFilterCategory.dwa)
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)localFilterCategory.Fv.remove(0);
          Object localObject1 = new LinkedList();
          Object localObject2 = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          Iterator localIterator = localFilterCategory.Fv.iterator();
          while (localIterator.hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)localIterator.next();
            if (localaxpz.ui(localQIMFilterCategoryItem2.id))
            {
              ((List)localObject1).add(localQIMFilterCategoryItem2);
            }
            else
            {
              ayva.a();
              if (ayva.needShowRedDot(3, localQIMFilterCategoryItem2.categoryId, localQIMFilterCategoryItem2.id)) {
                ((List)localObject2).add(localQIMFilterCategoryItem2);
              } else {
                localLinkedList.add(localQIMFilterCategoryItem2);
              }
            }
          }
          Collections.shuffle(localLinkedList);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject2).next());
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject1).next());
          }
          localLinkedList.add(0, localQIMFilterCategoryItem1);
          localFilterCategory.Fv = localLinkedList;
        }
      }
    }
    
    public CopyOnWriteArrayList<FilterCategory> e(String paramString)
      throws JSONException
    {
      int j = 0;
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      paramString = new JSONObject(paramString);
      Object localObject1 = FilterDesc.parse(paramString.getJSONArray("filters")).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FilterDesc)((Iterator)localObject1).next();
        ayva.rB.put(((FilterDesc)localObject2).name, localObject2);
      }
      localObject1 = paramString.getJSONArray("categorys");
      Object localObject2 = new ArrayList(((JSONArray)localObject1).length());
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        ((ArrayList)localObject2).add(new FilterCategory(((JSONArray)localObject1).getJSONObject(i), null));
        i += 1;
      }
      localCopyOnWriteArrayList.clear();
      localCopyOnWriteArrayList.addAll((Collection)localObject2);
      ((axpr)axov.a(5)).aC((List)localObject2);
      paramString = paramString.optJSONArray("locked_categorys");
      if (paramString != null)
      {
        i = j;
        while (i < paramString.length())
        {
          localObject2 = paramString.optJSONObject(i);
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).optString("comboId");
            localObject2 = new LockedCategory((JSONObject)localObject2);
            this.rs.put(localObject1, localObject2);
          }
          i += 1;
        }
      }
      return localCopyOnWriteArrayList;
    }
    
    public ArrayList<FilterCategory> eR()
    {
      boolean bool = ayva.aRf();
      ArrayList localArrayList1 = new ArrayList(2);
      FilterCategory localFilterCategory = new FilterCategory(1001, acfp.m(2131716378), false, false, 0, 0);
      ArrayList localArrayList2 = new ArrayList(15);
      if (!bool) {
        localArrayList2.add(a(4, acfp.m(2131716397), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
      }
      localArrayList2.add(a(-1, acfp.m(2131716393), 103, "tran_no", null, "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_no_static.png", "NoEffect", "1", "2", "Basic"));
      if (!bool)
      {
        localArrayList2.add(a(12, acfp.m(2131716396), 103, "tran_reverse", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn_static.png", "Flipping", "1", "12", "Basic"));
        localArrayList2.add(a(13, acfp.m(2131716383), 103, "tran_recombine", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix_static.png", "Recombination", "1", "13", "Basic"));
        localArrayList2.add(a(1, acfp.m(2131716389), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "3", "Basic"));
        localArrayList2.add(a(10, acfp.m(2131716400), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "1", "4", "Basic"));
        localArrayList2.add(a(11, acfp.m(2131716387), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "1", "5", "Basic"));
        String str = Build.MODEL;
        if ((str != null) && (!str.equals("MI NOTE LTE")) && (!str.equals("R7Plusm")) && (!str.equals("vivo X5M")) && (!str.equals("SLA-AL00")) && (!str.equals("vivo Y71A")) && (!str.equals("vivo Y66i A")) && (!str.equals("Redmi 4A")) && (!str.equals("vivo X6Plus A")) && (!str.equals("vivo Y31")) && (!str.equals("SCL-AL00")) && (!str.equals("2014813")) && (!str.equals("Redmi Note 5A")) && (!str.equals("A31"))) {
          localArrayList2.add(a(3, acfp.m(2131716382), 103, "tran_speed", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed_static.png", "speedLine", "1", "6", "Basic"));
        }
      }
      localArrayList2.add(a(9, acfp.m(2131716384), 103, "tran_slip", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip_static.png", "sideSlip", "1", "7", "Basic"));
      localArrayList2.add(a(8, acfp.m(2131716398), 103, "tran_light", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut_static.png", "flashOut", "1", "8", "Basic"));
      localArrayList2.add(a(5, acfp.m(2131716401), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic"));
      localArrayList2.add(a(6, acfp.m(2131716394), 103, "tran_zoom", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "10", "Basic"));
      localArrayList2.add(a(7, acfp.m(2131716380), 103, "tran_wipe", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "11", "Basic"));
      localFilterCategory.Fv = localArrayList2;
      localArrayList1.add(localFilterCategory);
      return localArrayList1;
    }
    
    public ArrayList<QIMFilterCategoryItem> eS()
    {
      ArrayList localArrayList = new ArrayList(10);
      if (!ayva.aRf())
      {
        localArrayList.add(a(1, acfp.m(2131716379), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "3", "Basic"));
        localArrayList.add(a(10, acfp.m(2131716395), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "0", "4", "Basic"));
        localArrayList.add(a(11, acfp.m(2131716399), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "0", "5", "Basic"));
      }
      return localArrayList;
    }
    
    public void eTP()
    {
      c(this.am);
      this.b = ayva.a(this.am, true, false);
      this.c = ayva.a(this.am, false, true);
      this.d = ayva.a(this.am, false, false);
    }
  }
  
  public static class b
  {
    public ArrayList<FilterCategory> GE = new ArrayList();
    public ArrayList<FilterCategory> GF = new ArrayList();
    public ArrayList<QIMFilterCategoryItem> GG = new ArrayList();
    public ArrayList<QIMFilterCategoryItem> filterList = new ArrayList();
    public QIMFilterCategoryItem g;
    public QIMFilterCategoryItem h;
  }
  
  public static abstract interface c
  {
    public abstract void CT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayva
 * JD-Core Version:    0.7.0.1
 */