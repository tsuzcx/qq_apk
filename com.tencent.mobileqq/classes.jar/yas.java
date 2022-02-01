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

public class yas
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, yap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<yap> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xst jdField_a_of_type_Xst;
  private yat jdField_a_of_type_Yat;
  private yei jdField_a_of_type_Yei;
  public String b;
  private HashMap<String, WeakReference<yhc>> b;
  
  public yas(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Yei = new yei(8, 0, 1.6F, UIUtils.RecycleBitmapMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561717, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561718, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = zfe.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      UIUtils.setRoundCornerViewByURL(paramImageView, paramString, 80, 128, 4, UIUtils.roundDefaultIcon, "QQStoryMemory");
    }
  }
  
  private void a(yhc paramyhc, int paramInt)
  {
    ykq.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramyhc.a(2131381055);
      if (((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846622));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((yap)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramyhc));
        localStoryCoverView.setContentDescription(vzh.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramyhc.a(2131373358);
    paramyhc = (ImageView)paramyhc.a(2131373347);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramyhc.setBackgroundResource(2130846623);
      ((ImageView)localObject).setImageResource(2130846627);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(anvx.a(2131705998));
      return;
      paramyhc.setBackgroundResource(2130846622);
      ((ImageView)localObject).setImageResource(2130846626);
    }
  }
  
  public yap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (yap)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    ykq.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(xst paramxst)
  {
    this.jdField_a_of_type_Xst = paramxst;
  }
  
  public void a(yat paramyat)
  {
    this.jdField_a_of_type_Yat = paramyat;
  }
  
  public void b(List<yap> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (yap)paramList.next();
        paramString = (yap)this.jdField_a_of_type_JavaUtilHashMap.get(((yap)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          ykq.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((yap)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((yap)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((yhc)((WeakReference)localObject).get()).a(2131381055)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof yau)) {
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
    yhc localyhc;
    for (paramView = new yhc(localView);; paramView = localyhc)
    {
      a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localyhc = (yhc)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    yap localyap = a(paramInt);
    if (localyap == null) {}
    label130:
    label151:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (getItemViewType(paramInt) == 0)
      {
        if (this.jdField_a_of_type_Xst != null) {
          this.jdField_a_of_type_Xst.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Xst != null)
        {
          if (getItemViewType(0) != 0) {
            break label130;
          }
          this.jdField_a_of_type_Xst.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, localyap.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Yat == null) {
            break label151;
          }
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Yat.a(str, paramInt, paramView, localyap.jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_Xst.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, localyap.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yas
 * JD-Core Version:    0.7.0.1
 */