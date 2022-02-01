import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class yan
  extends acnd
{
  yan(yam paramyam) {}
  
  protected void ah(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.bYi != 2) && (paramBoolean) && (this.this$0.c != null) && (this.this$0.b != null) && (this.this$0.b.troopUin.equals(paramString)) && (this.this$0.b.hasPostRedPoint())) {
      this.this$0.c.showRedDot(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG + "Q.hotchat.aio_post_red_point", 2, "onBuluoHotChatRedPointComing, troopUin:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yan
 * JD-Core Version:    0.7.0.1
 */