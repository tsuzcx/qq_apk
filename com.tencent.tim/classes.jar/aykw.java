import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.c;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.qq.im.capture.view.PressScaleTextView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.10;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.12;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.13;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.14;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener.2;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.a;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.util.List;
import mqq.os.MqqHandler;

public class aykw
  extends ReportDialog
  implements Handler.Callback, View.OnClickListener, XPanelContainer.c, EditTextPanel.a
{
  private float FO;
  private float FP;
  private boolean WI;
  public aykl a;
  public aykw.a a;
  public EditTextPreView a;
  private PressScaleTextView jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView;
  EditTextPanel jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel;
  public HorizontalSelectColorLayout a;
  public String aAz;
  public EditText ag;
  axug b;
  public FitSystemWindowsRelativeLayout b;
  public DynamicTextItem.TextMap b;
  public DynamicTextItem b;
  public int brh;
  public int bri = -1;
  public int brj = aytj.R(false);
  public int brl;
  private boolean bsY;
  public DynamicTextItem d;
  private boolean ddW;
  private boolean dzI;
  public boolean dzJ;
  public ViewTreeObserver.OnGlobalLayoutListener e;
  private InputFilter[] e;
  private int eKs = 580;
  private int eKt = axvb.TEXT_SIZE;
  private int eKu;
  public int eKv = XPanelContainer.aLe;
  public int eKw = -1;
  private int eKx;
  private InputFilter[] f = new InputFilter[0];
  private View.OnClickListener gH = new ayky(this);
  public XPanelContainer h;
  public View hF;
  private Runnable iS = new EditTextDialog.10(this);
  private Button ie;
  public int mColor;
  Context mContext;
  private int mIndex;
  public int mMode;
  public ViewGroup mRootView;
  public int mSize;
  public String mText = "";
  public RelativeLayout ok;
  private QQToast toast;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  public aykw(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131755374);
    this.jdField_a_of_type_Aykl = new aykl();
    this.jdField_e_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new aykw.d(20) };
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.eKx = ((Activity)this.mContext).getIntent().getIntExtra("capture_operation_in", -1);
    }
    this.dzJ = paramBoolean;
  }
  
  private void afm(int paramInt)
  {
    this.eKu = paramInt;
    switch (this.eKu)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem == null);
          this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.eOU();
        } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
        return;
      } while (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem == null);
      paramInt = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw();
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.eOT();
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.cz(paramInt, true);
    } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
  }
  
  private void bub()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    int i;
    boolean bool;
    if (this.dzI)
    {
      localLayoutParams.height = ayom.getWindowScreenHeight(getContext());
      if (ayxa.aRq())
      {
        int[] arrayOfInt = ayxa.getRealDisplay(this.mContext);
        if ((arrayOfInt.length == 2) && (arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
        {
          localLayoutParams.height = arrayOfInt[1];
          if ((!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) || (!DisplayUtil.checkNavigationBarShow(this.mContext))) {
            break label250;
          }
          i = 1;
          if ((i == 0) && (!DisplayUtil.isFlymeOS7NavBarShow())) {
            break label255;
          }
          bool = true;
          label117:
          if (QLog.isColorLevel()) {
            QLog.d("EditTextDialog", 2, new Object[] { "isNavigationBarExist, ", Boolean.valueOf(bool) });
          }
          if (!bool) {}
        }
      }
    }
    for (localLayoutParams.height -= DisplayUtil.getNavigationBarHeight(this.mContext);; localLayoutParams.height = -1)
    {
      localLayoutParams.flags |= 0x20;
      localLayoutParams.gravity = 80;
      ((Window)localObject).setAttributes(localLayoutParams);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        localObject = new SystemBarCompact(this, true, this.mContext.getResources().getColor(17170445));
        ((SystemBarCompact)localObject).setStatusBarDrawable(null);
        ((SystemBarCompact)localObject).init();
      }
      setCanceledOnTouchOutside(false);
      return;
      label250:
      i = 0;
      break;
      label255:
      bool = false;
      break label117;
    }
  }
  
  private void eSr()
  {
    getWindow().getDecorView().setSystemUiVisibility(4);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new aylg(this));
  }
  
  private void eSs()
  {
    if ((this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem == null) || (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null)) {}
    do
    {
      return;
      String str2 = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getText(this.mIndex);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
      if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem);
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.mIndex, str1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditTextDialog", 2, "text size changednow text size:" + this.eKt);
  }
  
  private void initView()
  {
    this.mRootView = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131559260, null));
    this.jdField_e_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aykw.c(null);
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new aykw.b(null));
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.mRootView.findViewById(2131377568));
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setOnTouchListener(new aykx(this));
    this.h = ((XPanelContainer)this.mRootView.findViewById(2131377546));
    this.ag = ((EditText)this.mRootView.findViewById(2131379497));
    this.ag.setHighlightColor(Color.parseColor("#cceae8"));
    this.hF = this.mRootView.findViewById(2131379488);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel = ((EditTextPanel)this.mRootView.findViewById(2131366285).findViewById(2131372835));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setPanelListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.j(this.ag);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setOpIn(this.eKx);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setEditPhoto(this.bsY);
    this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView = ((PressScaleTextView)this.mRootView.findViewById(2131379461));
    this.ie = ((Button)this.mRootView.findViewById(2131379462));
    if (this.ddW)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView.setVisibility(0);
      this.ie.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView.setOnClickListener(new aykz(this));
      this.ie.setOnClickListener(new ayla(this));
    }
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView = ((EditTextPreView)this.mRootView.findViewById(2131379500));
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setOnClickListener(new aylb(this));
    this.ag.setFocusableInTouchMode(true);
    this.ag.setFocusable(true);
    this.ag.setOnFocusChangeListener(new aylc(this));
    this.h.ja(this.ag);
    this.ag.addTextChangedListener(new ayld(this));
    this.ag.setOnTouchListener(new ayle(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)this.mRootView.findViewById(2131372322));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new aytj(), false, 0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setEditDialogMode(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new aylf(this));
  }
  
  public int RW()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getWidth() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getLeft();
    }
    ram.d("EditTextDialog", "getPreViewCenterX:" + i);
    return i;
  }
  
  public int RX()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getHeight() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getTop();
    }
    ram.d("EditTextDialog", "getPreViewCenterY()=" + i);
    return i;
  }
  
  public void Zy(boolean paramBoolean)
  {
    this.ddW = paramBoolean;
  }
  
  public void Zz(boolean paramBoolean)
  {
    this.dzI = paramBoolean;
  }
  
  public View a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onCreatePanel id = " + paramInt);
    }
    XPanelContainer.aLe = (int)(50.0F * this.mContext.getResources().getDisplayMetrics().density);
    if (this.ok != null) {
      XPanelContainer.aLe += this.ok.getHeight();
    }
    return null;
  }
  
  public void a(axug paramaxug)
  {
    this.jdField_b_of_type_Axug = paramaxug;
  }
  
  public void a(aykw.a parama)
  {
    this.jdField_a_of_type_Aykw$a = parama;
  }
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelItemClick position = " + paramInt);
    }
    Object localObject;
    if ((this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.ag != null) && (paramDynamicTextConfigBean != null))
    {
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw();
      localObject = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.eN();
      if (paramDynamicTextConfigBean.text_id != this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getType()) {
        break label357;
      }
      paramDynamicTextConfigBean = this.jdField_b_of_type_Axug.a(paramDynamicTextConfigBean.text_id, (List)localObject);
      paramDynamicTextConfigBean.setTextSize(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getTextSize());
      this.eKt = paramDynamicTextConfigBean.getTextSize();
      paramDynamicTextConfigBean.o = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.o;
      paramDynamicTextConfigBean.aeK(0);
      paramDynamicTextConfigBean.setText(0, paramDynamicTextConfigBean.getText(0));
      if (!(paramDynamicTextConfigBean instanceof axvb)) {
        break label391;
      }
      ((axvb)paramDynamicTextConfigBean).setTextColor(this.brj);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
      label165:
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.eOT();
      if (!this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.equals(paramDynamicTextConfigBean)) {
        this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextConfigBean;
      }
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView, true, 3000, 500, new EditTextDialog.14(this));
      this.ag.setFilters(this.f);
      this.ag.setText(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Ii());
      if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getType() != 0)
      {
        if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a() != null) {
          break label403;
        }
        this.ag.setFilters(this.jdField_e_of_type_ArrayOfAndroidTextInputFilter);
      }
      label282:
      this.ag.setSelection(this.ag.length());
      if (!this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Ii().equals(axug.aa(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getType(), this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw()))) {
        break label427;
      }
      this.ag.setSelectAllOnFocus(true);
      if (this.ag.hasFocus()) {
        this.ag.selectAll();
      }
    }
    for (;;)
    {
      this.eKw = paramInt;
      return;
      label357:
      localObject = axug.a(axug.at(paramDynamicTextConfigBean.text_id), this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.uiHandler.post(new EditTextDialog.13(this));
      break;
      label391:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
      break label165;
      label403:
      this.ag.setFilters(new InputFilter[] { this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a() });
      break label282;
      label427:
      this.ag.setOnClickListener(null);
      this.ag.setSelectAllOnFocus(false);
      this.ag.requestFocus();
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      this.mIndex = paramInt;
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.d = paramDynamicTextItem;
    } while (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem == null);
    this.eKt = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getTextSize();
    this.mSize = this.eKt;
    this.mText = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getText(this.mIndex);
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "normalTextSize" + this.eKt);
    }
    String str2 = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getText(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(paramInt, str1);
    }
    this.ag.setFilters(this.f);
    this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.setText(paramInt, str1);
    this.aAz = str1;
    ram.d("EditTextDialog", "setTextInfo:" + paramDynamicTextItem + " index:" + paramInt + " text:" + str1);
    this.jdField_a_of_type_Aykl.text = str1;
    this.ag.setText(this.jdField_a_of_type_Aykl.text);
    if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getType() != 0)
    {
      if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a() == null) {
        this.ag.setFilters(this.jdField_e_of_type_ArrayOfAndroidTextInputFilter);
      }
    }
    else
    {
      this.ag.setSelection(this.ag.length());
      if (!this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Ii().equals(axug.aa(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getType(), this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw()))) {
        break label483;
      }
      this.ag.setOnClickListener(this.gH);
      this.ag.setSelectAllOnFocus(true);
      if (this.ag.hasFocus()) {
        this.ag.selectAll();
      }
    }
    for (;;)
    {
      paramInt = this.jdField_b_of_type_Axug.a(paramDynamicTextItem);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel != null) {
        this.eKw = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.mc(paramInt);
      }
      if (this.eKu == 0) {
        afm(0);
      }
      if (!(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem instanceof axvb)) {
        break label494;
      }
      paramDynamicTextItem = (axvb)this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.FO = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getHeight();
      this.FP = paramDynamicTextItem.getLineCount();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
      this.mColor = paramDynamicTextItem.getTextColor();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(this.mColor);
      return;
      this.ag.setFilters(new InputFilter[] { this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a() });
      break;
      label483:
      this.ag.setOnClickListener(null);
    }
    label494:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
  }
  
  public void bo() {}
  
  protected int getMarginTop()
  {
    return this.brl;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      o(paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    this.uiHandler.obtainMessage(0, paramInt1, paramInt2).sendToTarget();
  }
  
  public void nN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "dismiss isCancel:" + paramBoolean);
    }
    Object localObject = (InputMethodManager)getContext().getSystemService("input_method");
    if (this.ag != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
    }
    this.jdField_a_of_type_Aykw$a.ZA(false);
    this.jdField_a_of_type_Aykw$a.lA(RW(), RX());
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(null);
    localObject = this.jdField_a_of_type_Aykw$a;
    DynamicTextItem localDynamicTextItem = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((aykw.a)localObject).a(localDynamicTextItem, paramBoolean, this.mMode, this.WI);
      this.WI = false;
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
      getWindow().getDecorView().removeCallbacks(this.iS);
      super.dismiss();
      return;
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "doPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    if (paramInt2 == 34)
    {
      if ((this.eKw == -1) && (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null))
      {
        int i = this.jdField_b_of_type_Axug.a(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem);
        this.eKw = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.mc(i);
      }
      if (this.eKw != -1) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.ii(-1, this.eKw);
      }
      afm(1);
    }
    for (;;)
    {
      this.uiHandler.post(new EditTextDialog.12(this, paramInt1, paramInt2));
      return;
      if (paramInt2 == 1) {
        afm(0);
      } else if (paramInt2 == 0) {
        afm(1);
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.mIsCanceled = true;
    }
    nN(true);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onClick getCurrentPanel = " + this.h.vm());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    XPanelContainer.aLe = this.eKv;
    if (this.jdField_a_of_type_Aykw$a == null) {
      return;
    }
    Object localObject2 = this.ag.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      localObject2 = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (!this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.getText(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw()).equals(localObject1)) {
        this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.setText(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw(), (String)localObject1);
      }
      if ((!((DynamicTextItem.TextMap)localObject2).equals(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap)) && (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.aPQ())) {
        this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.YZ(false);
      }
    }
    this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    ((Activity)this.mContext).dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.dzJ) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      getWindow().getDecorView().setSystemUiVisibility(4);
    }
  }
  
  public boolean r(int paramInt)
  {
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    this.brh = wja.dp2px(100.0F, getContext().getResources());
    bub();
    initView();
    if ((!this.dzJ) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      eSr();
    }
    super.setContentView(this.mRootView);
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    this.bsY = paramBoolean;
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (this.eKu == 0) {
        this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.cz(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem.Rw(), true);
      }
      if (!(this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem instanceof axvb)) {
        break label92;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
    }
    for (;;)
    {
      this.WI = false;
      this.h.abp(1);
      this.h.setOnPanelChangeListener(this);
      return;
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
      break;
      label92:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
    }
  }
  
  public int tq()
  {
    int i = this.ag.getTop();
    int j = getMarginTop();
    TextPaint localTextPaint = this.ag.getPaint();
    return (int)(i + j + this.ag.getBaseline() + localTextPaint.ascent());
  }
  
  public void xn(int paramInt)
  {
    this.brl = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void ZA(boolean paramBoolean);
    
    public abstract void ZB(boolean paramBoolean);
    
    public abstract void a(DynamicTextItem paramDynamicTextItem, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
    
    public abstract void eSt();
    
    public abstract void lA(int paramInt1, int paramInt2);
    
    public abstract void n(int paramInt1, int paramInt2);
    
    public abstract void xo(int paramInt);
  }
  
  public class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private b() {}
    
    public void onGlobalLayout()
    {
      int i = aykw.this.hF.getBottom();
      if (aykw.this.bri < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditTextDialog", 2, "onGlobalLayout first bottom:" + i);
        }
        aykw.this.bri = i;
        aykw.this.uiHandler.post(new EditTextDialog.InitialLayoutListener.1(this));
      }
      while (aykw.this.bri - i <= aykw.this.brh) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EditTextDialog", 2, "onGlobalLayout second bottom:" + i);
      }
      aykw.this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      aykw.this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(aykw.this.e);
      aykw.this.bri = i;
      aykw.this.mRootView.requestLayout();
      aykw.this.uiHandler.post(new EditTextDialog.InitialLayoutListener.2(this));
    }
  }
  
  public class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private c() {}
    
    public void onGlobalLayout()
    {
      int i = aykw.this.hF.getBottom();
      if (QLog.isColorLevel()) {
        QLog.i("EditTextDialog", 2, "onGlobalLayout third bottom:" + i + " last:" + aykw.this.bri);
      }
      if (aykw.this.a != null)
      {
        int[] arrayOfInt = new int[2];
        aykw.this.a.getLocationOnScreen(arrayOfInt);
        int j = arrayOfInt[1];
        int k = j - wja.dp2px(62.0F, BaseApplicationImpl.getContext().getResources());
        if (k < aykw.b(aykw.this)) {
          aykw.b(aykw.this, k);
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditTextDialog", 2, "max height" + k + "preViewTextMaxHeight" + aykw.b(aykw.this) + "y" + j);
        }
      }
      if (i - aykw.this.bri > aykw.this.brh)
      {
        aykw.this.nN(false);
        if (aykw.this.b != null) {
          aykw.this.b.mIsCanceled = false;
        }
        return;
      }
      aykw.this.uiHandler.post(new EditTextDialog.LayoutChangeListener.1(this));
    }
  }
  
  public static class d
    implements InputFilter
  {
    protected int max;
    private QQToast toast;
    
    public d(int paramInt)
    {
      this.max = paramInt;
    }
    
    public int d(CharSequence paramCharSequence)
    {
      int j = 0;
      int m = paramCharSequence.length();
      int i = 0;
      while (i < m)
      {
        int n = paramCharSequence.charAt(i);
        int k;
        if (n != 10)
        {
          k = j;
          if (n != 13) {}
        }
        else
        {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      return j;
    }
    
    protected void eSu()
    {
      if (this.toast == null) {
        this.toast = QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131705474), 0);
      }
      if (!this.toast.isShowing()) {
        this.toast.show();
      }
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      paramInt3 = this.max - (paramSpanned.length() - (paramInt4 - paramInt3));
      paramInt4 = paramInt2 - paramInt1 - d(paramCharSequence.subSequence(paramInt1, paramInt2));
      if (paramInt3 > 0)
      {
        paramInt2 = paramInt3;
        if (paramInt3 >= paramInt4) {}
      }
      else
      {
        paramInt2 = paramInt3 + d(paramSpanned);
      }
      if (((paramInt2 <= 0) || (paramInt2 < paramInt4)) && (!TextUtils.equals("", paramCharSequence))) {
        eSu();
      }
      if (paramInt2 <= 0) {
        return "";
      }
      if (paramInt2 >= paramInt4) {
        return null;
      }
      paramInt3 = paramInt2 + paramInt1;
      paramInt2 = paramInt3;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
      {
        paramInt3 -= 1;
        paramInt2 = paramInt3;
        if (paramInt3 == paramInt1) {
          return "";
        }
      }
      return paramCharSequence.subSequence(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykw
 * JD-Core Version:    0.7.0.1
 */