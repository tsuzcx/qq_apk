import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class afmq
  extends acck
{
  afmq(afmn paramafmn) {}
  
  public void IF(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnGetEmoListResult");
    }
    if (paramInt == 0)
    {
      if ((this.this$0.a.app != null) && (((afhc)this.this$0.a.app.getManager(333)).CV() > 0)) {
        this.this$0.dat();
      }
      this.this$0.dau();
    }
  }
  
  protected void IG(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnDeleteEmoResult");
    }
    if (paramInt == 0) {
      this.this$0.dau();
    }
  }
  
  public void aT(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoSend");
    }
    this.this$0.dau();
    afmn.a(this.this$0, paramInt);
  }
  
  protected void cHk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.this$0.dau();
    if ((this.this$0.a.app != null) && (((afhc)this.this$0.a.app.getManager(333)).CV() > 0)) {
      this.this$0.dat();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmq
 * JD-Core Version:    0.7.0.1
 */