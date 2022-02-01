import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.1;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.2;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.3;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class vto
  extends xpk
  implements View.OnClickListener
{
  public EditText a;
  public vuv a;
  public EditText b;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.jdField_a_of_type_Vuv = ((vuv)vux.a(29));
    a(2131558447);
    a(2131363839).setOnClickListener(this);
    a(2131363891).setOnClickListener(this);
    a(2131363790).setOnClickListener(this);
    a(2131363923).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131365913));
    this.b = ((EditText)a(2131365880));
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
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.1(this), true);
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.2(this), true);
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.3(this));
      continue;
      this.b.getText().toString();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.b.getText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      new vtn(BaseApplicationImpl.getApplication().getRuntime().getAccount()).a();
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.b.getText().toString(), this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vto
 * JD-Core Version:    0.7.0.1
 */