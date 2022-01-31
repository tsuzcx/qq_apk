import android.text.TextUtils;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class vyt
  extends uhn
{
  private List<QQStoryUserInfo> a;
  
  public vyt(QQStoryShieldListActivity paramQQStoryShieldListActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List<QQStoryUserInfo> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new QQStoryShieldListActivity.1.1(this, paramList));
  }
  
  public void a(boolean paramBoolean1, List<QQStoryUserInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString)
  {
    if (!TextUtils.equals(QQStoryShieldListActivity.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity), paramString)) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        paramList = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhk;
        if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Int == 2) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramList.a(paramArrayOfByte, 10, paramBoolean1, QQStoryShieldListActivity.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity));
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a(this.jdField_a_of_type_JavaUtilList);
      paramList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhl.jdField_b_of_type_JavaUtilList = paramList;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhl.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        paramArrayOfByte = paramList.iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramString = (QQStoryUserInfo)paramArrayOfByte.next();
          this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhl.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.uin, paramString);
        }
        this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhl.jdField_a_of_type_JavaUtilList = paramList;
      }
      a(paramList);
      QQStoryShieldListActivity.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    QQStoryShieldListActivity.b(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Beps.b();
    if (paramBoolean1)
    {
      List localList = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.jdField_a_of_type_Uhl.a(paramBoolean3);
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a(localList);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity, 2131695132, 0).b(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vyt
 * JD-Core Version:    0.7.0.1
 */