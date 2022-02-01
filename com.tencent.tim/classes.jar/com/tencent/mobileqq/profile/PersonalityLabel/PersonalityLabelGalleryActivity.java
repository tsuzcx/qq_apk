package com.tencent.mobileqq.profile.PersonalityLabel;

import acfd;
import albf;
import albi;
import albi.a;
import albi.b;
import albk;
import albl;
import albm;
import albn;
import albo;
import albp;
import albq;
import albr;
import albs;
import albt;
import albu;
import albv;
import albw;
import albx;
import alby;
import albz;
import alcb;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqep;
import aqfy;
import aqgv;
import aqha;
import aqhq;
import aqis;
import aqiw;
import aqju;
import arhz;
import arhz.a;
import ausj;
import avpw;
import avpw.d;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import wja;

public class PersonalityLabelGalleryActivity
  extends IphoneTitleBarActivity
  implements albi.b, Handler.Callback, View.OnClickListener
{
  private Button G;
  private ViewStub J;
  private TextView TU;
  acfd jdField_a_of_type_Acfd = new albm(this);
  public albi a;
  arhz.a jdField_a_of_type_Arhz$a = new albn(this);
  arhz jdField_a_of_type_Arhz;
  protected AccountDetailTopGestureLayout a;
  private c jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c;
  private long aga;
  public ausj al;
  private alcb jdField_b_of_type_Alcb = new albq(this);
  FriendListHandler jdField_b_of_type_ComTencentMobileqqAppFriendListHandler;
  public HashSet<Long> bs = new HashSet();
  BroadcastReceiver bx = new albp(this);
  private PersonalityLabel c;
  private List<String> cJ = new ArrayList();
  private boolean cvR = false;
  public boolean cvS = false;
  public boolean cvT = false;
  boolean cvU = false;
  boolean cvV = false;
  public volatile boolean cvW = true;
  private ProfileActivity.AllInOne d;
  private int drt;
  int dru = 0;
  QQToast f;
  QQToast g;
  private ConcurrentHashMap<Long, Integer> gA = new ConcurrentHashMap();
  private Button gW;
  private ConcurrentHashMap<Long, PersonalityLabelInfo> gy = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, byte[]> gz = new ConcurrentHashMap();
  private TextView ht;
  Drawable mDefaultDrawable;
  private float mDensity;
  private TextView mDesc;
  private View mEmptyView;
  private int mFromType = 0;
  private View mHeaderView;
  private boolean mIsLoading = false;
  private XListView mListView;
  private String mNickname;
  public Handler mSubHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  TextPaint mTextPaint;
  Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  private String mUin;
  private View xR;
  private boolean xv;
  
  private void NC(boolean paramBoolean)
  {
    if (!this.cvT)
    {
      if (!aqiw.isNetSupport(this))
      {
        showToast(getResources().getString(2131696270));
        return;
      }
      if (isTitleProgressShowing())
      {
        showToast("请等待数据加载完毕");
        return;
      }
    }
    View localView;
    if (!this.cvT)
    {
      paramBoolean = true;
      this.cvT = paramBoolean;
      dEO();
      localView = this.xR;
      if ((!this.xv) || (this.cvT) || (!atl())) {
        break label169;
      }
    }
    label169:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.mUIHandler.hasMessages(2)) {
        this.mUIHandler.removeMessages(2);
      }
      this.mUIHandler.sendEmptyMessage(2);
      if ((this.cvT) && (this.cvV))
      {
        this.cvU = false;
        dEQ();
      }
      if (this.c.unreadCount > 0) {
        SF(0);
      }
      dEU();
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private void SF(int paramInt)
  {
    int i = paramInt;
    if (this.cvT)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = 8;
      }
    }
    if (this.TU.getVisibility() != i) {
      this.TU.setVisibility(i);
    }
  }
  
  private void a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    int j = 1;
    int i = 0;
    for (;;)
    {
      b localb;
      label71:
      GlowCountRecyclerView localGlowCountRecyclerView;
      if (i < this.mListView.getChildCount())
      {
        localb = (b)this.mListView.getChildAt(i).getTag();
        if ((localb == null) || (localb.XM != paramLong)) {
          break label171;
        }
        if (paramPersonalityLabelInfo.getSize() <= 0) {
          break label152;
        }
        i = 1;
        if (localb.a.getVisibility() != 0) {
          break label158;
        }
        if (j != i)
        {
          localGlowCountRecyclerView = localb.a;
          if (i == 0) {
            break label164;
          }
        }
      }
      label152:
      label158:
      label164:
      for (i = 0;; i = 8)
      {
        localGlowCountRecyclerView.setVisibility(i);
        localb.a.setText(paramPersonalityLabelInfo.photoCount + "张");
        localb.a.getAdapter().notifyDataSetChanged();
        localb.a.smoothScrollToPosition(0);
        return;
        i = 0;
        break;
        j = 0;
        break label71;
      }
      label171:
      i += 1;
    }
  }
  
  private void a(String paramString, arhz.a parama)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.a(parama);
      this.jdField_a_of_type_Arhz.setMessage(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Arhz.show();
  }
  
  private void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  private void b(PersonalityLabel paramPersonalityLabel)
  {
    if ((paramPersonalityLabel != null) && (paramPersonalityLabel.getSize() > 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (this.mEmptyView == null) {}
        try
        {
          this.mEmptyView = this.J.inflate();
          if (this.mEmptyView != null)
          {
            View localView1 = this.mEmptyView.findViewById(2131366438);
            localTextView1 = (TextView)this.mEmptyView.findViewById(2131366435);
            localTextView2 = (TextView)this.mEmptyView.findViewById(2131366444);
            localView2 = this.mEmptyView.findViewById(2131366399);
            if (this.xv)
            {
              localTextView1.setText(2131701500);
              localTextView2.setText(getString(2131701496));
              localView2.setOnClickListener(this);
              return;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          TextView localTextView1;
          TextView localTextView2;
          View localView2;
          for (;;)
          {
            System.gc();
            if (QLog.isColorLevel()) {
              QLog.i("PersonalityLabelGalleryActivity", 2, "setEmptyText inflate empty view outOfMemoryError");
            }
            try
            {
              this.mEmptyView = this.J.inflate();
            }
            catch (OutOfMemoryError localOutOfMemoryError2) {}
          }
          if ((paramPersonalityLabel != null) && (paramPersonalityLabel.isCloseByUser == 1))
          {
            localTextView1.setText(2131701495);
            localView2.setVisibility(8);
            localTextView2.setVisibility(8);
            if (localOutOfMemoryError2.getPaddingBottom() <= 0) {
              localOutOfMemoryError2.setPadding(localOutOfMemoryError2.getPaddingLeft(), localOutOfMemoryError2.getPaddingTop(), localOutOfMemoryError2.getPaddingRight(), localOutOfMemoryError2.getPaddingBottom() + wja.dp2px(73.0F, getResources()));
            }
          }
          else
          {
            localTextView1.setText(2131701500);
            localView2.setVisibility(8);
            localTextView2.setText(getString(2131701499));
          }
        }
      }
    } while (localOutOfMemoryError2.getPaddingBottom() > 0);
    localOutOfMemoryError2.setPadding(localOutOfMemoryError2.getPaddingLeft(), localOutOfMemoryError2.getPaddingTop(), localOutOfMemoryError2.getPaddingRight(), localOutOfMemoryError2.getPaddingBottom() + wja.dp2px(73.0F, getResources()));
  }
  
  public static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).getInt();
  }
  
  private void c(PersonalityLabel paramPersonalityLabel)
  {
    this.gy.clear();
    if ((paramPersonalityLabel != null) && (paramPersonalityLabel.personalityLabelInfos != null) && (paramPersonalityLabel.personalityLabelInfos.size() > 0))
    {
      paramPersonalityLabel = paramPersonalityLabel.personalityLabelInfos.iterator();
      while (paramPersonalityLabel.hasNext())
      {
        PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramPersonalityLabel.next();
        this.gy.put(Long.valueOf(localPersonalityLabelInfo.id), localPersonalityLabelInfo);
      }
    }
  }
  
  private void dE(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.mFromType = paramIntent.getIntExtra("fromType", this.mFromType);
      this.d = ((ProfileActivity.AllInOne)paramIntent.getParcelableExtra("personality_label_allinone"));
      this.mUin = paramIntent.getStringExtra("uin");
      this.mNickname = paramIntent.getStringExtra("nickname");
      if (!TextUtils.isEmpty(this.mUin)) {
        break label79;
      }
      QQToast.a(this, "打开标签失败，请重试", 0);
      finish();
    }
    label79:
    do
    {
      return;
      if ((TextUtils.isEmpty(this.mNickname)) && (!this.mUin.equals(this.app.getCurrentAccountUin())))
      {
        this.mNickname = aqgv.s(this.app, this.mUin);
        if ((TextUtils.isEmpty(this.mNickname)) || (TextUtils.equals(this.mNickname, this.mUin)))
        {
          this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
          this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.DG(this.mUin);
        }
      }
    } while (this.mFromType != 3);
    this.cvS = true;
  }
  
  private void dEP()
  {
    TextView localTextView;
    int i;
    int j;
    if (!this.xv)
    {
      localTextView = (TextView)this.mHeaderView.findViewById(2131380976);
      i = (int)(getResources().getDisplayMetrics().widthPixels - (this.mDensity * 57.0F + 0.5F));
      if (this.mTextPaint == null) {
        this.mTextPaint = new TextPaint();
      }
      this.mTextPaint.setTextSize(this.mDensity * 28.0F);
      j = (int)(this.mTextPaint.measureText("的标签") + 0.5F);
      str = this.mNickname;
      if (str == null) {
        localTextView.setText("ta的标签");
      }
    }
    else
    {
      return;
    }
    String str = TextUtils.ellipsize(str, this.mTextPaint, i - j, TextUtils.TruncateAt.END).toString();
    localTextView.setText(str + "的标签");
  }
  
  private void dEQ()
  {
    getSharedPreferences("personality_label" + this.mUin, 0).edit().putBoolean("tips_displayed", true).commit();
  }
  
  private void dER()
  {
    a("正在处理...", this.jdField_a_of_type_Arhz$a);
    ThreadManager.postImmediately(new PersonalityLabelGalleryActivity.4(this), null, true);
  }
  
  private void dES()
  {
    ((albz)this.app.getBusinessHandler(112)).fy(this.mUin, 1);
  }
  
  public static byte[] g(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt(paramInt);
    return localByteBuffer.array();
  }
  
  private void kC(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mListView.getChildCount())
      {
        b localb = (b)this.mListView.getChildAt(i).getTag();
        if ((localb != null) && (localb.XM == paramLong)) {
          localb.a.getAdapter().notifyDataSetChanged();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).show(getTitleBarHeight());
  }
  
  public void a(long paramLong, albi.a parama)
  {
    PersonalityLabelPhoto localPersonalityLabelPhoto = parama.a;
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState:" + localPersonalityLabelPhoto.uniseq + " state:" + parama.state + " progress:" + parama.progress);
    }
    if (parama.state == 4) {
      aw(paramLong, true);
    }
    int i = 0;
    Object localObject1;
    if (i < this.mListView.getChildCount())
    {
      localObject1 = (b)this.mListView.getChildAt(i).getTag();
      if ((localObject1 == null) || (((b)localObject1).XM != paramLong)) {}
    }
    for (;;)
    {
      if (localObject1 == null) {}
      label400:
      for (;;)
      {
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find holder");
        }
        i = 0;
        label164:
        Object localObject2;
        e locale;
        if (i < ((b)localObject1).a.getChildCount())
        {
          localObject2 = ((b)localObject1).a.getChildAt(i);
          locale = (e)((b)localObject1).a.getChildViewHolder((View)localObject2);
          if (locale == null)
          {
            localObject2 = null;
            label212:
            if ((localObject2 == null) || (!(localObject2 instanceof albi.a)) || (((albi.a)localObject2).a.uniseq != localPersonalityLabelPhoto.uniseq)) {
              break label365;
            }
          }
        }
        for (localObject1 = locale;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label400;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find childHolder");
          }
          a(parama, localPersonalityLabelPhoto, (e)localObject1);
          if (parama.state == 4)
          {
            this.cvR = true;
            ((e)localObject1).lw.setTag(2131373142, null);
            if (this.mSubHandler.hasMessages(0)) {
              this.mSubHandler.removeMessages(0);
            }
            parama = this.mSubHandler.obtainMessage(0, this.c);
            this.mSubHandler.sendMessageDelayed(parama, 200L);
            return;
            localObject2 = locale.lw.getTag(2131373142);
            break label212;
            label365:
            i += 1;
            break label164;
          }
          if (parama.state != 3) {
            break;
          }
          QQToast.a(this, 0, "上传图片失败", 0).show();
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  void a(albi.a parama, PersonalityLabelPhoto paramPersonalityLabelPhoto, e parame)
  {
    int j = 1;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label bindProgressState id:" + paramPersonalityLabelPhoto.fileId + " key:" + paramPersonalityLabelPhoto.uniseq + " item:" + parama);
    }
    if (!paramPersonalityLabelPhoto.local)
    {
      if (parame.c != null)
      {
        parame.lw.removeView(parame.c);
        parame.c = null;
      }
      if (parame.CB.getVisibility() != 8) {
        parame.CB.setVisibility(8);
      }
    }
    do
    {
      return;
      paramPersonalityLabelPhoto = Long.toString(paramPersonalityLabelPhoto.uniseq);
      if (parama != null) {
        break;
      }
      if (parame.c != null)
      {
        parame.c.bind(paramPersonalityLabelPhoto);
        parame.c.Wt(paramPersonalityLabelPhoto);
        parame.lw.removeView(parame.c);
        parame.c = null;
      }
    } while (parame.CB.getVisibility() == 8);
    parame.CB.setVisibility(8);
    return;
    switch (parama.state)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
      if (parame.c == null)
      {
        MessageProgressView localMessageProgressView = new MessageProgressView(this);
        localMessageProgressView.setRadius(this.mDensity * 2.0F, false);
        localMessageProgressView.setCustomSize(1);
        localMessageProgressView.setShowCorner(false);
        localMessageProgressView.setProgressBackgroudColor(2130706432);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.mDensity * 120.0F), (int)(this.mDensity * 120.0F));
        parame.lw.addView(localMessageProgressView, localLayoutParams);
        parame.c = localMessageProgressView;
      }
      parame.c.bind(paramPersonalityLabelPhoto);
      if (parama.state != 2)
      {
        parame.c.setDrawStatus(1);
        parame.c.setAnimProgress(0, paramPersonalityLabelPhoto);
      }
      while (parame.CB.getVisibility() != 8)
      {
        parame.CB.setVisibility(8);
        return;
        parame.c.setDrawStatus(1);
        parame.c.setAnimProgress(parama.progress, paramPersonalityLabelPhoto);
      }
    }
    if (parame.c != null)
    {
      parame.c.bind(paramPersonalityLabelPhoto);
      if ((parama.state == 3) || (!parame.c.sd(paramPersonalityLabelPhoto)))
      {
        parame.c.Wt(paramPersonalityLabelPhoto);
        parame.lw.removeView(parame.c);
        parame.c = null;
      }
    }
    else
    {
      label458:
      if (parama.state != 3) {
        break label536;
      }
      i = 1;
      label469:
      if (parame.CB.getVisibility() != 0) {
        break label542;
      }
      label479:
      if (i == j) {
        break label546;
      }
      parama = parame.CB;
      if (i == 0) {
        break label548;
      }
    }
    label536:
    label542:
    label546:
    label548:
    for (int i = k;; i = 8)
    {
      parama.setVisibility(i);
      return;
      if (parama.state != 4) {
        break label458;
      }
      parame.c.setDrawStatus(1);
      parame.c.setAnimProgress(100, paramPersonalityLabelPhoto);
      break label458;
      i = 0;
      break label469;
      j = 0;
      break label479;
      break;
    }
  }
  
  boolean a(int paramInt, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    return (this.xv) && (!this.cvT) && (this.cvU) && (paramInt == 0);
  }
  
  public boolean atl()
  {
    return (this.c != null) && (this.c.getSize() > 0);
  }
  
  public void aw(long paramLong, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    Object localObject;
    boolean bool;
    if (this.gz.get(Long.valueOf(paramLong)) != null)
    {
      localObject = this.gA.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label199;
      }
      if (((Integer)localObject).intValue() != 1) {
        break label135;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "updateCookieIndex labelId:" + paramLong + " add:" + paramBoolean + " completed:" + bool);
      }
      localObject = (byte[])this.gz.get(Long.valueOf(paramLong));
      if ((bool) || (localObject.length <= 0))
      {
        return;
        label135:
        bool = false;
      }
      else
      {
        int k = byteArrayToInt((byte[])localObject);
        if (paramBoolean)
        {
          i = k + i;
          if (i >= 0) {
            break label196;
          }
          i = j;
        }
        label196:
        for (;;)
        {
          localObject = g(i);
          this.gz.put(Long.valueOf(paramLong), localObject);
          return;
          i = -1;
          break;
        }
        label199:
        bool = false;
      }
    }
  }
  
  public void b(PersonalityLabel paramPersonalityLabel, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI " + paramBoolean + " label:" + paramPersonalityLabel);
    }
    if (paramPersonalityLabel == null) {}
    Object localObject;
    int i;
    label161:
    do
    {
      return;
      if ((!this.xv) && (paramPersonalityLabel.isCloseByUser == 1))
      {
        paramPersonalityLabel.personalityLabelInfos.clear();
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI guest isCloseByUser=true");
        }
      }
      this.c = paramPersonalityLabel;
      c(paramPersonalityLabel);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c.notifyDataSetChanged();
      b(paramPersonalityLabel);
      if (this.mEmptyView != null) {
        this.mListView.setEmptyView(this.mEmptyView);
      }
      dEO();
      localObject = this.xR;
      if ((!this.xv) || (this.cvT) || (!atl())) {
        break;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
    } while (!paramBoolean);
    x(8, "", false);
    label235:
    label237:
    ConcurrentHashMap localConcurrentHashMap;
    long l;
    if (paramPersonalityLabel.unreadCount > 0)
    {
      this.TU.setText(String.format(albf.bVh, new Object[] { Integer.valueOf(paramPersonalityLabel.unreadCount) }));
      this.TU.setOnClickListener(new albo(this));
      SF(0);
      i = 0;
      if (i < this.c.getSize())
      {
        localObject = (PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(i);
        localConcurrentHashMap = this.gA;
        l = ((PersonalityLabelInfo)localObject).id;
        if (!((PersonalityLabelInfo)localObject).isComplete()) {
          break label325;
        }
      }
    }
    label325:
    for (int j = 1;; j = 0)
    {
      localConcurrentHashMap.put(Long.valueOf(l), Integer.valueOf(j));
      i += 1;
      break label237;
      break;
      i = 8;
      break label161;
      SF(8);
      break label235;
    }
  }
  
  public void c(View paramView, long paramLong)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramView.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new albt(this, localValueAnimator, paramView));
    localValueAnimator.addListener(new albk(this, paramLong));
    localValueAnimator.start();
  }
  
  void dEO()
  {
    int i = 0;
    if (this.xv)
    {
      if (this.cvT) {
        break label67;
      }
      setRightButton(2131721064, this);
      this.leftView.setVisibility(0);
      localTextView = this.rightViewText;
      if (!atl()) {
        break label87;
      }
    }
    for (;;)
    {
      localTextView.setVisibility(i);
      if (!this.cvT) {
        break label93;
      }
      this.mDesc.setText(2131701497);
      return;
      label67:
      setRightButton(2131721066, this);
      this.leftView.setVisibility(8);
      break;
      label87:
      i = 8;
    }
    label93:
    TextView localTextView = this.mDesc;
    if (this.xv) {}
    for (i = 2131701496;; i = 2131701498)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  void dET()
  {
    this.mListView.setSelection(0);
    int k = (int)(87.0F * this.mDensity);
    int j = this.mListView.getChildCount() - 1;
    int i = 0;
    Object localObject1;
    View localView;
    Object localObject2;
    boolean bool;
    if (j >= 0)
    {
      localObject1 = this.mListView.getChildAt(j).getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof b))) {
        break label224;
      }
      localObject1 = (b)localObject1;
      localView = ((b)localObject1).container;
      localObject2 = localView.getTag();
      if (localObject2 == null)
      {
        bool = false;
        label89:
        if (bool) {
          break label114;
        }
      }
    }
    label224:
    for (;;)
    {
      j -= 1;
      break;
      bool = ((Boolean)localObject2).booleanValue();
      break label89;
      label114:
      localObject2 = ValueAnimator.ofInt(new int[] { 0, k });
      ((ValueAnimator)localObject2).setInterpolator(new DecelerateInterpolator(1.0F));
      ((ValueAnimator)localObject2).addUpdateListener(new albr(this, (ValueAnimator)localObject2, localView));
      ((ValueAnimator)localObject2).addListener(new albs(this, (b)localObject1, localView));
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).setStartDelay(i);
      ((ValueAnimator)localObject2).start();
      this.bs.remove(Long.valueOf(((b)localObject1).XM));
      i += 150;
      continue;
      return;
    }
  }
  
  void dEU()
  {
    int i = 0;
    for (;;)
    {
      View localView;
      ImageView localImageView;
      if (i < this.mListView.getChildCount())
      {
        localView = this.mListView.getChildAt(i);
        localObject = localView.getTag();
        if ((localObject == null) || (!(localObject instanceof b))) {
          break label129;
        }
        localImageView = ((b)localObject).Cy;
        if (localImageView != null) {}
      }
      else
      {
        return;
      }
      ObjectAnimator localObjectAnimator = (ObjectAnimator)localView.getTag(2131362231);
      Object localObject = localObjectAnimator;
      if (localObjectAnimator == null)
      {
        localObject = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 45.0F });
        ((ObjectAnimator)localObject).setDuration(100L);
        ((ObjectAnimator)localObject).addListener(new albl(this, (ObjectAnimator)localObject));
        localView.setTag(2131362231, localObject);
      }
      ((ObjectAnimator)localObject).start();
      label129:
      i += 1;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
      } while ((paramIntent == null) || (paramIntent.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "pick photo from qzone size:" + paramIntent.size());
      }
    } while (this.aga <= 0L);
    this.cJ.clear();
    this.cJ.addAll(paramIntent);
    this.drt = 0;
    if (aqiw.isNetworkAvailable(getApplicationContext()))
    {
      this.cvW = false;
      dER();
      return;
    }
    QQToast.a(getApplicationContext(), 0, 2131696270, 0).show();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561529);
    dE(getIntent());
    this.xv = this.app.getCurrentAccountUin().equals(this.mUin);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.card.modify_personality_label");
    paramBundle.setPriority(2147483647);
    registerReceiver(this.bx, paramBundle);
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mListView = ((XListView)findViewById(2131370573));
    this.mHeaderView = getLayoutInflater().inflate(2131561530, this.mListView, false);
    this.mListView.addHeaderView(this.mHeaderView);
    this.J = ((ViewStub)findViewById(2131366447));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c = new c(null);
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c);
    this.xR = findViewById(2131363629);
    this.G = ((Button)findViewById(2131378178));
    this.gW = ((Button)findViewById(2131362221));
    this.G.setOnClickListener(this);
    this.gW.setOnClickListener(this);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    addObserver(this.jdField_b_of_type_Alcb);
    dEP();
    this.mDesc = ((TextView)this.mHeaderView.findViewById(2131380646));
    this.TU = ((TextView)this.mHeaderView.findViewById(2131381009));
    if (this.xv) {
      if (getSharedPreferences("personality_label" + this.mUin, 0).getBoolean("tips_displayed", false)) {
        break label428;
      }
    }
    label428:
    for (boolean bool = true;; bool = false)
    {
      this.cvU = bool;
      if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
        ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      }
      this.jdField_a_of_type_Albi = ((albi)this.app.getManager(230));
      if (this.xv) {
        this.jdField_a_of_type_Albi.a(this);
      }
      x(0, "正在加载...", true);
      this.mSubHandler.sendEmptyMessage(1);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    aqis.a().edT();
    this.jdField_a_of_type_Albi.a(null);
    this.mSubHandler.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_b_of_type_Alcb);
    unregisterReceiver(this.bx);
    removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "select photos from phone album : size = " + localArrayList.size());
      }
      this.aga = paramIntent.getLongExtra("label_id", 0L);
      if (this.aga > 0L)
      {
        this.cJ.clear();
        this.cJ.addAll(localArrayList);
        this.drt = 0;
        if (!aqiw.isNetworkAvailable(getApplicationContext())) {
          break label126;
        }
        this.cvW = false;
        dER();
      }
    }
    return;
    label126:
    QQToast.a(getApplicationContext(), 0, 2131696270, 0).show();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    initTitle();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.cvV)
    {
      this.cvU = false;
      dEQ();
      if (this.mUIHandler.hasMessages(2)) {
        this.mUIHandler.removeMessages(2);
      }
      this.mUIHandler.sendEmptyMessage(2);
    }
  }
  
  public void e(List<PersonalityLabelPhoto> paramList, long paramLong)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)this.gy.get(Long.valueOf(paramLong));
    if (localPersonalityLabelInfo == null) {
      return;
    }
    localPersonalityLabelInfo.personalityLabelPhotos.addAll(0, paramList);
    localPersonalityLabelInfo.photoCount += paramList.size();
    a(paramLong, localPersonalityLabelInfo);
    if (this.mSubHandler.hasMessages(0)) {
      this.mSubHandler.removeMessages(0);
    }
    paramList = this.mSubHandler.obtainMessage(0, this.c);
    this.mSubHandler.sendMessageDelayed(paramList, 200L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = (PersonalityLabel)paramMessage.obj;
      if (this.xv) {}
      for (paramMessage = this.app.getCurrentAccountUin();; paramMessage = this.mUin)
      {
        aqhq.y("profile_personality_v1.2_" + paramMessage, localObject);
        return false;
      }
      if (this.mFromType == 3) {
        paramMessage = null;
      }
      while ((paramMessage != null) && (paramMessage.getSize() > 0))
      {
        int i = 0;
        while (i < paramMessage.personalityLabelInfos.size())
        {
          localObject = (PersonalityLabelInfo)paramMessage.personalityLabelInfos.get(i);
          this.jdField_a_of_type_Albi.a(((PersonalityLabelInfo)localObject).id, (PersonalityLabelInfo)localObject, false);
          i += 1;
        }
        paramMessage = (PersonalityLabel)aqhq.o("profile_personality_v1.2_" + this.mUin);
        if ((paramMessage != null) && (paramMessage.unreadCount > 0))
        {
          paramMessage.praiseCount += paramMessage.unreadCount;
          paramMessage.unreadCount = 0;
        }
      }
      runOnUiThread(new PersonalityLabelGalleryActivity.1(this, paramMessage));
      return false;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$c.notifyDataSetChanged();
    } while (paramMessage.arg1 != 1);
    this.mListView.setSelection(0);
    return false;
  }
  
  void initTitle()
  {
    setLeftViewName(2131690700);
    if (!this.xv) {
      this.rightViewText.setVisibility(8);
    }
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.cvT)
    {
      NC(true);
      return true;
    }
    Object localObject;
    Bundle localBundle;
    if (this.cvR)
    {
      if (this.mFromType != 3) {
        break label160;
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("com.tencent.mobileqq.card.modify_personality_label");
      localBundle = new Bundle();
      localBundle.putBoolean("onTagChanged", true);
      ((Intent)localObject).putExtra("key_bundle_data", localBundle);
      sendBroadcast((Intent)localObject);
    }
    for (;;)
    {
      if ((this.mFromType == 4) && (this.mUin != null) && (this.mUin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new ProfileActivity.AllInOne(this.mUin, 0);
        localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (ProfileActivity.AllInOne)localObject, localBundle);
        overridePendingTransition(2130772000, 2130772001);
      }
      return super.onBackEvent();
      label160:
      setResult(-1);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.G) && (this.c != null)) {
      if (this.c != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, PersonalityLabelShareActivity.class);
      localIntent.putExtra("data", this.c);
      startActivity(localIntent);
      anot.a(this.app, "dc00898", "", "", "0X8007FD4", "0X8007FD4", 0, 0, "0", "0", "", "");
      continue;
      if ((paramView == this.gW) || (2131366399 == paramView.getId()))
      {
        anot.a(this.app, "dc00898", "", "", "0X8007FD3", "0X8007FD3", 0, 0, "0", "0", "", "");
        if ((this.c != null) && (this.c.remainCount <= 0))
        {
          if (this.g == null) {
            this.g = QQToast.a(this, "最多只能添加10个标签。", 0);
          }
          if (!this.g.isShowing()) {
            this.g.show(getTitleBarHeight());
          }
        }
        else
        {
          aqep.a(this.app.getCurrentAccountUin(), this.app, this, false);
        }
      }
      else if (paramView == this.rightViewText)
      {
        NC(true);
      }
    }
  }
  
  public void x(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.ht == null) {
      this.ht = ((TextView)findViewById(2131370787));
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.ht.getText()))) {
      this.ht.setText(paramString);
    }
    if (paramInt != this.ht.getVisibility()) {
      this.ht.setVisibility(paramInt);
    }
    if (paramBoolean) {
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    while (!isTitleProgressShowing()) {
      return;
    }
    stopTitleProgress();
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    private final int drv = (int)(3.0F * PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this));
    
    private a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.right = this.drv;
    }
  }
  
  public static class b
  {
    public ImageView Cx;
    public ImageView Cy;
    public ImageView Cz;
    public View FM;
    public View FN;
    View FO;
    public long XM;
    public TextView Xd;
    public TextView Xe;
    public GlowCountRecyclerView a;
    View container;
    public ImageView dy;
    public View itemView;
  }
  
  public class c
    extends BaseAdapter
    implements View.OnClickListener
  {
    private c() {}
    
    private void a(PersonalityLabelGalleryActivity.b paramb, PersonalityLabelInfo paramPersonalityLabelInfo)
    {
      if (PersonalityLabelGalleryActivity.this.cvT)
      {
        if (paramb.Cx.getVisibility() != 8) {
          paramb.Cx.setVisibility(8);
        }
        if (paramb.Cy.getVisibility() != 0) {
          paramb.Cy.setVisibility(0);
        }
        if (paramb.Cz.getVisibility() != 8) {
          paramb.Cz.setVisibility(8);
        }
        if (paramb.dy.getVisibility() != 0) {
          paramb.dy.setVisibility(0);
        }
        paramb.FN.setTag(paramPersonalityLabelInfo);
        paramb.FN.setOnClickListener(this);
        paramb.FN.setTag(2131362230, Integer.valueOf(4));
        paramb.FN.setTag(2131365679, paramb);
        paramb = paramb.Cy;
        if (!PersonalityLabelGalleryActivity.this.cvT) {
          break label384;
        }
      }
      label384:
      for (int i = 2130846573;; i = 2130846565)
      {
        paramb.setImageResource(i);
        return;
        if (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this))
        {
          if (paramb.Cx.getVisibility() != 0) {
            paramb.Cx.setVisibility(0);
          }
          if (paramb.Cy.getVisibility() != 0) {
            paramb.Cy.setVisibility(0);
          }
          if (paramb.Cz.getVisibility() != 8) {
            paramb.Cz.setVisibility(8);
          }
          if (paramb.dy.getVisibility() != 8) {
            paramb.dy.setVisibility(8);
          }
          paramb.FN.setTag(paramPersonalityLabelInfo);
          paramb.FN.setOnClickListener(this);
          paramb.FN.setTag(2131362230, Integer.valueOf(1));
          break;
        }
        if (paramb.Cx.getVisibility() != 8) {
          paramb.Cx.setVisibility(8);
        }
        if (paramb.Cy.getVisibility() != 8) {
          paramb.Cy.setVisibility(8);
        }
        if (paramb.Cz.getVisibility() != 0) {
          paramb.Cz.setVisibility(0);
        }
        if (paramb.dy.getVisibility() != 8) {
          paramb.dy.setVisibility(8);
        }
        paramb.FN.setTag(paramPersonalityLabelInfo);
        paramb.FN.setOnClickListener(this);
        paramb.FN.setTag(2131362230, Integer.valueOf(3));
        break;
      }
    }
    
    private void a(PersonalityLabelInfo paramPersonalityLabelInfo)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(PersonalityLabelGalleryActivity.this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 48);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PersonalityLabelGalleryActivity.this.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      localIntent.putExtra("label_id", paramPersonalityLabelInfo.id);
      PersonalityLabelGalleryActivity.this.startActivity(localIntent);
      aqfy.anim(PersonalityLabelGalleryActivity.this, false, true);
    }
    
    void a(PersonalityLabelInfo paramPersonalityLabelInfo, PersonalityLabelGalleryActivity.b paramb)
    {
      String str = paramb.Xe.getText().toString();
      if (paramPersonalityLabelInfo.praiseCount > 0L)
      {
        if (PersonalityLabelGalleryActivity.this.dru <= 0) {
          PersonalityLabelGalleryActivity.this.dru = ((int)(PersonalityLabelGalleryActivity.this.getResources().getDisplayMetrics().widthPixels - 95.0F * PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this)));
        }
        if (PersonalityLabelGalleryActivity.this.mTextPaint == null) {
          PersonalityLabelGalleryActivity.this.mTextPaint = new TextPaint();
        }
        PersonalityLabelGalleryActivity.this.mTextPaint.setTextSize(PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this) * 14.0F);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramPersonalityLabelInfo.praiseCount);
        localStringBuilder1.insert(0, "共").append("个赞");
        int j = (int)(PersonalityLabelGalleryActivity.this.mTextPaint.measureText(localStringBuilder1.toString()) + 0.5F);
        StringBuilder localStringBuilder2 = new StringBuilder();
        int i = 0;
        if (i < paramPersonalityLabelInfo.zanUins.size())
        {
          localStringBuilder2.append(((PersonalityLabelZan)paramPersonalityLabelInfo.zanUins.get(i)).nick);
          if (i == paramPersonalityLabelInfo.zanUins.size() - 1) {
            localStringBuilder2.append("，");
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder2.append("、");
          }
        }
        paramPersonalityLabelInfo = TextUtils.ellipsize(localStringBuilder2.toString(), PersonalityLabelGalleryActivity.this.mTextPaint, PersonalityLabelGalleryActivity.this.dru - j, TextUtils.TruncateAt.END).toString();
        paramPersonalityLabelInfo = paramPersonalityLabelInfo + localStringBuilder1.toString();
        if (!TextUtils.equals(paramPersonalityLabelInfo, str)) {
          paramb.Xe.setText(paramPersonalityLabelInfo);
        }
        paramPersonalityLabelInfo = paramb.Xe;
        if (!PersonalityLabelGalleryActivity.this.cvT) {
          break label371;
        }
      }
      label371:
      for (float f = 0.5F;; f = 1.0F)
      {
        paramPersonalityLabelInfo.setAlpha(f);
        return;
        paramPersonalityLabelInfo = PersonalityLabelGalleryActivity.this.getResources().getString(2131701514);
        break;
      }
    }
    
    public void b(PersonalityLabelInfo paramPersonalityLabelInfo)
    {
      avpw.d locald = avpw.d.a();
      locald.cMP = PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin();
      locald.nickname = PersonalityLabelGalleryActivity.this.app.getCurrentNickname();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_title", PersonalityLabelGalleryActivity.this.getString(2131718034));
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putBoolean("key_multiple_model_need_download_img", true);
      localBundle.putInt("_input_max", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
      localBundle.putBoolean("show_album", false);
      localBundle.putBoolean("key_need_change_to_jpg", true);
      avpw.a(PersonalityLabelGalleryActivity.this, locald, localBundle, 1);
    }
    
    public int getCount()
    {
      if ((PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this) != null) && (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).personalityLabelInfos != null)) {
        return PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).personalityLabelInfos.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this) != null) && (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).personalityLabelInfos != null)) {
        return PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).personalityLabelInfos.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      PersonalityLabelGalleryActivity.b localb;
      Object localObject1;
      if (paramView == null)
      {
        paramView = PersonalityLabelGalleryActivity.this.getLayoutInflater().inflate(2131561528, paramViewGroup, false);
        localb = new PersonalityLabelGalleryActivity.b(null);
        localb.FM = paramView.findViewById(2131368258);
        localb.Xd = ((TextView)paramView.findViewById(2131370120));
        localb.FN = paramView.findViewById(2131363020);
        localb.Cx = ((ImageView)paramView.findViewById(2131362230));
        localb.Cy = ((ImageView)paramView.findViewById(2131362231));
        localb.dy = ((ImageView)paramView.findViewById(2131365679));
        localb.Cz = ((ImageView)paramView.findViewById(2131382428));
        localb.a = ((GlowCountRecyclerView)paramView.findViewById(2131376994));
        localb.Xe = ((TextView)paramView.findViewById(2131382430));
        localb.FO = paramView.findViewById(2131379755);
        localb.container = paramView.findViewById(2131365322);
        localb.FO.setOnClickListener(this);
        localb.FO.setTag(2131362230, Integer.valueOf(5));
        if (!PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this)) {
          localb.Xe.setTextColor(Color.parseColor("#777777"));
        }
        localb.a.setTextSizeDp(12);
        localObject1 = new PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this, null);
        localb.a.addItemDecoration((RecyclerView.ItemDecoration)localObject1);
        paramView.setTag(localb);
      }
      for (;;)
      {
        localb.itemView = paramView;
        localObject1 = (PersonalityLabelInfo)getItem(paramInt);
        if (localObject1 != null) {
          break;
        }
        QLog.d("PersonalityLabelGalleryActivity", 1, "getView labelInfo == null");
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localb = (PersonalityLabelGalleryActivity.b)paramView.getTag();
      }
      localb.XM = ((PersonalityLabelInfo)localObject1).id;
      Object localObject2 = (Integer)localb.FM.getTag(2131370120);
      if ((localObject2 == null) || (((Integer)localObject2).intValue() != ((PersonalityLabelInfo)localObject1).bgColor))
      {
        localb.FM.setBackgroundDrawable(new ColorDrawable(((PersonalityLabelInfo)localObject1).bgColor));
        localb.Xd.setTextColor(((PersonalityLabelInfo)localObject1).bgColor);
        localb.FM.setTag(2131370120, Integer.valueOf(((PersonalityLabelInfo)localObject1).bgColor));
      }
      if (!localb.Xd.getText().equals(((PersonalityLabelInfo)localObject1).text)) {
        localb.Xd.setText(((PersonalityLabelInfo)localObject1).text);
      }
      a(localb, (PersonalityLabelInfo)localObject1);
      localb.FN.setTag(2131382430, localb);
      label508:
      boolean bool2;
      boolean bool1;
      if (!PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this))
      {
        if (((PersonalityLabelInfo)localObject1).praiseFlag > 0) {
          localb.Cz.setImageResource(2130846594);
        }
      }
      else
      {
        if (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this))
        {
          localb.Xe.setOnClickListener(this);
          localb.Xe.setTag(localObject1);
          localb.Xe.setTag(2131362230, Integer.valueOf(2));
        }
        a((PersonalityLabelInfo)localObject1, localb);
        bool2 = PersonalityLabelGalleryActivity.this.a(paramInt, (PersonalityLabelInfo)localObject1);
        if ((paramInt == 0) && (bool2)) {
          PersonalityLabelGalleryActivity.this.cvV = true;
        }
        if (localb.FO.getVisibility() != 0) {
          break label927;
        }
        bool1 = true;
        label602:
        if (bool2 != bool1)
        {
          localObject2 = localb.FO;
          if (!bool2) {
            break label933;
          }
          i = 0;
          label624:
          ((View)localObject2).setVisibility(i);
        }
        localObject2 = new StaggeredGridLayoutManager(1, 0);
        localb.a.setLayoutManager((RecyclerView.LayoutManager)localObject2);
        localb.a.setAdapter(new PersonalityLabelGalleryActivity.d(PersonalityLabelGalleryActivity.this, ((PersonalityLabelInfo)localObject1).id));
        localb.a.setText(((PersonalityLabelInfo)localObject1).photoCount + "张");
        if (PersonalityLabelGalleryActivity.this.a != null) {
          PersonalityLabelGalleryActivity.this.a.bS(localb.a);
        }
        if ((((PersonalityLabelInfo)localObject1).personalityLabelPhotos == null) || (((PersonalityLabelInfo)localObject1).personalityLabelPhotos.size() <= 0)) {
          break label940;
        }
        localb.a.setVisibility(0);
        localb.a.setOnScrollListener(new albu(this, (PersonalityLabelInfo)localObject1));
        label781:
        localObject2 = localb.container.getTag();
        if (localObject2 != null) {
          break label953;
        }
        bool1 = false;
        label799:
        bool2 = PersonalityLabelGalleryActivity.this.bs.contains(Long.valueOf(((PersonalityLabelInfo)localObject1).id));
        if (bool2 != bool1)
        {
          localObject1 = (FrameLayout.LayoutParams)localb.container.getLayoutParams();
          if (!bool2) {
            break label966;
          }
        }
      }
      label927:
      label933:
      label940:
      label953:
      label966:
      for (int i = j;; i = -2)
      {
        ((FrameLayout.LayoutParams)localObject1).height = i;
        localb.container.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localb.container.setTag(Boolean.valueOf(bool2));
        if (PersonalityLabelGalleryActivity.this.bs.size() > 0) {
          PersonalityLabelGalleryActivity.this.mUIHandler.post(new PersonalityLabelGalleryActivity.ListViewAdapter.2(this));
        }
        break;
        localb.Cz.setImageResource(2130846582);
        break label508;
        bool1 = false;
        break label602;
        i = 8;
        break label624;
        localb.a.setVisibility(8);
        break label781;
        bool1 = ((Boolean)localObject2).booleanValue();
        break label799;
      }
    }
    
    public void onClick(View paramView)
    {
      Object localObject1 = paramView.getTag(2131362230);
      int i;
      Object localObject2;
      if ((localObject1 != null) && ((localObject1 instanceof Integer)))
      {
        i = ((Integer)localObject1).intValue();
        if (i != 1) {
          break label206;
        }
        if (PersonalityLabelGalleryActivity.this.cvU)
        {
          PersonalityLabelGalleryActivity.this.cvU = false;
          PersonalityLabelGalleryActivity.c(PersonalityLabelGalleryActivity.this);
          if (PersonalityLabelGalleryActivity.this.mUIHandler.hasMessages(2)) {
            PersonalityLabelGalleryActivity.this.mUIHandler.removeMessages(2);
          }
          PersonalityLabelGalleryActivity.this.mUIHandler.sendEmptyMessage(2);
        }
        localObject1 = (PersonalityLabelInfo)paramView.getTag();
        if (localObject1 != null)
        {
          localObject2 = ausj.b(paramView.getContext());
          ((ausj)localObject2).addButton("从手机相册选择");
          ((ausj)localObject2).addButton("从空间相册选择");
          ((ausj)localObject2).addCancelButton("取消");
          ((ausj)localObject2).a(new albv(this, (PersonalityLabelInfo)localObject1, (ausj)localObject2));
          ((ausj)localObject2).show();
          anot.a(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD2", "0X8007FD2", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label206:
        if (i != 2) {
          break;
        }
        if (!PersonalityLabelGalleryActivity.this.cvT)
        {
          localObject1 = (PersonalityLabelInfo)paramView.getTag();
          localObject2 = new Intent(PersonalityLabelGalleryActivity.this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/labzan?_wv=1027&labelId=" + ((PersonalityLabelInfo)localObject1).id);
          PersonalityLabelGalleryActivity.this.startActivity((Intent)localObject2);
        }
      }
      PersonalityLabelInfo localPersonalityLabelInfo;
      if (i == 3)
      {
        localPersonalityLabelInfo = (PersonalityLabelInfo)paramView.getTag();
        if (localPersonalityLabelInfo.praiseFlag <= 0)
        {
          ((albz)PersonalityLabelGalleryActivity.this.app.getBusinessHandler(112)).ax(PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this), localPersonalityLabelInfo.id);
          localPersonalityLabelInfo.praiseFlag = 1;
          localPersonalityLabelInfo.praiseCount += 1L;
          localObject2 = null;
          localObject1 = null;
          i = localPersonalityLabelInfo.zanUins.size();
          if (i > 0)
          {
            i -= 1;
            label381:
            localObject2 = localObject1;
            if (i >= 0)
            {
              if (((PersonalityLabelZan)localPersonalityLabelInfo.zanUins.get(i)).uin != Long.valueOf(PersonalityLabelGalleryActivity.this.getCurrentAccountUin()).longValue()) {
                break label863;
              }
              localObject1 = (PersonalityLabelZan)localPersonalityLabelInfo.zanUins.remove(i);
            }
          }
        }
      }
      label863:
      for (;;)
      {
        i -= 1;
        break label381;
        PersonalityLabelZan localPersonalityLabelZan = new PersonalityLabelZan();
        localPersonalityLabelZan.uin = Long.valueOf(PersonalityLabelGalleryActivity.this.getCurrentAccountUin()).longValue();
        if (localObject2 != null) {}
        for (localObject1 = ((PersonalityLabelZan)localObject2).nick;; localObject1 = aqgv.s(PersonalityLabelGalleryActivity.this.app, PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin()))
        {
          localPersonalityLabelZan.nick = ((String)localObject1);
          localPersonalityLabelInfo.zanUins.add(0, localPersonalityLabelZan);
          a(localPersonalityLabelInfo, (PersonalityLabelGalleryActivity.b)paramView.getTag(2131382430));
          ((ImageView)paramView.findViewById(2131382428)).setImageResource(2130846594);
          PersonalityLabelGalleryActivity.b(PersonalityLabelGalleryActivity.this, true);
          if (PersonalityLabelGalleryActivity.this.mSubHandler.hasMessages(0)) {
            PersonalityLabelGalleryActivity.this.mSubHandler.removeMessages(0);
          }
          localObject1 = PersonalityLabelGalleryActivity.this.mSubHandler.obtainMessage(0, PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this));
          PersonalityLabelGalleryActivity.this.mSubHandler.sendMessageDelayed((Message)localObject1, 500L);
          anot.a(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD0", "0X8007FD0", 0, 0, "", "", "", "");
          break;
        }
        if (PersonalityLabelGalleryActivity.this.f == null) {
          PersonalityLabelGalleryActivity.this.f = QQToast.a(PersonalityLabelGalleryActivity.this, "每个标签每天只能点一个赞哦。", 0);
        }
        if (PersonalityLabelGalleryActivity.this.f.isShowing()) {
          break;
        }
        PersonalityLabelGalleryActivity.this.f.show(PersonalityLabelGalleryActivity.this.getTitleBarHeight());
        break;
        if (i == 4)
        {
          localObject2 = (PersonalityLabelInfo)paramView.getTag();
          i = ((PersonalityLabelInfo)localObject2).photoCount;
          if (i > 0) {}
          for (localObject1 = String.format("确认删除标签 “%s”，其中包含%d张照片？", new Object[] { ((PersonalityLabelInfo)localObject2).text, Integer.valueOf(i) });; localObject1 = String.format("确认删除标签 “%s”？", new Object[] { ((PersonalityLabelInfo)localObject2).text }))
          {
            aqha.a(PersonalityLabelGalleryActivity.this, (String)localObject1, 2131721058, 2131693962, new albw(this, paramView, (PersonalityLabelInfo)localObject2), new albx(this)).show();
            break;
          }
        }
        if (i != 5) {
          break;
        }
        PersonalityLabelGalleryActivity.c(PersonalityLabelGalleryActivity.this);
        paramView.setVisibility(8);
        PersonalityLabelGalleryActivity.this.cvU = false;
        break;
      }
    }
  }
  
  public class d
    extends RecyclerView.Adapter<PersonalityLabelGalleryActivity.e>
    implements View.OnClickListener
  {
    private int Cc = (int)(120.0F * PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this));
    private long agb;
    
    public d(long paramLong)
    {
      this.agb = paramLong;
    }
    
    public PersonalityLabelGalleryActivity.e a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561531, paramViewGroup, false);
      return new PersonalityLabelGalleryActivity.e(PersonalityLabelGalleryActivity.this, paramViewGroup);
    }
    
    public void a(PersonalityLabelGalleryActivity.e parame, int paramInt)
    {
      PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).get(Long.valueOf(this.agb));
      if (PersonalityLabelGalleryActivity.this.mDefaultDrawable == null) {
        PersonalityLabelGalleryActivity.this.mDefaultDrawable = PersonalityLabelGalleryActivity.this.getResources().getDrawable(2131165579);
      }
      Object localObject1 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).localThumbPath;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new File((String)localObject1);
      }
      for (;;)
      {
        try
        {
          localObject1 = new URL("file:///" + ((File)localObject1).getAbsolutePath());
          parame.CA.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, this.Cc, this.Cc, PersonalityLabelGalleryActivity.this.mDefaultDrawable, PersonalityLabelGalleryActivity.this.mDefaultDrawable));
          if (!PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this)) {
            break label418;
          }
          localObject1 = PersonalityLabelGalleryActivity.this.a.a(this.agb, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt));
          PersonalityLabelGalleryActivity.this.a((albi.a)localObject1, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt), parame);
          parame.lw.setTag(2131373142, localObject1);
          parame.lw.setTag(Integer.valueOf(paramInt));
          parame.lw.setOnClickListener(this);
          EventCollector.getInstance().onRecyclerBindViewHolder(parame, paramInt, getItemId(paramInt));
          return;
        }
        catch (MalformedURLException localMalformedURLException1)
        {
          localMalformedURLException1.printStackTrace();
          continue;
        }
        Object localObject2 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).get350SizeUrl();
        if ((((String)localObject2).startsWith("http")) || (((String)localObject2).startsWith("https")))
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, this.Cc, this.Cc, PersonalityLabelGalleryActivity.this.mDefaultDrawable, PersonalityLabelGalleryActivity.this.mDefaultDrawable);
          parame.CA.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = new File((String)localObject2);
          try
          {
            localObject2 = new URL("file:///" + ((File)localObject2).getAbsolutePath());
            parame.CA.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.Cc, this.Cc, PersonalityLabelGalleryActivity.this.mDefaultDrawable, PersonalityLabelGalleryActivity.this.mDefaultDrawable));
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            localMalformedURLException2.printStackTrace();
          }
          continue;
          label418:
          Object localObject3 = null;
        }
      }
    }
    
    public int getItemCount()
    {
      PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).get(Long.valueOf(this.agb));
      if ((localPersonalityLabelInfo != null) && (localPersonalityLabelInfo.personalityLabelPhotos != null)) {
        return localPersonalityLabelInfo.personalityLabelPhotos.size();
      }
      return 0;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public void onClick(View paramView)
    {
      if (PersonalityLabelGalleryActivity.this.cvT) {}
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (paramView.getId() == 2131373142)
          {
            localObject1 = paramView.getTag();
            localObject2 = paramView.getTag(2131373142);
            if ((localObject2 == null) || (!(localObject2 instanceof albi.a)) || (((albi.a)localObject2).state != 3)) {
              break;
            }
            localObject1 = (albi.a)localObject2;
            if (PersonalityLabelGalleryActivity.this.al == null)
            {
              PersonalityLabelGalleryActivity.this.al = ausj.b(paramView.getContext());
              PersonalityLabelGalleryActivity.this.al.addButton("重新上传");
              PersonalityLabelGalleryActivity.this.al.addButton("删除");
              PersonalityLabelGalleryActivity.this.al.addCancelButton("取消");
            }
            PersonalityLabelGalleryActivity.this.al.a(new alby(this, (albi.a)localObject1));
            PersonalityLabelGalleryActivity.this.al.show();
          }
        }
      } while ((localObject1 == null) || (!(localObject1 instanceof Integer)));
      int m = ((Integer)localObject1).intValue();
      Object localObject3 = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this).get(Long.valueOf(this.agb));
      Object localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = m;
      if (i < ((PersonalityLabelInfo)localObject3).personalityLabelPhotos.size())
      {
        PersonalityLabelPhoto localPersonalityLabelPhoto = (PersonalityLabelPhoto)((PersonalityLabelInfo)localObject3).personalityLabelPhotos.get(i);
        if (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this))
        {
          localObject1 = PersonalityLabelGalleryActivity.this.a.a(this.agb, localPersonalityLabelPhoto);
          label295:
          if ((localObject1 == null) || (((albi.a)localObject1).state != 3)) {
            break label339;
          }
          k = j;
          if (i >= m) {}
        }
        for (int k = j - 1;; k = j)
        {
          i += 1;
          j = k;
          break;
          localObject1 = null;
          break label295;
          label339:
          ((ArrayList)localObject2).add(localPersonalityLabelPhoto.getOriginUrl());
          localArrayList.add(String.valueOf(localPersonalityLabelPhoto.fileId));
        }
      }
      Object localObject1 = new Intent(PersonalityLabelGalleryActivity.this, TroopAvatarWallPreviewActivity.class);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("index", j);
      ((Bundle)localObject3).putStringArrayList("seqNum", (ArrayList)localObject2);
      ((Bundle)localObject3).putStringArrayList("photoIds", localArrayList);
      if (PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this))
      {
        bool = true;
        label437:
        ((Bundle)localObject3).putBoolean("delete_ability", bool);
        if (!PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this)) {
          break label611;
        }
      }
      label611:
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject3).putBoolean("SHOW_MENU", bool);
        ((Bundle)localObject3).putBoolean("IS_EDIT", false);
        ((Bundle)localObject3).putBoolean("is_use_path", true);
        ((Bundle)localObject3).putBoolean("is_show_action", false);
        ((Bundle)localObject3).putBoolean("is_not_show_index", false);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("from_personality_label", true);
        ((Bundle)localObject2).putLong("label_id", this.agb);
        ((Bundle)localObject3).putBundle("bundle_data_extra", (Bundle)localObject2);
        ((Intent)localObject1).putExtras((Bundle)localObject3);
        PersonalityLabelGalleryActivity.this.startActivity((Intent)localObject1);
        anot.a(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD1", "0X8007FD1", 0, 0, "", "", "", "");
        break;
        bool = false;
        break label437;
      }
    }
  }
  
  class e
    extends RecyclerView.ViewHolder
  {
    ImageView CA;
    ImageView CB;
    MessageProgressView c;
    RelativeLayout lw;
    
    public e(View paramView)
    {
      super();
      float f = 2.0F * PersonalityLabelGalleryActivity.a(PersonalityLabelGalleryActivity.this);
      this.lw = ((RelativeLayout)paramView.findViewById(2131373142));
      this.CA = ((ImageView)paramView.findViewById(2131373082));
      ((CornerImageView)this.CA).setRadius(f);
      ((CornerImageView)this.CA).setPressMask(true);
      this.CB = ((ImageView)paramView.findViewById(2131366690));
      ((CornerImageView)this.CB).setRadius(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity
 * JD-Core Version:    0.7.0.1
 */