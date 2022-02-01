import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ygh
  implements ygb.a, ygg.a
{
  private yfw b;
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ygg jdField_c_of_type_Ygg;
  private Context mContext;
  
  public ygh(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.mContext = paramContext;
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    ygb.a().b(this);
  }
  
  public boolean D(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ad == null) {}
    do
    {
      return false;
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ad.getLeft() > paramFloat1) || (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ad.getRight() < paramFloat1)) {
        return true;
      }
    } while ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ad.getTop() <= paramFloat2) && (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ad.getBottom() >= paramFloat2));
    return true;
  }
  
  public void I(float paramFloat1, float paramFloat2) {}
  
  public void Um()
  {
    yfy.b(this, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.b = yfx.b(yfy.bO(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentUin()));
    if (this.b == null) {}
    String str;
    do
    {
      return;
      str = this.b.localPath;
    } while (str == null);
    ygb.a().a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL, this.mContext).a(yfy.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(ygg paramygg)
  {
    this.jdField_c_of_type_Ygg = paramygg;
  }
  
  public void cia() {}
  
  public void cib()
  {
    cie();
    if (this.jdField_c_of_type_Ygg != null) {
      this.jdField_c_of_type_Ygg.cih();
    }
  }
  
  public void cie()
  {
    yfy.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL);
  }
  
  public void cif() {}
  
  public int e(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void fN(int paramInt1, int paramInt2)
  {
    ygb.a().d(this.mContext).KO();
    yfw localyfw = this.b;
    if (localyfw != null)
    {
      yfy.a(localyfw, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentUin());
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.ve(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localyfw, paramInt2), 10, null, false);
      anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "dc00898", "", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, "0X80091A5", "0X80091A5", localyfw.pokeemoId, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public int wG()
  {
    return xks.c(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygh
 * JD-Core Version:    0.7.0.1
 */