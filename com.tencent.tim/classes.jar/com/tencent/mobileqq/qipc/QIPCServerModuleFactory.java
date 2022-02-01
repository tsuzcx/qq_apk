package com.tencent.mobileqq.qipc;

import aacv;
import acbu;
import accu;
import acdr;
import acee;
import acfe;
import aclt;
import aczn;
import adal;
import adot;
import adst;
import aeaj;
import aebb;
import aeer;
import afgv;
import afhr;
import agmu;
import ahfr;
import ahsw;
import ahvf;
import aiaq;
import aihk;
import ailz;
import aiov;
import akxs;
import alap;
import alsq;
import anjy;
import anqd;
import aobn;
import aobw;
import aogv;
import aopd;
import apwp;
import aqqv;
import aqqz;
import aqrj;
import aroh;
import arzi;
import avdj;
import avfr;
import avmy;
import avre;
import awop;
import axch;
import axil;
import axyu;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import ify;
import ld;
import lgm;
import mqq.app.SecurityFileModule;
import muy;
import rfg;
import tfi.a;
import tfi.b;
import tjq;
import tzc.a;
import znx;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return accu.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return aopd.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return arzi.a().b();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return avfr.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return alap.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return rfg.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return muy.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return aqrj.a();
    }
    if ("SignInModule".equals(paramString)) {
      return aclt.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return avdj.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return aacv.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return awop.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return aeaj.a();
    }
    if ("soso_interface".equals(paramString)) {
      return aczn.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return alsq.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return avre.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return anjy.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return tjq.a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return tfi.b.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return tfi.a.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return ld.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return afhr.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return acbu.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return aqqv.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return aogv.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return tzc.a.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return aobn.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return adst.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return adot.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return aiaq.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return znx.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return aebb.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return ailz.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return adal.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return agmu.a().b();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return aobw.c();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return anqd.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return axch.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return aqqz.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return aiov.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return afgv.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return apwp.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return axyu.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return axil.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return acfe.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return acee.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return aroh.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return akxs.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return lgm.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aeer.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return ify.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return ahvf.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return aihk.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return avmy.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return ahfr.a();
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return acdr.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return MiniGamePublicAccountIPCModule.getInstance();
    }
    if ("module_game_buddy".equals(paramString)) {
      return ahsw.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */