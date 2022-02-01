package com.tencent.mobileqq.musicgene;

import acci;
import aiwn;
import aiwv;
import aixd;
import ajmi.a;
import ajmj;
import ajmq;
import ajmq.a;
import ajna;
import ajnd;
import ajne;
import ajnf;
import ajng;
import ajnh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import auvw;
import auvw.a;
import auvw.b;
import avqq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import svi;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final HashMap<String, Long> lK = new HashMap();
  private static final HashMap<String, String> lL = new HashMap();
  private static final HashMap<String, d> lM = new HashMap();
  private ImageView Bf;
  private ImageView Bg;
  private ImageView Bh;
  private ImageView Bi;
  private TextView UU;
  private TextView Uj;
  private ajmq.a jdField_a_of_type_Ajmq$a = new ajnf(this);
  private ajnh jdField_a_of_type_Ajnh;
  private final a jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$a = new a(this);
  private final b jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$b = new b(this);
  private aixd jdField_b_of_type_Aixd;
  LyricViewDetail jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail;
  private aiwn h;
  private aiwn i;
  private final ajmi.a mCallback = new ajne(this);
  private final ServiceConnection mConn = new ajnd(this);
  private View.OnClickListener mOnClickListener = new ajna(this);
  private ajmj mService;
  
  private static Point a(Activity paramActivity)
  {
    Point localPoint = new Point();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13) {
        paramActivity.getSize(localPoint);
      }
    }
    else
    {
      return localPoint;
    }
    localPoint.x = paramActivity.getWidth();
    localPoint.y = paramActivity.getHeight();
    return localPoint;
  }
  
  private String a(ajmj paramajmj, SongInfo paramSongInfo, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.id) {
        paramSongInfo.type = 4;
      }
      str1 = str2;
      switch (paramSongInfo.type)
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      paramSongInfo = str1;
      if (TextUtils.isEmpty(str1))
      {
        paramSongInfo = str1;
        if (paramajmj != null) {
          paramSongInfo = null;
        }
      }
      try
      {
        paramajmj = paramajmj.getExtras();
        paramSongInfo = str1;
        if (paramajmj != null) {
          paramSongInfo = paramajmj.getString("KEY_SOURCE_NAME");
        }
        return paramSongInfo;
        str1 = getString(2131696540);
        continue;
        str1 = getString(2131696140);
      }
      catch (RemoteException paramajmj)
      {
        for (;;)
        {
          paramajmj = paramSongInfo;
        }
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    String str = "";
    if (paramSongInfo != null) {
      str = paramSongInfo.title + "_____" + String.valueOf(paramSongInfo.id);
    }
    return str;
  }
  
  private void a(d paramd, String paramString)
  {
    c localc = new c(paramd.name, paramd.singer, paramd.imgUrl, paramd.shareUrl, paramd.songUrl, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$a, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localc;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$a, 53).sendToTarget();
    a(paramd.name, paramd.singer, paramd.imgUrl, paramString, paramd.arK, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.i = aiwv.a(paramString, true);
      if (this.i == null) {
        this.h = aiwv.a(paramString, false);
      }
    } while ((this.i == null) && (this.h == null));
    this.jdField_b_of_type_Aixd.stop();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_b_of_type_Aixd.a(paramLyricViewDetail);
    this.jdField_b_of_type_Aixd.a(this.i, this.h, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$a, 52);
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_SONG_NAME", paramString1);
    localBundle.putString("KEY_SINGER_NAME", paramString2);
    localBundle.putString("KEY_IMG_URL", paramString3);
    localBundle.putString("KEY_SOURCE_NAME", paramString4);
    localBundle.putBoolean("KEY_IS_FAVOURITE", paramBoolean1);
    localBundle.putBoolean("KEY_MATCH_SONG", paramBoolean2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  private void dyx()
  {
    ajmj localajmj = this.mService;
    if (localajmj == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = localajmj.a();
        if (localObject1 == null) {
          break label388;
        }
        localObject1 = a((SongInfo)localObject1);
        if (!lK.containsKey(localObject1)) {
          break label388;
        }
        l1 = ((Long)lK.get(localObject1)).longValue();
        if (!lL.containsKey(localObject1)) {
          break label381;
        }
        localObject1 = (String)lL.get(localObject1);
        Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
        if (!(localObject2 instanceof Long)) {
          break label373;
        }
        l2 = ((Long)localObject2).longValue();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
          this.jdField_b_of_type_Aixd.stop();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
        return;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().d() == null) || (l2 != l1))
      {
        a(localException, this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
        this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(Long.valueOf(l1));
      }
      int j = localajmj.getPlayState();
      this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l2 = localajmj.Gt();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      int k = (int)l1;
      if (localajmj.isPlaying())
      {
        boolean bool = this.jdField_b_of_type_Aixd.isPlaying();
        if (!bool) {
          this.jdField_b_of_type_Aixd.start();
        }
        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + l1 + " seekPosition:" + k + " isPlaying:" + bool);
        this.jdField_b_of_type_Aixd.seek(k);
        return;
      }
      if (3 == j)
      {
        this.jdField_b_of_type_Aixd.seek(k);
        this.jdField_b_of_type_Aixd.pause();
        return;
      }
      this.jdField_b_of_type_Aixd.stop();
      return;
      label373:
      l2 = -1L;
      continue;
      label381:
      String str = "";
      continue;
      label388:
      l1 = 0L;
      str = "";
    }
  }
  
  private void iL(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    }
  }
  
  private void n(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    localBundle.putString("audio_url", paramString5);
    localBundle.putInt("req_type", 2);
    paramString1 = new ArrayList(1);
    paramString1.add(paramString4);
    localBundle.putStringArrayList("image_url", paramString1);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("strurt_msgid", "0");
    localBundle.putString("struct_url", this.app.getCurrentUin());
    localBundle.putBoolean("from_web", true);
    avqq.a(this.app, this, localBundle, null, 0);
  }
  
  private void o(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() > 45) {
        str = paramString1.substring(0, 45) + "…";
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 60) {
        paramString1 = paramString2.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", str);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", 1101244924L);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { str }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131721057));
      svi.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new ajng(this, localIntent));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      setContentView(2131559678);
      bindService(new Intent(this, QQPlayerService.class), this.mConn, 33);
      paramBundle = findViewById(2131372117);
      View localView = findViewById(2131372106);
      int j = a(this).x;
      paramBundle.getLayoutParams().height = j;
      localView.getLayoutParams().height = j;
      this.Uj = ((TextView)findViewById(2131372116));
      this.UU = ((TextView)findViewById(2131372110));
      this.Bg = ((ImageView)findViewById(2131372112));
      this.Bf = ((ImageView)findViewById(2131372114));
      this.Bh = ((ImageView)findViewById(2131372109));
      this.Bf.setOnClickListener(this.mOnClickListener);
      this.jdField_a_of_type_Ajnh = ((ajnh)this.app.getBusinessHandler(92));
      this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131372113));
      this.jdField_b_of_type_Aixd = new aixd(this.jdField_b_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
      findViewById(2131372107).setOnClickListener(this.mOnClickListener);
      this.Bg.setOnClickListener(this.mOnClickListener);
      this.Bi = ((ImageView)findViewById(2131372115));
      this.Bi.setOnClickListener(this.mOnClickListener);
      this.Bh.setOnClickListener(this.mOnClickListener);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$b);
      anot.a(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
      return bool;
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    ajmj localajmj = this.mService;
    if (localajmj != null) {}
    try
    {
      localajmj.b(this.mCallback);
      label19:
      unbindService(this.mConn);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$b);
      super.doOnDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label19;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.jdField_b_of_type_Aixd != null) {
        this.jdField_b_of_type_Aixd.stop();
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
      }
    }
  }
  
  public static class a
    extends Handler
  {
    private final WeakReference<MusicPlayerActivity> mActivity;
    
    public a(MusicPlayerActivity paramMusicPlayerActivity)
    {
      super();
      this.mActivity = new WeakReference(paramMusicPlayerActivity);
    }
    
    private void a(int[] paramArrayOfInt, boolean paramBoolean)
    {
      MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.mActivity.get();
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2) && (localMusicPlayerActivity != null))
      {
        int i = paramArrayOfInt[0];
        int j = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, j, j, j, j, i });
        ((ImageView)localMusicPlayerActivity.findViewById(2131372108)).setImageDrawable(localGradientDrawable);
        localMusicPlayerActivity.findViewById(2131372111).setBackgroundColor(i);
        i = paramArrayOfInt[1];
        j = Color.argb(128, Color.red(i), Color.green(i), Color.blue(i));
        MusicPlayerActivity.a(localMusicPlayerActivity).setTextColor(i);
        MusicPlayerActivity.b(localMusicPlayerActivity).setTextColor(i);
        localMusicPlayerActivity.b.a().setLyricHilightColor(i);
        localMusicPlayerActivity.b.a().setLyricColor(j);
        MusicPlayerActivity.b(localMusicPlayerActivity).setTag(Integer.valueOf(i));
        MusicPlayerActivity.a(localMusicPlayerActivity).setTag(Integer.valueOf(i));
        MusicPlayerActivity.c(localMusicPlayerActivity).setTag(Integer.valueOf(i));
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130842620, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130842621, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130840368, i);
        if (paramBoolean)
        {
          MusicPlayerActivity.a(localMusicPlayerActivity, 2130842141, i);
          MusicPlayerActivity.a(localMusicPlayerActivity, 2130842143, i);
          MusicPlayerActivity.a(localMusicPlayerActivity, 2130842142, i);
          MusicPlayerActivity.a(localMusicPlayerActivity, 2130837599, i);
        }
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = 4;
      int j = 1;
      Object localObject1 = (MusicPlayerActivity)this.mActivity.get();
      Object localObject2 = paramMessage.getData();
      if (localObject1 != null) {
        switch (paramMessage.what)
        {
        }
      }
      label495:
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
                do
                {
                  do
                  {
                    return;
                    a(((Bundle)localObject2).getIntArray("KEY_COLOR_LIST"), ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG"));
                    return;
                    i = paramMessage.arg1;
                    paramMessage = MusicPlayerActivity.b((MusicPlayerActivity)localObject1).getTag();
                    if ((paramMessage instanceof Integer))
                    {
                      j = ((Integer)paramMessage).intValue();
                      MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130842620, j);
                      MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130842621, j);
                    }
                    if ((i == 3) || (i == 4)) {
                      MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130842621);
                    }
                    for (;;)
                    {
                      MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
                      return;
                      MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130842620);
                    }
                  } while (!(paramMessage.obj instanceof MusicPlayerActivity.c));
                  localObject2 = (MusicPlayerActivity.c)paramMessage.obj;
                  if (paramMessage.arg1 == 1) {
                    i = 0;
                  }
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setVisibility(i);
                  if (MusicPlayerActivity.a((MusicPlayerActivity)localObject1).isSelected()) {
                    MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130842142);
                  }
                  for (;;)
                  {
                    MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setVisibility(i);
                    MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setImageResource(2130842141);
                    MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setVisibility(i);
                    MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setImageResource(2130837599);
                    MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setTag(localObject2);
                    return;
                    MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130842143);
                  }
                } while (localObject2 == null);
                paramMessage = ((Bundle)localObject2).getString("KEY_SONG_NAME");
                ((Bundle)localObject2).getString("KEY_SINGER_NAME");
                Object localObject3 = ((Bundle)localObject2).getString("KEY_IMG_URL");
                boolean bool1 = ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG");
                boolean bool2 = ((Bundle)localObject2).getBoolean("KEY_IS_FAVOURITE");
                if (!TextUtils.isEmpty(paramMessage)) {
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setText(paramMessage);
                }
                if (bool1)
                {
                  if (!bool2) {
                    break label495;
                  }
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130842142);
                }
                URLDrawable localURLDrawable;
                Object localObject4;
                for (;;)
                {
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setSelected(bool2);
                  if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!Patterns.WEB_URL.matcher((CharSequence)localObject3).matches())) {
                    break label522;
                  }
                  paramMessage = (URLImageView)((MusicPlayerActivity)localObject1).findViewById(2131372117);
                  localURLDrawable = URLDrawable.getDrawable((String)localObject3, URLDrawable.URLDrawableOptions.obtain());
                  localObject4 = ajmq.aD((String)localObject3);
                  if (localObject4 == null) {
                    break label550;
                  }
                  localObject3 = new int[((List)localObject4).size()];
                  i = 0;
                  while (i < ((List)localObject4).size())
                  {
                    localObject3[i] = ((Integer)((List)localObject4).get(i)).intValue();
                    i += 1;
                  }
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130842143);
                }
                a((int[])localObject3, bool1);
                for (;;)
                {
                  paramMessage.setImageDrawable(localURLDrawable);
                  paramMessage = ((Bundle)localObject2).getString("KEY_SOURCE_NAME");
                  if (!TextUtils.isEmpty(paramMessage)) {
                    break;
                  }
                  MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(2131696141);
                  return;
                  localObject3 = new ajmq((String)localObject3, MusicPlayerActivity.a((MusicPlayerActivity)localObject1), Boolean.valueOf(bool1));
                  if (localURLDrawable.getStatus() == 1)
                  {
                    localObject4 = localURLDrawable.getCurrDrawable();
                    if ((localObject4 instanceof RegionDrawable)) {
                      ((ajmq)localObject3).run(null, ((RegionDrawable)localObject4).getBitmap());
                    }
                  }
                  else
                  {
                    localURLDrawable.setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
                  }
                }
                MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(((MusicPlayerActivity)localObject1).getString(2131696139, new Object[] { paramMessage }));
                return;
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
                return;
              } while (!(paramMessage.obj instanceof View));
              localObject2 = (View)paramMessage.obj;
              paramMessage = auvw.a((Context)localObject1).b(3).a(((MusicPlayerActivity)localObject1).getString(paramMessage.arg1)).a(paramMessage.arg2);
              paramMessage.c(49);
              paramMessage = new auvw.b(paramMessage).b(Color.argb(13, 255, 255, 255)).a(5).a();
            } while (paramMessage == null);
            paramMessage = paramMessage.a();
          } while (paramMessage == null);
          paramMessage.jb((View)localObject2);
          return;
          localObject1 = MusicPlayerActivity.d((MusicPlayerActivity)localObject1).getTag();
        } while (!(localObject1 instanceof MusicPlayerActivity.c));
        localObject1 = (MusicPlayerActivity.c)localObject1;
      } while (!(paramMessage.obj instanceof Bitmap));
      label522:
      label550:
      localObject2 = (Bitmap)paramMessage.obj;
      long l = System.currentTimeMillis();
      i = j;
      if (paramMessage.arg1 == 2) {
        i = 0;
      }
      WXShareHelper.a().a(String.valueOf(l), ((MusicPlayerActivity.c)localObject1).title, (Bitmap)localObject2, ((MusicPlayerActivity.c)localObject1).desc, ((MusicPlayerActivity.c)localObject1).url, i, ((MusicPlayerActivity.c)localObject1).audioUrl);
    }
  }
  
  public static class b
    implements acci
  {
    private final WeakReference<MusicPlayerActivity> mActivity;
    
    public b(MusicPlayerActivity paramMusicPlayerActivity)
    {
      this.mActivity = new WeakReference(paramMusicPlayerActivity);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.mActivity.get();
      String str2;
      if (((paramObject instanceof String)) && (localMusicPlayerActivity != null))
      {
        str2 = (String)paramObject;
        QLog.d("MusicPlayerActivity", 4, new Object[] { "musicPlayerActivity onUpdate ", String.valueOf(str2) });
      }
      String str1;
      Object localObject8;
      String str4;
      String str3;
      Object localObject9;
      Object localObject6;
      long l3;
      boolean bool2;
      long l1;
      Object localObject4;
      Object localObject3;
      boolean bool1;
      Object localObject5;
      Object localObject1;
      switch (paramInt)
      {
      default: 
        return;
      case 81: 
        str1 = "";
        localObject8 = "";
        str4 = "";
        str3 = "";
        localObject9 = "";
        localObject6 = "";
        paramBoolean = false;
        l3 = 0L;
        bool2 = false;
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = localObject6;
        localObject1 = localObject8;
        paramObject = str1;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(str2).getJSONObject("data");
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = localObject6;
          localObject1 = localObject8;
          paramObject = str1;
          str1 = localJSONObject.optString("picurl");
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = localObject6;
          localObject1 = localObject8;
          paramObject = str1;
          str2 = localJSONObject.optString("lyric");
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = localObject6;
          localObject1 = str2;
          paramObject = str1;
          str5 = localJSONObject.optString("shareurl");
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          if (!localJSONObject.has("isfavorite")) {
            continue;
          }
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          paramInt = localJSONObject.getInt("isfavorite");
        }
        catch (Exception localException)
        {
          try
          {
            JSONObject localJSONObject;
            String str5;
            localObject1 = ((ajmj)localObject1).a();
            if (!bool2) {
              continue;
            }
            anot.a(localMusicPlayerActivity.app, "CliOper", "", "", "0X8006827", "0X8006827", 0, 0, "", "", "", "");
            if (localObject1 == null) {
              continue;
            }
            str1 = MusicPlayerActivity.a(localMusicPlayerActivity, (SongInfo)localObject1);
            localObject9 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              continue;
            }
            localObject9 = paramObject.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
            MusicPlayerActivity.access$600().put(str1, Long.valueOf(l2));
            MusicPlayerActivity.x().put(str1, localObject9);
            if (localObject1 == null) {
              continue;
            }
            paramObject = new MusicPlayerActivity.d(l2, (String)localObject4, (String)localObject3, (String)localObject8, (String)localObject6, (String)localObject5, paramBoolean);
            localObject9 = MusicPlayerActivity.a(localMusicPlayerActivity, (SongInfo)localObject1);
            MusicPlayerActivity.S().put(localObject9, paramObject);
            paramObject = new MusicPlayerActivity.c((String)localObject4, (String)localObject3, (String)localObject5, (String)localObject6, (String)localObject8, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
            localObject6 = Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 51);
            if (!bool2) {
              continue;
            }
            paramInt = 1;
            ((Message)localObject6).arg1 = paramInt;
            ((Message)localObject6).obj = paramObject;
            ((Message)localObject6).sendToTarget();
            Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 53).sendToTarget();
            MusicPlayerActivity.a(localMusicPlayerActivity, (String)localObject4, (String)localObject3, (String)localObject5, MusicPlayerActivity.a(localMusicPlayerActivity, MusicPlayerActivity.a(localMusicPlayerActivity), (SongInfo)localObject1, l2), paramBoolean, bool2);
            return;
            paramInt = 0;
            break label1074;
            paramBoolean = false;
            continue;
            localException = localException;
            bool2 = false;
            paramBoolean = bool1;
            Object localObject7 = localObject5;
            localObject8 = "";
            localObject5 = localObject3;
            localObject9 = paramObject;
            long l2 = l1;
            localObject3 = localObject4;
            localObject4 = localObject5;
            paramObject = localObject1;
            localObject5 = localObject9;
          }
          catch (RemoteException localRemoteException)
          {
            localObject2 = null;
            continue;
            paramInt = 0;
            continue;
          }
        }
        l2 = l3;
        localObject8 = str3;
        localObject6 = str4;
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        if (!localJSONObject.isNull("songinfo"))
        {
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          localObject9 = localJSONObject.getJSONObject("songinfo");
          l1 = l3;
          localObject4 = str3;
          localObject3 = str4;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          localObject6 = ((JSONObject)localObject9).optString("strSongName");
          l1 = l3;
          localObject4 = str3;
          localObject3 = localObject6;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          localObject8 = ((JSONObject)localObject9).optString("strSingerName");
          l1 = l3;
          localObject4 = localObject8;
          localObject3 = localObject6;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          l2 = ((JSONObject)localObject9).getInt("iSongId");
          l1 = l2;
          localObject4 = localObject8;
          localObject3 = localObject6;
          bool1 = paramBoolean;
          localObject5 = str5;
          localObject1 = str2;
          paramObject = str1;
          localObject9 = ((JSONObject)localObject9).optString("strUrl");
          bool2 = true;
        }
        localObject3 = localObject8;
        localObject4 = localObject6;
        paramObject = str2;
        localObject5 = str1;
        localObject8 = localObject9;
        localObject6 = str5;
        localObject1 = MusicPlayerActivity.a(localMusicPlayerActivity);
        if (localObject1 != null)
        {
          QLog.d("MusicPlayerActivity", 4, new Object[] { "MusicPlayerActivity add favourite success ", String.valueOf(str2) });
          for (;;)
          {
            try
            {
              if (new JSONObject(str2).getInt("code") != 0) {
                break;
              }
              paramObject = MusicPlayerActivity.a(localMusicPlayerActivity).getTag();
              if ((paramObject instanceof Integer))
              {
                paramInt = ((Integer)paramObject).intValue();
                Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 54, 2131696134, paramInt, MusicPlayerActivity.a(localMusicPlayerActivity)).sendToTarget();
                return;
              }
            }
            catch (Exception paramObject)
            {
              QLog.d("MusicPlayerActivity", 1, "add favourite parse json ", paramObject);
              return;
            }
            paramInt = -1;
          }
          QLog.d("MusicPlayerActivity", 4, new Object[] { "MusicPlayerActivity del favourite success ", String.valueOf(str2) });
          return;
        }
        Object localObject2 = null;
        continue;
        label1074:
        if (paramInt == 1) {
          paramBoolean = true;
        }
      }
    }
  }
  
  public static class c
  {
    public final String audioUrl;
    public final String desc;
    public final String iconUrl;
    public final String imgUrl;
    public final String title;
    public final String url;
    
    public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.imgUrl = paramString3;
      this.url = paramString4;
      this.audioUrl = paramString5;
      this.iconUrl = paramString6;
    }
  }
  
  public static class d
  {
    public final long acZ;
    public final boolean arK;
    public final String imgUrl;
    public final String name;
    public final String shareUrl;
    public final String singer;
    public final String songUrl;
    
    public d(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
    {
      this.acZ = paramLong;
      this.name = paramString1;
      this.singer = paramString2;
      this.songUrl = paramString3;
      this.shareUrl = paramString4;
      this.imgUrl = paramString5;
      this.arK = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */