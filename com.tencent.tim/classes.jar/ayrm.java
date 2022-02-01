import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.1;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.2;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.3;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;
import java.util.Iterator;
import java.util.List;

public class ayrm
  extends aygy
  implements View.OnClickListener, ayjb.a, ayrb, ayrc, ayrd
{
  private ImageView arrowView;
  private ayrf b;
  private View backgroundView;
  private View contentView;
  private boolean dAv;
  private volatile boolean dAw;
  public boolean dAx;
  private View footerView;
  private XListView listView;
  private Handler mHandler;
  private View mRootView;
  private ObjectAnimator objectAnimator;
  private SlideBottomPanel slidePanel;
  
  public ayrm(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private boolean bF(int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramInt1 == 1) {
      if ((paramInt2 == 0) || (paramInt2 == 1000) || (paramInt2 == 1004)) {
        bool1 = true;
      }
    }
    do
    {
      return bool1;
      if (paramInt1 == 4)
      {
        if (paramInt2 == 1) {}
        for (bool1 = bool3;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramInt1 != 101);
    if (paramInt2 == 3000) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void dealSendViewAnimation()
  {
    if ((this.footerView != null) && (this.footerView.getVisibility() == 8) && (this.slidePanel.aQZ()) && (this.jdField_b_of_type_Ayrf != null) && (this.jdField_b_of_type_Ayrf.aQX()))
    {
      this.dAw = true;
      showSendView(0, 1, 0);
      alwx.b(this.jdField_b_of_type_Aygz);
    }
  }
  
  private void eTq()
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3F, 0.0F), Keyframe.ofFloat(0.45F, -80.0F), Keyframe.ofFloat(0.65F, 50.0F), Keyframe.ofFloat(0.8F, -30.0F), Keyframe.ofFloat(0.9F, 10.0F), Keyframe.ofFloat(1.0F, 0.0F) });
    this.objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.contentView, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.objectAnimator.setDuration(1600L);
    this.objectAnimator.setStartDelay(1000L);
    this.objectAnimator.setRepeatCount(1);
    this.objectAnimator.start();
    this.dAv = true;
  }
  
  private View getBottomView()
  {
    View localView = new View(getContext());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(130.0F, getResources())));
    localView.setBackgroundResource(2130851351);
    return localView;
  }
  
  private void initData()
  {
    this.mHandler = new Handler(Looper.getMainLooper());
    ayrl.a().a(this);
    List localList = ayrl.a().ib();
    if ((localList != null) && (this.jdField_b_of_type_Ayrf != null))
    {
      oV(localList);
      this.jdField_b_of_type_Ayrf.setData(localList);
    }
    ayjb.a().a(this);
  }
  
  private void initView()
  {
    this.mRootView = ((ViewStub)y(2131378002)).inflate();
    this.slidePanel = ((SlideBottomPanel)this.mRootView.findViewById(2131378488));
    this.contentView = this.mRootView.findViewById(2131365396);
    this.listView = ((XListView)this.mRootView.findViewById(2131370527));
    this.footerView = this.mRootView.findViewById(2131378016);
    this.backgroundView = this.mRootView.findViewById(2131363236);
    this.arrowView = ((ImageView)this.mRootView.findViewById(2131380118));
    this.listView.addFooterView(getBottomView());
    this.jdField_b_of_type_Ayrf = new ayrf(getContext(), this);
    this.jdField_b_of_type_Ayrf.a(this);
    this.listView.setAdapter(this.jdField_b_of_type_Ayrf);
    this.slidePanel.setSlidePanelListener(this);
    this.footerView.findViewById(2131377979).setOnClickListener(this);
  }
  
  private void oV(List<ayrk> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ayrk)paramList.next()).eTl();
      }
    }
  }
  
  private void showSendView(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.footerView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.footerView.setVisibility(paramInt3);
  }
  
  public void Zr(boolean paramBoolean)
  {
    if (this.slidePanel != null)
    {
      if (!paramBoolean) {
        break label29;
      }
      if (!this.slidePanel.aQY()) {
        this.slidePanel.eTr();
      }
    }
    label29:
    while (!this.slidePanel.aQY()) {
      return;
    }
    this.slidePanel.eTs();
  }
  
  public void a(int paramInt, ayrk paramayrk)
  {
    if (this.jdField_b_of_type_Ayrf != null)
    {
      this.jdField_b_of_type_Ayrf.a(paramInt, paramayrk);
      if (this.listView != null)
      {
        int i = this.listView.getFirstVisiblePosition();
        int j = this.listView.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j))
        {
          Object localObject = this.listView.getChildAt(paramInt - i);
          if ((((View)localObject).getTag() instanceof ayrf.a))
          {
            localObject = (ayrf.a)((View)localObject).getTag();
            ((ayrf.a)localObject).d = paramayrk;
            this.jdField_b_of_type_Ayrf.a(paramInt, (ayrf.a)localObject);
          }
        }
      }
      if (!this.dAw) {
        dealSendViewAnimation();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.i("SendPanelPart", 4, "onUpdateIcon uin is empty");
      }
    }
    label164:
    do
    {
      for (;;)
      {
        return;
        List localList = ayrl.a().ib();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        int j = localList.size();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label164;
          }
          ayrk localayrk = (ayrk)localList.get(i);
          if ((!TextUtils.isEmpty(localayrk.uin)) && (localayrk.uin.equals(paramString1)) && (bF(paramInt, localayrk.messageType)))
          {
            localayrk.iconBitmap = paramBitmap;
            localayrk.iconUrl = paramString2;
            if (this.mHandler == null) {
              break;
            }
            this.mHandler.post(new SendPanelPart.2(this, i, localayrk));
            return;
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
  }
  
  public void cancelAnimator()
  {
    if ((this.dAv) && (this.objectAnimator != null))
    {
      this.objectAnimator.cancel();
      this.dAv = false;
    }
  }
  
  public void destroy()
  {
    if (this.jdField_b_of_type_Ayrf != null) {
      this.jdField_b_of_type_Ayrf.destroy();
    }
  }
  
  public void displayPanel()
  {
    dealSendViewAnimation();
    if (this.backgroundView != null) {
      this.backgroundView.setVisibility(0);
    }
    alwx.d(this.jdField_b_of_type_Aygz);
  }
  
  public void displayPanelFinish()
  {
    if (this.arrowView != null) {
      this.arrowView.setBackgroundResource(2130850667);
    }
  }
  
  public void eRX()
  {
    if ((this.jdField_b_of_type_Ayrf != null) && (this.mHandler != null))
    {
      this.mHandler.post(new SendPanelPart.3(this));
      this.dAw = false;
    }
  }
  
  public void eTk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SendPanelPart", 4, "compositeFail");
    }
    if (this.mHandler != null) {
      this.mHandler.post(new SendPanelPart.1(this));
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (this.backgroundView != null)
    {
      this.backgroundView.setVisibility(0);
      this.backgroundView.setAlpha(paramFloat);
    }
  }
  
  @NonNull
  public Context getContext()
  {
    return super.getContext();
  }
  
  public void hQ(List<ayrk> paramList)
  {
    if (this.jdField_b_of_type_Ayrf != null) {
      this.jdField_b_of_type_Ayrf.setData(paramList);
    }
  }
  
  public void hidePanel()
  {
    if ((this.footerView != null) && (this.footerView.getVisibility() == 0)) {
      showSendView(1, 0, 8);
    }
    if (this.backgroundView != null) {
      this.backgroundView.setVisibility(8);
    }
  }
  
  public void hidePanelFinish()
  {
    if (this.arrowView != null) {
      this.arrowView.setBackgroundResource(2130850666);
    }
  }
  
  public boolean onBackPressed()
  {
    return super.onBackPressed();
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
      if (this.jdField_b_of_type_Aygz.a.aQA()) {
        this.dAx = true;
      }
      this.jdField_b_of_type_Aygz.bsV();
      alwx.a(this.jdField_b_of_type_Aygz);
      axip.a().eLu();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initView();
    initData();
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Ayrf != null) {
      this.jdField_b_of_type_Ayrf.onDestroy();
    }
    this.dAw = false;
    ayjb.a().b(this);
    super.onDestroy();
  }
  
  public void onLoadStart() {}
  
  public void onResume()
  {
    super.onResume();
    if (ayrl.a().dAu)
    {
      ayrl.a().dAu = false;
      eTq();
      ayrl.a().ZM(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrm
 * JD-Core Version:    0.7.0.1
 */