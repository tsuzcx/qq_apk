package com.tencent.mobileqq.widget;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import argj;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public class PhotoWallView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, argj
{
  protected ImageView FE;
  protected ImageView FF;
  protected ImageView FG;
  protected View JA;
  protected View JB;
  protected View Jz;
  private CardHandler.d a;
  protected b a;
  protected ProfileCardNewPhotoWallView a;
  public TextView acc;
  public TextView acd;
  protected LinkedList<ProfilePhotoWall> ar = new LinkedList();
  protected c b;
  protected CardHandler c;
  protected int ehn;
  public Button hz;
  protected Activity mActivity;
  protected QQAppInterface mApp;
  protected View mContentView;
  protected View mEmptyView;
  protected Handler mHandler;
  protected LayoutInflater mInflater;
  protected TextView mMoreText;
  protected String mUin;
  protected ArrayList<ProfilePhotoWall> pk = new ArrayList();
  
  public PhotoWallView(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, b paramb)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$d = new a(this);
    this.mActivity = ((Activity)paramContext);
    this.mApp = paramQQAppInterface;
    this.mUin = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b = paramb;
    onInit();
  }
  
  private void aNi()
  {
    boolean bool1 = this.mApp.getCurrentAccountUin().equals(this.mUin);
    boolean bool2 = this.ar.isEmpty();
    if (bool1)
    {
      if (bool2)
      {
        this.mContentView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
        return;
      }
      this.mContentView.setVisibility(0);
      this.mEmptyView.setVisibility(8);
      return;
    }
    this.mEmptyView.setVisibility(8);
    if (bool2)
    {
      this.mContentView.setVisibility(8);
      return;
    }
    this.mContentView.setVisibility(0);
  }
  
  private void as(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.ar.clear();
      this.ar.addAll(paramMessage);
      if (this.pk.size() != 0) {
        f(this.ar, this.pk);
      }
      if (this.ar.size() > 9)
      {
        int i = this.ar.size() - 1;
        while (i >= 9)
        {
          this.ar.remove(i);
          i -= 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.ar, this.ar.size());
    }
  }
  
  public static void e(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    String str = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean) {
      str = "https://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + paramString;
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("url", str);
    if (!paramBoolean)
    {
      paramActivity.startActivity(paramString);
      return;
    }
    paramActivity.startActivityForResult(paramString, 1022);
  }
  
  public static List<ProfilePhotoWall> f(List<ProfilePhotoWall> paramList1, List<ProfilePhotoWall> paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int j = 0;
    int i = 0;
    label34:
    if (j < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(j);
      label56:
      if (i >= paramList1.size()) {
        break label123;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label116;
      }
      int k = i + 1;
      paramList1.add(i, localProfilePhotoWall1);
      i = k;
    }
    label116:
    label123:
    for (;;)
    {
      j += 1;
      break label34;
      break;
      i += 1;
      break label56;
    }
  }
  
  private void onInit()
  {
    this.mInflater = LayoutInflater.from(getContext());
    this.mHandler = new Handler(this);
    this.c = ((CardHandler)this.mApp.getBusinessHandler(2));
    this.mInflater.inflate(getLayout(), this, true);
    this.mContentView = findViewById(2131373196);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView = ((ProfileCardNewPhotoWallView)this.mContentView.findViewById(2131373205));
    this.Jz = this.mContentView.findViewById(2131373208);
    this.JA = this.mContentView.findViewById(2131373209);
    this.mMoreText = ((TextView)this.mContentView.findViewById(2131373210));
    this.mEmptyView = findViewById(2131373197);
    this.JB = findViewById(2131373198);
    this.FE = ((ImageView)findViewById(2131373199));
    this.FF = ((ImageView)findViewById(2131373200));
    this.FG = ((ImageView)findViewById(2131373201));
    this.acc = ((TextView)findViewById(2131373203));
    this.acd = ((TextView)findViewById(2131373202));
    this.hz = ((Button)this.mEmptyView.findViewById(2131373204));
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.mUin, this.mActivity, this.mApp);
    this.mMoreText.setOnClickListener(this);
    this.JB.setAlpha(0.15F);
    this.hz.setOnClickListener(this);
    if (this.mApp.getCurrentAccountUin().equals(this.mUin)) {
      this.mMoreText.setText(2131697269);
    }
    for (;;)
    {
      this.JA.setVisibility(8);
      ThreadManager.post(new PhotoWallView.1(this), 5, null, true);
      return;
      this.mMoreText.setText(2131697268);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, String paramString, ArrayList<PhotoWall> paramArrayList, List<ProfilePhotoWall> paramList)
  {
    if (this.b == null) {
      this.b = new c();
    }
    this.b.totalPic = paramInt1;
    this.b.hasMore = paramInt2;
    this.b.attachInfo = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.mUin;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.b.eho = paramList.size();
    }
  }
  
  public void b(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (!paramBoolean) {
      this.mHandler.sendEmptyMessage(5);
    }
    while (parammobile_sub_get_photo_wall_rsp == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.addAll(this.ar);
    }
    b(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, localArrayList);
    paramString = this.mHandler.obtainMessage(2);
    paramString.obj = localArrayList;
    this.mHandler.sendMessage(paramString);
  }
  
  public void eie()
  {
    if ((this.b.hasMore == 1) && (this.b.eho < 9))
    {
      this.Jz.setVisibility(0);
      this.c.eD(this.mUin, this.b.attachInfo);
    }
  }
  
  public void ein()
  {
    boolean bool = this.mApp.getCurrentAccountUin().equals(this.mUin);
    e(this.mActivity, this.mUin, bool);
  }
  
  protected int getLayout()
  {
    return 2131561591;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          this.ehn = 0;
          this.c.eD(this.mUin, "");
          try
          {
            long l = Long.parseLong(this.mUin);
            this.c.a(l, this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$d);
            this.mHandler.removeMessages(3);
            return true;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL fail!", paramMessage);
              }
              this.mHandler.sendEmptyMessage(5);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_DATABASE");
          }
          as(paramMessage);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b != null) && (this.ar.size() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b.YA(this.ar.size());
          }
          aNi();
          paramMessage = Message.obtain();
          paramMessage.what = 3;
          handleMessage(paramMessage);
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_SERVER");
          }
          this.ehn |= 0x1;
          as(paramMessage);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b != null) && (this.ehn == 17))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b.YA(this.ar.size());
            aNi();
          }
        } while (this.b.hasMore == 1);
        this.Jz.setVisibility(8);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "handleMessage MSG_ADD_NOW_VIDEO_GALLERY");
        }
        this.ehn |= 0x10;
        f(this.ar, this.pk);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.ar, this.ar.size());
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b == null) || (this.ehn != 17));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$b.YA(this.ar.size());
      aNi();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FAILED");
    }
    this.Jz.setVisibility(8);
    return true;
  }
  
  public boolean hasMore()
  {
    if (this.b != null) {
      return this.b.hasMore == 1;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = this.mApp.getCurrentAccountUin().equals(this.mUin);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ein();
      if (bool)
      {
        anot.a(this.mApp, "dc00898", "", "", "0X8007EBE", "0X8007EBE", 0, 0, "", "", "", "");
      }
      else
      {
        anot.a(this.mApp, "dc00898", "", "", "0X8007EBF", "0X8007EBF", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "dc00898", "", "", "0X8007EC0", "0X8007EC0", 0, 0, "", "", "", "");
        e(this.mActivity, this.mUin, bool);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    paramInt2 = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - getResources().getDimensionPixelSize(2131297953) * 2;
    paramInt1 = (int)(f * 2.0F + 0.5F);
    paramInt3 = (paramInt2 - paramInt1) * 2 / 3;
    this.FE.layout(0, 0, 0 + paramInt3, paramInt3 + 0 + paramInt1);
    paramInt3 = (paramInt2 - paramInt1) / 3;
    paramInt4 = paramInt2 - paramInt3;
    this.FF.layout(paramInt4, 0, paramInt4 + paramInt3, paramInt3 + 0);
    paramInt3 = (paramInt2 - paramInt1) / 3;
    paramInt2 -= paramInt3;
    paramInt1 += paramInt3;
    this.FG.layout(paramInt2, paramInt1, paramInt2 + paramInt3, paramInt3 + paramInt1);
  }
  
  static class a
    extends CardHandler.d
  {
    private WeakReference<PhotoWallView> mRef;
    
    public a(PhotoWallView paramPhotoWallView)
    {
      this.mRef = new WeakReference(paramPhotoWallView);
    }
    
    public void H(int paramInt, List<NowLiveGallary.RspBody.PhotoInfo> paramList)
    {
      if (this.mRef != null) {}
      for (PhotoWallView localPhotoWallView = (PhotoWallView)this.mRef.get();; localPhotoWallView = null)
      {
        if (localPhotoWallView == null) {
          return;
        }
        if (paramInt != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay errorCode:" + paramInt);
          }
          localPhotoWallView.mHandler.sendEmptyMessage(4);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay size:" + paramList.size());
        }
        localPhotoWallView.pk.clear();
        paramInt = 0;
        while (paramInt < paramList.size())
        {
          Object localObject = (NowLiveGallary.RspBody.PhotoInfo)paramList.get(paramInt);
          localObject = new NowShowVideoInfo(((NowLiveGallary.RspBody.PhotoInfo)localObject).cover.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).video.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).timestamp.get());
          localPhotoWallView.pk.add(localObject);
          paramInt += 1;
        }
        if (localPhotoWallView.pk.size() > 0) {
          anot.a((QQAppInterface)this.n.get(), "dc00899", "NOW", "", "qq_zlk", "replay_exp", 0, 0, localPhotoWallView.mUin, "", "", "");
        }
        localPhotoWallView.mHandler.sendEmptyMessage(4);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void YA(int paramInt);
  }
  
  public static class c
  {
    public String attachInfo;
    public int eho;
    public int hasMore;
    public int totalPic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoWallView
 * JD-Core Version:    0.7.0.1
 */