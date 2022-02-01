package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;

class QCircleRecommendImageView$3
  implements Runnable
{
  QCircleRecommendImageView$3(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void run()
  {
    if (QCircleRecommendImageView.a(this.this$0) != null) {
      QCircleRecommendImageView.a(this.this$0).stop();
    }
    QCircleRecommendImageView.a(this.this$0, false);
    QCircleRecommendImageView.b(this.this$0);
    QCircleRecommendImageView.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.3
 * JD-Core Version:    0.7.0.1
 */