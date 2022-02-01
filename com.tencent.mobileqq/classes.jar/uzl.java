import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.1;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.3;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.4;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class uzl
  extends vbl<vat>
{
  private int jdField_a_of_type_Int = 3;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private aakb jdField_a_of_type_Aakb;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private int b = 3;
  
  public uzl(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString, int paramInt1, int paramInt2, vat paramvat)
  {
    int i = 0;
    while (i < paramvat.jdField_a_of_type_JavaUtilList.size())
    {
      FeedCloudMeta.StReply localStReply = ((vbc)paramvat.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
      if ((localStReply != null) && (paramString.equals(localStReply.id.get())))
      {
        paramvat.a(paramString, this.jdField_a_of_type_Int);
        return paramInt2;
      }
      i += 1;
    }
    return paramInt1;
  }
  
  private List<vat> a(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      vat localvat = new vat(localStComment);
      int i;
      if ((a()) && (paramList.size() == 1)) {
        i = localStComment.vecReply.size();
      }
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          localvat.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(j));
          j += 1;
        }
        if (localStComment.vecReply.size() <= this.jdField_a_of_type_Int) {
          i = localStComment.vecReply.size();
        } else {
          i = this.jdField_a_of_type_Int;
        }
      }
      if (i < localStComment.vecReply.size()) {
        localvat.a(2, localStComment.vecReply.size() - i);
      }
      localArrayList.add(localvat);
    }
    return localArrayList;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
  }
  
  private void a(String paramString, vat paramvat)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get().size())
      {
        FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get(i);
        if ((localStReply != null) && (paramString.equals(localStReply.id.get()))) {
          paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.remove(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(vat paramvat)
  {
    int i;
    if (paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() <= this.jdField_a_of_type_Int) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramvat.jdField_a_of_type_JavaUtilList.size())
      {
        vbc localvbc = (vbc)paramvat.jdField_a_of_type_JavaUtilList.get(i);
        if ((localvbc != null) && ((localvbc.jdField_a_of_type_Int == 2) || (localvbc.jdField_a_of_type_Int == 3))) {
          paramvat.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCircleCommentPanelBlock.1(this, paramBoolean));
      }
    }
    else {
      return;
    }
    if (paramBoolean) {
      a();
    }
    notifyDataSetChanged();
  }
  
  private boolean a()
  {
    return (a() != null) && (a().getPageId() != 69);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(new zzl());
    } while (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator() instanceof SimpleItemAnimator));
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCircleCommentPanelBlock.3(this, paramInt));
      }
    }
    else {
      return;
    }
    b();
    notifyItemRemoved(paramInt);
    notifyItemRangeChanged(paramInt, this.mDataList.size() - paramInt);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCircleCommentPanelBlock.4(this, paramInt));
      }
    }
    else {
      return;
    }
    b();
    notifyItemChanged(paramInt);
  }
  
  public int a(int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() < paramInt)) {
      return 0;
    }
    return ((vat)this.mDataList.get(paramInt)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get().size();
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean(a(), (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleCommentPanelBlock";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {}
    Object localObject;
    do
    {
      return;
      localObject = (vat)this.mDataList.get(paramInt1);
    } while ((((vat)localObject).jdField_a_of_type_JavaUtilList.size() <= paramInt2) || (((vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_Int != 2));
    int i = this.b;
    if (((vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(paramInt2)).b <= i) {
      i = ((vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(paramInt2)).b;
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      int k = 0;
      int j = paramInt2;
      paramInt2 = k;
      while (paramInt2 < i)
      {
        ((vat)localObject).jdField_a_of_type_JavaUtilList.add(j, new vbc(1, (FeedCloudMeta.StReply)((vat)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get(j)));
        j += 1;
        paramInt2 += 1;
      }
      if (paramInt1 != 0) {
        ((vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int = 3;
      }
      for (((vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(j)).b = 0;; ((vbc)localObject).b -= i)
      {
        a(false);
        return;
        localObject = (vbc)((vat)localObject).jdField_a_of_type_JavaUtilList.get(j);
      }
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.mDataList.size())) {
      this.mDataList.add(paramInt, new vat(paramStComment));
    }
    a(false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    }
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  public void a(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if ((this.mDataList.size() > 0) && (((vat)this.mDataList.get(0)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.typeFlag.get() == 1))
    {
      a(1, paramStComment);
      return;
    }
    a(0, paramStComment);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, List<FeedCloudMeta.StComment> paramList)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.mDataList.clear();
    a(true);
    this.mDataList.addAll(a(paramList));
    a(true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label78:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.mDataList.size()) {
        if (((vat)this.mDataList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramString)) {
          this.mDataList.remove(i);
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label78;
        }
        c(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StComment paramStComment)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label86:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.mDataList.size()) {
        if (paramString.equals(((vat)this.mDataList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) {
          this.mDataList.set(i, new vat(paramStComment));
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label86;
        }
        d(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label98:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.mDataList.size())
      {
        vat localvat = (vat)this.mDataList.get(i);
        if (paramString.equals(localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()))
        {
          localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get().add(paramStReply);
          localvat.a(1, paramStReply);
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label98;
        }
        d(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    label124:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.mDataList.size())
      {
        vat localvat = (vat)this.mDataList.get(i);
        if ((paramString1.equals(localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) && (localvat.jdField_a_of_type_JavaUtilList != null) && (localvat.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          a(paramString2, localvat);
          i = a(paramString2, -1, i, localvat);
          a(localvat);
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label124;
        }
        d(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, FeedCloudMeta.StReply paramStReply)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    label174:
    label178:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.mDataList.size())
      {
        vat localvat = (vat)this.mDataList.get(i);
        if (paramString1.equals(localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()))
        {
          j = localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get().size() - 1;
          label82:
          if (j < 0) {
            break label174;
          }
          if (paramString2.equals(((FeedCloudMeta.StReply)localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get(j)).id.get()))
          {
            localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get().set(j, paramStReply);
            localvat.a(paramString2, paramStReply);
          }
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label178;
        }
        d(i);
        return;
        j -= 1;
        break label82;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), a(paramList));
    a(true);
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {}
    vat localvat;
    do
    {
      return;
      localvat = (vat)this.mDataList.get(paramInt1);
    } while ((localvat.jdField_a_of_type_JavaUtilList.size() <= paramInt2) || (((vbc)localvat.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_Int != 3));
    Iterator localIterator = localvat.jdField_a_of_type_JavaUtilList.iterator();
    paramInt1 = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        vbc localvbc = (vbc)localIterator.next();
        if (paramInt1 < this.jdField_a_of_type_Int)
        {
          paramInt1 += 1;
          continue;
        }
        if (localvbc.jdField_a_of_type_Int == 3)
        {
          localvbc.jdField_a_of_type_Int = 2;
          localvbc.b = (localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() - (localvat.jdField_a_of_type_JavaUtilList.size() - 1));
        }
      }
      else
      {
        a(false);
        return;
      }
      localIterator.remove();
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      vat localvat = (vat)localIterator.next();
      if (paramString.equals(localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) {
        localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.typeFlag.set(0);
      }
    }
    a(false);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = null;
    if (this.mDataList.size() > 0)
    {
      if ((this.mDataList.get(0) != null) && (((vat)this.mDataList.get(0)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.typeFlag.get() == 1)) {
        ((vat)this.mDataList.get(0)).jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.typeFlag.set(0);
      }
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        vat localvat = (vat)localIterator.next();
        if (localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramString))
        {
          localvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.typeFlag.set(1);
          localObject = localvat;
        }
        else
        {
          localLinkedList.add(localvat);
        }
      }
      if (localObject != null) {
        localLinkedList.add(0, localObject);
      }
      this.mDataList.clear();
      a(false);
      this.mDataList.addAll(new ArrayList(localLinkedList));
    }
    a(false);
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a(true);
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  public int getViewTypeCount()
  {
    return 0;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt)) {
      ((uzm)paramViewHolder).a(paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (vat)this.mDataList.get(paramInt), this.jdField_a_of_type_Aakb);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleCommentItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    return new uzm(this, paramViewGroup, null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = getParentRecyclerView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */