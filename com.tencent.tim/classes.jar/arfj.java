import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class arfj
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private arfj.a a;
  private QQAppInterface app;
  private boolean cZV;
  private Context context;
  private TextView jdField_do;
  private CheckBox mCheckBox;
  private TextView mLeftBtn;
  private TextView mRightBtn;
  private TextView mTitle;
  
  public arfj(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, 2131756467);
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.cZV = paramBoolean;
    initDialog();
  }
  
  private void initDialog()
  {
    setContentView(2131562976);
    this.mTitle = ((TextView)findViewById(2131365867));
    this.jdField_do = ((TextView)findViewById(2131365863));
    this.mCheckBox = ((CheckBox)findViewById(2131364575));
    this.mLeftBtn = ((TextView)findViewById(2131365852));
    this.mRightBtn = ((TextView)findViewById(2131365858));
    if (this.mTitle != null) {
      this.mTitle.setText(acfp.m(2131704923));
    }
    if (this.jdField_do != null) {
      this.jdField_do.setText(acfp.m(2131704922));
    }
    if (this.mCheckBox != null)
    {
      if (!this.cZV) {
        break label231;
      }
      this.mCheckBox.setVisibility(0);
      this.mCheckBox.setText(acfp.m(2131704924));
      this.mCheckBox.setChecked(aqmj.aT(this.context, this.app.getCurrentUin()));
      this.mCheckBox.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      if (this.mLeftBtn != null)
      {
        this.mLeftBtn.setText(2131721058);
        this.mLeftBtn.setOnClickListener(this);
      }
      if (this.mRightBtn != null)
      {
        this.mRightBtn.setText(2131721079);
        this.mRightBtn.setOnClickListener(this);
      }
      setCancelable(true);
      setCanceledOnTouchOutside(true);
      return;
      label231:
      this.mCheckBox.setVisibility(8);
      this.mCheckBox.setChecked(false);
    }
  }
  
  public void a(arfj.a parama)
  {
    this.a = parama;
  }
  
  public boolean isChecked()
  {
    if (this.mCheckBox != null) {
      return this.mCheckBox.isChecked();
    }
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i = 3;
    if (this.cZV)
    {
      if (this.mCheckBox.isChecked()) {
        i = 1;
      }
    }
    else {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      dismiss();
      anot.a(this.app, "dc00898", "", "", "0X800A365", "0X800A365", i, 0, "1", "", "", "");
      continue;
      if (this.a != null)
      {
        this.a.a(this, paramView, isChecked());
        if (this.cZV) {
          aqmj.D(this.context, this.app.getCurrentUin(), this.mCheckBox.isChecked());
        }
        dismiss();
      }
      anot.a(this.app, "dc00898", "", "", "0X800A364", "0X800A364", i, 0, "1", "", "", "");
    }
  }
  
  public void setContentText(String paramString)
  {
    this.jdField_do.setText(paramString);
  }
  
  @Deprecated
  public void setTitleText(String paramString)
  {
    this.mTitle.setText(paramString);
  }
  
  public void show(int paramInt)
  {
    super.show();
    anot.a(this.app, "dc00898", "", "", "0X800A363", "0X800A363", paramInt, 0, "1", "", "", "");
  }
  
  public static abstract interface a
  {
    public abstract void a(Dialog paramDialog, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfj
 * JD-Core Version:    0.7.0.1
 */