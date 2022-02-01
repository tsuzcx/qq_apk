import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class rmd
  implements View.OnClickListener
{
  private String TAG = "SlideShowViewController";
  private rlv jdField_a_of_type_Rlv;
  private rmd.a jdField_a_of_type_Rmd$a;
  private SlideProgressNotifier b;
  private Activity mContext;
  private View mDivider;
  private LinearLayoutManager mLinearLayoutManager;
  private View mRootView;
  private int mTotalDuration = 20999;
  private RecyclerView o;
  private TextView yP;
  private TextView yQ;
  private TextView yR;
  private TextView yS;
  
  public rmd(Activity paramActivity, rmd.a parama)
  {
    this.mContext = paramActivity;
    this.jdField_a_of_type_Rmd$a = parama;
    initUI();
    update();
  }
  
  private boolean LJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mContext != null)
    {
      bool1 = bool2;
      if (this.mContext.getIntent() != null)
      {
        bool1 = bool2;
        if (this.mContext.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void dT(View paramView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator1.setDuration(240L);
    localObjectAnimator1.setInterpolator(new rlp(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator1.setStartDelay(0L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator2.setDuration(260L);
    localObjectAnimator2.setInterpolator(new rlp(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator2.setStartDelay(237L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator3.setDuration(270L);
    localObjectAnimator3.setInterpolator(new rlp(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator3.setStartDelay(495L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    paramView.setDuration(240L);
    paramView.setInterpolator(new rlp(0.33F, 0.0F, 0.67F, 1.0F));
    paramView.setStartDelay(763L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramView });
    localAnimatorSet.start();
  }
  
  private void initUI()
  {
    this.mRootView = this.mContext.findViewById(2131375241);
    this.mRootView.setVisibility(0);
    this.mDivider = this.mContext.findViewById(2131375237);
    this.mDivider.setVisibility(0);
    int i;
    if ((this.mContext instanceof NewPhotoListActivity))
    {
      i = 1;
      if (i == 0) {
        break label354;
      }
      this.mRootView.setBackgroundColor(-526087);
      this.mDivider.setBackgroundColor(-3026479);
    }
    for (;;)
    {
      this.o = ((RecyclerView)this.mRootView.findViewById(2131375243));
      this.mLinearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
      this.o.setLayoutManager(this.mLinearLayoutManager);
      this.jdField_a_of_type_Rlv = new rlv(this.mRootView.getContext(), this, this.jdField_a_of_type_Rmd$a);
      this.jdField_a_of_type_Rlv.bJ(rma.a().getPhotoList());
      this.o.setAdapter(this.jdField_a_of_type_Rlv);
      this.o.getRecycledViewPool().setMaxRecycledViews(this.jdField_a_of_type_Rlv.getItemViewType(0), 10);
      this.jdField_a_of_type_Rlv.a(new rme(this));
      new auwd(new rlz(this.jdField_a_of_type_Rlv)).attachToRecyclerView(this.o);
      this.yQ = ((TextView)this.mRootView.findViewById(2131375244));
      this.yP = ((TextView)this.mRootView.findViewById(2131375245));
      this.yR = ((TextView)this.mRootView.findViewById(2131375236));
      this.yR.setOnClickListener(this);
      this.yS = ((TextView)this.mRootView.findViewById(2131375235));
      this.yS.setOnClickListener(this);
      this.b = new SlideProgressNotifier(this.mContext, 2131561628);
      if (LJ())
      {
        this.mTotalDuration = 60000;
        rma.a().xJ(this.mTotalDuration);
      }
      return;
      i = 0;
      break;
      label354:
      this.mRootView.setBackgroundColor(1996488704);
      this.mDivider.setBackgroundColor(-1728053248);
    }
  }
  
  public void blB()
  {
    if (this.b != null)
    {
      this.b.destroy();
      this.b.dismiss();
    }
  }
  
  public void bvv()
  {
    List localList = rma.a().getPhotoList();
    if ((this.mLinearLayoutManager != null) && (this.o != null))
    {
      int i = this.mLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.mLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject = this.mLinearLayoutManager.findViewByPosition(i);
        if (localObject != null)
        {
          localObject = this.o.getChildViewHolder((View)localObject);
          if ((localObject instanceof rlv.a))
          {
            SlideItemInfo localSlideItemInfo1 = (SlideItemInfo)((rlv.a)localObject).mRoot.getTag();
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              SlideItemInfo localSlideItemInfo2 = (SlideItemInfo)localIterator.next();
              if ((localSlideItemInfo1.mSrcPath.equals(localSlideItemInfo2.mSrcPath)) && (localSlideItemInfo2.aIO))
              {
                localSlideItemInfo2.aIO = false;
                dT(((rlv.a)localObject).mRoot);
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void bvw()
  {
    if (this.b != null)
    {
      this.b.destroy();
      this.b.dismiss();
      List localList = rma.a().getPhotoList();
      Iterator localIterator = localList.iterator();
      for (int i = 0; localIterator.hasNext(); i = (int)((SlideItemInfo)localIterator.next()).dU() + i) {}
      int j = i;
      if (i == 0) {
        j = 5000;
      }
      i = (int)(j * 1.5D);
      j = (int)(localList.size() * 1.0D / (localList.size() + 1) * 100.0D);
      this.b.u(0, i, j, 0);
    }
  }
  
  public void bvx()
  {
    if (this.b != null)
    {
      List localList = rma.a().getPhotoList();
      int j = localList.size();
      int i = j;
      if (j == 0) {
        i = 1;
      }
      j = (int)(localList.size() * 1.0D / (localList.size() + 1) * 100.0D);
      this.b.ah(i * 1000, 99, j);
    }
  }
  
  public String nb()
  {
    if (this.jdField_a_of_type_Rlv != null) {
      return this.jdField_a_of_type_Rlv.nb();
    }
    return "";
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131378493: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = (SlideItemInfo)paramView.getTag();
        i = rma.a().getPhotoList().indexOf(localObject1);
        if ((this.jdField_a_of_type_Rmd$a != null) && (localObject1 != null)) {
          this.jdField_a_of_type_Rmd$a.sA(((SlideItemInfo)localObject1).mSrcPath);
        }
        xH(i);
      }
    case 2131375236: 
      if ((this.mContext instanceof NewPhotoListActivity))
      {
        i = 0;
        label117:
        if (rma.a().tF() != 11) {
          break label335;
        }
        j = 1;
        label130:
        localObject1 = rma.a().getPhotoList();
        if ((j == 0) || (i == 0) || (((List)localObject1).size() != 0)) {
          break label340;
        }
        if (this.jdField_a_of_type_Rmd$a != null) {
          this.jdField_a_of_type_Rmd$a.bvy();
        }
        localObject1 = rma.a().getPhotoList();
        if ((((List)localObject1).size() >= 1) && (((List)localObject1).size() <= 10) && (((SlideItemInfo)((List)localObject1).get(0)).dU() <= 20999L)) {
          rma.a().a(this.mContext, null, 2);
        }
      }
      for (;;)
      {
        try
        {
          if (rma.a().tF() != 13) {
            break;
          }
          rar.a("pic_fictitious", "clk_next", this.mContext.getIntent(), new String[0]);
          if ((!rma.a().LI()) || (this.mContext == null)) {
            break;
          }
          rar.a("video_edit_new", "change_pic", this.mContext.getIntent(), new String[0]);
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.TAG, 2, aurp.getStackTraceAsString(localException));
        break;
        i = 1;
        break label117;
        label335:
        j = 0;
        break label130;
        label340:
        rma.a().a(this.mContext, null, 2);
        if ((this.mContext != null) && (this.mContext.getIntent().getBooleanExtra("from_qzone_slideshow", false))) {
          if ((this.mContext instanceof NewPhotoListActivity)) {
            rma.a().xK(14);
          } else if ((this.mContext instanceof NewPhotoPreviewActivity)) {
            rma.a().xK(19);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "qqstory_slideshow_auto_optimize");
    }
    Object localObject2 = rma.a().getPhotoList().iterator();
    int k = 0;
    int j = 0;
    int i = 0;
    label455:
    SlideItemInfo localSlideItemInfo;
    int n;
    if (((Iterator)localObject2).hasNext())
    {
      localSlideItemInfo = (SlideItemInfo)((Iterator)localObject2).next();
      n = k + 1;
      if (localSlideItemInfo.mediaType == 1)
      {
        k = j;
        j = i + 1;
        i = k;
      }
    }
    for (;;)
    {
      int m = j;
      k = n;
      j = i;
      i = m;
      break label455;
      if (localSlideItemInfo.mediaType == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        if ((this.mContext instanceof NewPhotoListActivity))
        {
          m = 1;
          label551:
          if (rma.a().tF() != 11) {
            break label689;
          }
          n = 1;
          label565:
          if (n == 0) {
            break label695;
          }
          n = 0;
          label573:
          if (m == 0) {
            break label701;
          }
        }
        label689:
        label695:
        label701:
        for (localObject2 = "0";; localObject2 = "1")
        {
          rar.a("pic_choose", "clk_autoCut", n, 0, new String[] { localObject2, k + "", j + "", i + "" });
          rma.a().bvv();
          break;
          m = 0;
          break label551;
          n = 0;
          break label565;
          n = 1;
          break label573;
        }
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public void update()
  {
    int k;
    int m;
    label27:
    int n;
    label40:
    List localList;
    if (rma.a().tG() == 22)
    {
      k = 1;
      if (rma.a().tF() != 11) {
        break label124;
      }
      m = 1;
      if (!(this.mContext instanceof NewPhotoListActivity)) {
        break label130;
      }
      n = 1;
      localList = rma.a().getPhotoList();
      if (localList == null) {
        break label966;
      }
    }
    label130:
    label322:
    label966:
    for (int i1 = localList.size();; i1 = 0)
    {
      long l = 0L;
      Object localObject;
      SlideItemInfo localSlideItemInfo;
      label124:
      int i;
      int j;
      int i2;
      int i4;
      if (i1 > 0)
      {
        localObject = localList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
            if (localSlideItemInfo != null)
            {
              l += localSlideItemInfo.dU();
              continue;
              k = 0;
              break;
              m = 0;
              break label27;
              n = 0;
              break label40;
            }
          }
        }
        if ((l > this.mTotalDuration) && (k == 0))
        {
          this.yQ.setTextColor(this.mContext.getResources().getColor(2131167465));
          this.yP.setTextColor(this.mContext.getResources().getColor(2131167465));
          if (this.yS.getVisibility() != 0)
          {
            localObject = rma.a().getPhotoList().iterator();
            i = 0;
            j = 0;
            i2 = 0;
            if (((Iterator)localObject).hasNext())
            {
              localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
              i4 = i2 + 1;
              if (localSlideItemInfo.mediaType == 1)
              {
                i2 = j;
                j = i + 1;
                i = i2;
              }
            }
          }
        }
      }
      for (;;)
      {
        int i3 = j;
        i2 = i4;
        j = i;
        i = i3;
        break;
        if (localSlideItemInfo.mediaType == 0)
        {
          i2 = j + 1;
          j = i;
          i = i2;
          continue;
          if (m != 0)
          {
            i3 = 0;
            if (n == 0) {
              break label544;
            }
            localObject = "0";
            rar.a("pic_choose", "exp_autoCut", i3, 0, new String[] { localObject, i2 + "", j + "", i + "" });
            this.yS.setVisibility(0);
            if (k == 0) {
              this.yQ.setText(this.mContext.getString(2131701772, new Object[] { Integer.valueOf(this.mTotalDuration / 1000) }));
            }
            this.yP.setText(rmc.formatTimeToString(l));
            this.yP.setVisibility(0);
            this.o.setVisibility(0);
            if (k == 0) {
              break label782;
            }
            localObject = this.yR;
            if ((i1 < 2) || (i1 > 30)) {
              break label776;
            }
            bool = true;
            ((TextView)localObject).setEnabled(bool);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Rlv != null) {
              this.jdField_a_of_type_Rlv.bJ(localList);
            }
            return;
            i3 = 1;
            break;
            localObject = "1";
            break label322;
            if (n != 0)
            {
              this.yQ.setTextColor(this.mContext.getResources().getColor(2131167196));
              this.yP.setTextColor(this.mContext.getResources().getColor(2131167466));
            }
            for (;;)
            {
              this.yS.setVisibility(8);
              break;
              this.yQ.setTextColor(this.mContext.getResources().getColor(2131167654));
              this.yP.setTextColor(this.mContext.getResources().getColor(2131167654));
            }
            if (n != 0)
            {
              this.yQ.setTextColor(this.mContext.getResources().getColor(2131167196));
              if ((m != 0) || (k != 0)) {
                break label756;
              }
              this.yQ.setText(this.mContext.getString(2131701774));
            }
            for (;;)
            {
              this.o.setVisibility(8);
              this.yP.setVisibility(8);
              this.yS.setVisibility(8);
              break;
              this.yQ.setTextColor(this.mContext.getResources().getColor(2131167654));
              break label677;
              label756:
              this.yQ.setText(this.mContext.getString(2131701773));
            }
            bool = false;
            break label514;
            if (m == 0)
            {
              localObject = this.yR;
              if ((i1 >= 2) && (i1 <= 10) && (l <= this.mTotalDuration)) {}
              for (bool = true;; bool = false)
              {
                ((TextView)localObject).setEnabled(bool);
                break;
              }
            }
            if (n != 0)
            {
              localObject = this.yR;
              if ((i1 >= 1) && (i1 <= 10) && (l <= this.mTotalDuration)) {}
              for (bool = true;; bool = false)
              {
                ((TextView)localObject).setEnabled(bool);
                break;
              }
            }
            if (i1 != 0) {
              break label906;
            }
            this.yR.setEnabled(true);
          }
          localObject = this.yR;
          if ((i1 >= 1) && (i1 <= 10) && (l <= this.mTotalDuration)) {}
          for (boolean bool = true;; bool = false)
          {
            ((TextView)localObject).setEnabled(bool);
            break;
          }
        }
        else
        {
          i2 = i;
          i = j;
          j = i2;
        }
      }
    }
  }
  
  public void xH(int paramInt)
  {
    if (this.jdField_a_of_type_Rlv != null) {
      this.jdField_a_of_type_Rlv.xH(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(SlideItemInfo paramSlideItemInfo);
    
    public abstract void bvy();
    
    public abstract void er(int paramInt1, int paramInt2);
    
    public abstract void sA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmd
 * JD-Core Version:    0.7.0.1
 */