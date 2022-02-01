import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.1;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.2;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.3;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class prv
  extends qwe
  implements View.OnClickListener
{
  public EditText X;
  public EditText Y;
  public psv a;
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.a = ((psv)psx.a(29));
    setContentView(2131558483);
    findViewById(2131363868).setOnClickListener(this);
    findViewById(2131363917).setOnClickListener(this);
    findViewById(2131363819).setOnClickListener(this);
    findViewById(2131363951).setOnClickListener(this);
    this.X = ((EditText)findViewById(2131366261));
    this.Y = ((EditText)findViewById(2131366227));
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
      this.Y.getText().toString();
      this.X.getText().toString();
      this.Y.getText().clear();
      this.X.getText().clear();
      new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount()).clearAllDb();
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.Y.getText().toString(), this.X.getText().toString()));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prv
 * JD-Core Version:    0.7.0.1
 */