import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQServiceEntry;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import java.util.ArrayList;
import java.util.List;

public class fga
  extends BaseAdapter
{
  public fga(QQServiceEntry paramQQServiceEntry, int paramInt)
  {
    paramQQServiceEntry.jdField_a_of_type_JavaUtilList = new ArrayList();
    ffz[] arrayOfffz = QQServiceEntry.jdField_a_of_type_ArrayOfFfz;
    int j = arrayOfffz.length;
    int i = 0;
    while (i < j)
    {
      ffz localffz = arrayOfffz[i];
      if ((localffz.jdField_a_of_type_Int & paramInt) != 0) {
        paramQQServiceEntry.jdField_a_of_type_JavaUtilList.add(localffz);
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
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
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.a.getContext();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = ((LayoutInflater)((Context)localObject).getSystemService("layout_inflater")).inflate(2130903976, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-2, this.a.i + 4));
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131231292);
    paramView.setAdjustViewBounds(true);
    paramView.setImageDrawable(((Context)localObject).getResources().getDrawable(((ffz)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).b));
    localObject = paramView.getDrawable();
    if (!this.a.jdField_a_of_type_Boolean) {
      ((TextView)paramViewGroup.findViewById(2131231293)).setText(((ffz)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramView.setImageDrawable((Drawable)localObject);
      return paramViewGroup;
      ((Drawable)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_IN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fga
 * JD-Core Version:    0.7.0.1
 */