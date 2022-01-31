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

public class wng
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, wnd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<wnd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wfh jdField_a_of_type_Wfh;
  private wnh jdField_a_of_type_Wnh;
  private wqw jdField_a_of_type_Wqw;
  public String b;
  private HashMap<String, WeakReference<wtq>> b;
  
  public wng(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Wqw = new wqw(8, 0, 1.6F, xsm.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((uwm)uwa.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561495, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561496, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = xsj.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      xsm.a(paramImageView, paramString, 80, 128, 4, xsm.b, "QQStoryMemory");
    }
  }
  
  private void a(wtq paramwtq, int paramInt)
  {
    wxe.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramwtq.a(2131379841);
      if (((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846162));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((wnd)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramwtq));
        localStoryCoverView.setContentDescription(ulg.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramwtq.a(2131372468);
    paramwtq = (ImageView)paramwtq.a(2131372457);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramwtq.setBackgroundResource(2130846163);
      ((ImageView)localObject).setImageResource(2130846167);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(alud.a(2131706919));
      return;
      paramwtq.setBackgroundResource(2130846162);
      ((ImageView)localObject).setImageResource(2130846166);
    }
  }
  
  public wnd a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (wnd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    wxe.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(wfh paramwfh)
  {
    this.jdField_a_of_type_Wfh = paramwfh;
  }
  
  public void a(wnh paramwnh)
  {
    this.jdField_a_of_type_Wnh = paramwnh;
  }
  
  public void b(List<wnd> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (wnd)paramList.next();
        paramString = (wnd)this.jdField_a_of_type_JavaUtilHashMap.get(((wnd)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          wxe.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wnd)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((wnd)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((wtq)((WeakReference)localObject).get()).a(2131379841)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof wni)) {
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
    for (paramViewGroup = new wtq(paramView);; paramViewGroup = (wtq)paramView.getTag())
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
        if (this.jdField_a_of_type_Wfh != null) {
          this.jdField_a_of_type_Wfh.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Wfh != null)
        {
          if (getItemViewType(0) != 0) {
            break label111;
          }
          this.jdField_a_of_type_Wfh.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
        while (this.jdField_a_of_type_Wnh != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Wnh.a(str, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
          return;
          label111:
          this.jdField_a_of_type_Wfh.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wng
 * JD-Core Version:    0.7.0.1
 */