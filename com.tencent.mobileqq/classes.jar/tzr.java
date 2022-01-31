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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.10;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.11;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.8;
import com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.9;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class tzr
  extends ydh
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
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public CommentEditText a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private tzy jdField_a_of_type_Tzy;
  private tzz jdField_a_of_type_Tzz;
  private ydi jdField_a_of_type_Ydi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public tzr(Activity paramActivity)
  {
    super(paramActivity, 2131755395);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(a(), null);
    b();
    setCancelable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    c();
    a(this.jdField_a_of_type_AndroidViewView);
    e();
    setOnDismissListener(this);
    P_();
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    }
    e(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363574));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131377631));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new tzs(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setEditableFactory(baiv.c);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363615));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363656));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", aekt.a(250.0F, getContext().getResources()));
    QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = azgq.a(250.0F);
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.jdField_a_of_type_Int);
    }
    d();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363335);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new tzt(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    f();
  }
  
  private void d()
  {
    tzu localtzu = new tzu(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298914);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131365646));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localtzu);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
      return;
    }
    QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    h();
  }
  
  private void e(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.invalidate();
    QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ydi = new ydi(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ydi.a(new tzv(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new tzw(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new tzx(this));
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Boolean) {
      d(this.jdField_b_of_type_AndroidViewView);
    }
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  @TargetApi(19)
  public void P_()
  {
    int i = 0;
    super.P_();
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
  
  protected abstract int a();
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    String str = "";
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof baiv))
    {
      localObject = (baiv)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      if (localObject == null) {
        break label147;
      }
      localObject = ((baiv)localObject).a();
    }
    for (;;)
    {
      return bjwp.b(((String)localObject).replaceAll(alpo.a(2131706174), alpo.a(2131706176)).replaceAll(alpo.a(2131706173), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131718144), "/chigua")).trim();
      localObject = str;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof baiq))
      {
        baiq localbaiq = (baiq)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
        localObject = str;
        if (localbaiq != null)
        {
          localObject = localbaiq.a();
          continue;
          label147:
          localObject = "";
        }
      }
    }
  }
  
  protected abstract void a(View paramView);
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(paramString.length());
  }
  
  public void a(tzy paramtzy)
  {
    this.jdField_a_of_type_Tzy = paramtzy;
  }
  
  public void a(tzz paramtzz)
  {
    this.jdField_a_of_type_Tzz = paramtzz;
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    g();
    if (paramBoolean)
    {
      a().post(new QCircleBaseInputPopupWindow.10(this));
      return;
    }
    a().post(new QCircleBaseInputPopupWindow.11(this));
  }
  
  protected void b()
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
  
  public void b(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new QCircleBaseInputPopupWindow.8(this, paramView));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  public void c(View paramView)
  {
    paramView.post(new QCircleBaseInputPopupWindow.9(this, paramView));
  }
  
  public void dismiss()
  {
    c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    b(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    default: 
    case 2131363574: 
    case 2131377631: 
    case 2131363656: 
      do
      {
        return;
        QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
        i();
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        return;
        QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
        b(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        return;
      } while (this.jdField_a_of_type_Tzy == null);
      this.jdField_a_of_type_Tzy.a();
      return;
    }
    QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
    b(true);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Ydi != null)
    {
      this.jdField_a_of_type_Ydi.a();
      this.jdField_a_of_type_Ydi = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Tzz != null) {
      this.jdField_a_of_type_Tzz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzr
 * JD-Core Version:    0.7.0.1
 */