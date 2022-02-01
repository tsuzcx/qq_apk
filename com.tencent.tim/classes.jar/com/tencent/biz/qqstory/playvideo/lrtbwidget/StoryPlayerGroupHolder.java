package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import ankt;
import ayxa;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import plt;
import puy;
import qgy.c;
import qgy.d;
import qhc.a;
import qip;
import qis;
import qiv;
import qiw;
import qiz;
import qjk;
import qjm;
import qjn;
import qjo;
import qjp;
import qjq;
import qjs;
import qjw;
import qjx;
import qmm;
import qmo;
import qmy;
import qng;
import qnu;
import qnv;
import qny;
import qoe;
import ram;

public class StoryPlayerGroupHolder
  extends qis
{
  public StoryPlayerVideoAdapter a;
  private VideoViewVideoHolder.j jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$j;
  private XViewPager.f jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f = new qjn(this);
  public XViewPager a;
  private VideoViewVideoHolder.j b = new qjo(this);
  public int bmz = -1;
  private qjk c;
  private ViewGroup cp;
  private qiw e;
  private int mPlayerRepeatMode = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, qjk paramqjk)
  {
    super(paramViewGroup);
    this.c = paramqjk;
    boC();
    a(new qjs((ViewGroup)this.mItemView));
    a(new qip((ViewGroup)this.mItemView));
    a(new qiz((ViewGroup)this.mItemView));
    a(new qoe(this.mItemView.findViewById(2131382204)));
    a(new qny((LinearLayout)this.mItemView.findViewById(2131381319)));
    a(new qmy((LinearLayout)this.mItemView.findViewById(2131365783)));
    a(new qmm((LinearLayout)this.mItemView.findViewById(2131363290)));
    a(new qnv((LinearLayout)this.mItemView.findViewById(2131373670)));
    a(new qmo((LinearLayout)this.mItemView.findViewById(2131363686)));
    a(new qiv((LinearLayout)this.mItemView.findViewById(2131370783)));
    a(new qng(this.mItemView.findViewById(2131377332).findViewById(2131371943)));
    a(new qnu(this.mItemView.findViewById(2131372295)));
  }
  
  private void boC()
  {
    if (ayxa.sHasNotch)
    {
      View localView = this.mItemView.findViewById(2131373405);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (ayxa.sNotchHeight / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int sE()
  {
    boolean bool = ankt.bA(this.mItemView.getContext());
    ram.d("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(ankt.cIE - ankt.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  public boolean JH()
  {
    return this.bmz == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1;
  }
  
  public boolean JI()
  {
    boolean bool = false;
    if ((this.d instanceof qhc.a)) {
      bool = puy.a(QQStoryContext.a()).fh(((qhc.a)this.d).getUnionId());
    }
    return bool;
  }
  
  public boolean JJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.c.a().groupId, this.d.groupId))
    {
      localObject = fX(this.d.groupId);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      ram.b(this.TAG, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        b((qjw)localObject);
        bool1 = true;
      }
    }
    return bool1;
    label83:
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).size()) {
        break;
      }
      qjw localqjw = (qjw)StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localqjw.a.vid, (CharSequence)localObject))
      {
        b(localqjw);
        return true;
      }
      i += 1;
    }
  }
  
  public VideoViewVideoHolder a()
  {
    qjw localqjw = a();
    if (localqjw != null) {
      return (VideoViewVideoHolder)localqjw.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public qjw a()
  {
    return a(this.bmz);
  }
  
  public qjw a(int paramInt)
  {
    qjw localqjw = null;
    if (paramInt >= 0)
    {
      XViewPager.b localb = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localb != null) {
        localqjw = (qjw)localb.object;
      }
      return localqjw;
    }
    ram.w(this.TAG, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, qgy.d paramd, @NonNull ArrayList<qjq> paramArrayList)
  {
    boolean bool = this.aDy;
    super.a(paramInt, paramd, paramArrayList);
    if (bool)
    {
      ram.d(this.TAG, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.bmu), Integer.valueOf(paramInt), Integer.valueOf(this.nR.size()), Integer.valueOf(paramArrayList.size()), paramd.d.groupId });
      this.mPlayerRepeatMode = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.r(paramArrayList, paramInt);
      paramd = fX(paramd.d.groupId);
      if (paramd == null) {
        break label621;
      }
      paramInt = 0;
      label125:
      if (paramInt >= paramArrayList.size()) {
        break label621;
      }
      if (!TextUtils.equals(((qjq)paramArrayList.get(paramInt)).vid, paramd)) {
        break label305;
      }
    }
    for (;;)
    {
      paramd = (qiv)b(qiv.class);
      if ((JI()) && (paramd != null) && (paramd.isShow()))
      {
        ram.b(this.TAG + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramd.boA();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          ram.b(this.TAG + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          ram.a(this.TAG, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramd.d.groupId);
          break;
          label305:
          paramInt += 1;
          break label125;
        }
        paramd = a();
        if ((paramd instanceof qjx))
        {
          paramd = (VideoViewVideoHolder)((qjx)paramd).b(VideoViewVideoHolder.class);
          if (paramd != null)
          {
            paramd.boG();
            ram.b(this.TAG + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem();
        ram.b(this.TAG, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          ram.d(this.TAG, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.bmu), Integer.valueOf(paramArrayList.size()), this.d.groupId, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem()), Integer.valueOf(paramInt), Integer.valueOf(this.mPlayerRepeatMode) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() != paramInt) {
            break label609;
          }
          paramd = a(paramInt);
          ram.b(this.TAG, "onBind, getPageHolderOfPosition = %s", paramd);
          if ((paramd != null) && (paramd.isSelected())) {
            break label593;
          }
          ram.b(this.TAG, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f.onPageSelected(paramInt);
          paramd = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.bP().iterator();
          while (paramd.hasNext()) {
            ((XViewPager.f)paramd.next()).onPageSelected(paramInt);
          }
          break;
          paramInt = 0;
        }
        label593:
        ram.b(this.TAG, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramd);
        return;
        label609:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label621:
      paramInt = -1;
    }
  }
  
  public void a(qiw paramqiw, VideoViewVideoHolder.j paramj)
  {
    this.e = paramqiw;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$j = paramj;
  }
  
  public void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    qip localqip;
    if (paramBoolean1)
    {
      this.cp.setVisibility(0);
      if (paramBoolean2)
      {
        localqip = (qip)a(qip.class);
        if (localqip != null) {
          localqip.mItemView.setVisibility(0);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.cp.setVisibility(4);
      } while (!paramBoolean2);
      localqip = (qip)a(qip.class);
    } while (localqip == null);
    localqip.mItemView.setVisibility(4);
  }
  
  public void boy()
  {
    super.boy();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.r(new ArrayList(0), this.bmu);
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.mItemView.findViewById(2131381896));
    int i = (int)this.mItemView.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.3F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(true, true, false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    XViewPager localXViewPager = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    StoryPlayerVideoAdapter localStoryPlayerVideoAdapter = new StoryPlayerVideoAdapter(a(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter = localStoryPlayerVideoAdapter;
    localXViewPager.setAdapter(localStoryPlayerVideoAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$f);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new qjm(this));
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561991, paramViewGroup, false);
    this.cp = ((ViewGroup)paramViewGroup.findViewById(2131377253));
    return paramViewGroup;
  }
  
  public String toString()
  {
    return "VerticalPagerHolder{mPosition=" + this.bmu + ", mData=" + this.nR + '}';
  }
  
  public class StoryPlayerVideoAdapter
    extends PagerAdapter
  {
    private String TAG = "Q.qqstory.playernew.StoryPlayerVideoAdapter";
    private SparseArray<qjw> aL = new SparseArray();
    private StoryPlayerGroupHolder jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    private qjp jdField_b_of_type_Qjp;
    private VideoViewVideoHolder.j c;
    private ArrayList<qjq> kr = new ArrayList();
    private int verticalPosition = -1;
    
    public StoryPlayerVideoAdapter(qjp paramqjp, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
    {
      this.jdField_b_of_type_Qjp = paramqjp;
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = paramStoryPlayerGroupHolder;
    }
    
    public void a(VideoViewVideoHolder.j paramj)
    {
      this.c = paramj;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      ram.a(this.TAG, "destroyItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s", Integer.valueOf(this.verticalPosition), Integer.valueOf(paramInt), this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.d.groupId);
      paramObject = (qjw)paramObject;
      if (paramObject.isSelected()) {
        paramObject.sE(false);
      }
      paramObject.boy();
      paramViewGroup.removeView(paramObject.mItemView);
      this.jdField_b_of_type_Qjp.recycle(paramObject);
      this.aL.remove(paramInt);
    }
    
    public int getCount()
    {
      return this.kr.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      paramObject = (qjw)paramObject;
      int i = 0;
      while (i < this.kr.size())
      {
        if (TextUtils.equals(((qjq)this.kr.get(i)).vid, paramObject.a.vid))
        {
          if (paramObject.bmB == i)
          {
            ram.a(this.TAG, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_UNCHANGED, vid = %s", Integer.valueOf(this.verticalPosition), Integer.valueOf(paramObject.bmB), paramObject.a.vid);
            if (paramObject.bmn != this.verticalPosition) {
              paramObject.dU(this.verticalPosition, i);
            }
            return -1;
          }
          ram.a(this.TAG, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_%d, vid = %s", Integer.valueOf(this.verticalPosition), Integer.valueOf(paramObject.bmB), Integer.valueOf(i), paramObject.a.vid);
          this.aL.remove(paramObject.bmB);
          paramObject.dU(this.verticalPosition, i);
          this.aL.put(i, paramObject);
          return i;
        }
        i += 1;
      }
      ram.w(this.TAG, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_NONE, old vid=%s, groupId=%s, id=%d", new Object[] { Integer.valueOf(this.verticalPosition), Integer.valueOf(paramObject.bmB), paramObject.a.vid, this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.d.groupId, Integer.valueOf(System.identityHashCode(this)) });
      return -2;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ram.a(this.TAG, "instantiateItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s, vid=%s", Integer.valueOf(this.verticalPosition), Integer.valueOf(paramInt), this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.d.groupId, ((qjq)this.kr.get(paramInt)).vid);
      qjx localqjx = (qjx)this.jdField_b_of_type_Qjp.c(qjx.class);
      if (localqjx == null)
      {
        localqjx = new qjx(paramViewGroup);
        localqjx.a(localqjx);
        localqjx.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
        localqjx.onCreate();
      }
      for (;;)
      {
        paramViewGroup.addView(localqjx.mItemView);
        paramViewGroup = (VideoViewVideoHolder)localqjx.b(VideoViewVideoHolder.class);
        if (paramViewGroup != null) {
          paramViewGroup.a(this.c);
        }
        Object localObject = (qjq)this.kr.get(paramInt);
        localqjx.a(this.verticalPosition, paramInt, (qjq)localObject, this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
        this.aL.put(paramInt, localqjx);
        localObject = StoryPlayerGroupHolder.this.fX(StoryPlayerGroupHolder.this.d.groupId);
        if ((StoryPlayerGroupHolder.this.Jv()) && ((TextUtils.equals(localqjx.a.vid, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == StoryPlayerGroupHolder.this.a.getCurrentItem())) || (TextUtils.equals(StoryPlayerGroupHolder.a(StoryPlayerGroupHolder.this).a().groupId, StoryPlayerGroupHolder.this.d.groupId))) && (paramViewGroup != null))
        {
          if (paramInt != StoryPlayerGroupHolder.this.a.getCurrentItem() + 1) {
            break label373;
          }
          ram.b(this.TAG, "pre-prepared video instantiateItem [↓]. video = %s", localqjx);
          paramViewGroup.aK(8, "onBind:pre-prepared");
        }
        label407:
        for (;;)
        {
          if ((TextUtils.equals(StoryPlayerGroupHolder.a(StoryPlayerGroupHolder.this).a().groupId, StoryPlayerGroupHolder.this.d.groupId)) && ((TextUtils.equals(localqjx.a.vid, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == StoryPlayerGroupHolder.this.a.getCurrentItem()))))
          {
            ram.b(this.TAG, "instantiateItem, setSelected => %s", localqjx);
            StoryPlayerGroupHolder.this.b(localqjx);
          }
          return localqjx;
          label373:
          if (paramViewGroup.a != null) {}
          for (paramViewGroup = paramViewGroup.a.vid;; paramViewGroup = null)
          {
            if ((paramViewGroup == null) || (paramViewGroup.startsWith("Loading"))) {
              break label407;
            }
            break;
          }
        }
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == ((qjw)paramObject).mItemView;
    }
    
    public void r(@NonNull ArrayList<qjq> paramArrayList, int paramInt)
    {
      this.TAG = ("Q.qqstory.playernew.StoryPlayerVideoAdapter" + System.identityHashCode(this) + "[" + paramInt + "]");
      ram.a(this.TAG, "setDataList, DataSize=%d, VerticalPosition=%d, VidList=%s", Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt), paramArrayList);
      this.kr.clear();
      this.kr.addAll(paramArrayList);
      this.verticalPosition = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public static class a
    extends plt
  {
    @Nullable
    public final File file;
    public final boolean isSuccess;
    public final String vid;
    
    public a(String paramString, boolean paramBoolean, File paramFile)
    {
      this.vid = paramString;
      this.isSuccess = paramBoolean;
      this.file = paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */