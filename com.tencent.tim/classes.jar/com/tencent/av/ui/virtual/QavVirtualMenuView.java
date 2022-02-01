package com.tencent.av.ui.virtual;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import ikd;
import ikm;
import java.util.ArrayList;
import jcc;
import jcc.a;
import jcs;
import jix;

public class QavVirtualMenuView
  extends QavMenuBaseView
  implements View.OnClickListener, jcc.a
{
  private ikm jdField_a_of_type_Ikm;
  private jcs jdField_a_of_type_Jcs;
  private Button bA;
  private jcc mAdapter;
  private HorizontalListView mListView;
  
  public QavVirtualMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavVirtualMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavVirtualMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  private void initUI(Context paramContext)
  {
    this.TAG = ("QavVirtualMenuView_" + AudioHelper.hG());
    setGravity(80);
    paramContext = LayoutInflater.from(paramContext).inflate(2131559899, this);
    paramContext.setOnTouchListener(new jix(this));
    this.bA = ((Button)paramContext.findViewById(2131373922));
    this.bA.setOnClickListener(this);
    this.mListView = ((HorizontalListView)paramContext.findViewById(2131368682));
  }
  
  public void K(long paramLong, boolean paramBoolean)
  {
    super.K(paramLong, paramBoolean);
    if (paramBoolean) {
      refreshUI();
    }
  }
  
  public void a(long paramLong, QavListItemBase.c paramc)
  {
    PendantItem localPendantItem = null;
    EffectSettingUi.a(this.mApp, paramLong);
    if (paramc == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.equals("-1", paramc.id));
        if (!TextUtils.equals("0", paramc.id)) {
          break;
        }
        if (this.jdField_a_of_type_Ikm != null) {
          this.jdField_a_of_type_Ikm.a(paramLong, null);
        }
      } while (!this.mApp.ch(13));
      ((ikd)this.mApp.a(13)).o(paramLong, "onEffectClick_vb");
      return;
      if (this.jdField_a_of_type_Ikm != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Ikm.a(paramc.id);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())) || (this.jdField_a_of_type_Ikm == null));
    this.jdField_a_of_type_Ikm.a(paramLong, localPendantItem);
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.mApp != null)
    {
      paramQavPanel = getContext();
      this.jdField_a_of_type_Ikm = ((ikm)this.mApp.a(14));
      this.jdField_a_of_type_Jcs = new jcs(5, this.jdField_a_of_type_Ikm);
      ArrayList localArrayList = this.jdField_a_of_type_Jcs.a(getContext());
      this.mAdapter = new jcc(this.mApp, paramQavPanel, localArrayList, this.mListView);
      this.jdField_a_of_type_Jcs.a(this.mAdapter);
      this.mAdapter.jV(true);
      this.mAdapter.a(this);
      this.mAdapter.a(this.jdField_a_of_type_Jcs);
      this.mListView.setAdapter(this.mAdapter);
      if (this.jdField_a_of_type_Ikm != null) {
        this.jdField_a_of_type_Ikm.a(0L, this.jdField_a_of_type_Jcs);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void dk(long paramLong)
  {
    EffectSettingUi.a(this.mApp, paramLong);
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.hG();
    if ((paramView == this.bA) && (this.b != null)) {
      this.b.c(l, 0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy(long paramLong)
  {
    if (this.jdField_a_of_type_Ikm != null) {
      this.jdField_a_of_type_Ikm.b(paramLong, this.jdField_a_of_type_Jcs);
    }
    super.onDestroy(paramLong);
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    Object localObject1;
    int i;
    int j;
    int k;
    if (this.mAdapter != null)
    {
      Object localObject2 = "0";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Ikm != null)
      {
        localObject3 = (PendantItem)this.jdField_a_of_type_Ikm.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((PendantItem)localObject3).getId();
        }
      }
      localObject2 = this.jdField_a_of_type_Jcs.a(getContext());
      this.mAdapter.bE((ArrayList)localObject2);
      i = 0;
      j = -1;
      if ((localObject2 == null) || (i >= ((ArrayList)localObject2).size())) {
        break label251;
      }
      Object localObject3 = (QavListItemBase.c)((ArrayList)localObject2).get(i);
      if (localObject3 == null) {
        k = j;
      }
      do
      {
        i += 1;
        j = k;
        break;
        if (TextUtils.equals("0", ((QavListItemBase.c)localObject3).id)) {
          j = i;
        }
        k = j;
      } while (!TextUtils.equals((CharSequence)localObject1, ((QavListItemBase.c)localObject3).id));
    }
    for (;;)
    {
      k = i;
      if (i == -1)
      {
        if (this.jdField_a_of_type_Ikm != null) {
          this.jdField_a_of_type_Ikm.a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 4, "refreshUI, curSelItemId[" + (String)localObject1 + "], curSelItemIndex[" + k + "], curDefaultIndex[" + j + "]");
      }
      BaseToolbar.setSelectedListViewItemAndShow(this.mListView, this.mAdapter, k);
      return;
      label251:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView
 * JD-Core Version:    0.7.0.1
 */