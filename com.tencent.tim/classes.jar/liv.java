import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.a;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

public class liv
  extends SosoInterface.a
{
  public liv(SelectPositionModule paramSelectPositionModule, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (!TextUtils.isEmpty(paramSosoLbsInfo.a.city)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "onLocationFinish() info.mLocation =" + paramSosoLbsInfo.a);
      }
      SelectPositionModule.a(this.this$0, new SelectPositionModule.PositionData(paramSosoLbsInfo.a));
      SelectPositionModule.a(this.this$0, SelectPositionModule.a(this.this$0));
      SelectPositionModule.b(this.this$0, SelectPositionModule.a(this.this$0));
      if (SelectPositionModule.a(this.this$0) != null) {
        SelectPositionModule.a(this.this$0).g(SelectPositionModule.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     liv
 * JD-Core Version:    0.7.0.1
 */