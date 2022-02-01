import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.b;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView.b;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qqa
  extends qpx
  implements ppe
{
  ShareGroupsListView.b a;
  public ShareGroupItem a;
  protected boolean aEI;
  protected boolean aEK;
  public HashMap<String, WeakReference<qqa.b>> fp = new HashMap();
  public List<HotSortVideoEntry> ob = new ArrayList();
  
  public qqa(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.aEI = paramBoolean;
  }
  
  private static void a(ImageView paramImageView, int paramInt, String paramString)
  {
    if (paramImageView == null) {
      ram.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "update imageView error. imageView is null.");
    }
    do
    {
      return;
      paramImageView.setVisibility(paramInt);
    } while (paramInt != 0);
    rpq.b(paramImageView, rpn.gm(paramString), 80, 80, null, "StoryDiscoverHeadImage");
  }
  
  private void ex(List<HotSortVideoEntry> paramList)
  {
    if (paramList.isEmpty()) {}
    do
    {
      int i;
      int k;
      do
      {
        return;
        if (this.aEK)
        {
          localVideoCollectionItem = (VideoCollectionItem)this.ne.get(this.ne.size() - 1);
          if (localVideoCollectionItem.collectionType == 7)
          {
            localVideoCollectionItem.hotSortVideoLIst.set(1, paramList.get(0));
            paramList.remove(0);
            this.aEK = false;
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "[hotlist]填了一个坑");
            }
          }
        }
        int m = paramList.size() / 2;
        if (paramList.size() % 2 == 1) {}
        for (i = 1;; i = 0)
        {
          int j = 0;
          k = 0;
          while (j < m)
          {
            localVideoCollectionItem = new VideoCollectionItem();
            localVideoCollectionItem.collectionType = 7;
            localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(j), "0_xx");
            localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k));
            localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k + 1));
            k += 2;
            this.ne.add(localVideoCollectionItem);
            this.aEK = false;
            j += 1;
          }
        }
      } while ((paramList.size() <= 0) || (i == 0));
      VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.collectionType = 7;
      localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(k), "0_xx");
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k));
      localVideoCollectionItem.hotSortVideoLIst.add(null);
      this.ne.add(localVideoCollectionItem);
      this.aEK = true;
    } while (!QLog.isColorLevel());
    QLog.i("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "[hotlist]又挖了一个坑");
  }
  
  public void G(List<HotSortVideoEntry> paramList, boolean paramBoolean)
  {
    this.aEI = true;
    clearData();
    this.ob = paramList;
    this.aEK = false;
    b(VideoCollectionItem.getProfilePlaceholderItem("hotsort"));
    b(VideoCollectionItem.getCurrentYearFakeItem("hotsort"));
    ex(paramList);
    notifyDataSetChanged();
  }
  
  public void H(List<HotSortVideoEntry> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty()) {
      return;
    }
    this.ob.addAll(paramList);
    ex(paramList);
    notifyDataSetChanged();
  }
  
  public boolean X(boolean paramBoolean)
  {
    return false;
  }
  
  public void a(ShareGroupsListView.b paramb)
  {
    super.a(paramb, paramb);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b = paramb;
  }
  
  public void b(HotSortVideoEntry paramHotSortVideoEntry)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.ob.size())
      {
        if (((HotSortVideoEntry)this.ob.get(i)).storyId.equals(paramHotSortVideoEntry.storyId)) {
          this.ob.set(i, paramHotSortVideoEntry);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  protected View d(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    paramInt = getItemViewType(paramInt);
    View localView = null;
    if (paramInt == 1)
    {
      localView = localLayoutInflater.inflate(2131561961, paramViewGroup, false);
      localView.setTag(new qqa.b(localView, this));
    }
    do
    {
      return localView;
      if (paramInt == 0)
      {
        paramViewGroup = localLayoutInflater.inflate(2131561896, paramViewGroup, false);
        paramViewGroup.setTag(new qqa.f(paramViewGroup, this));
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        paramViewGroup = localLayoutInflater.inflate(2131561960, paramViewGroup, false);
        paramViewGroup.setTag(new qqa.e(paramViewGroup, this));
        return paramViewGroup;
      }
    } while (paramInt != 7);
    paramViewGroup = localLayoutInflater.inflate(2131561957, paramViewGroup, false);
    paramViewGroup.setTag(new qqa.d(paramViewGroup, this));
    return paramViewGroup;
  }
  
  public void e(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      super.notifyDataSetChanged();
    }
  }
  
  protected boolean isSelf()
  {
    return false;
  }
  
  public void l(String paramString, List<VideoCollectionItem.b> paramList)
  {
    paramList = (WeakReference)this.fp.get(paramString);
    if ((paramList != null) && (paramList.get() != null))
    {
      VideoCollectionItem localVideoCollectionItem = ((psn)psx.a(19)).a(paramString);
      if (localVideoCollectionItem == null) {
        break label55;
      }
      ((qqa.b)paramList.get()).b.setData(localVideoCollectionItem);
    }
    label55:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "updateCollectionData: videoCollectionItem is null, collectionId:" + paramString);
  }
  
  public void setData(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    this.aEI = false;
    super.setData(paramList, paramBoolean);
  }
  
  public static class a
    extends plt
  {
    public int sortType;
    
    public String toString()
    {
      return "ChangeVideoSortEvent " + super.toString();
    }
  }
  
  public static class b
    extends qpx.a
    implements View.OnClickListener
  {
    public ShareGroupInnerListView b;
    public VideoCollectionItem b;
    public final qqa b;
    public Context context;
    public RelativeLayout fO;
    public ImageView mP;
    public ImageView mQ;
    public View op;
    public View oq;
    public TextView xu;
    public TextView xv;
    public TextView xw;
    public TextView xx;
    
    public b(View paramView, qqa paramqqa)
    {
      this.context = paramqqa.mContext;
      this.type = 1;
      this.fO = ((RelativeLayout)paramView.findViewById(2131379661));
      this.xu = ((TextView)paramView.findViewById(2131364861));
      this.xv = ((TextView)paramView.findViewById(2131364866));
      this.xw = ((TextView)paramView.findViewById(2131364871));
      this.mP = ((ImageView)paramView.findViewById(2131371262));
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView = ((ShareGroupInnerListView)paramView.findViewById(2131369273));
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
      aqcl.Q(this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView, false);
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setFocusable(false);
      this.jdField_b_of_type_Qqa = paramqqa;
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setLoadMoreDataListener(this.jdField_b_of_type_Qqa.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b);
      paramqqa = (quf)this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.getAdapter();
      paramqqa.setUid(this.jdField_b_of_type_Qqa.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId);
      paramqqa.b(this.jdField_b_of_type_Qqa.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b);
      this.op = paramView.findViewById(2131370466);
      this.oq = paramView.findViewById(2131370467);
      this.mQ = ((ImageView)paramView.findViewById(2131373471));
      this.xx = ((TextView)paramView.findViewById(2131362252));
      setNightMode();
    }
    
    public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem = paramVideoCollectionItem;
      if (TextUtils.equals(paramVideoCollectionItem.key, "local_empty_item"))
      {
        this.fO.setVisibility(8);
        this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
        this.op.setVisibility(8);
        paramView = (RelativeLayout.LayoutParams)this.oq.getLayoutParams();
        paramView.height = Integer.valueOf(paramVideoCollectionItem.collectionId).intValue();
        this.oq.setLayoutParams(paramView);
        this.oq.setVisibility(0);
        return;
      }
      if (TextUtils.equals(paramVideoCollectionItem.key, "local_desc_item"))
      {
        this.fO.setVisibility(8);
        this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
        this.op.setVisibility(8);
        this.oq.setVisibility(8);
        return;
      }
      this.fO.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(0);
      this.jdField_b_of_type_Qqa.fp.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
      paramView = roq.b(paramVideoCollectionItem.collectionTime);
      this.xu.setText(paramView[1]);
      Object localObject;
      if (!TextUtils.isEmpty(paramView[0]))
      {
        this.xv.setText(paramView[0]);
        this.xv.setVisibility(0);
        this.xu.setTextSize(1, 32.0F);
        localObject = (LinearLayout.LayoutParams)this.xu.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(0, rpq.dip2px(this.context, -8.0F), 0, 0);
        this.xu.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.fO.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.fO.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
        this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.resetCurrentX(0);
        this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setData(paramVideoCollectionItem);
        localObject = (RelativeLayout.LayoutParams)this.xw.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = rpq.dip2px(this.context, 80.0F);
        this.xw.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((paramVideoCollectionItem.collectionCount > 0) || (paramInt != 2)) {
          break label653;
        }
        this.xw.setText(acfp.m(2131714379));
        label380:
        localObject = this.jdField_b_of_type_Qqa.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
        if ((((ShareGroupItem)localObject).type != 2) || (!((ShareGroupItem)localObject).isPublic()) || (paramVideoCollectionItem.collectionCount <= 0)) {
          break label687;
        }
        this.mP.setOnClickListener(this);
        this.xw.setOnClickListener(this);
        this.mP.setVisibility(0);
        label437:
        if (!TextUtils.isEmpty(paramVideoCollectionItem.address)) {
          break label699;
        }
        this.xx.setVisibility(4);
        label455:
        this.op.setVisibility(8);
        this.oq.setVisibility(0);
        paramVideoCollectionItem = (RelativeLayout.LayoutParams)this.oq.getLayoutParams();
        if (paramInt != 2) {
          break label738;
        }
        paramVideoCollectionItem.height = rpq.dip2px(this.context, 150.0F);
      }
      for (;;)
      {
        this.oq.setLayoutParams(paramVideoCollectionItem);
        return;
        this.xv.setVisibility(8);
        this.xu.setTextSize(1, 20.0F);
        localObject = (LinearLayout.LayoutParams)this.xu.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.xu.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.fO.getLayoutParams();
        if ((paramInt == 3) && (TextUtils.equals(paramView[1], acfp.m(2131714372)))) {
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, rpq.dip2px(this.context, 10.0F), 0, rpq.dip2px(this.context, 7.0F));
        }
        for (;;)
        {
          this.fO.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, rpq.dip2px(this.context, 7.0F));
        }
        label653:
        this.xw.setText(this.context.getString(2131701754, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
        break label380;
        label687:
        this.mP.setVisibility(8);
        break label437;
        label699:
        paramVideoCollectionItem.address = paramVideoCollectionItem.address.replace(65292, '‧');
        this.xx.setText(paramVideoCollectionItem.address);
        this.xx.setVisibility(0);
        break label455;
        label738:
        if (TextUtils.equals(paramView[1], acfp.m(2131714376))) {
          paramVideoCollectionItem.height = rpq.dip2px(this.context, 172.0F);
        } else {
          paramVideoCollectionItem.height = rpq.dip2px(this.context, 176.0F);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.size() != 0) {
          break;
        }
        ram.d("Q.qqstory.shareGroup.ShareGroupsListAdapter", "no data to share");
      }
      roq.isToday(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime);
      int i = this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionCount;
      Iterator localIterator = this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.iterator();
      VideoCollectionItem.b localb;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localb = (VideoCollectionItem.b)localIterator.next();
      } while ((localb == null) || (quf.b.a(localb)) || (0 != 0));
      for (;;)
      {
        if (localb != null)
        {
          this.jdField_b_of_type_Qqa.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionId, this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime, localb.l, i, this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.feedId, null);
          break;
        }
        ram.d("Q.qqstory.shareGroup.ShareGroupsListAdapter", "cannot found first data to share to qq");
        break;
        localb = null;
      }
    }
    
    protected void setNightMode()
    {
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
        return;
      }
      this.mP.setImageResource(2130847490);
      this.op.setBackgroundColor(Color.parseColor("#0c284e"));
      this.oq.setBackgroundColor(Color.parseColor("#0c284e"));
      this.mQ.setBackgroundResource(2130847486);
      this.xw.setTextColor(Color.parseColor("#44608a"));
      this.xu.setTextColor(Color.parseColor("#6991b8"));
      this.xv.setTextColor(Color.parseColor("#6991b8"));
    }
  }
  
  public static class c
    extends RecyclerView.ViewHolder
  {
    public MyMemoriesListView.b b;
    public Context context;
    public ImageView jF;
    public ImageView mA;
    public ImageView mR;
    public ImageView mS;
    public TextView titleView;
    public TextView xA;
    public TextView xw;
    public TextView xy;
    public TextView xz;
    
    public c(View paramView, Context paramContext)
    {
      super();
      this.context = paramContext;
      this.jF = ((ImageView)paramView.findViewById(2131364286));
      this.xy = ((TextView)paramView.findViewById(2131364302));
      this.xw = ((TextView)paramView.findViewById(2131364329));
      this.mA = ((ImageView)paramView.findViewById(2131364320));
      this.titleView = ((TextView)paramView.findViewById(2131364327));
      this.xz = ((TextView)paramView.findViewById(2131364303));
      this.xA = ((TextView)paramView.findViewById(2131364321));
      this.mR = ((ImageView)paramView.findViewById(2131375121));
      this.mS = ((ImageView)paramView.findViewById(2131374683));
    }
    
    public void a(MyMemoriesListView.b paramb)
    {
      this.b = paramb;
    }
    
    public void c(HotSortVideoEntry paramHotSortVideoEntry)
    {
      if (paramHotSortVideoEntry == null)
      {
        this.itemView.setVisibility(8);
        return;
      }
      this.itemView.setVisibility(0);
      this.xy.setVisibility(8);
      int i = (riw.getWindowScreenWidth(this.context) - rpq.dip2px(this.context, 25.0F)) / 2;
      int j = (int)(i * 1.61D);
      this.itemView.getLayoutParams().width = i;
      this.jF.getLayoutParams().width = i;
      this.jF.getLayoutParams().height = j;
      Object localObject;
      if (paramHotSortVideoEntry.coverURL == null)
      {
        this.jF.setImageDrawable(this.context.getResources().getDrawable(2130847483));
        localObject = paramHotSortVideoEntry.storyId;
        this.itemView.setOnClickListener(new qqb(this, (String)localObject));
        this.xw.setVisibility(8);
        localObject = ((ptf)psx.a(2)).c(paramHotSortVideoEntry.unionId);
        if (localObject != null) {
          break label333;
        }
        if (!"NullImage".equals(this.mA.getTag()))
        {
          this.mA.setTag("NullImage");
          this.mA.setImageBitmap(aqhu.G());
        }
        this.titleView.setText(ppf.getString(2131701926));
        label217:
        if ((paramHotSortVideoEntry.likeCount != 0) || (paramHotSortVideoEntry.viewCount != 0)) {
          break label516;
        }
        this.xz.setVisibility(8);
        this.xA.setVisibility(8);
      }
      for (;;)
      {
        rar.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
        return;
        localObject = rpn.go(paramHotSortVideoEntry.coverURL);
        if (((String)localObject).equals(this.jF.getTag())) {
          break;
        }
        this.jF.setTag(localObject);
        rpq.a(this.jF, (String)localObject, i, j, i / 30, rpq.dl, "QQStoryMemory");
        break;
        label333:
        if (!((QQUserUIItem)localObject).headUrl.equals(this.mA.getTag()))
        {
          this.mA.setTag(((QQUserUIItem)localObject).headUrl);
          qqa.b(this.mA, 0, ((QQUserUIItem)localObject).headUrl);
        }
        this.titleView.setText(((QQUserUIItem)localObject).getDisplayName());
        if (((QQUserUIItem)localObject).isVipButNoFriend())
        {
          if (ppg.d.IE())
          {
            this.mR.setVisibility(0);
            this.mS.setVisibility(8);
            j = rpq.dip2px(this.context, 72.0F);
            this.titleView.setMaxWidth(i - j);
            break label217;
          }
          this.mR.setVisibility(8);
          this.mS.setVisibility(0);
          qem.a(this.mS, (QQUserUIItem)localObject);
          localObject = qem.e((QQUserUIItem)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label217;
          }
          this.mS.setTag(localObject);
          break label217;
        }
        this.mR.setVisibility(8);
        this.mS.setVisibility(8);
        break label217;
        label516:
        localObject = this.context.getResources().getDrawable(2130847756);
        ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.context, 12.0F), rpq.dip2px(this.context, 12.0F));
        this.xz.setText(rpq.aL(paramHotSortVideoEntry.viewCount));
        this.xz.setCompoundDrawables((Drawable)localObject, null, null, null);
        localObject = this.context.getResources().getDrawable(2130847350);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        this.xA.setText(rpq.aL(paramHotSortVideoEntry.likeCount));
        this.xA.setCompoundDrawables((Drawable)localObject, null, null, null);
        this.xz.setVisibility(0);
        this.xA.setVisibility(0);
      }
    }
    
    public void hide()
    {
      this.itemView.setVisibility(8);
    }
  }
  
  public static class d
    extends qpx.a
  {
    public qqa.c b;
    public qqa.c c;
    public TextView xB;
    public TextView xC;
    public TextView xD;
    public TextView xE;
    public TextView xF;
    public TextView xG;
    
    public d(View paramView, qqa paramqqa)
    {
      View localView = paramView.findViewById(2131375182);
      paramView = paramView.findViewById(2131375233);
      this.b = new qqa.c(localView, paramqqa.mContext);
      this.c = new qqa.c(paramView, paramqqa.mContext);
      this.xB = ((TextView)localView.findViewById(2131364327));
      this.xC = ((TextView)paramView.findViewById(2131364327));
      this.xD = ((TextView)localView.findViewById(2131364303));
      this.xE = ((TextView)paramView.findViewById(2131364303));
      this.xF = ((TextView)localView.findViewById(2131364321));
      this.xG = ((TextView)paramView.findViewById(2131364321));
      QQStoryContext.a();
      if (ThemeUtil.isInNightMode(QQStoryContext.c()))
      {
        this.xB.setTextColor(Color.parseColor("#6991b8"));
        this.xC.setTextColor(Color.parseColor("#6991b8"));
        this.xD.setTextColor(Color.parseColor("#6991b8"));
        this.xE.setTextColor(Color.parseColor("#6991b8"));
        this.xF.setTextColor(Color.parseColor("#6991b8"));
        this.xG.setTextColor(Color.parseColor("#6991b8"));
      }
      if (paramqqa.a != null)
      {
        this.b.a(paramqqa.a);
        this.c.a(paramqqa.a);
      }
    }
    
    public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
    {
      if ((paramVideoCollectionItem == null) || (paramView == null))
      {
        ram.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
        return;
      }
      paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
      paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
      this.b.c(paramView);
      if (paramVideoCollectionItem == null)
      {
        this.c.hide();
        return;
      }
      this.c.c(paramVideoCollectionItem);
    }
  }
  
  public static class e
    extends qpx.a
    implements View.OnClickListener
  {
    final qqa b;
    final Button cm;
    final LinearLayout eU;
    final ImageView mT;
    final ImageView mU;
    List<QQUserUIItem> oc = new ArrayList();
    final TextView xH;
    final TextView xI;
    
    public e(View paramView, qqa paramqqa)
    {
      this.type = 2;
      this.b = paramqqa;
      this.xI = ((TextView)paramView.findViewById(2131379515));
      this.xH = ((TextView)paramView.findViewById(2131379541));
      this.mT = ((ImageView)paramView.findViewById(2131373610));
      this.cm = ((Button)paramView.findViewById(2131378958));
      this.eU = ((LinearLayout)paramView.findViewById(2131371240));
      this.mU = ((ImageView)paramView.findViewById(2131368868));
      this.cm.setOnClickListener(this);
      this.eU.setOnClickListener(this);
      this.xI.setOnClickListener(this);
    }
    
    private void ey(List<String> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      this.oc.clear();
      Object localObject1 = (ptf)psx.a(2);
      Object localObject2 = new ArrayList();
      int j = Math.min(paramList.size(), 6);
      int i = 0;
      if (i < j)
      {
        String str = (String)paramList.get(i);
        QQUserUIItem localQQUserUIItem = ((ptf)localObject1).b(str);
        if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl))) {
          this.oc.add(localQQUserUIItem);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject2).add(new QQUserUIItem.a("", str));
        }
      }
      if (!((List)localObject2).isEmpty()) {
        new pxs(1, (List)localObject2).sendRequest();
      }
      this.eU.removeAllViews();
      int k = this.oc.size();
      j = 0;
      label181:
      label193:
      int m;
      if (j < k)
      {
        if (j != 0) {
          break label274;
        }
        i = -1;
        paramList = this.b.mContext;
        localObject1 = this.eU;
        localObject2 = (QQUserUIItem)this.oc.get(j);
        m = this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount;
        if (this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount <= 6) {
          break label292;
        }
      }
      label274:
      label292:
      for (boolean bool = true;; bool = false)
      {
        qow.a(paramList, (LinearLayout)localObject1, 34, (QQUserUIItem)localObject2, i, m, bool);
        j += 1;
        break label181;
        break;
        if (j == k - 1)
        {
          i = 1;
          break label193;
        }
        i = 0;
        break label193;
      }
    }
    
    public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
    {
      if (this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
        return;
      }
      paramView = this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
      this.xI.setText(paramView.name);
      if (paramView.type == 1)
      {
        paramVideoCollectionItem = acfp.m(2131714381);
        this.mT.setImageResource(2130847681);
        this.cm.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramView.backgroundUrl)) {
          rpq.a(this.mU, paramView.backgroundUrl, 0, 0, null);
        }
        if (paramView.headerUnionIdList != null) {
          paramView.memberCount = Math.max(paramView.headerUnionIdList.size(), paramView.memberCount);
        }
        paramVideoCollectionItem = paramVideoCollectionItem + " · " + paramView.memberCount + acfp.m(2131714383);
        this.xH.setText(paramVideoCollectionItem);
        ey(paramView.headerUnionIdList);
        return;
        paramVideoCollectionItem = null;
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b.dL(this.cm);
        continue;
        this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b.dM(this.eU);
        continue;
        this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b.dM(this.eU);
      }
    }
  }
  
  public static class f
    extends qpx.a
  {
    protected final qqa b;
    public Context context;
    public View op;
    public TextView xJ;
    public TextView xK;
    public TextView xL;
    
    public f(View paramView, qqa paramqqa)
    {
      this.b = paramqqa;
      this.context = paramView.getContext();
      this.type = 0;
      this.xJ = ((TextView)paramView.findViewById(2131382401));
      this.xK = ((TextView)paramView.findViewById(2131381645));
      this.xL = ((TextView)paramView.findViewById(2131381809));
      this.op = paramView.findViewById(2131370466);
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null))
      {
        if (this.xK != null) {
          this.xK.setTextColor(Color.parseColor("#44608a"));
        }
        this.xJ.setTextColor(Color.parseColor("#6991b8"));
        this.xL.setTextColor(Color.parseColor("#6991b8"));
        if (this.op != null) {
          this.op.setBackgroundColor(Color.parseColor("#0c284e"));
        }
      }
      this.xL.setOnClickListener(new qqc(this));
    }
    
    public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
    {
      int i = 0;
      if (this.b.aEI)
      {
        this.xJ.setText(acfp.m(2131714396));
        this.xJ.setPadding(rpq.dip2px(this.context, 3.0F), 0, 0, 0);
        this.xK.setText("");
        if (paramInt != 1) {
          break label174;
        }
        this.xL.setVisibility(0);
        tc(this.b.aEI);
      }
      for (;;)
      {
        paramVideoCollectionItem = this.op;
        if (paramInt == 1) {
          i = 4;
        }
        paramVideoCollectionItem.setVisibility(i);
        return;
        this.xJ.setText(roq.aJ(paramVideoCollectionItem.collectionTime));
        this.xJ.setPadding(0, 0, 0, 0);
        if (paramVideoCollectionItem.collectionCount <= 0)
        {
          this.xK.setText("");
          break;
        }
        this.xK.setText(this.context.getString(2131701775, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
        break;
        label174:
        this.xL.setVisibility(8);
      }
    }
    
    protected void tc(boolean paramBoolean)
    {
      int i = rpq.dip2px(this.context, 17.0F);
      if (paramBoolean)
      {
        this.xL.setText(acfp.m(2131714375));
        localDrawable = this.context.getResources().getDrawable(2130847767);
        localDrawable.setBounds(0, 0, i, i);
        this.xL.setCompoundDrawables(localDrawable, null, null, null);
        return;
      }
      this.xL.setText(acfp.m(2131714386));
      Drawable localDrawable = this.context.getResources().getDrawable(2130847766);
      localDrawable.setBounds(0, 0, i, i);
      this.xL.setCompoundDrawables(localDrawable, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqa
 * JD-Core Version:    0.7.0.1
 */