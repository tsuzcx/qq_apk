package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.HashMap;
import kbp;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kxm;
import kxm.b;
import ljh.b;
import ljm;
import mix;
import mnn;
import mpl;
import mpn;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment;", "Landroid/support/v4/app/Fragment;", "()V", "finish", "", "handleVideoAddToTopicResult", "errorCode", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "topicId", "rowKey", "", "errorMsg", "needShowServerErrorMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicFragment
  extends ReportV4Fragment
{
  public static final a a = new a(null);
  private HashMap ee;
  
  private final void a(int paramInt1, FragmentActivity paramFragmentActivity, int paramInt2, String paramString1, String paramString2)
  {
    int j = 1;
    int i;
    if (paramInt1 != 0)
    {
      if (!dT(paramInt1)) {
        break label126;
      }
      paramFragmentActivity = (CharSequence)paramString2;
      if ((paramFragmentActivity != null) && (paramFragmentActivity.length() != 0)) {
        break label120;
      }
      i = 1;
      if (i != 0) {
        break label126;
      }
      label42:
      paramFragmentActivity = kxm.a();
      if (paramFragmentActivity == null) {
        break label138;
      }
      paramFragmentActivity = new kxm.b().a("uin", paramFragmentActivity.getCurrentAccountUin()).a("column_id", Integer.valueOf(paramInt2)).a("rowkey", paramString1);
      if (!mix.DJ()) {
        break label133;
      }
    }
    label133:
    for (paramInt2 = j;; paramInt2 = 0)
    {
      kbp.bp("0X800ADD2", paramFragmentActivity.a("ugc_column_flag", Integer.valueOf(paramInt2)).a("reason_flag", Integer.valueOf(paramInt1)).build());
      return;
      label120:
      i = 0;
      break;
      label126:
      paramFragmentActivity = Unit.INSTANCE;
      break label42;
    }
    label138:
    QLog.e("SelectTopicFragment", 1, "getQQApp, app == null");
  }
  
  private final boolean dT(int paramInt)
  {
    return (paramInt == 100010) || (paramInt == 110010);
  }
  
  private final void finish()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction().remove((Fragment)this).commit();
      localObject = ((FragmentActivity)localObject).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "window");
      localObject = ((Window)localObject).getDecorView().findViewById(16908290);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject = (ViewGroup)localObject;
      View localView = ((ViewGroup)localObject).findViewById(2131376731);
      if (localView != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
  }
  
  public void aQW()
  {
    if (this.ee != null) {
      this.ee.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_rowKey");
      if (paramBundle != null)
      {
        localObject = getArguments();
        if (localObject == null) {
          break label185;
        }
      }
    }
    label185:
    for (int i = ((Bundle)localObject).getInt("key_from");; i = 0)
    {
      if (((CharSequence)paramBundle).length() > 0) {
        j = 1;
      }
      if (j == 0) {
        break label190;
      }
      localObject = getActivity();
      if (localObject != null)
      {
        SelectTopicView localSelectTopicView = new SelectTopicView((FragmentActivity)localObject, new ljm((ljh.b)new mnn()));
        mpn localmpn = new mpn((Activity)localObject, (View)localSelectTopicView, new RelativeLayout.LayoutParams(-1, -2));
        localSelectTopicView.setSelectCallback((Function1)new SelectTopicFragment.onCreate..inlined.let.lambda.1(localmpn, (FragmentActivity)localObject, this, i, paramBundle));
        localmpn.setOnDismissListener((DialogInterface.OnDismissListener)new mpl(this, i, paramBundle));
        localmpn.show();
      }
      return;
      paramBundle = "";
      break;
    }
    label190:
    QLog.e("SelectTopicFragment", 1, "start select topic failed, rowkey isEmpty");
    finish();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment$Companion;", "", "()V", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment
 * JD-Core Version:    0.7.0.1
 */