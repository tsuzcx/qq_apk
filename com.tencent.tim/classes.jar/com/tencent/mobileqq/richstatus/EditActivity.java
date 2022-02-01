package com.tencent.mobileqq.richstatus;

import acfp;
import amev;
import amfb;
import amfc;
import amfd;
import amfe;
import amff;
import amhj;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqqs;
import arev;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;

public class EditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.e
{
  public static boolean cCp;
  public static int screenHeight;
  public static int screenWidth;
  private View Gy;
  View Gz;
  private int MAX_COUNT = 47;
  TextView Yd;
  private amff jdField_a_of_type_Amff = new amfb(this);
  private RichStatusEditText.b jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$b = new amfe(this);
  private RichStatusEditText jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
  private int aLx;
  public long aiB;
  long aiC = 0L;
  private Intent am;
  private arev b;
  private RichStatus c;
  private boolean cCq = true;
  private amhj d;
  protected View.OnClickListener fI = new amfd(this);
  boolean isResume = false;
  private LinearLayout ki;
  Drawable mLoadingDrawable;
  private TextWatcher mTextWatcher = new amfc(this);
  
  private void OZ(boolean paramBoolean)
  {
    if (this.c.actionId == 0) {
      if (this.b != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.b, true, true);
      }
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = a(false, paramBoolean);
        localObject2 = a(true, paramBoolean);
      } while ((localObject1 == null) || (localObject2 == null));
      localObject1 = new arev((Drawable)localObject1, (Drawable)localObject2);
      if (this.aLx != 1) {
        ((arev)localObject1).setEnable(false);
      }
      if ((this.b != null) && (this.b.getDrawable() != null)) {
        ((arev)localObject1).getDrawable().setState(this.b.getDrawable().getState());
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getEditableText();
    } while (localObject2 == null);
    if (((ImageSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), arev.class)).length > 0) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.b, (arev)localObject1);
    }
    for (;;)
    {
      this.b = ((arev)localObject1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().insert(0, "[S]");
      int i = "[S]".length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSpan((ImageSpan)localObject1, 0, i);
    }
  }
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    if (QLog.isColorLevel()) {
      QLog.d("EditActivity", 2, "tv.getWidth() = " + paramView.getWidth() + ",tv.getHeight()" + paramView.getHeight());
    }
    try
    {
      Object localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
      ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramView.draw((Canvas)localObject);
      paramView.setDrawingCacheEnabled(true);
      localObject = paramView.getDrawingCache();
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("EditActivity", 2, "cacheBm is null");
          return null;
        }
      }
      else
      {
        localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        paramView.destroyDrawingCache();
        paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
        paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        return paramView;
      }
    }
    catch (OutOfMemoryError paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditActivity", 2, paramView.getMessage());
      }
    }
    return null;
  }
  
  private Drawable a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(58);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131559466, null);
    localView.setPadding(0, 0, 0, 0);
    ImageView localImageView = (ImageView)localView.findViewById(2131368932);
    TextView localTextView = (TextView)localView.findViewById(2131368933);
    Object localObject2 = this.c.actionText;
    Object localObject1 = localObject2;
    if (this.c.dataText != null) {
      localObject1 = (String)localObject2 + this.c.dataText;
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 10) {
      localObject2 = ((String)localObject1).substring(0, 9) + "...";
    }
    localTextView.setText((CharSequence)localObject2);
    if (paramBoolean2) {
      localTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    }
    for (;;)
    {
      localImageView.setImageBitmap(this.d.i(this.c.actionId, 200));
      localView.setBackgroundResource(2130850442);
      return a(localView);
      if ((localSignatureManager.b != null) && (!TextUtils.isEmpty(localSignatureManager.b.fontColor))) {
        localTextView.setTextColor(Color.parseColor(localSignatureManager.b.fontColor));
      }
    }
  }
  
  private void dNa()
  {
    Object localObject = (SignatureManager)this.app.getManager(58);
    if (!this.cCq) {
      return;
    }
    if (this.b != null) {}
    for (int i = Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.b), 0);; i = 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().length();
      if ((this.c == null) || ((j == 0) && (this.aLx == 1)))
      {
        this.c = new RichStatus(null);
        this.c.plainText = new ArrayList();
        while (this.c.plainText.size() < 2) {
          this.c.plainText.add(null);
        }
      }
      if ((((SignatureManager)localObject).b == null) || (((SignatureManager)localObject).b.a == null))
      {
        if (this.aLx != 1) {
          break label291;
        }
        this.c.plainText.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i, j).toString().trim());
      }
      for (;;)
      {
        this.c.plainText.set(1, null);
        j = this.c.countLength();
        i = j;
        if (this.c != null)
        {
          i = j;
          if (this.c.actionText != null)
          {
            i = j;
            if (this.c.actionId == 0) {
              i = j - 7;
            }
          }
        }
        localObject = Integer.toString(this.MAX_COUNT - i);
        if (i <= this.MAX_COUNT) {
          break;
        }
        this.Yd.setTextColor(-65536);
        this.Yd.setText((CharSequence)localObject);
        return;
        label291:
        this.c.plainText.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i, j).toString());
      }
      this.Yd.setTextColor(Color.parseColor("#777777"));
      this.Yd.setText((CharSequence)localObject);
      return;
    }
  }
  
  void IM()
  {
    new Handler().postDelayed(new EditActivity.5(this), 500L);
  }
  
  public void dNb()
  {
    if (this.aLx == 1)
    {
      if (this.c.countLength() > this.MAX_COUNT) {
        toast(2131718855);
      }
    }
    else {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_new_xuan_yan", this.c.encode());
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    RichStatus localRichStatus;
    if ((paramInt2 == -1) && (paramInt1 == 17))
    {
      if (this.am != null) {
        break label149;
      }
      this.am = paramIntent;
      this.c.actionId = ((int)this.am.getLongExtra("k_action_id", 0L));
      this.c.actionText = this.am.getStringExtra("k_action_text");
      if (TextUtils.isEmpty(this.c.actionText))
      {
        localObject = this.d.a(this.c.actionId);
        localRichStatus = this.c;
        if (localObject == null) {
          break label161;
        }
      }
    }
    label149:
    label161:
    for (Object localObject = ((amev)localObject).name;; localObject = " ")
    {
      localRichStatus.actionText = ((String)localObject);
      this.c.dataId = ((int)paramIntent.getLongExtra("k_data_id", 0L));
      this.c.dataText = paramIntent.getStringExtra("k_data_text");
      OZ(false);
      return;
      this.am.putExtras(paramIntent);
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.aLx = getIntent().getIntExtra("param_entry", 0);
    int i = getIntent().getIntExtra("max_word_count", -1);
    if (i != -1) {
      this.MAX_COUNT = i;
    }
    if (this.aLx == 1) {
      super.setContentView(2131563108);
    }
    for (;;)
    {
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      screenHeight = paramBundle.heightPixels;
      screenWidth = paramBundle.widthPixels;
      this.d = ((amhj)this.app.getManager(15));
      if (this.d != null) {
        break;
      }
      toast(2131717096);
      super.finish();
      return false;
      super.setContentViewNoTitle(2131563108);
    }
    if (this.d.avO())
    {
      toast(2131718859);
      super.finish();
      return false;
    }
    this.mLoadingDrawable = new ColorDrawable(Color.parseColor("#dedede"));
    this.d.addListener(this.jdField_a_of_type_Amff);
    this.ki = ((LinearLayout)super.findViewById(2131369301));
    this.Gz = super.findViewById(2131369296);
    if (this.aLx == 1)
    {
      LayoutInflater.from(this).inflate(2131563109, this.ki, true);
      setTitle(acfp.m(2131705393));
      this.leftView.setText(2131690700);
      this.Gz.setVisibility(4);
      this.Yd = ((TextView)super.findViewById(2131365473));
      this.Yd.setTextColor(getResources().getColor(2131167385));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)super.findViewById(2131369292));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint(acfp.m(2131705390));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$b);
      paramBundle = getIntent().getByteArrayExtra("param_old_xuan_yan");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        this.c = RichStatus.parseStatus(paramBundle);
        this.c.locationText = "";
        paramBundle = this.c.plainText;
        if (paramBundle != null) {
          break label570;
        }
        paramBundle = new ArrayList();
        this.c.plainText = paramBundle;
      }
    }
    label570:
    for (;;)
    {
      if (paramBundle.size() < 2)
      {
        paramBundle.add(null);
        continue;
        this.c = new RichStatus(null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
      OZ(false);
      if (paramBundle.get(0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(0));
      }
      if (paramBundle.get(1) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(1));
      }
      dNa();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.mTextWatcher);
      this.Gy = super.findViewById(2131370854);
      this.Gy.setVisibility(8);
      this.leftView.setOnClickListener(this.fI);
      ((RelativeLayout)super.findViewById(2131363279)).setVisibility(8);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    
    if (this.b != null) {
      this.b.a(null);
    }
    if (this.d != null) {
      this.d.removeListener(this.jdField_a_of_type_Amff);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.removeTextChangedListener(this.mTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(null);
    }
    gR();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    this.isResume = false;
    gR();
    super.doOnPause();
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.cCq = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.cCq = true;
  }
  
  public void doOnResume()
  {
    this.isResume = true;
    if (this.aLx == 1) {
      IM();
    }
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.c != null) {
      paramBundle.putByteArray("param_rich_status", this.c.encode());
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void doOnStart()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(58);
    if ((localSignatureManager.b != null) && (localSignatureManager.b.a == null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    }
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
    }
    super.doOnStop();
  }
  
  void gR()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public boolean isWrapContent()
  {
    return this.aLx == 1;
  }
  
  public boolean onBackEvent()
  {
    this.aiB = System.currentTimeMillis();
    if (this.aLx == 1)
    {
      if (this.c.countLength() > this.MAX_COUNT)
      {
        toast(2131718855);
        return true;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.c.encode());
      setResult(-1, localIntent);
      super.finish();
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    paramView.getId();
    if (paramView.getId() != 2131369292) {
      gR();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  protected void toast(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).show(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity
 * JD-Core Version:    0.7.0.1
 */