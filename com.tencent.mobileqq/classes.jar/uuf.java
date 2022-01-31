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

public class uuf
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  public String a;
  private HashMap<String, uuc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<uuc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private umg jdField_a_of_type_Umg;
  private uug jdField_a_of_type_Uug;
  private uxv jdField_a_of_type_Uxv;
  public String b;
  private HashMap<String, WeakReference<vap>> b;
  
  public uuf(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uxv = new uxv(8, 0, 1.6F, vzl.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561287, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561288, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = vzi.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      vzl.a(paramImageView, paramString, 80, 128, 4, vzl.b, "QQStoryMemory");
    }
  }
  
  private void a(vap paramvap, int paramInt)
  {
    ved.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramvap.a(2131379104);
      if (((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        localStoryCoverView.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845710));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(((uuc)localObject).jdField_a_of_type_JavaLangString, new WeakReference(paramvap));
        localStoryCoverView.setContentDescription(ssf.jdField_a_of_type_JavaLangString + " " + (paramInt + 1));
        return;
        if (((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
        {
          a(localStoryCoverView.a, ((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramvap.a(2131372130);
    paramvap = (ImageView)paramvap.a(2131372119);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramvap.setBackgroundResource(2130845711);
      ((ImageView)localObject).setImageResource(2130845715);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(ajya.a(2131706535));
      return;
      paramvap.setBackgroundResource(2130845710);
      ((ImageView)localObject).setImageResource(2130845714);
    }
  }
  
  public uuc a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (uuc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    ved.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(umg paramumg)
  {
    this.jdField_a_of_type_Umg = paramumg;
  }
  
  public void a(uug paramuug)
  {
    this.jdField_a_of_type_Uug = paramuug;
  }
  
  public void b(List<uuc> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (uuc)paramList.next();
        paramString = (uuc)this.jdField_a_of_type_JavaUtilHashMap.get(((uuc)localObject).jdField_a_of_type_JavaLangString);
        if ((paramString == null) || (((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null))
        {
          ved.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uuc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((uuc)localObject).jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            a(((StoryCoverView)((vap)((WeakReference)localObject).get()).a(2131379104)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
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
      if ((a(paramInt) instanceof uuh)) {
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
    for (paramViewGroup = new vap(paramView);; paramViewGroup = (vap)paramView.getTag())
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
        if (this.jdField_a_of_type_Umg != null) {
          this.jdField_a_of_type_Umg.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Umg != null)
        {
          if (getItemViewType(0) != 0) {
            break label111;
          }
          this.jdField_a_of_type_Umg.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
        while (this.jdField_a_of_type_Uug != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Uug.a(str, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
          return;
          label111:
          this.jdField_a_of_type_Umg.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, paramAdapterView.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuf
 * JD-Core Version:    0.7.0.1
 */