import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xby
  extends BaseAdapter
{
  private List<xbz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, xca> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      xbz localxbz = (xbz)this.jdField_a_of_type_JavaUtilList.get(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localxbz.jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(List<xbz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    xbz localxbz = (xbz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560323, paramViewGroup, false);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, DpUtil.dip2px(paramViewGroup.getContext(), 50.0F)));
      paramViewGroup = new xca();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378200));
      paramViewGroup.b = paramView.findViewById(2131379173);
      if ((localxbz != null) && (Build.VERSION.SDK_INT >= 4)) {
        paramView.setContentDescription(localxbz.jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramViewGroup);
    }
    label260:
    label266:
    for (;;)
    {
      if ((localxbz != null) && (paramViewGroup != null) && (paramView != null))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localxbz.jdField_a_of_type_JavaLangString);
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (!localxbz.jdField_a_of_type_Boolean) {
          break label251;
        }
        paramInt = Color.parseColor("#ffff5b84");
        label185:
        localTextView.setTextColor(paramInt);
        paramViewGroup = paramViewGroup.b;
        if (!localxbz.jdField_a_of_type_Boolean) {
          break label260;
        }
      }
      for (paramInt = 0;; paramInt = 8)
      {
        paramViewGroup.setVisibility(paramInt);
        paramView.setSelected(localxbz.jdField_a_of_type_Boolean);
        return paramView;
        paramViewGroup = (xca)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if (paramViewGroup == null) {
          break label266;
        }
        paramView = paramViewGroup.jdField_a_of_type_AndroidViewView;
        break;
        label251:
        paramInt = Color.parseColor("#ff878b99");
        break label185;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xby
 * JD-Core Version:    0.7.0.1
 */