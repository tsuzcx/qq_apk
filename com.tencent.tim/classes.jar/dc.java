import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class dc
  implements View.OnClickListener
{
  dc(db paramdb) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.H()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.aM();
      Object localObject1 = (dl)paramView.getTag();
      Object localObject3 = ((dl)localObject1).a();
      Object localObject2 = ((DataLineMsgSet)localObject3).getFirstItem();
      if (((DataLineMsgSet)localObject3).isSingle())
      {
        if (-1000 != ((DataLineMsgRecord)localObject2).msgtype)
        {
          FileManagerEntity localFileManagerEntity = ahav.a((DataLineMsgRecord)localObject2);
          if (avlx.a().E(localFileManagerEntity))
          {
            avlx.a().L(this.this$0.mContext, localFileManagerEntity.getFilePath(), true);
          }
          else if ((((DataLineMsgRecord)localObject2).nOpType == 31) || (ahav.r(localFileManagerEntity)))
          {
            db.a(this.this$0, (DataLineMsgRecord)localObject2);
          }
          else if (((DataLineMsgRecord)localObject2).nOpType == 29)
          {
            db.b(this.this$0, (DataLineMsgRecord)localObject2);
          }
          else
          {
            localObject3 = new agvm(this.this$0.mContext, localFileManagerEntity);
            ArrayList localArrayList = new ArrayList();
            if (localFileManagerEntity.nFileType == 0)
            {
              Iterator localIterator = db.a(this.this$0).iterator();
              label350:
              while (localIterator.hasNext())
              {
                Object localObject4 = (DataLineMsgSet)localIterator.next();
                if (((DataLineMsgSet)localObject4).isSingle())
                {
                  localObject4 = ((DataLineMsgSet)localObject4).values().iterator();
                  for (;;)
                  {
                    if (!((Iterator)localObject4).hasNext()) {
                      break label350;
                    }
                    DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject4).next();
                    int j = ahav.getFileType(localDataLineMsgRecord.filename);
                    int i = j;
                    if (j == -1)
                    {
                      i = j;
                      if (localDataLineMsgRecord.msgtype == -2000) {
                        i = 0;
                      }
                    }
                    if (i != localFileManagerEntity.nFileType) {
                      break;
                    }
                    if (localDataLineMsgRecord != localObject2) {
                      localArrayList.add(String.valueOf(ahav.a(localDataLineMsgRecord).nSessionId));
                    } else {
                      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
                    }
                  }
                }
              }
              if (localArrayList.size() == 0) {
                localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
              }
              ((agvm)localObject3).ep(localArrayList);
            }
            localObject1 = ahbr.a(((dl)localObject1).a().d, localFileManagerEntity.fileName);
            localObject2 = new agvn(this.this$0.mContext, (agvq)localObject3);
            ((agvn)localObject2).Oy(11);
            ((agvn)localObject2).k((Rect)localObject1);
            ((agvn)localObject2).djN();
          }
        }
      }
      else if (((DataLineMsgSet)localObject3).getGroupType() == -2000)
      {
        localObject1 = new Intent(this.this$0.b, LiteMutiPicViewerActivity.class);
        ((Intent)localObject1).putExtra("dataline_group_id", ((DataLineMsgSet)localObject3).getGroupId());
        this.this$0.b.startActivity((Intent)localObject1);
      }
      else
      {
        localObject1 = new Intent(this.this$0.b, DLFilesViewerActivity.class);
        ((Intent)localObject1).putExtra("dl_files_groupid", ((DataLineMsgSet)localObject3).getGroupId());
        this.this$0.b.startActivityForResult((Intent)localObject1, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */