import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import com.tencent.tim.filemanager.widget.SendBottomBar.2.1;
import java.util.ArrayList;
import java.util.Iterator;

public class aufk
  implements View.OnClickListener
{
  public aufk(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.this$0, true);
      new Handler().postDelayed(new SendBottomBar.2.1(this), 800L);
      Object localObject1;
      Object localObject2;
      switch (SendBottomBar.a(this.this$0).DX())
      {
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        this.this$0.VJ(true);
        break;
      case 7: 
        if (SendBottomBar.a(this.this$0).akI())
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putParcelableArrayListExtra("reslut_select_file_info_list", atwb.ep());
          ((Intent)localObject1).putExtra("approval_attachment_customid", SendBottomBar.a(this.this$0).Ea());
          SendBottomBar.a(this.this$0).setResult(-1, (Intent)localObject1);
        }
        SendBottomBar.a(this.this$0).finish();
        break;
      case 1: 
        SendBottomBar.a(this.this$0);
        break;
      case 5: 
        if ((audx.amK()) && (atwb.fO() > atvz.fJ()))
        {
          ahal.a(SplashActivity.sTopActivity, 2131693826, 2131693832, new aufl(this));
        }
        else
        {
          localObject1 = atwb.ep();
          localObject2 = new Intent();
          ((Intent)localObject2).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
          SendBottomBar.a(this.this$0).setResult(-1, (Intent)localObject2);
          SendBottomBar.a(this.this$0).finish();
        }
        break;
      case 8: 
        localObject1 = SendBottomBar.a(this.this$0).getIntent();
        if (localObject1 != null) {
          if (((Intent)localObject1).getStringExtra("posturl") != null)
          {
            ((Intent)localObject1).putParcelableArrayListExtra("fileinfo", atwb.ep());
            SendBottomBar.a(this.this$0).setResult(-1, (Intent)localObject1);
            SendBottomBar.a(this.this$0).finish();
          }
          else
          {
            SendBottomBar.a(this.this$0).setResult(-1, (Intent)localObject1);
            SendBottomBar.a(this.this$0).finish();
          }
        }
        break;
      case 9: 
        if (SendBottomBar.a(this.this$0).akI())
        {
          localObject1 = new Intent();
          Object localObject3 = atwb.ep();
          localObject2 = new ArrayList();
          if (localObject3 != null)
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              FileInfo localFileInfo = (FileInfo)((Iterator)localObject3).next();
              if ((localFileInfo != null) && (!TextUtils.isEmpty(localFileInfo.getPath()))) {
                ((ArrayList)localObject2).add(localFileInfo.getPath());
              }
            }
          }
          ((Intent)localObject1).putStringArrayListExtra("reslut_select_file_info_list", (ArrayList)localObject2);
          SendBottomBar.a(this.this$0).setResult(-1, (Intent)localObject1);
        }
        SendBottomBar.a(this.this$0).finish();
        break;
      case 10: 
        this.this$0.dmR();
        break;
      case 11: 
        SendBottomBar.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufk
 * JD-Core Version:    0.7.0.1
 */