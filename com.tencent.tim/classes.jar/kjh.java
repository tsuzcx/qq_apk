import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.qphone.base.util.QLog;

public class kjh
  implements mqv.a
{
  public kjh(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment) {}
  
  public void L(float paramFloat) {}
  
  public void aDx() {}
  
  public void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d(ReadInJoyUploadAvatarFragment.TAG, 1, "onFileTransferFinished,retCode:" + paramInt + "  fileUrl:" + paramString1 + "  fileMd5:" + paramString2 + "  uuid:" + paramString3);
    paramString2 = this.this$0.getActivity();
    if (paramString2 == null)
    {
      QLog.e(ReadInJoyUploadAvatarFragment.TAG, 1, "onFileTransferFinished activity = null");
      return;
    }
    paramString3 = new Bundle();
    switch (paramInt)
    {
    default: 
      QLog.e(ReadInJoyUploadAvatarFragment.TAG, 1, "onFileTransferFinished no handler, retCode=" + paramInt);
      paramString1 = "";
      paramInt = 3;
    }
    for (;;)
    {
      paramString3.putInt("retCode", paramInt);
      paramString3.putString("msg", "");
      paramString3.putString("url", paramString1);
      paramString1 = paramString2.getIntent();
      paramString1.putExtra("Bundle", paramString3);
      paramString2.setResult(-1, paramString1);
      paramString2.finish();
      return;
      paramInt = 0;
      continue;
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString1 = "";
      paramInt = 2;
      continue;
      paramString1 = "";
      paramInt = 3;
      continue;
      paramString1 = "";
      paramInt = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjh
 * JD-Core Version:    0.7.0.1
 */