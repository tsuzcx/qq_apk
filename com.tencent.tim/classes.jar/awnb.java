import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class awnb
  extends awni
{
  public awnb(QzoneHuangzuanVipIconShow paramQzoneHuangzuanVipIconShow, VipResourcesListener paramVipResourcesListener, int paramInt1, awmz paramawmz, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5) {}
  
  public void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable)
  {
    QzoneHuangzuanVipIconShow.access$000(this.a, paramInt, paramDrawable, this.Yu, this.jdField_b_of_type_Awmz);
    if (this.mCount <= 0)
    {
      QzoneHuangzuanVipIconShow.access$100(this.a, this.jdField_b_of_type_Awmz, this.eCa, this.Yu, this.Yv, this.Ep, this.DY, this.val$location, this.EB, this.val$type);
      if (this.jdField_b_of_type_CooperationVipVipcomponentUtilVipResourcesListener != null) {
        this.jdField_b_of_type_CooperationVipVipcomponentUtilVipResourcesListener.onLoaded(this.jdField_b_of_type_Awmz);
      }
    }
  }
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_b_of_type_CooperationVipVipcomponentUtilVipResourcesListener != null) {
      this.jdField_b_of_type_CooperationVipVipcomponentUtilVipResourcesListener.onFailed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnb
 * JD-Core Version:    0.7.0.1
 */