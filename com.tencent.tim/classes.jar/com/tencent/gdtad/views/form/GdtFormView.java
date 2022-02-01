package com.tencent.gdtad.views.form;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import arhz;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.AdFormViewListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.xijing.AdButtonView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import tkw;
import tlx;
import tly;
import tmc;

public class GdtFormView
  extends LinearLayout
  implements AdFormCommitListener, AdFormErrorListener
{
  private GdtFormTableView a;
  private GdtAd ad;
  private int bCa = -1;
  private View.OnClickListener cQ = new tlx(this);
  private AdFormData data;
  private WeakReference<AdFormViewListener> listener;
  private arhz t;
  private QQToast toast;
  
  public GdtFormView(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    super(paramContext);
    a(paramContext, paramGdtAd, paramAdFormData);
  }
  
  private void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      tkw.e("GdtFormView", "init error");
      return;
    }
    this.ad = paramGdtAd;
    this.data = paramAdFormData;
    tmc.d(new WeakReference(a()));
    initViews(paramContext);
  }
  
  private void a(boolean paramBoolean, AdFormError paramAdFormError)
  {
    if ((this.listener != null) && (this.listener.get() != null)) {
      ((AdFormViewListener)this.listener.get()).onCommitted(paramBoolean, paramAdFormError);
    }
  }
  
  private void commit()
  {
    tly.a(getContext(), getAd(), a(), new WeakReference(this));
  }
  
  private void initViews(Context paramContext)
  {
    if ((this.data == null) || (!this.data.isValid()))
    {
      tkw.e("GdtFormView", "initViews error");
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setBackgroundColor(a().backgroundColor);
    setOrientation(1);
    if (a().title != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new TextView(paramContext);
        ((TextView)localObject).setText(a().title.text);
        ((TextView)localObject).setTextColor(a().title.color);
        ((TextView)localObject).setTextSize(0, a().title.size);
        ((TextView)localObject).setTypeface(null, 1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        addView((View)localObject, localLayoutParams);
      }
      this.a = new GdtFormTableView(paramContext, a().table, new WeakReference(this));
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      }
      addView(this.a, (ViewGroup.LayoutParams)localObject);
      paramContext = new AdButtonView(paramContext, a().button);
      localObject = new LinearLayout.LayoutParams(-1, a().buttonHeight);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      paramContext.setOnClickListener(this.cQ);
      return;
    }
  }
  
  private void reset()
  {
    if (this.a == null)
    {
      tkw.e("GdtFormView", "reset error");
      return;
    }
    this.a.reset();
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      tkw.e("GdtFormView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.t != null) && (this.t.isShowing()));
      this.t = new arhz(getContext(), getResources().getDimensionPixelSize(2131299627));
      this.t.setCancelable(false);
      this.t.setMessage(acfp.m(2131706872) + a().button.text.text);
      this.t.show();
      return;
    } while ((paramBoolean) || (this.t == null));
    if (this.t.isShowing()) {}
    try
    {
      this.t.dismiss();
      this.t = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        tkw.e("GdtFormView", "showLoading", localThrowable);
      }
    }
  }
  
  private boolean validate()
  {
    if ((a() == null) || (!a().isValid()))
    {
      tkw.e("GdtFormView", "validate error");
      return false;
    }
    AdFormError localAdFormError = a().validate();
    if (localAdFormError == null)
    {
      tkw.e("GdtFormView", "validate error");
      return false;
    }
    if (localAdFormError.type == 2) {
      return true;
    }
    onError(localAdFormError);
    return false;
  }
  
  protected AdFormData a()
  {
    return this.data;
  }
  
  public void afterCommit(AdFormError paramAdFormError)
  {
    boolean bool = true;
    showLoading(false);
    onError(paramAdFormError);
    if ((paramAdFormError != null) && (paramAdFormError.type == 1)) {}
    for (;;)
    {
      if (bool) {
        reset();
      }
      a(bool, paramAdFormError);
      return;
      bool = false;
    }
  }
  
  public void beforeCommit()
  {
    showLoading(true);
  }
  
  protected GdtAd getAd()
  {
    return this.ad;
  }
  
  public void onError(AdFormError paramAdFormError)
  {
    if ((paramAdFormError == null) || (a() == null) || (!a().isValid())) {
      tkw.e("GdtFormView", "onError error");
    }
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
              if (paramAdFormError.type != 1) {
                break;
              }
              this.bCa = -1;
              this.a.showError(-1);
            } while ((this.toast != null) && (this.toast.isShowing()));
            this.toast = QQToast.a(getContext(), 2, a().button.text.text + acfp.m(2131706871), 0);
            this.toast.show();
            return;
            if (paramAdFormError.type != 4) {
              break;
            }
            this.bCa = -1;
            this.a.showError(-1);
          } while ((this.toast != null) && (this.toast.isShowing()));
          this.toast = QQToast.a(getContext(), 1, a().button.text.text + acfp.m(2131706874), 0);
          this.toast.show();
          return;
          if (paramAdFormError.type != 7) {
            break;
          }
          this.bCa = -1;
          this.a.showError(-1);
        } while ((this.toast != null) && (this.toast.isShowing()));
        this.toast = QQToast.a(getContext(), 1, acfp.m(2131706873), 0);
        this.toast.show();
        return;
        if (paramAdFormError.type != 2) {
          break;
        }
      } while ((paramAdFormError.index != -1) && (paramAdFormError.index != this.bCa));
      this.bCa = -1;
      this.a.showError(-1);
      return;
      if ((paramAdFormError.index == -1) || (TextUtils.isEmpty(paramAdFormError.toString()))) {
        break;
      }
      this.bCa = paramAdFormError.index;
      this.a.showError(this.bCa);
    } while ((this.toast != null) && (this.toast.isShowing()));
    this.toast = QQToast.a(getContext(), 1, paramAdFormError.toString(), 0);
    this.toast.show();
    return;
    tkw.e("GdtFormView", "onError error");
  }
  
  public void setListener(WeakReference<AdFormViewListener> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormView
 * JD-Core Version:    0.7.0.1
 */