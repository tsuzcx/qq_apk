import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class isb
{
  private boolean UG;
  public ish a;
  public isj a;
  public isk a;
  public ism a;
  public isn a;
  public iso a;
  public iss a;
  public isz a;
  public ita a;
  public itc a;
  public itc[] a;
  public int asV = -1;
  public int asW = -1;
  private int asX;
  private int asY;
  private int asZ;
  private int ata;
  public itc[] b = new itc[4];
  public AVRedPacketManager c;
  public List<AVRedPacketManager.LocalEmojiInfo> fu;
  public boolean mIsSend;
  public Vibrator mVibrator;
  
  public isb(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfItc = new itc[10];
    this.jdField_a_of_type_Isj = new isj();
    this.jdField_a_of_type_Isn = new isn(this.jdField_a_of_type_Isj);
    this.jdField_a_of_type_Isk = new isk();
    this.jdField_a_of_type_Iso = new iso(this.jdField_a_of_type_Isk);
    this.jdField_a_of_type_Isz = new isz();
    this.jdField_a_of_type_Ita = new ita();
    this.jdField_a_of_type_Ish = new ish(this.jdField_a_of_type_Isk);
    this.jdField_a_of_type_Ism = new ism();
    this.jdField_a_of_type_Iss = new iss(this.jdField_a_of_type_Isk);
    this.jdField_a_of_type_Isj.setTipsText(paramContext.getString(2131698023));
    this.mVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
  }
  
  public long a(AVRedPacketManager.LocalEmojiInfo paramLocalEmojiInfo)
  {
    long l2 = 3000L;
    long l1;
    if ((this.c != null) && (this.c.vw())) {
      l1 = 5000L;
    }
    do
    {
      do
      {
        return l1;
        l1 = l2;
      } while (paramLocalEmojiInfo == null);
      if (paramLocalEmojiInfo.fallDownDuration > 0) {
        return paramLocalEmojiInfo.fallDownDuration;
      }
      l1 = l2;
    } while (paramLocalEmojiInfo.emojiId < 3);
    return 2000L;
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "setAVRedPacketManager1 avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.c = paramAVRedPacketManager;
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager, itc[] paramArrayOfitc)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfItc.length)
    {
      this.jdField_a_of_type_ArrayOfItc[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_emoji_" + (i + 1) + ".png"));
      i += 1;
    }
    this.b[0] = new itc(paramAVRedPacketManager.o("qav_redpacket_perfect.png"));
    this.b[1] = new itc(paramAVRedPacketManager.o("qav_redpacket_cool.png"));
    this.b[2] = new itc(paramAVRedPacketManager.o("qav_redpacket_miss.png"));
    this.b[3] = new itc(paramAVRedPacketManager.o("qav_redpacket_excellent.png"));
    this.jdField_a_of_type_Itc = new itc(paramAVRedPacketManager.o("qav_redpacket_miss_background.png"));
    this.jdField_a_of_type_Ish.b(paramAVRedPacketManager, paramArrayOfitc);
    this.jdField_a_of_type_Ism.c(paramAVRedPacketManager);
  }
  
  public void apP()
  {
    this.jdField_a_of_type_Isj.iQ(true);
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_a_of_type_Isn.b(paramAVRedPacketManager);
    this.jdField_a_of_type_Iso.b(paramAVRedPacketManager);
    this.jdField_a_of_type_Iss.b(paramAVRedPacketManager);
  }
  
  public void b(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 0)) {
      break label21;
    }
    label21:
    while ((paramBoolean) && (this.asW == paramLocalFrameSyncInfo.localHitInfo.emojiId)) {
      return;
    }
    if (this.asW != paramLocalFrameSyncInfo.localHitInfo.emojiId)
    {
      this.asW = paramLocalFrameSyncInfo.localHitInfo.emojiId;
      this.mVibrator.vibrate(200L);
    }
    if (paramBoolean) {
      bO(paramLocalFrameSyncInfo.localHitInfo.topWordTipType, paramLocalFrameSyncInfo.localHitInfo.comboCnt);
    }
    long l;
    label105:
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    if (paramBoolean)
    {
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() <= 0) {
        break label413;
      }
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
    }
    for (;;)
    {
      label132:
      this.jdField_a_of_type_Isk.mStartTime = l;
      Rect localRect = this.jdField_a_of_type_Isj.getBounds();
      this.jdField_a_of_type_Isk.setBounds(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_Iso.mStartTime = l;
      this.jdField_a_of_type_Iso.aqk();
      this.jdField_a_of_type_Ita.b = null;
      this.jdField_a_of_type_Ita.setColor(-12375);
      this.jdField_a_of_type_Ish.mStartTime = l;
      this.jdField_a_of_type_Ish.aqk();
      this.jdField_a_of_type_Ish.bP(paramLocalFrameSyncInfo.localHitInfo.comboCnt, paramLocalFrameSyncInfo.localHitInfo.newAddScore);
      this.jdField_a_of_type_Iss.mStartTime = l;
      this.jdField_a_of_type_Iss.aqk();
      if ((localLocalEmojiInfo != null) && (localLocalEmojiInfo.emojiId == paramLocalFrameSyncInfo.localHitInfo.emojiId))
      {
        this.jdField_a_of_type_Isk.b = this.jdField_a_of_type_ArrayOfItc[localLocalEmojiInfo.emojiType];
        this.jdField_a_of_type_Isk.iP(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Ish.iP(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Iso.iP(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Isz.iP(localLocalEmojiInfo.isBigEmoji);
      }
      for (;;)
      {
        this.jdField_a_of_type_Ita.mStartTime = l;
        this.jdField_a_of_type_Isz.mStartTime = l;
        this.jdField_a_of_type_Isz.b = this.b[(paramLocalFrameSyncInfo.localHitInfo.topWordTipType - 1)];
        if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 4) {
          break;
        }
        this.jdField_a_of_type_Ism.mStartTime = l;
        return;
        l = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
        break label105;
        label413:
        if ((this.fu == null) || (this.fu.size() <= 0)) {
          break label473;
        }
        localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(paramLocalFrameSyncInfo.localHitInfo.emojiId);
        break label132;
        this.jdField_a_of_type_Isk.b = this.jdField_a_of_type_Isj.b;
      }
      label473:
      localLocalEmojiInfo = null;
    }
  }
  
  public void bB(List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    this.fu = paramList;
  }
  
  public void bO(int paramInt1, int paramInt2)
  {
    int i = 3;
    if (paramInt1 == 1) {
      paramInt1 = i;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.c != null)) {
        this.c.C(paramInt1, false);
      }
      if ((paramInt2 > 0) && (this.c != null)) {
        this.c.C(6, false);
      }
      return;
      if (paramInt1 == 2) {
        paramInt1 = 2;
      } else if (paramInt1 == 3) {
        paramInt1 = 4;
      } else if (paramInt1 == 4) {
        paramInt1 = 5;
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  public void c(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    long l1 = 0L;
    b(paramBoolean, paramLocalFrameSyncInfo);
    if (paramBoolean)
    {
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() > 0)
      {
        paramLocalFrameSyncInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
        QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
        if (this.asV != paramLocalFrameSyncInfo.emojiId)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState,new emoji, isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
          }
          this.asV = paramLocalFrameSyncInfo.emojiId;
          this.jdField_a_of_type_Isj.setDuration(a(paramLocalFrameSyncInfo));
          this.jdField_a_of_type_Isj.mStartTime = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_Isj.lG(paramLocalFrameSyncInfo.trackNum);
          this.jdField_a_of_type_Isj.b = this.jdField_a_of_type_ArrayOfItc[paramLocalFrameSyncInfo.emojiType];
          this.jdField_a_of_type_Isn.iP(paramLocalFrameSyncInfo.isBigEmoji);
          if (this.c != null) {
            this.c.bN(paramLocalFrameSyncInfo.emojiId, paramLocalFrameSyncInfo.emojiType);
          }
        }
      }
      if (this.asV == this.asW) {
        this.jdField_a_of_type_Isj.b = null;
      }
    }
    while ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (this.fu == null)) {
      return;
    }
    if ((this.asV < this.fu.size()) && (this.c != null)) {
      this.c.lC(this.asV);
    }
    this.asV += 1;
    this.jdField_a_of_type_Isj.iQ(false);
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    int i;
    long l2;
    if (this.asV < this.fu.size())
    {
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(this.asV);
      QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + localLocalEmojiInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Isj.mStartTime = (paramLocalFrameSyncInfo.localHitInfo.hitStartTime + 500L);
      this.jdField_a_of_type_Isj.setDuration(a(localLocalEmojiInfo));
      i = this.asV % 3;
      this.jdField_a_of_type_Isj.lG(i);
      this.jdField_a_of_type_Isj.UI = true;
      this.jdField_a_of_type_Isj.b = this.jdField_a_of_type_ArrayOfItc[localLocalEmojiInfo.emojiType];
      l2 = this.jdField_a_of_type_Isj.mStartTime - NetConnInfoCenter.getServerTimeMillis();
      if (l2 >= 0L) {
        break label577;
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Isj.mStartTime, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
      }
      this.jdField_a_of_type_Isn.iP(localLocalEmojiInfo.isBigEmoji);
      return;
      this.jdField_a_of_type_Isj.b = null;
      return;
      label577:
      l1 = l2;
    }
  }
  
  public int ct(int paramInt)
  {
    if ((this.fu != null) && (this.fu.size() > 0))
    {
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(paramInt);
      if (localLocalEmojiInfo != null) {
        return localLocalEmojiInfo.emojiType;
      }
    }
    return -1;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    this.jdField_a_of_type_Isj.draw(paramCanvas, paramPaint);
    this.jdField_a_of_type_Isn.draw(paramCanvas, paramPaint);
    int k;
    int m;
    int j;
    if (this.UG)
    {
      Rect localRect = this.jdField_a_of_type_Isk.getBounds();
      k = localRect.left;
      m = localRect.top;
      if (!imt.uc()) {
        break label155;
      }
      j = this.asX;
    }
    for (int i = this.asY;; i = this.ata)
    {
      paramCanvas.translate(j - k, i - m);
      this.jdField_a_of_type_Iso.draw(paramCanvas, paramPaint);
      this.jdField_a_of_type_Isk.draw(paramCanvas, paramPaint);
      this.jdField_a_of_type_Iss.draw(paramCanvas, paramPaint);
      this.jdField_a_of_type_Ish.draw(paramCanvas, paramPaint);
      if (this.UG) {
        paramCanvas.restore();
      }
      this.jdField_a_of_type_Ita.draw(paramCanvas, paramPaint);
      this.jdField_a_of_type_Ism.draw(paramCanvas, paramPaint);
      this.jdField_a_of_type_Isz.draw(paramCanvas, paramPaint);
      return;
      label155:
      j = this.asZ;
    }
  }
  
  public void iO(boolean paramBoolean)
  {
    this.UG = paramBoolean;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.asX = (paramInt1 * 40 / 750);
    this.asY = (paramInt1 * 600 / 750);
    this.asZ = (paramInt1 * 534 / 750);
    this.ata = (paramInt1 * 260 / 750);
    this.jdField_a_of_type_Isj.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Isn.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Isk.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Iso.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Ita.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Isz.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Ish.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Ism.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Iss.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void recycle()
  {
    int j = 0;
    itc[] arrayOfitc = this.jdField_a_of_type_ArrayOfItc;
    int k = arrayOfitc.length;
    int i = 0;
    itc localitc;
    while (i < k)
    {
      localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    arrayOfitc = this.b;
    k = arrayOfitc.length;
    i = j;
    while (i < k)
    {
      localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Itc != null) {
      this.jdField_a_of_type_Itc.recycle();
    }
    if (this.jdField_a_of_type_Isn != null) {
      this.jdField_a_of_type_Isn.recycle();
    }
    if (this.jdField_a_of_type_Iso != null) {
      this.jdField_a_of_type_Iso.recycle();
    }
    if (this.jdField_a_of_type_Ish != null) {
      this.jdField_a_of_type_Ish.recycle();
    }
    if (this.jdField_a_of_type_Ism != null) {
      this.jdField_a_of_type_Ism.recycle();
    }
    if (this.mVibrator != null) {
      this.mVibrator.cancel();
    }
    if (this.jdField_a_of_type_Iss != null) {
      this.jdField_a_of_type_Iss.recycle();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "recycle mAVRedPacketManager set to null");
    }
    this.c = null;
    this.jdField_a_of_type_ArrayOfItc = null;
    this.b = null;
    this.jdField_a_of_type_Itc = null;
    this.jdField_a_of_type_Isj = null;
    this.fu = null;
    this.jdField_a_of_type_Isn = null;
    this.jdField_a_of_type_Isk = null;
    this.jdField_a_of_type_Iso = null;
    this.jdField_a_of_type_Isz = null;
    this.jdField_a_of_type_Ita = null;
    this.jdField_a_of_type_Ish = null;
    this.jdField_a_of_type_Ism = null;
    this.mVibrator = null;
    this.jdField_a_of_type_Iss = null;
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
  }
  
  public void setStartTime(long paramLong)
  {
    if (this.fu != null)
    {
      this.asV = 0;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(this.asV);
      this.jdField_a_of_type_Isj.mStartTime = paramLong;
      this.jdField_a_of_type_Isj.setDuration(a(localLocalEmojiInfo));
      int i = this.asV % 3;
      this.jdField_a_of_type_Isj.lG(i);
      this.jdField_a_of_type_Isj.UI = true;
      this.jdField_a_of_type_Isj.a = new isc(this);
      this.jdField_a_of_type_Isj.b = this.jdField_a_of_type_ArrayOfItc[localLocalEmojiInfo.emojiType];
      if (this.c != null) {
        this.c.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Isj.mStartTime, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, 0L);
      }
      this.jdField_a_of_type_Isn.mStartTime = paramLong;
      this.jdField_a_of_type_Isn.iP(localLocalEmojiInfo.isBigEmoji);
    }
  }
  
  public void update(long paramLong)
  {
    long l1 = paramLong - this.jdField_a_of_type_Isj.mStartTime;
    if (this.mIsSend) {
      if ((l1 > this.jdField_a_of_type_Isj.getDuration()) && (this.asW != this.asV))
      {
        this.jdField_a_of_type_Ita.b = this.jdField_a_of_type_Itc;
        this.jdField_a_of_type_Ita.setColor(-9942110);
        l1 = this.jdField_a_of_type_Isj.mStartTime + this.jdField_a_of_type_Isj.getDuration();
        if (this.jdField_a_of_type_Ita.mStartTime != l1)
        {
          this.jdField_a_of_type_Ita.mStartTime = l1;
          this.jdField_a_of_type_Isz.mStartTime = l1;
          bO(3, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameEmojiAnimation", 2, "send show miss mCurEmojiItemId = " + this.asV);
        }
        this.jdField_a_of_type_Isz.b = this.b[2];
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Isj.update(paramLong);
      this.jdField_a_of_type_Isn.update(paramLong);
      this.jdField_a_of_type_Isk.update(paramLong);
      this.jdField_a_of_type_Iso.update(paramLong);
      this.jdField_a_of_type_Ita.update(paramLong);
      this.jdField_a_of_type_Isz.update(paramLong);
      this.jdField_a_of_type_Ish.update(paramLong);
      this.jdField_a_of_type_Ism.update(paramLong);
      this.jdField_a_of_type_Iss.update(paramLong);
      return;
      if ((l1 > this.jdField_a_of_type_Isj.getDuration()) && (this.fu != null))
      {
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
        if (this.asV < this.fu.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(this.asV);
          if (this.c != null) {
            this.c.lC(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Ita.b = this.jdField_a_of_type_Itc;
          this.jdField_a_of_type_Ita.setColor(-9942110);
          this.jdField_a_of_type_Ita.mStartTime = paramLong;
          this.jdField_a_of_type_Isz.mStartTime = paramLong;
          this.jdField_a_of_type_Isz.b = this.b[2];
          this.asV += 1;
          this.jdField_a_of_type_Isj.iQ(false);
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(this.asV);
          isj localisj = this.jdField_a_of_type_Isj;
          localisj.mStartTime += this.jdField_a_of_type_Isj.getDuration() + 500L;
          this.jdField_a_of_type_Isj.setDuration(a(localLocalEmojiInfo));
          int i = this.asV % 3;
          this.jdField_a_of_type_Isj.lG(i);
          this.jdField_a_of_type_Isj.UI = true;
          this.jdField_a_of_type_Isj.b = this.jdField_a_of_type_ArrayOfItc[localLocalEmojiInfo.emojiType];
          this.jdField_a_of_type_Isn.iP(localLocalEmojiInfo.isBigEmoji);
          long l2 = this.jdField_a_of_type_Isj.mStartTime - NetConnInfoCenter.getServerTimeMillis();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.c != null) {
            this.c.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Isj.mStartTime, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
          }
        }
        else if (this.asV == this.fu.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.fu.get(this.asV);
          if (this.c != null) {
            this.c.lC(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Ita.b = this.jdField_a_of_type_Itc;
          this.jdField_a_of_type_Ita.setColor(-9942110);
          this.jdField_a_of_type_Ita.mStartTime = paramLong;
          this.jdField_a_of_type_Isz.mStartTime = paramLong;
          this.jdField_a_of_type_Isz.b = this.b[2];
          this.asV += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isb
 * JD-Core Version:    0.7.0.1
 */