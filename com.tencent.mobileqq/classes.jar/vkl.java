import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.2;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.3;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class vkl
  extends vjp
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean d;
  
  public vkl(Activity paramActivity)
  {
    super(paramActivity);
    g();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
    }
    e(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Boolean) {
      d(this.jdField_b_of_type_AndroidViewView);
    }
    this.d = true;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    }
    c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new vkn(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new vko(this));
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    String str = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString();
    Matcher localMatcher = aakd.g.matcher(str);
    int i = 0;
    while (localMatcher.find()) {
      i += localMatcher.end() - localMatcher.start() - 2;
    }
    i = str.length() - i;
    int j = QzoneConfig.getQQCircleCommentMaxWordsLimit();
    if (i >= j - 10)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      if (i <= j) {
        break label162;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131166249));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("/" + j);
      return;
      label162:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131166250));
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Aakf = new aakf(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Aakf.a(new vkp(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  protected int a()
  {
    return 2131560693;
  }
  
  protected void a(View paramView) {}
  
  public void a(boolean paramBoolean)
  {
    show();
    l();
    if (paramBoolean)
    {
      a().post(new QCircleCommentInputPopupWindow.2(this));
      return;
    }
    a().post(new QCircleCommentInputPopupWindow.3(this));
  }
  
  protected boolean a()
  {
    boolean bool = false;
    int j;
    int i;
    try
    {
      j = QzoneConfig.getQQCircleCommentMaxWordsLimit();
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        i = 0;
      } else {
        i = Integer.parseInt(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return false;
    }
    if (i > j) {
      bool = true;
    }
    return bool;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364804));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363798));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363841));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380200));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381445));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380201));
    super.c();
    h();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    j();
  }
  
  public void dismiss()
  {
    b(false);
    super.dismiss();
  }
  
  protected void g()
  {
    vkm localvkm = new vkm(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299011);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131365926));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localvkm);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
    }
    do
    {
      return;
      QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
    } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this.jdField_a_of_type_AndroidAppActivity, localvkm);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
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
      i();
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      continue;
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      continue;
      if ((!a()) && (this.jdField_a_of_type_Vjt != null))
      {
        this.jdField_a_of_type_Vjt.a();
        continue;
        QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
        b(true);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkl
 * JD-Core Version:    0.7.0.1
 */