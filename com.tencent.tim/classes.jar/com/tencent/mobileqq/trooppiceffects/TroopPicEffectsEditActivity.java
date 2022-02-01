package com.tencent.mobileqq.trooppiceffects;

import acfp;
import akxj;
import akxq;
import akxy;
import akxy.a;
import akyf;
import akyf.a;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import apqk;
import apqk.a;
import apsy;
import apsz;
import apsz.c;
import aptj;
import apyu;
import apyw;
import apyx;
import apza;
import apzb;
import aqbn;
import aqcx;
import aqfy;
import aqhq;
import aqhu;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.HorizontalListView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import jnm;
import jnm.d;
import mqq.manager.TicketManager;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.Goods;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.LoginSig;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.ReqBody;
import tencent.im.oidb.cmd0x991.oidb_cmd0x991.User;
import wja;

public class TroopPicEffectsEditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  protected apzb a;
  protected a a;
  protected b a;
  protected a[] a;
  public Button cd;
  public String cqt;
  protected ProgressDialog d;
  public SparseArray<apsz.c> dK = new SparseArray(10);
  public int dXY = 40000;
  public String lS;
  protected FrameLayout mContentLayout;
  protected HorizontalListView mListView;
  protected String mTroopUin;
  
  public static void f(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TroopPicEffectsEditActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("friendUin", paramString1);
    localIntent.putExtra("troopUin", paramString2);
    paramActivity.startActivity(localIntent);
    aqfy.anim(paramActivity, false, true);
    apyu.ih("pic_select", "page_exp");
  }
  
  public void Ug(String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. path invalid,path:" + paramString);
      return;
    }
    akxq localakxq = akxj.a(2, 1007);
    Object localObject = new akxy.a();
    ((akxy.a)localObject).NP(this.cqt);
    ((akxy.a)localObject).setLocalPath(this.lS);
    ((akxy.a)localObject).Sp(1);
    ((akxy.a)localObject).NT(this.mTroopUin);
    ((akxy.a)localObject).So(1007);
    ((akxy.a)localObject).Sr(0);
    ((akxy.a)localObject).setEntrance(0);
    localObject = ((akxy.a)localObject).a();
    if (!localakxq.c((akxy)localObject))
    {
      QLog.e("TroopPicEffectsEditActivity", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return;
    }
    ((akxy)localObject).localPath = paramString;
    b(localakxq);
  }
  
  protected void a(a parama, im_msg_body.CustomFace paramCustomFace, jnm.d paramd)
  {
    oidb_cmd0x991.ReqBody localReqBody = new oidb_cmd0x991.ReqBody();
    oidb_cmd0x991.User localUser = new oidb_cmd0x991.User();
    oidb_cmd0x991.Goods localGoods = new oidb_cmd0x991.Goods();
    long l = Long.parseLong(this.cqt);
    localUser.uint64_group.set(l);
    localUser.uint32_client.set(1);
    localUser.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.nT().getBytes()), true);
    localUser.uint32_portal.set(600);
    oidb_cmd0x991.LoginSig localLoginSig = new oidb_cmd0x991.LoginSig();
    localLoginSig.uint32_type.set(1);
    localLoginSig.uint32_appid.set(0);
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.app.getCurrentAccountUin());; localObject = "")
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
      localUser.msg_login_sig.set(localLoginSig);
      localUser.uint32_instance_id.set(AppSetting.getAppId());
      localGoods.int32_product_id.set(parama.bVZ);
      localGoods.bytes_goods_name.set(ByteStringMicro.copyFrom(parama.aVQ.getBytes()));
      localGoods.int32_goods_price.set(9);
      localGoods.bytes_animation_param.set(ByteStringMicro.copyFrom("{}".getBytes()));
      localGoods.msg_img.set(paramCustomFace);
      localReqBody.msg_user.set(localUser);
      localReqBody.msg_goods.set(localGoods);
      jnm.a(this.app, paramd, localReqBody.toByteArray(), "OidbSvc.0x991_" + 0, 2449, 0, new Bundle(), 5000L);
      return;
    }
  }
  
  protected void b(akxq paramakxq)
  {
    ThreadManager.post(new TroopPicEffectsEditActivity.3(this, paramakxq.b), 8, null, true);
  }
  
  protected void c(apsy paramapsy)
  {
    ((apsz)this.app.getManager(113)).a("OidbSvc.0x6c3", 1731, 1, this.cqt, 1, 7, true, true, paramapsy);
  }
  
  protected void ckj()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a = new a[] { new a(40000, acfp.m(2131716053), Color.parseColor("#F2575757"), true), new a(40002, acfp.m(2131716056), Color.parseColor("#F23FCCDF"), false), new a(40001, acfp.m(2131716069), Color.parseColor("#F2EF7AEE"), false), new a(40003, acfp.m(2131716063), Color.parseColor("#F2FFA02D"), false), new a(40004, acfp.m(2131716055), Color.parseColor("#F21CD28C"), false), new a(40005, acfp.m(2131716062), Color.parseColor("#F2FF6EA2"), false) };
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a[0];
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$b);
    this.mListView.setOnItemClickListener(this);
    c(new apyw(this));
  }
  
  public void dS(int paramInt, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_Apzb != null)
    {
      this.mContentLayout.removeView(this.jdField_a_of_type_Apzb.getView());
      this.jdField_a_of_type_Apzb.onDestroy();
    }
    boolean bool = aptj.mj(paramInt);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Apzb = new NormalPicView(this);
    }
    for (;;)
    {
      this.mContentLayout.addView(this.jdField_a_of_type_Apzb.getView(), -1, -1);
      paramInt = i;
      label154:
      Object localObject1;
      Object localObject2;
      switch (JpegExifReader.readOrientation(paramString))
      {
      default: 
        paramInt = i;
      case 4: 
      case 5: 
      case 7: 
        localObject1 = new BitmapFactory.Options();
        localObject2 = new File(paramString);
      }
      try
      {
        localObject2 = new BufferedInputStream(new FileInputStream((File)localObject2), 2048);
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject2, 720, 1080));
        ((BufferedInputStream)localObject2).close();
        paramString = aqhu.d(paramString, (BitmapFactory.Options)localObject1);
        localObject1 = new Matrix();
        ((Matrix)localObject1).reset();
        ((Matrix)localObject1).setRotate(paramInt);
        this.jdField_a_of_type_Apzb.setBitmap(Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject1, true));
        if (bool) {
          this.jdField_a_of_type_Apzb.play();
        }
        return;
        this.jdField_a_of_type_Apzb = new PhantomPicView(this);
        continue;
        this.jdField_a_of_type_Apzb = new ShakePicView(this);
        continue;
        int j = this.mContentLayout.getWidth();
        this.jdField_a_of_type_Apzb = new VideoPicView(this, paramInt, j, j * 1024 / 750);
        if (bool) {
          continue;
        }
        localObject1 = (apqk)this.app.getManager(223);
        ((apqk)localObject1).d(this);
        ((apqk)localObject1).a(paramInt, this.cqt, null);
        continue;
        paramInt = 90;
        break label154;
        paramInt = 180;
        break label154;
        paramInt = 270;
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563281);
    setTitle(acfp.m(2131716060));
    this.leftView.setText(acfp.m(2131716065));
    this.mContentLayout = ((FrameLayout)findViewById(2131380375));
    this.cd = ((Button)findViewById(2131380376));
    this.mListView = ((HorizontalListView)findViewById(2131380374));
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$b = new b();
    this.cd.setOnClickListener(this);
    this.mListView.setDividerWidth(aqcx.dip2px(this, 5.0F));
    paramBundle = getIntent();
    this.cqt = paramBundle.getStringExtra("friendUin");
    this.mTroopUin = paramBundle.getStringExtra("troopUin");
    this.lS = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    dS(40000, this.lS);
    ckj();
    apyu.ih("action_select", "page_exp");
    return true;
  }
  
  public void doOnDestroy()
  {
    ecG();
    if (this.jdField_a_of_type_Apzb != null) {
      this.jdField_a_of_type_Apzb.onDestroy();
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a = new a[0];
    ((apqk)this.app.getManager(223)).e(this);
    super.doOnDestroy();
  }
  
  public void ecG()
  {
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public String gI(String paramString)
  {
    if ((paramString == null) || (this.app == null)) {
      return paramString;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).c(this.cqt);
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", this.cqt).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  public boolean onBackEvent()
  {
    apyu.ih("action_select", "clk_back");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.cd)
    {
      c(new apyx(this));
      showProgressDialog();
      apyu.ih("send_pic", "clk_send");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    dS(this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a[paramInt].bVZ, this.lS);
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a[paramInt];
    this.dXY = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a[paramInt].bVZ;
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$a[i];
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        ((a)localObject1).isSelected = bool;
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity$b.notifyDataSetChanged();
    Object localObject2 = (apsz.c)this.dK.get(this.dXY);
    if (localObject2 != null)
    {
      localObject1 = ((apsz.c)localObject2).wording;
      if (localObject2 == null) {
        break label237;
      }
      localObject2 = ((apsz.c)localObject2).cre;
      label143:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label243;
      }
      i = ((String)localObject1).indexOf((String)localObject2);
      j = i + ((String)localObject2).length();
    }
    for (;;)
    {
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), i, j, 18);
      this.cd.setText((CharSequence)localObject1);
      apyu.ih("action_select", "clk_switch");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = "30金豆秀一下";
      break;
      label237:
      localObject2 = null;
      break label143;
      label243:
      i = 0;
    }
  }
  
  protected void showProgressDialog()
  {
    if (this.d == null)
    {
      this.d = new ReportProgressDialog(this, 2131756467);
      this.d.setCancelable(true);
      this.d.show();
      this.d.setContentView(2131559761);
      ((TextView)this.d.findViewById(2131373180)).setText(acfp.m(2131716061));
      return;
    }
    this.d.show();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (apqk.a)paramObject;
    if ((paramObservable.isFinish) && (paramObservable.cqv.equals("" + this.dXY)) && ((this.jdField_a_of_type_Apzb instanceof VideoPicView))) {
      ((VideoPicView)this.jdField_a_of_type_Apzb).play();
    }
  }
  
  public static class a
  {
    public String aVQ;
    public int bVZ;
    public int bWa;
    public String coverUrl;
    public boolean isSelected;
    
    public a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
    {
      this.bVZ = paramInt1;
      this.aVQ = paramString;
      this.coverUrl = ("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_item_" + paramInt1 + ".png");
      this.bWa = paramInt2;
      this.isSelected = paramBoolean;
    }
  }
  
  public class b
    extends BaseAdapter
  {
    protected b() {}
    
    public int getCount()
    {
      return TroopPicEffectsEditActivity.this.a.length;
    }
    
    public Object getItem(int paramInt)
    {
      return TroopPicEffectsEditActivity.this.a[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return TroopPicEffectsEditActivity.this.a[paramInt].bVZ;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (paramView == null)
      {
        localObject1 = new TroopPicEffectsEditActivity.d();
        paramView = LayoutInflater.from(TroopPicEffectsEditActivity.this).inflate(2131563280, paramViewGroup, false);
        ((TroopPicEffectsEditActivity.d)localObject1).imageView = ((ImageView)paramView.findViewById(2131380371));
        ((TroopPicEffectsEditActivity.d)localObject1).textView = ((TextView)paramView.findViewById(2131380373));
        ((TroopPicEffectsEditActivity.d)localObject1).nI = paramView.findViewById(2131380372);
        paramView.setTag(localObject1);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
        localObject2 = URLDrawable.getDrawable(TroopPicEffectsEditActivity.this.a[paramInt].coverUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setTag(aqbn.d(190, 270, aqcx.dip2px(TroopPicEffectsEditActivity.this, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.a);
        ((TroopPicEffectsEditActivity.d)localObject1).imageView.setImageDrawable((Drawable)localObject2);
        ((TroopPicEffectsEditActivity.d)localObject1).textView.setText(TroopPicEffectsEditActivity.this.a[paramInt].aVQ);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, aqcx.dip2px(TroopPicEffectsEditActivity.this, 5.0F), aqcx.dip2px(TroopPicEffectsEditActivity.this, 5.0F), aqcx.dip2px(TroopPicEffectsEditActivity.this, 5.0F), aqcx.dip2px(TroopPicEffectsEditActivity.this, 5.0F) });
        ((GradientDrawable)localObject2).setColor(TroopPicEffectsEditActivity.this.a[paramInt].bWa);
        ((TroopPicEffectsEditActivity.d)localObject1).textView.setBackgroundDrawable((Drawable)localObject2);
        localObject1 = ((TroopPicEffectsEditActivity.d)localObject1).nI;
        if (!TroopPicEffectsEditActivity.this.a[paramInt].isSelected) {
          break label363;
        }
      }
      label363:
      for (int i = 0;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (TroopPicEffectsEditActivity.d)paramView.getTag();
        break;
      }
    }
  }
  
  public static class c
    implements akyf
  {
    protected WeakReference<TroopPicEffectsEditActivity> mActivityRef;
    
    public c(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity)
    {
      this.mActivityRef = new WeakReference(paramTroopPicEffectsEditActivity);
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      return null;
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      TroopPicEffectsEditActivity localTroopPicEffectsEditActivity = (TroopPicEffectsEditActivity)this.mActivityRef.get();
      if (localTroopPicEffectsEditActivity == null) {
        return;
      }
      localTroopPicEffectsEditActivity.ecG();
      Intent localIntent = new Intent(localTroopPicEffectsEditActivity, SplashActivity.class);
      localIntent.putExtra("uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("friendUin"));
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("troopUin"));
      localIntent.putExtra("isFromTroopEffectPic", true);
      localTroopPicEffectsEditActivity.startActivity(wja.a(localIntent, new int[] { 1 }));
      localTroopPicEffectsEditActivity.finish();
      localTroopPicEffectsEditActivity.a(localTroopPicEffectsEditActivity.a, (im_msg_body.CustomFace)parama.data, new apza(this, localTroopPicEffectsEditActivity));
    }
  }
  
  public static class d
  {
    public ImageView imageView;
    public View nI;
    public TextView textView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity
 * JD-Core Version:    0.7.0.1
 */