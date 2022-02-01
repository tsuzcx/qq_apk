import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.1;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class amcv
  extends MainBrowserPresenter
  implements aeep.a, aefb, aefc, Handler.Callback, xsi.a
{
  private aeev jdField_a_of_type_Aeev;
  private alyn jdField_a_of_type_Alyn;
  private alyp jdField_a_of_type_Alyp;
  private xuh jdField_a_of_type_Xuh;
  private aeey b;
  public amcn b;
  public amdq b;
  public int bWG;
  private volatile boolean cCl;
  private String currentUin;
  private AtomicBoolean dH = new AtomicBoolean(false);
  private int delayTime = 30000;
  private Handler mHandler;
  
  private void Uq(int paramInt)
  {
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(1);
      this.mHandler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private void a(aeev paramaeev)
  {
    this.jdField_a_of_type_Aeev = paramaeev;
  }
  
  private int bN(String paramString)
  {
    switch (amcj.a().IB())
    {
    }
    do
    {
      return -1;
      return 1;
      return dU(paramString);
      return dV(paramString);
      if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private void dMC()
  {
    aeep.registerModule();
    aeep.a().a(this);
    a(aeep.a());
    if (this.jdField_b_of_type_Aeey != null)
    {
      this.jdField_b_of_type_Aeey.a(this);
      this.jdField_b_of_type_Aeey.m(this.jdField_b_of_type_Amdq.mActivity, this.jdField_b_of_type_Amdq.b);
      this.jdField_b_of_type_Aeey.cWA();
    }
  }
  
  private void dMD()
  {
    if ((le(getCurrentPosition())) && (this.jdField_b_of_type_Amcn != null) && (this.jdField_b_of_type_Amcn.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcn.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.mHandler != null) {
          this.mHandler.removeMessages(1);
        }
        aeep.a().m(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).shmsgseq, Long.valueOf(amcj.a().yM()).longValue(), localRichMediaBrowserInfo.baseData.getType());
        Uq(this.delayTime);
        return;
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList is exception = " + localException.getMessage());
        return;
      }
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList return");
  }
  
  private int dT(String paramString)
  {
    Object localObject = this.jdField_b_of_type_Amcn.getSelectedItem();
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((RichMediaBrowserInfo)localObject).baseData;
    } while (localObject == null);
    int i;
    if ((localObject instanceof AIOVideoData))
    {
      localObject = (AIOVideoData)localObject;
      if (((AIOVideoData)localObject).mBusiType == 0) {
        if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString))) {
          i = 2;
        }
      }
    }
    for (;;)
    {
      return i;
      if ("0X8009AA6".equals(paramString))
      {
        i = 1;
        continue;
        if (((AIOVideoData)localObject).mBusiType == 1)
        {
          if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString)))
          {
            i = 1;
            continue;
          }
          if ("0X8009AA6".equals(paramString))
          {
            i = 1;
            continue;
            if ((!(localObject instanceof AIOFileVideoData)) || ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))) {
              break;
            }
            return 3;
          }
        }
      }
      i = -1;
    }
  }
  
  private int dU(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 4;
    }
    while (!"0X8009EFD".equals(paramString)) {
      return i;
    }
    return -1;
  }
  
  private int dV(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 5;
    }
    do
    {
      return i;
      if ("0X8009EFD".equals(paramString)) {
        return 4;
      }
    } while (!"0X800A882".equals(paramString));
    return 2;
  }
  
  private int getCurType()
  {
    switch (amcj.a().Iz())
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private int sZ()
  {
    Object localObject = this.jdField_b_of_type_Amcn.getSelectedItem();
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int i;
    if (localObject != null) {
      if ((localObject instanceof AIOFilePictureData)) {
        i = 2;
      }
    }
    for (;;)
    {
      return i;
      if ((localObject instanceof AIOPictureData))
      {
        if (!((AIOPictureData)localObject).bjg) {
          i = 1;
        } else {
          i = 5;
        }
      }
      else
      {
        if ((localObject instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).mBusiType == 0)
          {
            i = 4;
            continue;
          }
          if (((AIOVideoData)localObject).mBusiType == 1) {
            i = 3;
          }
        }
        else if ((localObject instanceof AIOFileVideoData))
        {
          i = 5;
          continue;
        }
        i = -1;
      }
    }
  }
  
  public void OK(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Aeey != null) && (this.jdField_b_of_type_Aeey.agB()) && (this.jdField_b_of_type_Amdq != null))
    {
      this.jdField_b_of_type_Aeey.cWB();
      this.jdField_b_of_type_Amdq.OL(paramBoolean);
    }
  }
  
  public void Uo(int paramInt)
  {
    this.bWG = paramInt;
  }
  
  public aeey a()
  {
    return this.jdField_b_of_type_Aeey;
  }
  
  public alyn a()
  {
    if (this.jdField_a_of_type_Alyn == null) {
      this.jdField_a_of_type_Alyn = new alyn(this.jdField_b_of_type_Amdq.mActivity);
    }
    return this.jdField_a_of_type_Alyn;
  }
  
  public alyp a()
  {
    if (this.jdField_a_of_type_Alyp == null) {
      this.jdField_a_of_type_Alyp = new alyp(this.jdField_b_of_type_Amdq.mActivity);
    }
    return this.jdField_a_of_type_Alyp;
  }
  
  public xuh a()
  {
    return this.jdField_a_of_type_Xuh;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_b_of_type_Amcn.f(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof amcu)) {
      ((amcu)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.delayTime = (paramInt * 1000);
    }
    if ((!this.cCl) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentPresenter();
      if (((paramString instanceof amcu)) && (this.jdField_b_of_type_Aeey != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((amcu)paramString).cWE();
        this.jdField_b_of_type_Aeey.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (cB(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof amcu)) && (this.jdField_b_of_type_Aeey != null) && (this.jdField_b_of_type_Amcn != null))
      {
        dad();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcn.getSelectedItem();
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
        {
          paramString = new ArrayList();
          switch (localRichMediaBrowserInfo.baseData.getType())
          {
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Aeey.jJ(paramString);
      return;
      paramString = amch.a(paramLong, paramList, a(), ((amcu)localBrowserBasePresenter).gM);
      continue;
      paramString = amch.a(paramLong, paramList, a(), ((amcu)localBrowserBasePresenter).gM, ((amcu)localBrowserBasePresenter).fs());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((aqiw.isNetworkAvailable()) && (paramDanmuItemBean != null) && (cB(paramLong)) && (this.jdField_b_of_type_Aeey != null))
    {
      dad();
      this.jdField_b_of_type_Aeey.a(paramDanmuItemBean);
    }
  }
  
  public void a(amcn paramamcn)
  {
    super.setGalleryModel(paramamcn);
    this.jdField_b_of_type_Amcn = paramamcn;
  }
  
  public void a(amdq paramamdq)
  {
    super.setGalleryScene(paramamdq);
    this.jdField_b_of_type_Amdq = paramamdq;
  }
  
  public void a(xuh paramxuh)
  {
    this.jdField_a_of_type_Xuh = paramxuh;
  }
  
  public void a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    if (paramArrayOfAIOBrowserBaseData != null) {}
    for (int i = paramArrayOfAIOBrowserBaseData.length;; i = 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + i + ", selected " + paramInt);
      if (this.browserScene != null) {
        this.browserScene.notifyImageModelDataChanged();
      }
      return;
    }
  }
  
  public int aa(long paramLong)
  {
    List localList = this.jdField_b_of_type_Amcn.be();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localList.get(i);
        if (((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId == paramLong)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256) || (paramInt2 == 269484035)) {
      if ((paramInt2 != 18) && (paramInt2 != 20)) {
        break label114;
      }
    }
    label114:
    for (int i = this.jdField_b_of_type_Amcn.Z(paramLong1);; i = this.jdField_b_of_type_Amcn.f(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof amcu)) {
        ((amcu)localBrowserBasePresenter).b(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
      }
      return;
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 256) || (paramInt2 == 1) || (paramInt2 == 0) || (paramInt2 == 269484034)) {
      if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
        break label127;
      }
    }
    label127:
    for (int i = this.jdField_b_of_type_Amcn.Z(paramLong);; i = this.jdField_b_of_type_Amcn.f(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof amcu)) {
        ((amcu)localBrowserBasePresenter).b(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void buildComplete()
  {
    if ((this.jdField_b_of_type_Amdq.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_b_of_type_Amdq.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((achu)((PeakAppInterface)localAppRuntime).getBusinessHandler(2)).dP(this.jdField_b_of_type_Amdq.mActivity);
      }
    }
    if (amch.avy())
    {
      this.jdField_b_of_type_Aeey = new aeey();
      this.mHandler = new Handler(Looper.getMainLooper(), this);
      this.currentUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      dMC();
    }
  }
  
  public void buildParams(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    AIORichMediaData localAIORichMediaData = (AIORichMediaData)paramIntent.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
    localRichMediaBrowserInfo.baseData = amdj.a(localAIORichMediaData);
    if (this.jdField_b_of_type_Amcn.b(localRichMediaBrowserInfo))
    {
      this.jdField_b_of_type_Amcn.b(localRichMediaBrowserInfo);
      if (paramIntent.getBoolean("muate_play")) {
        this.jdField_b_of_type_Amcn.c(localRichMediaBrowserInfo);
      }
      long l = paramIntent.getLong("click_video_bubble_time");
      if (l > 0L) {
        this.jdField_b_of_type_Amcn.a(localRichMediaBrowserInfo, l);
      }
    }
    this.jdField_b_of_type_Amcn.a(localRichMediaBrowserInfo);
    if (amcj.a().avE()) {
      this.jdField_b_of_type_Amcn.setReverse(true);
    }
    xsi.a().a(this);
  }
  
  public void buildPresenter() {}
  
  public boolean cB(long paramLong)
  {
    if (this.jdField_b_of_type_Amcn != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcn.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).shmsgseq);
    }
    return false;
  }
  
  public void cWC()
  {
    if ((this.jdField_b_of_type_Aeey != null) && (!this.jdField_b_of_type_Aeey.agB()) && (this.jdField_b_of_type_Amdq != null))
    {
      this.jdField_b_of_type_Aeey.cWC();
      this.jdField_b_of_type_Amdq.OL(true);
    }
  }
  
  public void cWD()
  {
    this.cCl = true;
  }
  
  public void cWE()
  {
    if (this.cCl)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof amcu)) && (this.jdField_b_of_type_Aeey != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((amcu)localBrowserBasePresenter).cWE();
        this.jdField_b_of_type_Aeey.a(null);
      }
    }
  }
  
  public void dMA()
  {
    anot.a(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", sZ(), 0, "" + getCurType(), "" + bN("0X8009EFC"), "", "");
  }
  
  public void dMB()
  {
    anot.a(null, "dc00898", "", "", "0X800A882", "0X800A882", sZ(), 0, "" + bN("0X800A882"), "", "", "");
  }
  
  public void dME()
  {
    anot.a(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", sZ(), 0, "" + getCurType(), "" + bN("0X8009EFD"), "", "");
  }
  
  public void dMF()
  {
    anot.a(null, "dc00898", "", "", "0X800A418", "0X800A418", sZ(), 0, "" + getCurType(), "" + bN("0X800A418"), "", "");
  }
  
  public void dMG()
  {
    anot.a(null, "dc00898", "", "", "0X800A419", "0X800A419", sZ(), 0, "" + getCurType(), "" + bN("0X800A419"), "", "");
  }
  
  public void dMH()
  {
    anot.a(null, "dc00898", "", "", "0X800A41A", "0X800A41A", sZ(), 0, "" + getCurType(), "" + bN("0X800A41A"), "", "");
  }
  
  public void dMI()
  {
    anot.a(null, "dc00898", "", "", "0X800A41B", "0X800A41B", sZ(), 0, "" + getCurType(), "" + bN("0X800A41B"), "", "");
  }
  
  public void dMx()
  {
    anot.a(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", sZ(), 0, "" + getCurType(), "" + bN("0X8009EFC"), "", "");
  }
  
  public void dMy()
  {
    anot.a(null, "dc00898", "", "", "0X800A41C", "0X800A41C", sZ(), 0, "" + getCurType(), "" + bN("0X800A41C"), "", "");
  }
  
  public void dMz()
  {
    anot.a(null, "dc00898", "", "", "0X800A41D", "0X800A41D", sZ(), 0, "" + getCurType(), "" + bN("0X800A41D"), "", "");
  }
  
  public void dad()
  {
    if (this.dH.compareAndSet(false, true)) {
      ThreadManagerV2.excute(new AIOBrowserPresenter.1(this), 128, null, true);
    }
  }
  
  public void fG(long paramLong)
  {
    Object localObject;
    if ((this.jdField_b_of_type_Amdq != null) && (this.jdField_b_of_type_Amdq.mAdapter != null))
    {
      localObject = this.jdField_b_of_type_Amcn.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((amcj.a().avB()) && (amcj.a().gJ() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Xuh != null) && (!bool)) {
        this.jdField_a_of_type_Xuh.gc(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof amcu))
        {
          int i = aa(paramLong);
          if (i >= 0) {
            ((amcu)localBrowserBasePresenter).Up(i);
          }
        }
      }
      if ((this.jdField_b_of_type_Amdq.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_b_of_type_Amdq.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
      return;
    }
  }
  
  public long fs()
  {
    BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
    if ((localBrowserBasePresenter instanceof amcu)) {
      return ((amcu)localBrowserBasePresenter).fs();
    }
    return 0L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      dMD();
    }
  }
  
  public boolean le(int paramInt)
  {
    return (amch.a(this.jdField_b_of_type_Amcn.getSelectedItem())) && (lf(paramInt));
  }
  
  public boolean lf(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Amcn != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcn.getItem(paramInt);
      bool1 = bool2;
      if (localRichMediaBrowserInfo != null)
      {
        bool1 = bool2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if ((localRichMediaBrowserInfo.baseData.getType() != 100) && (localRichMediaBrowserInfo.baseData.getType() != 101) && (localRichMediaBrowserInfo.baseData.getType() != 102))
          {
            bool1 = bool2;
            if (localRichMediaBrowserInfo.baseData.getType() != 103) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void n(long paramLong1, long paramLong2, String paramString)
  {
    ShortVideoUtils.a(null, getCurType(), paramString, 2, dT("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    aeep.a().b(this);
    if (this.jdField_b_of_type_Aeey != null) {
      this.jdField_b_of_type_Aeey.destroy();
    }
    if (this.jdField_a_of_type_Aeev != null)
    {
      this.jdField_a_of_type_Aeev.cWz();
      this.jdField_a_of_type_Aeev = null;
    }
    if (this.jdField_b_of_type_Amdq != null) {
      this.jdField_b_of_type_Amdq.onDestroy();
    }
    xsi.a().b(this);
    if (this.jdField_a_of_type_Alyn != null)
    {
      this.jdField_a_of_type_Alyn.exit(this.bWG);
      this.jdField_a_of_type_Alyn.dLB();
    }
    if (this.jdField_a_of_type_Alyp != null)
    {
      this.jdField_a_of_type_Alyp.exit();
      this.jdField_a_of_type_Alyp = null;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    dMF();
    return true;
  }
  
  public void onItemSelect(int paramInt)
  {
    if ((this.jdField_b_of_type_Amdq != null) && (le(paramInt)))
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof amcu)) && (this.jdField_b_of_type_Aeey != null))
      {
        ((amcu)localBrowserBasePresenter).dMu();
        this.jdField_b_of_type_Aeey.a(this);
        this.cCl = false;
      }
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_b_of_type_Amdq != null) {
      this.jdField_b_of_type_Amdq.OL(false);
    }
    if (a() != null)
    {
      a().cWB();
      a().clear();
    }
    dMG();
    return true;
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_b_of_type_Amcn.getItem(paramInt);
    if (paramView != null) {
      a().Ud(paramView.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcv
 * JD-Core Version:    0.7.0.1
 */