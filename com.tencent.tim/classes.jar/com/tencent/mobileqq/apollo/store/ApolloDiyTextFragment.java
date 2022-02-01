package com.tencent.mobileqq.apollo.store;

import abst;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoff;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import wja;

public class ApolloDiyTextFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  private TextView PT;
  private DisablePasteEditTextView a;
  boolean bFb = false;
  boolean bFc = false;
  private RelativeLayout el;
  private ImageView mBackView;
  private TextView titleView;
  private ImageView xy;
  
  public static String iF(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= aoff.oo.length) {
        break;
      }
      int j = paramString.indexOf(aoff.oo[i], 0);
      str = paramString;
      if (j != -1)
      {
        str = paramString;
        if (j + 2 <= paramString.length()) {
          str = paramString.replace(paramString.substring(j, j + 2), "");
        }
      }
      i += 1;
      paramString = str;
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a.bN(super.getActivity());
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.xy)
    {
      localObject = this.a.getText();
      if ((localObject != null) && (((Editable)localObject).length() > 0))
      {
        if (((Editable)localObject).length() > 12) {
          QQToast.a(super.getActivity(), acfp.m(2131702466), 0).show();
        }
      }
      else {
        VipUtils.a(null, "cmshow", "Apollo", "ConfirmClick", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("ret", 1);
      if (this.a.getText() != null) {}
      for (localObject = this.a.getText().toString();; localObject = "")
      {
        localIntent.putExtra("text", (String)localObject);
        super.getActivity().setResult(-1, localIntent);
        super.getActivity().finish();
        break;
      }
      if (paramView == this.mBackView)
      {
        localIntent = new Intent();
        localIntent.putExtra("ret", 0);
        if (this.a.getText() != null) {}
        for (localObject = this.a.getText().toString();; localObject = "")
        {
          localIntent.putExtra("text", (String)localObject);
          super.getActivity().setResult(0, localIntent);
          VipUtils.a(null, "cmshow", "Apollo", "CancelClick", 0, 0, new String[0]);
          super.getActivity().finish();
          break;
        }
      }
      if (paramView == this.PT)
      {
        this.a.setText("");
        this.a.setHint(" ");
        VipUtils.a(null, "cmshow", "Apollo", "ClearClick", 0, 0, new String[0]);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = super.getActivity();
    this.el = new RelativeLayout(paramLayoutInflater);
    this.el.setBackgroundColor(-1778384896);
    this.titleView = new TextView(paramLayoutInflater);
    this.titleView.setTextSize(14.0F);
    this.titleView.setTextColor(-1);
    paramViewGroup = new RelativeLayout.LayoutParams(-2, -2);
    paramViewGroup.addRule(14, -1);
    paramViewGroup.addRule(12, -1);
    paramViewGroup.bottomMargin = wja.dp2px(80.0F, getResources());
    this.el.addView(this.titleView, paramViewGroup);
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.bottomMargin = wja.dp2px(44.0F, getResources());
    this.el.addView(paramViewGroup, paramBundle);
    this.a = new DisablePasteEditTextView(paramLayoutInflater);
    this.a.setCursorVisible(true);
    this.a.setTextSize(24.0F);
    this.a.setTextColor(-1);
    this.a.setHintTextColor(-1);
    this.a.setHint(acfp.m(2131702470));
    this.a.setBackgroundColor(0);
    this.a.addTextChangedListener(this);
    this.a.setSingleLine(false);
    this.a.setSelection(0);
    float f = this.a.getPaint().measureText(acfp.m(2131702469));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13, -1);
    paramViewGroup.addView(this.a, paramBundle);
    this.a.setMaxWidth((int)(f + 1.0F));
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, wja.dp2px(1.0F, getResources())).addRule(10, -1);
    paramViewGroup.addView(paramBundle);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, wja.dp2px(1.0F, getResources())).addRule(12, -1);
    paramViewGroup.addView(paramBundle);
    this.mBackView = new ImageView(paramLayoutInflater);
    this.mBackView.setImageResource(2130838558);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(9);
    paramBundle.leftMargin = wja.dp2px(15.0F, getResources());
    this.mBackView.setOnClickListener(this);
    paramViewGroup.addView(this.mBackView, paramBundle);
    this.xy = new ImageView(paramLayoutInflater);
    this.xy.setOnClickListener(this);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(11);
    paramBundle.rightMargin = wja.dp2px(10.0F, getResources());
    paramViewGroup.addView(this.xy, paramBundle);
    this.PT = new TextView(paramLayoutInflater);
    this.PT.setText(acfp.m(2131702468));
    this.PT.setGravity(17);
    this.PT.setTextSize(16.0F);
    this.PT.setTextColor(-16777216);
    paramBundle = new RelativeLayout.LayoutParams(-2, -1);
    paramBundle.addRule(13);
    this.PT.setOnClickListener(this);
    paramViewGroup.addView(this.PT, paramBundle);
    paramBundle = new RelativeLayout.LayoutParams(-1, wja.dp2px(43.0F, getResources()));
    paramBundle.addRule(12, -1);
    this.el.addView(paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.getIntent().getStringExtra("extra_key_last_text");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.a.setGravity(17);
      this.a.setText(paramLayoutInflater);
      this.a.HZ(paramLayoutInflater.length());
      int i = 12 - paramLayoutInflater.length();
      this.titleView.setText(acfp.m(2131702467) + i + acfp.m(2131702465));
      if (i < 0) {
        this.titleView.setTextColor(-65536);
      }
      this.titleView.setTextColor(-1);
      this.xy.setImageResource(2130838560);
    }
    for (;;)
    {
      paramLayoutInflater = new AlphaAnimation(0.0F, 1.0F);
      paramLayoutInflater.setDuration(500L);
      paramLayoutInflater.setFillAfter(true);
      this.el.startAnimation(paramLayoutInflater);
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 1, 0, new String[0]);
      paramLayoutInflater = this.el;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.a.setGravity(3);
      this.titleView.setText("还可以输入12个字");
      this.titleView.setTextColor(-1);
      this.xy.setImageResource(2130838559);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.a.setHint(" ");
      str = paramCharSequence.toString();
      paramCharSequence = iF(str);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDiyTextActivity", 2, "onTextChanged:" + str + " newStr:" + paramCharSequence);
      }
      paramInt1 = paramCharSequence.length();
      paramInt2 = this.a.getSelectionEnd();
      if (paramInt1 > 50)
      {
        paramCharSequence = paramCharSequence.substring(0, 50);
        if (this.bFc) {
          break label414;
        }
        this.bFc = true;
        VipUtils.a(null, "cmshow", "Apollo", "reach50", 0, 0, new String[0]);
        paramInt1 = 50;
      }
    }
    for (;;)
    {
      this.titleView.setText(acfp.m(2131702464) + (12 - paramInt1) + acfp.m(2131702463));
      if (paramInt1 > 12)
      {
        this.titleView.setTextColor(-65536);
        if (!this.bFb)
        {
          this.bFb = true;
          VipUtils.a(null, "cmshow", "Apollo", "over12", 0, 0, new String[0]);
        }
        label226:
        if (paramInt2 < paramCharSequence.length()) {
          break label409;
        }
      }
      label280:
      label409:
      for (paramInt1 = paramCharSequence.length();; paramInt1 = paramInt2)
      {
        if (!str.equals(paramCharSequence))
        {
          this.a.removeTextChangedListener(this);
          this.a.setText(paramCharSequence);
          this.a.setSelection(paramInt1);
          this.a.addTextChangedListener(this);
        }
        if ((this.a.getText() != null) && (this.a.getText().length() > 0))
        {
          this.a.setGravity(17);
          if (this.xy != null) {
            this.xy.setImageResource(2130838560);
          }
        }
        do
        {
          return;
          if (paramInt1 < 50) {
            this.bFc = false;
          }
          break;
          this.bFb = false;
          this.titleView.setTextColor(-1);
          break label226;
          this.titleView.setText("还可以输入12个字");
          this.titleView.setTextColor(-1);
          break label280;
          this.a.setGravity(3);
        } while (this.xy == null);
        this.xy.setImageResource(2130838559);
        return;
      }
      label414:
      paramInt1 = 50;
    }
  }
  
  @TargetApi(11)
  static class DisablePasteEditTextView
    extends EditText
    implements ActionMode.Callback
  {
    public DisablePasteEditTextView(Context paramContext)
    {
      super();
      super.setLongClickable(false);
      super.setTextIsSelectable(false);
      super.setImeOptions(268435456);
      if (Build.VERSION.SDK_INT >= 11) {
        super.setCustomSelectionActionModeCallback(this);
      }
    }
    
    public void HZ(int paramInt)
    {
      try
      {
        super.setSelection(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDiyTextActivity", 1, localException.getMessage());
      }
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return false;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode) {}
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return false;
    }
    
    public boolean onTextContextMenuItem(int paramInt)
    {
      return true;
    }
  }
  
  public static class a
  {
    private int cru;
    private FrameLayout.LayoutParams d;
    private View qO;
    
    private a(Activity paramActivity)
    {
      this.qO = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
      this.qO.getViewTreeObserver().addOnGlobalLayoutListener(new abst(this));
      this.d = ((FrameLayout.LayoutParams)this.qO.getLayoutParams());
    }
    
    public static void bN(Activity paramActivity)
    {
      new a(paramActivity);
    }
    
    private void cEF()
    {
      int i = zR();
      int j;
      int k;
      if (i != this.cru)
      {
        j = this.qO.getRootView().getHeight();
        k = j - i;
        if (k <= j / 4) {
          break label58;
        }
      }
      label58:
      for (this.d.height = (j - k);; this.d.height = j)
      {
        this.qO.requestLayout();
        this.cru = i;
        return;
      }
    }
    
    private int zR()
    {
      Rect localRect = new Rect();
      this.qO.getWindowVisibleDisplayFrame(localRect);
      return localRect.bottom - localRect.top;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment
 * JD-Core Version:    0.7.0.1
 */