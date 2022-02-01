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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ykl
  extends BaseAdapter
{
  protected Context a;
  protected QQAppInterface a;
  protected ArrayList<ykn> a;
  protected ykm a;
  
  public ykl(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = wkp.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = ykn.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ykn localykn = (ykn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localykn.jdField_a_of_type_Boolean) && (!localArrayList.contains(localykn.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
          localArrayList.add(localykn.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(ykm paramykm)
  {
    this.jdField_a_of_type_Ykm = paramykm;
  }
  
  public void a(ykn paramykn)
  {
    if ((this.jdField_a_of_type_Ykm == null) || (this.jdField_a_of_type_Ykm.a(a(), paramykn))) {
      if (paramykn.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramykn.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ykm != null) {
        this.jdField_a_of_type_Ykm.a(a());
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
    ykn localykn = (ykn)getItem(paramInt);
    TroopInfo localTroopInfo = localykn.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    xsh localxsh;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localxsh = (xsh)paramView.getTag();
      localImageView = (ImageView)localxsh.a(2131367732);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(bfvo.f());
      label69:
      ((TextView)localxsh.a(2131367778)).setText(localTroopInfo.getTroopName());
      ((CheckBox)localxsh.a(2131364535)).setChecked(localykn.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839475);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560682, null);
      localxsh = new xsh(paramView);
      paramView.setTag(localxsh);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839491);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839482);
      } else {
        paramView.setBackgroundResource(2130839485);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykl
 * JD-Core Version:    0.7.0.1
 */