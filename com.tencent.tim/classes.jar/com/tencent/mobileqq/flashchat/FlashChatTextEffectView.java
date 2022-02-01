package com.tencent.mobileqq.flashchat;

import acfp;
import ahei;
import ahem;
import ahen;
import aheo;
import ahep;
import ahxs;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import aurf;
import azbx;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.b;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wyw;

public class FlashChatTextEffectView
  extends RichTextPanelRecyclerView
  implements Handler.Callback
{
  private static final int[] lt = { 10000, 12000, 7000, 8000, 8000 };
  ahep jdField_a_of_type_Ahep;
  a jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a;
  ahei b;
  public MqqHandler b;
  int bms;
  WeakReference<BaseChatPie> gW;
  public HashMap<Integer, Long> kX = new HashMap();
  GridLayoutManager mLayoutManager;
  ArrayList<FlashChatPanel.a> qe = new ArrayList();
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Ahei = new ahem(this);
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, ahep paramahep, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Ahei = new ahem(this);
    this.gW = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Ahep = paramahep;
    this.bms = paramInt;
    setClipToPadding(false);
    init();
    ie();
  }
  
  private static void a(b paramb)
  {
    if ((paramb != null) && (paramb.h != null))
    {
      String str = paramb.h.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.2(paramb));
    }
  }
  
  private static void b(b paramb)
  {
    if ((paramb != null) && (paramb.h != null))
    {
      String str = paramb.h.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.3(paramb));
    }
  }
  
  public void Mh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a != null) {
      dnc();
    }
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((FlashChatPanel.a)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.mDatas.get(paramInt)).b;
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public FlashChatPanel.a a(int paramInt)
  {
    if (paramInt >= this.qe.size()) {
      return null;
    }
    return (FlashChatPanel.a)this.qe.get(paramInt);
  }
  
  public void clear()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.clear();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void dmY()
  {
    int i = 0;
    while (i <= this.mLayoutManager.getChildCount())
    {
      Object localObject = this.mLayoutManager.getChildAt(i);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof b)) {
          b((b)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void dmZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.dmZ();
    }
  }
  
  public void dna()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.dna();
    }
  }
  
  public void dnb()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.dnb();
    }
  }
  
  void dnc()
  {
    int i = 0;
    while (i <= this.mLayoutManager.getChildCount())
    {
      Object localObject = this.mLayoutManager.getChildAt(i);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof b))
        {
          localObject = (b)localObject;
          this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.a((b)localObject, ((b)localObject).getPosition());
        }
      }
      i += 1;
    }
  }
  
  public int getSize()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.getItemCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof b)) {}
    for (Object localObject = (b)paramMessage.obj;; localObject = null)
    {
      switch (paramMessage.what)
      {
      }
      label263:
      for (;;)
      {
        return false;
        long l1;
        Long localLong;
        long l2;
        int i;
        if (paramMessage.what < lt.length)
        {
          l1 = lt[paramMessage.what];
          localLong = (Long)this.kX.get(Integer.valueOf(paramMessage.what));
          l2 = SystemClock.uptimeMillis();
          if (localLong != null) {
            break label242;
          }
          this.kX.put(Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()));
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label263;
          }
          this.kX.put(Integer.valueOf(paramMessage.what), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("shinkencai", 2, "plays position:" + paramMessage.what);
          }
          if (localObject != null) {
            a((b)localObject);
          }
          localObject = Message.obtain();
          ((Message)localObject).what = paramMessage.what;
          ((Message)localObject).obj = paramMessage.obj;
          this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1);
          return false;
          l1 = 7000L;
          break;
          label242:
          if (l2 - localLong.longValue() >= l1) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  public void ie()
  {
    if ((this.gW == null) || (this.gW.get() == null))
    {
      QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
      return;
    }
    Object localObject = ((FlashChatManager)((BaseChatPie)this.gW.get()).app.getManager(217)).cS();
    this.qe.clear();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      FlashChatPanel.a locala = new FlashChatPanel.a();
      locala.appid = localFlashChatItem.id;
      if (localFlashChatItem.id != -100000)
      {
        locala.contentDescription = acfp.m(2131706336);
        locala.text = localFlashChatItem.name;
        locala.beg = false;
        locala.b = localFlashChatItem;
        this.qe.add(locala);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.setDatas(this.qe);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.notifyDataSetChanged();
  }
  
  @TargetApi(9)
  public void init()
  {
    setOverScrollMode(2);
    this.mLayoutManager = new GridLayoutManager(getContext(), 3);
    setLayoutManager(this.mLayoutManager);
    this.jdField_b_of_type_MqqOsMqqHandler = new aurf(this);
    ahep localahep = this.jdField_a_of_type_Ahep;
    if (this.gW == null) {}
    for (BaseChatPie localBaseChatPie = null;; localBaseChatPie = (BaseChatPie)this.gW.get())
    {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a = new a(localahep, localBaseChatPie, this.bms, this.jdField_b_of_type_MqqOsMqqHandler);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a);
      return;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.gW != null) && (this.gW.get() != null)) {}
    for (paramView = ((BaseChatPie)this.gW.get()).app; paramInt == 0; paramView = BaseApplicationImpl.getApplication().getRuntime())
    {
      paramView.registObserver(this.jdField_b_of_type_Ahei);
      return;
    }
    paramView.unRegistObserver(this.jdField_b_of_type_Ahei);
  }
  
  public void select(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.mDatas != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.mDatas.size())
      {
        FlashChatPanel.a locala = (FlashChatPanel.a)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.mDatas.get(i);
        if (i == paramInt) {}
        for (locala.beg = true;; locala.beg = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$a.notifyDataSetChanged();
  }
  
  public static class a
    extends RecyclerView.Adapter<FlashChatTextEffectView.b>
  {
    public static SparseArray<WeakReference<ArkFlashChatContainerWrapper>> cG = new SparseArray();
    public static SparseArray<MessageForArkFlashChat> cH = new SparseArray();
    public static int id = 1;
    private String TAG = "FlashChatAdapter";
    public ahep b;
    private ArkAppView.b jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppView$b = new ahen(this);
    private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
    public int bms;
    private WeakReference<BaseChatPie> gW;
    List<FlashChatPanel.a> mDatas = new LinkedList();
    private String mText;
    
    public a(ahep paramahep, BaseChatPie paramBaseChatPie, int paramInt, MqqHandler paramMqqHandler)
    {
      this.jdField_b_of_type_Ahep = paramahep;
      this.gW = new WeakReference(paramBaseChatPie);
      this.bms = paramInt;
      this.jdField_b_of_type_MqqOsMqqHandler = paramMqqHandler;
    }
    
    public FlashChatTextEffectView.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new FlashChatTextEffectView.b(LayoutInflater.from(((BaseChatPie)this.gW.get()).a().getBaseContext()).inflate(2131561268, paramViewGroup, false), this.jdField_b_of_type_Ahep, this.bms);
    }
    
    public void a(FlashChatTextEffectView.b paramb, int paramInt)
    {
      Object localObject1 = (FlashChatPanel.a)this.mDatas.get(paramInt);
      Object localObject2 = (ViewGroup.MarginLayoutParams)paramb.itemView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).height = FlashChatPanel.cZH;
      ((ViewGroup.MarginLayoutParams)localObject2).width = FlashChatPanel.bsz;
      if (paramInt % 3 == 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.cZI;
      }
      for (;;)
      {
        if (paramInt / 3 == 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.cZI;
          label82:
          paramb.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramb.itemView.setBackgroundDrawable(new ColorDrawable(0));
          paramb.itemView.setContentDescription(acfp.m(2131706334) + ((FlashChatPanel.a)localObject1).b.name);
          paramb.actionId = ((FlashChatPanel.a)localObject1).actionId;
          paramb.appid = ((FlashChatPanel.a)localObject1).appid;
          paramb.b = ((FlashChatPanel.a)localObject1).b;
          paramb.a = ((FlashChatPanel.a)localObject1);
          paramb.f.setClipRadius(4.0F);
          paramb.itemView.setLayerType(0, null);
        }
        try
        {
          paramb.c.setVisibility(0);
          paramb.c.setBkgColorNormal(Color.parseColor(paramb.b.color));
          label231:
          String str;
          if (cG.get(paramb.b.id) == null)
          {
            localObject1 = null;
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = new ArkFlashChatContainerWrapper();
              cG.put(paramb.b.id, new WeakReference(localObject2));
            }
            localObject1 = (MessageForArkFlashChat)cH.get(paramb.b.id);
            if (localObject1 != null) {
              break label878;
            }
            localObject1 = new MessageForArkFlashChat();
            ((MessageForArkFlashChat)localObject1).uniseq = id;
            id += 1;
            ((MessageForArkFlashChat)localObject1).ark_app_message = new ArkFlashChatMessage();
            ((MessageForArkFlashChat)localObject1).ark_app_message.preview = true;
            cH.put(paramb.b.id, localObject1);
            if (this.gW.get() == null) {
              break label840;
            }
            this.mText = FlashChatManager.lj(((BaseChatPie)this.gW.get()).a.getText().toString());
            this.mText = this.mText.replaceAll("\\s", "");
            label400:
            if (!ahxs.de.get()) {
              this.mText = "";
            }
            ArkFlashChatMessage localArkFlashChatMessage = ((MessageForArkFlashChat)localObject1).ark_app_message;
            if (!TextUtils.isEmpty(this.mText)) {
              break label850;
            }
            str = acfp.m(2131706331);
            label440:
            localArkFlashChatMessage.promptText = str;
            ((MessageForArkFlashChat)localObject1).ark_app_message.appName = paramb.b.appName;
            ((MessageForArkFlashChat)localObject1).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
            ((ArkFlashChatContainerWrapper)localObject2).cdD();
            ((ArkFlashChatContainerWrapper)localObject2).a(((BaseChatPie)this.gW.get()).app, BaseApplicationImpl.sApplication, paramb.b.appName, paramb.b.mainView, paramb.b.ver, paramb.b.id, ((MessageForArkFlashChat)localObject1).ark_app_message.getMeta(((MessageForArkFlashChat)localObject1).uniseq, false), paramb.itemView.getContext().getResources().getDisplayMetrics().scaledDensity, ((BaseChatPie)this.gW.get()).a(), FlashChatPanel.bsz - azbx.dip2px(7.0F), FlashChatPanel.cZH - azbx.dip2px(7.0F), FlashChatPanel.bsz, FlashChatPanel.cZH, (MessageForArkFlashChat)localObject1);
            paramb.h = ((MessageForArkFlashChat)localObject1);
            paramb.f.setOnVisibleChangeListener(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppView$b);
            paramb.f.setCallback(new aheo(this, paramb, paramInt));
            paramb.f.a((wyw)localObject2, paramb.c);
            if ((paramb.f.getVisibility() == 0) && (ahxs.de.get()))
            {
              paramb.c.setVisibility(8);
              FlashChatTextEffectView.c(paramb);
              localObject1 = Message.obtain();
              ((Message)localObject1).obj = paramb;
              ((Message)localObject1).what = paramInt;
              if (paramInt >= FlashChatTextEffectView.access$100().length) {
                break label859;
              }
              this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, FlashChatTextEffectView.access$100()[paramInt]);
            }
          }
          for (;;)
          {
            EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
            return;
            if (paramInt % 3 == 2)
            {
              ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.cZI;
              ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
              break;
            }
            ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.cZI;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.cZI;
            break;
            if (paramInt / 3 == getItemCount() / 3)
            {
              ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.cZI;
              ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = 0;
              break label82;
            }
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.cZI;
            ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.cZI;
            break label82;
            localObject1 = (ArkFlashChatContainerWrapper)((WeakReference)cG.get(paramb.b.id)).get();
            break label231;
            label840:
            this.mText = "";
            break label400;
            label850:
            str = this.mText;
            break label440;
            label859:
            this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 7000L);
          }
        }
        catch (Throwable localThrowable)
        {
          label878:
          for (;;) {}
        }
      }
    }
    
    public void clear()
    {
      cG.clear();
      cH.clear();
    }
    
    public void dmZ()
    {
      int i = 0;
      while (i < cG.size())
      {
        Object localObject = (WeakReference)cG.valueAt(i);
        if (localObject != null)
        {
          localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ArkFlashChatContainerWrapper)localObject).doOnEvent(0);
          }
        }
        i += 1;
      }
    }
    
    public void dna()
    {
      int i = 0;
      while (i < cG.size())
      {
        Object localObject = (WeakReference)cG.valueAt(i);
        if (localObject != null)
        {
          localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ArkFlashChatContainerWrapper)localObject).doOnEvent(1);
          }
        }
        i += 1;
      }
    }
    
    public void dnb()
    {
      int i = 0;
      while (i < cG.size())
      {
        Object localObject = (WeakReference)cG.valueAt(i);
        if (localObject != null)
        {
          localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ArkFlashChatContainerWrapper)localObject).doOnEvent(2);
          }
        }
        i += 1;
      }
    }
    
    public int getItemCount()
    {
      return this.mDatas.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public void setDatas(List<? extends FlashChatPanel.a> paramList)
    {
      this.mDatas.clear();
      this.mDatas.addAll(paramList);
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener, View.OnLongClickListener
  {
    public FlashChatPanel.a a;
    public int actionId;
    public int appid;
    public FlashChatItem b;
    int bms;
    ahep c;
    public ArkAppLoadLayout c;
    public ArkAppView f;
    MessageForArkFlashChat h = null;
    
    public b(View paramView, ahep paramahep, int paramInt)
    {
      super();
      if (paramahep != null) {
        this.jdField_c_of_type_Ahep = paramahep;
      }
      this.bms = paramInt;
      this.f = ((ArkAppView)paramView.findViewById(2131362952));
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370776));
      this.itemView.setOnClickListener(this);
      this.itemView.setOnTouchListener(paramahep);
    }
    
    public void onClick(View paramView)
    {
      if (this.jdField_c_of_type_Ahep != null) {
        this.jdField_c_of_type_Ahep.h(paramView, getPosition(), this.bms);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      boolean bool = false;
      if (this.jdField_c_of_type_Ahep != null)
      {
        this.jdField_c_of_type_Ahep.x(paramView, getPosition(), this.bms);
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */