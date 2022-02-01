import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class alkb
  extends BaseAdapter
{
  private List<PhoneContact> EY;
  private Context mContext;
  
  public alkb(Context paramContext, List<PhoneContact> paramList)
  {
    this.mContext = paramContext;
    this.EY = paramList;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (alkb.a)paramView.getTag();
    PhoneContact localPhoneContact = (PhoneContact)this.EY.get(paramInt);
    paramInt = localPhoneContact.type;
    paramView = null;
    if (paramInt == 0) {
      paramView = localPhoneContact.label;
    }
    paramView = (String)ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), paramInt, paramView);
    paramViewGroup.Xy.setText(paramView);
    paramViewGroup.Xz.setText(localPhoneContact.mobileNo);
  }
  
  private View b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561252, null);
    alkb.a locala = new alkb.a(null);
    locala.Xy = ((TextView)paramViewGroup.findViewById(2131374869));
    locala.Xz = ((TextView)paramViewGroup.findViewById(2131374868));
    paramViewGroup.setTag(locala);
    return paramViewGroup;
  }
  
  public int getCount()
  {
    int i = this.EY.size();
    if (i > 20) {
      return 20;
    }
    return i;
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
    if (paramView == null) {}
    for (View localView = b(paramInt, paramViewGroup);; localView = paramView)
    {
      a(paramInt, localView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  static class a
  {
    public TextView Xy;
    public TextView Xz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkb
 * JD-Core Version:    0.7.0.1
 */