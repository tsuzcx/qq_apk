package com.tencent.mobileqq.activity.qwallet.widget;

class NumAnim$1
  implements NumAnim.Ruler
{
  NumAnim$1(NumAnim paramNumAnim) {}
  
  public NumAnim.SpannableValue getNumber(double paramDouble)
  {
    String str;
    if ((paramDouble >= 1000.0D) && (paramDouble < 10000.0D))
    {
      str = NumAnim.formatNumber(paramDouble, true);
      if (paramDouble < 10000.0D) {
        break label72;
      }
    }
    label72:
    for (int i = str.indexOf(NumAnim.WAN);; i = str.indexOf("."))
    {
      return new NumAnim.SpannableValue(str, 0, i);
      if ((paramDouble >= 0.0D) && (paramDouble < 1000.0D)) {
        break;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.NumAnim.1
 * JD-Core Version:    0.7.0.1
 */