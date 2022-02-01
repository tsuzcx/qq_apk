import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.10;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.8;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ohe
  extends sdz
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private ImageButton S;
  private ImageButton T;
  private ImageButton U;
  private EditText jdField_V_of_type_AndroidWidgetEditText;
  private ImageButton jdField_V_of_type_AndroidWidgetImageButton;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private EmoView jdField_a_of_type_ComTencentBizSubscribeCommentEmoView;
  private ohe.a jdField_a_of_type_Ohe$a;
  private sch jdField_a_of_type_Sch;
  private sea jdField_a_of_type_Sea;
  private boolean axc;
  private boolean axd;
  private int beV;
  private int beW = -1;
  private int beX = 140;
  private Button cb;
  private LinearLayout ew;
  private Activity mActivity;
  private SharedPreferences.Editor mEditor;
  private InputMethodManager mImm;
  private boolean mIsInit;
  private Handler mMainHandler;
  private SharedPreferences mPreferences;
  private View mRoot;
  private View nq;
  
  public ohe(Activity paramActivity)
  {
    super(paramActivity, 2131755750);
    this.mActivity = paramActivity;
    this.mRoot = LayoutInflater.from(getContext()).inflate(2131560194, null);
    beG();
    setCancelable(true);
    setContentView(this.mRoot);
    initView();
    initEvent();
    setOnDismissListener(this);
    beF();
  }
  
  private void beG()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(16);
  }
  
  private void beH()
  {
    String str = ohy.a().lt();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(str);
    }
  }
  
  private void beI()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getLayoutParams().height = this.beV;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.invalidate();
    ooz.d("CommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.beV);
  }
  
  private void beJ()
  {
    this.jdField_a_of_type_Sea = new sea(this.mRoot);
    this.jdField_a_of_type_Sea.a(new ohh(this));
    this.mRoot.getViewTreeObserver();
  }
  
  private void beK()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnFocusChangeListener(new ohi(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new ohj(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new ohk(this));
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
    this.ew = ((LinearLayout)this.mRoot.findViewById(2131365467));
    this.S = ((ImageButton)this.mRoot.findViewById(2131363856));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.mRoot.findViewById(2131379487));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new ohf(this));
    this.T = ((ImageButton)this.mRoot.findViewById(2131363897));
    this.U = ((ImageButton)this.mRoot.findViewById(2131363888));
    this.U.setOnClickListener(this);
    this.jdField_V_of_type_AndroidWidgetImageButton = ((ImageButton)this.mRoot.findViewById(2131363869));
    this.jdField_V_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.cb = ((Button)this.mRoot.findViewById(2131363939));
    this.mPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.mEditor = this.mPreferences.edit();
    this.beV = this.mPreferences.getInt("GroupSoftKeyboardHeight", wja.dp2px(250.0F, getContext().getResources()));
    ooz.d("CommentInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.beV);
    if (this.beV == 0)
    {
      this.beV = ankt.dip2px(250.0F);
      ooz.d("CommentInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.beV);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView = ((EmoView)this.mRoot.findViewById(2131366310));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.a(this.mActivity, getContext(), this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText, null);
    this.nq = this.mRoot.findViewById(2131363561);
    this.nq.setOnClickListener(new ohg(this));
    this.mImm = ((InputMethodManager)this.mActivity.getSystemService("input_method"));
    this.mIsInit = true;
    beI();
    beH();
  }
  
  private void qD(boolean paramBoolean)
  {
    this.axd = false;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(8);
    }
    du(this.nq);
    if (paramBoolean)
    {
      ds(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void qE(boolean paramBoolean)
  {
    if (this.axc) {
      dt(this.nq);
    }
    this.axd = true;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(0);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    if (this.jdField_V_of_type_AndroidWidgetEditText == null)
    {
      this.jdField_V_of_type_AndroidWidgetEditText = new EditText(this.ew.getContext());
      this.jdField_V_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    }
    if (this.jdField_V_of_type_AndroidWidgetEditText.getParent() == null) {
      this.ew.addView(this.jdField_V_of_type_AndroidWidgetEditText, 0, new LinearLayout.LayoutParams(1, 1));
    }
  }
  
  public void a(ohe.a parama)
  {
    this.jdField_a_of_type_Ohe$a = parama;
  }
  
  public void a(sch paramsch)
  {
    this.jdField_a_of_type_Sch = paramsch;
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
  
  public void dismiss()
  {
    hideSoftInput(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    qD(false);
    super.dismiss();
  }
  
  public void ds(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new WsCommentInputPopupWindow.8(this, paramView));
  }
  
  public String getText()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString().trim();
  }
  
  public void hideSoftInput(View paramView)
  {
    if (paramView != null) {
      this.mImm.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    ooz.d("CommentInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.beX) {
        QQToast.a(getContext(), acfp.m(2131704193) + this.beX + acfp.m(2131704194), 0).show();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e166[/em]");
      continue;
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.beX) {
        QQToast.a(getContext(), acfp.m(2131704193) + this.beX + acfp.m(2131704194), 0).show();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e163[/em]");
      continue;
      ooz.d("CommentInputPopupWindow", 1, "btn_emotion");
      qE(false);
      this.T.setVisibility(0);
      this.U.setVisibility(0);
      this.jdField_V_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.S.setVisibility(8);
      continue;
      ooz.d("CommentInputPopupWindow", 1, "text_input");
      qD(true);
      this.T.setVisibility(8);
      this.U.setVisibility(8);
      this.jdField_V_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.S.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_Sch != null)
      {
        this.jdField_a_of_type_Sch.beU();
        continue;
        ooz.d("CommentInputPopupWindow", 1, "btn_keyboard");
        qD(true);
        this.T.setVisibility(8);
        this.S.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Sea.bya();
    this.jdField_a_of_type_Sea = null;
    this.S.setVisibility(8);
    this.T.setVisibility(0);
    this.axc = false;
    qD(false);
    if (this.jdField_a_of_type_Ohe$a != null) {
      this.jdField_a_of_type_Ohe$a.onDismiss();
    }
    if ((this.jdField_V_of_type_AndroidWidgetEditText != null) && (this.jdField_V_of_type_AndroidWidgetEditText.getParent() != null))
    {
      this.ew.removeView(this.jdField_V_of_type_AndroidWidgetEditText);
      this.jdField_V_of_type_AndroidWidgetEditText = null;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
  }
  
  public void setText(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
  }
  
  public void show(int paramInt)
  {
    show();
    beJ();
    if (paramInt > 0)
    {
      getMainHandler().post(new WsCommentInputPopupWindow.9(this, paramInt));
      return;
    }
    getMainHandler().post(new WsCommentInputPopupWindow.10(this));
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohe
 * JD-Core Version:    0.7.0.1
 */