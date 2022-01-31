import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter;
import com.tencent.mobileqq.activity.MyPublishedHornActivity;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class cwr
  extends BaseHornListActivity.BaseHornAdapter
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private cwr(MyPublishedHornActivity paramMyPublishedHornActivity)
  {
    super(paramMyPublishedHornActivity);
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    boolean bool = a(paramInt);
    HornDetail localHornDetail = (HornDetail)super.getItem(paramInt);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localHornDetail, Boolean.valueOf(bool));
      return;
    }
  }
  
  public void a(HornDetail paramHornDetail)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.jdField_a_of_type_JavaUtilList.remove(paramHornDetail);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    HornDetail localHornDetail = (HornDetail)super.getItem(paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localHornDetail)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localHornDetail)).booleanValue();
    }
    return false;
  }
  
  public int getCount()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.b) {
      return super.getCount();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    Object localObject;
    switch (super.getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903679, paramViewGroup, false);
        paramViewGroup = new bwp();
        paramView.setTag(paramViewGroup);
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131233378));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)paramView.findViewById(2131233363));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setSpannableFactory(QQText.a);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233364));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233365));
        localObject = (HornDetail)super.getItem(paramInt);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.b) {
          break label282;
        }
        paramViewGroup.b.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(((HornDetail)localObject).content, TextView.BufferType.SPANNABLE);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((HornDetail)localObject).place + " ").append(((HornDetail)localObject).time);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("" + ((HornDetail)localObject).commentCnt);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("查看该喇叭评论内容");
        return paramView;
        paramViewGroup = (bwp)paramView.getTag();
        break;
        label282:
        paramViewGroup.b.setVisibility(0);
        if (a(paramInt)) {
          paramViewGroup.b.setImageResource(2130839125);
        } else {
          paramViewGroup.b.setImageResource(2130839124);
        }
      }
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityMyPublishedHornActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903283, null);
      paramViewGroup = new bwp();
      paramView.setTag(paramViewGroup);
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231066));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231868));
      ((LinearLayout)paramView).setOrientation(0);
      localObject = paramViewGroup.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label478;
      }
      paramInt = 2131562334;
      label418:
      ((TextView)localObject).setText(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label485;
      }
      paramInt = 0;
      label439:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_c_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label491;
      }
    }
    label478:
    label485:
    label491:
    for (paramInt = i;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (bwp)paramView.getTag();
      break;
      paramInt = 2131562926;
      break label418;
      paramInt = 8;
      break label439;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwr
 * JD-Core Version:    0.7.0.1
 */