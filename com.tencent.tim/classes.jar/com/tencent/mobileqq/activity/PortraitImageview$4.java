package com.tencent.mobileqq.activity;

class PortraitImageview$4
  implements Runnable
{
  float pi;
  float pj;
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.pf, (float)(l - this.val$startTime));
    float f2 = this.this$0.b(f1, 0.0F, this.pk, this.pf);
    float f3 = this.this$0.b(f1, 0.0F, this.pl, this.pf);
    this.this$0.postTranslate(f2 - this.pi, f3 - this.pj);
    this.this$0.setImageMatrix(this.this$0.getImageViewMatrix());
    this.pi = f2;
    this.pj = f3;
    if (f1 < this.pf) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.4
 * JD-Core Version:    0.7.0.1
 */