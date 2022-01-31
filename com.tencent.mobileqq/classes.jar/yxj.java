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
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
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

public class yxj
  extends bmiv
  implements Handler.Callback, View.OnClickListener, bmeu, ywi
{
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  private bmjh jdField_a_of_type_Bmjh;
  private FrameVideoHelper jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper;
  private SingleLyricView jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString = "EditVideoSmartMusicPart";
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ywh jdField_a_of_type_Ywh;
  private yxs jdField_a_of_type_Yxs;
  private yxv jdField_a_of_type_Yxv;
  private boolean jdField_a_of_type_Boolean = true;
  public float b;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString = (String)yuh.a().a("KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL", "http://down.qq.com/video_story/smart_music_anim.zip");
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long = System.currentTimeMillis();
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public yxj(@NonNull bmix parambmix)
  {
    super(parambmix);
    this.jdField_a_of_type_Float = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixoriginalaudiovolume", 0.7F);
    this.jdField_b_of_type_Float = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixmusicvolume", 1.0F);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yxq(this);
  }
  
  private void A()
  {
    bmld localbmld;
    if (bkwm.c.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f))
    {
      localbmld = bmld.a();
      if (this.jdField_a_of_type_Boolean) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      localbmld.a(bool);
      return;
    }
  }
  
  private float a(int paramInt)
  {
    if (paramInt == 1) {
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {}
    }
    do
    {
      do
      {
        do
        {
          return 0.0F;
        } while ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean));
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
          return this.jdField_a_of_type_Float;
        }
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          break;
        }
        return 1.0F;
        if (paramInt != 2) {
          break;
        }
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean));
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        return 1.0F;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        return this.jdField_b_of_type_Float;
      }
    } while ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean));
    return 1.0F;
  }
  
  private bmjh a()
  {
    if (this.jdField_a_of_type_Bmjh == null) {
      this.jdField_a_of_type_Bmjh = ((bmjh)this.jdField_a_of_type_Bmix.a(bmjh.class));
    }
    return this.jdField_a_of_type_Bmjh;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 3: 
      ywz.a().a();
      return;
    }
    ywz.a().b();
  }
  
  private void a(int paramInt, yxv paramyxv)
  {
    if (paramyxv == null) {
      paramyxv = (yxv)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.findViewHolderForAdapterPosition(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Yxv = paramyxv;
      if ((this.jdField_a_of_type_Yxv != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Yxv.a();
        ak_();
      }
      b(a());
      return;
    }
  }
  
  private void a(CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp) {}
  
  private void a(Intent paramIntent)
  {
    int j = 0;
    Object localObject1 = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic")) || (this.jdField_c_of_type_Boolean)) {}
    Object localObject2;
    label277:
    label282:
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
          if (this.jdField_a_of_type_Ywh != null)
          {
            this.jdField_a_of_type_Ywh.c();
            i();
          }
          localObject2 = new JSONObject((String)localObject1);
          paramIntent = new VsMusicItemInfo((JSONObject)localObject2);
          QLog.i("EditVideoSmartMusicPart", 2, "onReceive Music From H5:" + (String)localObject1);
          if (this.jdField_a_of_type_Yxs == null) {
            break;
          }
          if (this.jdField_a_of_type_Yxs.a() <= 0) {
            break label277;
          }
          i = 1;
          if (i == 0) {
            break label282;
          }
          if (this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int, paramIntent))
          {
            paramIntent.jdField_a_of_type_Boolean = false;
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramIntent.mSongMid);
            b((ArrayList)localObject1);
          }
          this.jdField_d_of_type_Int = (this.jdField_a_of_type_Yxs.a(paramIntent.mSongMid) + a());
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
    this.jdField_a_of_type_Yxs.a((ArrayList)localObject1);
  }
  
  private void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, yxv paramyxv)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.c();
    }
    i();
    a(paramInt, paramyxv);
    if (paramVsMusicItemInfo.jdField_a_of_type_Boolean) {
      a(paramVsMusicItemInfo);
    }
    y();
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return;
    }
    if ((paramMusicItemInfo.musicDuration == 0) && (paramMusicItemInfo.getLocalPath() != null)) {
      paramMusicItemInfo.musicDuration = ((int)ShortVideoUtils.a(paramMusicItemInfo.getLocalPath()));
    }
    if (this.g) {
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
  
  private void a(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, bkum.a().a(), this.jdField_f_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    this.jdField_c_of_type_JavaLangString = paramArrayList.getCmdName();
    VSNetworkHelper.a().a(a(), paramArrayList, new yxp(this));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    t();
    if (a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp)) {
      return;
    }
    a(paramStSmartMatchMusicRsp);
    a(paramStSmartMatchMusicRsp.vecMusic.get());
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
    i();
    if ((paramVsMusicItemInfo == null) || (TextUtils.isEmpty(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView == null)) {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics null");
    }
    while ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (!this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      return;
    }
    if ((paramVsMusicItemInfo.jdField_b_of_type_JavaLangString == null) || (paramVsMusicItemInfo.jdField_b_of_type_JavaLangString.isEmpty()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics is Empty");
      return;
    }
    a(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString, paramVsMusicItemInfo.jdField_a_of_type_JavaLangString, paramVsMusicItemInfo.musicStart);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (this.jdField_a_of_type_Yxs != null) {
      this.jdField_a_of_type_Yxs.a(paramArrayList, true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    a().a(this.jdField_b_of_type_Boolean);
    a().a(a(1));
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bmix.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_Bmix.a(Message.obtain(null, 3, 2, 0));
  }
  
  private void c(boolean paramBoolean)
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void j()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Ywh = new ywh();
      this.jdField_a_of_type_Ywh.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
      {
        this.jdField_a_of_type_Ywh.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        a(alpo.a(2131704206) + "\n视频时长：" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L + "s");
        a(alpo.a(2131704223) + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + "  " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
        bler.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L);
      }
      if (this.g) {
        this.jdField_a_of_type_Ywh.a(60000);
      }
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_Bmix.a().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES"));
      if (this.jdField_a_of_type_Bmix.a().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) != 2) {
        break label345;
      }
    }
    label345:
    for (int i = 0;; i = 1)
    {
      this.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_Bmix.a().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
      k();
      return;
      if (!(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
        break;
      }
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Long = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mStartTime;
      break;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaIoFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
    l();
    if ((this.jdField_a_of_type_JavaIoFile.exists()) || (bdje.a(this.jdField_d_of_type_JavaLangString)))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "animFile exist:" + this.jdField_a_of_type_JavaIoFile.exists() + " | downloadUrl:" + this.jdField_d_of_type_JavaLangString);
      return;
    }
    ThreadManagerV2.executeOnNetWorkThread(new EditVideoSmartMusicPart.1(this));
  }
  
  private void l()
  {
    File localFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
    if ((localFile.exists()) && (localFile.listFiles() != null))
    {
      if (localFile.listFiles().length < 25)
      {
        if (this.jdField_a_of_type_JavaIoFile != null) {
          this.jdField_a_of_type_JavaIoFile.delete();
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
  
  private void n()
  {
    this.jdField_e_of_type_AndroidViewView = a(2131379780);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378649));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131378937));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379767));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368837));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368827));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378837));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131368754));
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView = ((SingleLyricView)a(2131376790));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376800));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130850085);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130850084);
    this.jdField_c_of_type_AndroidViewView = a(2131369671);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2131369665);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366436));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().findViewById(2131363334);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().findViewById(2131363332);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    o();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new yxl(this));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new yxm(this));
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.g)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    QLog.d("EditVideoSmartMusicPart", 2, "getRealHeight" + azgq.c(a()) + "ScreenUtil.getRealWidth(getContext())" + azgq.e(a()));
    int i;
    int m;
    int k;
    int j;
    if (azgq.c(a()) / azgq.e(a()) >= 2.0F)
    {
      bngs.c((Activity)a());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if ((!bkwm.c.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) || ((!this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()) && (!this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (!this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label667;
      }
      i = aekt.a(105.0F, a().getResources());
      m = aekt.a(34.0F, a().getResources());
      k = aekt.a(19.0F, a().getResources());
      j = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), j);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localMarginLayoutParams.bottomMargin = m;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localMarginLayoutParams);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getLayoutParams();
      localMarginLayoutParams.bottomMargin = k;
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setLayoutParams(localMarginLayoutParams);
      return;
      if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams() == null)) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 0, this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height);
      break;
      label667:
      j = aekt.a(17.0F, a().getResources());
      i = aekt.a(0.0F, a().getResources());
      k = aekt.a(-15.0F, a().getResources());
      m = i;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView = ((SmartMusicRecyclerView)a(2131364938));
    this.jdField_a_of_type_Yxs = ((yxs)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getAdapter());
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setListener(new yxn(this));
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Yxs == null) {}
    VsMusicItemInfo localVsMusicItemInfo;
    do
    {
      return;
      localVsMusicItemInfo = this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int);
    } while (localVsMusicItemInfo == null);
    JSONObject localJSONObject = new JSONObject();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_f_of_type_Long;
    try
    {
      localJSONObject.put("music_id", localVsMusicItemInfo.mSongMid);
      localJSONObject.put("music_play_time", l1 - l2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        localJSONObject.put("video_duration", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      }
      yvu.a("mystatus_edit", "aimusic_exp_clk", 0, 0, new String[] { String.valueOf(localVsMusicItemInfo.jdField_a_of_type_Int), "", localJSONObject.toString() });
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      wsv.c("EditVideoSmartMusicPart", "reportSmartMusic   reportClickMusic() args3:" + localJSONObject.toString());
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
  
  private void q()
  {
    s();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null)
      {
        QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
        return;
      }
      a(alpo.a(2131704312));
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper = new FrameVideoHelper(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a(this.jdField_e_of_type_Long, new yxo(this));
      return;
    }
    a("抽帧耗时：0ms\n抽取图片数：" + this.jdField_a_of_type_JavaUtilArrayList.size() + "\n抽帧字节数：" + this.jdField_a_of_type_Long / 1000L + "KB");
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void r()
  {
    boolean bool = false;
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      q();
      yvu.a("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
    }
    if (!this.jdField_a_of_type_Boolean) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      v();
      return;
      this.jdField_a_of_type_Ywh.c();
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
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
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(arrayOfString);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1666L);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2147483647);
  }
  
  private void t()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void v()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = true;
        ((SmartMusicRecyclerView)localObject).setNeedScale(bool1);
      }
    }
    else if (this.jdField_a_of_type_Yxv != null)
    {
      localObject = this.jdField_a_of_type_Yxv;
      if (this.jdField_a_of_type_Boolean) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((yxv)localObject).a(bool1);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Yxv.b();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void w()
  {
    Activity localActivity = (Activity)a();
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bdcb.a(), "", Integer.valueOf(6) }));
    localIntent.putExtra("finish_animation_up_down", true);
    localActivity.startActivityForResult(localIntent, 1001);
    localActivity.overridePendingTransition(2130771979, 0);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getBackground() == null)
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838594);
      a().post(new EditVideoSmartMusicPart.7(this));
    }
  }
  
  private void y()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int - 1) != null) {
        localJSONObject.put("mid1", this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int - 1).mSongMid);
      }
      if (this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int) != null) {
        localJSONObject.put("mid2", this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int).mSongMid);
      }
      if (this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int + 1) != null) {
        localJSONObject.put("mid3", this.jdField_a_of_type_Yxs.a(this.jdField_a_of_type_Int + 1).mSongMid);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    yvu.a("mystatus_edit", "aimusic_exp", 0, 0, new String[] { "", "", localJSONObject.toString() });
    wsv.c("EditVideoSmartMusicPart", "reportSmartMusic   reportShowMusic() args3:" + localJSONObject.toString());
  }
  
  private void z()
  {
    if (bkwm.c.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
      bmld.a().a();
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Yxs.a() == null) || (this.jdField_a_of_type_Yxs.a().size() == 0)) {
      return 0;
    }
    return (int)(Math.floor(this.jdField_a_of_type_Yxs.getItemCount() / this.jdField_a_of_type_Yxs.a().size() / 2) * this.jdField_a_of_type_Yxs.a().size());
  }
  
  public Vibrator a()
  {
    if (this.jdField_a_of_type_AndroidOsVibrator == null) {
      this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)a().getSystemService("vibrator"));
    }
    return this.jdField_a_of_type_AndroidOsVibrator;
  }
  
  public bhow a()
  {
    if (this.jdField_a_of_type_Bhow == null) {
      this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_Bhow;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid) == null)) {
      return "";
    }
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
  }
  
  public void a()
  {
    super.a();
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_Bmix.b();
    this.g = this.jdField_a_of_type_Bmix.c();
    n();
    j();
    a(bmeu.class, this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_b_of_type_Int = ((Long)yuh.a().a("SmartMatchMusicSwitch", Long.valueOf(0L))).intValue();
    switch (this.jdField_b_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
        q();
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
    } while (this.jdField_d_of_type_AndroidViewView == null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      return;
    case 6: 
      c(false);
      return;
    }
    c(true);
  }
  
  public void a(int paramInt, bmwn parambmwn)
  {
    boolean bool2 = false;
    this.jdField_d_of_type_Boolean = true;
    if (this.g) {
      this.jdField_b_of_type_Boolean = true;
    }
    Object localObject = parambmwn.a;
    boolean bool1;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = true;
      ((PublishVideoEntry)localObject).putExtra("isMixOriginal", Boolean.valueOf(bool1));
      localObject = parambmwn.a;
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        bool1 = true;
      }
      ((PublishVideoEntry)localObject).isMixOriginal = bool1;
      parambmwn.a.isMuteRecordVoice = this.jdField_b_of_type_Boolean;
      parambmwn.a.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_Bmix.a().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
      parambmwn.a.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.g));
      parambmwn.a.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.jdField_a_of_type_Bmix.a().isLandTakePicToVideo()));
      if (!this.jdField_a_of_type_Boolean) {
        break label200;
      }
      parambmwn.a.backgroundMusicPath = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        this.jdField_a_of_type_Bmix.a().setVideoDuration(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      }
      return;
      bool1 = false;
      break;
      label200:
      if ((this.jdField_a_of_type_Ywh != null) && (this.jdField_a_of_type_Ywh.a() != null))
      {
        localObject = this.jdField_a_of_type_Ywh.a();
        parambmwn.a.backgroundMusicOffset = ((VsMusicItemInfo)localObject).musicStart;
        int i = ((VsMusicItemInfo)localObject).musicEnd - ((VsMusicItemInfo)localObject).musicStart;
        int j = i;
        if (!this.g)
        {
          j = i;
          if (i < 0) {
            j = 60000;
          }
          j = Math.min(j, (int)this.jdField_a_of_type_Bmix.a(paramInt));
        }
        parambmwn.a.backgroundMusicDuration = j;
        parambmwn.a.backgroundMusicPath = ((VsMusicItemInfo)localObject).getLocalPath();
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(((VsMusicItemInfo)localObject).mItemId));
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_mid_id", ((VsMusicItemInfo)localObject).mSongMid);
        parambmwn.a.putExtra("vs_publish_entry_json_key_song_name", ((VsMusicItemInfo)localObject).mMusicName);
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_album_pic", ((VsMusicItemInfo)localObject).mAlbumUrl);
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_download_url", ((VsMusicItemInfo)localObject).mUrl);
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_source_from", Integer.valueOf(((VsMusicItemInfo)localObject).jdField_a_of_type_Int));
        parambmwn.a.putExtra("originalRecordVolume", Float.valueOf(a(1)));
        parambmwn.a.putExtra("backgroundVolume", Float.valueOf(a(2)));
        this.jdField_a_of_type_Bmix.a().setSongMid(((VsMusicItemInfo)localObject).mSongMid);
        this.jdField_a_of_type_Bmix.a().setMusicType(((VsMusicItemInfo)localObject).jdField_a_of_type_Int);
        this.jdField_a_of_type_Bmix.a().setMusciPlayTime(System.currentTimeMillis() - this.jdField_f_of_type_Long);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.b(paramLong);
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Yxv != null)
      {
        this.jdField_a_of_type_Yxv.b(false);
        this.jdField_a_of_type_Yxv.b();
      }
      QQToast.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.jdField_c_of_type_JavaLangString, 1).a();
      QLog.w("EditVideoSmartMusicPart", 1, "mediaplayer onError: what:" + paramInt1 + " | extra:" + paramInt2);
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo.mSongMid.equals(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid)) {
      b(true);
    }
  }
  
  public void a(bmkb parambmkb) {}
  
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
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
        return;
      }
      QLog.d("EditVideoSmartMusicPart", 4, "start replay music name:" + paramVsMusicItemInfo.mMusicName);
      a(paramVsMusicItemInfo);
      if (this.jdField_a_of_type_Yxv != null) {
        this.jdField_a_of_type_Yxv.b(true);
      }
    } while ((this.jdField_a_of_type_Ywh == null) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Ywh.a(a(2));
    this.jdField_a_of_type_Ywh.a(paramVsMusicItemInfo);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (bdje.a(paramString2)) {
      str = "LRC";
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.setData(paramString1, str);
  }
  
  public void a(List<META.StMusic> paramList)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setMusicData(paramList);
    if (((paramList == null) || (paramList.size() == 0)) && (this.jdField_a_of_type_Yxs.a() == 0))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
      return;
    }
    x();
  }
  
  protected boolean a(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      a(paramMessage.arg1);
    }
  }
  
  public void aj_()
  {
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.d();
    }
  }
  
  public void ak_()
  {
    a().postDelayed(new EditVideoSmartMusicPart.9(this), 100L);
  }
  
  public void b()
  {
    if (!this.h) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "playBgMusic in = null mIsResume=" + this.h);
      }
    }
    while (this.jdField_a_of_type_Ywh == null) {
      return;
    }
    if (this.jdField_a_of_type_Yxv != null)
    {
      this.jdField_a_of_type_Yxv.b(false);
      this.jdField_a_of_type_Yxv.d();
    }
    b(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    this.jdField_a_of_type_Ywh.a();
  }
  
  public void b(String paramString) {}
  
  public void bd_()
  {
    super.bd_();
    this.h = false;
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.d();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.e();
    }
  }
  
  public void f()
  {
    super.f();
    this.h = true;
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null) && (this.jdField_d_of_type_Int != -1))
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.smoothScrollToPosition(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
  }
  
  public void g()
  {
    p();
    this.jdField_c_of_type_Boolean = true;
    a().removeCallbacks(null);
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    VSNetworkHelper.a().a(a());
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
    }
    if (this.jdField_a_of_type_Ywh != null) {
      this.jdField_a_of_type_Ywh.b();
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.a();
    }
    if (this.jdField_a_of_type_Yxv != null) {
      this.jdField_a_of_type_Yxv.b();
    }
    a().removeCallbacks(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369665: 
      r();
      z();
      A();
      return;
    case 2131369671: 
      boolean bool;
      ImageView localImageView;
      if (!this.jdField_b_of_type_Boolean)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        b(true);
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!this.jdField_b_of_type_Boolean) {
          break label105;
        }
      }
      label105:
      for (paramView = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        localImageView.setBackgroundDrawable(paramView);
        z();
        return;
        bool = false;
        break;
      }
    }
    w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxj
 * JD-Core Version:    0.7.0.1
 */