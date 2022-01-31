import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import java.util.ArrayList;
import java.util.List;

public class bcr
  extends BaseAdapter
{
  public List a;
  
  public bcr(QQLSActivity paramQQLSActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
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
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903499, null);
      paramView = new bct();
      localObject = (TextView)paramViewGroup.findViewById(2131298241);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setMaxLines(10);
      paramView.a = ((TextView)localObject);
      paramViewGroup.setTag(paramView);
    }
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return paramViewGroup;
    }
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bct localbct = (bct)paramViewGroup.getTag();
    if (localMessageRecord.istroop == 1001)
    {
      localObject = ((FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8)).a(localMessageRecord.senderuin);
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      paramView = paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
      if ((localMessageRecord.istroop != 0) || (!ActionMsgUtil.b(localMessageRecord.msgtype))) {
        break label330;
      }
    }
    for (;;)
    {
      localbct.a.setText(new QQText(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
      return paramViewGroup;
      if (AnonymousChatHelper.a(localMessageRecord))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131362566) + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
        break;
      }
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
      break;
      label330:
      localbct.a.setTextColor(-4210755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcr
 * JD-Core Version:    0.7.0.1
 */