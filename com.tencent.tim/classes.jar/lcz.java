import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.2;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.6;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class lcz
  extends lcs
{
  private mfq.a a = new ldc(this);
  private Activity activity;
  @Nullable
  private String aeA;
  private boolean ajv;
  @Nullable
  private ReadInJoySkinGuideView b;
  private lce f = new ldd(this);
  
  public lcz(@NotNull lct paramlct, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramlct, "RIJSkinOperationPopupStep");
    this.activity = paramActivity;
  }
  
  @UiThread
  private void a(GuideData paramGuideData, String paramString, int paramInt)
  {
    if (!isResumed()) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.b != null);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localFrameLayout = (FrameLayout)this.activity.findViewById(2131365363);
      this.b = new ReadInJoySkinGuideView(0, this.activity, localQQAppInterface, paramGuideData.id, paramString, paramInt, new lda(this, localFrameLayout, paramInt, localQQAppInterface), new ldb(this, localQQAppInterface, paramGuideData, localFrameLayout));
    } while (getCurrentTab() != 0);
    localFrameLayout.addView(this.b, -1, -1);
  }
  
  private void a(oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2)
  {
    boolean bool1 = a(paramGuideInfo1, paramInt);
    a(paramRefreshInfo, paramInt);
    boolean bool2 = a(paramInt, paramSkinInfo, paramGuideInfo2);
    ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.6(this, bool1 | bool2));
  }
  
  private void a(oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    mfo localmfo = (mfo)localQQAppInterface.getManager(270);
    RefreshData localRefreshData;
    if (paramRefreshInfo.has())
    {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
      localRefreshData = localmfo.a(this.activity, paramInt);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (paramRefreshInfo != null) {
          break label225;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo);
        label104:
        if (localRefreshData != null) {
          break label256;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData);
      }
      label135:
      if (paramRefreshInfo != null) {
        break label288;
      }
      if (localRefreshData != null)
      {
        aqmj.l(this.activity, localQQAppInterface.getCurrentAccountUin(), null, paramInt);
        aqhq.cm(mgh.getResPath());
        localmfo.b(0, "", -1L, paramInt);
      }
    }
    for (;;)
    {
      if (paramRefreshInfo != null)
      {
        paramRefreshInfo.showInFeeds = true;
        if (localRefreshData != null) {
          paramRefreshInfo.isShown = localRefreshData.isShown;
        }
        aqmj.l(this.activity, localQQAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt);
      }
      return;
      paramRefreshInfo = null;
      break;
      label225:
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo.toString());
      break label104;
      label256:
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData.toString());
      break label135;
      label288:
      if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (i <= paramRefreshInfo.endTime))
      {
        localmfo.b(0, "", -1L, paramInt);
        aqhq.cm(mgh.getResPath());
        localmfo.a(paramRefreshInfo, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "setRefreshType none and downloadRefreshRes");
        }
      }
    }
  }
  
  private boolean a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    mfl localmfl = (mfl)localQQAppInterface.getManager(paramInt);
    if (localmfl.a(paramString, paramBaseResData))
    {
      String str = localmfl.U(paramString, paramBaseResData.id);
      if (localmfl.b(paramString, paramBaseResData))
      {
        if (261 == paramInt)
        {
          if (aqmj.p(this.activity, paramBaseResData.id) != paramBaseResData.seq)
          {
            aqhq.cn(str);
            localmfl.c(paramString, paramBaseResData);
            return false;
          }
          aqmj.ah(this.activity, localQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
          aqmj.cQ(this.activity, localQQAppInterface.getCurrentAccountUin());
        }
        localmfl.b(paramString, paramBaseResData);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "checkAndSkinGuide：real: " + paramBaseResData.id);
        }
        if ((paramBaseResData instanceof GuideData))
        {
          paramString = (GuideData)paramBaseResData;
          ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.2(this, paramString, str, paramInt));
          return true;
        }
      }
      else
      {
        localmfl.c(paramString, paramBaseResData);
      }
    }
    return false;
  }
  
  private boolean a(int paramInt, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = false;
    RefreshData localRefreshData = ((mfo)localQQAppInterface.getManager(270)).a(this.activity, paramInt);
    int i = (int)(System.currentTimeMillis() / 1000L);
    Object localObject;
    boolean bool1;
    if (paramSkinInfo.has())
    {
      paramSkinInfo = new SkinData(paramSkinInfo);
      localObject = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject);
      }
      paramGuideInfo = (mfs)localQQAppInterface.getManager(261);
      if ((this.ajv) || (i < ((GuideData)localObject).beginTime) || (i > ((GuideData)localObject).endTime)) {
        break label258;
      }
      bool1 = bool2;
      if (a(261, "", (BaseResData)localObject)) {
        bool1 = true;
      }
      label165:
      localObject = paramGuideInfo.a(this.activity);
      if ((paramSkinInfo != null) || (paramGuideInfo.pg() != 1)) {
        break label310;
      }
      this.aeA = paramGuideInfo.jM();
      aqmj.ag(this.activity, localQQAppInterface.getCurrentAccountUin(), null);
      if ((localRefreshData != null) && (i <= localRefreshData.endTime))
      {
        localRefreshData.isShown = true;
        aqmj.l(this.activity, localQQAppInterface.getCurrentAccountUin(), localRefreshData.toJson().toString(), paramInt);
      }
    }
    label258:
    label310:
    while ((paramSkinInfo == null) || (localObject == null) || (!((SkinData)localObject).id.equals(paramSkinInfo.id)) || (((SkinData)localObject).seq == paramSkinInfo.seq))
    {
      return bool1;
      paramSkinInfo = null;
      break;
      bool1 = bool2;
      if (i > ((GuideData)localObject).endTime) {
        break label165;
      }
      bool1 = bool2;
      if (!aqiw.isWifiConnected(this.activity)) {
        break label165;
      }
      paramGuideInfo.a((GuideData)localObject);
      paramGuideInfo.a(((GuideData)localObject).skinData);
      bool1 = bool2;
      break label165;
    }
    aqmj.ag(this.activity, localQQAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
    if (paramSkinInfo.id.equals(paramGuideInfo.jM()))
    {
      this.aeA = paramSkinInfo.id;
      return bool1;
    }
    aqhq.cn(mfk.eP(paramSkinInfo.id));
    return bool1;
  }
  
  private boolean a(oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = (int)(System.currentTimeMillis() / 1000L);
    mfn localmfn = (mfn)((QQAppInterface)localObject).getManager(271);
    int i;
    if (paramGuideInfo.has())
    {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("RIJSkinOperationPopupStep", 2, "guideData = " + paramGuideInfo);
      }
      localObject = ((QQAppInterface)localObject).a().createEntityManager();
      if (paramGuideInfo == null) {
        break label338;
      }
      paramGuideInfo.business = "operation_guide";
      GuideData localGuideData = (GuideData)((EntityManager)localObject).find(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localGuideData == null) || (localGuideData.showTime == 0)) {
        ((EntityManager)localObject).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localmfn.d("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo == null) {
        break label345;
      }
      paramGuideInfo = paramGuideInfo.iterator();
      i = 0;
      label192:
      bool2 = bool1;
      if (!paramGuideInfo.hasNext()) {
        break label345;
      }
      localObject = (GuideData)paramGuideInfo.next();
      if ((i != 0) || (((GuideData)localObject).source != paramInt) || (j < ((GuideData)localObject).beginTime) || (j > ((GuideData)localObject).endTime)) {
        break label292;
      }
      if (a(271, "operation_guide", (BaseResData)localObject)) {
        bool1 = true;
      }
      this.ajv = true;
      bool2 = bool1;
    }
    for (;;)
    {
      i += 1;
      bool1 = bool2;
      break label192;
      paramGuideInfo = null;
      break;
      label292:
      bool2 = bool1;
      if (j <= ((GuideData)localObject).endTime)
      {
        bool2 = bool1;
        if (aqiw.isWifiConnected(this.activity))
        {
          localmfn.c("operation_guide", (BaseResData)localObject);
          bool2 = bool1;
        }
      }
    }
    label338:
    localmfn.dq(paramInt);
    label345:
    return bool2;
  }
  
  private void aKw()
  {
    ThreadManager.excute(new RIJSkinOperationPopupStep.1(this), 16, null, true);
  }
  
  private void aKx()
  {
    if (this.b != null)
    {
      this.b.onDestroy();
      ((FrameLayout)this.activity.findViewById(2131365363)).removeView(this.b);
      this.b = null;
    }
  }
  
  protected void aKn() {}
  
  protected void aKo()
  {
    aKw();
  }
  
  public int getCurrentTab()
  {
    return 0;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.addObserver(this.a);
    localQQAppInterface.addObserver(this.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.a);
    localQQAppInterface.removeObserver(this.f);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.aeA != null)
    {
      aqhq.cn(mfk.eP(this.aeA));
      this.aeA = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcz
 * JD-Core Version:    0.7.0.1
 */