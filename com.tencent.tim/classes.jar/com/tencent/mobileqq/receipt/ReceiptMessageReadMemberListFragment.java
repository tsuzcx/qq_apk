package com.tencent.mobileqq.receipt;

import altc;
import altd;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aqdf;
import aqdf.a;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ReceiptMessageReadMemberListFragment
  extends ReportV4Fragment
{
  private aqdf a;
  private QQAppInterface mApp;
  private View mContentView;
  
  @Nonnull
  public static ReceiptMessageReadMemberListFragment a(@Nonnull ArrayList<MemberInfo> paramArrayList, @Nullable String paramString)
  {
    ReceiptMessageReadMemberListFragment localReceiptMessageReadMemberListFragment = new ReceiptMessageReadMemberListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("ReceiptMessageReadMemberListFragment.EXTRA_KEY_MEMBER_LIST", paramArrayList);
    localBundle.putString("ReceiptMessageReadMemberListFragment.EXTRA_KEY_EMPTY_TEXT", paramString);
    localReceiptMessageReadMemberListFragment.setArguments(localBundle);
    return localReceiptMessageReadMemberListFragment;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("only allow used in main process");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContentView = paramLayoutInflater.inflate(2131558710, paramViewGroup, false);
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.a.destory();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    paramView = paramBundle.getParcelableArrayList("ReceiptMessageReadMemberListFragment.EXTRA_KEY_MEMBER_LIST");
    paramBundle = paramBundle.getString("ReceiptMessageReadMemberListFragment.EXTRA_KEY_EMPTY_TEXT");
    if (((paramView == null) || (paramView.isEmpty())) && (!TextUtils.isEmpty(paramBundle)))
    {
      localObject = this.mContentView.findViewById(2131366438);
      ((TextView)this.mContentView.findViewById(2131366442)).setText(paramBundle);
      ((View)localObject).setVisibility(0);
    }
    paramBundle = (RecyclerView)this.mContentView.findViewById(2131371233);
    this.a = new aqdf(BaseApplicationImpl.getContext(), this.mApp);
    Object localObject = new b(BaseApplicationImpl.getContext(), this.a, paramBundle, null);
    ((b)localObject).setData(paramView);
    paramBundle.setAdapter((RecyclerView.Adapter)localObject);
    paramBundle.setLayoutManager(new LinearLayoutManager(BaseApplicationImpl.getContext()));
    int i = (int)(getResources().getDisplayMetrics().density * 64.0F);
    paramBundle.addItemDecoration(new a(getResources().getDrawable(2130838349), i, 0, null));
  }
  
  public static class MemberInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<MemberInfo> CREATOR = new altd();
    public String name;
    public long readTime;
    public String uin;
    
    public MemberInfo(Parcel paramParcel)
    {
      this.uin = paramParcel.readString();
      this.name = paramParcel.readString();
      this.readTime = paramParcel.readLong();
    }
    
    MemberInfo(String paramString1, String paramString2, long paramLong)
    {
      this.uin = paramString1;
      this.name = paramString2;
      this.readTime = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.uin);
      paramParcel.writeString(this.name);
      paramParcel.writeLong(this.readTime);
    }
  }
  
  static class a
    extends RecyclerView.ItemDecoration
  {
    private int bAr;
    private int dwW;
    private Drawable fr;
    
    private a(Drawable paramDrawable, int paramInt1, int paramInt2)
    {
      this.fr = paramDrawable;
      this.bAr = paramInt1;
      this.dwW = paramInt2;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.set(0, 0, 0, this.fr.getIntrinsicHeight());
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      int j = paramRecyclerView.getPaddingLeft();
      int k = this.bAr;
      int m = paramRecyclerView.getWidth();
      int n = paramRecyclerView.getPaddingRight();
      int i1 = this.dwW;
      int i2 = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < i2)
      {
        paramState = paramRecyclerView.getChildAt(i);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
        int i3 = paramState.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        int i4 = this.fr.getIntrinsicHeight();
        this.fr.setBounds(j + k, i3, m - n - i1, i4 + i3);
        this.fr.draw(paramCanvas);
        i += 1;
      }
    }
  }
  
  public static class b
    extends RecyclerView.Adapter<ReceiptMessageReadMemberListFragment.c>
    implements aqdf.a
  {
    private RecyclerView D;
    private aqdf a;
    private RecyclerView.OnScrollListener b = new altc(this);
    private Bitmap du;
    private Context mContext;
    private int mCurrentScrollState = 0;
    private List<ReceiptMessageReadMemberListFragment.MemberInfo> mData;
    private Map<String, Bitmap> mN;
    
    private b(Context paramContext, aqdf paramaqdf, RecyclerView paramRecyclerView)
    {
      this.mContext = paramContext;
      this.a = paramaqdf;
      this.du = aqhu.G();
      this.a.a(this);
      this.mN = new HashMap();
      this.D = paramRecyclerView;
      paramRecyclerView.setOnScrollListener(this.b);
    }
    
    private Bitmap a(String paramString, int paramInt, byte paramByte)
    {
      Bitmap localBitmap = this.a.b(paramInt, paramString);
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.a.isPausing()) {
        this.a.a(paramString, paramInt, true, paramByte);
      }
      return this.du;
    }
    
    private void dJy()
    {
      int j = this.D.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.D.getChildAt(i);
        localObject = (ReceiptMessageReadMemberListFragment.c)this.D.getChildViewHolder((View)localObject);
        Bitmap localBitmap = (Bitmap)this.mN.get(ReceiptMessageReadMemberListFragment.c.a((ReceiptMessageReadMemberListFragment.c)localObject));
        if (localBitmap != null) {
          ReceiptMessageReadMemberListFragment.c.a((ReceiptMessageReadMemberListFragment.c)localObject).setImageBitmap(localBitmap);
        }
        i += 1;
      }
    }
    
    private Bitmap getFaceBitmap(String paramString)
    {
      return a(paramString, 1, (byte)0);
    }
    
    public ReceiptMessageReadMemberListFragment.c a(ViewGroup paramViewGroup, int paramInt)
    {
      return new ReceiptMessageReadMemberListFragment.c(LayoutInflater.from(this.mContext).inflate(2131562949, paramViewGroup, false), null);
    }
    
    public void a(ReceiptMessageReadMemberListFragment.c paramc, int paramInt)
    {
      ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)this.mData.get(paramInt);
      ReceiptMessageReadMemberListFragment.c.a(paramc, localMemberInfo.uin);
      ReceiptMessageReadMemberListFragment.c.a(paramc).setText(localMemberInfo.name);
      ReceiptMessageReadMemberListFragment.c.a(paramc).setImageBitmap(getFaceBitmap(localMemberInfo.uin));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramc, paramInt, getItemId(paramInt));
    }
    
    public int getItemCount()
    {
      if (this.mData == null) {
        return 0;
      }
      return this.mData.size();
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      this.mN.put(paramString, paramBitmap);
      if (paramInt1 <= 0)
      {
        if (this.mCurrentScrollState == 0) {
          dJy();
        }
        this.mN.clear();
      }
    }
    
    public void setData(List<ReceiptMessageReadMemberListFragment.MemberInfo> paramList)
    {
      this.mData = paramList;
      notifyDataSetChanged();
    }
  }
  
  public static class c
    extends RecyclerView.ViewHolder
  {
    private ImageView Db;
    private TextView Ug;
    private String mUin;
    
    private c(View paramView)
    {
      super();
      this.Ug = ((TextView)paramView.findViewById(2131380814));
      this.Db = ((ImageView)paramView.findViewById(2131369767));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment
 * JD-Core Version:    0.7.0.1
 */