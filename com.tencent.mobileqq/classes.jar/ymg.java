import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ymg
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<yqh> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public ymg(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public yqh a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (yqh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<yqh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    yqh localyqh = new yqh();
    this.jdField_a_of_type_JavaUtilList.add(localyqh);
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
    ymh localymh;
    View localView1;
    if (paramView == null)
    {
      localymh = new ymh(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559368, null);
      localymh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131378882));
      localymh.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131377325);
      localView1.setTag(localymh);
    }
    yqh localyqh;
    for (;;)
    {
      localyqh = a(paramInt);
      if (localyqh != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localymh = (ymh)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localyqh.jdField_a_of_type_Int + localyqh.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label272;
      }
      paramView = bgyo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841530, this.b, this.jdField_a_of_type_Int);
      label180:
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localyqh.jdField_a_of_type_Int + localyqh.b, paramView);
        localView2 = paramView;
      }
    }
    localymh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0)
    {
      localymh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131703269));
      label252:
      if (paramInt != this.c) {
        break label329;
      }
      localymh.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      break;
      label272:
      paramView = bgyo.a(localyqh.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break label180;
      localymh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131703413) + localyqh.c);
      break label252;
      label329:
      localymh.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */