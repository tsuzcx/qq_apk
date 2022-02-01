import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class abdq
  extends BaseAdapter
{
  static LRULinkedHashMap<String, URLDrawable> a = new LRULinkedHashMap(15);
  View Ay;
  long Nj;
  final int TYPE_COUNT = 3;
  final int TYPE_LIST = 1;
  final int cnL = 0;
  final int cnM = 2;
  int cnN;
  int cnO;
  int cnP;
  int cnQ;
  int cnR;
  int cnS;
  int cnT;
  int columnWidth;
  List<Object> data;
  Drawable eo;
  LinearLayout ig;
  QQAppInterface mApp;
  Context mContext;
  int mDisplayWidth;
  View.OnClickListener mOnClickListener;
  AdapterView.c mOnItemClickListener;
  String mUin;
  int pG = 4;
  public boolean scrolling;
  SharedPreferences sharedPreferences;
  
  public abdq(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.c paramc, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.mContext = paramContext;
    this.mOnClickListener = paramOnClickListener;
    this.mOnItemClickListener = paramc;
    this.data = new ArrayList();
    this.mDisplayWidth = paramInt1;
    this.mApp = paramQQAppInterface;
    this.mUin = paramString;
    this.cnN = paramInt2;
    this.cnP = aqcx.dip2px(this.mContext, 4.0F);
    this.columnWidth = ((this.mDisplayWidth - this.cnP * (this.pG + 1)) / this.pG);
    this.cnO = (this.columnWidth * 176 / 150);
    this.cnQ = (this.columnWidth - aqcx.dip2px(this.mContext, 10.0F));
    this.cnR = (this.cnO - aqcx.dip2px(this.mContext, 10.0F));
    this.eo = new ColorDrawable(0);
  }
  
  public void C(List<aqph> paramList, List<aqpf> paramList1)
  {
    this.data.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.data.add(paramList1);
    }
    this.data.addAll(paramList);
    paramList = ((acff)this.mApp.getManager(51)).a(this.mUin);
    if (paramList != null)
    {
      this.Nj = paramList.pendantId;
      this.cnS = paramList.faceId;
    }
    super.notifyDataSetChanged();
  }
  
  public void cBg()
  {
    if ((this.ig == null) || (this.Ay == null)) {
      return;
    }
    List localList = zpo.uG;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.ig.removeAllViews();
      int i = 0;
      if (i < localList.size())
      {
        Object localObject1 = (zpo.a)localList.get(i);
        View localView = LayoutInflater.from(this.mContext).inflate(2131562076, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363204);
        TextView localTextView1 = (TextView)localView.findViewById(2131366010);
        TextView localTextView2 = (TextView)localView.findViewById(2131366008);
        ImageView localImageView = (ImageView)localView.findViewById(2131379037);
        if (!TextUtils.isEmpty(((zpo.a)localObject1).imageUrl)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((zpo.a)localObject1).imageUrl));
        }
        localTextView1.setText(((zpo.a)localObject1).title);
        localTextView2.setText(((zpo.a)localObject1).desc);
        switch (((zpo.a)localObject1).tag)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          if (localImageView.getVisibility() == 0)
          {
            localObject2 = localImageView.getDrawable();
            if (localObject2 != null) {
              localImageView.setLayoutParams(new LinearLayout.LayoutParams(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight()));
            }
          }
          localView.setOnClickListener(new abdr(this, (zpo.a)localObject1, i));
          localView.addOnLayoutChangeListener(new abds(this));
          if (i != 0) {
            localView.findViewById(2131378669).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, wja.dp2px(75.0F, this.mContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.ig.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i += 1;
          break;
          localImageView.setImageResource(2130847936);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130847937);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838655);
          localImageView.setVisibility(0);
          continue;
          localImageView.setVisibility(8);
        }
      }
      this.ig.setVisibility(0);
      this.Ay.setVisibility(0);
      return;
    }
    this.ig.setVisibility(8);
    this.Ay.setVisibility(8);
  }
  
  public void clearCache()
  {
    a.clear();
  }
  
  public int getCount()
  {
    return this.data.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.data.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((this.data.get(paramInt - 1) instanceof aqph)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    Object localObject1;
    if ((paramInt >= getCount()) || (paramInt < 0))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    int i = getItemViewType(paramInt);
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new abdq.c();
      if (i == 0)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131562079, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131381214);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.cnN;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.ig = ((LinearLayout)paramView.findViewById(2131366488));
        this.Ay = paramView.findViewById(2131381215);
        cBg();
        paramView.setTag(localObject1);
      }
    }
    label147:
    label1965:
    label1990:
    label2130:
    label2136:
    for (;;)
    {
      ((abdq.c)localObject1).position = paramInt;
      aqph localaqph;
      if (i == 1)
      {
        localaqph = (aqph)getItem(paramInt);
        ((abdq.c)localObject1).h.setTag(localaqph);
        if (localaqph.cuF != null)
        {
          if (localaqph.cuF.equals("1"))
          {
            ((abdq.c)localObject1).xh.setVisibility(0);
            ((abdq.c)localObject1).xh.setImageDrawable(this.mContext.getResources().getDrawable(2130848318));
          }
        }
        else
        {
          label231:
          if (localaqph.name != null)
          {
            ((abdq.c)localObject1).Ph.setText(localaqph.name + "(" + localaqph.vN.size() + ")");
            ((abdq.c)localObject1).Ph.setContentDescription(localaqph.name);
          }
          ((abdq.c)localObject1).xi.setTag(Integer.valueOf(localaqph.tag));
          switch (localaqph.tag)
          {
          default: 
            ((abdq.c)localObject1).xi.setVisibility(8);
            label378:
            if ((localaqph.cuG != null) && (localaqph.cuG.equals("actLiTpl")))
            {
              if (localaqph.name == null) {
                break label2130;
              }
              ((abdq.c)localObject1).Pj.setText(localaqph.name);
              ((abdq.c)localObject1).Pj.setContentDescription(localaqph.name);
              ((abdq.c)localObject1).Pj.setVisibility(0);
            }
            break;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (localaqph.subtitle != null)
        {
          ((abdq.c)localObject1).Pk.setText(localaqph.subtitle);
          ((abdq.c)localObject1).Pk.setVisibility(0);
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            ((abdq.c)localObject1).ih.setVisibility(0);
            ((abdq.c)localObject1).divider.setVisibility(0);
            ((abdq.c)localObject1).jd.setVisibility(8);
            ((abdq.b)((abdq.c)localObject1).h.getAdapter()).a(localaqph);
            ((abdq.c)localObject1).Pi.setTag(Integer.valueOf(localaqph.ebe));
            ((abdq.c)localObject1).cq.setTag(Integer.valueOf(localaqph.ebe));
            if ((localaqph.vN.size() <= 4) || ((localaqph.cuG != null) && (!localaqph.cuG.equals("")))) {
              break label1990;
            }
            ((abdq.c)localObject1).Pi.setVisibility(0);
            ((abdq.c)localObject1).cq.setVisibility(0);
            if (localaqph.cVy) {
              break label1965;
            }
            ((abdq.c)localObject1).Pi.setText(2131697294);
            ((abdq.c)localObject1).cq.setImageResource(2130850771);
            if (paramInt != getCount() - 1) {
              break label2013;
            }
            ((abdq.c)localObject1).divider.setVisibility(8);
          }
          for (;;)
          {
            localObject1 = paramView;
            break;
            if (i == 1)
            {
              paramView = LayoutInflater.from(this.mContext).inflate(2131562078, paramViewGroup, false);
              ((abdq.c)localObject1).jd = ((RelativeLayout)paramView.findViewById(2131372976));
              ((abdq.c)localObject1).xh = ((ImageView)paramView.findViewById(2131372980));
              ((abdq.c)localObject1).Ph = ((TextView)paramView.findViewById(2131372982));
              ((abdq.c)localObject1).xi = ((ImageView)paramView.findViewById(2131372981));
              ((abdq.c)localObject1).h = ((GridView)paramView.findViewById(2131372969));
              ((abdq.c)localObject1).Pi = ((TextView)paramView.findViewById(2131372974));
              ((abdq.c)localObject1).cq = ((ImageView)paramView.findViewById(2131372973));
              ((abdq.c)localObject1).ih = ((LinearLayout)paramView.findViewById(2131372960));
              ((abdq.c)localObject1).Pj = ((TextView)paramView.findViewById(2131372962));
              ((abdq.c)localObject1).Pk = ((TextView)paramView.findViewById(2131372961));
              ((abdq.c)localObject1).divider = paramView.findViewById(2131365997);
              localObject2 = new abdq.b();
              ((abdq.c)localObject1).h.setAdapter((ListAdapter)localObject2);
              ((abdq.c)localObject1).h.setNumColumns(this.pG);
              ((abdq.c)localObject1).h.setColumnWidth(this.columnWidth);
              ((abdq.c)localObject1).h.setHorizontalSpacing(this.cnP);
              ((abdq.c)localObject1).h.setVerticalSpacing(this.cnP);
              ((abdq.c)localObject1).h.setSelector(new ColorDrawable(0));
              ((abdq.c)localObject1).h.setClickable(true);
              ((abdq.c)localObject1).h.setOnItemClickListener(this.mOnItemClickListener);
              ((abdq.c)localObject1).h.setAddStatesFromChildren(true);
              ((abdq.c)localObject1).Pi.setOnClickListener(this.mOnClickListener);
              ((abdq.c)localObject1).cq.setOnClickListener(this.mOnClickListener);
              paramView.setTag(localObject1);
              break label147;
            }
            if (i != 2) {
              break label2136;
            }
            paramView = LayoutInflater.from(this.mContext).inflate(2131562073, paramViewGroup, false);
            ((abdq.c)localObject1).jd = ((RelativeLayout)paramView.findViewById(2131366656));
            ((abdq.c)localObject1).xh = ((ImageView)paramView.findViewById(2131366674));
            ((abdq.c)localObject1).Ph = ((TextView)paramView.findViewById(2131366676));
            ((abdq.c)localObject1).xi = ((ImageView)paramView.findViewById(2131366675));
            ((abdq.c)localObject1).h = ((GridView)paramView.findViewById(2131375411));
            ((abdq.c)localObject1).Pi = ((TextView)paramView.findViewById(2131366654));
            ((abdq.c)localObject1).cq = ((ImageView)paramView.findViewById(2131366653));
            ((abdq.c)localObject1).ih = ((LinearLayout)paramView.findViewById(2131366629));
            ((abdq.c)localObject1).Pj = ((TextView)paramView.findViewById(2131366631));
            ((abdq.c)localObject1).Pk = ((TextView)paramView.findViewById(2131366630));
            ((abdq.c)localObject1).divider = paramView.findViewById(2131365997);
            ((abdq.c)localObject1).h.setAdapter(new abdq.a());
            ((abdq.c)localObject1).Ph.setText(acfp.m(2131702999) + AvatarPendantManager.ebf + ")");
            ((abdq.c)localObject1).h.setNumColumns(this.pG);
            ((abdq.c)localObject1).h.setColumnWidth(this.columnWidth);
            ((abdq.c)localObject1).h.setHorizontalSpacing(this.cnP);
            ((abdq.c)localObject1).h.setVerticalSpacing(this.cnP);
            ((abdq.c)localObject1).h.setSelector(new ColorDrawable(0));
            ((abdq.c)localObject1).h.setClickable(true);
            ((abdq.c)localObject1).h.setOnItemClickListener(this.mOnItemClickListener);
            ((abdq.c)localObject1).h.setAddStatesFromChildren(true);
            ((abdq.c)localObject1).Pi.setOnClickListener(this.mOnClickListener);
            ((abdq.c)localObject1).cq.setOnClickListener(this.mOnClickListener);
            paramView.setTag(localObject1);
            break label147;
            localObject1 = (abdq.c)paramView.getTag();
            break label147;
            if (localaqph.cuF.equals("3"))
            {
              ((abdq.c)localObject1).xh.setVisibility(0);
              ((abdq.c)localObject1).xh.setImageDrawable(this.mContext.getResources().getDrawable(2130848317));
              break label231;
            }
            ((abdq.c)localObject1).xh.setVisibility(8);
            break label231;
            ((abdq.c)localObject1).xi.setVisibility(0);
            ((abdq.c)localObject1).xi.setImageDrawable(this.mContext.getResources().getDrawable(2130847937));
            break label378;
            ((abdq.c)localObject1).xi.setVisibility(0);
            ((abdq.c)localObject1).xi.setImageDrawable(this.mContext.getResources().getDrawable(2130847936));
            break label378;
            ((abdq.c)localObject1).xi.setVisibility(0);
            ((abdq.c)localObject1).xi.setImageDrawable(this.mContext.getResources().getDrawable(2130848319));
            break label378;
            File localFile = new File(aqgm.csV + "/free.png");
            if (localFile.exists())
            {
              ((abdq.c)localObject1).xi.setVisibility(0);
              localObject3 = (URLDrawable)a.get("key_free.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.eo;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.eo;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  a.put("key_free.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((abdq.c)localObject1).xi.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((abdq.c)localObject1).xi.setVisibility(8);
            break label378;
            localFile = new File(aqgm.csV + "/rare.png");
            if (localFile.exists())
            {
              ((abdq.c)localObject1).xi.setVisibility(0);
              localObject3 = (URLDrawable)a.get("key_rare.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.eo;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.eo;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  a.put("key_rare.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((abdq.c)localObject1).xi.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((abdq.c)localObject1).xi.setVisibility(8);
            break label378;
            ((abdq.c)localObject1).xi.setVisibility(0);
            ((abdq.c)localObject1).xi.setImageDrawable(this.mContext.getResources().getDrawable(2130848325));
            break label378;
            ((abdq.c)localObject1).xi.setVisibility(0);
            ((abdq.c)localObject1).xi.setImageDrawable(this.mContext.getResources().getDrawable(2130848324));
            break label378;
            ((abdq.c)localObject1).ih.setVisibility(8);
            ((abdq.c)localObject1).jd.setVisibility(0);
            break label513;
            ((abdq.c)localObject1).ih.setVisibility(8);
            ((abdq.c)localObject1).jd.setVisibility(0);
            break label513;
            ((abdq.c)localObject1).Pi.setText(2131717405);
            ((abdq.c)localObject1).cq.setImageResource(2130850774);
            break label645;
            ((abdq.c)localObject1).Pi.setVisibility(8);
            ((abdq.c)localObject1).cq.setVisibility(8);
            break label645;
            label2013:
            ((abdq.c)localObject1).divider.setVisibility(0);
            continue;
            if (i == 2)
            {
              localObject2 = (List)getItem(paramInt);
              ((abdq.a)((abdq.c)localObject1).h.getAdapter()).hR((List)localObject2);
              if (((List)localObject2).size() == 8)
              {
                ((abdq.c)localObject1).Pi.setVisibility(0);
                ((abdq.c)localObject1).cq.setVisibility(0);
                ((abdq.c)localObject1).Pi.setText(acfp.m(2131702986));
              }
              else
              {
                ((abdq.c)localObject1).Pi.setVisibility(8);
                ((abdq.c)localObject1).cq.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public class a
    extends BaseAdapter
  {
    List<aqpf> fp;
    int pS = 1;
    
    public a() {}
    
    public int getCount()
    {
      if (this.fp != null) {
        return this.fp.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.fp != null) {
        return this.fp.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    /* Error */
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	abdq$a:fp	Ljava/util/List;
      //   4: astore 5
      //   6: aload 5
      //   8: ifnonnull +29 -> 37
      //   11: aload_2
      //   12: astore 5
      //   14: aload_2
      //   15: astore 6
      //   17: aload 5
      //   19: astore_2
      //   20: invokestatic 52	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
      //   23: iload_1
      //   24: aload_2
      //   25: aload_3
      //   26: aload_0
      //   27: iload_1
      //   28: invokevirtual 54	abdq$a:getItemId	(I)J
      //   31: invokevirtual 58	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
      //   34: aload 6
      //   36: areturn
      //   37: aload_2
      //   38: ifnonnull +501 -> 539
      //   41: new 9	abdq$a$a
      //   44: dup
      //   45: aload_0
      //   46: invokespecial 61	abdq$a$a:<init>	(Labdq$a;)V
      //   49: astore 7
      //   51: aload_0
      //   52: getfield 20	abdq$a:b	Labdq;
      //   55: getfield 65	abdq:mContext	Landroid/content/Context;
      //   58: invokestatic 71	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   61: ldc 72
      //   63: aload_3
      //   64: iconst_0
      //   65: invokevirtual 76	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   68: astore 5
      //   70: aload 5
      //   72: astore_2
      //   73: aload_2
      //   74: astore 5
      //   76: aload 7
      //   78: aload_2
      //   79: ldc 77
      //   81: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
      //   84: checkcast 85	android/widget/RelativeLayout
      //   87: putfield 89	abdq$a$a:jb	Landroid/widget/RelativeLayout;
      //   90: aload_2
      //   91: astore 5
      //   93: aload 7
      //   95: aload_2
      //   96: ldc 90
      //   98: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
      //   101: checkcast 92	com/tencent/mobileqq/vas/avatar/VasAvatar
      //   104: putfield 95	abdq$a$a:b	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
      //   107: aload_2
      //   108: astore 5
      //   110: aload 7
      //   112: aload_2
      //   113: ldc 96
      //   115: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
      //   118: checkcast 98	android/widget/ImageView
      //   121: putfield 102	abdq$a$a:xa	Landroid/widget/ImageView;
      //   124: aload_2
      //   125: astore 5
      //   127: aload 7
      //   129: aload_2
      //   130: ldc 103
      //   132: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
      //   135: checkcast 105	android/widget/TextView
      //   138: putfield 109	abdq$a$a:Pf	Landroid/widget/TextView;
      //   141: aload_2
      //   142: astore 5
      //   144: aload 7
      //   146: aload_2
      //   147: ldc 110
      //   149: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
      //   152: checkcast 98	android/widget/ImageView
      //   155: putfield 113	abdq$a$a:xb	Landroid/widget/ImageView;
      //   158: aload_2
      //   159: astore 5
      //   161: aload 7
      //   163: getfield 89	abdq$a$a:jb	Landroid/widget/RelativeLayout;
      //   166: invokevirtual 117	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
      //   169: astore 6
      //   171: aload 6
      //   173: ifnull +310 -> 483
      //   176: aload_2
      //   177: astore 5
      //   179: aload 6
      //   181: aload_0
      //   182: getfield 20	abdq$a:b	Labdq;
      //   185: getfield 120	abdq:columnWidth	I
      //   188: putfield 125	android/view/ViewGroup$LayoutParams:width	I
      //   191: aload_2
      //   192: astore 5
      //   194: aload 6
      //   196: aload_0
      //   197: getfield 20	abdq$a:b	Labdq;
      //   200: getfield 120	abdq:columnWidth	I
      //   203: putfield 128	android/view/ViewGroup$LayoutParams:height	I
      //   206: aload_2
      //   207: astore 5
      //   209: aload 7
      //   211: getfield 89	abdq$a$a:jb	Landroid/widget/RelativeLayout;
      //   214: aload 6
      //   216: invokevirtual 132	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   219: aload_2
      //   220: astore 5
      //   222: aload_2
      //   223: aload 7
      //   225: invokevirtual 136	android/view/View:setTag	(Ljava/lang/Object;)V
      //   228: aload 7
      //   230: astore 6
      //   232: aload_2
      //   233: astore 5
      //   235: aload_0
      //   236: iload_1
      //   237: invokevirtual 138	abdq$a:getItem	(I)Ljava/lang/Object;
      //   240: checkcast 140	aqpf
      //   243: astore 8
      //   245: aload 8
      //   247: ifnull +345 -> 592
      //   250: aload_2
      //   251: astore 5
      //   253: aload 6
      //   255: getfield 109	abdq$a$a:Pf	Landroid/widget/TextView;
      //   258: aload 8
      //   260: getfield 144	aqpf:name	Ljava/lang/String;
      //   263: invokevirtual 148	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   266: aload_2
      //   267: astore 5
      //   269: aload 8
      //   271: getfield 151	aqpf:ebe	I
      //   274: istore 4
      //   276: aload_2
      //   277: astore 5
      //   279: aload 6
      //   281: getfield 95	abdq$a$a:b	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
      //   284: invokevirtual 155	com/tencent/mobileqq/vas/avatar/VasAvatar:getDrawable	()Landroid/graphics/drawable/Drawable;
      //   287: astore 7
      //   289: aload_2
      //   290: astore 5
      //   292: aload 7
      //   294: instanceof 157
      //   297: ifeq +289 -> 586
      //   300: aload_2
      //   301: astore 5
      //   303: aload 7
      //   305: checkcast 157	com/tencent/image/URLDrawable
      //   308: invokevirtual 160	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
      //   311: astore 7
      //   313: aload_2
      //   314: astore 5
      //   316: new 162	aqsg
      //   319: dup
      //   320: iload 4
      //   322: bipush 7
      //   324: ldc 164
      //   326: iconst_1
      //   327: invokespecial 167	aqsg:<init>	(IILjava/lang/String;Z)V
      //   330: astore 9
      //   332: aload_2
      //   333: astore 5
      //   335: aload 9
      //   337: aload 7
      //   339: putfield 171	aqsg:dQ	Landroid/graphics/drawable/Drawable;
      //   342: aload_2
      //   343: astore 5
      //   345: aload 6
      //   347: getfield 95	abdq$a$a:b	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
      //   350: aconst_null
      //   351: aload 9
      //   353: invokevirtual 175	com/tencent/mobileqq/vas/avatar/VasAvatar:setLoader	(Lcom/tencent/mobileqq/vas/avatar/AvatarLayout;Laqsg;)V
      //   356: aload_2
      //   357: astore 5
      //   359: aload 6
      //   361: getfield 89	abdq$a$a:jb	Landroid/widget/RelativeLayout;
      //   364: aload 8
      //   366: invokevirtual 176	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
      //   369: aload_2
      //   370: astore 5
      //   372: aload_0
      //   373: getfield 20	abdq$a:b	Labdq;
      //   376: ldc 178
      //   378: iconst_0
      //   379: invokestatic 184	cooperation/qzone/video/QzoneLiveVideoInterface:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   382: putfield 188	abdq:sharedPreferences	Landroid/content/SharedPreferences;
      //   385: aload_2
      //   386: astore 5
      //   388: aload_0
      //   389: getfield 20	abdq$a:b	Labdq;
      //   392: aload_0
      //   393: getfield 20	abdq$a:b	Labdq;
      //   396: getfield 188	abdq:sharedPreferences	Landroid/content/SharedPreferences;
      //   399: ldc 190
      //   401: iconst_0
      //   402: invokeinterface 196 3 0
      //   407: putfield 199	abdq:cnT	I
      //   410: aload_2
      //   411: astore 5
      //   413: aload_0
      //   414: getfield 20	abdq$a:b	Labdq;
      //   417: getfield 199	abdq:cnT	I
      //   420: aload 8
      //   422: getfield 151	aqpf:ebe	I
      //   425: if_icmpne +126 -> 551
      //   428: aload_2
      //   429: astore 5
      //   431: aload_2
      //   432: aload_0
      //   433: getfield 20	abdq$a:b	Labdq;
      //   436: getfield 65	abdq:mContext	Landroid/content/Context;
      //   439: invokevirtual 205	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   442: ldc 206
      //   444: invokevirtual 211	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
      //   447: invokevirtual 215	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
      //   450: aload_2
      //   451: astore 5
      //   453: aload 8
      //   455: getfield 151	aqpf:ebe	I
      //   458: aload_0
      //   459: getfield 20	abdq$a:b	Labdq;
      //   462: getfield 218	abdq:cnS	I
      //   465: if_icmpne +100 -> 565
      //   468: aload_2
      //   469: astore 5
      //   471: aload 6
      //   473: getfield 102	abdq$a$a:xa	Landroid/widget/ImageView;
      //   476: iconst_0
      //   477: invokevirtual 222	android/widget/ImageView:setVisibility	(I)V
      //   480: goto +112 -> 592
      //   483: aload_2
      //   484: astore 5
      //   486: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   489: ifeq +14 -> 503
      //   492: aload_2
      //   493: astore 5
      //   495: ldc 230
      //   497: iconst_2
      //   498: ldc 232
      //   500: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   503: aload_2
      //   504: astore 5
      //   506: new 122	android/view/ViewGroup$LayoutParams
      //   509: dup
      //   510: aload_0
      //   511: getfield 20	abdq$a:b	Labdq;
      //   514: getfield 120	abdq:columnWidth	I
      //   517: aload_0
      //   518: getfield 20	abdq$a:b	Labdq;
      //   521: getfield 239	abdq:cnO	I
      //   524: invokespecial 242	android/view/ViewGroup$LayoutParams:<init>	(II)V
      //   527: astore 6
      //   529: goto -323 -> 206
      //   532: astore_2
      //   533: aload 5
      //   535: astore_2
      //   536: goto +56 -> 592
      //   539: aload_2
      //   540: invokevirtual 246	android/view/View:getTag	()Ljava/lang/Object;
      //   543: checkcast 9	abdq$a$a
      //   546: astore 6
      //   548: goto -316 -> 232
      //   551: aload_2
      //   552: astore 5
      //   554: aload_2
      //   555: aconst_null
      //   556: invokevirtual 215	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
      //   559: goto -109 -> 450
      //   562: astore_2
      //   563: aload_2
      //   564: athrow
      //   565: aload_2
      //   566: astore 5
      //   568: aload 6
      //   570: getfield 102	abdq$a$a:xa	Landroid/widget/ImageView;
      //   573: bipush 8
      //   575: invokevirtual 222	android/widget/ImageView:setVisibility	(I)V
      //   578: goto +14 -> 592
      //   581: astore 5
      //   583: goto +9 -> 592
      //   586: aconst_null
      //   587: astore 7
      //   589: goto -276 -> 313
      //   592: aload_2
      //   593: astore 5
      //   595: aload 5
      //   597: astore 6
      //   599: goto -579 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	602	0	this	a
      //   0	602	1	paramInt	int
      //   0	602	2	paramView	View
      //   0	602	3	paramViewGroup	ViewGroup
      //   274	47	4	i	int
      //   4	563	5	localObject1	Object
      //   581	1	5	localThrowable	java.lang.Throwable
      //   593	3	5	localView	View
      //   15	583	6	localObject2	Object
      //   49	539	7	localObject3	Object
      //   243	211	8	localaqpf	aqpf
      //   330	22	9	localaqsg	aqsg
      // Exception table:
      //   from	to	target	type
      //   76	90	532	java/lang/Throwable
      //   93	107	532	java/lang/Throwable
      //   110	124	532	java/lang/Throwable
      //   127	141	532	java/lang/Throwable
      //   144	158	532	java/lang/Throwable
      //   161	171	532	java/lang/Throwable
      //   179	191	532	java/lang/Throwable
      //   194	206	532	java/lang/Throwable
      //   209	219	532	java/lang/Throwable
      //   222	228	532	java/lang/Throwable
      //   235	245	532	java/lang/Throwable
      //   253	266	532	java/lang/Throwable
      //   269	276	532	java/lang/Throwable
      //   279	289	532	java/lang/Throwable
      //   292	300	532	java/lang/Throwable
      //   303	313	532	java/lang/Throwable
      //   316	332	532	java/lang/Throwable
      //   335	342	532	java/lang/Throwable
      //   345	356	532	java/lang/Throwable
      //   359	369	532	java/lang/Throwable
      //   372	385	532	java/lang/Throwable
      //   388	410	532	java/lang/Throwable
      //   413	428	532	java/lang/Throwable
      //   431	450	532	java/lang/Throwable
      //   453	468	532	java/lang/Throwable
      //   471	480	532	java/lang/Throwable
      //   486	492	532	java/lang/Throwable
      //   495	503	532	java/lang/Throwable
      //   506	529	532	java/lang/Throwable
      //   554	559	532	java/lang/Throwable
      //   568	578	532	java/lang/Throwable
      //   0	6	562	finally
      //   41	70	562	finally
      //   76	90	562	finally
      //   93	107	562	finally
      //   110	124	562	finally
      //   127	141	562	finally
      //   144	158	562	finally
      //   161	171	562	finally
      //   179	191	562	finally
      //   194	206	562	finally
      //   209	219	562	finally
      //   222	228	562	finally
      //   235	245	562	finally
      //   253	266	562	finally
      //   269	276	562	finally
      //   279	289	562	finally
      //   292	300	562	finally
      //   303	313	562	finally
      //   316	332	562	finally
      //   335	342	562	finally
      //   345	356	562	finally
      //   359	369	562	finally
      //   372	385	562	finally
      //   388	410	562	finally
      //   413	428	562	finally
      //   431	450	562	finally
      //   453	468	562	finally
      //   471	480	562	finally
      //   486	492	562	finally
      //   495	503	562	finally
      //   506	529	562	finally
      //   539	548	562	finally
      //   554	559	562	finally
      //   568	578	562	finally
      //   0	6	581	java/lang/Throwable
      //   41	70	581	java/lang/Throwable
      //   539	548	581	java/lang/Throwable
    }
    
    public void hR(List<aqpf> paramList)
    {
      if (this.fp == null) {
        this.fp = new ArrayList();
      }
      this.fp.clear();
      this.fp.addAll(paramList);
      super.notifyDataSetChanged();
    }
    
    public class a
    {
      public TextView Pf;
      public VasAvatar b;
      public RelativeLayout jb;
      public ImageView xa;
      public ImageView xb;
      
      public a() {}
    }
  }
  
  public class b
    extends BaseAdapter
  {
    String bfr;
    String bfs;
    int cnV;
    int pS;
    List<aqpg> vN;
    
    public b() {}
    
    public void a(aqph paramaqph)
    {
      if (this.vN == null) {
        this.vN = new ArrayList();
      }
      this.vN.clear();
      if (paramaqph.vN == null) {
        return;
      }
      this.bfr = paramaqph.cuD;
      this.pS = paramaqph.pS;
      this.cnV = paramaqph.tag;
      this.bfs = paramaqph.cuF;
      if (this.bfs == null) {
        this.bfs = "";
      }
      if ((paramaqph.cuG != null) && (paramaqph.cuG.equals("actLiTpl"))) {
        this.cnV = 3;
      }
      if ((!paramaqph.cVy) && (paramaqph.vN.size() > 4) && ((paramaqph.cuG == null) || (paramaqph.cuG.equals("")))) {
        this.vN.addAll(paramaqph.vN.subList(0, 4));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        return;
        this.vN.addAll(paramaqph.vN);
      }
    }
    
    public int getCount()
    {
      if (this.vN != null) {
        return this.vN.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.vN != null) {
        return this.vN.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (this.vN == null)
      {
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      Object localObject2;
      label200:
      label219:
      aqpg localaqpg;
      if (paramView == null)
      {
        localObject1 = new abdq.b.a();
        localObject2 = LayoutInflater.from(abdq.this.mContext).inflate(2131562075, paramViewGroup, false);
        ((abdq.b.a)localObject1).jc = ((RelativeLayout)((View)localObject2).findViewById(2131372967));
        ((abdq.b.a)localObject1).xc = ((ImageView)((View)localObject2).findViewById(2131372966));
        ((abdq.b.a)localObject1).xd = ((ImageView)((View)localObject2).findViewById(2131372977));
        ((abdq.b.a)localObject1).xe = ((ImageView)((View)localObject2).findViewById(2131372979));
        ((abdq.b.a)localObject1).Pg = ((TextView)((View)localObject2).findViewById(2131372975));
        ((abdq.b.a)localObject1).xf = ((ImageView)((View)localObject2).findViewById(2131372968));
        ((abdq.b.a)localObject1).xg = ((ImageView)((View)localObject2).findViewById(2131372978));
        paramView = ((abdq.b.a)localObject1).jc.getLayoutParams();
        if (paramView != null)
        {
          paramView.width = abdq.this.columnWidth;
          paramView.height = abdq.this.cnO;
          ((abdq.b.a)localObject1).jc.setLayoutParams(paramView);
          ((View)localObject2).setTag(localObject1);
          paramView = (View)localObject2;
          localaqpg = (aqpg)getItem(paramInt);
          if (localaqpg != null)
          {
            ((abdq.b.a)localObject1).xc.setTag(localaqpg);
            ((abdq.b.a)localObject1).Pg.setText(localaqpg.name);
            paramView.setContentDescription(localaqpg.name);
            switch (localaqpg.ebg)
            {
            default: 
              ((abdq.b.a)localObject1).xf.setVisibility(8);
              label302:
              switch (localaqpg.ebh)
              {
              case 7: 
              case 8: 
              default: 
                ((abdq.b.a)localObject1).xg.setVisibility(8);
                label350:
                localObject2 = localaqpg.cuD;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  localObject2 = this.bfr;
                }
                break;
              }
              break;
            }
          }
        }
      }
      for (;;)
      {
        Object localObject4;
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject4 = (URLDrawable)abdq.a.get(localObject2);
          if (localObject4 == null) {
            break label1559;
          }
          ((abdq.b.a)localObject1).xc.setImageDrawable((Drawable)localObject4);
          if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
            ((URLDrawable)localObject4).restartDownload();
          }
        }
        label434:
        ((abdq.b.a)localObject1).jc.setTag(localaqpg);
        if (this.pS == paramInt)
        {
          paramView.setBackgroundDrawable(abdq.this.mContext.getResources().getDrawable(2130848276));
          label472:
          if (localaqpg.ebe == 0) {
            break label1784;
          }
          if (localaqpg.ebe != abdq.this.Nj) {
            break label1733;
          }
          ((abdq.b.a)localObject1).xe.setVisibility(0);
          if (abdq.this.scrolling) {
            break label1772;
          }
        }
        for (;;)
        {
          try
          {
            label1559:
            Object localObject5;
            for (;;)
            {
              localObject2 = new URL("protocol_pendant_image", "AIO_STATIC", String.valueOf(localaqpg.ebe));
              if (localObject2 != null)
              {
                localObject4 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = abdq.this.cnQ;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = abdq.this.cnR;
                ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = abdq.this.eo;
                ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = abdq.this.eo;
                localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
                ((abdq.b.a)localObject1).xd.setImageDrawable((Drawable)localObject2);
                if (((URLDrawable)localObject2).getStatus() == 2) {
                  ((URLDrawable)localObject2).restartDownload();
                }
              }
              localObject1 = paramView;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
              }
              paramView = new ViewGroup.LayoutParams(abdq.this.columnWidth, abdq.this.cnO);
              break label200;
              localObject1 = (abdq.b.a)paramView.getTag();
              break label219;
              Object localObject6 = new File(aqgm.csV + "/new.png");
              if ((((File)localObject6).exists()) && (!this.bfs.equals("1")))
              {
                ((abdq.b.a)localObject1).xf.setVisibility(0);
                localObject4 = (URLDrawable)abdq.a.get("key_new.png");
                localObject2 = localObject4;
                if (localObject4 == null)
                {
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = abdq.this.eo;
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = abdq.this.eo;
                  localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                  localObject2 = localObject4;
                  if (((URLDrawable)localObject4).getStatus() == 1)
                  {
                    abdq.a.put("key_new.png", localObject4);
                    localObject2 = localObject4;
                  }
                }
                ((abdq.b.a)localObject1).xf.setImageDrawable((Drawable)localObject2);
                break label302;
              }
              ((abdq.b.a)localObject1).xf.setVisibility(8);
              break label302;
              localObject6 = new File(aqgm.csV + "/hot.png");
              if ((((File)localObject6).exists()) && (!this.bfs.equals("3")))
              {
                ((abdq.b.a)localObject1).xf.setVisibility(0);
                localObject4 = (URLDrawable)abdq.a.get("key_hot.png");
                localObject2 = localObject4;
                if (localObject4 == null)
                {
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = abdq.this.eo;
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = abdq.this.eo;
                  localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                  localObject2 = localObject4;
                  if (((URLDrawable)localObject4).getStatus() == 1)
                  {
                    abdq.a.put("key_hot.png", localObject4);
                    localObject2 = localObject4;
                  }
                }
                ((abdq.b.a)localObject1).xf.setImageDrawable((Drawable)localObject2);
                break label302;
              }
              ((abdq.b.a)localObject1).xf.setVisibility(8);
              break label302;
              localObject6 = new File(aqgm.csV + "/activity.png");
              if ((((File)localObject6).exists()) && (this.cnV != 3) && (this.cnV != 5))
              {
                ((abdq.b.a)localObject1).xg.setVisibility(0);
                localObject4 = (URLDrawable)abdq.a.get("key_activity.png");
                localObject2 = localObject4;
                if (localObject4 == null)
                {
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = abdq.this.eo;
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = abdq.this.eo;
                  localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                  localObject2 = localObject4;
                  if (((URLDrawable)localObject4).getStatus() == 1)
                  {
                    abdq.a.put("key_activity.png", localObject4);
                    localObject2 = localObject4;
                  }
                }
                ((abdq.b.a)localObject1).xg.setImageDrawable((Drawable)localObject2);
                break label350;
              }
              ((abdq.b.a)localObject1).xg.setVisibility(8);
              break label350;
              localObject6 = new File(aqgm.csV + "/limit.png");
              if (((File)localObject6).exists())
              {
                ((abdq.b.a)localObject1).xg.setVisibility(0);
                localObject4 = (URLDrawable)abdq.a.get("key_limit.png");
                localObject2 = localObject4;
                if (localObject4 == null)
                {
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = abdq.this.eo;
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = abdq.this.eo;
                  localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                  localObject2 = localObject4;
                  if (((URLDrawable)localObject4).getStatus() == 1)
                  {
                    abdq.a.put("key_limit.png", localObject4);
                    localObject2 = localObject4;
                  }
                }
                ((abdq.b.a)localObject1).xg.setImageDrawable((Drawable)localObject2);
                break label350;
              }
              ((abdq.b.a)localObject1).xg.setVisibility(8);
              break label350;
              localObject6 = new File(aqgm.csV + "/rare.png");
              if ((((File)localObject6).exists()) && (this.cnV != 5))
              {
                ((abdq.b.a)localObject1).xg.setVisibility(0);
                localObject4 = (URLDrawable)abdq.a.get("key_rare.png");
                localObject2 = localObject4;
                if (localObject4 == null)
                {
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = abdq.this.eo;
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = abdq.this.eo;
                  localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                  localObject2 = localObject4;
                  if (((URLDrawable)localObject4).getStatus() == 1)
                  {
                    abdq.a.put("key_rare.png", localObject4);
                    localObject2 = localObject4;
                  }
                }
                ((abdq.b.a)localObject1).xg.setImageDrawable((Drawable)localObject2);
                break label350;
              }
              ((abdq.b.a)localObject1).xg.setVisibility(8);
              break label350;
              try
              {
                localObject4 = new URL("protocol_pendant_image", "DEFAULT_HEAD", (String)localObject2);
                if (localObject4 == null) {
                  break label434;
                }
                localObject6 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = abdq.this.cnQ;
                ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = abdq.this.cnR;
                ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = abdq.this.eo;
                ((URLDrawable.URLDrawableOptions)localObject6).mUseMemoryCache = true;
                ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = abdq.this.eo;
                localObject4 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject6);
                ((abdq.b.a)localObject1).xc.setImageDrawable((Drawable)localObject4);
                if (((URLDrawable)localObject4).getStatus() == 2) {
                  ((URLDrawable)localObject4).restartDownload();
                }
              }
              catch (MalformedURLException localMalformedURLException2)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AvatarPendantAdapter", 2, localMalformedURLException2.getMessage());
                  }
                  localObject5 = null;
                }
              }
            }
            if (localObject5.getStatus() != 1) {
              break label434;
            }
            abdq.a.put(localObject2, localObject5);
            break label434;
            paramView.setBackgroundDrawable(null);
            break label472;
            label1733:
            ((abdq.b.a)localObject1).xe.setVisibility(8);
          }
          catch (MalformedURLException localMalformedURLException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarPendantAdapter", 2, localMalformedURLException1.getMessage());
            }
            Object localObject3 = null;
            continue;
          }
          label1772:
          ((abdq.b.a)localObject1).xd.setImageDrawable(null);
          continue;
          label1784:
          ((abdq.b.a)localObject1).xd.setImageDrawable(null);
        }
      }
    }
    
    public class a
    {
      public TextView Pg;
      public RelativeLayout jc;
      public ImageView xc;
      public ImageView xd;
      public ImageView xe;
      public ImageView xf;
      public ImageView xg;
      
      public a() {}
    }
  }
  
  public class c
  {
    TextView Ph;
    TextView Pi;
    TextView Pj;
    TextView Pk;
    ImageView cq;
    View divider;
    GridView h;
    LinearLayout ih;
    RelativeLayout jd;
    public int position;
    ImageView xh;
    ImageView xi;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdq
 * JD-Core Version:    0.7.0.1
 */