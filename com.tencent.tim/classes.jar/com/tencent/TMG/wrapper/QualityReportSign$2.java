package com.tencent.TMG.wrapper;

class QualityReportSign$2
  implements QualityReportSign.GetSignListener
{
  QualityReportSign$2(QualityReportSign paramQualityReportSign) {}
  
  public void onGetSignCompleted(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0) {
      this.this$0.mSign = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.wrapper.QualityReportSign.2
 * JD-Core Version:    0.7.0.1
 */