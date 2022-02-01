import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.3;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.4;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class aasz
  extends aatc
{
  public boolean byO = false;
  public boolean byP = false;
  public boolean byQ = false;
  boolean byR = true;
  public boolean byS = true;
  public final Runnable fk = new RMVideoInitState.2(this);
  public boolean mIsInited = false;
  
  public void CV(boolean paramBoolean)
  {
    this.byR = paramBoolean;
  }
  
  boolean Xa()
  {
    return (RMVideoStateMgr.a().byX) && (this.byO) && (this.byP);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramObject instanceof anim.c)) {
      switch (paramInt)
      {
      }
    }
    Object localObject;
    for (;;)
    {
      super.a(paramObject, paramInt, paramVarArgs);
      return;
      if (paramVarArgs != null) {
        if ((paramVarArgs[0] instanceof Boolean))
        {
          this.byP = true;
          cyc();
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA[success] obj= " + paramVarArgs[0]);
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story"))) {
            rar.b("take_video", "camera_initial", 0, 0, new String[0]);
          }
          ThreadManager.post(new RMVideoInitState.5(this), 8, null, true);
        }
        else if ((paramVarArgs[0] instanceof String))
        {
          if (!this.byQ)
          {
            this.byQ = true;
            RMVideoStateMgr.a().j(2002, acfp.m(2131713954), false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA, error = " + paramVarArgs[0]);
          }
          if (1 == aaqi.ciB) {
            awed.ad(anhm.sUin + "", "qzone_video_record", "2", null);
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story")))
          {
            rar.b("take_video", "camera_initial", 0, -1, new String[0]);
            continue;
            if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof String)))
            {
              if (!this.byQ)
              {
                this.byQ = true;
                RMVideoStateMgr.a().j(2003, acfp.m(2131713949), false);
              }
              if (QLog.isColorLevel()) {
                QLog.d("RMVideoInitState", 2, "[@] EVENT_SET_CAMERA_PARAM error, error = " + paramVarArgs[0]);
              }
              if (1 == aaqi.ciB)
              {
                awed.ad(anhm.sUin + "", "qzone_video_record", "3", null);
                continue;
                if (!this.byQ)
                {
                  this.byQ = true;
                  RMVideoStateMgr.a().j(2002, acfp.m(2131713947), false);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RMVideoInitState", 2, "[@] EVENT_CAMERA_DISABLED error");
                }
                if (1 == aaqi.ciB)
                {
                  awed.ad(anhm.sUin + "", "qzone_video_record", "4", null);
                  continue;
                  if ((paramObject instanceof AudioCapture))
                  {
                    localObject = RMVideoStateMgr.a();
                    switch (paramInt)
                    {
                    case 4: 
                    default: 
                      break;
                    case 3: 
                      if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof Boolean)) && (((Boolean)paramVarArgs[0]).booleanValue()))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [OK]");
                        }
                      }
                      else
                      {
                        if (QLog.isColorLevel())
                        {
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]麦克风初始化参数失败...");
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]mAudioSampleRate=" + aniq.bth + " mAudioChannel=" + aniq.ckG + " mAudioFormat=" + aniq.mAudioFormat);
                        }
                        ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                        ((RMVideoStateMgr)localObject).byY = false;
                        ((RMVideoStateMgr)localObject).CZ(false);
                        if (((RMVideoStateMgr)localObject).mHandler != null) {
                          ((RMVideoStateMgr)localObject).mHandler.post(new RMVideoInitState.6(this));
                        }
                        while (1 == aaqi.ciB)
                        {
                          awed.ad(anhm.sUin + "", "qzone_video_record", "5", null);
                          break;
                          if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [Error]麦克风参数初始化失败 ,rmStateMgr.mHandler = null");
                          }
                        }
                      }
                      break;
                    case 5: 
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_OPEN_MIC [error]麦克风打开失败...");
                      }
                      ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                      ((RMVideoStateMgr)localObject).byY = false;
                      if (RMVideoStateMgr.byW)
                      {
                        ((RMVideoStateMgr)localObject).CZ(true);
                        cyc();
                      }
                      for (;;)
                      {
                        if (!((RMVideoStateMgr)localObject).bzc)
                        {
                          RMVideoStateMgr.a().l(0, acfp.m(2131713950), false);
                          ((RMVideoStateMgr)localObject).bzc = true;
                        }
                        if (1 != aaqi.ciB) {
                          break;
                        }
                        awed.ad(anhm.sUin + "", "qzone_video_record", "6", null);
                        break;
                        ((RMVideoStateMgr)localObject).CZ(false);
                      }
                    case 6: 
                      if ((paramVarArgs == null) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
                        break label922;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [OK]");
                      }
                      ((RMVideoStateMgr)localObject).CZ(true);
                      cyc();
                      ((RMVideoStateMgr)localObject).byY = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label922:
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [error]麦克风启动录制失败...");
    }
    ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    ((RMVideoStateMgr)localObject).byY = false;
    if (RMVideoStateMgr.byW)
    {
      ((RMVideoStateMgr)localObject).CZ(true);
      cyc();
    }
    for (;;)
    {
      if (!((RMVideoStateMgr)localObject).bzc)
      {
        RMVideoStateMgr.a().l(0, acfp.m(2131713945), false);
        ((RMVideoStateMgr)localObject).bzc = true;
      }
      if (1 != aaqi.ciB) {
        break;
      }
      awed.ad(anhm.sUin + "", "qzone_video_record", "7", null);
      break;
      ((RMVideoStateMgr)localObject).CZ(false);
    }
  }
  
  public void cxZ()
  {
    if (Xa()) {
      RMVideoStateMgr.a().tl(3);
    }
  }
  
  void cya()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] retake called");
    }
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.reset();
    }
    for (;;)
    {
      try
      {
        localRMVideoStateMgr.stopWatching();
        if (!this.byR) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().retake()");
        }
        AVCodec.get().retake();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
      }
      if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.reset();
      }
      aniu.a().a().UU(0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().init()");
      }
      AVCodec.get().init();
      this.byR = true;
    }
  }
  
  void cyb()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit called");
    }
    localRMVideoStateMgr.mHandler.postDelayed(new RMVideoInitState.1(this), 50L);
  }
  
  void cyc()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (Xa())
    {
      localRMVideoStateMgr.mHandler.removeCallbacks(this.fk);
      localRMVideoStateMgr.mHandler.post(new RMVideoInitState.3(this));
    }
  }
  
  public void initState()
  {
    this.byQ = false;
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr != null)
    {
      if (localRMVideoStateMgr.jdField_a_of_type_Anka != null) {
        localRMVideoStateMgr.jdField_a_of_type_Anka.a(localRMVideoStateMgr);
      }
      if (localRMVideoStateMgr.jdField_a_of_type_Aatf != null) {
        localRMVideoStateMgr.jdField_a_of_type_Aatf.cwu();
      }
      if (!localRMVideoStateMgr.byX) {
        this.mIsInited = false;
      }
      if (!this.mIsInited) {
        cyb();
      }
    }
    else
    {
      return;
    }
    localRMVideoStateMgr.cym();
    cya();
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct)
  {
    paramAVCodecCallback = RMVideoStateMgr.a();
    switch (paramMessageStruct.mId)
    {
    default: 
      return;
    }
    paramAVCodecCallback.bdG = ((String)paramMessageStruct.mObj0);
    this.byO = true;
    paramAVCodecCallback.jdField_a_of_type_Aasw = null;
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] onAVCodecEvent[RMFileEventNotify] path=" + paramAVCodecCallback.bdG + ",files : " + Arrays.toString(new File(paramAVCodecCallback.bdG).list()));
    }
    paramAVCodecCallback.mHandler.post(new RMVideoInitState.4(this));
    cyc();
  }
  
  public boolean onBackPressed()
  {
    RMVideoStateMgr.a().AQ("RMVideoInitState");
    return false;
  }
  
  public void onPause()
  {
    RMVideoStateMgr.a().cyn();
    this.mIsInited = false;
  }
  
  public void onStop()
  {
    RMVideoStateMgr.a().cyn();
    this.mIsInited = false;
    this.byO = false;
    this.byP = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasz
 * JD-Core Version:    0.7.0.1
 */