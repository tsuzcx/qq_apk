import android.content.res.Resources;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseHornListActivity;
import com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter;
import com.tencent.mobileqq.activity.MyPublishedHornActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class cwl
  extends NearHornObserver
{
  public cwl(MyPublishedHornActivity paramMyPublishedHornActivity) {}
  
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
          break label104;
        }
        localHornDetail.commentCnt = paramInt;
        i = 1;
      }
    }
    label104:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cwm(this));
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      this.a.e = paramString;
      if (this.a.jdField_b_of_type_ComTencentMobileqqDataHornDetail != null)
      {
        this.a.jdField_a_of_type_Cwq.a(this.a.jdField_b_of_type_ComTencentMobileqqDataHornDetail);
        if ((this.a.jdField_a_of_type_JavaUtilList.size() == 0) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.b)) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a(this.a.jdField_b_of_type_ComTencentMobileqqDataHornDetail.hornKey);
      }
      this.a.jdField_a_of_type_Cwq.a();
      this.a.jdField_a_of_type_Cwq.notifyDataSetChanged();
      return;
    }
    if ((QLog.isColorLevel()) && (this.a.jdField_b_of_type_ComTencentMobileqqDataHornDetail != null)) {
      QLog.i("NearHornRelated", 2, "MyPublishedHornActivity: hornDeleteFail:" + this.a.jdField_b_of_type_ComTencentMobileqqDataHornDetail.hornKey + " ret code is " + paramInt);
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString = this.a.jdField_a_of_type_Bwn.obtainMessage(3);
    this.a.jdField_a_of_type_Bwn.sendMessage(paramString);
  }
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, int paramInt, String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.b = this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.b.booleanValue();
      if (paramBoolean1.booleanValue()) {
        this.a.jdField_a_of_type_JavaUtilList.clear();
      }
      if (paramList.size() > 0)
      {
        paramBoolean1 = (HornDetail)paramList.get(paramList.size() - 1);
        this.a.jdField_b_of_type_JavaLangString = paramBoolean1.hornKey;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramBoolean1 = (HornDetail)paramList.next();
          this.a.jdField_a_of_type_JavaUtilList.add(paramBoolean1);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.a = false;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if ((this.a.jdField_a_of_type_JavaUtilList.size() == 0) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        paramList = new TextView(this.a.jdField_a_of_type_AndroidContentContext);
        paramBoolean1 = new RelativeLayout.LayoutParams(-1, -2);
        paramBoolean1.addRule(13, -1);
        paramList.setTextColor(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.getResources().getColor(2131361872));
        paramList.setTextSize(16.0F);
        paramList.setGravity(1);
        paramList.setText(2131563274);
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramList, paramBoolean1);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i("NearHornRelated", 2, "MyPublishedHornActivity: getHornList Fail, retCode is " + paramInt);
      }
      if (!paramBoolean1.booleanValue())
      {
        paramList = this.a.jdField_a_of_type_Bwn.obtainMessage(0);
        this.a.jdField_a_of_type_Bwn.sendMessageDelayed(paramList, 1000L);
      }
      else
      {
        paramList = this.a.jdField_a_of_type_Bwn.obtainMessage(3);
        this.a.jdField_a_of_type_Bwn.sendMessage(paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwl
 * JD-Core Version:    0.7.0.1
 */