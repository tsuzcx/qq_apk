package cooperation.qqreader.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqgz;
import aqgz.a;
import avmt;
import avnm;
import avnn;
import avob.a;
import avoc;
import avof;
import avog;
import avoh;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ReaderTabBarView
  extends LinearLayout
{
  private ArrayList<String> EQ = new ArrayList();
  private List<WebViewTabBarData> Lw;
  private avnn a;
  private int aXA = -1;
  public TabBarView.a b;
  private LinearLayout.LayoutParams c;
  private SparseArray<a> ea;
  private SparseArray<ArrayList<String>> eb = new SparseArray();
  private int exC = 1;
  private int exD;
  private int exE;
  private int exF;
  private int exG;
  private Drawable gS = new ColorDrawable(Color.parseColor("#e5e5e5"));
  private String[] iR;
  private String[] iS;
  private String[] iT;
  private AppInterface mApp;
  private Context mContext;
  private int mOldPosition = -1;
  private HashMap<Integer, c> qE = new HashMap();
  private int[] tG;
  
  public ReaderTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReaderTabBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReaderTabBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.c = new LinearLayout.LayoutParams(0, aqcx.dip2px(paramContext, 54.0F));
    this.c.weight = 1.0F;
    this.c.gravity = 17;
    this.ea = new SparseArray();
  }
  
  private void K(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.ea.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.ea.valueAt(i);
      if (locala != null)
      {
        locala.Hx.setImageDrawable(locala.gT);
        locala.agh.setTextColor(this.exE);
        if (paramInt2 == locala.position)
        {
          locala.Hx.setImageDrawable(locala.gU);
          locala.agh.setTextColor(this.exF);
        }
      }
      i += 1;
    }
    if (paramBoolean) {
      lg(paramInt1, paramInt2);
    }
    avoc.d("ReaderTabBarView", "mSelectedTab =" + paramInt1 + ",tabIndex=" + paramInt2 + ",isHumanClick=" + paramBoolean);
  }
  
  private void L(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c localc = (c)this.qE.get(Integer.valueOf(paramInt1));
    if (localc == null)
    {
      cr(paramInt1, paramBoolean);
      localc = (c)this.qE.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      if (localc != null) {
        localc.cs(paramInt1, paramBoolean);
      }
      do
      {
        return;
      } while (paramInt2 < localc.priority);
      localc.priority = paramInt2;
      localc.type = 1;
    }
  }
  
  private void ZZ(String paramString)
  {
    if (this.a != null) {
      this.a.ZW(paramString);
    }
  }
  
  private View[] a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    TabItemView localTabItemView = new TabItemView(getContext());
    localTabItemView.agh.setText(paramString);
    localTabItemView.agh.setContentDescription(paramString);
    localTabItemView.LK.setBackgroundDrawable(this.gS);
    d locald = new d(null);
    locald.agh = localTabItemView.agh;
    locald.Hx = localTabItemView.Hx;
    localTabItemView.setTag(-3, locald);
    localTabItemView.setBackgroundDrawable(null);
    localTabItemView.setOnClickListener(new b(this, paramInt, this.Lw));
    addView(localTabItemView, paramInt, this.c);
    if (AppSetting.enableTalkBack) {
      localTabItemView.setContentDescription(paramString);
    }
    return new View[] { localTabItemView, localTabItemView.Hx, localTabItemView.agh };
  }
  
  private View[] a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  private void abP(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 1: 
      setRedIconShow(1, false);
      ZZ("769.100900");
      return;
    case 0: 
      setRedIconShow(0, false);
      ZZ("769.100920");
      return;
    case 3: 
      setRedIconShow(3, false);
      ZZ("769.100916");
      return;
    case 2: 
      setRedIconShow(2, false);
      ZZ("769.100970");
      return;
    case 6: 
      setRedIconShow(6, false);
      ZZ("769.100980");
      return;
    }
    setRedIconShow(4, false);
    ZZ("769.100990");
  }
  
  private void abQ(int paramInt)
  {
    abP(paramInt);
    avog.h(this.mContext, paramInt, false);
    a(avog.z(this.mContext, paramInt), paramInt, ln(paramInt), false, new Object[] { avog.o(this.mContext, paramInt) });
  }
  
  private void ae(int paramInt1, String paramString, int paramInt2)
  {
    b(paramInt1, 2, paramString, paramInt2, true);
  }
  
  private void at(Map<String, RedAppInfo> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (this.a.tw("769.100900")) {
      setRedIconShow(1, true);
    }
    if (this.a.tw("769.100920")) {
      setRedIconShow(0, true);
    }
    if (this.a.tw("769.100916")) {
      setRedIconShow(3, true);
    }
    if (this.a.tw("769.100970")) {
      setRedIconShow(2, true);
    }
    if (this.a.tw("769.100980")) {
      setRedIconShow(6, true);
    }
    if (this.a.tw("769.100990")) {
      setRedIconShow(4, true);
    }
    abP(this.tG[this.aXA]);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    Object localObject = (a)this.ea.get(paramInt1);
    if ((localObject == null) || (((a)localObject).yh == null) || (this.qE.containsKey(Integer.valueOf(paramInt1)))) {
      return;
    }
    localObject = (RedTouchUI)new RedTouchUI(this.mContext, ((a)localObject).yh).a(5).a();
    ((RedTouchUI)localObject).setRedpointImgResID(2130851400);
    ((RedTouchUI)localObject).setTextOrNumImgRedID(2130851404);
    paramString = new c(paramInt2, paramString, paramBoolean, paramInt3, (RedTouchUI)localObject);
    this.qE.put(Integer.valueOf(paramInt1), paramString);
  }
  
  private void cr(int paramInt, boolean paramBoolean)
  {
    b(paramInt, 1, "", 0, paramBoolean);
  }
  
  private void eBu()
  {
    int i = 0;
    while (i <= 3)
    {
      if (avog.m(this.mContext, i))
      {
        setTextMsg(i, avog.o(this.mContext, i), ln(i) + 1, true);
        avof.c(getNetWorkTypeName(), getResolution(), "69", "335", "", "2", "", "", "");
      }
      i += 1;
    }
  }
  
  private void lg(int paramInt1, int paramInt2)
  {
    if ((this.iR == null) || (this.iS == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVENT_REPORT_TAB_SWITCH_KEY_CUR_TAB_INDEX", paramInt1);
    localBundle.putInt("EVENT_REPORT_TAB_SWITCH_KEY_CLICK_TAB_INDEX", paramInt2);
    localBundle.putStringArray("EVENT_REPORT_TAB_SWITCH_KEY_PAGE_IDS", this.iR);
    localBundle.putStringArray("EVENT_REPORT_TAB_SWITCH_KEY_MODULE_IDS", this.iS);
    avnm.a().handleEvent("EVENT_REPORT_TAB_SWITCH", localBundle);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramInt1 == 1) {
      setRedIconShow(paramInt2, paramBoolean);
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        setTextMsg(paramInt2, (String)paramVarArgs[0], paramInt3, paramBoolean);
        return;
      }
    } while (paramInt1 != 3);
    setUnReadMsg(paramInt2, Integer.parseInt((String)paramVarArgs[0]));
  }
  
  public void a(Intent paramIntent, @NonNull List<WebViewTabBarData> paramList, TabBarView.a parama)
  {
    this.b = parama;
    parama = null;
    if ((getContext() instanceof ReaderHomePageActivity)) {
      parama = ((ReaderHomePageActivity)getContext()).a();
    }
    Object localObject = parama;
    if (parama == null)
    {
      avoc.e("ReaderTabBarView", "[init] configDataHelper is null!");
      localObject = new avmt((Activity)getContext());
    }
    this.tG = ((avmt)localObject).al();
    this.iR = ((avmt)localObject).Z();
    this.iS = ((avmt)localObject).aa();
    this.iT = ((avmt)localObject).Y();
    int j = avmt.exw;
    this.exE = avmt.exx;
    this.exF = avmt.exy;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_tab_main_tab_pos", 0);
      avoc.i("ReaderTabBarView", " targetTabPos=" + i);
      paramIntent.removeExtra("key_tab_main_tab_pos");
      j = paramIntent.getIntExtra("key_tab_color", avmt.exw);
      paramIntent.removeExtra("key_tab_color");
      this.exE = paramIntent.getIntExtra("key_tab_name_color", avmt.exx);
      paramIntent.removeExtra("key_tab_name_color");
      this.exF = paramIntent.getIntExtra("key_name_selected_color", avmt.exy);
      paramIntent.removeExtra("key_tab_name_color");
      setBackgroundDrawable(new ColorDrawable(j));
      this.Lw = paramList;
      int m = paramList.size();
      avoc.d("ReaderTabBarView", "[init] dataList size = " + m);
      j = 0;
      label277:
      if (j >= m) {
        break label495;
      }
      paramIntent = new a();
      paramIntent.position = this.exD;
      if (this.tG != null) {
        break label481;
      }
    }
    label481:
    for (int k = avmt.lm(Integer.parseInt(((WebViewTabBarData)paramList.get(j)).tag));; k = this.tG[this.exD])
    {
      paramIntent.itemId = k;
      paramIntent.name = ((WebViewTabBarData)paramList.get(j)).tabName;
      parama = a(((WebViewTabBarData)paramList.get(j)).tabName);
      paramIntent.yh = parama[0];
      paramIntent.Hx = ((ImageView)parama[1]);
      paramIntent.agh = ((TextView)parama[2]);
      paramIntent.gT = avoh.t(((WebViewTabBarData)paramList.get(j)).tabIcon);
      paramIntent.gU = avoh.t(this.iT[this.exD]);
      this.ea.put(paramIntent.itemId, paramIntent);
      this.exD += 1;
      j += 1;
      break label277;
      avoc.e("ReaderTabBarView", "[init] intent is null!");
      i = 0;
      break;
    }
    label495:
    this.exG = i;
    K(this.mOldPosition, this.exG, true);
    this.aXA = this.exG;
    this.mOldPosition = this.aXA;
    int i = avob.a.bC(this.mContext);
    if (i > 0)
    {
      lh(0, i);
      avof.c(getNetWorkTypeName(), getResolution(), "69", "335", "", "2", "", "", "");
    }
    eBu();
  }
  
  public boolean aKS()
  {
    if (this.aXA == -1) {}
    while (this.tG[this.aXA] != 0) {
      return false;
    }
    return true;
  }
  
  public boolean aKT()
  {
    boolean bool = true;
    if (this.aXA == -1) {
      return false;
    }
    if (this.tG[this.aXA] == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void bOU()
  {
    ThreadManager.postImmediately(new ReaderTabBarView.1(this), null, false);
  }
  
  public void eBs()
  {
    ((QQBrowserActivity)this.mContext).c().getIntent().putExtra("key_current_tab_item_id", this.exC);
  }
  
  public void eBt()
  {
    this.EQ = new ArrayList();
    this.EQ.add("769.100900");
    this.EQ.add("769.100920");
    this.EQ.add("769.100916");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("769.100900.100901");
    localArrayList.add("769.100900.100902");
    localArrayList.add("769.100900.100903");
    localArrayList.add("769.100900.100904");
    localArrayList.add("769.100900.100905");
    localArrayList.add("769.100900.100906");
    localArrayList.add("769.100900.100907");
    localArrayList.add("769.100900.100908");
    localArrayList.add("769.100900.100909");
    localArrayList.add("769.100900.100910");
    localArrayList.add("769.100900.100911");
    this.eb.put(1, localArrayList);
    this.EQ.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100920.100921");
    this.eb.put(0, localArrayList);
    this.EQ.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100970");
    this.eb.put(2, localArrayList);
    this.EQ.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100980");
    this.eb.put(6, localArrayList);
    this.EQ.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100990");
    this.eb.put(4, localArrayList);
    this.EQ.addAll(localArrayList);
  }
  
  public String getNetWorkTypeName()
  {
    return aqgz.a(this.mContext).networkType;
  }
  
  public String getResolution()
  {
    return avoh.j((Activity)this.mContext);
  }
  
  public void lh(int paramInt1, int paramInt2)
  {
    b(paramInt1, 3, String.valueOf(paramInt2), 0, false);
  }
  
  public int ln(int paramInt)
  {
    c localc = (c)this.qE.get(Integer.valueOf(paramInt));
    if (localc == null) {
      return 0;
    }
    return localc.priority;
  }
  
  public boolean nv(int paramInt)
  {
    if (!this.qE.containsKey(Integer.valueOf(paramInt))) {
      return false;
    }
    return ((c)this.qE.get(Integer.valueOf(paramInt))).show;
  }
  
  public void setCurrentItemId(int paramInt)
  {
    this.exC = paramInt;
  }
  
  public void setRedIconShow(int paramInt, boolean paramBoolean)
  {
    L(paramInt, 0, paramBoolean);
  }
  
  public void setSelectedTab(int paramInt)
  {
    setSelectedTab(paramInt, true);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = getChildCount();
    paramInt = i;
    if (i >= j) {
      paramInt = j - 1;
    }
    if (this.aXA != paramInt)
    {
      if (this.b != null) {
        this.b.onTabSelected(this.aXA, paramInt);
      }
      K(this.aXA, paramInt, paramBoolean);
      this.aXA = paramInt;
    }
  }
  
  public void setTextMsg(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    c localc = (c)this.qE.get(Integer.valueOf(paramInt1));
    if (localc == null) {
      ae(paramInt1, paramString, paramInt2);
    }
    for (paramString = (c)this.qE.get(Integer.valueOf(paramInt1));; paramString = localc)
    {
      if (paramString != null) {
        paramString.cs(paramInt1, paramBoolean);
      }
      do
      {
        return;
      } while (paramInt2 < localc.priority);
      localc.priority = paramInt2;
      localc.type = 2;
      localc.content = paramString;
    }
  }
  
  public void setUnReadMsg(int paramInt1, int paramInt2)
  {
    setUnReadMsg(paramInt1, paramInt2, 0);
  }
  
  public void setUnReadMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = (c)this.qE.get(Integer.valueOf(paramInt1));
    if (localc == null)
    {
      lh(paramInt1, paramInt2);
      localc = (c)this.qE.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      if (localc != null) {
        localc.cs(paramInt1, true);
      }
      do
      {
        return;
      } while (paramInt3 < localc.priority);
      localc.priority = paramInt3;
      localc.type = 3;
      localc.content = String.valueOf(paramInt2);
    }
  }
  
  public static class a
  {
    ImageView Hx;
    TextView agh;
    Drawable gT;
    Drawable gU;
    int itemId;
    String name;
    int position;
    View yh;
  }
  
  static class b
    implements View.OnClickListener
  {
    final List<WebViewTabBarData> Lx;
    private long azP;
    final WeakReference<ReaderTabBarView> j;
    final int position;
    
    b(ReaderTabBarView paramReaderTabBarView, int paramInt, @NonNull List<WebViewTabBarData> paramList)
    {
      this.j = new WeakReference(paramReaderTabBarView);
      this.position = paramInt;
      this.Lx = paramList;
    }
    
    public void onClick(View paramView)
    {
      ReaderTabBarView localReaderTabBarView = (ReaderTabBarView)this.j.get();
      if (localReaderTabBarView == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.position != ReaderTabBarView.a(localReaderTabBarView))
        {
          long l = System.currentTimeMillis();
          if (l - this.azP >= 500L)
          {
            this.azP = l;
            localReaderTabBarView.setSelectedTab(this.position);
            int i = ReaderTabBarView.a(localReaderTabBarView)[this.position];
            localReaderTabBarView.setCurrentItemId(i);
            localReaderTabBarView.eBs();
            ReaderTabBarView.a(localReaderTabBarView, i);
            String str1 = localReaderTabBarView.getNetWorkTypeName();
            String str2 = localReaderTabBarView.getResolution();
            switch (i)
            {
            default: 
              break;
            case 0: 
              avof.e(str1, str2, "297", "0", "3", "", "");
              if (localReaderTabBarView.nv(i)) {
                avof.c(str1, str2, "69", "336", "0", "3", "", "", "");
              }
              break;
            case 1: 
              avof.e(str1, str2, "298", "0", "3", "", "");
              break;
            case 3: 
              if (avob.a.cR(localReaderTabBarView.getContext())) {
                avob.a.Y(localReaderTabBarView.getContext(), false);
              }
              avof.e(str1, str2, "300", "0", "3", "", "");
              break;
            case 2: 
              avof.e(str1, str2, "1847", "0", "3", "", "");
            }
          }
        }
      }
    }
  }
  
  class c
  {
    RedTouchUI b;
    String content;
    int priority = 0;
    boolean show;
    int type;
    
    public c(int paramInt1, String paramString, boolean paramBoolean, int paramInt2, RedTouchUI paramRedTouchUI)
    {
      this.type = paramInt1;
      this.content = paramString;
      this.show = paramBoolean;
      this.priority = paramInt2;
      this.b = paramRedTouchUI;
    }
    
    public void cs(int paramInt, boolean paramBoolean)
    {
      if (ReaderTabBarView.a(ReaderTabBarView.this).get(paramInt) == null) {}
      label165:
      do
      {
        do
        {
          return;
          this.show = paramBoolean;
          if ((!this.show) && (ReaderTabBarView.a(ReaderTabBarView.this).containsKey(Integer.valueOf(paramInt)))) {
            ReaderTabBarView.a(ReaderTabBarView.this).remove(Integer.valueOf(paramInt));
          }
          switch (this.type)
          {
          default: 
            paramInt = 0;
          }
          for (;;)
          {
            if (this.show) {
              break label165;
            }
            this.b.dGB();
            return;
            paramInt = 0;
            continue;
            paramInt = -1;
            try
            {
              int i = Integer.parseInt(this.content);
              paramInt = i;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                avoc.e("ReaderTabBarView", localNumberFormatException.getMessage());
                continue;
                paramBoolean = false;
              }
            }
            if (this.show)
            {
              if (paramInt <= 0) {
                break;
              }
              paramBoolean = true;
              this.show = paramBoolean;
            }
            paramInt = 4;
          }
          RedAppInfo localRedAppInfo = new RedAppInfo();
          localRedAppInfo.Tj(1);
          localRedAppInfo.setType(paramInt);
          RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
          RedTypeInfo localRedTypeInfo = new RedTypeInfo();
          localRedTypeInfo.setRed_type(paramInt);
          Object localObject;
          if (paramInt == 4) {
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("cn", "#FF0000");
            localRedTypeInfo.setRed_desc(((JSONObject)localObject).toString());
            localRedTypeInfo.setRed_content(this.content);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(localRedTypeInfo);
            localRedDisplayInfo.eK((ArrayList)localObject);
            localRedAppInfo.a(localRedDisplayInfo);
            this.b.b(localRedAppInfo);
            if (localRedTypeInfo.getRed_type() != 0) {
              break;
            }
            if (ReaderTabBarView.b(ReaderTabBarView.this) == 4)
            {
              this.b.a(0, 20, 8, 0).a();
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              avoc.e("ReaderTabBarView", localJSONException.getMessage());
            }
          }
        } while (ReaderTabBarView.b(ReaderTabBarView.this) != 5);
        this.b.a(0, 15, 8, 0).a();
        return;
        if (ReaderTabBarView.b(ReaderTabBarView.this) == 4)
        {
          this.b.a(0, 30, 2, 0).a();
          return;
        }
      } while (ReaderTabBarView.b(ReaderTabBarView.this) != 5);
      this.b.a(0, 25, 2, 0).a();
    }
  }
  
  static class d
  {
    public ImageView Hx;
    public TextView agh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.ReaderTabBarView
 * JD-Core Version:    0.7.0.1
 */