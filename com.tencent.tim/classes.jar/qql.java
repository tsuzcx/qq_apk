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
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.a;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.b;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qql
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  StoryPickerHorizontalListView.a jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$a;
  StoryPickerHorizontalListView.b jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b;
  public String avR;
  final int bnD;
  final int bnE;
  final int bnF;
  HashMap<String, VideoCollectionItem.b> fr = new HashMap();
  HashMap<String, WeakReference<qql.a>> fs = new HashMap();
  Context mContext;
  List<VideoCollectionItem.b> mVideoList = new ArrayList();
  
  public qql(Context paramContext)
  {
    this.mContext = paramContext;
    this.bnD = rpq.dip2px(paramContext, 90.0F);
    this.bnE = rpq.dip2px(paramContext, 146.0F);
    this.bnF = rpq.dip2px(paramContext, 4.0F);
  }
  
  private void O(View paramView, int paramInt)
  {
    paramView = (qql.a)paramView.getTag();
    VideoCollectionItem.b localb = a(paramInt);
    paramView.a(localb, paramInt);
    this.fs.put(localb.mVid, new WeakReference(paramView));
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561967, paramViewGroup, false);
    paramViewGroup.setTag(new qql.a(paramViewGroup));
    return paramViewGroup;
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      rpq.a(paramImageView, rpn.gm(paramString), this.bnD, this.bnE, this.bnF, rpq.dl, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public VideoCollectionItem.b a(int paramInt)
  {
    return (VideoCollectionItem.b)this.mVideoList.get(paramInt);
  }
  
  public void a(StoryPickerHorizontalListView.a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$a = parama;
  }
  
  public void a(StoryPickerHorizontalListView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b = paramb;
  }
  
  public int getCount()
  {
    return this.mVideoList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = a(paramViewGroup);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      O(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public void o(List<VideoCollectionItem.b> paramList, String paramString)
  {
    if (!this.avR.equals(paramString)) {
      ram.w("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.avR, paramString });
    }
    for (;;)
    {
      return;
      ram.v("StoryPickerHorizontalListAdapter", "updateData");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (VideoCollectionItem.b)paramList.next();
        paramString = (VideoCollectionItem.b)this.fr.get(((VideoCollectionItem.b)localObject).mVid);
        if ((paramString != null) && (((VideoCollectionItem.b)localObject).l != null))
        {
          paramString.l = ((VideoCollectionItem.b)localObject).l;
          localObject = (WeakReference)this.fs.get(((VideoCollectionItem.b)localObject).mVid);
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = ((qql.a)((WeakReference)localObject).get()).a;
            d(((StoryCoverView)localObject).mImageView, paramString.l.mVideoThumbnailUrl);
            ((StoryCoverView)localObject).setPollLayout(paramString.l.getPollLayout(), -1, null);
            ((StoryCoverView)localObject).setRateLayout(paramString.l.getInteractLayout(), -1, -1L, -1);
          }
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b != null)
    {
      VideoCollectionItem.b localb = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.avR, QQStoryContext.a().getCurrentUid());
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b.a(str, paramInt, paramView, localb);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
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
  
  public class a
  {
    public StoryCoverView a;
    public ImageView mV;
    
    public a(View paramView)
    {
      this.mV = ((ImageView)paramView.findViewById(2131364372));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131381830));
    }
    
    void a(VideoCollectionItem.b paramb, int paramInt)
    {
      if (paramb.l == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_Qql.mContext.getResources().getDrawable(2130847483));
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
        this.mV.setTag(Integer.valueOf(paramInt));
        ImageView localImageView = this.mV;
        if (!paramb.checked) {
          break label186;
        }
        paramInt = 2130841267;
        label78:
        localImageView.setImageResource(paramInt);
        if (!paramb.aFx) {
          break label192;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
      }
      for (;;)
      {
        this.mV.setOnClickListener(new qqm(this));
        return;
        if (TextUtils.isEmpty(paramb.l.mVideoThumbnailUrl)) {
          break;
        }
        qql.a(this.jdField_a_of_type_Qql, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.mImageView, paramb.l.mVideoThumbnailUrl);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramb.l.getPollLayout(), -1, null);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramb.l.getInteractLayout(), -1, -1L, -1);
        break;
        label186:
        paramInt = 2130841263;
        break label78;
        label192:
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qql
 * JD-Core Version:    0.7.0.1
 */