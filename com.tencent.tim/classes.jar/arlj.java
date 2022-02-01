import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer.a;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingVideoWrapper.2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class arlj
  extends arlg
  implements SeekBar.OnSeekBarChangeListener, FloatingScreenContainer.a, IVideoOuterStatusListener
{
  private ImageView FW;
  private ImageView FX;
  private ImageView FY;
  private ImageView FZ;
  private List<View> Jt;
  public arld a;
  private IFullScreenEnterListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener;
  private IVideoInnerStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener;
  private int aEt = -1;
  private TextView acA;
  private TextView acB;
  private TextView acx;
  private TextView acy;
  private TextView acz;
  private ObjectAnimator bQ;
  private FrameLayout co;
  private int ekj;
  private int ekk;
  private int ekl = 0;
  private int ekm;
  private int ekn;
  private int eko;
  private int ekp;
  private Runnable ia = new FloatingVideoWrapper.2(this);
  private LinearLayout lD;
  private StringBuilder mFormatBuilder;
  private Formatter mFormatter;
  private SeekBar mSeekBar;
  private int mVideoHeight = -1;
  private int mVideoWidth = -1;
  private ImageView pd;
  
  public arlj(Context paramContext)
  {
    super(paramContext);
  }
  
  private void Ua(boolean paramBoolean)
  {
    int k = -2;
    if (this.mContext == null) {}
    Resources localResources;
    label64:
    label118:
    do
    {
      for (;;)
      {
        return;
        localResources = this.mContext.getResources();
        Object localObject;
        int i;
        int j;
        if (this.pd != null)
        {
          localObject = this.pd.getLayoutParams();
          if (paramBoolean)
          {
            ((ViewGroup.LayoutParams)localObject).width = -2;
            ((ViewGroup.LayoutParams)localObject).height = -2;
            this.pd.setImageResource(2130838134);
            this.pd.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          if (this.FZ != null)
          {
            localObject = (LinearLayout.LayoutParams)this.FZ.getLayoutParams();
            if (!paramBoolean) {
              break label235;
            }
            i = 32;
            j = k;
            if (localResources != null)
            {
              i = wja.dp2px(16.0F, localResources);
              j = k;
            }
            ((LinearLayout.LayoutParams)localObject).width = j;
            ((LinearLayout.LayoutParams)localObject).height = j;
            ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, i);
            this.FZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          if (this.acz != null)
          {
            if (!paramBoolean) {
              break label265;
            }
            this.acz.setTextSize(17.0F);
          }
        }
        for (;;)
        {
          if (this.et == null) {
            break label275;
          }
          if ((this.aEt != 2) && (this.aEt != 3)) {
            break label277;
          }
          if (localResources == null) {
            break;
          }
          this.et.setBackgroundColor(localResources.getColor(2131167250));
          return;
          ((ViewGroup.LayoutParams)localObject).width = -1;
          ((ViewGroup.LayoutParams)localObject).height = -1;
          this.pd.setImageResource(2130847114);
          break label64;
          j = 40;
          i = 16;
          if (localResources == null) {
            break label118;
          }
          j = wja.dp2px(20.0F, localResources);
          i = wja.dp2px(8.0F, localResources);
          break label118;
          this.acz.setTextSize(12.0F);
        }
      }
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        this.et.setBackgroundResource(2130847115);
        return;
      }
    } while (localResources == null);
    label235:
    this.et.setBackgroundColor(localResources.getColor(2131167595));
    label265:
    label275:
    label277:
    return;
  }
  
  private void Ub(boolean paramBoolean)
  {
    Iterator localIterator = this.Jt.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
    }
  }
  
  private void Uc(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (this.b != null)
      {
        this.b.setClipToOutline(paramBoolean);
        if ((this.mContext != null) && (this.mContext.getResources() != null))
        {
          if (!paramBoolean) {
            break label96;
          }
          afxl.setBackground(this.b, this.mContext.getResources().getDrawable(2130847109));
        }
      }
    }
    for (;;)
    {
      if ((this.cn != null) && (this.mContext != null) && (this.mContext.getResources() != null)) {
        this.cn.setClipToOutline(paramBoolean);
      }
      return;
      label96:
      afxl.setBackground(this.b, this.mContext.getResources().getDrawable(2130847108));
    }
  }
  
  private void Zf(int paramInt)
  {
    eki();
    if (this.b != null) {
      Ub(this.b.aGO());
    }
    a(false, new View[] { this.pd });
    a(true, new View[] { this.acz });
    if (this.et != null) {
      this.et.setBackgroundColor(this.mContext.getResources().getColor(2131167250));
    }
    if (this.FZ != null)
    {
      if (!mN(paramInt)) {
        break label136;
      }
      this.FZ.setImageResource(2130847113);
      this.FZ.setVisibility(0);
    }
    for (;;)
    {
      if (this.acz != null)
      {
        if (paramInt != 400) {
          break;
        }
        this.acz.setText(2131701866);
      }
      return;
      label136:
      this.FZ.setVisibility(8);
    }
    if (paramInt == 401)
    {
      this.acz.setText(2131701867);
      return;
    }
    if (paramInt == 402)
    {
      this.acz.setText(2131701869);
      return;
    }
    if (paramInt == 403)
    {
      this.acz.setText(2131701868);
      return;
    }
    this.acz.setText(2131701867);
  }
  
  private void Zg(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramInt == 0) {}
    for (;;)
    {
      if (this.et != null)
      {
        PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
        this.bQ = ObjectAnimator.ofPropertyValuesHolder(this.et, new PropertyValuesHolder[] { localPropertyValuesHolder });
        this.bQ.addUpdateListener(new arll(this, f2, f1));
        this.bQ.addListener(new arlm(this, paramInt));
        this.bQ.setDuration(300L).start();
      }
      do
      {
        return;
      } while (paramInt != 1);
      f2 = 1.0F;
      f1 = 0.0F;
    }
  }
  
  private void aVf()
  {
    if (this.b != null)
    {
      if (!this.b.aGN()) {
        return;
      }
      this.b.x(true, this.mVideoWidth, this.mVideoHeight);
      this.b.aVf();
      Ub(true);
      Ua(true);
      a(false, new View[] { this.FV });
    }
    eki();
    Uc(false);
    ekj();
  }
  
  private void ejN()
  {
    if (this.b != null)
    {
      if (!this.b.aGO()) {
        return;
      }
      this.b.x(false, this.mVideoWidth, this.mVideoHeight);
      this.b.ejN();
      Ub(false);
      Ua(false);
      a(true, new View[] { this.FV });
    }
    if (this.jdField_a_of_type_Arld != null) {
      this.jdField_a_of_type_Arld.byN();
    }
    this.bQ = null;
    Uc(true);
    ekj();
  }
  
  private void ekh()
  {
    if ((this.b == null) || (!this.b.aGM())) {}
    label95:
    do
    {
      return;
      if (this.b.aGN())
      {
        if ((this.jdField_a_of_type_Arle == null) || (!this.jdField_a_of_type_Arle.ap(this.b.getFloatingCenterX(), this.b.getFloatingCenterY())))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener == null) {
            break label95;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener.onEnter(this.b.getFloatingCenterX(), this.b.getFloatingCenterY());
        }
        for (;;)
        {
          arlb.ejU();
          return;
          aVf();
        }
      }
    } while (!this.b.aGO());
    ekk();
  }
  
  private void eki()
  {
    if (this.et != null)
    {
      if (this.et.getVisibility() != 0) {
        this.et.setVisibility(0);
      }
      if (this.et.getAlpha() != 1.0F) {
        this.et.setAlpha(1.0F);
      }
    }
    this.ekl = 0;
  }
  
  private void ekj()
  {
    if (this.b == null) {}
    do
    {
      return;
      if (this.b.aGN())
      {
        if (this.aEt == 1)
        {
          this.et.setContentDescription(acfp.m(2131706346));
          return;
        }
        this.et.setContentDescription(acfp.m(2131706347));
        return;
      }
      if (this.ekl == 0)
      {
        this.et.setContentDescription(acfp.m(2131706350));
        return;
      }
    } while (this.ekl != 1);
    this.et.setContentDescription(acfp.m(2131706344));
  }
  
  private void ekk()
  {
    switch (this.ekl)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.aEt != 0) && (this.aEt != 1));
      Zg(1);
      return;
    }
    Zg(0);
  }
  
  private void ekl()
  {
    onVideoStart(this.ekk);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStart();
    }
  }
  
  private void ekm()
  {
    onVideoStop();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  private boolean mN(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403);
  }
  
  private String stringForTime(long paramLong)
  {
    if (this.mFormatter == null)
    {
      this.mFormatBuilder = new StringBuilder();
      this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
    }
    this.ekm = ((int)(paramLong / 1000L));
    this.ekn = (this.ekm % 60);
    this.eko = (this.ekm / 60 % 60);
    this.ekp = (this.ekm / 3600);
    this.mFormatBuilder.setLength(0);
    if (this.ekp > 0) {
      return this.mFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(this.ekp), Integer.valueOf(this.eko), Integer.valueOf(this.ekn) }).toString();
    }
    return this.mFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(this.eko), Integer.valueOf(this.ekn) }).toString();
  }
  
  public void Ze(int paramInt)
  {
    if ((this.b != null) && (this.b.aGN())) {
      FloatingScreenManager.getInstance().saveFloatingCenter(this.b.getFloatingCenterX(), this.b.getFloatingCenterY());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoClose(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = null;
    ThreadManager.getUIHandler().removeCallbacks(this.ia);
    super.Ze(paramInt);
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    int i = super.a(paramFloatingScreenParams, paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoClose(6);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = null;
      this.ekk = 0;
      return i;
      arlb.ejQ();
    }
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a(arle paramarle)
  {
    super.a(paramarle);
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = paramIFullScreenEnterListener;
  }
  
  public void ekd()
  {
    a(true, new View[] { this.b, this.FV, this.acy });
    a(false, new View[] { this.acx, this.acz, this.FZ, this.pd, this.FW });
    b(true, new View[] { this.acx, this.acy, this.mSeekBar });
    eki();
    Ua(false);
    Ub(false);
    ekj();
  }
  
  public void eke()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a(0, new arlk(this));
    }
  }
  
  public void iJ(View paramView)
  {
    this.co.removeAllViews();
    iK(paramView);
    paramView.setId(2131375046);
    this.co.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    iK(this.FW);
    this.co.addView(this.FW);
    this.cn.removeAllViews();
    iK(this.co);
    this.cn.addView(this.co, new FrameLayout.LayoutParams(-1, -1));
    iK(this.et);
    this.cn.addView(this.et, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void initViews(Context paramContext)
  {
    super.initViews(paramContext);
    this.b.setOnBackPressListener(this);
    this.co = new FrameLayout(this.mContext);
    this.co.setId(2131375043);
    this.FW = new ImageView(this.mContext);
    this.FW.setId(2131375029);
    this.FW.setScaleType(ImageView.ScaleType.FIT_XY);
    this.FX = ((ImageView)this.et.findViewById(2131375033));
    this.FX.setContentDescription(acfp.m(2131706352));
    this.FY = ((ImageView)this.et.findViewById(2131375032));
    this.FY.setContentDescription(acfp.m(2131706348));
    this.acx = ((TextView)this.et.findViewById(2131375039));
    this.acx.setContentDescription(acfp.m(2131706349));
    this.acy = ((TextView)this.et.findViewById(2131375038));
    this.acy.setContentDescription(acfp.m(2131706345));
    this.lD = ((LinearLayout)this.et.findViewById(2131375036));
    this.pd = ((ImageView)this.et.findViewById(2131375034));
    this.pd.setContentDescription(acfp.m(2131706351));
    this.acz = ((TextView)this.et.findViewById(2131375040));
    this.FZ = ((ImageView)this.et.findViewById(2131375035));
    this.acA = ((TextView)this.et.findViewById(2131375042));
    this.acB = ((TextView)this.et.findViewById(2131375041));
    g(new View[] { this.FX, this.FY, this.acx, this.acy, this.pd });
    this.mSeekBar = ((SeekBar)this.et.findViewById(2131375045));
    this.mSeekBar.setOnSeekBarChangeListener(this);
    this.mSeekBar.setThumb(paramContext.getResources().getDrawable(2130850761));
    this.mSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130846938));
    if (this.Jt == null) {
      this.Jt = new ArrayList(4);
    }
    this.Jt.clear();
    this.Jt.add(this.lD);
    this.Jt.add(this.FX);
    this.Jt.add(this.FY);
  }
  
  public void onBackPressed()
  {
    Ze(3);
    arlb.ejW();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131375031)
    {
      Ze(1);
      arlb.ejT();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131375032)
      {
        Ze(2);
        arlb.eka();
      }
      else if (i == 2131375033)
      {
        ejN();
        arlb.ejV();
      }
      else if (i == 2131375039)
      {
        ekl();
        arlb.ejX();
      }
      else if (i == 2131375038)
      {
        ekm();
        arlb.ejX();
      }
      else if (i == 2131375034)
      {
        ekl();
      }
      else if (i == 2131375037)
      {
        ekh();
      }
    }
  }
  
  public void onOrientationChange(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.aGM())) {
      this.b.TY(paramBoolean);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.ekj = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoSeek(this.ekj);
      onVideoProgressUpdate((int)(this.ekj * this.ekk / 100.0D));
    }
  }
  
  public void onSetVideoCover(Bitmap paramBitmap)
  {
    if ((this.FW != null) && (paramBitmap != null))
    {
      this.FW.setImageBitmap(paramBitmap);
      this.FW.setVisibility(0);
    }
  }
  
  public void onSetVideoCover(Drawable paramDrawable)
  {
    if ((this.FW != null) && (paramDrawable != null))
    {
      this.FW.setImageDrawable(paramDrawable);
      this.FW.setVisibility(0);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStart();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoBuffering()
  {
    Zf(400);
    b(true, new View[] { this.acx, this.acy, this.mSeekBar });
    this.aEt = 3;
  }
  
  public void onVideoComplete(boolean paramBoolean)
  {
    if (this.b.aGN()) {
      arlb.ejY();
    }
    for (;;)
    {
      a(true, new View[] { this.acx, this.pd });
      a(false, new View[] { this.acy, this.acz, this.FZ });
      a(paramBoolean, new View[] { this.FW });
      b(true, new View[] { this.acx, this.acy, this.mSeekBar });
      this.acA.setText(stringForTime(this.ekk));
      this.mSeekBar.setProgress(100);
      this.aEt = 1;
      ekj();
      return;
      arlb.ejZ();
    }
  }
  
  public void onVideoError(int paramInt)
  {
    Zf(401);
    b(false, new View[] { this.acx, this.acy, this.mSeekBar });
    this.aEt = 2;
  }
  
  public void onVideoProgressUpdate(int paramInt)
  {
    if (this.ekk == 0) {
      return;
    }
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      this.ekj = ((int)(100.0D * i / this.ekk));
      this.mSeekBar.setProgress(this.ekj);
      this.acA.setText(stringForTime(i));
      return;
      i = paramInt;
      if (paramInt > this.ekk) {
        i = this.ekk;
      }
    }
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mVideoWidth = paramInt1;
    }
    if (paramInt2 > 0) {
      this.mVideoHeight = paramInt2;
    }
    FloatingScreenContainer localFloatingScreenContainer;
    if ((this.b != null) && (this.b.aGM()))
    {
      localFloatingScreenContainer = this.b;
      if (this.b.aGN()) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localFloatingScreenContainer.x(bool, this.mVideoWidth, this.mVideoHeight);
      return;
    }
  }
  
  public void onVideoStart(int paramInt)
  {
    if (this.ekk != paramInt) {
      arlb.Zb(paramInt);
    }
    a(false, new View[] { this.acx, this.pd, this.acz, this.FZ });
    a(true, new View[] { this.acy });
    b(true, new View[] { this.acx, this.acy, this.mSeekBar });
    ThreadManager.getUIHandler().postDelayed(this.ia, 300L);
    if (this.et != null)
    {
      if ((Build.VERSION.SDK_INT < 23) || (this.b == null) || (!this.b.aGO())) {
        break label172;
      }
      this.et.setBackgroundResource(2130847115);
    }
    label172:
    do
    {
      for (;;)
      {
        this.aEt = 0;
        ekj();
        if ((paramInt > 0) && (this.ekk != paramInt)) {
          break;
        }
        return;
        if ((this.mContext != null) && (this.mContext.getResources() != null)) {
          this.et.setBackgroundColor(this.mContext.getResources().getColor(2131167595));
        }
      }
      this.ekk = paramInt;
    } while (this.acB == null);
    this.acB.setText(stringForTime(this.ekk));
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.acx, this.pd });
    a(false, new View[] { this.acy, this.acz, this.FZ });
    b(true, new View[] { this.acx, this.acy, this.mSeekBar });
    this.aEt = 1;
    ekj();
  }
  
  public void setFullScreenViewClickListener(arld paramarld)
  {
    this.jdField_a_of_type_Arld = paramarld;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlj
 * JD-Core Version:    0.7.0.1
 */