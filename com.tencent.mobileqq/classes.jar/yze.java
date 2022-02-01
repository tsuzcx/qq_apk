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

public class yze
  extends BaseAdapter
{
  protected Context a;
  protected QQAppInterface a;
  protected ArrayList<yzg> a;
  protected yzf a;
  
  public yze(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = wzk.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = yzg.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        yzg localyzg = (yzg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localyzg.jdField_a_of_type_Boolean) && (!localArrayList.contains(localyzg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
          localArrayList.add(localyzg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(yzf paramyzf)
  {
    this.jdField_a_of_type_Yzf = paramyzf;
  }
  
  public void a(yzg paramyzg)
  {
    if ((this.jdField_a_of_type_Yzf == null) || (this.jdField_a_of_type_Yzf.a(a(), paramyzg))) {
      if (paramyzg.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramyzg.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Yzf != null) {
        this.jdField_a_of_type_Yzf.a(a());
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
    yzg localyzg = (yzg)getItem(paramInt);
    TroopInfo localTroopInfo = localyzg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    yhc localyhc;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localyhc = (yhc)paramView.getTag();
      localImageView = (ImageView)localyhc.a(2131367868);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(bheg.f());
      label69:
      ((TextView)localyhc.a(2131367915)).setText(localTroopInfo.getTroopName());
      ((CheckBox)localyhc.a(2131364617)).setChecked(localyzg.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839496);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560735, null);
      localyhc = new yhc(paramView);
      paramView.setTag(localyhc);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839512);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839503);
      } else {
        paramView.setBackgroundResource(2130839506);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yze
 * JD-Core Version:    0.7.0.1
 */