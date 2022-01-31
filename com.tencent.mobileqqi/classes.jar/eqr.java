import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class eqr
  extends BaseAdapter
{
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
  private Drawable.ConstantState jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public eqr(AlbumListActivity paramAlbumListActivity)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = paramAlbumListActivity.getResources().getDrawable(2130837803).getConstantState();
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    URL localURL;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListActivity.getLayoutInflater().inflate(2130903544, null);
      paramViewGroup = (TextView)localView;
      localObject = a(paramInt);
      paramViewGroup.setText(((QQAlbumInfo)localObject).name + String.format(" (%d)", new Object[] { Integer.valueOf(((QQAlbumInfo)localObject).imageCount) }));
      paramView = paramViewGroup.getCompoundDrawables()[0];
      localURL = AlbumUtil.a(((QQAlbumInfo)localObject).cover, 200);
      if ((paramView == null) || (!URLDrawable.class.isInstance(paramView))) {
        break label231;
      }
      localObject = (URLDrawable)paramView;
      paramView = (View)localObject;
      if (!localURL.equals(((URLDrawable)localObject).getURL())) {
        ((URLDrawable)localObject).cancelDownload(true);
      }
    }
    label231:
    for (paramView = null;; paramView = null)
    {
      if (paramView == null)
      {
        paramView = URLDrawable.getDrawable(localURL, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, null);
        paramView.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListActivity.c);
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListActivity.getResources());
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramViewGroup.setCompoundDrawables(paramView, null, (Drawable)localObject, null);
      }
      return localView;
      paramViewGroup = (TextView)paramView;
      localView = paramView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqr
 * JD-Core Version:    0.7.0.1
 */