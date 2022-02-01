import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class adbw
  implements aqms.a
{
  adbw(adbv paramadbv, AppInterface paramAppInterface, String paramString, adbv.a parama) {}
  
  public void j(boolean paramBoolean, ArrayList<aqms> paramArrayList)
  {
    paramArrayList = (adcb)paramArrayList.get(0);
    if ((adbv.a(this.jdField_a_of_type_Adbv) != null) && (adbv.a(this.jdField_a_of_type_Adbv) == paramArrayList) && (this.b != null))
    {
      QLog.w(this.jdField_a_of_type_Adbv.TAG, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + adbu.adw() + "], config[" + paramArrayList.b + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Adbv.a(paramArrayList.b);
        this.jdField_a_of_type_Adbv.l(this.b);
      }
      adbv.a(this.jdField_a_of_type_Adbv, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adbv$a != null) {
        this.jdField_a_of_type_Adbv$a.b(this.jdField_a_of_type_Adbv.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Adbv.TAG, 1, "异步加载config返回[" + this.val$from + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbw
 * JD-Core Version:    0.7.0.1
 */