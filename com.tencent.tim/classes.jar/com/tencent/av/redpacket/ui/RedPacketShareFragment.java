package com.tencent.av.redpacket.ui;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import arhz;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import rwt;
import wja;

@TargetApi(11)
public class RedPacketShareFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  Bitmap N;
  private String Qr;
  private String Qs;
  private String Qt;
  boolean UL;
  private arhz a;
  VideoAppInterface mApp;
  boolean mEnable = true;
  private Handler mHandler = new Handler(this);
  
  private void a(Button paramButton, int paramInt)
  {
    Object localObject1 = getResources();
    Object localObject2 = null;
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject1, paramInt);
      a(paramButton, (Bitmap)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketShareFragment", 2, "setButtonDrawable e = " + localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void a(Button paramButton, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = getResources();
      BitmapDrawable localBitmapDrawable = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap.setAlpha(128);
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, paramBitmap);
      ((StateListDrawable)localObject).addState(new int[] { -16842919 }, localBitmapDrawable);
      ((StateListDrawable)localObject).setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
      paramButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
    }
  }
  
  private static String aO(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketShareFragment", 2, "hitEmojiCntToExceedPercent, hitEmojiCnt=" + paramInt);
    }
    if (paramInt <= 3) {}
    do
    {
      return "20%";
      if ((paramInt >= 4) && (paramInt <= 5)) {
        return "30%";
      }
      if ((paramInt >= 6) && (paramInt <= 7)) {
        return "40%";
      }
      if (paramInt == 8) {
        return "50%";
      }
      if ((paramInt >= 9) && (paramInt <= 10)) {
        return "60%";
      }
      if ((paramInt >= 11) && (paramInt <= 12)) {
        return "70%";
      }
      if ((paramInt >= 13) && (paramInt <= 14)) {
        return "80%";
      }
      if (paramInt == 15) {
        return "90%";
      }
    } while (paramInt != 16);
    return "99.99%";
  }
  
  public static void ak(String paramString, int paramInt)
  {
    QLog.d("RedPacketShareFragment", 1, "WL_DEBUG reportClickEvent actionName = " + paramString + ", fromType = " + paramInt);
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void aqy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "showWaitingDialog");
    }
    if ((getActivity() == null) || (getActivity().isFinishing()) || ((this.a != null) && (this.a.isShowing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShareFragment", 2, "showWaitingDialog, activity is finishing or dlg showing");
      }
      return;
    }
    if (this.a == null) {
      this.a = new arhz(getActivity(), getResources().getDimensionPixelSize(2131299627));
    }
    this.a.setMessage(getActivity().getString(2131698017));
    this.a.setBackAndSearchFilter(true);
    this.a.show();
  }
  
  private void aqz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "dismissWaittingDialog");
    }
    if ((getActivity() != null) && (this.a != null) && (this.a.isShowing()) && (!getActivity().isFinishing())) {
      this.a.dismiss();
    }
  }
  
  @TargetApi(12)
  private void bJ(View paramView)
  {
    if (this.mApp != null)
    {
      Object localObject2 = (AVRedPacketManager)this.mApp.a(6);
      if (localObject2 != null)
      {
        Object localObject3 = ((AVRedPacketManager)localObject2).J();
        ((AVRedPacketManager)localObject2).h(null);
        Object localObject1 = (ViewGroup)getActivity().getLayoutInflater().inflate(2131559966, null);
        ((ViewGroup)localObject1).findViewById(2131377546).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject3));
        localObject3 = ((AVRedPacketManager)localObject2).o("qav_redpacket_share_preview_background.png");
        if (localObject3 != null) {
          ((ViewGroup)localObject1).findViewById(2131363236).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject3));
        }
        localObject3 = this.mApp.getCurrentAccountUin();
        Object localObject4 = this.mApp.a(0, (String)localObject3, null, true, true);
        if (localObject4 != null) {
          ((ViewGroup)localObject1).findViewById(2131368375).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject4));
        }
        if (getArguments().getBoolean("isGoodScore"))
        {
          localObject4 = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_bqd.png");
          if (localObject4 != null) {
            ((ViewGroup)localObject1).findViewById(2131363714).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject4));
          }
        }
        localObject4 = (TextView)((ViewGroup)localObject1).findViewById(2131377719);
        this.Qr = Integer.toString(getArguments().getInt("score"));
        ((TextView)localObject4).setText(this.Qr);
        localObject4 = (TextView)((ViewGroup)localObject1).findViewById(2131379404);
        Object localObject5 = getString(2131698020);
        this.Qs = aO(getArguments().getInt("count"));
        String str = this.Qs;
        Object localObject6 = String.format((String)localObject5, new Object[] { str });
        localObject5 = new ForegroundColorSpan(-410357);
        localObject6 = new SpannableString((CharSequence)localObject6);
        ((SpannableString)localObject6).setSpan(localObject5, 3, str.length() + 3, 17);
        ((TextView)localObject4).setText((CharSequence)localObject6);
        ((TextView)((ViewGroup)localObject1).findViewById(2131379407)).setText(String.format(getString(2131698021), new Object[] { this.mApp.getDisplayName(0, (String)localObject3, null) }));
        localObject2 = ((AVRedPacketManager)localObject2).d("qav_redpacket_share_preview_qrcode.png", false);
        if (localObject2 != null) {
          ((ViewGroup)localObject1).findViewById(2131375321).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject2));
        }
        ((ViewGroup)localObject1).measure(View.MeasureSpec.makeMeasureSpec(wja.dp2px(375.0F, getResources()), 1073741824), View.MeasureSpec.makeMeasureSpec(wja.dp2px(667.0F, getResources()), 1073741824));
        ((ViewGroup)localObject1).layout(0, 0, ((ViewGroup)localObject1).getMeasuredWidth(), ((ViewGroup)localObject1).getMeasuredHeight());
        this.N = loadBitmapFromView((View)localObject1);
        paramView = (ImageView)paramView.findViewById(2131373566);
        localObject1 = RoundedBitmapDrawableFactory.create(getResources(), this.N);
        ((RoundedBitmapDrawable)localObject1).setCornerRadius(wja.dp2px(10.0F, getResources()));
        paramView.setImageDrawable((Drawable)localObject1);
      }
    }
    getArguments();
  }
  
  private void c(View paramView, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = getResources();
      BitmapDrawable localBitmapDrawable = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap.setAlpha(128);
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, paramBitmap);
      ((StateListDrawable)localObject).addState(new int[] { -16842919 }, localBitmapDrawable);
      ((StateListDrawable)localObject).setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
      paramView.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  @Nullable
  private String he()
  {
    if (this.mApp == null) {}
    do
    {
      return null;
      try
      {
        String str = "temp_qav_redpacket_share_" + System.currentTimeMillis() + this.mApp.getCurrentAccountUin() + ".png";
        str = rwt.a(getActivity(), str, this.N);
        return str;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.i("RedPacketShareFragment", 2, localOutOfMemoryError.getMessage());
    return null;
  }
  
  public static void iF(String paramString)
  {
    ak(paramString, 0);
  }
  
  private void lI(int paramInt)
  {
    if (!this.mEnable)
    {
      QQToast.a(BaseApplication.getContext(), 2131701501, 0).show();
      return;
    }
    int i;
    if ((paramInt == 2) || (paramInt == 3)) {
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        rwt.ez(1, i);
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        if ((this.N == null) || (this.N.isRecycled()))
        {
          rwt.ez(1, 2131701502);
          return;
        }
        iW(true);
        if (paramInt == 0)
        {
          aqy();
          ThreadManager.postImmediately(new RedPacketShareFragment.1(this), null, true);
          return;
        }
        if (paramInt == 1)
        {
          aqy();
          ThreadManager.postImmediately(new RedPacketShareFragment.2(this), null, true);
          return;
        }
        if ((paramInt != 2) && (paramInt != 3)) {
          break;
        }
        aqy();
        ThreadManager.postImmediately(new RedPacketShareFragment.3(this, paramInt), null, true);
        return;
      }
      i = -1;
    }
  }
  
  private Bitmap loadBitmapFromView(View paramView)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramView.layout(0, 0, i, j);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  private void u(View paramView)
  {
    Object localObject1 = (Button)paramView.findViewById(2131363744);
    Object localObject2 = (Button)paramView.findViewById(2131363745);
    Button localButton1 = (Button)paramView.findViewById(2131363746);
    Button localButton2 = (Button)paramView.findViewById(2131363747);
    View localView = paramView.findViewById(2131377622);
    paramView = paramView.findViewById(2131364677);
    ((Button)localObject1).setOnClickListener(this);
    ((Button)localObject2).setOnClickListener(this);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    localView.setOnClickListener(this);
    paramView.setOnClickListener(this);
    a((Button)localObject1, 2130839252);
    a((Button)localObject2, 2130839253);
    a(localButton1, 2130839256);
    a(localButton2, 2130839249);
    if (this.mApp != null)
    {
      localObject2 = (AVRedPacketManager)this.mApp.a(6);
      if (localObject2 != null)
      {
        localObject1 = ((AVRedPacketManager)localObject2).o("qav_redpacket_share_save.png");
        localObject2 = ((AVRedPacketManager)localObject2).o("qav_redpacket_share_close.png");
        c(localView, (Bitmap)localObject1);
        c(paramView, (Bitmap)localObject2);
      }
    }
  }
  
  void aqw()
  {
    this.mEnable = false;
    ThreadManager.postImmediately(new RedPacketShareFragment.4(this), null, true);
  }
  
  public void aqx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "onNewRedPacketGameStart");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  protected int getLayoutId()
  {
    return 2131559965;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return true;
  }
  
  public void iW(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mEnable = paramBoolean;
      return;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 21: 
      ak("0X8008CF8", 1);
      return;
    }
    ak("0X8008CF8", 2);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity() != null) && ((getActivity().getAppInterface() instanceof VideoAppInterface))) {
      this.mApp = ((VideoAppInterface)getActivity().getAppInterface());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lI(0);
      ak("0X8008CF6", 1);
      continue;
      lI(1);
      ak("0X8008CF6", 2);
      continue;
      lI(2);
      ak("0X8008CF6", 3);
      continue;
      lI(3);
      ak("0X8008CF6", 4);
      continue;
      if (this.mEnable) {
        if (this.N == null)
        {
          QQToast.a(BaseApplication.getContext(), 1, 2131701502, 0).show();
        }
        else if (!this.UL)
        {
          aqw();
        }
        else
        {
          QQToast.a(BaseApplication.getContext(), 0, acfp.m(2131713791), 0).show();
          continue;
          getActivity().onBackPressed();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mApp != null) {
      ((AVRedPacketManager)this.mApp.a(6)).a(this);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    u(paramLayoutInflater);
    bJ(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
    aqz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment
 * JD-Core Version:    0.7.0.1
 */