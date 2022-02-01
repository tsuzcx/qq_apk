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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ykm
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, ykj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ykj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ycn jdField_a_of_type_Ycn;
  private ykn jdField_a_of_type_Ykn;
  private yoc jdField_a_of_type_Yoc;
  public String b;
  private HashMap<String, WeakReference<yqw>> b;
  
  public ykm(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Yoc = new yoc(8, 0, 1.6F, zps.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561771, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561772, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = zpp.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      zps.a(paramImageView, paramString, 80, 128, 4, zps.b, "QQStoryMemory");
    }
  }
  
  private void a(yqw paramyqw, int paramInt)
  {
    yuk.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramyqw.a(2131380977);
      if (((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846618));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((ykj)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramyqw));
        localStoryCoverView.setContentDescription(win.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramyqw.a(2131373181);
    paramyqw = (ImageView)paramyqw.a(2131373167);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramyqw.setBackgroundResource(2130846619);
      ((ImageView)localObject).setImageResource(2130846623);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(anzj.a(2131705417));
      return;
      paramyqw.setBackgroundResource(2130846618);
      ((ImageView)localObject).setImageResource(2130846622);
    }
  }
  
  public ykj a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ykj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    yuk.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(List<ykj> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ykj localykj = (ykj)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localykj.jdField_a_of_type_JavaLangString, localykj);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(ycn paramycn)
  {
    this.jdField_a_of_type_Ycn = paramycn;
  }
  
  public void a(ykn paramykn)
  {
    this.jdField_a_of_type_Ykn = paramykn;
  }
  
  public void b(List<ykj> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ykj)paramList.next();
        paramString = (ykj)this.jdField_a_of_type_JavaUtilHashMap.get(((ykj)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          yuk.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((ykj)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((ykj)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((yqw)((WeakReference)localObject).get()).a(2131380977)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof yko)) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = a(paramInt, paramViewGroup);
      localView.setFocusable(true);
    }
    yqw localyqw;
    for (paramView = new yqw(localView);; paramView = localyqw)
    {
      a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localyqw = (yqw)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ykj localykj = a(paramInt);
    if (localykj == null) {}
    label130:
    label151:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (getItemViewType(paramInt) == 0)
      {
        if (this.jdField_a_of_type_Ycn != null) {
          this.jdField_a_of_type_Ycn.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Ycn != null)
        {
          if (getItemViewType(0) != 0) {
            break label130;
          }
          this.jdField_a_of_type_Ycn.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, localykj.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Ykn == null) {
            break label151;
          }
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Ykn.a(str, paramInt, paramView, localykj.jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_Ycn.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, localykj.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykm
 * JD-Core Version:    0.7.0.1
 */