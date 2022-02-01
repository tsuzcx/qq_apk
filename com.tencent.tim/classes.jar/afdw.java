import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.doutu.DoutuManager.10;
import com.tencent.mobileqq.doutu.DoutuManager.3;
import com.tencent.mobileqq.doutu.DoutuManager.4;
import com.tencent.mobileqq.doutu.DoutuManager.5;
import com.tencent.mobileqq.doutu.DoutuManager.6;
import com.tencent.mobileqq.doutu.DoutuManager.9;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class afdw
  implements Manager
{
  private static long Xp = 512000L;
  private static long Xq = 500L;
  public static final String bDf = aoqr.oz(acbn.SDCARD_PATH + "DoutuRes" + File.separator);
  public static volatile boolean bXy;
  public MqqHandler F;
  private HandlerThread O;
  private long Xl = 15L;
  private long Xm = 15L;
  private long Xn = 1800L;
  private long Xo = 15L;
  public afdt b;
  private boolean bXA = false;
  private boolean bXB = true;
  private boolean bXC = true;
  public boolean bXD;
  private boolean bXz = false;
  private boolean bmW;
  public int cQA = 4;
  private volatile int cQB;
  private volatile int cQC;
  private volatile int cQD;
  private int cQz = 3;
  private EntityManager em;
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> fc = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> fd = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, afdv> fe = new ConcurrentHashMap();
  private Card g;
  public LinearLayout iF;
  private long lastTimeStamp;
  private QQAppInterface mApp;
  private volatile int status = 0;
  private List<DoutuData> zq = new ArrayList();
  private List<DoutuData> zr = new ArrayList();
  public List<String> zs = new ArrayList();
  private List<ChatMessage> zt;
  
  public afdw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.em = this.mApp.a().createEntityManager();
    this.O = ThreadManager.newFreeHandlerThread("DoutuManager", 0);
    this.O.start();
    this.F = new MqqHandler(this.O.getLooper());
  }
  
  private boolean S(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label43:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label43;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public static void a(RelativeLayout paramRelativeLayout, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "doOnChatPieDestory");
    }
    paramQQAppInterface = (afdw)paramQQAppInterface.getManager(214);
    if (paramQQAppInterface != null)
    {
      if ((paramRelativeLayout != null) && (paramQQAppInterface.iF != null)) {
        paramRelativeLayout.removeView(paramQQAppInterface.iF);
      }
      paramQQAppInterface.cYA();
      paramQQAppInterface.cQB = 0;
      paramQQAppInterface.cQD = 0;
      paramQQAppInterface.zt = null;
      paramQQAppInterface.cQC = 0;
    }
  }
  
  private boolean aiP()
  {
    if (!this.bmW) {
      ciY();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "isComboOpen : " + this.bXA + "isDoutuSettingOpen : " + this.bXC);
    }
    return (this.bXA) && (this.bXC) && (this.bXB);
  }
  
  public static boolean an(MessageRecord paramMessageRecord)
  {
    return (ap(paramMessageRecord)) || (ao(paramMessageRecord));
  }
  
  private static boolean ao(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.size > 0L) && (paramMessageRecord.size < Xp) && (paramMessageRecord.width > 0L) && (paramMessageRecord.width < Xq) && (paramMessageRecord.height > 0L) && (paramMessageRecord.height < Xq)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean ap(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      PicMessageExtraData localPicMessageExtraData;
      do
      {
        return false;
        if ((paramMessageRecord instanceof MessageForMarketFace)) {
          return true;
        }
        if (!(paramMessageRecord instanceof MessageForPic)) {
          break;
        }
        paramMessageRecord = (MessageForPic)paramMessageRecord;
        localPicMessageExtraData = paramMessageRecord.picExtraData;
        if ((paramMessageRecord.imageType == 2000) || (paramMessageRecord.imageType == 3) || (paramMessageRecord.imageType == 4)) {
          return true;
        }
      } while ((localPicMessageExtraData == null) || ((localPicMessageExtraData.imageBizType != 1) && (localPicMessageExtraData.imageBizType != 3) && (!localPicMessageExtraData.isHotPics())));
      return true;
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!((MessageForStructing)paramMessageRecord).isHotPicsStruct()));
    return true;
  }
  
  private void cYD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "preLoad, isDoutuOpen() = " + aiO() + ", doutuListPreload.size() = " + this.zq.size());
    }
    if ((aiO()) && (this.zq.size() == 0)) {
      cYC();
    }
  }
  
  private void cYE()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "dropPersistDoutuData ");
    }
    ThreadManager.excute(new DoutuManager.10(this), 32, null, false);
  }
  
  private void ciY()
  {
    this.bXC = aqmj.ay(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bXz = aqmj.ax(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bXA = aqmj.az(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bXD = aqmj.aA(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    long l1 = aqmj.k(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    int i = aqmj.aY(this.mApp.getApp(), this.mApp.getCurrentUin());
    long l2 = aqmj.l(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    long l3 = aqmj.m(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    int j = aqmj.aV(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if (l1 > 0L) {
      this.Xl = l1;
    }
    if (i > 0) {
      this.cQz = i;
    }
    if (l2 > 0L) {
      this.Xm = l2;
    }
    if (l3 > 0L) {
      this.Xo = l3;
    }
    if (j > 0) {
      this.cQA = j;
    }
    this.bmW = true;
  }
  
  private String dU(String paramString)
  {
    try
    {
      str1 = alab.getFileMD5String(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label81;
      }
      for (;;)
      {
        try
        {
          paramString = aszr.getFileMD5String(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label79;
      }
      return "";
      label79:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label81:
      paramString = null;
    }
  }
  
  public static void ej(Context paramContext)
  {
    if (!bXy) {
      aqmj.L(paramContext, true);
    }
  }
  
  private List<DoutuData> ex()
  {
    List localList = null;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "readDoutuDataFromDB ");
    }
    if (this.em != null) {
      localList = this.em.query(DoutuData.class, true, null, null, null, null, null, null);
    }
    return localList;
  }
  
  private void jQ(List<DoutuData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "persistDoutuData ");
    }
    ThreadManager.excute(new DoutuManager.9(this, paramList), 32, null, false);
  }
  
  private boolean lM(String paramString)
  {
    Object localObject = new File(bDf);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        ((File)localObject).delete();
      }
    }
    else {
      return false;
    }
    if (aqmj.bZ(this.mApp.getApp()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkLocalResFiles : isDoutuResDamaged !");
      }
      aqhq.delete(bDf, false);
      return false;
    }
    if ((((File)localObject).listFiles() == null) || (((File)localObject).listFiles().length == 0))
    {
      aqhq.delete(bDf, false);
      return false;
    }
    localObject = new File(bDf + "doutuResInfo");
    if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
    {
      try
      {
        localObject = aqhq.readFileToString((File)localObject);
        if ((QLog.isColorLevel()) && (paramString != null) && (localObject != null)) {
          QLog.d("DoutuManager", 2, "checkLocalResFiles: md5Record = " + (String)localObject + ", md5 = " + paramString);
        }
        if ((localObject == null) || (paramString == null) || (((String)localObject).length() == 0) || (paramString.length() == 0) || (!paramString.equals(localObject)))
        {
          aqhq.delete(bDf, false);
          return false;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        aqhq.delete(bDf, false);
        return false;
      }
      return true;
    }
    aqhq.delete(bDf, false);
    return false;
  }
  
  private void sv(String paramString)
  {
    String str = bDf;
    try
    {
      aqhq.W(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DoutuManager", 2, "[unzip]", paramString);
    }
  }
  
  public void HI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "doOnLogin, isFirstLogin = " + paramBoolean);
    }
    initData();
    if ((aqiw.isWifiEnabled(BaseApplication.getContext())) && (!paramBoolean)) {
      cYF();
    }
  }
  
  public void HJ(boolean paramBoolean)
  {
    this.bXB = paramBoolean;
  }
  
  public void P(boolean paramBoolean, List<DoutuData> paramList)
  {
    DoutuData localDoutuData;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleGetDoutuList : isSuccess = " + paramBoolean);
      }
      if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0)) {
        break label497;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleGetDoutuList : dataList.size() = " + paramList.size());
      }
      this.zq.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localDoutuData = (DoutuData)paramList.next();
        this.zq.add(localDoutuData);
      }
      jQ(this.zq);
    }
    finally {}
    if ((this.b != null) && (this.zr.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "add data to doutuListShowing");
      }
      paramList = this.zq.iterator();
      while (paramList.hasNext())
      {
        localDoutuData = (DoutuData)paramList.next();
        if (this.zr.size() < 20)
        {
          this.zr.add(localDoutuData);
          if (!TextUtils.isEmpty(localDoutuData.pic_md5)) {
            this.zs.add(localDoutuData.pic_md5);
          }
        }
      }
      this.b.zp = new ArrayList();
      this.b.zp.addAll(this.zr);
      this.zq.clear();
      cYE();
      this.b.resetData();
      if (this.b.q != null) {
        this.b.q.sendEmptyMessage(81);
      }
    }
    int i;
    if (this.zq.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if ((i < 9) && (i < this.zq.size()))
      {
        localDoutuData = (DoutuData)this.zq.get(i);
        if (localDoutuData == null) {}
      }
      else
      {
        label497:
        label505:
        for (;;)
        {
          try
          {
            paramList = localDoutuData.thumb_down_url;
            if (!paramList.startsWith("https")) {
              break label505;
            }
            paramList = paramList.replaceFirst("https", "http");
            paramList = new URL(paramList);
          }
          catch (MalformedURLException paramList)
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions;
            QLog.e("DoutuManager", 1, "getView url exception e = " + paramList.getMessage());
            paramList = null;
            continue;
          }
          if (paramList == null) {
            break;
          }
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mExtraInfo = localDoutuData;
          URLDrawable.getDrawable(paramList, localURLDrawableOptions).startDownload();
          break;
          this.status = 0;
          return;
        }
      }
      i += 1;
    }
  }
  
  public void a(afdv paramafdv, SessionInfo paramSessionInfo, long paramLong)
  {
    ThreadManager.post(new DoutuManager.4(this, paramafdv, paramLong, paramSessionInfo), 5, null, true);
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler, afdv paramafdv)
  {
    if (paramViewGroup == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : parentView is null.");
      }
      return;
    }
    finally {}
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131366052);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuLayout != null.");
      }
      this.iF = ((LinearLayout)localObject);
      paramViewGroup = (DoutuEmotionHorizonListView)this.iF.findViewById(2131366055);
      this.b = ((afdt)paramViewGroup.getAdapter());
      if (this.b == null)
      {
        this.b = new afdt(paramContext, this.mApp, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.bXD, paramafdv, this.cQA);
        paramViewGroup.setAdapter(this.b);
      }
      cYB();
    }
    for (;;)
    {
      if ((this.lastTimeStamp <= 0L) || (System.currentTimeMillis() - this.lastTimeStamp <= 0L) || (System.currentTimeMillis() - this.lastTimeStamp >= 1000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : not frequency click.");
        }
        this.b = new afdt(paramContext, this.mApp, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.bXD, paramafdv, this.cQA);
        paramViewGroup.setAdapter(this.b);
        if (this.zq.size() <= 0) {
          break label825;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuListPreload.size() > 0.");
        }
        this.zr.clear();
        this.zs.clear();
        paramContext = this.zq.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            paramBaseActivity = (DoutuData)paramContext.next();
            if (this.zr.size() < 20)
            {
              this.zr.add(paramBaseActivity);
              if (!TextUtils.isEmpty(paramBaseActivity.pic_md5))
              {
                this.zs.add(paramBaseActivity.pic_md5);
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuLayout == null.");
                }
                this.iF = ((LinearLayout)View.inflate(paramContext, 2131558646, null));
                localObject = (DoutuEmotionHorizonListView)this.iF.findViewById(2131366055);
                this.b = new afdt(paramContext, this.mApp, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.bXD, paramafdv, this.cQA);
                ((DoutuEmotionHorizonListView)localObject).setAdapter(this.b);
                ((DoutuEmotionHorizonListView)localObject).setOnScrollStateChangedListener(new afdx(this));
                ((DoutuEmotionHorizonListView)localObject).setTouchListener(new afdz(this, paramMqqHandler));
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                localLayoutParams.addRule(2, 2131369277);
                localLayoutParams.addRule(11);
                paramViewGroup.addView(this.iF, localLayoutParams);
                paramViewGroup = (ViewGroup)localObject;
                break;
              }
            }
          }
        }
        if (this.b != null)
        {
          this.b.zp = new ArrayList();
          this.b.zp.addAll(this.zr);
        }
        this.zq.clear();
        cYE();
        label568:
        if (this.b != null)
        {
          this.b.resetData();
          this.b.notifyDataSetChanged();
        }
        this.lastTimeStamp = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramBaseActivity = new StringBuilder().append("showDoutuEmotionLayout isSmartSwitchNew:").append(this.bXD).append(", defaultCount:").append(this.cQA).append(", ");
          if (paramafdv == null) {
            break label863;
          }
        }
      }
    }
    label825:
    label863:
    for (paramContext = paramafdv.toString();; paramContext = "")
    {
      QLog.d("DoutuManager", 2, paramContext);
      if ((paramafdv != null) && (paramafdv.isValid()) && (this.bXD) && (this.b != null))
      {
        this.fe.put(Long.valueOf(this.b.Ki), new afdv(this.b.Ki, 0));
        a(paramafdv, paramSessionInfo, this.b.Ki);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        paramViewGroup.setScrollX(0);
      }
      this.iF.setVisibility(0);
      anot.a(this.mApp, "dc00898", "", "", "0X8007FA9", "0X8007FA9", 0, 0, "", "", "", "");
      if (paramMqqHandler == null) {
        break;
      }
      paramMqqHandler.removeMessages(80);
      paramMqqHandler.sendEmptyMessageDelayed(80, 5000L);
      break;
      if (this.status != 0) {
        break label568;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : status == STATUS_GETTING_DOUTU_IDEL.");
      }
      this.zr.clear();
      cYC();
      break label568;
    }
  }
  
  public void a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramSessionInfo != null)) {}
  }
  
  public void a(boolean paramBoolean, List<DoutuData> paramList, long paramLong)
  {
    boolean bool = true;
    Object localObject;
    if (this.fe.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (afdv)this.fe.get(Long.valueOf(paramLong));
      ((afdv)localObject).count += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleGetRecommendPicList isSuccess:").append(paramBoolean).append(", key:").append(paramLong).append(", type:, responseCount:");
      if (this.fe.get(Long.valueOf(paramLong)) == null) {
        break label268;
      }
      i = ((afdv)this.fe.get(Long.valueOf(paramLong))).count;
      localObject = ((StringBuilder)localObject).append(i).append(", size:");
      if (paramList != null) {
        break label274;
      }
    }
    DoutuData localDoutuData;
    label268:
    label274:
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("DoutuManager", 2, i);
      localObject = new ArrayList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label285;
      }
      i = 0;
      while (i < paramList.size())
      {
        localDoutuData = (DoutuData)paramList.get(i);
        if ((!TextUtils.isEmpty(localDoutuData.pic_md5)) && (!this.zs.contains(localDoutuData.pic_md5)))
        {
          ((List)localObject).add(localDoutuData);
          this.zs.add(localDoutuData.pic_md5);
        }
        i += 1;
      }
      i = 0;
      break;
    }
    label285:
    if (((List)localObject).size() >= 0)
    {
      i = 0;
      if (i < ((List)localObject).size())
      {
        localDoutuData = (DoutuData)((List)localObject).get(i);
        if (localDoutuData == null) {}
      }
    }
    label533:
    for (;;)
    {
      try
      {
        paramList = localDoutuData.thumb_down_url;
        if (!paramList.startsWith("https")) {
          break label533;
        }
        paramList = paramList.replaceFirst("https", "http");
        paramList = new URL(paramList);
      }
      catch (MalformedURLException paramList)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        QLog.e("DoutuManager", 1, "getView url exception e = " + paramList.getMessage());
        paramList = null;
        continue;
      }
      if (paramList != null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = localDoutuData;
        URLDrawable.getDrawable(paramList, localURLDrawableOptions).startDownload();
      }
      i += 1;
      break;
      if ((this.fe.get(Long.valueOf(paramLong)) != null) && (((afdv)this.fe.get(Long.valueOf(paramLong))).count >= 1)) {}
      for (;;)
      {
        if ((this.b != null) && (this.b.Ki == paramLong)) {
          ThreadManager.getUIHandler().post(new DoutuManager.5(this, paramBoolean, (List)localObject, bool, paramLong));
        }
        if (bool) {
          this.fe.remove(Long.valueOf(paramLong));
        }
        return;
        bool = false;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean3, int paramInt)
  {
    this.bXz = paramBoolean1;
    this.bXA = paramBoolean2;
    this.bXD = paramBoolean3;
    if (paramLong1 > 0L) {
      this.Xl = paramLong1;
    }
    if (paramLong2 > 0L) {
      this.Xm = paramLong2;
    }
    if (paramLong3 > 0L) {
      this.Xo = paramLong3;
    }
    if (paramInt > 0) {
      this.cQA = paramInt;
    }
  }
  
  public boolean aiO()
  {
    return false;
  }
  
  public void cYA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "hideDoutuEmotionLayout.");
    }
    if (this.iF != null)
    {
      cYB();
      this.iF.setVisibility(8);
      this.iF = null;
      this.b = null;
      this.zr.clear();
      this.zs.clear();
      cYD();
    }
  }
  
  public void cYB()
  {
    if (this.b == null) {}
    while ((this.b.kg == null) && (this.b.b == null)) {
      return;
    }
    Object localObject1 = new afea();
    ((afea)localObject1).dcId = "dc03631";
    localObject1.getClass();
    Object localObject2 = new afea.a((afea)localObject1);
    ((afea.a)localObject2).user_id = String.valueOf(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue());
    if (this.b.b != null)
    {
      ((afea.a)localObject2).aXR = this.b.b.pic_md5;
      ((afea.a)localObject2).click_url = this.b.b.pic_down_url;
    }
    if (this.b.a != null)
    {
      ((afea.a)localObject2).bDh = this.b.a.url;
      ((afea.a)localObject2).bDg = this.b.a.md5;
    }
    if ((this.b.kg != null) && (this.b.kg.size() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.b.kg.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList1.add(str);
        localArrayList2.add(this.b.kg.get(str));
      }
      ((afea.a)localObject2).vY = localArrayList1;
      ((afea.a)localObject2).vZ = localArrayList2;
    }
    int i;
    if (this.b.mSessionInfo != null)
    {
      i = this.b.mSessionInfo.cZ;
      if (i != 0) {
        break label401;
      }
      ((afea.a)localObject2).aXN = "c2c";
    }
    for (;;)
    {
      ((afea.a)localObject2).aXO = this.b.mSessionInfo.aTl;
      ((afea.a)localObject2).mobile_type = "android";
      ((afea)localObject1).a = ((afea.a)localObject2);
      localObject1 = ((afea)localObject1).V();
      localObject2 = new NewIntent(this.mApp.getApp(), afeb.class);
      ((NewIntent)localObject2).putExtra("KEY_CMD", 5);
      ((NewIntent)localObject2).putExtra("key_report_content", ((JSONObject)localObject1).toString());
      this.b.b = null;
      this.b.kg = null;
      this.mApp.startServlet((NewIntent)localObject2);
      return;
      label401:
      if (i == 1) {
        ((afea.a)localObject2).aXN = "group";
      } else if (i == 3000) {
        ((afea.a)localObject2).aXN = "discuss";
      } else {
        ((afea.a)localObject2).aXN = "other";
      }
    }
  }
  
  public void cYC()
  {
    ThreadManager.post(new DoutuManager.3(this), 5, null, true);
  }
  
  public void cYF()
  {
    if (bXy)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : isLoadingRes = true");
      }
      return;
    }
    bXy = true;
    if ((!aiO()) && (!aiP()))
    {
      bXy = false;
      return;
    }
    String str1 = aqmj.ae(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    String str2 = aqmj.ad(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if ((QLog.isColorLevel()) && (str1 != null) && (str2 != null)) {
      QLog.d("DoutuManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + str2);
    }
    if ((str1 == null) || (str1.length() == 0) || (str2 == null) || (str2.length() == 0))
    {
      bXy = false;
      return;
    }
    if (!lM(str1))
    {
      String str3 = bDf + "DoutuRes.zip";
      aquz localaquz = new aquz(str2, new File(str3));
      localaquz.cWw = true;
      aqvc localaqvc = ((aqva)this.mApp.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [download] startDownload: " + str2 + " path=" + str3);
      }
      localaqvc.a(localaquz, new afdy(this, str2, str3, str1), null);
      return;
    }
    DuiButtonImageView.aiQ();
    bXy = false;
  }
  
  public void initData()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "initData ");
      }
      Object localObject1 = ex();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.zq.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoutuData localDoutuData = (DoutuData)((Iterator)localObject1).next();
          this.zq.add(localDoutuData);
        }
      }
    }
    finally {}
  }
  
  public void jc(long paramLong)
  {
    Object localObject;
    if (this.fe.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (afdv)this.fe.get(Long.valueOf(paramLong));
      ((afdv)localObject).count += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleGetRecommendPicTimeOut key:").append(paramLong).append(", smartCount:");
      if (this.fe.get(Long.valueOf(paramLong)) == null) {
        break label203;
      }
    }
    label203:
    for (int i = ((afdv)this.fe.get(Long.valueOf(paramLong))).count;; i = 0)
    {
      QLog.i("DoutuManager", 2, i);
      if ((this.fe.get(Long.valueOf(paramLong)) != null) && (((afdv)this.fe.get(Long.valueOf(paramLong))).count >= 1))
      {
        this.fe.remove(Long.valueOf(paramLong));
        if ((this.b != null) && (this.b.Ki == paramLong)) {
          ThreadManager.getUIHandler().post(new DoutuManager.6(this, paramLong));
        }
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.iF = null;
    this.b = null;
    try
    {
      if (this.F != null) {
        this.F.removeCallbacksAndMessages(null);
      }
      if (this.O != null) {
        this.O.quit();
      }
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    this.O = null;
    this.F = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdw
 * JD-Core Version:    0.7.0.1
 */