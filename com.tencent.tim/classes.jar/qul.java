import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.a;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.3;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.4;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.5;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class qul
  extends rsd
  implements MemoriesInnerListView.a, IEventReceiver, qtr.c, quf.a
{
  public static final String KEY = "MemoriesVideoListSegment";
  private qtr jdField_a_of_type_Qtr;
  private final qul.a jdField_a_of_type_Qul$a;
  private boolean aDA = true;
  private boolean aEJ;
  public String ayG;
  public String ayH;
  private HashMap<String, WeakReference<quf>> fp = new HashMap();
  public int mSource;
  
  public qul(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.mSource = paramInt;
    this.jdField_a_of_type_Qtr = new qtr(paramString, this);
    this.jdField_a_of_type_Qtr.create();
    this.jdField_a_of_type_Qul$a = new qul.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qul$a);
  }
  
  private void a(int paramInt, VideoCollectionItem paramVideoCollectionItem, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        ThreadManager.getUIHandler().postDelayed(new MemoriesVideoListSegment.3(this, paramInt, paramVideoCollectionItem, paramString), 300L);
      }
    }
    do
    {
      return;
      localObject = (MemoriesInnerListView)((qyd)localObject).get(2131369273);
    } while (localObject == null);
    Iterator localIterator = paramVideoCollectionItem.collectionVideoUIItemList.iterator();
    int i = 0;
    for (;;)
    {
      if ((!localIterator.hasNext()) || (TextUtils.equals(((VideoCollectionItem.b)localIterator.next()).mVid, paramString)))
      {
        if (paramVideoCollectionItem.collectionVideoUIItemList.size() > 2) {
          break;
        }
        ThreadManager.getUIHandler().post(new MemoriesVideoListSegment.4(this, (MemoriesInnerListView)localObject, i, paramString));
        return;
      }
      i += 1;
    }
    if (!paramBoolean)
    {
      ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "feedPosition:%d do scroll data pos:%d", Integer.valueOf(paramInt), Integer.valueOf(i));
      int j = rpq.dip2px(this.context, 80.0F) * i;
      ((MemoriesInnerListView)localObject).resetCurrentX(j);
      ((MemoriesInnerListView)localObject).getAdapter().notifyDataSetChanged();
      ram.a("Q.qqstory.memories.MemoriesVideoListSegment", "feedPosition:%d do scroll data pos:%d, scrollx:%d", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j));
    }
    ThreadManager.getUIHandler().postDelayed(new MemoriesVideoListSegment.5(this, (MemoriesInnerListView)localObject, i, paramString), 400L);
  }
  
  private String getSessionId()
  {
    return String.valueOf(hashCode());
  }
  
  private void ws(int paramInt)
  {
    setSelection(paramInt);
    ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollVertical,position:%d", Integer.valueOf(paramInt));
  }
  
  protected int J(int paramInt)
  {
    if (this.jdField_a_of_type_Qtr.aFs)
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_Qtr.nh.get(paramInt);
      if (localVideoCollectionItem.collectionType == 0) {
        return 0;
      }
      if (localVideoCollectionItem.collectionType == 1) {
        return 1;
      }
      if (localVideoCollectionItem.collectionType == 8) {
        return 2;
      }
      throw new IllegalStateException("get view type error because unknown view type:" + localVideoCollectionItem.collectionType);
    }
    return 3;
  }
  
  protected boolean KB()
  {
    this.jdField_a_of_type_Qtr.bqD();
    return true;
  }
  
  protected boolean Z(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qtr.refreshData(false);
    return true;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    int i = J(paramInt);
    if (i == 0) {
      return b(paramInt, paramqyd, paramViewGroup);
    }
    if (i == 1) {
      return c(paramInt, paramqyd, paramViewGroup);
    }
    if (i == 2) {
      return d(paramInt, paramqyd, paramViewGroup);
    }
    if (i == 3) {
      return d(paramInt, paramqyd);
    }
    throw new IllegalStateException("bind view error because unknown view type:" + i);
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = J(paramInt);
    if (paramInt == 0) {
      return new qyd(LayoutInflater.from(this.context).inflate(2131561896, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new qyd(LayoutInflater.from(this.context).inflate(2131561886, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new qyd(LayoutInflater.from(this.context).inflate(2131561894, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new qyd(LayoutInflater.from(this.context).inflate(2131561891, paramViewGroup, false));
    }
    throw new IllegalStateException("create view error because unknown view type:" + paramInt);
  }
  
  public View b(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramViewGroup = (VideoCollectionItem)this.jdField_a_of_type_Qtr.nh.get(paramInt);
    TextView localTextView1 = (TextView)paramqyd.get(2131382401);
    TextView localTextView2 = (TextView)paramqyd.get(2131381645);
    View localView = paramqyd.get(2131370466);
    if (ThemeUtil.isInNightMode(qem.getQQAppInterface()))
    {
      localTextView2.setTextColor(Color.parseColor("#44608a"));
      localTextView1.setTextColor(Color.parseColor("#6991b8"));
      localView.setBackgroundColor(Color.parseColor("#0c284e"));
    }
    localTextView1.setText(roq.aJ(paramViewGroup.collectionTime));
    if (paramViewGroup.collectionCount <= 0)
    {
      localTextView2.setText("");
      if (paramInt != 0) {
        break label166;
      }
    }
    label166:
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      return paramqyd.getItemView();
      localTextView2.setText(this.context.getString(2131701775, new Object[] { Integer.valueOf(paramViewGroup.collectionCount) }));
      break;
    }
  }
  
  public void b(String paramString1, int paramInt, View paramView, String paramString2)
  {
    Bosses.get().postJob(new qun(this, "Q.qqstory.memories.MemoriesVideoListSegment", paramString1, paramString2, paramInt, paramView));
  }
  
  protected void bqO()
  {
    this.jdField_a_of_type_Qtr.refreshData(true);
    bqW();
  }
  
  public void bqW()
  {
    a().setOnLoadMoreListener(getKey(), new qum(this));
    SegmentList localSegmentList = a();
    String str = getKey();
    if (!isEnd()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  public View c(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RelativeLayout)paramqyd.get(2131379661);
    Object localObject4 = (TextView)paramqyd.get(2131364861);
    Object localObject5 = (TextView)paramqyd.get(2131364866);
    TextView localTextView1 = (TextView)paramqyd.get(2131364871);
    paramViewGroup = (MemoriesInnerListView)paramqyd.get(2131369273);
    Object localObject1 = paramqyd.get(2131370467);
    Object localObject2 = (ImageView)paramqyd.get(2131373471);
    TextView localTextView2 = (TextView)paramqyd.get(2131362252);
    if (ThemeUtil.isInNightMode(qem.getQQAppInterface()))
    {
      ((View)localObject1).setBackgroundColor(Color.parseColor("#0c284e"));
      ((ImageView)localObject2).setBackgroundResource(2130847486);
      localTextView1.setTextColor(Color.parseColor("#44608a"));
      ((TextView)localObject4).setTextColor(Color.parseColor("#6991b8"));
      ((TextView)localObject5).setTextColor(Color.parseColor("#6991b8"));
    }
    localObject2 = (VideoCollectionItem)this.jdField_a_of_type_Qtr.nh.get(paramInt);
    paramViewGroup.setSelection(0);
    aqcl.Q(paramViewGroup, false);
    paramViewGroup.setFocusable(false);
    String[] arrayOfString = roq.b(((VideoCollectionItem)localObject2).collectionTime);
    ((TextView)localObject4).setText(arrayOfString[1]);
    if (!TextUtils.isEmpty(arrayOfString[0]))
    {
      ((TextView)localObject5).setText(arrayOfString[0]);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject4).setTextSize(1, 32.0F);
      localObject5 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, rpq.dip2px(this.context, -8.0F), 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localTextView1.setText(this.context.getString(2131701754, new Object[] { Integer.valueOf(((VideoCollectionItem)localObject2).collectionCount) }));
      if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).address)) {
        break label590;
      }
      localTextView2.setVisibility(4);
      label344:
      localObject3 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (paramInt != 1) {
        break label628;
      }
      ((RelativeLayout.LayoutParams)localObject3).height = rpq.dip2px(this.context, 150.0F);
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramViewGroup.b = this;
      localObject1 = (quf)paramViewGroup.getAdapter();
      ((quf)localObject1).setUid(this.jdField_a_of_type_Qtr.mUid);
      ((quf)localObject1).a(this);
      paramViewGroup.setSelection(0);
      paramViewGroup.resetCurrentX(0);
      paramViewGroup.setDate(((VideoCollectionItem)localObject2).collectionVideoUIItemList, ((VideoCollectionItem)localObject2).collectionId);
      this.fp.put(((VideoCollectionItem)localObject2).collectionId, new WeakReference(localObject1));
      return paramqyd.getItemView();
      ((TextView)localObject5).setVisibility(8);
      ((TextView)localObject4).setTextSize(1, 20.0F);
      localObject5 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      if (TextUtils.equals(arrayOfString[1], acfp.m(2131708108))) {
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, rpq.dip2px(this.context, 10.0F), 0, rpq.dip2px(this.context, 7.0F));
      }
      for (;;)
      {
        ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        break;
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, rpq.dip2px(this.context, 7.0F));
      }
      label590:
      ((VideoCollectionItem)localObject2).address = ((VideoCollectionItem)localObject2).address.replace(65292, '‧');
      localTextView2.setText(((VideoCollectionItem)localObject2).address);
      localTextView2.setVisibility(0);
      break label344;
      label628:
      if (TextUtils.equals(arrayOfString[1], acfp.m(2131708100))) {
        ((RelativeLayout.LayoutParams)localObject3).height = rpq.dip2px(this.context, 172.0F);
      } else {
        ((RelativeLayout.LayoutParams)localObject3).height = rpq.dip2px(this.context, 176.0F);
      }
    }
  }
  
  public View d(int paramInt, qyd paramqyd)
  {
    TextView localTextView = (TextView)paramqyd.get(2131370815);
    if ((this.jdField_a_of_type_Qtr.l != null) && (this.jdField_a_of_type_Qtr.l.errorCode == 11111)) {
      localTextView.setText(acfp.m(2131708113));
    }
    for (;;)
    {
      return paramqyd.getItemView();
      localTextView.setText(acfp.m(2131708111));
    }
  }
  
  public View d(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    return paramqyd.getItemView();
  }
  
  public int getCount()
  {
    if (this.isDisplay)
    {
      if (!this.jdField_a_of_type_Qtr.aFs) {
        return 1;
      }
      return this.jdField_a_of_type_Qtr.nh.size();
    }
    return 0;
  }
  
  public String getKey()
  {
    return "MemoriesVideoListSegment";
  }
  
  protected int getViewTypeCount()
  {
    return 4;
  }
  
  public boolean isEnd()
  {
    if (isDisplay()) {
      return this.jdField_a_of_type_Qtr.aFt;
    }
    return true;
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  public void m(String paramString, List<VideoCollectionItem.b> paramList)
  {
    ram.w("Q.qqstory.memories.MemoriesVideoListSegment", "updateCollectionData. collectionId=%s", new Object[] { paramString });
    WeakReference localWeakReference = (WeakReference)this.fp.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((quf)localWeakReference.get()).p(paramList, paramString);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Qtr.destroy();
    this.aDA = false;
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qul$a);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.aEJ = false;
  }
  
  public void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Qtr.nh.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
      if (paramString1.equals(localVideoCollectionItem.feedId))
      {
        this.ayG = null;
        this.ayH = null;
        ws(i);
        a(i, localVideoCollectionItem, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      VideoCollectionItem localVideoCollectionItem;
      return;
      i += 1;
      break;
    }
    ram.d("Q.qqstory.memories.MemoriesVideoListSegment", "scroll2NewGroup, loadmore");
    this.ayG = paramString1;
    this.ayH = paramString2;
    KB();
  }
  
  public void rO(String paramString)
  {
    ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "onInnerListRefresh collectionId=%s", paramString);
    this.jdField_a_of_type_Qtr.rZ(paramString);
    paramString = ((ptf)psx.a(2)).b(this.jdField_a_of_type_Qtr.mUid);
    int i = StoryMemoriesFragment.dX(this.mSource);
    if ((paramString != null) && (paramString.isMe())) {}
    for (paramString = "1";; paramString = "2")
    {
      rar.a("memory", "left_right", i, 0, new String[] { paramString, "", "", "" });
      return;
    }
  }
  
  public void setDisplay(boolean paramBoolean)
  {
    super.setDisplay(paramBoolean);
    if (this.isDisplay) {
      bqW();
    }
  }
  
  public void tq(boolean paramBoolean)
  {
    boolean bool = true;
    SegmentList localSegmentList;
    String str;
    if (paramBoolean)
    {
      notifyDataSetChanged(true);
      localSegmentList = a();
      str = getKey();
      if (isEnd()) {
        break label83;
      }
    }
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, paramBoolean, bool);
      if ((this.ayG != null) && (this.ayH != null))
      {
        q(this.ayG, this.ayH, false);
        this.ayG = null;
        this.ayH = null;
      }
      return;
      notifyDataSetChanged(false);
      break;
      label83:
      bool = false;
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qul, qiy>
  {
    public a(@NonNull qul paramqul)
    {
      super();
    }
    
    public void a(@NonNull qul paramqul, @NonNull qiy paramqiy)
    {
      ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramqiy.a, paramqiy.vid);
      if ((qul.a(paramqul).equals(paramqiy.axu)) && ((paramqiy.a instanceof qha.b)))
      {
        qvd localqvd = ((qha.b)paramqiy.a).a;
        if (localqvd != null) {
          paramqul.q(localqvd.mFeedId, paramqiy.vid, true);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return qiy.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qul
 * JD-Core Version:    0.7.0.1
 */