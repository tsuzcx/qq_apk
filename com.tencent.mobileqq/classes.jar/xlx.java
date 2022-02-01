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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xlx
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, xlu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<xlu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xdy jdField_a_of_type_Xdy;
  private xly jdField_a_of_type_Xly;
  private xpn jdField_a_of_type_Xpn;
  public String b;
  private HashMap<String, WeakReference<xsh>> b;
  
  public xlx(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Xpn = new xpn(8, 0, 1.6F, UIUtils.RecycleBitmapMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((vvj)vux.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561649, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561650, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = yql.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      UIUtils.setRoundCornerViewByURL(paramImageView, paramString, 80, 128, 4, UIUtils.roundDefaultIcon, "QQStoryMemory");
    }
  }
  
  private void a(xsh paramxsh, int paramInt)
  {
    xvv.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramxsh.a(2131380703);
      if (((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846526));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((xlu)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramxsh));
        localStoryCoverView.setContentDescription(vkm.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramxsh.a(2131373147);
    paramxsh = (ImageView)paramxsh.a(2131373136);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramxsh.setBackgroundResource(2130846527);
      ((ImageView)localObject).setImageResource(2130846531);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(amtj.a(2131705647));
      return;
      paramxsh.setBackgroundResource(2130846526);
      ((ImageView)localObject).setImageResource(2130846530);
    }
  }
  
  public xlu a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (xlu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    xvv.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(List<xlu> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xlu localxlu = (xlu)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localxlu.jdField_a_of_type_JavaLangString, localxlu);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void a(xdy paramxdy)
  {
    this.jdField_a_of_type_Xdy = paramxdy;
  }
  
  public void a(xly paramxly)
  {
    this.jdField_a_of_type_Xly = paramxly;
  }
  
  public void b(List<xlu> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (xlu)paramList.next();
        paramString = (xlu)this.jdField_a_of_type_JavaUtilHashMap.get(((xlu)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          xvv.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((xlu)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((xlu)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((xsh)((WeakReference)localObject).get()).a(2131380703)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof xlz)) {
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
    xsh localxsh;
    for (paramView = new xsh(localView);; paramView = localxsh)
    {
      a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localxsh = (xsh)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    xlu localxlu = a(paramInt);
    if (localxlu == null) {}
    label130:
    label151:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (getItemViewType(paramInt) == 0)
      {
        if (this.jdField_a_of_type_Xdy != null) {
          this.jdField_a_of_type_Xdy.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Xdy != null)
        {
          if (getItemViewType(0) != 0) {
            break label130;
          }
          this.jdField_a_of_type_Xdy.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, localxlu.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Xly == null) {
            break label151;
          }
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Xly.a(str, paramInt, paramView, localxlu.jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_Xdy.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, localxlu.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */