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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xtt
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, yap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<yap> jdField_a_of_type_JavaUtilList = new ArrayList();
  xtx jdField_a_of_type_Xtx;
  xty jdField_a_of_type_Xty;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<xtu>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public xtt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = UIUtils.dip2px(paramContext, 90.0F);
    this.jdField_b_of_type_Int = UIUtils.dip2px(paramContext, 146.0F);
    this.c = UIUtils.dip2px(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561796, paramViewGroup, false);
    paramViewGroup.setTag(new xtu(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (xtu)paramView.getTag();
    yap localyap = a(paramInt);
    paramView.a(localyap, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localyap.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      UIUtils.setRoundCornerViewByURL(paramImageView, zfe.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, UIUtils.roundDefaultIcon, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public yap a(int paramInt)
  {
    return (yap)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<yap> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      yap localyap = (yap)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localyap.jdField_a_of_type_JavaLangString, localyap);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(xtx paramxtx)
  {
    this.jdField_a_of_type_Xtx = paramxtx;
  }
  
  public void a(xty paramxty)
  {
    this.jdField_a_of_type_Xty = paramxty;
  }
  
  public void b(List<yap> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      ykq.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      ykq.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (yap)paramList.next();
        paramString = (yap)this.jdField_a_of_type_JavaUtilHashMap.get(((yap)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((yap)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((xtu)((WeakReference)localObject).get()).a;
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
    if (this.jdField_a_of_type_Xty != null)
    {
      yap localyap = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Xty.a(str, paramInt, paramView, localyap);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtt
 * JD-Core Version:    0.7.0.1
 */