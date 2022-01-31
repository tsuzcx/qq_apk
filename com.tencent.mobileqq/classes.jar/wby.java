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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wby
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, wiu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<wiu> jdField_a_of_type_JavaUtilList = new ArrayList();
  wcc jdField_a_of_type_Wcc;
  wcd jdField_a_of_type_Wcd;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<wbz>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public wby(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = xod.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = xod.a(paramContext, 146.0F);
    this.c = xod.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561556, paramViewGroup, false);
    paramViewGroup.setTag(new wbz(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (wbz)paramView.getTag();
    wiu localwiu = a(paramInt);
    paramView.a(localwiu, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localwiu.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      xod.a(paramImageView, xoa.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, xod.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public wiu a(int paramInt)
  {
    return (wiu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<wiu> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wiu localwiu = (wiu)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localwiu.jdField_a_of_type_JavaLangString, localwiu);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(wcc paramwcc)
  {
    this.jdField_a_of_type_Wcc = paramwcc;
  }
  
  public void a(wcd paramwcd)
  {
    this.jdField_a_of_type_Wcd = paramwcd;
  }
  
  public void b(List<wiu> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      wsv.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      wsv.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (wiu)paramList.next();
        paramString = (wiu)this.jdField_a_of_type_JavaUtilHashMap.get(((wiu)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((wiu)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((wbz)((WeakReference)localObject).get()).a;
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = a(paramViewGroup);
      localView.setFocusable(true);
    }
    a(localView, paramInt);
    return localView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Wcd != null)
    {
      paramAdapterView = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Wcd.a(str, paramInt, paramView, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wby
 * JD-Core Version:    0.7.0.1
 */