import android.annotation.TargetApi;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.3;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.4;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.6;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.7;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class advr
  implements Manager
{
  public static int cKr = 8;
  private advl jdField_a_of_type_Advl;
  private advm.a jdField_a_of_type_Advm$a = new advt(this);
  public advm a;
  private advq jdField_a_of_type_Advq = new advs(this);
  DeviceProfileManager.a jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = new advr.a(this);
  public volatile boolean bRp;
  public String bvJ;
  public String bvK;
  public SparseArray<ArrayList<String>> cp = new SparseArray();
  public ConcurrentHashMap<String, DynamicAvatar> eN;
  public Runnable ge = new DynamicAvatarManager.8(this);
  private AppInterface mApp;
  private Resources mResources;
  public ArrayList<WeakReference<aqcy>> uT;
  public ArrayList<WeakReference<aqcy>> uU;
  public ArrayList<WeakReference<aqcy>> uV;
  public ArrayList<WeakReference<aqcy>> uW;
  
  public advr(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "new DynamicAvatarManager param app is null.");
      }
      return;
    }
    this.mApp = paramAppInterface;
    this.mApp.addObserver(this.jdField_a_of_type_Advq, true);
    this.uW = new ArrayList();
    this.uV = new ArrayList();
    this.uT = new ArrayList();
    this.uU = new ArrayList();
    this.eN = new ConcurrentHashMap();
    this.jdField_a_of_type_Advm = new advm(paramAppInterface);
    this.jdField_a_of_type_Advm.a(this.jdField_a_of_type_Advm$a);
    this.mResources = BaseApplicationImpl.getContext().getResources();
    initConfig();
    cKr = this.jdField_a_of_type_Advl.cKl;
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
  }
  
  private Setting a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    if (paramInt == 18)
    {
      paramString = "stranger_" + Integer.toString(paramInt) + "_" + paramString;
      if ((this.mApp instanceof NearbyAppInterface)) {
        localObject1 = ((aqdm)this.mApp.getManager(216)).getFaceSetting(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (!(this.mApp instanceof QQAppInterface));
        return ((QQAppInterface)this.mApp).a().a(true).getFaceSetting(paramString);
        localObject1 = localObject2;
      } while ((this.mApp instanceof NearbyAppInterface));
      localObject1 = localObject2;
    } while (!(this.mApp instanceof QQAppInterface));
    Object localObject1 = this.mApp.getEntityManagerFactory().createEntityManager();
    paramString = (Setting)((EntityManager)localObject1).find(Setting.class, paramString);
    ((EntityManager)localObject1).close();
    return paramString;
  }
  
  public static String a(int paramInt1, int paramInt2, DynamicAvatar paramDynamicAvatar)
  {
    Object localObject;
    if (paramDynamicAvatar == null) {
      localObject = null;
    }
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          str = "";
          if (paramInt1 != 17) {
            break;
          }
          if (paramInt2 == 100) {
            return paramDynamicAvatar.basicSmallUrl;
          }
          if (paramInt2 == 200) {
            return paramDynamicAvatar.basicMiddleUrl;
          }
          localObject = str;
        } while (paramInt2 != 640);
        return paramDynamicAvatar.basicBigUrl;
        localObject = str;
      } while (paramInt1 != 18);
      if (paramInt2 == 100) {
        return paramDynamicAvatar.nearbySmallUrl;
      }
      if (paramInt2 == 200) {
        return paramDynamicAvatar.nearbyMiddleUrl;
      }
      localObject = str;
    } while (paramInt2 != 640);
    return paramDynamicAvatar.nearbyBigUrl;
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(aqcy paramaqcy, boolean paramBoolean)
  {
    if (paramaqcy == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaqcy.dYr).append("_").append(paramaqcy.dYs).append("_").append(paramaqcy.mId);
    if ((paramBoolean) || ((paramaqcy.cTC) && (!TextUtils.isEmpty(paramaqcy.mUrl)))) {
      localStringBuilder.append("_").append(paramaqcy.mUrl);
    }
    return localStringBuilder.toString();
  }
  
  private void az(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    int j;
    synchronized (this.uV)
    {
      j = this.uV.size() - 1;
      if (j >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.uV.get(j);
        if (localWeakReference == null)
        {
          this.uV.remove(j);
        }
        else
        {
          aqcy localaqcy = (aqcy)localWeakReference.get();
          if (localaqcy == null) {
            this.uV.remove(j);
          } else if (paramString1.equals(localaqcy.mKey)) {
            if (TextUtils.isEmpty(paramString2))
            {
              localaqcy.N = null;
              localaqcy.edp();
              this.uV.remove(j);
            }
            else
            {
              localaqcy.mUrl = paramString2;
              localaqcy.mBigUrl = paramString3;
              if ((localaqcy.bb == null) || (localaqcy.bb.get() == null) || (!paramString2.equals(((DynamicAvatarView)localaqcy.bb.get()).YP))) {
                break label225;
              }
              this.uV.remove(localWeakReference);
            }
          }
        }
      }
      else
      {
        if (i != 0) {
          GX(paramString2);
        }
        return;
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      label225:
      i = 1;
    }
  }
  
  public static String b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    int i = 18;
    if (paramInt2 == 200)
    {
      paramInt2 = 17;
      if (paramInt1 != 32) {
        break label37;
      }
    }
    label37:
    for (paramInt1 = i;; paramInt1 = 17)
    {
      return a(paramInt1, paramInt2, paramString, paramInt3);
      paramInt2 = 18;
      break;
    }
  }
  
  private boolean b(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo dynamicAvatrInfo or setting info is null.");
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          long l = System.currentTimeMillis() / 1000L;
          if ((l - paramDynamicAvatar.getTimeStamp >= 0L) && (l - paramDynamicAvatar.getTimeStamp < 86400L)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo beyond 24h, stamp: " + paramDynamicAvatar.getTimeStamp);
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
          break label331;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label331:
    return false;
  }
  
  public void GW(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!TextUtils.isEmpty(paramString.basicSmallUrl)) {
        localObject = advm.h(paramString.basicSmallUrl);
      }
      try
      {
        localObject = ((File)localObject).toURI().toURL().toString();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = 100;
        localURLDrawableOptions.mRequestHeight = 100;
        URLDrawable.removeMemoryCacheByUrl((String)localObject, localURLDrawableOptions);
        if (!TextUtils.isEmpty(paramString.basicMiddleUrl)) {
          localObject = advm.h(paramString.basicMiddleUrl);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          do
          {
            localObject = ((File)localObject).toURI().toURL().toString();
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = 200;
            localURLDrawableOptions.mRequestHeight = 200;
            URLDrawable.removeMemoryCacheByUrl((String)localObject, localURLDrawableOptions);
            if (TextUtils.isEmpty(paramString.basicBigUrl)) {
              break;
            }
            paramString = advm.h(paramString.basicBigUrl);
            try
            {
              paramString = paramString.toURI().toURL().toString();
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 640;
              ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 640;
              URLDrawable.removeMemoryCacheByUrl(paramString, (URLDrawable.URLDrawableOptions)localObject);
              return;
            }
            catch (Exception paramString) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(paramString));
            return;
            localException1 = localException1;
          } while (!QLog.isColorLevel());
          QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(localException1));
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(localException2));
            }
          }
        }
      }
    }
  }
  
  public void GX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_Advm == null) {
      return;
    }
    this.jdField_a_of_type_Advm.li(paramString);
  }
  
  public advl a()
  {
    if (this.jdField_a_of_type_Advl == null) {
      initConfig();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "getConfig DynamicAvatarConfig|" + this.jdField_a_of_type_Advl);
    }
    return this.jdField_a_of_type_Advl;
  }
  
  public advm a()
  {
    return this.jdField_a_of_type_Advm;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1;
    if ((this.mApp instanceof QQAppInterface))
    {
      if (this.eN.containsKey(paramString))
      {
        localObject1 = (DynamicAvatar)this.eN.get(paramString);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("getDynamicAvatarInfo cache is null: ");
          if (localObject1 != null) {
            break label184;
          }
          bool1 = true;
          QLog.i("Q.dynamicAvatar", 2, bool1);
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(paramInt, paramString);
        localObject2 = this.eN;
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      label184:
      try
      {
        this.eN.put(paramString, localObject1);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("db find dynamic avatarInfo is null: ");
          if (localObject1 != null) {
            break label225;
          }
          bool1 = bool2;
          QLog.i("Q.dynamicAvatar", 2, bool1);
        }
        return localObject1;
      }
      finally {}
      bool1 = false;
      break;
      if ((this.mApp instanceof NearbyAppInterface))
      {
        localObject1 = ((NearbyAppInterface)this.mApp).a().a(paramInt, paramString);
        continue;
        label225:
        bool1 = false;
      }
    }
  }
  
  public DynamicAvatar a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((this.mApp instanceof QQAppInterface))
    {
      localObject1 = localObject2;
      if (this.eN.containsKey(paramString)) {
        localObject1 = (DynamicAvatar)this.eN.get(paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getDynamicAvatarInfoFromCache: ");
      if (localObject1 != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("Q.dynamicAvatar", 2, bool);
      return localObject1;
    }
  }
  
  public void a(advo paramadvo)
  {
    if (paramadvo == null) {}
    while (!(this.mApp instanceof QQAppInterface)) {
      return;
    }
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    for (;;)
    {
      try
      {
        localCursor = localEntityManager.query(false, DynamicAvatar.class.getSimpleName(), null, null, null, null, null, null, null);
        if (localCursor != null) {}
        try
        {
          int i = localCursor.getCount();
          localCursor.moveToFirst();
          if (i >= 1000)
          {
            if (i > 333)
            {
              localCursor.moveToNext();
              i -= 1;
              continue;
            }
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("delete from ");
            ((StringBuilder)localObject1).append(DynamicAvatar.class.getSimpleName());
            ((StringBuilder)localObject1).append(" where ");
            ((StringBuilder)localObject1).append("_id");
            ((StringBuilder)localObject1).append(" < ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(";");
            localEntityManager.execSQL(((StringBuilder)localObject1).toString());
          }
          if ((paramadvo == null) || (paramadvo.uQ == null) || (paramadvo.uQ.isEmpty())) {
            continue;
          }
          paramadvo = paramadvo.uQ.iterator();
          if (!paramadvo.hasNext()) {
            continue;
          }
          localObject1 = DynamicAvatar.convertFrom((advo.a)paramadvo.next());
          if (localObject1 == null) {
            continue;
          }
          ??? = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(((DynamicAvatar)localObject1).uin) });
          if (??? != null)
          {
            ((DynamicAvatar)localObject1).setStatus(((DynamicAvatar)???).getStatus());
            ((DynamicAvatar)localObject1).setId(((DynamicAvatar)???).getId());
          }
          if (((DynamicAvatar)localObject1).getStatus() != 1000) {
            continue;
          }
          localEntityManager.persistOrReplace((Entity)localObject1);
          synchronized (this.eN)
          {
            if (this.eN.size() > 200)
            {
              Iterator localIterator = this.eN.entrySet().iterator();
              i = 0;
              if (localIterator.hasNext())
              {
                localIterator.remove();
                int j = i + 1;
                i = j;
                if (j < 100) {
                  continue;
                }
              }
            }
            if (((DynamicAvatar)localObject1).uin > 0L) {
              this.eN.put(String.valueOf(((DynamicAvatar)localObject1).uin), localObject1);
            }
            if (((DynamicAvatar)localObject1).tinyId > 0L) {
              this.eN.put(String.valueOf(((DynamicAvatar)localObject1).tinyId), localObject1);
            }
          }
          if (localCursor == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        Object localObject1;
        Cursor localCursor = null;
        continue;
      }
      localCursor.close();
      localEntityManager.getTransaction().end();
      localEntityManager.close();
      throw paramadvo;
      localEntityManager.update((Entity)localObject1);
    }
    localEntityManager.getTransaction().commit();
    if (localCursor != null) {
      localCursor.close();
    }
    localEntityManager.getTransaction().end();
    localEntityManager.close();
  }
  
  public void a(aqcy paramaqcy)
  {
    if (paramaqcy == null) {
      return;
    }
    synchronized (this.uW)
    {
      this.uW.remove(paramaqcy.bc);
    }
    synchronized (this.uT)
    {
      this.uT.remove(paramaqcy.bc);
      this.uU.remove(paramaqcy.bc);
      synchronized (this.uV)
      {
        this.uV.remove(paramaqcy.bc);
        return;
      }
      paramaqcy = finally;
      throw paramaqcy;
    }
  }
  
  public void a(aqcy paramaqcy, boolean paramBoolean)
  {
    if (paramaqcy == null) {
      return;
    }
    if (paramBoolean)
    {
      String str = a(paramaqcy, false);
      ArrayList localArrayList2 = (ArrayList)this.cp.get(paramaqcy.mSource);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.cp.put(paramaqcy.mSource, localArrayList1);
      }
      localArrayList1.add(str);
      localArrayList1.add(a(paramaqcy, true));
      if ((paramaqcy.mSource == 1) || (paramaqcy.mSource == 0)) {
        ThreadManager.post(new DynamicAvatarManager.6(this, paramaqcy, System.currentTimeMillis()), 5, null, true);
      }
      if (paramaqcy.bb.get() != null) {
        ((DynamicAvatarView)paramaqcy.bb.get()).YP = "";
      }
    }
    ThreadManager.postImmediately(new DynamicAvatarManager.7(this, paramaqcy), null, true);
  }
  
  public void a(aqcy paramaqcy, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.uV.size() < cKr) || (paramBoolean1))
    {
      ??? = paramaqcy.mKey;
      synchronized (this.uV)
      {
        this.uV.add(paramaqcy.bc);
        if (paramBoolean1) {}
      }
      for (;;)
      {
        long l1;
        synchronized (this.uW)
        {
          this.uW.remove(paramaqcy.bc);
          ??? = new DynamicAvatarManager.3(this, paramaqcy, (String)???);
          if (!paramBoolean2)
          {
            l1 = 0L;
            long l2 = l1;
            if (aqgz.getCpuNumber() <= 2) {
              l2 = l1 * 2L;
            }
            ThreadManager.getSubThreadHandler().postDelayed(new DynamicAvatarManager.4(this, (Runnable)???), l2);
            return;
            paramaqcy = finally;
            throw paramaqcy;
          }
        }
        if (paramaqcy.mSource == 0) {
          l1 = 1500L;
        } else {
          l1 = 400L;
        }
      }
    }
    synchronized (this.uW)
    {
      this.uW.add(paramaqcy.bc);
      return;
    }
  }
  
  public void a(DynamicAvatar paramDynamicAvatar)
  {
    EntityManager localEntityManager;
    DynamicAvatar localDynamicAvatar;
    if ((this.mApp instanceof QQAppInterface))
    {
      localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      localDynamicAvatar = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(paramDynamicAvatar.uin) });
      if (localDynamicAvatar != null)
      {
        paramDynamicAvatar.setStatus(localDynamicAvatar.getStatus());
        paramDynamicAvatar.setId(localDynamicAvatar.getId());
      }
      if (paramDynamicAvatar.getStatus() != 1000) {
        break label120;
      }
      localEntityManager.persistOrReplace(paramDynamicAvatar);
    }
    for (;;)
    {
      localEntityManager.close();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "updateDynamicAvatarInfo: avatarInfo is : " + localDynamicAvatar);
      }
      return;
      label120:
      localEntityManager.update(paramDynamicAvatar);
    }
  }
  
  @TargetApi(11)
  public boolean a(aqcy paramaqcy)
  {
    int i = 640;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (!paramaqcy.bRs)
    {
      localObject1 = a(paramaqcy, false);
      localObject2 = (ArrayList)this.cp.get(paramaqcy.mSource);
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1)))
      {
        bool1 = false;
        return bool1;
      }
    }
    File localFile = advm.h(paramaqcy.mUrl);
    if (paramaqcy.dYt == 640) {}
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      localObject2 = paramaqcy.fR;
      localObject1 = localObject2;
      if ((localObject2 instanceof aqdj)) {
        localObject1 = ((aqdj)localObject2).getCurrDrawable();
      }
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localObject1 = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject1).mRequestedFPS = this.jdField_a_of_type_Advl.cKn;
      int j = i;
      if (anlm.ayn()) {
        j = aqhu.ka(i);
      }
      ((VideoDrawable.VideoDrawableParams)localObject1).mVideoRoundCorner = j;
      ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
      ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
      localURLDrawableOptions.mExtraInfo = localObject1;
      boolean bool2 = paramaqcy.b(URLDrawable.getDrawable(localFile, localURLDrawableOptions));
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      bool1 = bool2;
      if (paramaqcy.mSource < 0) {
        break;
      }
      bool1 = bool2;
      if (aqcy.oR.length <= paramaqcy.mSource) {
        break;
      }
      bool1 = bool2;
      if (this.mApp == null) {
        break;
      }
      adwc.b(this.mApp, "0X800711C", aqcy.oR[paramaqcy.mSource]);
      return bool2;
      if (paramaqcy.dYt == 200) {
        i = 200;
      } else {
        i = 100;
      }
    }
  }
  
  public boolean a(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {}
    do
    {
      do
      {
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
          break label242;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo basic: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo nearby: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label242:
    return false;
  }
  
  public void aZ(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    do
    {
      do
      {
        return;
        if (!(this.mApp instanceof QQAppInterface)) {
          break;
        }
        oidb_0x74b.RspBody localRspBody = new oidb_0x74b.RspBody();
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          a(advo.a(localRspBody));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      } while (!QLog.isDevelopLevel());
      paramArrayOfByte.printStackTrace();
      return;
    } while (!(this.mApp instanceof NearbyAppInterface));
    ((NearbyAppInterface)this.mApp).a().bk(paramArrayOfByte);
  }
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    boolean bool = true;
    Object localObject = null;
    if (this.mApp != null)
    {
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      if (paramInt == 18)
      {
        localObject = "tinyId=?";
        localObject = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, (String)localObject, new String[] { paramString });
        localEntityManager.close();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getAvatarInfoFromDb: avatarInfo is null: ");
      if (localObject != null) {
        break label112;
      }
    }
    for (;;)
    {
      QLog.d("Q.dynamicAvatar", 2, bool);
      return localObject;
      localObject = "uin=?";
      break;
      label112:
      bool = false;
    }
  }
  
  public void b(aqcy paramaqcy)
  {
    if (paramaqcy == null) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (ShortVideoUtils.awI()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.dynamicAvatar", 2, "getDynamicAvatar isVideoSoLibLoaded false.");
        }
      } while (this.bRp);
      ThreadManager.getSubThreadHandler().postDelayed(new DynamicAvatarManager.1(this), 10000L);
      this.bRp = true;
      return;
      if (paramaqcy.bRs) {
        break;
      }
      ??? = a(paramaqcy, false);
      localArrayList = (ArrayList)this.cp.get(paramaqcy.mSource);
    } while ((localArrayList != null) && (localArrayList.contains(???)));
    if (aqcy.cTz) {
      synchronized (this.uW)
      {
        this.uW.add(paramaqcy.bc);
        return;
      }
    }
    a(paramaqcy, true, true);
  }
  
  public void cUH()
  {
    this.cp.clear();
    synchronized (this.uT)
    {
      this.uU.clear();
      this.uT.clear();
      return;
    }
  }
  
  public boolean iQ(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Advl != null) {
      switch (paramInt)
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "isPlayDynamicAvatar|source:" + paramInt + ",isPlay:" + bool1 + "\n" + this.jdField_a_of_type_Advl);
      }
      return bool1;
      bool1 = this.jdField_a_of_type_Advl.bRh;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRi;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRk;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRl;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRj;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRm;
      continue;
      bool1 = true;
      continue;
      bool1 = this.jdField_a_of_type_Advl.bRk;
    }
  }
  
  public void initConfig()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Advl = new advl();
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "DynamicAvatarConfig|init config:" + this.jdField_a_of_type_Advl + ",costTime:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void onDestroy()
  {
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
    this.mApp.removeObserver(this.jdField_a_of_type_Advq);
    this.jdField_a_of_type_Advm.onDestory();
    this.jdField_a_of_type_Advm = null;
    this.jdField_a_of_type_Advq = null;
    this.mApp = null;
  }
  
  public void pauseAll() {}
  
  public void resumeAll()
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "resumeAll pausedSize: " + this.uW.size() + " loadinging size: " + this.uV.size() + " playing size" + this.uT.size() + " waiting play size: " + this.uU.size());
    }
    if (aqcy.cTz) {
      return;
    }
    int i;
    synchronized (this.uW)
    {
      i = this.uW.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference1 = (WeakReference)this.uW.get(i);
        if ((localWeakReference1 != null) && (localWeakReference1.get() != null)) {
          ((aqcy)localWeakReference1.get()).edp();
        } else {
          this.uW.remove(i);
        }
      }
    }
    int m = Math.min(cKr, this.uW.size());
    for (;;)
    {
      Object localObject2;
      int j;
      synchronized (this.uV)
      {
        int k = this.uV.size();
        if (m >= cKr)
        {
          i = k;
          localObject2 = new ArrayList();
          j = k - 1;
          if (j >= k - i)
          {
            WeakReference localWeakReference2 = (WeakReference)this.uV.remove(j);
            if ((localWeakReference2 == null) || (localWeakReference2.get() == null)) {
              break label434;
            }
            ((ArrayList)localObject2).add(((aqcy)localWeakReference2.get()).mUrl);
            break label434;
          }
        }
        else
        {
          i = k - (cKr - m);
          continue;
        }
        if (this.jdField_a_of_type_Advm != null) {
          this.jdField_a_of_type_Advm.dY((ArrayList)localObject2);
        }
      }
      synchronized (this.uW)
      {
        i = Math.min(this.uW.size() - 1, m - 1);
        while (i >= 0)
        {
          localObject2 = (WeakReference)this.uW.get(i);
          if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            a((aqcy)((WeakReference)localObject2).get(), false, false);
            i -= 1;
            continue;
            localObject3 = finally;
            throw localObject3;
          }
          else
          {
            this.uW.remove(i);
          }
        }
      }
      return;
      i -= 1;
      break;
      label434:
      j -= 1;
    }
  }
  
  public void sr(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Advl != null) && (this.jdField_a_of_type_Advl.bRf)) {}
    synchronized (this.jdField_a_of_type_Advl)
    {
      this.jdField_a_of_type_Advl.anq();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|mDynamicAvatarConfig:" + this.jdField_a_of_type_Advl);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|isSuccess:" + paramBoolean);
      }
      return;
    }
  }
  
  static class a
    implements DeviceProfileManager.a
  {
    WeakReference<advr> ao;
    
    public a(advr paramadvr)
    {
      this.ao = new WeakReference(paramadvr);
    }
    
    public void sr(boolean paramBoolean)
    {
      advr localadvr = (advr)this.ao.get();
      if (localadvr != null) {
        localadvr.sr(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advr
 * JD-Core Version:    0.7.0.1
 */