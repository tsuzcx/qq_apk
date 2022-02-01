import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.1;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;
import dov.com.qq.im.capture.data.TemplateData;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axpx
  extends axon
{
  public static final File bk = new File(new File(aasa.SDCARD_PATH), "capture_template");
  public static final String cVG = aasa.SDCARD_PATH + "capture_template" + File.separator;
  public static final String cVH = cVG + "resource" + File.separator;
  public static final String cVI = cVG + "capture_res" + File.separator;
  private axpx.a a;
  public axqm[] a;
  public QIMTemplateItem[] a;
  CopyOnWriteArrayList<TemplateData> az;
  public axqm b;
  public Bitmap hq;
  String mContent;
  private boolean mInited;
  
  public axpx()
  {
    this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem = new QIMTemplateItem[5];
    this.jdField_a_of_type_ArrayOfAxqm = new axqm[5];
  }
  
  private boolean P(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          paramString1 = aqhq.px(paramString1.getPath());
          if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(paramString2))) {
            return true;
          }
        }
        catch (UnsatisfiedLinkError paramString1) {}
      }
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
  }
  
  public static boolean aPv()
  {
    boolean bool = new File(cVG + "template_config.xml").exists();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 1, "getQQShortVideoFilterConfig:" + cVG + "template_config.xml" + "|" + bool);
    }
    return bool;
  }
  
  public static void adi(String paramString)
  {
    boolean bool = true;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTemplateManager", 2, "updateTemplateConfig error: " + paramString);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("showQAEntrance") != 1) {
          continue;
        }
        psr.sj(bool);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      aqhq.z(cVG, "template_config.xml", paramString);
      return;
      bool = false;
    }
  }
  
  private void af(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ThreadManager.excute(new CaptureTemplateManager.2(this, paramString2, paramString4, paramString1), 128, null, true);
  }
  
  private static String bU(Context paramContext)
  {
    try
    {
      File localFile = new File(cVG + "template_config.xml");
      jll.bl("CaptureTemplateManager", "getQQShortVideoFilterConfig:" + cVG + "template_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return aqhq.readFileToString(localFile);
      }
      aqmj.aK(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
      return null;
    }
    catch (IOException paramContext)
    {
      ram.e("CaptureTemplateManager", paramContext.toString());
    }
    return null;
  }
  
  private void deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private void eNP()
  {
    label17:
    Iterator localIterator;
    if ((this.az == null) || (this.az.size() <= 0)) {
      return;
    } else {
      localIterator = this.az.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label17;
      }
      Object localObject = (TemplateData)localIterator.next();
      if ((((TemplateData)localObject).Fv == null) || (((TemplateData)localObject).Fv.size() <= 0)) {
        break;
      }
      String str = ((TemplateData)localObject).cVM;
      localObject = ((TemplateData)localObject).Fv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)((Iterator)localObject).next();
        if ((localQIMTemplateItem.id.equals(str)) && (!P(localQIMTemplateItem.localVideoPath, localQIMTemplateItem.videoMd5)) && (!TextUtils.isEmpty(localQIMTemplateItem.videoUrl))) {
          af(localQIMTemplateItem.videoUrl, localQIMTemplateItem.localVideoPath, localQIMTemplateItem.id, localQIMTemplateItem.videoMd5);
        }
      }
    }
  }
  
  public static void eNQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 2, "deleteTemplateConfig");
    }
    File localFile = new File(cVG + "template_config.xml");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public final axqm a()
  {
    return this.b;
  }
  
  public QIMTemplateItem a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
  }
  
  public void a(axqm paramaxqm, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfAxqm[2] = paramaxqm;
      if (this.jdField_a_of_type_ArrayOfAxqm[1] != null) {}
      this.jdField_a_of_type_ArrayOfAxqm[1] = paramaxqm;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    this.jdField_a_of_type_ArrayOfAxqm[paramInt] = paramaxqm;
  }
  
  public void a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, int paramInt)
  {
    axpr localaxpr = (axpr)axov.a(5);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] = paramQIMTemplateItem;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] = paramQIMTemplateItem;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    QIMTemplateItem localQIMTemplateItem = this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
    paramActivity = paramQIMTemplateItem;
    if (localQIMTemplateItem != null)
    {
      localaxpr.a(localQIMTemplateItem);
      if (paramQIMTemplateItem != null) {
        break label176;
      }
      paramActivity = paramQIMTemplateItem;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedTemplate last:" + localQIMTemplateItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt] = paramActivity;
      if ((paramActivity == null) || (paramActivity.auG())) {
        break;
      }
      return;
      label176:
      paramActivity = paramQIMTemplateItem;
      if (TextUtils.equals(localQIMTemplateItem.id, paramQIMTemplateItem.id)) {
        paramActivity = localQIMTemplateItem;
      }
    }
  }
  
  public boolean a(axqm paramaxqm, int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramaxqm != null)
    {
      axqm localaxqm = this.jdField_a_of_type_ArrayOfAxqm[paramInt];
      boolean bool1 = bool3;
      if (localaxqm != null)
      {
        bool1 = bool3;
        if (paramaxqm.getUniqueId().equals(localaxqm.getUniqueId())) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 2, "isApplying :" + paramaxqm);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean aD(List<TemplateData> paramList)
  {
    ram.d("CaptureTemplateManager", "preInitCombo: " + paramList.size());
    axpr localaxpr = (axpr)axov.a(5);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      TemplateData localTemplateData = (TemplateData)paramList.next();
      if (localTemplateData.Fv == null) {
        break label244;
      }
      Iterator localIterator = localTemplateData.Fv.iterator();
      if (localIterator.hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)localIterator.next();
        axqm localaxqm;
        if (localTemplateData.dvZ)
        {
          localaxqm = localaxpr.a(localQIMTemplateItem);
          localaxqm.outState = localaxqm.getState();
          if (localaxqm.outState == 1)
          {
            localaxqm.eGB = ((int)(10000.0F * localaxqm.getProgress()));
            ram.d("CaptureTemplateManager", "preInitCombo progress: " + localQIMTemplateItem.name + ", progress: " + localaxqm.eGB);
            bool = true;
          }
        }
        for (;;)
        {
          break;
          if (localaxqm.outState != 2) {
            if (localaxqm.outState == 3) {
              localaxqm.eGB = 10000;
            }
          }
        }
      }
    }
    label244:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public Bitmap aW()
  {
    return this.hq;
  }
  
  public void aq(Bitmap paramBitmap)
  {
    this.hq = paramBitmap;
  }
  
  public boolean bw(Context paramContext)
  {
    bool2 = false;
    paramContext = bU(paramContext);
    bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        this.mContent = paramContext;
        this.az = d(paramContext);
        boolean bool3 = this.az.isEmpty();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ram.e("CaptureTemplateManager", "initFromCache", paramContext);
        bool1 = bool2;
      }
    }
    ram.d("CaptureTemplateManager", "initFromCache " + bool1);
    return bool1;
  }
  
  public CopyOnWriteArrayList<TemplateData> d(String paramString)
    throws JSONException
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString).getJSONArray("categorys");
    ArrayList localArrayList = new ArrayList(paramString.length());
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(new TemplateData(paramString.getJSONObject(i)));
      i += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll(localArrayList);
    ((axpr)axov.a(5)).eNK();
    aD(localArrayList);
    return localCopyOnWriteArrayList;
  }
  
  public void d(axqm paramaxqm)
  {
    this.b = paramaxqm;
  }
  
  public void eNO()
  {
    if (this.mInited) {
      return;
    }
    this.mInited = true;
    loadConfig();
  }
  
  public void loadConfig()
  {
    if ((this.az == null) || (this.az.size() <= 0)) {
      bw(BaseApplicationImpl.sApplication);
    }
    eNP();
    if (this.jdField_a_of_type_Axpx$a != null) {
      this.jdField_a_of_type_Axpx$a.bN(this.az);
    }
  }
  
  public void onDestroy() {}
  
  public void onInit()
  {
    ThreadManager.post(new CaptureTemplateManager.1(this), 8, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void bN(List<TemplateData> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axpx
 * JD-Core Version:    0.7.0.1
 */