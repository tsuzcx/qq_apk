import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoListViewLogic.4;
import com.tencent.tim.todo.TodoListViewLogic.7;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.tim.todo.widget.TodoCardView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aunz
  implements View.OnClickListener, aunw.a, aupf.b
{
  private ImageView Hd;
  private View KX;
  private View KY;
  private View KZ;
  private TextView MZ;
  private ativ jdField_a_of_type_Ativ;
  private aunt jdField_a_of_type_Aunt;
  private aunv jdField_a_of_type_Aunv;
  private TodoCardView jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView;
  private QQAppInterface app;
  private ViewPropertyAnimator jdField_b_of_type_AndroidViewViewPropertyAnimator;
  private aunx jdField_b_of_type_Aunx;
  private FPSSwipListView c;
  private String cIH = "";
  private TextView centerView;
  private Activity context;
  private augx d;
  private boolean djk;
  private ViewGroup e;
  private int erM = -1;
  private RelativeLayout ff;
  private TextView leftView;
  private HashMap<Long, Integer> qk = new HashMap();
  private ImageView rightViewImg;
  private RelativeLayout titleRoot;
  private TextView titleTextView;
  
  public aunz(Activity paramActivity, QQAppInterface paramQQAppInterface, aunt paramaunt, augx paramaugx)
  {
    this.context = paramActivity;
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Aunt = paramaunt;
    this.d = paramaugx;
  }
  
  private void evK()
  {
    this.KY = LayoutInflater.from(this.context).inflate(2131563219, this.c, false);
    this.KY.setOnClickListener(new auob(this));
  }
  
  private void evL()
  {
    this.c.setOnScrollListener(new auoc(this));
  }
  
  private void evN()
  {
    if ((this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView != null) && (this.ff.getVisibility() == 0))
    {
      auoi localauoi = (auoi)this.app.getManager(376);
      if ((this.jdField_b_of_type_Aunx.hq().size() > 0) || (localauoi.OL() > 0)) {
        this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.setTodoData();
    this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.setAnimationProgress(1.0F);
    this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.ewe();
    this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.setVisibility(0);
  }
  
  private void initAdapter()
  {
    this.jdField_a_of_type_Aunv = new aunv(this.app, this.context);
    this.c.setAdapter(this.jdField_a_of_type_Aunv);
    this.jdField_a_of_type_Aunv.a(this);
    this.jdField_a_of_type_Aunv.setOnClickListener(this);
  }
  
  private void initViews()
  {
    this.titleRoot = ((RelativeLayout)this.ff.findViewById(2131379791));
    this.titleRoot.setBackgroundColor(this.context.getResources().getColor(2131167654));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.titleRoot.getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.context);
      this.titleRoot.setLayoutParams(localLayoutParams);
    }
    this.rightViewImg = ((ImageView)this.titleRoot.findViewById(2131369594));
    this.MZ = ((TextView)this.titleRoot.findViewById(2131369612));
    this.leftView = ((TextView)this.titleRoot.findViewById(2131369579));
    this.centerView = ((TextView)this.titleRoot.findViewById(2131369627));
    this.MZ.setText(2131721059);
    this.MZ.setVisibility(0);
    this.leftView.setVisibility(8);
    this.titleRoot.findViewById(2131363675).setVisibility(8);
    this.MZ.setOnClickListener(this);
    this.c = ((FPSSwipListView)this.ff.findViewById(2131379963));
    this.c.setDivider(null);
    this.c.setDividerHeight(0);
    this.c.setOverscrollHeader(this.context.getResources().getDrawable(2130839646));
    this.KZ = LayoutInflater.from(this.context).inflate(2131563217, this.c, false);
    this.KX = LayoutInflater.from(this.context).inflate(2131563220, this.c, false);
    evK();
    this.titleTextView = ((TextView)this.KX.findViewById(2131379965));
    this.c.addHeaderView(this.KX, null, false);
    this.c.addHeaderView(this.KY, null, false);
    this.jdField_a_of_type_Ativ = new ativ(this.context, "SP_LEY_REFRESH_TIME_TODO_LIST", this.c, null, new auoa(this));
    this.c.setDragEnable(true);
    evL();
  }
  
  public boolean Pp()
  {
    return this.d.Pp();
  }
  
  public void W(ViewGroup paramViewGroup)
  {
    this.e = paramViewGroup;
    if ((this.context != null) && (paramViewGroup != null))
    {
      this.ff = ((RelativeLayout)LayoutInflater.from(this.context).inflate(2131563212, paramViewGroup, false));
      paramViewGroup.addView(this.ff);
      initViews();
      onCreate();
    }
  }
  
  public void Zt(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.cIH = paramString;
      TodoInfo localTodoInfo = new TodoInfo();
      localTodoInfo.todoId = paramString;
      b(localTodoInfo);
    }
  }
  
  public aunx a()
  {
    return this.jdField_b_of_type_Aunx;
  }
  
  public void b(int paramInt, TodoInfo paramTodoInfo)
  {
    if (paramTodoInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (aunu)this.app.getBusinessHandler(181);
      switch (paramInt)
      {
      default: 
        return;
      case 2131364767: 
        ((aunu)localObject).gR(paramTodoInfo.todoId, paramTodoInfo.status);
        aupe.L(this.app, "0X80091C5", 1);
        anpc.report("tim_mine_tab_remain_click_delete_remain_click");
        return;
      case 2131364768: 
        String str = String.format(this.context.getResources().getString(2131721208), new Object[] { paramTodoInfo.content });
        localObject = new Bundle();
        ((Bundle)localObject).putString(aupe.cIK, paramTodoInfo.todoId);
        ((Bundle)localObject).putInt("BUSI_TYPE", 1043);
        ((Bundle)localObject).putInt("forward_type", -1);
        ((Bundle)localObject).putString("forward_text", str);
        paramTodoInfo = new Intent();
        paramTodoInfo.putExtra("k_dataline", false);
        paramTodoInfo.putExtra("k_favorites", false);
        paramTodoInfo.setClass(this.context, ForwardRecentActivity.class);
        paramTodoInfo.putExtras((Bundle)localObject);
        ahgq.f(this.context, paramTodoInfo, 21);
        aupe.L(this.app, "0X80091C6", 1);
        anpc.report("tim_mine_tab_remain_click_share_remain_click");
        return;
      }
    } while (paramTodoInfo.status != 2);
    ((aunu)localObject).b(paramTodoInfo.todoId, 3, paramTodoInfo.content, paramTodoInfo.remindTime);
    aupe.L(this.app, "0X80091C3", 1);
  }
  
  public void b(TodoInfo paramTodoInfo)
  {
    this.erM = aupe.a(paramTodoInfo, this.jdField_a_of_type_Aunv);
    this.c.smoothScrollToPosition(this.erM + this.c.getHeaderViewsCount());
    new Handler().postDelayed(new TodoListViewLogic.4(this), 400L);
  }
  
  public void dY(Bundle paramBundle)
  {
    aupe.a(paramBundle, this.app, this.context);
  }
  
  public void evM()
  {
    Object localObject2 = (Rect)this.context.getIntent().getParcelableExtra("param_card_rect");
    if (localObject2 == null)
    {
      this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView = ((TodoCardView)LayoutInflater.from(this.context).inflate(2131563224, this.e, false));
      this.ff.addView(this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131379791);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
      return;
    }
    this.ff.setVisibility(4);
    Object localObject1 = new View(this.context);
    ((View)localObject1).setBackgroundResource(2130838984);
    this.e.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, -1));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
    TodoCardView localTodoCardView = (TodoCardView)LayoutInflater.from(this.context).inflate(2131563224, this.e, false);
    this.jdField_a_of_type_ComTencentTimTodoWidgetTodoCardView = localTodoCardView;
    this.e.addView(localTodoCardView);
    localTodoCardView.setTodoData();
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      ((Rect)localObject2).top -= ImmersiveUtils.getStatusBarHeight(this.context);
    }
    Object localObject3 = this.context.getResources().getDisplayMetrics();
    localMarginLayoutParams.setMargins(((Rect)localObject2).left, ((Rect)localObject2).top, ((DisplayMetrics)localObject3).widthPixels - ((Rect)localObject2).right, ((DisplayMetrics)localObject3).heightPixels - ((Rect)localObject2).bottom);
    localObject2 = (RelativeLayout.LayoutParams)localTodoCardView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = localMarginLayoutParams.topMargin;
    localTodoCardView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((View)localObject1).setVisibility(0);
    localTodoCardView.setVisibility(0);
    localObject2 = new RelativeLayout.LayoutParams(localMarginLayoutParams);
    localObject3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject3).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject3).addUpdateListener(new auoe(this, localMarginLayoutParams, (RelativeLayout.LayoutParams)localObject2, (View)localObject1, localTodoCardView));
    ((ValueAnimator)localObject3).addListener(new auof(this, (View)localObject1, localTodoCardView));
    ((ValueAnimator)localObject3).setDuration(200L);
    this.e.post(new TodoListViewLogic.7(this, (ValueAnimator)localObject3));
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Aunx != null)
    {
      this.jdField_a_of_type_Aunv.od(this.jdField_b_of_type_Aunx.hq());
      evN();
    }
    if (this.jdField_a_of_type_Ativ != null)
    {
      if (paramInt != aunx.erI) {
        break label77;
      }
      if (!paramBoolean2) {
        break label66;
      }
      this.jdField_a_of_type_Ativ.aGQ();
      this.c.setOverScrollFooter(this.KZ);
    }
    for (;;)
    {
      setTitle();
      return;
      label66:
      this.c.setOverScrollFooter(null);
      continue;
      label77:
      if (paramInt == aunx.erJ)
      {
        this.jdField_a_of_type_Ativ.aGQ();
        this.c.setOverScrollFooter(null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = null;
    Object localObject = localIntent;
    if (paramView.getTag() != null)
    {
      localObject = localIntent;
      if ((paramView.getTag() instanceof aupf.a)) {
        localObject = ((aupf.a)paramView.getTag()).d;
      }
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Aunt != null)
      {
        this.jdField_a_of_type_Aunt.evD();
        continue;
        localIntent = new Intent(this.context, TodoNewActivity.class);
        localIntent.putExtra("todoinfo", (Parcelable)localObject);
        if ((localObject != null) && (((TodoInfo)localObject).status == 2)) {
          localIntent.putExtra("param_mode", 3);
        }
        for (;;)
        {
          this.context.startActivity(localIntent);
          if ((TextUtils.isEmpty(this.cIH)) || (localObject == null) || (!((TodoInfo)localObject).todoId.equals(this.cIH))) {
            break;
          }
          aupe.L(this.app, "0X80091D8", 1);
          break;
          localIntent.putExtra("param_mode", 1);
        }
        if (this.jdField_b_of_type_Aunx != null)
        {
          this.jdField_b_of_type_Aunx.evI();
          continue;
          if ((paramView.getTag(-10) instanceof TodoInfo))
          {
            localObject = (TodoInfo)paramView.getTag(-10);
            a().a((TodoInfo)localObject);
            if ((!TextUtils.isEmpty(this.cIH)) && (((TodoInfo)localObject).status == 1) && (((TodoInfo)localObject).todoId.equals(this.cIH))) {
              aupe.L(this.app, "0X80091D7", 1);
            }
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    if ((this.ff != null) && (this.context != null))
    {
      initAdapter();
      this.jdField_b_of_type_Aunx = new aunx(this.app, this, true);
      this.jdField_b_of_type_Aunx.create();
      if (this.jdField_b_of_type_Aunx.aJu()) {
        this.jdField_a_of_type_Ativ.lz(true);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Aunx != null) {
      this.jdField_b_of_type_Aunx.destroy();
    }
  }
  
  public void onStart()
  {
    if ((this.ff != null) && (this.context != null) && (this.jdField_b_of_type_Aunx != null))
    {
      this.jdField_b_of_type_Aunx.onStart();
      this.c.setSelection(0);
    }
  }
  
  public void onStop()
  {
    if ((this.ff != null) && (this.context != null) && (this.jdField_b_of_type_Aunx != null)) {
      this.jdField_b_of_type_Aunx.onStop();
    }
    this.c.AP();
  }
  
  public void qw(String paramString)
  {
    QQToast.a(this.context, paramString, 0).show((int)this.context.getResources().getDimension(2131299627));
  }
  
  public void setTitle()
  {
    Object localObject = (auoi)this.app.getManager(376);
    localObject = this.context.getResources().getString(2131721213, new Object[] { Integer.valueOf(((auoi)localObject).et().size()) });
    this.titleTextView.setText((CharSequence)localObject);
    this.centerView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunz
 * JD-Core Version:    0.7.0.1
 */