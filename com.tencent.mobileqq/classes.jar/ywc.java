import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ywc
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<zaf> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public ywc(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = zft.b(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = zft.b(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public zaf a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (zaf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<zaf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    zaf localzaf = new zaf();
    this.jdField_a_of_type_JavaUtilList.add(localzaf);
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
    ywd localywd;
    View localView1;
    if (paramView == null)
    {
      localywd = new ywd(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559316, null);
      localywd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131378824));
      localywd.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131377300);
      localView1.setTag(localywd);
    }
    zaf localzaf;
    for (;;)
    {
      localzaf = a(paramInt);
      if (localzaf != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localywd = (ywd)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localzaf.jdField_a_of_type_Int + localzaf.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label272;
      }
      paramView = bhgm.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841487, this.b, this.jdField_a_of_type_Int);
      label180:
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localzaf.jdField_a_of_type_Int + localzaf.b, paramView);
        localView2 = paramView;
      }
    }
    localywd.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0)
    {
      localywd.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702683));
      label252:
      if (paramInt != this.c) {
        break label329;
      }
      localywd.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      break;
      label272:
      paramView = bhgm.a(localzaf.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break label180;
      localywd.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702832) + localzaf.c);
      break label252;
      label329:
      localywd.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywc
 * JD-Core Version:    0.7.0.1
 */