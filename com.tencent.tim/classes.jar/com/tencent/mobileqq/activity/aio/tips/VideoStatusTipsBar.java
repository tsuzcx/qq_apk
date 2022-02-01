package com.tencent.mobileqq.activity.aio.tips;

import acdu;
import acff;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import apuh;
import aqdj;
import aqgv;
import aqha;
import aqiw;
import aqji;
import aqji.c;
import aqju;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.g;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ivv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import jjk;
import jll;
import mqq.os.MqqHandler;
import yjf;
import yjh;
import yjq;

public class VideoStatusTipsBar
  implements View.OnClickListener, yjf
{
  private final String TAG;
  private RefreshMultiStateRunnable jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable;
  private yjh jdField_a_of_type_Yjh;
  private QQAppInterface app;
  private LinearLayout hq;
  private LinearLayout hr;
  Context mContext;
  protected float mDensity;
  private ImageView[] n = new ImageView[3];
  private ImageView[] o = new ImageView[3];
  private SessionInfo sessionInfo;
  private MqqHandler uiHandler;
  private View xM;
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, yjh paramyjh, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.TAG = ("VideoStatusTipsBar." + paramSessionInfo.cZ + "." + paramSessionInfo.aTl + "_" + AudioHelper.hG());
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Yjh = paramyjh;
    this.mContext = paramContext;
    this.uiHandler = paramMqqHandler;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "VideoStatusTipsBar, curFriendUin[" + paramSessionInfo.aTl + "], curType[" + paramSessionInfo.cZ + "]");
    }
  }
  
  private boolean TG()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.app.a().sM())
    {
      bool1 = bool2;
      if (!this.app.bF())
      {
        jjk.S(false, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "startGroupAudio phone is calling!");
        }
        String str1 = this.mContext.getString(2131697899);
        String str2 = this.mContext.getString(2131697879);
        aqha.a(this.mContext, 230, str2, str1, 2131721058, 2131721079, new yjq(this), null).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    if (!aqiw.isNetSupport(paramContext.getApplicationContext())) {
      QQToast.a(paramContext, 2131696206, 0).show(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131299627));
    }
    boolean bool2;
    Intent localIntent;
    long[] arrayOfLong;
    for (;;)
    {
      return;
      if (paramString1 != null)
      {
        bool2 = paramQQAppInterface.a().cw(paramString1);
        if ((paramInt2 == 2) && (!bool2))
        {
          paramString2 = new HashMap();
          paramString2.put("MultiAVType", String.valueOf(2));
          paramString2.put("from", "tipBar");
          ChatActivityUtils.a(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2);
          return;
        }
        if (paramQQAppInterface.a().getSessionType() == 4) {}
        for (boolean bool1 = true; !paramQQAppInterface.a().a(paramContext, paramInt1, paramString1, bool1); bool1 = false)
        {
          localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
          localIntent.addFlags(262144);
          localIntent.addFlags(268435456);
          if (paramInt1 != 3000) {
            break label271;
          }
          ArrayList localArrayList = ((acdu)paramQQAppInterface.getManager(53)).z(paramString1);
          if (localArrayList == null) {
            break label390;
          }
          int j = localArrayList.size();
          arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
            if (localDiscussionMemberInfo != null) {
              arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
            }
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", arrayOfLong);
      label271:
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString1);
      localIntent.putExtra("openClass", paramBoolean);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("Fromwhere", paramString2);
      localIntent.putExtra("flag", bool2);
      if (1 == paramInt1) {
        localIntent.putExtra("groupInfo", aqji.b(paramQQAppInterface, paramString1));
      }
      paramContext.startActivity(localIntent);
      return;
      label390:
      arrayOfLong = null;
    }
  }
  
  private void ciH()
  {
    if (this.xM == null)
    {
      aqji.c.edX();
      this.xM = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131558674, null);
      this.xM.setId(2131372045);
      this.xM.setPadding(0, (int)(this.mDensity * 2.0F), 0, (int)(this.mDensity * 2.0F));
      this.xM.setClickable(true);
      this.xM.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label252;
      }
      this.xM.setBackgroundResource(2130839720);
    }
    for (;;)
    {
      this.hq = ((LinearLayout)this.xM.findViewById(2131363200));
      this.n[0] = ((ImageView)this.hq.findViewById(2131363177));
      this.n[1] = ((ImageView)this.hq.findViewById(2131363179));
      this.n[2] = ((ImageView)this.hq.findViewById(2131363181));
      this.hr = ((LinearLayout)this.xM.findViewById(2131363218));
      this.o[0] = ((ImageView)this.hr.findViewById(2131363215));
      this.o[1] = ((ImageView)this.hr.findViewById(2131363216));
      this.o[2] = ((ImageView)this.hr.findViewById(2131363217));
      return;
      label252:
      this.xM.setBackgroundColor(Color.parseColor("#1f1f1f"));
    }
  }
  
  private int fo(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 22: 
    default: 
      i = 3;
    case 20: 
    case 21: 
      return i;
    }
    return 2;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.xM;
  }
  
  public a a(int paramInt1, long paramLong1, int paramInt2, boolean paramBoolean, long paramLong2, TextView paramTextView)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    AVNotifyCenter.g localg = this.app.a().a(paramInt1, paramLong1);
    if (localg == null)
    {
      if (this.sessionInfo.cZ == 3000)
      {
        localObject1 = this.mContext.getString(2131690198);
        str = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
        localObject1 = str;
        localObject2 = localObject3;
        if (paramInt2 == 2)
        {
          localObject1 = str;
          localObject2 = localObject3;
          if (paramLong2 > 99L)
          {
            if (!paramBoolean) {
              break label243;
            }
            localObject1 = this.mContext.getString(2131690188);
          }
        }
      }
      for (localObject2 = localObject3;; localObject2 = localObject3)
      {
        paramTextView.setVisibility(8);
        if (this.sessionInfo.cZ != 3000) {
          break label773;
        }
        jll.b(this.xM, this.mContext.getString(2131697734));
        label167:
        paramTextView = new a();
        paramTextView.name = ((String)localObject2);
        paramTextView.text = ((String)localObject1);
        return paramTextView;
        localObject1 = localObject4;
        if (this.sessionInfo.cZ != 1) {
          break;
        }
        if (paramBoolean)
        {
          localObject1 = this.mContext.getString(2131690159);
          break;
        }
        localObject1 = this.mContext.getString(2131690154);
        break;
        label243:
        localObject1 = this.mContext.getString(2131690189);
      }
    }
    if (localg.Te)
    {
      localObject1 = this.app.a().ai(localg.id);
      if (localObject1 == null) {
        if (this.sessionInfo.cZ == 3000)
        {
          localObject1 = this.mContext.getString(2131690198);
          label317:
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label809;
          }
          localObject2 = this.mContext.getString(2131690189);
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      localObject1 = localObject2;
      if (this.sessionInfo.cZ != 1) {
        break label317;
      }
      localObject1 = this.mContext.getString(2131690154);
      break label317;
      if (paramLong2 == 1L)
      {
        localObject2 = this.mContext.getString(2131690199);
      }
      else
      {
        if (this.sessionInfo.cZ == 3000) {
          localObject2 = this.mContext.getString(2131690197);
        }
        for (;;)
        {
          localObject2 = String.format((String)localObject2, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label806;
          }
          localObject2 = this.mContext.getString(2131690160);
          break;
          localObject2 = str;
          if (this.sessionInfo.cZ == 1) {
            localObject2 = this.mContext.getString(2131690153);
          }
        }
        localObject2 = Long.toString(localg.id);
        localObject3 = Long.toString(paramLong1);
        paramInt1 = 2;
        if (this.sessionInfo.cZ == 1) {
          paramInt1 = 1;
        }
        localObject3 = aqgv.a(this.app, (String)localObject2, (String)localObject3, paramInt1, 0);
        if (paramLong2 == 1L)
        {
          localObject1 = this.mContext.getString(2131690199);
          localObject2 = localObject3;
          break;
        }
        if (this.sessionInfo.cZ == 3000) {
          localObject1 = this.mContext.getString(2131690197);
        }
        for (;;)
        {
          str = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          localObject1 = str;
          localObject2 = localObject3;
          if (paramInt2 != 2) {
            break;
          }
          localObject1 = str;
          localObject2 = localObject3;
          if (paramLong2 <= 99L) {
            break;
          }
          if (!paramBoolean) {
            break label754;
          }
          localObject1 = this.mContext.getString(2131690188);
          localObject2 = localObject3;
          break;
          if (this.sessionInfo.cZ == 1) {
            if (paramBoolean) {
              localObject1 = this.mContext.getString(2131690159);
            } else {
              localObject1 = this.mContext.getString(2131690153);
            }
          }
        }
        label754:
        localObject1 = this.mContext.getString(2131690160);
        localObject2 = localObject3;
        break;
        label773:
        if (this.sessionInfo.cZ != 1) {
          break label167;
        }
        jll.b(this.xM, this.mContext.getString(2131697767), paramInt2);
        break label167;
        label806:
        continue;
        label809:
        localObject1 = null;
      }
    }
  }
  
  public a a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject2 = this.app.getCurrentAccountUin();
    Object localObject1 = Long.toString(paramLong1);
    if ((paramLong1 != 0L) && (!((String)localObject2).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject2 = Long.toString(paramLong2);
      int i = 2;
      if (this.sessionInfo.cZ == 1) {
        i = 1;
      }
      localObject2 = aqgv.a(this.app, (String)localObject1, (String)localObject2, i, 0);
      if (paramInt2 == 1) {
        if (this.sessionInfo.cZ == 3000) {
          localObject1 = this.mContext.getString(2131690201);
        }
      }
    }
    for (;;)
    {
      paramTextView.setVisibility(8);
      paramTextView = (TextView)localObject2;
      for (;;)
      {
        if (this.sessionInfo.cZ == 3000)
        {
          jll.b(this.xM, this.mContext.getString(2131694257));
          label150:
          paramImageView.setVisibility(0);
          paramImageView = new a();
          paramImageView.name = paramTextView;
          paramImageView.text = ((String)localObject1);
          return paramImageView;
          if (this.sessionInfo.cZ != 1) {
            break label492;
          }
          localObject1 = this.mContext.getString(2131690155);
          break;
          if (paramInt2 != 2) {
            break label492;
          }
          if (this.sessionInfo.cZ == 3000)
          {
            localObject1 = this.mContext.getString(2131690202);
            break;
          }
          if (this.sessionInfo.cZ != 1) {
            break label492;
          }
          localObject1 = this.mContext.getString(2131690156);
          break;
          if (this.app.a().uo())
          {
            localObject1 = this.mContext.getString(2131690203);
            this.app.a().iy(false);
            localObject2 = localObject1;
            if (paramInt1 == 2)
            {
              paramTextView.setVisibility(8);
              paramTextView = null;
            }
          }
          else
          {
            if (this.sessionInfo.cZ != 3000) {
              break label407;
            }
            localObject1 = this.mContext.getString(2131690194);
          }
        }
      }
      for (;;)
      {
        this.app.a().iy(true);
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
        }
        paramTextView.setVisibility(0);
        localObject1 = localObject2;
        paramTextView = null;
        break;
        label407:
        if (this.sessionInfo.cZ == 1)
        {
          if (paramBoolean)
          {
            localObject1 = this.mContext.getString(2131690191);
            continue;
          }
          localObject1 = this.mContext.getString(2131690187);
          continue;
          if (this.sessionInfo.cZ != 1) {
            break label150;
          }
          jll.b(this.xM, this.mContext.getString(2131694258), paramInt1);
          break label150;
        }
        localObject1 = null;
      }
      label492:
      localObject1 = null;
    }
  }
  
  String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "refreshMultiVideoStatus[" + paramString1 + "], uinType[" + paramInt1 + "], uin[" + paramString2 + "], type[" + paramInt2 + "], memberUin[" + paramLong + "], curType[" + this.sessionInfo.cZ + "]");
    }
    if ((this.sessionInfo.cZ != 3000) && (this.sessionInfo.cZ != 1)) {}
    for (;;)
    {
      if (getType() == this.jdField_a_of_type_Yjh.wN()) {
        this.jdField_a_of_type_Yjh.ciA();
      }
      return;
      try
      {
        l3 = Long.parseLong(paramString2);
        k = jll.cL(this.sessionInfo.cZ);
        l2 = this.app.a().d(k, l3);
        localObject = this.app.a().a(l3);
        i = this.app.a().z(l3);
        bool3 = this.app.a().i(k, l3);
        l1 = l2;
        paramInt1 = paramInt2;
        if (k == 1)
        {
          l1 = l2;
          paramInt1 = paramInt2;
          if (!bool3)
          {
            l1 = l2;
            paramInt1 = paramInt2;
            if (paramString2 != null)
            {
              l1 = l2;
              paramInt1 = paramInt2;
              if (TextUtils.isDigitsOnly(paramString2))
              {
                paramInt1 = paramInt2;
                try
                {
                  paramString1 = this.app.a().a(Long.parseLong(paramString2));
                  if (paramString1 == null) {
                    break label2372;
                  }
                  paramInt1 = paramInt2;
                  if (paramString1.aqy == 10)
                  {
                    paramInt1 = paramInt2;
                    if (paramString1.memberNum > 0)
                    {
                      paramInt1 = paramInt2;
                      if (System.currentTimeMillis() > paramString1.time + 90000L)
                      {
                        paramInt1 = paramInt2;
                        QLog.w(this.TAG, 1, "refreshMultiVideoStatus, 跑马灯超时," + paramString1 + "]");
                        paramInt1 = paramInt2;
                        paramString1.memberNum = 0;
                        paramInt1 = paramInt2;
                        this.app.a().a(14, k, l3, null, 0L);
                      }
                    }
                  }
                  paramInt1 = paramInt2;
                  paramInt2 = fo(paramString1.aqA);
                  paramInt1 = paramInt2;
                  j = paramString1.memberNum;
                  l1 = j;
                }
                catch (NumberFormatException paramString1)
                {
                  label581:
                  paramInt2 = paramInt1;
                }
              }
            }
          }
        }
        try
        {
          paramInt1 = paramString1.aqy;
          j = 1;
          i = paramInt1;
          paramInt1 = j;
          j = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = i;
          i = j;
          if ((paramInt2 != 10) && (paramInt2 != 2)) {
            break label2366;
          }
          this.app.a().q(l3, paramInt2, (int)l1);
          if (paramInt2 != 2) {
            break label2366;
          }
          paramString1 = this.app.a().a(l3, paramInt2);
          j = 21;
          if (paramString1 == null) {
            break label2366;
          }
          if ((paramString1.ang != 2) || (paramString1.gameId != 4) || (paramString1.aqz != 0)) {
            break label1020;
          }
          bool1 = true;
          if (paramString1.memberNum <= 0) {
            j = 23;
          }
          this.app.a().a(2, l3, paramInt2, paramString1.ang, paramString1.gameId, paramString1.aqz, j, paramString1.memberNum);
        }
        catch (NumberFormatException paramString1)
        {
          for (;;)
          {
            acff localacff;
            float f;
            l2 = l1;
            continue;
            paramString1 = (String)localObject;
          }
          bool1 = false;
          break label581;
        }
        if (l1 <= 0L) {
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 1, "refreshMultiVideoStatus, 显示跑马灯, memberNum[" + l1 + "], avtype[" + paramInt2 + "], isChating[" + bool3 + "], step[" + i + "]");
        }
        ciH();
        localTextView = (TextView)this.xM.findViewById(2131379512);
        localImageView1 = (ImageView)this.xM.findViewById(2131368740);
        localImageView2 = (ImageView)this.xM.findViewById(2131368739);
        if (bool3)
        {
          paramString1 = a(paramLong, l3, paramInt2, bool1, paramInt1, l1, localTextView, localImageView1);
          if ((paramInt1 != 1) && (paramInt1 != 2)) {
            break label1046;
          }
          gk(3000L);
          paramInt1 = this.mContext.getResources().getColor(2131167452);
          a(paramString1.name, paramString1.text, paramInt1, String.valueOf(l3), paramInt2);
          localTextView.setTextColor(paramInt1);
          bool2 = ThemeUtil.isInNightMode(this.app);
          if ((paramInt2 != 2) || (this.app.a().cw(paramString2))) {
            break label1348;
          }
          localImageView2.setImageDrawable(null);
          anot.a(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.sessionInfo.aTl, "" + apuh.n(this.app, this.sessionInfo.aTl), "", "");
          this.hq.setVisibility(0);
          if ((localObject != null) && (((Vector)localObject).size() != 0)) {
            break label1056;
          }
          paramString1 = this.n;
          paramInt2 = paramString1.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramString1[paramInt1].setVisibility(8);
            paramInt1 += 1;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          int k;
          long l2;
          Object localObject;
          boolean bool3;
          TextView localTextView;
          ImageView localImageView1;
          ImageView localImageView2;
          boolean bool2;
          long l3 = 0L;
          continue;
          long l1 = l2;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e(this.TAG, 2, "refreshMultiVideoStatus error : " + paramString1);
            paramInt1 = paramInt2;
            l1 = l2;
          }
          int j = 0;
          paramInt2 = i;
          int i = j;
          continue;
          label1020:
          boolean bool1 = false;
          continue;
          paramString1 = a(k, l3, paramInt2, bool1, l1, localTextView);
          continue;
          label1046:
          gk(90000L);
          continue;
          label1056:
          if (((Vector)localObject).size() == 1)
          {
            this.n[0].setVisibility(0);
            this.n[1].setVisibility(8);
            this.n[2].setVisibility(8);
            this.n[0].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((Vector)localObject).get(0)).id)));
            if (ThemeUtil.isInNightMode(this.app)) {
              break label2335;
            }
            localImageView1.setImageResource(2130839710);
            label1143:
            bool2 = true;
            bool1 = bool2;
            if (this.app.bF())
            {
              bool1 = bool2;
              if (bool3) {
                if (this.app.a().ll() != 2) {
                  break label2346;
                }
              }
            }
          }
          label1444:
          label1575:
          label2346:
          for (bool1 = true;; bool1 = false)
          {
            zZ(bool1);
            return;
            if (((Vector)localObject).size() == 2)
            {
              this.n[0].setVisibility(0);
              this.n[1].setVisibility(0);
              this.n[2].setVisibility(8);
              this.n[0].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((Vector)localObject).get(0)).id)));
              this.n[1].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((Vector)localObject).get(1)).id)));
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < this.n.length)
            {
              this.n[paramInt1].setVisibility(0);
              this.n[paramInt1].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((Vector)localObject).get(paramInt1)).id)));
              paramInt1 += 1;
            }
            break;
            label1348:
            if (((paramInt2 == 10) || (paramInt2 == 1) || (k == 2)) && (!this.app.a().cw(paramString2)))
            {
              if (k != 2) {
                break label2360;
              }
              paramString1 = this.app.a().a(k, l3);
              if ((paramString1 != null) && (paramString1.size() == 1) && (this.app.getCurrentUin().equalsIgnoreCase(String.valueOf(((AVNotifyCenter.g)paramString1.get(0)).id))))
              {
                bool1 = true;
                if ((paramString1 != null) && (paramString1.size() != 0) && (!bool1)) {
                  break label1575;
                }
                if (!bool2) {
                  break label1568;
                }
              }
              for (paramInt1 = 2130850854;; paramInt1 = 2130850853)
              {
                localImageView2.setImageResource(paramInt1);
                if (bool1)
                {
                  paramString1 = (TextView)this.xM.findViewById(2131373919);
                  if (paramString1 != null) {
                    paramString1.setText(this.mContext.getString(2131690196));
                  }
                }
                this.hq.setVisibility(8);
                this.hr.setVisibility(8);
                QLog.w(this.TAG, 1, "拿不到用户数据，放弃展示 aloneStatus:" + bool1);
                break;
                bool1 = false;
                break label1444;
              }
              localImageView2.setImageBitmap(null);
              this.hq.setVisibility(8);
              this.hr.setVisibility(0);
              localacff = (acff)this.app.getManager(51);
              localObject = new ArrayList(3);
              paramInt1 = 0;
              label1624:
              if (paramInt1 < paramString1.size())
              {
                if (localacff.isFriend(String.valueOf(((AVNotifyCenter.g)paramString1.get(paramInt1)).id))) {
                  ((ArrayList)localObject).add(paramString1.get(paramInt1));
                }
                if (((ArrayList)localObject).size() != 3) {}
              }
              else
              {
                localacff = (acff)this.app.getManager(51);
                if (((ArrayList)localObject).size() != 0) {
                  break label1959;
                }
                paramLong = ((AVNotifyCenter.g)paramString1.get(0)).id;
                paramString1 = String.valueOf(paramLong);
                if (!localacff.isFriend(paramString1)) {
                  break label2189;
                }
                if (((ArrayList)localObject).size() != 1) {
                  break label1976;
                }
                this.o[0].setVisibility(0);
                this.o[1].setVisibility(8);
                this.o[2].setVisibility(8);
                this.o[0].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((ArrayList)localObject).get(0)).id)));
              }
              for (;;)
              {
                paramInt1 = 2;
                if (this.sessionInfo.cZ == 1) {
                  paramInt1 = 1;
                }
                paramString2 = aqgv.a(this.app, paramString1, paramString2, paramInt1, 0);
                paramString1 = null;
                if (l1 != 1L) {
                  break label2223;
                }
                paramString1 = this.mContext.getString(2131690200);
                localObject = (TextView)this.xM.findViewById(2131373919);
                if (localObject != null)
                {
                  f = this.xM.getResources().getDimensionPixelSize(2131297409);
                  ((TextView)localObject).setText(new StringBuilder(jll.a(this.xM.getContext(), paramString2.toString(), (TextView)localObject, f)).append(paramString1));
                }
                if (localTextView.getVisibility() == 0) {
                  localTextView.setVisibility(8);
                }
                paramString1 = (TextView)this.xM.findViewById(2131372051);
                if (paramString1 == null) {
                  break;
                }
                paramString1.setVisibility(8);
                break;
                paramInt1 += 1;
                break label1624;
                paramLong = ((AVNotifyCenter.g)((ArrayList)localObject).get(0)).id;
                break label1709;
                if (((ArrayList)localObject).size() == 2)
                {
                  this.o[0].setVisibility(0);
                  this.o[1].setVisibility(0);
                  this.o[2].setVisibility(8);
                  this.o[0].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((ArrayList)localObject).get(0)).id)));
                  this.o[1].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((ArrayList)localObject).get(1)).id)));
                }
                else if (((ArrayList)localObject).size() == 3)
                {
                  paramInt1 = 0;
                  while (paramInt1 < this.o.length)
                  {
                    this.o[paramInt1].setVisibility(0);
                    this.o[paramInt1].setImageDrawable(j(String.valueOf(((AVNotifyCenter.g)((ArrayList)localObject).get(paramInt1)).id)));
                    paramInt1 += 1;
                  }
                }
                else
                {
                  this.o[0].setVisibility(0);
                  this.o[1].setVisibility(8);
                  this.o[2].setVisibility(8);
                  this.o[0].setImageDrawable(j(paramString1));
                }
              }
              if (bool2) {}
              for (paramInt1 = 2130850854;; paramInt1 = 2130850853)
              {
                localImageView2.setImageResource(paramInt1);
                this.hr.setVisibility(8);
                break;
              }
              if (this.sessionInfo.cZ == 3000) {
                paramString1 = this.mContext.getString(2131690197);
              }
              for (;;)
              {
                paramString1 = String.format(paramString1, new Object[] { Long.valueOf(l1) });
                break;
                if (this.sessionInfo.cZ == 1) {
                  paramString1 = this.mContext.getString(2131690153);
                }
              }
            }
            label1709:
            label1976:
            if (bool2) {}
            label2223:
            for (paramInt1 = 2130850854;; paramInt1 = 2130850853)
            {
              localImageView2.setImageResource(paramInt1);
              this.hq.setVisibility(8);
              this.hr.setVisibility(8);
              break;
            }
            localImageView1.setImageResource(2130839711);
            break label1143;
          }
          label1568:
          label1959:
          label2360:
          label2366:
          label2372:
          paramInt1 = 0;
          label2189:
          label2335:
          l1 = l2;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.xM.findViewById(2131379511);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.mContext.getApplicationContext());
      localTextView.setId(2131372051);
      float f = this.mContext.getResources().getDimensionPixelSize(2131297766);
      paramString1 = a(this.mContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.mContext.getResources().getDimensionPixelSize(2131297418));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    TextView localTextView = new TextView(this.mContext.getApplicationContext());
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {}
    try
    {
      paramInt1 = this.app.a().z(Long.valueOf(paramString3).longValue());
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = (String)this.app.a().cX.get(paramString3);
        if (paramString1 == null) {
          break label413;
        }
        i = Integer.valueOf(paramString1.split(";")[0]).intValue();
        paramInt2 = Integer.valueOf(paramString1.split(";")[1]).intValue();
        if (i != 1) {
          break label372;
        }
        if (paramInt2 > 99) {
          paramString1 = this.app.getApp().getString(2131697802);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131373919);
        if (ThemeUtil.isInNightMode(this.app)) {
          localTextView.setTextColor(Color.parseColor("#A8A8A8"));
        }
        localLinearLayout.addView(localTextView);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i;
        paramInt1 = 0;
        continue;
        paramString1 = String.format(this.app.getApp().getString(2131697801), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label372:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.app.getApp().getString(2131721245), this.app.getApp().getString(2131721246));
          continue;
          label413:
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void ciE()
  {
    a("showMeetinInvitedInfo", this.sessionInfo.cZ, this.sessionInfo.aTl, 4, 0L);
  }
  
  public void ciF()
  {
    a("cancelMeetingInvitedInfo", this.sessionInfo.cZ, this.sessionInfo.aTl, 4, 0L);
  }
  
  public void ciG()
  {
    this.app.a().iy(true);
    a("doRefreshMultiState", this.sessionInfo.cZ, this.sessionInfo.aTl, 0, 0L);
  }
  
  void ciI()
  {
    int j = jll.cL(this.sessionInfo.cZ);
    long l = Long.parseLong(this.sessionInfo.aTl);
    Object localObject = new HashMap();
    AVNotifyCenter.h localh = this.app.a().a(l);
    int i;
    boolean bool;
    if (localh != null)
    {
      i = localh.aqy;
      if ((i == 2) && (localh.ang == 2) && (localh.gameId == 4)) {
        bool = true;
      }
    }
    while (i == 2)
    {
      QQToast.a(this.app.getApp(), acfp.m(2131700838), 0).show(this.app.getApp().getResources().getDimensionPixelSize(2131299627));
      return;
      bool = false;
      continue;
      i = this.app.a().z(l);
      bool = false;
    }
    this.app.a().k(9, l, i);
    ((Map)localObject).put("MultiAVType", String.valueOf(i));
    if (i == 2)
    {
      ((Map)localObject).put("Fromwhere", "SmallScreen");
      if (!this.app.a().cw(this.sessionInfo.aTl)) {
        anot.a(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.sessionInfo.aTl, "" + apuh.n(this.app, this.sessionInfo.aTl), "2", "");
      }
    }
    if (this.app.a().i(j, l)) {
      if (this.app.a().as(String.valueOf(l)) == 14)
      {
        ((Map)localObject).put("from", "tipBar");
        ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo.cZ, this.sessionInfo.aTl, (Map)localObject);
        label354:
        if (this.sessionInfo.cZ != 3000) {
          break label583;
        }
        if (!this.app.a().i(j, l)) {
          break label585;
        }
      }
    }
    label583:
    label585:
    for (localObject = "Cover_back";; localObject = "Clk_discuss_floating")
    {
      anot.a(this.app, "CliOper", "", "", "Multi_call", (String)localObject, 0, 0, "", "", "", "");
      return;
      ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo.cZ, this.sessionInfo.aTl, true, true, null, (Map)localObject);
      break label354;
      a(this.app, this.mContext, this.sessionInfo.cZ, this.sessionInfo.aTl, i, bool, null);
      if (this.sessionInfo.cZ != 1) {
        break label354;
      }
      if (this.app.a().z(l) == 10)
      {
        anot.a(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        break label354;
      }
      anot.a(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
      break label354;
      break;
    }
  }
  
  void ciJ()
  {
    boolean bool = false;
    if (this.app.a().getSessionType() == 1) {
      bool = true;
    }
    if (this.app.a().cz(this.sessionInfo.aTl)) {
      if (this.app.a().aq(this.sessionInfo.aTl) == 1)
      {
        anot.a(this.app, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.aTn, null, bool, this.sessionInfo.troopUin, false, true, null, "from_internal");
      anot.a(this.app, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
      anot.a(this.app, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
      bool = false;
    }
  }
  
  public int getType()
  {
    return 2;
  }
  
  void gk(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable = new RefreshMultiStateRunnable(this);
    }
    for (;;)
    {
      if (this.uiHandler != null)
      {
        this.uiHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable, paramLong);
        this.app.a().iy(false);
      }
      return;
      this.uiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable);
    }
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label560:
    for (;;)
    {
      return;
      long l3 = AudioHelper.hG();
      if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
      {
        a("onAIOEvent_1_" + paramInt + "." + l3, this.sessionInfo.cZ, this.sessionInfo.aTl, 0, 0L);
        return;
      }
      int i = this.app.a().getSessionType();
      if (i == 3)
      {
        if (!this.app.a().cw(this.sessionInfo.aTl)) {
          a("onAIOEvent_2_" + paramInt + "." + l3, this.sessionInfo.cZ, this.sessionInfo.aTl, 0, 0L);
        }
      }
      else {
        for (;;)
        {
          if ((!this.app.a().cz(this.sessionInfo.aTl)) || (!((acff)this.app.getManager(51)).isFriend(this.sessionInfo.aTl))) {
            break label560;
          }
          paramVarArgs = this.sessionInfo.aTl;
          if (this.app.a().cz(paramVarArgs))
          {
            i = this.app.a().aq(paramVarArgs);
            if (i == 1) {
              anot.a(this.app, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (i == 2) {
              anot.a(this.app, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
            }
          }
          q(0, paramVarArgs, "");
          long l1 = 0L;
          try
          {
            long l2 = Long.parseLong(paramVarArgs);
            l1 = l2;
          }
          catch (Exception localException)
          {
            label357:
            Intent localIntent;
            break label357;
          }
          if (l1 == 0L) {
            break;
          }
          l1 = this.app.a().y(paramVarArgs);
          QLog.w(this.TAG, 1, "QueryRoomInfo.notify, eventType[" + paramInt + "], roomId[" + l1 + "], peerUin[" + paramVarArgs + "], seq[" + l3 + "]");
          localIntent = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
          localIntent.putExtra("roomId", l1);
          localIntent.putExtra("peerUin", Long.parseLong(paramVarArgs));
          localIntent.putExtra("uin", this.app.getAccount());
          localIntent.putExtra("seq", l3);
          this.mContext.sendBroadcast(localIntent);
          return;
          if ((i == 1) || (i == 2)) {
            q(this.app.a().lk(), this.app.a().ay(), this.app.a().gZ());
          }
        }
      }
    }
  }
  
  protected Drawable j(String paramString)
  {
    return aqdj.a(this.app, paramString, (byte)4);
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
      if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
      {
        long l = Long.parseLong(this.sessionInfo.aTl);
        boolean bool = this.app.a().cw(this.sessionInfo.aTl);
        AVNotifyCenter.h localh = this.app.a().a(l);
        if (localh != null) {}
        for (int i = localh.aqy;; i = this.app.a().z(l))
        {
          if (((i != 10) || (bool)) && (TG())) {
            break label148;
          }
          ciI();
          break;
        }
      }
      else
      {
        label148:
        if (!TG()) {
          ciJ();
        }
      }
    }
  }
  
  public void q(int paramInt, String paramString1, String paramString2)
  {
    boolean bool1 = this.app.a().cz(paramString1);
    boolean bool2 = this.app.bF();
    this.app.a().up();
    boolean bool3 = this.app.a().uo();
    int i;
    if (bool1) {
      i = this.app.a().aq(paramString1);
    }
    for (;;)
    {
      QLog.w(this.TAG, 1, "refreshVideoStatus, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], sessionType[" + i + "], isOtherTerminalAvChatting[" + bool1 + "], isVideoChatting[" + bool2 + "], SmallScreenState[" + this.app.a().ll() + "], isReceiver[" + this.app.a().up() + "], isWaittingState[" + this.app.a().uo() + "]");
      ImageView localImageView;
      TextView localTextView;
      if (((bool2) && (!this.app.a().sB()) && ((i == 1) || (i == 2)) && (this.sessionInfo.cZ == paramInt) && ((this.sessionInfo.aTl.equals(paramString1)) || (this.sessionInfo.aTl.equals(paramString2)))) || ((bool1) && (this.sessionInfo.aTl.equals(paramString1)))) {
        if (this.xM == null)
        {
          this.xM = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131558674, null);
          this.xM.setId(2131372045);
          this.xM.setPadding(0, (int)(2.0F * this.mDensity), 0, (int)(2.0F * this.mDensity));
          this.xM.setBackgroundResource(2130839720);
          this.xM.setClickable(true);
          this.hq = ((LinearLayout)this.xM.findViewById(2131363200));
          this.hr = ((LinearLayout)this.xM.findViewById(2131363218));
          localImageView = (ImageView)this.xM.findViewById(2131368740);
          localTextView = (TextView)this.xM.findViewById(2131379512);
          label440:
          this.hq.setVisibility(8);
          this.hr.setVisibility(8);
          if (this.app.a().ay() == null) {}
        }
      }
      try
      {
        Long.parseLong(this.app.a().ay());
        label507:
        String str;
        if (bool1)
        {
          jll.b(this.xM, this.mContext.getString(2131697553));
          str = "";
          if (!bool1) {
            break label842;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.mContext.getResources().getString(2131697553);
          }
          if (i != 2) {
            break label990;
          }
          paramString2 = this.mContext.getResources().getString(2131698155);
          label560:
          a(null, paramString2, this.mContext.getResources().getColor(2131167312), paramString1, 0);
          QLog.i(this.TAG, 1, "refreshVideoStatus info=" + paramString2 + ", peerUin=" + paramString1);
          this.xM.setOnClickListener(this);
          if (ThemeUtil.isInNightMode(this.app)) {
            break label921;
          }
          this.xM.setBackgroundResource(2130839720);
          localImageView.setImageResource(2130839710);
          label655:
          localImageView.setVisibility(0);
          if ((!bool2) || (bool1)) {
            break label948;
          }
          if (this.app.a().ll() != 2) {
            break label942;
          }
          bool1 = true;
          label688:
          zZ(bool1);
          label694:
          if ((!bool2) || (this.app.a().uo())) {
            break label956;
          }
          localTextView.setVisibility(0);
        }
        label842:
        do
        {
          return;
          if (!bool2) {
            break label993;
          }
          i = this.app.a().getSessionType();
          break;
          localImageView = (ImageView)this.xM.findViewById(2131368740);
          localTextView = (TextView)this.xM.findViewById(2131379512);
          break label440;
          if (!bool2) {
            break label507;
          }
          if (paramInt == 1)
          {
            jll.b(this.xM, this.mContext.getString(2131690636), this.app.a().z(this.app.a().bG()));
            break label507;
          }
          jll.b(this.xM, this.mContext.getString(2131690636));
          break label507;
          paramString2 = str;
          if (!bool2) {
            break label990;
          }
          if (bool3)
          {
            paramString2 = this.mContext.getResources().getString(2131698196);
            break label560;
          }
          if (i == 1)
          {
            paramString2 = this.mContext.getResources().getString(2131697562);
            break label560;
          }
          paramString2 = str;
          if (i != 2) {
            break label990;
          }
          paramString2 = this.mContext.getResources().getString(2131698170);
          break label560;
          this.xM.setBackgroundColor(-14737633);
          localImageView.setImageResource(2130839711);
          break label655;
          bool1 = false;
          break label688;
          zZ(true);
          break label694;
          localTextView.setVisibility(8);
          return;
        } while (getType() != this.jdField_a_of_type_Yjh.wN());
        label921:
        label942:
        label948:
        label956:
        this.jdField_a_of_type_Yjh.ciA();
        return;
      }
      catch (Exception paramString2)
      {
        label990:
        for (;;) {}
        label993:
        i = 0;
      }
    }
  }
  
  public int wM()
  {
    return 61;
  }
  
  public void zZ(boolean paramBoolean)
  {
    if ((this.mContext != null) && ((this.mContext instanceof FragmentActivity))) {}
    for (boolean bool = ((FragmentActivity)this.mContext).isResume();; bool = false)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_Yjh != null)) {
        this.jdField_a_of_type_Yjh.a(this, new Object[0]);
      }
      ivv.a(this.xM, paramBoolean, bool);
      return;
    }
  }
  
  static class RefreshMultiStateRunnable
    implements Runnable
  {
    final WeakReference<VideoStatusTipsBar> mRef;
    
    public RefreshMultiStateRunnable(VideoStatusTipsBar paramVideoStatusTipsBar)
    {
      this.mRef = new WeakReference(paramVideoStatusTipsBar);
    }
    
    public void run()
    {
      VideoStatusTipsBar localVideoStatusTipsBar = (VideoStatusTipsBar)this.mRef.get();
      if (localVideoStatusTipsBar != null) {
        localVideoStatusTipsBar.ciG();
      }
    }
  }
  
  static class a
  {
    String name = null;
    String text = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */