package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import ahpq;
import ahps;
import ahpt;
import ahpu;
import ahpv;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqdf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xd84.RspBody;

public class IntimatePlayTogetherMiniGameCardView
  extends FrameLayout
{
  private TextView Tw;
  private LinearLayout ja;
  private RecyclerView z;
  private ImageView zY;
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext)
  {
    super(paramContext);
    initView(paramContext, null, 0);
  }
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext, paramAttributeSet, 0);
  }
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void a(View paramView, IntimateInfo paramIntimateInfo)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (IntimatePlayTogetherMiniGameCardView)((ViewGroup)paramView).findViewById(2131367705);
      if (paramView != null) {
        paramView.a(paramIntimateInfo);
      }
    }
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    int i;
    if ((paramIntimateInfo != null) && (paramIntimateInfo.commonBodies != null) && (!paramIntimateInfo.commonBodies.isEmpty()))
    {
      localObject3 = paramIntimateInfo.commonBodies.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (oidb_0xcf4.CommonBody)((Iterator)localObject3).next();
        if (((oidb_0xcf4.CommonBody)localObject2).uint32_oidb_cmd.get() != 3460) {
          break label481;
        }
        localObject1 = localObject2;
      }
      if (localObject1 == null)
      {
        QLog.d("IntimatePlayTogetherMin", 1, new Object[] { "updateIntimateInfo", "no 0xd84 cmd found in common body response" });
        setVisibility(8);
        return;
      }
      try
      {
        localObject2 = new oidb_0xd84.RspBody();
        ((oidb_0xd84.RspBody)localObject2).mergeFrom(((oidb_0xcf4.CommonBody)localObject1).string_oidb_body.get().toByteArray());
        localObject1 = new MISC.StGetFriendPlayListV2Rsp();
        ((MISC.StGetFriendPlayListV2Rsp)localObject1).mergeFrom(((oidb_0xd84.RspBody)localObject2).bytes_xmitinfo.get().toByteArray());
        if (((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.size() <= 0)
        {
          setVisibility(8);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntimateInfo)
      {
        QLog.e("IntimatePlayTogetherMin", 2, "updateIntimateInfo", paramIntimateInfo);
        setVisibility(8);
        return;
      }
      localObject2 = new ahpq(this, (MISC.StGetFriendPlayListV2Rsp)localObject1);
      setVisibility(0);
      if (this.Tw != null) {
        this.Tw.setText(String.valueOf(((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get()));
      }
      if ((((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get() < 2) || (TextUtils.isEmpty(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get()))) {
        break label484;
      }
      i = 1;
      label269:
      if (this.zY != null)
      {
        localObject3 = this.zY;
        if (i == 0) {
          break label489;
        }
      }
    }
    label481:
    label484:
    label489:
    for (int j = 0;; j = 4)
    {
      ((ImageView)localObject3).setVisibility(j);
      if (this.z != null)
      {
        this.z.setLayoutManager(new LinearLayoutManager(getContext()));
        paramIntimateInfo = new a(((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get(), paramIntimateInfo.friendUin, (View.OnClickListener)localObject2);
        paramIntimateInfo.Pl(2064);
        this.z.setAdapter(paramIntimateInfo);
      }
      paramIntimateInfo = ((MISC.StAppPlayingInfo)((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get().get(0)).appMetaInfo;
      localObject3 = new MiniAppConfig(MiniAppInfo.from(paramIntimateInfo));
      if (((MiniAppConfig)localObject3).launchParam != null) {
        ((MiniAppConfig)localObject3).launchParam.scene = 2064;
      }
      if (ahpv.a(paramIntimateInfo)) {}
      for (paramIntimateInfo = "c2close";; paramIntimateInfo = "page_view")
      {
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject3, paramIntimateInfo, "expo", null, null);
        if (i != 0) {
          MiniAppCmdUtil.getInstance().getAppInfoByLink(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get(), 2, new ahps(this, (MISC.StGetFriendPlayListV2Rsp)localObject1));
        }
        setOnClickListener((View.OnClickListener)localObject2);
        return;
      }
      setVisibility(8);
      return;
      break;
      i = 0;
      break label269;
    }
  }
  
  private static void a(ThemeImageView paramThemeImageView, String paramString)
  {
    if ((paramThemeImageView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = new aqdf(paramThemeImageView.getContext(), (QQAppInterface)localObject);
    Bitmap localBitmap = ((aqdf)localObject).a(1, paramString, 0, (byte)4);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ((aqdf)localObject).destory();
      paramThemeImageView.setImageBitmap(localBitmap);
      return;
    }
    ((aqdf)localObject).a(new ahpt((aqdf)localObject, paramThemeImageView));
    ((aqdf)localObject).a(paramString, 200, false, 1, true, (byte)0, 4);
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    LayoutInflater.from(paramContext).inflate(2131559449, this);
    this.z = ((RecyclerView)findViewById(2131367706));
    this.Tw = ((TextView)findViewById(2131367709));
    this.zY = ((ImageView)findViewById(2131367707));
    this.ja = ((LinearLayout)findViewById(2131367710));
    setVisibility(8);
  }
  
  public static class a
    extends RecyclerView.Adapter<IntimatePlayTogetherMiniGameCardView.b>
  {
    private List<MISC.StAppPlayingInfo> Cd;
    private ColorStateList attrValue;
    private int colorInt;
    private int daC = 9999;
    private final View.OnClickListener fm;
    private final String friendUin;
    private boolean isTheme;
    
    public a(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
    {
      this.Cd = paramList;
      this.friendUin = paramString;
      this.fm = paramOnClickListener;
    }
    
    private int A(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 2131695073;
      }
      return 2131695076;
    }
    
    private void a(IntimatePlayTogetherMiniGameCardView.b paramb)
    {
      try
      {
        if (this.attrValue != null)
        {
          paramb.P().setTextColor(this.attrValue);
          paramb.Q().setTextColor(this.attrValue);
          return;
        }
        paramb.P().setTextColor(this.colorInt);
        paramb.Q().setTextColor(this.colorInt);
        return;
      }
      catch (Throwable paramb)
      {
        QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramb);
      }
    }
    
    public void Pl(int paramInt)
    {
      this.daC = paramInt;
    }
    
    public IntimatePlayTogetherMiniGameCardView.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new IntimatePlayTogetherMiniGameCardView.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559450, null, false));
    }
    
    public void a(IntimatePlayTogetherMiniGameCardView.b paramb, int paramInt)
    {
      MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.Cd.get(paramInt);
      boolean bool;
      if (localStAppPlayingInfo != null)
      {
        bool = ahpv.a(localStAppPlayingInfo.appMetaInfo);
        paramb.itemView.setOnClickListener(new ahpu(this, localStAppPlayingInfo, bool));
        paramb.ch().setVisibility(0);
        paramb.a().setVisibility(0);
        paramb.Q().setVisibility(0);
        if (localStAppPlayingInfo.appMetaInfo != null)
        {
          paramb.P().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
          paramb.c().setImageDrawable(MiniAppUtils.getIcon(paramb.c().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
        }
        IntimatePlayTogetherMiniGameCardView.b(paramb.a(), this.friendUin);
        if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
          break label271;
        }
        if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
          break label228;
        }
        paramb.Q().setText(2131695068);
        paramb.c().setText(A(bool));
      }
      for (;;)
      {
        if (this.isTheme) {
          a(paramb);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
        label228:
        TextView localTextView = paramb.Q();
        if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
        for (int i = 2131695070;; i = 2131695069)
        {
          localTextView.setText(i);
          break;
        }
        label271:
        if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
        {
          paramb.Q().setText(String.format(paramb.itemView.getContext().getString(2131695071), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
          paramb.c().setText(A(bool));
        }
        else
        {
          paramb.ch().setVisibility(8);
          paramb.a().setVisibility(8);
          paramb.Q().setVisibility(8);
          paramb.c().setText(A(bool));
        }
      }
    }
    
    public int getItemCount()
    {
      return 1;
    }
    
    public void setTextColor(int paramInt)
    {
      this.isTheme = true;
      this.colorInt = paramInt;
    }
    
    public void setTextColor(ColorStateList paramColorStateList)
    {
      this.isTheme = true;
      this.attrValue = paramColorStateList;
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    private View Dy;
    private TextView Tx;
    private TextView Ty;
    private TextView Tz;
    private URLImageView bh;
    private ThemeImageView g;
    private Button gj;
    
    b(View paramView)
    {
      super();
      this.bh = ((URLImageView)paramView.findViewById(2131369342));
      this.Tx = ((TextView)paramView.findViewById(2131369344));
      this.Ty = ((TextView)paramView.findViewById(2131369347));
      this.g = ((ThemeImageView)paramView.findViewById(2131369340));
      this.Tz = ((TextView)paramView.findViewById(2131369346));
      this.gj = ((Button)paramView.findViewById(2131369345));
      this.Dy = paramView.findViewById(2131369341);
    }
    
    TextView P()
    {
      return this.Tx;
    }
    
    TextView Q()
    {
      return this.Tz;
    }
    
    public ThemeImageView a()
    {
      return this.g;
    }
    
    Button c()
    {
      return this.gj;
    }
    
    URLImageView c()
    {
      return this.bh;
    }
    
    View ch()
    {
      return this.Dy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView
 * JD-Core Version:    0.7.0.1
 */