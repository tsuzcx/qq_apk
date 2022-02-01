import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI.1;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class iwb
  extends VideoLayerUIBase
{
  private iwb.a jdField_a_of_type_Iwb$a;
  jhj jdField_a_of_type_Jhj;
  private int atY;
  
  public iwb(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, iwb.a parama)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_a_of_type_Iwb$a = parama;
    this.mPosition = 2;
    this.jdField_a_of_type_Jdl = jdl.a(paramContext, this.mApp, this.jdField_a_of_type_ComTencentAvVideoController.b().ani, true);
    ary();
    arx();
    avp();
    art();
    aru();
  }
  
  private void art()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void aru()
  {
    if (this.jdField_a_of_type_ArrayOfIzm != null)
    {
      int i = 1;
      while (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[i].setZOrder(-1);
        i += 1;
      }
    }
  }
  
  private void arw()
  {
    if (this.jdField_a_of_type_ArrayOfIzm[0].getVisibility() == 0)
    {
      String str1 = this.mApp.getCurrentAccountUin();
      String str2 = (String)this.jdField_a_of_type_ArrayOfIzm[0].getTag(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int i = lK();
        if (i > 0) {
          L(0, i);
        }
      }
    }
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2)
    {
      this.jdField_a_of_type_ArrayOfIzm[0].f(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfIzm[1].f(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfIzm[2].f(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfIzm[3].f(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfIzm[4].f(Boolean.valueOf(true));
      if ((!this.jdField_a_of_type_ArrayOfIzm[0].wf()) || ((this.mOrientation != 0) && (this.mOrientation != 180)) || (this.jdField_a_of_type_ArrayOfIzm[0].wj())) {
        break label208;
      }
      if (this.mOrientation != 0) {
        break label181;
      }
      this.jdField_a_of_type_ArrayOfIzm[0].setPaddings(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(2131298196));
    }
    for (;;)
    {
      this.jdField_a_of_type_Jdl.a(this.jdField_a_of_type_ComTencentAvVideoController.b(), this.jdField_a_of_type_ArrayOfIzm, paramInt1, paramInt2, paramBoolean, this.mOrientation, this.ayt);
      return;
      label181:
      this.jdField_a_of_type_ArrayOfIzm[0].setPaddings(0, this.mContext.getResources().getDimensionPixelSize(2131298196), 0, 0);
      continue;
      label208:
      this.jdField_a_of_type_ArrayOfIzm[0].setPaddings(paramInt3, paramInt3, paramInt3, paramInt3);
    }
  }
  
  private int lJ()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_ArrayOfIzm.length; j = k)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      String str = (String)localizm.getTag(0);
      k = j;
      if (localizm.getVisibility() == 0)
      {
        k = j;
        if (localizm.wi())
        {
          k = j;
          if (!TextUtils.isEmpty(str)) {
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  private int lK()
  {
    String str1 = this.mApp.getCurrentAccountUin();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      String str2 = (String)localizm.getTag(0);
      if ((localizm.getVisibility() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void lT(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "closeVideoView index: " + paramInt);
    }
    int j = 0;
    float f1 = 0.0F;
    int i = 0;
    boolean bool1 = false;
    Object localObject2 = ImageView.ScaleType.CENTER_INSIDE;
    int n = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    Object localObject1 = localObject2;
    int m;
    if (paramInt == 0)
    {
      k = this.jdField_a_of_type_ArrayOfIzm[0].getTextColor();
      float f2 = this.jdField_a_of_type_ArrayOfIzm[0].getTextSize();
      m = this.jdField_a_of_type_ArrayOfIzm[0].getMaxLength();
      boolean bool2 = this.jdField_a_of_type_ArrayOfIzm[0].wh();
      localObject1 = localObject2;
      bool1 = bool2;
      i = m;
      f1 = f2;
      j = k;
      if (n == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfIzm[0].getScaleType();
        j = k;
        f1 = f2;
        i = m;
        bool1 = bool2;
      }
    }
    int k = paramInt;
    while (k < this.jdField_a_of_type_ArrayOfIzm.length) {
      if ((k < this.jdField_a_of_type_ArrayOfIzm.length - 1) && (this.jdField_a_of_type_ArrayOfIzm[(k + 1)].getVisibility() == 0))
      {
        m = this.jdField_a_of_type_ArrayOfIzm[k].getZOrder();
        int i1 = this.jdField_a_of_type_ArrayOfIzm[(k + 1)].getZOrder();
        this.jdField_a_of_type_ArrayOfIzm[k].setZOrder(i1);
        this.jdField_a_of_type_ArrayOfIzm[(k + 1)].setZOrder(m);
        localObject2 = this.jdField_a_of_type_ArrayOfIzm[k];
        this.jdField_a_of_type_ArrayOfIzm[k] = this.jdField_a_of_type_ArrayOfIzm[(k + 1)];
        this.jdField_a_of_type_ArrayOfIzm[(k + 1)] = localObject2;
        k += 1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfIzm[k];
        ((izm)localObject2).setVisibility(1);
        arv();
        ((izm)localObject2).setText(null);
        ((izm)localObject2).jO(true);
        ((izm)localObject2).enableLoading(false);
        ((izm)localObject2).jK(false);
        ((izm)localObject2).flush(true);
        ((izm)localObject2).an(null, 0);
        ((izm)localObject2).kc("");
      }
    }
    arw();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfIzm[0].jL(false);
      this.jdField_a_of_type_ArrayOfIzm[0].setTextColor(j);
      this.jdField_a_of_type_ArrayOfIzm[0].setTextSize(f1);
      this.jdField_a_of_type_ArrayOfIzm[0].setMaxLength(i);
      this.jdField_a_of_type_ArrayOfIzm[0].jN(bool1);
      if (n == 4) {
        this.jdField_a_of_type_ArrayOfIzm[0].setScaleType((ImageView.ScaleType)localObject1);
      }
    }
    jj(false);
  }
  
  private void setGlRender(String paramString, YUVTexture paramYUVTexture)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.sz())
    {
      GraphicRenderMgr.getInstance().setGlRender(paramString, paramYUVTexture);
      QLog.i("SmallScreenVideoLayerUI", 1, "setGlRender[small_screen], key[" + paramString + "], render[" + paramYUVTexture + "]");
    }
  }
  
  @TargetApi(11)
  public void F(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.YG) && (!wW())) {
      this.mCacheRotation = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.mRotation) || (paramInt == this.mCacheRotation))
      {
        if (paramInt % 90 != this.mRotation % 90) {
          this.axw = 0;
        }
        this.mRotation = paramInt;
        this.mCacheRotation = paramInt;
        int i = VideoLayerUI.a("SmallScreenVideoLayerUI", this.mContext, paramInt, paramBoolean, this.mDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2)
        {
          if (this.mOrientation != 0)
          {
            paramBoolean = bool;
            if (this.mOrientation != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          jj(paramBoolean);
          return;
          paramInt = 0;
          while (paramInt < super.getChildCount())
          {
            super.a(paramInt).setRotation(i);
            paramInt += 1;
          }
          this.mOrientation = i;
        }
      }
    }
  }
  
  public boolean L(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index1: " + paramInt1 + ", index2: " + paramInt2);
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfIzm.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfIzm.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
      }
      return false;
    }
    ca(paramInt1, paramInt2);
    return true;
  }
  
  void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    int j = c("setBackground", paramString, paramInt);
    int i = j;
    izm localizm;
    if (j < 0)
    {
      j = cD(0);
      if (j >= 0)
      {
        localizm = this.jdField_a_of_type_ArrayOfIzm[j];
        localizm.setVisibility(0);
        arv();
        arw();
        localizm.setTag(0, paramString);
        localizm.setTag(1, Integer.valueOf(paramInt));
        localizm.kc(this.mApp.getCurrentAccountUin());
        String str = VideoLayerUI.u(paramString, paramInt);
        setGlRender(str, null);
        setGlRender(str, localizm.a());
        long l = AudioHelper.hG();
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[setBackground], key[" + str + "], index[" + j + "], seq[" + l + "], " + localizm.hl());
        boolean bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equals(this.mApp.getCurrentAccountUin())) {
            bool1 = false;
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, bool1);
      }
      i = j;
      if (paramBoolean2)
      {
        i = j;
        if (j > 0)
        {
          L(0, j);
          i = 0;
        }
      }
    }
    if (i >= 0)
    {
      localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      localizm.setBackground(paramBitmap);
      localizm.jO(paramBoolean1);
      if (!paramBoolean1) {
        localizm.enableLoading(false);
      }
    }
    jj(false);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i + ", needRenderVideo: " + paramBoolean1);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int i = c("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + i);
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfIzm[i];
      paramString1.setVisibility(0);
      arv();
      arw();
      paramString1.setText(paramString2);
      paramString1.setTextSize(paramFloat);
      paramString1.setTextColor(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.jL(bool);
      if (i == 0) {
        paramString1.setMaxLength(12);
      }
    }
    else
    {
      return;
    }
    paramString1.setMaxLength(2147483647);
  }
  
  void arv()
  {
    int i = lJ();
    if (this.atY != i)
    {
      this.atY = i;
      if (this.jdField_a_of_type_Iwb$a != null) {
        this.jdField_a_of_type_Iwb$a.lN(this.atY);
      }
    }
  }
  
  public void arx()
  {
    this.jdField_a_of_type_Jdt = new jdt(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void ary()
  {
    super.ary();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      this.jdField_a_of_type_ArrayOfIzm[i].jP(true);
      i += 1;
    }
  }
  
  void arz()
  {
    if (this.jdField_a_of_type_Jhj == null) {
      this.jdField_a_of_type_Jhj = new jhj(this.mApp, this.mContext);
    }
  }
  
  void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.YG + "], isFillBlackEdge[" + paramBoolean3 + "], seq[" + l + "]");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.mApp.getCurrentAccountUin()))) {
      break label130;
    }
    label130:
    while (irc.getGLVersion(this.mContext) == 1) {
      return;
    }
    boolean bool = paramBoolean2;
    if (b(this.jdField_a_of_type_ComTencentAvVideoController.b()))
    {
      bool = paramBoolean2;
      if (!paramBoolean2)
      {
        bool = paramBoolean2;
        if (!wV()) {
          bool = true;
        }
      }
    }
    wY();
    int i;
    String str;
    Object localObject;
    if (paramBoolean1)
    {
      i = c("setRemoteHasVideo_open", paramString, paramInt);
      str = VideoLayerUI.u(paramString, paramInt);
      if (i < 0)
      {
        i = cD(0);
        if (i < 0) {
          break label738;
        }
        localObject = this.jdField_a_of_type_ArrayOfIzm[i];
        ((izm)localObject).an(paramString, paramInt);
        ((izm)localObject).kc(this.mApp.getCurrentAccountUin());
      }
    }
    for (;;)
    {
      try
      {
        setGlRender(str, ((izm)localObject).a());
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_1], key[" + str + "], index[" + i + "], " + ((izm)localObject).hl());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, true);
        paramString = (String)localObject;
        if ((i <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4)) {
          break label732;
        }
        paramInt = i;
        if (paramString != null)
        {
          paramString.jK(paramBoolean3);
          paramString.J(l, this.jdField_a_of_type_Jdl.vX());
          paramString.enableLoading(true);
          paramString.setVisibility(0);
          arv();
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4) {
            break label597;
          }
          if (paramInt != 0) {
            break label587;
          }
          paramString.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if ((bool) && (paramInt > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PX))) {
          L(0, paramInt);
        }
        if (paramInt > 0) {
          arw();
        }
        jj(false);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      paramString = this.jdField_a_of_type_ArrayOfIzm[i];
      setGlRender(str, paramString.a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_2], key[" + str + "], index[" + i + "], " + paramString.hl());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, true);
      paramInt = i;
      continue;
      label587:
      paramString.setScaleType(ImageView.ScaleType.CENTER_CROP);
      continue;
      label597:
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
      {
        paramString.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        continue;
        i = c("setRemoteHasVideo_close", paramString, paramInt);
        if (i < 0) {
          break;
        }
        paramString = VideoLayerUI.u(paramString, paramInt);
        localObject = GraphicRenderMgr.getInstance();
        ((GraphicRenderMgr)localObject).flushGlRender(paramString);
        ((GraphicRenderMgr)localObject).setGlRender(paramString, null);
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_no], key[" + paramString + "], index[" + i + "]");
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, true, true);
        lT(i);
        return;
        label732:
        paramInt = i;
        continue;
        label738:
        paramString = null;
      }
    }
  }
  
  public void b(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    case 6006: 
    case 6007: 
    default: 
    case 6005: 
      do
      {
        return;
      } while (((iya.f)iya.a(paramObservable)).avE != 2);
      return;
    }
    arz();
    paramObservable = (ijn)paramObservable[1];
    this.jdField_a_of_type_Jhj.c(paramObservable);
  }
  
  boolean d(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setLocalHasVideo, isLocalHasVideo[" + this.YG + "->" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (irc.getGLVersion(this.mContext) == 1) {
      return false;
    }
    int i;
    String str1;
    Object localObject3;
    if (paramBoolean1)
    {
      ThreadManager.post(this.ch, 8, null, false);
      String str2 = this.mApp.getCurrentAccountUin();
      i = c("setLocalHasVideo_open", str2, 1);
      str1 = VideoLayerUI.u(str2, 1);
      if (i < 0)
      {
        int j = cD(0);
        if (j >= 0)
        {
          localObject3 = this.jdField_a_of_type_ArrayOfIzm[j];
          ((izm)localObject3).setTag(0, str2);
          ((izm)localObject3).setTag(1, Integer.valueOf(1));
          ((izm)localObject3).kc(str2);
        }
        try
        {
          GraphicRenderMgr.getInstance().setAccountUin(str2);
          setGlRender(str1, ((izm)localObject3).a());
          localObject1 = localObject4;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localObject2 = "UnsatisfiedLinkError" + localUnsatisfiedLinkError.getMessage();
          }
        }
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_1], key[" + str1 + "], index[" + j + "], log[" + localObject1 + "], " + ((izm)localObject3).hl());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, false);
        localObject1 = localObject3;
        localObject3 = localObject1;
        i = j;
        if (j <= 1) {
          break label567;
        }
        localObject3 = localObject1;
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4) {
          break label567;
        }
        i = j;
        if (localObject1 != null)
        {
          localObject1.jK(false);
          localObject1.enableLoading(false);
          localObject1.jO(true);
          localObject1.setVisibility(0);
          localObject1.setScaleType(ImageView.ScaleType.CENTER_CROP);
          if (CameraUtils.a(this.mContext).ar(l)) {
            localObject1.J(l, CameraUtils.a(this.mContext).isFrontCamera());
          }
          arv();
        }
        if (i == 0)
        {
          j = lK();
          if (j > 0) {
            L(i, j);
          }
        }
        jj(false);
      }
    }
    for (;;)
    {
      this.YG = paramBoolean1;
      return true;
      localObject3 = this.jdField_a_of_type_ArrayOfIzm[i];
      setGlRender(str1, ((izm)localObject3).a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_2], key[" + str1 + "], index[" + i + "], " + ((izm)localObject3).hl());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, false);
      label567:
      Object localObject2 = localObject3;
      break;
      if (!paramBoolean1)
      {
        ThreadManager.post(this.ci, 8, null, false);
        localObject2 = this.mApp.getCurrentAccountUin();
        i = c("setLocalHasVideo_close", (String)localObject2, 1);
        if (i >= 0)
        {
          localObject2 = VideoLayerUI.u((String)localObject2, 1);
          localObject3 = GraphicRenderMgr.getInstance();
          ((GraphicRenderMgr)localObject3).flushGlRender((String)localObject2);
          ((GraphicRenderMgr)localObject3).clearCameraFrames();
          ((GraphicRenderMgr)localObject3).setGlRender((String)localObject2, null);
          QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_no], key[" + (String)localObject2 + "], index[" + i + "]");
          this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, true, false);
          lT(i);
        }
      }
    }
  }
  
  void f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.mTopOffset = paramInt1;
    this.ayt = paramInt2;
    jj(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qw)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_ArrayOfIzm.length)
        {
          izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
          if (i == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              localizm.jN(false);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localizm.jN(true);
            continue;
            localizm.jN(true);
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfIzm.length)
        {
          this.jdField_a_of_type_ArrayOfIzm[paramInt1].jN(false);
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void jj(boolean paramBoolean)
  {
    boolean bool = true;
    int i = super.getWidth();
    int j = super.getHeight();
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "layoutVideoView, virtical[" + paramBoolean + "], sessionType[" + localiiv.amI + "], width[" + i + "], height[" + j + "]");
    }
    this.jdField_a_of_type_ArrayOfIzm[0].setPaddings(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfIzm[0].layout(0, 0, i, j);
    this.jdField_a_of_type_ArrayOfIzm[0].setBackgroundColor(-15197410);
    if (b(localiiv))
    {
      jdl localjdl = this.jdField_a_of_type_Jdl;
      izm[] arrayOfizm = this.jdField_a_of_type_ArrayOfIzm;
      int k = this.mPosition;
      int m = this.mTopOffset;
      int n = this.ayt;
      if (!localiiv.PT)
      {
        paramBoolean = bool;
        localjdl.a(arrayOfizm, i, j, k, m, n, paramBoolean);
        ild.by(j, i);
      }
    }
    for (;;)
    {
      super.invalidate();
      return;
      paramBoolean = false;
      break;
      if (c(localiiv)) {
        b(paramBoolean, i, j, 0);
      }
    }
  }
  
  public int lI()
  {
    return this.jdField_a_of_type_Jdl.getStyle();
  }
  
  public void lS(int paramInt)
  {
    super.lS(paramInt);
    if (this.jdField_a_of_type_Jdl.getStyle() != paramInt)
    {
      this.jdField_a_of_type_Jdl = jdl.a(this.mContext, this.mApp, paramInt, true);
      jj(true);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[paramInt].jI(this.jdField_a_of_type_Jdl.vX());
        a(-1049L, this.jdField_a_of_type_ArrayOfIzm[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  public void lU(int paramInt)
  {
    this.jdField_a_of_type_Jdl.a(this.jdField_a_of_type_ArrayOfIzm, getWidth(), getHeight(), paramInt, this.mTopOffset, this.ayt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Jdl != null)
    {
      this.jdField_a_of_type_Jdl.onDestroy();
      this.jdField_a_of_type_Jdl = null;
    }
  }
  
  protected void onFirstDraw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
    }
    if (this.mApp != null) {
      this.mApp.getHandler().post(new SmallScreenVideoLayerUI.1(this));
    }
  }
  
  public static abstract interface a
  {
    public abstract void lN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwb
 * JD-Core Version:    0.7.0.1
 */