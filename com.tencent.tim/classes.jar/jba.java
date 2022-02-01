import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class jba
  extends iid
{
  public jba(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void A(long paramLong1, long paramLong2)
  {
    super.A(paramLong1, paramLong2);
    this.this$0.atk();
    this.this$0.a(paramLong2, 5, false, 72, 0);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.this$0.b.c(paramLong, paramInt1, paramInt2, paramBoolean);
    ((AVActivity)this.this$0.mContext.get()).b.Q(paramLong, paramBoolean);
    if (paramLong == this.this$0.mSelfUin) {
      this.this$0.ate();
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.this$0.aoI + "], seq[" + paramLong1 + "]");
    }
    ioa localioa;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
      do
      {
        do
        {
          return;
          if (paramLong3 == 1L)
          {
            this.this$0.jI("onGaOperationResult");
            this.this$0.v("onGaOperationResult.1", paramLong1);
            this.this$0.f(paramLong1, this.this$0.a.b().jdField_if);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.this$0.TAG, 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + paramLong3);
        return;
      } while (paramLong3 != 1L);
      this.this$0.a(this.this$0.mSelfUin, paramInt1, false, -1, 0);
      return;
    case 90: 
      if (paramLong3 == 3L)
      {
        ArrayList localArrayList = this.this$0.a.b().jdField_if;
        paramInt1 = 0;
        if (paramInt1 >= localArrayList.size()) {
          break label761;
        }
        localioa = (ioa)localArrayList.get(paramInt1);
        if ((paramLong2 != localioa.uin) || (localioa.videoSrcType != 1)) {
          break;
        }
      }
      break;
    }
    label485:
    label622:
    label761:
    for (boolean bool = localioa.Tp;; bool = false)
    {
      this.this$0.c.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
      this.this$0.dE(paramLong1);
      this.this$0.v("onGaOperationResult.2", paramLong1);
      for (;;)
      {
        this.this$0.O(paramLong1, 65535);
        return;
        paramInt1 += 1;
        break;
        if (paramLong3 == 2L)
        {
          iwu.b(this.this$0.mApp, 1029);
        }
        else if (paramLong3 == 4L)
        {
          if ((paramLong2 == this.this$0.mApp.getLongAccountUin()) && (!this.this$0.a.b().PY))
          {
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label546;
            }
            iwu.b(this.this$0.mApp, 1031);
          }
          for (;;)
          {
            if (this.this$0.aqx != 2) {
              break label622;
            }
            anot.a(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
            break;
            paramInt1 = 0;
            break label485;
            if (QLog.isColorLevel()) {
              QLog.d(this.this$0.TAG, 2, "VideoConstants.GaChatOperationResult.EV_GA_SDK_GO_ON_STAGE_SUC with repeat message " + MultiVideoCtrlLayerUIBase.a(this.this$0));
            }
            if (MultiVideoCtrlLayerUIBase.a(this.this$0))
            {
              iwu.b(this.this$0.mApp, 1031);
              MultiVideoCtrlLayerUIBase.a(this.this$0, false);
            }
          }
        }
        else if (paramLong3 == 8L)
        {
          if (MultiVideoCtrlLayerUIBase.a(this.this$0))
          {
            MultiVideoCtrlLayerUIBase.a(this.this$0, false);
            iwu.a(this.this$0.mApp, 1033, this.this$0.mRes.getString(2131697931));
          }
        }
        else if ((paramLong3 == 9L) && (MultiVideoCtrlLayerUIBase.a(this.this$0)))
        {
          MultiVideoCtrlLayerUIBase.a(this.this$0, false);
          iwu.a(this.this$0.mApp, 1033, this.this$0.mRes.getString(2131697932));
        }
      }
      this.this$0.dt(paramLong3);
      return;
      this.this$0.O(paramLong1, 65535);
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (paramLong3 == this.this$0.mSelfUin) {
      if (this.this$0.a.b().PY)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 1, "onMemberVideoOut, seq[" + paramLong1 + "]");
        }
        this.this$0.cD(paramLong1);
        if (this.this$0.a != null) {
          this.this$0.a.a(this.this$0.mSelfUin, this.this$0.a.b().jdField_if, this.this$0.a.b().ig, 1, false);
        }
      }
    }
    for (;;)
    {
      this.this$0.atk();
      this.this$0.a(paramLong3, 6, false, 73, 0);
      return;
      ioa localioa = new ioa();
      localioa.uin = paramLong3;
      localioa.videoSrcType = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localioa);
      this.this$0.c.update(null, new Object[] { Integer.valueOf(104), localArrayList });
      if (paramInt == 2)
      {
        this.this$0.mX(1036);
        iwu.a(this.this$0.mApp, 1036);
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberJoin, mRelationId[" + this.this$0.md + "], groupId[" + paramLong1 + "], isQQUser[" + paramBoolean2 + "], friendUin[" + paramLong2 + "], isRefresh[" + paramBoolean1 + "]");
    }
    if (this.this$0.md != paramLong1) {
      return;
    }
    this.this$0.Xj = paramBoolean2;
    this.this$0.a(paramLong2, 0, paramBoolean1, 70, 0);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (((!this.this$0.a.OY) && ((paramLong != this.this$0.mSelfUin) || (!paramBoolean1)) && (paramBoolean1)) || (paramLong == 0L)) {
      this.this$0.ate();
    }
    if ((this.this$0.a.OY) || (paramLong == this.this$0.mSelfUin) || (paramLong == 0L)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      if (!paramBoolean1) {
        break;
      }
      if ((this.this$0.a.b() != null) && (this.this$0.a.b().ane != 1))
      {
        String str = this.this$0.a.d(String.valueOf(paramLong), String.valueOf(this.this$0.a.b().ll), this.this$0.aqx);
        if (str != null)
        {
          localObject = str;
          if (str.length() != 0) {}
        }
        else
        {
          localObject = String.valueOf(paramLong);
        }
        str = this.this$0.mRes.getString(2131697742);
        float f = jjn.a(str, this.this$0.mZ.getPaint());
        f = Math.min(this.this$0.mRes.getDisplayMetrics().widthPixels - f - this.this$0.mRes.getDimensionPixelSize(2131298354) * 2, this.this$0.mRes.getDimensionPixelSize(2131297418));
        jjn.b(localStringBuilder, (String)localObject, this.this$0.mZ.getPaint(), f);
        localStringBuilder.append(str);
      }
      iwu.a(this.this$0.mApp, 1033, localStringBuilder.toString());
      if ((this.this$0.a.b() != null) && ((this.this$0.a.b().ane != 1) || (!paramBoolean1)) && ((this.this$0.a.b().ane != 0) || (paramBoolean1))) {
        this.this$0.jf(paramBoolean1);
      }
    } while ((this.this$0.a.b() == null) || (paramBoolean2));
    Object localObject = this.this$0.a.b();
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      ((iiv)localObject).ad("setRoomMicOff", i);
      return;
      if ((this.this$0.a.b() == null) || (this.this$0.a.b().ane == 0)) {
        break;
      }
      localStringBuilder.append(this.this$0.mRes.getString(2131697739));
      break;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.this$0.a(paramLong, 2, paramBoolean2, i, paramInt);
      return;
    }
  }
  
  protected void amA()
  {
    if ((this.this$0.bW != null) && (this.this$0.mApp != null) && (this.this$0.mApp.getHandler() != null)) {
      this.this$0.mApp.getHandler().post(this.this$0.bW);
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberLeave, mRelationId[" + this.this$0.md + "], groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + this.this$0.Xj + "->" + paramBoolean + "]");
    }
    if (this.this$0.md != paramLong1) {
      return;
    }
    this.this$0.Xj = paramBoolean;
    super.b(paramLong1, paramLong2, paramBoolean);
    this.this$0.a(paramLong2, 1, true, 71, 0);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 7;
      j = 78;
    }
    for (;;)
    {
      this.this$0.a(paramLong2, i, false, j, 0);
      return;
      i = 8;
      j = 79;
      this.this$0.mX(1036);
      iwu.a(this.this$0.mApp, 1036);
    }
  }
  
  protected void bG(long paramLong)
  {
    QLog.w(this.this$0.TAG, 1, "onDestroyUI, groupId[" + paramLong + "], mRelationId[" + this.this$0.md + "], mIntentRelationId[" + this.this$0.oC + "]");
    if ((this.this$0.md == paramLong) || (this.this$0.oC == paramLong)) {
      this.this$0.jg(true);
    }
  }
  
  protected void m(long paramLong, int paramInt)
  {
    super.m(paramLong, paramInt);
    if ((paramLong == this.this$0.mApp.getLongAccountUin()) || (paramInt != 0) || (paramLong == 0L)) {
      this.this$0.ate();
    }
    if ((this.this$0.a.OY) || (paramLong == this.this$0.mSelfUin) || (paramLong == 0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt == 1)
    {
      String str = this.this$0.a.d(String.valueOf(paramLong), String.valueOf(this.this$0.a.b().ll), this.this$0.aqx);
      if (str != null)
      {
        localObject = str;
        if (str.length() != 0) {}
      }
      else
      {
        localObject = String.valueOf(paramLong);
      }
      float f = this.this$0.mRes.getDimensionPixelSize(2131297418);
      localStringBuilder.append(this.this$0.mRes.getString(2131697745));
      jjn.b(localStringBuilder, (String)localObject, this.this$0.mZ.getPaint(), f);
      localStringBuilder.append(this.this$0.mRes.getString(2131697744));
      iwu.a(this.this$0.mApp, 1033, localStringBuilder.toString());
      localObject = this.this$0;
      if (paramInt != 1) {
        break label287;
      }
    }
    label287:
    for (boolean bool = true;; bool = false)
    {
      ((MultiVideoCtrlLayerUIBase)localObject).jf(bool);
      return;
      if (paramInt != 0) {
        break;
      }
      localStringBuilder.append(this.this$0.mRes.getString(2131697746));
      break;
    }
  }
  
  protected void p(long paramLong, int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.this$0.TAG, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.this$0.a.b().b(paramLong, paramInt);
    if ((paramInt != -1) && (((ioa)this.this$0.a.b().jdField_if.get(paramInt)).Tp))
    {
      this.this$0.auQ();
      iwu.a(this.this$0.mApp, 1036);
      iwu.a(this.this$0.mApp, 1037);
    }
    this.this$0.dE(l);
    this.this$0.jJ("onFirstFrameDataComeIn");
  }
  
  protected void q(ArrayList<Long> paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      iwu.a(this.this$0.mApp, 1034);
      iwu.a(this.this$0.mApp, 1035);
      if (this.this$0.bV != null)
      {
        this.this$0.mApp.getHandler().removeCallbacks(this.this$0.bV);
        this.this$0.bV = null;
      }
      return;
    }
    if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.this$0.mSelfUin))
    {
      iwu.b(this.this$0.mApp, 1034, 2131697726);
      iwu.a(this.this$0.mApp, 1035, this.this$0.mApp.getApp().getString(2131698101), new jbb(this));
      return;
    }
    Object localObject;
    long l;
    if (this.this$0.bV == null)
    {
      this.this$0.bV = new MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable(this.this$0);
      localObject = this.this$0.mApp.getHandler();
      Runnable localRunnable = this.this$0.bV;
      if (this.this$0.a.kL < 2000L)
      {
        l = 2000L;
        ((Handler)localObject).postDelayed(localRunnable, l);
      }
    }
    else
    {
      paramArrayList = this.this$0.a.d(String.valueOf(paramArrayList.get(0)), String.valueOf(this.this$0.a.b().ll), this.this$0.aqx);
      float f = this.this$0.mRes.getDimensionPixelSize(2131297418);
      localObject = new StringBuilder();
      jjn.b((StringBuilder)localObject, paramArrayList, this.this$0.mZ.getPaint(), f);
      if (paramInt != 1) {
        break label419;
      }
      ((StringBuilder)localObject).append(this.this$0.mApp.getApp().getString(2131697727));
      iwu.a(this.this$0.mApp, 1035, this.this$0.mApp.getApp().getString(2131698102), new jbc(this));
    }
    for (;;)
    {
      paramArrayList = ((StringBuilder)localObject).toString();
      iwu.a(this.this$0.mApp, 1034, paramArrayList);
      return;
      l = this.this$0.a.kL;
      break;
      label419:
      ((StringBuilder)localObject).append(this.this$0.mApp.getApp().getString(2131697728)).append(paramInt);
      ((StringBuilder)localObject).append(this.this$0.mApp.getApp().getString(2131697729));
      iwu.a(this.this$0.mApp, 1035, this.this$0.mApp.getApp().getString(2131698103), new jbd(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jba
 * JD-Core Version:    0.7.0.1
 */