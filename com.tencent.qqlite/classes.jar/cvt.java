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

public class cvt
  extends BaseAdapter
{
  public cvt(QQServiceEntry paramQQServiceEntry, int paramInt)
  {
    paramQQServiceEntry.jdField_a_of_type_JavaUtilList = new ArrayList();
    cvs[] arrayOfcvs = QQServiceEntry.jdField_a_of_type_ArrayOfCvs;
    int j = arrayOfcvs.length;
    int i = 0;
    while (i < j)
    {
      cvs localcvs = arrayOfcvs[i];
      if ((localcvs.jdField_a_of_type_Int & paramInt) != 0) {
        paramQQServiceEntry.jdField_a_of_type_JavaUtilList.add(localcvs);
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
      paramViewGroup = ((LayoutInflater)((Context)localObject).getSystemService("layout_inflater")).inflate(2130903632, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-2, this.a.i + 4));
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131296759);
    paramView.setAdjustViewBounds(true);
    paramView.setImageDrawable(((Context)localObject).getResources().getDrawable(((cvs)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).b));
    localObject = paramView.getDrawable();
    if (!this.a.jdField_a_of_type_Boolean) {
      ((TextView)paramViewGroup.findViewById(2131296760)).setText(((cvs)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramView.setImageDrawable((Drawable)localObject);
      return paramViewGroup;
      ((Drawable)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_IN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvt
 * JD-Core Version:    0.7.0.1
 */