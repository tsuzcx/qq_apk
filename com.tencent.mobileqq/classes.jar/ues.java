import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;

public class ues
{
  public static Editable.Factory a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new uet();
  }
  
  private ImageButton a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    Context localContext = paramRelativeLayout.getContext();
    ImageButton localImageButton = new ImageButton(localContext);
    localImageButton.setContentDescription(localContext.getString(2131689856));
    localImageButton.setBackgroundResource(2130837995);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      localLayoutParams.rightMargin = bhtq.a(5.0F);
      localLayoutParams.bottomMargin = bhtq.a(7.0F);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      paramRelativeLayout.addView(localImageButton, localLayoutParams);
      return localImageButton;
    }
  }
  
  private EmoticonMainPanel a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt, asmr paramasmr)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    acid.a(paramPublicFragmentActivity, paramEditText);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    paramEditText = (EmoticonMainPanel)View.inflate(paramPublicFragmentActivity, 2131559123, null);
    paramEditText.setCallBack(paramasmr);
    paramEditText.b = true;
    paramEditText.a(paramPublicFragmentActivity.app, 1008, paramPublicFragmentActivity, paramPublicFragmentActivity.getTitleBarHeight(), null, null);
    paramEditText.k();
    paramEditText.setOnlySysEmotionEnable(true);
    paramViewGroup.addView(paramEditText, new RelativeLayout.LayoutParams(-1, paramInt));
    return paramEditText;
  }
  
  private void a(asmu paramasmu)
  {
    assj localassj;
    int i;
    int j;
    int k;
    int m;
    if (((paramasmu instanceof assj)) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      localassj = (assj)paramasmu;
      i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      k = localassj.a;
      m = localassj.b;
      if ((i >= 0) && (j >= 0) && (j >= i) && (m != -1)) {}
    }
    else
    {
      return;
    }
    if (k == 1) {}
    for (;;)
    {
      try
      {
        paramasmu = behh.b(m);
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramasmu);
      }
      catch (IllegalArgumentException paramasmu)
      {
        QLog.e("WSCommentEmoController", 2, "sendEmoticon: ", paramasmu);
        continue;
      }
      localassj.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app, null);
      return;
      paramasmu = behh.a(m);
    }
  }
  
  public void a()
  {
    ImageButton localImageButton;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        break label34;
      }
    }
    label34:
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getHeight() != paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams().height = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.invalidate();
    }
  }
  
  public void a(PublicFragmentActivity paramPublicFragmentActivity, ViewGroup paramViewGroup, EditText paramEditText, int paramInt)
  {
    if ((paramEditText == null) || (paramViewGroup == null) || (paramPublicFragmentActivity == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity = paramPublicFragmentActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(paramPublicFragmentActivity, paramViewGroup, paramEditText, paramInt, new ueu(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new uev(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ues
 * JD-Core Version:    0.7.0.1
 */