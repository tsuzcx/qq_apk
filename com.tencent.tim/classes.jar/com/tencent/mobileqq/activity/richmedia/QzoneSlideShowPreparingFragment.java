package com.tencent.mobileqq.activity.richmedia;

import aaqj;
import aaqq;
import aaqq.a;
import aasi;
import aasj;
import aask;
import aasl;
import aasm;
import acfp;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;
import rlr;
import rma;
import vnk;

public class QzoneSlideShowPreparingFragment
  extends PublicBaseFragment
  implements vnk
{
  private static final String TAG = rlr.class.getName();
  private TextView OA;
  private TextView Oz;
  private ProgressBar V;
  private aqju ac;
  private int cjB;
  private Runnable fi = new QzoneSlideShowPreparingFragment.2(this);
  private Handler mainHandler = new aasi(this, Looper.getMainLooper());
  private ImageView wy;
  
  private void I(int paramInt, Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramInt == -1) {
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("key_content");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i = paramIntent.getIntExtra("key_priv", 1);
        localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
        if (localObject2 != null) {
          break label266;
        }
        localObject2 = new ArrayList();
      }
    }
    label266:
    for (;;)
    {
      int j = paramIntent.getIntExtra("key_font_id", -1);
      int k = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int m = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (paramIntent.saveMode <= 5) {}
      for (paramInt = paramIntent.saveMode;; paramInt = 0)
      {
        int n = (int)paramIntent.videoDuration;
        VideoComponentCallback localVideoComponentCallback = new VideoComponentCallback();
        localVideoComponentCallback.setRefer(getClass().getName());
        a(paramIntent.audioFilePath, paramInt, paramIntent.videoFilePath, paramIntent.thumbPath, paramIntent.fakeVid, n, localVideoComponentCallback, (String)localObject1, i, (ArrayList)localObject2, false, j, k, str1, m, str2, bool1, bool2, bool3);
        if (this.cjB == 18) {
          LpReportInfo_pf00064.allReport(585, 15, 9);
        }
        finish();
        return;
      }
      finish();
      return;
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, aaqj paramaaqj, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.hs(str, paramString4);
    }
    aaqq.a locala = new aaqq.a();
    locala.E = getActivity();
    locala.bdL = str;
    locala.mAudioFilePath = paramString1;
    locala.ciH = paramInt1;
    locala.aAu = paramString2;
    locala.mThumbFilePath = paramString3;
    locala.mThumbWidth = 0;
    locala.gP = 0;
    locala.fakeVid = paramString4;
    locala.ciC = paramInt2;
    locala.a = paramaaqj;
    locala.mContent = paramString5;
    locala.mPriv = paramInt3;
    locala.eo = paramArrayList;
    locala.bxk = true;
    locala.topicSyncQzone = paramBoolean1;
    locala.fontId = paramInt4;
    locala.fontFormatType = paramInt5;
    locala.fontUrl = paramString6;
    locala.superFontId = paramInt6;
    locala.bdK = paramString7;
    locala.bxp = paramBoolean2;
    locala.bxq = paramBoolean3;
    locala.isSyncToQQStory = paramBoolean4;
    locala.bxr = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    locala.cii = rlr.a().tF();
    locala.mUin = "";
    locala.mUinType = 0;
    locala.mTroopUin = "";
    new aaqq(locala).execute(new Void[0]);
  }
  
  private void cvK()
  {
    if (this.ac == null)
    {
      String str = acfp.m(2131713385);
      this.ac = aqha.a(getActivity(), 230, str, null, acfp.m(2131713386), acfp.m(2131713384), new aasl(this), new aasm(this));
    }
    this.ac.show();
  }
  
  public void finish()
  {
    this.mainHandler.removeCallbacks(this.fi);
    rma.a().bvr();
    getActivity().finish();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    I(paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    cvK();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d(TAG, 2, "QzoneSlideShowPreparingFragment onCreate");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 0;
    QLog.d(TAG, 2, "QzoneSlideShowPreparingFragment onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2131559270, paramViewGroup, false);
    this.Oz = ((TextView)paramLayoutInflater.findViewById(2131380729));
    this.OA = ((TextView)paramLayoutInflater.findViewById(2131380589));
    this.V = ((ProgressBar)paramLayoutInflater.findViewById(2131372943));
    this.wy = ((ImageView)paramLayoutInflater.findViewById(2131369845));
    this.V.setProgress(0);
    this.V.setMax(100);
    this.Oz.setText("0%");
    this.OA.setOnClickListener(new aasj(this));
    this.mainHandler.postDelayed(this.fi, 200L);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      rma.a().bvr();
      paramViewGroup = paramBundle.getParcelableArrayListExtra("qzone_slide_show_matters");
      int j = paramBundle.getIntExtra("qqstory_slide_show_scene", 21);
      this.cjB = paramBundle.getIntExtra("entrance_qzone_p2v", -1);
      if ((paramViewGroup == null) || (paramViewGroup.size() <= 0) || (j != 22)) {
        break label425;
      }
      Object localObject = (LocalMediaInfo)paramViewGroup.get(0);
      if (((LocalMediaInfo)localObject).mMimeType.contains("image"))
      {
        new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
        paramBundle = BitmapFactory.decodeFile(((LocalMediaInfo)localObject).path);
        this.wy.setImageBitmap(paramBundle);
      }
      for (;;)
      {
        paramBundle = new ArrayList();
        while (i < paramViewGroup.size())
        {
          paramBundle.add(new SlideItemInfo((LocalMediaInfo)paramViewGroup.get(i)));
          i += 1;
        }
        if (((LocalMediaInfo)localObject).mMimeType.contains("video"))
        {
          paramBundle = new MediaMetadataRetriever();
          paramBundle.setDataSource(((LocalMediaInfo)localObject).path);
          localObject = paramBundle.getFrameAtTime(0L, 3);
          paramBundle.release();
          this.wy.setImageBitmap((Bitmap)localObject);
        }
      }
      rma.a().eW(paramBundle);
      rma.a().setData(paramBundle);
      rma.a().xL(j);
      rma.a().xK(this.cjB);
      rma.a().a(getActivity(), new aask(this), 2);
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(680, 1, 1);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label425:
      QLog.e(TAG, 2, "slideShowLocalMediaInfos is null or SlideShowScene is not QzoneSlideShowPhotoListManager.SCENE_QZONE");
      finish();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment
 * JD-Core Version:    0.7.0.1
 */