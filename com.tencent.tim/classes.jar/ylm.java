import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.bless.BlessManager.1;
import com.tencent.mobileqq.activity.bless.BlessManager.4;
import com.tencent.mobileqq.activity.bless.BlessManager.5;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ylm
  implements Manager
{
  public static final String aYE = "bless" + File.separator;
  private static int screenWidth;
  private BlessTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private yme jdField_a_of_type_Yme;
  private String aYF;
  public String aYG;
  public String aYH;
  private BlessTask jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private yme jdField_b_of_type_Yme;
  private AtomicBoolean bM = new AtomicBoolean(false);
  private volatile boolean bnj;
  private boolean bnk;
  private volatile boolean bnl;
  private boolean bnm;
  private boolean bnn;
  private ConcurrentHashMap<String, aquz> db = new ConcurrentHashMap();
  protected Runnable eG = new BlessManager.1(this);
  private Drawable eb;
  private Drawable ec;
  private long iu;
  private MessageForShortVideo m;
  private QQAppInterface mApp;
  private ArrayList<BlessPtvModule> qX;
  private ArrayList<BlessWording> qY;
  private ArrayList<String> qZ;
  
  public ylm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = acbn.SDCARD_PATH + aYE;
    this.aYG = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    this.aYH = (this.aYG + File.separator + "history" + File.separator + "ptvHistory");
    cjf();
    cje();
    ThreadManager.getSubThreadHandler().post(this.eG);
  }
  
  private void Ah(boolean paramBoolean)
  {
    boolean bool = true;
    acxw localacxw = this.mApp.a().a();
    RecentUser localRecentUser = localacxw.b(acbn.blr, 9003);
    int i;
    label78:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.qY != null) && (this.qY.size() > 0))
    {
      i = 1;
      if ((i == 0) || (!TU()) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted)) {
        break label184;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initEntrance show=").append(bool).append(" hasConfig=").append(paramBoolean).append(" task=").append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask).append(" isDeleted=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
          break label189;
        }
        localObject = "";
        label139:
        QLog.d("BlessManager", 2, localObject);
      }
      if (!bool) {
        break label231;
      }
      if (localRecentUser != null) {
        break label204;
      }
      a(localacxw);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew = false;
    }
    label184:
    label189:
    label204:
    label231:
    while (localRecentUser == null) {
      for (;;)
      {
        return;
        i = 0;
        break;
        bool = false;
        break label78;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted);
        break label139;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew)
        {
          a(localacxw, localRecentUser);
          a(localacxw);
        }
      }
    }
    a(localacxw, localRecentUser);
  }
  
  private boolean Ua()
  {
    String str1 = pJ();
    String str2 = pI();
    if ((str1 == null) || (str2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "isStarVideoFileReady() videoCoverPath=" + str1 + ", videoPath=" + str2);
      }
      return false;
    }
    return true;
  }
  
  private void a(acxw paramacxw)
  {
    RecentUser localRecentUser = paramacxw.a(acbn.blr, 9003);
    long l = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = acbn.blr;
    localRecentUser.setType(9003);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    paramacxw.e(localRecentUser);
    bh(this.mApp);
  }
  
  private void a(acxw paramacxw, RecentUser paramRecentUser)
  {
    paramacxw.f(paramRecentUser);
    bh(this.mApp);
  }
  
  private void a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {}
    String[] arrayOfString;
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfString = new String[11];
      arrayOfString[0] = paramBlessTask.mainBanner;
      arrayOfString[1] = paramBlessTask.mainCenter;
      arrayOfString[2] = paramBlessTask.typeBanner;
      arrayOfString[3] = paramBlessTask.succeededBanner;
      arrayOfString[4] = paramBlessTask.defaultVoice;
      arrayOfString[5] = paramBlessTask.starAvator;
      arrayOfString[6] = paramBlessTask.starVideo;
      arrayOfString[7] = paramBlessTask.recentHeadImgUrl;
      arrayOfString[8] = paramBlessTask.ptvAnimationUrl;
      arrayOfString[9] = paramBlessTask.starAvatorSimple;
      arrayOfString[10] = paramBlessTask.recentHeadImgUrlSimple;
      arrayOfFile = new File(this.aYG).listFiles();
    } while (arrayOfFile == null);
    int k = 0;
    label129:
    if (k < arrayOfFile.length) {
      if ((!arrayOfFile[k].getName().endsWith(".zip")) && (!arrayOfFile[k].isDirectory())) {
        break label174;
      }
    }
    label512:
    label528:
    for (;;)
    {
      k += 1;
      break label129;
      break;
      label174:
      int n = 0;
      int i = 0;
      int j = 0;
      label200:
      Object localObject;
      label247:
      int i1;
      for (;;)
      {
        if (n < arrayOfString.length) {
          if (TextUtils.isEmpty(arrayOfString[n]))
          {
            n += 1;
          }
          else
          {
            localObject = getFileNameFromUrl(arrayOfString[n]);
            if (arrayOfString[n].equals(paramBlessTask.starVideo))
            {
              localObject = arwv.encodeHexStr(arrayOfString[n]);
              j = 1;
              if (!arrayOfFile[k].getName().equals(localObject)) {
                break label512;
              }
              i1 = 0;
              n = i;
            }
          }
        }
      }
      for (i = i1;; i = i1)
      {
        if (i == 0) {
          break label528;
        }
        arrayOfFile[k].delete();
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "deleteOldBanner=" + arrayOfFile[k].getName());
        }
        if (j != 0)
        {
          localObject = this.aYG + paramBlessTask.starVideoCoverFolderName + File.separator;
          localObject = new File((String)localObject + paramBlessTask.starVideoCoverFileName);
          if ((((File)localObject).exists()) && (((File)localObject).isFile()))
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "deleteOldCover=" + ((File)localObject).getName());
            }
          }
        }
        if (n == 0) {
          break;
        }
        localObject = new File(pL());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break;
        }
        ((File)localObject).delete();
        break;
        if (arrayOfString[n].equals(paramBlessTask.ptvAnimationUrl))
        {
          i = 1;
          break label247;
          break label200;
        }
        break label247;
        i1 = 1;
        n = i;
      }
    }
  }
  
  private void a(BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        localEntityManager.drop(BlessTask.class);
        if (paramBlessTask != null) {
          localEntityManager.persistOrReplace(paramBlessTask);
        }
        localEntityManager.drop(BlessPtvModule.class);
        if (paramArrayList != null)
        {
          paramBlessTask = paramArrayList.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.persistOrReplace((BlessPtvModule)paramBlessTask.next());
            continue;
          }
        }
      }
      catch (Exception paramBlessTask)
      {
        paramBlessTask.printStackTrace();
        localEntityTransaction.end();
        return;
        localEntityManager.drop(BlessWording.class);
        if (paramArrayList1 != null)
        {
          paramBlessTask = paramArrayList1.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.persistOrReplace((BlessWording)paramBlessTask.next());
            continue;
          }
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "save task and modules to db");
      }
      localEntityTransaction.end();
    }
  }
  
  private void a(String paramString, BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "processReceivedConfig newTask=" + paramBlessTask);
    }
    Object localObject2;
    if (this.qX != null)
    {
      localObject1 = this.qX.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label152;
        }
        localObject2 = (BlessPtvModule)((Iterator)localObject1).next();
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
          if (!((BlessPtvModule)localObject2).id.equals(localBlessPtvModule.id)) {
            break;
          }
          if (((BlessPtvModule)localObject2).data.equals(localBlessPtvModule.data)) {
            localBlessPtvModule.broken = ((BlessPtvModule)localObject2).broken;
          } else {
            localBlessPtvModule.broken = true;
          }
        }
      }
    }
    label152:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      localObject1 = getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo);
      localObject2 = getFileNameFromUrl(paramBlessTask.starVideo);
      if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
        paramBlessTask.videoPlayed = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed;
      }
    }
    if ((this.eb != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!TextUtils.isEmpty(paramBlessTask.starAvator)) && (!paramBlessTask.starAvator.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator))) {
      this.eb = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (paramBlessTask.festival_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.festival_id) && (paramBlessTask.task_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.task_id))
    {
      paramBlessTask.isNew = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew;
      paramBlessTask.isDeleted = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = paramBlessTask;
    this.qX = paramArrayList;
    this.qY = paramArrayList1;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    da(this.qX);
    this.bnl = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
    Ah(this.bnl);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
    this.jdField_a_of_type_Yme.clear();
    Object localObject1 = this.mApp.getPreferences();
    yme.a((SharedPreferences)localObject1, this.jdField_a_of_type_Yme, 1);
    a(paramBlessTask, paramArrayList, paramArrayList1);
    ((SharedPreferences)localObject1).edit().remove("bless_send_wording").commit();
    this.aYF = null;
    yP(paramString);
  }
  
  private boolean a(BlessTask paramBlessTask, boolean paramBoolean)
  {
    if (paramBlessTask == null) {
      return false;
    }
    Object localObject2;
    Object localObject1;
    label68:
    String str1;
    if (paramBoolean)
    {
      localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.starAvator, paramBlessTask.starVideo }));
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramBlessTask.starAvatorSimple))
      {
        ((ArrayList)localObject2).add(paramBlessTask.starAvatorSimple);
        localObject1 = localObject2;
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      paramBoolean = true;
      if (!((Iterator)localObject2).hasNext()) {
        break label550;
      }
      str1 = (String)((Iterator)localObject2).next();
      localObject1 = getFileNameFromUrl(str1);
      if ((TextUtils.isEmpty(str1)) || (!str1.equals(paramBlessTask.starVideo))) {
        break label555;
      }
      localObject1 = arwv.encodeHexStr(str1);
      paramBlessTask.ex1 = ((String)localObject1);
    }
    label545:
    label550:
    label555:
    for (int i = 1;; i = 0)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "checkBannersReady error banner: " + str1);
        return false;
        localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.mainBanner, paramBlessTask.mainCenter, paramBlessTask.typeBanner, paramBlessTask.succeededBanner, paramBlessTask.defaultVoice }));
        if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrl)) {
          ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrl);
        }
        if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrlSimple)) {
          ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrlSimple);
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramBlessTask.ptvAnimationUrl)) {
          break label68;
        }
        ((ArrayList)localObject2).add(paramBlessTask.ptvAnimationUrl);
        localObject1 = localObject2;
        break label68;
      }
      String str2 = this.aYG + (String)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "checkBannersReady: " + str1 + " urlPath=" + str2 + "  fileName=" + (String)localObject1);
      }
      if (!new File(str2).exists())
      {
        dI(str1, str2);
        if (!QLog.isColorLevel()) {
          break label545;
        }
        QLog.d("BlessManager", 2, "checkBannersReady no banner: " + str2);
        paramBoolean = false;
      }
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.aYG + paramBlessTask.starVideoCoverFolderName + File.separator + paramBlessTask.starVideoCoverFileName;
          if ((VersionUtils.isIceScreamSandwich()) && (!new File((String)localObject1).exists()))
          {
            cjm();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + str2);
            }
            paramBoolean = false;
            continue;
            return paramBoolean;
          }
        }
      }
    }
  }
  
  private boolean aa(String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Date localDate1 = getDate(paramString1);
    Date localDate2 = getDate(paramString2);
    if ((localDate1 == null) || (localDate2 == null)) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "isInTime now=" + l + "  beginDate.getTime():" + localDate1.getTime() + "  endDate.getTime():" + localDate2.getTime());
      }
      if ((l > localDate1.getTime()) && (l < localDate2.getTime())) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "not in time" + paramString1 + " " + paramString2);
    return false;
  }
  
  private void bh(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  private void cje()
  {
    Object localObject2 = null;
    Object localObject1 = this.mApp.getPreferences();
    this.jdField_a_of_type_Yme = yme.a((SharedPreferences)localObject1, 1);
    this.jdField_b_of_type_Yme = yme.a((SharedPreferences)localObject1, 2);
    Object localObject3 = aqmk.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    if (localObject3 != null)
    {
      this.qZ = new ArrayList((Collection)localObject3);
      this.aYF = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("initUinSendRecordFromSp sendWording=").append(this.aYF).append(" uinListToSend=");
        if (this.qZ != null) {
          break label183;
        }
        localObject1 = this.qZ;
        label112:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" blessUinList=");
        if (this.jdField_a_of_type_Yme != null) {
          break label197;
        }
        localObject1 = null;
        label133:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" webUinList=");
        if (this.jdField_b_of_type_Yme != null) {
          break label211;
        }
      }
    }
    label183:
    label197:
    label211:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(this.jdField_b_of_type_Yme.size()))
    {
      QLog.d("BlessManager", 2, localObject1);
      return;
      this.qZ = new ArrayList();
      break;
      localObject1 = Integer.valueOf(this.qZ.size());
      break label112;
      localObject1 = Integer.valueOf(this.jdField_a_of_type_Yme.size());
      break label133;
    }
  }
  
  private void cjf()
  {
    Object localObject1 = this.mApp.a().createEntityManager();
    Object localObject2 = (ArrayList)((EntityManager)localObject1).query(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.qX = ((ArrayList)((EntityManager)localObject1).query(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.qY = ((ArrayList)((EntityManager)localObject1).query(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((EntityManager)localObject1).close();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("initTaskAndModuleFromDB task=");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
        break label248;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" blessWordings=").append(this.qY).append(" module=");
      if (this.qX != null) {
        break label259;
      }
    }
    label259:
    for (localObject1 = this.qX;; localObject1 = Integer.valueOf(this.qX.size()))
    {
      QLog.d("BlessManager", 2, localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
        break label273;
      }
      this.bnl = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
      Ah(this.bnl);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
      return;
      label248:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.toString();
      break;
    }
    label273:
    Ah(false);
  }
  
  private void cjl()
  {
    Object localObject;
    label150:
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.qX != null))
    {
      localObject = new ArrayList(Arrays.asList(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice }));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
      }
      Iterator localIterator = ((ArrayList)localObject).iterator();
      break label217;
      if (!localIterator.hasNext()) {
        break label466;
      }
      str = (String)localIterator.next();
      localObject = getFileNameFromUrl(str);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo))) {
        break label461;
      }
      localObject = arwv.encodeHexStr(str);
      i = 1;
      label208:
      if (localObject != null) {
        break label218;
      }
      Ah(false);
    }
    label456:
    label461:
    label466:
    label469:
    for (;;)
    {
      label217:
      return;
      label218:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label150;
      }
      localObject = this.aYG + (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label150;
      }
      if (!new File((String)localObject).exists())
      {
        if (!QLog.isColorLevel()) {
          break label456;
        }
        QLog.d("BlessManager", 2, "checkAllDownloaded no banner: " + (String)localObject);
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label469;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "check Modules and banners all ready");
        }
        if ((this.qY == null) || (this.qY.size() <= 0)) {
          break;
        }
        this.bnl = true;
        Ah(true);
        return;
        if (i == 0) {
          break label150;
        }
        str = this.aYG + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
        if ((!VersionUtils.isIceScreamSandwich()) || (new File(str).exists())) {
          break label150;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + (String)localObject);
          i = 0;
        }
        else
        {
          i = 0;
          continue;
          i = 0;
          break label208;
          i = 1;
        }
      }
    }
  }
  
  @TargetApi(10)
  private void cjm()
  {
    if ((VersionUtils.isIceScreamSandwich()) && (!this.bnj)) {
      ThreadManager.post(new BlessManager.4(this), 5, null, false);
    }
  }
  
  private void dI(String paramString1, String paramString2)
  {
    if (aqiw.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download 2g give up " + paramString2);
      }
    }
    do
    {
      return;
      localaquz = (aquz)this.db.get(paramString2);
      if (localaquz == null) {
        break label144;
      }
      if ((localaquz.getStatus() != 2) && (localaquz.getStatus() != 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "download duplicated " + paramString2);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "download task status error, cancel it " + paramString2);
    }
    localaquz.cancel(true);
    label144:
    aquz localaquz = new aquz(paramString1, new File(paramString2));
    localaquz.cWw = true;
    aqvc localaqvc = ((aqva)this.mApp.getManager(47)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.db.put(paramString2, localaquz);
    localaqvc.a(localaquz, new yln(this, paramString2, paramString1), null);
  }
  
  private void da(ArrayList<BlessPtvModule> paramArrayList)
  {
    if (paramArrayList == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.aYG).listFiles();
    } while (arrayOfFile == null);
    int j = 0;
    label28:
    if (j < arrayOfFile.length) {
      if ((arrayOfFile[j].getName().endsWith(".zip")) && (!arrayOfFile[j].isDirectory())) {
        break label68;
      }
    }
    label68:
    label77:
    label252:
    for (;;)
    {
      j += 1;
      break label28;
      break;
      String str1 = null;
      Iterator localIterator = paramArrayList.iterator();
      int i;
      if (localIterator.hasNext())
      {
        BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
        str1 = localBlessPtvModule.id;
        String str2 = localBlessPtvModule.id + ".zip";
        if (arrayOfFile[j].getName().equals(str2)) {
          if (localBlessPtvModule.broken)
          {
            localBlessPtvModule.broken = false;
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label252;
        }
        arrayOfFile[j].delete();
        aqhq.cn(this.aYG + str1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "deleteOldModules=" + arrayOfFile[j].getName());
        break;
        i = 0;
        continue;
        break label77;
        i = 1;
      }
    }
  }
  
  public static Date getDate(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static int getScreenWidth()
  {
    if (screenWidth <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return screenWidth;
    }
  }
  
  private void i(Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = this.mApp.getApp().getSharedPreferences("bless_config", 4).edit();
    if (paramSet == null) {
      localEditor.remove("config_list");
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putStringSet("config_list", paramSet);
    }
  }
  
  public static String pN()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("bless_config", 4).getString("config_content", "");
  }
  
  private void yP(String paramString)
  {
    SharedPreferences.Editor localEditor = this.mApp.getApp().getSharedPreferences("bless_config", 4).edit();
    localEditor.putString("config_content", paramString);
    localEditor.commit();
  }
  
  private Set<String> z()
  {
    return this.mApp.getApp().getSharedPreferences("bless_config", 4).getStringSet("config_list", null);
  }
  
  public void Ai(boolean paramBoolean)
  {
    this.bnk = paramBoolean;
  }
  
  public void Aj(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onPushCmd: " + paramBoolean);
    }
    if (paramBoolean)
    {
      cjj();
      return;
    }
    cjk();
  }
  
  public boolean TT()
  {
    return this.mApp.a().a().b(acbn.blr, 9003) != null;
  }
  
  public boolean TU()
  {
    return false;
  }
  
  public boolean TV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isStarTime");
    }
    return aa(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starEnd);
  }
  
  public boolean TW()
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    boolean bool2 = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.BlessPTVEnable.name()).equals("1");
    boolean bool3 = VideoEnvironment.n(this.mApp);
    boolean bool4 = VideoEnvironment.auL();
    boolean bool5 = imm.isBeautySupported();
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isPTVEnabled task=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled + " ptvRecord=" + bool3 + " isX86=" + bool4 + " frontCamera=" + true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled == 1) && (bool3) && (!bool4) && (bool5) && (!bool2)) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public boolean TX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled != 1) {
      return true;
    }
    return false;
  }
  
  public boolean TY()
  {
    return this.bnk;
  }
  
  public boolean TZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while ((!VersionUtils.isIceScreamSandwich()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed) || (!TV()) || (!Ua())) {
      return false;
    }
    return true;
  }
  
  public BlessTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  }
  
  public MessageForShortVideo a()
  {
    MessageForShortVideo localMessageForShortVideo = this.m;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getPtvMessage: " + localMessageForShortVideo);
    }
    return localMessageForShortVideo;
  }
  
  public ujt.a a(int paramInt1, int paramInt2)
  {
    ujt.a locala = new ujt.a();
    locala.bEU = 0;
    if (paramInt1 == 2) {
      locala.bEV = 1;
    }
    for (;;)
    {
      locala.FB = paramInt2;
      return locala;
      if (paramInt1 == 3) {
        locala.bEV = 4;
      } else {
        locala.bEV = 0;
      }
    }
  }
  
  public Drawable aG()
  {
    Object localObject2 = BaseApplication.getContext().getResources().getDrawable(2130838926);
    boolean bool = anlm.Vr();
    Object localObject3;
    Object localObject1;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null))
    {
      if ((this.ec == null) || (this.bnm != bool))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl;
        localObject1 = localObject3;
        if (bool)
        {
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple;
          }
        }
        localObject1 = getFileNameFromUrl((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.aYG + (String)localObject1;
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          i = wja.dp2px(50.0F, BaseApplication.getContext().getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
          this.ec = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      if (this.ec != null)
      {
        localObject1 = this.ec;
        this.bnm = bool;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TZ())
      {
        if ((this.eb == null) || (this.bnm != bool))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator;
          localObject2 = localObject3;
          if (bool)
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple)) {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple;
            }
          }
          localObject2 = getFileNameFromUrl((String)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = this.aYG + (String)localObject2;
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            i = wja.dp2px(50.0F, BaseApplication.getContext().getResources());
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
            this.eb = URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3);
          }
        }
        localObject2 = localObject1;
        if (this.eb != null)
        {
          localObject2 = this.eb;
          this.bnm = bool;
        }
      }
      return localObject2;
      localObject1 = localObject2;
    }
  }
  
  public String ay(String paramString1, String paramString2)
  {
    paramString1 = getShareUrl() + "&uuid=" + paramString1 + "&md5=" + paramString2 + "&nick=";
    return paramString1 + aqgo.encodeToString(this.mApp.getCurrentNickname().getBytes(), 2);
  }
  
  public ArrayList<String> bL()
  {
    return this.qZ;
  }
  
  public ArrayList<String> bM()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.aYF)) {
      localArrayList.add(this.aYF);
    }
    if (this.qY != null)
    {
      Iterator localIterator = this.qY.iterator();
      while (localIterator.hasNext())
      {
        BlessWording localBlessWording = (BlessWording)localIterator.next();
        if (localBlessWording.hasEditingWording()) {
          localArrayList.add(localBlessWording.getEditingWording());
        } else {
          localArrayList.add(localBlessWording.wording);
        }
      }
    }
    return localArrayList;
  }
  
  public String cO(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return null;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
    }
    while (str != null)
    {
      return this.aYG + File.separator + str;
      str = getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner);
      continue;
      str = getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner);
    }
  }
  
  public void cjg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "clearBlessConfigs");
    }
    i(null);
    a(null, null, null);
    Ah(false);
  }
  
  public void cjh()
  {
    this.qZ.clear();
    aqmk.a(this.mApp.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  public void cji()
  {
    if (this.qY != null)
    {
      Iterator localIterator = this.qY.iterator();
      while (localIterator.hasNext()) {
        ((BlessWording)localIterator.next()).setEditingWording(null);
      }
    }
  }
  
  public void cjj()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = true;
      localEntityManager = this.mApp.a().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
    }
    try
    {
      localEntityTransaction.begin();
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localEntityTransaction.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityManager.close();
    Ah(false);
  }
  
  public void cjk()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted false");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = false;
      localEntityManager = this.mApp.a().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
    }
    try
    {
      localEntityTransaction.begin();
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localEntityTransaction.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityManager.close();
  }
  
  public void cjn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "check entrance.  nextTask:" + this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
    }
    if (!TU())
    {
      acxw localacxw = this.mApp.a().a();
      RecentUser localRecentUser = localacxw.b(acbn.blr, 9003);
      if (localRecentUser != null) {
        a(localacxw, localRecentUser);
      }
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (aa(this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1) && (!this.bnn))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.eG);
      ThreadManager.getSubThreadHandler().post(this.eG);
    }
  }
  
  public void cjo()
  {
    ThreadManager.post(new BlessManager.5(this), 5, null, true);
  }
  
  public void dq(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu < 3000L) {
      return;
    }
    this.iu = l;
    String str = pM();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", str);
    wgv.c(paramContext, localIntent, str);
  }
  
  public void gF(List<String> paramList)
  {
    this.qZ.clear();
    this.qZ.addAll(paramList);
    aqmk.a(this.mApp.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
  }
  
  public String getFileNameFromUrl(String paramString)
  {
    for (;;)
    {
      try
      {
        String str;
        int i;
        if (paramString.startsWith("http://"))
        {
          str = paramString.substring("http://".length(), paramString.length());
          i = str.lastIndexOf('/');
          if (i == -1) {
            return null;
          }
        }
        else
        {
          if (!paramString.startsWith("https://")) {
            break;
          }
          str = paramString.substring("https://".length(), paramString.length());
          continue;
        }
        int j = str.substring(0, i).lastIndexOf('/');
        if (j != -1)
        {
          i = j;
          j = str.lastIndexOf("?");
          if (j > i) {
            return str.substring(i + 1, j);
          }
          str = str.substring(i + 1);
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "getFileNameFromUrl failed: " + paramString, localThrowable);
        }
        return null;
      }
    }
    return paramString;
  }
  
  public String getShareUrl()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl))) {
      return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl;
  }
  
  public void h(Set<String> paramSet)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramSet.iterator();
    Object localObject6;
    Object localObject8;
    Object localObject7;
    while (localIterator.hasNext())
    {
      localObject6 = (String)localIterator.next();
      localObject8 = new BlessTask();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      boolean bool = BlessTask.parse((String)localObject6, (BlessTask)localObject8, localArrayList1, localArrayList2);
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "onNewConfigReceived tmpNewTask=" + localObject8 + " tmpNewBlessWordings=" + localArrayList2.size() + " tmpNewPtvModules=" + localArrayList1.size() + " result=" + bool);
      }
      if (!bool) {
        break label576;
      }
      localObject7 = getDate(((BlessTask)localObject8).entranceBegin);
      Date localDate = getDate(((BlessTask)localObject8).entranceEnd);
      if ((localObject7 != null) && (localDate != null) && (localDate.getTime() >= l1) && (((BlessTask)localObject8).entranceEnabled == 1))
      {
        localArrayList3.add(localObject8);
        if ((localObject2 == null) || (localObject5 == null) || (((((Date)localObject7).getTime() <= ((Date)localObject5).getTime()) || (((Date)localObject7).getTime() <= l1)) && ((((Date)localObject7).getTime() >= ((Date)localObject5).getTime()) || (((Date)localObject5).getTime() >= l1))))
        {
          localObject5 = localArrayList2;
          localObject4 = localArrayList1;
          localObject3 = localObject8;
          localObject1 = localObject7;
          localObject2 = localObject6;
        }
      }
    }
    for (;;)
    {
      localObject6 = localObject5;
      localObject7 = localObject4;
      localObject8 = localObject3;
      localObject5 = localObject1;
      localObject4 = localObject2;
      localObject1 = localObject6;
      localObject3 = localObject7;
      localObject2 = localObject8;
      break;
      if ((localObject4 != null) && (localObject2 != null))
      {
        a((String)localObject4, localObject2, (ArrayList)localObject3, localObject1);
        localObject4 = null;
        localObject3 = null;
        localObject1 = null;
        if (localArrayList3.size() <= 1) {
          break label517;
        }
        localObject3 = localObject4;
        if (localObject2 == null) {
          break label512;
        }
        localObject4 = getDate(localObject2.entranceBegin);
        l1 = 9223372036854775807L;
        localObject5 = localArrayList3.iterator();
        label415:
        localObject3 = localObject1;
        if (!((Iterator)localObject5).hasNext()) {
          break label512;
        }
        localObject3 = (BlessTask)((Iterator)localObject5).next();
        if (localObject3 == localObject2) {
          break label573;
        }
        localObject6 = getDate(((BlessTask)localObject3).entranceBegin);
        if ((localObject6 == null) || (localObject4 == null)) {
          break label573;
        }
        long l2 = ((Date)localObject6).getTime() - ((Date)localObject4).getTime();
        if ((l2 <= 0L) || (l2 >= l1)) {
          break label573;
        }
        localObject1 = localObject3;
        l1 = l2;
      }
      label512:
      label517:
      label573:
      for (;;)
      {
        break label415;
        cjg();
        break;
        i(paramSet);
        this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "onNewConfigReceived validCount=" + localArrayList3.size() + "  nextTask:" + this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
        }
        return;
      }
      label576:
      localObject6 = localObject2;
      localObject7 = localObject1;
      localObject1 = localObject5;
      localObject2 = localObject4;
      localObject5 = localObject7;
      localObject4 = localObject3;
      localObject3 = localObject6;
    }
  }
  
  public boolean ic(String paramString)
  {
    this.jdField_a_of_type_Yme.bnu();
    return this.jdField_a_of_type_Yme.contains(paramString);
  }
  
  public boolean ie(String paramString)
  {
    this.jdField_b_of_type_Yme.bnu();
    return this.jdField_b_of_type_Yme.contains(paramString);
  }
  
  public void j(MessageForShortVideo paramMessageForShortVideo)
  {
    this.m = paramMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "setPtvMessage: " + paramMessageForShortVideo);
    }
  }
  
  public Boolean k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationSwtich);
  }
  
  public String m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareQzoneTitle;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareWeixinTitle;
  }
  
  public void onDestroy()
  {
    Object localObject = (aqva)this.mApp.getManager(47);
    if (localObject != null)
    {
      localObject = ((aqva)localObject).a(1);
      if (localObject != null) {
        ((aqvc)localObject).a(true, null);
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eG);
  }
  
  public String pG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter);
    } while (str == null);
    return this.aYG + File.separator + str;
  }
  
  public String pH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceHint;
  }
  
  public String pI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.aYG + getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ex1);
      File localFile = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "getStarVideoPath: " + str);
      }
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStarVideoPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public String pJ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.aYG + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
      if (new File(str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStartVideoCoverPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public String pK()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {
      return "";
    }
    String str = getFileNameFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
    if (str == null) {
      return "";
    }
    return this.aYG + File.separator + str;
  }
  
  public String pL()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {}
    String str;
    do
    {
      return "";
      str = pK();
    } while (!str.endsWith(".zip"));
    return str.substring(0, str.length() - 4) + File.separator;
  }
  
  public String pM()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.webBlessUrl))) {
      return "https://ti.qq.com/mass-blessing/index.html?_wv=16777223";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.webBlessUrl;
  }
  
  public void r(int paramInt1, String paramString, int paramInt2)
  {
    if (this.qY == null) {}
    int i;
    do
    {
      return;
      i = paramInt1;
      if (paramInt2 == this.qY.size() + 1) {
        i = paramInt1 - 1;
      }
    } while ((i < 0) || (i >= this.qY.size()));
    ((BlessWording)this.qY.get(i)).setEditingWording(paramString);
  }
  
  public void setRead(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread == 0) {}
      }
      else {
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("BlessManager", 4, "update task to db read=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread + " videoPlayed=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread = -1;
          EntityManager localEntityManager = this.mApp.a().createEntityManager();
          localEntityTransaction = localEntityManager.getTransaction();
          try
          {
            localEntityTransaction.begin();
            localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
            localEntityTransaction.commit();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              localEntityTransaction.end();
            }
          }
          finally
          {
            localEntityTransaction.end();
          }
          localEntityManager.close();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed = true;
        }
      }
    }
  }
  
  public void t(ArrayList<String> paramArrayList, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.mApp.getPreferences();
    String str;
    if (paramInt == 1)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.jdField_a_of_type_Yme.add(str);
      }
      yme.a(localSharedPreferences, this.jdField_a_of_type_Yme, 1);
    }
    while (paramInt != 2) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      this.jdField_b_of_type_Yme.add(str);
    }
    yme.a(localSharedPreferences, this.jdField_b_of_type_Yme, 2);
  }
  
  public int wT()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      i = -1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread > 1) {
      return i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread;
  }
  
  public int wU()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread < 1) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getUnreadNum=1");
    }
    return 1;
  }
  
  public int wV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.uinTotalLimit;
  }
  
  public int wW()
  {
    this.jdField_a_of_type_Yme.bnu();
    return wV() - this.jdField_a_of_type_Yme.size();
  }
  
  public int wX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.sendTotalLimit;
  }
  
  public int wY()
  {
    this.jdField_a_of_type_Yme.bnu();
    int j = wX();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_a_of_type_Yme.getTotalCount();
    }
    return i;
  }
  
  public int wZ()
  {
    return 100;
  }
  
  public int xa()
  {
    return 30;
  }
  
  public int xb()
  {
    this.jdField_b_of_type_Yme.bnu();
    return xa() - this.jdField_b_of_type_Yme.size();
  }
  
  public int xc()
  {
    this.jdField_b_of_type_Yme.bnu();
    int j = wZ();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_b_of_type_Yme.getTotalCount();
    }
    return i;
  }
  
  public int xd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCount;
  }
  
  public int xe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 2000;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCost;
  }
  
  public void yO(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (this.qY != null)
      {
        str = paramString;
        if (this.qY.size() > 0)
        {
          str = paramString;
          if (paramString.equals(((BlessWording)this.qY.get(0)).wording)) {
            str = "";
          }
        }
      }
    } while ((this.aYF != null) && (this.aYF.equals(str)));
    this.aYF = str;
    paramString = this.mApp.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylm
 * JD-Core Version:    0.7.0.1
 */