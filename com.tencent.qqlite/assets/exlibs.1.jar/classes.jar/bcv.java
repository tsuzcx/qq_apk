import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class bcv
  extends XBaseAdapter
{
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcv(QQLSActivity paramQQLSActivity) {}
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 40;
    System.currentTimeMillis();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903506, null);
      paramView = new bcx();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298251));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131298263));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131298252));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131298255));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    bcx localbcx = (bcx)paramViewGroup.getTag();
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localbcx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
    if (localRecentBaseData.a() == 0)
    {
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      if (paramView != null) {
        if (ActionMsgUtil.b(paramView.msgtype))
        {
          localbcx.jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.a);
          localbcx.b.setText(new QQText(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.a()));
          localbcx.c.setText(localRecentBaseData.jdField_b_of_type_JavaLangString);
          if (localRecentBaseData.a() != 4000) {
            break label585;
          }
        }
      }
    }
    label585:
    for (paramInt = ((NewFriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(31)).a();; paramInt = i)
    {
      localbcx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(localbcx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, paramInt, 0);
      return paramViewGroup;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity;
      Object localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a();
      Object localObject2 = localRecentBaseData.a();
      int k = localRecentBaseData.a();
      if (localRecentBaseData.b() > 40) {}
      for (paramInt = j;; paramInt = localRecentBaseData.b())
      {
        if (paramView.a(((QQMessageFacade)localObject1).a((String)localObject2, k, paramInt))) {}
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localbcx.b.setTextColor(-4210755);
        break;
      }
      localbcx.b.setTextColor(-4210755);
      break;
      if (localRecentBaseData.a() == 1001)
      {
        localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
        localObject1 = ((FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8)).a(((MessageRecord)localObject2).senderuin);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject2, false));
        localbcx.b.setTextColor(-4210755);
        break;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
      localbcx.b.setTextColor(-4210755);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcv
 * JD-Core Version:    0.7.0.1
 */