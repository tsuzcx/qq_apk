import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import java.util.ArrayList;
import java.util.List;

public class dcc
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public dcc(QQLSActivity paramQQLSActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramArrayList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903593, null);
      paramView = new dce();
      localObject = (TextView)paramViewGroup.findViewById(2131233017);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setMaxLines(10);
      paramView.a = ((TextView)localObject);
      paramViewGroup.setTag(paramView);
    }
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return paramViewGroup;
    }
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = (dce)paramViewGroup.getTag();
    if (localMessageRecord.istroop == 7000)
    {
      paramView = SubAccountDataControll.a().b(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)) + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
      if (ActionMsgUtil.b(localMessageRecord.msgtype))
      {
        if (!"1".equals(com.tencent.mobileqq.transfile.TransfileUtile.a(localMessageRecord.msg)[3])) {
          break label270;
        }
        paramInt = 1;
        label201:
        if (paramInt == 0) {
          break label275;
        }
      }
    }
    label270:
    label275:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131560105);; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131560111))
    {
      ((dce)localObject).a.setText(new QQText(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
      return paramViewGroup;
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
      break;
      paramInt = 0;
      break label201;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcc
 * JD-Core Version:    0.7.0.1
 */