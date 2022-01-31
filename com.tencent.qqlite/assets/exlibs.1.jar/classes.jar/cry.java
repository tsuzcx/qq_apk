import SummaryCard.RespCondSearch;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class cry
  extends FriendListObserver
{
  public cry(ConditionSearchManager paramConditionSearchManager) {}
  
  protected void a(long paramLong, boolean paramBoolean, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "searchseq = " + this.a.jdField_a_of_type_Long + " | seq = " + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      return;
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      paramObject = (RespCondSearch)paramObject;
      ConditionSearchManager localConditionSearchManager = this.a;
      if (paramObject.cEndFlag == 0)
      {
        paramBoolean = true;
        localConditionSearchManager.jdField_d_of_type_Boolean = paramBoolean;
        this.a.m = paramObject.iPage;
        this.a.b = paramObject.dwSessionID;
        if (this.a.jdField_a_of_type_JavaUtilList != null) {
          break label290;
        }
        this.a.jdField_a_of_type_JavaUtilList = paramObject.vUserList;
      }
      for (;;)
      {
        if ((this.a.n >= 2) || ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() >= 10)) || (!this.a.jdField_d_of_type_Boolean)) {
          break label330;
        }
        paramObject = this.a;
        paramObject.n += 1;
        ((FriendListHandler)ConditionSearchManager.a(this.a).a(1)).a(this.a.jdField_a_of_type_Long, this.a.m + 1, this.a.b, this.a.jdField_k_of_type_JavaLangString, this.a.jdField_k_of_type_Int, this.a.l, this.a.c, this.a.jdField_d_of_type_ArrayOfJavaLangString);
        return;
        paramBoolean = false;
        break;
        label290:
        if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty())) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramObject.vUserList);
        }
      }
      label330:
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() < 6)) {
        this.a.jdField_d_of_type_Boolean = false;
      }
      this.a.a(true, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_d_of_type_Boolean);
      return;
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      this.a.jdField_d_of_type_Boolean = false;
      this.a.a(true, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_d_of_type_Boolean);
      return;
    }
    if (this.a.n == 0)
    {
      this.a.a(false, null, this.a.jdField_d_of_type_Boolean);
      return;
    }
    this.a.a(true, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_d_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cry
 * JD-Core Version:    0.7.0.1
 */