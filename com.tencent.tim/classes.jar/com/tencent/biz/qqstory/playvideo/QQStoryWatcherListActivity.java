package com.tencent.biz.qqstory.playvideo;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import annt;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ppv;
import ppv.c;
import psx;
import ptf;
import pxs;
import pxs.a;
import pxs.b;
import pzm;
import qat;
import qfq;
import qfr;
import qoj;
import qvf;
import qwo;
import rpq;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String axn = acfp.m(2131712529);
  public a a;
  qoj a;
  protected qwo a;
  boolean aDe = true;
  public boolean aDf = false;
  public VideoListFeedItem c;
  Drawable dc;
  XListView h;
  TextView ht;
  View mEmptyView;
  public String mFeedId;
  View mFooterView;
  View mLoadingLayout;
  public int mSource;
  TextView xf;
  TextView xh;
  
  public QQStoryWatcherListActivity()
  {
    this.jdField_a_of_type_Qwo = new qfr(this);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQStoryWatcherListActivity.2(this, paramBoolean1, paramBoolean2, paramList));
      return;
    }
    c(paramBoolean1, paramBoolean2, paramList);
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    if (!paramBoolean1)
    {
      this.ht.setVisibility(8);
      this.xf.setVisibility(0);
      this.mLoadingLayout.setVisibility(0);
      this.h.setVisibility(8);
      return;
    }
    if (paramList != null)
    {
      this.aDf = paramBoolean2;
      if (this.aDe)
      {
        this.mLoadingLayout.setVisibility(8);
        this.ht.setVisibility(8);
        if (paramList.size() == 0)
        {
          this.mEmptyView.setVisibility(0);
          this.h.setVisibility(8);
          this.aDe = false;
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label153;
        }
        wi(3);
        return;
        this.mEmptyView.setVisibility(8);
        this.h.setVisibility(0);
        this.jdField_a_of_type_Qoj.setData(paramList);
        break;
        this.jdField_a_of_type_Qoj.appendData(paramList);
      }
      label153:
      wi(1);
      return;
    }
    this.ht.setVisibility(8);
    this.mLoadingLayout.setVisibility(8);
    this.mEmptyView.setVisibility(0);
    this.h.setVisibility(8);
    this.aDf = paramBoolean2;
  }
  
  public static void i(Activity paramActivity, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, QQStoryWatcherListActivity.class);
    localIntent.putExtra("feed_id", paramString);
    localIntent.putExtra("source", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562042);
    super.setTitle(axn);
    this.leftView.setText(2131691039);
    super.findViewById(2131377546).setBackgroundColor(getResources().getColor(2131167363));
    this.mLoadingLayout = super.findViewById(2131375097);
    this.ht = ((TextView)super.findViewById(2131375274));
    this.h = ((XListView)super.findViewById(2131382124));
    this.mEmptyView = super.findViewById(2131366443);
    this.xf = ((TextView)super.findViewById(2131377225));
    try
    {
      this.xf.setCompoundDrawablesWithIntrinsicBounds(0, 2130847495, 0, 0);
      this.xf.setOnClickListener(this);
      this.mFooterView = LayoutInflater.from(this).inflate(2131562040, null);
      this.h.addFooterView(this.mFooterView);
      this.xh = ((TextView)this.mFooterView.findViewById(2131370546));
      this.jdField_a_of_type_Qoj = new qoj(this, null);
      this.h.setAdapter(this.jdField_a_of_type_Qoj);
      this.h.setOnScrollListener(new qfq(this));
      this.mFeedId = super.getIntent().getStringExtra("feed_id");
      this.mSource = super.getIntent().getIntExtra("source", 0);
      if (TextUtils.isEmpty(this.mFeedId))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("Q.qqstory.player.watcherlist.activity", 2, "doOnCreate: feedid is null!!!!");
        }
        return true;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        annt.e(paramBundle);
      }
      this.c = ((VideoListFeedItem)((qvf)psx.a(11)).a(this.mFeedId));
      if ((this.c != null) && (this.c.mViewTotalTime > 0L)) {
        super.setTitle(axn + rpq.aL(this.c.mViewTotalTime));
      }
      this.jdField_a_of_type_Qoj.a(this.jdField_a_of_type_Qwo);
      this.dc = getResources().getDrawable(2130839651);
      this.dc.setBounds(0, 0, this.dc.getMinimumWidth(), this.dc.getMinimumHeight());
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a = new a(this, this.mFeedId);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a.boe();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.dc instanceof Animatable)) {
      ((Animatable)this.dc).stop();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131377225) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a.boe();
        this.xf.setVisibility(8);
        this.ht.setVisibility(0);
        this.mLoadingLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131370546)
      {
        wi(1);
        a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a);
      }
    }
  }
  
  public void wi(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "setFooterText: footerMode = " + paramInt);
      }
      return;
      this.mFooterView.setVisibility(8);
      this.xh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((Animatable)this.dc).stop();
      this.xh.setOnClickListener(null);
      continue;
      this.mFooterView.setVisibility(0);
      this.xh.setText(acfp.m(2131712528));
      this.xh.setCompoundDrawables(this.dc, null, null, null);
      ((Animatable)this.dc).start();
      this.xh.setOnClickListener(null);
      continue;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a.AI >= 2000L)
      {
        wi(0);
      }
      else
      {
        this.mFooterView.setVisibility(0);
        String str = String.format("%s人累计浏览%s次", new Object[] { rpq.aL(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a.AI), rpq.aL(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$a.AJ) });
        this.xh.setText(str);
        this.xh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.dc).stop();
        this.xh.setOnClickListener(null);
        continue;
        this.mFooterView.setVisibility(0);
        this.xh.setText(acfp.m(2131712534));
        this.xh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.dc).stop();
        this.xh.setOnClickListener(this);
      }
    }
  }
  
  public static final class a
    extends ppv.c<pzm, qat>
    implements pxs.a
  {
    protected long AI;
    protected long AJ;
    final QQStoryWatcherListActivity jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
    final pxs jdField_a_of_type_Pxs;
    int blV = 0;
    boolean isFirstPage = true;
    final String mFeedId;
    List<qqstory_struct.UserSimpleInfo> nL;
    List<qqstory_struct.UserSimpleInfo> nM;
    
    public a(QQStoryWatcherListActivity paramQQStoryWatcherListActivity, String paramString)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity = paramQQStoryWatcherListActivity;
      this.mFeedId = paramString;
      this.jdField_a_of_type_Pxs = new pxs(this);
    }
    
    private void bof()
    {
      if ((this.nL == null) || (this.nL.isEmpty()))
      {
        QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
        return;
      }
      if (this.blV >= this.nL.size())
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage return, currentReqSeek = " + this.blV + ", uinCount = " + this.nL.size());
        }
        QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
        return;
      }
      this.nM = this.nL.subList(this.blV, Math.min(this.blV + 20, this.nL.size()));
      int i = this.nM.size();
      if (this.nM.isEmpty())
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage return, because toRequireList.isEmpty(), currentReqSeek = " + this.blV + ", uinCount = " + this.nL.size());
        }
        QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
        return;
      }
      Object localObject = (ptf)psx.a(2);
      ArrayList localArrayList2 = new ArrayList(i);
      ArrayList localArrayList1 = new ArrayList(i);
      Iterator localIterator = this.nM.iterator();
      while (localIterator.hasNext())
      {
        String str = ((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8();
        QQUserUIItem localQQUserUIItem = ((ptf)localObject).b(str);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList2.add(new QQUserUIItem.a("", str));
        } else {
          localArrayList1.add(localQQUserUIItem);
        }
      }
      if (localArrayList2.isEmpty())
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage load localData userIDS = " + localArrayList2);
        }
        this.blV += i;
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
        if (this.blV >= this.nL.size()) {}
        for (boolean bool = true;; bool = false)
        {
          QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool, localArrayList1);
          return;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage requestUserIds = " + localArrayList2);
      }
      this.jdField_a_of_type_Pxs.B(1, localArrayList2);
    }
    
    public void a(@NonNull pzm parampzm, @Nullable qat paramqat, @NonNull ErrorMessage paramErrorMessage)
    {
      int i = 0;
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onResponseOnUIThread errorMsg = " + paramErrorMessage);
      }
      if ((paramErrorMessage.isSuccess()) && (paramqat != null))
      {
        this.AI = paramqat.AE;
        this.AJ = paramqat.AF;
        if (this.AJ < this.AI) {
          this.AJ = this.AI;
        }
        if (this.AJ > 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.setTitle(QQStoryWatcherListActivity.axn + rpq.aL(this.AJ));
        }
        this.nL = paramqat.nE;
        if (QLog.isDevelopLevel())
        {
          parampzm = new StringBuilder().append("GetWatcherHelper: onResponseOnUIThread isSuccess mTotalWatcherCount = ").append(this.AI).append(", mTotalReadTime = ").append(this.AJ).append(", uinCount = ");
          if (this.nL != null) {
            break label244;
          }
        }
        for (;;)
        {
          QLog.w("Q.qqstory.player.watcherlist.activity", 2, i);
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.c != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.c.mViewTotalTime = this.AJ;
            ((qvf)psx.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.c);
          }
          bof();
          return;
          label244:
          i = this.nL.size();
        }
      }
      QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, false, false, null);
    }
    
    public void boe()
    {
      pzm localpzm = new pzm();
      localpzm.feedId = this.mFeedId;
      ppv.a().a(localpzm, this);
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherIds feedId = " + this.mFeedId);
      }
    }
    
    public void c(pxs.b paramb)
    {
      boolean bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onCallback errorInfo = " + paramb.b);
      }
      if (paramb.b.isSuccess())
      {
        int i = this.nM.size();
        Object localObject = (ptf)psx.a(2);
        paramb = new ArrayList(i);
        Iterator localIterator = this.nM.iterator();
        while (localIterator.hasNext())
        {
          QQUserUIItem localQQUserUIItem = ((ptf)localObject).b(((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8());
          if (localQQUserUIItem != null) {
            paramb.add(localQQUserUIItem);
          }
        }
        this.blV += i;
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
        if (this.blV >= this.nL.size()) {}
        for (bool = true;; bool = false)
        {
          QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool, paramb);
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.aDe)
      {
        paramb = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
        if (this.blV >= this.nL.size()) {}
        for (;;)
        {
          QQStoryWatcherListActivity.b(paramb, false, bool, null);
          return;
          bool = false;
        }
      }
      new Handler(Looper.getMainLooper()).post(new QQStoryWatcherListActivity.GetWatcherHelper.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */