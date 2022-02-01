import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;
import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.7;
import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.9;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class srs
  extends aygy
  implements Handler.Callback, View.OnClickListener, aydu, sqx.a
{
  private TextView AV;
  private TextView AW;
  private TextView AX;
  private long BY;
  private long Dn;
  private long Do;
  private long Dp;
  private long Dq = System.currentTimeMillis();
  private File L;
  private final String TAG = "EditVideoSmartMusicPart";
  private ayhm jdField_a_of_type_Ayhm;
  private FrameVideoHelper jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper;
  private SingleLyricView jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
  private sqx jdField_a_of_type_Sqx;
  private ssa.a jdField_a_of_type_Ssa$a;
  private ssa jdField_a_of_type_Ssa;
  private String aDN;
  private String aGc = (String)spp.a().getValue("KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL", "https://down.qq.com/video_story/smart_music_anim.zip");
  private boolean aMF = true;
  private boolean aMG;
  private boolean aMH;
  private boolean aMI;
  private boolean aMJ;
  private boolean aMK;
  private FrameLayout aO;
  protected BroadcastReceiver ao = new srz(this);
  private auru jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private VsMusicItemInfo jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private int byS;
  private int byT;
  private int byU = -1;
  private QQAnimationDrawable d;
  private Drawable dq;
  private Drawable dr;
  private HashMap<String, String> fT = new HashMap();
  private RelativeLayout gb;
  public int mCurrentPos;
  private boolean mDestroyed;
  private boolean mIsResume;
  private LocalMediaInfo mLocalMediaInfo;
  private Vibrator mVibrator;
  private String mVideoPath;
  private ImageView oH;
  private ImageView oI;
  private ImageView oJ;
  private ImageView oK;
  public float ot = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixoriginalaudiovolume", 0.7F);
  public float ou;
  private ArrayList<FrameVideoHelper.FrameBuffer> ou;
  private View qB;
  private View qC;
  private View qD;
  private View qE;
  private View qF;
  
  public srs(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_ou_of_type_Float = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixmusicvolume", 1.0F);
  }
  
  private ayhm a()
  {
    if (this.jdField_a_of_type_Ayhm == null) {
      this.jdField_a_of_type_Ayhm = ((ayhm)this.jdField_b_of_type_Aygz.a(ayhm.class));
    }
    return this.jdField_a_of_type_Ayhm;
  }
  
  private void a(int paramInt, ssa.a parama)
  {
    if (parama == null) {
      parama = (ssa.a)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.findViewHolderForAdapterPosition(paramInt);
    }
    for (;;)
    {
      this.mCurrentPos = paramInt;
      this.jdField_a_of_type_Ssa$a = parama;
      if ((this.jdField_a_of_type_Ssa$a != null) && (!this.aMF))
      {
        this.jdField_a_of_type_Ssa$a.showCover();
        vibrate();
      }
      tA(nO());
      return;
    }
  }
  
  private void a(CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp) {}
  
  private void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, ssa.a parama)
  {
    this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.stop();
    }
    bAv();
    a(paramInt, parama);
    if (paramVsMusicItemInfo.aMO) {
      a(paramVsMusicItemInfo);
    }
    bAu();
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return;
    }
    if ((paramMusicItemInfo.musicDuration == 0) && (paramMusicItemInfo.getLocalPath() != null)) {
      paramMusicItemInfo.musicDuration = ((int)ShortVideoUtils.getDuration(paramMusicItemInfo.getLocalPath()));
    }
    if (this.aMK) {
      if (paramMusicItemInfo.musicStart + 15999 <= paramMusicItemInfo.musicDuration) {
        break label90;
      }
    }
    label90:
    for (int i = paramMusicItemInfo.musicDuration;; i = paramMusicItemInfo.musicStart + 15999)
    {
      paramMusicItemInfo.musicDuration = i;
      if (paramMusicItemInfo.musicEnd == 0) {
        paramMusicItemInfo.musicEnd = paramMusicItemInfo.musicDuration;
      }
      if (paramMusicItemInfo.musicStart <= paramMusicItemInfo.musicEnd) {
        break;
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    bAq();
    if (a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp)) {
      return;
    }
    a(paramStSmartMatchMusicRsp);
    setMusicData(paramStSmartMatchMusicRsp.vecMusic.get());
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest failed" + VSBaseRequest.concactRetCodeAndMsg(paramLong, paramString));
      return true;
    }
    if (paramStSmartMatchMusicRsp.vecMusic.size() == 0)
    {
      QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest success but the music size is 0");
      return true;
    }
    return false;
  }
  
  private void b(VsMusicItemInfo paramVsMusicItemInfo)
  {
    bAv();
    if ((paramVsMusicItemInfo == null) || (TextUtils.isEmpty(paramVsMusicItemInfo.aGe)) || (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView == null)) {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics null");
    }
    while ((this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (!this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      return;
    }
    if ((paramVsMusicItemInfo.aGe == null) || (paramVsMusicItemInfo.aGe.isEmpty()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics is Empty");
      return;
    }
    u(paramVsMusicItemInfo.aGe, paramVsMusicItemInfo.aGd, paramVsMusicItemInfo.musicStart);
  }
  
  private void bAj()
  {
    this.L = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
    bAk();
    if ((this.L.exists()) || (aqmr.isEmpty(this.aGc)))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "animFile exist:" + this.L.exists() + " | downloadUrl:" + this.aGc);
      return;
    }
    ThreadManagerV2.executeOnNetWorkThread(new EditVideoSmartMusicPart.1(this));
  }
  
  private void bAk()
  {
    File localFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
    if ((localFile.exists()) && (localFile.listFiles() != null))
    {
      if (localFile.listFiles().length < 25)
      {
        if (this.L != null) {
          this.L.delete();
        }
        localFile.delete();
        QLog.i("EditVideoSmartMusicPart", 1, "anim file is not complete and delete");
      }
    }
    else {
      return;
    }
    QLog.i("EditVideoSmartMusicPart", 1, "anim file is exist and complete");
  }
  
  private void bAl()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView = ((SmartMusicRecyclerView)y(2131365538));
    this.jdField_a_of_type_Ssa = ((ssa)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getAdapter());
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setListener(new srw(this));
  }
  
  private void bAm()
  {
    if (this.jdField_a_of_type_Ssa == null) {}
    VsMusicItemInfo localVsMusicItemInfo;
    do
    {
      return;
      localVsMusicItemInfo = this.jdField_a_of_type_Ssa.a(this.mCurrentPos);
    } while (localVsMusicItemInfo == null);
    JSONObject localJSONObject = new JSONObject();
    long l1 = System.currentTimeMillis();
    long l2 = this.Dq;
    try
    {
      localJSONObject.put("music_id", localVsMusicItemInfo.mSongMid);
      localJSONObject.put("music_play_time", l1 - l2);
      if (this.mLocalMediaInfo != null) {
        localJSONObject.put("video_duration", this.mLocalMediaInfo.mDuration);
      }
      sqn.a("mystatus_edit", "aimusic_exp_clk", 0, 0, new String[] { String.valueOf(localVsMusicItemInfo.from), "", localJSONObject.toString() });
      this.Dq = System.currentTimeMillis();
      ram.i("EditVideoSmartMusicPart", "reportSmartMusic   reportClickMusic() args3:" + localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void bAn()
  {
    bAp();
    this.Do = System.currentTimeMillis();
    if ((this.jdField_ou_of_type_JavaUtilArrayList == null) || (this.jdField_ou_of_type_JavaUtilArrayList.size() == 0))
    {
      if (this.mLocalMediaInfo == null)
      {
        QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
        return;
      }
      tz(acfp.m(2131705706));
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper = new FrameVideoHelper(this.mVideoPath, this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mDuration);
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a(this.Dp, new srx(this));
      return;
    }
    tz("抽帧耗时：0ms\n抽取图片数：" + this.jdField_ou_of_type_JavaUtilArrayList.size() + "\n抽帧字节数：" + this.Dn / 1000L + "KB");
    cD(this.jdField_ou_of_type_JavaUtilArrayList);
  }
  
  private void bAo()
  {
    boolean bool = false;
    if ((!this.aMI) && (this.byS == 0))
    {
      bAn();
      sqn.a("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
    }
    if (!this.aMF) {
      bool = true;
    }
    this.aMF = bool;
    if (!this.aMF)
    {
      a(this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      this.oI.setBackgroundDrawable(this.dq);
    }
    for (;;)
    {
      bAr();
      return;
      this.jdField_a_of_type_Sqx.stop();
      this.oI.setBackgroundDrawable(this.dr);
    }
  }
  
  private void bAp()
  {
    if ((this.L == null) || (!this.L.exists()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
      if (this.oJ != null) {
        this.oJ.setVisibility(0);
      }
      if (this.aO != null) {
        this.aO.setVisibility(0);
      }
      return;
    }
    String[] arrayOfString = new String[25];
    int i = 0;
    if (i < 25)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/music_000");
      if (i < 10) {}
      for (Object localObject = "0" + i;; localObject = Integer.valueOf(i))
      {
        arrayOfString[i] = (localObject + ".png");
        i += 1;
        break;
      }
    }
    if (this.aO != null) {
      this.aO.setVisibility(0);
    }
    this.d = new QQAnimationDrawable();
    this.d.Q(arrayOfString);
    this.d.setDuration(1666L);
    this.oJ.setVisibility(8);
    this.oK.setImageDrawable(this.d);
    this.oK.setVisibility(0);
    this.d.start(2147483647);
  }
  
  private void bAq()
  {
    if (this.oK != null)
    {
      this.oK.setImageDrawable(null);
      this.oK.setVisibility(8);
    }
    if (this.d != null) {
      this.d.stop();
    }
    if (this.oJ != null) {
      this.oJ.setVisibility(0);
    }
  }
  
  private void bAr()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
      if (!this.aMF)
      {
        bool1 = true;
        ((SmartMusicRecyclerView)localObject).setNeedScale(bool1);
      }
    }
    else if (this.jdField_a_of_type_Ssa$a != null)
    {
      localObject = this.jdField_a_of_type_Ssa$a;
      if (this.aMF) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ssa.a)localObject).vb(bool1);
      if (this.aMF) {
        this.jdField_a_of_type_Ssa$a.bAy();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void bAs()
  {
    Activity localActivity = (Activity)getContext();
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { aqgz.getIMEI(), "", Integer.valueOf(6) }));
    localIntent.putExtra("finish_animation_up_down", true);
    localActivity.startActivityForResult(localIntent, 1001);
    localActivity.overridePendingTransition(2130771991, 0);
  }
  
  private void bAt()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getBackground() == null)
    {
      this.qF.setBackgroundResource(2130838903);
      a().post(new EditVideoSmartMusicPart.7(this));
    }
  }
  
  private void bAu()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Ssa.a(this.mCurrentPos - 1) != null) {
        localJSONObject.put("mid1", this.jdField_a_of_type_Ssa.a(this.mCurrentPos - 1).mSongMid);
      }
      if (this.jdField_a_of_type_Ssa.a(this.mCurrentPos) != null) {
        localJSONObject.put("mid2", this.jdField_a_of_type_Ssa.a(this.mCurrentPos).mSongMid);
      }
      if (this.jdField_a_of_type_Ssa.a(this.mCurrentPos + 1) != null) {
        localJSONObject.put("mid3", this.jdField_a_of_type_Ssa.a(this.mCurrentPos + 1).mSongMid);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    sqn.a("mystatus_edit", "aimusic_exp", 0, 0, new String[] { "", "", localJSONObject.toString() });
    ram.i("EditVideoSmartMusicPart", "reportSmartMusic   reportShowMusic() args3:" + localJSONObject.toString());
  }
  
  private void bAw()
  {
    if (axcg.c.ob(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.entryType)) {
      ayjb.a().eRW();
    }
  }
  
  private void bAx()
  {
    ayjb localayjb;
    if (axcg.c.ob(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.entryType))
    {
      localayjb = ayjb.a();
      if (this.aMF) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      localayjb.Zq(bool);
      return;
    }
  }
  
  private void bk(Intent paramIntent)
  {
    int j = 0;
    Object localObject1 = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic")) || (this.mDestroyed)) {}
    Object localObject2;
    label280:
    label285:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "mMusicReceiver onReceive:" + (String)localObject1);
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null) {
            this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setHasAutoSet(false);
          }
          if (this.jdField_a_of_type_Sqx != null)
          {
            this.jdField_a_of_type_Sqx.stop();
            bAv();
          }
          localObject2 = new JSONObject((String)localObject1);
          paramIntent = new VsMusicItemInfo((JSONObject)localObject2);
          QLog.i("EditVideoSmartMusicPart", 2, "onReceive Music From H5:" + (String)localObject1);
          if (this.jdField_a_of_type_Ssa == null) {
            break;
          }
          if (this.jdField_a_of_type_Ssa.ut() <= 0) {
            break label280;
          }
          i = 1;
          if (i == 0) {
            break label285;
          }
          if (this.jdField_a_of_type_Ssa.a(this.mCurrentPos, paramIntent))
          {
            paramIntent.aMO = false;
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramIntent.mSongMid);
            cE((ArrayList)localObject1);
          }
          this.byU = (this.jdField_a_of_type_Ssa.bp(paramIntent.mSongMid) + us());
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setLastPosition(-1);
          return;
        }
        catch (JSONException paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("EditVideoSmartMusicPart", 2, QLog.getStackTraceString(paramIntent));
        return;
        i = 0;
      }
      localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("music_items");
      ((ArrayList)localObject1).add(paramIntent);
    } while (localObject2 == null);
    int i = j;
    while (i < ((JSONArray)localObject2).length())
    {
      ((ArrayList)localObject1).add(new VsMusicItemInfo(((JSONArray)localObject2).getJSONObject(i)));
      i += 1;
    }
    this.jdField_a_of_type_Ssa.setData((ArrayList)localObject1);
  }
  
  private void cD(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList)
  {
    this.aMI = true;
    this.BY = System.currentTimeMillis();
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, axaq.a().b(), this.aMJ, this.byT, this.mLocalMediaInfo);
    this.aDN = paramArrayList.getCmdName();
    VSNetworkHelper.a().a(getContext(), paramArrayList, new sry(this));
  }
  
  private void cE(ArrayList<String> paramArrayList)
  {
    if (this.jdField_a_of_type_Ssa != null) {
      this.jdField_a_of_type_Ssa.r(paramArrayList, true);
    }
  }
  
  private void initData()
  {
    Object localObject;
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.mLocalMediaInfo = ((EditTakeVideoSource)localObject).d;
      this.mVideoPath = ((EditTakeVideoSource)localObject).sourcePath;
      this.jdField_a_of_type_Sqx = new sqx();
      this.jdField_a_of_type_Sqx.a(this);
      if (this.mLocalMediaInfo != null)
      {
        this.jdField_a_of_type_Sqx.setVideoDuration(this.mLocalMediaInfo.mDuration);
        tz(acfp.m(2131705600) + "\n视频时长：" + this.mLocalMediaInfo.mDuration / 1000L + "s");
        tz(acfp.m(2131705617) + this.mLocalMediaInfo.mediaWidth + "  " + this.mLocalMediaInfo.mediaHeight);
        axip.a().setVideoDuration(this.mLocalMediaInfo.mDuration / 1000L);
      }
      if (this.aMK) {
        this.jdField_a_of_type_Sqx.yO(60000);
      }
      this.jdField_ou_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_b_of_type_Aygz.F().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES"));
      if (this.jdField_b_of_type_Aygz.F().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) != 2) {
        break label345;
      }
    }
    label345:
    for (int i = 0;; i = 1)
    {
      this.byT = i;
      this.Dn = this.jdField_b_of_type_Aygz.F().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
      bAj();
      return;
      if (!(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
        break;
      }
      localObject = (EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.mLocalMediaInfo = ((EditLocalVideoSource)localObject).d;
      this.mVideoPath = ((EditLocalVideoSource)localObject).sourcePath;
      this.Dp = ((EditLocalVideoSource)localObject).d.mStartTime;
      break;
    }
  }
  
  private void initView()
  {
    this.qF = y(2131381827);
    this.AW = ((TextView)y(2131380605));
    this.AX = ((TextView)y(2131380925));
    this.gb = ((RelativeLayout)y(2131381814));
    this.oH = ((ImageView)y(2131369831));
    this.oI = ((ImageView)y(2131369815));
    this.AV = ((TextView)y(2131380812));
    this.oK = ((ImageView)y(2131369733));
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView = ((SingleLyricView)y(2131378503));
    this.oJ = ((ImageView)y(2131378515));
    this.dq = getContext().getResources().getDrawable(2130851880);
    this.dr = getContext().getResources().getDrawable(2130851879);
    this.qD = y(2131370707);
    this.qD.setOnClickListener(this);
    this.qE = y(2131370699);
    this.qE.setOnClickListener(this);
    this.aO = ((FrameLayout)y(2131367182));
    this.qC = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayii.getActivity().findViewById(2131363559);
    this.qB = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayii.getActivity().findViewById(2131363557);
    this.aO.setOnClickListener(this);
    bAl();
    this.AW.setOnClickListener(new sru(this));
    this.AX.setOnClickListener(new srv(this));
    if ((this.qD != null) && (this.aMK)) {
      this.qD.setVisibility(8);
    }
    QLog.d("EditVideoSmartMusicPart", 2, "getRealHeight" + ankt.getRealHeight(getContext()) + "ScreenUtil.getRealWidth(getContext())" + ankt.aE(getContext()));
    int i;
    int m;
    int k;
    int j;
    if (ankt.getRealHeight(getContext()) / ankt.aE(getContext()) >= 2.0F)
    {
      ayxa.resetFullScreen((Activity)getContext());
      this.qB.setVisibility(8);
      this.qC.setVisibility(8);
      if ((!axcg.c.ob(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.entryType)) || ((!this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lc()) && (!this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) && (!this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()))) {
        break label667;
      }
      i = wja.dp2px(105.0F, getContext().getResources());
      m = wja.dp2px(34.0F, getContext().getResources());
      k = wja.dp2px(19.0F, getContext().getResources());
      j = i;
    }
    for (;;)
    {
      this.gb.setPadding(this.gb.getPaddingLeft(), this.gb.getPaddingTop(), this.gb.getPaddingRight(), j);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.aO.getLayoutParams();
      localMarginLayoutParams.bottomMargin = m;
      this.aO.setLayoutParams(localMarginLayoutParams);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getLayoutParams();
      localMarginLayoutParams.bottomMargin = k;
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setLayoutParams(localMarginLayoutParams);
      return;
      if ((this.jdField_b_of_type_Aygz.ok == null) || (this.jdField_b_of_type_Aygz.ok.getLayoutParams() == null)) {
        break;
      }
      this.qF.setPadding(0, 0, 0, this.jdField_b_of_type_Aygz.ok.getLayoutParams().height);
      break;
      label667:
      j = wja.dp2px(17.0F, getContext().getResources());
      i = wja.dp2px(0.0F, getContext().getResources());
      k = wja.dp2px(-15.0F, getContext().getResources());
      m = i;
    }
  }
  
  private float o(int paramInt)
  {
    if (paramInt == 1) {
      if ((!this.aMF) || (!this.aMG)) {}
    }
    do
    {
      do
      {
        do
        {
          return 0.0F;
        } while ((!this.aMF) && (this.aMG));
        if ((!this.aMF) && (!this.aMG)) {
          return this.ot;
        }
        if ((!this.aMF) || (this.aMG)) {
          break;
        }
        return 1.0F;
        if (paramInt != 2) {
          break;
        }
      } while ((this.aMF) && (this.aMG));
      if ((!this.aMF) && (this.aMG)) {
        return 1.0F;
      }
      if ((!this.aMF) && (!this.aMG)) {
        return this.jdField_ou_of_type_Float;
      }
    } while ((this.aMF) && (!this.aMG));
    return 1.0F;
  }
  
  private void uZ(boolean paramBoolean)
  {
    if (this.aMH) {
      return;
    }
    a().tt(this.aMG);
    a().setVolume(o(1));
    if (paramBoolean)
    {
      this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 2, 0));
  }
  
  private void va(boolean paramBoolean)
  {
    View localView = this.qF;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void yP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 3: 
      srl.a().bAb();
      return;
    }
    srl.a().onVideoStop();
  }
  
  public auru a()
  {
    if (this.jdField_b_of_type_Auru == null) {
      this.jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
    }
    return this.jdField_b_of_type_Auru;
  }
  
  public void a(int paramInt, ayqb paramayqb)
  {
    boolean bool2 = false;
    this.aMH = true;
    if (this.aMK) {
      this.aMG = true;
    }
    Object localObject = paramayqb.g;
    boolean bool1;
    if (!this.aMG)
    {
      bool1 = true;
      ((PublishVideoEntry)localObject).putExtra("isMixOriginal", Boolean.valueOf(bool1));
      localObject = paramayqb.g;
      bool1 = bool2;
      if (!this.aMG) {
        bool1 = true;
      }
      ((PublishVideoEntry)localObject).isMixOriginal = bool1;
      paramayqb.g.isMuteRecordVoice = this.aMG;
      paramayqb.g.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_b_of_type_Aygz.F().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
      paramayqb.g.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.aMK));
      paramayqb.g.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.jdField_b_of_type_Aygz.a().isLandTakePicToVideo()));
      if (!this.aMF) {
        break label200;
      }
      paramayqb.g.backgroundMusicPath = null;
    }
    for (;;)
    {
      if (this.mLocalMediaInfo != null) {
        this.jdField_b_of_type_Aygz.a().setVideoDuration(this.mLocalMediaInfo.mDuration);
      }
      return;
      bool1 = false;
      break;
      label200:
      if ((this.jdField_a_of_type_Sqx != null) && (this.jdField_a_of_type_Sqx.a() != null))
      {
        localObject = this.jdField_a_of_type_Sqx.a();
        paramayqb.g.backgroundMusicOffset = ((VsMusicItemInfo)localObject).musicStart;
        int i = ((VsMusicItemInfo)localObject).musicEnd - ((VsMusicItemInfo)localObject).musicStart;
        int j = i;
        if (!this.aMK)
        {
          j = i;
          if (i < 0) {
            j = 60000;
          }
          j = Math.min(j, (int)this.jdField_b_of_type_Aygz.x(paramInt));
        }
        paramayqb.g.backgroundMusicDuration = j;
        paramayqb.g.backgroundMusicPath = ((VsMusicItemInfo)localObject).getLocalPath();
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(((VsMusicItemInfo)localObject).mItemId));
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_mid_id", ((VsMusicItemInfo)localObject).mSongMid);
        paramayqb.g.putExtra("vs_publish_entry_json_key_song_name", ((VsMusicItemInfo)localObject).mMusicName);
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_album_pic", ((VsMusicItemInfo)localObject).mAlbumUrl);
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_download_url", ((VsMusicItemInfo)localObject).mUrl);
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_source_from", Integer.valueOf(((VsMusicItemInfo)localObject).from));
        paramayqb.g.putExtra("originalRecordVolume", Float.valueOf(o(1)));
        paramayqb.g.putExtra("backgroundVolume", Float.valueOf(o(2)));
        this.jdField_b_of_type_Aygz.a().setSongMid(((VsMusicItemInfo)localObject).mSongMid);
        this.jdField_b_of_type_Aygz.a().setMusicType(((VsMusicItemInfo)localObject).from);
        this.jdField_b_of_type_Aygz.a().setMusciPlayTime(System.currentTimeMillis() - this.Dq);
      }
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) && (!this.aMF))
    {
      if (this.jdField_a_of_type_Ssa$a != null)
      {
        this.jdField_a_of_type_Ssa$a.showProgressBar(false);
        this.jdField_a_of_type_Ssa$a.bAy();
      }
      QQToast.a(BaseApplicationImpl.sApplication, this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mErrorMsg, 1).show();
      QLog.w("EditVideoSmartMusicPart", 1, "mediaplayer onError: what:" + paramInt1 + " | extra:" + paramInt2);
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo.mSongMid.equals(this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid)) {
      uZ(true);
    }
  }
  
  public void a(ayic.a parama) {}
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic itemInfo=null");
      }
    }
    do
    {
      return;
      if (this.aMF)
      {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
        return;
      }
      QLog.d("EditVideoSmartMusicPart", 4, "start replay music name:" + paramVsMusicItemInfo.mMusicName);
      a(paramVsMusicItemInfo);
      if (this.jdField_a_of_type_Ssa$a != null) {
        this.jdField_a_of_type_Ssa$a.showProgressBar(true);
      }
    } while ((this.jdField_a_of_type_Sqx == null) || (this.aMF));
    this.jdField_a_of_type_Sqx.setVolume(o(2));
    this.jdField_a_of_type_Sqx.a(paramVsMusicItemInfo);
  }
  
  public void bAv()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.clear();
    }
  }
  
  public void bsg()
  {
    if (!this.mIsResume) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "playBgMusic in = null mIsResume=" + this.mIsResume);
      }
    }
    while (this.jdField_a_of_type_Sqx == null) {
      return;
    }
    if (this.jdField_a_of_type_Ssa$a != null)
    {
      this.jdField_a_of_type_Ssa$a.showProgressBar(false);
      this.jdField_a_of_type_Ssa$a.bAz();
    }
    b(this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    this.jdField_a_of_type_Sqx.start();
  }
  
  public void bsh()
  {
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.pause();
    }
  }
  
  public void bsi()
  {
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.resume();
    }
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      return;
    case 6: 
      va(false);
      return;
    }
    va(true);
  }
  
  protected boolean e(Message paramMessage)
  {
    if (this.mDestroyed) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      yP(paramMessage.arg1);
    }
  }
  
  public Vibrator getVibrator()
  {
    if (this.mVibrator == null) {
      this.mVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    }
    return this.mVibrator;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public String nO()
  {
    if ((this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (this.AX == null) || (this.fT == null) || (this.fT.get(this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid) == null)) {
      return "";
    }
    return (String)this.fT.get(this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
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
      bAo();
      bAw();
      bAx();
      continue;
      boolean bool;
      label72:
      ImageView localImageView;
      if (!this.aMG)
      {
        bool = true;
        this.aMG = bool;
        uZ(true);
        localImageView = this.oH;
        if (!this.aMG) {
          break label118;
        }
      }
      label118:
      for (Drawable localDrawable = this.dr;; localDrawable = this.dq)
      {
        localImageView.setBackgroundDrawable(localDrawable);
        bAw();
        break;
        bool = false;
        break label72;
      }
      bAs();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.aMJ = this.jdField_b_of_type_Aygz.Ld();
    this.aMK = this.jdField_b_of_type_Aygz.aQB();
    initView();
    initData();
    a(aydu.class, this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.ao, localIntentFilter);
    this.byS = ((Long)spp.a().getValue("SmartMatchMusicSwitch", Long.valueOf(0L))).intValue();
    switch (this.byS)
    {
    }
    do
    {
      do
      {
        return;
        bAn();
      } while (this.oI == null);
      this.oI.setBackgroundDrawable(this.dq);
      this.aMF = false;
      this.aO.setVisibility(0);
      return;
    } while (this.qE == null);
    this.qE.setVisibility(8);
  }
  
  public void onDestroy()
  {
    bAm();
    this.mDestroyed = true;
    a().removeCallbacks(null);
    BaseApplicationImpl.getApplication().unregisterReceiver(this.ao);
    VSNetworkHelper.a().cK(getContext());
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.stop();
    }
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.release();
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.clear();
    }
    if (this.jdField_a_of_type_Ssa$a != null) {
      this.jdField_a_of_type_Ssa$a.bAy();
    }
    a().removeCallbacks(null);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mIsResume = false;
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mIsResume = true;
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null) && (this.byU != -1))
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.smoothScrollToPosition(this.byU);
      this.byU = -1;
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.jdField_a_of_type_Sqx != null) {
      this.jdField_a_of_type_Sqx.seekTo(paramLong);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setMusicData(paramList);
    if (((paramList == null) || (paramList.size() == 0)) && (this.jdField_a_of_type_Ssa.ut() == 0))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
      return;
    }
    bAt();
  }
  
  public void tA(String paramString) {}
  
  public void tz(String paramString) {}
  
  public void u(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (aqmr.isEmpty(paramString2)) {
      str = "LRC";
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.setData(paramString1, str);
  }
  
  public int us()
  {
    if ((this.jdField_a_of_type_Ssa.getData() == null) || (this.jdField_a_of_type_Ssa.getData().size() == 0)) {
      return 0;
    }
    return (int)(Math.floor(this.jdField_a_of_type_Ssa.getItemCount() / this.jdField_a_of_type_Ssa.getData().size() / 2) * this.jdField_a_of_type_Ssa.getData().size());
  }
  
  public void vibrate()
  {
    a().postDelayed(new EditVideoSmartMusicPart.9(this), 100L);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo);
    
    public abstract void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean);
    
    public abstract void b(int paramInt, ssa.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srs
 * JD-Core Version:    0.7.0.1
 */