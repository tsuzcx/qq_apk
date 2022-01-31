import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class cqd
  extends NearHornObserver
{
  public cqd(HornListActivity paramHornListActivity) {}
  
  protected void a(String paramString, int paramInt)
  {
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter != null)
    {
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        HornDetail localHornDetail = (HornDetail)localIterator.next();
        if (!localHornDetail.hornKey.equals(paramString)) {
          break label170;
        }
        localHornDetail.commentCnt = paramInt;
        i = 1;
      }
    }
    label170:
    for (;;)
    {
      break;
      if (i != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
      }
      if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_AndroidViewView.getTag() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail.hornKey.equals(paramString)))
      {
        ((bwp)this.a.jdField_a_of_type_AndroidViewView.getTag()).c.setText(String.valueOf(paramInt));
        this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail.commentCnt = paramInt;
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean2.booleanValue())
    {
      this.a.jdField_a_of_type_JavaLangString = paramString;
      if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler == null)) {
        break label279;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.b = this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a.booleanValue();
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramBoolean1.booleanValue()) {
          this.a.jdField_a_of_type_JavaUtilList.clear();
        }
        if (paramList.size() > 0)
        {
          paramBoolean1 = (HornDetail)paramList.get(paramList.size() - 1);
          paramBoolean2 = (HornDetail)paramList.get(0);
          if (paramBoolean1.publishTime <= paramBoolean2.publishTime) {
            break label232;
          }
          this.a.jdField_b_of_type_JavaLangString = paramBoolean2.hornKey;
        }
        for (this.a.jdField_b_of_type_Long = paramBoolean2.publishTime;; this.a.jdField_b_of_type_Long = paramBoolean1.publishTime)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramBoolean1 = (HornDetail)paramList.next();
            if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail.hornKey.equals(paramBoolean1.hornKey))) {
              this.a.jdField_a_of_type_JavaUtilList.add(paramBoolean1);
            }
          }
          label232:
          this.a.jdField_b_of_type_JavaLangString = paramBoolean1.hornKey;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.a = false;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
      }
    }
    return;
    label279:
    if (QLog.isColorLevel()) {
      QLog.i("NearHornRelated", 2, "HornListActivity: getHornList Fail, retCode is " + paramInt);
    }
    if (!paramBoolean1.booleanValue())
    {
      paramList = this.a.jdField_a_of_type_Bwo.obtainMessage(0);
      this.a.jdField_a_of_type_Bwo.sendMessageDelayed(paramList, 1000L);
      return;
    }
    paramList = this.a.jdField_a_of_type_Bwo.obtainMessage(3);
    this.a.jdField_a_of_type_Bwo.sendMessage(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqd
 * JD-Core Version:    0.7.0.1
 */