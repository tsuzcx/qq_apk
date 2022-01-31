import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;
import java.util.List;

public class vfv
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<vjy> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public vfv(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = vpm.b(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = vpm.b(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public vjy a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (vjy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<vjy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    vjy localvjy = new vjy();
    this.jdField_a_of_type_JavaUtilList.add(localvjy);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.c = 0;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView1;
    if (paramView == null)
    {
      paramViewGroup = new vfw(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559193, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131377245));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131375818);
      localView1.setTag(paramViewGroup);
    }
    vjy localvjy;
    for (;;)
    {
      localvjy = a(paramInt);
      if (localvjy != null) {
        break;
      }
      return localView1;
      paramViewGroup = (vfw)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localvjy.jdField_a_of_type_Int + localvjy.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label249;
      }
      paramView = baxi.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841054, this.b, this.jdField_a_of_type_Int);
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localvjy.jdField_a_of_type_Int + localvjy.b, paramView);
        localView2 = paramView;
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131703795));
    }
    for (;;)
    {
      if (paramInt != this.c) {
        break label305;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView1;
      label249:
      paramView = baxi.a(localvjy.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131703944) + localvjy.c);
    }
    label305:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */