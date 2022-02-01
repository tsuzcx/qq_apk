import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uoi
  implements View.OnClickListener
{
  uoi(uog paramuog) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (abdx.a)paramView.getTag();
      if ((((abdx.a)localObject).entity instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)((abdx.a)localObject).entity;
        this.this$0.c((FileManagerEntity)localObject);
      }
      else if ((((abdx.a)localObject).entity instanceof TencentDocData))
      {
        localObject = (TencentDocData)((abdx.a)localObject).entity;
        this.this$0.c((TencentDocData)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoi
 * JD-Core Version:    0.7.0.1
 */