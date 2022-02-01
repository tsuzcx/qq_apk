package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aydg;
import aygk;
import aygl;
import aygm;
import aygy;
import aygz;
import ayhm;
import ayii;
import azbx;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import prw;
import prw.a;
import psd;
import psr;
import psx;
import ram;
import rar;
import rrq;
import rsu;
import wja;

public class EditVideoGuide
  extends aygy
  implements View.OnClickListener
{
  private GotoLocationPageDelayRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable;
  private InitGuideTypeDelayRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable;
  public int aYE;
  protected AtomicBoolean aZ = new AtomicBoolean();
  public int bqm;
  private RelativeLayout fU;
  private Handler mHandler;
  private ImageView ni;
  private TextView yn;
  
  public EditVideoGuide(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private boolean KY()
  {
    return ((Boolean)((psr)psx.a(10)).c("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  private void bsM()
  {
    switch (this.aYE)
    {
    default: 
      return;
    case 3: 
    case 6: 
      this.b.changeState(6);
      return;
    case 4: 
      this.b.changeState(2);
      return;
    }
    this.b.changeState(7);
  }
  
  private boolean eN(int paramInt)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide. guideType = %d", Integer.valueOf(paramInt));
    int j = -wja.dp2px(1.0F, getContext().getResources());
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    switch (paramInt)
    {
    default: 
      ram.e("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide error. unknown guideType = %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    case 1: 
      this.yn.setText(acfp.m(2131705529));
      i = wja.dp2px(12.0F, getContext().getResources());
      paramInt = 0;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ni.getLayoutParams();
      localLayoutParams.setMargins(i, 0, 0, 0);
      this.ni.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.yn.getLayoutParams();
      localLayoutParams.setMargins(paramInt, 0, 0, j);
      this.yn.setLayoutParams(localLayoutParams);
      this.fU.setVisibility(0);
      return true;
      this.yn.setText(acfp.m(2131705649));
      this.yn.measure(i, k);
      i = this.yn.getMeasuredWidth();
      paramInt = wja.dp2px(114.0F, getContext().getResources());
      k = i / 2;
      i = wja.dp2px(108.0F, getContext().getResources());
      paramInt -= k;
      continue;
      this.yn.setText(acfp.m(2131705546));
      this.yn.measure(i, k);
      i = this.yn.getMeasuredWidth();
      paramInt = wja.dp2px(162.0F, getContext().getResources());
      k = i / 2;
      i = wja.dp2px(156.0F, getContext().getResources());
      paramInt -= k;
      continue;
      this.yn.setText(acfp.m(2131705504));
      this.yn.measure(i, k);
      i = this.yn.getMeasuredWidth();
      paramInt = wja.dp2px(114.0F, getContext().getResources());
      k = i / 2;
      i = wja.dp2px(108.0F, getContext().getResources());
      paramInt -= k;
      continue;
      this.yn.setText(acfp.m(2131705544));
      paramInt = wja.dp2px(15.0F, getResources());
      k = wja.dp2px(12.0F, getResources());
      i = wja.dp2px(12.0F, getResources());
      k = (azbx.SCREEN_WIDTH - paramInt * 2 - k * 5) / 6;
      paramInt = wja.dp2px(3.0F, getResources());
      i = paramInt + (k - i) / 2;
      localLayoutParams = (RelativeLayout.LayoutParams)this.fU.getLayoutParams();
      localLayoutParams.setMargins(0, 0, 0, wja.dp2px(161.0F, getResources()));
      this.fU.setLayoutParams(localLayoutParams);
    }
  }
  
  private void startAnimation()
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(500L);
    localAlphaAnimation1.setRepeatCount(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.05F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(10);
    localTranslateAnimation.setRepeatMode(2);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(500L);
    localAlphaAnimation2.setRepeatCount(0);
    localAlphaAnimation2.setStartOffset(5000L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation2);
    localAnimationSet.setFillAfter(false);
    this.fU.startAnimation(localAnimationSet);
    localTranslateAnimation.setAnimationListener(new aygm(this));
  }
  
  public void bsL()
  {
    if (this.aYE != 8)
    {
      if (this.fU != null)
      {
        this.fU.clearAnimation();
        this.fU.setVisibility(4);
      }
      this.aYE = 8;
    }
  }
  
  public void bsN()
  {
    if (this.aYE == 6) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.mHandler == null) {
          this.mHandler = new Handler();
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable = new GotoLocationPageDelayRunnable();
        }
        this.mHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable, 200L);
      }
      return;
    }
  }
  
  public boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return super.e(paramMessage);
      ram.d("Q.qqstory.publish.edit.EditVideoGuide", "handleEditVideoMessage. mWaitForFragmentMsg = %s.", Boolean.valueOf(this.aZ.get()));
    } while (!this.aZ.compareAndSet(true, false));
    if ((this.mHandler != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable != null))
    {
      this.mHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = null;
    }
    paramMessage = (ayhm)a(ayhm.class);
    if (paramMessage != null) {}
    for (paramMessage = paramMessage.ca();; paramMessage = null)
    {
      int i;
      if (paramMessage == null)
      {
        i = 0;
        int j = i;
        if (i > this.b.a.ti()) {
          j = this.b.a.ti();
        }
        if (j >= 2) {
          break label171;
        }
        tA(false);
      }
      for (;;)
      {
        yK();
        return true;
        i = paramMessage.size();
        break;
        label171:
        tA(true);
      }
    }
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
      bsM();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.fU = ((RelativeLayout)y(2131375268));
    this.yn = ((TextView)y(2131375269));
    this.ni = ((ImageView)y(2131375270));
    this.yn.setOnClickListener(this);
    boolean bool1 = aygz.r(this.b.a.aCQ, 262144);
    boolean bool2 = KY();
    if ((!bool1) || (bool2))
    {
      ram.d("Q.qqstory.publish.edit.EditVideoGuide", "enableMultiVideoFragment = %s, hasShowFragmentGuide = %s.", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      tA(false);
      this.aZ.set(false);
      return;
    }
    ram.i("Q.qqstory.publish.edit.EditVideoGuide", "wait for fragment list message.");
    this.aZ.set(true);
    if (this.mHandler == null) {
      this.mHandler = new Handler();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = new InitGuideTypeDelayRunnable(null);
    }
    this.mHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable, 5000L);
  }
  
  public void onDestroy()
  {
    if (this.fU != null) {
      this.fU.clearAnimation();
    }
    if (this.mHandler != null)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable != null)
      {
        this.mHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable = null;
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable != null)
      {
        this.mHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = null;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.aZ.get()) {
      yK();
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    paramObject = (psr)psx.a(10);
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      bsL();
    case 0: 
    case 13: 
    case 10: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
    case 7: 
    case 5: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    rsu localrsu = new rsu(this.jdField_a_of_type_Ayii.getContext());
                    localrsu.sI(acfp.m(2131705614));
                    localrsu.show();
                    localrsu.setOnDismissListener(new aygk(this));
                    paramObject.n("has_show_basal_guide", Boolean.valueOf(true));
                    rar.a("video_edit", "guide_txt", 0, 0, new String[0]);
                    return;
                    paramObject = new rrq(this.jdField_a_of_type_Ayii.getContext());
                    paramObject.sI(acfp.m(2131705645));
                  } while (((Activity)getContext()).isFinishing());
                  paramObject.show();
                  paramObject.setOnDismissListener(new aygl(this));
                  rar.a("video_edit", "guide_filter", 0, 0, new String[0]);
                  return;
                } while (!eN(2));
                startAnimation();
                rar.a("video_edit", "guide_sticker", 0, 0, new String[0]);
                return;
              } while (!eN(3));
              startAnimation();
              paramObject.n("has_show_music_guide", Boolean.valueOf(true));
              rar.a("video_edit", "guide_music", 0, 0, new String[0]);
              return;
            } while (!eN(1));
            startAnimation();
            paramObject.n("has_show_draw_line_guide", Boolean.valueOf(true));
            rar.a("video_edit", "guide_graffiti", 0, 0, new String[0]);
            return;
          } while (!eN(4));
          startAnimation();
          paramObject.n("has_show_add_poi_paster_guide", Boolean.valueOf(true));
          rar.a("video_edit", "guide_place", 0, 0, new String[0]);
          return;
        } while (!eN(5));
        startAnimation();
        paramObject.n("has_show_fragment_guide", Boolean.valueOf(true));
        return;
        if (this.b.a.asi == 1) {
          paramObject.n("has_show_draw_line_guide", Boolean.valueOf(true));
        }
        bsL();
        return;
      } while (this.aYE == 2);
      bsL();
      return;
    case 6: 
      bsN();
      bsL();
      return;
    }
    if (this.b.a.asi == 1) {
      paramObject.n("has_show_music_guide", Boolean.valueOf(true));
    }
    bsL();
  }
  
  protected void tA(boolean paramBoolean)
  {
    if (this.b.a.asi != 1)
    {
      this.aYE = 8;
      this.bqm = 8;
      ram.i("Q.qqstory.publish.edit.EditVideoGuide", "not story business, initial guideType = GUIDE_NULL.");
      return;
    }
    ram.d("Q.qqstory.publish.edit.EditVideoGuide", "initGuideType. enableMultiFragment = %s.", Boolean.valueOf(paramBoolean));
    psr localpsr = (psr)psx.a(10);
    if ((paramBoolean) && (!((Boolean)localpsr.c("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue()))
    {
      this.aYE = 7;
      this.bqm = 7;
      return;
    }
    if (!((Boolean)localpsr.c("has_show_basal_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.aYE = 1;
      this.bqm = 1;
      return;
    }
    paramBoolean = ((Boolean)localpsr.c("has_show_music_guide", Boolean.valueOf(false))).booleanValue();
    prw localprw = (prw)((psd)psx.a(20)).a(1);
    if ((!paramBoolean) && (!localprw.a((prw.a)localprw.getData())))
    {
      this.aYE = 4;
      this.bqm = 4;
      return;
    }
    if (!((Boolean)localpsr.c("has_show_draw_line_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.aYE = 5;
      this.bqm = 5;
      return;
    }
    if (!((Boolean)localpsr.c("has_show_add_poi_paster_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.aYE = 6;
      this.bqm = 6;
      return;
    }
    this.aYE = 8;
    this.bqm = 8;
  }
  
  protected void yK()
  {
    ram.d("Q.qqstory.publish.edit.EditVideoGuide", "checkShowGuide. guideType = %d.", Integer.valueOf(this.aYE));
    switch (this.aYE)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 7: 
      this.b.changeState(24);
      return;
    case 1: 
      this.b.changeState(13);
      return;
    case 4: 
      this.b.changeState(15);
      return;
    case 5: 
      this.b.changeState(16);
      return;
    }
    this.b.changeState(17);
  }
  
  class GotoLocationPageDelayRunnable
    implements Runnable
  {
    public GotoLocationPageDelayRunnable() {}
    
    public void run()
    {
      aydg localaydg = (aydg)EditVideoGuide.this.a(aydg.class);
      if (localaydg != null) {
        localaydg.bsa();
      }
    }
  }
  
  class InitGuideTypeDelayRunnable
    implements Runnable
  {
    private InitGuideTypeDelayRunnable() {}
    
    public void run()
    {
      if (EditVideoGuide.this.aZ.compareAndSet(true, false))
      {
        EditVideoGuide.this.tA(false);
        EditVideoGuide.this.yK();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide
 * JD-Core Version:    0.7.0.1
 */