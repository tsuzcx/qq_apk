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
import java.util.Iterator;
import java.util.List;

public class xne
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 20999;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private String jdField_a_of_type_JavaLangString = "SlideShowViewController";
  private xms jdField_a_of_type_Xms;
  private xng jdField_a_of_type_Xng;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public xne(Activity paramActivity, xng paramxng)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xng = paramxng;
    f();
    a();
  }
  
  private void a(View paramView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator1.setDuration(240L);
    localObjectAnimator1.setInterpolator(new xmj(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator1.setStartDelay(0L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator2.setDuration(260L);
    localObjectAnimator2.setInterpolator(new xmj(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator2.setStartDelay(237L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.5F });
    localObjectAnimator3.setDuration(270L);
    localObjectAnimator3.setInterpolator(new xmj(0.33F, 0.0F, 0.67F, 1.0F));
    localObjectAnimator3.setStartDelay(495L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 1.0F });
    paramView.setDuration(240L);
    paramView.setInterpolator(new xmj(0.33F, 0.0F, 0.67F, 1.0F));
    paramView.setStartDelay(763L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramView });
    localAnimatorSet.start();
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131373859);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131373855);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    int i;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity))
    {
      i = 1;
      if (i == 0) {
        break label353;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-526087);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-3026479);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373861));
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_Xms = new xms(this.jdField_a_of_type_AndroidViewView.getContext(), this, this.jdField_a_of_type_Xng);
      this.jdField_a_of_type_Xms.a(xna.a().a());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Xms);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getRecycledViewPool().setMaxRecycledViews(this.jdField_a_of_type_Xms.getItemViewType(0), 10);
      this.jdField_a_of_type_Xms.a(new xnf(this));
      new bidr(new xmz(this.jdField_a_of_type_Xms)).attachToRecyclerView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373862));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373863));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373854));
      this.c.setOnClickListener(this);
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373853));
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier = new SlideProgressNotifier(this.jdField_a_of_type_AndroidAppActivity, 2131561236);
      if (a())
      {
        this.jdField_a_of_type_Int = 60000;
        xna.a().a(this.jdField_a_of_type_Int);
      }
      return;
      i = 0;
      break;
      label353:
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1728053248);
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Xms != null) {
      return this.jdField_a_of_type_Xms.a();
    }
    return "";
  }
  
  public void a()
  {
    int k;
    int m;
    label27:
    int n;
    label40:
    List localList;
    if (xna.a().b() == 22)
    {
      k = 1;
      if (xna.a().a() != 11) {
        break label124;
      }
      m = 1;
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity)) {
        break label130;
      }
      n = 1;
      localList = xna.a().a();
      if (localList == null) {
        break label963;
      }
    }
    label130:
    label322:
    label963:
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
              l += localSlideItemInfo.a();
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
        if ((l > this.jdField_a_of_type_Int) && (k == 0))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167063));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167063));
          if (this.d.getVisibility() != 0)
          {
            localObject = xna.a().a().iterator();
            i = 0;
            j = 0;
            i2 = 0;
            if (((Iterator)localObject).hasNext())
            {
              localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
              i4 = i2 + 1;
              if (localSlideItemInfo.jdField_b_of_type_Int == 1)
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
        if (localSlideItemInfo.jdField_b_of_type_Int == 0)
        {
          i2 = j + 1;
          j = i;
          i = i2;
          continue;
          if (m != 0)
          {
            i3 = 0;
            if (n == 0) {
              break label541;
            }
            localObject = "0";
            wxj.a("pic_choose", "exp_autoCut", i3, 0, new String[] { localObject, i2 + "", j + "", i + "" });
            this.d.setVisibility(0);
            if (k == 0) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699914, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int / 1000) }));
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(xnd.a(l));
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
            if (k == 0) {
              break label779;
            }
            localObject = this.c;
            if ((i1 < 2) || (i1 > 30)) {
              break label773;
            }
            bool = true;
            label511:
            ((TextView)localObject).setEnabled(bool);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Xms != null) {
              this.jdField_a_of_type_Xms.a(localList);
            }
            return;
            i3 = 1;
            break;
            localObject = "1";
            break label322;
            if (n != 0)
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166813));
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167064));
            }
            for (;;)
            {
              this.d.setVisibility(8);
              break;
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167194));
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167194));
            }
            if (n != 0)
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166813));
              if ((m != 0) || (k != 0)) {
                break label753;
              }
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699916));
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              this.d.setVisibility(8);
              break;
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167194));
              break label674;
              label753:
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699915));
            }
            bool = false;
            break label511;
            if (m == 0)
            {
              localObject = this.c;
              if ((i1 >= 2) && (i1 <= 10) && (l <= this.jdField_a_of_type_Int)) {}
              for (bool = true;; bool = false)
              {
                ((TextView)localObject).setEnabled(bool);
                break;
              }
            }
            if (n != 0)
            {
              localObject = this.c;
              if ((i1 >= 1) && (i1 <= 10) && (l <= this.jdField_a_of_type_Int)) {}
              for (bool = true;; bool = false)
              {
                ((TextView)localObject).setEnabled(bool);
                break;
              }
            }
            if (i1 != 0) {
              break label903;
            }
            this.c.setEnabled(true);
          }
          localObject = this.c;
          if ((i1 >= 1) && (i1 <= 10) && (l <= this.jdField_a_of_type_Int)) {}
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
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Xms != null) {
      this.jdField_a_of_type_Xms.a(paramInt);
    }
  }
  
  public void b()
  {
    List localList = xna.a().a();
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null))
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(i);
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
          if ((localObject instanceof xmv))
          {
            SlideItemInfo localSlideItemInfo1 = (SlideItemInfo)((xmv)localObject).a.getTag();
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              SlideItemInfo localSlideItemInfo2 = (SlideItemInfo)localIterator.next();
              if ((localSlideItemInfo1.jdField_b_of_type_JavaLangString.equals(localSlideItemInfo2.jdField_b_of_type_JavaLangString)) && (localSlideItemInfo2.c))
              {
                localSlideItemInfo2.c = false;
                a(((xmv)localObject).a);
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.b();
      List localList = xna.a().a();
      Iterator localIterator = localList.iterator();
      for (int i = 0; localIterator.hasNext(); i = (int)((SlideItemInfo)localIterator.next()).a() + i) {}
      int j = i;
      if (i == 0) {
        j = 5000;
      }
      i = (int)(j * 1.5D);
      j = (int)(localList.size() * 1.0D / (localList.size() + 1) * 100.0D);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(0, i, j, 0);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null)
    {
      List localList = xna.a().a();
      int j = localList.size();
      int i = j;
      if (j == 0) {
        i = 1;
      }
      j = (int)(localList.size() * 1.0D / (localList.size() + 1) * 100.0D);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(i * 1000, 99, j);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376834: 
      paramView = (SlideItemInfo)paramView.getTag();
      i = xna.a().a().indexOf(paramView);
      if ((this.jdField_a_of_type_Xng != null) && (paramView != null)) {
        this.jdField_a_of_type_Xng.b(paramView.jdField_b_of_type_JavaLangString);
      }
      a(i);
      return;
    case 2131373854: 
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity))
      {
        i = 0;
        label104:
        if (xna.a().a() != 11) {
          break label310;
        }
        j = 1;
        label117:
        paramView = xna.a().a();
        if ((j == 0) || (i == 0) || (paramView.size() != 0)) {
          break label315;
        }
        if (this.jdField_a_of_type_Xng != null) {
          this.jdField_a_of_type_Xng.a();
        }
        paramView = xna.a().a();
        if ((paramView.size() >= 1) && (paramView.size() <= 10) && (((SlideItemInfo)paramView.get(0)).a() <= 20999L)) {
          xna.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 2);
        }
      }
      for (;;)
      {
        try
        {
          if (xna.a().a() != 13) {
            break;
          }
          wxj.a("pic_fictitious", "clk_next", this.jdField_a_of_type_AndroidAppActivity.getIntent(), new String[0]);
          if ((!xna.a().a()) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
            break;
          }
          wxj.a("video_edit_new", "change_pic", this.jdField_a_of_type_AndroidAppActivity.getIntent(), new String[0]);
          return;
        }
        catch (Exception paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, bhsw.a(paramView));
        return;
        i = 1;
        break label104;
        label310:
        j = 0;
        break label117;
        label315:
        xna.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 2);
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("from_qzone_slideshow", false))) {
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity)) {
            xna.a().b(14);
          } else if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoPreviewActivity)) {
            xna.a().b(19);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qqstory_slideshow_auto_optimize");
    }
    paramView = xna.a().a().iterator();
    int k = 0;
    int j = 0;
    int i = 0;
    SlideItemInfo localSlideItemInfo;
    int n;
    if (paramView.hasNext())
    {
      localSlideItemInfo = (SlideItemInfo)paramView.next();
      n = k + 1;
      if (localSlideItemInfo.jdField_b_of_type_Int == 1)
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
      break;
      if (localSlideItemInfo.jdField_b_of_type_Int == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof NewPhotoListActivity))
        {
          m = 1;
          if (xna.a().a() != 11) {
            break label654;
          }
          n = 1;
          label537:
          if (n == 0) {
            break label660;
          }
          n = 0;
          label545:
          if (m == 0) {
            break label666;
          }
        }
        label654:
        label660:
        label666:
        for (paramView = "0";; paramView = "1")
        {
          wxj.a("pic_choose", "clk_autoCut", n, 0, new String[] { paramView, k + "", j + "", i + "" });
          xna.a().i();
          return;
          m = 0;
          break;
          n = 0;
          break label537;
          n = 1;
          break label545;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xne
 * JD-Core Version:    0.7.0.1
 */