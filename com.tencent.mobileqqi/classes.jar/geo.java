import android.os.Handler;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity.SortComparator;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileCardTemplateInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class geo
  implements Runnable
{
  public geo(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "initTemplateListData start.");
    }
    Object localObject2 = null;
    Object localObject3 = ProfileCardUtil.a(this.a.b, false);
    Collections.sort((List)localObject3, new ProfileCardBrowserActivity.SortComparator(this.a));
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject1 = new ArrayList();
        i = 0;
        while (i < ((ArrayList)localObject3).size())
        {
          localObject2 = new ProfileCardTemplateInfo();
          ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)((ArrayList)localObject3).get(i));
          ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 0;
          ((ArrayList)localObject1).add(localObject2);
          i += 1;
        }
      }
    }
    boolean bool = this.a.a((ArrayList)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "initTemplateListData has user set flag : " + bool);
    }
    localObject2 = new ProfileCardTemplate();
    ((ProfileCardTemplate)localObject2).jdField_a_of_type_Long = 0L;
    ((ProfileCardTemplate)localObject2).d = "http://imgcache.qq.com/club/mobile/profile/template/default_v_5.jpg";
    ((ProfileCardTemplate)localObject2).c = "0";
    ((ProfileCardTemplate)localObject2).e = "";
    ((ProfileCardTemplate)localObject2).jdField_a_of_type_JavaLangString = this.a.getString(2131561912);
    localObject3 = new ProfileCardTemplateInfo();
    ((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject2);
    if (!bool) {}
    for (int i = 4;; i = 2)
    {
      ((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_Int = i;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      if ((!QLog.isColorLevel()) || (this.a.jdField_a_of_type_JavaUtilList == null)) {
        break;
      }
      i = j;
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "initTemplateListData, id : " + ((ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_Long + ", status : " + ((ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ", position : " + i);
        i += 1;
      }
    }
    this.a.jdField_a_of_type_JavaUtilList.add(localObject3);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     geo
 * JD-Core Version:    0.7.0.1
 */