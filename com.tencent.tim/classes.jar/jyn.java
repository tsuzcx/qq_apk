import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.EncryptUinInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class jyn
  extends jym.a
{
  jyn(jym paramjym) {}
  
  protected void a(boolean paramBoolean, List<EncryptUinInfo> paramList, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (EncryptUinInfo)paramList.get(0);
      if ((paramList.code != 0) || (paramList.rb != this.this$0.mApp.getLongAccountUin()) || (TextUtils.isEmpty(paramList.UZ))) {
        break label113;
      }
      jym.a(this.this$0, paramList.UZ);
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: " + jym.a(this.this$0));
      }
    }
    label113:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: failed，code=" + paramList.code);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      super.onUpdate(paramInt, paramBoolean, paramObject);
      this.this$0.mApp.removeObserver(jym.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyn
 * JD-Core Version:    0.7.0.1
 */