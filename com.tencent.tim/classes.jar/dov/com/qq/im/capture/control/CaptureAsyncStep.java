package dov.com.qq.im.capture.control;

import alvs;
import awrz;
import awtq;
import axbi;
import axol;
import axov;
import axpl;
import axpr;
import axro;
import axsu;
import aywa;
import ayzs;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import common.config.service.QzoneConfig;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import skj;
import sxa;

public class CaptureAsyncStep
{
  public static class BindRichMediaClient
    extends AsyncStep
  {
    public int od()
    {
      alvs.a().bu(BaseApplicationImpl.sApplication);
      return 7;
    }
  }
  
  public static class BindTroopMemberClient
    extends AsyncStep
  {
    public skj mClient;
    
    public int od()
    {
      this.mClient = skj.a();
      this.mClient.bzj();
      this.mClient.h(new axpl(this));
      return 7;
    }
  }
  
  public static class InitCombo
    extends AsyncStep
  {
    public int od()
    {
      aywa.a(axol.getAppInterface());
      axpr localaxpr = (axpr)axov.a(5);
      localaxpr.eNH();
      localaxpr.YP(false);
      if ((this.mParams[0] != null) && ((this.mParams[0] instanceof QIMEffectCameraCaptureUnit))) {
        ((QIMEffectCameraCaptureUnit)this.mParams[0]).CT(false);
      }
      for (;;)
      {
        return 7;
        if ((this.mParams[0] != null) && ((this.mParams[0] instanceof awtq))) {
          ((awtq)this.mParams[0]).CT(false);
        }
      }
    }
  }
  
  public static class InitMusic
    extends AsyncStep
  {
    public int od()
    {
      axro localaxro = (axro)axov.a().c(8);
      if (localaxro != null) {
        localaxro.eOq();
      }
      ((QIMMusicConfigManager)axov.a(2)).eNH();
      return 7;
    }
  }
  
  public static class InitPaster
    extends AsyncStep
  {
    public int od()
    {
      aywa.a(axol.getAppInterface());
      axsu localaxsu = (axsu)axov.a().c(4);
      localaxsu.eNH();
      localaxsu.clear();
      return 7;
    }
  }
  
  public static class InitTemplate
    extends AsyncStep
  {
    public int od()
    {
      ((ayzs)axov.a(3)).eNH();
      ayzs.dyy = ((Integer)this.mParams[1]).intValue();
      return 7;
    }
  }
  
  public static class LoadQzoneConfig
    extends AsyncStep
  {
    public int od()
    {
      QzoneConfig.getInstance().loadAllConfigs();
      return 7;
    }
  }
  
  public static class OnShowOther
    extends AsyncStep
  {
    public int od()
    {
      awrz localawrz = (awrz)axov.a(13);
      localawrz.acZ(0);
      localawrz.acY(2);
      sxa.a().bzW = 1;
      sxa.a().bzY = 1;
      return 7;
    }
  }
  
  public static class StoryCameraReq
    extends AsyncStep
  {
    public int od()
    {
      axbi localaxbi = (axbi)QQStoryContext.c().getBusinessHandler(3);
      localaxbi.acl("MqStoryCamera");
      localaxbi.acl("MqEmoCamera");
      localaxbi.eIA();
      localaxbi.eIz();
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep
 * JD-Core Version:    0.7.0.1
 */