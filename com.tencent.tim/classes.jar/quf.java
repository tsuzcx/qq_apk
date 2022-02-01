import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.b;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class quf
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private MyMemoriesListView.b jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b;
  private quf.a jdField_a_of_type_Quf$a;
  private qwh jdField_a_of_type_Qwh;
  public String avR;
  QQUserUIItem f;
  private HashMap<String, VideoCollectionItem.b> fr = new HashMap();
  private HashMap<String, WeakReference<qyd>> fs = new HashMap();
  private Context mContext;
  public String mUid;
  private List<VideoCollectionItem.b> mVideoList = new ArrayList();
  
  public quf(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Qwh = new qwh(8, 0, 1.6F, rpq.fy, null);
    this.f = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
  }
  
  private void a(qyd paramqyd, int paramInt)
  {
    ram.v("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      StoryCoverView localStoryCoverView = (StoryCoverView)paramqyd.get(2131381830);
      if (((VideoCollectionItem.b)localObject).l == null)
      {
        localStoryCoverView.mImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130847483));
        localStoryCoverView.setPollLayout(null, -1, null);
        localStoryCoverView.setRateLayout(null, -1, -1L, -1);
      }
      for (;;)
      {
        this.fs.put(((VideoCollectionItem.b)localObject).mVid, new WeakReference(paramqyd));
        localStoryCoverView.setContentDescription(plr.asY + " " + (paramInt + 1));
        return;
        if (((VideoCollectionItem.b)localObject).l.mVideoThumbnailUrl != null)
        {
          d(localStoryCoverView.mImageView, ((VideoCollectionItem.b)localObject).l.mVideoThumbnailUrl);
          localStoryCoverView.setPollLayout(((VideoCollectionItem.b)localObject).l.getPollLayout(), -1, null);
          localStoryCoverView.setRateLayout(((VideoCollectionItem.b)localObject).l.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
    Object localObject = (ImageView)paramqyd.get(2131373814);
    paramqyd = (ImageView)paramqyd.get(2131373800);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.c()))
    {
      paramqyd.setBackgroundResource(2130847484);
      ((ImageView)localObject).setImageResource(2130847488);
    }
    for (;;)
    {
      ((ImageView)localObject).setContentDescription(acfp.m(2131708102));
      return;
      paramqyd.setBackgroundResource(2130847483);
      ((ImageView)localObject).setImageResource(2130847487);
    }
  }
  
  private View d(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561888, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561889, paramViewGroup, false);
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    paramString = rpn.gm(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      rpq.a(paramImageView, paramString, 80, 128, 4, rpq.dl, "QQStoryMemory");
    }
  }
  
  public VideoCollectionItem.b a(int paramInt)
  {
    if (paramInt < this.mVideoList.size()) {
      return (VideoCollectionItem.b)this.mVideoList.get(paramInt);
    }
    ram.b("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.mVideoList.size()));
    return null;
  }
  
  public void a(quf.a parama)
  {
    this.jdField_a_of_type_Quf$a = parama;
  }
  
  public void b(MyMemoriesListView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b = paramb;
  }
  
  public int getCount()
  {
    if (this.mVideoList != null) {
      return this.mVideoList.size();
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
      if ((a(paramInt) instanceof quf.b)) {
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
      localView = d(paramInt, paramViewGroup);
      localView.setFocusable(true);
    }
    qyd localqyd;
    for (paramView = new qyd(localView);; paramView = localqyd)
    {
      a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localqyd = (qyd)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VideoCollectionItem.b localb = a(paramInt);
    if (localb == null) {}
    label130:
    label151:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (getItemViewType(paramInt) == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b.bpB();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b != null)
        {
          if (getItemViewType(0) != 0) {
            break label130;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b.a(this.avR, paramInt - 1, paramView, localb.mVid);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Quf$a == null) {
            break label151;
          }
          String str = VideoCollectionEntry.getCollectionKey(1, this.avR, this.mUid);
          this.jdField_a_of_type_Quf$a.b(str, paramInt, paramView, localb.mVid);
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b.a(this.avR, paramInt, paramView, localb.mVid);
        }
      }
    }
  }
  
  public void p(List<VideoCollectionItem.b> paramList, String paramString)
  {
    if (!this.avR.equals(paramString)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (VideoCollectionItem.b)paramList.next();
        paramString = (VideoCollectionItem.b)this.fr.get(((VideoCollectionItem.b)localObject).mVid);
        if ((paramString == null) || (((VideoCollectionItem.b)localObject).l == null))
        {
          ram.w("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
        }
        else
        {
          paramString.l = ((VideoCollectionItem.b)localObject).l;
          localObject = (WeakReference)this.fs.get(((VideoCollectionItem.b)localObject).mVid);
          if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
            d(((StoryCoverView)((qyd)((WeakReference)localObject).get()).get(2131381830)).mImageView, paramString.l.mVideoThumbnailUrl);
          }
        }
      }
    }
  }
  
  public void setData(List<VideoCollectionItem.b> paramList, String paramString)
  {
    this.mVideoList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem.b localb = (VideoCollectionItem.b)paramList.next();
      this.fr.put(localb.mVid, localb);
    }
    this.avR = paramString;
    super.notifyDataSetChanged();
  }
  
  public void setUid(String paramString)
  {
    this.mUid = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString1, int paramInt, View paramView, String paramString2);
  }
  
  public static class b
    extends VideoCollectionItem.b
  {
    public b()
    {
      super(null);
    }
    
    public static boolean a(VideoCollectionItem.b paramb)
    {
      return TextUtils.equals("memory_publish", paramb.mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quf
 * JD-Core Version:    0.7.0.1
 */