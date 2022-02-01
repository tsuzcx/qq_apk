import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.1;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.2;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class adio
{
  private static String btt = "";
  long TC;
  long TD;
  long TE;
  long TF;
  long TG;
  long TH;
  long TI;
  long TJ;
  private adjd a;
  String bsO = null;
  int cHb;
  int cHc;
  AppInterface mAppInterface;
  private Context mContext;
  long mEndTime;
  Object mLock = new Object();
  int mResult;
  long mStartTime;
  int mType;
  private ArrayList<ArCloudConfigInfo> uv;
  
  public adio(AppInterface paramAppInterface, Context paramContext)
  {
    btt = adiz.sl();
    this.uv = new ArrayList();
    this.a = new adjd(paramAppInterface);
    this.mAppInterface = paramAppInterface;
    this.mContext = paramContext;
  }
  
  private void Gk(boolean paramBoolean)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
    long l = System.currentTimeMillis();
    File[] arrayOfFile = new File(sB()).listFiles();
    if (arrayOfFile == null) {}
    label413:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= arrayOfFile.length) {
          break label413;
        }
        Object localObject1 = arrayOfFile[i];
        if ((((int)((l - ((File)localObject1).lastModified()) / 86400000L) > 7) || (paramBoolean)) && (((File)localObject1).getName().endsWith("_config.dat")))
        {
          ArCloudConfigInfo localArCloudConfigInfo = adjg.a(sB(), ((File)localObject1).getName());
          if (localArCloudConfigInfo == null) {
            break;
          }
          a(localArCloudConfigInfo);
          ((File)localObject1).delete();
          if (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
          {
            localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            Object localObject2;
            if (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
            {
              localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
              if (((File)localObject1).exists()) {
                ((File)localObject1).delete();
              }
              localObject1 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator);
              if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
              {
                localObject2 = ((File)localObject1).listFiles();
                if (localObject2 != null)
                {
                  int j = 0;
                  while (j < localObject2.length)
                  {
                    localObject2[j].delete();
                    j += 1;
                  }
                }
                ((File)localObject1).delete();
              }
            }
            if ((localArCloudConfigInfo.uk != null) && (localArCloudConfigInfo.uk.size() > 0))
            {
              localObject1 = localArCloudConfigInfo.uk.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
                localObject2 = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + ((ArVideoResourceInfo)localObject2).videoMd5 + "_model.zip");
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(adhh paramadhh, adio.a parama, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerModelResources");
    Object localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue);
    cRK();
    this.mStartTime = System.currentTimeMillis();
    this.bsO = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc;
    if ((!((File)localObject1).exists()) && (!paramArCloudConfigInfo.aef()))
    {
      localObject1 = new adja.b();
      ((adja.b)localObject1).type = 2;
      ((adja.b)localObject1).url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bud;
      ((adja.b)localObject1).md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc;
      this.TC = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.Uq / 8192L);
      ((adja.b)localObject1).fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.Uq;
      ((adja.b)localObject1).fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue;
      ((adja.b)localObject1).bNI = false;
      this.mType = paramArCloudConfigInfo.type;
      this.TJ += this.TC;
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.ael()))
    {
      localObject1 = new File(btt + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu + File.separator);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "offlie  " + jpe.dO(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu));
      if ((!((File)localObject1).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu)))
      {
        localObject1 = new adja.b();
        ((adja.b)localObject1).type = 4;
        ((adja.b)localObject1).url = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Adbm != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF).exists())
      {
        localObject1 = new adja.b();
        ((adja.b)localObject1).type = 7;
        ((adja.b)localObject1).url = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brD;
        ((adja.b)localObject1).md5 = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE;
        ((adja.b)localObject1).fileSize = paramArCloudConfigInfo.jdField_a_of_type_Adbm.RR;
        ((adja.b)localObject1).fileName = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF;
        ((adja.b)localObject1).bNI = true;
        localArrayList.add(localObject1);
      }
    }
    else
    {
      if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO)) && (!new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO).exists()))
      {
        localObject1 = new adja.b();
        ((adja.b)localObject1).type = 6;
        ((adja.b)localObject1).url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btM;
        ((adja.b)localObject1).md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN;
        ((adja.b)localObject1).fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.Up;
        ((adja.b)localObject1).fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO;
        ((adja.b)localObject1).bNI = true;
        localArrayList.add(localObject1);
      }
      if ((paramArCloudConfigInfo.type != 0) && (paramArCloudConfigInfo.type != 100) && (paramArCloudConfigInfo.type != 7) && (paramArCloudConfigInfo.type != 8)) {
        break label1066;
      }
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        break label1360;
      }
    }
    Object localObject2;
    label1066:
    label1325:
    label1360:
    for (localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);; localObject2 = null)
    {
      Iterator localIterator = null;
      Object localObject3 = localIterator;
      if (localObject1 != null)
      {
        localObject3 = localIterator;
        if (((File)localObject1).exists()) {
          localObject3 = alab.getFileMD5String(((File)localObject1).getAbsolutePath());
        }
      }
      if ((localObject1 != null) && (((File)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum))) {}
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
            adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator);
            parama.a(true, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            if ((parama != null) && ((paramArCloudConfigInfo.aef()) || (paramArCloudConfigInfo.aeg()))) {
              parama.cRY();
            }
            if (localArrayList.size() <= 0) {
              break label1325;
            }
            this.a.a(localArrayList, new adip(this, parama, paramArCloudConfigInfo, paramadhh));
            return;
          }
          catch (Exception paramadhh)
          {
            new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName).delete();
            QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
            parama.a(false, 3, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
            parama.a(false, paramArCloudConfigInfo);
            return;
          }
          try
          {
            adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF, adiz.jN(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE));
          }
          catch (Exception localException) {}
        }
        break;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localObject2 = new adja.b();
          ((adja.b)localObject2).type = 3;
          ((adja.b)localObject2).url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
          ((adja.b)localObject2).md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
          this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
          ((adja.b)localObject2).fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
          this.TJ += this.TF;
          this.TH = System.currentTimeMillis();
          ((adja.b)localObject2).fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
          ((adja.b)localObject2).bNI = true;
          localArrayList.add(localObject2);
          continue;
          if ((paramArCloudConfigInfo.uk != null) && (paramArCloudConfigInfo.uk.size() > 0))
          {
            localObject3 = new ArrayList();
            localIterator = paramArCloudConfigInfo.uk.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.videoType != 4)
              {
                File localFile = new File(localArVideoResourceInfo.bus);
                localObject2 = null;
                if (localFile.exists()) {
                  localObject2 = alab.getFileMD5String(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localArVideoResourceInfo.videoMd5))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.videoUrl)))
                {
                  localObject2 = new adja.b();
                  ((adja.b)localObject2).type = 3;
                  ((adja.b)localObject2).url = localArVideoResourceInfo.videoUrl;
                  ((adja.b)localObject2).md5 = localArVideoResourceInfo.videoMd5;
                  this.TF = (localArVideoResourceInfo.videoSize / 8192L);
                  ((adja.b)localObject2).fileSize = localArVideoResourceInfo.videoSize;
                  this.TJ += this.TF;
                  this.TH = System.currentTimeMillis();
                  ((adja.b)localObject2).fileName = localArVideoResourceInfo.bus;
                  ((adja.b)localObject2).bNI = false;
                  localArrayList.add(localObject2);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.videoUrl);
                }
              }
            }
          }
        }
      }
      parama.a(true, paramArCloudConfigInfo);
      if (paramArCloudConfigInfo.cFe != 1) {
        a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc, paramadhh);
      }
      b(paramArCloudConfigInfo);
      return;
    }
  }
  
  private void a(adio.a parama, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.ael()) && (!new File(btt + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu)))
    {
      localObject1 = new adja.b();
      ((adja.b)localObject1).type = 4;
      ((adja.b)localObject1).url = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Adbm != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF).exists())
      {
        localObject1 = new adja.b();
        ((adja.b)localObject1).type = 7;
        ((adja.b)localObject1).url = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brD;
        ((adja.b)localObject1).md5 = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE;
        ((adja.b)localObject1).fileSize = paramArCloudConfigInfo.jdField_a_of_type_Adbm.RR;
        ((adja.b)localObject1).fileName = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF;
        ((adja.b)localObject1).bNI = true;
        localArrayList.add(localObject1);
      }
    }
    else if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO)))
    {
      if (new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO).exists()) {
        break label967;
      }
      localObject1 = btt + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN + "_model.zip";
      if (!new File((String)localObject1).exists()) {
        break label894;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        adjg.fn((String)localObject1, adiz.sC());
        if ((paramArCloudConfigInfo.type == 0) || (paramArCloudConfigInfo.type == 7) || (paramArCloudConfigInfo.type == 8))
        {
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
            break label1594;
          }
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
          localIterator = null;
          localObject3 = localIterator;
          if (localObject1 != null)
          {
            localObject3 = localIterator;
            if (((File)localObject1).exists()) {
              localObject3 = alab.getFileMD5String(((File)localObject1).getAbsolutePath());
            }
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum))) {
            break label1024;
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
            adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator);
            parama.b(true, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
            if ((paramArCloudConfigInfo.uk == null) || (paramArCloudConfigInfo.uk.size() <= 0)) {
              break label1540;
            }
            localObject3 = new ArrayList();
            Iterator localIterator = paramArCloudConfigInfo.uk.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.videoType != 4)
              {
                File localFile = new File(localArVideoResourceInfo.bus);
                localObject1 = null;
                if (localFile.exists()) {
                  localObject1 = alab.getFileMD5String(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.videoMd5))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.videoUrl)))
                {
                  localObject1 = new adja.b();
                  ((adja.b)localObject1).type = 3;
                  ((adja.b)localObject1).url = localArVideoResourceInfo.videoUrl;
                  ((adja.b)localObject1).md5 = localArVideoResourceInfo.videoMd5;
                  this.TF = (localArVideoResourceInfo.videoSize / 8192L);
                  ((adja.b)localObject1).fileSize = localArVideoResourceInfo.videoSize;
                  this.TJ += this.TF;
                  this.TH = System.currentTimeMillis();
                  ((adja.b)localObject1).fileName = localArVideoResourceInfo.bus;
                  ((adja.b)localObject1).bNI = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.videoUrl);
                }
              }
            }
            try
            {
              adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF, adiz.jN(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          adja.b localb1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
          parama.b(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localb1 = new adja.b();
        localb1.type = 6;
        localb1.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btM;
        localb1.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN;
        localb1.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.Up;
        localb1.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO;
        localb1.bNI = true;
        localArrayList.add(localb1);
        continue;
      }
      label894:
      localb1 = new adja.b();
      localb1.type = 6;
      localb1.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btM;
      localb1.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN;
      localb1.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.Up;
      localb1.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO;
      localb1.bNI = true;
      localArrayList.add(localb1);
      continue;
      try
      {
        label967:
        adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO, adiz.sC());
      }
      catch (Exception localException3) {}
      continue;
      label1024:
      adja.b localb2;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.type == 7))
      {
        localObject3 = "";
        Object localObject2 = localObject3;
        if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
        {
          localObject2 = localObject3;
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum != null) {
            localObject2 = btt + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + "_model.zip";
          }
        }
        localObject3 = btt + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator;
        if (new File((String)localObject2).exists())
        {
          try
          {
            adjg.fn((String)localObject2, (String)localObject3);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localb2 = new adja.b();
            localb2.type = 3;
            localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
            localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
            this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
            localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
            this.TJ += this.TF;
            this.TH = System.currentTimeMillis();
            localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
            localb2.bNI = true;
            localArrayList.add(localb2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localb2 = new adja.b();
          localb2.type = 3;
          localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
          localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
          this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
          localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
          this.TJ += this.TF;
          this.TH = System.currentTimeMillis();
          localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
          localb2.bNI = true;
          localArrayList.add(localb2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localb2 = new adja.b();
        localb2.type = 3;
        localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
        localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
        this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
        localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
        this.TJ += this.TF;
        this.TH = System.currentTimeMillis();
        localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
        localb2.bNI = true;
        localArrayList.add(localb2);
        continue;
        label1540:
        if ((parama != null) && (paramArCloudConfigInfo.aeg())) {
          parama.cRZ();
        }
        if (localArrayList.size() > 0)
        {
          this.a.a(localArrayList, new adiq(this, parama, paramArCloudConfigInfo));
          return;
        }
        parama.b(true, paramArCloudConfigInfo);
        return;
        label1594:
        localb2 = null;
      }
    }
  }
  
  public static boolean a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    cRU();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
    {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue = (btt + "ar_cloud_marker_feature/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc + "_signature.db");
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf = (btt + "ar_cloud_marker_model/" + paramArCloudConfigInfo.type + File.separator);
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName = (btt + "ar_cloud_marker_model/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + "_model.zip");
    }
    if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO = (btt + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.aeh()) && (paramArCloudConfigInfo.jdField_a_of_type_Adbm != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF = (btt + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE + ".zip");
    }
    if ((paramArCloudConfigInfo.uk != null) && (paramArCloudConfigInfo.uk.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.uk.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.videoType == 4) {
          localArVideoResourceInfo.bus = adkz.jQ(localArVideoResourceInfo.videoUrl);
        } else if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
          localArVideoResourceInfo.bus = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + localArVideoResourceInfo.videoMd5 + "_model.zip");
        }
      }
    }
    return true;
  }
  
  private boolean a(String paramString, adhh paramadhh)
  {
    if (paramadhh == null) {
      return false;
    }
    try
    {
      paramadhh = new String(paramadhh.a[0].dl, "utf-8");
      paramString = paramString + "_config.dat";
      return adjg.n(paramadhh, sB(), paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "saveJsonConfigInfo failed. error msg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void b(adio.a parama, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.ael()) && (!new File(btt + "pddata/app/offline/html5/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu + File.separator).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu)))
    {
      localObject1 = new adja.b();
      ((adja.b)localObject1).type = 4;
      ((adja.b)localObject1).url = String.valueOf(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.buu);
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_Adbm != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF)))
    {
      if (!new File(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF).exists())
      {
        localObject1 = new adja.b();
        ((adja.b)localObject1).type = 7;
        ((adja.b)localObject1).url = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brD;
        ((adja.b)localObject1).md5 = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE;
        ((adja.b)localObject1).fileSize = paramArCloudConfigInfo.jdField_a_of_type_Adbm.RR;
        ((adja.b)localObject1).fileName = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF;
        ((adja.b)localObject1).bNI = true;
        localArrayList.add(localObject1);
      }
    }
    else if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO)))
    {
      if (new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO).exists()) {
        break label972;
      }
      localObject1 = btt + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN + "_model.zip";
      if (!new File((String)localObject1).exists()) {
        break label899;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        adjg.fn((String)localObject1, adiz.sC());
        if ((paramArCloudConfigInfo.type == 0) || (paramArCloudConfigInfo.type == 7) || (paramArCloudConfigInfo.type == 8))
        {
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
            break label1599;
          }
          localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
          localIterator = null;
          localObject3 = localIterator;
          if (localObject1 != null)
          {
            localObject3 = localIterator;
            if (((File)localObject1).exists()) {
              localObject3 = alab.getFileMD5String(((File)localObject1).getAbsolutePath());
            }
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum))) {
            break label1029;
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject1 = new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName);
            adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName, ((File)localObject1).getParentFile().getAbsolutePath() + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator);
            parama.c(true, paramArCloudConfigInfo);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete.");
            if ((paramArCloudConfigInfo.uk == null) || (paramArCloudConfigInfo.uk.size() <= 0)) {
              break label1545;
            }
            localObject3 = new ArrayList();
            Iterator localIterator = paramArCloudConfigInfo.uk.iterator();
            while (localIterator.hasNext())
            {
              ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
              if (localArVideoResourceInfo.videoType != 4)
              {
                File localFile = new File(localArVideoResourceInfo.bus);
                localObject1 = null;
                if (localFile.exists()) {
                  localObject1 = alab.getFileMD5String(localFile.getAbsolutePath());
                }
                if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.videoMd5))) && (!((ArrayList)localObject3).contains(localArVideoResourceInfo.videoUrl)))
                {
                  localObject1 = new adja.b();
                  ((adja.b)localObject1).type = 3;
                  ((adja.b)localObject1).url = localArVideoResourceInfo.videoUrl;
                  ((adja.b)localObject1).md5 = localArVideoResourceInfo.videoMd5;
                  this.TF = (localArVideoResourceInfo.videoSize / 8192L);
                  ((adja.b)localObject1).fileSize = localArVideoResourceInfo.videoSize;
                  this.TJ += this.TF;
                  this.TH = System.currentTimeMillis();
                  ((adja.b)localObject1).fileName = localArVideoResourceInfo.bus;
                  ((adja.b)localObject1).bNI = false;
                  localArrayList.add(localObject1);
                  ((ArrayList)localObject3).add(localArVideoResourceInfo.videoUrl);
                }
              }
            }
            try
            {
              adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF, adiz.jN(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE));
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException4)
        {
          adja.b localb1;
          new File(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName).delete();
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
          parama.c(false, paramArCloudConfigInfo);
          return;
        }
        localException2 = localException2;
        localb1 = new adja.b();
        localb1.type = 6;
        localb1.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btM;
        localb1.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN;
        localb1.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.Up;
        localb1.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO;
        localb1.bNI = true;
        localArrayList.add(localb1);
        continue;
      }
      label899:
      localb1 = new adja.b();
      localb1.type = 6;
      localb1.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btM;
      localb1.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN;
      localb1.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.Up;
      localb1.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO;
      localb1.bNI = true;
      localArrayList.add(localb1);
      continue;
      try
      {
        label972:
        adjg.fn(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO, adiz.sC());
      }
      catch (Exception localException3) {}
      continue;
      label1029:
      adja.b localb2;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.type == 7))
      {
        localObject3 = "";
        Object localObject2 = localObject3;
        if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
        {
          localObject2 = localObject3;
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum != null) {
            localObject2 = btt + "ar_model/0/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + "_model.zip";
          }
        }
        localObject3 = btt + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + File.separator;
        if (new File((String)localObject2).exists())
        {
          try
          {
            adjg.fn((String)localObject2, (String)localObject3);
          }
          catch (Exception localException5) {}
          if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            localb2 = new adja.b();
            localb2.type = 3;
            localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
            localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
            this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
            localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
            this.TJ += this.TF;
            this.TH = System.currentTimeMillis();
            localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
            localb2.bNI = true;
            localArrayList.add(localb2);
          }
        }
        else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
        {
          localb2 = new adja.b();
          localb2.type = 3;
          localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
          localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
          this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
          localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
          this.TJ += this.TF;
          this.TH = System.currentTimeMillis();
          localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
          localb2.bNI = true;
          localArrayList.add(localb2);
        }
      }
      else if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
      {
        localb2 = new adja.b();
        localb2.type = 3;
        localb2.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
        localb2.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
        this.TF = (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur / 8192L);
        localb2.fileSize = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.Ur;
        this.TJ += this.TF;
        this.TH = System.currentTimeMillis();
        localb2.fileName = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName;
        localb2.bNI = true;
        localArrayList.add(localb2);
        continue;
        label1545:
        if ((parama != null) && (paramArCloudConfigInfo.aeg())) {
          parama.cSa();
        }
        if (localArrayList.size() > 0)
        {
          this.a.a(localArrayList, new adir(this, parama, paramArCloudConfigInfo));
          return;
        }
        parama.c(true, paramArCloudConfigInfo);
        return;
        label1599:
        localb2 = null;
      }
    }
  }
  
  private void b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    int i;
    if (paramArCloudConfigInfo != null) {
      i = 0;
    }
    while (i < this.uv.size())
    {
      if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc.equals(((ArCloudConfigInfo)this.uv.get(i)).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc))) {
        return;
      }
      i += 1;
    }
    this.uv.add(paramArCloudConfigInfo);
  }
  
  private static boolean b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    cRU();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf = (btt + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.type + File.separator);
    }
    if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO = (btt + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.aeh()) && (paramArCloudConfigInfo.jdField_a_of_type_Adbm != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF = (btt + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE + ".zip");
    }
    if ((paramArCloudConfigInfo.uk != null) && (paramArCloudConfigInfo.uk.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.uk.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.videoType == 4) {
          localArVideoResourceInfo.bus = adkz.jQ(localArVideoResourceInfo.videoUrl);
        } else {
          localArVideoResourceInfo.bus = (btt + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.type + File.separator + localArVideoResourceInfo.videoMd5 + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName = (btt + "ar_cloud_classfiy_model/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + "_model.zip");
    }
    return true;
  }
  
  private static boolean c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    cRU();
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf = (btt + "ar_cloud_scene_model/" + paramArCloudConfigInfo.type + File.separator);
    }
    if ((paramArCloudConfigInfo.cFh == 1) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN))) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btO = (btt + "ar_cloud_relationship/" + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.btN + "_relationship.zip");
    }
    if ((paramArCloudConfigInfo.aeh()) && (paramArCloudConfigInfo.jdField_a_of_type_Adbm != null)) {
      paramArCloudConfigInfo.jdField_a_of_type_Adbm.brF = (btt + "ar_cloud_transfer/" + paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE + ".zip");
    }
    if ((paramArCloudConfigInfo.uk != null) && (paramArCloudConfigInfo.uk.size() > 0))
    {
      Iterator localIterator = paramArCloudConfigInfo.uk.iterator();
      while (localIterator.hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
        if (localArVideoResourceInfo.videoType == 4) {
          localArVideoResourceInfo.bus = adkz.jQ(localArVideoResourceInfo.videoUrl);
        } else {
          localArVideoResourceInfo.bus = (btt + "ar_cloud_scene_model/" + paramArCloudConfigInfo.type + File.separator + localArVideoResourceInfo.videoMd5 + "_model.zip");
        }
      }
    }
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) {
      paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName = (btt + "ar_cloud_scene_model/" + paramArCloudConfigInfo.type + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum + "_model.zip");
    }
    return true;
  }
  
  static void cRU()
  {
    if (TextUtils.isEmpty(btt)) {
      btt = adiz.sl();
    }
  }
  
  private void iI(long paramLong)
  {
    this.uv.clear();
    File[] arrayOfFile = new File(sB()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i = 0;
    label30:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i < arrayOfFile.length)
    {
      localObject1 = arrayOfFile[i];
      if (((File)localObject1).getName().endsWith("_config.dat"))
      {
        localObject2 = sB();
        localObject3 = ((File)localObject1).getName();
        if (((File)localObject1).lastModified() + paramLong >= System.currentTimeMillis()) {
          break label89;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      label89:
      localObject1 = adjg.a((String)localObject2, (String)localObject3);
      a((ArCloudConfigInfo)localObject1);
      if (((localObject1 == null) || (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo == null) || (new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue).exists())) && ((localObject1 == null) || (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) || (new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName).exists())))
      {
        if ((localObject1 != null) && (((ArCloudConfigInfo)localObject1).uk != null) && (((ArCloudConfigInfo)localObject1).uk.size() > 0) && (((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null))
        {
          localObject2 = ((ArCloudConfigInfo)localObject1).uk.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ArVideoResourceInfo)((Iterator)localObject2).next();
            if ((new File(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + ((ArVideoResourceInfo)localObject3).videoMd5 + "_model.zip").exists()) || (((ArVideoResourceInfo)localObject3).videoType == 4)) {}
          }
        }
        this.uv.add(localObject1);
      }
    }
  }
  
  private static String sB()
  {
    cRU();
    return btt + "ar_cloud_marker_config/";
  }
  
  public boolean a(adhh paramadhh, adio.a parama, boolean paramBoolean, String arg4)
  {
    Object localObject;
    try
    {
      localObject = new String(paramadhh.a[0].dl, "utf-8");
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. jsonContent = " + (String)localObject);
      localObject = adhg.a((String)localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + localObject);
      if ((localObject == null) || (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo == null))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
        return false;
      }
    }
    catch (Exception paramadhh)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. parse json failed. error msg = " + paramadhh.getMessage());
      return false;
    }
    if (((ArCloudConfigInfo)localObject).jdField_a_of_type_Adbm != null)
    {
      if ((aded.adL()) || (!adbu.adu()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of device not support");
        return false;
      }
      if (((ArCloudConfigInfo)localObject).picId != null) {
        anot.a(null, "CliOper", "", "", "0X80098CB", "0X80098CB", 0, 0, ((ArCloudConfigInfo)localObject).picId, "0", "0", "");
      }
    }
    if (((ArCloudConfigInfo)localObject).cFh == 1)
    {
      if (!aded.adL()) {}
      return false;
    }
    if (paramBoolean)
    {
      if (((ArCloudConfigInfo)localObject).cFh != 1) {
        break label322;
      }
      if ((((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (TextUtils.isEmpty(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.taskId)) || (!((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelARRelationShip.taskId.equals(???))) {}
    }
    else
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
      a((ArCloudConfigInfo)localObject);
      synchronized (this.mLock)
      {
        a(paramadhh, parama, (ArCloudConfigInfo)localObject);
        return true;
      }
    }
    return false;
    label322:
    return false;
  }
  
  public boolean a(adhj arg1, adio.a parama, boolean paramBoolean, String paramString)
  {
    if (??? == null) {
      return false;
    }
    ??? = ???.U();
    if (??? == null) {
      return false;
    }
    try
    {
      ??? = new String(???, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadMarkerConfig. jsonContent = " + ???);
      }
      paramString = adhg.a(???);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + paramString);
      if (paramString == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException ???)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "processObjectClassifyRecogResult. parse json failed. error msg = " + ???.getMessage());
      return false;
    }
    if (paramString.jdField_a_of_type_Adbm != null)
    {
      if ((aded.adL()) || (!adbu.adu()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
        return false;
      }
      if (paramString.picId != null) {
        anot.a(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramString.picId, "0", "0", "");
      }
    }
    if ((paramString.cFh == 1) || (paramString.type == 7))
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ar card not support");
      return false;
    }
    b(paramString);
    if ((QLog.isDebugVersion()) && (paramString.cCF == 0)) {
      ThreadManager.getUIHandler().post(new ARMarkerResourceManager.1(this));
    }
    paramString.cCF = Math.max(1, paramString.cCF);
    synchronized (this.mLock)
    {
      a(parama, paramString);
      return true;
    }
  }
  
  public boolean a(adhy paramadhy, adio.a parama, boolean paramBoolean, String arg4)
  {
    if (paramadhy == null) {
      return false;
    }
    paramadhy = paramadhy.U();
    if (paramadhy == null) {
      return false;
    }
    try
    {
      paramadhy = new String(paramadhy, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadSceneConfig. jsonContent = " + paramadhy);
      }
      paramadhy = adhg.a(paramadhy);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig. config = " + paramadhy);
      if (paramadhy == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramadhy)
    {
      QLog.i("AREngine_ARMarkerResourceManager", 1, "processSceneRecogResult. parse json failed. error msg = " + paramadhy.getMessage());
      return false;
    }
    if (paramadhy.jdField_a_of_type_Adbm != null)
    {
      if ((aded.adL()) || (!adbu.adu()))
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
        return false;
      }
      if (paramadhy.picId != null) {
        anot.a(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramadhy.picId, "0", "0", "");
      }
    }
    if (paramadhy.cFh == 1) {
      try
      {
        boolean bool = aded.adL();
        if (!bool) {}
        return false;
      }
      catch (Exception ???)
      {
        QLog.i("AREngine_ARMarkerResourceManager", 1, " HotVideoUtils.saveBlurBitmap e = " + ???.getMessage());
      }
    }
    if (paramBoolean)
    {
      if (paramadhy.cFh != 1) {
        break label349;
      }
      if ((paramadhy.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip == null) || (!paramadhy.aeg())) {}
    }
    else
    {
      c(paramadhy);
      if ((QLog.isDebugVersion()) && (paramadhy.cCF == 0)) {
        ThreadManager.getUIHandler().post(new ARMarkerResourceManager.2(this));
      }
      paramadhy.cCF = Math.max(1, paramadhy.cCF);
      synchronized (this.mLock)
      {
        b(parama, paramadhy);
        return true;
      }
    }
    return false;
    label349:
    return false;
  }
  
  public ArrayList<ArCloudConfigInfo> cM()
  {
    return this.uv;
  }
  
  public void cRK()
  {
    this.mStartTime = 0L;
    this.mEndTime = 0L;
    this.bsO = null;
    this.TC = 0L;
    this.TD = 0L;
    this.TE = 0L;
    this.cHb = -1;
    this.TF = 0L;
    this.TG = 0L;
    this.TH = 0L;
    this.cHc = -1;
    this.TI = 0L;
    this.mType = -1;
    this.TJ = 0L;
    this.mResult = -1;
  }
  
  public void cRV()
  {
    synchronized (this.mLock)
    {
      if (this.a != null) {
        this.a.cRV();
      }
      return;
    }
  }
  
  public void cRW()
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "arCloudDownloadReport start.");
    adix.a().a(this.bsO, this.TC, this.TD, this.cHb, this.TF, this.TG, this.cHc, this.TI, this.mType, this.mEndTime - this.mStartTime, this.TJ, this.mResult);
  }
  
  public void d(long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    iI(paramLong);
    Gk(paramBoolean);
    adix.a().iK(System.currentTimeMillis() - l);
  }
  
  public void uninit()
  {
    if (this.a != null) {
      this.a.uninit();
    }
  }
  
  public static abstract interface a
  {
    public abstract void KW(int paramInt);
    
    public abstract void KX(int paramInt);
    
    public abstract void KY(int paramInt);
    
    public abstract void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo);
    
    public abstract void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo);
    
    public abstract void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo);
    
    public abstract void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo);
    
    public abstract void cRY();
    
    public abstract void cRZ();
    
    public abstract void cSa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adio
 * JD-Core Version:    0.7.0.1
 */