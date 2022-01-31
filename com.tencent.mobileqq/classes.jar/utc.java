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

public class utc
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<uxf> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public utc(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = vct.a(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = vct.a(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public uxf a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (uxf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<uxf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    uxf localuxf = new uxf();
    this.jdField_a_of_type_JavaUtilList.add(localuxf);
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
      paramViewGroup = new utd(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493624, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131311430));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131310052);
      localView1.setTag(paramViewGroup);
    }
    uxf localuxf;
    for (;;)
    {
      localuxf = a(paramInt);
      if (localuxf != null) {
        break;
      }
      return localView1;
      paramViewGroup = (utd)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localuxf.jdField_a_of_type_Int + localuxf.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label249;
      }
      paramView = azvq.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130840980, this.b, this.jdField_a_of_type_Int);
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localuxf.jdField_a_of_type_Int + localuxf.b, paramView);
        localView2 = paramView;
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131637999));
    }
    for (;;)
    {
      if (paramInt != this.c) {
        break label305;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView1;
      label249:
      paramView = azvq.a(localuxf.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131638148) + localuxf.c);
    }
    label305:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */