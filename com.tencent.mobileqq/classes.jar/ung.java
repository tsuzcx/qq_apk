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

public class ung
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public String a;
  HashMap<String, uuc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<uuc> jdField_a_of_type_JavaUtilList = new ArrayList();
  unk jdField_a_of_type_Unk;
  unl jdField_a_of_type_Unl;
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<unh>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public ung(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = vzl.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = vzl.a(paramContext, 146.0F);
    this.c = vzl.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561366, paramViewGroup, false);
    paramViewGroup.setTag(new unh(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (unh)paramView.getTag();
    uuc localuuc = a(paramInt);
    paramView.a(localuuc, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localuuc.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      vzl.a(paramImageView, vzi.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, vzl.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public uuc a(int paramInt)
  {
    return (uuc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<uuc> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uuc localuuc = (uuc)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localuuc.jdField_a_of_type_JavaLangString, localuuc);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(unk paramunk)
  {
    this.jdField_a_of_type_Unk = paramunk;
  }
  
  public void a(unl paramunl)
  {
    this.jdField_a_of_type_Unl = paramunl;
  }
  
  public void b(List<uuc> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      ved.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
    }
    for (;;)
    {
      return;
      ved.a("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (uuc)paramList.next();
        paramString = (uuc)this.jdField_a_of_type_JavaUtilHashMap.get(((uuc)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((uuc)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((unh)((WeakReference)localObject).get()).a;
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
    if (this.jdField_a_of_type_Unl != null)
    {
      paramAdapterView = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_Unl.a(str, paramInt, paramView, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ung
 * JD-Core Version:    0.7.0.1
 */