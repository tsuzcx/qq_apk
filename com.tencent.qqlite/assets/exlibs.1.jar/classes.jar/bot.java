import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bot
  implements View.OnClickListener
{
  public bot(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    String str;
    label270:
    do
    {
      int i;
      do
      {
        do
        {
          boolean bool1;
          do
          {
            do
            {
              do
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("TroopMemberListActivity", 2, "mOnKickOutBtnClickListener onclick");
                }
                i = paramView.getId();
                str = (String)paramView.getTag();
                if (i != 2131298847) {
                  break label270;
                }
                paramView = paramView.findViewById(2131298848);
                bool1 = bool2;
                if (paramView.getTag() != null)
                {
                  bool1 = bool2;
                  if ((paramView.getTag() instanceof Boolean)) {
                    bool1 = ((Boolean)paramView.getTag()).booleanValue();
                  }
                }
                paramView = this.a.a(str, bool1);
                if (!bool1) {
                  break;
                }
              } while (this.a.jdField_r_of_type_JavaLangString.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.jdField_r_of_type_JavaLangString))
              {
                paramView = this.a.a(this.a.jdField_r_of_type_JavaLangString, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.jdField_r_of_type_JavaLangString = str;
              return;
            } while (this.a.q.equals(str));
            if (paramView != null) {
              paramView.a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.q))
            {
              paramView = this.a.a(this.a.q, bool1);
              if (paramView != null) {
                paramView.a.b(true);
              }
            }
            this.a.q = str;
            return;
            if (i != 2131298884) {
              break label397;
            }
            paramView = paramView.findViewById(2131298885);
            bool1 = bool3;
            if (paramView.getTag() != null)
            {
              bool1 = bool3;
              if ((paramView.getTag() instanceof Boolean)) {
                bool1 = ((Boolean)paramView.getTag()).booleanValue();
              }
            }
            if (!bool1) {
              break;
            }
            paramView = this.a.a(this.a.jdField_r_of_type_JavaLangString, bool1);
          } while (paramView == null);
          paramView.a.b(true);
          this.a.jdField_r_of_type_JavaLangString = "";
          return;
          paramView = this.a.a(this.a.q, bool1);
        } while (paramView == null);
        paramView.a.b(true);
        this.a.q = "";
        return;
      } while ((i != 2131298850) || (!this.a.b));
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "delBtn onClick, uin=" + str);
      }
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break;
      }
    } while (!this.a.isResume());
    label397:
    QQToast.a(this.a, this.a.getString(2131363516), 0).b(this.a.getTitleBarHeight());
    return;
    if (this.a.jdField_r_of_type_Int == 1)
    {
      this.a.e(str);
      return;
    }
    paramView = new Dialog(this.a, 2131624119);
    paramView.setContentView(2130903187);
    ((TextView)paramView.findViewById(2131296911)).setText(this.a.getString(2131362852));
    TextView localTextView = (TextView)paramView.findViewById(2131296470);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131297087);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(this.a.getString(2131362859));
    localCheckBox.setText(this.a.getString(2131362860));
    localTextView = (TextView)paramView.findViewById(2131296914);
    Object localObject = (TextView)paramView.findViewById(2131296915);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new bou(this, paramView));
    ((TextView)localObject).setOnClickListener(new bov(this, str, localCheckBox, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bot
 * JD-Core Version:    0.7.0.1
 */