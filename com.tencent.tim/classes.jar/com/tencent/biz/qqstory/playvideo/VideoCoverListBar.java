package com.tencent.biz.qqstory.playvideo;

import afei;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import psu;
import psx;
import qem;
import qgl;
import qgm;
import qwq;
import raj.a;
import ram;
import rar;
import rpn;
import rpq;

public class VideoCoverListBar
  extends ListView
{
  private a jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$a;
  private b jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$b;
  private c jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$c;
  private String axp;
  private afei jdField_b_of_type_Afei;
  private psu jdField_b_of_type_Psu;
  private int bmg;
  private int bmh;
  private int bmi;
  private int bmj;
  private afei c;
  private List<String> mVidList = new ArrayList();
  
  public VideoCoverListBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoCoverListBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void C(int paramInt, List<String> paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      ThreadManager.getUIHandler().post(new VideoCoverListBar.2(this, paramInt, paramList));
    }
    do
    {
      return;
      if (paramList == null) {}
      for (this.mVidList = new ArrayList();; this.mVidList = paramList)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$b.notifyDataSetChanged();
        if (this.mVidList.size() > 1) {
          break;
        }
        setVisibility(8);
        ram.d("Q.qqstory.player:VideoCoverListBar", "video list too small, hide");
        return;
      }
      setVisibility(0);
      if (paramInt >= 0) {
        ThreadManager.getUIHandler().postDelayed(new VideoCoverListBar.3(this, paramInt), 30L);
      }
    } while ((paramInt < 0) || (paramInt >= this.mVidList.size()));
    rar.a("play_video", "exp_mini", 0, 0, new String[] { "2", "", "", (String)this.mVidList.get(paramInt) });
  }
  
  private void init(Context paramContext)
  {
    this.jdField_b_of_type_Psu = ((psu)psx.a(5));
    int i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.bmg = getContext().getResources().getDimensionPixelOffset(2131299508);
    this.bmh = getContext().getResources().getDimensionPixelOffset(2131299507);
    this.bmi = getContext().getResources().getDimensionPixelOffset(2131299505);
    this.bmj = rpq.dip2px(paramContext, 11.0F);
    this.jdField_b_of_type_Afei = new afei(-2631721, this.bmg, this.bmh);
    this.c = new afei(0, this.bmg, this.bmh);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$b = new b(null);
    setOverScrollMode(2);
    setDivider(new ColorDrawable(0));
    setDividerHeight(this.bmj);
    setHeaderDividersEnabled(false);
    setFooterDividersEnabled(false);
    setVerticalScrollBarEnabled(false);
    setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$b);
    setOnTouchListener(new qgl(this, i));
  }
  
  public void a(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$c = paramc;
  }
  
  public void bom()
  {
    rF(this.axp);
  }
  
  public void bon()
  {
    C(-1, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$c.getData());
  }
  
  public void rF(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$c.getData();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (TextUtils.equals((CharSequence)localList.get(i), paramString))
        {
          this.axp = paramString;
          ram.b("Q.qqstory.player:VideoCoverListBar", "notify ! vid = %s , index = %d", paramString, Integer.valueOf(i));
          C(i, localList);
          return;
        }
        i += 1;
      }
    }
    C(-1, localList);
    ram.w("Q.qqstory.player:VideoCoverListBar", "vid not found ! vid = %s", new Object[] { paramString });
  }
  
  public void setOnVideoClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void rG(String paramString);
  }
  
  public class b
    extends BaseAdapter
  {
    private b() {}
    
    public int getCount()
    {
      return VideoCoverListBar.a(VideoCoverListBar.this).size();
    }
    
    public String getItem(int paramInt)
    {
      return (String)VideoCoverListBar.a(VideoCoverListBar.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(VideoCoverListBar.this.getContext()).inflate(2131561930, null);
        paramView = new a(localView);
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.wj(paramInt);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        a locala = (a)paramView.getTag();
        localView = paramView;
        paramView = locala;
      }
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public class a
    {
      private VideoCoverImgBorder a;
      private TextView mTimeText;
      private String mVid;
      
      public a(View paramView)
      {
        this.a = ((VideoCoverImgBorder)paramView.findViewById(2131363584));
        this.mTimeText = ((TextView)paramView.findViewById(2131379661));
        this.a.setOnClickListener(new qgm(this, VideoCoverListBar.b.this));
      }
      
      private void br(String paramString, int paramInt)
      {
        if (TextUtils.isEmpty(paramString))
        {
          rpq.a(this.a, paramString, VideoCoverListBar.a(VideoCoverListBar.this), VideoCoverListBar.a(VideoCoverListBar.this), VideoCoverListBar.c(VideoCoverListBar.this), VideoCoverListBar.d(VideoCoverListBar.this), "VideoCoverList");
          return;
        }
        rpq.a(this.a, paramString, VideoCoverListBar.a(VideoCoverListBar.this), VideoCoverListBar.b(VideoCoverListBar.this), VideoCoverListBar.c(VideoCoverListBar.this), VideoCoverListBar.d(VideoCoverListBar.this), "VideoCoverList");
      }
      
      public void wj(int paramInt)
      {
        ram.b("Q.qqstory.player:VideoCoverListBar", "bindView, position=%d", Integer.valueOf(paramInt));
        this.mVid = VideoCoverListBar.b.this.getItem(paramInt);
        Object localObject = VideoCoverListBar.a(VideoCoverListBar.this).b(this.mVid);
        if (localObject == null)
        {
          localObject = new StoryVideoItem();
          ((StoryVideoItem)localObject).mVid = this.mVid;
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(((StoryVideoItem)localObject).getThumbUrl()))
          {
            br(rpn.gm(((StoryVideoItem)localObject).getThumbUrl()), paramInt);
            if (!((StoryVideoItem)localObject).isUploadFail()) {
              break label177;
            }
            this.a.setState(0);
          }
          for (;;)
          {
            if ((!VideoCoverListBar.a(VideoCoverListBar.this).Jw()) && (!VideoCoverListBar.a(VideoCoverListBar.this).Jx())) {
              break label246;
            }
            this.mTimeText.setText("");
            this.a.clearColorFilter();
            return;
            br(rpn.gm(raj.a.gb(((StoryVideoItem)localObject).mVideoLocalThumbnailPath)), paramInt);
            break;
            label177:
            if (TextUtils.isEmpty(VideoCoverListBar.a(VideoCoverListBar.this))) {
              this.a.setState(2);
            } else if (TextUtils.equals(this.mVid, VideoCoverListBar.a(VideoCoverListBar.this))) {
              this.a.setState(1);
            } else {
              this.a.setState(2);
            }
          }
          label246:
          if ((qem.d((StoryVideoItem)localObject)) || (((StoryVideoItem)localObject).mErrorCode != 0))
          {
            this.mTimeText.setText("");
            this.a.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
            return;
          }
          long l2 = ((StoryVideoItem)localObject).mCreateTime;
          long l1;
          if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L) {
            l1 = ((StoryVideoItem)localObject).mTimeZoneOffsetMillis;
          }
          for (boolean bool = true;; bool = false)
          {
            localObject = qwq.a(l2, l1, bool, false, true);
            this.mTimeText.setText((CharSequence)localObject);
            this.a.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
            return;
            l1 = TimeZone.getDefault().getRawOffset();
          }
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean Jw();
    
    public abstract boolean Jx();
    
    public abstract List<String> getData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar
 * JD-Core Version:    0.7.0.1
 */