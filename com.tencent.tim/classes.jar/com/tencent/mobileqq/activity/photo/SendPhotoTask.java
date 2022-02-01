package com.tencent.mobileqq.activity.photo;

import akxe;
import akxj;
import akxq;
import akxy;
import ambj;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import anpc;
import aptk;
import aqfx;
import aqfy;
import aqhq;
import aqip;
import aqmd;
import avfp;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import syw;
import szw;
import szy;
import zsz;

public class SendPhotoTask
  implements Runnable
{
  long Lv = 0L;
  long Lw = 0L;
  Intent Q;
  public String aTl;
  boolean btb = false;
  boolean btc;
  int ceR = 0;
  HashMap<Integer, SendVideoActivity.SendVideoInfo> hu;
  HashMap<String, PhotoSendParams> hv;
  WeakReference<BaseActivity> mActivity;
  int mBusiType;
  int mCurType;
  Handler mHandler = null;
  boolean mNeedCompress = true;
  ArrayList<String> mPaths;
  int mTopicId;
  ArrayList<String> rL;
  ArrayList<CompressInfo> rM = new ArrayList();
  
  public SendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent, Handler paramHandler)
  {
    this.mActivity = new WeakReference(paramBaseActivity);
    this.mHandler = paramHandler;
    this.Q = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.Q = paramIntent;
    }
    cH(this.Q);
    if (this.mHandler != null)
    {
      if (((this.mPaths == null) || (this.mPaths.isEmpty())) && ((this.hv == null) || (this.hv.isEmpty())) && ((this.rL == null) || (this.rL.isEmpty()))) {
        this.mHandler.sendEmptyMessage(4);
      }
    }
    else {
      return;
    }
    this.mHandler.sendEmptyMessage(1);
  }
  
  private boolean VM()
  {
    if (this.Q.hasExtra("presend_handler"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "presendPic ,sendPhotoTask return directly!");
      }
      return true;
    }
    return false;
  }
  
  protected boolean I(String paramString, int paramInt)
  {
    this.Q.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.Q.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    akxq localakxq = akxj.a(2, this.mBusiType);
    localakxq.bEW = this.Q.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    akxy localakxy = akxj.a(this.mBusiType, this.Q);
    if (!a(localakxq, localakxy)) {}
    do
    {
      return false;
      if (!this.mNeedCompress) {
        break;
      }
    } while (!a(localakxy));
    for (;;)
    {
      a((BaseActivity)this.mActivity.get(), localakxq);
      this.Lw = localakxy.uniseq;
      return true;
      localakxy.localPath = paramString;
    }
  }
  
  protected CompressInfo a(int paramInt, Intent paramIntent)
  {
    return akxj.b(paramInt, paramIntent);
  }
  
  protected ArrayList<Integer> a(CompressInfo paramCompressInfo)
  {
    return avfp.an(paramCompressInfo.destPath);
  }
  
  protected void a(akxq paramakxq, QQAppInterface paramQQAppInterface)
  {
    akxj.a(paramakxq, paramQQAppInterface);
  }
  
  protected void a(BaseActivity paramBaseActivity, akxq paramakxq)
  {
    boolean bool1 = false;
    int i = -1;
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhoto,activity or app is null,return!");
      }
    }
    do
    {
      return;
      if ((paramakxq != null) && (paramakxq.b != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
    return;
    d(paramBaseActivity.app, this.aTl, paramakxq.b.localPath);
    if (paramakxq.b.uinType == 9501)
    {
      b(paramBaseActivity, paramakxq);
      return;
    }
    Object localObject;
    int j;
    if ((paramakxq.b.uinType == 9500) && ((paramakxq.dpE == 2) || (paramakxq.dpE == 4)))
    {
      localObject = paramBaseActivity.getIntent();
      this.Q.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramakxq.b.peerUin);
      ((Intent)localObject).putExtra("key_confess_topicid", paramakxq.b.topicId);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramakxq.b.localPath);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(aqfx.REQUEST_CODE, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 82);
      }
      paramBaseActivity.startActivityForResult((Intent)localObject, 2);
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.mPaths.size()];
        this.mPaths.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (bool2) {
          i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        }
        if (paramakxq.b == null) {
          break;
        }
        j = this.mCurType;
        if (paramakxq.b.ceG == 2) {
          bool1 = true;
        }
        zsz.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      a(paramakxq, paramBaseActivity.app);
    }
  }
  
  protected boolean a(akxq paramakxq, akxy paramakxy)
  {
    if (!paramakxq.c(paramakxy))
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return false;
    }
    return true;
  }
  
  protected boolean a(akxy paramakxy)
  {
    CompressInfo localCompressInfo = a(this.mBusiType, this.Q);
    if (localCompressInfo == null)
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. compressInfo is null!");
      return false;
    }
    localCompressInfo.uinType = this.mCurType;
    localCompressInfo.cuS = true;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto,compressInfo.uinType" + localCompressInfo.uinType);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask, compress start.compressInfo.src = " + localCompressInfo.srcPath);
    }
    d(localCompressInfo);
    paramakxy.localPath = localCompressInfo.destPath;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + paramakxy.localPath);
    }
    if ((localCompressInfo.picQuality != 2) && (is(localCompressInfo.destPath))) {
      aqip.beginPile();
    }
    try
    {
      paramakxy.yv = a(localCompressInfo);
      if ((paramakxy.yv != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + paramakxy.yv.toString());
      }
      aqip.endPile("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + localCompressInfo.destPath + ")");
      this.rM.add(localCompressInfo);
      if (localCompressInfo.cuQ)
      {
        paramakxy.protocolType = 1;
        akxe.a(paramakxy, "fixProtocolType", "sendReq.upInfo.protocolType");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + localCompressInfo.destPath + "'s size is " + aqhq.getFileSizes(localCompressInfo.destPath));
        }
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos， " + localCompressInfo.destPath);
        }
      }
      paramakxy.protocolType = paramakxy.getProtocolType();
    }
    return true;
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.Q.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.Q.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.Q.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = akxj.a(2, 1045);
    paramParcelable = akxj.a(1045, this.Q);
    if (!a(paramString, paramParcelable)) {
      return false;
    }
    if (paramParcelable != null) {
      paramParcelable.localPath = null;
    }
    a((BaseActivity)this.mActivity.get(), paramString);
    return true;
  }
  
  protected void b(BaseActivity paramBaseActivity, akxq paramakxq)
  {
    Object localObject = (syw)paramBaseActivity.app.getBusinessHandler(51);
    if ((((syw)localObject).bn(Long.parseLong(paramakxq.b.peerUin))) && (((syw)localObject).i(Long.parseLong(paramakxq.b.peerUin), 17))) {}
    for (boolean bool = true; !Boolean.valueOf(bool).booleanValue(); bool = false)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramakxq.b.localPath);
      ((szy)paramBaseActivity.app.getBusinessHandler(49)).a().a(szy.aIl, paramakxq.b.peerUin, (List)localObject);
      return;
    }
    paramBaseActivity.runOnUiThread(new SendPhotoTask.1(this, (syw)localObject, paramakxq, paramBaseActivity));
  }
  
  protected void cH(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.mBusiType = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      this.mNeedCompress = paramIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
      this.mCurType = paramIntent.getIntExtra("uintype", 1003);
      this.btb = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.btc = paramIntent.getBooleanExtra("send_in_background", false);
      this.mPaths = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      this.rL = this.Q.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
      this.hu = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
      this.aTl = paramIntent.getStringExtra("uin");
      this.ceR = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      this.mTopicId = paramIntent.getIntExtra("key_confess_topicid", 0);
      this.hv = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.photo_send_pic_type"));
      if (this.hv == null) {
        this.hv = new HashMap();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, " sendPhotoTask(),  mBusiType :" + this.mBusiType + ", mNeedCompress:" + this.mNeedCompress + ", mCurType:" + this.mCurType + ",mIsWaitForResult:" + this.btb + ",picQualityType: " + this.ceR + ",mSendBackground = " + this.btc + "mPaths :" + Arrays.toString(this.mPaths.toArray()) + ", PhotoTypeSize:" + this.hv.size());
  }
  
  protected void cI(Intent paramIntent)
  {
    paramIntent = new SendVideoActivity.b((BaseActivity)this.mActivity.get(), paramIntent);
    paramIntent.uH();
    paramIntent.cAr();
  }
  
  protected ArrayList<String> ca()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    if (i < this.mPaths.size())
    {
      localObject = (String)this.mPaths.get(i);
      if (ir((String)localObject)) {
        QLog.e("SendPhotoTask", 2, "sendPhotoTask. path invalid,path:" + (String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!m(i, (String)localObject)) && (!VM()) && (I((String)localObject, i)))
        {
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Photo : " + (String)localObject);
          }
        }
      }
    }
    if ((localArrayList.size() >= 5) && (this.mCurType == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths path=", (String)((Iterator)localObject).next() });
        }
        QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  lastMessageUniseq=", Long.valueOf(this.Lw) });
      }
      hp(localArrayList);
    }
    while (!QLog.isColorLevel()) {
      return localArrayList;
    }
    QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths size=", Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  protected ArrayList<String> cb()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.hv.size() > 0)
    {
      Iterator localIterator = this.hv.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = (PhotoSendParams)this.hv.get(localObject2);
        if ((ir((String)localObject2)) || (localObject1 == null) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawMd5)) || (((PhotoSendParams)localObject1).fileSize <= 0L) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawDownloadUrl)))
        {
          localObject2 = new StringBuilder().append("sendPhotoTask. path invalid, path:").append((String)localObject2).append(", params:");
          if (localObject1 != null) {}
          for (localObject1 = ((PhotoSendParams)localObject1).toString();; localObject1 = "")
          {
            QLog.e("SendPhotoTask", 2, (String)localObject1);
            break;
          }
        }
        if (a((String)localObject2, (Parcelable)localObject1))
        {
          localArrayList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("SendPhotoTask", 2, "sendPhotoTask Qzone path:" + (String)localObject2 + ", photoMd5:" + ((PhotoSendParams)localObject1).rawMd5);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((ambj)paramQQAppInterface.getManager(326)).hi(paramString1, paramString2);
  }
  
  protected void d(CompressInfo paramCompressInfo)
  {
    RichmediaService.f(paramCompressInfo);
  }
  
  protected void hp(List<String> paramList)
  {
    if ((this.mActivity.get() != null) && (((BaseActivity)this.mActivity.get()).app != null)) {
      aptk.a(((BaseActivity)this.mActivity.get()).app, this.aTl, ((BaseActivity)this.mActivity.get()).app.getCurrentUin(), paramList, this.Lw);
    }
  }
  
  protected boolean ir(String paramString)
  {
    return !aqhq.fileExistsAndNotEmpty(paramString);
  }
  
  protected boolean is(String paramString)
  {
    return avfp.is(paramString);
  }
  
  protected boolean m(int paramInt, String paramString)
  {
    if ((this.hu != null) && (this.hu.get(Integer.valueOf(paramInt)) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Video : " + paramString);
      }
      SendVideoActivity.SendVideoInfo localSendVideoInfo = (SendVideoActivity.SendVideoInfo)this.hu.get(Integer.valueOf(paramInt));
      Intent localIntent = new Intent();
      localIntent.putExtra("file_send_path", paramString);
      localIntent.putExtra("file_send_size", localSendVideoInfo.fileSize);
      localIntent.putExtra("file_send_duration", localSendVideoInfo.duration);
      localIntent.putExtra("uin", this.aTl);
      localIntent.putExtra("uintype", this.mCurType);
      localIntent.putExtra("file_source", "album_flow");
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.ceR);
      cI(localIntent);
      return true;
    }
    return false;
  }
  
  public void run()
  {
    int i = 0;
    if (this.Lv > 0L) {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSendPhotoIdleCost", false, this.Lv, 0L, null, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.mActivity + ", idleCost" + this.Lv);
    }
    long l = System.currentTimeMillis();
    if ((this.rL != null) && (!this.rL.isEmpty())) {
      aqmd.a(((BaseActivity)this.mActivity.get()).app, this.rL, this.aTl, this.mCurType);
    }
    if (this.mPaths == null) {
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(2);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, mPaths.size() : " + this.mPaths.size());
      }
      ArrayList localArrayList1 = ca();
      ArrayList localArrayList2 = cb();
      akxe.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3.addAll(localArrayList1);
      localArrayList3.addAll(localArrayList2);
      if (localArrayList3.size() > 0) {
        this.Q.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList3);
      }
      this.Q.putExtra("param_selNum", localArrayList3.size());
      if (this.ceR == 2)
      {
        int j = localArrayList3.size();
        if (this.hu != null) {
          i = this.hu.size();
        }
        aqfy.ki(j, i);
      }
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */