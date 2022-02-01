import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;

public class vab
  extends zwh
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private uzh jdField_a_of_type_Uzh;
  private vai jdField_a_of_type_Vai;
  private zuf jdField_a_of_type_Zuf;
  private zwi jdField_a_of_type_Zwi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 140;
  private ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  private ImageButton d;
  
  public vab(Activity paramActivity)
  {
    super(paramActivity, 2131755410);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560045, null);
    b();
    setCancelable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    c();
    d();
    setOnDismissListener(this);
    I_();
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private uzh a()
  {
    if (this.jdField_a_of_type_Uzh == null) {
      this.jdField_a_of_type_Uzh = new uzh();
    }
    return this.jdField_a_of_type_Uzh;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(paramInt1);
    this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(paramInt1);
    this.d.setVisibility(paramInt1);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(paramInt2);
  }
  
  private void a(boolean paramBoolean)
  {
    a().c();
    d(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void b()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(16);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    a().b();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    if (this.jdField_a_of_type_AndroidWidgetEditText == null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = new EditText(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.getParent() == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetEditText, 0, new LinearLayout.LayoutParams(1, 1));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365259));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363899));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378740));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new vac(this));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363939));
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363930));
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.d = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363912));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363984));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", AIOUtils.dp2px(250.0F, getContext().getResources()));
    vmp.b("CommentInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ScreenUtil.dip2px(250.0F);
      vmp.b("CommentInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.jdField_a_of_type_Int);
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366056);
    a().a((PublicFragmentActivity)this.jdField_a_of_type_AndroidAppActivity, localViewGroup, this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363646);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new vad(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    e();
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    g();
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    a().a(this.jdField_a_of_type_Int);
    vmp.b("CommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Zwi = new zwi(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Zwi.a(new vae(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnFocusChangeListener(new vaf(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new vag(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new vah(this));
  }
  
  @TargetApi(19)
  public void I_()
  {
    int i = 0;
    super.I_();
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
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    String str = "";
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      if (localObject == null) {
        break label128;
      }
      localObject = ((QzoneTextBuilder)localObject).toPlainText();
    }
    for (;;)
    {
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject)) || (android.text.TextUtils.equals("[emoji]", (CharSequence)localObject)))
      {
        return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString();
        localObject = str;
        if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof QQTextBuilder))
        {
          QQTextBuilder localQQTextBuilder = (QQTextBuilder)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
          localObject = str;
          if (localQQTextBuilder != null) {
            localObject = a(localQQTextBuilder);
          }
        }
      }
      else
      {
        return QzoneEmotionUtils.splash2Emo((String)localObject);
        label128:
        localObject = "";
      }
    }
  }
  
  public String a(QQTextBuilder paramQQTextBuilder)
  {
    int j = 0;
    int i = paramQQTextBuilder.length();
    Object localObject1 = new char[i];
    paramQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject1);
    localObject1 = (QQText.EmoticonSpan[])paramQQTextBuilder.getSpans(0, i, QQText.EmoticonSpan.class);
    i = 0;
    if (j < localObject1.length)
    {
      Object localObject2 = localObject1[j];
      int k = paramQQTextBuilder.getSpanStart(localObject2);
      int m = paramQQTextBuilder.getSpanEnd(localObject2);
      switch (((QQText.EmoticonSpan)localObject2).emojiType)
      {
      }
      for (;;)
      {
        j += 1;
        break;
        localObject2 = com.tencent.mobileqq.text.TextUtils.getEmojiString(((QQText.EmoticonSpan)localObject2).index);
        localStringBuffer.replace(k + i, m + i, (String)localObject2);
        i += ((String)localObject2).length() - (m - k);
        continue;
        localObject2 = ((QQText.EmoticonSpan)localObject2).getDescription();
        localStringBuffer.replace(k + i, m + i, (String)localObject2);
        i += ((String)localObject2).length() - (m - k);
        continue;
        localObject2 = QQSysFaceUtil.getFaceDescription(((QQText.EmoticonSpan)localObject2).index & 0x7FFFFFFF);
        localStringBuffer.replace(k + i, m + i, (String)localObject2);
        i += ((String)localObject2).length() - (m - k);
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(int paramInt)
  {
    show();
    f();
    if (paramInt > 0)
    {
      a().post(new WsCommentInputPopupWindow.9(this, paramInt));
      return;
    }
    a().post(new WsCommentInputPopupWindow.10(this));
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new WsCommentInputPopupWindow.8(this, paramView));
  }
  
  public void a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  public void a(vai paramvai)
  {
    this.jdField_a_of_type_Vai = paramvai;
  }
  
  public void a(zuf paramzuf)
  {
    this.jdField_a_of_type_Zuf = paramzuf;
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    a(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    vmp.b("CommentInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_c_of_type_Int) {
        QQToast.a(getContext(), anvx.a(2131701680) + this.jdField_c_of_type_Int + anvx.a(2131701681), 0).a();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e166[/em]");
      a(0, 8);
      continue;
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_c_of_type_Int) {
        QQToast.a(getContext(), anvx.a(2131701680) + this.jdField_c_of_type_Int + anvx.a(2131701681), 0).a();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e163[/em]");
      a(0, 8);
      continue;
      vmp.b("CommentInputPopupWindow", 1, "btn_emotion");
      b(false);
      a(0, 8);
      continue;
      vmp.b("CommentInputPopupWindow", 1, "text_input");
      a(true);
      a(8, 0);
      continue;
      if (this.jdField_a_of_type_Zuf != null)
      {
        this.jdField_a_of_type_Zuf.a();
        continue;
        vmp.b("CommentInputPopupWindow", 1, "btn_keyboard");
        a(true);
        a(8, 0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Zwi != null) {
      this.jdField_a_of_type_Zwi.a();
    }
    this.jdField_a_of_type_Zwi = null;
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    a(false);
    if (this.jdField_a_of_type_Vai != null) {
      this.jdField_a_of_type_Vai.a();
    }
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getParent() != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText = null;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.clearFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vab
 * JD-Core Version:    0.7.0.1
 */