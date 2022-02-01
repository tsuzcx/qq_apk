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

public class zfq
  extends BaseAdapter
{
  protected Context a;
  protected QQAppInterface a;
  protected ArrayList<zfs> a;
  protected zfr a;
  
  public zfq(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = xfe.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = zfs.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        zfs localzfs = (zfs)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localzfs.jdField_a_of_type_Boolean) && (!localArrayList.contains(localzfs.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localzfs.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(zfr paramzfr)
  {
    this.jdField_a_of_type_Zfr = paramzfr;
  }
  
  public void a(zfs paramzfs)
  {
    if ((this.jdField_a_of_type_Zfr == null) || (this.jdField_a_of_type_Zfr.a(a(), paramzfs))) {
      if (paramzfs.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramzfs.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Zfr != null) {
        this.jdField_a_of_type_Zfr.a(a());
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
    zfs localzfs = (zfs)getItem(paramInt);
    TroopInfo localTroopInfo = localzfs.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    ynb localynb;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localynb = (ynb)paramView.getTag();
      localImageView = (ImageView)localynb.a(2131367631);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(bgmo.f());
      label69:
      ((TextView)localynb.a(2131367677)).setText(localTroopInfo.getTroopName());
      ((CheckBox)localynb.a(2131364471)).setChecked(localzfs.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839432);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560656, null);
      localynb = new ynb(paramView);
      paramView.setTag(localynb);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839448);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839439);
      } else {
        paramView.setBackgroundResource(2130839442);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfq
 * JD-Core Version:    0.7.0.1
 */