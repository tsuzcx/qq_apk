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

public class uan
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, uhj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<uhj> jdField_a_of_type_JavaUtilList = new ArrayList();
  uar jdField_a_of_type_Uar;
  uas jdField_a_of_type_Uas;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<uao>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public uan(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = vms.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = vms.a(paramContext, 146.0F);
    this.c = vms.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495776, paramViewGroup, false);
    paramViewGroup.setTag(new uao(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (uao)paramView.getTag();
    uhj localuhj = a(paramInt);
    paramView.a(localuhj, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localuhj.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      vms.a(paramImageView, vmp.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, vms.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public uhj a(int paramInt)
  {
    return (uhj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<uhj> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uhj localuhj = (uhj)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localuhj.jdField_a_of_type_JavaLangString, localuhj);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(uar paramuar)
  {
    this.jdField_a_of_type_Uar = paramuar;
  }
  
  public void a(uas paramuas)
  {
    this.jdField_a_of_type_Uas = paramuas;
  }
  
  public void b(List<uhj> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      urk.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      urk.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (uhj)paramList.next();
        paramString = (uhj)this.jdField_a_of_type_JavaUtilHashMap.get(((uhj)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((uhj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uhj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((uhj)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((uao)((WeakReference)localObject).get()).a;
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
    if (this.jdField_a_of_type_Uas != null)
    {
      paramAdapterView = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Uas.a(str, paramInt, paramView, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uan
 * JD-Core Version:    0.7.0.1
 */