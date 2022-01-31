import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wix
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, wiu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<wiu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private way jdField_a_of_type_Way;
  private wiy jdField_a_of_type_Wiy;
  private wmn jdField_a_of_type_Wmn;
  public String b;
  private HashMap<String, WeakReference<wph>> b;
  
  public wix(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Wmn = new wmn(8, 0, 1.6F, xod.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((usd)urr.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561477, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561478, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = xoa.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      xod.a(paramImageView, paramString, 80, 128, 4, xod.b, "QQStoryMemory");
    }
  }
  
  private void a(wph paramwph, int paramInt)
  {
    wsv.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramwph.a(2131379783);
      if (((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846089));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((wiu)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramwph));
        localStoryCoverView.setContentDescription(ugx.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramwph.a(2131372448);
    paramwph = (ImageView)paramwph.a(2131372437);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramwph.setBackgroundResource(2130846090);
      ((ImageView)localObject).setImageResource(2130846094);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(alpo.a(2131706907));
      return;
      paramwph.setBackgroundResource(2130846089);
      ((ImageView)localObject).setImageResource(2130846093);
    }
  }
  
  public wiu a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (wiu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    wsv.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(way paramway)
  {
    this.jdField_a_of_type_Way = paramway;
  }
  
  public void a(wiy paramwiy)
  {
    this.jdField_a_of_type_Wiy = paramwiy;
  }
  
  public void b(List<wiu> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (wiu)paramList.next();
        paramString = (wiu)this.jdField_a_of_type_JavaUtilHashMap.get(((wiu)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          wsv.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wiu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((wiu)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((wph)((WeakReference)localObject).get()).a(2131379783)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      if ((a(paramInt) instanceof wiz)) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = a(paramInt, paramViewGroup);
      paramView.setFocusable(true);
    }
    for (paramViewGroup = new wph(paramView);; paramViewGroup = (wph)paramView.getTag())
    {
      a(paramViewGroup, paramInt);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(paramInt);
    if (paramAdapterView == null) {}
    for (;;)
    {
      return;
      if (getItemViewType(paramInt) == 0)
      {
        if (this.jdField_a_of_type_Way != null) {
          this.jdField_a_of_type_Way.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Way != null)
        {
          if (getItemViewType(0) != 0) {
            break label111;
          }
          this.jdField_a_of_type_Way.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
        while (this.jdField_a_of_type_Wiy != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Wiy.a(str, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
          return;
          label111:
          this.jdField_a_of_type_Way.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wix
 * JD-Core Version:    0.7.0.1
 */