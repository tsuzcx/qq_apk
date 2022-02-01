import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.4;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.7;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.os.MqqHandler;

public class afhl
{
  private static Executor mExecutor;
  private afhj jdField_b_of_type_Afhj;
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new afhm(this);
  private QQAppInterface mApp;
  private Context mContext;
  private Handler uiHandler = new Handler(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
  private final List<Integer> zI = Arrays.asList(new Integer[] { Integer.valueOf(-2000), Integer.valueOf(-1035), Integer.valueOf(-2006) });
  private final List<Integer> zJ = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3000) });
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.poolThreadName = "groupemostore_pool";
    localThreadPoolParams.corePoolsize = 2;
    localThreadPoolParams.maxPooolSize = 2;
    localThreadPoolParams.priority = 5;
    localThreadPoolParams.queue = new LinkedBlockingQueue();
    localThreadPoolParams.keepAliveTime = 10;
    mExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public afhl(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = this.mApp.getApp();
    this.jdField_b_of_type_Afhj = ((afhj)this.mApp.getManager(259));
  }
  
  private String kA(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      String str = this.mApp.getCurrentAccountUin();
      return acbn.bmd + aczs.jH(str) + paramString + ".jpg";
    }
    return "";
  }
  
  public int CY()
  {
    return (this.mContext.getResources().getDisplayMetrics().widthPixels - ankt.dip2px(11.0F) * 2 - ankt.dip2px(2.0F) * 2) / 3;
  }
  
  public int CZ()
  {
    int k = 0;
    int j = 0;
    Object localObject = (afhu)this.mApp.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from getFavEmoCount.");
    }
    localObject = ((afhu)localObject).ez();
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (!((List)localObject).isEmpty()) {
        for (i = 0; j < ((List)localObject).size(); i = k)
        {
          if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(j)).RomaingType))
          {
            k = i;
            if ("needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {}
          }
          else
          {
            k = i + 1;
          }
          j += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "emoCount: " + i);
    }
    return i;
  }
  
  public void HU(String paramString)
  {
    MqqHandler localMqqHandler;
    Object localObject;
    if (this.mApp != null)
    {
      localMqqHandler = this.mApp.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject = eG();
        if (localObject != null) {
          break label39;
        }
        QLog.e("EmoticonFromGroup_Manager", 1, "save to WY, datas is null.");
      }
    }
    return;
    label39:
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (EmoticonFromGroupEntity)localIterator.next();
    } while (!paramString.equals(((EmoticonFromGroupEntity)localObject).md5));
    for (paramString = (String)localObject;; paramString = null)
    {
      if (paramString != null)
      {
        if (paramString.msg != null)
        {
          if ((acfx.W(paramString.msg)) || (acei.W(paramString.msg))) {
            ahao.OS(2131693822);
          }
        }
        else
        {
          QLog.e("EmoticonFromGroup_Manager.msgnull", 1, "save2WY msg is null.");
          return;
        }
        this.mApp.a().a().a(paramString.msg, new afhl.a(localMqqHandler));
        this.uiHandler.sendEmptyMessage(1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("EmoticonFromGroup_Manager", 2, "save2WY, tarEmo is null.");
      return;
    }
  }
  
  public int a(URLDrawable paramURLDrawable)
  {
    int j = -1;
    int i = j;
    String str;
    if (paramURLDrawable != null)
    {
      i = j;
      if (1 == paramURLDrawable.getStatus())
      {
        str = paramURLDrawable.getURL().toString();
        i = j;
        if (aoiz.hasFile(str))
        {
          Object localObject = aoiz.getFile(str);
          str = null;
          if (localObject != null) {
            str = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
          }
          i = j;
          if (str != null)
          {
            i = j;
            if (!"".equals(str))
            {
              localObject = this.mApp.getCurrentAccountUin();
              str = acbn.bmd + aczs.jH((String)localObject) + str + ".jpg";
            }
          }
        }
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Emo.onUploadPic", 2, "addEmoticonToServer urldrawable status: " + paramURLDrawable.getStatus());
      }
      paramURLDrawable.saveTo(str);
      i = xtm.s(this.mContext, str);
      return i;
    }
    catch (IOException paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
    }
    return -1;
  }
  
  public Drawable a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (65537 == paramInt1)
        {
          localURLDrawableOptions.mRequestWidth = paramInt2;
          localURLDrawableOptions.mRequestHeight = paramInt2;
          paramDrawable = new URL(paramEmoticonFromGroupEntity.thumbURL + "?noRound");
          if (paramDrawable != null)
          {
            paramDrawable = URLDrawable.getDrawable(paramDrawable, localURLDrawableOptions);
            if (paramEmoticonFromGroupEntity.msg == null) {
              break;
            }
            paramDrawable.setTag(paramEmoticonFromGroupEntity.msg);
            return paramDrawable;
          }
        }
        else
        {
          if (1 != paramInt1) {
            break label164;
          }
          if (paramEmoticonFromGroupEntity.gifImg) {
            localURLDrawableOptions.mPlayGifImage = true;
          }
          if (paramDrawable != null)
          {
            localURLDrawableOptions.mLoadingDrawable = paramDrawable;
            localURLDrawableOptions.mFailedDrawable = paramDrawable;
          }
          paramDrawable = new URL(paramEmoticonFromGroupEntity.bigURL);
          continue;
        }
        return null;
      }
      catch (MalformedURLException paramEmoticonFromGroupEntity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "group emo new URL error!");
        }
        paramEmoticonFromGroupEntity.printStackTrace();
      }
      label164:
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "URLString get type error!");
      }
      paramDrawable = null;
    }
    return paramDrawable;
  }
  
  public EmoticonFromGroupEntity a(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = new EmoticonFromGroupEntity();
    localEmoticonFromGroupEntity.troopUin = paramMessageRecord.frienduin;
    localEmoticonFromGroupEntity.fromType = paramMessageRecord.istroop;
    localEmoticonFromGroupEntity.timestamp = paramMessageRecord.time;
    localEmoticonFromGroupEntity.msgseq = paramMessageRecord.shmsgseq;
    MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
    boolean bool;
    if ((localMessageForPic.imageType == 3) || (localMessageForPic.imageType == 2000))
    {
      bool = true;
      localEmoticonFromGroupEntity.gifImg = bool;
      localEmoticonFromGroupEntity.md5 = localMessageForPic.md5;
      paramMessageRecord = aoop.a(localMessageForPic, 65537);
      if (paramMessageRecord != null) {
        break label154;
      }
      paramMessageRecord = null;
      label106:
      localEmoticonFromGroupEntity.thumbURL = paramMessageRecord;
      paramMessageRecord = aoop.a(localMessageForPic, 1);
      if (paramMessageRecord != null) {
        break label162;
      }
    }
    label154:
    label162:
    for (paramMessageRecord = localObject;; paramMessageRecord = paramMessageRecord.toString())
    {
      localEmoticonFromGroupEntity.bigURL = paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "addBaseInfoToEmoticonFromGroupEntity");
      }
      return localEmoticonFromGroupEntity;
      bool = false;
      break;
      paramMessageRecord = paramMessageRecord.toString();
      break label106;
    }
  }
  
  public MessageForPic a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return null;
    }
    Object localObject1 = this.mApp.b().c(paramEmoticonFromGroupEntity.troopUin, paramEmoticonFromGroupEntity.fromType, paramEmoticonFromGroupEntity.msgseq);
    if (localObject1 != null)
    {
      if ((localObject1 instanceof MessageForPic)) {
        return (MessageForPic)localObject1;
      }
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        Iterator localIterator = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (MessageRecord)localIterator.next();
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            if (((MessageForPic)localObject2).md5.equals(paramEmoticonFromGroupEntity.md5))
            {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject2, (MessageForMixedMsg)localObject1);
              return localObject2;
            }
          }
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext, MessageForPic paramMessageForPic, View paramView)
  {
    if (paramMessageForPic == null) {
      return;
    }
    paramView = sxx.getViewRect(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    localBundle.putBoolean("IS_APP_SHARE_PIC", true);
    localBundle.putBoolean("group.emo.big.preview", true);
    localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
    avfp.a(paramContext, localBundle, new AIOImageProviderService(paramMessageForPic.selfuin, null, -1, paramMessageForPic), xtm.a(paramMessageForPic), -1, -1);
  }
  
  public boolean a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (this.jdField_b_of_type_Afhj.cQU < 1)
    {
      if (300 == afhs.cQV) {
        QQToast.a(this.mContext, 2131689841, 0).show(2131299627);
      }
      do
      {
        do
        {
          return false;
        } while (144 != afhs.cQV);
        new afho(this, (BaseActivity)localObject);
      } while (localObject == null);
      FavEmosmManageActivity.dd((Context)localObject);
      return false;
    }
    localObject = this.jdField_b_of_type_Afhj;
    ((afhj)localObject).cQU -= 1;
    i(paramEmoticonFromGroupEntity);
    QQToast.a(this.mContext, 2, 2131693078, 0).show(2131299627);
    return true;
  }
  
  public void ah(MessageRecord paramMessageRecord)
  {
    if (aq(paramMessageRecord)) {
      this.jdField_b_of_type_Afhj.ag(paramMessageRecord);
    }
  }
  
  public void ai(MessageRecord paramMessageRecord)
  {
    ah(paramMessageRecord);
  }
  
  public boolean ajm()
  {
    boolean bool2 = true;
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.vip_individuation.name());
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.length >= 8)
        {
          bool1 = bool2;
          if ("0".equals(localObject[7])) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean aq(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (this.zJ.contains(Integer.valueOf(paramMessageRecord.istroop)))
      {
        bool1 = bool2;
        if (this.zI.contains(Integer.valueOf(paramMessageRecord.msgtype))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String bp(long paramLong)
  {
    String str = null;
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l);
    if (l >= paramLong)
    {
      l -= paramLong;
      int i;
      if (0L < l)
      {
        if (localTime1.year != localTime2.year) {
          break label226;
        }
        i = (int)Math.ceil(l / 86400000.0D) - 1;
        if (i == 0) {
          str = acfp.m(2131705806);
        }
      }
      else
      {
        return str;
      }
      if (1 == i) {
        return acfp.m(2131705797);
      }
      if (7 > i)
      {
        switch (localTime1.weekDay)
        {
        default: 
          return null;
        case 0: 
          return acfp.m(2131705818);
        case 1: 
          return acfp.m(2131705842);
        case 2: 
          return acfp.m(2131705805);
        case 3: 
          return acfp.m(2131705819);
        case 4: 
          return acfp.m(2131705801);
        case 5: 
          return acfp.m(2131705825);
        }
        return acfp.m(2131705833);
      }
      return g(paramLong, 1);
      label226:
      return g(paramLong, 0);
    }
    return g(paramLong, 0);
  }
  
  public void cZA()
  {
    ThreadManager.post(new EmoticonFromGroupManager.4(this), 5, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Manager", 2, "init mEmoManager.mCountOfSpare:" + this.jdField_b_of_type_Afhj.cQU);
    }
  }
  
  public Drawable e(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (paramInt < 0)) {
      return null;
    }
    int i = paramInt * 2;
    paramInt *= 2;
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, paramInt, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, paramInt);
      paramDrawable.draw(localCanvas);
      return new BitmapDrawable(aqhu.getCircleFaceBitmap((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()));
    }
  }
  
  public List<EmoticonFromGroupEntity> eF()
  {
    return this.jdField_b_of_type_Afhj.eF();
  }
  
  public List<EmoticonFromGroupEntity> eG()
  {
    return this.jdField_b_of_type_Afhj.eE();
  }
  
  public Map<String, List<EmoticonFromGroupEntity>> f(List<EmoticonFromGroupEntity> paramList)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = null;
    Object localObject = localEmoticonFromGroupEntity;
    if (paramList != null)
    {
      localObject = localEmoticonFromGroupEntity;
      if (!paramList.isEmpty())
      {
        localObject = new TreeMap(new afhn(this));
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
          String str = h(localEmoticonFromGroupEntity.timestamp, 2);
          if (((Map)localObject).containsKey(str))
          {
            ((List)((Map)localObject).get(str)).add(localEmoticonFromGroupEntity);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localEmoticonFromGroupEntity);
            ((Map)localObject).put(str, localArrayList);
          }
        }
      }
    }
    return localObject;
  }
  
  public String g(long paramLong, int paramInt)
  {
    String str = null;
    SimpleDateFormat localSimpleDateFormat;
    switch (paramInt)
    {
    default: 
      localSimpleDateFormat = null;
    }
    for (;;)
    {
      if (localSimpleDateFormat != null) {
        str = localSimpleDateFormat.format(new Date(paramLong));
      }
      return str;
      localSimpleDateFormat = new SimpleDateFormat("y年M月d日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("M月d日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
  }
  
  public void g(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.jdField_b_of_type_Afhj.a(paramEmoticonFromGroupEntity, 2);
  }
  
  public boolean g(List<CustomEmotionData> paramList, String paramString)
  {
    paramString = kB(paramString);
    if (!paramList.isEmpty())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.equals(((CustomEmotionData)paramList.next()).md5))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "filter favorite true.");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public String h(long paramLong, int paramInt)
  {
    return g(1000L * paramLong, paramInt);
  }
  
  public void h(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.jdField_b_of_type_Afhj.d(paramEmoticonFromGroupEntity);
  }
  
  public long i(String paramString, int paramInt)
  {
    long l = 0L;
    SimpleDateFormat localSimpleDateFormat = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localSimpleDateFormat != null) {}
      try
      {
        l = localSimpleDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
      localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("MM月dd日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    return 0L;
  }
  
  public String i(String paramString1, int paramInt, String paramString2)
  {
    long l = i(paramString1, 2);
    return bp(l) + paramString2 + "(" + paramInt + ")";
  }
  
  public void i(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    URLDrawable localURLDrawable = (URLDrawable)a(paramEmoticonFromGroupEntity, 1, -1, null);
    if (localURLDrawable == null)
    {
      QLog.e("EmoticonFromGroup_Manager", 1, "get drawable failed: " + paramEmoticonFromGroupEntity);
      return;
    }
    if (1 != localURLDrawable.getStatus())
    {
      this.jdField_b_of_type_Afhj.zG.add(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new afhq(this, localURLDrawable));
      localURLDrawable.startDownload();
    }
    for (;;)
    {
      paramEmoticonFromGroupEntity.status = 0;
      return;
      this.jdField_b_of_type_Afhj.zG.remove(localURLDrawable);
      mExecutor.execute(new EmoticonFromGroupManager.7(this, localURLDrawable));
    }
  }
  
  public String kB(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (aoiz.hasFile(paramString)))
    {
      paramString = aoiz.getFile(paramString);
      if (paramString != null) {
        return SecUtil.getFileMd5(paramString.getAbsolutePath());
      }
    }
    return "";
  }
  
  public void ka(List<MessageRecord> paramList)
  {
    if (!ajm()) {}
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Afhj.CW() >= 600) || (this.jdField_b_of_type_Afhj.CX() >= 300))
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmoticonFromGroup_Manager", 1, "over max limit.");
        }
      }
      else
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.next();
          Integer localInteger = Integer.valueOf(localMessageRecord.msgtype);
          if ((this.zI.contains(localInteger)) && (!acei.W(localMessageRecord)) && (!ajpd.aK(localMessageRecord)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 2, "filterMessageByType type: " + localInteger);
            }
            this.jdField_b_of_type_Afhj.af(localMessageRecord);
          }
        }
      }
    }
  }
  
  public void kb(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_b_of_type_Afhj.T(paramList, 2);
  }
  
  public void kc(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_b_of_type_Afhj.jZ(paramList);
  }
  
  public void kd(List<EmoticonFromGroupEntity> paramList)
  {
    if (!paramList.isEmpty()) {
      QQToast.a(this.mContext, 2, 2131693078, 0).show(2131299627);
    }
    mExecutor.execute(new EmoticonFromGroupManager.5(this, paramList));
  }
  
  public boolean lQ(String paramString)
  {
    boolean bool2 = false;
    Object localObject = (afhu)this.mApp.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "call getEmoticonDataList from EmoticonFromGroupManager.filterFavoriteEmoticonAfterDownload");
    }
    localObject = ((afhu)localObject).ez();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(i)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject).get(i)).RomaingType))) {
          localArrayList.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (!localArrayList.isEmpty())
    {
      localObject = localArrayList.iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((CustomEmotionData)((Iterator)localObject).next()).md5));
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "filterFavoriteEmoticonAfterDownload " + paramString);
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean lR(String paramString)
  {
    Iterator localIterator = eG().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (EmoticonFromGroupEntity)localIterator.next();
    } while ((!paramString.equals(((EmoticonFromGroupEntity)localObject).md5)) || (((EmoticonFromGroupEntity)localObject).status == 0));
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramString;
      this.uiHandler.sendMessage((Message)localObject);
      if (this.jdField_b_of_type_Afhj.cQU < 1) {}
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "isSuccess: " + bool);
        }
        return bool;
      }
    }
  }
  
  static class a
    implements agmf.a
  {
    public MqqHandler q;
    
    public a(MqqHandler paramMqqHandler)
    {
      this.q = paramMqqHandler;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.q != null) {
        this.q.sendMessageDelayed(this.q.obtainMessage(101, paramInt, 0, paramString), 1500L);
      }
    }
    
    public void onSuccess(Object paramObject)
    {
      if (this.q != null) {
        this.q.sendEmptyMessageDelayed(100, 1500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhl
 * JD-Core Version:    0.7.0.1
 */