import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class vto
  extends aghq
{
  vto(vtm paramvtm) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferProgress");
    if (this.this$0.rd != null)
    {
      paramInt = 0;
      if (paramInt >= this.this$0.pz.size()) {
        break label232;
      }
      if (((vtm.a)this.this$0.pz.get(paramInt)).uniseq != paramLong1) {}
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.this$0.rd.size())
        {
          paramString = (FileManagerEntity)this.this$0.rd.get(paramInt);
          if (paramString.uniseq != paramLong1) {
            break label202;
          }
          if (this.this$0.mDialog != null) {
            this.this$0.mDialog.setMessage(String.format(this.this$0.aPU, new Object[] { Integer.valueOf(this.this$0.mCurrentIndex + 1), Integer.valueOf(this.this$0.mTotalSize), Integer.valueOf((int)(paramString.fProgress * 100.0F)) }));
          }
        }
        return;
        paramInt += 1;
        break;
        label202:
        paramInt += 1;
      }
      this.this$0.rd = this.this$0.mApp.a().eW();
      return;
      label232:
      paramInt = -1;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String arg6, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferEnd");
    if (!this.this$0.mPause) {
      synchronized (this.this$0.pz)
      {
        this.this$0.bVo();
        return;
      }
    }
  }
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferStart");
    if (this.this$0.mDialog != null) {
      this.this$0.mDialog.setMessage(String.format(this.this$0.aPU, new Object[] { Integer.valueOf(this.this$0.mCurrentIndex + 1), Integer.valueOf(this.this$0.mTotalSize), Integer.valueOf(0) }));
    }
    this.this$0.rd = this.this$0.mApp.a().eW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vto
 * JD-Core Version:    0.7.0.1
 */