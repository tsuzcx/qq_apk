import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

final class atxq
  implements View.OnClickListener
{
  atxq(FileManagerEntity paramFileManagerEntity, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (audk.a(this.b).bd(false)) {
        ahal.a(this.val$activity, 2131693826, 2131693829, new atxr(this, localQQAppInterface, localArrayList));
      } else {
        audx.b(localQQAppInterface, localArrayList, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxq
 * JD-Core Version:    0.7.0.1
 */