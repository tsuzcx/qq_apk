import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public class zfl
  extends ahct
{
  public zfl(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void fk(View paramView)
  {
    paramView = (ziz.a)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.entity;
    if (5 != localFileManagerEntity.cloudType) {
      ahav.I(localFileManagerEntity);
    }
    switch (paramView.actionType)
    {
    }
    for (;;)
    {
      ChatHistoryC2CFileFragment.a(this.this$0).notifyDataSetChanged();
      return;
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ahao.OS(2131693819);
        return;
      }
      agzy.a(localFileManagerEntity).a(false, this.this$0.mActivity, new zfm(this, localFileManagerEntity));
      continue;
      this.this$0.c(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.this$0.mApp.a().js(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((acde)this.this$0.mApp.getBusinessHandler(8)).g(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.this$0.mApp.a().bZ(localFileManagerEntity.nSessionId);
        continue;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ahao.OS(2131693819);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        agzy.a(localFileManagerEntity).a(bool, this.this$0.mActivity, new zfn(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfl
 * JD-Core Version:    0.7.0.1
 */