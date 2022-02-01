import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.util.widget.NoScrollGridView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ahrb
  extends RecyclerView.Adapter
  implements Handler.Callback, awos
{
  private static int daQ;
  private ImageView Ad;
  private ImageView Ae;
  private ImageView Af;
  private TextView KJ;
  private TextView RK;
  private TextView TB;
  private ahrb.e jdField_a_of_type_Ahrb$e;
  private FeedsItemData.TopCardInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo;
  private QQGamePubAccountFragment jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment;
  private Dialog au;
  private awoe b;
  private int daP;
  private FrameLayout.LayoutParams f;
  private SparseArrayCompat<View> i = new SparseArrayCompat();
  private SparseArrayCompat<View> j = new SparseArrayCompat();
  private LinearLayout jb;
  private LinearLayout jc;
  private LinearLayout jd;
  private List<FeedsItemData> jl = new ArrayList();
  private QQAppInterface mApp;
  private Context mContext;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  private FrameLayout o;
  
  public ahrb(Context paramContext, QQAppInterface paramQQAppInterface, QQGamePubAccountFragment paramQQGamePubAccountFragment)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment = paramQQGamePubAccountFragment;
    awot.a().a(this);
  }
  
  public static boolean a(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null)) {}
    while ((TextUtils.isEmpty(paramTopCardInfo.gameInfo.gamePkgName)) || (TextUtils.isEmpty(paramTopCardInfo.gameInfo.gameIcon + paramTopCardInfo.gameInfo.gameName))) {
      return false;
    }
    return true;
  }
  
  private List<FeedsItemData> bh(List<FeedsItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedsItemData localFeedsItemData = (FeedsItemData)paramList.next();
      if ((localFeedsItemData.type == 1) || (localFeedsItemData.type == 2) || (localFeedsItemData.type == 3) || (localFeedsItemData.type == 4) || (localFeedsItemData.type == 5) || (localFeedsItemData.type == 6) || (localFeedsItemData.type == 7) || (localFeedsItemData.type == 100)) {
        localArrayList.add(localFeedsItemData);
      }
    }
    return localArrayList;
  }
  
  public void Kx(boolean paramBoolean)
  {
    if (paramBoolean) {
      notifyItemChanged(daQ);
    }
    if (this.jl != null) {
      notifyItemRangeChanged(rl(), this.jl.size());
    }
  }
  
  public void Pm(int paramInt)
  {
    if ((this.jl != null) && (this.jl.size() >= paramInt - rl()))
    {
      this.jl.remove(paramInt - rl());
      notifyItemRemoved(paramInt);
      notifyDataSetChanged();
    }
  }
  
  public FeedsItemData.GameInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.b() == null) {
      return new FeedsItemData.GameInfo();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.b();
  }
  
  public FeedsItemData a(int paramInt)
  {
    if ((this.jl != null) && (paramInt - rl() >= 0) && (paramInt - rl() < this.jl.size())) {
      return (FeedsItemData)this.jl.get(paramInt - rl());
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4)
  {
    this.au = new ReportDialog(this.mContext, 2131755482);
    Object localObject = View.inflate(this.mContext, 2131559376, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(280.0F, this.mContext.getResources()), -1);
    ((ImageView)((View)localObject).findViewById(2131369084)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_popView_card@2x.png"));
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131380994);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      localTextView1.setText(paramString2);
      localTextView1.setTextColor(ahtz.c(-16733441, 1593879295));
      ((ImageView)((View)localObject).findViewById(2131361967)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_arrow@2x.png"));
      paramString2 = (CheckBox)((View)localObject).findViewById(2131364580);
      TextView localTextView2 = (TextView)((View)localObject).findViewById(2131380606);
      TextView localTextView3 = (TextView)((View)localObject).findViewById(2131380766);
      localTextView3.setTextColor(ahtz.c(-16733441, 1593879295));
      this.au.setContentView((View)localObject, localLayoutParams);
      this.au.setCanceledOnTouchOutside(false);
      localObject = paramJSONObject.optString("app");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localTextView3.setVisibility(8);
      }
      paramString2.setOnCheckedChangeListener(new ahre(this, paramString1));
      localTextView2.setOnClickListener(new ahrf(this, paramString4));
      localTextView1.setOnClickListener(new ahrg(this, paramString4, paramString3));
      localTextView3.setOnClickListener(new ahrh(this, paramString4, paramJSONObject, (String)localObject));
      this.au.show();
      paramString1 = new HashMap();
      tbb.b(paramString1, paramString4);
      paramString1.put(Integer.valueOf(2), paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        break label411;
      }
      paramString1.put(Integer.valueOf(10), "0");
    }
    for (;;)
    {
      paramString1.put(Integer.valueOf(11), "1");
      tbb.a(abmt.getAppInterface(), "769", "205710", a().gameAppId, "76905", "1", "160", paramString1);
      return;
      localTextView1.setText(acfp.m(2131711734));
      break;
      label411:
      paramString1.put(Integer.valueOf(10), "1");
    }
  }
  
  public void a(List<FeedsItemData> paramList, FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    paramList = bh(paramList);
    kW(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.jl != null) {
        notifyItemRangeRemoved(rl(), this.jl.size());
      }
      aGQ();
      this.jl = paramList;
      if ((paramTopCardInfo != null) && (paramTopCardInfo.gameInfo != null)) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(paramTopCardInfo.gameInfo);
      }
    }
    label173:
    label193:
    label237:
    label243:
    label248:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
      notifyItemChanged(daQ);
      return;
      boolean bool;
      if ((this.jl != null) && (this.jl.size() > paramList.size()))
      {
        int k = this.jl.size();
        int m = paramList.size();
        this.jl = paramList;
        notifyItemRangeChanged(rl(), paramList.size());
        notifyItemRangeRemoved(rl() + paramList.size(), k - m);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label243;
        }
        if (paramTopCardInfo != null) {
          break label237;
        }
        bool = true;
        cd(false, bool);
      }
      for (;;)
      {
        if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null)) {
          break label248;
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(paramTopCardInfo.gameInfo);
        break;
        this.jl = paramList;
        notifyDataSetChanged();
        break label173;
        bool = false;
        break label193;
        aGQ();
      }
    }
  }
  
  public void aGQ()
  {
    if (this.jb != null) {
      this.jb.setVisibility(8);
    }
  }
  
  public void addFooterView(View paramView)
  {
    this.j.put(this.j.size() + 200000, paramView);
    notifyDataSetChanged();
  }
  
  public void addHeaderView(View paramView)
  {
    this.i.put(this.i.size() + 100000, paramView);
    notifyDataSetChanged();
  }
  
  public void ca(List<FeedsItemData> paramList)
  {
    if (this.jl == null) {
      this.jl = paramList;
    }
    for (;;)
    {
      kW(this.jl);
      notifyDataSetChanged();
      return;
      this.jl.addAll(paramList);
    }
  }
  
  public void cd(boolean paramBoolean1, boolean paramBoolean2)
  {
    cmZ();
    this.f.topMargin = wja.dp2px(20.0F, this.mContext.getResources());
    this.jc.setLayoutParams(this.f);
    this.jc.setVisibility(0);
    if (paramBoolean1)
    {
      this.Ae.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setDuration(1000L);
      this.Ae.startAnimation(localRotateAnimation);
      this.TB.setVisibility(0);
      this.TB.setText(acfp.m(2131711718));
      return;
    }
    if (paramBoolean2)
    {
      this.Ae.clearAnimation();
      this.Ae.setVisibility(8);
      this.TB.setVisibility(8);
      this.jd.setVisibility(0);
      return;
    }
    this.jd.setVisibility(8);
    this.Ae.clearAnimation();
    this.Ae.setVisibility(8);
    this.TB.setVisibility(0);
    this.TB.setText(acfp.m(2131711720));
  }
  
  public void clear()
  {
    awot.a().b(this);
    if (this.b != null) {
      awok.b(this.b);
    }
  }
  
  public void cmZ()
  {
    if (this.jc == null)
    {
      localFrameLayout = new FrameLayout(this.mContext);
      this.jc = new LinearLayout(this.mContext);
      this.f = new FrameLayout.LayoutParams(-2, -2);
      this.jc.setOrientation(0);
      this.f.gravity = 1;
      this.f.topMargin = wja.dp2px(20.0F, this.mContext.getResources());
      this.TB = new TextView(this.mContext);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
      this.TB.setText(acfp.m(2131711721));
      this.TB.setTextColor(2130706432);
      this.Ae = new ImageView(this.mContext);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.mContext.getResources().getDrawable(2130848044);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.mContext.getResources().getDrawable(2130848044);
      localObject3 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject1);
      this.Ae.setImageDrawable((Drawable)localObject3);
      this.Ae.setVisibility(8);
      localObject3 = new LinearLayout.LayoutParams(wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()));
      this.jc.addView(this.Ae, (ViewGroup.LayoutParams)localObject3);
      this.jc.addView(this.TB, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.jc, this.f);
      localFrameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, wja.dp2px(120.0F, this.mContext.getResources())));
      this.Ae.setVisibility(0);
      localObject2 = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject2).setRepeatCount(-1);
      ((Animation)localObject2).setDuration(1000L);
      this.Ae.startAnimation((Animation)localObject2);
      this.TB.setText(acfp.m(2131711711));
      this.jd = new LinearLayout(this.mContext);
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      this.jd.setOrientation(1);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      this.Af = new ImageView(this.mContext);
      this.Af.setVisibility(0);
      localObject1 = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201908/upload_dc6398e215f1241b9ea8b9034b7cddac.png", (URLDrawable.URLDrawableOptions)localObject1);
      this.Af.setImageDrawable((Drawable)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      this.Af.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.RK = new TextView(this.mContext);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(7.0F, this.mContext.getResources());
      this.RK.setText(acfp.m(2131711736));
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      this.RK.setTextColor(2130706432);
      this.jd.addView(this.Af, (ViewGroup.LayoutParams)localObject1);
      this.jd.addView(this.RK, (ViewGroup.LayoutParams)localObject3);
      this.jd.setVisibility(8);
      localFrameLayout.addView(this.jd, (ViewGroup.LayoutParams)localObject2);
      addFooterView(localFrameLayout);
    }
    while ((this.jl == null) || (this.jl.size() <= 0))
    {
      FrameLayout localFrameLayout;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      return;
    }
    this.jc.setVisibility(0);
    this.Ae.clearAnimation();
    this.Ae.setVisibility(8);
    this.TB.setText(acfp.m(2131711728));
    this.Af.setVisibility(8);
  }
  
  public void dps()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559369, null, false);
    localRelativeLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
    this.jdField_a_of_type_Ahrb$e = new ahrb.e(localRelativeLayout, this.mContext);
    this.daP = (this.i.size() + 100000);
    daQ = this.i.size();
    this.i.put(this.daP, localRelativeLayout);
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12820");
    localHashSet.add("13032");
    return localHashSet;
  }
  
  public int getItemCount()
  {
    return rl() + tT() + getRealItemCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (jV(paramInt)) {
      return this.i.keyAt(paramInt);
    }
    if (jW(paramInt)) {
      return this.j.keyAt(paramInt - rl() - getRealItemCount());
    }
    return ((FeedsItemData)this.jl.get(paramInt - rl())).type;
  }
  
  public int getRealItemCount()
  {
    if (this.jl == null) {
      return 0;
    }
    return this.jl.size();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.o == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (paramMessage.arg1 == 0)
    {
      this.Ad.setVisibility(0);
      paramMessage = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      paramMessage.setRepeatCount(-1);
      paramMessage.setDuration(1000L);
      paramMessage.setRepeatMode(1);
      this.Ad.clearAnimation();
      this.Ad.setAnimation(paramMessage);
      this.Ad.startAnimation(paramMessage);
      this.KJ.setTextSize(14.0F);
      this.KJ.setTextColor(2130706432);
      this.KJ.setTypeface(Typeface.DEFAULT);
      this.KJ.setText(acfp.m(2131711729));
      return false;
    }
    this.Ad.clearAnimation();
    this.Ad.setVisibility(8);
    this.KJ.setText((String)paramMessage.obj);
    this.KJ.setTextSize(18.0F);
    this.KJ.setTextColor(-16777216);
    this.KJ.setTypeface(Typeface.DEFAULT, 1);
    return false;
  }
  
  public boolean jV(int paramInt)
  {
    return paramInt < rl();
  }
  
  public boolean jW(int paramInt)
  {
    return paramInt >= rl() + getRealItemCount();
  }
  
  public void kW(List<FeedsItemData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int m = 0;
    int k = 0;
    label18:
    FeedsItemData localFeedsItemData2;
    if (m < paramList.size())
    {
      localFeedsItemData2 = (FeedsItemData)paramList.get(m);
      if (localFeedsItemData2.type != 4) {
        break label141;
      }
      FeedsItemData localFeedsItemData1 = null;
      if (m + 1 < paramList.size()) {
        localFeedsItemData1 = (FeedsItemData)paramList.get(m + 1);
      }
      if ((localFeedsItemData1 == null) || (localFeedsItemData1.type != 4)) {
        break label146;
      }
    }
    label141:
    label146:
    for (int n = 1;; n = 0)
    {
      if (k % 2 == 0) {
        if (n != 0)
        {
          localFeedsItemData2.miniType = 0;
          label112:
          k += 1;
        }
      }
      for (;;)
      {
        m += 1;
        break label18;
        break;
        localFeedsItemData2.miniType = 1;
        break label112;
        localFeedsItemData2.miniType = 2;
        break label112;
        k = 0;
      }
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (jV(paramInt)) {
      if ((paramViewHolder instanceof ahrb.e)) {
        ((ahrb.e)paramViewHolder).a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo, this);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
              return;
            } while (jW(paramInt));
            if ((!(paramViewHolder instanceof ahrb.b)) && (!(paramViewHolder instanceof ahrb.a))) {
              break;
            }
            localObject1 = a(paramInt);
          } while (localObject1 == null);
          if ((((FeedsItemData)localObject1).type == 1) || (((FeedsItemData)localObject1).type == 2) || (((FeedsItemData)localObject1).type == 3))
          {
            localObject2 = (ahrb.b)paramViewHolder;
            ((ahrb.b)localObject2).a(this, (FeedsItemData)localObject1, paramInt);
            ((ahrb.b)localObject2).TK.setTag(a().gameAppId);
            localObject2 = new HashMap();
            tbb.b((Map)localObject2, ((FeedsItemData)localObject1).msgId);
            ((Map)localObject2).put(Integer.valueOf(2), ((FeedsItemData)localObject1).msgId);
            ((Map)localObject2).put(Integer.valueOf(4), "8");
            ((Map)localObject2).put(Integer.valueOf(6), ((FeedsItemData)localObject1).feedId);
            ((Map)localObject2).put(Integer.valueOf(43), ((FeedsItemData)localObject1).algorithmId);
            ((Map)localObject2).put(Integer.valueOf(44), ((FeedsItemData)localObject1).type + "");
            if (((FeedsItemData)localObject1).gameInfo != null) {}
            for (localObject1 = ((FeedsItemData)localObject1).gameInfo.gameAppId;; localObject1 = "")
            {
              tbb.a(abmt.getAppInterface(), "769", "205021", (String)localObject1, "76902", "1", "160", (Map)localObject2);
              break;
            }
          }
        } while (((FeedsItemData)localObject1).type != 4);
        ((ahrb.a)paramViewHolder).a(this, (FeedsItemData)localObject1, paramInt);
        localObject2 = new HashMap();
        tbb.b((Map)localObject2, ((FeedsItemData)localObject1).msgId);
        ((Map)localObject2).put(Integer.valueOf(2), ((FeedsItemData)localObject1).msgId);
        ((Map)localObject2).put(Integer.valueOf(4), "8");
        ((Map)localObject2).put(Integer.valueOf(6), ((FeedsItemData)localObject1).feedId);
        ((Map)localObject2).put(Integer.valueOf(43), ((FeedsItemData)localObject1).algorithmId);
        ((Map)localObject2).put(Integer.valueOf(44), ((FeedsItemData)localObject1).type + "");
        if (((FeedsItemData)localObject1).gameInfo != null) {}
        for (localObject1 = ((FeedsItemData)localObject1).gameInfo.gameAppId;; localObject1 = "")
        {
          tbb.a(abmt.getAppInterface(), "769", "205021", (String)localObject1, "76902", "1", "160", (Map)localObject2);
          break;
        }
      } while (!(paramViewHolder instanceof ahsa));
      localObject1 = a(paramInt);
    } while (localObject1 == null);
    ((ahsa)paramViewHolder).a((FeedsItemData)localObject1);
    Object localObject2 = new HashMap();
    tbb.b((Map)localObject2, ((FeedsItemData)localObject1).msgId);
    ((Map)localObject2).put(Integer.valueOf(2), ((FeedsItemData)localObject1).msgId);
    ((Map)localObject2).put(Integer.valueOf(6), ((FeedsItemData)localObject1).feedId);
    ((Map)localObject2).put(Integer.valueOf(4), "8");
    ((Map)localObject2).put(Integer.valueOf(43), ((FeedsItemData)localObject1).algorithmId);
    ((Map)localObject2).put(Integer.valueOf(44), ((FeedsItemData)localObject1).type + "");
    if (((FeedsItemData)localObject1).gameInfo != null) {}
    for (Object localObject1 = ((FeedsItemData)localObject1).gameInfo.gameAppId;; localObject1 = "")
    {
      tbb.a(abmt.getAppInterface(), "769", "205021", (String)localObject1, "76902", "1", "160", (Map)localObject2);
      break;
    }
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if ("12820".equals(paramString)) {}
    while (!"13032".equals(paramString)) {
      return;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.i.get(paramInt) != null)
    {
      if (paramInt == this.daP) {
        return this.jdField_a_of_type_Ahrb$e;
      }
      return new ahrc(this, (View)this.i.get(paramInt));
    }
    if (this.j.get(paramInt) != null) {
      return new ahrd(this, (View)this.j.get(paramInt));
    }
    if (paramInt == 4)
    {
      paramViewGroup = new RelativeLayout(this.mContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      Object localObject1 = new LinearLayout(this.mContext);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject1).setPadding(wja.dp2px(5.0F, this.mContext.getResources()), 0, wja.dp2px(5.0F, this.mContext.getResources()), 0);
      Object localObject2 = new RelativeLayout(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 8.0F;
      Object localObject3 = new TextView(this.mContext);
      ((TextView)localObject3).setTextColor(-16777216);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setId(2131379769);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, wja.dp2px(45.0F, this.mContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject4).setMargins(wja.dp2px(12.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), 0);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131363118);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setMaxWidth(wja.dp2px(80.0F, this.mContext.getResources()));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.setMargins(wja.dp2px(12.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()), 0, wja.dp2px(8.0F, this.mContext.getResources()));
      localLayoutParams2.addRule(3, 2131379769);
      ((RelativeLayout)localObject2).addView((View)localObject4, localLayoutParams2);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131372578);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.leftMargin = wja.dp2px(8.0F, this.mContext.getResources());
      localLayoutParams2.addRule(6, 2131363118);
      localLayoutParams2.addRule(1, 2131363118);
      ((RelativeLayout)localObject2).addView((View)localObject4, localLayoutParams2);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setTextColor(-6052957);
      ((TextView)localObject4).setTextSize(10.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setId(2131367867);
      ((TextView)localObject4).setBackgroundColor(1270796256);
      ((TextView)localObject4).setPadding(wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()));
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, wja.dp2px(-1.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363118);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new CornerImageView(this.mContext);
      ((CornerImageView)localObject2).setId(2131368962);
      localLayoutParams = new LinearLayout.LayoutParams(0, wja.dp2px(71.0F, this.mContext.getResources()));
      localLayoutParams.weight = 3.0F;
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramViewGroup.addView((View)localObject1, localLayoutParams1);
      localObject1 = new ImageView(this.mContext);
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, wja.dp2px(1.0F, this.mContext.getResources()));
      ((ImageView)localObject1).setImageDrawable(new ColorDrawable(-263173));
      ((ImageView)localObject1).setId(2131365990);
      ((ImageView)localObject1).setPadding(wja.dp2px(25.0F, this.mContext.getResources()), 0, 0, 0);
      localLayoutParams1.rightMargin = wja.dp2px(4.0F, this.mContext.getResources());
      paramViewGroup.addView((View)localObject1, localLayoutParams1);
      return new ahrb.a(paramViewGroup);
    }
    if ((paramInt == 5) || (paramInt == 7) || (paramInt == 6)) {
      return ahsf.a(this.mContext, paramInt, paramViewGroup);
    }
    return new ahrb.b(LayoutInflater.from(this.mContext).inflate(2131559368, paramViewGroup, false));
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((paramViewHolder instanceof ahrb.b))
    {
      paramViewHolder = (ahrb.b)paramViewHolder;
      if ((paramViewHolder.a != null) && (ahsx.a().a() == paramViewHolder.a))
      {
        paramViewHolder.a.stop();
        paramViewHolder.a.release();
      }
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
  }
  
  public int rl()
  {
    if (this.i == null) {
      return 0;
    }
    return this.i.size();
  }
  
  public int tT()
  {
    return this.j.size();
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    public ImageView Ag;
    public TextView TC;
    public TextView TD;
    public TextView TE;
    private FeedsItemData a;
    private ahrb b;
    public CornerImageView m;
    private int mPosition;
    public TextView tvTitle;
    
    public a(View paramView)
    {
      super();
      this.tvTitle = ((TextView)paramView.findViewById(2131379769));
      this.TC = ((TextView)paramView.findViewById(2131363118));
      this.TD = ((TextView)paramView.findViewById(2131372578));
      this.m = ((CornerImageView)paramView.findViewById(2131368962));
      this.TE = ((TextView)paramView.findViewById(2131367867));
      this.Ag = ((ImageView)paramView.findViewById(2131365990));
    }
    
    public void a(ahrb paramahrb, FeedsItemData paramFeedsItemData, int paramInt)
    {
      this.b = paramahrb;
      this.a = paramFeedsItemData;
      this.mPosition = paramInt;
      if (this.a.miniType == 1)
      {
        this.itemView.setBackgroundDrawable(ahtz.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
        this.Ag.setVisibility(8);
      }
      for (;;)
      {
        this.tvTitle.setText(this.a.title);
        this.TC.setText(this.a.authorName);
        try
        {
          this.m.setImageURL(this.a.coverImgUrl);
          this.m.setRadius(wja.dp2px(4.0F, this.itemView.getResources()));
          this.TE.setText(this.b.a().gameName);
          if ((!TextUtils.isEmpty(this.b.a().gameName)) && (this.b.a().gameName.length() > 8))
          {
            this.TD.setVisibility(4);
            this.itemView.setOnClickListener(new ahri(this));
            return;
            if (this.a.miniType == 2)
            {
              this.itemView.setBackgroundDrawable(ahtz.a(this.itemView.getContext(), 0.0F, 0.0F, 8.0F, 8.0F));
              this.Ag.setVisibility(0);
              continue;
            }
            this.itemView.setBackgroundDrawable(ahtz.a(this.itemView.getContext(), 8.0F, 8.0F, 0.0F, 0.0F));
            this.Ag.setVisibility(8);
          }
        }
        catch (Exception paramahrb)
        {
          for (;;)
          {
            QLog.e("QQGamePubFeedsAdapter", 1, paramahrb, new Object[0]);
          }
        }
      }
      if (this.a.viewersNum > 10000) {}
      for (paramahrb = Math.round(this.a.viewersNum / 10000.0F * 10.0F) / 10.0F + acfp.m(2131711737);; paramahrb = this.a.viewersNum + acfp.m(2131711725))
      {
        this.TD.setText(paramahrb);
        break;
      }
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private ImageView Ah;
    private ausj N;
    public TextView TC;
    public TextView TF;
    private TextView TG;
    private TextView TH;
    private TextView TI;
    private TextView TJ;
    public TextView TK;
    private FeedsItemData a;
    public GameCenterVideoViewController a;
    private ahrb b;
    public URLImageView bi;
    private URLImageView bj;
    private LinearLayout je;
    private ausj.a k = new ahrj(this);
    public RelativeLayout layoutAction;
    private int mPosition;
    public CornerImageView n;
    public TextView tvTitle;
    private TextView zM;
    
    public b(View paramView)
    {
      super();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = ((GameCenterVideoViewController)paramView.findViewById(2131381766));
      this.tvTitle = ((TextView)paramView.findViewById(2131380976));
      this.bi = ((URLImageView)paramView.findViewById(2131372757));
      this.n = ((CornerImageView)paramView.findViewById(2131363117));
      this.TC = ((TextView)paramView.findViewById(2131363118));
      this.TF = ((TextView)paramView.findViewById(2131381980));
      this.je = ((LinearLayout)paramView.findViewById(2131370137));
      this.TG = ((TextView)paramView.findViewById(2131370138));
      this.zM = ((TextView)paramView.findViewById(2131372758));
      this.bj = ((URLImageView)paramView.findViewById(2131370142));
      this.TH = ((TextView)paramView.findViewById(2131370143));
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.dpR();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.dpT();
      this.TI = ((TextView)paramView.findViewById(2131380882));
      this.TJ = ((TextView)paramView.findViewById(2131380775));
      this.TK = ((TextView)paramView.findViewById(2131362021));
      this.layoutAction = ((RelativeLayout)paramView.findViewById(2131370153));
      this.Ah = ((ImageView)paramView.findViewById(2131361984));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramView.getResources().getDrawable(2130841786);
      localURLDrawableOptions.mFailedDrawable = paramView.getResources().getDrawable(2130841786);
      paramView = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_arrow@2x.png", localURLDrawableOptions);
      this.Ah.setImageDrawable(paramView);
    }
    
    /* Error */
    public void a(ahrb paramahrb, FeedsItemData paramFeedsItemData, int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: putfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   5: aload_0
      //   6: aload_1
      //   7: putfield 168	ahrb$b:b	Lahrb;
      //   10: aload_0
      //   11: iload_3
      //   12: putfield 165	ahrb$b:mPosition	I
      //   15: aload_0
      //   16: getfield 72	ahrb$b:bi	Lcom/tencent/image/URLImageView;
      //   19: bipush 8
      //   21: invokevirtual 182	com/tencent/image/URLImageView:setVisibility	(I)V
      //   24: aload_0
      //   25: getfield 88	ahrb$b:je	Landroid/widget/LinearLayout;
      //   28: bipush 8
      //   30: invokevirtual 183	android/widget/LinearLayout:setVisibility	(I)V
      //   33: aload_0
      //   34: getfield 91	ahrb$b:TG	Landroid/widget/TextView;
      //   37: bipush 8
      //   39: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   42: aload_0
      //   43: getfield 97	ahrb$b:bj	Lcom/tencent/image/URLImageView;
      //   46: bipush 8
      //   48: invokevirtual 182	com/tencent/image/URLImageView:setVisibility	(I)V
      //   51: aload_0
      //   52: getfield 100	ahrb$b:TH	Landroid/widget/TextView;
      //   55: bipush 8
      //   57: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   60: aload_0
      //   61: getfield 94	ahrb$b:zM	Landroid/widget/TextView;
      //   64: bipush 8
      //   66: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   69: aload_0
      //   70: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   73: iconst_0
      //   74: invokevirtual 185	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setVisibility	(I)V
      //   77: aload_0
      //   78: getfield 80	ahrb$b:TC	Landroid/widget/TextView;
      //   81: iconst_0
      //   82: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   85: aload_0
      //   86: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   89: iconst_0
      //   90: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   93: aload_0
      //   94: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   97: aload_0
      //   98: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   101: invokevirtual 193	android/view/View:getContext	()Landroid/content/Context;
      //   104: ldc 194
      //   106: ldc 194
      //   108: ldc 194
      //   110: ldc 194
      //   112: invokestatic 199	ahtz:a	(Landroid/content/Context;FFFF)Landroid/graphics/drawable/StateListDrawable;
      //   115: invokevirtual 202	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
      //   118: aload_2
      //   119: getfield 208	com/tencent/mobileqq/gamecenter/data/FeedsItemData:rcmdReason	Ljava/lang/String;
      //   122: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   125: ifeq +356 -> 481
      //   128: aload_0
      //   129: getfield 110	ahrb$b:TI	Landroid/widget/TextView;
      //   132: bipush 8
      //   134: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   137: aload_2
      //   138: getfield 217	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
      //   141: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   144: ifeq +378 -> 522
      //   147: aload_2
      //   148: getfield 220	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
      //   151: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   154: ifeq +368 -> 522
      //   157: aload_0
      //   158: getfield 121	ahrb$b:layoutAction	Landroid/widget/RelativeLayout;
      //   161: bipush 8
      //   163: invokevirtual 221	android/widget/RelativeLayout:setVisibility	(I)V
      //   166: aload_2
      //   167: getfield 224	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
      //   170: iconst_3
      //   171: if_icmpne +515 -> 686
      //   174: aload_0
      //   175: getfield 62	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
      //   178: bipush 8
      //   180: invokevirtual 225	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVisibility	(I)V
      //   183: aload_0
      //   184: getfield 91	ahrb$b:TG	Landroid/widget/TextView;
      //   187: iconst_0
      //   188: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   191: aload_0
      //   192: getfield 72	ahrb$b:bi	Lcom/tencent/image/URLImageView;
      //   195: iconst_0
      //   196: invokevirtual 182	com/tencent/image/URLImageView:setVisibility	(I)V
      //   199: aload_0
      //   200: getfield 72	ahrb$b:bi	Lcom/tencent/image/URLImageView;
      //   203: ldc 226
      //   205: invokevirtual 229	com/tencent/image/URLImageView:setBackgroundColor	(I)V
      //   208: aload_0
      //   209: getfield 72	ahrb$b:bi	Lcom/tencent/image/URLImageView;
      //   212: aload_2
      //   213: getfield 232	com/tencent/mobileqq/gamecenter/data/FeedsItemData:coverImgUrl	Ljava/lang/String;
      //   216: invokevirtual 236	com/tencent/image/URLImageView:setImageURL	(Ljava/lang/String;)V
      //   219: aload_0
      //   220: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   223: iconst_4
      //   224: invokevirtual 185	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setVisibility	(I)V
      //   227: aload_0
      //   228: getfield 80	ahrb$b:TC	Landroid/widget/TextView;
      //   231: iconst_4
      //   232: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   235: aload_0
      //   236: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   239: iconst_4
      //   240: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   243: aload_0
      //   244: getfield 67	ahrb$b:tvTitle	Landroid/widget/TextView;
      //   247: aload_2
      //   248: getfield 239	com/tencent/mobileqq/gamecenter/data/FeedsItemData:title	Ljava/lang/String;
      //   251: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   254: aload_0
      //   255: getfield 80	ahrb$b:TC	Landroid/widget/TextView;
      //   258: aload_2
      //   259: getfield 246	com/tencent/mobileqq/gamecenter/data/FeedsItemData:authorName	Ljava/lang/String;
      //   262: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   265: invokestatic 132	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
      //   268: astore_1
      //   269: aload_1
      //   270: aload_0
      //   271: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   274: invokevirtual 193	android/view/View:getContext	()Landroid/content/Context;
      //   277: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   280: ldc 250
      //   282: invokevirtual 143	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
      //   285: putfield 147	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
      //   288: aload_1
      //   289: aload_0
      //   290: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   293: invokevirtual 193	android/view/View:getContext	()Landroid/content/Context;
      //   296: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   299: ldc 250
      //   301: invokevirtual 143	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
      //   304: putfield 150	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
      //   307: aload_0
      //   308: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   311: aload_2
      //   312: getfield 253	com/tencent/mobileqq/gamecenter/data/FeedsItemData:authorIcon	Ljava/lang/String;
      //   315: aload_1
      //   316: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
      //   319: invokevirtual 254	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
      //   322: aload_0
      //   323: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   326: ldc 255
      //   328: aload_0
      //   329: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   332: invokevirtual 256	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:getResources	()Landroid/content/res/Resources;
      //   335: invokestatic 262	wja:dp2px	(FLandroid/content/res/Resources;)I
      //   338: i2f
      //   339: invokevirtual 266	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setRadius	(F)V
      //   342: aload_0
      //   343: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   346: ldc 255
      //   348: aload_0
      //   349: getfield 77	ahrb$b:n	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
      //   352: invokevirtual 256	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:getResources	()Landroid/content/res/Resources;
      //   355: invokestatic 262	wja:dp2px	(FLandroid/content/res/Resources;)I
      //   358: i2f
      //   359: invokevirtual 266	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setRadius	(F)V
      //   362: aload_0
      //   363: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   366: getfield 269	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
      //   369: sipush 10000
      //   372: if_icmple +597 -> 969
      //   375: aload_0
      //   376: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   379: getfield 224	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
      //   382: iconst_1
      //   383: if_icmpne +527 -> 910
      //   386: new 271	java/lang/StringBuilder
      //   389: dup
      //   390: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   393: ldc_w 274
      //   396: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   399: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   402: aload_0
      //   403: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   406: getfield 287	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoViewers	I
      //   409: i2f
      //   410: ldc_w 288
      //   413: fdiv
      //   414: ldc_w 289
      //   417: fmul
      //   418: invokestatic 295	java/lang/Math:round	(F)I
      //   421: i2f
      //   422: ldc_w 289
      //   425: fdiv
      //   426: invokevirtual 298	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   429: ldc_w 299
      //   432: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   435: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   438: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   441: astore_1
      //   442: aload_0
      //   443: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   446: aload_1
      //   447: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   450: aload_0
      //   451: getfield 116	ahrb$b:TK	Landroid/widget/TextView;
      //   454: ldc_w 304
      //   457: iconst_m1
      //   458: invokestatic 308	ahtz:c	(II)Landroid/content/res/ColorStateList;
      //   461: invokevirtual 312	android/widget/TextView:setTextColor	(Landroid/content/res/ColorStateList;)V
      //   464: aload_0
      //   465: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   468: aload_0
      //   469: invokevirtual 316	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   472: aload_0
      //   473: getfield 116	ahrb$b:TK	Landroid/widget/TextView;
      //   476: aload_0
      //   477: invokevirtual 317	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   480: return
      //   481: aload_0
      //   482: getfield 110	ahrb$b:TI	Landroid/widget/TextView;
      //   485: new 271	java/lang/StringBuilder
      //   488: dup
      //   489: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   492: aload_2
      //   493: getfield 208	com/tencent/mobileqq/gamecenter/data/FeedsItemData:rcmdReason	Ljava/lang/String;
      //   496: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   499: ldc_w 319
      //   502: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   505: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   508: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   511: aload_0
      //   512: getfield 110	ahrb$b:TI	Landroid/widget/TextView;
      //   515: iconst_0
      //   516: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   519: goto -382 -> 137
      //   522: aload_0
      //   523: getfield 121	ahrb$b:layoutAction	Landroid/widget/RelativeLayout;
      //   526: iconst_0
      //   527: invokevirtual 221	android/widget/RelativeLayout:setVisibility	(I)V
      //   530: aload_2
      //   531: getfield 220	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
      //   534: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   537: ifeq +43 -> 580
      //   540: aload_0
      //   541: getfield 116	ahrb$b:TK	Landroid/widget/TextView;
      //   544: bipush 8
      //   546: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   549: aload_0
      //   550: getfield 126	ahrb$b:Ah	Landroid/widget/ImageView;
      //   553: bipush 8
      //   555: invokevirtual 320	android/widget/ImageView:setVisibility	(I)V
      //   558: aload_2
      //   559: getfield 217	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
      //   562: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   565: ifeq +64 -> 629
      //   568: aload_0
      //   569: getfield 113	ahrb$b:TJ	Landroid/widget/TextView;
      //   572: bipush 8
      //   574: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   577: goto -411 -> 166
      //   580: aload_0
      //   581: getfield 116	ahrb$b:TK	Landroid/widget/TextView;
      //   584: new 271	java/lang/StringBuilder
      //   587: dup
      //   588: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   591: aload_2
      //   592: getfield 220	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
      //   595: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   598: ldc_w 319
      //   601: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   604: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   607: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   610: aload_0
      //   611: getfield 116	ahrb$b:TK	Landroid/widget/TextView;
      //   614: iconst_0
      //   615: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   618: aload_0
      //   619: getfield 126	ahrb$b:Ah	Landroid/widget/ImageView;
      //   622: iconst_0
      //   623: invokevirtual 320	android/widget/ImageView:setVisibility	(I)V
      //   626: goto -68 -> 558
      //   629: aload_0
      //   630: getfield 113	ahrb$b:TJ	Landroid/widget/TextView;
      //   633: new 271	java/lang/StringBuilder
      //   636: dup
      //   637: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   640: aload_2
      //   641: getfield 217	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
      //   644: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   647: ldc_w 319
      //   650: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   653: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   656: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   659: aload_0
      //   660: getfield 113	ahrb$b:TJ	Landroid/widget/TextView;
      //   663: iconst_0
      //   664: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   667: goto -501 -> 166
      //   670: astore_1
      //   671: ldc_w 322
      //   674: iconst_1
      //   675: aload_1
      //   676: iconst_0
      //   677: anewarray 324	java/lang/Object
      //   680: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   683: goto -464 -> 219
      //   686: aload_0
      //   687: getfield 62	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
      //   690: iconst_0
      //   691: invokevirtual 225	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVisibility	(I)V
      //   694: aload_2
      //   695: getfield 224	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
      //   698: iconst_1
      //   699: if_icmpne +131 -> 830
      //   702: aload_0
      //   703: getfield 88	ahrb$b:je	Landroid/widget/LinearLayout;
      //   706: iconst_0
      //   707: invokevirtual 183	android/widget/LinearLayout:setVisibility	(I)V
      //   710: aload_0
      //   711: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   714: invokevirtual 334	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
      //   717: checkcast 336	android/widget/RelativeLayout$LayoutParams
      //   720: astore_1
      //   721: aload_1
      //   722: ldc_w 337
      //   725: aload_0
      //   726: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   729: invokevirtual 193	android/view/View:getContext	()Landroid/content/Context;
      //   732: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   735: invokestatic 262	wja:dp2px	(FLandroid/content/res/Resources;)I
      //   738: putfield 340	android/widget/RelativeLayout$LayoutParams:rightMargin	I
      //   741: aload_0
      //   742: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   745: aload_1
      //   746: invokevirtual 344	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   749: aload_0
      //   750: getfield 97	ahrb$b:bj	Lcom/tencent/image/URLImageView;
      //   753: iconst_0
      //   754: invokevirtual 182	com/tencent/image/URLImageView:setVisibility	(I)V
      //   757: aload_0
      //   758: getfield 100	ahrb$b:TH	Landroid/widget/TextView;
      //   761: iconst_0
      //   762: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   765: aload_0
      //   766: getfield 100	ahrb$b:TH	Landroid/widget/TextView;
      //   769: aload_2
      //   770: getfield 347	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoSrcName	Ljava/lang/String;
      //   773: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   776: aload_0
      //   777: getfield 97	ahrb$b:bj	Lcom/tencent/image/URLImageView;
      //   780: aload_2
      //   781: getfield 350	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoSrcImg	Ljava/lang/String;
      //   784: invokevirtual 236	com/tencent/image/URLImageView:setImageURL	(Ljava/lang/String;)V
      //   787: aload_0
      //   788: getfield 62	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
      //   791: new 352	ahrl
      //   794: dup
      //   795: aload_0
      //   796: invokespecial 353	ahrl:<init>	(Lahrb$b;)V
      //   799: invokevirtual 357	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$a;)V
      //   802: aload_0
      //   803: getfield 62	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
      //   806: aload_2
      //   807: iconst_2
      //   808: invokevirtual 361	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
      //   811: goto -568 -> 243
      //   814: astore_1
      //   815: ldc_w 322
      //   818: iconst_1
      //   819: aload_1
      //   820: iconst_0
      //   821: anewarray 324	java/lang/Object
      //   824: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   827: goto -40 -> 787
      //   830: aload_0
      //   831: getfield 94	ahrb$b:zM	Landroid/widget/TextView;
      //   834: bipush 8
      //   836: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
      //   839: aload_0
      //   840: getfield 94	ahrb$b:zM	Landroid/widget/TextView;
      //   843: aload_2
      //   844: getfield 364	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoDuration	I
      //   847: invokestatic 369	kwz:ba	(I)Ljava/lang/String;
      //   850: invokevirtual 243	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   853: aload_0
      //   854: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   857: invokevirtual 334	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
      //   860: checkcast 336	android/widget/RelativeLayout$LayoutParams
      //   863: astore_1
      //   864: aload_1
      //   865: ldc 255
      //   867: aload_0
      //   868: getfield 189	ahrb$b:itemView	Landroid/view/View;
      //   871: invokevirtual 193	android/view/View:getContext	()Landroid/content/Context;
      //   874: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   877: invokestatic 262	wja:dp2px	(FLandroid/content/res/Resources;)I
      //   880: putfield 340	android/widget/RelativeLayout$LayoutParams:rightMargin	I
      //   883: aload_0
      //   884: getfield 83	ahrb$b:TF	Landroid/widget/TextView;
      //   887: aload_1
      //   888: invokevirtual 344	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   891: goto -104 -> 787
      //   894: astore_1
      //   895: ldc_w 322
      //   898: iconst_1
      //   899: aload_1
      //   900: iconst_0
      //   901: anewarray 324	java/lang/Object
      //   904: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   907: goto -565 -> 342
      //   910: new 271	java/lang/StringBuilder
      //   913: dup
      //   914: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   917: ldc_w 370
      //   920: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   923: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   926: aload_0
      //   927: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   930: getfield 269	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
      //   933: i2f
      //   934: ldc_w 288
      //   937: fdiv
      //   938: ldc_w 289
      //   941: fmul
      //   942: invokestatic 295	java/lang/Math:round	(F)I
      //   945: i2f
      //   946: ldc_w 289
      //   949: fdiv
      //   950: invokevirtual 298	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   953: ldc_w 371
      //   956: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   959: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   962: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   965: astore_1
      //   966: goto -524 -> 442
      //   969: aload_0
      //   970: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   973: getfield 224	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
      //   976: iconst_1
      //   977: if_icmpne +45 -> 1022
      //   980: new 271	java/lang/StringBuilder
      //   983: dup
      //   984: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   987: ldc_w 274
      //   990: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   993: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   996: aload_0
      //   997: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   1000: getfield 287	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoViewers	I
      //   1003: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1006: ldc_w 375
      //   1009: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   1012: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1015: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1018: astore_1
      //   1019: goto -577 -> 442
      //   1022: new 271	java/lang/StringBuilder
      //   1025: dup
      //   1026: invokespecial 273	java/lang/StringBuilder:<init>	()V
      //   1029: ldc_w 376
      //   1032: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   1035: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1038: aload_0
      //   1039: getfield 175	ahrb$b:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
      //   1042: getfield 269	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
      //   1045: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1048: ldc_w 377
      //   1051: invokestatic 280	acfp:m	(I)Ljava/lang/String;
      //   1054: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1057: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1060: astore_1
      //   1061: goto -619 -> 442
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1064	0	this	b
      //   0	1064	1	paramahrb	ahrb
      //   0	1064	2	paramFeedsItemData	FeedsItemData
      //   0	1064	3	paramInt	int
      // Exception table:
      //   from	to	target	type
      //   199	219	670	java/lang/Exception
      //   776	787	814	java/lang/Exception
      //   265	342	894	java/lang/Exception
    }
    
    public void onClick(View paramView)
    {
      paramView.getId();
      Object localObject = new HashMap();
      tbb.b((Map)localObject, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
      ((Map)localObject).put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
      ((Map)localObject).put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
      ((Map)localObject).put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
      tbb.a(abmt.getAppInterface(), "769", "205022", this.b.a().gameAppId, "76902", "1", "160", (Map)localObject);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl)) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/"))
        {
          MiniAppLauncher.startMiniApp(ahrb.a(this.b), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
        }
        else
        {
          localObject = new Intent(ahrb.a(this.b), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
          ahrb.a(this.b).startActivity((Intent)localObject);
        }
      }
    }
  }
  
  public static class c
  {
    public ImageView Ai;
    public TextView TL;
    public TextView TM;
    public ahuo a;
    public ImageSwitcher g;
    public ImageSwitcher h;
    public ImageView ko;
  }
  
  public static class d
    extends BaseAdapter
  {
    private Map<String, Boolean> kW;
    public List<FeedsItemData.LabelInfo> labels;
    private Context mContext;
    
    public d(List<FeedsItemData.LabelInfo> paramList, Context paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubFeedsAdapter", 0, "[LabelsAdapter] set next image");
      }
      if (paramList == null) {}
      for (this.labels = new ArrayList();; this.labels = paramList)
      {
        this.kW = new HashMap();
        this.mContext = paramContext;
        return;
      }
    }
    
    public int getCount()
    {
      return this.labels.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.labels.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubFeedsAdapter", 0, "[getView] set next image");
      }
      FeedsItemData.LabelInfo localLabelInfo = (FeedsItemData.LabelInfo)this.labels.get(paramInt);
      ahrb.c localc;
      Object localObject1;
      if (paramView == null)
      {
        localc = new ahrb.c();
        paramView = new RelativeLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localObject1 = new RelativeLayout(this.mContext);
        ((RelativeLayout)localObject1).setId(2131369087);
        Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(7.0F, this.mContext.getResources());
        ((RelativeLayout)localObject1).setPadding(wja.dp2px(1.0F, this.mContext.getResources()), wja.dp2px(1.0F, this.mContext.getResources()), wja.dp2px(1.0F, this.mContext.getResources()), wja.dp2px(1.0F, this.mContext.getResources()));
        Object localObject3 = new ImageSwitcher(this.mContext);
        ((ImageSwitcher)localObject3).setId(2131368963);
        ((ImageSwitcher)localObject3).setFactory(new ahrm(this));
        Object localObject4 = new RelativeLayout.LayoutParams(wja.dp2px(30.0F, this.mContext.getResources()), wja.dp2px(30.0F, this.mContext.getResources()));
        ((RelativeLayout.LayoutParams)localObject4).addRule(9);
        ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new ImageSwitcher(this.mContext);
        ((ImageSwitcher)localObject4).setFactory(new ahrn(this));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(30.0F, this.mContext.getResources()), wja.dp2px(30.0F, this.mContext.getResources()));
        localLayoutParams.addRule(5, ((ImageSwitcher)localObject3).getId());
        localLayoutParams.leftMargin = wja.dp2px(22.0F, this.mContext.getResources());
        ((RelativeLayout)localObject1).addView((View)localObject4, localLayoutParams);
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localc.h = ((ImageSwitcher)localObject3);
        localc.g = ((ImageSwitcher)localObject4);
        localc.a = new ahuo(localc.g, localc.h);
        localObject2 = new ImageView(this.mContext);
        ((ImageView)localObject2).setId(2131368962);
        localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(34.0F, this.mContext.getResources()), wja.dp2px(32.0F, this.mContext.getResources()));
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localc.Ai = ((ImageView)localObject2);
        localObject3 = new TextView(this.mContext);
        ((TextView)localObject3).setSingleLine(true);
        ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
        ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(9.0F, this.mContext.getResources());
        ((TextView)localObject3).setTextSize(12.0F);
        ((TextView)localObject3).setTextColor(-14540254);
        ((TextView)localObject3).setId(2131372190);
        paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
        localc.TL = ((TextView)localObject3);
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setMaxLines(1);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(14);
        ((RelativeLayout.LayoutParams)localObject4).addRule(3, ((TextView)localObject3).getId());
        ((RelativeLayout.LayoutParams)localObject4).topMargin = wja.dp2px(2.0F, this.mContext.getResources());
        ((TextView)localObject2).setTextColor(-2145246686);
        ((TextView)localObject2).setTextSize(10.0F);
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        localObject3 = new ImageView(this.mContext);
        ((ImageView)localObject3).setImageDrawable(this.mContext.getResources().getDrawable(2130851400));
        localObject4 = new RelativeLayout.LayoutParams(wja.dp2px(8.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, ((RelativeLayout)localObject1).getId());
        ((RelativeLayout.LayoutParams)localObject4).addRule(6, ((RelativeLayout)localObject1).getId());
        paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        localc.ko = ((ImageView)localObject3);
        localc.TM = ((TextView)localObject2);
        paramView.setPadding(wja.dp2px(5.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), wja.dp2px(5.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()));
        paramView.setTag(localc);
      }
      for (;;)
      {
        localc.ko.setVisibility(8);
        if (ahtz.a(localLabelInfo.redInfo))
        {
          localc.ko.setVisibility(0);
          if (!this.kW.containsKey(localLabelInfo.name))
          {
            this.kW.put(localLabelInfo.name, Boolean.valueOf(true));
            localObject1 = new HashMap();
            tbb.b((Map)localObject1, localLabelInfo.msgId);
            ((Map)localObject1).put(Integer.valueOf(2), localLabelInfo.msgId);
            ((Map)localObject1).put(Integer.valueOf(3), localLabelInfo.reportId);
            tbb.a(abmt.getAppInterface(), "769", "205648", localLabelInfo.appId, "76903", "1", "160", (Map)localObject1);
          }
        }
        if (!localLabelInfo.isFriend) {
          break label1386;
        }
        localc.Ai.setVisibility(8);
        localc.g.setVisibility(0);
        localc.h.setVisibility(0);
        if ((localLabelInfo.friendList != null) && (localLabelInfo.friendList.size() > 0)) {}
        try
        {
          if (localLabelInfo.friendList.size() < 2) {
            break label1300;
          }
          localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(0)).icon);
          localc.g.setImageDrawable((Drawable)localObject1);
          localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(1)).icon);
          localc.h.setImageDrawable((Drawable)localObject1);
          if (localLabelInfo.friendList.size() >= 4)
          {
            localObject1 = new ArrayList();
            int i = 0;
            for (;;)
            {
              if (i < localLabelInfo.friendList.size())
              {
                ((List)localObject1).add(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(i)).icon);
                i += 1;
                continue;
                localc = (ahrb.c)paramView.getTag();
                break;
              }
            }
            localc.a.kZ((List)localObject1);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.e("QQGamePubFeedsAdapter", 1, "[TopCardVH] initView error." + localException1);
          }
        }
      }
      localc.TL.setText(acfp.m(2131711732));
      localc.TM.setText(acfp.m(2131711727) + localLabelInfo.friendNum + acfp.m(2131711719));
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label1300:
        localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(0)).icon);
        localc.h.setVisibility(0);
        localc.h.setImageDrawable((Drawable)localObject1);
        localc.g.setVisibility(8);
        break;
        try
        {
          label1386:
          URLDrawable localURLDrawable;
          if ((localLabelInfo.icons != null) && (localLabelInfo.icons.size() > 0))
          {
            if (localLabelInfo.icons.size() < 2) {
              break label1562;
            }
            localc.Ai.setVisibility(4);
            localc.g.setVisibility(0);
            localc.h.setVisibility(0);
            localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(0));
            localc.g.setImageDrawable(localURLDrawable);
            localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(1));
            localc.h.setImageDrawable(localURLDrawable);
            if (localLabelInfo.icons.size() >= 4) {
              localc.a.kZ(localLabelInfo.icons);
            }
          }
          for (;;)
          {
            localc.TL.setText(localLabelInfo.name);
            localc.TM.setText(localLabelInfo.desc);
            break;
            label1562:
            localc.Ai.setVisibility(0);
            localc.g.setVisibility(8);
            localc.h.setVisibility(8);
            localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(0));
            localc.Ai.setImageDrawable(localURLDrawable);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("QQGamePubFeedsAdapter", 1, "[TopCardVH] initView error." + localException2);
          }
        }
      }
    }
  }
  
  public static class e
    extends RecyclerView.ViewHolder
  {
    public NoScrollGridView a;
    public ShadowView a;
    public FeedsItemData.TopCardInfo b;
    public FrameLayout bH;
    public ahrb c;
    public FrameGifView g;
    public Context mContext;
    public TextView tvTitle;
    
    public e(View paramView, Context paramContext)
    {
      super();
      this.tvTitle = ((TextView)paramView.findViewById(2131380646));
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView = ((NoScrollGridView)paramView.findViewById(2131368288));
      this.g = ((FrameGifView)paramView.findViewById(2131377389));
      this.g.setPlayLoop(true);
      this.bH = ((FrameLayout)paramView.findViewById(2131377392));
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView = ((ShadowView)paramView.findViewById(2131377393));
      this.tvTitle.setText(acfp.m(2131711722));
      this.mContext = paramContext;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView.setShadowProperties(wja.dp2px(6.0F, this.mContext.getResources()), 0.0F, wja.dp2px(2.0F, this.mContext.getResources()), Color.parseColor("#1A0066FF"));
    }
    
    public void a(FeedsItemData.TopCardInfo paramTopCardInfo, ahrb paramahrb)
    {
      this.c = paramahrb;
      Iterator localIterator;
      int i;
      if ((paramTopCardInfo != null) && (ahrb.a(paramTopCardInfo)))
      {
        paramahrb = new RecyclerView.LayoutParams(-1, -2);
        this.itemView.setLayoutParams(paramahrb);
        this.b = paramTopCardInfo;
        paramahrb = new HashMap();
        tbb.b(paramahrb, this.b.msgId);
        paramahrb.put(Integer.valueOf(2), this.b.msgId);
        paramahrb.put(Integer.valueOf(4), "8");
        paramahrb.put(Integer.valueOf(6), this.c.a().gameAppId);
        localIterator = this.b.labelInfos.iterator();
        i = 32;
      }
      while (localIterator.hasNext())
      {
        paramahrb.put(Integer.valueOf(i), ((FeedsItemData.LabelInfo)localIterator.next()).reportId);
        i += 1;
        continue;
        paramTopCardInfo = new RecyclerView.LayoutParams(-1, 0);
        this.itemView.setLayoutParams(paramTopCardInfo);
        return;
      }
      tbb.a(abmt.getAppInterface(), "769", "205609", this.c.a().gameAppId, "76903", "1", "160", paramahrb);
      this.b = paramTopCardInfo;
      if ((this.b.labelInfos != null) && (this.b.labelInfos.size() <= 4)) {
        this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setAdapter(new ahrb.d(this.b.labelInfos, this.mContext));
        this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setOnItemClickListener(new ahro(this));
        long l = NetConnInfoCenter.getServerTime();
        if ((TextUtils.isEmpty(paramTopCardInfo.bannerIconZip)) || (paramTopCardInfo.bannerBeginTime > l) || (l > paramTopCardInfo.bannerEndTime)) {
          break label497;
        }
        this.bH.setVisibility(0);
        if ((this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams()).topMargin = wja.dp2px(8.0F, this.mContext.getResources());
        }
        this.g.setVisibility(0);
        this.g.setGifData(paramTopCardInfo.bannerGap, null, paramTopCardInfo.bannerIconZip, acbk.jb(paramTopCardInfo.bannerIconZip), true);
        tbb.a(abmt.getAppInterface(), "769", "205646", this.c.a().gameAppId, "76903", "1", "160", new String[] { "", "", "8" });
        paramTopCardInfo = paramTopCardInfo.bannerUrl;
        if (TextUtils.isEmpty(paramTopCardInfo)) {
          break;
        }
        this.g.setOnClickListener(new ahrp(this, paramTopCardInfo));
        return;
        this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(5);
      }
      label497:
      this.bH.setVisibility(8);
      this.g.setVisibility(8);
      this.g.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrb
 * JD-Core Version:    0.7.0.1
 */