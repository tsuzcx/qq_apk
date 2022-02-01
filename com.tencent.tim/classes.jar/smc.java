import android.graphics.Rect;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.qphone.base.util.QLog;

class smc
  implements BounceScrollView.c
{
  smc(slz paramslz) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.this$0.jdField_a_of_type_Apbo$c != null) && (this.this$0.aLY))
    {
      Rect localRect = new Rect();
      this.this$0.b.getHitRect(localRect);
      if (this.this$0.ab.getLocalVisibleRect(localRect))
      {
        this.this$0.aLY = false;
        aprv.a(this.this$0.mContext, null, this.this$0.jdField_a_of_type_Apbo$c.apurl, 0, null, null);
        anot.a(this.this$0.app, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "exp_ad", 0, 0, this.this$0.troopUin, String.valueOf(this.this$0.jdField_a_of_type_Apbo$b.mType), "8020205751015455", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "onScrollChanged 广告图片可见-------------------------");
        }
      }
    }
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smc
 * JD-Core Version:    0.7.0.1
 */