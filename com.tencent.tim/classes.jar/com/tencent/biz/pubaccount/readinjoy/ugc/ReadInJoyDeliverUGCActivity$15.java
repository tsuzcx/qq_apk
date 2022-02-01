package com.tencent.biz.pubaccount.readinjoy.ugc;

import akyj;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import aojg;
import aooi;
import aool;
import aqhu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kbp;
import kxm;
import lbz;

class ReadInJoyDeliverUGCActivity$15
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$15(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Object paramObject, int paramInt) {}
  
  public void run()
  {
    if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {}
    label424:
    long l1;
    CompressInfo localCompressInfo;
    long l2;
    String str1;
    label1431:
    do
    {
      String str2;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic");
              }
              if (!this.val$object.equals(ReadInJoyDeliverUGCActivity.a(this.this$0)))
              {
                if (!(this.val$object instanceof HotPicData)) {
                  break;
                }
                localObject = (HotPicData)this.val$object;
                if (this.val$position < 9)
                {
                  ReadInJoyDeliverUGCActivity.a(this.this$0).aw(this.val$position, ((HotPicData)localObject).originalUrl);
                  ReadInJoyDeliverUGCActivity.a(this.this$0).ax(this.val$position, ((HotPicData)localObject).md5);
                  ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.val$position, Integer.valueOf(((HotPicData)localObject).height));
                  ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.val$position, Integer.valueOf(((HotPicData)localObject).width));
                  ReadInJoyDeliverUGCActivity.f(this.this$0);
                }
                while (ReadInJoyDeliverUGCActivity.d(this.this$0) == ReadInJoyDeliverUGCActivity.a(this.this$0))
                {
                  ReadInJoyDeliverUGCActivity.d(this.this$0, true);
                  lbz.a().a(this.this$0.app.getCurrentUin(), ReadInJoyDeliverUGCActivity.c(this.this$0), ReadInJoyDeliverUGCActivity.b(this.this$0), ReadInJoyDeliverUGCActivity.e(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0).z(), ReadInJoyDeliverUGCActivity.a(this.this$0).w(), ReadInJoyDeliverUGCActivity.a(this.this$0).x(), ReadInJoyDeliverUGCActivity.a(this.this$0).A(), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.g(this.this$0));
                  return;
                  ReadInJoyDeliverUGCActivity.c(this.this$0, false);
                  this.this$0.aAt();
                }
              }
            }
            if (!(this.val$object instanceof String)) {
              break;
            }
            str2 = (String)this.val$object;
            if (!TextUtils.isEmpty(str2)) {
              break label424;
            }
            this.this$0.aAt();
            this.this$0.aCY();
          } while (!QLog.isColorLevel());
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
          return;
          this.this$0.aAt();
          this.this$0.aCY();
        } while (!QLog.isColorLevel());
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
        return;
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          break;
        }
        ReadInJoyDeliverUGCActivity.e(this.this$0, true);
        this.this$0.aAt();
        this.this$0.aCY();
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic file not exist, path=" + str2);
      return;
      l1 = ((File)localObject).length();
      ReadInJoyDeliverUGCActivity.a(this.this$0).H(this.val$position, l1);
      ReadInJoyDeliverUGCActivity.a(this.this$0).J(this.val$position, NetConnInfoCenter.getServerTimeMillis());
      localCompressInfo = new CompressInfo(str2, 0);
      localCompressInfo.picType = 0;
      localCompressInfo.busiType = 1036;
      boolean bool1 = true;
      Object localObject = new BitmapFactory.Options();
      for (;;)
      {
        try
        {
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          aqhu.d(str2, (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outHeight <= ((BitmapFactory.Options)localObject).outWidth) {
            continue;
          }
          i = ((BitmapFactory.Options)localObject).outHeight;
          if (i <= 2560) {
            bool1 = false;
          }
        }
        catch (Exception localException2)
        {
          int i;
          boolean bool2;
          aooi localaooi;
          ReadInJoyDeliverUGCActivity.b localb;
          aool localaool;
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "isNeedCompress error" + localException2.toString());
          continue;
          ReadInJoyDeliverUGCActivity.b(this.this$0).add(localCompressInfo.destPath);
          continue;
          localCompressInfo.dpx = localException1.outWidth;
          localCompressInfo.dpy = localException1.outHeight;
          continue;
          str1 = localCompressInfo.destPath;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "beforeCompress picture: w:" + ((BitmapFactory.Options)localObject).outWidth + "  h:" + ((BitmapFactory.Options)localObject).outHeight + " size:" + l1 / 1024L + "kb isNeedCompress:" + bool1);
        }
        if (!bool1) {
          continue;
        }
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        bool2 = akyj.b(localCompressInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "compress result= " + bool2);
        }
        if (bool2) {
          continue;
        }
        ReadInJoyDeliverUGCActivity.c(this.this$0, 1001);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic compressPath=" + localCompressInfo.destPath + ", path=" + str2 + ", width=" + localCompressInfo.dpx + ", height=" + localCompressInfo.dpy);
        }
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.val$position, Integer.valueOf(((BitmapFactory.Options)localObject).outWidth));
        ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.val$position, Integer.valueOf(((BitmapFactory.Options)localObject).outHeight));
        if (!TextUtils.isEmpty(localCompressInfo.destPath)) {
          continue;
        }
        localObject = str2;
        l2 = new File((String)localObject).length();
        ReadInJoyDeliverUGCActivity.a(this.this$0).I(this.val$position, l2);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "afterCompress picture: w:" + localCompressInfo.dpx + "  h:" + localCompressInfo.dpy + " size:" + l2 / 1024L + "kb");
        }
        ReadInJoyDeliverUGCActivity.a(this.this$0).K(this.val$position, NetConnInfoCenter.getServerTimeMillis());
        localaooi = this.this$0.app.a();
        localb = new ReadInJoyDeliverUGCActivity.b(this.this$0, this.this$0.getMainLooper());
        localaool = new aool();
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "doStartUploadPicposition" + this.val$position);
        }
        localb.addFilter(new Class[] { aojg.class });
        localaooi.a(localb);
        localaool.cNy = true;
        localaool.dOM = 10;
        localaool.dQ = ((String)localObject);
        localaool.mUniseq = this.val$position;
        localaool.mPeerUin = "0";
        localaool.mFileType = 24;
        localaool.ckW = "KandianUGCPicUpload";
        localaooi.a(localaool);
        localb.and = true;
        ReadInJoyDeliverUGCActivity.d(this.this$0).add(localb);
        ReadInJoyDeliverUGCActivity.e(this.this$0).add(localaool);
        ReadInJoyDeliverUGCActivity.a(this.this$0).L(this.val$position, NetConnInfoCenter.getServerTimeMillis());
        if (!bool1) {
          break;
        }
        try
        {
          localObject = str2.substring(str2.lastIndexOf(".") + 1);
          if (l2 != l1) {
            break label1431;
          }
          kbp.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(localCompressInfo.dpx), String.valueOf(localCompressInfo.dpy), (String)localObject, kxm.bb(0), false);
          return;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
        return;
        i = localException1.outWidth;
      }
    } while (l2 <= l1);
    kbp.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(localCompressInfo.dpx), String.valueOf(localCompressInfo.dpy), str1, kxm.bb(1), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.15
 * JD-Core Version:    0.7.0.1
 */