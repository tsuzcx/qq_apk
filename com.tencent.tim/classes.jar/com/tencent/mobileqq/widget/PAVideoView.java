package com.tencent.mobileqq.widget;

import afei;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import anvf;
import anvf.b;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import wja;

public class PAVideoView
  extends BubbleVideoView
{
  public static afei d = new afei(-2236446, 100, 100);
  public static int egQ;
  public static int egR = egQ + 1;
  public static int egS = egR + 1;
  public int ID = (int)(Math.random() * 1000.0D);
  public long IO;
  private Shader a;
  public anvf.b a;
  public anvf a;
  public String cAp = "";
  public String cAq;
  private float[] dJ = new float[egS + 1];
  public boolean dau;
  public boolean dav;
  public int egT;
  public int egU;
  private boolean mBlockLayout;
  public int mBusiType;
  public String mCoverUrl;
  public int mMode = egQ;
  public String mSourceName;
  public String mUin;
  public int mUinType;
  public String mVid;
  
  public PAVideoView(Context paramContext)
  {
    super(paramContext);
    this.dJ[egQ] = 1.777F;
    this.dJ[egR] = 0.83F;
    this.dJ[egS] = 1.0F;
  }
  
  public Shader a()
  {
    return this.jdField_a_of_type_AndroidGraphicsShader;
  }
  
  public void a(anvf paramanvf, anvf.b paramb)
  {
    this.egT = paramanvf.dMK;
    this.egU = paramanvf.dML;
    this.mCoverUrl = paramanvf.imgUrl;
    this.mVid = paramanvf.ciu;
    if (paramanvf.e.message == null) {}
    for (long l = 0L;; l = paramanvf.e.message.uniseq)
    {
      this.IO = l;
      this.mUinType = paramanvf.e.uinType;
      this.mUin = paramanvf.e.uin;
      this.mBusiType = paramanvf.type;
      this.cAq = paramanvf.Wz;
      if ((paramanvf.e instanceof AbsShareMsg)) {
        this.mSourceName = ((AbsShareMsg)paramanvf.e).mSourceName;
      }
      this.jdField_a_of_type_Anvf = paramanvf;
      this.cAp = paramanvf.videoUrl;
      this.jdField_a_of_type_Anvf$b = paramb;
      return;
    }
  }
  
  public Drawable f(String paramString)
  {
    afei localafei = d;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, d, d);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PAVideoView" + this.ID, 2, "getCoverDrawable():  getDrawable Exception, mCoverUrl=" + this.mCoverUrl, paramString);
        }
        return d;
      }
      paramString = localafei;
    } while (!QLog.isColorLevel());
    QLog.e("PAVideoView" + this.ID, 2, "getCoverDrawable():  mCoverUrl=" + this.mCoverUrl);
    return localafei;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j;
    float f;
    if (this.dav)
    {
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      i = getPaddingLeft();
      j = getPaddingRight();
      f = this.dJ[this.mMode];
      if (!this.dau) {
        break label114;
      }
      if (this.mMode != egQ) {
        break label94;
      }
      paramInt2 = BaseChatItemLayout.bNS - BaseChatItemLayout.bNY;
      paramInt1 = (int)(paramInt2 / f + 0.5F);
      i = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      label94:
      paramInt1 = BaseChatItemLayout.bNS - BaseChatItemLayout.bNY;
      paramInt2 = (int)(paramInt1 * f + 0.5F);
      break;
      label114:
      paramInt2 = View.MeasureSpec.makeMeasureSpec((int)((paramInt2 - i - j) / f + 0.5F), 1073741824);
      i = paramInt1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidGraphicsShader == null)
    {
      paramInt1 = wja.dp2px(55.0F, getResources());
      if (!this.dau) {
        break label136;
      }
      if (this.mMode != egQ) {
        break label112;
      }
      paramInt1 = wja.dp2px(55.0F, getResources());
    }
    label136:
    for (;;)
    {
      float f1 = paramInt2 - paramInt1;
      float f2 = paramInt2;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.jdField_a_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
      return;
      label112:
      if (this.mMode == egR)
      {
        paramInt1 = wja.dp2px(75.0F, getResources());
        continue;
        paramInt1 = (int)(paramInt2 * 0.6F);
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayout) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mBlockLayout = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.mBlockLayout = false;
  }
  
  public void setRatioByMode(int paramInt, float paramFloat)
  {
    if ((paramInt == egS) || (paramInt == egQ) || (paramInt == egR)) {
      this.dJ[paramInt] = paramFloat;
    }
  }
  
  public void showCover()
  {
    this.jdField_a_of_type_Anvf$b.bU.setVisibility(0);
    setImageDrawable(f(this.mCoverUrl));
    if (QLog.isColorLevel()) {
      QLog.d("PAVideoView" + this.ID, 2, "showCover():  mVid=" + this.mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAVideoView
 * JD-Core Version:    0.7.0.1
 */