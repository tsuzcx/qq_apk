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

public class unj
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, uuf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<uuf> jdField_a_of_type_JavaUtilList = new ArrayList();
  unn jdField_a_of_type_Unn;
  uno jdField_a_of_type_Uno;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<unk>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public unj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = vzo.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = vzo.a(paramContext, 146.0F);
    this.c = vzo.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561367, paramViewGroup, false);
    paramViewGroup.setTag(new unk(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (unk)paramView.getTag();
    uuf localuuf = a(paramInt);
    paramView.a(localuuf, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localuuf.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      vzo.a(paramImageView, vzl.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, vzo.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public uuf a(int paramInt)
  {
    return (uuf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<uuf> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uuf localuuf = (uuf)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localuuf.jdField_a_of_type_JavaLangString, localuuf);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(unn paramunn)
  {
    this.jdField_a_of_type_Unn = paramunn;
  }
  
  public void a(uno paramuno)
  {
    this.jdField_a_of_type_Uno = paramuno;
  }
  
  public void b(List<uuf> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      veg.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      veg.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (uuf)paramList.next();
        paramString = (uuf)this.jdField_a_of_type_JavaUtilHashMap.get(((uuf)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((uuf)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((unk)((WeakReference)localObject).get()).a;
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
    if (this.jdField_a_of_type_Uno != null)
    {
      paramAdapterView = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Uno.a(str, paramInt, paramView, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unj
 * JD-Core Version:    0.7.0.1
 */