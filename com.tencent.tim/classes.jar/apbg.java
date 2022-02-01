import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class apbg
  extends accd
{
  apbg(apbc paramapbc) {}
  
  protected void aa(boolean paramBoolean, Object paramObject)
  {
    this.c.app.removeObserver(this.c.jdField_a_of_type_Accd);
    if (this.c.mActivity == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.c.mActivity.get())
    {
      this.c.mActivity = null;
      if (this.c.jdField_b_of_type_Apbc$c != null) {
        break;
      }
      apbc.a(this.c);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate data null");
      apbc.a(this.c);
      this.c.jdField_b_of_type_Apbc$c.bE(-1, "");
      this.c.jdField_b_of_type_Apbc$c = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((apbc.e)paramObject).resultCode;
      i = j;
    }
    catch (Exception paramObject)
    {
      label135:
      String str;
      break label135;
    }
    QLog.i("TroopCreateLogic", 1, "onGetTroopCreate retCode:" + i + "  currentUin:" + this.c.app.getCurrentUin());
    apbc.a(this.c);
    this.c.jdField_b_of_type_Apbc$c.bE(i, "");
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate troopUin:" + str);
      apbc.a(this.c);
      this.c.jdField_b_of_type_Apbc$c.bE(-1, "");
      this.c.jdField_b_of_type_Apbc$c = null;
      return;
    }
    this.c.jdField_a_of_type_Apbc$d.troopUin = str;
    anot.a(this.c.app, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.c.jdField_a_of_type_Apbc$d.classify), "", "");
    if (this.c.jdField_a_of_type_Apbc$d.HD == null)
    {
      i = 1;
      anot.a(this.c.app, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.c.jdField_a_of_type_Apbc$d.createFrom, "" + i, "");
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate success troopUin:" + str + " number:" + i + "  createFrom:" + this.c.jdField_a_of_type_Apbc$d.createFrom);
      ThreadManager.post(new TroopCreateLogic.4.1(this, str, paramObject, i), 8, null, true);
      if (this.c.jdField_a_of_type_Apbc$d.cPG)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.c.ch(paramObject, str);
      }
      this.c.jdField_b_of_type_Apbc$c.bE(0, str);
      if (this.c.jdField_a_of_type_Apbc$d.HD.size() <= 0) {
        break label634;
      }
      ((acms)this.c.app.getBusinessHandler(20)).a(str, this.c.jdField_a_of_type_Apbc$d.HD, "");
      this.c.app.addObserver(this.c.jdField_b_of_type_Acnd);
    }
    for (;;)
    {
      apbc.a(this.c);
      return;
      i = this.c.jdField_a_of_type_Apbc$d.HD.size();
      break;
      label634:
      this.c.jdField_b_of_type_Apbc$c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbg
 * JD-Core Version:    0.7.0.1
 */