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

public class wgh
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, wnd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<wnd> jdField_a_of_type_JavaUtilList = new ArrayList();
  wgl jdField_a_of_type_Wgl;
  wgm jdField_a_of_type_Wgm;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<wgi>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public wgh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = xsm.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = xsm.a(paramContext, 146.0F);
    this.c = xsm.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561574, paramViewGroup, false);
    paramViewGroup.setTag(new wgi(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (wgi)paramView.getTag();
    wnd localwnd = a(paramInt);
    paramView.a(localwnd, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localwnd.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      xsm.a(paramImageView, xsj.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, xsm.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public wnd a(int paramInt)
  {
    return (wnd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<wnd> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wnd localwnd = (wnd)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localwnd.jdField_a_of_type_JavaLangString, localwnd);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(wgl paramwgl)
  {
    this.jdField_a_of_type_Wgl = paramwgl;
  }
  
  public void a(wgm paramwgm)
  {
    this.jdField_a_of_type_Wgm = paramwgm;
  }
  
  public void b(List<wnd> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      wxe.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      wxe.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (wnd)paramList.next();
        paramString = (wnd)this.jdField_a_of_type_JavaUtilHashMap.get(((wnd)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((wnd)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((wgi)((WeakReference)localObject).get()).a;
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
    if (this.jdField_a_of_type_Wgm != null)
    {
      paramAdapterView = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Wgm.a(str, paramInt, paramView, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgh
 * JD-Core Version:    0.7.0.1
 */