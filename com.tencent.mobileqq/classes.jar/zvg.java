import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zvg
  implements Runnable
{
  zvg(zvf paramzvf, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    Object localObject = (List)this.jdField_a_of_type_Zvf.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b.remove(this.jdField_a_of_type_Zvf.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Zvf.b);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "getTroopMemberInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopManager.ITroopMemberInfoCallBack localITroopMemberInfoCallBack = (TroopManager.ITroopMemberInfoCallBack)((WeakReference)((Iterator)localObject).next()).get();
      if (localITroopMemberInfoCallBack != null) {
        localITroopMemberInfoCallBack.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zvg
 * JD-Core Version:    0.7.0.1
 */