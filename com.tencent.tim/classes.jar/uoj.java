import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uoj
  implements View.OnClickListener
{
  uoj(uog paramuog) {}
  
  public void onClick(View paramView)
  {
    abdx.a locala = (abdx.a)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)locala.entity;
    if (5 != localFileManagerEntity.cloudType) {
      ahav.I(localFileManagerEntity);
    }
    switch (locala.actionType)
    {
    }
    for (;;)
    {
      this.this$0.a.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ahao.OS(2131693819);
        }
        else
        {
          agzy.a(localFileManagerEntity).a(false, this.this$0.mContext, new uok(this, localFileManagerEntity));
          break;
          this.this$0.c(localFileManagerEntity);
          break;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.this$0.mApp.a().js(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((acde)this.this$0.mApp.getBusinessHandler(8)).g(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.this$0.mApp.a().bZ(localFileManagerEntity.nSessionId);
          break;
          if (aqiw.isNetSupport(BaseApplication.getContext())) {
            break label246;
          }
          ahao.OS(2131693819);
        }
      }
      label246:
      boolean bool = localFileManagerEntity.isSend();
      agzy.a(localFileManagerEntity).a(bool, this.this$0.mContext, new uol(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */