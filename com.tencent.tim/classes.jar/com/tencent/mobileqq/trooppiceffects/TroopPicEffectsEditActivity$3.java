package com.tencent.mobileqq.trooppiceffects;

import akxy;
import akyj;
import aooi;
import aool;
import aool.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, akxy paramakxy) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.localPath, 0);
    ((CompressInfo)localObject).picType = 0;
    akyj.b((CompressInfo)localObject);
    aool localaool = new aool();
    localaool.mSelfUin = this.this$0.app.getAccount();
    localaool.mPeerUin = this.this$0.cqt;
    localaool.cmn = this.this$0.app.getCurrentAccountUin();
    localaool.mUinType = 1;
    localaool.mFileType = 1;
    localaool.cNy = true;
    localaool.mBusiType = this.a.busiType;
    localaool.dQ = ((CompressInfo)localObject).destPath;
    localaool.mMd5 = this.a.md5;
    localObject = new aool.d();
    localaool.en = localObject;
    ((aool.d)localObject).cNJ = false;
    localaool.b = new TroopPicEffectsEditActivity.c(this.this$0);
    localaool.cND = this.a.cuZ;
    localaool.cvb = this.a.cvb;
    localaool.mFileType = 55;
    localaool.mUniseq = System.currentTimeMillis();
    this.this$0.app.a().a(localaool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */