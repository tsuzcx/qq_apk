import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multimsg.save.FileSaveProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ajlm
  extends ReportDialog
  implements View.OnClickListener
{
  private TextView UT;
  public ajlm.a a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new ajln(this);
  private FileSaveProgressView jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView;
  
  public ajlm(@NonNull Context paramContext)
  {
    super(paramContext, 2131755379);
    initView(paramContext);
  }
  
  private void doCancel()
  {
    if (isShowing()) {
      if (this.jdField_a_of_type_Ajlm$a != null) {
        this.jdField_a_of_type_Ajlm$a.cancel();
      }
    }
    try
    {
      super.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "cancel dialog exception: " + localThrowable.getMessage());
    }
  }
  
  private void initEvent()
  {
    setCanceledOnTouchOutside(false);
    setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void initView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559332, null);
    setContentView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView = ((FileSaveProgressView)paramContext.findViewById(2131377633));
    this.UT = ((TextView)paramContext.findViewById(2131364221));
    this.UT.setOnClickListener(this);
    initEvent();
  }
  
  public void Rg(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView.setProgress(paramInt);
    }
  }
  
  public void a(ajlm.a parama)
  {
    this.jdField_a_of_type_Ajlm$a = parama;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      doCancel();
    }
  }
  
  public void show()
  {
    if (!isShowing()) {}
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "show dialog exception: " + localThrowable.getMessage());
    }
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlm
 * JD-Core Version:    0.7.0.1
 */