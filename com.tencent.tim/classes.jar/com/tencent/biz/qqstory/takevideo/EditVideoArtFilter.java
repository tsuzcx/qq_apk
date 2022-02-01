package com.tencent.biz.qqstory.takevideo;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqcu;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import ras;
import rca;
import rdb;
import rdc;
import rel;
import rfh;
import riw;
import rkm;
import rkq;

@TargetApi(11)
public class EditVideoArtFilter
  extends rdb
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, Runnable
{
  public static final String azw = ArtFilterManager.aAa + "artfiltertemp/";
  long BH = 0L;
  private a jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a;
  private b jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b;
  ArtFilterItemView jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView;
  public boolean aGJ;
  boolean aGK = false;
  public boolean aGL = true;
  boolean aGM = false;
  boolean aGN = true;
  public AtomicInteger an = new AtomicInteger(0);
  String azA = "";
  public String azx;
  public String azy;
  public String azz;
  public int bpM;
  private int bpN = -1;
  public int bpO;
  int bpP = 0;
  int bpQ = 0;
  int bpR = -1;
  int bpS = 0;
  Context context;
  Bitmap cz;
  private FrameLayout frameLayout;
  public HorizontalListView g;
  String originalFilePath;
  long timeStamp;
  private TextView yh;
  private TextView yi;
  
  public EditVideoArtFilter(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  private void ty(boolean paramBoolean)
  {
    this.aGJ = paramBoolean;
    if (paramBoolean)
    {
      this.yi.setClickable(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.yi.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.yi.setClickable(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.yi.setAlpha(1.0F);
  }
  
  private void wU(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a.mSelectedPosition = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a.notifyDataSetChanged();
  }
  
  public boolean KW()
  {
    return (this.aGK) || (!this.aGN);
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    if (KW())
    {
      rkq localrkq = paramrkm.jdField_a_of_type_Rkq;
      localrkq.bsR += 1;
      anot.a(null, "dc00898", "", "", "0X8007551", "0X8007551", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X8007552", "0X8007552", this.bpR, 0, "", "", "", "");
      paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("5");
      paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves7 = (this.bpR + "");
      ras.bw("0X80075EF", ras.bpo);
    }
  }
  
  public void aq(int paramInt, boolean paramBoolean)
  {
    rfh localrfh = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a.a(paramInt);
    if (localrfh == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask:position:" + paramInt + "FilterTemplate" + localrfh);
    }
    wU(paramInt);
    if ((this.azz.endsWith(".gif")) && (!paramBoolean))
    {
      QQToast.a(this.context, this.context.getResources().getString(2131690524), 0).show();
      return;
    }
    if (paramInt == 0)
    {
      bx(null, -1);
      this.bpN = -1;
      return;
    }
    this.bpN = localrfh.id;
    Object localObject = azw + this.timeStamp + "_" + localrfh.id + ".png";
    if (new File((String)localObject).exists())
    {
      bx((String)localObject, localrfh.id);
      return;
    }
    paramInt = this.an.incrementAndGet();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask: timeStamp:" + this.timeStamp + " currentTaskId:" + paramInt + " compressedFilePath:" + this.azz);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.xh(paramInt);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b.obtainMessage(35);
    ((Message)localObject).obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b.sendMessageDelayed((Message)localObject, 20000L);
    ty(true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("param_art_filter_style_id", localrfh.id);
    ((Bundle)localObject).putString("param_art_filter_style_name", localrfh.name);
    ((Bundle)localObject).putLong("param_art_filter_file_name", this.timeStamp);
    ((Bundle)localObject).putString("param_art_filter_resource_path", this.azz);
    ((Bundle)localObject).putInt("param_art_filter_task_id", paramInt);
    QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_get_art_filter_path", (Bundle)localObject, new rca(this, localrfh));
  }
  
  public void bsy()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.btH();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "CancelFilterTaskId:" + this.an.get());
    }
    this.an.incrementAndGet();
    ty(false);
  }
  
  public void bsz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "updateCropImg");
    }
    this.cz = null;
    this.aGN = true;
    if (!TextUtils.isEmpty(this.azz)) {
      this.azz = null;
    }
    wU(0);
    this.bpS = 0;
    if (KW()) {
      this.aGK = true;
    }
  }
  
  public void bx(String paramString, int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      Bitmap localBitmap;
      Object localObject2;
      label323:
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.azA + " lastOriginalBitmap:" + this.aGN + " fileOutputPath:" + paramString);
        }
        if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
          break label407;
        }
        this.bpS = this.bpQ;
        boolean bool = paramString.equals(this.azA);
        if (bool) {
          return;
        }
        localObject1 = null;
      }
      finally {}
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString);
        localObject2 = localBitmap;
        localObject1 = localBitmap;
        if (this.aGM)
        {
          localObject2 = localBitmap;
          localObject1 = localBitmap;
          if (this.bpO != 0)
          {
            localObject2 = localBitmap;
            localObject1 = localBitmap;
            if (this.bpO % 90 == 0)
            {
              localObject1 = localBitmap;
              if (QLog.isColorLevel())
              {
                localObject1 = localBitmap;
                QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "load bitmap has exif rotate " + this.bpO);
              }
              localObject1 = localBitmap;
              int i = localBitmap.getWidth();
              localObject1 = localBitmap;
              int j = localBitmap.getHeight();
              localObject1 = localBitmap;
              localObject2 = new Matrix();
              localObject1 = localBitmap;
              ((Matrix)localObject2).postRotate(this.bpO, i / 2.0F, j / 2.0F);
              localObject1 = localBitmap;
              localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, i, j, (Matrix)localObject2, true);
              localObject1 = localBitmap;
              localBitmap.recycle();
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.qqstory.publish.edit.EditVideoArtFilter", 1, "load oom");
        Object localObject3 = localObject1;
        continue;
      }
      if (localObject2 != null)
      {
        this.b.e((Bitmap)localObject2, true);
        this.azA = paramString;
        this.bpR = paramInt;
        this.aGN = false;
        if (!QLog.isColorLevel()) {
          break label461;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.azA + " lastOriginalBitmap:" + this.aGN + " fileOutputPath:" + paramString);
      }
    }
    label407:
    if (this.cz != null) {
      if (!this.aGN)
      {
        localObject1 = this.cz.copy(a(this.cz), true);
        this.b.e((Bitmap)localObject1, true);
      }
    }
    for (;;)
    {
      this.azA = "";
      this.aGN = true;
      break label323;
      label461:
      break;
      this.cz = this.b.W().copy(a(this.b.W()), true);
    }
  }
  
  boolean eM(int paramInt)
  {
    if (this.azz == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "compressedFilePath has not generated");
      }
    }
    do
    {
      long l;
      do
      {
        return false;
        l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "mLastItemClickTime:" + this.BH + " mLastItemClickPosition:" + this.bpQ + " ClickTime:" + l + " ClickPosition:" + paramInt);
        }
      } while (l - this.BH < 300L);
      this.BH = l;
    } while ((this.bpQ == paramInt) && (this.aGJ));
    this.bpQ = paramInt;
    if (this.bpQ != 0) {
      anot.a(null, "dc00898", "", "", "0X8007550", "0X8007550", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 666) && (paramInt2 == -1)) {
      this.aGL = false;
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.b.bqq == 12)
    {
      if (eM(this.bpP))
      {
        tx(false);
        aq(this.bpP, true);
        this.b.changeState(0);
      }
      return true;
    }
    return false;
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
      if (eM(this.bpP))
      {
        if ((this.b != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 5, 2);
        }
        tx(false);
        aq(this.bpP, true);
        this.b.changeState(0);
        continue;
        if ((this.b != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 5, 3);
        }
        this.b.changeState(0);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this.b.jdField_a_of_type_Rel.getActivity();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a = new a(this.context);
    this.originalFilePath = this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b = new b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView = ((ArtFilterItemView)y(2131363009));
    this.yh = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131363002));
    this.yi = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131363003));
    this.yh.setOnClickListener(this);
    this.yi.setOnClickListener(this);
    this.g = ((HorizontalListView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131363010));
    this.g.setOnItemClickListener(this);
    if ((this.g != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a != null)) {
      this.g.postDelayed(this, 10L);
    }
    this.frameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131363004));
    this.frameLayout.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setHandler(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b, this.azy);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.cz != null)
    {
      this.cz.recycle();
      this.cz = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$b = null;
    if (this.aGL) {
      QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_exit_art_filter", null, null);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (eM(paramInt))
    {
      if ((this.b != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
        LpReportInfo_pf00064.allReport(615, 5, 4);
      }
      tx(false);
      aq(paramInt, false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (paramView.getId() == 2131363004))
    {
      if (this.aGJ) {
        return true;
      }
      onClick(this.yi);
      return true;
    }
    return false;
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "editVideoState Change:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(this);
      }
      return;
    }
    this.bpP = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a.mSelectedPosition;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.show();
    anot.a(null, "dc00898", "", "", "0X800754F", "0X800754F", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 673	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azx	Ljava/lang/String;
    //   4: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +235 -> 242
    //   10: new 213	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 674	java/util/ArrayList:<init>	()V
    //   17: astore_2
    //   18: new 676	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 673	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azx	Ljava/lang/String;
    //   26: invokespecial 677	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: aload_3
    //   34: invokevirtual 680	org/json/JSONArray:length	()I
    //   37: if_icmpge +71 -> 108
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 684	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 4
    //   47: aload_2
    //   48: new 298	rfh
    //   51: dup
    //   52: aload 4
    //   54: ldc_w 685
    //   57: invokevirtual 691	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: aload 4
    //   62: ldc_w 693
    //   65: invokevirtual 696	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: aload 4
    //   70: ldc_w 698
    //   73: invokevirtual 691	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   76: aload 4
    //   78: ldc_w 699
    //   81: invokevirtual 696	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: aload 4
    //   86: ldc_w 701
    //   89: invokevirtual 696	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokespecial 704	rfh:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   95: invokeinterface 707 2 0
    //   100: pop
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -73 -> 32
    //   108: aload_2
    //   109: invokeinterface 711 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 716 1 0
    //   121: ifeq +130 -> 251
    //   124: new 312	java/io/File
    //   127: dup
    //   128: aload_3
    //   129: invokeinterface 720 1 0
    //   134: checkcast 298	rfh
    //   137: getfield 722	rfh:thumbPath	Ljava/lang/String;
    //   140: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 318	java/io/File:exists	()Z
    //   150: ifeq +11 -> 161
    //   153: aload 4
    //   155: invokevirtual 725	java/io/File:isFile	()Z
    //   158: ifne -43 -> 115
    //   161: aload_3
    //   162: invokeinterface 728 1 0
    //   167: goto -52 -> 115
    //   170: astore_3
    //   171: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 246
    //   179: iconst_2
    //   180: ldc_w 730
    //   183: invokestatic 484	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +34 -> 223
    //   192: ldc 246
    //   194: iconst_2
    //   195: new 67	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 732
    //   205: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_2
    //   209: invokeinterface 735 1 0
    //   214: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 168	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a	Lcom/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a;
    //   227: aload_2
    //   228: invokevirtual 739	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a:eL	(Ljava/util/List;)V
    //   231: aload_0
    //   232: getfield 610	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:g	Lcom/tencent/widget/HorizontalListView;
    //   235: aload_0
    //   236: getfield 168	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a	Lcom/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a;
    //   239: invokevirtual 743	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   242: aload_0
    //   243: getfield 610	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:g	Lcom/tencent/widget/HorizontalListView;
    //   246: aload_0
    //   247: invokevirtual 614	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   250: return
    //   251: aload_2
    //   252: invokestatic 748	java/util/Collections:sort	(Ljava/util/List;)V
    //   255: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +34 -> 292
    //   261: ldc 246
    //   263: iconst_2
    //   264: new 67	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 732
    //   274: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokeinterface 735 1 0
    //   283: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: getfield 168	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a	Lcom/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a;
    //   296: aload_2
    //   297: invokevirtual 739	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a:eL	(Ljava/util/List;)V
    //   300: goto -69 -> 231
    //   303: astore_3
    //   304: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +34 -> 341
    //   310: ldc 246
    //   312: iconst_2
    //   313: new 67	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 732
    //   323: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokeinterface 735 1 0
    //   332: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_0
    //   342: getfield 168	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter$a	Lcom/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a;
    //   345: aload_2
    //   346: invokevirtual 739	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter$a:eL	(Ljava/util/List;)V
    //   349: aload_3
    //   350: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	EditVideoArtFilter
    //   31	74	1	i	int
    //   17	329	2	localArrayList	ArrayList
    //   29	133	3	localObject1	Object
    //   170	1	3	localJSONException	org.json.JSONException
    //   303	47	3	localObject2	Object
    //   45	109	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	170	org/json/JSONException
    //   32	101	170	org/json/JSONException
    //   108	115	170	org/json/JSONException
    //   115	161	170	org/json/JSONException
    //   161	167	170	org/json/JSONException
    //   251	255	170	org/json/JSONException
    //   18	30	303	finally
    //   32	101	303	finally
    //   108	115	303	finally
    //   115	161	303	finally
    //   161	167	303	finally
    //   171	186	303	finally
    //   251	255	303	finally
  }
  
  public void tx(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "initState:isProcessing:" + this.aGJ);
    }
    if (this.aGJ)
    {
      bsy();
      if (paramBoolean) {
        wU(this.bpS);
      }
    }
    this.bpN = -1;
  }
  
  /* Error */
  public void u(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 12
    //   9: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +45 -> 57
    //   15: ldc 246
    //   17: iconst_2
    //   18: new 67	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 760
    //   28: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 421	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:cz	Landroid/graphics/Bitmap;
    //   35: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc_w 328
    //   41: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   48: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 763	android/graphics/Bitmap:isRecycled	()Z
    //   61: ifeq +4 -> 65
    //   64: return
    //   65: aload_0
    //   66: getfield 421	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:cz	Landroid/graphics/Bitmap;
    //   69: ifnonnull +17 -> 86
    //   72: aload_0
    //   73: aload_1
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 486	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   79: iconst_1
    //   80: invokevirtual 490	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   83: putfield 421	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:cz	Landroid/graphics/Bitmap;
    //   86: aload_0
    //   87: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   90: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +20 -> 113
    //   96: new 312	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   104: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 318	java/io/File:exists	()Z
    //   110: ifne -46 -> 64
    //   113: aload_0
    //   114: invokestatic 504	android/os/SystemClock:uptimeMillis	()J
    //   117: putfield 303	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:timeStamp	J
    //   120: new 67	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   127: getstatic 87	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azw	Ljava/lang/String;
    //   130: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 303	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:timeStamp	J
    //   137: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: ldc_w 765
    //   143: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 13
    //   151: aload_0
    //   152: getfield 421	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:cz	Landroid/graphics/Bitmap;
    //   155: invokevirtual 457	android/graphics/Bitmap:getHeight	()I
    //   158: istore_3
    //   159: aload_0
    //   160: getfield 421	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:cz	Landroid/graphics/Bitmap;
    //   163: invokevirtual 454	android/graphics/Bitmap:getWidth	()I
    //   166: istore 5
    //   168: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +40 -> 211
    //   174: ldc 246
    //   176: iconst_2
    //   177: new 67	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 767
    //   187: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_3
    //   191: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 769
    //   197: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 5
    //   202: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iload_3
    //   212: iload 5
    //   214: invokestatic 775	java/lang/Math:max	(II)I
    //   217: istore 4
    //   219: iload 4
    //   221: aload_0
    //   222: getfield 777	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:bpM	I
    //   225: if_icmple +455 -> 680
    //   228: aload_0
    //   229: getfield 777	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:bpM	I
    //   232: i2f
    //   233: iload 4
    //   235: i2f
    //   236: fdiv
    //   237: fstore_2
    //   238: iload 5
    //   240: i2f
    //   241: fload_2
    //   242: fmul
    //   243: invokestatic 781	java/lang/Math:round	(F)I
    //   246: istore 4
    //   248: iload_3
    //   249: i2f
    //   250: fload_2
    //   251: fmul
    //   252: invokestatic 781	java/lang/Math:round	(F)I
    //   255: istore_3
    //   256: aload_1
    //   257: iload 4
    //   259: iload_3
    //   260: iconst_0
    //   261: invokestatic 785	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   264: astore 7
    //   266: aload 7
    //   268: astore 9
    //   270: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +44 -> 317
    //   276: ldc 246
    //   278: iconst_2
    //   279: new 67	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 787
    //   289: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 4
    //   294: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc_w 789
    //   300: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload_3
    //   304: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 7
    //   315: astore 9
    //   317: aload 9
    //   319: ifnull +726 -> 1045
    //   322: new 791	java/io/FileOutputStream
    //   325: dup
    //   326: new 312	java/io/File
    //   329: dup
    //   330: aload 13
    //   332: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   335: invokespecial 794	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   338: astore 7
    //   340: new 796	java/io/BufferedOutputStream
    //   343: dup
    //   344: aload 7
    //   346: invokespecial 799	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   349: astore 8
    //   351: aload 9
    //   353: getstatic 805	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   356: bipush 90
    //   358: aload 8
    //   360: invokevirtual 809	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   363: istore 6
    //   365: aload 9
    //   367: invokevirtual 471	android/graphics/Bitmap:recycle	()V
    //   370: iload 6
    //   372: ifeq +49 -> 421
    //   375: aload_0
    //   376: aload 13
    //   378: putfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   381: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +32 -> 416
    //   387: ldc 246
    //   389: iconst_2
    //   390: new 67	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 811
    //   400: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   407: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_0
    //   417: iconst_0
    //   418: putfield 107	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:aGM	Z
    //   421: aload 8
    //   423: astore 10
    //   425: aload 7
    //   427: astore 8
    //   429: aload 10
    //   431: ifnull +8 -> 439
    //   434: aload 10
    //   436: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   439: aload 8
    //   441: astore 9
    //   443: aload 10
    //   445: astore 7
    //   447: aload 8
    //   449: ifnull +16 -> 465
    //   452: aload 8
    //   454: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   457: aload 10
    //   459: astore 7
    //   461: aload 8
    //   463: astore 9
    //   465: aload_0
    //   466: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   469: ifnonnull -405 -> 64
    //   472: new 791	java/io/FileOutputStream
    //   475: dup
    //   476: new 312	java/io/File
    //   479: dup
    //   480: aload 13
    //   482: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   485: invokespecial 794	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   488: astore 8
    //   490: new 796	java/io/BufferedOutputStream
    //   493: dup
    //   494: aload 8
    //   496: invokespecial 799	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   499: astore 9
    //   501: aload_1
    //   502: getstatic 805	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   505: bipush 90
    //   507: aload 9
    //   509: invokevirtual 809	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   512: ifeq +49 -> 561
    //   515: aload_0
    //   516: aload 13
    //   518: putfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   521: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +32 -> 556
    //   527: ldc 246
    //   529: iconst_2
    //   530: new 67	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 817
    //   540: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_0
    //   544: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   547: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload_0
    //   557: iconst_0
    //   558: putfield 107	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:aGM	Z
    //   561: aload 9
    //   563: ifnull +8 -> 571
    //   566: aload 9
    //   568: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   571: aload 8
    //   573: ifnull +8 -> 581
    //   576: aload 8
    //   578: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   581: aload_0
    //   582: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   585: ifnonnull -521 -> 64
    //   588: aload_0
    //   589: aload_0
    //   590: getfield 586	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:originalFilePath	Ljava/lang/String;
    //   593: putfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   596: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq +32 -> 631
    //   602: ldc 246
    //   604: iconst_2
    //   605: new 67	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 819
    //   615: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_0
    //   619: getfield 261	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:azz	Ljava/lang/String;
    //   622: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: aload_0
    //   632: iconst_1
    //   633: putfield 107	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:aGM	Z
    //   636: return
    //   637: astore_1
    //   638: aload_1
    //   639: invokevirtual 822	java/lang/OutOfMemoryError:printStackTrace	()V
    //   642: return
    //   643: astore 7
    //   645: aload 7
    //   647: invokevirtual 822	java/lang/OutOfMemoryError:printStackTrace	()V
    //   650: iconst_0
    //   651: ifeq +11 -> 662
    //   654: new 824	java/lang/NullPointerException
    //   657: dup
    //   658: invokespecial 825	java/lang/NullPointerException:<init>	()V
    //   661: athrow
    //   662: iconst_0
    //   663: ifeq -599 -> 64
    //   666: new 824	java/lang/NullPointerException
    //   669: dup
    //   670: invokespecial 825	java/lang/NullPointerException:<init>	()V
    //   673: athrow
    //   674: astore_1
    //   675: aload_1
    //   676: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   679: return
    //   680: aload_1
    //   681: aload_0
    //   682: aload_1
    //   683: invokespecial 486	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   686: iconst_1
    //   687: invokevirtual 490	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   690: astore 9
    //   692: goto -375 -> 317
    //   695: astore 7
    //   697: aload 7
    //   699: invokevirtual 822	java/lang/OutOfMemoryError:printStackTrace	()V
    //   702: iconst_0
    //   703: ifeq +11 -> 714
    //   706: new 824	java/lang/NullPointerException
    //   709: dup
    //   710: invokespecial 825	java/lang/NullPointerException:<init>	()V
    //   713: athrow
    //   714: iconst_0
    //   715: ifeq -651 -> 64
    //   718: new 824	java/lang/NullPointerException
    //   721: dup
    //   722: invokespecial 825	java/lang/NullPointerException:<init>	()V
    //   725: athrow
    //   726: astore_1
    //   727: aload_1
    //   728: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   731: return
    //   732: astore 7
    //   734: aload 7
    //   736: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   739: aload 8
    //   741: astore 9
    //   743: aload 10
    //   745: astore 7
    //   747: goto -282 -> 465
    //   750: astore 7
    //   752: aconst_null
    //   753: astore 8
    //   755: aload 7
    //   757: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   760: aload 10
    //   762: ifnull +8 -> 770
    //   765: aload 10
    //   767: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   770: aload 8
    //   772: astore 9
    //   774: aload 10
    //   776: astore 7
    //   778: aload 8
    //   780: ifnull -315 -> 465
    //   783: aload 8
    //   785: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   788: aload 8
    //   790: astore 9
    //   792: aload 10
    //   794: astore 7
    //   796: goto -331 -> 465
    //   799: astore 7
    //   801: aload 7
    //   803: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   806: aload 8
    //   808: astore 9
    //   810: aload 10
    //   812: astore 7
    //   814: goto -349 -> 465
    //   817: astore_1
    //   818: aconst_null
    //   819: astore 8
    //   821: aload 11
    //   823: astore 7
    //   825: aload 8
    //   827: ifnull +8 -> 835
    //   830: aload 8
    //   832: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   835: aload 7
    //   837: ifnull +8 -> 845
    //   840: aload 7
    //   842: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   845: aload_1
    //   846: athrow
    //   847: astore 7
    //   849: aload 7
    //   851: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   854: goto -9 -> 845
    //   857: astore_1
    //   858: aload_1
    //   859: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   862: goto -281 -> 581
    //   865: astore 8
    //   867: aload 9
    //   869: astore_1
    //   870: aload 8
    //   872: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   875: aload 7
    //   877: ifnull +8 -> 885
    //   880: aload 7
    //   882: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   885: aload_1
    //   886: ifnull -305 -> 581
    //   889: aload_1
    //   890: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   893: goto -312 -> 581
    //   896: astore_1
    //   897: aload_1
    //   898: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   901: goto -320 -> 581
    //   904: astore_1
    //   905: aload 9
    //   907: astore 8
    //   909: aload 7
    //   911: ifnull +8 -> 919
    //   914: aload 7
    //   916: invokevirtual 814	java/io/BufferedOutputStream:close	()V
    //   919: aload 8
    //   921: ifnull +8 -> 929
    //   924: aload 8
    //   926: invokevirtual 815	java/io/FileOutputStream:close	()V
    //   929: aload_1
    //   930: athrow
    //   931: astore 7
    //   933: aload 7
    //   935: invokevirtual 826	java/io/IOException:printStackTrace	()V
    //   938: goto -9 -> 929
    //   941: astore_1
    //   942: goto -33 -> 909
    //   945: astore_1
    //   946: aload 9
    //   948: astore 7
    //   950: goto -41 -> 909
    //   953: astore 9
    //   955: aload_1
    //   956: astore 8
    //   958: aload 9
    //   960: astore_1
    //   961: goto -52 -> 909
    //   964: astore 9
    //   966: aload 8
    //   968: astore_1
    //   969: aload 9
    //   971: astore 8
    //   973: goto -103 -> 870
    //   976: astore 10
    //   978: aload 8
    //   980: astore_1
    //   981: aload 9
    //   983: astore 7
    //   985: aload 10
    //   987: astore 8
    //   989: goto -119 -> 870
    //   992: astore_1
    //   993: aconst_null
    //   994: astore 8
    //   996: goto -171 -> 825
    //   999: astore_1
    //   1000: goto -175 -> 825
    //   1003: astore_1
    //   1004: aload 8
    //   1006: astore 7
    //   1008: aload 10
    //   1010: astore 8
    //   1012: goto -187 -> 825
    //   1015: astore 9
    //   1017: aload 7
    //   1019: astore 8
    //   1021: aload 9
    //   1023: astore 7
    //   1025: goto -270 -> 755
    //   1028: astore 9
    //   1030: aload 8
    //   1032: astore 10
    //   1034: aload 7
    //   1036: astore 8
    //   1038: aload 9
    //   1040: astore 7
    //   1042: goto -287 -> 755
    //   1045: aconst_null
    //   1046: astore 8
    //   1048: aload 12
    //   1050: astore 10
    //   1052: goto -623 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	this	EditVideoArtFilter
    //   0	1055	1	paramBitmap	Bitmap
    //   237	14	2	f	float
    //   158	146	3	i	int
    //   217	76	4	j	int
    //   166	73	5	k	int
    //   363	8	6	bool	boolean
    //   264	196	7	localObject1	Object
    //   643	3	7	localOutOfMemoryError1	OutOfMemoryError
    //   695	3	7	localOutOfMemoryError2	OutOfMemoryError
    //   732	3	7	localIOException1	java.io.IOException
    //   745	1	7	localObject2	Object
    //   750	6	7	localException1	java.lang.Exception
    //   776	19	7	localObject3	Object
    //   799	3	7	localIOException2	java.io.IOException
    //   812	29	7	localObject4	Object
    //   847	68	7	localIOException3	java.io.IOException
    //   931	3	7	localIOException4	java.io.IOException
    //   948	93	7	localObject5	Object
    //   349	482	8	localObject6	Object
    //   865	6	8	localException2	java.lang.Exception
    //   907	140	8	localObject7	Object
    //   268	679	9	localObject8	Object
    //   953	6	9	localObject9	Object
    //   964	18	9	localException3	java.lang.Exception
    //   1015	7	9	localException4	java.lang.Exception
    //   1028	11	9	localException5	java.lang.Exception
    //   1	810	10	localObject10	Object
    //   976	33	10	localException6	java.lang.Exception
    //   1032	19	10	localObject11	Object
    //   4	818	11	localObject12	Object
    //   7	1042	12	localObject13	Object
    //   149	368	13	str	String
    // Exception table:
    //   from	to	target	type
    //   72	86	637	java/lang/OutOfMemoryError
    //   256	266	643	java/lang/OutOfMemoryError
    //   654	662	674	java/io/IOException
    //   666	674	674	java/io/IOException
    //   680	692	695	java/lang/OutOfMemoryError
    //   706	714	726	java/io/IOException
    //   718	726	726	java/io/IOException
    //   434	439	732	java/io/IOException
    //   452	457	732	java/io/IOException
    //   151	211	750	java/lang/Exception
    //   211	256	750	java/lang/Exception
    //   256	266	750	java/lang/Exception
    //   270	313	750	java/lang/Exception
    //   322	340	750	java/lang/Exception
    //   645	650	750	java/lang/Exception
    //   680	692	750	java/lang/Exception
    //   697	702	750	java/lang/Exception
    //   765	770	799	java/io/IOException
    //   783	788	799	java/io/IOException
    //   151	211	817	finally
    //   211	256	817	finally
    //   256	266	817	finally
    //   270	313	817	finally
    //   322	340	817	finally
    //   645	650	817	finally
    //   680	692	817	finally
    //   697	702	817	finally
    //   830	835	847	java/io/IOException
    //   840	845	847	java/io/IOException
    //   566	571	857	java/io/IOException
    //   576	581	857	java/io/IOException
    //   472	490	865	java/lang/Exception
    //   880	885	896	java/io/IOException
    //   889	893	896	java/io/IOException
    //   472	490	904	finally
    //   914	919	931	java/io/IOException
    //   924	929	931	java/io/IOException
    //   490	501	941	finally
    //   501	556	945	finally
    //   556	561	945	finally
    //   870	875	953	finally
    //   490	501	964	java/lang/Exception
    //   501	556	976	java/lang/Exception
    //   556	561	976	java/lang/Exception
    //   340	351	992	finally
    //   351	370	999	finally
    //   375	416	999	finally
    //   416	421	999	finally
    //   755	760	1003	finally
    //   340	351	1015	java/lang/Exception
    //   351	370	1028	java/lang/Exception
    //   375	416	1028	java/lang/Exception
    //   416	421	1028	java/lang/Exception
  }
  
  class a
    extends BaseAdapter
  {
    LruCache<String, Bitmap> g;
    Context mContext;
    int mReqHeight;
    int mReqWidth;
    int mSelectedPosition = -1;
    List<rfh> ox;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.ox = new ArrayList();
      this.mReqHeight = riw.dip2px(this.mContext, 130.0F);
      this.mReqWidth = riw.dip2px(this.mContext, 96.0F);
      this.g = new LruCache(20);
    }
    
    public rfh a(int paramInt)
    {
      if (paramInt < this.ox.size()) {
        return (rfh)this.ox.get(paramInt);
      }
      return null;
    }
    
    public void eL(List<rfh> paramList)
    {
      this.ox.clear();
      rfh localrfh = new rfh();
      this.ox.add(localrfh);
      this.ox.addAll(paramList);
      this.mSelectedPosition = 0;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.ox.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala;
      View localView1;
      if (paramView == null)
      {
        locala = new a();
        localView1 = LayoutInflater.from(this.mContext).inflate(2131559493, null);
        locala.nf = ((ImageView)localView1.findViewById(2131379633));
        locala.oC = localView1.findViewById(2131377963);
        localView1.setTag(locala);
      }
      rfh localrfh;
      for (;;)
      {
        localrfh = a(paramInt);
        if (localrfh != null) {
          break;
        }
        EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
        return localView1;
        locala = (a)paramView.getTag();
        localView1 = paramView;
      }
      paramView = (Bitmap)this.g.get(localrfh.id + localrfh.name);
      View localView2 = paramView;
      if (paramView == null)
      {
        if (paramInt != 0) {
          break label272;
        }
        paramView = aqcu.decodeSampledBitmapFromResource(EditVideoArtFilter.this.context.getResources(), 2130842323, this.mReqWidth, this.mReqHeight);
        label180:
        localView2 = paramView;
        if (paramView != null)
        {
          this.g.put(localrfh.id + localrfh.name, paramView);
          localView2 = paramView;
        }
      }
      locala.nf.setImageBitmap(localView2);
      if (paramInt == 0)
      {
        locala.nf.setContentDescription(acfp.m(2131705561));
        label252:
        if (paramInt != this.mSelectedPosition) {
          break label329;
        }
        locala.oC.setVisibility(0);
      }
      for (;;)
      {
        break;
        label272:
        paramView = aqcu.decodeSampledBitmapFromFile(localrfh.thumbPath, this.mReqWidth, this.mReqHeight);
        break label180;
        locala.nf.setContentDescription(acfp.m(2131705710) + localrfh.azY);
        break label252;
        label329:
        locala.oC.setVisibility(4);
      }
    }
    
    class a
    {
      ImageView nf;
      View oC;
      
      a() {}
    }
  }
  
  public class b
    extends Handler
  {
    b() {}
    
    public void dispatchMessage(Message paramMessage)
    {
      super.dispatchMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
          EditVideoArtFilter.a(EditVideoArtFilter.this, false);
          localObject = (String)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER SUCCESS,fileOutputPath:" + (String)localObject);
          }
          EditVideoArtFilter.this.bx((String)localObject, paramMessage.arg1);
          EditVideoArtFilter.this.a.as(0, true);
          return;
          EditVideoArtFilter.a(EditVideoArtFilter.this, false);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER ERROR");
          }
          EditVideoArtFilter.this.a.btH();
          QQToast.a(EditVideoArtFilter.this.context, EditVideoArtFilter.this.context.getResources().getString(2131690524), 0).show();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER TIMEOUT,state:isProcessing:" + EditVideoArtFilter.this.aGJ + ",taskId:" + paramMessage.obj + ",currentFilterTaskId:" + EditVideoArtFilter.this.an);
          }
        } while ((!EditVideoArtFilter.this.aGJ) || (((Integer)paramMessage.obj).intValue() != EditVideoArtFilter.this.an.get()));
        EditVideoArtFilter.a(EditVideoArtFilter.this, false);
        EditVideoArtFilter.this.bsy();
        QQToast.a(EditVideoArtFilter.this.context, EditVideoArtFilter.this.context.getResources().getString(2131690524), 0).show();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "UPDATE_FILTER_PROGRESS,state:isProcessing:" + EditVideoArtFilter.this.aGJ + ",taskId:" + paramMessage.arg1 + ",updateCount:" + paramMessage.arg2 + ",currentFilterTaskId:" + EditVideoArtFilter.this.an);
        }
      } while ((!EditVideoArtFilter.this.aGJ) || (EditVideoArtFilter.this.a.fV.getVisibility() != 0) || (paramMessage.arg1 != EditVideoArtFilter.this.an.get()));
      EditVideoArtFilter.this.a.as(paramMessage.arg2, false);
      Object localObject = EditVideoArtFilter.a(EditVideoArtFilter.this).obtainMessage(38);
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).arg2 = (paramMessage.arg2 + 1);
      EditVideoArtFilter.a(EditVideoArtFilter.this).sendMessageDelayed((Message)localObject, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoArtFilter
 * JD-Core Version:    0.7.0.1
 */