import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xzs
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, ygo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<ygo> jdField_a_of_type_JavaUtilList = new ArrayList();
  xzw jdField_a_of_type_Xzw;
  xzx jdField_a_of_type_Xzx;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<xzt>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public xzs(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = zlx.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = zlx.a(paramContext, 146.0F);
    this.c = zlx.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561809, paramViewGroup, false);
    paramViewGroup.setTag(new xzt(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (xzt)paramView.getTag();
    ygo localygo = a(paramInt);
    paramView.a(localygo, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localygo.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      zlx.a(paramImageView, zlu.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, zlx.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public ygo a(int paramInt)
  {
    return (ygo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<ygo> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ygo localygo = (ygo)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localygo.jdField_a_of_type_JavaLangString, localygo);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(xzw paramxzw)
  {
    this.jdField_a_of_type_Xzw = paramxzw;
  }
  
  public void a(xzx paramxzx)
  {
    this.jdField_a_of_type_Xzx = paramxzx;
  }
  
  public void b(List<ygo> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      yqp.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      yqp.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ygo)paramList.next();
        paramString = (ygo)this.jdField_a_of_type_JavaUtilHashMap.get(((ygo)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((ygo)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((ygo)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((ygo)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((xzt)((WeakReference)localObject).get()).a;
            a(((StoryCoverView)localObject).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
            ((StoryCoverView)localObject).setPollLayout(paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
            ((StoryCoverView)localObject).setRateLayout(paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
          }
        }
      }
    }
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
    if (paramView == null)
    {
      paramView = a(paramViewGroup);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Xzx != null)
    {
      ygo localygo = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Xzx.a(str, paramInt, paramView, localygo);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzs
 * JD-Core Version:    0.7.0.1
 */