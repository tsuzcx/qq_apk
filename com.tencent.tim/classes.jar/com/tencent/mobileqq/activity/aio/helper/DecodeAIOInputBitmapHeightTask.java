package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import wja;

public class DecodeAIOInputBitmapHeightTask
  implements Runnable
{
  private WeakReference<BaseChatPie> dU;
  
  public DecodeAIOInputBitmapHeightTask(BaseChatPie paramBaseChatPie)
  {
    this.dU = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.dU.get();
    if (localBaseChatPie == null) {
      return;
    }
    Object localObject1 = localBaseChatPie.a;
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = false;
    localObject2 = BitmapFactory.decodeResource(localBaseChatPie.mActivity.getResources(), 2130850843, (BitmapFactory.Options)localObject2);
    float f;
    int j;
    int k;
    if (localObject2 != null)
    {
      i = wja.dp2px(((Bitmap)localObject2).getHeight() / 2, localBaseChatPie.mActivity.getResources());
      localObject2 = ((EditText)localObject1).getPaint().getFontMetrics();
      f = Math.abs(((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top);
      j = wja.dp2px(36.0F, localBaseChatPie.mActivity.getResources());
      k = ((EditText)localObject1).getPaddingTop();
    }
    for (int i = (Math.max(j, Math.max((int)(((EditText)localObject1).getPaddingBottom() + k + f), i)) - localBaseChatPie.mActivity.getResources().getDimensionPixelSize(2131298573)) / 2;; i = 0)
    {
      i = Math.max(i, 0);
      localObject1 = localBaseChatPie.getUIHandler();
      if (localObject1 == null) {
        break;
      }
      ((MqqHandler)localObject1).post(new DecodeAIOInputBitmapHeightTask.1(this, localBaseChatPie, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask
 * JD-Core Version:    0.7.0.1
 */