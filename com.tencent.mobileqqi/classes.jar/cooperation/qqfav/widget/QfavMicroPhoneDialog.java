package cooperation.qqfav.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.OvalProgress;
import ibp;
import mqq.app.AppRuntime;

public class QfavMicroPhoneDialog
  extends Dialog
  implements View.OnClickListener, VoicePlayer.VoicePlayerListener
{
  public static final int a = 7;
  public static final int b = 9;
  public static final int c = 11;
  public static final int d = 12;
  public Context a;
  protected Handler a;
  protected Button a;
  protected EditText a;
  public ImageView a;
  protected RelativeLayout a;
  public TextView a;
  protected VoicePlayer a;
  public OvalProgress a;
  protected QfavMicroPhoneDialog.Listener a;
  protected String a;
  public int e;
  
  public QfavMicroPhoneDialog(Context paramContext, AppRuntime paramAppRuntime, QfavMicroPhoneDialog.Listener paramListener)
  {
    super(paramContext, 2131624405);
    this.jdField_a_of_type_AndroidOsHandler = new ibp(this);
    this.jdField_a_of_type_CooperationQqfavWidgetQfavMicroPhoneDialog$Listener = paramListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setContentView(2130903463);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232664));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131232672).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress = ((OvalProgress)findViewById(2131232665));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232666));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131232667));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232671));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232669));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
  }
  
  private void a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty(str)) || (!FileUtil.a(str))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(str, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839033);
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a())
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839032);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839033);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 8) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setProgressParams(paramInt1, paramInt2);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    this.e = paramInt;
    if ((!TextUtils.isEmpty(paramString)) && (FileUtil.a(paramString)) && (this.e > 0))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.e = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt) + "\"");
      return true;
    }
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    if (paramView == null) {
      return;
    }
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      }
      cancel();
      return;
      a();
      i = 0;
      continue;
      i = j;
      if (this.jdField_a_of_type_CooperationQqfavWidgetQfavMicroPhoneDialog$Listener != null)
      {
        this.jdField_a_of_type_CooperationQqfavWidgetQfavMicroPhoneDialog$Listener.a(this.jdField_a_of_type_JavaLangString, this.e, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavMicroPhoneDialog
 * JD-Core Version:    0.7.0.1
 */