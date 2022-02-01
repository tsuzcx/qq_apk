package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acfp;
import aelc;
import aelc.a;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import ysf;
import yuw;

public class PhoneContactStatusCheckView
  extends LinearLayout
  implements View.OnClickListener
{
  private Boolean aj;
  private boolean bss;
  private boolean bst;
  private boolean bsu;
  private Button eL;
  private int mCurState = 0;
  private ImageView mIconView;
  private ImageView mLoadingView;
  private WeakReference<PhoneContactFragment> mRef;
  private TextView mTipView;
  private Handler mUIHandler;
  
  public PhoneContactStatusCheckView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PhoneContactStatusCheckView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PhoneContactStatusCheckView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void crn()
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.1(this), 16, null, true);
  }
  
  private void init()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131559423, this);
    this.mIconView = ((ImageView)findViewById(2131365246));
    this.mLoadingView = ((ImageView)findViewById(2131370787));
    this.mTipView = ((TextView)findViewById(2131365247));
    this.eL = ((Button)findViewById(2131365245));
    this.eL.setOnClickListener(this);
    this.mUIHandler = new Handler(Looper.getMainLooper());
    crn();
  }
  
  public void Bi(boolean paramBoolean) {}
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    anot.a(paramQQAppInterface, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  public void bu(QQAppInterface paramQQAppInterface)
  {
    this.aj = Boolean.valueOf(((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).Uy());
  }
  
  public void bv(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (localObject == null) {
      QLog.e("PhoneContactStatusCheckView", 1, "checkPhoneStatus CONTACT_MANAGER get null.");
    }
    label24:
    label69:
    do
    {
      do
      {
        do
        {
          return;
          if (this.aj == null) {
            this.aj = Boolean.valueOf(((PhoneContactManagerImp)localObject).Uw());
          }
          RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)localObject).a();
          int j = ((PhoneContactManagerImp)localObject).xy();
          int i;
          if (!this.aj.booleanValue())
          {
            i = 4;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactStatusCheckView", 2, String.format("checkPhoneStatus [%s, %s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), this.aj, localRespondQueryQQBindingStat }));
            }
            localObject = ((ysf)paramQQAppInterface.getManager(34)).a();
            switch (i)
            {
            default: 
              setVisibility(8);
              showLoading(false);
            }
          }
          for (;;)
          {
            if (this.mCurState != i) {
              this.mCurState = i;
            }
            switch (this.mCurState)
            {
            default: 
              return;
            case 1: 
              if (this.bss) {
                break label24;
              }
              this.bss = true;
              a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
              return;
              if (j >= 9)
              {
                if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.isStopFindMatch))
                {
                  i = 3;
                  break label69;
                }
                i = 0;
                break label69;
              }
              if (j == 8)
              {
                if (((PhoneContactManagerImp)localObject).Uo())
                {
                  i = 5;
                  break label69;
                }
                i = 0;
                break label69;
              }
              if (j == 7)
              {
                i = 2;
                break label69;
              }
              if ((j == 6) && (((PhoneContactManagerImp)localObject).a().lastUsedFlag == 3L))
              {
                i = 3;
                break label69;
              }
              if (j == 2)
              {
                i = 0;
                break label69;
              }
              if (j == 4)
              {
                if (((PhoneContactManagerImp)localObject).Uo())
                {
                  i = 5;
                  break label69;
                }
                i = 0;
                break label69;
              }
              i = 1;
              break label69;
              setVisibility(0);
              this.mIconView.setVisibility(0);
              showLoading(false);
              this.mTipView.setText(((aelc)localObject).d.title);
              this.eL.setText(((aelc)localObject).d.buttonTitle);
              this.eL.setVisibility(0);
              continue;
              setVisibility(0);
              this.mIconView.setVisibility(0);
              showLoading(false);
              this.mTipView.setText(((aelc)localObject).c.title);
              this.eL.setText(((aelc)localObject).c.buttonTitle);
              this.eL.setVisibility(0);
              continue;
              setVisibility(0);
              this.mIconView.setVisibility(0);
              showLoading(false);
              this.mTipView.setText(((aelc)localObject).e.title);
              this.eL.setText(((aelc)localObject).e.buttonTitle);
              this.eL.setVisibility(0);
              continue;
              setVisibility(0);
              this.mIconView.setVisibility(0);
              showLoading(false);
              this.mTipView.setText(((aelc)localObject).f.title);
              this.eL.setText(((aelc)localObject).f.buttonTitle);
              this.eL.setVisibility(0);
              continue;
              setVisibility(0);
              this.mIconView.setVisibility(8);
              showLoading(true);
              this.mTipView.setText(acfp.m(2131709500));
              this.eL.setVisibility(8);
              continue;
              setVisibility(8);
              showLoading(false);
            }
          }
        } while (this.bst);
        this.bst = true;
        a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
        return;
      } while (this.bsu);
      this.bsu = true;
      a(paramQQAppInterface, "dc00898", "0X8009F25", 0);
      return;
    } while (this.bsu);
    this.bsu = true;
    a(paramQQAppInterface, "dc00898", "0X8009F23", 0);
  }
  
  public void cro()
  {
    this.bsu = false;
    this.bst = false;
    this.bss = false;
  }
  
  protected void g(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.3(this, paramPhoneContactManagerImp), 16, null, false);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.mRef == null)
    {
      localObject = null;
      if (localObject != null) {
        break label35;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (PhoneContactFragment)this.mRef.get();
      break;
      label35:
      localObject = ((PhoneContactFragment)localObject).getActivity();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((FragmentActivity)localObject).app;
        if (localQQAppInterface != null)
        {
          PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)localQQAppInterface.getManager(11);
          if (localPhoneContactManagerImp == null)
          {
            QLog.i("PhoneContactStatusCheckView", 1, "onClick CONTACT_MANAGER is null");
          }
          else if (!aqiw.isNetSupport(getContext()))
          {
            localObject = BaseApplicationImpl.getContext();
            QQToast.a((Context)localObject, 1, 2131696348, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299627));
          }
          else
          {
            switch (this.mCurState)
            {
            }
            for (;;)
            {
              int i = localPhoneContactManagerImp.xy();
              if (QLog.isColorLevel()) {
                QLog.d("PhoneContactStatusCheckView", 2, "onClick phone contact state = " + i + ", has = " + this.aj);
              }
              if (this.aj.booleanValue()) {
                break label321;
              }
              yuw.a((Activity)localObject, localQQAppInterface, new PhoneContactStatusCheckView.2(this, localPhoneContactManagerImp), new DenyRunnable((Context)localObject, new DenyRunnable.a(localQQAppInterface)));
              break;
              a(localQQAppInterface, "dc00898", "0X8009F22", 0);
              continue;
              a(localQQAppInterface, "dc00898", "0X8009F22", 0);
              continue;
              a(localQQAppInterface, "dc00898", "0X8009F26", 0);
              continue;
              a(localQQAppInterface, "dc00898", "0X8009F24", 0);
            }
            label321:
            g(localPhoneContactManagerImp);
          }
        }
      }
    }
  }
  
  public void setPhoneContactFragment(PhoneContactFragment paramPhoneContactFragment)
  {
    this.mRef = new WeakReference(paramPhoneContactFragment);
  }
  
  public void showLoading(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      this.mLoadingView.setVisibility(0);
      localDrawable = this.mLoadingView.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).start();
      }
    }
    do
    {
      return;
      this.mLoadingView.setVisibility(8);
      localDrawable = this.mLoadingView.getDrawable();
    } while (!(localDrawable instanceof AnimationDrawable));
    ((AnimationDrawable)localDrawable).stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView
 * JD-Core Version:    0.7.0.1
 */