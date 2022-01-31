import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class gjz
  extends BaseAdapter
{
  public List a;
  
  public gjz(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130838726;
    }
    if (paramQCallRecord.isMissCall()) {
      return 2130838732;
    }
    return 2130838721;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.uinType == 3000)
    {
      switch (paramQCallRecord.state)
      {
      default: 
        paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562417);
      }
      for (;;)
      {
        return paramQCallRecord;
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562417);
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562474);
        paramQCallRecord = paramQCallRecord.talkTime;
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561733, new Object[] { paramQCallRecord });
        String str2 = paramQCallRecord.talkTime;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561756);
        paramQCallRecord = str1;
        if (!TextUtils.isEmpty(str2))
        {
          paramQCallRecord = str1;
          try
          {
            if (Long.parseLong(str2) > 0L)
            {
              paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561733, new Object[] { str2 });
              return paramQCallRecord;
            }
          }
          catch (Exception paramQCallRecord)
          {
            paramQCallRecord.printStackTrace();
            return str1;
          }
        }
      }
    }
    switch (paramQCallRecord.state)
    {
    default: 
      return "";
    case 0: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561728), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561763);
    case 2: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561728), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131563053);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560131);
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560135);
    case 10: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560131);
    case 7: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560130);
    case 12: 
      if (paramQCallRecord.isSender()) {
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560133);
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560131);
    case 42: 
    case 43: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131560133);
    }
    if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561728), new Object[] { paramQCallRecord.getTalkTimeMinute() });
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561763);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new gka();
      if (i != QCallRecord.TYPE_DATE) {
        break label142;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903547, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232888));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231418));
    }
    QCallRecord localQCallRecord;
    for (;;)
    {
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView;
      paramView = (gka)paramViewGroup.getTag();
      localQCallRecord = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (i != QCallRecord.TYPE_DATE) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localQCallRecord.getDateString());
      paramInt = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131362036);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt);
      return paramViewGroup;
      label142:
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903550, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232899));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232900));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232901));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131232902));
    }
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localQCallRecord.getTime());
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(a(localQCallRecord));
    paramView.c.setText(a(localQCallRecord));
    if (localQCallRecord.isVideo())
    {
      paramView.b.setVisibility(0);
      return paramViewGroup;
    }
    paramView.b.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjz
 * JD-Core Version:    0.7.0.1
 */