import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public class qsi
  implements View.OnClickListener
{
  private long Ap;
  private ImageButton Z;
  private SystemEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
  private qsi.a jdField_a_of_type_Qsi$a;
  private FrameLayout aE;
  private boolean aFi;
  private boolean aFj;
  private boolean aFk;
  private boolean aFl;
  private XEditTextEx b;
  afmf e = new qsk(this);
  private Context mContext;
  private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
  private View mRootView;
  private View ob;
  
  public qsi(Context paramContext, View paramView, qsi.a parama)
  {
    this.mContext = paramContext;
    this.mRootView = paramView;
    this.jdField_a_of_type_Qsi$a = parama;
    initData();
    bqd();
  }
  
  private void bmz()
  {
    boolean bool;
    if (!this.aFk) {
      if (this.b.getText().length() == 0)
      {
        bool = true;
        this.b.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qsi$a != null) {
        this.jdField_a_of_type_Qsi$a.tm(bool);
      }
      this.aFk = false;
      this.aFj = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.ob.setVisibility(8);
      this.Z.setSelected(false);
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private void bqd()
  {
    ((PatchedButton)this.mRootView.findViewById(2131367817)).setOnClickListener(this);
    this.Z.setOnClickListener(this);
    this.mOnGlobalLayoutListener = new qsj(this);
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
  }
  
  private void bqe()
  {
    ram.d("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard up. mIsForceChange = %s.", Boolean.valueOf(this.aFl));
    if (this.aFj)
    {
      this.aFk = true;
      bmz();
    }
    if (!this.b.isFocused()) {
      this.b.requestFocus();
    }
    this.aFi = true;
    if (this.jdField_a_of_type_Qsi$a != null) {
      this.jdField_a_of_type_Qsi$a.tl(this.aFl);
    }
    this.aFl = false;
  }
  
  private void bqf()
  {
    ram.d("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard down. mIsForceChange = %s.", Boolean.valueOf(this.aFl));
    this.aFi = false;
    boolean bool;
    if (!this.aFk) {
      if (this.b.getText().length() == 0)
      {
        bool = true;
        this.b.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qsi$a != null) {
        this.jdField_a_of_type_Qsi$a.tm(bool);
      }
      this.aFk = false;
      this.aFl = false;
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void initData()
  {
    this.b = ((XEditTextEx)this.mRootView.findViewById(2131366528));
    this.aE = ((FrameLayout)this.mRootView.findViewById(2131366380));
    this.ob = this.mRootView.findViewById(2131365353);
    this.Z = ((ImageButton)this.mRootView.findViewById(2131366345));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.mContext, this.aE, this.b, this.e);
  }
  
  public boolean Ks()
  {
    return (this.aFi) || (this.aFj);
  }
  
  public boolean Kv()
  {
    return this.aFi;
  }
  
  public boolean Kw()
  {
    return this.aFk;
  }
  
  public void bmy()
  {
    if (this.aFi)
    {
      this.aFk = true;
      setKeyBoardState(false);
    }
    if (!this.b.isFocused()) {
      this.b.requestFocus();
    }
    if (this.jdField_a_of_type_Qsi$a != null) {
      this.jdField_a_of_type_Qsi$a.tl(this.aFl);
    }
    this.aFj = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.ob.setVisibility(0);
    this.Z.setSelected(true);
  }
  
  public void bqb()
  {
    if (this.aFi) {
      setKeyBoardState(false);
    }
    if (this.aFj) {
      bmz();
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
      if (System.currentTimeMillis() - this.Ap >= 500L)
      {
        this.Ap = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Qsi$a == null) || (!this.jdField_a_of_type_Qsi$a.Kt()))
        {
          this.aFk = true;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
          {
            bmz();
            setKeyBoardState(true);
          }
          else
          {
            setKeyBoardState(false);
            new Handler().postDelayed(new KeyboardAndEmojiManager.2(this), 200L);
            continue;
            if (this.jdField_a_of_type_Qsi$a != null) {
              this.jdField_a_of_type_Qsi$a.bqc();
            }
          }
        }
      }
    }
  }
  
  public void rW(String paramString)
  {
    ((PatchedButton)this.mRootView.findViewById(2131367817)).setText(paramString);
  }
  
  public void release()
  {
    this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    this.aFl = true;
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!paramBoolean) {
        break label81;
      }
      if (!this.b.isFocused()) {
        this.b.requestFocus();
      }
      localInputMethodManager.showSoftInput(this.b, 1);
    }
    for (;;)
    {
      ram.d("Q.qqstory.detail.KeyboardAndEmojiManager", "setKeyBoardState: %s." + paramBoolean);
      return;
      label81:
      localInputMethodManager.hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Kt();
    
    public abstract void bqc();
    
    public abstract void tl(boolean paramBoolean);
    
    public abstract void tm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsi
 * JD-Core Version:    0.7.0.1
 */