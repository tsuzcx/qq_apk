import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import java.util.Arrays;
import java.util.List;

public class r
  extends l
{
  private Paint j;
  private int[] s;
  
  public r(ETTextView paramETTextView, ETFont paramETFont)
  {
    super(paramETTextView, paramETFont);
  }
  
  private void M()
  {
    int i;
    label66:
    q localq;
    if (this.b == null)
    {
      this.b = new Canvas(this.d);
      if (this.j == null)
      {
        this.j = new Paint();
        this.j.setColor(-16777216);
      }
      this.jdField_s_of_type_ArrayOfInt = new int[this.D.size()];
      i = 0;
      if (i >= this.D.size()) {
        return;
      }
      localq = (q)this.D.get(i);
      if (localq.aJ) {
        break label130;
      }
      this.jdField_s_of_type_ArrayOfInt[i] = 0;
    }
    for (;;)
    {
      i += 1;
      break label66;
      this.b.setBitmap(this.d);
      break;
      label130:
      this.jdField_s_of_type_ArrayOfInt[i] = 1;
      this.j.setTextSize(localq.height);
      float f1 = localq.height / 2.0F;
      float f2 = (this.j.descent() + this.j.ascent()) / 2.0F;
      this.b.drawText(String.valueOf(localq.jdField_a_of_type_Char), localq.left, localq.top + (f1 - f2), this.j);
    }
  }
  
  protected void N()
  {
    int k = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i;
    label46:
    q localq;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.d);
      int m = this.D.size();
      i = 0;
      if (i >= m) {
        return;
      }
      localq = (q)this.D.get(i);
      switch (localq.type)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.d);
      break;
      Object localObject = a(localq.width, k);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, localq.left, localq.top + localq.height - k, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(localq.left, localq.top, localq.left + localq.width, localq.top + localq.height, this.m);
      if ((localq.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof aofk.a))
      {
        ((aofk.a)localq.jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, localq.left, localq.top, localq.top + localq.height, localq.top + localq.height, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((localq.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof amfz))
      {
        localObject = (amfz)localq.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((amfz)localObject).cCu = false;
        ((amfz)localObject).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, localq.left, localq.top, localq.top, localq.top + localq.height, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
  
  public void O()
  {
    if ((this.mFont == null) || (F())) {}
    do
    {
      return;
      if ((this.cD <= 0) || (this.cD > 5) || (this.aw))
      {
        j.e(getTag(), "0行或超过5行或全EMOJI不支持播放动画..." + this.mFont.mFontPath);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if (i.isDebug) {
      j.i(getTag(), "StartAnimation......animInfo:" + Arrays.toString(this.M));
    }
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    this.frameIndex = 0;
    i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.jdField_s_of_type_ArrayOfInt, this.d, null, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cD, this.cE, this.lineSpace, this.mFont.mAnimationId, this.frameIndex, this.M, this.mFont.m_comboIndex);
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    j.e(getTag(), "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.M));
  }
  
  public boolean onDraw(Canvas paramCanvas)
  {
    if (F())
    {
      r("StrikingLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!G())
    {
      r("StrikingLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.jdField_s_of_type_JavaUtilList == null) || (this.jdField_s_of_type_JavaUtilList.isEmpty()))
    {
      r(acfp.m(2131714990));
      return false;
    }
    if (this.y.length <= 0)
    {
      r(acfp.m(2131714991));
      return false;
    }
    long l = System.nanoTime();
    Q();
    c(paramCanvas);
    M();
    h.h(this.mFont.mFontId);
    int i = h.m(this.mFont.mFontId);
    if ((!this.aw) && (this.cD > 0) && (this.cD < 6))
    {
      if (this.mFont.mShouldDisplayAnimation)
      {
        i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.jdField_s_of_type_ArrayOfInt, this.d, null, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cD, this.cE, this.lineSpace, this.mFont.mAnimationId, this.frameIndex, this.M, this.mFont.m_comboIndex);
        N();
        paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
        if (this.frameIndex == 0) {
          O();
        }
        if (i.isDebug)
        {
          j.b(getTag(), l, "字数：" + this.y.length + "\n   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px\n");
          r("StrikingLayout::onDraw......");
        }
        return true;
      }
      if ((!this.mFont.mShouldDisplayAnimation) && (i == 1))
      {
        i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.jdField_s_of_type_ArrayOfInt, this.d, null, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cD, this.cE, this.lineSpace, this.mFont.mAnimationId, this.M[0], this.M, this.mFont.m_comboIndex);
        N();
        paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
        if (i.isDebug)
        {
          j.b(getTag(), l, "字数：" + this.y.length + "\n   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px\n");
          r("StrikingLayout::onDraw......");
        }
        return true;
      }
    }
    this.Q = new int[0];
    i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.d, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cF, this.Q, this.cL);
    Y();
    paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
    if (I) {
      d(paramCanvas);
    }
    if (i.isDebug)
    {
      j.b(getTag(), l, "字数：" + this.y.length + "\n   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px\n");
      r("StrikingLayout::onDraw......");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     r
 * JD-Core Version:    0.7.0.1
 */