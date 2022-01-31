import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.addContactTroopView.BaseTroopCardView;
import com.tencent.biz.addContactTroopView.TroopCardGroup;
import com.tencent.biz.addContactTroopView.TroopCardSameCity;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;

public class wge
  extends BaseAdapter
{
  public List a;
  private List b;
  
  private wge(TroopView paramTroopView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopCardView localBaseTroopCardView = (BaseTroopCardView)localIterator.next();
      try
      {
        localBaseTroopCardView.e();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((searchtab.Card)this.b.get(paramInt)).type.get() - 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (searchtab.Card)this.b.get(paramInt);
    if (paramView == null) {
      if (1 == paramViewGroup.type.get())
      {
        paramView = new TroopCardGroup(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.a);
        paramView.a();
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilList.add((BaseTroopCardView)paramView);
        ((BaseTroopCardView)paramView).a(paramViewGroup);
        return paramView;
        if (2 == paramViewGroup.type.get())
        {
          paramView = new TroopCardSameCity(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.a);
          paramView.a();
        }
        else
        {
          paramView = new TroopCardXingquBuluo(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.a);
          paramView.a();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wge
 * JD-Core Version:    0.7.0.1
 */