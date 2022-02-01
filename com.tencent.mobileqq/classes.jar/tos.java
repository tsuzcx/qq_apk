import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class tos
  extends ReportDialog
  implements View.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  private tot jdField_a_of_type_Tot;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public tos(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    a(2131379001, null, this.jdField_a_of_type_JavaLangString, this.b);
    a(2131365157, null, this.c, this.d);
    a(2131370003, this, this.e, this.f);
    a(2131376688, this, this.g, this.h);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Tot != null) {
      this.jdField_a_of_type_Tot.a(paramInt, this.i);
    }
    dismiss();
  }
  
  private void a(int paramInt, View.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    try
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (paramOnClickListener != null) {
        localTextView.setOnClickListener(paramOnClickListener);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localTextView.setText(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localTextView.setTextColor(Color.parseColor(paramString2));
      }
      return;
    }
    catch (Exception paramOnClickListener)
    {
      QLog.d("RIJUserLevelDialog", 1, "initTextView error,msg=" + paramOnClickListener);
    }
  }
  
  public void a(tou paramtou)
  {
    if (paramtou == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramtou.jdField_a_of_type_JavaLangString;
    this.c = paramtou.c;
    this.e = paramtou.e;
    this.f = paramtou.f;
    this.g = paramtou.g;
    this.h = paramtou.h;
    this.i = paramtou.i;
    this.jdField_a_of_type_Tot = paramtou.jdField_a_of_type_Tot;
    this.b = paramtou.b;
    this.d = paramtou.d;
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
      a(1);
      continue;
      a(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    }
    setContentView(2131560355);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tos
 * JD-Core Version:    0.7.0.1
 */