import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import org.json.JSONArray;
import org.json.JSONException;

public class boo
  extends BaseAdapter
{
  public boo(EnterpriseDetailActivity paramEnterpriseDetailActivity, int paramInt1, JSONArray paramJSONArray, int paramInt2) {}
  
  public String a(int paramInt)
  {
    try
    {
      String str = this.jdField_a_of_type_OrgJsonJSONArray.getString(paramInt);
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public int getCount()
  {
    int i = 9;
    if (this.jdField_a_of_type_Int < 9) {
      i = this.jdField_a_of_type_Int;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AsyncImageView localAsyncImageView = new AsyncImageView(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity);
    localAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView = null;
    try
    {
      paramViewGroup = URLDrawable.getDrawable(this.jdField_a_of_type_OrgJsonJSONArray.getString(paramInt));
      paramView = paramViewGroup;
    }
    catch (JSONException paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
    }
    localAsyncImageView.setImageDrawable(paramView);
    localAsyncImageView.setLayoutParams(new AbsListView.LayoutParams(this.b, this.b));
    return localAsyncImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     boo
 * JD-Core Version:    0.7.0.1
 */