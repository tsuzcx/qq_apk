import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditText;
import com.tencent.widget.XEditTextEx;

public class ayov
  extends ReportDialog
  implements TextWatcher, View.OnClickListener
{
  XEditText jdField_a_of_type_ComTencentWidgetXEditText;
  private qsi jdField_a_of_type_Qsi;
  private DialogInterface.OnShowListener jdField_b_of_type_AndroidContentDialogInterface$OnShowListener;
  private aygz jdField_b_of_type_Aygz;
  String cXJ;
  private Context mContext;
  ViewGroup mRootView;
  
  public ayov(@NonNull Context paramContext, aygz paramaygz)
  {
    super(paramContext, 2131755374);
    this.mContext = paramContext;
    this.jdField_b_of_type_Aygz = paramaygz;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void bo(String paramString, boolean paramBoolean)
  {
    super.setOnShowListener(new ayox(this, paramBoolean));
    super.show();
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentWidgetXEditText.setSelection(paramString.length());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditText.setText(this.cXJ);
    paramString = this.jdField_a_of_type_ComTencentWidgetXEditText;
    if (this.cXJ == null) {}
    for (int i = 0;; i = this.cXJ.length())
    {
      paramString.setSelection(i);
      return;
    }
  }
  
  public void dismiss()
  {
    this.cXJ = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
    this.jdField_a_of_type_Qsi.bqb();
    this.jdField_a_of_type_Qsi.release();
    if (isShowing()) {
      super.dismiss();
    }
  }
  
  public String getText()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
  }
  
  public void init()
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = riw.getWindowScreenHeight(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(34);
    this.mRootView = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561828, null));
    this.mRootView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText = ((XEditTextEx)this.mRootView.findViewById(2131366528));
    this.jdField_a_of_type_ComTencentWidgetXEditText.addTextChangedListener(this);
    setContentView(this.mRootView);
    this.jdField_a_of_type_Qsi = new qsi(getContext(), this.mRootView, new ayow(this));
    this.jdField_a_of_type_Qsi.rW(this.mContext.getString(2131691042));
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayov
 * JD-Core Version:    0.7.0.1
 */