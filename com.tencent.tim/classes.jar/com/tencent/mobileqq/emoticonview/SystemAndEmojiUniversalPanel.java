package com.tencent.mobileqq.emoticonview;

import afmf;
import afom;
import afoo;
import afos;
import afqq;
import afqr;
import afqu;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import aqnm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class SystemAndEmojiUniversalPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private EditText H;
  private afqq jdField_a_of_type_Afqq;
  private b jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$b;
  private ImageButton ax;
  private boolean bZX;
  private EmotionPanelListView c;
  private int cSL;
  private int cSx;
  private int cSy;
  private boolean can;
  private boolean cao;
  private afoo d;
  private float density;
  private afmf g;
  private int[] kZ = new int[2];
  private int spacing;
  private TextWatcher textWatcher = new afqu(this);
  
  public SystemAndEmojiUniversalPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int Dv()
  {
    if (ajL()) {
      return this.ax.getMeasuredHeight();
    }
    return 0;
  }
  
  private void Nb(int paramInt)
  {
    ThreadManager.post(new SystemAndEmojiUniversalPanel.1(this, paramInt), 5, null, true);
  }
  
  private void a(List<afom> paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (afom)paramList.get(i);
        if ((paramListView instanceof afqr))
        {
          paramListView = (afqr)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.b(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (afom)paramList.get(i);
        if ((paramListView instanceof afqr))
        {
          paramListView = (afqr)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.b(getContext(), this.density);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  private boolean ajL()
  {
    return (this.ax != null) && (this.ax.getVisibility() == 0);
  }
  
  private int getColumnNum()
  {
    int j = this.d.TL;
    int i = j;
    if (this.bZX)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonUniversalPanel", 2, "multiWindowMode: " + this.d.TL + "->" + j);
        i = j;
      }
    }
    return i;
  }
  
  private void gv(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.kZ[1] + paramView.getWidth() - this.spacing - this.cSx;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  private void m(AbsListView paramAbsListView)
  {
    if (ajL())
    {
      int[] arrayOfInt = new int[2];
      this.ax.getLocationOnScreen(arrayOfInt);
      this.cSy = this.ax.getLeft();
      this.cSx = arrayOfInt[1];
      n(paramAbsListView);
    }
  }
  
  private void n(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.kZ);
            this.kZ[0] = localView2.getLeft();
            if ((this.cSy > 0) && (this.kZ[0] + localView2.getWidth() * 2.0F / 3.0F > this.cSy) && (this.cSx > 0) && (this.kZ[1] + localView2.getWidth() - this.spacing > this.cSx)) {
              gv(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$b != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$b.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void init()
  {
    setBackgroundColor(getResources().getColor(2131165785));
    this.density = getResources().getDisplayMetrics().density;
    this.spacing = aqnm.dip2px(5.0F);
    this.d = new afoo(7, 7, null);
    this.ax = ((ImageButton)findViewById(2131365704));
    ImageButton localImageButton;
    if (this.H != null)
    {
      this.ax.setVisibility(0);
      Editable localEditable = this.H.getText();
      localImageButton = this.ax;
      if (TextUtils.isEmpty(localEditable)) {
        break label257;
      }
    }
    label257:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      this.ax.setOnClickListener(this);
      this.c = ((EmotionPanelListView)findViewById(2131366382));
      this.c.setDivider(null);
      this.c.setEdgeEffectEnabled(false);
      this.c.setSelector(2130851773);
      int i = getColumnNum();
      this.jdField_a_of_type_Afqq = new afqq(null, getContext(), i, 1, this.d.type, this.g, null, 0);
      this.jdField_a_of_type_Afqq.Na(Dv());
      this.jdField_a_of_type_Afqq.widthPixels = this.cSL;
      this.jdField_a_of_type_Afqq.a = this.d;
      this.jdField_a_of_type_Afqq.a(this.c);
      this.c.setAdapter(this.jdField_a_of_type_Afqq);
      Nb(i);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.H != null) {
      this.H.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131365704) && (this.g != null)) {
      this.g.delete();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestory() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.H != null) {
      this.H.removeTextChangedListener(this.textWatcher);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("EmoticonUniversalPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    paramInt2 = this.cSL;
    if (paramInt1 != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onMeasure: oldWidth=" + paramInt2 + " newWidth=" + paramInt1);
      }
      afos.a().destory();
      afos.widthPixels = paramInt1;
      if (paramInt1 / localDisplayMetrics.widthPixels >= 0.66F) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.bZX = bool;
      this.cSL = paramInt1;
      if ((this.jdField_a_of_type_Afqq != null) && (this.ax != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new SystemAndEmojiUniversalPanel.2(this));
      }
      return;
    }
  }
  
  public void setDispatchKeyEventListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel$b = paramb;
  }
  
  public void setEmoticonCallback(afmf paramafmf)
  {
    this.g = paramafmf;
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.cao = paramBoolean;
  }
  
  public void setShowCommonUsedSystemEmoji(boolean paramBoolean)
  {
    this.can = paramBoolean;
  }
  
  public void setShowDeleteButton(EditText paramEditText)
  {
    this.H = paramEditText;
  }
  
  public static class a
  {
    private SystemAndEmojiUniversalPanel.b a;
    private boolean cao;
    private boolean cap;
    private afmf e;
    private Context mContext;
    private EditText mEditText;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public a a(afmf paramafmf)
    {
      this.e = paramafmf;
      return this;
    }
    
    public a a(EditText paramEditText)
    {
      this.mEditText = paramEditText;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.cao = paramBoolean;
      return this;
    }
    
    public SystemAndEmojiUniversalPanel a()
    {
      SystemAndEmojiUniversalPanel localSystemAndEmojiUniversalPanel = (SystemAndEmojiUniversalPanel)View.inflate(this.mContext, 2131559299, null);
      a(localSystemAndEmojiUniversalPanel);
      return localSystemAndEmojiUniversalPanel;
    }
    
    public void a(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel)
    {
      if (paramSystemAndEmojiUniversalPanel == null) {
        return;
      }
      paramSystemAndEmojiUniversalPanel.setEmoticonCallback(this.e);
      paramSystemAndEmojiUniversalPanel.setDispatchKeyEventListener(this.a);
      paramSystemAndEmojiUniversalPanel.setShowDeleteButton(this.mEditText);
      paramSystemAndEmojiUniversalPanel.setShowCommonUsedSystemEmoji(this.cap);
      paramSystemAndEmojiUniversalPanel.setFilterSysFaceBeyond255Enable(this.cao);
      paramSystemAndEmojiUniversalPanel.init();
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel
 * JD-Core Version:    0.7.0.1
 */