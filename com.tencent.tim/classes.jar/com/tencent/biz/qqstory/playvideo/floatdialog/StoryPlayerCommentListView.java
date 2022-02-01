package com.tencent.biz.qqstory.playvideo.floatdialog;

import acfp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pmi;
import pqs;
import pqy;
import ptq;
import qhy;
import qhy.g;
import qib;
import qic;
import qid;
import qie;
import qif;
import qru;
import ram;
import rar;
import rsd;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, AdapterView.c, AdapterView.d
{
  private a jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a;
  private b jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$b;
  private qhy jdField_a_of_type_Qhy;
  public int mSource;
  private List<rsd> nQ = new ArrayList();
  
  public StoryPlayerCommentListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    qru localqru = this.jdField_a_of_type_Qhy.a();
    if ((localqru == null) || (localqru.d == null))
    {
      ram.w("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    pqs localpqs;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localpqs = new pqs(2, paramCommentEntry.feedId, paramInt);
      localpqs.commentId = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localpqs;; paramCommentEntry = new pqs(2, localqru.d.feedId, paramInt, localqru.d))
    {
      paramCommentEntry.c = localqru.d;
      pmi.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void init()
  {
    setOnLoadMoreListener("CommentFloatDialog", new qif(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a.close();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < sC()) {
      return false;
    }
    paramInt -= sC();
    paramView = ((qid)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ram.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Qhy.a();
    if ((paramAdapterView != null) && (paramAdapterView.d != null)) {
      if (!paramAdapterView.d.getOwner().isMe()) {
        break label143;
      }
    }
    label143:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      rar.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, rar.bX(this.mSource) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Qhy.sD(this.jdField_a_of_type_Qhy.isOpen());
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a.b(paramView, paramInt, this.jdField_a_of_type_Qhy.sB());
    }
    return true;
  }
  
  public void b(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qhy.a(paramCommentEntry, paramBoolean);
    pqy.a().bmw();
    azy();
    QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131714969), 0).show();
    a(2, paramCommentEntry);
  }
  
  public void b(@NonNull qhy paramqhy, a parama, int paramInt)
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a = parama;
    this.jdField_a_of_type_Qhy = paramqhy;
    this.mSource = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$b = new b(null);
    this.jdField_a_of_type_Qhy.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$b);
    qid localqid = (qid)a("PlayerCommentSegment");
    if (localqid != null) {
      localqid.a(paramqhy, parama, this.mSource);
    }
    parama = (qic)a("PlayerCommentEmptySegment");
    if (parama != null) {
      parama.a(paramqhy);
    }
    parama = (qie)a("PlayerDoubleTabSegment");
    if (parama != null) {
      parama.a(paramqhy);
    }
  }
  
  public void box()
  {
    super.setActTAG("list_qqstory_detail");
    Object localObject = new qie(getContext());
    qid localqid = new qid(getContext());
    qic localqic = new qic(getContext());
    qib localqib = new qib(getContext(), 30);
    this.nQ.add(localObject);
    this.nQ.add(localqib);
    this.nQ.add(localqid);
    this.nQ.add(localqic);
    localObject = this.nQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((rsd)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < sC()) {}
    do
    {
      return;
      paramInt -= sC();
      paramAdapterView = ((qid)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        ram.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Qhy.sD(this.jdField_a_of_type_Qhy.isOpen());
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a == null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a.a(paramAdapterView, paramInt, this.jdField_a_of_type_Qhy.sB());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void pn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.xT(1);
      return;
    }
    super.eu(1, buK);
  }
  
  public int sC()
  {
    Iterator localIterator = this.nQ.iterator();
    rsd localrsd;
    for (int i = 0;; i = localrsd.getCount() + i) {
      if (localIterator.hasNext())
      {
        localrsd = (rsd)localIterator.next();
        if (!(localrsd instanceof qid)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public int sD()
  {
    Iterator localIterator = this.nQ.iterator();
    int i = 0;
    rsd localrsd;
    if (localIterator.hasNext())
    {
      localrsd = (rsd)localIterator.next();
      if ((localrsd instanceof qid)) {
        i = localrsd.getCount() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localrsd.getCount() + i;
        break;
      }
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
    
    public abstract void a(@NonNull qru paramqru, ErrorMessage paramErrorMessage);
    
    public abstract void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
    
    public abstract void close();
    
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  class b
    implements qhy.g
  {
    private b() {}
    
    public void a(@NonNull qru paramqru, ErrorMessage paramErrorMessage, boolean paramBoolean)
    {
      Object localObject;
      if (paramErrorMessage.isSuccess())
      {
        localObject = "suc";
        ram.b("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramqru);
        boolean bool = StoryPlayerCommentListView.a(StoryPlayerCommentListView.this).isOpen();
        localObject = (qid)StoryPlayerCommentListView.this.a("PlayerCommentSegment");
        if (localObject != null) {
          ((qid)localObject).c(paramqru);
        }
        localObject = (qie)StoryPlayerCommentListView.this.a("PlayerDoubleTabSegment");
        if (localObject != null) {
          ((qie)localObject).c(paramqru);
        }
        localObject = (qic)StoryPlayerCommentListView.this.a("PlayerCommentEmptySegment");
        if (localObject != null)
        {
          ((qic)localObject).c(paramqru);
          if (!paramBoolean) {
            break label183;
          }
          ((qic)localObject).setLoading(true);
        }
        label118:
        localObject = StoryPlayerCommentListView.this;
        if (paramqru.Y(bool)) {
          break label192;
        }
      }
      label183:
      label192:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
        StoryPlayerCommentListView.this.azy();
        if (StoryPlayerCommentListView.a(StoryPlayerCommentListView.this) != null) {
          StoryPlayerCommentListView.a(StoryPlayerCommentListView.this).a(paramqru, paramErrorMessage);
        }
        return;
        localObject = "fail";
        break;
        ((qic)localObject).setLoading(false);
        break label118;
      }
    }
    
    public void a(@NonNull qru paramqru, boolean paramBoolean)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = "suc";
        ram.b("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramqru);
        boolean bool = StoryPlayerCommentListView.a(StoryPlayerCommentListView.this).isOpen();
        localObject = (qid)StoryPlayerCommentListView.this.a("PlayerCommentSegment");
        if (localObject != null) {
          ((qid)localObject).c(paramqru);
        }
        localObject = (qie)StoryPlayerCommentListView.this.a("PlayerDoubleTabSegment");
        if (localObject != null) {
          ((qie)localObject).c(paramqru);
        }
        localObject = (qic)StoryPlayerCommentListView.this.a("PlayerCommentEmptySegment");
        if (localObject != null)
        {
          ((qic)localObject).c(paramqru);
          ((qic)localObject).setLoading(false);
        }
        if (!paramBoolean) {
          break label159;
        }
        localObject = StoryPlayerCommentListView.this;
        if (paramqru.Y(bool)) {
          break label154;
        }
        paramBoolean = true;
        label130:
        ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
      }
      for (;;)
      {
        StoryPlayerCommentListView.this.azy();
        return;
        localObject = "fail";
        break;
        label154:
        paramBoolean = false;
        break label130;
        label159:
        StoryPlayerCommentListView.this.setLoadMoreComplete("CommentFloatDialog", false, false);
      }
    }
    
    public void bow()
    {
      StoryPlayerCommentListView.this.azy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */