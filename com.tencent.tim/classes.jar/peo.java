import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.10;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.11;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.12;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.9;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public abstract class peo
  extends sdz
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private ImageButton S;
  private ImageButton T;
  public CommentEditText a;
  private peo.a jdField_a_of_type_Peo$a;
  private peo.b jdField_a_of_type_Peo$b;
  private sea jdField_a_of_type_Sea;
  private boolean axc;
  private boolean axd;
  private EmoticonMainPanel jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private SystemAndEmojiEmoticonPanel jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private int beV;
  private int beW = -1;
  private AlphaAnimation c;
  private Button cb;
  private LinearLayout eH;
  private Activity mActivity;
  private SharedPreferences.Editor mEditor;
  private InputMethodManager mImm;
  private boolean mIsInit;
  private Handler mMainHandler;
  private SharedPreferences mPreferences;
  protected View mRoot;
  private View nq;
  
  public peo(Activity paramActivity)
  {
    super(paramActivity, 2131755750);
    this.mActivity = paramActivity;
    this.mRoot = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
    beG();
    setCancelable(true);
    initView();
    setContentView(this.mRoot);
    dD(this.mRoot);
    initEvent();
    setOnDismissListener(this);
    beF();
  }
  
  private void beI()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams().height = this.beV;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.beV);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams().height = this.beV;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.beV);
    }
  }
  
  private void beJ()
  {
    this.jdField_a_of_type_Sea = new sea(this.mRoot);
    this.jdField_a_of_type_Sea.a(new pet(this));
    this.mRoot.getViewTreeObserver();
  }
  
  private void beK()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new peu(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new pev(this));
  }
  
  private void bkl()
  {
    per localper = new per(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299627);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.mRoot.findViewById(2131366310));
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localper);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYY = true;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.daq();
    }
    do
    {
      return;
      QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
    } while ((this.mActivity == null) || (this.eH == null));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this.mActivity, localper);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setBackgroundColor(-1);
    this.eH.addView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
  }
  
  private void bkn()
  {
    if (this.axc) {
      dt(this.nq);
    }
    this.axd = true;
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    }
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void dt(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void du(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  private void initEvent()
  {
    this.S.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.cb.setOnClickListener(this);
    beK();
  }
  
  private void initView()
  {
    this.eH = ((LinearLayout)this.mRoot.findViewById(2131364998));
    this.S = ((ImageButton)this.mRoot.findViewById(2131363856));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.mRoot.findViewById(2131379487));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new pep(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setEditableFactory(aofw.a);
    this.T = ((ImageButton)this.mRoot.findViewById(2131363897));
    this.cb = ((Button)this.mRoot.findViewById(2131363939));
    this.mPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.mEditor = this.mPreferences.edit();
    this.beV = this.mPreferences.getInt("GroupSoftKeyboardHeight", wja.dp2px(250.0F, getContext().getResources()));
    QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.beV);
    if (this.beV == 0)
    {
      this.beV = ankt.dip2px(250.0F);
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.beV);
    }
    bkl();
    this.nq = this.mRoot.findViewById(2131363561);
    this.nq.setOnClickListener(new peq(this));
    this.mImm = ((InputMethodManager)this.mActivity.getSystemService("input_method"));
    this.mIsInit = true;
    beI();
  }
  
  private void qD(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
    }
    du(this.nq);
    if (paramBoolean) {
      ds(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  public void a(peo.a parama)
  {
    this.jdField_a_of_type_Peo$a = parama;
  }
  
  public void a(peo.b paramb)
  {
    this.jdField_a_of_type_Peo$b = paramb;
  }
  
  @TargetApi(19)
  public void beF()
  {
    int i = 0;
    super.beF();
    Object localObject = getWindow();
    if (localObject == null) {}
    label102:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label102;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  protected void beG()
  {
    if ((getWindow() != null) && (getWindow().getAttributes() != null))
    {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setSoftInputMode(16);
    }
  }
  
  protected void bkm()
  {
    if (this.mRoot != null)
    {
      this.c = new AlphaAnimation(0.0F, 1.0F);
      this.c.setDuration(200L);
      this.c.setAnimationListener(new pes(this));
      this.mRoot.setAnimation(this.c);
      this.c.start();
    }
  }
  
  protected abstract void dD(View paramView);
  
  public void dismiss()
  {
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    qD(false);
    super.dismiss();
  }
  
  public void ds(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new QCircleBaseInputPopupWindow.9(this, paramView));
  }
  
  protected abstract int getLayoutId();
  
  public String getText()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    String str = "";
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof aofw))
    {
      localObject = (aofw)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      if (localObject == null) {
        break label133;
      }
      localObject = ((aofw)localObject).AE();
    }
    for (;;)
    {
      ((String)localObject).replaceAll(acfp.aE(2130968993), acfp.aE(2130968994)).replaceAll(acfp.aE(2130968992), "/MM");
      return awif.sh("").trim();
      localObject = str;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof aofr))
      {
        aofr localaofr = (aofr)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
        localObject = str;
        if (localaofr != null)
        {
          localObject = localaofr.AE();
          continue;
          label133:
          localObject = "";
        }
      }
    }
  }
  
  public void hideSoftInput(View paramView)
  {
    paramView.post(new QCircleBaseInputPopupWindow.10(this, paramView));
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
      bkn();
      this.T.setVisibility(0);
      this.S.setVisibility(8);
      continue;
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      qD(true);
      this.T.setVisibility(8);
      this.S.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_Peo$a != null)
      {
        this.jdField_a_of_type_Peo$a.biG();
        continue;
        QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
        qD(true);
        this.T.setVisibility(8);
        this.S.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Sea != null)
    {
      this.jdField_a_of_type_Sea.bya();
      this.jdField_a_of_type_Sea = null;
    }
    this.S.setVisibility(8);
    this.T.setVisibility(0);
    this.axc = false;
    if (this.jdField_a_of_type_Peo$b != null) {
      this.jdField_a_of_type_Peo$b.onDismiss();
    }
  }
  
  public void qG(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  public void setText(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(paramString.length());
  }
  
  public void show(boolean paramBoolean)
  {
    show();
    beJ();
    if (paramBoolean)
    {
      getMainHandler().post(new QCircleBaseInputPopupWindow.11(this));
      return;
    }
    getMainHandler().post(new QCircleBaseInputPopupWindow.12(this));
  }
  
  public static abstract interface a
  {
    public abstract void biG();
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     peo
 * JD-Core Version:    0.7.0.1
 */