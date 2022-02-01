import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragment4CmGame;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class abql
  implements abqq, Handler.Callback, View.OnClickListener
{
  private TextView Bp;
  private TextView Bq;
  private abqk jdField_a_of_type_Abqk;
  private abqr jdField_a_of_type_Abqr;
  private boolean aPk;
  private boolean aPl;
  private boolean aPm;
  private auru jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private GdtAppReceiver jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private boolean bEK;
  private boolean bEL;
  boolean bEM;
  private FrameLayout bo;
  private int cqN = 0;
  private int cqO;
  private int cqP = 0;
  private RelativeLayout dZ;
  private ImageView jn;
  private int mGameId;
  private boolean mIsMute = true;
  private RelativeLayout mRootView;
  private ImageView oX;
  private ImageView oY;
  long wD;
  
  public abql(RelativeLayout paramRelativeLayout, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, new Object[] { "[CmGameVideoViewController], isPortrait:", Boolean.valueOf(paramBoolean), ",gameId:", Integer.valueOf(paramInt) });
    }
    this.mGameId = paramInt;
    this.dZ = paramRelativeLayout;
    setOrientation(paramBoolean);
    bDE();
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.mRootView.getContext());
    if (2 == paramInt) {
      localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838594));
    }
    do
    {
      return localImageView;
      if (1 == paramInt)
      {
        localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838588));
        return localImageView;
      }
    } while (3 != paramInt);
    localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838589));
    return localImageView;
  }
  
  private String a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("bt", String.valueOf(paramLong1));
      ((JSONObject)localObject).put("et", String.valueOf(paramLong2));
      ((JSONObject)localObject).put("bf", String.valueOf(paramLong3));
      ((JSONObject)localObject).put("ef", String.valueOf(paramLong4));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    int m = 0;
    if ((paramLinearLayout == null) || (paramDouble < 3.0D)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    int n = (int)paramDouble;
    if (((paramDouble > 3.0D) && (paramDouble < 4.0D)) || ((paramDouble > 4.0D) && (paramDouble < 5.0D))) {}
    for (int i = 1;; i = 0)
    {
      int j = wja.dp2px(15.0F, this.mRootView.getResources());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      j = 0;
      if (j < n)
      {
        if (j == 0) {}
        for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = wja.dp2px(3.0F, this.mRootView.getResources()))
        {
          paramLinearLayout.addView(a(1), localLayoutParams);
          j += 1;
          break;
        }
      }
      j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= i) {
          break;
        }
        paramLinearLayout.addView(a(2), localLayoutParams);
        j += 1;
      }
      while (k < 5 - n - i)
      {
        paramLinearLayout.addView(a(3), localLayoutParams);
        k += 1;
      }
      break;
    }
  }
  
  private void bDE()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
        return;
      }
      QLog.i("cmgame_process.CmGameVideoViewController", 1, "registerReceiverForApp");
      this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.mRootView.getContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
  }
  
  private void bDF()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
        return;
      }
      QLog.i("cmgame_process.CmGameVideoViewController", 1, "unregisterReceiverForApp");
      this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(this.mRootView.getContext());
      this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
  }
  
  private void cEl()
  {
    this.mIsMute = true;
    this.bEL = false;
    this.aPm = false;
    this.bEM = false;
    if (this.aPl) {}
    for (int i = 1;; i = 2)
    {
      v(6, i, true);
      cEq();
      DZ(true);
      return;
    }
  }
  
  private void cEm()
  {
    int n = 0;
    if (this.jdField_a_of_type_Abqk == null) {
      return;
    }
    int i;
    int m;
    int i1;
    Object localObject;
    int j;
    if ((this.aPk) || (this.bEK))
    {
      i = 1;
      m = this.jdField_a_of_type_Abqr.getVideoWidth();
      i1 = this.jdField_a_of_type_Abqr.getVideoHeight();
      localObject = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      if (i == 0) {
        break label227;
      }
      j = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      label78:
      if (i == 0) {
        break label244;
      }
    }
    label227:
    label244:
    for (int k = Math.max(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);; k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels))
    {
      i1 = (int)(1.0F * j * i1 / m);
      localObject = (RelativeLayout.LayoutParams)this.bo.getLayoutParams();
      m = n;
      if (i != 0)
      {
        m = n;
        if (!oH()) {
          m = (int)(150.0F * k / 1334.0F);
        }
      }
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      ((RelativeLayout.LayoutParams)localObject).width = j;
      ((RelativeLayout.LayoutParams)localObject).topMargin = m;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
      this.oY.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_Abqk.previewImgUrl, (URLDrawable.URLDrawableOptions)localObject));
      this.oY.setVisibility(8);
      return;
      i = 0;
      break;
      j = Math.max(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      break label78;
    }
  }
  
  private void cEn()
  {
    if (this.jdField_a_of_type_Abqr == null) {
      return;
    }
    this.jn.setVisibility(8);
    this.dZ.addView(this.mRootView);
    if (this.mIsMute) {
      this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838575));
    }
    View localView;
    for (;;)
    {
      localView = this.jdField_a_of_type_Abqr.bP();
      if (localView != null) {
        break;
      }
      QLog.w("cmgame_process.CmGameVideoViewController", 1, "[setViewStatus], videoView is null.");
      return;
      this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838576));
    }
    try
    {
      Object localObject = (RelativeLayout)this.mRootView.findViewById(2131381636);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      ((RelativeLayout)localObject).addView(localView, localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)this.bo.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      initBottomBar();
      localView.setOnClickListener(new abqp(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("cmgame_process.CmGameVideoViewController", 1, "fail to addview," + localThrowable);
    }
  }
  
  private void cEp()
  {
    if (this.bEM) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while ((!oH()) || (this.aPk));
      localActivity = p();
    } while (localActivity == null);
    this.bEK = true;
    this.cqP = localActivity.getRequestedOrientation();
    localActivity.setRequestedOrientation(1);
  }
  
  private void cEq()
  {
    if ((oH()) && (!this.aPk))
    {
      Activity localActivity = p();
      if (localActivity != null)
      {
        this.bEK = false;
        localActivity.setRequestedOrientation(this.cqP);
      }
    }
  }
  
  private void initBottomBar()
  {
    if (this.jdField_a_of_type_Abqk == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.aPk) {
          break label646;
        }
        Object localObject1 = (RelativeLayout)this.mRootView.findViewById(2131363630);
        localObject7 = (RelativeLayout)this.mRootView.findViewById(2131363631);
        ((RelativeLayout)localObject7).setOnClickListener(this);
        ((RelativeLayout)localObject1).setOnClickListener(this);
        if (this.jdField_a_of_type_Abqk.vSize == 185)
        {
          ((RelativeLayout)localObject1).setVisibility(8);
          ((RelativeLayout)localObject7).setVisibility(0);
          localObject4 = (ImageView)((RelativeLayout)localObject7).findViewById(2131362130);
          localObject6 = (TextView)((RelativeLayout)localObject7).findViewById(2131362149);
          localObject3 = (TextView)((RelativeLayout)localObject7).findViewById(2131362069);
          localObject5 = (Button)((RelativeLayout)localObject7).findViewById(2131362158);
          localTextView = (TextView)((RelativeLayout)localObject7).findViewById(2131362141);
          localObject1 = (LinearLayout)((RelativeLayout)localObject7).findViewById(2131362143);
          if (localObject4 != null)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_Abqk.bannerLogo)) {
              break label852;
            }
            localObject7 = URLDrawable.URLDrawableOptions.obtain();
            localObject8 = this.mRootView.getResources();
            ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = ((Resources)localObject8).getDrawable(2130846397);
            ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = ((Resources)localObject8).getDrawable(2130846397);
            localObject7 = URLDrawable.getDrawable(this.jdField_a_of_type_Abqk.bannerLogo, (URLDrawable.URLDrawableOptions)localObject7);
            ((URLDrawable)localObject7).setTag(aqbn.d(rpq.dip2px(BaseApplicationImpl.getContext(), 200.0F), rpq.dip2px(BaseApplicationImpl.getContext(), 200.0F), aqcx.dip2px(this.mRootView.getContext(), 12.0F)));
            ((URLDrawable)localObject7).setDecodeHandler(aqbn.d);
            ((ImageView)localObject4).setImageDrawable((Drawable)localObject7);
          }
          if (localObject6 != null) {
            ((TextView)localObject6).setText(this.jdField_a_of_type_Abqk.bannerImgName);
          }
          if (localObject3 != null)
          {
            localObject6 = this.jdField_a_of_type_Abqk.bannerBaseInfoText;
            localObject4 = localObject6;
            if (((String)localObject6).length() > 15)
            {
              localObject4 = ((String)localObject6).substring(0, 15);
              localObject4 = (String)localObject4 + "...";
            }
            ((TextView)localObject3).setText(acfp.m(2131704161) + (String)localObject4);
          }
          if (localObject5 != null)
          {
            if ((this.jdField_a_of_type_Abqk.productType != 12) && (this.jdField_a_of_type_Abqk.productType != 19)) {
              break label862;
            }
            ((Button)localObject5).setText(acfp.m(2131704159));
            ((Button)localObject5).setOnClickListener(this);
          }
          if (localTextView == null) {
            break;
          }
          this.jdField_a_of_type_Abqk.appScore /= 2.0D;
          localObject3 = new StringBuilder(500);
          if ((Double.compare(this.jdField_a_of_type_Abqk.appScore, 0.0D) != 0) && (this.jdField_a_of_type_Abqk.appScore >= 3.0D)) {
            break label876;
          }
          ((StringBuilder)localObject3).append("精品推荐 ");
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(8);
          }
          if ((0L != this.jdField_a_of_type_Abqk.downloadNum) && (this.jdField_a_of_type_Abqk.downloadNum >= 100000L)) {
            break label931;
          }
          ((StringBuilder)localObject3).append("热门推荐 ");
          localTextView.setText(((StringBuilder)localObject3).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      localThrowable.setVisibility(0);
      ((RelativeLayout)localObject7).setVisibility(8);
      Object localObject4 = (ImageView)localThrowable.findViewById(2131362129);
      Object localObject6 = (TextView)localThrowable.findViewById(2131362148);
      Object localObject3 = (TextView)localThrowable.findViewById(2131362068);
      TextView localTextView = (TextView)localThrowable.findViewById(2131362140);
      Object localObject5 = (Button)localThrowable.findViewById(2131362156);
      Object localObject2 = (LinearLayout)localThrowable.findViewById(2131362142);
      continue;
      label646:
      Object localObject7 = (RelativeLayout)this.mRootView.findViewById(2131363630);
      Object localObject8 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject7).getLayoutParams();
      ((RelativeLayout)localObject7).setOnClickListener(this);
      localObject2 = (Button)((RelativeLayout)localObject7).findViewById(2131362159);
      localObject4 = (ImageView)((RelativeLayout)localObject7).findViewById(2131362129);
      localObject6 = (TextView)((RelativeLayout)localObject7).findViewById(2131362148);
      localObject3 = (TextView)((RelativeLayout)localObject7).findViewById(2131362068);
      localTextView = (TextView)((RelativeLayout)localObject7).findViewById(2131362140);
      localObject5 = (Button)((RelativeLayout)localObject7).findViewById(2131362156);
      localObject7 = (LinearLayout)((RelativeLayout)localObject7).findViewById(2131362142);
      if (oH())
      {
        ((Button)localObject2).setVisibility(8);
        ((Button)localObject5).setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject8).height = wja.dp2px(157.0F, this.mRootView.getResources());
        localObject2 = localObject5;
      }
      for (;;)
      {
        ((Button)localObject2).setOnClickListener(this);
        localObject5 = localObject2;
        localObject2 = localObject7;
        break;
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject5).setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject8).height = wja.dp2px(104.0F, this.mRootView.getResources());
      }
      label852:
      ((ImageView)localObject4).setImageResource(2130838600);
      continue;
      label862:
      ((Button)localObject5).setText(acfp.m(2131704156));
      continue;
      label876:
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      a(this.jdField_a_of_type_Abqk.appScore, (LinearLayout)localObject2);
      ((StringBuilder)localObject3).append(new DecimalFormat("0.0").format(this.jdField_a_of_type_Abqk.appScore)).append("分 ");
      continue;
      label931:
      if (this.jdField_a_of_type_Abqk.downloadNum < 1000000L) {
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Abqk.downloadNum);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Abqk.productType != 12) && (this.jdField_a_of_type_Abqk.productType != 19)) {
          break label1082;
        }
        ((StringBuilder)localObject3).append("次下载");
        break;
        if (this.jdField_a_of_type_Abqk.downloadNum < 100000000L) {
          ((StringBuilder)localObject3).append(new BigDecimal(this.jdField_a_of_type_Abqk.downloadNum / 10000.0D).setScale(0, 4)).append("万");
        } else {
          ((StringBuilder)localObject3).append(new BigDecimal(this.jdField_a_of_type_Abqk.downloadNum / 100000000.0D).setScale(0, 4)).append("亿");
        }
      }
      label1082:
      ((StringBuilder)localObject3).append("次浏览");
    }
  }
  
  private boolean oH()
  {
    if (this.jdField_a_of_type_Abqk == null) {}
    while ((this.jdField_a_of_type_Abqk.vSize != 585) && (this.jdField_a_of_type_Abqk.vSize != 565)) {
      return false;
    }
    return true;
  }
  
  private Activity p()
  {
    if (this.mRootView != null)
    {
      Context localContext = this.mRootView.getContext();
      if ((localContext instanceof Activity)) {
        return (Activity)localContext;
      }
    }
    return null;
  }
  
  public void CL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[adsJumping]");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      GdtHandler.a(a((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)))));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, paramString, new Object[0]);
    }
  }
  
  public void DZ(boolean paramBoolean)
  {
    QLog.i("cmgame_process.CmGameVideoViewController", 1, "[closeVideoView], isByUser:" + paramBoolean);
    if ((this.mRootView == null) || (this.jdField_a_of_type_Abqr == null) || (this.jdField_a_of_type_Abqk == null)) {}
    RelativeLayout localRelativeLayout;
    View localView;
    do
    {
      return;
      localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131381636);
      localView = this.jdField_a_of_type_Abqr.bP();
    } while (localView == null);
    if (paramBoolean) {}
    try
    {
      abmt.a().callbackFromRequest(this.jdField_a_of_type_Abqk.jsState, 0, "sc.game_ad_video_view_close.local", "{}");
      label100:
      this.aPl = false;
      this.cqN = 0;
      localRelativeLayout.removeView(localView);
      this.jdField_a_of_type_Abqr.release();
      this.Bq.setVisibility(8);
      this.dZ.removeView(this.mRootView);
      this.jdField_a_of_type_Abqr = null;
      try
      {
        abmt.a().callbackFromRequest(this.jdField_a_of_type_Abqk.jsState, 0, "cs.xy_life_cycle_event_activity.local", "{}");
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localException, new Object[0]);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label100;
    }
  }
  
  public GdtAppReceiver a()
  {
    return this.jdField_b_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 7;
    localParams.activity = new WeakReference((Activity)this.mRootView.getContext());
    if (paramAdInfo != null) {
      localParams.ad = new GdtAd(paramAdInfo);
    }
    localParams.reportForClick = true;
    localParams.aOV = true;
    localParams.appReceiver = new WeakReference(a());
    localParams.n = null;
    localParams.p = GdtCanvasFragment4CmGame.class;
    return localParams;
  }
  
  public void b(abqk paramabqk)
  {
    if (System.currentTimeMillis() - this.wD < 1500L) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameVideoViewController", 2, "click too quick, not play");
      }
    }
    do
    {
      return;
      this.wD = System.currentTimeMillis();
      if (paramabqk == null)
      {
        QLog.w("cmgame_process.CmGameVideoViewController", 1, "[playVideo], fail to play ads video.");
        return;
      }
      this.cqN = 0;
      this.jdField_a_of_type_Abqk = paramabqk;
    } while (this.jdField_b_of_type_Auru == null);
    this.jdField_b_of_type_Auru.obtainMessage(0).sendToTarget();
  }
  
  public void cEo() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Abqk == null);
        DZ(false);
        cEp();
        cEo();
        cEn();
        if (this.jdField_a_of_type_Abqr != null) {
          this.jdField_a_of_type_Abqr.E(this.jdField_a_of_type_Abqk.url, "sd", 0);
        }
        abmt.a().callbackFromRequest(this.jdField_a_of_type_Abqk.jsState, 0, "sc.game_ad_video_start.local", "{}");
        return false;
      } while ((this.jdField_a_of_type_Abqr == null) || (this.jdField_a_of_type_Abqr.bP() == null));
      cEm();
      return false;
    case 2: 
      this.Bq.setVisibility(8);
      this.oY.setVisibility(0);
      return false;
    case 3: 
      if (!this.bEM) {
        this.jn.setVisibility(0);
      }
      this.oY.setVisibility(0);
      return false;
    }
    this.jn.setVisibility(8);
    this.oY.setVisibility(8);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.aPl)
      {
        cEl();
      }
      else
      {
        for (;;)
        {
          try
          {
            if (this.jdField_a_of_type_Abqr != null)
            {
              this.jn.setVisibility(0);
              this.aPm = true;
              this.jdField_a_of_type_Abqr.pause();
            }
            Context localContext = this.mRootView.getContext();
            if (this.cqO <= 15) {
              break label211;
            }
            String str1 = "观看至少15秒视频才可获得有效奖励哦";
            aqha.a(localContext, 0, null, str1, acfp.m(2131704158), acfp.m(2131704157), new abqn(this), new abqo(this)).show();
          }
          catch (Throwable localThrowable)
          {
            QLog.e("cmgame_process.CmGameVideoViewController", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
          }
          break;
          label211:
          String str2 = acfp.m(2131704160);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameVideoViewController", 2, "[click ad btn]");
        }
        CL(this.jdField_a_of_type_Abqk.adsContent);
        v(3, 0, true);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Abqr != null) {
      this.jdField_a_of_type_Abqr.release();
    }
    bDF();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setOrientation(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.dZ == null) {
          return;
        }
        this.aPk = paramBoolean;
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.dZ.getContext());
        if (paramBoolean)
        {
          this.mRootView = ((RelativeLayout)localLayoutInflater.inflate(2131558715, null));
          this.Bp = ((TextView)this.mRootView.findViewById(2131364682));
          this.Bq = ((TextView)this.mRootView.findViewById(2131362256));
          this.oX = ((ImageView)this.mRootView.findViewById(2131363080));
          this.jn = ((ImageView)this.mRootView.findViewById(2131373370));
          this.oY = ((ImageView)this.mRootView.findViewById(2131362137));
          this.bo = ((FrameLayout)this.mRootView.findViewById(2131381712));
          this.mRootView.setOnClickListener(this);
          this.Bp.setOnClickListener(this);
          this.oX.setOnClickListener(new abqm(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      this.mRootView = ((RelativeLayout)localThrowable.inflate(2131558714, null));
    }
  }
  
  public void v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Abqk == null) || (this.jdField_a_of_type_Abqr == null)) {}
    while ((this.bEM) && (!paramBoolean)) {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "video_SPA", this.jdField_a_of_type_Abqk.adId, paramInt1, new String[] { Integer.toString(this.mGameId), Long.toString(this.cqO), Integer.toString(paramInt2), Integer.toString(this.jdField_a_of_type_Abqk.vSize) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abql
 * JD-Core Version:    0.7.0.1
 */