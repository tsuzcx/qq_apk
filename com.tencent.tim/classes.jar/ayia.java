import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class ayia
  extends aygy
  implements View.OnClickListener
{
  private long BI;
  public float Fy = 3.0F;
  View Ng;
  private DoodleLayout a;
  private long aCH;
  public boolean aGH;
  arht jdField_b_of_type_Arht;
  private ayrk jdField_b_of_type_Ayrk;
  FrameLayout bw;
  private ProviderView c;
  int eKi = -1;
  private View fP;
  private String fakeId;
  private ViewGroup fo;
  private Dialog mDialog;
  private int mState = 0;
  private RelativeLayout ol;
  public float progress;
  
  public ayia(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private Bundle E()
  {
    Bundle localBundle = null;
    if (this.jdField_b_of_type_Aygz.bQ != null) {
      localBundle = this.jdField_b_of_type_Aygz.bQ.getBundle("container");
    }
    return localBundle;
  }
  
  private arht a()
  {
    arht localarht = new arht(getContext());
    localarht.YE(wja.dp2px(50.0F, getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    localarht.a(new ayib(this));
    return localarht;
  }
  
  private void eRR()
  {
    if (this.c == null)
    {
      this.c = new StaticStickerProviderView(getContext());
      this.c.setTabBarPosition(1);
      this.bw.addView(this.c);
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
      }
      return;
    }
    if (!this.c.isInit())
    {
      if (this.jdField_b_of_type_Aygz.ok != null)
      {
        int k = this.c.getContentHeight();
        int j = this.jdField_b_of_type_Aygz.ok.getHeight();
        int i = j;
        if (j <= 0) {
          i = ayxa.eMW;
        }
        i = (int)rpq.b(getContext(), i);
        this.c.TZ(i + k);
      }
      this.c.onCreate(E());
    }
    this.c.setVisibility(0);
    this.c.dKI();
    this.bw.setVisibility(0);
    this.Ng.setVisibility(0);
  }
  
  @TargetApi(16)
  private void initUI()
  {
    y(2131364110).setVisibility(8);
    this.fo = ((ViewGroup)y(2131381813));
    this.fo.setVisibility(0);
    this.ol = ((RelativeLayout)y(2131381815));
    if (ayxa.aRq())
    {
      this.fP = y(2131381824);
      this.fP.setBackground(null);
    }
    y(2131381818).setOnClickListener(this);
    if ((!axcg.am(this.jdField_a_of_type_Ayii.getActivity().getIntent())) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 14)) {
      ((TextView)y(2131381818)).setText(acfp.m(2131705591));
    }
    Object localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent();
    int i = axcg.i((Intent)localObject);
    if ((axcg.au((Intent)localObject)) || (i == axcg.n.getId()) || (i == axcg.g.getId()) || (i == axcg.q.getId()) || (i == axcg.r.getId()) || (i == axcg.o.getId()) || (i == axcg.s.getId()) || (i == axcg.v.getId())) {
      ((TextView)y(2131381818)).setText(getContext().getText(2131717066));
    }
    if ((axcg.b((Intent)localObject, this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())) || (axcg.ao(this.jdField_a_of_type_Ayii.getActivity().getIntent())))
    {
      y(2131381827).setVisibility(8);
      y(2131381822).setVisibility(8);
      y(2131381823).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)y(2131380515)).setText(2131696327);
      }
      y(2131381817).setOnClickListener(this);
      this.bw = ((FrameLayout)y(2131381820));
      this.Ng = y(2131381816);
      if (this.jdField_b_of_type_Aygz.ok != null)
      {
        i = this.jdField_b_of_type_Aygz.ok.getHeight();
        localObject = this.bw.getLayoutParams();
        if (i > 0) {
          break label634;
        }
        ((ViewGroup.LayoutParams)localObject).height += ayxa.eMW;
        label430:
        this.bw.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.Ng.getLayoutParams();
        if (i > 0) {
          break label647;
        }
        ((ViewGroup.LayoutParams)localObject).height += ayxa.eMW;
        label462:
        this.Ng.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((rpv.LS()) && (ankt.getRealHeight(getContext()) / ankt.aE(getContext()) >= 2.0F) && (ayxa.sHasNotch))
      {
        localObject = (RelativeLayout.LayoutParams)this.ol.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, ayxa.getNotchInScreenHeight((Activity)getContext()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.ol.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_b_of_type_Aygz.Ld()) {
        break label660;
      }
    }
    label647:
    label660:
    for (localObject = "2";; localObject = "1")
    {
      sqn.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_b_of_type_Aygz.La()) {
        break label667;
      }
      alwx.f(this.jdField_b_of_type_Aygz);
      return;
      y(2131381822).setOnClickListener(this);
      y(2131381823).setOnClickListener(this);
      break;
      label634:
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label430;
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label462;
    }
    label667:
    alwx.h(this.jdField_b_of_type_Aygz);
  }
  
  public void adB(String paramString)
  {
    this.fakeId = paramString;
  }
  
  public void adc()
  {
    if (this.jdField_a_of_type_Ayii == null) {
      return;
    }
    this.jdField_a_of_type_Ayii.getRootView().postDelayed(new EditVideoStoryButton.3(this), 1000L);
  }
  
  public void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    n(paramBoolean1, paramBoolean2, true);
  }
  
  public void az(int paramInt, long paramLong)
  {
    this.progress = paramInt;
    this.aGH = false;
    this.Fy = (50000.0F / (float)paramLong);
    if (this.Fy == 0.0F) {
      this.Fy = 1.0F;
    }
    adc();
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      dLp();
    }
    do
    {
      return;
      eRR();
      return;
      if (paramInt1 == 9) {
        n(true, true, false);
      }
      for (;;)
      {
        dLp();
        this.mState = paramInt2;
        this.jdField_b_of_type_Ayrk = null;
        return;
        at(true, false);
      }
      at(false, false);
      return;
      this.mState = paramInt2;
    } while (!(paramObject instanceof ayrk));
    this.jdField_b_of_type_Ayrk = ((ayrk)paramObject);
  }
  
  @TargetApi(14)
  public void d(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mDialog == null)
    {
      this.mDialog = new ReportDialog(getContext());
      Object localObject = this.mDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.mDialog.requestWindowFeature(1);
      this.mDialog.setContentView(2131562035);
      localObject = (ImageView)this.mDialog.findViewById(2131373659);
      this.jdField_b_of_type_Arht = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_b_of_type_Arht);
    }
    ((TextView)this.mDialog.findViewById(2131371989)).setText(paramString);
    this.mDialog.setCancelable(paramBoolean);
    this.mDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_b_of_type_Arht.setProgress(0);
    a().getRootView().postDelayed(new EditVideoStoryButton.2(this), paramInt);
  }
  
  public void dLp()
  {
    this.bw.setVisibility(8);
    this.Ng.setVisibility(8);
  }
  
  public void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  public void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.BK = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.BK += 500L;
      }
      if (paramBoolean1) {
        ayjd.t(this.fo, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_b_of_type_Aygz.a(Message.obtain(null, 11, Long.valueOf(this.BK)));
        return;
        ayjd.s(this.fo, paramBoolean3);
      }
    }
    this.fo.setAnimation(null);
    ViewGroup localViewGroup = this.fo;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.BK = 0L;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramIntent != null) && ((this.fakeId == null) || (!this.fakeId.equals(paramIntent.getStringExtra("fakeId")))));
        if (this.mState == 49) {}
        Object localObject;
        for (boolean bool = true;; bool = false)
        {
          localObject = this.jdField_b_of_type_Ayrk;
          this.jdField_b_of_type_Aygz.changeState(0);
          this.aGH = true;
          if (paramInt2 != -1) {
            break;
          }
          updateProgress(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (ayrk)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          dismissProgressDialog();
          localObject = new StringBuilder(acfp.m(2131705666));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Ayii.getContext(), 1, (CharSequence)localObject, 0).show();
          return;
        }
      } while (paramInt2 != 0);
      dismissProgressDialog();
      return;
    } while (paramInt2 != -1);
    this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayii.a(paramInt2, paramIntent, 2130772067, 0);
  }
  
  public boolean onBackPressed()
  {
    return System.currentTimeMillis() < this.BK;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (Math.abs(SystemClock.uptimeMillis() - this.BI) > 500L)
    {
      this.BI = SystemClock.uptimeMillis();
      i = paramView.getId();
      if (this.BK <= System.currentTimeMillis()) {
        break label91;
      }
      ram.w("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.BK), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.w("EditVideoStoryButton", "you click button too fast, ignore it !");
      continue;
      label91:
      this.jdField_b_of_type_Aygz.eRM();
      this.jdField_b_of_type_Aygz.bta();
      if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld()) && (this.jdField_b_of_type_Aygz.a() != null) && (!this.jdField_b_of_type_Aygz.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131381819: 
      case 2131381820: 
      case 2131381821: 
      default: 
        break;
      case 2131381817: 
        this.jdField_b_of_type_Aygz.bsV();
        break;
      case 2131381823: 
        if (this.jdField_b_of_type_Aygz.eO(5))
        {
          this.jdField_b_of_type_Aygz.changeState(0);
        }
        else
        {
          this.jdField_b_of_type_Aygz.eRK();
          sqn.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381822: 
        if (this.jdField_b_of_type_Aygz.eO(6))
        {
          this.jdField_b_of_type_Aygz.changeState(0);
        }
        else
        {
          this.jdField_b_of_type_Aygz.changeState(6);
          sqn.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381818: 
        axim.a().eKB();
        axip.a().eLu();
        axiy.i("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l = SystemClock.uptimeMillis();
        if ((l - this.aCH >= 800L) && (!this.jdField_a_of_type_Ayii.getActivity().isFinishing()))
        {
          this.aCH = l;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          this.jdField_b_of_type_Aygz.bsX();
          if (this.jdField_b_of_type_Aygz.La()) {
            alwx.e(this.jdField_b_of_type_Aygz);
          } else {
            alwx.g(this.jdField_b_of_type_Aygz);
          }
        }
        break;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initUI();
  }
  
  public void onDestroy()
  {
    dismissProgressDialog();
    super.onDestroy();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_b_of_type_Arht == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Arht.stopAnimating();
      this.jdField_b_of_type_Arht.setProgress(paramInt);
      this.jdField_b_of_type_Arht.setShowText(true);
      this.jdField_b_of_type_Arht.setShowImage(false);
      this.jdField_b_of_type_Arht.setText(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_b_of_type_Arht.getProgress() + ", progress:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayia
 * JD-Core Version:    0.7.0.1
 */