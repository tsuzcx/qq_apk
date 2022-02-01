import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudFeedListActivity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atli
  implements View.OnClickListener
{
  public atli(CloudFeedListActivity paramCloudFeedListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (atjv.a)paramView.getTag();
    Object localObject2 = ((atjv.a)localObject1).a;
    if (((atiu)localObject2).getCloudFileType() == 0) {
      athu.a(this.a.app, this.a, (atiu)localObject2, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((atiu)localObject2).getCloudFileType() == 2)
      {
        athu.a(this.a.app, this.a, (atiu)localObject2);
      }
      else if (((atiu)localObject2).getCloudFileType() == 3)
      {
        ArrayList localArrayList = new ArrayList();
        localObject2 = ((FileManagerEntity)localObject2).combinePhotoList;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Iterator localIterator = ((List)localObject2).iterator();
          while (localIterator.hasNext())
          {
            FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
            if (localFileManagerEntity != null)
            {
              this.a.app.a().v(localFileManagerEntity);
              localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
            }
          }
          if (((List)localObject2).size() == 1)
          {
            athu.a(this.a.app, this.a, (atiu)((List)localObject2).get(0), localArrayList);
          }
          else
          {
            localObject2 = new Intent(this.a, CloudPhotoListActivity.class);
            ((Intent)localObject2).putStringArrayListExtra("photo_entity_list_intent", localArrayList);
            localObject1 = (atkl.a)localObject1;
            if ((localObject1 != null) && (((atkl.a)localObject1).dhX))
            {
              ((Intent)localObject2).putExtra("key_file_browser_mode", 2);
              this.a.startActivityForResult((Intent)localObject2, 8);
            }
            else
            {
              this.a.startActivity((Intent)localObject2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atli
 * JD-Core Version:    0.7.0.1
 */