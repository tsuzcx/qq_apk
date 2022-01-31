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

public class gfq
  extends BaseAdapter
{
  public List a;
  
  public gfq(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130838728;
    }
    if (paramQCallRecord.isMissCall()) {
      return 2130838734;
    }
    return 2130838723;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    Object localObject = "";
    if (paramQCallRecord.uinType == 3000) {
      switch (paramQCallRecord.state)
      {
      default: 
        localObject = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562417);
      }
    }
    for (;;)
    {
      return localObject;
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562417);
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131562474);
      paramQCallRecord = paramQCallRecord.talkTime;
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561733, new Object[] { paramQCallRecord });
      String str = paramQCallRecord.talkTime;
      paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561756);
      localObject = paramQCallRecord;
      if (!TextUtils.isEmpty(str))
      {
        localObject = paramQCallRecord;
        try
        {
          if (Long.parseLong(str) > 0L)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131561733, new Object[] { str });
            return localObject;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return paramQCallRecord;
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
      paramViewGroup = new gfr();
      if (i != QCallRecord.TYPE_DATE) {
        break label142;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903549, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232891));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231418));
    }
    QCallRecord localQCallRecord;
    for (;;)
    {
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView;
      paramView = (gfr)paramViewGroup.getTag();
      localQCallRecord = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (i != QCallRecord.TYPE_DATE) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localQCallRecord.getDateString());
      paramInt = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131362046);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt);
      return paramViewGroup;
      label142:
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903552, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232902));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232903));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232904));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131232905));
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
 * Qualified Name:     gfq
 * JD-Core Version:    0.7.0.1
 */