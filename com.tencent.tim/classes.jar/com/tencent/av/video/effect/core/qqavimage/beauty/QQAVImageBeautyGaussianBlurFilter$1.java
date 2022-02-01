package com.tencent.av.video.effect.core.qqavimage.beauty;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import java.util.List;

class QQAVImageBeautyGaussianBlurFilter$1
  implements Runnable
{
  QQAVImageBeautyGaussianBlurFilter$1(QQAVImageBeautyGaussianBlurFilter paramQQAVImageBeautyGaussianBlurFilter) {}
  
  public void run()
  {
    if (QQAVImageBeautyGaussianBlurFilter.access$000(this.this$0) != null)
    {
      int i = 0;
      while (i < QQAVImageBeautyGaussianBlurFilter.access$100(this.this$0).size())
      {
        ((QQAVImageFilter)QQAVImageBeautyGaussianBlurFilter.access$200(this.this$0).get(i)).init();
        ((QQAVImageFilter)QQAVImageBeautyGaussianBlurFilter.access$500(this.this$0).get(i)).onOutputSizeChanged(QQAVImageBeautyGaussianBlurFilter.access$300(this.this$0), QQAVImageBeautyGaussianBlurFilter.access$400(this.this$0));
        this.this$0.onOutputSizeChanged(QQAVImageBeautyGaussianBlurFilter.access$600(this.this$0), QQAVImageBeautyGaussianBlurFilter.access$700(this.this$0));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyGaussianBlurFilter.1
 * JD-Core Version:    0.7.0.1
 */