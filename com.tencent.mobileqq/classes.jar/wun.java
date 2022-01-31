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

public class wun
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<wyq> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public wun(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = xee.b(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = xee.b(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public wyq a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (wyq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<wyq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    wyq localwyq = new wyq();
    this.jdField_a_of_type_JavaUtilList.add(localwyq);
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
      paramViewGroup = new wuo(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559236, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131377768));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131376317);
      localView1.setTag(paramViewGroup);
    }
    wyq localwyq;
    for (;;)
    {
      localwyq = a(paramInt);
      if (localwyq != null) {
        break;
      }
      return localView1;
      paramViewGroup = (wuo)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localwyq.jdField_a_of_type_Int + localwyq.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label249;
      }
      paramView = bcwc.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841173, this.b, this.jdField_a_of_type_Int);
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localwyq.jdField_a_of_type_Int + localwyq.b, paramView);
        localView2 = paramView;
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131704167));
    }
    for (;;)
    {
      if (paramInt != this.c) {
        break label305;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView1;
      label249:
      paramView = bcwc.a(localwyq.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131704316) + localwyq.c);
    }
    label305:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */