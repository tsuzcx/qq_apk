import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class zjl
  extends BaseAdapter
{
  protected Context a;
  protected QQAppInterface a;
  protected ArrayList<zjn> a;
  protected zjm a;
  
  public zjl(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = xiz.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = zjn.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        zjn localzjn = (zjn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localzjn.jdField_a_of_type_Boolean) && (!localArrayList.contains(localzjn.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localzjn.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(zjm paramzjm)
  {
    this.jdField_a_of_type_Zjm = paramzjm;
  }
  
  public void a(zjn paramzjn)
  {
    if ((this.jdField_a_of_type_Zjm == null) || (this.jdField_a_of_type_Zjm.a(a(), paramzjn))) {
      if (paramzjn.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramzjn.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Zjm != null) {
        this.jdField_a_of_type_Zjm.a(a());
      }
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
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
    zjn localzjn = (zjn)getItem(paramInt);
    TroopInfo localTroopInfo = localzjn.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    yqw localyqw;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localyqw = (yqw)paramView.getTag();
      localImageView = (ImageView)localyqw.a(2131367700);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(bhmq.f());
      label69:
      ((TextView)localyqw.a(2131367746)).setText(localTroopInfo.getTroopName());
      ((CheckBox)localyqw.a(2131364516)).setChecked(localzjn.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839440);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560671, null);
      localyqw = new yqw(paramView);
      paramView.setTag(localyqw);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839456);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839447);
      } else {
        paramView.setBackgroundResource(2130839450);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjl
 * JD-Core Version:    0.7.0.1
 */