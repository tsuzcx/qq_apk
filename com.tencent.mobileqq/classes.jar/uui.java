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

public class uui
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, uuf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<uuf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private umj jdField_a_of_type_Umj;
  private uuj jdField_a_of_type_Uuj;
  private uxy jdField_a_of_type_Uxy;
  public String b;
  private HashMap<String, WeakReference<vas>> b;
  
  public uui(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uxy = new uxy(8, 0, 1.6F, vzo.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdo)tdc.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561288, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561289, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = vzl.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      vzo.a(paramImageView, paramString, 80, 128, 4, vzo.b, "QQStoryMemory");
    }
  }
  
  private void a(vas paramvas, int paramInt)
  {
    veg.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramvas.a(2131379099);
      if (((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845704));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((uuf)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramvas));
        localStoryCoverView.setContentDescription(ssi.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramvas.a(2131372130);
    paramvas = (ImageView)paramvas.a(2131372119);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramvas.setBackgroundResource(2130845705);
      ((ImageView)localObject).setImageResource(2130845709);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(ajyc.a(2131706524));
      return;
      paramvas.setBackgroundResource(2130845704);
      ((ImageView)localObject).setImageResource(2130845708);
    }
  }
  
  public uuf a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (uuf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    veg.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(umj paramumj)
  {
    this.jdField_a_of_type_Umj = paramumj;
  }
  
  public void a(uuj paramuuj)
  {
    this.jdField_a_of_type_Uuj = paramuuj;
  }
  
  public void b(List<uuf> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (uuf)paramList.next();
        paramString = (uuf)this.jdField_a_of_type_JavaUtilHashMap.get(((uuf)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          veg.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uuf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((uuf)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((vas)((WeakReference)localObject).get()).a(2131379099)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof uuk)) {
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
    for (paramViewGroup = new vas(paramView);; paramViewGroup = (vas)paramView.getTag())
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
        if (this.jdField_a_of_type_Umj != null) {
          this.jdField_a_of_type_Umj.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Umj != null)
        {
          if (getItemViewType(0) != 0) {
            break label111;
          }
          this.jdField_a_of_type_Umj.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
        while (this.jdField_a_of_type_Uuj != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Uuj.a(str, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
          return;
          label111:
          this.jdField_a_of_type_Umj.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */