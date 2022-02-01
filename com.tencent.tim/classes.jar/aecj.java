import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.ColorNoteListLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aecj
  implements aecv, RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener
{
  private static int cLY = 2131167673;
  private static int cLZ = 2131167654;
  private static int cMa = 2130839492;
  private View Bt;
  private ViewStub E;
  private aeci jdField_a_of_type_Aeci;
  private ColorNoteListLayout jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout;
  private aecv b;
  private boolean bSU;
  private boolean bSV = true;
  private Context context;
  private BounceScrollView g;
  private GestureDetector mGestureDetector;
  private boolean mIsShowing;
  RecyclerView recyclerView;
  private View root;
  private ImageView yr;
  
  public aecj(Context paramContext, aecv paramaecv)
  {
    this.context = paramContext;
    this.b = paramaecv;
  }
  
  private void cVK()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      cLY = 2131165403;
      cLZ = 2131165381;
      cMa = 2130839493;
      return;
    }
    cLY = 2131167673;
    cLZ = 2131167654;
    cMa = 2130839492;
  }
  
  private void hide()
  {
    this.mIsShowing = false;
    if ((this.Bt != null) && (this.Bt.getVisibility() == 0) && (this.Bt.hasFocus())) {
      return;
    }
    this.root.animate().alpha(0.0F).setDuration(200L).start();
    ViewPropertyAnimator localViewPropertyAnimator = this.recyclerView.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    if (this.bSU) {}
    for (float f = -this.recyclerView.getWidth();; f = this.recyclerView.getWidth())
    {
      localViewPropertyAnimator.translationX(f).setDuration(180L).setListener(new aecr(this)).start();
      return;
    }
  }
  
  private void init()
  {
    cVK();
    this.root = LayoutInflater.from(this.context).inflate(2131559016, null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout = ((ColorNoteListLayout)this.root.findViewById(2131364906));
    this.yr = ((ImageView)this.root.findViewById(2131364910));
    this.g = ((BounceScrollView)this.root.findViewById(2131363708));
    this.recyclerView = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.getRecyclerView();
    this.E = ((ViewStub)this.root.findViewById(2131364909));
    Object localObject = new LinearLayoutManager(this.context);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setOnClickListener(this);
    this.recyclerView.setOnClickListener(this);
    this.root.setOnClickListener(this);
    this.yr.setOnClickListener(new aeck(this));
    this.mGestureDetector = new GestureDetector(new aecl(this));
    localObject = new aecm(this);
    this.root.setOnTouchListener((View.OnTouchListener)localObject);
    this.root.findViewById(2131363708).setOnTouchListener((View.OnTouchListener)localObject);
    this.root.setBackgroundResource(cLZ);
    this.root.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.context), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.requestFocus();
  }
  
  public void cVJ()
  {
    hide();
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public void o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mIsShowing = true;
    this.bSU = paramBoolean;
    init();
    this.jdField_a_of_type_Aeci = new aeci();
    this.jdField_a_of_type_Aeci.setHideListener(this);
    this.jdField_a_of_type_Aeci.Hi(paramBoolean);
    Object localObject1 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().ep();
    this.jdField_a_of_type_Aeci.jF((List)localObject1);
    this.recyclerView.setAdapter(this.jdField_a_of_type_Aeci);
    this.recyclerView.setVisibility(4);
    this.jdField_a_of_type_Aeci.a(new aecn(this));
    Object localObject2;
    if (((List)localObject1).size() > 0)
    {
      localObject2 = (ColorNote)((List)localObject1).get(0);
      if (aebs.h((ColorNote)localObject2)) {
        anot.a(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", aeax.gU(aebs.gV(((ColorNote)localObject2).getServiceType())), 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setAnchor(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setHideListener(this);
    this.root.setAlpha(0.0F);
    this.root.animate().alpha(0.9F).setDuration(200L).setListener(new aecq(this, paramBoolean)).start();
    if (!this.bSV)
    {
      this.yr.setVisibility(8);
      localObject2 = new ArrayMap();
      localObject3 = ((List)localObject1).iterator();
      label271:
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      paramInt2 = ((ColorNote)((Iterator)localObject3).next()).getServiceType();
      if (!((ArrayMap)localObject2).containsValue(Integer.valueOf(paramInt2))) {
        break label350;
      }
    }
    label350:
    for (paramInt1 = ((Integer)((ArrayMap)localObject2).valueAt(paramInt2)).intValue() + 1;; paramInt1 = 1)
    {
      ((ArrayMap)localObject2).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      break label271;
      this.yr.setVisibility(0);
      break;
    }
    label355:
    Object localObject3 = ((ArrayMap)localObject2).keySet().iterator();
    paramInt1 = 0;
    paramInt2 = 0;
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      i = ((Integer)((Iterator)localObject3).next()).intValue();
      if (((Integer)((ArrayMap)localObject2).get(Integer.valueOf(i))).intValue() <= paramInt2) {
        break label625;
      }
      paramInt1 = ((Integer)((ArrayMap)localObject2).get(Integer.valueOf(i))).intValue();
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      anot.a(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, ((List)localObject1).size() + "", aeax.gT(paramInt1) + "", "", "");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ColorNote)((Iterator)localObject1).next();
        if (aebs.j((ColorNote)localObject2))
        {
          localObject3 = ykf.a((ColorNote)localObject2);
          if (aebs.i((ColorNote)localObject2)) {}
          for (paramInt1 = 1;; paramInt1 = 2)
          {
            anot.a(null, "dc00898", "", "", "0X800AE8E", "0X800AE8E", paramInt1, ((UpComingMsgModel)localObject3).reportType, "", "", "", "");
            break;
          }
        }
      }
      return;
      label625:
      i = paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  public void onAnimationsFinished()
  {
    if (this.jdField_a_of_type_Aeci.getItemCount() == 0) {
      hide();
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
      hide();
      anot.a(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
  }
  
  public void onPostThemeChanged()
  {
    cVK();
    this.root.setBackgroundResource(cLY);
    this.yr.setBackgroundResource(cMa);
  }
  
  public void refresh()
  {
    this.jdField_a_of_type_Aeci.notifyDataSetChanged();
  }
  
  public View y()
  {
    return this.root;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecj
 * JD-Core Version:    0.7.0.1
 */