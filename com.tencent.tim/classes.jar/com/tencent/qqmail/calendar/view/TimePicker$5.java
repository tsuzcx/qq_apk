package com.tencent.qqmail.calendar.view;

class TimePicker$5
  implements NumberPicker.OnValueChangeListener
{
  TimePicker$5(TimePicker paramTimePicker) {}
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    TimePicker.access$000(this.this$0);
    paramNumberPicker.requestFocus();
    paramNumberPicker = this.this$0;
    if (!TimePicker.access$100(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      TimePicker.access$102(paramNumberPicker, bool);
      TimePicker.access$200(this.this$0);
      TimePicker.access$300(this.this$0);
      return;
    }
  }
  
  public void onValueChangeAfterScroll(NumberPicker paramNumberPicker, int paramInt)
  {
    TimePicker.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.TimePicker.5
 * JD-Core Version:    0.7.0.1
 */