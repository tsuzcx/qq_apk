import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class akjb
  extends BaseAdapter
  implements aqdf.a
{
  private List<akjj> DU = new ArrayList();
  private akig jdField_a_of_type_Akig;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private Context mContext;
  
  public akjb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Akig = new akig(paramQQAppInterface, paramContext);
    }
  }
  
  public void ca(List<akjj> paramList)
  {
    if (paramList != null)
    {
      this.DU.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.DU.size();
  }
  
  public List<akjj> getData()
  {
    return this.DU;
  }
  
  public Object getItem(int paramInt)
  {
    return this.DU.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Akig == null) {
      return -1;
    }
    return this.jdField_a_of_type_Akig.a((akjj)this.DU.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (this.jdField_a_of_type_Akig == null) {
      localView = null;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      akjj localakjj = (akjj)this.DU.get(paramInt);
      int i = this.jdField_a_of_type_Akig.a(localakjj);
      akhv localakhv = this.jdField_a_of_type_Akig.a(i);
      localView = paramView;
      if (localakhv != null)
      {
        localakhv.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        localView = localakhv.a(localakjj, this.mContext, paramView);
      }
      paramView = localView;
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Akig == null) {
      return 1;
    }
    return this.jdField_a_of_type_Akig.getItemCount();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void setData(List<akjj> paramList)
  {
    this.DU.clear();
    if (paramList != null) {
      this.DU.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void setNearbyPeopleCard(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjb
 * JD-Core Version:    0.7.0.1
 */