package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import appb;
import aptw;
import aptw.b;
import apvg;
import apvh;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;
import ujt;
import ujt.d;
import wso;
import xwn;

public class RobotPanelLayoutBase
  extends RDBaseListLayout<c, b>
  implements View.OnClickListener, aptw.b
{
  public aptw b;
  protected BaseChatPie c;
  public String crF;
  public String cro;
  protected int dXl;
  private WeakReference<e> mListenerRef;
  
  public RobotPanelLayoutBase(Context paramContext)
  {
    super(paramContext);
    cn(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cn(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cn(1);
  }
  
  public static aptw a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (aptw)((QQAppInterface)localAppRuntime).getManager(203);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = paramContext.getResources().getInteger(2131427349);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.h(paramContext, 2131719509, 1);
      return;
    }
    boolean bool = paramBaseChatPie instanceof xwn;
    ujt.d locald = new ujt.d();
    locald.aSL = paramBoolean;
    if (bool)
    {
      paramString3 = appb.a(paramBaseChatPie.app, paramContext, paramString2, paramString2, paramString3, false, true);
      paramString2 = new ArrayList();
      paramString3 = appb.a(paramString3, paramString2);
      paramString1 = paramString3 + " " + paramString1;
      ujt.a(paramBaseChatPie.app, paramContext, paramBaseChatPie.sessionInfo, paramString1, paramString2, locald);
      return;
    }
    ujt.a(paramBaseChatPie.app, paramContext, paramBaseChatPie.sessionInfo, paramString1, null, locald);
  }
  
  public String BC()
  {
    return this.cro;
  }
  
  public int LH()
  {
    return this.dXl;
  }
  
  public boolean RI()
  {
    init();
    setOverScrollMode(0);
    int i = 2130851038;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130850842;
      }
      setBackgroundResource(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("RobotPanelLayoutBase", 2, "onInit setBackgroundResource exception");
      }
    }
    return true;
  }
  
  protected void TZ(String paramString)
  {
    if (this.mListenerRef != null)
    {
      e locale = (e)this.mListenerRef.get();
      if (locale != null) {
        locale.xP(paramString);
      }
    }
  }
  
  public void V(String paramString1, String paramString2, boolean paramBoolean)
  {
    bYN();
  }
  
  public b a(int paramInt, c paramc)
  {
    paramc = new b();
    View localView = LayoutInflater.from(getContext()).inflate(2131560860, null, false);
    localView.setOnClickListener(this);
    paramc.eW(localView);
    paramc.IV = localView.findViewById(2131369424);
    paramc.titleText = ((TextView)localView.findViewById(2131379420));
    localView.setTag(paramc);
    return paramc;
  }
  
  public String a(c paramc)
  {
    return null;
  }
  
  public ArrayList<c> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(f.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((f)((Iterator)localObject).next()).items);
    }
    return paramRspBody;
  }
  
  public void a(int paramInt, c paramc) {}
  
  public void a(int paramInt, c paramc, b paramb)
  {
    if (paramc.aBB())
    {
      aptw localaptw = a();
      if (localaptw == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      paramc.cPY = localaptw.aBy();
    }
    if (paramc.cPY) {}
    for (paramc = paramc.b;; paramc = paramc.a)
    {
      paramb.titleText.setText(paramc.title);
      a(paramb);
      return;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((paramBaseChatPie == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {}
    do
    {
      return;
      if (a() != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
    return;
    paramString5 = c.a(paramString7, paramString6, paramString5, paramString4);
    paramString6 = paramString5.a.title;
    c(paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString5.b.title)) {
      if (QLog.isColorLevel()) {
        QLog.d("RobotPanelLayoutBase", 2, "talking: " + paramString6);
      }
    }
    for (;;)
    {
      d(paramString5, paramString6);
      return;
      if (!paramString5.a.url.startsWith("inputKeyOp://sendToRobot")) {
        break;
      }
      a(getContext(), paramString5.a.title, paramString2, paramString3, false, paramBaseChatPie);
      if (QLog.isColorLevel()) {
        QLog.d("RobotPanelLayoutBase", 2, "send to robot: " + paramString5.a.title);
      }
    }
    int i;
    if (paramString5.a.url.startsWith("inputKeyOp://sendToBackEnd"))
    {
      i = paramString5.a.url.indexOf("content=");
      if (i <= 0) {
        break label410;
      }
    }
    label410:
    for (paramString4 = paramString5.a.url.substring(i + 8);; paramString4 = null)
    {
      a(getContext(), paramString5.a.title, paramString2, paramString3, true, paramBaseChatPie);
      a(paramString1, paramString2, paramString4, paramString5);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotPanelLayoutBase", 2, "send to server: " + paramString5.a.title);
      break;
      if (!paramString5.a.url.startsWith("http")) {
        break;
      }
      paramBaseChatPie = new Intent(getContext(), QQBrowserActivity.class);
      paramBaseChatPie.putExtra("url", paramString5.a.url);
      getContext().startActivity(paramBaseChatPie);
      break;
    }
  }
  
  protected void a(b paramb)
  {
    int i = aqcx.dip2px(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(aqcx.dip2px(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(aqcx.dip2px(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramb.titleText.setTextColor(Color.parseColor("#737373"));
      localGradientDrawable1.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColorFilter(Color.argb(126, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#1F1F1F"));
    }
    for (;;)
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      paramb.IV.setBackgroundDrawable(localStateListDrawable);
      return;
      paramb.titleText.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
  }
  
  public void a(c paramc) {}
  
  public void a(c paramc, String paramString) {}
  
  public void a(String paramString1, String paramString2, BaseChatPie paramBaseChatPie, a parama)
  {
    this.c = paramBaseChatPie;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, c paramc)
  {
    if ((paramc == null) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.b == null)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new apvg(this, paramc);
          if ("1".equals(paramString1))
          {
            this.b.a(l2, paramString3, paramString2);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        for (;;)
        {
          QLog.e("RobotPanelLayoutBase", 2, "sendContent exception:" + paramString1 + ":" + paramString2);
          l2 = -1L;
          l1 = -1L;
        }
        this.b.a(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public void b(c paramc) {}
  
  public void b(c paramc, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, c paramc)
  {
    if ((this.b == null) || (TextUtils.isEmpty(paramString3)) || (paramc == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new apvh(this, paramc);
          if ("1".equals(paramString1))
          {
            this.b.b(l2, paramString3, paramString2);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        for (;;)
        {
          QLog.e("RobotPanelLayoutBase", 2, "requestGrayTips exception:" + paramString1 + ":" + paramString2);
          l2 = -1L;
          l1 = -1L;
        }
        this.b.b(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public void bYN()
  {
    update();
  }
  
  public void c(c paramc, String paramString) {}
  
  public void cbt()
  {
    this.mListenerRef = null;
    if (this.b != null) {
      this.b.a(null);
    }
  }
  
  public void d(c paramc, String paramString) {}
  
  public void init()
  {
    this.b = a();
    if (this.b != null) {
      this.b.a(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
  }
  
  public void onClick(View paramView)
  {
    c localc = (c)i(o(paramView));
    if (localc == null) {}
    while (this.c == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = localc.a.title;
    a(localc, str);
    Object localObject;
    if (!TextUtils.isEmpty(localc.b.title)) {
      localObject = a(localc);
    }
    for (;;)
    {
      b(localc, (String)localObject);
      TZ((String)localObject);
      break;
      if (localc.a.url.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localc);
        localObject = str;
      }
      else if (localc.a.url.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localc);
        localObject = str;
      }
      else
      {
        localObject = str;
        if (localc.a.url.startsWith("http"))
        {
          localObject = new Intent(getContext(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localc.a.url);
          getContext().startActivity((Intent)localObject);
          localObject = str;
        }
      }
    }
  }
  
  public void setInputLineCount(int paramInt)
  {
    this.dXl = paramInt;
  }
  
  public void setListener(e parame)
  {
    if (parame == null)
    {
      this.mListenerRef = null;
      return;
    }
    this.mListenerRef = new WeakReference(parame);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      yW(false);
      this.cro = null;
      this.crF = null;
      if (this.c != null) {
        this.c.bIe();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + paramInt);
      }
      return;
      if (this.c != null) {
        this.c.bIf();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void af(boolean paramBoolean, String paramString);
  }
  
  public static class b
    extends wso
  {
    public View IV;
    public TextView titleText;
  }
  
  public static class c
  {
    public RobotPanelLayoutBase.d a;
    public RobotPanelLayoutBase.d b;
    public boolean cPY;
    public boolean cSG;
    
    public static c a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      c localc = new c();
      localc.a = RobotPanelLayoutBase.d.a(paramString4, paramString3);
      localc.b = RobotPanelLayoutBase.d.a(paramString2, paramString1);
      localc.cSG = false;
      return localc;
    }
    
    public static c a(cmd0x934.Item paramItem)
    {
      c localc = new c();
      localc.a = RobotPanelLayoutBase.d.a(paramItem.off_info);
      localc.b = RobotPanelLayoutBase.d.a(paramItem.on_info);
      localc.cSG = paramItem.hot.get();
      return localc;
    }
    
    public boolean aBB()
    {
      return !TextUtils.isEmpty(this.b.title);
    }
  }
  
  public static class d
  {
    public int bgColor = -1;
    public int borderColor = -7829368;
    public int fontColor = -16777216;
    public String icon;
    public String title;
    public String url;
    
    public static d a(String paramString1, String paramString2)
    {
      d locald = new d();
      locald.title = paramString1;
      locald.icon = "";
      locald.url = paramString2;
      try
      {
        locald.bgColor = 0;
        locald.fontColor = 0;
        locald.borderColor = 0;
        return locald;
      }
      catch (Exception paramString1) {}
      return locald;
    }
    
    public static d a(cmd0x934.ItemInfo paramItemInfo)
    {
      d locald = new d();
      locald.title = paramItemInfo.title.get();
      locald.icon = paramItemInfo.icon.get();
      locald.url = paramItemInfo.url.get();
      try
      {
        locald.bgColor = Color.parseColor(paramItemInfo.color.get());
        locald.fontColor = Color.parseColor(paramItemInfo.font_color.get());
        locald.borderColor = Color.parseColor(paramItemInfo.border_color.get());
        return locald;
      }
      catch (Exception paramItemInfo) {}
      return locald;
    }
  }
  
  public static abstract interface e
  {
    public abstract void xP(String paramString);
  }
  
  public static class f
  {
    public ArrayList<RobotPanelLayoutBase.c> items;
    public String name;
    
    public static f a(cmd0x934.List paramList)
    {
      f localf = new f();
      localf.name = paramList.name.get();
      localf.items = new ArrayList(paramList.items.size());
      int i = 0;
      while (i < paramList.items.size())
      {
        localf.items.add(RobotPanelLayoutBase.c.a((cmd0x934.Item)paramList.items.get(i)));
        i += 1;
      }
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */