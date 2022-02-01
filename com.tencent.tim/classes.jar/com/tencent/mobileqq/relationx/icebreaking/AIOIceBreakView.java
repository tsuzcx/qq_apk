package com.tencent.mobileqq.relationx.icebreaking;

import aluo;
import alup;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import ygl;
import ygz;
import yhf;

public class AIOIceBreakView
  extends LinearLayout
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private a jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakView$a;
  private QQAppInterface app;
  private int bYV;
  private Drawable bm;
  private Context context;
  private CustomImgView e;
  private CustomImgView f;
  private View.OnClickListener fE = new aluo(this);
  private View.OnClickListener fF = new alup(this);
  private CustomImgView g;
  private BaseActivity h;
  
  public AIOIceBreakView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    initViews();
  }
  
  public AIOIceBreakView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    initViews();
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(ygl paramygl)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramygl.a();
    paramygl = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramygl = URLDrawable.URLDrawableOptions.obtain();
    }
    paramygl.mLoadingDrawable = this.bm;
    paramygl.mFailedDrawable = this.bm;
    paramygl.mPlayGifImage = true;
    return paramygl;
  }
  
  private void a(CustomImgView paramCustomImgView, ygl paramygl)
  {
    paramCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130845956));
    if (paramygl == null)
    {
      paramCustomImgView.setImageDrawable(this.bm);
      return;
    }
    Object localObject = paramygl.e();
    if (localObject == null)
    {
      paramCustomImgView.setImageDrawable(this.bm);
      return;
    }
    localObject = paramygl.a((URL)localObject, a(paramygl));
    paramCustomImgView.setTag(paramygl);
    paramCustomImgView.setImageDrawable((Drawable)localObject);
    paramCustomImgView.setOnClickListener(this.fF);
  }
  
  private void a(ygl paramygl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "sendPic");
    }
    if (paramygl == null) {}
    do
    {
      return;
      paramygl = (ygz)paramygl;
      yhf.a(this.app).yG(paramygl.getKeyWord());
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramygl.getFilePath());
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.troopUin);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.topicId);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("quick_send_original_md5", paramygl.pz());
      localIntent.putExtra("quick_send_original_size", paramygl.es());
      localIntent.putExtra("quick_send_thumb_md5", paramygl.pB());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
      localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
      ThreadManager.post(new SendPhotoTask(this.h, localIntent, null), 8, null, false);
      paramygl = this.app.getHandler(ChatActivity.class);
    } while (paramygl == null);
    paramygl.sendMessage(paramygl.obtainMessage(92));
  }
  
  private void initViews()
  {
    View localView = LayoutInflater.from(this.context).inflate(2131558668, this);
    ((TextView)localView.findViewById(2131381167)).setOnClickListener(this.fE);
    this.e = ((CustomImgView)localView.findViewById(2131369108));
    this.f = ((CustomImgView)localView.findViewById(2131369109));
    this.g = ((CustomImgView)localView.findViewById(2131369112));
    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
    this.f.setScaleType(ImageView.ScaleType.FIT_XY);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    this.bm = getResources().getDrawable(2130838388);
    this.bYV = ((int)(getResources().getDisplayMetrics().density * 6.0F));
  }
  
  public void c(BaseChatPie paramBaseChatPie, List<ygl> paramList)
  {
    int i = 1;
    if ((paramList == null) || (paramList.size() < 3)) {}
    do
    {
      return;
      this.app = paramBaseChatPie.app;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
      this.h = paramBaseChatPie.a();
      a(this.e, (ygl)paramList.get(0));
      a(this.f, (ygl)paramList.get(1));
      a(this.g, (ygl)paramList.get(2));
    } while (paramBaseChatPie.sessionInfo.cZ == 1044);
    if (paramBaseChatPie.sessionInfo.cZ == 0) {}
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
  
  public void setOnIceImageClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ae(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView
 * JD-Core Version:    0.7.0.1
 */