package com.tencent.mobileqq.activity.bless;

class CountDownView$1
  implements Runnable
{
  CountDownView$1(CountDownView paramCountDownView) {}
  
  public void run()
  {
    if ((CountDownView.a(this.this$0)) && (CountDownView.a(this.this$0) >= CountDownView.g().length))
    {
      this.this$0.cjE();
      if (CountDownView.a(this.this$0) != null) {
        CountDownView.a(this.this$0).cjG();
      }
    }
    while (CountDownView.a(this.this$0) >= CountDownView.g().length) {
      return;
    }
    CountDownView.a(this.this$0);
    this.this$0.setImageResource(CountDownView.g()[CountDownView.a(this.this$0)]);
    this.this$0.postDelayed(CountDownView.a(this.this$0), 1000L);
    CountDownView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView.1
 * JD-Core Version:    0.7.0.1
 */