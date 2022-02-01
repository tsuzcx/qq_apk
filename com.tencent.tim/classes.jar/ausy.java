import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AuthorizationItem;
import com.tencent.widget.AuthorizationItem.a;
import java.util.List;

public class ausy
  extends ausj
  implements View.OnClickListener
{
  private final List<AuthorizationItem.a> Li;
  private tlq.a jdField_b_of_type_Tlq$a;
  private final tlq.b jdField_b_of_type_Tlq$b;
  
  public ausy(Activity paramActivity, tlq.b paramb, tlq.a parama, List<AuthorizationItem.a> paramList)
  {
    super(paramActivity);
    this.Li = paramList;
    this.jdField_b_of_type_Tlq$b = paramb;
    this.jdField_b_of_type_Tlq$a = parama;
    initView();
  }
  
  private AuthorizationItem a(AuthorizationItem.a parama, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, parama, paramInt);
  }
  
  private void initView()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559224, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131369423);
    if ((this.Li != null) && (this.Li.size() > 0))
    {
      int k = this.Li.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((AuthorizationItem.a)this.Li.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((AuthorizationItem.a)this.Li.get(j), i, this.jdField_b_of_type_Tlq$b.gW(((AuthorizationItem.a)this.Li.get(j)).key)));
          j += 1;
          break;
          label145:
          if (k == 2)
          {
            if (j == 0) {
              i = 0;
            } else {
              i = 2;
            }
          }
          else if (j == 0) {
            i = 0;
          } else if (j < k - 1) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
    addView(localLinearLayout1);
    localLinearLayout1.findViewById(2131363800).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363826).setOnClickListener(this);
    localLinearLayout1.findViewById(2131369785).setOnClickListener(this);
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
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      Object localObject1 = new ausw(getContext());
      Object localObject2 = ((ausw)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131755013);
      }
      ((ausw)localObject1).show();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_b_of_type_Tlq$a != null)
      {
        this.jdField_b_of_type_Tlq$b.errCode = 2;
        this.jdField_b_of_type_Tlq$a.a(this.jdField_b_of_type_Tlq$b);
      }
      dismiss();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
      int i = 0;
      while (i < this.Li.size())
      {
        localObject2 = (AuthorizationItem.a)this.Li.get(i);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Tlq$b.gW(((AuthorizationItem.a)localObject2).key)))
        {
          ((SharedPreferences)localObject1).edit().putBoolean(((AuthorizationItem.a)localObject2).key, true).apply();
          if (QLog.isColorLevel()) {
            QLog.d("ActionSheet", 2, "record " + ((AuthorizationItem.a)localObject2).key + " authorize");
          }
        }
        i += 1;
      }
      if (this.jdField_b_of_type_Tlq$a != null)
      {
        this.jdField_b_of_type_Tlq$b.errCode = 0;
        this.jdField_b_of_type_Tlq$a.a(this.jdField_b_of_type_Tlq$b);
      }
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausy
 * JD-Core Version:    0.7.0.1
 */