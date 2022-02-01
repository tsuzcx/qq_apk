package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kxm;
import kxm.b;
import ljh.d;
import ljm;
import mix;
import mna;
import mpf;
import mpf.a;
import mpm;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "context", "Landroid/support/v4/app/FragmentActivity;", "listPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListContract$IListView;", "(Landroid/support/v4/app/FragmentActivity;Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getContext", "()Landroid/support/v4/app/FragmentActivity;", "createTopicListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "topicAdapter", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1;", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView
  extends BaseSelectView<ColumnInfo, b>
{
  public static final a a;
  @NotNull
  private final FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private final mpm jdField_a_of_type_Mpm;
  private final Function1<ColumnInfo, Unit> b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicView$a = new a(null);
  }
  
  public SelectTopicView(@NotNull FragmentActivity paramFragmentActivity, @NotNull ljm<ColumnInfo, ljh.d<ColumnInfo>> paramljm)
  {
    super((Activity)paramFragmentActivity, paramljm);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_Mpm = new mpm(this, (Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.b = ((Function1)new SelectTopicView.createTopicListener.1(this));
  }
  
  @NotNull
  public mpf<ColumnInfo, b> a()
  {
    return (mpf)this.jdField_a_of_type_Mpm;
  }
  
  public void aQV()
  {
    mix.Q((Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4);
    QQAppInterface localQQAppInterface = kxm.a();
    if (localQQAppInterface != null)
    {
      kbp.bp("0X800AC60", new kxm.b().a("uin", localQQAppInterface.getCurrentAccountUin()).a("source", Integer.valueOf(1)).build());
      return;
    }
    QLog.e("SelectTopicView", 1, "handleRightActionClick, app == null");
  }
  
  @NotNull
  public String ki()
  {
    return "";
  }
  
  @NotNull
  public String kj()
  {
    if (mix.DJ()) {
      return "";
    }
    return "";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mna.a(this.b);
  }
  
  protected void onDetachedFromWindow()
  {
    mna.b(this.b);
    super.onDetachedFromWindow();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$Companion;", "", "()V", "REQUEST_CODE_CREATE_TOPIC", "", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "titleText", "Landroid/widget/TextView;", "introView", "coverView", "Landroid/widget/ImageView;", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "getCoverView", "()Landroid/widget/ImageView;", "getIntroView", "()Landroid/widget/TextView;", "getTitleText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
    extends mpf.a
  {
    @NotNull
    private final ImageView jF;
    @NotNull
    private final TextView rg;
    @NotNull
    private final TextView titleText;
    
    public b(@NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull ImageView paramImageView)
    {
      this.titleText = paramTextView1;
      this.rg = paramTextView2;
      this.jF = paramImageView;
    }
    
    @NotNull
    public final ImageView g()
    {
      return this.jF;
    }
    
    @NotNull
    public final TextView p()
    {
      return this.titleText;
    }
    
    @NotNull
    public final TextView q()
    {
      return this.rg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */