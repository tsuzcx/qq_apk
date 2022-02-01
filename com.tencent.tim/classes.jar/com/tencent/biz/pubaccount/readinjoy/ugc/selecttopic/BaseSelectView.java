package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ljh.d;
import ljm;
import mpf;
import mpf.a;
import mpg;
import mph;
import mpi;
import mpj;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView;", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/IOnActivityResult;", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListContract$IListView;", "context", "Landroid/app/Activity;", "listPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "errorLayout", "Landroid/view/View;", "isLoadingMore", "", "listView", "Landroid/widget/ListView;", "loadingLayout", "onScrollListener", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView$onScrollListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView$onScrollListener$1;", "rightActionBtn", "Landroid/widget/TextView;", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "selectTip", "getSelectTip", "selectTipView", "addItemToTop", "(Ljava/lang/Object;)V", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "errorMsg", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setListData", "allList", "", "isAppend", "setTotal", "total", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSelectView<BEAN, HOLDER extends mpf.a>
  extends RelativeLayout
  implements ljh.d<BEAN>
{
  @Nullable
  private Function1<? super BEAN, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private mpj jdField_a_of_type_Mpj;
  @NotNull
  private final String ajw;
  @NotNull
  private final String ajx;
  private final ljm<BEAN, ljh.d<BEAN>> b;
  private boolean isLoadingMore;
  private ListView listView;
  private View lp;
  private View lq;
  private TextView re;
  private TextView rf;
  
  public BaseSelectView(@NotNull Activity paramActivity, @NotNull ljm<BEAN, ljh.d<BEAN>> paramljm)
  {
    super((Context)paramActivity);
    this.b = paramljm;
    this.jdField_a_of_type_Mpj = new mpj(this);
    LayoutInflater.from((Context)paramActivity).inflate(2131560467, (ViewGroup)this, true);
    paramActivity = findViewById(2131377928);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.selectTipView)");
    this.re = ((TextView)paramActivity);
    paramActivity = findViewById(2131366498);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.errorLayout)");
    this.lp = paramActivity;
    paramActivity = findViewById(2131377271);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.rightActionBtn)");
    this.rf = ((TextView)paramActivity);
    paramActivity = findViewById(2131370536);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.listView)");
    this.listView = ((ListView)paramActivity);
    paramActivity = findViewById(2131370789);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.loadingLayout)");
    this.lq = paramActivity;
    this.lp.setOnClickListener((View.OnClickListener)new mpg(this));
    this.ajw = "";
    this.ajx = "";
  }
  
  public final void W(BEAN paramBEAN)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBEAN);
    localArrayList.addAll((Collection)a().be());
    a().cS((List)localArrayList);
    this.listView.setVisibility(0);
    this.lq.setVisibility(8);
    this.lp.setVisibility(8);
  }
  
  @Nullable
  public final Function1<BEAN, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  @NotNull
  public abstract mpf<BEAN, HOLDER> a();
  
  public void aQV() {}
  
  @NotNull
  public String ki()
  {
    return this.ajw;
  }
  
  @NotNull
  public String kj()
  {
    return this.ajx;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.re.setText((CharSequence)ki());
    if (((CharSequence)kj()).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.rf.setText((CharSequence)kj());
        this.rf.setOnClickListener((View.OnClickListener)new mph(this));
      }
      this.listView.setAdapter((ListAdapter)a());
      this.listView.setOnItemClickListener((AdapterView.OnItemClickListener)new mpi(this));
      this.listView.setOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_Mpj);
      this.b.a((ljh.d)this);
      this.b.aMF();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.b.detachView();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    this.listView.setVisibility(8);
    this.lq.setVisibility(8);
    this.lp.setVisibility(8);
  }
  
  public void setCenterError(int paramInt, @Nullable String paramString)
  {
    this.listView.setVisibility(8);
    this.lq.setVisibility(8);
    this.lp.setVisibility(0);
  }
  
  public void setCenterHide()
  {
    this.listView.setVisibility(0);
    this.lq.setVisibility(8);
  }
  
  public void setCenterLoading()
  {
    this.listView.setVisibility(8);
    this.lp.setVisibility(8);
    this.lq.setVisibility(0);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.isLoadingMore = false;
  }
  
  public void setFooterHasMore()
  {
    this.isLoadingMore = false;
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading()
  {
    this.isLoadingMore = true;
  }
  
  public void setFooterNoMore()
  {
    this.isLoadingMore = false;
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    a().cS(paramList);
  }
  
  public final void setSelectCallback(@Nullable Function1<? super BEAN, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.BaseSelectView
 * JD-Core Version:    0.7.0.1
 */