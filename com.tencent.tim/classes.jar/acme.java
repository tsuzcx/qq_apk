import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

class acme
  extends SubAccountObserver
{
  acme(acmd paramacmd, anxs paramanxs, anxr paramanxr, boolean paramBoolean) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramString3 == null) || (paramString2 == null) || (paramString1 == null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handlerGetBindSubAccount() onGetKeyBack key is null or ? happen 0 ? =>");
        if (paramString3 != null) {
          break label107;
        }
        bool1 = true;
        paramString3 = localStringBuilder.append(bool1);
        if (paramString2 != null) {
          break label113;
        }
      }
      label107:
      label113:
      for (bool1 = true;; bool1 = false)
      {
        paramString2 = paramString3.append(bool1);
        bool1 = bool2;
        if (paramString1 == null) {
          bool1 = true;
        }
        QLog.e("SUB_ACCOUNT", 2, bool1);
        this.jdField_a_of_type_Acmd.notifyUI(2, true, this.b);
        return;
        bool1 = false;
        break;
      }
    }
    if ((this.jdField_a_of_type_Acmd.app != null) && (paramString2.equalsIgnoreCase(this.b.aQf)) && (paramString1.equalsIgnoreCase(this.jdField_a_of_type_Acmd.app.getAccount())))
    {
      this.jdField_a_of_type_Anxr.R(paramString2, paramString3, this.bJr);
      anxk.a(this.jdField_a_of_type_Acmd.app, (byte)1, paramString2);
      this.b.cKA = true;
      this.jdField_a_of_type_Acmd.notifyUI(2, true, this.b);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder().append("handlerGetBindSubAccount() onGetKeyBack error happen 1 ? =>app:");
      if (this.jdField_a_of_type_Acmd.app == null) {
        bool1 = true;
      }
      QLog.d("SUB_ACCOUNT", 2, bool1 + " subUin:" + paramString2.equalsIgnoreCase(this.b.aQf) + " mainAccount:" + paramString1.equalsIgnoreCase(this.jdField_a_of_type_Acmd.app.getAccount()));
    }
    this.jdField_a_of_type_Acmd.notifyUI(2, true, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acme
 * JD-Core Version:    0.7.0.1
 */