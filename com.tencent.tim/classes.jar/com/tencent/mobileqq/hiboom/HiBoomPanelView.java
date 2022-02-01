package com.tencent.mobileqq.hiboom;

import acfp;
import acle;
import ahxo.a;
import ahxr;
import ahxs;
import ahyb;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqqj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import wja;

public class HiBoomPanelView
  extends RichTextPanelView
  implements Handler.Callback
{
  public static final String NAME = acfp.m(2131707154);
  public static int UG;
  public static int UH;
  public static int dbU;
  public static int dbV;
  ahyb jdField_a_of_type_Ahyb;
  a jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$a = null;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  BaseChatPie mBaseChatPie = null;
  public Handler mHandler;
  GridLayoutManager mLayoutManager;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    UH = localResources.getDisplayMetrics().widthPixels / 4;
    UG = UH;
    dbU = wja.dp2px(2.0F, localResources);
    dbV = wja.dp2px(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, ahyb paramahyb)
  {
    super(???);
    this.mBaseChatPie = paramBaseChatPie;
    this.mHandler = new Handler(this);
    setClipToPadding(false);
    this.jdField_a_of_type_Ahyb = paramahyb;
    init();
    paramBaseChatPie = (ahxs)this.mBaseChatPie.app.getManager(219);
    synchronized (paramBaseChatPie.handlerLock)
    {
      paramBaseChatPie.cV = this.mHandler;
      return;
    }
  }
  
  public void Af(boolean paramBoolean)
  {
    ahxs localahxs = (ahxs)this.mBaseChatPie.app.getManager(219);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localahxs.handlerLock)
      {
        localahxs.cV = this.mHandler;
        ie();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel gone");
    }
    synchronized (localObject1.handlerLock)
    {
      localObject1.cV = null;
      return;
    }
  }
  
  b a(int paramInt)
  {
    int j = this.mLayoutManager.findFirstVisibleItemPosition();
    int k = this.mLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      Object localObject = this.mLayoutManager.getChildAt(i - j);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject instanceof b))
        {
          localObject = (b)localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$a.hZ(((b)localObject).position) == paramInt) {
            return localObject;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  void a(b paramb, int paramInt)
  {
    if (!paramb.ciQ) {
      return;
    }
    if (paramInt == -1)
    {
      paramb.itemView.setContentDescription(acfp.m(2131707157));
      paramb.qw.setVisibility(8);
      paramb.ag.setVisibility(8);
      paramb.a.setVisibility(8);
      paramb.oY.setVisibility(8);
      paramb.c.setVisibility(8);
      paramb.AF.setVisibility(0);
      paramb.AF.setImageResource(2130848031);
      if (!this.mBaseChatPie.app.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramb.mRedDot.setVisibility(0);
        return;
      }
      paramb.mRedDot.setVisibility(8);
      return;
    }
    paramb.AF.setVisibility(8);
    paramb.mRedDot.setVisibility(8);
    Object localObject = (ahxs)this.mBaseChatPie.app.getManager(219);
    if (ahxs.de.get())
    {
      paramb.ag.setVisibility(8);
      ahxr localahxr = ((ahxs)localObject).a(paramInt);
      if (((ahxs)localObject).G.contains(Integer.valueOf(paramInt)))
      {
        paramb.a.ciX = false;
        paramb.qw.setVisibility(0);
        paramb.qw.setBackgroundResource(2130848037);
        paramb.qw.setText(acfp.m(2131707153));
      }
      while (localahxr.ciP)
      {
        paramb.itemView.setContentDescription(localahxr.name + acfp.m(2131707152));
        paramb.a.setVisibility(8);
        paramb.oY.setVisibility(8);
        paramb.c.setVisibility(0);
        paramb.c.setHiBoom(localahxr.id, 0, ahxs.b);
        String str = ahxs.ls(this.mBaseChatPie.a.getText().toString());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localahxr.name;
        }
        paramb.c.setText((CharSequence)localObject);
        return;
        if (((ahxs)localObject).H.contains(Integer.valueOf(paramInt)))
        {
          paramb.a.ciX = false;
          paramb.qw.setVisibility(0);
          paramb.qw.setBackgroundResource(2130848036);
          paramb.qw.setText(acfp.m(2131707155));
        }
        else
        {
          paramb.a.ciX = true;
          paramb.qw.setVisibility(8);
        }
      }
      paramb.itemView.setContentDescription(acfp.m(2131707156));
      paramb.a.setVisibility(0);
      paramb.oY.setVisibility(0);
      paramb.c.setVisibility(8);
      if (localahxr.fl != null) {
        paramb.oY.setImageBitmap(localahxr.fl);
      }
      while (localahxr.isDownloading)
      {
        paramb.a.clf();
        paramb.a.setProgress(localahxr.progress);
        return;
        paramb.oY.setImageResource(2130848032);
      }
      paramb.a.dqT();
      return;
    }
    paramb.ag.setVisibility(0);
    paramb.a.setVisibility(8);
    paramb.oY.setVisibility(8);
    paramb.c.setVisibility(8);
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ie();
      continue;
      b localb = a(paramMessage.arg1);
      if (localb != null)
      {
        localb.a.setProgress(paramMessage.arg2);
        continue;
        int i = paramMessage.arg1;
        paramMessage = a(i);
        if (paramMessage != null) {
          a(paramMessage, i);
        }
      }
    }
  }
  
  public void ie()
  {
    ahxs localahxs = (ahxs)this.mBaseChatPie.app.getManager(219);
    if (!localahxs.db.get())
    {
      localahxs.dqM();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$a.d(localahxs.F, localahxs.G, localahxs.H);
  }
  
  @TargetApi(9)
  public void init()
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(2);
    this.mLayoutManager = new GridLayoutManager(getContext(), 4);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager(this.mLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$a = new a();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$a);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Ahyb);
  }
  
  public class a
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    List<Integer> mDatas = new ArrayList();
    
    public a()
    {
      this.mDatas.add(Integer.valueOf(-1));
    }
    
    public void d(List<Integer> paramList1, List<Integer> paramList2, List<Integer> paramList3)
    {
      this.mDatas.clear();
      if (paramList1 != null) {
        this.mDatas.addAll(paramList1);
      }
      if ((paramList2 != null) && (paramList2.size() > 0)) {
        this.mDatas.addAll(paramList2);
      }
      if ((paramList3 != null) && (paramList3.size() > 0)) {
        this.mDatas.addAll(paramList3);
      }
      this.mDatas.add(Integer.valueOf(-1));
      notifyDataSetChanged();
    }
    
    public int getItemCount()
    {
      return this.mDatas.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      if (hZ(paramInt) == -2) {
        return 2;
      }
      return 1;
    }
    
    public int hZ(int paramInt)
    {
      return ((Integer)this.mDatas.get(paramInt)).intValue();
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      HiBoomPanelView.b localb;
      if ((paramViewHolder instanceof HiBoomPanelView.b))
      {
        localb = (HiBoomPanelView.b)paramViewHolder;
        localb.position = paramInt;
        if (localb.ciQ) {
          break label41;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        label41:
        int i = hZ(paramInt);
        ViewGroup.LayoutParams localLayoutParams = localb.itemView.getLayoutParams();
        localLayoutParams.height = HiBoomPanelView.UG;
        localLayoutParams.width = HiBoomPanelView.UH;
        localb.itemView.setPadding(0, 0, HiBoomPanelView.dbU, HiBoomPanelView.dbU);
        localLayoutParams = localb.c.getLayoutParams();
        localLayoutParams.width = (HiBoomPanelView.UH - HiBoomPanelView.dbU - HiBoomPanelView.dbV * 2);
        localLayoutParams.height = localLayoutParams.width;
        HiBoomPanelView.this.a(localb, i);
      }
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = null;
      boolean bool = true;
      switch (paramInt)
      {
      default: 
        return null;
      }
      try
      {
        paramViewGroup = LayoutInflater.from(HiBoomPanelView.this.getContext()).inflate(2131563329, paramViewGroup, false);
        localObject = paramViewGroup;
        if (paramViewGroup == null) {
          localObject = new View(HiBoomPanelView.this.getContext());
        }
        return new HiBoomPanelView.b(HiBoomPanelView.this, (View)localObject, bool);
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          QLog.e("HiBoomFont.HiBoomPanelView", 1, "inflate hiboom item error: ", paramViewGroup);
          bool = false;
          paramViewGroup = (ViewGroup)localObject;
        }
      }
    }
  }
  
  public class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public ImageView AF;
    public SectorProgressView a;
    public ProgressBar ag;
    public HiBoomTextView c;
    public boolean ciQ;
    public ImageView mRedDot;
    public ImageView oY;
    public int position;
    public TextView qw;
    
    public b(View paramView, boolean paramBoolean)
    {
      super();
      this.ciQ = paramBoolean;
      if (paramBoolean)
      {
        this.c = ((HiBoomTextView)paramView.findViewById(2131368514));
        this.c.setLoadingScale(0.6F);
        this.oY = ((ImageView)paramView.findViewById(2131368512));
        this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView = ((SectorProgressView)paramView.findViewById(2131368513));
        this.AF = ((ImageView)paramView.findViewById(2131368509));
        this.mRedDot = ((ImageView)paramView.findViewById(2131368510));
        this.ag = ((ProgressBar)paramView.findViewById(2131368507));
        this.qw = ((TextView)paramView.findViewById(2131368511));
        paramView.setOnClickListener(this);
      }
    }
    
    public void onClick(View paramView)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.getVisibility() == 0) {
        if (!this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.isInProgress())
        {
          this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.clf();
          this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(0);
          i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.a.hZ(this.position);
          ahxs.b.Pw(i);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject2;
        Object localObject1;
        if (this.AF.getVisibility() == 0)
        {
          switch (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.a.hZ(this.position))
          {
          default: 
            break;
          case -1: 
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.mBaseChatPie.app.getCurrentUin();
            if (this.mRedDot.getVisibility() == 0) {}
            for (localObject1 = "0";; localObject1 = "1")
            {
              VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", (String)localObject1);
              this.mRedDot.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.mBaseChatPie.app.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
              localObject1 = aqqj.o(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
              if (QLog.isColorLevel()) {
                QLog.d("HiBoomFont.HiBoomPanelView", 2, "enter hiboom mall url = " + (String)localObject1);
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), (String)localObject1, 4096L, null, false, -1);
              break;
            }
          }
        }
        else if (this.ag.getVisibility() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomPanelView", 2, "dirty filter ");
          }
        }
        else
        {
          if (ahxs.dd.compareAndSet(false, true))
          {
            localObject1 = (acle)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.mBaseChatPie.app.getBusinessHandler(13);
            localObject2 = (ahxs)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.mBaseChatPie.app.getManager(219);
            i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.a.hZ(this.position);
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick hiboomid = " + i);
            }
            if (((ahxs)localObject2).H.contains(Integer.valueOf(i))) {
              ((acle)localObject1).e(i, true, this.c.getText());
            }
            for (;;)
            {
              anot.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.mBaseChatPie.app, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
              break;
              ((acle)localObject1).z(i, this.c.getText(), 2);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick is sending");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */